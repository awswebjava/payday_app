package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class migrlegupd_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action60") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A626MigrLegId = httpContext.GetPar( "MigrLegId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_60_2875( A3CliCod, A1EmpCod, A626MigrLegId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action62") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_62_2875( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action64") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A627MigrLegConvenio = httpContext.GetPar( "MigrLegConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A604MigrLegCategoria = httpContext.GetPar( "MigrLegCategoria") ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_64_2875( AV7CliCod, A627MigrLegConvenio, A604MigrLegCategoria) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action65") == 0 )
      {
         AV176sinesTexto = httpContext.GetPar( "sinesTexto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_65_2875( AV176sinesTexto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action67") == 0 )
      {
         AV177actTexto = httpContext.GetPar( "actTexto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_67_2875( AV177actTexto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action69") == 0 )
      {
         AV178modTexto = httpContext.GetPar( "modTexto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_69_2875( AV178modTexto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action71") == 0 )
      {
         AV175texto = httpContext.GetPar( "texto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_71_2875( AV175texto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action73") == 0 )
      {
         AV179sitRevTexto = httpContext.GetPar( "sitRevTexto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_73_2875( AV179sitRevTexto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action75") == 0 )
      {
         AV180condTexto = httpContext.GetPar( "condTexto") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_75_2875( AV180condTexto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action77") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A595MigrLegSexo = httpContext.GetPar( "MigrLegSexo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV104dummyErrores);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_77_2875( AV7CliCod, A595MigrLegSexo, AV104dummyErrores) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action79") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A607MigrLegClase = httpContext.GetPar( "MigrLegClase") ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
         httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV104dummyErrores);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_79_2875( AV7CliCod, A607MigrLegClase, AV104dummyErrores) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action80") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A596MigrLegEstadoCivil = httpContext.GetPar( "MigrLegEstadoCivil") ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV104dummyErrores);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_80_2875( AV7CliCod, A596MigrLegEstadoCivil, AV104dummyErrores) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action82") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_82_2875( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action84") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A609MigrLegFormaPago = httpContext.GetPar( "MigrLegFormaPago") ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV104dummyErrores);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_84_2875( AV7CliCod, A609MigrLegFormaPago, AV104dummyErrores) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action86") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_86_2875( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action88") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_88_2875( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action90") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A612MigrLegBanTipCuen = httpContext.GetPar( "MigrLegBanTipCuen") ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV104dummyErrores);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_90_2875( AV7CliCod, A612MigrLegBanTipCuen, AV104dummyErrores) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
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
         gx3asaclicod2875( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"EMPCOD") == 0 )
      {
         AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaempcod2875( AV18EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel23"+"_"+"vSINESTEXTO") == 0 )
      {
         A625MigrLegSiniestrado = httpContext.GetPar( "MigrLegSiniestrado") ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx23asasinestexto2875( A625MigrLegSiniestrado) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel24"+"_"+"vMENSAJE") == 0 )
      {
         A625MigrLegSiniestrado = httpContext.GetPar( "MigrLegSiniestrado") ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A616MigrLegActividad = httpContext.GetPar( "MigrLegActividad") ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         A617MigrLegModalidad = httpContext.GetPar( "MigrLegModalidad") ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A620MigrLegZona = httpContext.GetPar( "MigrLegZona") ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         A623MigrLegSituacionRevista = httpContext.GetPar( "MigrLegSituacionRevista") ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A624MigrLegCondicion = httpContext.GetPar( "MigrLegCondicion") ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx24asamensaje2875( A625MigrLegSiniestrado, A616MigrLegActividad, A617MigrLegModalidad, A620MigrLegZona, A623MigrLegSituacionRevista, A624MigrLegCondicion, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel25"+"_"+"vACTTEXTO") == 0 )
      {
         A616MigrLegActividad = httpContext.GetPar( "MigrLegActividad") ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx25asaacttexto2875( A616MigrLegActividad) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel26"+"_"+"vMODTEXTO") == 0 )
      {
         A617MigrLegModalidad = httpContext.GetPar( "MigrLegModalidad") ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx26asamodtexto2875( A617MigrLegModalidad) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel27"+"_"+"vTEXTO") == 0 )
      {
         A620MigrLegZona = httpContext.GetPar( "MigrLegZona") ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx27asatexto2875( A620MigrLegZona) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel28"+"_"+"vSITREVTEXTO") == 0 )
      {
         A623MigrLegSituacionRevista = httpContext.GetPar( "MigrLegSituacionRevista") ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx28asasitrevtexto2875( A623MigrLegSituacionRevista) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel29"+"_"+"vCONDTEXTO") == 0 )
      {
         A624MigrLegCondicion = httpContext.GetPar( "MigrLegCondicion") ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx29asacondtexto2875( A624MigrLegCondicion) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel30"+"_"+"vSEXOERROR") == 0 )
      {
         A595MigrLegSexo = httpContext.GetPar( "MigrLegSexo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx30asasexoerror2875( A595MigrLegSexo, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel31"+"_"+"vESTADOCIVILERROR") == 0 )
      {
         A596MigrLegEstadoCivil = httpContext.GetPar( "MigrLegEstadoCivil") ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx31asaestadocivilerror2875( A596MigrLegEstadoCivil, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel32"+"_"+"vDISCAPACIDADERROR") == 0 )
      {
         A598MigrLegDiscapacidad = httpContext.GetPar( "MigrLegDiscapacidad") ;
         httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx32asadiscapacidaderror2875( A598MigrLegDiscapacidad, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel33"+"_"+"vFORMADEPAGOERROR") == 0 )
      {
         A609MigrLegFormaPago = httpContext.GetPar( "MigrLegFormaPago") ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx33asaformadepagoerror2875( A609MigrLegFormaPago, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel34"+"_"+"vSCVOERROR") == 0 )
      {
         A622MigrLegSCVO = httpContext.GetPar( "MigrLegSCVO") ;
         httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx34asascvoerror2875( A622MigrLegSCVO, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel35"+"_"+"vTIENECONYUGEERROR") == 0 )
      {
         A631MigrTieneConyuge = httpContext.GetPar( "MigrTieneConyuge") ;
         httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx35asatieneconyugeerror2875( A631MigrTieneConyuge, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel36"+"_"+"vTIPOCUENTAERROR") == 0 )
      {
         A612MigrLegBanTipCuen = httpContext.GetPar( "MigrLegBanTipCuen") ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx36asatipocuentaerror2875( A612MigrLegBanTipCuen, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel37"+"_"+"vCATBASICO") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A627MigrLegConvenio = httpContext.GetPar( "MigrLegConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         AV156CatCodigo = httpContext.GetPar( "CatCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV156CatCodigo", AV156CatCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx37asacatbasico2875( AV7CliCod, A627MigrLegConvenio, AV156CatCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_94") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_94( A3CliCod, A1EmpCod) ;
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
            AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
            AV40MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40MigrLegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV40MigrLegNumero), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Importación de Legajos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public migrlegupd_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public migrlegupd_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( migrlegupd_impl.class ));
   }

   public migrlegupd_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbMigrLegModTra = new HTMLChoice();
      cmbMigrLegTipoTarifa = new HTMLChoice();
      cmbMigrLegClase = new HTMLChoice();
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
      if ( cmbMigrLegModTra.getItemCount() > 0 )
      {
         A2415MigrLegModTra = cmbMigrLegModTra.getValidValue(A2415MigrLegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegModTra.setValue( GXutil.rtrim( A2415MigrLegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModTra.getInternalname(), "Values", cmbMigrLegModTra.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegTipoTarifa.getItemCount() > 0 )
      {
         A2427MigrLegTipoTarifa = cmbMigrLegTipoTarifa.getValidValue(A2427MigrLegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegTipoTarifa.setValue( GXutil.rtrim( A2427MigrLegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegTipoTarifa.getInternalname(), "Values", cmbMigrLegTipoTarifa.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegClase.getItemCount() > 0 )
      {
         A607MigrLegClase = cmbMigrLegClase.getValidValue(A607MigrLegClase) ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegClase.setValue( GXutil.rtrim( A607MigrLegClase) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegClase.getInternalname(), "Values", cmbMigrLegClase.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegId_Internalname, httpContext.getMessage( "ID/Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegId_Internalname, GXutil.rtrim( A626MigrLegId), GXutil.rtrim( localUtil.format( A626MigrLegId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCUIL_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCUIL_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCUIL_Internalname, GXutil.rtrim( A597MigrLegCUIL), GXutil.rtrim( localUtil.format( A597MigrLegCUIL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCUIL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCUIL_Enabled, 0, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Cuit", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegApellido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegApellido_Internalname, A592MigrLegApellido, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtMigrLegApellido_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegNombre_Internalname, httpContext.getMessage( "Nombres", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegNombre_Internalname, A593MigrLegNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtMigrLegNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegmodtra_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegmodtra_Internalname, httpContext.getMessage( "Relación laboral", ""), "", "", lblTextblockmigrlegmodtra_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegmodtra_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegmodtra_Internalname, tblTablemergedmigrlegmodtra_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegModTra.getInternalname(), httpContext.getMessage( "Relación laboral", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegModTra, cmbMigrLegModTra.getInternalname(), GXutil.rtrim( A2415MigrLegModTra), 1, cmbMigrLegModTra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegModTra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "", true, (byte)(0), "HLP_MigrLegUPD.htm");
      cmbMigrLegModTra.setValue( GXutil.rtrim( A2415MigrLegModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModTra.getInternalname(), "Values", cmbMigrLegModTra.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegmodtra_righttext_Internalname, lblMigrlegmodtra_righttext_Caption, "", "", lblMigrlegmodtra_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegtipotarifa_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegtipotarifa_Internalname, httpContext.getMessage( "Tipo de tarifa", ""), "", "", lblTextblockmigrlegtipotarifa_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegtipotarifa_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegtipotarifa_Internalname, tblTablemergedmigrlegtipotarifa_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegTipoTarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegTipoTarifa, cmbMigrLegTipoTarifa.getInternalname(), GXutil.rtrim( A2427MigrLegTipoTarifa), 1, cmbMigrLegTipoTarifa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegTipoTarifa.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_MigrLegUPD.htm");
      cmbMigrLegTipoTarifa.setValue( GXutil.rtrim( A2427MigrLegTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegTipoTarifa.getInternalname(), "Values", cmbMigrLegTipoTarifa.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegtipotarifa_righttext_Internalname, lblMigrlegtipotarifa_righttext_Caption, "", "", lblMigrlegtipotarifa_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegclase_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegclase_Internalname, httpContext.getMessage( "Frecuencia de pago", ""), "", "", lblTextblockmigrlegclase_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegclase_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegclase_Internalname, tblTablemergedmigrlegclase_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegClase.getInternalname(), httpContext.getMessage( "Frecuencia de pago", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegClase, cmbMigrLegClase.getInternalname(), GXutil.rtrim( A607MigrLegClase), 1, cmbMigrLegClase.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegClase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "", true, (byte)(0), "HLP_MigrLegUPD.htm");
      cmbMigrLegClase.setValue( GXutil.rtrim( A607MigrLegClase) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegClase.getInternalname(), "Values", cmbMigrLegClase.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegclase_righttext_Internalname, lblMigrlegclase_righttext_Caption, "", "", lblMigrlegclase_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecNac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecNac_Internalname, httpContext.getMessage( "Fecha de Nacimiento", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMigrLegFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecNac_Internalname, localUtil.format(A594MigrLegFecNac, "99/99/9999"), localUtil.format( A594MigrLegFecNac, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecNac_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtMigrLegFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MigrLegUPD.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecIngreso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecIngreso_Internalname, httpContext.getMessage( "Fecha de Ingreso", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMigrLegFecIngreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecIngreso_Internalname, localUtil.format(A603MigrLegFecIngreso, "99/99/9999"), localUtil.format( A603MigrLegFecIngreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecIngreso_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtMigrLegFecIngreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecIngreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecIngreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MigrLegUPD.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegsexo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegsexo_Internalname, httpContext.getMessage( "Sexo", ""), "", "", lblTextblockmigrlegsexo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegsexo_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegsexo_Internalname, tblTablemergedmigrlegsexo_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegsexo.setProperty("Caption", Combo_migrlegsexo_Caption);
      ucCombo_migrlegsexo.setProperty("Cls", Combo_migrlegsexo_Cls);
      ucCombo_migrlegsexo.setProperty("EmptyItem", Combo_migrlegsexo_Emptyitem);
      ucCombo_migrlegsexo.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegsexo.setProperty("DropDownOptionsData", AV189MigrLegSexo_Data);
      ucCombo_migrlegsexo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegsexo_Internalname, "COMBO_MIGRLEGSEXOContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegSexo_Internalname, httpContext.getMessage( "Sexo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSexo_Internalname, GXutil.rtrim( A595MigrLegSexo), GXutil.rtrim( localUtil.format( A595MigrLegSexo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSexo_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSexo_Visible, edtMigrLegSexo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegsexo_righttext_Internalname, lblMigrlegsexo_righttext_Caption, "", "", lblMigrlegsexo_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegDomici_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegDomici_Internalname, httpContext.getMessage( "Domicilio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegDomici_Internalname, A599MigrLegDomici, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,110);\"", (short)(0), 1, edtMigrLegDomici_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "VarcharTextArea", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCodPos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCodPos_Internalname, httpContext.getMessage( "Código Postal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegCodPos_Internalname, A601MigrLegCodPos, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,115);\"", (short)(0), 1, edtMigrLegCodPos_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegTelefono_Internalname, httpContext.getMessage( "Teléfono", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegTelefono_Internalname, A602MigrLegTelefono, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,120);\"", (short)(0), 1, edtMigrLegTelefono_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegEmail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegEmail_Internalname, httpContext.getMessage( "Email", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegEmail_Internalname, A600MigrLegEmail, GXutil.rtrim( localUtil.format( A600MigrLegEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,125);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegestadocivil_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegestadocivil_Internalname, httpContext.getMessage( "Estado Civil", ""), "", "", lblTextblockmigrlegestadocivil_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegestadocivil_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegestadocivil_Internalname, tblTablemergedmigrlegestadocivil_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegestadocivil.setProperty("Caption", Combo_migrlegestadocivil_Caption);
      ucCombo_migrlegestadocivil.setProperty("Cls", Combo_migrlegestadocivil_Cls);
      ucCombo_migrlegestadocivil.setProperty("EmptyItem", Combo_migrlegestadocivil_Emptyitem);
      ucCombo_migrlegestadocivil.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegestadocivil.setProperty("DropDownOptionsData", AV191MigrLegEstadoCivil_Data);
      ucCombo_migrlegestadocivil.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegestadocivil_Internalname, "COMBO_MIGRLEGESTADOCIVILContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegEstadoCivil_Internalname, httpContext.getMessage( "Estado Civil", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegEstadoCivil_Internalname, A596MigrLegEstadoCivil, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,139);\"", (short)(0), edtMigrLegEstadoCivil_Visible, edtMigrLegEstadoCivil_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegestadocivil_righttext_Internalname, lblMigrlegestadocivil_righttext_Caption, "", "", lblMigrlegestadocivil_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegarea_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegarea_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockmigrlegarea_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegarea_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegarea_Internalname, tblTablemergedmigrlegarea_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegarea.setProperty("Caption", Combo_migrlegarea_Caption);
      ucCombo_migrlegarea.setProperty("Cls", Combo_migrlegarea_Cls);
      ucCombo_migrlegarea.setProperty("EmptyItem", Combo_migrlegarea_Emptyitem);
      ucCombo_migrlegarea.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegarea.setProperty("DropDownOptionsData", AV26MigrLegArea_Data);
      ucCombo_migrlegarea.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegarea_Internalname, "COMBO_MIGRLEGAREAContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegArea_Internalname, httpContext.getMessage( "Área", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegArea_Internalname, A605MigrLegArea, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,155);\"", (short)(0), edtMigrLegArea_Visible, edtMigrLegArea_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegarea_righttext_Internalname, lblMigrlegarea_righttext_Caption, "", "", lblMigrlegarea_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegsindicato_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegsindicato_Internalname, httpContext.getMessage( "Sindicato", ""), "", "", lblTextblockmigrlegsindicato_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegsindicato_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegsindicato_Internalname, tblTablemergedmigrlegsindicato_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegsindicato.setProperty("Caption", Combo_migrlegsindicato_Caption);
      ucCombo_migrlegsindicato.setProperty("Cls", Combo_migrlegsindicato_Cls);
      ucCombo_migrlegsindicato.setProperty("EmptyItem", Combo_migrlegsindicato_Emptyitem);
      ucCombo_migrlegsindicato.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegsindicato.setProperty("DropDownOptionsData", AV133MigrLegSindicato_Data);
      ucCombo_migrlegsindicato.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegsindicato_Internalname, "COMBO_MIGRLEGSINDICATOContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegSindicato_Internalname, httpContext.getMessage( "Sindicato", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegSindicato_Internalname, A613MigrLegSindicato, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,171);\"", (short)(0), edtMigrLegSindicato_Visible, edtMigrLegSindicato_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegsindicato_righttext_Internalname, lblMigrlegsindicato_righttext_Caption, "", "", lblMigrlegsindicato_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockmigrlegconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegconvenio_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegconvenio_Internalname, tblTablemergedmigrlegconvenio_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegconvenio.setProperty("Caption", Combo_migrlegconvenio_Caption);
      ucCombo_migrlegconvenio.setProperty("Cls", Combo_migrlegconvenio_Cls);
      ucCombo_migrlegconvenio.setProperty("EmptyItem", Combo_migrlegconvenio_Emptyitem);
      ucCombo_migrlegconvenio.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegconvenio.setProperty("DropDownOptionsData", AV135MigrLegConvenio_Data);
      ucCombo_migrlegconvenio.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegconvenio_Internalname, "COMBO_MIGRLEGCONVENIOContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegConvenio_Internalname, httpContext.getMessage( "Convenio", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegConvenio_Internalname, A627MigrLegConvenio, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,187);\"", (short)(0), edtMigrLegConvenio_Visible, edtMigrLegConvenio_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegconvenio_righttext_Internalname, lblMigrlegconvenio_righttext_Caption, "", "", lblMigrlegconvenio_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegcategoria_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegcategoria_Internalname, httpContext.getMessage( "Categoría", ""), "", "", lblTextblockmigrlegcategoria_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegcategoria_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegcategoria_Internalname, tblTablemergedmigrlegcategoria_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegcategoria.setProperty("Caption", Combo_migrlegcategoria_Caption);
      ucCombo_migrlegcategoria.setProperty("Cls", Combo_migrlegcategoria_Cls);
      ucCombo_migrlegcategoria.setProperty("EmptyItem", Combo_migrlegcategoria_Emptyitem);
      ucCombo_migrlegcategoria.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegcategoria.setProperty("DropDownOptionsData", AV126MigrLegCategoria_Data);
      ucCombo_migrlegcategoria.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegcategoria_Internalname, "COMBO_MIGRLEGCATEGORIAContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCategoria_Internalname, httpContext.getMessage( "Categoría", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 203,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegCategoria_Internalname, A604MigrLegCategoria, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,203);\"", (short)(0), edtMigrLegCategoria_Visible, edtMigrLegCategoria_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegcategoria_righttext_Internalname, lblMigrlegcategoria_righttext_Caption, "", "", lblMigrlegcategoria_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegbanco_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegbanco_Internalname, httpContext.getMessage( "Banco", ""), "", "", lblTextblockmigrlegbanco_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegbanco_Internalname, tblTablemergedmigrlegbanco_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegbanco.setProperty("Caption", Combo_migrlegbanco_Caption);
      ucCombo_migrlegbanco.setProperty("Cls", Combo_migrlegbanco_Cls);
      ucCombo_migrlegbanco.setProperty("EmptyItem", Combo_migrlegbanco_Emptyitem);
      ucCombo_migrlegbanco.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegbanco.setProperty("DropDownOptionsData", AV139MigrLegBanco_Data);
      ucCombo_migrlegbanco.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegbanco_Internalname, "COMBO_MIGRLEGBANCOContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegBanco_Internalname, httpContext.getMessage( "Banco", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanco_Internalname, A610MigrLegBanco, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,219);\"", (short)(0), edtMigrLegBanco_Visible, edtMigrLegBanco_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegbanco_righttext_Internalname, lblMigrlegbanco_righttext_Caption, "", "", lblMigrlegbanco_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegBasico_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegBasico_Internalname, httpContext.getMessage( "Básico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 226,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A608MigrLegBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegBasico_Enabled!=0) ? localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,226);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegobrasocial_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegobrasocial_Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblTextblockmigrlegobrasocial_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegobrasocial_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegobrasocial_Internalname, tblTablemergedmigrlegobrasocial_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegobrasocial.setProperty("Caption", Combo_migrlegobrasocial_Caption);
      ucCombo_migrlegobrasocial.setProperty("Cls", Combo_migrlegobrasocial_Cls);
      ucCombo_migrlegobrasocial.setProperty("EmptyItem", Combo_migrlegobrasocial_Emptyitem);
      ucCombo_migrlegobrasocial.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegobrasocial.setProperty("DropDownOptionsData", AV131MigrLegObraSocial_Data);
      ucCombo_migrlegobrasocial.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegobrasocial_Internalname, "COMBO_MIGRLEGOBRASOCIALContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegObraSocial_Internalname, httpContext.getMessage( "Obra Social", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 240,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegObraSocial_Internalname, A614MigrLegObraSocial, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,240);\"", (short)(0), edtMigrLegObraSocial_Visible, edtMigrLegObraSocial_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegobrasocial_righttext_Internalname, lblMigrlegobrasocial_righttext_Caption, "", "", lblMigrlegobrasocial_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCBU_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCBU_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 247,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCBU_Internalname, A621MigrLegCBU, GXutil.rtrim( localUtil.format( A621MigrLegCBU, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,247);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCBU_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCBU_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CBU", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegmodalidad_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegmodalidad_Internalname, httpContext.getMessage( "Modalidad AFIP", ""), "", "", lblTextblockmigrlegmodalidad_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegmodalidad_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegmodalidad_Internalname, tblTablemergedmigrlegmodalidad_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegmodalidad.setProperty("Caption", Combo_migrlegmodalidad_Caption);
      ucCombo_migrlegmodalidad.setProperty("Cls", Combo_migrlegmodalidad_Cls);
      ucCombo_migrlegmodalidad.setProperty("EmptyItem", Combo_migrlegmodalidad_Emptyitem);
      ucCombo_migrlegmodalidad.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegmodalidad.setProperty("DropDownOptionsData", AV141MigrLegModalidad_Data);
      ucCombo_migrlegmodalidad.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegmodalidad_Internalname, "COMBO_MIGRLEGMODALIDADContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegModalidad_Internalname, httpContext.getMessage( "Migr Leg Modalidad", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 261,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegModalidad_Internalname, A617MigrLegModalidad, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,261);\"", (short)(0), edtMigrLegModalidad_Visible, edtMigrLegModalidad_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegmodalidad_righttext_Internalname, lblMigrlegmodalidad_righttext_Caption, "", "", lblMigrlegmodalidad_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegHorSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegHorSem_Internalname, httpContext.getMessage( "Horas normales semanales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 268,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegHorSem_Internalname, GXutil.ltrim( localUtil.ntoc( A2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegHorSem_Enabled!=0) ? localUtil.format( A2275MigrLegHorSem, "Z9.9") : localUtil.format( A2275MigrLegHorSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,268);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegHorSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegHorSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegzona_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegzona_Internalname, httpContext.getMessage( "Zona AFIP", ""), "", "", lblTextblockmigrlegzona_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegzona_Internalname, tblTablemergedmigrlegzona_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegzona.setProperty("Caption", Combo_migrlegzona_Caption);
      ucCombo_migrlegzona.setProperty("Cls", Combo_migrlegzona_Cls);
      ucCombo_migrlegzona.setProperty("EmptyItem", Combo_migrlegzona_Emptyitem);
      ucCombo_migrlegzona.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegzona.setProperty("DropDownOptionsData", AV129MigrLegZona_Data);
      ucCombo_migrlegzona.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegzona_Internalname, "COMBO_MIGRLEGZONAContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegZona_Internalname, httpContext.getMessage( "Zona", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 282,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegZona_Internalname, A620MigrLegZona, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,282);\"", (short)(0), edtMigrLegZona_Visible, edtMigrLegZona_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegzona_righttext_Internalname, lblMigrlegzona_righttext_Caption, "", "", lblMigrlegzona_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegactividad_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegactividad_Internalname, httpContext.getMessage( "Actividad AFIP", ""), "", "", lblTextblockmigrlegactividad_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegactividad_Internalname, tblTablemergedmigrlegactividad_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegactividad.setProperty("Caption", Combo_migrlegactividad_Caption);
      ucCombo_migrlegactividad.setProperty("Cls", Combo_migrlegactividad_Cls);
      ucCombo_migrlegactividad.setProperty("EmptyItem", Combo_migrlegactividad_Emptyitem);
      ucCombo_migrlegactividad.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegactividad.setProperty("DropDownOptionsData", AV143MigrLegActividad_Data);
      ucCombo_migrlegactividad.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegactividad_Internalname, "COMBO_MIGRLEGACTIVIDADContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegActividad_Internalname, httpContext.getMessage( "Actividad", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 298,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegActividad_Internalname, A616MigrLegActividad, GXutil.rtrim( localUtil.format( A616MigrLegActividad, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,298);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegActividad_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegActividad_Visible, edtMigrLegActividad_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegactividad_righttext_Internalname, lblMigrlegactividad_righttext_Caption, "", "", lblMigrlegactividad_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegcondicion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegcondicion_Internalname, httpContext.getMessage( "Condición AFIP", ""), "", "", lblTextblockmigrlegcondicion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegcondicion_Internalname, tblTablemergedmigrlegcondicion_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegcondicion.setProperty("Caption", Combo_migrlegcondicion_Caption);
      ucCombo_migrlegcondicion.setProperty("Cls", Combo_migrlegcondicion_Cls);
      ucCombo_migrlegcondicion.setProperty("EmptyItem", Combo_migrlegcondicion_Emptyitem);
      ucCombo_migrlegcondicion.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegcondicion.setProperty("DropDownOptionsData", AV147MigrLegCondicion_Data);
      ucCombo_migrlegcondicion.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegcondicion_Internalname, "COMBO_MIGRLEGCONDICIONContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCondicion_Internalname, httpContext.getMessage( "Condición", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 314,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCondicion_Internalname, A624MigrLegCondicion, GXutil.rtrim( localUtil.format( A624MigrLegCondicion, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,314);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCondicion_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegCondicion_Visible, edtMigrLegCondicion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegcondicion_righttext_Internalname, lblMigrlegcondicion_righttext_Caption, "", "", lblMigrlegcondicion_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegActLabClas_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegActLabClas_Internalname, httpContext.getMessage( "Actividad laboral AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 321,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegActLabClas_Internalname, A2239MigrLegActLabClas, GXutil.rtrim( localUtil.format( A2239MigrLegActLabClas, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,321);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegActLabClas_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegActLabClas_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegPueAfip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegPueAfip_Internalname, httpContext.getMessage( "Puesto desempeñado AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 326,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegPueAfip_Internalname, A2240MigrLegPueAfip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,326);\"", (short)(0), 1, edtMigrLegPueAfip_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "255", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 331,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegObs_Internalname, A628MigrLegObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,331);\"", (short)(0), 1, edtMigrLegObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
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
      if ( ! isFullAjaxMode( ) )
      {
         /* WebComponent */
         web.GxWebStd.gx_hidden_field( httpContext, "W0334"+"", GXutil.rtrim( WebComp_Wcimportarlegajofamilia_Component));
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
         httpContext.writeText( " id=\""+"gxHTMLWrpW0334"+""+"\""+"") ;
         httpContext.writeText( ">") ;
         if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
         {
            if ( GXutil.strcmp(GXutil.lower( OldWcimportarlegajofamilia), GXutil.lower( WebComp_Wcimportarlegajofamilia_Component)) != 0 )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0334"+"");
            }
            WebComp_Wcimportarlegajofamilia.componentdraw();
            if ( GXutil.strcmp(GXutil.lower( OldWcimportarlegajofamilia), GXutil.lower( WebComp_Wcimportarlegajofamilia_Component)) != 0 )
            {
               httpContext.ajax_rspEndCmp();
            }
         }
         httpContext.writeText( "</div>") ;
      }
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 342,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 344,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MigrLegUPD.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegsexo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomigrlegsexo_Internalname, GXutil.rtrim( AV190ComboMigrLegSexo), GXutil.rtrim( localUtil.format( AV190ComboMigrLegSexo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomigrlegsexo_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomigrlegsexo_Visible, edtavCombomigrlegsexo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegestadocivil_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegestadocivil_Internalname, AV192ComboMigrLegEstadoCivil, "", "", (short)(0), edtavCombomigrlegestadocivil_Visible, edtavCombomigrlegestadocivil_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegarea_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegarea_Internalname, AV13ComboMigrLegArea, "", "", (short)(0), edtavCombomigrlegarea_Visible, edtavCombomigrlegarea_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegsindicato_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegsindicato_Internalname, AV134ComboMigrLegSindicato, "", "", (short)(0), edtavCombomigrlegsindicato_Visible, edtavCombomigrlegsindicato_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegconvenio_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegconvenio_Internalname, AV136ComboMigrLegConvenio, "", "", (short)(0), edtavCombomigrlegconvenio_Visible, edtavCombomigrlegconvenio_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegcategoria_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegcategoria_Internalname, AV127ComboMigrLegCategoria, "", "", (short)(0), edtavCombomigrlegcategoria_Visible, edtavCombomigrlegcategoria_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegbanco_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegbanco_Internalname, AV140ComboMigrLegBanco, "", "", (short)(0), edtavCombomigrlegbanco_Visible, edtavCombomigrlegbanco_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegobrasocial_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegobrasocial_Internalname, AV132ComboMigrLegObraSocial, "", "", (short)(0), edtavCombomigrlegobrasocial_Visible, edtavCombomigrlegobrasocial_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegmodalidad_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegmodalidad_Internalname, AV142ComboMigrLegModalidad, "", "", (short)(0), edtavCombomigrlegmodalidad_Visible, edtavCombomigrlegmodalidad_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegzona_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtavCombomigrlegzona_Internalname, AV130ComboMigrLegZona, "", "", (short)(0), edtavCombomigrlegzona_Visible, edtavCombomigrlegzona_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegactividad_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomigrlegactividad_Internalname, AV144ComboMigrLegActividad, GXutil.rtrim( localUtil.format( AV144ComboMigrLegActividad, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomigrlegactividad_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomigrlegactividad_Visible, edtavCombomigrlegactividad_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegcondicion_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomigrlegcondicion_Internalname, AV148ComboMigrLegCondicion, GXutil.rtrim( localUtil.format( AV148ComboMigrLegCondicion, "@!")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomigrlegcondicion_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomigrlegcondicion_Visible, edtavCombomigrlegcondicion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 372,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,372);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 373,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,373);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 374,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,374);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegNumero_Visible, edtMigrLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 375,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegDiscapacidad_Internalname, GXutil.rtrim( A598MigrLegDiscapacidad), GXutil.rtrim( localUtil.format( A598MigrLegDiscapacidad, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,375);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegDiscapacidad_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegDiscapacidad_Visible, edtMigrLegDiscapacidad_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 376,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegOSAfip_Internalname, GXutil.rtrim( A634MigrLegOSAfip), GXutil.rtrim( localUtil.format( A634MigrLegOSAfip, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,376);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegOSAfip_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegOSAfip_Visible, edtMigrLegOSAfip_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 377,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegLugarDePago_Internalname, A606MigrLegLugarDePago, GXutil.rtrim( localUtil.format( A606MigrLegLugarDePago, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,377);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegLugarDePago_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegLugarDePago_Visible, edtMigrLegLugarDePago_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 378,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanSuc_Internalname, A611MigrLegBanSuc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,378);\"", (short)(0), edtMigrLegBanSuc_Visible, edtMigrLegBanSuc_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 379,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBanTipCuen_Internalname, A612MigrLegBanTipCuen, GXutil.rtrim( localUtil.format( A612MigrLegBanTipCuen, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,379);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBanTipCuen_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegBanTipCuen_Visible, edtMigrLegBanTipCuen_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 380,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCuentaBanc_Internalname, A619MigrLegCuentaBanc, GXutil.rtrim( localUtil.format( A619MigrLegCuentaBanc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,380);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCuentaBanc_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegCuentaBanc_Visible, edtMigrLegCuentaBanc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 381,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegFormaPago_Internalname, A609MigrLegFormaPago, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,381);\"", (short)(0), edtMigrLegFormaPago_Visible, edtMigrLegFormaPago_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 382,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSituacionRevista_Internalname, A623MigrLegSituacionRevista, GXutil.rtrim( localUtil.format( A623MigrLegSituacionRevista, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,382);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSituacionRevista_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSituacionRevista_Visible, edtMigrLegSituacionRevista_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 383,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegSiniestrado_Internalname, A625MigrLegSiniestrado, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,383);\"", (short)(0), edtMigrLegSiniestrado_Visible, edtMigrLegSiniestrado_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 384,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSCVO_Internalname, GXutil.rtrim( A622MigrLegSCVO), GXutil.rtrim( localUtil.format( A622MigrLegSCVO, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,384);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSCVO_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSCVO_Visible, edtMigrLegSCVO_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 385,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegPlanMedico_Internalname, A615MigrLegPlanMedico, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,385);\"", (short)(0), edtMigrLegPlanMedico_Visible, edtMigrLegPlanMedico_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 386,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrTieneConyuge_Internalname, GXutil.rtrim( A631MigrTieneConyuge), GXutil.rtrim( localUtil.format( A631MigrTieneConyuge, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,386);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrTieneConyuge_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrTieneConyuge_Visible, edtMigrTieneConyuge_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MigrLegUPD.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 387,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrCantidadHijos_Internalname, GXutil.ltrim( localUtil.ntoc( A632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrCantidadHijos_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,387);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrCantidadHijos_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrCantidadHijos_Visible, edtMigrCantidadHijos_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MigrLegUPD.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
            {
               WebComp_Wcimportarlegajofamilia.componentstart();
            }
         }
      }
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
      e11282 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGSEXO_DATA"), AV189MigrLegSexo_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGESTADOCIVIL_DATA"), AV191MigrLegEstadoCivil_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGAREA_DATA"), AV26MigrLegArea_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGSINDICATO_DATA"), AV133MigrLegSindicato_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGCONVENIO_DATA"), AV135MigrLegConvenio_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGCATEGORIA_DATA"), AV126MigrLegCategoria_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGBANCO_DATA"), AV139MigrLegBanco_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGOBRASOCIAL_DATA"), AV131MigrLegObraSocial_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGMODALIDAD_DATA"), AV141MigrLegModalidad_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGZONA_DATA"), AV129MigrLegZona_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGACTIVIDAD_DATA"), AV143MigrLegActividad_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGCONDICION_DATA"), AV147MigrLegCondicion_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z87MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z595MigrLegSexo = httpContext.cgiGet( "Z595MigrLegSexo") ;
            Z596MigrLegEstadoCivil = httpContext.cgiGet( "Z596MigrLegEstadoCivil") ;
            Z605MigrLegArea = httpContext.cgiGet( "Z605MigrLegArea") ;
            Z613MigrLegSindicato = httpContext.cgiGet( "Z613MigrLegSindicato") ;
            Z627MigrLegConvenio = httpContext.cgiGet( "Z627MigrLegConvenio") ;
            Z604MigrLegCategoria = httpContext.cgiGet( "Z604MigrLegCategoria") ;
            Z610MigrLegBanco = httpContext.cgiGet( "Z610MigrLegBanco") ;
            Z614MigrLegObraSocial = httpContext.cgiGet( "Z614MigrLegObraSocial") ;
            Z617MigrLegModalidad = httpContext.cgiGet( "Z617MigrLegModalidad") ;
            Z620MigrLegZona = httpContext.cgiGet( "Z620MigrLegZona") ;
            Z616MigrLegActividad = httpContext.cgiGet( "Z616MigrLegActividad") ;
            Z624MigrLegCondicion = httpContext.cgiGet( "Z624MigrLegCondicion") ;
            Z592MigrLegApellido = httpContext.cgiGet( "Z592MigrLegApellido") ;
            Z593MigrLegNombre = httpContext.cgiGet( "Z593MigrLegNombre") ;
            Z594MigrLegFecNac = localUtil.ctod( httpContext.cgiGet( "Z594MigrLegFecNac"), 0) ;
            Z597MigrLegCUIL = httpContext.cgiGet( "Z597MigrLegCUIL") ;
            Z598MigrLegDiscapacidad = httpContext.cgiGet( "Z598MigrLegDiscapacidad") ;
            Z599MigrLegDomici = httpContext.cgiGet( "Z599MigrLegDomici") ;
            Z600MigrLegEmail = httpContext.cgiGet( "Z600MigrLegEmail") ;
            Z601MigrLegCodPos = httpContext.cgiGet( "Z601MigrLegCodPos") ;
            Z602MigrLegTelefono = httpContext.cgiGet( "Z602MigrLegTelefono") ;
            Z603MigrLegFecIngreso = localUtil.ctod( httpContext.cgiGet( "Z603MigrLegFecIngreso"), 0) ;
            Z606MigrLegLugarDePago = httpContext.cgiGet( "Z606MigrLegLugarDePago") ;
            Z2415MigrLegModTra = httpContext.cgiGet( "Z2415MigrLegModTra") ;
            Z607MigrLegClase = httpContext.cgiGet( "Z607MigrLegClase") ;
            Z608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( "Z608MigrLegBasico")) ;
            Z609MigrLegFormaPago = httpContext.cgiGet( "Z609MigrLegFormaPago") ;
            Z611MigrLegBanSuc = httpContext.cgiGet( "Z611MigrLegBanSuc") ;
            Z612MigrLegBanTipCuen = httpContext.cgiGet( "Z612MigrLegBanTipCuen") ;
            Z634MigrLegOSAfip = httpContext.cgiGet( "Z634MigrLegOSAfip") ;
            Z615MigrLegPlanMedico = httpContext.cgiGet( "Z615MigrLegPlanMedico") ;
            Z618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "Z618MigrLegFecUltMod"), 0) ;
            Z619MigrLegCuentaBanc = httpContext.cgiGet( "Z619MigrLegCuentaBanc") ;
            Z621MigrLegCBU = httpContext.cgiGet( "Z621MigrLegCBU") ;
            Z622MigrLegSCVO = httpContext.cgiGet( "Z622MigrLegSCVO") ;
            Z623MigrLegSituacionRevista = httpContext.cgiGet( "Z623MigrLegSituacionRevista") ;
            Z2239MigrLegActLabClas = httpContext.cgiGet( "Z2239MigrLegActLabClas") ;
            Z2240MigrLegPueAfip = httpContext.cgiGet( "Z2240MigrLegPueAfip") ;
            Z625MigrLegSiniestrado = httpContext.cgiGet( "Z625MigrLegSiniestrado") ;
            Z626MigrLegId = httpContext.cgiGet( "Z626MigrLegId") ;
            Z631MigrTieneConyuge = httpContext.cgiGet( "Z631MigrTieneConyuge") ;
            Z632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( "Z632MigrCantidadHijos"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "Z635MigrEncontroOsoSigla")) ;
            Z689MigrLegAreaDef = GXutil.strtobool( httpContext.cgiGet( "Z689MigrLegAreaDef")) ;
            Z690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "Z690MigrLegEstadoCivilDef")) ;
            Z691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "Z691MigrLegClaseDef")) ;
            Z692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "Z692MigrLegFormaPagoDef")) ;
            Z693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "Z693MigrLegTipoCuentaDef")) ;
            Z694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "Z694MigrLegActividadDef")) ;
            Z695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "Z695MigrLegModalidadDef")) ;
            Z696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "Z696MigrLegZonaDef")) ;
            Z697MigrLegSCVODef = GXutil.strtobool( httpContext.cgiGet( "Z697MigrLegSCVODef")) ;
            Z698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "Z698MigrLegSituacionDef")) ;
            Z699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "Z699MigrLegCondicionDef")) ;
            Z700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "Z700MigrLegSiniestradoDef")) ;
            Z2216MigrPuesto = httpContext.cgiGet( "Z2216MigrPuesto") ;
            Z2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "Z2205MigrLegFecEgreso"), 0) ;
            Z2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( "Z2275MigrLegHorSem")) ;
            Z2427MigrLegTipoTarifa = httpContext.cgiGet( "Z2427MigrLegTipoTarifa") ;
            A618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "Z618MigrLegFecUltMod"), 0) ;
            A635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "Z635MigrEncontroOsoSigla")) ;
            A689MigrLegAreaDef = GXutil.strtobool( httpContext.cgiGet( "Z689MigrLegAreaDef")) ;
            A690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "Z690MigrLegEstadoCivilDef")) ;
            A691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "Z691MigrLegClaseDef")) ;
            A692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "Z692MigrLegFormaPagoDef")) ;
            A693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "Z693MigrLegTipoCuentaDef")) ;
            A694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "Z694MigrLegActividadDef")) ;
            A695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "Z695MigrLegModalidadDef")) ;
            A696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "Z696MigrLegZonaDef")) ;
            A697MigrLegSCVODef = GXutil.strtobool( httpContext.cgiGet( "Z697MigrLegSCVODef")) ;
            A698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "Z698MigrLegSituacionDef")) ;
            A699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "Z699MigrLegCondicionDef")) ;
            A700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "Z700MigrLegSiniestradoDef")) ;
            A2216MigrPuesto = httpContext.cgiGet( "Z2216MigrPuesto") ;
            A2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "Z2205MigrLegFecEgreso"), 0) ;
            O634MigrLegOSAfip = httpContext.cgiGet( "O634MigrLegOSAfip") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N634MigrLegOSAfip = httpContext.cgiGet( "N634MigrLegOSAfip") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV18EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV40MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vMIGRLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV64AuxMigrLegCategoria = httpContext.cgiGet( "vAUXMIGRLEGCATEGORIA") ;
            AV176sinesTexto = httpContext.cgiGet( "vSINESTEXTO") ;
            AV158mensaje = httpContext.cgiGet( "vMENSAJE") ;
            AV177actTexto = httpContext.cgiGet( "vACTTEXTO") ;
            AV178modTexto = httpContext.cgiGet( "vMODTEXTO") ;
            AV175texto = httpContext.cgiGet( "vTEXTO") ;
            AV179sitRevTexto = httpContext.cgiGet( "vSITREVTEXTO") ;
            AV180condTexto = httpContext.cgiGet( "vCONDTEXTO") ;
            AV164sexoError = httpContext.cgiGet( "vSEXOERROR") ;
            AV73estadocivilError = httpContext.cgiGet( "vESTADOCIVILERROR") ;
            AV74discapacidadError = httpContext.cgiGet( "vDISCAPACIDADERROR") ;
            AV76formadepagoError = httpContext.cgiGet( "vFORMADEPAGOERROR") ;
            AV77scvoError = httpContext.cgiGet( "vSCVOERROR") ;
            AV103tieneconyugeError = httpContext.cgiGet( "vTIENECONYUGEERROR") ;
            AV166tipocuentaError = httpContext.cgiGet( "vTIPOCUENTAERROR") ;
            AV156CatCodigo = httpContext.cgiGet( "vCATCODIGO") ;
            AV154CatBasico = localUtil.ctond( httpContext.cgiGet( "vCATBASICO")) ;
            AV65LegNumeroPorId = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMEROPORID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV62LegNomApe = httpContext.cgiGet( "vLEGNOMAPE") ;
            AV66LegNumeroPorCUIL = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMEROPORCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV63LegIdNomApe = httpContext.cgiGet( "vLEGIDNOMAPE") ;
            AV155categoriaExiste = GXutil.strtobool( httpContext.cgiGet( "vCATEGORIAEXISTE")) ;
            AV157siniestradoExiste = GXutil.strtobool( httpContext.cgiGet( "vSINIESTRADOEXISTE")) ;
            AV159actividadExiste = GXutil.strtobool( httpContext.cgiGet( "vACTIVIDADEXISTE")) ;
            AV160ModalidadExiste = GXutil.strtobool( httpContext.cgiGet( "vMODALIDADEXISTE")) ;
            AV161ZonaExiste = GXutil.strtobool( httpContext.cgiGet( "vZONAEXISTE")) ;
            AV162SituacionExiste = GXutil.strtobool( httpContext.cgiGet( "vSITUACIONEXISTE")) ;
            AV163CondicionExiste = GXutil.strtobool( httpContext.cgiGet( "vCONDICIONEXISTE")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDUMMYERRORES"), AV104dummyErrores);
            AV168sexoExiste = GXutil.strtobool( httpContext.cgiGet( "vSEXOEXISTE")) ;
            AV92ClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vCLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV95EstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( "vESTADOCIVIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV173estadoCivilExiste = GXutil.strtobool( httpContext.cgiGet( "vESTADOCIVILEXISTE")) ;
            AV172discapacidadExiste = GXutil.strtobool( httpContext.cgiGet( "vDISCAPACIDADEXISTE")) ;
            AV98FormaDePago = (byte)(localUtil.ctol( httpContext.cgiGet( "vFORMADEPAGO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV167formadepagoExiste = GXutil.strtobool( httpContext.cgiGet( "vFORMADEPAGOEXISTE")) ;
            AV171scvoExiste = GXutil.strtobool( httpContext.cgiGet( "vSCVOEXISTE")) ;
            AV170tieneConyugeExiste = GXutil.strtobool( httpContext.cgiGet( "vTIENECONYUGEEXISTE")) ;
            AV111tipoCuentaBanco = httpContext.cgiGet( "vTIPOCUENTABANCO") ;
            AV169tipocuentaExiste = GXutil.strtobool( httpContext.cgiGet( "vTIPOCUENTAEXISTE")) ;
            A618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "MIGRLEGFECULTMOD"), 0) ;
            A629MigrLegErrores = httpContext.cgiGet( "MIGRLEGERRORES") ;
            A633MigrLegWarnings = httpContext.cgiGet( "MIGRLEGWARNINGS") ;
            A635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "MIGRENCONTROOSOSIGLA")) ;
            A689MigrLegAreaDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGAREADEF")) ;
            A690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGESTADOCIVILDEF")) ;
            A691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGCLASEDEF")) ;
            A692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGFORMAPAGODEF")) ;
            A693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGTIPOCUENTADEF")) ;
            A694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGACTIVIDADDEF")) ;
            A695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGMODALIDADDEF")) ;
            A696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGZONADEF")) ;
            A697MigrLegSCVODef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGSCVODEF")) ;
            A698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGSITUACIONDEF")) ;
            A699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGCONDICIONDEF")) ;
            A700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGSINIESTRADODEF")) ;
            A2216MigrPuesto = httpContext.cgiGet( "MIGRPUESTO") ;
            A2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "MIGRLEGFECEGRESO"), 0) ;
            A2206MigrOtrosDatos = httpContext.cgiGet( "MIGROTROSDATOS") ;
            AV203Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_migrlegsexo_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Objectcall") ;
            Combo_migrlegsexo_Class = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Class") ;
            Combo_migrlegsexo_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Icontype") ;
            Combo_migrlegsexo_Icon = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Icon") ;
            Combo_migrlegsexo_Caption = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Caption") ;
            Combo_migrlegsexo_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Tooltip") ;
            Combo_migrlegsexo_Cls = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Cls") ;
            Combo_migrlegsexo_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Selectedvalue_set") ;
            Combo_migrlegsexo_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Selectedvalue_get") ;
            Combo_migrlegsexo_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Selectedtext_set") ;
            Combo_migrlegsexo_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Selectedtext_get") ;
            Combo_migrlegsexo_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Gamoauthtoken") ;
            Combo_migrlegsexo_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Ddointernalname") ;
            Combo_migrlegsexo_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Titlecontrolalign") ;
            Combo_migrlegsexo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Dropdownoptionstype") ;
            Combo_migrlegsexo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Enabled")) ;
            Combo_migrlegsexo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Visible")) ;
            Combo_migrlegsexo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Titlecontrolidtoreplace") ;
            Combo_migrlegsexo_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Datalisttype") ;
            Combo_migrlegsexo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Allowmultipleselection")) ;
            Combo_migrlegsexo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Datalistfixedvalues") ;
            Combo_migrlegsexo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Isgriditem")) ;
            Combo_migrlegsexo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Hasdescription")) ;
            Combo_migrlegsexo_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Datalistproc") ;
            Combo_migrlegsexo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Datalistprocparametersprefix") ;
            Combo_migrlegsexo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Remoteservicesparameters") ;
            Combo_migrlegsexo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegsexo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Includeonlyselectedoption")) ;
            Combo_migrlegsexo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Includeselectalloption")) ;
            Combo_migrlegsexo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Emptyitem")) ;
            Combo_migrlegsexo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Includeaddnewoption")) ;
            Combo_migrlegsexo_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Htmltemplate") ;
            Combo_migrlegsexo_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Multiplevaluestype") ;
            Combo_migrlegsexo_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Loadingdata") ;
            Combo_migrlegsexo_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Noresultsfound") ;
            Combo_migrlegsexo_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Emptyitemtext") ;
            Combo_migrlegsexo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Onlyselectedvalues") ;
            Combo_migrlegsexo_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Selectalltext") ;
            Combo_migrlegsexo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Multiplevaluesseparator") ;
            Combo_migrlegsexo_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Addnewoptiontext") ;
            Combo_migrlegsexo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGSEXO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegestadocivil_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Objectcall") ;
            Combo_migrlegestadocivil_Class = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Class") ;
            Combo_migrlegestadocivil_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Icontype") ;
            Combo_migrlegestadocivil_Icon = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Icon") ;
            Combo_migrlegestadocivil_Caption = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Caption") ;
            Combo_migrlegestadocivil_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Tooltip") ;
            Combo_migrlegestadocivil_Cls = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Cls") ;
            Combo_migrlegestadocivil_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Selectedvalue_set") ;
            Combo_migrlegestadocivil_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Selectedvalue_get") ;
            Combo_migrlegestadocivil_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Selectedtext_set") ;
            Combo_migrlegestadocivil_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Selectedtext_get") ;
            Combo_migrlegestadocivil_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Gamoauthtoken") ;
            Combo_migrlegestadocivil_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Ddointernalname") ;
            Combo_migrlegestadocivil_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Titlecontrolalign") ;
            Combo_migrlegestadocivil_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Dropdownoptionstype") ;
            Combo_migrlegestadocivil_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Enabled")) ;
            Combo_migrlegestadocivil_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Visible")) ;
            Combo_migrlegestadocivil_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Titlecontrolidtoreplace") ;
            Combo_migrlegestadocivil_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Datalisttype") ;
            Combo_migrlegestadocivil_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Allowmultipleselection")) ;
            Combo_migrlegestadocivil_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Datalistfixedvalues") ;
            Combo_migrlegestadocivil_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Isgriditem")) ;
            Combo_migrlegestadocivil_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Hasdescription")) ;
            Combo_migrlegestadocivil_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Datalistproc") ;
            Combo_migrlegestadocivil_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Datalistprocparametersprefix") ;
            Combo_migrlegestadocivil_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Remoteservicesparameters") ;
            Combo_migrlegestadocivil_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegestadocivil_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Includeonlyselectedoption")) ;
            Combo_migrlegestadocivil_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Includeselectalloption")) ;
            Combo_migrlegestadocivil_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Emptyitem")) ;
            Combo_migrlegestadocivil_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Includeaddnewoption")) ;
            Combo_migrlegestadocivil_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Htmltemplate") ;
            Combo_migrlegestadocivil_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Multiplevaluestype") ;
            Combo_migrlegestadocivil_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Loadingdata") ;
            Combo_migrlegestadocivil_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Noresultsfound") ;
            Combo_migrlegestadocivil_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Emptyitemtext") ;
            Combo_migrlegestadocivil_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Onlyselectedvalues") ;
            Combo_migrlegestadocivil_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Selectalltext") ;
            Combo_migrlegestadocivil_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Multiplevaluesseparator") ;
            Combo_migrlegestadocivil_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Addnewoptiontext") ;
            Combo_migrlegestadocivil_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGESTADOCIVIL_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegarea_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Objectcall") ;
            Combo_migrlegarea_Class = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Class") ;
            Combo_migrlegarea_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Icontype") ;
            Combo_migrlegarea_Icon = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Icon") ;
            Combo_migrlegarea_Caption = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Caption") ;
            Combo_migrlegarea_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Tooltip") ;
            Combo_migrlegarea_Cls = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Cls") ;
            Combo_migrlegarea_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Selectedvalue_set") ;
            Combo_migrlegarea_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Selectedvalue_get") ;
            Combo_migrlegarea_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Selectedtext_set") ;
            Combo_migrlegarea_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Selectedtext_get") ;
            Combo_migrlegarea_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Gamoauthtoken") ;
            Combo_migrlegarea_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Ddointernalname") ;
            Combo_migrlegarea_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Titlecontrolalign") ;
            Combo_migrlegarea_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Dropdownoptionstype") ;
            Combo_migrlegarea_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Enabled")) ;
            Combo_migrlegarea_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Visible")) ;
            Combo_migrlegarea_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Titlecontrolidtoreplace") ;
            Combo_migrlegarea_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Datalisttype") ;
            Combo_migrlegarea_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Allowmultipleselection")) ;
            Combo_migrlegarea_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Datalistfixedvalues") ;
            Combo_migrlegarea_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Isgriditem")) ;
            Combo_migrlegarea_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Hasdescription")) ;
            Combo_migrlegarea_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Datalistproc") ;
            Combo_migrlegarea_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Datalistprocparametersprefix") ;
            Combo_migrlegarea_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Remoteservicesparameters") ;
            Combo_migrlegarea_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegarea_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Includeonlyselectedoption")) ;
            Combo_migrlegarea_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Includeselectalloption")) ;
            Combo_migrlegarea_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Emptyitem")) ;
            Combo_migrlegarea_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Includeaddnewoption")) ;
            Combo_migrlegarea_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Htmltemplate") ;
            Combo_migrlegarea_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Multiplevaluestype") ;
            Combo_migrlegarea_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Loadingdata") ;
            Combo_migrlegarea_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Noresultsfound") ;
            Combo_migrlegarea_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Emptyitemtext") ;
            Combo_migrlegarea_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Onlyselectedvalues") ;
            Combo_migrlegarea_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Selectalltext") ;
            Combo_migrlegarea_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Multiplevaluesseparator") ;
            Combo_migrlegarea_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGAREA_Addnewoptiontext") ;
            Combo_migrlegarea_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGAREA_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegsindicato_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Objectcall") ;
            Combo_migrlegsindicato_Class = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Class") ;
            Combo_migrlegsindicato_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Icontype") ;
            Combo_migrlegsindicato_Icon = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Icon") ;
            Combo_migrlegsindicato_Caption = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Caption") ;
            Combo_migrlegsindicato_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Tooltip") ;
            Combo_migrlegsindicato_Cls = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Cls") ;
            Combo_migrlegsindicato_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Selectedvalue_set") ;
            Combo_migrlegsindicato_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Selectedvalue_get") ;
            Combo_migrlegsindicato_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Selectedtext_set") ;
            Combo_migrlegsindicato_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Selectedtext_get") ;
            Combo_migrlegsindicato_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Gamoauthtoken") ;
            Combo_migrlegsindicato_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Ddointernalname") ;
            Combo_migrlegsindicato_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Titlecontrolalign") ;
            Combo_migrlegsindicato_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Dropdownoptionstype") ;
            Combo_migrlegsindicato_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Enabled")) ;
            Combo_migrlegsindicato_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Visible")) ;
            Combo_migrlegsindicato_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Titlecontrolidtoreplace") ;
            Combo_migrlegsindicato_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Datalisttype") ;
            Combo_migrlegsindicato_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Allowmultipleselection")) ;
            Combo_migrlegsindicato_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Datalistfixedvalues") ;
            Combo_migrlegsindicato_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Isgriditem")) ;
            Combo_migrlegsindicato_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Hasdescription")) ;
            Combo_migrlegsindicato_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Datalistproc") ;
            Combo_migrlegsindicato_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Datalistprocparametersprefix") ;
            Combo_migrlegsindicato_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Remoteservicesparameters") ;
            Combo_migrlegsindicato_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegsindicato_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Includeonlyselectedoption")) ;
            Combo_migrlegsindicato_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Includeselectalloption")) ;
            Combo_migrlegsindicato_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Emptyitem")) ;
            Combo_migrlegsindicato_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Includeaddnewoption")) ;
            Combo_migrlegsindicato_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Htmltemplate") ;
            Combo_migrlegsindicato_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Multiplevaluestype") ;
            Combo_migrlegsindicato_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Loadingdata") ;
            Combo_migrlegsindicato_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Noresultsfound") ;
            Combo_migrlegsindicato_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Emptyitemtext") ;
            Combo_migrlegsindicato_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Onlyselectedvalues") ;
            Combo_migrlegsindicato_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Selectalltext") ;
            Combo_migrlegsindicato_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Multiplevaluesseparator") ;
            Combo_migrlegsindicato_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Addnewoptiontext") ;
            Combo_migrlegsindicato_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGSINDICATO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegconvenio_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Objectcall") ;
            Combo_migrlegconvenio_Class = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Class") ;
            Combo_migrlegconvenio_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Icontype") ;
            Combo_migrlegconvenio_Icon = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Icon") ;
            Combo_migrlegconvenio_Caption = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Caption") ;
            Combo_migrlegconvenio_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Tooltip") ;
            Combo_migrlegconvenio_Cls = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Cls") ;
            Combo_migrlegconvenio_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Selectedvalue_set") ;
            Combo_migrlegconvenio_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Selectedvalue_get") ;
            Combo_migrlegconvenio_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Selectedtext_set") ;
            Combo_migrlegconvenio_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Selectedtext_get") ;
            Combo_migrlegconvenio_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Gamoauthtoken") ;
            Combo_migrlegconvenio_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Ddointernalname") ;
            Combo_migrlegconvenio_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Titlecontrolalign") ;
            Combo_migrlegconvenio_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Dropdownoptionstype") ;
            Combo_migrlegconvenio_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Enabled")) ;
            Combo_migrlegconvenio_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Visible")) ;
            Combo_migrlegconvenio_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Titlecontrolidtoreplace") ;
            Combo_migrlegconvenio_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Datalisttype") ;
            Combo_migrlegconvenio_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Allowmultipleselection")) ;
            Combo_migrlegconvenio_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Datalistfixedvalues") ;
            Combo_migrlegconvenio_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Isgriditem")) ;
            Combo_migrlegconvenio_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Hasdescription")) ;
            Combo_migrlegconvenio_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Datalistproc") ;
            Combo_migrlegconvenio_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Datalistprocparametersprefix") ;
            Combo_migrlegconvenio_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Remoteservicesparameters") ;
            Combo_migrlegconvenio_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegconvenio_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Includeonlyselectedoption")) ;
            Combo_migrlegconvenio_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Includeselectalloption")) ;
            Combo_migrlegconvenio_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Emptyitem")) ;
            Combo_migrlegconvenio_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Includeaddnewoption")) ;
            Combo_migrlegconvenio_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Htmltemplate") ;
            Combo_migrlegconvenio_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Multiplevaluestype") ;
            Combo_migrlegconvenio_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Loadingdata") ;
            Combo_migrlegconvenio_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Noresultsfound") ;
            Combo_migrlegconvenio_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Emptyitemtext") ;
            Combo_migrlegconvenio_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Onlyselectedvalues") ;
            Combo_migrlegconvenio_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Selectalltext") ;
            Combo_migrlegconvenio_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Multiplevaluesseparator") ;
            Combo_migrlegconvenio_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Addnewoptiontext") ;
            Combo_migrlegconvenio_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCONVENIO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegcategoria_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Objectcall") ;
            Combo_migrlegcategoria_Class = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Class") ;
            Combo_migrlegcategoria_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Icontype") ;
            Combo_migrlegcategoria_Icon = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Icon") ;
            Combo_migrlegcategoria_Caption = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Caption") ;
            Combo_migrlegcategoria_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Tooltip") ;
            Combo_migrlegcategoria_Cls = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Cls") ;
            Combo_migrlegcategoria_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Selectedvalue_set") ;
            Combo_migrlegcategoria_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Selectedvalue_get") ;
            Combo_migrlegcategoria_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Selectedtext_set") ;
            Combo_migrlegcategoria_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Selectedtext_get") ;
            Combo_migrlegcategoria_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Gamoauthtoken") ;
            Combo_migrlegcategoria_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Ddointernalname") ;
            Combo_migrlegcategoria_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Titlecontrolalign") ;
            Combo_migrlegcategoria_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Dropdownoptionstype") ;
            Combo_migrlegcategoria_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Enabled")) ;
            Combo_migrlegcategoria_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Visible")) ;
            Combo_migrlegcategoria_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Titlecontrolidtoreplace") ;
            Combo_migrlegcategoria_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Datalisttype") ;
            Combo_migrlegcategoria_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Allowmultipleselection")) ;
            Combo_migrlegcategoria_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Datalistfixedvalues") ;
            Combo_migrlegcategoria_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Isgriditem")) ;
            Combo_migrlegcategoria_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Hasdescription")) ;
            Combo_migrlegcategoria_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Datalistproc") ;
            Combo_migrlegcategoria_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Datalistprocparametersprefix") ;
            Combo_migrlegcategoria_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Remoteservicesparameters") ;
            Combo_migrlegcategoria_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegcategoria_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Includeonlyselectedoption")) ;
            Combo_migrlegcategoria_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Includeselectalloption")) ;
            Combo_migrlegcategoria_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Emptyitem")) ;
            Combo_migrlegcategoria_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Includeaddnewoption")) ;
            Combo_migrlegcategoria_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Htmltemplate") ;
            Combo_migrlegcategoria_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Multiplevaluestype") ;
            Combo_migrlegcategoria_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Loadingdata") ;
            Combo_migrlegcategoria_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Noresultsfound") ;
            Combo_migrlegcategoria_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Emptyitemtext") ;
            Combo_migrlegcategoria_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Onlyselectedvalues") ;
            Combo_migrlegcategoria_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Selectalltext") ;
            Combo_migrlegcategoria_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Multiplevaluesseparator") ;
            Combo_migrlegcategoria_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Addnewoptiontext") ;
            Combo_migrlegcategoria_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCATEGORIA_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegbanco_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Objectcall") ;
            Combo_migrlegbanco_Class = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Class") ;
            Combo_migrlegbanco_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Icontype") ;
            Combo_migrlegbanco_Icon = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Icon") ;
            Combo_migrlegbanco_Caption = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Caption") ;
            Combo_migrlegbanco_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Tooltip") ;
            Combo_migrlegbanco_Cls = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Cls") ;
            Combo_migrlegbanco_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Selectedvalue_set") ;
            Combo_migrlegbanco_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Selectedvalue_get") ;
            Combo_migrlegbanco_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Selectedtext_set") ;
            Combo_migrlegbanco_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Selectedtext_get") ;
            Combo_migrlegbanco_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Gamoauthtoken") ;
            Combo_migrlegbanco_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Ddointernalname") ;
            Combo_migrlegbanco_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Titlecontrolalign") ;
            Combo_migrlegbanco_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Dropdownoptionstype") ;
            Combo_migrlegbanco_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Enabled")) ;
            Combo_migrlegbanco_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Visible")) ;
            Combo_migrlegbanco_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Titlecontrolidtoreplace") ;
            Combo_migrlegbanco_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Datalisttype") ;
            Combo_migrlegbanco_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Allowmultipleselection")) ;
            Combo_migrlegbanco_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Datalistfixedvalues") ;
            Combo_migrlegbanco_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Isgriditem")) ;
            Combo_migrlegbanco_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Hasdescription")) ;
            Combo_migrlegbanco_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Datalistproc") ;
            Combo_migrlegbanco_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Datalistprocparametersprefix") ;
            Combo_migrlegbanco_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Remoteservicesparameters") ;
            Combo_migrlegbanco_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegbanco_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Includeonlyselectedoption")) ;
            Combo_migrlegbanco_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Includeselectalloption")) ;
            Combo_migrlegbanco_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Emptyitem")) ;
            Combo_migrlegbanco_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Includeaddnewoption")) ;
            Combo_migrlegbanco_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Htmltemplate") ;
            Combo_migrlegbanco_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Multiplevaluestype") ;
            Combo_migrlegbanco_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Loadingdata") ;
            Combo_migrlegbanco_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Noresultsfound") ;
            Combo_migrlegbanco_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Emptyitemtext") ;
            Combo_migrlegbanco_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Onlyselectedvalues") ;
            Combo_migrlegbanco_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Selectalltext") ;
            Combo_migrlegbanco_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Multiplevaluesseparator") ;
            Combo_migrlegbanco_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Addnewoptiontext") ;
            Combo_migrlegbanco_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGBANCO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegobrasocial_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Objectcall") ;
            Combo_migrlegobrasocial_Class = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Class") ;
            Combo_migrlegobrasocial_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Icontype") ;
            Combo_migrlegobrasocial_Icon = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Icon") ;
            Combo_migrlegobrasocial_Caption = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Caption") ;
            Combo_migrlegobrasocial_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Tooltip") ;
            Combo_migrlegobrasocial_Cls = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Cls") ;
            Combo_migrlegobrasocial_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Selectedvalue_set") ;
            Combo_migrlegobrasocial_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Selectedvalue_get") ;
            Combo_migrlegobrasocial_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Selectedtext_set") ;
            Combo_migrlegobrasocial_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Selectedtext_get") ;
            Combo_migrlegobrasocial_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Gamoauthtoken") ;
            Combo_migrlegobrasocial_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Ddointernalname") ;
            Combo_migrlegobrasocial_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Titlecontrolalign") ;
            Combo_migrlegobrasocial_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Dropdownoptionstype") ;
            Combo_migrlegobrasocial_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Enabled")) ;
            Combo_migrlegobrasocial_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Visible")) ;
            Combo_migrlegobrasocial_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Titlecontrolidtoreplace") ;
            Combo_migrlegobrasocial_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Datalisttype") ;
            Combo_migrlegobrasocial_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Allowmultipleselection")) ;
            Combo_migrlegobrasocial_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Datalistfixedvalues") ;
            Combo_migrlegobrasocial_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Isgriditem")) ;
            Combo_migrlegobrasocial_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Hasdescription")) ;
            Combo_migrlegobrasocial_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Datalistproc") ;
            Combo_migrlegobrasocial_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Datalistprocparametersprefix") ;
            Combo_migrlegobrasocial_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Remoteservicesparameters") ;
            Combo_migrlegobrasocial_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegobrasocial_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Includeonlyselectedoption")) ;
            Combo_migrlegobrasocial_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Includeselectalloption")) ;
            Combo_migrlegobrasocial_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Emptyitem")) ;
            Combo_migrlegobrasocial_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Includeaddnewoption")) ;
            Combo_migrlegobrasocial_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Htmltemplate") ;
            Combo_migrlegobrasocial_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Multiplevaluestype") ;
            Combo_migrlegobrasocial_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Loadingdata") ;
            Combo_migrlegobrasocial_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Noresultsfound") ;
            Combo_migrlegobrasocial_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Emptyitemtext") ;
            Combo_migrlegobrasocial_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Onlyselectedvalues") ;
            Combo_migrlegobrasocial_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Selectalltext") ;
            Combo_migrlegobrasocial_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Multiplevaluesseparator") ;
            Combo_migrlegobrasocial_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Addnewoptiontext") ;
            Combo_migrlegobrasocial_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGOBRASOCIAL_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegmodalidad_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Objectcall") ;
            Combo_migrlegmodalidad_Class = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Class") ;
            Combo_migrlegmodalidad_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Icontype") ;
            Combo_migrlegmodalidad_Icon = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Icon") ;
            Combo_migrlegmodalidad_Caption = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Caption") ;
            Combo_migrlegmodalidad_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Tooltip") ;
            Combo_migrlegmodalidad_Cls = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Cls") ;
            Combo_migrlegmodalidad_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Selectedvalue_set") ;
            Combo_migrlegmodalidad_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Selectedvalue_get") ;
            Combo_migrlegmodalidad_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Selectedtext_set") ;
            Combo_migrlegmodalidad_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Selectedtext_get") ;
            Combo_migrlegmodalidad_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Gamoauthtoken") ;
            Combo_migrlegmodalidad_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Ddointernalname") ;
            Combo_migrlegmodalidad_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Titlecontrolalign") ;
            Combo_migrlegmodalidad_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Dropdownoptionstype") ;
            Combo_migrlegmodalidad_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Enabled")) ;
            Combo_migrlegmodalidad_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Visible")) ;
            Combo_migrlegmodalidad_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Titlecontrolidtoreplace") ;
            Combo_migrlegmodalidad_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Datalisttype") ;
            Combo_migrlegmodalidad_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Allowmultipleselection")) ;
            Combo_migrlegmodalidad_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Datalistfixedvalues") ;
            Combo_migrlegmodalidad_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Isgriditem")) ;
            Combo_migrlegmodalidad_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Hasdescription")) ;
            Combo_migrlegmodalidad_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Datalistproc") ;
            Combo_migrlegmodalidad_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Datalistprocparametersprefix") ;
            Combo_migrlegmodalidad_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Remoteservicesparameters") ;
            Combo_migrlegmodalidad_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegmodalidad_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Includeonlyselectedoption")) ;
            Combo_migrlegmodalidad_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Includeselectalloption")) ;
            Combo_migrlegmodalidad_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Emptyitem")) ;
            Combo_migrlegmodalidad_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Includeaddnewoption")) ;
            Combo_migrlegmodalidad_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Htmltemplate") ;
            Combo_migrlegmodalidad_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Multiplevaluestype") ;
            Combo_migrlegmodalidad_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Loadingdata") ;
            Combo_migrlegmodalidad_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Noresultsfound") ;
            Combo_migrlegmodalidad_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Emptyitemtext") ;
            Combo_migrlegmodalidad_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Onlyselectedvalues") ;
            Combo_migrlegmodalidad_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Selectalltext") ;
            Combo_migrlegmodalidad_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Multiplevaluesseparator") ;
            Combo_migrlegmodalidad_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Addnewoptiontext") ;
            Combo_migrlegmodalidad_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGMODALIDAD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegzona_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Objectcall") ;
            Combo_migrlegzona_Class = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Class") ;
            Combo_migrlegzona_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Icontype") ;
            Combo_migrlegzona_Icon = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Icon") ;
            Combo_migrlegzona_Caption = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Caption") ;
            Combo_migrlegzona_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Tooltip") ;
            Combo_migrlegzona_Cls = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Cls") ;
            Combo_migrlegzona_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Selectedvalue_set") ;
            Combo_migrlegzona_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Selectedvalue_get") ;
            Combo_migrlegzona_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Selectedtext_set") ;
            Combo_migrlegzona_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Selectedtext_get") ;
            Combo_migrlegzona_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Gamoauthtoken") ;
            Combo_migrlegzona_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Ddointernalname") ;
            Combo_migrlegzona_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Titlecontrolalign") ;
            Combo_migrlegzona_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Dropdownoptionstype") ;
            Combo_migrlegzona_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Enabled")) ;
            Combo_migrlegzona_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Visible")) ;
            Combo_migrlegzona_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Titlecontrolidtoreplace") ;
            Combo_migrlegzona_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Datalisttype") ;
            Combo_migrlegzona_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Allowmultipleselection")) ;
            Combo_migrlegzona_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Datalistfixedvalues") ;
            Combo_migrlegzona_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Isgriditem")) ;
            Combo_migrlegzona_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Hasdescription")) ;
            Combo_migrlegzona_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Datalistproc") ;
            Combo_migrlegzona_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Datalistprocparametersprefix") ;
            Combo_migrlegzona_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Remoteservicesparameters") ;
            Combo_migrlegzona_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegzona_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Includeonlyselectedoption")) ;
            Combo_migrlegzona_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Includeselectalloption")) ;
            Combo_migrlegzona_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Emptyitem")) ;
            Combo_migrlegzona_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Includeaddnewoption")) ;
            Combo_migrlegzona_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Htmltemplate") ;
            Combo_migrlegzona_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Multiplevaluestype") ;
            Combo_migrlegzona_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Loadingdata") ;
            Combo_migrlegzona_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Noresultsfound") ;
            Combo_migrlegzona_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Emptyitemtext") ;
            Combo_migrlegzona_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Onlyselectedvalues") ;
            Combo_migrlegzona_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Selectalltext") ;
            Combo_migrlegzona_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Multiplevaluesseparator") ;
            Combo_migrlegzona_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGZONA_Addnewoptiontext") ;
            Combo_migrlegzona_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGZONA_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegactividad_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Objectcall") ;
            Combo_migrlegactividad_Class = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Class") ;
            Combo_migrlegactividad_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Icontype") ;
            Combo_migrlegactividad_Icon = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Icon") ;
            Combo_migrlegactividad_Caption = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Caption") ;
            Combo_migrlegactividad_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Tooltip") ;
            Combo_migrlegactividad_Cls = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Cls") ;
            Combo_migrlegactividad_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Selectedvalue_set") ;
            Combo_migrlegactividad_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Selectedvalue_get") ;
            Combo_migrlegactividad_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Selectedtext_set") ;
            Combo_migrlegactividad_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Selectedtext_get") ;
            Combo_migrlegactividad_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Gamoauthtoken") ;
            Combo_migrlegactividad_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Ddointernalname") ;
            Combo_migrlegactividad_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Titlecontrolalign") ;
            Combo_migrlegactividad_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Dropdownoptionstype") ;
            Combo_migrlegactividad_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Enabled")) ;
            Combo_migrlegactividad_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Visible")) ;
            Combo_migrlegactividad_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Titlecontrolidtoreplace") ;
            Combo_migrlegactividad_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Datalisttype") ;
            Combo_migrlegactividad_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Allowmultipleselection")) ;
            Combo_migrlegactividad_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Datalistfixedvalues") ;
            Combo_migrlegactividad_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Isgriditem")) ;
            Combo_migrlegactividad_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Hasdescription")) ;
            Combo_migrlegactividad_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Datalistproc") ;
            Combo_migrlegactividad_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Datalistprocparametersprefix") ;
            Combo_migrlegactividad_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Remoteservicesparameters") ;
            Combo_migrlegactividad_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegactividad_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Includeonlyselectedoption")) ;
            Combo_migrlegactividad_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Includeselectalloption")) ;
            Combo_migrlegactividad_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Emptyitem")) ;
            Combo_migrlegactividad_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Includeaddnewoption")) ;
            Combo_migrlegactividad_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Htmltemplate") ;
            Combo_migrlegactividad_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Multiplevaluestype") ;
            Combo_migrlegactividad_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Loadingdata") ;
            Combo_migrlegactividad_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Noresultsfound") ;
            Combo_migrlegactividad_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Emptyitemtext") ;
            Combo_migrlegactividad_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Onlyselectedvalues") ;
            Combo_migrlegactividad_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Selectalltext") ;
            Combo_migrlegactividad_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Multiplevaluesseparator") ;
            Combo_migrlegactividad_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Addnewoptiontext") ;
            Combo_migrlegactividad_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGACTIVIDAD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegcondicion_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Objectcall") ;
            Combo_migrlegcondicion_Class = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Class") ;
            Combo_migrlegcondicion_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Icontype") ;
            Combo_migrlegcondicion_Icon = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Icon") ;
            Combo_migrlegcondicion_Caption = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Caption") ;
            Combo_migrlegcondicion_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Tooltip") ;
            Combo_migrlegcondicion_Cls = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Cls") ;
            Combo_migrlegcondicion_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Selectedvalue_set") ;
            Combo_migrlegcondicion_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Selectedvalue_get") ;
            Combo_migrlegcondicion_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Selectedtext_set") ;
            Combo_migrlegcondicion_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Selectedtext_get") ;
            Combo_migrlegcondicion_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Gamoauthtoken") ;
            Combo_migrlegcondicion_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Ddointernalname") ;
            Combo_migrlegcondicion_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Titlecontrolalign") ;
            Combo_migrlegcondicion_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Dropdownoptionstype") ;
            Combo_migrlegcondicion_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Enabled")) ;
            Combo_migrlegcondicion_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Visible")) ;
            Combo_migrlegcondicion_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Titlecontrolidtoreplace") ;
            Combo_migrlegcondicion_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Datalisttype") ;
            Combo_migrlegcondicion_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Allowmultipleselection")) ;
            Combo_migrlegcondicion_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Datalistfixedvalues") ;
            Combo_migrlegcondicion_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Isgriditem")) ;
            Combo_migrlegcondicion_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Hasdescription")) ;
            Combo_migrlegcondicion_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Datalistproc") ;
            Combo_migrlegcondicion_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Datalistprocparametersprefix") ;
            Combo_migrlegcondicion_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Remoteservicesparameters") ;
            Combo_migrlegcondicion_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegcondicion_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Includeonlyselectedoption")) ;
            Combo_migrlegcondicion_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Includeselectalloption")) ;
            Combo_migrlegcondicion_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Emptyitem")) ;
            Combo_migrlegcondicion_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Includeaddnewoption")) ;
            Combo_migrlegcondicion_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Htmltemplate") ;
            Combo_migrlegcondicion_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Multiplevaluestype") ;
            Combo_migrlegcondicion_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Loadingdata") ;
            Combo_migrlegcondicion_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Noresultsfound") ;
            Combo_migrlegcondicion_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Emptyitemtext") ;
            Combo_migrlegcondicion_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Onlyselectedvalues") ;
            Combo_migrlegcondicion_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Selectalltext") ;
            Combo_migrlegcondicion_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Multiplevaluesseparator") ;
            Combo_migrlegcondicion_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Addnewoptiontext") ;
            Combo_migrlegcondicion_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGCONDICION_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A626MigrLegId = httpContext.cgiGet( edtMigrLegId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
            A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
            A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
            A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
            cmbMigrLegModTra.setValue( httpContext.cgiGet( cmbMigrLegModTra.getInternalname()) );
            A2415MigrLegModTra = httpContext.cgiGet( cmbMigrLegModTra.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
            cmbMigrLegTipoTarifa.setValue( httpContext.cgiGet( cmbMigrLegTipoTarifa.getInternalname()) );
            A2427MigrLegTipoTarifa = httpContext.cgiGet( cmbMigrLegTipoTarifa.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
            cmbMigrLegClase.setValue( httpContext.cgiGet( cmbMigrLegClase.getInternalname()) );
            A607MigrLegClase = httpContext.cgiGet( cmbMigrLegClase.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
            if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFecNac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MIGRLEGFECNAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFecNac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A594MigrLegFecNac = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
            }
            else
            {
               A594MigrLegFecNac = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MIGRLEGFECINGRESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFecIngreso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A603MigrLegFecIngreso = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
            }
            else
            {
               A603MigrLegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
            }
            A595MigrLegSexo = httpContext.cgiGet( edtMigrLegSexo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
            A599MigrLegDomici = httpContext.cgiGet( edtMigrLegDomici_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
            A601MigrLegCodPos = httpContext.cgiGet( edtMigrLegCodPos_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
            A602MigrLegTelefono = httpContext.cgiGet( edtMigrLegTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
            A600MigrLegEmail = httpContext.cgiGet( edtMigrLegEmail_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
            A596MigrLegEstadoCivil = httpContext.cgiGet( edtMigrLegEstadoCivil_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
            A605MigrLegArea = httpContext.cgiGet( edtMigrLegArea_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
            A613MigrLegSindicato = httpContext.cgiGet( edtMigrLegSindicato_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
            A627MigrLegConvenio = httpContext.cgiGet( edtMigrLegConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
            A604MigrLegCategoria = httpContext.cgiGet( edtMigrLegCategoria_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
            A610MigrLegBanco = httpContext.cgiGet( edtMigrLegBanco_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGBASICO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegBasico_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A608MigrLegBasico = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
            }
            else
            {
               A608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
            }
            A614MigrLegObraSocial = httpContext.cgiGet( edtMigrLegObraSocial_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
            A621MigrLegCBU = httpContext.cgiGet( edtMigrLegCBU_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
            A617MigrLegModalidad = httpContext.cgiGet( edtMigrLegModalidad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGHORSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegHorSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2275MigrLegHorSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
            }
            else
            {
               A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
            }
            A620MigrLegZona = httpContext.cgiGet( edtMigrLegZona_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
            A616MigrLegActividad = httpContext.cgiGet( edtMigrLegActividad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
            A624MigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtMigrLegCondicion_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
            A2239MigrLegActLabClas = httpContext.cgiGet( edtMigrLegActLabClas_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
            A2240MigrLegPueAfip = httpContext.cgiGet( edtMigrLegPueAfip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
            A628MigrLegObs = httpContext.cgiGet( edtMigrLegObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
            AV190ComboMigrLegSexo = httpContext.cgiGet( edtavCombomigrlegsexo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV190ComboMigrLegSexo", AV190ComboMigrLegSexo);
            AV192ComboMigrLegEstadoCivil = httpContext.cgiGet( edtavCombomigrlegestadocivil_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV192ComboMigrLegEstadoCivil", AV192ComboMigrLegEstadoCivil);
            AV13ComboMigrLegArea = httpContext.cgiGet( edtavCombomigrlegarea_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13ComboMigrLegArea", AV13ComboMigrLegArea);
            AV134ComboMigrLegSindicato = httpContext.cgiGet( edtavCombomigrlegsindicato_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134ComboMigrLegSindicato", AV134ComboMigrLegSindicato);
            AV136ComboMigrLegConvenio = httpContext.cgiGet( edtavCombomigrlegconvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV136ComboMigrLegConvenio", AV136ComboMigrLegConvenio);
            AV127ComboMigrLegCategoria = httpContext.cgiGet( edtavCombomigrlegcategoria_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV127ComboMigrLegCategoria", AV127ComboMigrLegCategoria);
            AV140ComboMigrLegBanco = httpContext.cgiGet( edtavCombomigrlegbanco_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV140ComboMigrLegBanco", AV140ComboMigrLegBanco);
            AV132ComboMigrLegObraSocial = httpContext.cgiGet( edtavCombomigrlegobrasocial_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV132ComboMigrLegObraSocial", AV132ComboMigrLegObraSocial);
            AV142ComboMigrLegModalidad = httpContext.cgiGet( edtavCombomigrlegmodalidad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV142ComboMigrLegModalidad", AV142ComboMigrLegModalidad);
            AV130ComboMigrLegZona = httpContext.cgiGet( edtavCombomigrlegzona_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV130ComboMigrLegZona", AV130ComboMigrLegZona);
            AV144ComboMigrLegActividad = httpContext.cgiGet( edtavCombomigrlegactividad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV144ComboMigrLegActividad", AV144ComboMigrLegActividad);
            AV148ComboMigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtavCombomigrlegcondicion_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV148ComboMigrLegCondicion", AV148ComboMigrLegCondicion);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A87MigrLegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            else
            {
               A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            A598MigrLegDiscapacidad = httpContext.cgiGet( edtMigrLegDiscapacidad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
            A634MigrLegOSAfip = httpContext.cgiGet( edtMigrLegOSAfip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
            A606MigrLegLugarDePago = GXutil.upper( httpContext.cgiGet( edtMigrLegLugarDePago_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
            A611MigrLegBanSuc = httpContext.cgiGet( edtMigrLegBanSuc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
            A612MigrLegBanTipCuen = GXutil.upper( httpContext.cgiGet( edtMigrLegBanTipCuen_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
            A619MigrLegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtMigrLegCuentaBanc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
            A609MigrLegFormaPago = httpContext.cgiGet( edtMigrLegFormaPago_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
            A623MigrLegSituacionRevista = GXutil.upper( httpContext.cgiGet( edtMigrLegSituacionRevista_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
            A625MigrLegSiniestrado = httpContext.cgiGet( edtMigrLegSiniestrado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
            A622MigrLegSCVO = httpContext.cgiGet( edtMigrLegSCVO_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
            A615MigrLegPlanMedico = httpContext.cgiGet( edtMigrLegPlanMedico_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
            A631MigrTieneConyuge = httpContext.cgiGet( edtMigrTieneConyuge_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRCANTIDADHIJOS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrCantidadHijos_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A632MigrCantidadHijos = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
            }
            else
            {
               A632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MigrLegUPD");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
            forbiddenHiddens.add("MigrEncontroOsoSigla", GXutil.booltostr( A635MigrEncontroOsoSigla));
            forbiddenHiddens.add("MigrLegAreaDef", GXutil.booltostr( A689MigrLegAreaDef));
            forbiddenHiddens.add("MigrLegEstadoCivilDef", GXutil.booltostr( A690MigrLegEstadoCivilDef));
            forbiddenHiddens.add("MigrLegClaseDef", GXutil.booltostr( A691MigrLegClaseDef));
            forbiddenHiddens.add("MigrLegFormaPagoDef", GXutil.booltostr( A692MigrLegFormaPagoDef));
            forbiddenHiddens.add("MigrLegTipoCuentaDef", GXutil.booltostr( A693MigrLegTipoCuentaDef));
            forbiddenHiddens.add("MigrLegActividadDef", GXutil.booltostr( A694MigrLegActividadDef));
            forbiddenHiddens.add("MigrLegModalidadDef", GXutil.booltostr( A695MigrLegModalidadDef));
            forbiddenHiddens.add("MigrLegZonaDef", GXutil.booltostr( A696MigrLegZonaDef));
            forbiddenHiddens.add("MigrLegSCVODef", GXutil.booltostr( A697MigrLegSCVODef));
            forbiddenHiddens.add("MigrLegSituacionDef", GXutil.booltostr( A698MigrLegSituacionDef));
            forbiddenHiddens.add("MigrLegCondicionDef", GXutil.booltostr( A699MigrLegCondicionDef));
            forbiddenHiddens.add("MigrLegSiniestradoDef", GXutil.booltostr( A700MigrLegSiniestradoDef));
            forbiddenHiddens.add("MigrPuesto", GXutil.rtrim( localUtil.format( A2216MigrPuesto, "")));
            forbiddenHiddens.add("MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("migrlegupd:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A87MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
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
                  sMode75 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode75 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound75 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_280( ) ;
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
                     if ( GXutil.strcmp(sEvt, "COMBO_MIGRLEGCONVENIO.ONOPTIONCLICKED") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e12282 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11282 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e13282 ();
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
               else if ( GXutil.strcmp(sEvtType, "W") == 0 )
               {
                  sEvtType = GXutil.left( sEvt, 4) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 334 )
                  {
                     OldWcimportarlegajofamilia = httpContext.cgiGet( "W0334") ;
                     if ( ( GXutil.len( OldWcimportarlegajofamilia) == 0 ) || ( GXutil.strcmp(OldWcimportarlegajofamilia, WebComp_Wcimportarlegajofamilia_Component) != 0 ) )
                     {
                        WebComp_Wcimportarlegajofamilia = WebUtils.getWebComponent(getClass(), "web." + OldWcimportarlegajofamilia + "_impl", remoteHandle, context);
                        WebComp_Wcimportarlegajofamilia_Component = OldWcimportarlegajofamilia ;
                     }
                     if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
                     {
                        WebComp_Wcimportarlegajofamilia.componentprocess("W0334", "", sEvt);
                     }
                     WebComp_Wcimportarlegajofamilia_Component = OldWcimportarlegajofamilia ;
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
         e13282 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2875( ) ;
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
      if ( isDsp( ) || isDlt( ) )
      {
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes2875( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsexo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegestadocivil_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegestadocivil_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegarea_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegarea_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsindicato_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsindicato_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegconvenio_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcategoria_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcategoria_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegbanco_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegbanco_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegobrasocial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegobrasocial_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegmodalidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegmodalidad_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegzona_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegzona_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegactividad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegactividad_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcondicion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcondicion_Enabled), 5, 0), true);
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

   public void confirm_280( )
   {
      beforeValidate2875( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2875( ) ;
         }
         else
         {
            checkExtendedTable2875( ) ;
            closeExtendedTableCursors2875( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption280( )
   {
   }

   public void e11282( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_char1[0] = AV25MigrLegArea ;
      GXv_char2[0] = AV36MigrLegLugarDePago ;
      GXv_char3[0] = AV30MigrLegCategoria ;
      GXv_char4[0] = AV28MigrLegBanco ;
      GXv_char5[0] = AV45MigrLegSindicato ;
      GXv_char6[0] = AV41MigrLegObraSocial ;
      GXv_char7[0] = AV43MigrLegPlanMedico ;
      GXv_char8[0] = AV23MigrLegActividad ;
      GXv_char9[0] = AV38MigrLegModalidad ;
      GXv_char10[0] = AV51MigrLegZona ;
      GXv_char11[0] = AV49MigrLegSituacionRevista ;
      GXv_char12[0] = AV34MigrLegConvenio ;
      GXv_char13[0] = AV32MigrLegCondicion ;
      GXv_char14[0] = AV47MigrLegSiniestrado ;
      GXv_char15[0] = AV90MigrLegSexo ;
      GXv_char16[0] = AV195MigrLegModTra ;
      GXv_char17[0] = AV196MigrLegTipoTarifa ;
      GXv_char18[0] = AV94MigrLegClase ;
      GXv_char19[0] = AV105MigrLegEstadoCivil ;
      GXv_char20[0] = AV109MigrLegBanTipCuen ;
      GXv_char21[0] = AV106MigrLegDiscapacidad ;
      GXv_char22[0] = AV107MigrLegFormaPago ;
      GXv_char23[0] = AV100MigrLegSCVO ;
      GXv_char24[0] = AV101MigrTieneConyuge ;
      GXv_boolean25[0] = AV184MigrEncontroOsoAfip ;
      GXv_boolean26[0] = AV185MigrEncontroOsoSigla ;
      new web.getmigrdatos2(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_char11, GXv_char12, GXv_char13, GXv_char14, GXv_char15, GXv_char16, GXv_char17, GXv_char18, GXv_char19, GXv_char20, GXv_char21, GXv_char22, GXv_char23, GXv_char24, GXv_boolean25, GXv_boolean26) ;
      migrlegupd_impl.this.AV25MigrLegArea = GXv_char1[0] ;
      migrlegupd_impl.this.AV36MigrLegLugarDePago = GXv_char2[0] ;
      migrlegupd_impl.this.AV30MigrLegCategoria = GXv_char3[0] ;
      migrlegupd_impl.this.AV28MigrLegBanco = GXv_char4[0] ;
      migrlegupd_impl.this.AV45MigrLegSindicato = GXv_char5[0] ;
      migrlegupd_impl.this.AV41MigrLegObraSocial = GXv_char6[0] ;
      migrlegupd_impl.this.AV43MigrLegPlanMedico = GXv_char7[0] ;
      migrlegupd_impl.this.AV23MigrLegActividad = GXv_char8[0] ;
      migrlegupd_impl.this.AV38MigrLegModalidad = GXv_char9[0] ;
      migrlegupd_impl.this.AV51MigrLegZona = GXv_char10[0] ;
      migrlegupd_impl.this.AV49MigrLegSituacionRevista = GXv_char11[0] ;
      migrlegupd_impl.this.AV34MigrLegConvenio = GXv_char12[0] ;
      migrlegupd_impl.this.AV32MigrLegCondicion = GXv_char13[0] ;
      migrlegupd_impl.this.AV47MigrLegSiniestrado = GXv_char14[0] ;
      migrlegupd_impl.this.AV90MigrLegSexo = GXv_char15[0] ;
      migrlegupd_impl.this.AV195MigrLegModTra = GXv_char16[0] ;
      migrlegupd_impl.this.AV196MigrLegTipoTarifa = GXv_char17[0] ;
      migrlegupd_impl.this.AV94MigrLegClase = GXv_char18[0] ;
      migrlegupd_impl.this.AV105MigrLegEstadoCivil = GXv_char19[0] ;
      migrlegupd_impl.this.AV109MigrLegBanTipCuen = GXv_char20[0] ;
      migrlegupd_impl.this.AV106MigrLegDiscapacidad = GXv_char21[0] ;
      migrlegupd_impl.this.AV107MigrLegFormaPago = GXv_char22[0] ;
      migrlegupd_impl.this.AV100MigrLegSCVO = GXv_char23[0] ;
      migrlegupd_impl.this.AV101MigrTieneConyuge = GXv_char24[0] ;
      migrlegupd_impl.this.AV184MigrEncontroOsoAfip = GXv_boolean25[0] ;
      migrlegupd_impl.this.AV185MigrEncontroOsoSigla = GXv_boolean26[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25MigrLegArea", AV25MigrLegArea);
      httpContext.ajax_rsp_assign_attri("", false, "AV36MigrLegLugarDePago", AV36MigrLegLugarDePago);
      httpContext.ajax_rsp_assign_attri("", false, "AV30MigrLegCategoria", AV30MigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCATEGORIA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30MigrLegCategoria, ""))));
      httpContext.ajax_rsp_assign_attri("", false, "AV28MigrLegBanco", AV28MigrLegBanco);
      httpContext.ajax_rsp_assign_attri("", false, "AV45MigrLegSindicato", AV45MigrLegSindicato);
      httpContext.ajax_rsp_assign_attri("", false, "AV41MigrLegObraSocial", AV41MigrLegObraSocial);
      httpContext.ajax_rsp_assign_attri("", false, "AV43MigrLegPlanMedico", AV43MigrLegPlanMedico);
      httpContext.ajax_rsp_assign_attri("", false, "AV23MigrLegActividad", AV23MigrLegActividad);
      httpContext.ajax_rsp_assign_attri("", false, "AV38MigrLegModalidad", AV38MigrLegModalidad);
      httpContext.ajax_rsp_assign_attri("", false, "AV51MigrLegZona", AV51MigrLegZona);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGZONA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51MigrLegZona, ""))));
      httpContext.ajax_rsp_assign_attri("", false, "AV49MigrLegSituacionRevista", AV49MigrLegSituacionRevista);
      httpContext.ajax_rsp_assign_attri("", false, "AV34MigrLegConvenio", AV34MigrLegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV34MigrLegConvenio, ""))));
      httpContext.ajax_rsp_assign_attri("", false, "AV32MigrLegCondicion", AV32MigrLegCondicion);
      httpContext.ajax_rsp_assign_attri("", false, "AV47MigrLegSiniestrado", AV47MigrLegSiniestrado);
      httpContext.ajax_rsp_assign_attri("", false, "AV90MigrLegSexo", AV90MigrLegSexo);
      httpContext.ajax_rsp_assign_attri("", false, "AV195MigrLegModTra", AV195MigrLegModTra);
      httpContext.ajax_rsp_assign_attri("", false, "AV196MigrLegTipoTarifa", AV196MigrLegTipoTarifa);
      httpContext.ajax_rsp_assign_attri("", false, "AV94MigrLegClase", AV94MigrLegClase);
      httpContext.ajax_rsp_assign_attri("", false, "AV105MigrLegEstadoCivil", AV105MigrLegEstadoCivil);
      httpContext.ajax_rsp_assign_attri("", false, "AV109MigrLegBanTipCuen", AV109MigrLegBanTipCuen);
      httpContext.ajax_rsp_assign_attri("", false, "AV106MigrLegDiscapacidad", AV106MigrLegDiscapacidad);
      httpContext.ajax_rsp_assign_attri("", false, "AV107MigrLegFormaPago", AV107MigrLegFormaPago);
      httpContext.ajax_rsp_assign_attri("", false, "AV100MigrLegSCVO", AV100MigrLegSCVO);
      httpContext.ajax_rsp_assign_attri("", false, "AV101MigrTieneConyuge", AV101MigrTieneConyuge);
      httpContext.ajax_rsp_assign_attri("", false, "AV184MigrEncontroOsoAfip", AV184MigrEncontroOsoAfip);
      httpContext.ajax_rsp_assign_attri("", false, "AV185MigrEncontroOsoSigla", AV185MigrEncontroOsoSigla);
      GXv_char24[0] = AV181start_MigrLegConvenio ;
      new web.getmigrtlegupd_convenio(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24) ;
      migrlegupd_impl.this.AV181start_MigrLegConvenio = GXv_char24[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV181start_MigrLegConvenio", AV181start_MigrLegConvenio);
      AV55WebSession.setValue(httpContext.getMessage( "&SelectedValueMigrLegConvenio", ""), AV181start_MigrLegConvenio);
      new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "setea ", "")+AV181start_MigrLegConvenio+httpContext.getMessage( " en el start", "")) ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext27[0] = AV56WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext27) ;
      AV56WWPContext = GXv_SdtWWPContext27[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28;
      edtMigrLegCondicion_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCondicion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCondicion_Visible), 5, 0), true);
      AV148ComboMigrLegCondicion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV148ComboMigrLegCondicion", AV148ComboMigrLegCondicion);
      edtavCombomigrlegcondicion_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcondicion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcondicion_Visible), 5, 0), true);
      edtMigrLegActividad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegActividad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegActividad_Visible), 5, 0), true);
      AV144ComboMigrLegActividad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV144ComboMigrLegActividad", AV144ComboMigrLegActividad);
      edtavCombomigrlegactividad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegactividad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegactividad_Visible), 5, 0), true);
      edtMigrLegZona_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegZona_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegZona_Visible), 5, 0), true);
      AV130ComboMigrLegZona = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV130ComboMigrLegZona", AV130ComboMigrLegZona);
      edtavCombomigrlegzona_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegzona_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegzona_Visible), 5, 0), true);
      edtMigrLegModalidad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegModalidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegModalidad_Visible), 5, 0), true);
      AV142ComboMigrLegModalidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV142ComboMigrLegModalidad", AV142ComboMigrLegModalidad);
      edtavCombomigrlegmodalidad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegmodalidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegmodalidad_Visible), 5, 0), true);
      edtMigrLegObraSocial_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObraSocial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObraSocial_Visible), 5, 0), true);
      AV132ComboMigrLegObraSocial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV132ComboMigrLegObraSocial", AV132ComboMigrLegObraSocial);
      edtavCombomigrlegobrasocial_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegobrasocial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegobrasocial_Visible), 5, 0), true);
      edtMigrLegBanco_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanco_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanco_Visible), 5, 0), true);
      AV140ComboMigrLegBanco = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV140ComboMigrLegBanco", AV140ComboMigrLegBanco);
      edtavCombomigrlegbanco_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegbanco_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegbanco_Visible), 5, 0), true);
      edtMigrLegCategoria_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCategoria_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCategoria_Visible), 5, 0), true);
      AV127ComboMigrLegCategoria = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV127ComboMigrLegCategoria", AV127ComboMigrLegCategoria);
      edtavCombomigrlegcategoria_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcategoria_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcategoria_Visible), 5, 0), true);
      edtMigrLegConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegConvenio_Visible), 5, 0), true);
      AV136ComboMigrLegConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV136ComboMigrLegConvenio", AV136ComboMigrLegConvenio);
      edtavCombomigrlegconvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegconvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegconvenio_Visible), 5, 0), true);
      edtMigrLegSindicato_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSindicato_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSindicato_Visible), 5, 0), true);
      AV134ComboMigrLegSindicato = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV134ComboMigrLegSindicato", AV134ComboMigrLegSindicato);
      edtavCombomigrlegsindicato_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsindicato_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsindicato_Visible), 5, 0), true);
      edtMigrLegArea_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegArea_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegArea_Visible), 5, 0), true);
      AV13ComboMigrLegArea = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13ComboMigrLegArea", AV13ComboMigrLegArea);
      edtavCombomigrlegarea_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegarea_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegarea_Visible), 5, 0), true);
      edtMigrLegEstadoCivil_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEstadoCivil_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEstadoCivil_Visible), 5, 0), true);
      AV192ComboMigrLegEstadoCivil = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV192ComboMigrLegEstadoCivil", AV192ComboMigrLegEstadoCivil);
      edtavCombomigrlegestadocivil_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegestadocivil_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegestadocivil_Visible), 5, 0), true);
      edtMigrLegSexo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSexo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSexo_Visible), 5, 0), true);
      AV190ComboMigrLegSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV190ComboMigrLegSexo", AV190ComboMigrLegSexo);
      edtavCombomigrlegsexo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsexo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsexo_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGSEXO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGESTADOCIVIL' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGAREA' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGSINDICATO' */
      S142 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGCONVENIO' */
      S152 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGCATEGORIA' */
      S162 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGBANCO' */
      S172 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGOBRASOCIAL' */
      S182 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGMODALIDAD' */
      S192 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGZONA' */
      S202 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGACTIVIDAD' */
      S212 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGCONDICION' */
      S222 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV22IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean30 = AV22IsAuthorized ;
         GXv_boolean26[0] = GXt_boolean30 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD_Insert", GXv_boolean26) ;
         migrlegupd_impl.this.GXt_boolean30 = GXv_boolean26[0] ;
         AV22IsAuthorized = GXt_boolean30 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean30 = AV22IsAuthorized ;
         GXv_boolean26[0] = GXt_boolean30 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD_Update", GXv_boolean26) ;
         migrlegupd_impl.this.GXt_boolean30 = GXv_boolean26[0] ;
         AV22IsAuthorized = GXt_boolean30 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean30 = AV22IsAuthorized ;
         GXv_boolean26[0] = GXt_boolean30 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD_Delete", GXv_boolean26) ;
         migrlegupd_impl.this.GXt_boolean30 = GXv_boolean26[0] ;
         AV22IsAuthorized = GXt_boolean30 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV203Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV54TrnContext.fromxml(AV55WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtMigrLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Visible), 5, 0), true);
      edtMigrLegDiscapacidad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDiscapacidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDiscapacidad_Visible), 5, 0), true);
      edtMigrLegOSAfip_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Visible), 5, 0), true);
      edtMigrLegLugarDePago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegLugarDePago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegLugarDePago_Visible), 5, 0), true);
      edtMigrLegBanSuc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanSuc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanSuc_Visible), 5, 0), true);
      edtMigrLegBanTipCuen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanTipCuen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanTipCuen_Visible), 5, 0), true);
      edtMigrLegCuentaBanc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCuentaBanc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCuentaBanc_Visible), 5, 0), true);
      edtMigrLegFormaPago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFormaPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFormaPago_Visible), 5, 0), true);
      edtMigrLegSituacionRevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSituacionRevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSituacionRevista_Visible), 5, 0), true);
      edtMigrLegSiniestrado_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSiniestrado_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSiniestrado_Visible), 5, 0), true);
      edtMigrLegSCVO_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSCVO_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSCVO_Visible), 5, 0), true);
      edtMigrLegPlanMedico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegPlanMedico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPlanMedico_Visible), 5, 0), true);
      edtMigrTieneConyuge_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrTieneConyuge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrTieneConyuge_Visible), 5, 0), true);
      edtMigrCantidadHijos_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrCantidadHijos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrCantidadHijos_Visible), 5, 0), true);
      /* Object Property */
      if ( true )
      {
         bDynCreated_Wcimportarlegajofamilia = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Wcimportarlegajofamilia_Component), GXutil.lower( "ImportarLegajoFamilia")) != 0 )
      {
         WebComp_Wcimportarlegajofamilia = WebUtils.getWebComponent(getClass(), "web.importarlegajofamilia_impl", remoteHandle, context);
         WebComp_Wcimportarlegajofamilia_Component = "ImportarLegajoFamilia" ;
      }
      if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
      {
         WebComp_Wcimportarlegajofamilia.setjustcreated();
         WebComp_Wcimportarlegajofamilia.componentprepare(new Object[] {"W0334","",Integer.valueOf(AV7CliCod),Short.valueOf(AV18EmpCod),Integer.valueOf(AV40MigrLegNumero)});
         WebComp_Wcimportarlegajofamilia.componentbind(new Object[] {"","",""});
      }
      new web.msgdebug7(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "porque no reciboe nada ", "")+AV107MigrLegFormaPago+httpContext.getMessage( " &MigrLegCategoria ", "")+AV30MigrLegCategoria) ;
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGSEXO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGCLASE' */
      S232 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGMODTRA' */
      S242 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGTIPOTARIFA' */
      S252 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGESTADOCIVIL' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGDISCAPACIDAD' */
      S262 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGFORMAPAGO' */
      S272 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGSCVO' */
      S282 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRTIENECONYUGE' */
      S292 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGBANTIPCUEN' */
      S302 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e13282( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.msgdebug7(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "&Mode ", "")+Gx_mode) ;
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "llama a validarRegistroMigracion", "")) ;
         GXv_objcol_svchar31[0] = AV104dummyErrores ;
         GXv_objcol_svchar32[0] = AV104dummyErrores ;
         new web.validarregistromigracion(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, false, true, (short)(0), GXv_objcol_svchar31, GXv_objcol_svchar32) ;
         AV104dummyErrores = GXv_objcol_svchar31[0] ;
         AV104dummyErrores = GXv_objcol_svchar32[0] ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV104dummyErrores", AV104dummyErrores);
   }

   public void e12282( )
   {
      /* Combo_migrlegconvenio_Onoptionclicked Routine */
      returnInSub = false ;
      AV136ComboMigrLegConvenio = Combo_migrlegconvenio_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV136ComboMigrLegConvenio", AV136ComboMigrLegConvenio);
      AV55WebSession.setValue(httpContext.getMessage( "&SelectedValueMigrLegConvenio", ""), GXutil.trim( AV136ComboMigrLegConvenio));
      new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "setea ", "")+AV136ComboMigrLegConvenio+httpContext.getMessage( " en el xlick", "")) ;
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGCATEGORIA' */
      S162 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV126MigrLegCategoria_Data", AV126MigrLegCategoria_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69warnings", AV69warnings);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68errores", AV68errores);
   }

   public void S222( )
   {
      /* 'LOADCOMBOMIGRLEGCONDICION' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV147MigrLegCondicion_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegCondicion", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV147MigrLegCondicion_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegcondicion_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegcondicion.sendProperty(context, "", false, Combo_migrlegcondicion_Internalname, "SelectedValue_set", Combo_migrlegcondicion_Selectedvalue_set);
      AV148ComboMigrLegCondicion = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV148ComboMigrLegCondicion", AV148ComboMigrLegCondicion);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegcondicion_Enabled = false ;
         ucCombo_migrlegcondicion.sendProperty(context, "", false, Combo_migrlegcondicion_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegcondicion_Enabled));
      }
      lblMigrlegcondicion_righttext_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblMigrlegcondicion_righttext_Internalname, "Caption", lblMigrlegcondicion_righttext_Caption, true);
   }

   public void S212( )
   {
      /* 'LOADCOMBOMIGRLEGACTIVIDAD' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV143MigrLegActividad_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegActividad", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV143MigrLegActividad_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegactividad_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegactividad.sendProperty(context, "", false, Combo_migrlegactividad_Internalname, "SelectedValue_set", Combo_migrlegactividad_Selectedvalue_set);
      AV144ComboMigrLegActividad = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV144ComboMigrLegActividad", AV144ComboMigrLegActividad);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegactividad_Enabled = false ;
         ucCombo_migrlegactividad.sendProperty(context, "", false, Combo_migrlegactividad_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegactividad_Enabled));
      }
      lblMigrlegactividad_righttext_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblMigrlegactividad_righttext_Internalname, "Caption", lblMigrlegactividad_righttext_Caption, true);
   }

   public void S202( )
   {
      /* 'LOADCOMBOMIGRLEGZONA' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV129MigrLegZona_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegZona", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV129MigrLegZona_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegzona_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegzona.sendProperty(context, "", false, Combo_migrlegzona_Internalname, "SelectedValue_set", Combo_migrlegzona_Selectedvalue_set);
      AV130ComboMigrLegZona = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV130ComboMigrLegZona", AV130ComboMigrLegZona);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegzona_Enabled = false ;
         ucCombo_migrlegzona.sendProperty(context, "", false, Combo_migrlegzona_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegzona_Enabled));
      }
      lblMigrlegzona_righttext_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblMigrlegzona_righttext_Internalname, "Caption", lblMigrlegzona_righttext_Caption, true);
   }

   public void S192( )
   {
      /* 'LOADCOMBOMIGRLEGMODALIDAD' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV141MigrLegModalidad_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegModalidad", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV141MigrLegModalidad_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegmodalidad_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegmodalidad.sendProperty(context, "", false, Combo_migrlegmodalidad_Internalname, "SelectedValue_set", Combo_migrlegmodalidad_Selectedvalue_set);
      AV142ComboMigrLegModalidad = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV142ComboMigrLegModalidad", AV142ComboMigrLegModalidad);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegmodalidad_Enabled = false ;
         ucCombo_migrlegmodalidad.sendProperty(context, "", false, Combo_migrlegmodalidad_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegmodalidad_Enabled));
      }
      GXv_boolean26[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean25[0] = AV58existe ;
      GXv_boolean35[0] = AV115esCodigo ;
      GXv_boolean36[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Modalidad", ""), "", AV38MigrLegModalidad, GXv_boolean26, GXv_char24, GXv_boolean25, GXv_boolean35, GXv_boolean36) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean25[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean36[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Modalidad", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegmodalidad_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegmodalidad_righttext_Internalname, "Caption", lblMigrlegmodalidad_righttext_Caption, true);
         lblTextblockmigrlegmodalidad_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegmodalidad_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegmodalidad_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegmodalidad_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegmodalidad_righttext_Internalname, "Caption", lblMigrlegmodalidad_righttext_Caption, true);
         }
         else
         {
            lblMigrlegmodalidad_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegmodalidad_righttext_Internalname, "Caption", lblMigrlegmodalidad_righttext_Caption, true);
         }
      }
   }

   public void S182( )
   {
      /* 'LOADCOMBOMIGRLEGOBRASOCIAL' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV131MigrLegObraSocial_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegObraSocial", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV131MigrLegObraSocial_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegobrasocial_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegobrasocial.sendProperty(context, "", false, Combo_migrlegobrasocial_Internalname, "SelectedValue_set", Combo_migrlegobrasocial_Selectedvalue_set);
      AV132ComboMigrLegObraSocial = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV132ComboMigrLegObraSocial", AV132ComboMigrLegObraSocial);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegobrasocial_Enabled = false ;
         ucCombo_migrlegobrasocial.sendProperty(context, "", false, Combo_migrlegobrasocial_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegobrasocial_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Obra Social", ""), "", AV41MigrLegObraSocial, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         if ( AV57hayLike )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajeseleccionaropcionmigracion(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Obra Social", ""), AV153valorFiltro, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegobrasocial_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegobrasocial_righttext_Internalname, "Caption", lblMigrlegobrasocial_righttext_Caption, true);
            lblTextblockmigrlegobrasocial_Fontbold = (byte)(1) ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegobrasocial_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegobrasocial_Fontbold, 1, 0), true);
         }
         else
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Obra Social", ""), AV153valorFiltro, true, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegobrasocial_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegobrasocial_righttext_Internalname, "Caption", lblMigrlegobrasocial_righttext_Caption, true);
            lblTextblockmigrlegobrasocial_Fontbold = (byte)(1) ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegobrasocial_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegobrasocial_Fontbold, 1, 0), true);
         }
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegobrasocial_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegobrasocial_righttext_Internalname, "Caption", lblMigrlegobrasocial_righttext_Caption, true);
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "&existe ", "")+GXutil.trim( GXutil.booltostr( AV58existe))) ;
            if ( AV58existe )
            {
               AV186OsoDescrip = "" ;
               AV187OsoCod = "" ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "&MigrEncontroOsoAfip ", "")+GXutil.trim( GXutil.booltostr( AV184MigrEncontroOsoAfip))) ;
               if ( AV184MigrEncontroOsoAfip )
               {
                  GXv_char24[0] = AV187OsoCod ;
                  GXv_boolean36[0] = false ;
                  new web.getobrasocialporcodigoafip(remoteHandle, context).execute( AV7CliCod, GXutil.strReplace( GXutil.trim( AV41MigrLegObraSocial), "-", ""), GXv_char24, GXv_boolean36) ;
                  migrlegupd_impl.this.AV187OsoCod = GXv_char24[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "&OsoCod ", "")+AV187OsoCod) ;
               }
               else
               {
                  if ( AV185MigrEncontroOsoSigla )
                  {
                     GXv_char24[0] = AV187OsoCod ;
                     GXv_boolean36[0] = false ;
                     new web.getobrasocialporsigla(remoteHandle, context).execute( AV7CliCod, GXutil.trim( AV41MigrLegObraSocial), GXv_char24, GXv_boolean36) ;
                     migrlegupd_impl.this.AV187OsoCod = GXv_char24[0] ;
                  }
                  else
                  {
                     if ( AV115esCodigo )
                     {
                        AV187OsoCod = AV41MigrLegObraSocial ;
                     }
                  }
               }
               GXv_char24[0] = AV186OsoDescrip ;
               GXv_boolean36[0] = false ;
               new web.getobrasocial(remoteHandle, context).execute( AV7CliCod, AV187OsoCod, GXv_char24, GXv_boolean36) ;
               migrlegupd_impl.this.AV186OsoDescrip = GXv_char24[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "&OsoDescrip ", "")+AV186OsoDescrip) ;
               lblMigrlegobrasocial_righttext_Caption = AV186OsoDescrip ;
               httpContext.ajax_rsp_assign_prop("", false, lblMigrlegobrasocial_righttext_Internalname, "Caption", lblMigrlegobrasocial_righttext_Caption, true);
            }
            else
            {
               lblMigrlegobrasocial_righttext_Caption = "" ;
               httpContext.ajax_rsp_assign_prop("", false, lblMigrlegobrasocial_righttext_Internalname, "Caption", lblMigrlegobrasocial_righttext_Caption, true);
            }
         }
      }
   }

   public void S172( )
   {
      /* 'LOADCOMBOMIGRLEGBANCO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV139MigrLegBanco_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegBanco", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV139MigrLegBanco_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegbanco_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegbanco.sendProperty(context, "", false, Combo_migrlegbanco_Internalname, "SelectedValue_set", Combo_migrlegbanco_Selectedvalue_set);
      AV140ComboMigrLegBanco = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV140ComboMigrLegBanco", AV140ComboMigrLegBanco);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegbanco_Enabled = false ;
         ucCombo_migrlegbanco.sendProperty(context, "", false, Combo_migrlegbanco_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegbanco_Enabled));
      }
      lblMigrlegbanco_righttext_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblMigrlegbanco_righttext_Internalname, "Caption", lblMigrlegbanco_righttext_Caption, true);
   }

   public void S162( )
   {
      /* 'LOADCOMBOMIGRLEGCATEGORIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV203Pgmname, httpContext.getMessage( "LoadComboMigrLegCategoria", "")) ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV126MigrLegCategoria_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegCategoria", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV126MigrLegCategoria_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegcategoria_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegcategoria.sendProperty(context, "", false, Combo_migrlegcategoria_Internalname, "SelectedValue_set", Combo_migrlegcategoria_Selectedvalue_set);
      AV127ComboMigrLegCategoria = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV127ComboMigrLegCategoria", AV127ComboMigrLegCategoria);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegcategoria_Enabled = false ;
         ucCombo_migrlegcategoria.sendProperty(context, "", false, Combo_migrlegcategoria_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegcategoria_Enabled));
      }
      GXv_char24[0] = AV183ConveCodigo ;
      GXv_objcol_svchar32[0] = AV68errores ;
      GXv_objcol_svchar31[0] = AV69warnings ;
      GXv_char23[0] = "" ;
      GXv_boolean36[0] = false ;
      GXv_boolean35[0] = false ;
      GXv_boolean26[0] = false ;
      GXv_char22[0] = "" ;
      new web.traducirmigracioncaracter(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Convenio", ""), AV34MigrLegConvenio, false, "", "", "", "", GXv_char24, GXv_objcol_svchar32, GXv_objcol_svchar31, GXv_char23, GXv_boolean36, GXv_boolean35, GXv_boolean26, GXv_char22) ;
      migrlegupd_impl.this.AV183ConveCodigo = GXv_char24[0] ;
      AV68errores = GXv_objcol_svchar32[0] ;
      AV69warnings = GXv_objcol_svchar31[0] ;
      GXv_char24[0] = AV194ZonCod ;
      GXv_objcol_svchar32[0] = AV68errores ;
      GXv_objcol_svchar31[0] = AV69warnings ;
      GXv_char23[0] = "" ;
      GXv_boolean36[0] = false ;
      GXv_boolean35[0] = false ;
      GXv_boolean26[0] = false ;
      GXv_char22[0] = "" ;
      new web.traducirmigracioncaracter(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Zona", ""), AV51MigrLegZona, false, "", "", "", "", GXv_char24, GXv_objcol_svchar32, GXv_objcol_svchar31, GXv_char23, GXv_boolean36, GXv_boolean35, GXv_boolean26, GXv_char22) ;
      migrlegupd_impl.this.AV194ZonCod = GXv_char24[0] ;
      AV68errores = GXv_objcol_svchar32[0] ;
      AV69warnings = GXv_objcol_svchar31[0] ;
      GXv_char24[0] = AV193auxDependencia ;
      new web.migrarmardependenciacategoria(remoteHandle, context).execute( AV183ConveCodigo, AV194ZonCod, GXv_char24) ;
      migrlegupd_impl.this.AV193auxDependencia = GXv_char24[0] ;
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Categoria", ""), AV193auxDependencia, AV30MigrLegCategoria, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Categoria", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegcategoria_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegcategoria_righttext_Internalname, "Caption", lblMigrlegcategoria_righttext_Caption, true);
         lblTextblockmigrlegcategoria_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegcategoria_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegcategoria_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegcategoria_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegcategoria_righttext_Internalname, "Caption", lblMigrlegcategoria_righttext_Caption, true);
         }
         else
         {
            lblMigrlegcategoria_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegcategoria_righttext_Internalname, "Caption", lblMigrlegcategoria_righttext_Caption, true);
         }
      }
   }

   public void S152( )
   {
      /* 'LOADCOMBOMIGRLEGCONVENIO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV135MigrLegConvenio_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegConvenio", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV135MigrLegConvenio_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegconvenio_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegconvenio.sendProperty(context, "", false, Combo_migrlegconvenio_Internalname, "SelectedValue_set", Combo_migrlegconvenio_Selectedvalue_set);
      AV136ComboMigrLegConvenio = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV136ComboMigrLegConvenio", AV136ComboMigrLegConvenio);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegconvenio_Enabled = false ;
         ucCombo_migrlegconvenio.sendProperty(context, "", false, Combo_migrlegconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegconvenio_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Convenio", ""), "", AV34MigrLegConvenio, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Convenio", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegconvenio_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegconvenio_righttext_Internalname, "Caption", lblMigrlegconvenio_righttext_Caption, true);
         lblTextblockmigrlegconvenio_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegconvenio_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegconvenio_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegconvenio_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegconvenio_righttext_Internalname, "Caption", lblMigrlegconvenio_righttext_Caption, true);
         }
         else
         {
            lblMigrlegconvenio_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegconvenio_righttext_Internalname, "Caption", lblMigrlegconvenio_righttext_Caption, true);
         }
      }
   }

   public void S142( )
   {
      /* 'LOADCOMBOMIGRLEGSINDICATO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV133MigrLegSindicato_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegSindicato", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV133MigrLegSindicato_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegsindicato_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegsindicato.sendProperty(context, "", false, Combo_migrlegsindicato_Internalname, "SelectedValue_set", Combo_migrlegsindicato_Selectedvalue_set);
      AV134ComboMigrLegSindicato = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV134ComboMigrLegSindicato", AV134ComboMigrLegSindicato);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegsindicato_Enabled = false ;
         ucCombo_migrlegsindicato.sendProperty(context, "", false, Combo_migrlegsindicato_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegsindicato_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Sindicato", ""), "", AV45MigrLegSindicato, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Sindicato", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegsindicato_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsindicato_righttext_Internalname, "Caption", lblMigrlegsindicato_righttext_Caption, true);
         lblTextblockmigrlegsindicato_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegsindicato_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegsindicato_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegsindicato_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsindicato_righttext_Internalname, "Caption", lblMigrlegsindicato_righttext_Caption, true);
         }
         else
         {
            lblMigrlegsindicato_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsindicato_righttext_Internalname, "Caption", lblMigrlegsindicato_righttext_Caption, true);
         }
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOMIGRLEGAREA' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV26MigrLegArea_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegArea", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV26MigrLegArea_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegarea_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegarea.sendProperty(context, "", false, Combo_migrlegarea_Internalname, "SelectedValue_set", Combo_migrlegarea_Selectedvalue_set);
      AV13ComboMigrLegArea = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13ComboMigrLegArea", AV13ComboMigrLegArea);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegarea_Enabled = false ;
         ucCombo_migrlegarea.sendProperty(context, "", false, Combo_migrlegarea_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegarea_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Area", ""), "", AV25MigrLegArea, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         if ( AV57hayLike )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajeseleccionaropcionmigracion(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Area", ""), AV153valorFiltro, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegarea_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegarea_righttext_Internalname, "Caption", lblMigrlegarea_righttext_Caption, true);
            lblTextblockmigrlegarea_Fontbold = (byte)(1) ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegarea_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegarea_Fontbold, 1, 0), true);
         }
         else
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Area", ""), AV153valorFiltro, true, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegarea_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegarea_righttext_Internalname, "Caption", lblMigrlegarea_righttext_Caption, true);
            lblTextblockmigrlegarea_Fontbold = (byte)(1) ;
            httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegarea_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegarea_Fontbold, 1, 0), true);
         }
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegarea_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegarea_righttext_Internalname, "Caption", lblMigrlegarea_righttext_Caption, true);
         }
         else
         {
            lblMigrlegarea_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegarea_righttext_Internalname, "Caption", lblMigrlegarea_righttext_Caption, true);
         }
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOMIGRLEGESTADOCIVIL' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV191MigrLegEstadoCivil_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegEstadoCivil", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV191MigrLegEstadoCivil_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegestadocivil_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegestadocivil.sendProperty(context, "", false, Combo_migrlegestadocivil_Internalname, "SelectedValue_set", Combo_migrlegestadocivil_Selectedvalue_set);
      AV192ComboMigrLegEstadoCivil = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV192ComboMigrLegEstadoCivil", AV192ComboMigrLegEstadoCivil);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegestadocivil_Enabled = false ;
         ucCombo_migrlegestadocivil.sendProperty(context, "", false, Combo_migrlegestadocivil_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegestadocivil_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Estado Civil", ""), "", AV105MigrLegEstadoCivil, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Estado Civil", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegestadocivil_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegestadocivil_righttext_Internalname, "Caption", lblMigrlegestadocivil_righttext_Caption, true);
         lblTextblockmigrlegestadocivil_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegestadocivil_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegestadocivil_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegestadocivil_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegestadocivil_righttext_Internalname, "Caption", lblMigrlegestadocivil_righttext_Caption, true);
         }
         else
         {
            lblMigrlegestadocivil_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegestadocivil_righttext_Internalname, "Caption", lblMigrlegestadocivil_righttext_Caption, true);
         }
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOMIGRLEGSEXO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = AV189MigrLegSexo_Data ;
      GXv_char24[0] = AV15ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item34[0] = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      new web.migrlegupdloaddvcombo(remoteHandle, context).execute( "MigrLegSexo", Gx_mode, AV7CliCod, AV18EmpCod, AV40MigrLegNumero, GXv_char24, GXv_objcol_SdtDVB_SDTComboData_Item34) ;
      migrlegupd_impl.this.AV15ComboSelectedValue = GXv_char24[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = GXv_objcol_SdtDVB_SDTComboData_Item34[0] ;
      AV189MigrLegSexo_Data = GXt_objcol_SdtDVB_SDTComboData_Item33 ;
      Combo_migrlegsexo_Selectedvalue_set = AV15ComboSelectedValue ;
      ucCombo_migrlegsexo.sendProperty(context, "", false, Combo_migrlegsexo_Internalname, "SelectedValue_set", Combo_migrlegsexo_Selectedvalue_set);
      AV190ComboMigrLegSexo = AV15ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV190ComboMigrLegSexo", AV190ComboMigrLegSexo);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegsexo_Enabled = false ;
         ucCombo_migrlegsexo.sendProperty(context, "", false, Combo_migrlegsexo_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegsexo_Enabled));
      }
      GXv_boolean36[0] = AV57hayLike ;
      GXv_char24[0] = AV153valorFiltro ;
      GXv_boolean35[0] = AV58existe ;
      GXv_boolean26[0] = AV115esCodigo ;
      GXv_boolean25[0] = AV128defaultEs ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV40MigrLegNumero, httpContext.getMessage( "Sexo", ""), "", AV90MigrLegSexo, GXv_boolean36, GXv_char24, GXv_boolean35, GXv_boolean26, GXv_boolean25) ;
      migrlegupd_impl.this.AV57hayLike = GXv_boolean36[0] ;
      migrlegupd_impl.this.AV153valorFiltro = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean35[0] ;
      migrlegupd_impl.this.AV115esCodigo = GXv_boolean26[0] ;
      migrlegupd_impl.this.AV128defaultEs = GXv_boolean25[0] ;
      if ( ! AV58existe && ! (GXutil.strcmp("", AV153valorFiltro)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Sexo", ""), AV153valorFiltro, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegsexo_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsexo_righttext_Internalname, "Caption", lblMigrlegsexo_righttext_Caption, true);
         lblTextblockmigrlegsexo_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegsexo_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegsexo_Fontbold, 1, 0), true);
      }
      else
      {
         if ( AV128defaultEs )
         {
            GXt_char37 = "" ;
            GXv_char24[0] = GXt_char37 ;
            new web.migrmsjgenericodef(remoteHandle, context).execute( AV7CliCod, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            lblMigrlegsexo_righttext_Caption = GXt_char37 ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsexo_righttext_Internalname, "Caption", lblMigrlegsexo_righttext_Caption, true);
         }
         else
         {
            lblMigrlegsexo_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop("", false, lblMigrlegsexo_righttext_Internalname, "Caption", lblMigrlegsexo_righttext_Caption, true);
         }
      }
   }

   public void S312( )
   {
      /* 'LOADCOMBOMIGRLEGPLANMEDICO' Routine */
      returnInSub = false ;
   }

   public void S322( )
   {
      /* 'LOADCOMBOMIGRLEGSINIESTRADO' Routine */
      returnInSub = false ;
   }

   public void S332( )
   {
      /* 'LOADCOMBOMIGRLEGSITUACIONREVISTA' Routine */
      returnInSub = false ;
   }

   public void S342( )
   {
      /* 'LOADCOMBOMIGRLEGLUGARDEPAGO' Routine */
      returnInSub = false ;
   }

   public void S232( )
   {
      /* 'LOADCOMBOMIGRLEGCLASE' Routine */
      returnInSub = false ;
      GXv_int38[0] = AV7CliCod ;
      GXv_int39[0] = AV93LegClase ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = AV75claseError ;
      GXv_boolean36[0] = AV58existe ;
      new web.traducirclaselegajo(remoteHandle, context).execute( GXv_int38, AV94MigrLegClase, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV7CliCod = GXv_int38[0] ;
      migrlegupd_impl.this.AV93LegClase = GXv_int39[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV75claseError = GXv_char24[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      if ( (GXutil.strcmp("", AV94MigrLegClase)==0) )
      {
         cmbMigrLegClase.addItem("", httpContext.getMessage( "Seleccione Clase", ""), (short)(0));
      }
      AV205GXV2 = 1 ;
      AV204GXV1 = web.gxdomainclaseleg.getValues() ;
      while ( AV205GXV2 <= AV204GXV1.size() )
      {
         AV92ClaseLeg = ((Number) AV204GXV1.elementAt(-1+AV205GXV2)).byteValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92ClaseLeg", GXutil.str( AV92ClaseLeg, 1, 0));
         cmbMigrLegClase.addItem(GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV92ClaseLeg), "")), GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV92ClaseLeg), "")), (short)(0));
         AV205GXV2 = (int)(AV205GXV2+1) ;
      }
      if ( ! AV58existe )
      {
         cmbMigrLegClase.addItem(AV94MigrLegClase, new web.mensajemigrselvalida(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
      }
      if ( ! (GXutil.strcmp("", AV75claseError)==0) && ! (GXutil.strcmp("", AV94MigrLegClase)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Clase", ""), AV94MigrLegClase, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegclase_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegclase_righttext_Internalname, "Caption", lblMigrlegclase_righttext_Caption, true);
         lblTextblockmigrlegclase_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegclase_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegclase_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegclase_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegclase_righttext_Internalname, "Caption", lblMigrlegclase_righttext_Caption, true);
      }
   }

   public void S242( )
   {
      /* 'LOADCOMBOMIGRLEGMODTRA' Routine */
      returnInSub = false ;
      GXv_int38[0] = AV7CliCod ;
      GXv_char24[0] = AV197LegModTra ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char23[0] = AV198modTraError ;
      GXv_boolean36[0] = AV58existe ;
      new web.traducirmodotrabajo(remoteHandle, context).execute( GXv_int38, AV195MigrLegModTra, GXv_char24, GXv_objcol_svchar32, GXv_char23, GXv_boolean36) ;
      migrlegupd_impl.this.AV7CliCod = GXv_int38[0] ;
      migrlegupd_impl.this.AV197LegModTra = GXv_char24[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV198modTraError = GXv_char23[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      if ( (GXutil.strcmp("", AV195MigrLegModTra)==0) )
      {
         cmbMigrLegModTra.addItem("", httpContext.getMessage( "Seleccione relación laboral", ""), (short)(0));
      }
      AV207GXV4 = 1 ;
      AV206GXV3 = web.gxdomainmodo_trabajo.getValues() ;
      while ( AV207GXV4 <= AV206GXV3.size() )
      {
         AV199modo_trabajo = (String)AV206GXV3.elementAt(-1+AV207GXV4) ;
         cmbMigrLegModTra.addItem(GXutil.trim( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV199modo_trabajo), "")), GXutil.trim( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV199modo_trabajo), "")), (short)(0));
         AV207GXV4 = (int)(AV207GXV4+1) ;
      }
      if ( ! AV58existe )
      {
         cmbMigrLegModTra.addItem(AV195MigrLegModTra, new web.mensajemigrselvalida(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
      }
      if ( ! (GXutil.strcmp("", AV198modTraError)==0) && ! (GXutil.strcmp("", AV195MigrLegModTra)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Relación laboral", ""), AV195MigrLegModTra, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegmodtra_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegmodtra_righttext_Internalname, "Caption", lblMigrlegmodtra_righttext_Caption, true);
         lblTextblockmigrlegmodtra_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegmodtra_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegmodtra_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegmodtra_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegmodtra_righttext_Internalname, "Caption", lblMigrlegmodtra_righttext_Caption, true);
      }
   }

   public void S252( )
   {
      /* 'LOADCOMBOMIGRLEGTIPOTARIFA' Routine */
      returnInSub = false ;
      GXv_int38[0] = AV7CliCod ;
      GXv_char24[0] = AV200LegTipoTarifa ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char23[0] = AV201tipoTarifaError ;
      GXv_boolean36[0] = AV58existe ;
      new web.traducirtipotarifa(remoteHandle, context).execute( GXv_int38, AV196MigrLegTipoTarifa, GXv_char24, GXv_objcol_svchar32, GXv_char23, GXv_boolean36) ;
      migrlegupd_impl.this.AV7CliCod = GXv_int38[0] ;
      migrlegupd_impl.this.AV200LegTipoTarifa = GXv_char24[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV201tipoTarifaError = GXv_char23[0] ;
      migrlegupd_impl.this.AV58existe = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      if ( (GXutil.strcmp("", AV196MigrLegTipoTarifa)==0) )
      {
         cmbMigrLegTipoTarifa.addItem("", httpContext.getMessage( "Seleccione tipo de tarifa", ""), (short)(0));
      }
      AV209GXV6 = 1 ;
      AV208GXV5 = web.gxdomaintipo_tarifa.getValues() ;
      while ( AV209GXV6 <= AV208GXV5.size() )
      {
         AV202tipo_tarifa = (String)AV208GXV5.elementAt(-1+AV209GXV6) ;
         cmbMigrLegTipoTarifa.addItem(GXutil.trim( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV202tipo_tarifa), "")), GXutil.trim( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV202tipo_tarifa), "")), (short)(0));
         AV209GXV6 = (int)(AV209GXV6+1) ;
      }
      if ( ! AV58existe )
      {
         cmbMigrLegTipoTarifa.addItem(AV196MigrLegTipoTarifa, new web.mensajemigrselvalida(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
      }
      if ( ! (GXutil.strcmp("", AV201tipoTarifaError)==0) && ! (GXutil.strcmp("", AV196MigrLegTipoTarifa)==0) )
      {
         GXt_char37 = "" ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Tiop de tarifa", ""), AV196MigrLegTipoTarifa, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         lblMigrlegtipotarifa_righttext_Caption = GXt_char37 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegtipotarifa_righttext_Internalname, "Caption", lblMigrlegtipotarifa_righttext_Caption, true);
         lblTextblockmigrlegtipotarifa_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegtipotarifa_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegtipotarifa_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegtipotarifa_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegtipotarifa_righttext_Internalname, "Caption", lblMigrlegtipotarifa_righttext_Caption, true);
      }
   }

   public void S302( )
   {
      /* 'LOADCOMBOMIGRLEGBANTIPCUEN' Routine */
      returnInSub = false ;
   }

   public void S262( )
   {
      /* 'LOADCOMBOMIGRLEGDISCAPACIDAD' Routine */
      returnInSub = false ;
   }

   public void S272( )
   {
      /* 'LOADCOMBOMIGRLEGFORMAPAGO' Routine */
      returnInSub = false ;
   }

   public void S282( )
   {
      /* 'LOADCOMBOMIGRLEGSCVO' Routine */
      returnInSub = false ;
   }

   public void S292( )
   {
      /* 'LOADCOMBOMIGRTIENECONYUGE' Routine */
      returnInSub = false ;
   }

   public void zm2875( int GX_JID )
   {
      if ( ( GX_JID == 93 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z595MigrLegSexo = T00283_A595MigrLegSexo[0] ;
            Z596MigrLegEstadoCivil = T00283_A596MigrLegEstadoCivil[0] ;
            Z605MigrLegArea = T00283_A605MigrLegArea[0] ;
            Z613MigrLegSindicato = T00283_A613MigrLegSindicato[0] ;
            Z627MigrLegConvenio = T00283_A627MigrLegConvenio[0] ;
            Z604MigrLegCategoria = T00283_A604MigrLegCategoria[0] ;
            Z610MigrLegBanco = T00283_A610MigrLegBanco[0] ;
            Z614MigrLegObraSocial = T00283_A614MigrLegObraSocial[0] ;
            Z617MigrLegModalidad = T00283_A617MigrLegModalidad[0] ;
            Z620MigrLegZona = T00283_A620MigrLegZona[0] ;
            Z616MigrLegActividad = T00283_A616MigrLegActividad[0] ;
            Z624MigrLegCondicion = T00283_A624MigrLegCondicion[0] ;
            Z592MigrLegApellido = T00283_A592MigrLegApellido[0] ;
            Z593MigrLegNombre = T00283_A593MigrLegNombre[0] ;
            Z594MigrLegFecNac = T00283_A594MigrLegFecNac[0] ;
            Z597MigrLegCUIL = T00283_A597MigrLegCUIL[0] ;
            Z598MigrLegDiscapacidad = T00283_A598MigrLegDiscapacidad[0] ;
            Z599MigrLegDomici = T00283_A599MigrLegDomici[0] ;
            Z600MigrLegEmail = T00283_A600MigrLegEmail[0] ;
            Z601MigrLegCodPos = T00283_A601MigrLegCodPos[0] ;
            Z602MigrLegTelefono = T00283_A602MigrLegTelefono[0] ;
            Z603MigrLegFecIngreso = T00283_A603MigrLegFecIngreso[0] ;
            Z606MigrLegLugarDePago = T00283_A606MigrLegLugarDePago[0] ;
            Z2415MigrLegModTra = T00283_A2415MigrLegModTra[0] ;
            Z607MigrLegClase = T00283_A607MigrLegClase[0] ;
            Z608MigrLegBasico = T00283_A608MigrLegBasico[0] ;
            Z609MigrLegFormaPago = T00283_A609MigrLegFormaPago[0] ;
            Z611MigrLegBanSuc = T00283_A611MigrLegBanSuc[0] ;
            Z612MigrLegBanTipCuen = T00283_A612MigrLegBanTipCuen[0] ;
            Z634MigrLegOSAfip = T00283_A634MigrLegOSAfip[0] ;
            Z615MigrLegPlanMedico = T00283_A615MigrLegPlanMedico[0] ;
            Z618MigrLegFecUltMod = T00283_A618MigrLegFecUltMod[0] ;
            Z619MigrLegCuentaBanc = T00283_A619MigrLegCuentaBanc[0] ;
            Z621MigrLegCBU = T00283_A621MigrLegCBU[0] ;
            Z622MigrLegSCVO = T00283_A622MigrLegSCVO[0] ;
            Z623MigrLegSituacionRevista = T00283_A623MigrLegSituacionRevista[0] ;
            Z2239MigrLegActLabClas = T00283_A2239MigrLegActLabClas[0] ;
            Z2240MigrLegPueAfip = T00283_A2240MigrLegPueAfip[0] ;
            Z625MigrLegSiniestrado = T00283_A625MigrLegSiniestrado[0] ;
            Z626MigrLegId = T00283_A626MigrLegId[0] ;
            Z631MigrTieneConyuge = T00283_A631MigrTieneConyuge[0] ;
            Z632MigrCantidadHijos = T00283_A632MigrCantidadHijos[0] ;
            Z635MigrEncontroOsoSigla = T00283_A635MigrEncontroOsoSigla[0] ;
            Z689MigrLegAreaDef = T00283_A689MigrLegAreaDef[0] ;
            Z690MigrLegEstadoCivilDef = T00283_A690MigrLegEstadoCivilDef[0] ;
            Z691MigrLegClaseDef = T00283_A691MigrLegClaseDef[0] ;
            Z692MigrLegFormaPagoDef = T00283_A692MigrLegFormaPagoDef[0] ;
            Z693MigrLegTipoCuentaDef = T00283_A693MigrLegTipoCuentaDef[0] ;
            Z694MigrLegActividadDef = T00283_A694MigrLegActividadDef[0] ;
            Z695MigrLegModalidadDef = T00283_A695MigrLegModalidadDef[0] ;
            Z696MigrLegZonaDef = T00283_A696MigrLegZonaDef[0] ;
            Z697MigrLegSCVODef = T00283_A697MigrLegSCVODef[0] ;
            Z698MigrLegSituacionDef = T00283_A698MigrLegSituacionDef[0] ;
            Z699MigrLegCondicionDef = T00283_A699MigrLegCondicionDef[0] ;
            Z700MigrLegSiniestradoDef = T00283_A700MigrLegSiniestradoDef[0] ;
            Z2216MigrPuesto = T00283_A2216MigrPuesto[0] ;
            Z2205MigrLegFecEgreso = T00283_A2205MigrLegFecEgreso[0] ;
            Z2275MigrLegHorSem = T00283_A2275MigrLegHorSem[0] ;
            Z2427MigrLegTipoTarifa = T00283_A2427MigrLegTipoTarifa[0] ;
         }
         else
         {
            Z595MigrLegSexo = A595MigrLegSexo ;
            Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
            Z605MigrLegArea = A605MigrLegArea ;
            Z613MigrLegSindicato = A613MigrLegSindicato ;
            Z627MigrLegConvenio = A627MigrLegConvenio ;
            Z604MigrLegCategoria = A604MigrLegCategoria ;
            Z610MigrLegBanco = A610MigrLegBanco ;
            Z614MigrLegObraSocial = A614MigrLegObraSocial ;
            Z617MigrLegModalidad = A617MigrLegModalidad ;
            Z620MigrLegZona = A620MigrLegZona ;
            Z616MigrLegActividad = A616MigrLegActividad ;
            Z624MigrLegCondicion = A624MigrLegCondicion ;
            Z592MigrLegApellido = A592MigrLegApellido ;
            Z593MigrLegNombre = A593MigrLegNombre ;
            Z594MigrLegFecNac = A594MigrLegFecNac ;
            Z597MigrLegCUIL = A597MigrLegCUIL ;
            Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
            Z599MigrLegDomici = A599MigrLegDomici ;
            Z600MigrLegEmail = A600MigrLegEmail ;
            Z601MigrLegCodPos = A601MigrLegCodPos ;
            Z602MigrLegTelefono = A602MigrLegTelefono ;
            Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
            Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
            Z2415MigrLegModTra = A2415MigrLegModTra ;
            Z607MigrLegClase = A607MigrLegClase ;
            Z608MigrLegBasico = A608MigrLegBasico ;
            Z609MigrLegFormaPago = A609MigrLegFormaPago ;
            Z611MigrLegBanSuc = A611MigrLegBanSuc ;
            Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
            Z634MigrLegOSAfip = A634MigrLegOSAfip ;
            Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
            Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
            Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
            Z621MigrLegCBU = A621MigrLegCBU ;
            Z622MigrLegSCVO = A622MigrLegSCVO ;
            Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
            Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
            Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
            Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
            Z626MigrLegId = A626MigrLegId ;
            Z631MigrTieneConyuge = A631MigrTieneConyuge ;
            Z632MigrCantidadHijos = A632MigrCantidadHijos ;
            Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
            Z689MigrLegAreaDef = A689MigrLegAreaDef ;
            Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
            Z691MigrLegClaseDef = A691MigrLegClaseDef ;
            Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
            Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
            Z694MigrLegActividadDef = A694MigrLegActividadDef ;
            Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
            Z696MigrLegZonaDef = A696MigrLegZonaDef ;
            Z697MigrLegSCVODef = A697MigrLegSCVODef ;
            Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
            Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
            Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
            Z2216MigrPuesto = A2216MigrPuesto ;
            Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
            Z2275MigrLegHorSem = A2275MigrLegHorSem ;
            Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         }
      }
      if ( GX_JID == -93 )
      {
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z595MigrLegSexo = A595MigrLegSexo ;
         Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
         Z605MigrLegArea = A605MigrLegArea ;
         Z613MigrLegSindicato = A613MigrLegSindicato ;
         Z627MigrLegConvenio = A627MigrLegConvenio ;
         Z604MigrLegCategoria = A604MigrLegCategoria ;
         Z610MigrLegBanco = A610MigrLegBanco ;
         Z614MigrLegObraSocial = A614MigrLegObraSocial ;
         Z617MigrLegModalidad = A617MigrLegModalidad ;
         Z620MigrLegZona = A620MigrLegZona ;
         Z616MigrLegActividad = A616MigrLegActividad ;
         Z624MigrLegCondicion = A624MigrLegCondicion ;
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z594MigrLegFecNac = A594MigrLegFecNac ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
         Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
         Z599MigrLegDomici = A599MigrLegDomici ;
         Z600MigrLegEmail = A600MigrLegEmail ;
         Z601MigrLegCodPos = A601MigrLegCodPos ;
         Z602MigrLegTelefono = A602MigrLegTelefono ;
         Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
         Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
         Z2415MigrLegModTra = A2415MigrLegModTra ;
         Z607MigrLegClase = A607MigrLegClase ;
         Z608MigrLegBasico = A608MigrLegBasico ;
         Z609MigrLegFormaPago = A609MigrLegFormaPago ;
         Z611MigrLegBanSuc = A611MigrLegBanSuc ;
         Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
         Z634MigrLegOSAfip = A634MigrLegOSAfip ;
         Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
         Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
         Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
         Z621MigrLegCBU = A621MigrLegCBU ;
         Z622MigrLegSCVO = A622MigrLegSCVO ;
         Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
         Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
         Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
         Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
         Z626MigrLegId = A626MigrLegId ;
         Z628MigrLegObs = A628MigrLegObs ;
         Z629MigrLegErrores = A629MigrLegErrores ;
         Z633MigrLegWarnings = A633MigrLegWarnings ;
         Z631MigrTieneConyuge = A631MigrTieneConyuge ;
         Z632MigrCantidadHijos = A632MigrCantidadHijos ;
         Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         Z689MigrLegAreaDef = A689MigrLegAreaDef ;
         Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
         Z691MigrLegClaseDef = A691MigrLegClaseDef ;
         Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
         Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
         Z694MigrLegActividadDef = A694MigrLegActividadDef ;
         Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
         Z696MigrLegZonaDef = A696MigrLegZonaDef ;
         Z697MigrLegSCVODef = A697MigrLegSCVODef ;
         Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
         Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
         Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
         Z2216MigrPuesto = A2216MigrPuesto ;
         Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
         Z2206MigrOtrosDatos = A2206MigrOtrosDatos ;
         Z2275MigrLegHorSem = A2275MigrLegHorSem ;
         Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
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
            GXt_int40 = A3CliCod ;
            GXv_int38[0] = GXt_int40 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int38) ;
            migrlegupd_impl.this.GXt_int40 = GXv_int38[0] ;
            A3CliCod = GXt_int40 ;
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
      if ( ! (0==AV18EmpCod) )
      {
         A1EmpCod = AV18EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int41 = A1EmpCod ;
            GXv_int42[0] = GXt_int41 ;
            new web.getempcod(remoteHandle, context).execute( GXv_int42) ;
            migrlegupd_impl.this.GXt_int41 = GXv_int42[0] ;
            A1EmpCod = GXt_int41 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         }
      }
      if ( ! (0==AV18EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV18EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         A87MigrLegNumero = AV40MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      A595MigrLegSexo = AV190ComboMigrLegSexo ;
      httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
      A596MigrLegEstadoCivil = AV192ComboMigrLegEstadoCivil ;
      httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
      A605MigrLegArea = AV13ComboMigrLegArea ;
      httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
      A613MigrLegSindicato = AV134ComboMigrLegSindicato ;
      httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
      A627MigrLegConvenio = AV136ComboMigrLegConvenio ;
      httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
      A604MigrLegCategoria = AV127ComboMigrLegCategoria ;
      httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
      A610MigrLegBanco = AV140ComboMigrLegBanco ;
      httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
      A614MigrLegObraSocial = AV132ComboMigrLegObraSocial ;
      httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
      A617MigrLegModalidad = AV142ComboMigrLegModalidad ;
      httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
      A620MigrLegZona = AV130ComboMigrLegZona ;
      httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
      A616MigrLegActividad = AV144ComboMigrLegActividad ;
      httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
      A624MigrLegCondicion = AV148ComboMigrLegCondicion ;
      httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
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
         AV203Pgmname = "MigrLegUPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV203Pgmname", AV203Pgmname);
         AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
         GXt_char37 = AV178modTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV178modTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
         GXt_char37 = AV175texto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV175texto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
         GXt_char37 = AV177actTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV177actTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
         GXt_char37 = AV180condTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV180condTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
      }
   }

   public void load2875( )
   {
      /* Using cursor T00285 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A595MigrLegSexo = T00285_A595MigrLegSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         A596MigrLegEstadoCivil = T00285_A596MigrLegEstadoCivil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         A605MigrLegArea = T00285_A605MigrLegArea[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
         A613MigrLegSindicato = T00285_A613MigrLegSindicato[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
         A627MigrLegConvenio = T00285_A627MigrLegConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A604MigrLegCategoria = T00285_A604MigrLegCategoria[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
         A610MigrLegBanco = T00285_A610MigrLegBanco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
         A614MigrLegObraSocial = T00285_A614MigrLegObraSocial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
         A617MigrLegModalidad = T00285_A617MigrLegModalidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A620MigrLegZona = T00285_A620MigrLegZona[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         A616MigrLegActividad = T00285_A616MigrLegActividad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         A624MigrLegCondicion = T00285_A624MigrLegCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         A592MigrLegApellido = T00285_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00285_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A594MigrLegFecNac = T00285_A594MigrLegFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         A597MigrLegCUIL = T00285_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A598MigrLegDiscapacidad = T00285_A598MigrLegDiscapacidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         A599MigrLegDomici = T00285_A599MigrLegDomici[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
         A600MigrLegEmail = T00285_A600MigrLegEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
         A601MigrLegCodPos = T00285_A601MigrLegCodPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
         A602MigrLegTelefono = T00285_A602MigrLegTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
         A603MigrLegFecIngreso = T00285_A603MigrLegFecIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         A606MigrLegLugarDePago = T00285_A606MigrLegLugarDePago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
         A2415MigrLegModTra = T00285_A2415MigrLegModTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
         A607MigrLegClase = T00285_A607MigrLegClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
         A608MigrLegBasico = T00285_A608MigrLegBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
         A609MigrLegFormaPago = T00285_A609MigrLegFormaPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         A611MigrLegBanSuc = T00285_A611MigrLegBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
         A612MigrLegBanTipCuen = T00285_A612MigrLegBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         A634MigrLegOSAfip = T00285_A634MigrLegOSAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         A615MigrLegPlanMedico = T00285_A615MigrLegPlanMedico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
         A618MigrLegFecUltMod = T00285_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = T00285_A619MigrLegCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
         A621MigrLegCBU = T00285_A621MigrLegCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
         A622MigrLegSCVO = T00285_A622MigrLegSCVO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
         A623MigrLegSituacionRevista = T00285_A623MigrLegSituacionRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A2239MigrLegActLabClas = T00285_A2239MigrLegActLabClas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
         A2240MigrLegPueAfip = T00285_A2240MigrLegPueAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
         A625MigrLegSiniestrado = T00285_A625MigrLegSiniestrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A626MigrLegId = T00285_A626MigrLegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         A628MigrLegObs = T00285_A628MigrLegObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
         A629MigrLegErrores = T00285_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = T00285_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = T00285_A631MigrTieneConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         A632MigrCantidadHijos = T00285_A632MigrCantidadHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
         A635MigrEncontroOsoSigla = T00285_A635MigrEncontroOsoSigla[0] ;
         A689MigrLegAreaDef = T00285_A689MigrLegAreaDef[0] ;
         A690MigrLegEstadoCivilDef = T00285_A690MigrLegEstadoCivilDef[0] ;
         A691MigrLegClaseDef = T00285_A691MigrLegClaseDef[0] ;
         A692MigrLegFormaPagoDef = T00285_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = T00285_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = T00285_A694MigrLegActividadDef[0] ;
         A695MigrLegModalidadDef = T00285_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = T00285_A696MigrLegZonaDef[0] ;
         A697MigrLegSCVODef = T00285_A697MigrLegSCVODef[0] ;
         A698MigrLegSituacionDef = T00285_A698MigrLegSituacionDef[0] ;
         A699MigrLegCondicionDef = T00285_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = T00285_A700MigrLegSiniestradoDef[0] ;
         A2216MigrPuesto = T00285_A2216MigrPuesto[0] ;
         A2205MigrLegFecEgreso = T00285_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = T00285_A2206MigrOtrosDatos[0] ;
         A2275MigrLegHorSem = T00285_A2275MigrLegHorSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
         A2427MigrLegTipoTarifa = T00285_A2427MigrLegTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
         zm2875( -93) ;
      }
      pr_default.close(3);
      onLoadActions2875( ) ;
   }

   public void onLoadActions2875( )
   {
      AV203Pgmname = "MigrLegUPD" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV203Pgmname", AV203Pgmname);
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
      {
         edtMigrLegOSAfip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegOSAfip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      GXt_char37 = AV177actTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV177actTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
      GXt_char37 = AV178modTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV178modTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
      GXt_char37 = AV175texto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV175texto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
      GXt_char37 = AV179sitRevTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV179sitRevTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
      GXt_char37 = AV180condTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV180condTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
      GXt_char37 = AV176sinesTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV176sinesTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
   }

   public void checkExtendedTable2875( )
   {
      nIsDirty_75 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV203Pgmname = "MigrLegUPD" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV203Pgmname", AV203Pgmname);
      /* Using cursor T00284 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      GXv_int38[0] = AV65LegNumeroPorId ;
      GXv_char24[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int38, GXv_char24) ;
      migrlegupd_impl.this.AV65LegNumeroPorId = GXv_int38[0] ;
      migrlegupd_impl.this.AV62LegNomApe = GXv_char24[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      GXv_int38[0] = AV66LegNumeroPorCUIL ;
      GXv_char24[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int38, GXv_char24) ;
      migrlegupd_impl.this.AV66LegNumeroPorCUIL = GXv_int38[0] ;
      migrlegupd_impl.this.AV63LegIdNomApe = GXv_char24[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      if ( (GXutil.strcmp("", A592MigrLegApellido)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Apellido", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGAPELLIDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegApellido_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A593MigrLegNombre)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombres", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGNOMBRE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A594MigrLegFecNac)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Nacimiento", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFECNAC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecNac_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A595MigrLegSexo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Sexo", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGSEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSexo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A596MigrLegEstadoCivil)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Estado Civil", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGESTADOCIVIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegEstadoCivil_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A597MigrLegCUIL)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "CUIL", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCUIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCUIL_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A603MigrLegFecIngreso)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Ingreso", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFECINGRESO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecIngreso_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      if ( (GXutil.strcmp("", A2415MigrLegModTra)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Relación laboral", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGMODTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegModTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A607MigrLegClase)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCLASE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegClase.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A609MigrLegFormaPago)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Forma de Pago", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFORMAPAGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFormaPago_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A614MigrLegObraSocial)==0) && ( ( GXutil.strcmp(A624MigrLegCondicion, "02") != 0 ) && ( GXutil.strcmp(GXutil.upper( A624MigrLegCondicion), httpContext.getMessage( "JUBILADO", "")) != 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGOBRASOCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegObraSocial_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
      {
         edtMigrLegOSAfip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegOSAfip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      GXt_char37 = AV177actTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV177actTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
      if ( (GXutil.strcmp("", A616MigrLegActividad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGACTIVIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegActividad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV178modTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV178modTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
      if ( (GXutil.strcmp("", A617MigrLegModalidad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Modalidad", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGMODALIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegModalidad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV175texto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV175texto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
      if ( (GXutil.strcmp("", A620MigrLegZona)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGZONA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegZona_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV179sitRevTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV179sitRevTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
      GXt_char37 = AV180condTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV180condTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
      if ( (GXutil.strcmp("", A624MigrLegCondicion)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Condición", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCondicion_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV176sinesTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV176sinesTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
      if ( (GXutil.strcmp("", A626MigrLegId)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "ID/Código", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A2427MigrLegTipoTarifa)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGTIPOTARIFA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegTipoTarifa.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2875( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_94( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T00286 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
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

   public void getKey2875( )
   {
      /* Using cursor T00287 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound75 = (short)(1) ;
      }
      else
      {
         RcdFound75 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00283 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2875( 93) ;
         RcdFound75 = (short)(1) ;
         A87MigrLegNumero = T00283_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         A595MigrLegSexo = T00283_A595MigrLegSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         A596MigrLegEstadoCivil = T00283_A596MigrLegEstadoCivil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         A605MigrLegArea = T00283_A605MigrLegArea[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
         A613MigrLegSindicato = T00283_A613MigrLegSindicato[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
         A627MigrLegConvenio = T00283_A627MigrLegConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A604MigrLegCategoria = T00283_A604MigrLegCategoria[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
         A610MigrLegBanco = T00283_A610MigrLegBanco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
         A614MigrLegObraSocial = T00283_A614MigrLegObraSocial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
         A617MigrLegModalidad = T00283_A617MigrLegModalidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A620MigrLegZona = T00283_A620MigrLegZona[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         A616MigrLegActividad = T00283_A616MigrLegActividad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         A624MigrLegCondicion = T00283_A624MigrLegCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         A592MigrLegApellido = T00283_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00283_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A594MigrLegFecNac = T00283_A594MigrLegFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         A597MigrLegCUIL = T00283_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A598MigrLegDiscapacidad = T00283_A598MigrLegDiscapacidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         A599MigrLegDomici = T00283_A599MigrLegDomici[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
         A600MigrLegEmail = T00283_A600MigrLegEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
         A601MigrLegCodPos = T00283_A601MigrLegCodPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
         A602MigrLegTelefono = T00283_A602MigrLegTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
         A603MigrLegFecIngreso = T00283_A603MigrLegFecIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         A606MigrLegLugarDePago = T00283_A606MigrLegLugarDePago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
         A2415MigrLegModTra = T00283_A2415MigrLegModTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
         A607MigrLegClase = T00283_A607MigrLegClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
         A608MigrLegBasico = T00283_A608MigrLegBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
         A609MigrLegFormaPago = T00283_A609MigrLegFormaPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         A611MigrLegBanSuc = T00283_A611MigrLegBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
         A612MigrLegBanTipCuen = T00283_A612MigrLegBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         A634MigrLegOSAfip = T00283_A634MigrLegOSAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         A615MigrLegPlanMedico = T00283_A615MigrLegPlanMedico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
         A618MigrLegFecUltMod = T00283_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = T00283_A619MigrLegCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
         A621MigrLegCBU = T00283_A621MigrLegCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
         A622MigrLegSCVO = T00283_A622MigrLegSCVO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
         A623MigrLegSituacionRevista = T00283_A623MigrLegSituacionRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A2239MigrLegActLabClas = T00283_A2239MigrLegActLabClas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
         A2240MigrLegPueAfip = T00283_A2240MigrLegPueAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
         A625MigrLegSiniestrado = T00283_A625MigrLegSiniestrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A626MigrLegId = T00283_A626MigrLegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         A628MigrLegObs = T00283_A628MigrLegObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
         A629MigrLegErrores = T00283_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = T00283_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = T00283_A631MigrTieneConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         A632MigrCantidadHijos = T00283_A632MigrCantidadHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
         A635MigrEncontroOsoSigla = T00283_A635MigrEncontroOsoSigla[0] ;
         A689MigrLegAreaDef = T00283_A689MigrLegAreaDef[0] ;
         A690MigrLegEstadoCivilDef = T00283_A690MigrLegEstadoCivilDef[0] ;
         A691MigrLegClaseDef = T00283_A691MigrLegClaseDef[0] ;
         A692MigrLegFormaPagoDef = T00283_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = T00283_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = T00283_A694MigrLegActividadDef[0] ;
         A695MigrLegModalidadDef = T00283_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = T00283_A696MigrLegZonaDef[0] ;
         A697MigrLegSCVODef = T00283_A697MigrLegSCVODef[0] ;
         A698MigrLegSituacionDef = T00283_A698MigrLegSituacionDef[0] ;
         A699MigrLegCondicionDef = T00283_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = T00283_A700MigrLegSiniestradoDef[0] ;
         A2216MigrPuesto = T00283_A2216MigrPuesto[0] ;
         A2205MigrLegFecEgreso = T00283_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = T00283_A2206MigrOtrosDatos[0] ;
         A2275MigrLegHorSem = T00283_A2275MigrLegHorSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
         A2427MigrLegTipoTarifa = T00283_A2427MigrLegTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
         A3CliCod = T00283_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00283_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         O634MigrLegOSAfip = A634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2875( ) ;
         if ( AnyError == 1 )
         {
            RcdFound75 = (short)(0) ;
            initializeNonKey2875( ) ;
         }
         Gx_mode = sMode75 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound75 = (short)(0) ;
         initializeNonKey2875( ) ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode75 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2875( ) ;
      if ( RcdFound75 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound75 = (short)(0) ;
      /* Using cursor T00288 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00288_A3CliCod[0] < A3CliCod ) || ( T00288_A3CliCod[0] == A3CliCod ) && ( T00288_A1EmpCod[0] < A1EmpCod ) || ( T00288_A1EmpCod[0] == A1EmpCod ) && ( T00288_A3CliCod[0] == A3CliCod ) && ( T00288_A87MigrLegNumero[0] < A87MigrLegNumero ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00288_A3CliCod[0] > A3CliCod ) || ( T00288_A3CliCod[0] == A3CliCod ) && ( T00288_A1EmpCod[0] > A1EmpCod ) || ( T00288_A1EmpCod[0] == A1EmpCod ) && ( T00288_A3CliCod[0] == A3CliCod ) && ( T00288_A87MigrLegNumero[0] > A87MigrLegNumero ) ) )
         {
            A3CliCod = T00288_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00288_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T00288_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            RcdFound75 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound75 = (short)(0) ;
      /* Using cursor T00289 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00289_A3CliCod[0] > A3CliCod ) || ( T00289_A3CliCod[0] == A3CliCod ) && ( T00289_A1EmpCod[0] > A1EmpCod ) || ( T00289_A1EmpCod[0] == A1EmpCod ) && ( T00289_A3CliCod[0] == A3CliCod ) && ( T00289_A87MigrLegNumero[0] > A87MigrLegNumero ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00289_A3CliCod[0] < A3CliCod ) || ( T00289_A3CliCod[0] == A3CliCod ) && ( T00289_A1EmpCod[0] < A1EmpCod ) || ( T00289_A1EmpCod[0] == A1EmpCod ) && ( T00289_A3CliCod[0] == A3CliCod ) && ( T00289_A87MigrLegNumero[0] < A87MigrLegNumero ) ) )
         {
            A3CliCod = T00289_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00289_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T00289_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            RcdFound75 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2875( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2875( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound75 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A87MigrLegNumero = Z87MigrLegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2875( ) ;
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
            {
               /* Insert record */
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2875( ) ;
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
                  GX_FocusControl = edtMigrLegId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2875( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = Z87MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2875( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00282 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z595MigrLegSexo, T00282_A595MigrLegSexo[0]) != 0 ) || ( GXutil.strcmp(Z596MigrLegEstadoCivil, T00282_A596MigrLegEstadoCivil[0]) != 0 ) || ( GXutil.strcmp(Z605MigrLegArea, T00282_A605MigrLegArea[0]) != 0 ) || ( GXutil.strcmp(Z613MigrLegSindicato, T00282_A613MigrLegSindicato[0]) != 0 ) || ( GXutil.strcmp(Z627MigrLegConvenio, T00282_A627MigrLegConvenio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z604MigrLegCategoria, T00282_A604MigrLegCategoria[0]) != 0 ) || ( GXutil.strcmp(Z610MigrLegBanco, T00282_A610MigrLegBanco[0]) != 0 ) || ( GXutil.strcmp(Z614MigrLegObraSocial, T00282_A614MigrLegObraSocial[0]) != 0 ) || ( GXutil.strcmp(Z617MigrLegModalidad, T00282_A617MigrLegModalidad[0]) != 0 ) || ( GXutil.strcmp(Z620MigrLegZona, T00282_A620MigrLegZona[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z616MigrLegActividad, T00282_A616MigrLegActividad[0]) != 0 ) || ( GXutil.strcmp(Z624MigrLegCondicion, T00282_A624MigrLegCondicion[0]) != 0 ) || ( GXutil.strcmp(Z592MigrLegApellido, T00282_A592MigrLegApellido[0]) != 0 ) || ( GXutil.strcmp(Z593MigrLegNombre, T00282_A593MigrLegNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z594MigrLegFecNac), GXutil.resetTime(T00282_A594MigrLegFecNac[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z597MigrLegCUIL, T00282_A597MigrLegCUIL[0]) != 0 ) || ( GXutil.strcmp(Z598MigrLegDiscapacidad, T00282_A598MigrLegDiscapacidad[0]) != 0 ) || ( GXutil.strcmp(Z599MigrLegDomici, T00282_A599MigrLegDomici[0]) != 0 ) || ( GXutil.strcmp(Z600MigrLegEmail, T00282_A600MigrLegEmail[0]) != 0 ) || ( GXutil.strcmp(Z601MigrLegCodPos, T00282_A601MigrLegCodPos[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z602MigrLegTelefono, T00282_A602MigrLegTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z603MigrLegFecIngreso), GXutil.resetTime(T00282_A603MigrLegFecIngreso[0])) ) || ( GXutil.strcmp(Z606MigrLegLugarDePago, T00282_A606MigrLegLugarDePago[0]) != 0 ) || ( GXutil.strcmp(Z2415MigrLegModTra, T00282_A2415MigrLegModTra[0]) != 0 ) || ( GXutil.strcmp(Z607MigrLegClase, T00282_A607MigrLegClase[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z608MigrLegBasico, T00282_A608MigrLegBasico[0]) != 0 ) || ( GXutil.strcmp(Z609MigrLegFormaPago, T00282_A609MigrLegFormaPago[0]) != 0 ) || ( GXutil.strcmp(Z611MigrLegBanSuc, T00282_A611MigrLegBanSuc[0]) != 0 ) || ( GXutil.strcmp(Z612MigrLegBanTipCuen, T00282_A612MigrLegBanTipCuen[0]) != 0 ) || ( GXutil.strcmp(Z634MigrLegOSAfip, T00282_A634MigrLegOSAfip[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z615MigrLegPlanMedico, T00282_A615MigrLegPlanMedico[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z618MigrLegFecUltMod), GXutil.resetTime(T00282_A618MigrLegFecUltMod[0])) ) || ( GXutil.strcmp(Z619MigrLegCuentaBanc, T00282_A619MigrLegCuentaBanc[0]) != 0 ) || ( GXutil.strcmp(Z621MigrLegCBU, T00282_A621MigrLegCBU[0]) != 0 ) || ( GXutil.strcmp(Z622MigrLegSCVO, T00282_A622MigrLegSCVO[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z623MigrLegSituacionRevista, T00282_A623MigrLegSituacionRevista[0]) != 0 ) || ( GXutil.strcmp(Z2239MigrLegActLabClas, T00282_A2239MigrLegActLabClas[0]) != 0 ) || ( GXutil.strcmp(Z2240MigrLegPueAfip, T00282_A2240MigrLegPueAfip[0]) != 0 ) || ( GXutil.strcmp(Z625MigrLegSiniestrado, T00282_A625MigrLegSiniestrado[0]) != 0 ) || ( GXutil.strcmp(Z626MigrLegId, T00282_A626MigrLegId[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z631MigrTieneConyuge, T00282_A631MigrTieneConyuge[0]) != 0 ) || ( Z632MigrCantidadHijos != T00282_A632MigrCantidadHijos[0] ) || ( Z635MigrEncontroOsoSigla != T00282_A635MigrEncontroOsoSigla[0] ) || ( Z689MigrLegAreaDef != T00282_A689MigrLegAreaDef[0] ) || ( Z690MigrLegEstadoCivilDef != T00282_A690MigrLegEstadoCivilDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z691MigrLegClaseDef != T00282_A691MigrLegClaseDef[0] ) || ( Z692MigrLegFormaPagoDef != T00282_A692MigrLegFormaPagoDef[0] ) || ( Z693MigrLegTipoCuentaDef != T00282_A693MigrLegTipoCuentaDef[0] ) || ( Z694MigrLegActividadDef != T00282_A694MigrLegActividadDef[0] ) || ( Z695MigrLegModalidadDef != T00282_A695MigrLegModalidadDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z696MigrLegZonaDef != T00282_A696MigrLegZonaDef[0] ) || ( Z697MigrLegSCVODef != T00282_A697MigrLegSCVODef[0] ) || ( Z698MigrLegSituacionDef != T00282_A698MigrLegSituacionDef[0] ) || ( Z699MigrLegCondicionDef != T00282_A699MigrLegCondicionDef[0] ) || ( Z700MigrLegSiniestradoDef != T00282_A700MigrLegSiniestradoDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2216MigrPuesto, T00282_A2216MigrPuesto[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2205MigrLegFecEgreso), GXutil.resetTime(T00282_A2205MigrLegFecEgreso[0])) ) || ( DecimalUtil.compareTo(Z2275MigrLegHorSem, T00282_A2275MigrLegHorSem[0]) != 0 ) || ( GXutil.strcmp(Z2427MigrLegTipoTarifa, T00282_A2427MigrLegTipoTarifa[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z595MigrLegSexo, T00282_A595MigrLegSexo[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSexo");
               GXutil.writeLogRaw("Old: ",Z595MigrLegSexo);
               GXutil.writeLogRaw("Current: ",T00282_A595MigrLegSexo[0]);
            }
            if ( GXutil.strcmp(Z596MigrLegEstadoCivil, T00282_A596MigrLegEstadoCivil[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegEstadoCivil");
               GXutil.writeLogRaw("Old: ",Z596MigrLegEstadoCivil);
               GXutil.writeLogRaw("Current: ",T00282_A596MigrLegEstadoCivil[0]);
            }
            if ( GXutil.strcmp(Z605MigrLegArea, T00282_A605MigrLegArea[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegArea");
               GXutil.writeLogRaw("Old: ",Z605MigrLegArea);
               GXutil.writeLogRaw("Current: ",T00282_A605MigrLegArea[0]);
            }
            if ( GXutil.strcmp(Z613MigrLegSindicato, T00282_A613MigrLegSindicato[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSindicato");
               GXutil.writeLogRaw("Old: ",Z613MigrLegSindicato);
               GXutil.writeLogRaw("Current: ",T00282_A613MigrLegSindicato[0]);
            }
            if ( GXutil.strcmp(Z627MigrLegConvenio, T00282_A627MigrLegConvenio[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegConvenio");
               GXutil.writeLogRaw("Old: ",Z627MigrLegConvenio);
               GXutil.writeLogRaw("Current: ",T00282_A627MigrLegConvenio[0]);
            }
            if ( GXutil.strcmp(Z604MigrLegCategoria, T00282_A604MigrLegCategoria[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCategoria");
               GXutil.writeLogRaw("Old: ",Z604MigrLegCategoria);
               GXutil.writeLogRaw("Current: ",T00282_A604MigrLegCategoria[0]);
            }
            if ( GXutil.strcmp(Z610MigrLegBanco, T00282_A610MigrLegBanco[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegBanco");
               GXutil.writeLogRaw("Old: ",Z610MigrLegBanco);
               GXutil.writeLogRaw("Current: ",T00282_A610MigrLegBanco[0]);
            }
            if ( GXutil.strcmp(Z614MigrLegObraSocial, T00282_A614MigrLegObraSocial[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegObraSocial");
               GXutil.writeLogRaw("Old: ",Z614MigrLegObraSocial);
               GXutil.writeLogRaw("Current: ",T00282_A614MigrLegObraSocial[0]);
            }
            if ( GXutil.strcmp(Z617MigrLegModalidad, T00282_A617MigrLegModalidad[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegModalidad");
               GXutil.writeLogRaw("Old: ",Z617MigrLegModalidad);
               GXutil.writeLogRaw("Current: ",T00282_A617MigrLegModalidad[0]);
            }
            if ( GXutil.strcmp(Z620MigrLegZona, T00282_A620MigrLegZona[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegZona");
               GXutil.writeLogRaw("Old: ",Z620MigrLegZona);
               GXutil.writeLogRaw("Current: ",T00282_A620MigrLegZona[0]);
            }
            if ( GXutil.strcmp(Z616MigrLegActividad, T00282_A616MigrLegActividad[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegActividad");
               GXutil.writeLogRaw("Old: ",Z616MigrLegActividad);
               GXutil.writeLogRaw("Current: ",T00282_A616MigrLegActividad[0]);
            }
            if ( GXutil.strcmp(Z624MigrLegCondicion, T00282_A624MigrLegCondicion[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCondicion");
               GXutil.writeLogRaw("Old: ",Z624MigrLegCondicion);
               GXutil.writeLogRaw("Current: ",T00282_A624MigrLegCondicion[0]);
            }
            if ( GXutil.strcmp(Z592MigrLegApellido, T00282_A592MigrLegApellido[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegApellido");
               GXutil.writeLogRaw("Old: ",Z592MigrLegApellido);
               GXutil.writeLogRaw("Current: ",T00282_A592MigrLegApellido[0]);
            }
            if ( GXutil.strcmp(Z593MigrLegNombre, T00282_A593MigrLegNombre[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegNombre");
               GXutil.writeLogRaw("Old: ",Z593MigrLegNombre);
               GXutil.writeLogRaw("Current: ",T00282_A593MigrLegNombre[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z594MigrLegFecNac), GXutil.resetTime(T00282_A594MigrLegFecNac[0])) ) )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFecNac");
               GXutil.writeLogRaw("Old: ",Z594MigrLegFecNac);
               GXutil.writeLogRaw("Current: ",T00282_A594MigrLegFecNac[0]);
            }
            if ( GXutil.strcmp(Z597MigrLegCUIL, T00282_A597MigrLegCUIL[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCUIL");
               GXutil.writeLogRaw("Old: ",Z597MigrLegCUIL);
               GXutil.writeLogRaw("Current: ",T00282_A597MigrLegCUIL[0]);
            }
            if ( GXutil.strcmp(Z598MigrLegDiscapacidad, T00282_A598MigrLegDiscapacidad[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegDiscapacidad");
               GXutil.writeLogRaw("Old: ",Z598MigrLegDiscapacidad);
               GXutil.writeLogRaw("Current: ",T00282_A598MigrLegDiscapacidad[0]);
            }
            if ( GXutil.strcmp(Z599MigrLegDomici, T00282_A599MigrLegDomici[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegDomici");
               GXutil.writeLogRaw("Old: ",Z599MigrLegDomici);
               GXutil.writeLogRaw("Current: ",T00282_A599MigrLegDomici[0]);
            }
            if ( GXutil.strcmp(Z600MigrLegEmail, T00282_A600MigrLegEmail[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegEmail");
               GXutil.writeLogRaw("Old: ",Z600MigrLegEmail);
               GXutil.writeLogRaw("Current: ",T00282_A600MigrLegEmail[0]);
            }
            if ( GXutil.strcmp(Z601MigrLegCodPos, T00282_A601MigrLegCodPos[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCodPos");
               GXutil.writeLogRaw("Old: ",Z601MigrLegCodPos);
               GXutil.writeLogRaw("Current: ",T00282_A601MigrLegCodPos[0]);
            }
            if ( GXutil.strcmp(Z602MigrLegTelefono, T00282_A602MigrLegTelefono[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegTelefono");
               GXutil.writeLogRaw("Old: ",Z602MigrLegTelefono);
               GXutil.writeLogRaw("Current: ",T00282_A602MigrLegTelefono[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z603MigrLegFecIngreso), GXutil.resetTime(T00282_A603MigrLegFecIngreso[0])) ) )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFecIngreso");
               GXutil.writeLogRaw("Old: ",Z603MigrLegFecIngreso);
               GXutil.writeLogRaw("Current: ",T00282_A603MigrLegFecIngreso[0]);
            }
            if ( GXutil.strcmp(Z606MigrLegLugarDePago, T00282_A606MigrLegLugarDePago[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegLugarDePago");
               GXutil.writeLogRaw("Old: ",Z606MigrLegLugarDePago);
               GXutil.writeLogRaw("Current: ",T00282_A606MigrLegLugarDePago[0]);
            }
            if ( GXutil.strcmp(Z2415MigrLegModTra, T00282_A2415MigrLegModTra[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegModTra");
               GXutil.writeLogRaw("Old: ",Z2415MigrLegModTra);
               GXutil.writeLogRaw("Current: ",T00282_A2415MigrLegModTra[0]);
            }
            if ( GXutil.strcmp(Z607MigrLegClase, T00282_A607MigrLegClase[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegClase");
               GXutil.writeLogRaw("Old: ",Z607MigrLegClase);
               GXutil.writeLogRaw("Current: ",T00282_A607MigrLegClase[0]);
            }
            if ( DecimalUtil.compareTo(Z608MigrLegBasico, T00282_A608MigrLegBasico[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegBasico");
               GXutil.writeLogRaw("Old: ",Z608MigrLegBasico);
               GXutil.writeLogRaw("Current: ",T00282_A608MigrLegBasico[0]);
            }
            if ( GXutil.strcmp(Z609MigrLegFormaPago, T00282_A609MigrLegFormaPago[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFormaPago");
               GXutil.writeLogRaw("Old: ",Z609MigrLegFormaPago);
               GXutil.writeLogRaw("Current: ",T00282_A609MigrLegFormaPago[0]);
            }
            if ( GXutil.strcmp(Z611MigrLegBanSuc, T00282_A611MigrLegBanSuc[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegBanSuc");
               GXutil.writeLogRaw("Old: ",Z611MigrLegBanSuc);
               GXutil.writeLogRaw("Current: ",T00282_A611MigrLegBanSuc[0]);
            }
            if ( GXutil.strcmp(Z612MigrLegBanTipCuen, T00282_A612MigrLegBanTipCuen[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegBanTipCuen");
               GXutil.writeLogRaw("Old: ",Z612MigrLegBanTipCuen);
               GXutil.writeLogRaw("Current: ",T00282_A612MigrLegBanTipCuen[0]);
            }
            if ( GXutil.strcmp(Z634MigrLegOSAfip, T00282_A634MigrLegOSAfip[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegOSAfip");
               GXutil.writeLogRaw("Old: ",Z634MigrLegOSAfip);
               GXutil.writeLogRaw("Current: ",T00282_A634MigrLegOSAfip[0]);
            }
            if ( GXutil.strcmp(Z615MigrLegPlanMedico, T00282_A615MigrLegPlanMedico[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegPlanMedico");
               GXutil.writeLogRaw("Old: ",Z615MigrLegPlanMedico);
               GXutil.writeLogRaw("Current: ",T00282_A615MigrLegPlanMedico[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z618MigrLegFecUltMod), GXutil.resetTime(T00282_A618MigrLegFecUltMod[0])) ) )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFecUltMod");
               GXutil.writeLogRaw("Old: ",Z618MigrLegFecUltMod);
               GXutil.writeLogRaw("Current: ",T00282_A618MigrLegFecUltMod[0]);
            }
            if ( GXutil.strcmp(Z619MigrLegCuentaBanc, T00282_A619MigrLegCuentaBanc[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCuentaBanc");
               GXutil.writeLogRaw("Old: ",Z619MigrLegCuentaBanc);
               GXutil.writeLogRaw("Current: ",T00282_A619MigrLegCuentaBanc[0]);
            }
            if ( GXutil.strcmp(Z621MigrLegCBU, T00282_A621MigrLegCBU[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCBU");
               GXutil.writeLogRaw("Old: ",Z621MigrLegCBU);
               GXutil.writeLogRaw("Current: ",T00282_A621MigrLegCBU[0]);
            }
            if ( GXutil.strcmp(Z622MigrLegSCVO, T00282_A622MigrLegSCVO[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSCVO");
               GXutil.writeLogRaw("Old: ",Z622MigrLegSCVO);
               GXutil.writeLogRaw("Current: ",T00282_A622MigrLegSCVO[0]);
            }
            if ( GXutil.strcmp(Z623MigrLegSituacionRevista, T00282_A623MigrLegSituacionRevista[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSituacionRevista");
               GXutil.writeLogRaw("Old: ",Z623MigrLegSituacionRevista);
               GXutil.writeLogRaw("Current: ",T00282_A623MigrLegSituacionRevista[0]);
            }
            if ( GXutil.strcmp(Z2239MigrLegActLabClas, T00282_A2239MigrLegActLabClas[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegActLabClas");
               GXutil.writeLogRaw("Old: ",Z2239MigrLegActLabClas);
               GXutil.writeLogRaw("Current: ",T00282_A2239MigrLegActLabClas[0]);
            }
            if ( GXutil.strcmp(Z2240MigrLegPueAfip, T00282_A2240MigrLegPueAfip[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegPueAfip");
               GXutil.writeLogRaw("Old: ",Z2240MigrLegPueAfip);
               GXutil.writeLogRaw("Current: ",T00282_A2240MigrLegPueAfip[0]);
            }
            if ( GXutil.strcmp(Z625MigrLegSiniestrado, T00282_A625MigrLegSiniestrado[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSiniestrado");
               GXutil.writeLogRaw("Old: ",Z625MigrLegSiniestrado);
               GXutil.writeLogRaw("Current: ",T00282_A625MigrLegSiniestrado[0]);
            }
            if ( GXutil.strcmp(Z626MigrLegId, T00282_A626MigrLegId[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegId");
               GXutil.writeLogRaw("Old: ",Z626MigrLegId);
               GXutil.writeLogRaw("Current: ",T00282_A626MigrLegId[0]);
            }
            if ( GXutil.strcmp(Z631MigrTieneConyuge, T00282_A631MigrTieneConyuge[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrTieneConyuge");
               GXutil.writeLogRaw("Old: ",Z631MigrTieneConyuge);
               GXutil.writeLogRaw("Current: ",T00282_A631MigrTieneConyuge[0]);
            }
            if ( Z632MigrCantidadHijos != T00282_A632MigrCantidadHijos[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrCantidadHijos");
               GXutil.writeLogRaw("Old: ",Z632MigrCantidadHijos);
               GXutil.writeLogRaw("Current: ",T00282_A632MigrCantidadHijos[0]);
            }
            if ( Z635MigrEncontroOsoSigla != T00282_A635MigrEncontroOsoSigla[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrEncontroOsoSigla");
               GXutil.writeLogRaw("Old: ",Z635MigrEncontroOsoSigla);
               GXutil.writeLogRaw("Current: ",T00282_A635MigrEncontroOsoSigla[0]);
            }
            if ( Z689MigrLegAreaDef != T00282_A689MigrLegAreaDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegAreaDef");
               GXutil.writeLogRaw("Old: ",Z689MigrLegAreaDef);
               GXutil.writeLogRaw("Current: ",T00282_A689MigrLegAreaDef[0]);
            }
            if ( Z690MigrLegEstadoCivilDef != T00282_A690MigrLegEstadoCivilDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegEstadoCivilDef");
               GXutil.writeLogRaw("Old: ",Z690MigrLegEstadoCivilDef);
               GXutil.writeLogRaw("Current: ",T00282_A690MigrLegEstadoCivilDef[0]);
            }
            if ( Z691MigrLegClaseDef != T00282_A691MigrLegClaseDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegClaseDef");
               GXutil.writeLogRaw("Old: ",Z691MigrLegClaseDef);
               GXutil.writeLogRaw("Current: ",T00282_A691MigrLegClaseDef[0]);
            }
            if ( Z692MigrLegFormaPagoDef != T00282_A692MigrLegFormaPagoDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFormaPagoDef");
               GXutil.writeLogRaw("Old: ",Z692MigrLegFormaPagoDef);
               GXutil.writeLogRaw("Current: ",T00282_A692MigrLegFormaPagoDef[0]);
            }
            if ( Z693MigrLegTipoCuentaDef != T00282_A693MigrLegTipoCuentaDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegTipoCuentaDef");
               GXutil.writeLogRaw("Old: ",Z693MigrLegTipoCuentaDef);
               GXutil.writeLogRaw("Current: ",T00282_A693MigrLegTipoCuentaDef[0]);
            }
            if ( Z694MigrLegActividadDef != T00282_A694MigrLegActividadDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegActividadDef");
               GXutil.writeLogRaw("Old: ",Z694MigrLegActividadDef);
               GXutil.writeLogRaw("Current: ",T00282_A694MigrLegActividadDef[0]);
            }
            if ( Z695MigrLegModalidadDef != T00282_A695MigrLegModalidadDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegModalidadDef");
               GXutil.writeLogRaw("Old: ",Z695MigrLegModalidadDef);
               GXutil.writeLogRaw("Current: ",T00282_A695MigrLegModalidadDef[0]);
            }
            if ( Z696MigrLegZonaDef != T00282_A696MigrLegZonaDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegZonaDef");
               GXutil.writeLogRaw("Old: ",Z696MigrLegZonaDef);
               GXutil.writeLogRaw("Current: ",T00282_A696MigrLegZonaDef[0]);
            }
            if ( Z697MigrLegSCVODef != T00282_A697MigrLegSCVODef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSCVODef");
               GXutil.writeLogRaw("Old: ",Z697MigrLegSCVODef);
               GXutil.writeLogRaw("Current: ",T00282_A697MigrLegSCVODef[0]);
            }
            if ( Z698MigrLegSituacionDef != T00282_A698MigrLegSituacionDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSituacionDef");
               GXutil.writeLogRaw("Old: ",Z698MigrLegSituacionDef);
               GXutil.writeLogRaw("Current: ",T00282_A698MigrLegSituacionDef[0]);
            }
            if ( Z699MigrLegCondicionDef != T00282_A699MigrLegCondicionDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegCondicionDef");
               GXutil.writeLogRaw("Old: ",Z699MigrLegCondicionDef);
               GXutil.writeLogRaw("Current: ",T00282_A699MigrLegCondicionDef[0]);
            }
            if ( Z700MigrLegSiniestradoDef != T00282_A700MigrLegSiniestradoDef[0] )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegSiniestradoDef");
               GXutil.writeLogRaw("Old: ",Z700MigrLegSiniestradoDef);
               GXutil.writeLogRaw("Current: ",T00282_A700MigrLegSiniestradoDef[0]);
            }
            if ( GXutil.strcmp(Z2216MigrPuesto, T00282_A2216MigrPuesto[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrPuesto");
               GXutil.writeLogRaw("Old: ",Z2216MigrPuesto);
               GXutil.writeLogRaw("Current: ",T00282_A2216MigrPuesto[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2205MigrLegFecEgreso), GXutil.resetTime(T00282_A2205MigrLegFecEgreso[0])) ) )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegFecEgreso");
               GXutil.writeLogRaw("Old: ",Z2205MigrLegFecEgreso);
               GXutil.writeLogRaw("Current: ",T00282_A2205MigrLegFecEgreso[0]);
            }
            if ( DecimalUtil.compareTo(Z2275MigrLegHorSem, T00282_A2275MigrLegHorSem[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegHorSem");
               GXutil.writeLogRaw("Old: ",Z2275MigrLegHorSem);
               GXutil.writeLogRaw("Current: ",T00282_A2275MigrLegHorSem[0]);
            }
            if ( GXutil.strcmp(Z2427MigrLegTipoTarifa, T00282_A2427MigrLegTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("migrlegupd:[seudo value changed for attri]"+"MigrLegTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2427MigrLegTipoTarifa);
               GXutil.writeLogRaw("Current: ",T00282_A2427MigrLegTipoTarifa[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2875( )
   {
      beforeValidate2875( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2875( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2875( 0) ;
         checkOptimisticConcurrency2875( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2875( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2875( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002810 */
                  pr_default.execute(8, new Object[] {Integer.valueOf(A87MigrLegNumero), A595MigrLegSexo, A596MigrLegEstadoCivil, A605MigrLegArea, A613MigrLegSindicato, A627MigrLegConvenio, A604MigrLegCategoria, A610MigrLegBanco, A614MigrLegObraSocial, A617MigrLegModalidad, A620MigrLegZona, A616MigrLegActividad, A624MigrLegCondicion, A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A606MigrLegLugarDePago, A2415MigrLegModTra, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A634MigrLegOSAfip, A615MigrLegPlanMedico, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A2239MigrLegActLabClas, A2240MigrLegPueAfip, A625MigrLegSiniestrado, A626MigrLegId, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), Boolean.valueOf(A689MigrLegAreaDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A691MigrLegClaseDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A697MigrLegSCVODef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), A2216MigrPuesto, A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2275MigrLegHorSem, A2427MigrLegTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
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
                        resetCaption280( ) ;
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
            load2875( ) ;
         }
         endLevel2875( ) ;
      }
      closeExtendedTableCursors2875( ) ;
   }

   public void update2875( )
   {
      beforeValidate2875( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2875( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2875( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2875( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2875( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002811 */
                  pr_default.execute(9, new Object[] {A595MigrLegSexo, A596MigrLegEstadoCivil, A605MigrLegArea, A613MigrLegSindicato, A627MigrLegConvenio, A604MigrLegCategoria, A610MigrLegBanco, A614MigrLegObraSocial, A617MigrLegModalidad, A620MigrLegZona, A616MigrLegActividad, A624MigrLegCondicion, A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A606MigrLegLugarDePago, A2415MigrLegModTra, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A634MigrLegOSAfip, A615MigrLegPlanMedico, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A2239MigrLegActLabClas, A2240MigrLegPueAfip, A625MigrLegSiniestrado, A626MigrLegId, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), Boolean.valueOf(A689MigrLegAreaDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A691MigrLegClaseDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A697MigrLegSCVODef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), A2216MigrPuesto, A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2275MigrLegHorSem, A2427MigrLegTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2875( ) ;
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
         endLevel2875( ) ;
      }
      closeExtendedTableCursors2875( ) ;
   }

   public void deferredUpdate2875( )
   {
   }

   public void delete( )
   {
      beforeValidate2875( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2875( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2875( ) ;
         afterConfirm2875( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2875( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002812 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
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
      sMode75 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2875( ) ;
      Gx_mode = sMode75 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2875( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV203Pgmname = "MigrLegUPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV203Pgmname", AV203Pgmname);
         AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
         if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
         {
            edtMigrLegOSAfip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
         }
         else
         {
            edtMigrLegOSAfip_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
         }
         GXt_char37 = AV177actTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV177actTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
         GXt_char37 = AV178modTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV178modTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
         GXt_char37 = AV175texto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV175texto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
         GXt_char37 = AV179sitRevTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV179sitRevTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
         GXt_char37 = AV180condTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV180condTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
         GXt_char37 = AV176sinesTexto ;
         GXv_char24[0] = GXt_char37 ;
         new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV176sinesTexto = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T002813 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_legajoFamilia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel2875( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2875( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "migrlegupd");
         if ( AnyError == 0 )
         {
            confirmValues280( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "migrlegupd");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2875( )
   {
      /* Scan By routine */
      /* Using cursor T002814 */
      pr_default.execute(12);
      RcdFound75 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A3CliCod = T002814_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002814_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T002814_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2875( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound75 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A3CliCod = T002814_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002814_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T002814_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
   }

   public void scanEnd2875( )
   {
      pr_default.close(12);
   }

   public void afterConfirm2875( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2875( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2875( )
   {
      /* Before Update Rules */
      GXt_char37 = AV164sexoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Sexo", ""), ""), GXutil.trim( A595MigrLegSexo), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV164sexoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV164sexoError", AV164sexoError);
      GXv_int39[0] = (byte)(0) ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV168sexoExiste ;
      new web.traducirsexo(remoteHandle, context).execute( AV7CliCod, A595MigrLegSexo, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV168sexoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV168sexoExiste", AV168sexoExiste);
      GXt_char37 = AV73estadocivilError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Estado Civil", ""), ""), GXutil.trim( A596MigrLegEstadoCivil), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV73estadocivilError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73estadocivilError", AV73estadocivilError);
      GXv_char24[0] = AV156CatCodigo ;
      GXv_boolean36[0] = AV155categoriaExiste ;
      new web.getcategoriapordescrip(remoteHandle, context).execute( AV7CliCod, A627MigrLegConvenio, A604MigrLegCategoria, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV156CatCodigo = GXv_char24[0] ;
      migrlegupd_impl.this.AV155categoriaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV156CatCodigo", AV156CatCodigo);
      httpContext.ajax_rsp_assign_attri("", false, "AV155categoriaExiste", AV155categoriaExiste);
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV157siniestradoExiste ;
      new web.getsiniestradopordescrip(remoteHandle, context).execute( AV176sinesTexto, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV157siniestradoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV157siniestradoExiste", AV157siniestradoExiste);
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV159actividadExiste ;
      new web.getactividadpordescrip(remoteHandle, context).execute( AV177actTexto, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV159actividadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV159actividadExiste", AV159actividadExiste);
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV160ModalidadExiste ;
      new web.getmodalidadpordescrip(remoteHandle, context).execute( AV178modTexto, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV160ModalidadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV160ModalidadExiste", AV160ModalidadExiste);
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV161ZonaExiste ;
      new web.getzonapordescrip(remoteHandle, context).execute( AV175texto, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV161ZonaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV161ZonaExiste", AV161ZonaExiste);
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV162SituacionExiste ;
      new web.getsituacionpordescrip(remoteHandle, context).execute( AV179sitRevTexto, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV162SituacionExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV162SituacionExiste", AV162SituacionExiste);
      GXv_int42[0] = (short)(0) ;
      GXv_boolean36[0] = AV163CondicionExiste ;
      new web.getcondicionpordescrip(remoteHandle, context).execute( AV180condTexto, GXv_int42, GXv_boolean36) ;
      migrlegupd_impl.this.AV163CondicionExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV163CondicionExiste", AV163CondicionExiste);
      if ( ! (0==AV66LegNumeroPorCUIL) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El CUIL ", "")+GXutil.trim( A597MigrLegCUIL)+httpContext.getMessage( " ya existe en la empresa, legajo \"", "")+GXutil.trim( AV63LegIdNomApe)+"\"", 1, "MIGRLEGCUIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCUIL_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV74discapacidadError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Discapacidad", ""), ""), GXutil.trim( A598MigrLegDiscapacidad), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV74discapacidadError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74discapacidadError", AV74discapacidadError);
      GXt_dtime43 = GXutil.resetTime( A594MigrLegFecNac );
      GXt_dtime44 = GXutil.resetTime( A603MigrLegFecIngreso );
      if ( ( GXutil.age( GXt_dtime43, GXt_dtime44) < 16 ) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A594MigrLegFecNac)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La edad no puede ser menor a 16", ""), 1, "MIGRLEGFECNAC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecNac_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A608MigrLegBasico)==0) && ( (GXutil.strcmp("", AV64AuxMigrLegCategoria)==0) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar Sueldo Básico fuera de convenio", ""), 1, "MIGRLEGBASICO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegBasico_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV76formadepagoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Forma de Pago", ""), ""), GXutil.trim( A609MigrLegFormaPago), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV76formadepagoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76formadepagoError", AV76formadepagoError);
      GXt_char37 = AV166tipocuentaError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Tipo de Cuenta", ""), ""), GXutil.trim( A612MigrLegBanTipCuen), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV166tipocuentaError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV166tipocuentaError", AV166tipocuentaError);
      GXt_char37 = AV77scvoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "SCVO", ""), ""), GXutil.trim( A622MigrLegSCVO), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV77scvoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77scvoError", AV77scvoError);
      if ( true )
      {
         GXt_char37 = AV158mensaje ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Siniestrado", ""), ""), A625MigrLegSiniestrado, false, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV158mensaje = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
      }
      else
      {
         if ( true )
         {
            GXt_char37 = AV158mensaje ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Actividad", ""), ""), A616MigrLegActividad, false, false, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            AV158mensaje = GXt_char37 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
         }
         else
         {
            if ( true )
            {
               GXt_char37 = AV158mensaje ;
               GXv_char24[0] = GXt_char37 ;
               new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Modalidad", ""), ""), A617MigrLegModalidad, false, false, GXv_char24) ;
               migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
               AV158mensaje = GXt_char37 ;
               httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
            }
            else
            {
               if ( true )
               {
                  GXt_char37 = AV158mensaje ;
                  GXv_char24[0] = GXt_char37 ;
                  new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Zona", ""), ""), A620MigrLegZona, false, false, GXv_char24) ;
                  migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                  AV158mensaje = GXt_char37 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
               }
               else
               {
                  if ( true )
                  {
                     GXt_char37 = AV158mensaje ;
                     GXv_char24[0] = GXt_char37 ;
                     new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Situacion", ""), ""), A623MigrLegSituacionRevista, false, false, GXv_char24) ;
                     migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                     AV158mensaje = GXt_char37 ;
                     httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
                  }
                  else
                  {
                     GXt_char37 = AV158mensaje ;
                     GXv_char24[0] = GXt_char37 ;
                     new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Condicion", ""), ""), A624MigrLegCondicion, false, false, GXv_char24) ;
                     migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                     AV158mensaje = GXt_char37 ;
                     httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
                  }
               }
            }
         }
      }
      if ( ! (0==AV65LegNumeroPorId) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El id ", "")+GXutil.trim( A626MigrLegId)+httpContext.getMessage( " ya existe en la empresa, legajo \"", "")+GXutil.trim( AV62LegNomApe)+"\"", 1, "MIGRLEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char37 = AV103tieneconyugeError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Tiene Conyuge", ""), ""), GXutil.trim( A631MigrTieneConyuge), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV103tieneconyugeError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV103tieneconyugeError", AV103tieneconyugeError);
      GXv_int38[0] = AV7CliCod ;
      GXv_int39[0] = AV92ClaseLeg ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = false ;
      new web.traducirclaselegajo(remoteHandle, context).execute( GXv_int38, A607MigrLegClase, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV7CliCod = GXv_int38[0] ;
      migrlegupd_impl.this.AV92ClaseLeg = GXv_int39[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      httpContext.ajax_rsp_assign_attri("", false, "AV92ClaseLeg", GXutil.str( AV92ClaseLeg, 1, 0));
      GXv_int42[0] = AV95EstadoCivil ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV173estadoCivilExiste ;
      new web.traducirestadocivil(remoteHandle, context).execute( AV7CliCod, A596MigrLegEstadoCivil, GXv_int42, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV95EstadoCivil = GXv_int42[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV173estadoCivilExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95EstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95EstadoCivil), 4, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV173estadoCivilExiste", AV173estadoCivilExiste);
      GXv_int42[0] = (short)(0) ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV172discapacidadExiste ;
      new web.traducirsinoanum(remoteHandle, context).execute( AV7CliCod, A598MigrLegDiscapacidad, httpContext.getMessage( "Discapacidad", ""), GXv_int42, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV172discapacidadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV172discapacidadExiste", AV172discapacidadExiste);
      GXv_int39[0] = AV98FormaDePago ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV167formadepagoExiste ;
      new web.traducirformapago(remoteHandle, context).execute( AV7CliCod, A609MigrLegFormaPago, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      migrlegupd_impl.this.AV98FormaDePago = GXv_int39[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV167formadepagoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98FormaDePago", GXutil.str( AV98FormaDePago, 1, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV167formadepagoExiste", AV167formadepagoExiste);
      GXv_boolean36[0] = false ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean35[0] = AV171scvoExiste ;
      new web.traducirsinoaboolean(remoteHandle, context).execute( AV7CliCod, A622MigrLegSCVO, httpContext.getMessage( "SCVO", ""), GXv_boolean36, GXv_objcol_svchar32, GXv_char24, GXv_boolean35) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV171scvoExiste = GXv_boolean35[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV171scvoExiste", AV171scvoExiste);
      GXv_boolean36[0] = false ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean35[0] = AV170tieneConyugeExiste ;
      new web.traducirsinoaboolean(remoteHandle, context).execute( AV7CliCod, A631MigrTieneConyuge, httpContext.getMessage( "Tiene Conyuge", ""), GXv_boolean36, GXv_objcol_svchar32, GXv_char24, GXv_boolean35) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV170tieneConyugeExiste = GXv_boolean35[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV170tieneConyugeExiste", AV170tieneConyugeExiste);
      GXv_char24[0] = AV111tipoCuentaBanco ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char23[0] = "" ;
      GXv_boolean36[0] = AV169tipocuentaExiste ;
      new web.traducirtipocuentabanco(remoteHandle, context).execute( AV7CliCod, A612MigrLegBanTipCuen, GXv_char24, GXv_objcol_svchar32, GXv_char23, GXv_boolean36) ;
      migrlegupd_impl.this.AV111tipoCuentaBanco = GXv_char24[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      migrlegupd_impl.this.AV169tipocuentaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV111tipoCuentaBanco", AV111tipoCuentaBanco);
      httpContext.ajax_rsp_assign_attri("", false, "AV169tipocuentaExiste", AV169tipocuentaExiste);
      GXt_decimal45 = AV154CatBasico ;
      GXv_decimal46[0] = GXt_decimal45 ;
      new web.getcatbasico(remoteHandle, context).execute( AV7CliCod, A627MigrLegConvenio, AV156CatCodigo, GXutil.serverDate( context, remoteHandle, pr_default), GXv_decimal46) ;
      migrlegupd_impl.this.GXt_decimal45 = GXv_decimal46[0] ;
      AV154CatBasico = GXt_decimal45 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV154CatBasico", GXutil.ltrimstr( AV154CatBasico, 14, 2));
      if ( ! (GXutil.strcmp("", A595MigrLegSexo)==0) && ! AV168sexoExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV164sexoError), 1, "MIGRLEGSEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSexo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A625MigrLegSiniestrado)==0) && ! AV157siniestradoExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGSINIESTRADO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSiniestrado_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A616MigrLegActividad)==0) && ! AV159actividadExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGACTIVIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegActividad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A617MigrLegModalidad)==0) && ! AV160ModalidadExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGMODALIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegModalidad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A620MigrLegZona)==0) && ! AV161ZonaExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGZONA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegZona_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A623MigrLegSituacionRevista)==0) && ! AV162SituacionExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGSITUACIONREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSituacionRevista_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A624MigrLegCondicion)==0) && ! AV163CondicionExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV158mensaje), 1, "MIGRLEGCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCondicion_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A596MigrLegEstadoCivil)==0) && ! AV173estadoCivilExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV73estadocivilError), 1, "MIGRLEGESTADOCIVIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegEstadoCivil_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A598MigrLegDiscapacidad)==0) && ! AV172discapacidadExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV74discapacidadError), 1, "MIGRLEGDISCAPACIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegDiscapacidad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A609MigrLegFormaPago)==0) && ! AV167formadepagoExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV76formadepagoError), 1, "MIGRLEGFORMAPAGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFormaPago_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A622MigrLegSCVO)==0) && ! AV171scvoExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV77scvoError), 1, "MIGRLEGSCVO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSCVO_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A631MigrTieneConyuge)==0) && ! AV170tieneConyugeExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV103tieneconyugeError), 1, "MIGRTIENECONYUGE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrTieneConyuge_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A612MigrLegBanTipCuen)==0) && ! AV169tipocuentaExiste )
      {
         httpContext.GX_msglist.addItem(new web.sacarformato(remoteHandle, context).executeUdp( AV166tipocuentaError), 1, "MIGRLEGBANTIPCUEN");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegBanTipCuen_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void beforeDelete2875( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2875( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2875( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2875( )
   {
      edtMigrLegId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegId_Enabled), 5, 0), true);
      edtMigrLegCUIL_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCUIL_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCUIL_Enabled), 5, 0), true);
      edtMigrLegApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegApellido_Enabled), 5, 0), true);
      edtMigrLegNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNombre_Enabled), 5, 0), true);
      cmbMigrLegModTra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegModTra.getEnabled(), 5, 0), true);
      cmbMigrLegTipoTarifa.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegTipoTarifa.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegTipoTarifa.getEnabled(), 5, 0), true);
      cmbMigrLegClase.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegClase.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegClase.getEnabled(), 5, 0), true);
      edtMigrLegFecNac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecNac_Enabled), 5, 0), true);
      edtMigrLegFecIngreso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecIngreso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecIngreso_Enabled), 5, 0), true);
      edtMigrLegSexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSexo_Enabled), 5, 0), true);
      edtMigrLegDomici_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDomici_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDomici_Enabled), 5, 0), true);
      edtMigrLegCodPos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCodPos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCodPos_Enabled), 5, 0), true);
      edtMigrLegTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegTelefono_Enabled), 5, 0), true);
      edtMigrLegEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEmail_Enabled), 5, 0), true);
      edtMigrLegEstadoCivil_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEstadoCivil_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEstadoCivil_Enabled), 5, 0), true);
      edtMigrLegArea_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegArea_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegArea_Enabled), 5, 0), true);
      edtMigrLegSindicato_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSindicato_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSindicato_Enabled), 5, 0), true);
      edtMigrLegConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegConvenio_Enabled), 5, 0), true);
      edtMigrLegCategoria_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCategoria_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCategoria_Enabled), 5, 0), true);
      edtMigrLegBanco_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanco_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanco_Enabled), 5, 0), true);
      edtMigrLegBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBasico_Enabled), 5, 0), true);
      edtMigrLegObraSocial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObraSocial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObraSocial_Enabled), 5, 0), true);
      edtMigrLegCBU_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCBU_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCBU_Enabled), 5, 0), true);
      edtMigrLegModalidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegModalidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegModalidad_Enabled), 5, 0), true);
      edtMigrLegHorSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegHorSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegHorSem_Enabled), 5, 0), true);
      edtMigrLegZona_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegZona_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegZona_Enabled), 5, 0), true);
      edtMigrLegActividad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegActividad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegActividad_Enabled), 5, 0), true);
      edtMigrLegCondicion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCondicion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCondicion_Enabled), 5, 0), true);
      edtMigrLegActLabClas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegActLabClas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegActLabClas_Enabled), 5, 0), true);
      edtMigrLegPueAfip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegPueAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPueAfip_Enabled), 5, 0), true);
      edtMigrLegObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObs_Enabled), 5, 0), true);
      edtavCombomigrlegsexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsexo_Enabled), 5, 0), true);
      edtavCombomigrlegestadocivil_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegestadocivil_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegestadocivil_Enabled), 5, 0), true);
      edtavCombomigrlegarea_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegarea_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegarea_Enabled), 5, 0), true);
      edtavCombomigrlegsindicato_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegsindicato_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegsindicato_Enabled), 5, 0), true);
      edtavCombomigrlegconvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegconvenio_Enabled), 5, 0), true);
      edtavCombomigrlegcategoria_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcategoria_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcategoria_Enabled), 5, 0), true);
      edtavCombomigrlegbanco_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegbanco_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegbanco_Enabled), 5, 0), true);
      edtavCombomigrlegobrasocial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegobrasocial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegobrasocial_Enabled), 5, 0), true);
      edtavCombomigrlegmodalidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegmodalidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegmodalidad_Enabled), 5, 0), true);
      edtavCombomigrlegzona_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegzona_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegzona_Enabled), 5, 0), true);
      edtavCombomigrlegactividad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegactividad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegactividad_Enabled), 5, 0), true);
      edtavCombomigrlegcondicion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegcondicion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegcondicion_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtMigrLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      edtMigrLegDiscapacidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDiscapacidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDiscapacidad_Enabled), 5, 0), true);
      edtMigrLegOSAfip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      edtMigrLegLugarDePago_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegLugarDePago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegLugarDePago_Enabled), 5, 0), true);
      edtMigrLegBanSuc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanSuc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanSuc_Enabled), 5, 0), true);
      edtMigrLegBanTipCuen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanTipCuen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanTipCuen_Enabled), 5, 0), true);
      edtMigrLegCuentaBanc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCuentaBanc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCuentaBanc_Enabled), 5, 0), true);
      edtMigrLegFormaPago_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFormaPago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFormaPago_Enabled), 5, 0), true);
      edtMigrLegSituacionRevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSituacionRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSituacionRevista_Enabled), 5, 0), true);
      edtMigrLegSiniestrado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSiniestrado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSiniestrado_Enabled), 5, 0), true);
      edtMigrLegSCVO_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSCVO_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSCVO_Enabled), 5, 0), true);
      edtMigrLegPlanMedico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegPlanMedico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPlanMedico_Enabled), 5, 0), true);
      edtMigrTieneConyuge_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrTieneConyuge_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrTieneConyuge_Enabled), 5, 0), true);
      edtMigrCantidadHijos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrCantidadHijos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrCantidadHijos_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2875( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues280( )
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.migrlegupd", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV40MigrLegNumero,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"MigrLegUPD");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
      forbiddenHiddens.add("MigrEncontroOsoSigla", GXutil.booltostr( A635MigrEncontroOsoSigla));
      forbiddenHiddens.add("MigrLegAreaDef", GXutil.booltostr( A689MigrLegAreaDef));
      forbiddenHiddens.add("MigrLegEstadoCivilDef", GXutil.booltostr( A690MigrLegEstadoCivilDef));
      forbiddenHiddens.add("MigrLegClaseDef", GXutil.booltostr( A691MigrLegClaseDef));
      forbiddenHiddens.add("MigrLegFormaPagoDef", GXutil.booltostr( A692MigrLegFormaPagoDef));
      forbiddenHiddens.add("MigrLegTipoCuentaDef", GXutil.booltostr( A693MigrLegTipoCuentaDef));
      forbiddenHiddens.add("MigrLegActividadDef", GXutil.booltostr( A694MigrLegActividadDef));
      forbiddenHiddens.add("MigrLegModalidadDef", GXutil.booltostr( A695MigrLegModalidadDef));
      forbiddenHiddens.add("MigrLegZonaDef", GXutil.booltostr( A696MigrLegZonaDef));
      forbiddenHiddens.add("MigrLegSCVODef", GXutil.booltostr( A697MigrLegSCVODef));
      forbiddenHiddens.add("MigrLegSituacionDef", GXutil.booltostr( A698MigrLegSituacionDef));
      forbiddenHiddens.add("MigrLegCondicionDef", GXutil.booltostr( A699MigrLegCondicionDef));
      forbiddenHiddens.add("MigrLegSiniestradoDef", GXutil.booltostr( A700MigrLegSiniestradoDef));
      forbiddenHiddens.add("MigrPuesto", GXutil.rtrim( localUtil.format( A2216MigrPuesto, "")));
      forbiddenHiddens.add("MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("migrlegupd:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z87MigrLegNumero", GXutil.ltrim( localUtil.ntoc( Z87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z595MigrLegSexo", GXutil.rtrim( Z595MigrLegSexo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z596MigrLegEstadoCivil", Z596MigrLegEstadoCivil);
      web.GxWebStd.gx_hidden_field( httpContext, "Z605MigrLegArea", Z605MigrLegArea);
      web.GxWebStd.gx_hidden_field( httpContext, "Z613MigrLegSindicato", Z613MigrLegSindicato);
      web.GxWebStd.gx_hidden_field( httpContext, "Z627MigrLegConvenio", Z627MigrLegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "Z604MigrLegCategoria", Z604MigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "Z610MigrLegBanco", Z610MigrLegBanco);
      web.GxWebStd.gx_hidden_field( httpContext, "Z614MigrLegObraSocial", Z614MigrLegObraSocial);
      web.GxWebStd.gx_hidden_field( httpContext, "Z617MigrLegModalidad", Z617MigrLegModalidad);
      web.GxWebStd.gx_hidden_field( httpContext, "Z620MigrLegZona", Z620MigrLegZona);
      web.GxWebStd.gx_hidden_field( httpContext, "Z616MigrLegActividad", Z616MigrLegActividad);
      web.GxWebStd.gx_hidden_field( httpContext, "Z624MigrLegCondicion", Z624MigrLegCondicion);
      web.GxWebStd.gx_hidden_field( httpContext, "Z592MigrLegApellido", Z592MigrLegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "Z593MigrLegNombre", Z593MigrLegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z594MigrLegFecNac", localUtil.dtoc( Z594MigrLegFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z597MigrLegCUIL", GXutil.rtrim( Z597MigrLegCUIL));
      web.GxWebStd.gx_hidden_field( httpContext, "Z598MigrLegDiscapacidad", GXutil.rtrim( Z598MigrLegDiscapacidad));
      web.GxWebStd.gx_hidden_field( httpContext, "Z599MigrLegDomici", Z599MigrLegDomici);
      web.GxWebStd.gx_hidden_field( httpContext, "Z600MigrLegEmail", Z600MigrLegEmail);
      web.GxWebStd.gx_hidden_field( httpContext, "Z601MigrLegCodPos", Z601MigrLegCodPos);
      web.GxWebStd.gx_hidden_field( httpContext, "Z602MigrLegTelefono", Z602MigrLegTelefono);
      web.GxWebStd.gx_hidden_field( httpContext, "Z603MigrLegFecIngreso", localUtil.dtoc( Z603MigrLegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z606MigrLegLugarDePago", Z606MigrLegLugarDePago);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2415MigrLegModTra", Z2415MigrLegModTra);
      web.GxWebStd.gx_hidden_field( httpContext, "Z607MigrLegClase", Z607MigrLegClase);
      web.GxWebStd.gx_hidden_field( httpContext, "Z608MigrLegBasico", GXutil.ltrim( localUtil.ntoc( Z608MigrLegBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z609MigrLegFormaPago", Z609MigrLegFormaPago);
      web.GxWebStd.gx_hidden_field( httpContext, "Z611MigrLegBanSuc", Z611MigrLegBanSuc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z612MigrLegBanTipCuen", Z612MigrLegBanTipCuen);
      web.GxWebStd.gx_hidden_field( httpContext, "Z634MigrLegOSAfip", GXutil.rtrim( Z634MigrLegOSAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "Z615MigrLegPlanMedico", Z615MigrLegPlanMedico);
      web.GxWebStd.gx_hidden_field( httpContext, "Z618MigrLegFecUltMod", localUtil.dtoc( Z618MigrLegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z619MigrLegCuentaBanc", Z619MigrLegCuentaBanc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z621MigrLegCBU", Z621MigrLegCBU);
      web.GxWebStd.gx_hidden_field( httpContext, "Z622MigrLegSCVO", GXutil.rtrim( Z622MigrLegSCVO));
      web.GxWebStd.gx_hidden_field( httpContext, "Z623MigrLegSituacionRevista", Z623MigrLegSituacionRevista);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2239MigrLegActLabClas", Z2239MigrLegActLabClas);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2240MigrLegPueAfip", Z2240MigrLegPueAfip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z625MigrLegSiniestrado", Z625MigrLegSiniestrado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z626MigrLegId", GXutil.rtrim( Z626MigrLegId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z631MigrTieneConyuge", GXutil.rtrim( Z631MigrTieneConyuge));
      web.GxWebStd.gx_hidden_field( httpContext, "Z632MigrCantidadHijos", GXutil.ltrim( localUtil.ntoc( Z632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z635MigrEncontroOsoSigla", Z635MigrEncontroOsoSigla);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z689MigrLegAreaDef", Z689MigrLegAreaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z690MigrLegEstadoCivilDef", Z690MigrLegEstadoCivilDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z691MigrLegClaseDef", Z691MigrLegClaseDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z692MigrLegFormaPagoDef", Z692MigrLegFormaPagoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z693MigrLegTipoCuentaDef", Z693MigrLegTipoCuentaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z694MigrLegActividadDef", Z694MigrLegActividadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z695MigrLegModalidadDef", Z695MigrLegModalidadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z696MigrLegZonaDef", Z696MigrLegZonaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z697MigrLegSCVODef", Z697MigrLegSCVODef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z698MigrLegSituacionDef", Z698MigrLegSituacionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z699MigrLegCondicionDef", Z699MigrLegCondicionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z700MigrLegSiniestradoDef", Z700MigrLegSiniestradoDef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2216MigrPuesto", Z2216MigrPuesto);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2205MigrLegFecEgreso", localUtil.dtoc( Z2205MigrLegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2275MigrLegHorSem", GXutil.ltrim( localUtil.ntoc( Z2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2427MigrLegTipoTarifa", Z2427MigrLegTipoTarifa);
      web.GxWebStd.gx_hidden_field( httpContext, "O634MigrLegOSAfip", GXutil.rtrim( O634MigrLegOSAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N634MigrLegOSAfip", GXutil.rtrim( A634MigrLegOSAfip));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGSEXO_DATA", AV189MigrLegSexo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGSEXO_DATA", AV189MigrLegSexo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGESTADOCIVIL_DATA", AV191MigrLegEstadoCivil_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGESTADOCIVIL_DATA", AV191MigrLegEstadoCivil_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGAREA_DATA", AV26MigrLegArea_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGAREA_DATA", AV26MigrLegArea_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGSINDICATO_DATA", AV133MigrLegSindicato_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGSINDICATO_DATA", AV133MigrLegSindicato_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGCONVENIO_DATA", AV135MigrLegConvenio_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGCONVENIO_DATA", AV135MigrLegConvenio_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGCATEGORIA_DATA", AV126MigrLegCategoria_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGCATEGORIA_DATA", AV126MigrLegCategoria_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGBANCO_DATA", AV139MigrLegBanco_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGBANCO_DATA", AV139MigrLegBanco_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGOBRASOCIAL_DATA", AV131MigrLegObraSocial_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGOBRASOCIAL_DATA", AV131MigrLegObraSocial_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGMODALIDAD_DATA", AV141MigrLegModalidad_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGMODALIDAD_DATA", AV141MigrLegModalidad_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGZONA_DATA", AV129MigrLegZona_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGZONA_DATA", AV129MigrLegZona_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGACTIVIDAD_DATA", AV143MigrLegActividad_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGACTIVIDAD_DATA", AV143MigrLegActividad_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGCONDICION_DATA", AV147MigrLegCondicion_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGCONDICION_DATA", AV147MigrLegCondicion_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGCONVENIO", AV34MigrLegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV34MigrLegConvenio, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vERRORES", AV68errores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vERRORES", AV68errores);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vWARNINGS", AV69warnings);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vWARNINGS", AV69warnings);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGZONA", AV51MigrLegZona);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGZONA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51MigrLegZona, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGCATEGORIA", AV30MigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCATEGORIA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30MigrLegCategoria, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV40MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV40MigrLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXMIGRLEGCATEGORIA", AV64AuxMigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "vSINESTEXTO", AV176sinesTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "vMENSAJE", AV158mensaje);
      web.GxWebStd.gx_hidden_field( httpContext, "vACTTEXTO", AV177actTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "vMODTEXTO", AV178modTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "vTEXTO", AV175texto);
      web.GxWebStd.gx_hidden_field( httpContext, "vSITREVTEXTO", AV179sitRevTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "vCONDTEXTO", AV180condTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "vSEXOERROR", AV164sexoError);
      web.GxWebStd.gx_hidden_field( httpContext, "vESTADOCIVILERROR", AV73estadocivilError);
      web.GxWebStd.gx_hidden_field( httpContext, "vDISCAPACIDADERROR", AV74discapacidadError);
      web.GxWebStd.gx_hidden_field( httpContext, "vFORMADEPAGOERROR", AV76formadepagoError);
      web.GxWebStd.gx_hidden_field( httpContext, "vSCVOERROR", AV77scvoError);
      web.GxWebStd.gx_hidden_field( httpContext, "vTIENECONYUGEERROR", AV103tieneconyugeError);
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOCUENTAERROR", AV166tipocuentaError);
      web.GxWebStd.gx_hidden_field( httpContext, "vCATCODIGO", GXutil.rtrim( AV156CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATBASICO", GXutil.ltrim( localUtil.ntoc( AV154CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMEROPORID", GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNOMAPE", AV62LegNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMEROPORCUIL", GXutil.ltrim( localUtil.ntoc( AV66LegNumeroPorCUIL, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGIDNOMAPE", AV63LegIdNomApe);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCATEGORIAEXISTE", AV155categoriaExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSINIESTRADOEXISTE", AV157siniestradoExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vACTIVIDADEXISTE", AV159actividadExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vMODALIDADEXISTE", AV160ModalidadExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vZONAEXISTE", AV161ZonaExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSITUACIONEXISTE", AV162SituacionExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCONDICIONEXISTE", AV163CondicionExiste);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDUMMYERRORES", AV104dummyErrores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDUMMYERRORES", AV104dummyErrores);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSEXOEXISTE", AV168sexoExiste);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLASELEG", GXutil.ltrim( localUtil.ntoc( AV92ClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vESTADOCIVIL", GXutil.ltrim( localUtil.ntoc( AV95EstadoCivil, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESTADOCIVILEXISTE", AV173estadoCivilExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDISCAPACIDADEXISTE", AV172discapacidadExiste);
      web.GxWebStd.gx_hidden_field( httpContext, "vFORMADEPAGO", GXutil.ltrim( localUtil.ntoc( AV98FormaDePago, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vFORMADEPAGOEXISTE", AV167formadepagoExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSCVOEXISTE", AV171scvoExiste);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vTIENECONYUGEEXISTE", AV170tieneConyugeExiste);
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOCUENTABANCO", GXutil.rtrim( AV111tipoCuentaBanco));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vTIPOCUENTAEXISTE", AV169tipocuentaExiste);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFECULTMOD", localUtil.dtoc( A618MigrLegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGERRORES", A629MigrLegErrores);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGWARNINGS", A633MigrLegWarnings);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRENCONTROOSOSIGLA", A635MigrEncontroOsoSigla);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGAREADEF", A689MigrLegAreaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGESTADOCIVILDEF", A690MigrLegEstadoCivilDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGCLASEDEF", A691MigrLegClaseDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGFORMAPAGODEF", A692MigrLegFormaPagoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGTIPOCUENTADEF", A693MigrLegTipoCuentaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGACTIVIDADDEF", A694MigrLegActividadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGMODALIDADDEF", A695MigrLegModalidadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGZONADEF", A696MigrLegZonaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGSCVODEF", A697MigrLegSCVODef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGSITUACIONDEF", A698MigrLegSituacionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGCONDICIONDEF", A699MigrLegCondicionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGSINIESTRADODEF", A700MigrLegSiniestradoDef);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRPUESTO", A2216MigrPuesto);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFECEGRESO", localUtil.dtoc( A2205MigrLegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGROTROSDATOS", A2206MigrOtrosDatos);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV203Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSEXO_Objectcall", GXutil.rtrim( Combo_migrlegsexo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSEXO_Cls", GXutil.rtrim( Combo_migrlegsexo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSEXO_Selectedvalue_set", GXutil.rtrim( Combo_migrlegsexo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSEXO_Enabled", GXutil.booltostr( Combo_migrlegsexo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSEXO_Emptyitem", GXutil.booltostr( Combo_migrlegsexo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGESTADOCIVIL_Objectcall", GXutil.rtrim( Combo_migrlegestadocivil_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGESTADOCIVIL_Cls", GXutil.rtrim( Combo_migrlegestadocivil_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGESTADOCIVIL_Selectedvalue_set", GXutil.rtrim( Combo_migrlegestadocivil_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGESTADOCIVIL_Enabled", GXutil.booltostr( Combo_migrlegestadocivil_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGESTADOCIVIL_Emptyitem", GXutil.booltostr( Combo_migrlegestadocivil_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGAREA_Objectcall", GXutil.rtrim( Combo_migrlegarea_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGAREA_Cls", GXutil.rtrim( Combo_migrlegarea_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGAREA_Selectedvalue_set", GXutil.rtrim( Combo_migrlegarea_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGAREA_Enabled", GXutil.booltostr( Combo_migrlegarea_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGAREA_Emptyitem", GXutil.booltostr( Combo_migrlegarea_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSINDICATO_Objectcall", GXutil.rtrim( Combo_migrlegsindicato_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSINDICATO_Cls", GXutil.rtrim( Combo_migrlegsindicato_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSINDICATO_Selectedvalue_set", GXutil.rtrim( Combo_migrlegsindicato_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSINDICATO_Enabled", GXutil.booltostr( Combo_migrlegsindicato_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGSINDICATO_Emptyitem", GXutil.booltostr( Combo_migrlegsindicato_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONVENIO_Objectcall", GXutil.rtrim( Combo_migrlegconvenio_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONVENIO_Cls", GXutil.rtrim( Combo_migrlegconvenio_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONVENIO_Selectedvalue_set", GXutil.rtrim( Combo_migrlegconvenio_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONVENIO_Enabled", GXutil.booltostr( Combo_migrlegconvenio_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONVENIO_Emptyitem", GXutil.booltostr( Combo_migrlegconvenio_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCATEGORIA_Objectcall", GXutil.rtrim( Combo_migrlegcategoria_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCATEGORIA_Cls", GXutil.rtrim( Combo_migrlegcategoria_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCATEGORIA_Selectedvalue_set", GXutil.rtrim( Combo_migrlegcategoria_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCATEGORIA_Enabled", GXutil.booltostr( Combo_migrlegcategoria_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCATEGORIA_Emptyitem", GXutil.booltostr( Combo_migrlegcategoria_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGBANCO_Objectcall", GXutil.rtrim( Combo_migrlegbanco_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGBANCO_Cls", GXutil.rtrim( Combo_migrlegbanco_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGBANCO_Selectedvalue_set", GXutil.rtrim( Combo_migrlegbanco_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGBANCO_Enabled", GXutil.booltostr( Combo_migrlegbanco_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGBANCO_Emptyitem", GXutil.booltostr( Combo_migrlegbanco_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGOBRASOCIAL_Objectcall", GXutil.rtrim( Combo_migrlegobrasocial_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGOBRASOCIAL_Cls", GXutil.rtrim( Combo_migrlegobrasocial_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGOBRASOCIAL_Selectedvalue_set", GXutil.rtrim( Combo_migrlegobrasocial_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGOBRASOCIAL_Enabled", GXutil.booltostr( Combo_migrlegobrasocial_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGOBRASOCIAL_Emptyitem", GXutil.booltostr( Combo_migrlegobrasocial_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGMODALIDAD_Objectcall", GXutil.rtrim( Combo_migrlegmodalidad_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGMODALIDAD_Cls", GXutil.rtrim( Combo_migrlegmodalidad_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGMODALIDAD_Selectedvalue_set", GXutil.rtrim( Combo_migrlegmodalidad_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGMODALIDAD_Enabled", GXutil.booltostr( Combo_migrlegmodalidad_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGMODALIDAD_Emptyitem", GXutil.booltostr( Combo_migrlegmodalidad_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGZONA_Objectcall", GXutil.rtrim( Combo_migrlegzona_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGZONA_Cls", GXutil.rtrim( Combo_migrlegzona_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGZONA_Selectedvalue_set", GXutil.rtrim( Combo_migrlegzona_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGZONA_Enabled", GXutil.booltostr( Combo_migrlegzona_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGZONA_Emptyitem", GXutil.booltostr( Combo_migrlegzona_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGACTIVIDAD_Objectcall", GXutil.rtrim( Combo_migrlegactividad_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGACTIVIDAD_Cls", GXutil.rtrim( Combo_migrlegactividad_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGACTIVIDAD_Selectedvalue_set", GXutil.rtrim( Combo_migrlegactividad_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGACTIVIDAD_Enabled", GXutil.booltostr( Combo_migrlegactividad_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGACTIVIDAD_Emptyitem", GXutil.booltostr( Combo_migrlegactividad_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONDICION_Objectcall", GXutil.rtrim( Combo_migrlegcondicion_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONDICION_Cls", GXutil.rtrim( Combo_migrlegcondicion_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONDICION_Selectedvalue_set", GXutil.rtrim( Combo_migrlegcondicion_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONDICION_Enabled", GXutil.booltostr( Combo_migrlegcondicion_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGCONDICION_Emptyitem", GXutil.booltostr( Combo_migrlegcondicion_Emptyitem));
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
      if ( ! ( WebComp_Wcimportarlegajofamilia == null ) )
      {
         WebComp_Wcimportarlegajofamilia.componentjscripts();
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
            {
               WebComp_Wcimportarlegajofamilia.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
            {
               WebComp_Wcimportarlegajofamilia.componentstart();
            }
         }
      }
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
      return formatLink("web.migrlegupd", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV40MigrLegNumero,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "MigrLegUPD" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importación de Legajos", "") ;
   }

   public void initializeNonKey2875( )
   {
      A595MigrLegSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
      A596MigrLegEstadoCivil = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
      A605MigrLegArea = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
      A613MigrLegSindicato = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
      A627MigrLegConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
      A604MigrLegCategoria = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
      A610MigrLegBanco = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
      A614MigrLegObraSocial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
      A617MigrLegModalidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
      A620MigrLegZona = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
      A616MigrLegActividad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
      A624MigrLegCondicion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
      AV64AuxMigrLegCategoria = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      AV65LegNumeroPorId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      AV62LegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      AV66LegNumeroPorCUIL = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      AV63LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      AV156CatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV156CatCodigo", AV156CatCodigo);
      AV155categoriaExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV155categoriaExiste", AV155categoriaExiste);
      AV176sinesTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
      AV158mensaje = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
      AV177actTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
      AV178modTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
      AV175texto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
      AV179sitRevTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
      AV180condTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
      AV104dummyErrores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV168sexoExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV168sexoExiste", AV168sexoExiste);
      AV164sexoError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV164sexoError", AV164sexoError);
      AV73estadocivilError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73estadocivilError", AV73estadocivilError);
      AV74discapacidadError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74discapacidadError", AV74discapacidadError);
      AV76formadepagoError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76formadepagoError", AV76formadepagoError);
      AV77scvoError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77scvoError", AV77scvoError);
      AV103tieneconyugeError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV103tieneconyugeError", AV103tieneconyugeError);
      AV166tipocuentaError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV166tipocuentaError", AV166tipocuentaError);
      A592MigrLegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      A593MigrLegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      A594MigrLegFecNac = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
      A597MigrLegCUIL = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
      A598MigrLegDiscapacidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
      A599MigrLegDomici = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
      A600MigrLegEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
      A601MigrLegCodPos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
      A602MigrLegTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
      A606MigrLegLugarDePago = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
      A2415MigrLegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
      A607MigrLegClase = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
      A608MigrLegBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
      A609MigrLegFormaPago = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
      A611MigrLegBanSuc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
      A612MigrLegBanTipCuen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
      A634MigrLegOSAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
      A615MigrLegPlanMedico = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A618MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
      A619MigrLegCuentaBanc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
      A621MigrLegCBU = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
      A622MigrLegSCVO = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
      A623MigrLegSituacionRevista = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
      A2239MigrLegActLabClas = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
      A2240MigrLegPueAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
      A625MigrLegSiniestrado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
      A626MigrLegId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
      A628MigrLegObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
      A629MigrLegErrores = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A629MigrLegErrores", A629MigrLegErrores);
      A633MigrLegWarnings = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A633MigrLegWarnings", A633MigrLegWarnings);
      A631MigrTieneConyuge = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
      A632MigrCantidadHijos = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
      A635MigrEncontroOsoSigla = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A635MigrEncontroOsoSigla", A635MigrEncontroOsoSigla);
      A689MigrLegAreaDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A689MigrLegAreaDef", A689MigrLegAreaDef);
      A690MigrLegEstadoCivilDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A690MigrLegEstadoCivilDef", A690MigrLegEstadoCivilDef);
      A691MigrLegClaseDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A691MigrLegClaseDef", A691MigrLegClaseDef);
      A692MigrLegFormaPagoDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A692MigrLegFormaPagoDef", A692MigrLegFormaPagoDef);
      A693MigrLegTipoCuentaDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A693MigrLegTipoCuentaDef", A693MigrLegTipoCuentaDef);
      A694MigrLegActividadDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A694MigrLegActividadDef", A694MigrLegActividadDef);
      A695MigrLegModalidadDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A695MigrLegModalidadDef", A695MigrLegModalidadDef);
      A696MigrLegZonaDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A696MigrLegZonaDef", A696MigrLegZonaDef);
      A697MigrLegSCVODef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A697MigrLegSCVODef", A697MigrLegSCVODef);
      A698MigrLegSituacionDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A698MigrLegSituacionDef", A698MigrLegSituacionDef);
      A699MigrLegCondicionDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A699MigrLegCondicionDef", A699MigrLegCondicionDef);
      A700MigrLegSiniestradoDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A700MigrLegSiniestradoDef", A700MigrLegSiniestradoDef);
      A2216MigrPuesto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2216MigrPuesto", A2216MigrPuesto);
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2205MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
      A2206MigrOtrosDatos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2206MigrOtrosDatos", A2206MigrOtrosDatos);
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
      A2427MigrLegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
      AV154CatBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV154CatBasico", GXutil.ltrimstr( AV154CatBasico, 14, 2));
      AV157siniestradoExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV157siniestradoExiste", AV157siniestradoExiste);
      AV159actividadExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV159actividadExiste", AV159actividadExiste);
      AV160ModalidadExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV160ModalidadExiste", AV160ModalidadExiste);
      AV161ZonaExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV161ZonaExiste", AV161ZonaExiste);
      AV162SituacionExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV162SituacionExiste", AV162SituacionExiste);
      AV163CondicionExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV163CondicionExiste", AV163CondicionExiste);
      AV92ClaseLeg = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92ClaseLeg", GXutil.str( AV92ClaseLeg, 1, 0));
      AV95EstadoCivil = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95EstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95EstadoCivil), 4, 0));
      AV173estadoCivilExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV173estadoCivilExiste", AV173estadoCivilExiste);
      AV172discapacidadExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV172discapacidadExiste", AV172discapacidadExiste);
      AV98FormaDePago = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98FormaDePago", GXutil.str( AV98FormaDePago, 1, 0));
      AV167formadepagoExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV167formadepagoExiste", AV167formadepagoExiste);
      AV171scvoExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV171scvoExiste", AV171scvoExiste);
      AV170tieneConyugeExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV170tieneConyugeExiste", AV170tieneConyugeExiste);
      AV111tipoCuentaBanco = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV111tipoCuentaBanco", AV111tipoCuentaBanco);
      AV169tipocuentaExiste = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV169tipocuentaExiste", AV169tipocuentaExiste);
      O634MigrLegOSAfip = A634MigrLegOSAfip ;
      httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
      Z595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      Z605MigrLegArea = "" ;
      Z613MigrLegSindicato = "" ;
      Z627MigrLegConvenio = "" ;
      Z604MigrLegCategoria = "" ;
      Z610MigrLegBanco = "" ;
      Z614MigrLegObraSocial = "" ;
      Z617MigrLegModalidad = "" ;
      Z620MigrLegZona = "" ;
      Z616MigrLegActividad = "" ;
      Z624MigrLegCondicion = "" ;
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      Z597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      Z606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      Z607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      Z611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      Z634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      Z621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      Z2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      Z625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      Z631MigrTieneConyuge = "" ;
      Z632MigrCantidadHijos = (short)(0) ;
      Z635MigrEncontroOsoSigla = false ;
      Z689MigrLegAreaDef = false ;
      Z690MigrLegEstadoCivilDef = false ;
      Z691MigrLegClaseDef = false ;
      Z692MigrLegFormaPagoDef = false ;
      Z693MigrLegTipoCuentaDef = false ;
      Z694MigrLegActividadDef = false ;
      Z695MigrLegModalidadDef = false ;
      Z696MigrLegZonaDef = false ;
      Z697MigrLegSCVODef = false ;
      Z698MigrLegSituacionDef = false ;
      Z699MigrLegCondicionDef = false ;
      Z700MigrLegSiniestradoDef = false ;
      Z2216MigrPuesto = "" ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
      Z2427MigrLegTipoTarifa = "" ;
   }

   public void initAll2875( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A87MigrLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      initializeNonKey2875( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wcimportarlegajofamilia == null ) )
      {
         if ( GXutil.len( WebComp_Wcimportarlegajofamilia_Component) != 0 )
         {
            WebComp_Wcimportarlegajofamilia.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713543112", true, true);
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
      httpContext.AddJavascriptSource("migrlegupd.js", "?20251713543112", false, true);
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
      edtMigrLegId_Internalname = "MIGRLEGID" ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL" ;
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO" ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE" ;
      lblTextblockmigrlegmodtra_Internalname = "TEXTBLOCKMIGRLEGMODTRA" ;
      cmbMigrLegModTra.setInternalname( "MIGRLEGMODTRA" );
      lblMigrlegmodtra_righttext_Internalname = "MIGRLEGMODTRA_RIGHTTEXT" ;
      tblTablemergedmigrlegmodtra_Internalname = "TABLEMERGEDMIGRLEGMODTRA" ;
      divTablesplittedmigrlegmodtra_Internalname = "TABLESPLITTEDMIGRLEGMODTRA" ;
      lblTextblockmigrlegtipotarifa_Internalname = "TEXTBLOCKMIGRLEGTIPOTARIFA" ;
      cmbMigrLegTipoTarifa.setInternalname( "MIGRLEGTIPOTARIFA" );
      lblMigrlegtipotarifa_righttext_Internalname = "MIGRLEGTIPOTARIFA_RIGHTTEXT" ;
      tblTablemergedmigrlegtipotarifa_Internalname = "TABLEMERGEDMIGRLEGTIPOTARIFA" ;
      divTablesplittedmigrlegtipotarifa_Internalname = "TABLESPLITTEDMIGRLEGTIPOTARIFA" ;
      lblTextblockmigrlegclase_Internalname = "TEXTBLOCKMIGRLEGCLASE" ;
      cmbMigrLegClase.setInternalname( "MIGRLEGCLASE" );
      lblMigrlegclase_righttext_Internalname = "MIGRLEGCLASE_RIGHTTEXT" ;
      tblTablemergedmigrlegclase_Internalname = "TABLEMERGEDMIGRLEGCLASE" ;
      divTablesplittedmigrlegclase_Internalname = "TABLESPLITTEDMIGRLEGCLASE" ;
      edtMigrLegFecNac_Internalname = "MIGRLEGFECNAC" ;
      edtMigrLegFecIngreso_Internalname = "MIGRLEGFECINGRESO" ;
      lblTextblockmigrlegsexo_Internalname = "TEXTBLOCKMIGRLEGSEXO" ;
      Combo_migrlegsexo_Internalname = "COMBO_MIGRLEGSEXO" ;
      edtMigrLegSexo_Internalname = "MIGRLEGSEXO" ;
      lblMigrlegsexo_righttext_Internalname = "MIGRLEGSEXO_RIGHTTEXT" ;
      tblTablemergedmigrlegsexo_Internalname = "TABLEMERGEDMIGRLEGSEXO" ;
      divTablesplittedmigrlegsexo_Internalname = "TABLESPLITTEDMIGRLEGSEXO" ;
      edtMigrLegDomici_Internalname = "MIGRLEGDOMICI" ;
      edtMigrLegCodPos_Internalname = "MIGRLEGCODPOS" ;
      edtMigrLegTelefono_Internalname = "MIGRLEGTELEFONO" ;
      edtMigrLegEmail_Internalname = "MIGRLEGEMAIL" ;
      lblTextblockmigrlegestadocivil_Internalname = "TEXTBLOCKMIGRLEGESTADOCIVIL" ;
      Combo_migrlegestadocivil_Internalname = "COMBO_MIGRLEGESTADOCIVIL" ;
      edtMigrLegEstadoCivil_Internalname = "MIGRLEGESTADOCIVIL" ;
      lblMigrlegestadocivil_righttext_Internalname = "MIGRLEGESTADOCIVIL_RIGHTTEXT" ;
      tblTablemergedmigrlegestadocivil_Internalname = "TABLEMERGEDMIGRLEGESTADOCIVIL" ;
      divTablesplittedmigrlegestadocivil_Internalname = "TABLESPLITTEDMIGRLEGESTADOCIVIL" ;
      lblTextblockmigrlegarea_Internalname = "TEXTBLOCKMIGRLEGAREA" ;
      Combo_migrlegarea_Internalname = "COMBO_MIGRLEGAREA" ;
      edtMigrLegArea_Internalname = "MIGRLEGAREA" ;
      lblMigrlegarea_righttext_Internalname = "MIGRLEGAREA_RIGHTTEXT" ;
      tblTablemergedmigrlegarea_Internalname = "TABLEMERGEDMIGRLEGAREA" ;
      divTablesplittedmigrlegarea_Internalname = "TABLESPLITTEDMIGRLEGAREA" ;
      lblTextblockmigrlegsindicato_Internalname = "TEXTBLOCKMIGRLEGSINDICATO" ;
      Combo_migrlegsindicato_Internalname = "COMBO_MIGRLEGSINDICATO" ;
      edtMigrLegSindicato_Internalname = "MIGRLEGSINDICATO" ;
      lblMigrlegsindicato_righttext_Internalname = "MIGRLEGSINDICATO_RIGHTTEXT" ;
      tblTablemergedmigrlegsindicato_Internalname = "TABLEMERGEDMIGRLEGSINDICATO" ;
      divTablesplittedmigrlegsindicato_Internalname = "TABLESPLITTEDMIGRLEGSINDICATO" ;
      lblTextblockmigrlegconvenio_Internalname = "TEXTBLOCKMIGRLEGCONVENIO" ;
      Combo_migrlegconvenio_Internalname = "COMBO_MIGRLEGCONVENIO" ;
      edtMigrLegConvenio_Internalname = "MIGRLEGCONVENIO" ;
      lblMigrlegconvenio_righttext_Internalname = "MIGRLEGCONVENIO_RIGHTTEXT" ;
      tblTablemergedmigrlegconvenio_Internalname = "TABLEMERGEDMIGRLEGCONVENIO" ;
      divTablesplittedmigrlegconvenio_Internalname = "TABLESPLITTEDMIGRLEGCONVENIO" ;
      lblTextblockmigrlegcategoria_Internalname = "TEXTBLOCKMIGRLEGCATEGORIA" ;
      Combo_migrlegcategoria_Internalname = "COMBO_MIGRLEGCATEGORIA" ;
      edtMigrLegCategoria_Internalname = "MIGRLEGCATEGORIA" ;
      lblMigrlegcategoria_righttext_Internalname = "MIGRLEGCATEGORIA_RIGHTTEXT" ;
      tblTablemergedmigrlegcategoria_Internalname = "TABLEMERGEDMIGRLEGCATEGORIA" ;
      divTablesplittedmigrlegcategoria_Internalname = "TABLESPLITTEDMIGRLEGCATEGORIA" ;
      lblTextblockmigrlegbanco_Internalname = "TEXTBLOCKMIGRLEGBANCO" ;
      Combo_migrlegbanco_Internalname = "COMBO_MIGRLEGBANCO" ;
      edtMigrLegBanco_Internalname = "MIGRLEGBANCO" ;
      lblMigrlegbanco_righttext_Internalname = "MIGRLEGBANCO_RIGHTTEXT" ;
      tblTablemergedmigrlegbanco_Internalname = "TABLEMERGEDMIGRLEGBANCO" ;
      divTablesplittedmigrlegbanco_Internalname = "TABLESPLITTEDMIGRLEGBANCO" ;
      edtMigrLegBasico_Internalname = "MIGRLEGBASICO" ;
      lblTextblockmigrlegobrasocial_Internalname = "TEXTBLOCKMIGRLEGOBRASOCIAL" ;
      Combo_migrlegobrasocial_Internalname = "COMBO_MIGRLEGOBRASOCIAL" ;
      edtMigrLegObraSocial_Internalname = "MIGRLEGOBRASOCIAL" ;
      lblMigrlegobrasocial_righttext_Internalname = "MIGRLEGOBRASOCIAL_RIGHTTEXT" ;
      tblTablemergedmigrlegobrasocial_Internalname = "TABLEMERGEDMIGRLEGOBRASOCIAL" ;
      divTablesplittedmigrlegobrasocial_Internalname = "TABLESPLITTEDMIGRLEGOBRASOCIAL" ;
      edtMigrLegCBU_Internalname = "MIGRLEGCBU" ;
      lblTextblockmigrlegmodalidad_Internalname = "TEXTBLOCKMIGRLEGMODALIDAD" ;
      Combo_migrlegmodalidad_Internalname = "COMBO_MIGRLEGMODALIDAD" ;
      edtMigrLegModalidad_Internalname = "MIGRLEGMODALIDAD" ;
      lblMigrlegmodalidad_righttext_Internalname = "MIGRLEGMODALIDAD_RIGHTTEXT" ;
      tblTablemergedmigrlegmodalidad_Internalname = "TABLEMERGEDMIGRLEGMODALIDAD" ;
      divTablesplittedmigrlegmodalidad_Internalname = "TABLESPLITTEDMIGRLEGMODALIDAD" ;
      edtMigrLegHorSem_Internalname = "MIGRLEGHORSEM" ;
      lblTextblockmigrlegzona_Internalname = "TEXTBLOCKMIGRLEGZONA" ;
      Combo_migrlegzona_Internalname = "COMBO_MIGRLEGZONA" ;
      edtMigrLegZona_Internalname = "MIGRLEGZONA" ;
      lblMigrlegzona_righttext_Internalname = "MIGRLEGZONA_RIGHTTEXT" ;
      tblTablemergedmigrlegzona_Internalname = "TABLEMERGEDMIGRLEGZONA" ;
      divTablesplittedmigrlegzona_Internalname = "TABLESPLITTEDMIGRLEGZONA" ;
      lblTextblockmigrlegactividad_Internalname = "TEXTBLOCKMIGRLEGACTIVIDAD" ;
      Combo_migrlegactividad_Internalname = "COMBO_MIGRLEGACTIVIDAD" ;
      edtMigrLegActividad_Internalname = "MIGRLEGACTIVIDAD" ;
      lblMigrlegactividad_righttext_Internalname = "MIGRLEGACTIVIDAD_RIGHTTEXT" ;
      tblTablemergedmigrlegactividad_Internalname = "TABLEMERGEDMIGRLEGACTIVIDAD" ;
      divTablesplittedmigrlegactividad_Internalname = "TABLESPLITTEDMIGRLEGACTIVIDAD" ;
      lblTextblockmigrlegcondicion_Internalname = "TEXTBLOCKMIGRLEGCONDICION" ;
      Combo_migrlegcondicion_Internalname = "COMBO_MIGRLEGCONDICION" ;
      edtMigrLegCondicion_Internalname = "MIGRLEGCONDICION" ;
      lblMigrlegcondicion_righttext_Internalname = "MIGRLEGCONDICION_RIGHTTEXT" ;
      tblTablemergedmigrlegcondicion_Internalname = "TABLEMERGEDMIGRLEGCONDICION" ;
      divTablesplittedmigrlegcondicion_Internalname = "TABLESPLITTEDMIGRLEGCONDICION" ;
      edtMigrLegActLabClas_Internalname = "MIGRLEGACTLABCLAS" ;
      edtMigrLegPueAfip_Internalname = "MIGRLEGPUEAFIP" ;
      edtMigrLegObs_Internalname = "MIGRLEGOBS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombomigrlegsexo_Internalname = "vCOMBOMIGRLEGSEXO" ;
      divSectionattribute_migrlegsexo_Internalname = "SECTIONATTRIBUTE_MIGRLEGSEXO" ;
      edtavCombomigrlegestadocivil_Internalname = "vCOMBOMIGRLEGESTADOCIVIL" ;
      divSectionattribute_migrlegestadocivil_Internalname = "SECTIONATTRIBUTE_MIGRLEGESTADOCIVIL" ;
      edtavCombomigrlegarea_Internalname = "vCOMBOMIGRLEGAREA" ;
      divSectionattribute_migrlegarea_Internalname = "SECTIONATTRIBUTE_MIGRLEGAREA" ;
      edtavCombomigrlegsindicato_Internalname = "vCOMBOMIGRLEGSINDICATO" ;
      divSectionattribute_migrlegsindicato_Internalname = "SECTIONATTRIBUTE_MIGRLEGSINDICATO" ;
      edtavCombomigrlegconvenio_Internalname = "vCOMBOMIGRLEGCONVENIO" ;
      divSectionattribute_migrlegconvenio_Internalname = "SECTIONATTRIBUTE_MIGRLEGCONVENIO" ;
      edtavCombomigrlegcategoria_Internalname = "vCOMBOMIGRLEGCATEGORIA" ;
      divSectionattribute_migrlegcategoria_Internalname = "SECTIONATTRIBUTE_MIGRLEGCATEGORIA" ;
      edtavCombomigrlegbanco_Internalname = "vCOMBOMIGRLEGBANCO" ;
      divSectionattribute_migrlegbanco_Internalname = "SECTIONATTRIBUTE_MIGRLEGBANCO" ;
      edtavCombomigrlegobrasocial_Internalname = "vCOMBOMIGRLEGOBRASOCIAL" ;
      divSectionattribute_migrlegobrasocial_Internalname = "SECTIONATTRIBUTE_MIGRLEGOBRASOCIAL" ;
      edtavCombomigrlegmodalidad_Internalname = "vCOMBOMIGRLEGMODALIDAD" ;
      divSectionattribute_migrlegmodalidad_Internalname = "SECTIONATTRIBUTE_MIGRLEGMODALIDAD" ;
      edtavCombomigrlegzona_Internalname = "vCOMBOMIGRLEGZONA" ;
      divSectionattribute_migrlegzona_Internalname = "SECTIONATTRIBUTE_MIGRLEGZONA" ;
      edtavCombomigrlegactividad_Internalname = "vCOMBOMIGRLEGACTIVIDAD" ;
      divSectionattribute_migrlegactividad_Internalname = "SECTIONATTRIBUTE_MIGRLEGACTIVIDAD" ;
      edtavCombomigrlegcondicion_Internalname = "vCOMBOMIGRLEGCONDICION" ;
      divSectionattribute_migrlegcondicion_Internalname = "SECTIONATTRIBUTE_MIGRLEGCONDICION" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO" ;
      edtMigrLegDiscapacidad_Internalname = "MIGRLEGDISCAPACIDAD" ;
      edtMigrLegOSAfip_Internalname = "MIGRLEGOSAFIP" ;
      edtMigrLegLugarDePago_Internalname = "MIGRLEGLUGARDEPAGO" ;
      edtMigrLegBanSuc_Internalname = "MIGRLEGBANSUC" ;
      edtMigrLegBanTipCuen_Internalname = "MIGRLEGBANTIPCUEN" ;
      edtMigrLegCuentaBanc_Internalname = "MIGRLEGCUENTABANC" ;
      edtMigrLegFormaPago_Internalname = "MIGRLEGFORMAPAGO" ;
      edtMigrLegSituacionRevista_Internalname = "MIGRLEGSITUACIONREVISTA" ;
      edtMigrLegSiniestrado_Internalname = "MIGRLEGSINIESTRADO" ;
      edtMigrLegSCVO_Internalname = "MIGRLEGSCVO" ;
      edtMigrLegPlanMedico_Internalname = "MIGRLEGPLANMEDICO" ;
      edtMigrTieneConyuge_Internalname = "MIGRTIENECONYUGE" ;
      edtMigrCantidadHijos_Internalname = "MIGRCANTIDADHIJOS" ;
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
      Form.setCaption( httpContext.getMessage( "Importación de Legajos", "") );
      edtMigrCantidadHijos_Jsonclick = "" ;
      edtMigrCantidadHijos_Enabled = 1 ;
      edtMigrCantidadHijos_Visible = 1 ;
      edtMigrTieneConyuge_Jsonclick = "" ;
      edtMigrTieneConyuge_Enabled = 1 ;
      edtMigrTieneConyuge_Visible = 1 ;
      edtMigrLegPlanMedico_Enabled = 1 ;
      edtMigrLegPlanMedico_Visible = 1 ;
      edtMigrLegSCVO_Jsonclick = "" ;
      edtMigrLegSCVO_Enabled = 1 ;
      edtMigrLegSCVO_Visible = 1 ;
      edtMigrLegSiniestrado_Enabled = 1 ;
      edtMigrLegSiniestrado_Visible = 1 ;
      edtMigrLegSituacionRevista_Jsonclick = "" ;
      edtMigrLegSituacionRevista_Enabled = 1 ;
      edtMigrLegSituacionRevista_Visible = 1 ;
      edtMigrLegFormaPago_Enabled = 1 ;
      edtMigrLegFormaPago_Visible = 1 ;
      edtMigrLegCuentaBanc_Jsonclick = "" ;
      edtMigrLegCuentaBanc_Enabled = 1 ;
      edtMigrLegCuentaBanc_Visible = 1 ;
      edtMigrLegBanTipCuen_Jsonclick = "" ;
      edtMigrLegBanTipCuen_Enabled = 1 ;
      edtMigrLegBanTipCuen_Visible = 1 ;
      edtMigrLegBanSuc_Enabled = 1 ;
      edtMigrLegBanSuc_Visible = 1 ;
      edtMigrLegLugarDePago_Jsonclick = "" ;
      edtMigrLegLugarDePago_Enabled = 1 ;
      edtMigrLegLugarDePago_Visible = 1 ;
      edtMigrLegOSAfip_Jsonclick = "" ;
      edtMigrLegOSAfip_Enabled = 1 ;
      edtMigrLegOSAfip_Visible = 1 ;
      edtMigrLegDiscapacidad_Jsonclick = "" ;
      edtMigrLegDiscapacidad_Enabled = 1 ;
      edtMigrLegDiscapacidad_Visible = 1 ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtMigrLegNumero_Enabled = 1 ;
      edtMigrLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombomigrlegcondicion_Jsonclick = "" ;
      edtavCombomigrlegcondicion_Enabled = 0 ;
      edtavCombomigrlegcondicion_Visible = 1 ;
      edtavCombomigrlegactividad_Jsonclick = "" ;
      edtavCombomigrlegactividad_Enabled = 0 ;
      edtavCombomigrlegactividad_Visible = 1 ;
      edtavCombomigrlegzona_Enabled = 0 ;
      edtavCombomigrlegzona_Visible = 1 ;
      edtavCombomigrlegmodalidad_Enabled = 0 ;
      edtavCombomigrlegmodalidad_Visible = 1 ;
      edtavCombomigrlegobrasocial_Enabled = 0 ;
      edtavCombomigrlegobrasocial_Visible = 1 ;
      edtavCombomigrlegbanco_Enabled = 0 ;
      edtavCombomigrlegbanco_Visible = 1 ;
      edtavCombomigrlegcategoria_Enabled = 0 ;
      edtavCombomigrlegcategoria_Visible = 1 ;
      edtavCombomigrlegconvenio_Enabled = 0 ;
      edtavCombomigrlegconvenio_Visible = 1 ;
      edtavCombomigrlegsindicato_Enabled = 0 ;
      edtavCombomigrlegsindicato_Visible = 1 ;
      edtavCombomigrlegarea_Enabled = 0 ;
      edtavCombomigrlegarea_Visible = 1 ;
      edtavCombomigrlegestadocivil_Enabled = 0 ;
      edtavCombomigrlegestadocivil_Visible = 1 ;
      edtavCombomigrlegsexo_Jsonclick = "" ;
      edtavCombomigrlegsexo_Enabled = 0 ;
      edtavCombomigrlegsexo_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtMigrLegObs_Enabled = 1 ;
      edtMigrLegPueAfip_Enabled = 1 ;
      edtMigrLegActLabClas_Jsonclick = "" ;
      edtMigrLegActLabClas_Enabled = 1 ;
      lblMigrlegcondicion_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegCondicion_Jsonclick = "" ;
      edtMigrLegCondicion_Enabled = 1 ;
      edtMigrLegCondicion_Visible = 1 ;
      Combo_migrlegcondicion_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegcondicion_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegcondicion_Caption = "" ;
      Combo_migrlegcondicion_Enabled = GXutil.toBoolean( -1) ;
      lblMigrlegactividad_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegActividad_Jsonclick = "" ;
      edtMigrLegActividad_Enabled = 1 ;
      edtMigrLegActividad_Visible = 1 ;
      Combo_migrlegactividad_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegactividad_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegactividad_Caption = "" ;
      Combo_migrlegactividad_Enabled = GXutil.toBoolean( -1) ;
      lblMigrlegzona_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegZona_Enabled = 1 ;
      edtMigrLegZona_Visible = 1 ;
      Combo_migrlegzona_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegzona_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegzona_Caption = "" ;
      Combo_migrlegzona_Enabled = GXutil.toBoolean( -1) ;
      edtMigrLegHorSem_Jsonclick = "" ;
      edtMigrLegHorSem_Enabled = 1 ;
      lblMigrlegmodalidad_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegModalidad_Enabled = 1 ;
      edtMigrLegModalidad_Visible = 1 ;
      Combo_migrlegmodalidad_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegmodalidad_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegmodalidad_Caption = "" ;
      Combo_migrlegmodalidad_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegmodalidad_Fontbold = (byte)(0) ;
      edtMigrLegCBU_Jsonclick = "" ;
      edtMigrLegCBU_Enabled = 1 ;
      lblMigrlegobrasocial_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegObraSocial_Enabled = 1 ;
      edtMigrLegObraSocial_Visible = 1 ;
      Combo_migrlegobrasocial_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegobrasocial_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegobrasocial_Caption = "" ;
      Combo_migrlegobrasocial_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegobrasocial_Fontbold = (byte)(0) ;
      edtMigrLegBasico_Jsonclick = "" ;
      edtMigrLegBasico_Enabled = 1 ;
      lblMigrlegbanco_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegBanco_Enabled = 1 ;
      edtMigrLegBanco_Visible = 1 ;
      Combo_migrlegbanco_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegbanco_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegbanco_Caption = "" ;
      Combo_migrlegbanco_Enabled = GXutil.toBoolean( -1) ;
      lblMigrlegcategoria_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegCategoria_Enabled = 1 ;
      edtMigrLegCategoria_Visible = 1 ;
      Combo_migrlegcategoria_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegcategoria_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegcategoria_Caption = "" ;
      Combo_migrlegcategoria_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegcategoria_Fontbold = (byte)(0) ;
      lblMigrlegconvenio_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegConvenio_Enabled = 1 ;
      edtMigrLegConvenio_Visible = 1 ;
      Combo_migrlegconvenio_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegconvenio_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegconvenio_Caption = "" ;
      Combo_migrlegconvenio_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegconvenio_Fontbold = (byte)(0) ;
      lblMigrlegsindicato_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegSindicato_Enabled = 1 ;
      edtMigrLegSindicato_Visible = 1 ;
      Combo_migrlegsindicato_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegsindicato_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegsindicato_Caption = "" ;
      Combo_migrlegsindicato_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegsindicato_Fontbold = (byte)(0) ;
      lblMigrlegarea_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegArea_Enabled = 1 ;
      edtMigrLegArea_Visible = 1 ;
      Combo_migrlegarea_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegarea_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegarea_Caption = "" ;
      Combo_migrlegarea_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegarea_Fontbold = (byte)(0) ;
      lblMigrlegestadocivil_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegEstadoCivil_Enabled = 1 ;
      edtMigrLegEstadoCivil_Visible = 1 ;
      Combo_migrlegestadocivil_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegestadocivil_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegestadocivil_Caption = "" ;
      Combo_migrlegestadocivil_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegestadocivil_Fontbold = (byte)(0) ;
      edtMigrLegEmail_Jsonclick = "" ;
      edtMigrLegEmail_Enabled = 1 ;
      edtMigrLegTelefono_Enabled = 1 ;
      edtMigrLegCodPos_Enabled = 1 ;
      edtMigrLegDomici_Enabled = 1 ;
      lblMigrlegsexo_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegSexo_Jsonclick = "" ;
      edtMigrLegSexo_Enabled = 1 ;
      edtMigrLegSexo_Visible = 1 ;
      Combo_migrlegsexo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegsexo_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegsexo_Caption = "" ;
      Combo_migrlegsexo_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegsexo_Fontbold = (byte)(0) ;
      edtMigrLegFecIngreso_Jsonclick = "" ;
      edtMigrLegFecIngreso_Enabled = 1 ;
      edtMigrLegFecNac_Jsonclick = "" ;
      edtMigrLegFecNac_Enabled = 1 ;
      lblMigrlegclase_righttext_Caption = httpContext.getMessage( "right text", "") ;
      cmbMigrLegClase.setJsonclick( "" );
      cmbMigrLegClase.setEnabled( 1 );
      lblTextblockmigrlegclase_Fontbold = (byte)(0) ;
      lblMigrlegtipotarifa_righttext_Caption = httpContext.getMessage( "right text", "") ;
      cmbMigrLegTipoTarifa.setJsonclick( "" );
      cmbMigrLegTipoTarifa.setEnabled( 1 );
      lblTextblockmigrlegtipotarifa_Fontbold = (byte)(0) ;
      lblMigrlegmodtra_righttext_Caption = httpContext.getMessage( "right text", "") ;
      cmbMigrLegModTra.setJsonclick( "" );
      cmbMigrLegModTra.setEnabled( 1 );
      lblTextblockmigrlegmodtra_Fontbold = (byte)(0) ;
      edtMigrLegNombre_Enabled = 1 ;
      edtMigrLegApellido_Enabled = 1 ;
      edtMigrLegCUIL_Jsonclick = "" ;
      edtMigrLegCUIL_Enabled = 1 ;
      edtMigrLegId_Jsonclick = "" ;
      edtMigrLegId_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Datos de legajo", "") ;
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

   public void gx3asaclicod2875( int AV7CliCod )
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
            GXt_int40 = A3CliCod ;
            GXv_int38[0] = GXt_int40 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int38) ;
            migrlegupd_impl.this.GXt_int40 = GXv_int38[0] ;
            A3CliCod = GXt_int40 ;
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

   public void gx5asaempcod2875( short AV18EmpCod )
   {
      if ( ! (0==AV18EmpCod) )
      {
         A1EmpCod = AV18EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int41 = A1EmpCod ;
            GXv_int42[0] = GXt_int41 ;
            new web.getempcod(remoteHandle, context).execute( GXv_int42) ;
            migrlegupd_impl.this.GXt_int41 = GXv_int42[0] ;
            A1EmpCod = GXt_int41 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx23asasinestexto2875( String A625MigrLegSiniestrado )
   {
      GXt_char37 = AV176sinesTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV176sinesTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV176sinesTexto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx24asamensaje2875( String A625MigrLegSiniestrado ,
                                   String A616MigrLegActividad ,
                                   String A617MigrLegModalidad ,
                                   String A620MigrLegZona ,
                                   String A623MigrLegSituacionRevista ,
                                   String A624MigrLegCondicion ,
                                   int AV7CliCod )
   {
      if ( true )
      {
         GXt_char37 = AV158mensaje ;
         GXv_char24[0] = GXt_char37 ;
         new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Siniestrado", ""), ""), A625MigrLegSiniestrado, false, false, GXv_char24) ;
         migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
         AV158mensaje = GXt_char37 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
      }
      else
      {
         if ( true )
         {
            GXt_char37 = AV158mensaje ;
            GXv_char24[0] = GXt_char37 ;
            new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Actividad", ""), ""), A616MigrLegActividad, false, false, GXv_char24) ;
            migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
            AV158mensaje = GXt_char37 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
         }
         else
         {
            if ( true )
            {
               GXt_char37 = AV158mensaje ;
               GXv_char24[0] = GXt_char37 ;
               new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Modalidad", ""), ""), A617MigrLegModalidad, false, false, GXv_char24) ;
               migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
               AV158mensaje = GXt_char37 ;
               httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
            }
            else
            {
               if ( true )
               {
                  GXt_char37 = AV158mensaje ;
                  GXv_char24[0] = GXt_char37 ;
                  new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Zona", ""), ""), A620MigrLegZona, false, false, GXv_char24) ;
                  migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                  AV158mensaje = GXt_char37 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
               }
               else
               {
                  if ( true )
                  {
                     GXt_char37 = AV158mensaje ;
                     GXv_char24[0] = GXt_char37 ;
                     new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Situacion", ""), ""), A623MigrLegSituacionRevista, false, false, GXv_char24) ;
                     migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                     AV158mensaje = GXt_char37 ;
                     httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
                  }
                  else
                  {
                     GXt_char37 = AV158mensaje ;
                     GXv_char24[0] = GXt_char37 ;
                     new web.mensajesecreararegistro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Condicion", ""), ""), A624MigrLegCondicion, false, false, GXv_char24) ;
                     migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
                     AV158mensaje = GXt_char37 ;
                     httpContext.ajax_rsp_assign_attri("", false, "AV158mensaje", AV158mensaje);
                  }
               }
            }
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV158mensaje)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx25asaacttexto2875( String A616MigrLegActividad )
   {
      GXt_char37 = AV177actTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV177actTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV177actTexto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx26asamodtexto2875( String A617MigrLegModalidad )
   {
      GXt_char37 = AV178modTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV178modTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV178modTexto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx27asatexto2875( String A620MigrLegZona )
   {
      GXt_char37 = AV175texto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV175texto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV175texto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx28asasitrevtexto2875( String A623MigrLegSituacionRevista )
   {
      GXt_char37 = AV179sitRevTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV179sitRevTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV179sitRevTexto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx29asacondtexto2875( String A624MigrLegCondicion )
   {
      GXt_char37 = AV180condTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV180condTexto = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV180condTexto)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx30asasexoerror2875( String A595MigrLegSexo ,
                                     int AV7CliCod )
   {
      GXt_char37 = AV164sexoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Sexo", ""), ""), GXutil.trim( A595MigrLegSexo), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV164sexoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV164sexoError", AV164sexoError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV164sexoError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx31asaestadocivilerror2875( String A596MigrLegEstadoCivil ,
                                            int AV7CliCod )
   {
      GXt_char37 = AV73estadocivilError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Estado Civil", ""), ""), GXutil.trim( A596MigrLegEstadoCivil), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV73estadocivilError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73estadocivilError", AV73estadocivilError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV73estadocivilError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx32asadiscapacidaderror2875( String A598MigrLegDiscapacidad ,
                                             int AV7CliCod )
   {
      GXt_char37 = AV74discapacidadError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Discapacidad", ""), ""), GXutil.trim( A598MigrLegDiscapacidad), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV74discapacidadError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74discapacidadError", AV74discapacidadError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV74discapacidadError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx33asaformadepagoerror2875( String A609MigrLegFormaPago ,
                                            int AV7CliCod )
   {
      GXt_char37 = AV76formadepagoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Forma de Pago", ""), ""), GXutil.trim( A609MigrLegFormaPago), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV76formadepagoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76formadepagoError", AV76formadepagoError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV76formadepagoError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx34asascvoerror2875( String A622MigrLegSCVO ,
                                     int AV7CliCod )
   {
      GXt_char37 = AV77scvoError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "SCVO", ""), ""), GXutil.trim( A622MigrLegSCVO), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV77scvoError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77scvoError", AV77scvoError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV77scvoError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx35asatieneconyugeerror2875( String A631MigrTieneConyuge ,
                                             int AV7CliCod )
   {
      GXt_char37 = AV103tieneconyugeError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Tiene Conyuge", ""), ""), GXutil.trim( A631MigrTieneConyuge), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV103tieneconyugeError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV103tieneconyugeError", AV103tieneconyugeError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV103tieneconyugeError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx36asatipocuentaerror2875( String A612MigrLegBanTipCuen ,
                                           int AV7CliCod )
   {
      GXt_char37 = AV166tipocuentaError ;
      GXv_char24[0] = GXt_char37 ;
      new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( httpContext.getMessage( "Tipo de Cuenta", ""), ""), GXutil.trim( A612MigrLegBanTipCuen), (short)(0), GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV166tipocuentaError = GXt_char37 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV166tipocuentaError", AV166tipocuentaError);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( AV166tipocuentaError)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx37asacatbasico2875( int AV7CliCod ,
                                     String A627MigrLegConvenio ,
                                     String AV156CatCodigo )
   {
      GXt_decimal45 = AV154CatBasico ;
      GXv_decimal46[0] = GXt_decimal45 ;
      new web.getcatbasico(remoteHandle, context).execute( AV7CliCod, A627MigrLegConvenio, AV156CatCodigo, GXutil.serverDate( context, remoteHandle, pr_default), GXv_decimal46) ;
      migrlegupd_impl.this.GXt_decimal45 = GXv_decimal46[0] ;
      AV154CatBasico = GXt_decimal45 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV154CatBasico", GXutil.ltrimstr( AV154CatBasico, 14, 2));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV154CatBasico, (byte)(14), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_60_2875( int A3CliCod ,
                           short A1EmpCod ,
                           String A626MigrLegId )
   {
      GXv_int38[0] = AV65LegNumeroPorId ;
      GXv_char24[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int38, GXv_char24) ;
      AV65LegNumeroPorId = GXv_int38[0] ;
      AV62LegNomApe = GXv_char24[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV62LegNomApe)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_62_2875( )
   {
      GXv_int38[0] = AV66LegNumeroPorCUIL ;
      GXv_char24[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int38, GXv_char24) ;
      AV66LegNumeroPorCUIL = GXv_int38[0] ;
      AV63LegIdNomApe = GXv_char24[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_64_2875( int AV7CliCod ,
                           String A627MigrLegConvenio ,
                           String A604MigrLegCategoria )
   {
      GXv_char24[0] = AV156CatCodigo ;
      GXv_boolean36[0] = AV155categoriaExiste ;
      new web.getcategoriapordescrip(remoteHandle, context).execute( AV7CliCod, A627MigrLegConvenio, A604MigrLegCategoria, GXv_char24, GXv_boolean36) ;
      AV156CatCodigo = GXv_char24[0] ;
      AV155categoriaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV156CatCodigo", AV156CatCodigo);
      httpContext.ajax_rsp_assign_attri("", false, "AV155categoriaExiste", AV155categoriaExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( AV156CatCodigo))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV155categoriaExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_65_2875( String AV176sinesTexto )
   {
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV157siniestradoExiste ;
      new web.getsiniestradopordescrip(remoteHandle, context).execute( AV176sinesTexto, GXv_char24, GXv_boolean36) ;
      AV157siniestradoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV157siniestradoExiste", AV157siniestradoExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV157siniestradoExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_67_2875( String AV177actTexto )
   {
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV159actividadExiste ;
      new web.getactividadpordescrip(remoteHandle, context).execute( AV177actTexto, GXv_char24, GXv_boolean36) ;
      AV159actividadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV159actividadExiste", AV159actividadExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV159actividadExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_69_2875( String AV178modTexto )
   {
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV160ModalidadExiste ;
      new web.getmodalidadpordescrip(remoteHandle, context).execute( AV178modTexto, GXv_char24, GXv_boolean36) ;
      AV160ModalidadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV160ModalidadExiste", AV160ModalidadExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV160ModalidadExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_71_2875( String AV175texto )
   {
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV161ZonaExiste ;
      new web.getzonapordescrip(remoteHandle, context).execute( AV175texto, GXv_char24, GXv_boolean36) ;
      AV161ZonaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV161ZonaExiste", AV161ZonaExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV161ZonaExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_73_2875( String AV179sitRevTexto )
   {
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV162SituacionExiste ;
      new web.getsituacionpordescrip(remoteHandle, context).execute( AV179sitRevTexto, GXv_char24, GXv_boolean36) ;
      AV162SituacionExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV162SituacionExiste", AV162SituacionExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV162SituacionExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_75_2875( String AV180condTexto )
   {
      GXv_int42[0] = (short)(0) ;
      GXv_boolean36[0] = AV163CondicionExiste ;
      new web.getcondicionpordescrip(remoteHandle, context).execute( AV180condTexto, GXv_int42, GXv_boolean36) ;
      AV163CondicionExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV163CondicionExiste", AV163CondicionExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV163CondicionExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_77_2875( int AV7CliCod ,
                           String A595MigrLegSexo ,
                           GXSimpleCollection<String> AV104dummyErrores )
   {
      GXv_int39[0] = (byte)(0) ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV168sexoExiste ;
      new web.traducirsexo(remoteHandle, context).execute( AV7CliCod, A595MigrLegSexo, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV168sexoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV168sexoExiste", AV168sexoExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( PrivateUtilities.encodeString( AV104dummyErrores.toxml(false, true, "Collection", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV168sexoExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_79_2875( int AV7CliCod ,
                           String A607MigrLegClase ,
                           GXSimpleCollection<String> AV104dummyErrores )
   {
      GXv_int38[0] = AV7CliCod ;
      GXv_int39[0] = AV92ClaseLeg ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = false ;
      new web.traducirclaselegajo(remoteHandle, context).execute( GXv_int38, A607MigrLegClase, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV7CliCod = GXv_int38[0] ;
      AV92ClaseLeg = GXv_int39[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      httpContext.ajax_rsp_assign_attri("", false, "AV92ClaseLeg", GXutil.str( AV92ClaseLeg, 1, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV92ClaseLeg, (byte)(1), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( PrivateUtilities.encodeString( AV104dummyErrores.toxml(false, true, "Collection", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_80_2875( int AV7CliCod ,
                           String A596MigrLegEstadoCivil ,
                           GXSimpleCollection<String> AV104dummyErrores )
   {
      GXv_int42[0] = AV95EstadoCivil ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV173estadoCivilExiste ;
      new web.traducirestadocivil(remoteHandle, context).execute( AV7CliCod, A596MigrLegEstadoCivil, GXv_int42, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV95EstadoCivil = GXv_int42[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV173estadoCivilExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95EstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95EstadoCivil), 4, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV173estadoCivilExiste", AV173estadoCivilExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV95EstadoCivil, (byte)(4), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( PrivateUtilities.encodeString( AV104dummyErrores.toxml(false, true, "Collection", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV173estadoCivilExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_82_2875( )
   {
      GXv_int42[0] = (short)(0) ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV172discapacidadExiste ;
      new web.traducirsinoanum(remoteHandle, context).execute( AV7CliCod, A598MigrLegDiscapacidad, httpContext.getMessage( "Discapacidad", ""), GXv_int42, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV172discapacidadExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV172discapacidadExiste", AV172discapacidadExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_84_2875( int AV7CliCod ,
                           String A609MigrLegFormaPago ,
                           GXSimpleCollection<String> AV104dummyErrores )
   {
      GXv_int39[0] = AV98FormaDePago ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean36[0] = AV167formadepagoExiste ;
      new web.traducirformapago(remoteHandle, context).execute( AV7CliCod, A609MigrLegFormaPago, GXv_int39, GXv_objcol_svchar32, GXv_char24, GXv_boolean36) ;
      AV98FormaDePago = GXv_int39[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV167formadepagoExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98FormaDePago", GXutil.str( AV98FormaDePago, 1, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV167formadepagoExiste", AV167formadepagoExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV98FormaDePago, (byte)(1), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( PrivateUtilities.encodeString( AV104dummyErrores.toxml(false, true, "Collection", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV167formadepagoExiste))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_86_2875( )
   {
      GXv_boolean36[0] = false ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean35[0] = AV171scvoExiste ;
      new web.traducirsinoaboolean(remoteHandle, context).execute( AV7CliCod, A622MigrLegSCVO, httpContext.getMessage( "SCVO", ""), GXv_boolean36, GXv_objcol_svchar32, GXv_char24, GXv_boolean35) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV171scvoExiste = GXv_boolean35[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV171scvoExiste", AV171scvoExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_88_2875( )
   {
      GXv_boolean36[0] = false ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char24[0] = "" ;
      GXv_boolean35[0] = AV170tieneConyugeExiste ;
      new web.traducirsinoaboolean(remoteHandle, context).execute( AV7CliCod, A631MigrTieneConyuge, httpContext.getMessage( "Tiene Conyuge", ""), GXv_boolean36, GXv_objcol_svchar32, GXv_char24, GXv_boolean35) ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV170tieneConyugeExiste = GXv_boolean35[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV170tieneConyugeExiste", AV170tieneConyugeExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_90_2875( int AV7CliCod ,
                           String A612MigrLegBanTipCuen ,
                           GXSimpleCollection<String> AV104dummyErrores )
   {
      GXv_char24[0] = AV111tipoCuentaBanco ;
      GXv_objcol_svchar32[0] = AV104dummyErrores ;
      GXv_char23[0] = "" ;
      GXv_boolean36[0] = AV169tipocuentaExiste ;
      new web.traducirtipocuentabanco(remoteHandle, context).execute( AV7CliCod, A612MigrLegBanTipCuen, GXv_char24, GXv_objcol_svchar32, GXv_char23, GXv_boolean36) ;
      AV111tipoCuentaBanco = GXv_char24[0] ;
      AV104dummyErrores = GXv_objcol_svchar32[0] ;
      AV169tipocuentaExiste = GXv_boolean36[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV111tipoCuentaBanco", AV111tipoCuentaBanco);
      httpContext.ajax_rsp_assign_attri("", false, "AV169tipocuentaExiste", AV169tipocuentaExiste);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( AV111tipoCuentaBanco))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( PrivateUtilities.encodeString( AV104dummyErrores.toxml(false, true, "Collection", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV169tipocuentaExiste))+"\"") ;
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
      cmbMigrLegModTra.setName( "MIGRLEGMODTRA" );
      cmbMigrLegModTra.setWebtags( "" );
      if ( cmbMigrLegModTra.getItemCount() > 0 )
      {
         A2415MigrLegModTra = cmbMigrLegModTra.getValidValue(A2415MigrLegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
      }
      cmbMigrLegTipoTarifa.setName( "MIGRLEGTIPOTARIFA" );
      cmbMigrLegTipoTarifa.setWebtags( "" );
      if ( cmbMigrLegTipoTarifa.getItemCount() > 0 )
      {
         A2427MigrLegTipoTarifa = cmbMigrLegTipoTarifa.getValidValue(A2427MigrLegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
      }
      cmbMigrLegClase.setName( "MIGRLEGCLASE" );
      cmbMigrLegClase.setWebtags( "" );
      if ( cmbMigrLegClase.getItemCount() > 0 )
      {
         A607MigrLegClase = cmbMigrLegClase.getValidValue(A607MigrLegClase) ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
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

   public void valid_Empcod( )
   {
      /* Using cursor T002815 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Migrlegid( )
   {
      if ( (GXutil.strcmp("", A626MigrLegId)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "ID/Código", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
      }
      GXv_int38[0] = AV65LegNumeroPorId ;
      GXv_char24[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int38, GXv_char24) ;
      migrlegupd_impl.this.AV65LegNumeroPorId = GXv_int38[0] ;
      AV65LegNumeroPorId = this.AV65LegNumeroPorId ;
      migrlegupd_impl.this.AV62LegNomApe = GXv_char24[0] ;
      AV62LegNomApe = this.AV62LegNomApe ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
   }

   public void valid_Migrlegcuil( )
   {
      if ( (GXutil.strcmp("", A597MigrLegCUIL)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "CUIL", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCUIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCUIL_Internalname ;
      }
      GXv_int38[0] = AV66LegNumeroPorCUIL ;
      GXv_char24[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int38, GXv_char24) ;
      migrlegupd_impl.this.AV66LegNumeroPorCUIL = GXv_int38[0] ;
      AV66LegNumeroPorCUIL = this.AV66LegNumeroPorCUIL ;
      migrlegupd_impl.this.AV63LegIdNomApe = GXv_char24[0] ;
      AV63LegIdNomApe = this.AV63LegIdNomApe ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrim( localUtil.ntoc( AV66LegNumeroPorCUIL, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
   }

   public void valid_Migrlegcategoria( )
   {
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
   }

   public void valid_Migrlegmodalidad( )
   {
      GXt_char37 = AV178modTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A617MigrLegModalidad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV178modTexto = GXt_char37 ;
      if ( (GXutil.strcmp("", A617MigrLegModalidad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Modalidad", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGMODALIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegModalidad_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV178modTexto", AV178modTexto);
   }

   public void valid_Migrlegzona( )
   {
      GXt_char37 = AV175texto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A620MigrLegZona, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV175texto = GXt_char37 ;
      if ( (GXutil.strcmp("", A620MigrLegZona)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGZONA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegZona_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV175texto", AV175texto);
   }

   public void valid_Migrlegactividad( )
   {
      GXt_char37 = AV177actTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A616MigrLegActividad, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV177actTexto = GXt_char37 ;
      if ( (GXutil.strcmp("", A616MigrLegActividad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGACTIVIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegActividad_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV177actTexto", AV177actTexto);
   }

   public void valid_Migrlegcondicion( )
   {
      GXt_char37 = AV180condTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A624MigrLegCondicion, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV180condTexto = GXt_char37 ;
      if ( (GXutil.strcmp("", A624MigrLegCondicion)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Condición", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCondicion_Internalname ;
      }
      if ( (GXutil.strcmp("", A614MigrLegObraSocial)==0) && ( ( GXutil.strcmp(A624MigrLegCondicion, "02") != 0 ) && ( GXutil.strcmp(GXutil.upper( A624MigrLegCondicion), httpContext.getMessage( "JUBILADO", "")) != 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCondicion_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV180condTexto", AV180condTexto);
   }

   public void valid_Migrlegsituacionrevista( )
   {
      GXt_char37 = AV179sitRevTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A623MigrLegSituacionRevista, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV179sitRevTexto = GXt_char37 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV179sitRevTexto", AV179sitRevTexto);
   }

   public void valid_Migrlegsiniestrado( )
   {
      GXt_char37 = AV176sinesTexto ;
      GXv_char24[0] = GXt_char37 ;
      new web.sacaracentos2(remoteHandle, context).execute( A625MigrLegSiniestrado, GXv_char24) ;
      migrlegupd_impl.this.GXt_char37 = GXv_char24[0] ;
      AV176sinesTexto = GXt_char37 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV176sinesTexto", AV176sinesTexto);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV34MigrLegConvenio',fld:'vMIGRLEGCONVENIO',pic:'',hsh:true},{av:'AV51MigrLegZona',fld:'vMIGRLEGZONA',pic:'',hsh:true},{av:'AV30MigrLegCategoria',fld:'vMIGRLEGCATEGORIA',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A618MigrLegFecUltMod',fld:'MIGRLEGFECULTMOD',pic:''},{av:'A635MigrEncontroOsoSigla',fld:'MIGRENCONTROOSOSIGLA',pic:''},{av:'A689MigrLegAreaDef',fld:'MIGRLEGAREADEF',pic:''},{av:'A690MigrLegEstadoCivilDef',fld:'MIGRLEGESTADOCIVILDEF',pic:''},{av:'A691MigrLegClaseDef',fld:'MIGRLEGCLASEDEF',pic:''},{av:'A692MigrLegFormaPagoDef',fld:'MIGRLEGFORMAPAGODEF',pic:''},{av:'A693MigrLegTipoCuentaDef',fld:'MIGRLEGTIPOCUENTADEF',pic:''},{av:'A694MigrLegActividadDef',fld:'MIGRLEGACTIVIDADDEF',pic:''},{av:'A695MigrLegModalidadDef',fld:'MIGRLEGMODALIDADDEF',pic:''},{av:'A696MigrLegZonaDef',fld:'MIGRLEGZONADEF',pic:''},{av:'A697MigrLegSCVODef',fld:'MIGRLEGSCVODEF',pic:''},{av:'A698MigrLegSituacionDef',fld:'MIGRLEGSITUACIONDEF',pic:''},{av:'A699MigrLegCondicionDef',fld:'MIGRLEGCONDICIONDEF',pic:''},{av:'A700MigrLegSiniestradoDef',fld:'MIGRLEGSINIESTRADODEF',pic:''},{av:'A2216MigrPuesto',fld:'MIGRPUESTO',pic:''},{av:'A2205MigrLegFecEgreso',fld:'MIGRLEGFECEGRESO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e13282',iparms:[{av:'AV203Pgmname',fld:'vPGMNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV104dummyErrores',fld:'vDUMMYERRORES',pic:''}]}");
      setEventMetadata("COMBO_MIGRLEGCONVENIO.ONOPTIONCLICKED","{handler:'e12282',iparms:[{av:'Combo_migrlegconvenio_Selectedvalue_get',ctrl:'COMBO_MIGRLEGCONVENIO',prop:'SelectedValue_get'},{av:'AV203Pgmname',fld:'vPGMNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV34MigrLegConvenio',fld:'vMIGRLEGCONVENIO',pic:'',hsh:true},{av:'AV68errores',fld:'vERRORES',pic:''},{av:'AV69warnings',fld:'vWARNINGS',pic:''},{av:'AV51MigrLegZona',fld:'vMIGRLEGZONA',pic:'',hsh:true},{av:'AV30MigrLegCategoria',fld:'vMIGRLEGCATEGORIA',pic:'',hsh:true}]");
      setEventMetadata("COMBO_MIGRLEGCONVENIO.ONOPTIONCLICKED",",oparms:[{av:'AV136ComboMigrLegConvenio',fld:'vCOMBOMIGRLEGCONVENIO',pic:''},{av:'AV126MigrLegCategoria_Data',fld:'vMIGRLEGCATEGORIA_DATA',pic:''},{av:'Combo_migrlegcategoria_Selectedvalue_set',ctrl:'COMBO_MIGRLEGCATEGORIA',prop:'SelectedValue_set'},{av:'AV127ComboMigrLegCategoria',fld:'vCOMBOMIGRLEGCATEGORIA',pic:''},{av:'Combo_migrlegcategoria_Enabled',ctrl:'COMBO_MIGRLEGCATEGORIA',prop:'Enabled'},{av:'AV69warnings',fld:'vWARNINGS',pic:''},{av:'AV68errores',fld:'vERRORES',pic:''},{av:'lblTextblockmigrlegcategoria_Fontbold',ctrl:'TEXTBLOCKMIGRLEGCATEGORIA',prop:'Fontbold'},{av:'lblMigrlegcategoria_righttext_Caption',ctrl:'MIGRLEGCATEGORIA_RIGHTTEXT',prop:'Caption'}]}");
      setEventMetadata("VALID_MIGRLEGID","{handler:'valid_Migrlegid',iparms:[{av:'A626MigrLegId',fld:'MIGRLEGID',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV65LegNumeroPorId',fld:'vLEGNUMEROPORID',pic:'ZZZZZZZ9'},{av:'AV62LegNomApe',fld:'vLEGNOMAPE',pic:''}]");
      setEventMetadata("VALID_MIGRLEGID",",oparms:[{av:'AV65LegNumeroPorId',fld:'vLEGNUMEROPORID',pic:'ZZZZZZZ9'},{av:'AV62LegNomApe',fld:'vLEGNOMAPE',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGCUIL","{handler:'valid_Migrlegcuil',iparms:[{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV66LegNumeroPorCUIL',fld:'vLEGNUMEROPORCUIL',pic:'ZZZZZZZ9'},{av:'AV63LegIdNomApe',fld:'vLEGIDNOMAPE',pic:''}]");
      setEventMetadata("VALID_MIGRLEGCUIL",",oparms:[{av:'AV66LegNumeroPorCUIL',fld:'vLEGNUMEROPORCUIL',pic:'ZZZZZZZ9'},{av:'AV63LegIdNomApe',fld:'vLEGIDNOMAPE',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGAPELLIDO","{handler:'valid_Migrlegapellido',iparms:[]");
      setEventMetadata("VALID_MIGRLEGAPELLIDO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNOMBRE","{handler:'valid_Migrlegnombre',iparms:[]");
      setEventMetadata("VALID_MIGRLEGNOMBRE",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGMODTRA","{handler:'valid_Migrlegmodtra',iparms:[]");
      setEventMetadata("VALID_MIGRLEGMODTRA",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGTIPOTARIFA","{handler:'valid_Migrlegtipotarifa',iparms:[]");
      setEventMetadata("VALID_MIGRLEGTIPOTARIFA",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCLASE","{handler:'valid_Migrlegclase',iparms:[]");
      setEventMetadata("VALID_MIGRLEGCLASE",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFECNAC","{handler:'valid_Migrlegfecnac',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFECNAC",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFECINGRESO","{handler:'valid_Migrlegfecingreso',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFECINGRESO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGSEXO","{handler:'valid_Migrlegsexo',iparms:[]");
      setEventMetadata("VALID_MIGRLEGSEXO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGESTADOCIVIL","{handler:'valid_Migrlegestadocivil',iparms:[]");
      setEventMetadata("VALID_MIGRLEGESTADOCIVIL",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCONVENIO","{handler:'valid_Migrlegconvenio',iparms:[]");
      setEventMetadata("VALID_MIGRLEGCONVENIO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCATEGORIA","{handler:'valid_Migrlegcategoria',iparms:[{av:'A604MigrLegCategoria',fld:'MIGRLEGCATEGORIA',pic:''},{av:'AV64AuxMigrLegCategoria',fld:'vAUXMIGRLEGCATEGORIA',pic:''}]");
      setEventMetadata("VALID_MIGRLEGCATEGORIA",",oparms:[{av:'AV64AuxMigrLegCategoria',fld:'vAUXMIGRLEGCATEGORIA',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGBASICO","{handler:'valid_Migrlegbasico',iparms:[]");
      setEventMetadata("VALID_MIGRLEGBASICO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGOBRASOCIAL","{handler:'valid_Migrlegobrasocial',iparms:[]");
      setEventMetadata("VALID_MIGRLEGOBRASOCIAL",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGMODALIDAD","{handler:'valid_Migrlegmodalidad',iparms:[{av:'A617MigrLegModalidad',fld:'MIGRLEGMODALIDAD',pic:''},{av:'AV178modTexto',fld:'vMODTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGMODALIDAD",",oparms:[{av:'AV178modTexto',fld:'vMODTEXTO',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGZONA","{handler:'valid_Migrlegzona',iparms:[{av:'A620MigrLegZona',fld:'MIGRLEGZONA',pic:''},{av:'AV175texto',fld:'vTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGZONA",",oparms:[{av:'AV175texto',fld:'vTEXTO',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGACTIVIDAD","{handler:'valid_Migrlegactividad',iparms:[{av:'A616MigrLegActividad',fld:'MIGRLEGACTIVIDAD',pic:''},{av:'AV177actTexto',fld:'vACTTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGACTIVIDAD",",oparms:[{av:'AV177actTexto',fld:'vACTTEXTO',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGCONDICION","{handler:'valid_Migrlegcondicion',iparms:[{av:'A624MigrLegCondicion',fld:'MIGRLEGCONDICION',pic:'@!'},{av:'A614MigrLegObraSocial',fld:'MIGRLEGOBRASOCIAL',pic:''},{av:'AV180condTexto',fld:'vCONDTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGCONDICION",",oparms:[{av:'AV180condTexto',fld:'vCONDTEXTO',pic:''}]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGSEXO","{handler:'validv_Combomigrlegsexo',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGSEXO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGESTADOCIVIL","{handler:'validv_Combomigrlegestadocivil',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGESTADOCIVIL",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGAREA","{handler:'validv_Combomigrlegarea',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGAREA",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGSINDICATO","{handler:'validv_Combomigrlegsindicato',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGSINDICATO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGCONVENIO","{handler:'validv_Combomigrlegconvenio',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGCONVENIO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGCATEGORIA","{handler:'validv_Combomigrlegcategoria',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGCATEGORIA",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGBANCO","{handler:'validv_Combomigrlegbanco',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGBANCO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGOBRASOCIAL","{handler:'validv_Combomigrlegobrasocial',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGOBRASOCIAL",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGMODALIDAD","{handler:'validv_Combomigrlegmodalidad',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGMODALIDAD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGZONA","{handler:'validv_Combomigrlegzona',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGZONA",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGACTIVIDAD","{handler:'validv_Combomigrlegactividad',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGACTIVIDAD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGCONDICION","{handler:'validv_Combomigrlegcondicion',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGCONDICION",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNUMERO","{handler:'valid_Migrlegnumero',iparms:[]");
      setEventMetadata("VALID_MIGRLEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGDISCAPACIDAD","{handler:'valid_Migrlegdiscapacidad',iparms:[]");
      setEventMetadata("VALID_MIGRLEGDISCAPACIDAD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGOSAFIP","{handler:'valid_Migrlegosafip',iparms:[]");
      setEventMetadata("VALID_MIGRLEGOSAFIP",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGBANTIPCUEN","{handler:'valid_Migrlegbantipcuen',iparms:[]");
      setEventMetadata("VALID_MIGRLEGBANTIPCUEN",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFORMAPAGO","{handler:'valid_Migrlegformapago',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFORMAPAGO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGSITUACIONREVISTA","{handler:'valid_Migrlegsituacionrevista',iparms:[{av:'A623MigrLegSituacionRevista',fld:'MIGRLEGSITUACIONREVISTA',pic:'@!'},{av:'AV179sitRevTexto',fld:'vSITREVTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGSITUACIONREVISTA",",oparms:[{av:'AV179sitRevTexto',fld:'vSITREVTEXTO',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGSINIESTRADO","{handler:'valid_Migrlegsiniestrado',iparms:[{av:'A625MigrLegSiniestrado',fld:'MIGRLEGSINIESTRADO',pic:''},{av:'AV176sinesTexto',fld:'vSINESTEXTO',pic:''}]");
      setEventMetadata("VALID_MIGRLEGSINIESTRADO",",oparms:[{av:'AV176sinesTexto',fld:'vSINESTEXTO',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGSCVO","{handler:'valid_Migrlegscvo',iparms:[]");
      setEventMetadata("VALID_MIGRLEGSCVO",",oparms:[]}");
      setEventMetadata("VALID_MIGRTIENECONYUGE","{handler:'valid_Migrtieneconyuge',iparms:[]");
      setEventMetadata("VALID_MIGRTIENECONYUGE",",oparms:[]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      Z605MigrLegArea = "" ;
      Z613MigrLegSindicato = "" ;
      Z627MigrLegConvenio = "" ;
      Z604MigrLegCategoria = "" ;
      Z610MigrLegBanco = "" ;
      Z614MigrLegObraSocial = "" ;
      Z617MigrLegModalidad = "" ;
      Z620MigrLegZona = "" ;
      Z616MigrLegActividad = "" ;
      Z624MigrLegCondicion = "" ;
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      Z597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      Z606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      Z607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      Z611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      Z634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      Z621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      Z2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      Z625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      Z631MigrTieneConyuge = "" ;
      Z2216MigrPuesto = "" ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
      Z2427MigrLegTipoTarifa = "" ;
      O634MigrLegOSAfip = "" ;
      N634MigrLegOSAfip = "" ;
      Combo_migrlegcondicion_Selectedvalue_get = "" ;
      Combo_migrlegactividad_Selectedvalue_get = "" ;
      Combo_migrlegzona_Selectedvalue_get = "" ;
      Combo_migrlegmodalidad_Selectedvalue_get = "" ;
      Combo_migrlegobrasocial_Selectedvalue_get = "" ;
      Combo_migrlegbanco_Selectedvalue_get = "" ;
      Combo_migrlegcategoria_Selectedvalue_get = "" ;
      Combo_migrlegconvenio_Selectedvalue_get = "" ;
      Combo_migrlegsindicato_Selectedvalue_get = "" ;
      Combo_migrlegarea_Selectedvalue_get = "" ;
      Combo_migrlegestadocivil_Selectedvalue_get = "" ;
      Combo_migrlegsexo_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A626MigrLegId = "" ;
      A627MigrLegConvenio = "" ;
      A604MigrLegCategoria = "" ;
      AV176sinesTexto = "" ;
      AV177actTexto = "" ;
      AV178modTexto = "" ;
      AV175texto = "" ;
      AV179sitRevTexto = "" ;
      AV180condTexto = "" ;
      A595MigrLegSexo = "" ;
      AV104dummyErrores = new GXSimpleCollection<String>(String.class, "internal", "");
      A607MigrLegClase = "" ;
      A596MigrLegEstadoCivil = "" ;
      A609MigrLegFormaPago = "" ;
      A612MigrLegBanTipCuen = "" ;
      A625MigrLegSiniestrado = "" ;
      A616MigrLegActividad = "" ;
      A617MigrLegModalidad = "" ;
      A620MigrLegZona = "" ;
      A623MigrLegSituacionRevista = "" ;
      A624MigrLegCondicion = "" ;
      A598MigrLegDiscapacidad = "" ;
      A622MigrLegSCVO = "" ;
      A631MigrTieneConyuge = "" ;
      AV156CatCodigo = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A597MigrLegCUIL = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      lblTextblockmigrlegmodtra_Jsonclick = "" ;
      lblMigrlegmodtra_righttext_Jsonclick = "" ;
      lblTextblockmigrlegtipotarifa_Jsonclick = "" ;
      lblMigrlegtipotarifa_righttext_Jsonclick = "" ;
      lblTextblockmigrlegclase_Jsonclick = "" ;
      lblMigrlegclase_righttext_Jsonclick = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      lblTextblockmigrlegsexo_Jsonclick = "" ;
      ucCombo_migrlegsexo = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV189MigrLegSexo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegsexo_righttext_Jsonclick = "" ;
      A599MigrLegDomici = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A600MigrLegEmail = "" ;
      lblTextblockmigrlegestadocivil_Jsonclick = "" ;
      ucCombo_migrlegestadocivil = new com.genexus.webpanels.GXUserControl();
      AV191MigrLegEstadoCivil_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegestadocivil_righttext_Jsonclick = "" ;
      lblTextblockmigrlegarea_Jsonclick = "" ;
      ucCombo_migrlegarea = new com.genexus.webpanels.GXUserControl();
      AV26MigrLegArea_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A605MigrLegArea = "" ;
      lblMigrlegarea_righttext_Jsonclick = "" ;
      lblTextblockmigrlegsindicato_Jsonclick = "" ;
      ucCombo_migrlegsindicato = new com.genexus.webpanels.GXUserControl();
      AV133MigrLegSindicato_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A613MigrLegSindicato = "" ;
      lblMigrlegsindicato_righttext_Jsonclick = "" ;
      lblTextblockmigrlegconvenio_Jsonclick = "" ;
      ucCombo_migrlegconvenio = new com.genexus.webpanels.GXUserControl();
      AV135MigrLegConvenio_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegconvenio_righttext_Jsonclick = "" ;
      lblTextblockmigrlegcategoria_Jsonclick = "" ;
      ucCombo_migrlegcategoria = new com.genexus.webpanels.GXUserControl();
      AV126MigrLegCategoria_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegcategoria_righttext_Jsonclick = "" ;
      lblTextblockmigrlegbanco_Jsonclick = "" ;
      ucCombo_migrlegbanco = new com.genexus.webpanels.GXUserControl();
      AV139MigrLegBanco_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A610MigrLegBanco = "" ;
      lblMigrlegbanco_righttext_Jsonclick = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      lblTextblockmigrlegobrasocial_Jsonclick = "" ;
      ucCombo_migrlegobrasocial = new com.genexus.webpanels.GXUserControl();
      AV131MigrLegObraSocial_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A614MigrLegObraSocial = "" ;
      lblMigrlegobrasocial_righttext_Jsonclick = "" ;
      A621MigrLegCBU = "" ;
      lblTextblockmigrlegmodalidad_Jsonclick = "" ;
      ucCombo_migrlegmodalidad = new com.genexus.webpanels.GXUserControl();
      AV141MigrLegModalidad_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegmodalidad_righttext_Jsonclick = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      lblTextblockmigrlegzona_Jsonclick = "" ;
      ucCombo_migrlegzona = new com.genexus.webpanels.GXUserControl();
      AV129MigrLegZona_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegzona_righttext_Jsonclick = "" ;
      lblTextblockmigrlegactividad_Jsonclick = "" ;
      ucCombo_migrlegactividad = new com.genexus.webpanels.GXUserControl();
      AV143MigrLegActividad_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegactividad_righttext_Jsonclick = "" ;
      lblTextblockmigrlegcondicion_Jsonclick = "" ;
      ucCombo_migrlegcondicion = new com.genexus.webpanels.GXUserControl();
      AV147MigrLegCondicion_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblMigrlegcondicion_righttext_Jsonclick = "" ;
      A2239MigrLegActLabClas = "" ;
      A2240MigrLegPueAfip = "" ;
      A628MigrLegObs = "" ;
      WebComp_Wcimportarlegajofamilia_Component = "" ;
      OldWcimportarlegajofamilia = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      AV190ComboMigrLegSexo = "" ;
      AV192ComboMigrLegEstadoCivil = "" ;
      AV13ComboMigrLegArea = "" ;
      AV134ComboMigrLegSindicato = "" ;
      AV136ComboMigrLegConvenio = "" ;
      AV127ComboMigrLegCategoria = "" ;
      AV140ComboMigrLegBanco = "" ;
      AV132ComboMigrLegObraSocial = "" ;
      AV142ComboMigrLegModalidad = "" ;
      AV130ComboMigrLegZona = "" ;
      AV144ComboMigrLegActividad = "" ;
      AV148ComboMigrLegCondicion = "" ;
      A634MigrLegOSAfip = "" ;
      A606MigrLegLugarDePago = "" ;
      A611MigrLegBanSuc = "" ;
      A619MigrLegCuentaBanc = "" ;
      A615MigrLegPlanMedico = "" ;
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      A2216MigrPuesto = "" ;
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      AV64AuxMigrLegCategoria = "" ;
      AV158mensaje = "" ;
      AV164sexoError = "" ;
      AV73estadocivilError = "" ;
      AV74discapacidadError = "" ;
      AV76formadepagoError = "" ;
      AV77scvoError = "" ;
      AV103tieneconyugeError = "" ;
      AV166tipocuentaError = "" ;
      AV154CatBasico = DecimalUtil.ZERO ;
      AV62LegNomApe = "" ;
      AV63LegIdNomApe = "" ;
      AV111tipoCuentaBanco = "" ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      A2206MigrOtrosDatos = "" ;
      AV203Pgmname = "" ;
      Combo_migrlegsexo_Objectcall = "" ;
      Combo_migrlegsexo_Class = "" ;
      Combo_migrlegsexo_Icontype = "" ;
      Combo_migrlegsexo_Icon = "" ;
      Combo_migrlegsexo_Tooltip = "" ;
      Combo_migrlegsexo_Selectedvalue_set = "" ;
      Combo_migrlegsexo_Selectedtext_set = "" ;
      Combo_migrlegsexo_Selectedtext_get = "" ;
      Combo_migrlegsexo_Gamoauthtoken = "" ;
      Combo_migrlegsexo_Ddointernalname = "" ;
      Combo_migrlegsexo_Titlecontrolalign = "" ;
      Combo_migrlegsexo_Dropdownoptionstype = "" ;
      Combo_migrlegsexo_Titlecontrolidtoreplace = "" ;
      Combo_migrlegsexo_Datalisttype = "" ;
      Combo_migrlegsexo_Datalistfixedvalues = "" ;
      Combo_migrlegsexo_Datalistproc = "" ;
      Combo_migrlegsexo_Datalistprocparametersprefix = "" ;
      Combo_migrlegsexo_Remoteservicesparameters = "" ;
      Combo_migrlegsexo_Htmltemplate = "" ;
      Combo_migrlegsexo_Multiplevaluestype = "" ;
      Combo_migrlegsexo_Loadingdata = "" ;
      Combo_migrlegsexo_Noresultsfound = "" ;
      Combo_migrlegsexo_Emptyitemtext = "" ;
      Combo_migrlegsexo_Onlyselectedvalues = "" ;
      Combo_migrlegsexo_Selectalltext = "" ;
      Combo_migrlegsexo_Multiplevaluesseparator = "" ;
      Combo_migrlegsexo_Addnewoptiontext = "" ;
      Combo_migrlegestadocivil_Objectcall = "" ;
      Combo_migrlegestadocivil_Class = "" ;
      Combo_migrlegestadocivil_Icontype = "" ;
      Combo_migrlegestadocivil_Icon = "" ;
      Combo_migrlegestadocivil_Tooltip = "" ;
      Combo_migrlegestadocivil_Selectedvalue_set = "" ;
      Combo_migrlegestadocivil_Selectedtext_set = "" ;
      Combo_migrlegestadocivil_Selectedtext_get = "" ;
      Combo_migrlegestadocivil_Gamoauthtoken = "" ;
      Combo_migrlegestadocivil_Ddointernalname = "" ;
      Combo_migrlegestadocivil_Titlecontrolalign = "" ;
      Combo_migrlegestadocivil_Dropdownoptionstype = "" ;
      Combo_migrlegestadocivil_Titlecontrolidtoreplace = "" ;
      Combo_migrlegestadocivil_Datalisttype = "" ;
      Combo_migrlegestadocivil_Datalistfixedvalues = "" ;
      Combo_migrlegestadocivil_Datalistproc = "" ;
      Combo_migrlegestadocivil_Datalistprocparametersprefix = "" ;
      Combo_migrlegestadocivil_Remoteservicesparameters = "" ;
      Combo_migrlegestadocivil_Htmltemplate = "" ;
      Combo_migrlegestadocivil_Multiplevaluestype = "" ;
      Combo_migrlegestadocivil_Loadingdata = "" ;
      Combo_migrlegestadocivil_Noresultsfound = "" ;
      Combo_migrlegestadocivil_Emptyitemtext = "" ;
      Combo_migrlegestadocivil_Onlyselectedvalues = "" ;
      Combo_migrlegestadocivil_Selectalltext = "" ;
      Combo_migrlegestadocivil_Multiplevaluesseparator = "" ;
      Combo_migrlegestadocivil_Addnewoptiontext = "" ;
      Combo_migrlegarea_Objectcall = "" ;
      Combo_migrlegarea_Class = "" ;
      Combo_migrlegarea_Icontype = "" ;
      Combo_migrlegarea_Icon = "" ;
      Combo_migrlegarea_Tooltip = "" ;
      Combo_migrlegarea_Selectedvalue_set = "" ;
      Combo_migrlegarea_Selectedtext_set = "" ;
      Combo_migrlegarea_Selectedtext_get = "" ;
      Combo_migrlegarea_Gamoauthtoken = "" ;
      Combo_migrlegarea_Ddointernalname = "" ;
      Combo_migrlegarea_Titlecontrolalign = "" ;
      Combo_migrlegarea_Dropdownoptionstype = "" ;
      Combo_migrlegarea_Titlecontrolidtoreplace = "" ;
      Combo_migrlegarea_Datalisttype = "" ;
      Combo_migrlegarea_Datalistfixedvalues = "" ;
      Combo_migrlegarea_Datalistproc = "" ;
      Combo_migrlegarea_Datalistprocparametersprefix = "" ;
      Combo_migrlegarea_Remoteservicesparameters = "" ;
      Combo_migrlegarea_Htmltemplate = "" ;
      Combo_migrlegarea_Multiplevaluestype = "" ;
      Combo_migrlegarea_Loadingdata = "" ;
      Combo_migrlegarea_Noresultsfound = "" ;
      Combo_migrlegarea_Emptyitemtext = "" ;
      Combo_migrlegarea_Onlyselectedvalues = "" ;
      Combo_migrlegarea_Selectalltext = "" ;
      Combo_migrlegarea_Multiplevaluesseparator = "" ;
      Combo_migrlegarea_Addnewoptiontext = "" ;
      Combo_migrlegsindicato_Objectcall = "" ;
      Combo_migrlegsindicato_Class = "" ;
      Combo_migrlegsindicato_Icontype = "" ;
      Combo_migrlegsindicato_Icon = "" ;
      Combo_migrlegsindicato_Tooltip = "" ;
      Combo_migrlegsindicato_Selectedvalue_set = "" ;
      Combo_migrlegsindicato_Selectedtext_set = "" ;
      Combo_migrlegsindicato_Selectedtext_get = "" ;
      Combo_migrlegsindicato_Gamoauthtoken = "" ;
      Combo_migrlegsindicato_Ddointernalname = "" ;
      Combo_migrlegsindicato_Titlecontrolalign = "" ;
      Combo_migrlegsindicato_Dropdownoptionstype = "" ;
      Combo_migrlegsindicato_Titlecontrolidtoreplace = "" ;
      Combo_migrlegsindicato_Datalisttype = "" ;
      Combo_migrlegsindicato_Datalistfixedvalues = "" ;
      Combo_migrlegsindicato_Datalistproc = "" ;
      Combo_migrlegsindicato_Datalistprocparametersprefix = "" ;
      Combo_migrlegsindicato_Remoteservicesparameters = "" ;
      Combo_migrlegsindicato_Htmltemplate = "" ;
      Combo_migrlegsindicato_Multiplevaluestype = "" ;
      Combo_migrlegsindicato_Loadingdata = "" ;
      Combo_migrlegsindicato_Noresultsfound = "" ;
      Combo_migrlegsindicato_Emptyitemtext = "" ;
      Combo_migrlegsindicato_Onlyselectedvalues = "" ;
      Combo_migrlegsindicato_Selectalltext = "" ;
      Combo_migrlegsindicato_Multiplevaluesseparator = "" ;
      Combo_migrlegsindicato_Addnewoptiontext = "" ;
      Combo_migrlegconvenio_Objectcall = "" ;
      Combo_migrlegconvenio_Class = "" ;
      Combo_migrlegconvenio_Icontype = "" ;
      Combo_migrlegconvenio_Icon = "" ;
      Combo_migrlegconvenio_Tooltip = "" ;
      Combo_migrlegconvenio_Selectedvalue_set = "" ;
      Combo_migrlegconvenio_Selectedtext_set = "" ;
      Combo_migrlegconvenio_Selectedtext_get = "" ;
      Combo_migrlegconvenio_Gamoauthtoken = "" ;
      Combo_migrlegconvenio_Ddointernalname = "" ;
      Combo_migrlegconvenio_Titlecontrolalign = "" ;
      Combo_migrlegconvenio_Dropdownoptionstype = "" ;
      Combo_migrlegconvenio_Titlecontrolidtoreplace = "" ;
      Combo_migrlegconvenio_Datalisttype = "" ;
      Combo_migrlegconvenio_Datalistfixedvalues = "" ;
      Combo_migrlegconvenio_Datalistproc = "" ;
      Combo_migrlegconvenio_Datalistprocparametersprefix = "" ;
      Combo_migrlegconvenio_Remoteservicesparameters = "" ;
      Combo_migrlegconvenio_Htmltemplate = "" ;
      Combo_migrlegconvenio_Multiplevaluestype = "" ;
      Combo_migrlegconvenio_Loadingdata = "" ;
      Combo_migrlegconvenio_Noresultsfound = "" ;
      Combo_migrlegconvenio_Emptyitemtext = "" ;
      Combo_migrlegconvenio_Onlyselectedvalues = "" ;
      Combo_migrlegconvenio_Selectalltext = "" ;
      Combo_migrlegconvenio_Multiplevaluesseparator = "" ;
      Combo_migrlegconvenio_Addnewoptiontext = "" ;
      Combo_migrlegcategoria_Objectcall = "" ;
      Combo_migrlegcategoria_Class = "" ;
      Combo_migrlegcategoria_Icontype = "" ;
      Combo_migrlegcategoria_Icon = "" ;
      Combo_migrlegcategoria_Tooltip = "" ;
      Combo_migrlegcategoria_Selectedvalue_set = "" ;
      Combo_migrlegcategoria_Selectedtext_set = "" ;
      Combo_migrlegcategoria_Selectedtext_get = "" ;
      Combo_migrlegcategoria_Gamoauthtoken = "" ;
      Combo_migrlegcategoria_Ddointernalname = "" ;
      Combo_migrlegcategoria_Titlecontrolalign = "" ;
      Combo_migrlegcategoria_Dropdownoptionstype = "" ;
      Combo_migrlegcategoria_Titlecontrolidtoreplace = "" ;
      Combo_migrlegcategoria_Datalisttype = "" ;
      Combo_migrlegcategoria_Datalistfixedvalues = "" ;
      Combo_migrlegcategoria_Datalistproc = "" ;
      Combo_migrlegcategoria_Datalistprocparametersprefix = "" ;
      Combo_migrlegcategoria_Remoteservicesparameters = "" ;
      Combo_migrlegcategoria_Htmltemplate = "" ;
      Combo_migrlegcategoria_Multiplevaluestype = "" ;
      Combo_migrlegcategoria_Loadingdata = "" ;
      Combo_migrlegcategoria_Noresultsfound = "" ;
      Combo_migrlegcategoria_Emptyitemtext = "" ;
      Combo_migrlegcategoria_Onlyselectedvalues = "" ;
      Combo_migrlegcategoria_Selectalltext = "" ;
      Combo_migrlegcategoria_Multiplevaluesseparator = "" ;
      Combo_migrlegcategoria_Addnewoptiontext = "" ;
      Combo_migrlegbanco_Objectcall = "" ;
      Combo_migrlegbanco_Class = "" ;
      Combo_migrlegbanco_Icontype = "" ;
      Combo_migrlegbanco_Icon = "" ;
      Combo_migrlegbanco_Tooltip = "" ;
      Combo_migrlegbanco_Selectedvalue_set = "" ;
      Combo_migrlegbanco_Selectedtext_set = "" ;
      Combo_migrlegbanco_Selectedtext_get = "" ;
      Combo_migrlegbanco_Gamoauthtoken = "" ;
      Combo_migrlegbanco_Ddointernalname = "" ;
      Combo_migrlegbanco_Titlecontrolalign = "" ;
      Combo_migrlegbanco_Dropdownoptionstype = "" ;
      Combo_migrlegbanco_Titlecontrolidtoreplace = "" ;
      Combo_migrlegbanco_Datalisttype = "" ;
      Combo_migrlegbanco_Datalistfixedvalues = "" ;
      Combo_migrlegbanco_Datalistproc = "" ;
      Combo_migrlegbanco_Datalistprocparametersprefix = "" ;
      Combo_migrlegbanco_Remoteservicesparameters = "" ;
      Combo_migrlegbanco_Htmltemplate = "" ;
      Combo_migrlegbanco_Multiplevaluestype = "" ;
      Combo_migrlegbanco_Loadingdata = "" ;
      Combo_migrlegbanco_Noresultsfound = "" ;
      Combo_migrlegbanco_Emptyitemtext = "" ;
      Combo_migrlegbanco_Onlyselectedvalues = "" ;
      Combo_migrlegbanco_Selectalltext = "" ;
      Combo_migrlegbanco_Multiplevaluesseparator = "" ;
      Combo_migrlegbanco_Addnewoptiontext = "" ;
      Combo_migrlegobrasocial_Objectcall = "" ;
      Combo_migrlegobrasocial_Class = "" ;
      Combo_migrlegobrasocial_Icontype = "" ;
      Combo_migrlegobrasocial_Icon = "" ;
      Combo_migrlegobrasocial_Tooltip = "" ;
      Combo_migrlegobrasocial_Selectedvalue_set = "" ;
      Combo_migrlegobrasocial_Selectedtext_set = "" ;
      Combo_migrlegobrasocial_Selectedtext_get = "" ;
      Combo_migrlegobrasocial_Gamoauthtoken = "" ;
      Combo_migrlegobrasocial_Ddointernalname = "" ;
      Combo_migrlegobrasocial_Titlecontrolalign = "" ;
      Combo_migrlegobrasocial_Dropdownoptionstype = "" ;
      Combo_migrlegobrasocial_Titlecontrolidtoreplace = "" ;
      Combo_migrlegobrasocial_Datalisttype = "" ;
      Combo_migrlegobrasocial_Datalistfixedvalues = "" ;
      Combo_migrlegobrasocial_Datalistproc = "" ;
      Combo_migrlegobrasocial_Datalistprocparametersprefix = "" ;
      Combo_migrlegobrasocial_Remoteservicesparameters = "" ;
      Combo_migrlegobrasocial_Htmltemplate = "" ;
      Combo_migrlegobrasocial_Multiplevaluestype = "" ;
      Combo_migrlegobrasocial_Loadingdata = "" ;
      Combo_migrlegobrasocial_Noresultsfound = "" ;
      Combo_migrlegobrasocial_Emptyitemtext = "" ;
      Combo_migrlegobrasocial_Onlyselectedvalues = "" ;
      Combo_migrlegobrasocial_Selectalltext = "" ;
      Combo_migrlegobrasocial_Multiplevaluesseparator = "" ;
      Combo_migrlegobrasocial_Addnewoptiontext = "" ;
      Combo_migrlegmodalidad_Objectcall = "" ;
      Combo_migrlegmodalidad_Class = "" ;
      Combo_migrlegmodalidad_Icontype = "" ;
      Combo_migrlegmodalidad_Icon = "" ;
      Combo_migrlegmodalidad_Tooltip = "" ;
      Combo_migrlegmodalidad_Selectedvalue_set = "" ;
      Combo_migrlegmodalidad_Selectedtext_set = "" ;
      Combo_migrlegmodalidad_Selectedtext_get = "" ;
      Combo_migrlegmodalidad_Gamoauthtoken = "" ;
      Combo_migrlegmodalidad_Ddointernalname = "" ;
      Combo_migrlegmodalidad_Titlecontrolalign = "" ;
      Combo_migrlegmodalidad_Dropdownoptionstype = "" ;
      Combo_migrlegmodalidad_Titlecontrolidtoreplace = "" ;
      Combo_migrlegmodalidad_Datalisttype = "" ;
      Combo_migrlegmodalidad_Datalistfixedvalues = "" ;
      Combo_migrlegmodalidad_Datalistproc = "" ;
      Combo_migrlegmodalidad_Datalistprocparametersprefix = "" ;
      Combo_migrlegmodalidad_Remoteservicesparameters = "" ;
      Combo_migrlegmodalidad_Htmltemplate = "" ;
      Combo_migrlegmodalidad_Multiplevaluestype = "" ;
      Combo_migrlegmodalidad_Loadingdata = "" ;
      Combo_migrlegmodalidad_Noresultsfound = "" ;
      Combo_migrlegmodalidad_Emptyitemtext = "" ;
      Combo_migrlegmodalidad_Onlyselectedvalues = "" ;
      Combo_migrlegmodalidad_Selectalltext = "" ;
      Combo_migrlegmodalidad_Multiplevaluesseparator = "" ;
      Combo_migrlegmodalidad_Addnewoptiontext = "" ;
      Combo_migrlegzona_Objectcall = "" ;
      Combo_migrlegzona_Class = "" ;
      Combo_migrlegzona_Icontype = "" ;
      Combo_migrlegzona_Icon = "" ;
      Combo_migrlegzona_Tooltip = "" ;
      Combo_migrlegzona_Selectedvalue_set = "" ;
      Combo_migrlegzona_Selectedtext_set = "" ;
      Combo_migrlegzona_Selectedtext_get = "" ;
      Combo_migrlegzona_Gamoauthtoken = "" ;
      Combo_migrlegzona_Ddointernalname = "" ;
      Combo_migrlegzona_Titlecontrolalign = "" ;
      Combo_migrlegzona_Dropdownoptionstype = "" ;
      Combo_migrlegzona_Titlecontrolidtoreplace = "" ;
      Combo_migrlegzona_Datalisttype = "" ;
      Combo_migrlegzona_Datalistfixedvalues = "" ;
      Combo_migrlegzona_Datalistproc = "" ;
      Combo_migrlegzona_Datalistprocparametersprefix = "" ;
      Combo_migrlegzona_Remoteservicesparameters = "" ;
      Combo_migrlegzona_Htmltemplate = "" ;
      Combo_migrlegzona_Multiplevaluestype = "" ;
      Combo_migrlegzona_Loadingdata = "" ;
      Combo_migrlegzona_Noresultsfound = "" ;
      Combo_migrlegzona_Emptyitemtext = "" ;
      Combo_migrlegzona_Onlyselectedvalues = "" ;
      Combo_migrlegzona_Selectalltext = "" ;
      Combo_migrlegzona_Multiplevaluesseparator = "" ;
      Combo_migrlegzona_Addnewoptiontext = "" ;
      Combo_migrlegactividad_Objectcall = "" ;
      Combo_migrlegactividad_Class = "" ;
      Combo_migrlegactividad_Icontype = "" ;
      Combo_migrlegactividad_Icon = "" ;
      Combo_migrlegactividad_Tooltip = "" ;
      Combo_migrlegactividad_Selectedvalue_set = "" ;
      Combo_migrlegactividad_Selectedtext_set = "" ;
      Combo_migrlegactividad_Selectedtext_get = "" ;
      Combo_migrlegactividad_Gamoauthtoken = "" ;
      Combo_migrlegactividad_Ddointernalname = "" ;
      Combo_migrlegactividad_Titlecontrolalign = "" ;
      Combo_migrlegactividad_Dropdownoptionstype = "" ;
      Combo_migrlegactividad_Titlecontrolidtoreplace = "" ;
      Combo_migrlegactividad_Datalisttype = "" ;
      Combo_migrlegactividad_Datalistfixedvalues = "" ;
      Combo_migrlegactividad_Datalistproc = "" ;
      Combo_migrlegactividad_Datalistprocparametersprefix = "" ;
      Combo_migrlegactividad_Remoteservicesparameters = "" ;
      Combo_migrlegactividad_Htmltemplate = "" ;
      Combo_migrlegactividad_Multiplevaluestype = "" ;
      Combo_migrlegactividad_Loadingdata = "" ;
      Combo_migrlegactividad_Noresultsfound = "" ;
      Combo_migrlegactividad_Emptyitemtext = "" ;
      Combo_migrlegactividad_Onlyselectedvalues = "" ;
      Combo_migrlegactividad_Selectalltext = "" ;
      Combo_migrlegactividad_Multiplevaluesseparator = "" ;
      Combo_migrlegactividad_Addnewoptiontext = "" ;
      Combo_migrlegcondicion_Objectcall = "" ;
      Combo_migrlegcondicion_Class = "" ;
      Combo_migrlegcondicion_Icontype = "" ;
      Combo_migrlegcondicion_Icon = "" ;
      Combo_migrlegcondicion_Tooltip = "" ;
      Combo_migrlegcondicion_Selectedvalue_set = "" ;
      Combo_migrlegcondicion_Selectedtext_set = "" ;
      Combo_migrlegcondicion_Selectedtext_get = "" ;
      Combo_migrlegcondicion_Gamoauthtoken = "" ;
      Combo_migrlegcondicion_Ddointernalname = "" ;
      Combo_migrlegcondicion_Titlecontrolalign = "" ;
      Combo_migrlegcondicion_Dropdownoptionstype = "" ;
      Combo_migrlegcondicion_Titlecontrolidtoreplace = "" ;
      Combo_migrlegcondicion_Datalisttype = "" ;
      Combo_migrlegcondicion_Datalistfixedvalues = "" ;
      Combo_migrlegcondicion_Datalistproc = "" ;
      Combo_migrlegcondicion_Datalistprocparametersprefix = "" ;
      Combo_migrlegcondicion_Remoteservicesparameters = "" ;
      Combo_migrlegcondicion_Htmltemplate = "" ;
      Combo_migrlegcondicion_Multiplevaluestype = "" ;
      Combo_migrlegcondicion_Loadingdata = "" ;
      Combo_migrlegcondicion_Noresultsfound = "" ;
      Combo_migrlegcondicion_Emptyitemtext = "" ;
      Combo_migrlegcondicion_Onlyselectedvalues = "" ;
      Combo_migrlegcondicion_Selectalltext = "" ;
      Combo_migrlegcondicion_Multiplevaluesseparator = "" ;
      Combo_migrlegcondicion_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode75 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV25MigrLegArea = "" ;
      GXv_char1 = new String[1] ;
      AV36MigrLegLugarDePago = "" ;
      GXv_char2 = new String[1] ;
      AV30MigrLegCategoria = "" ;
      GXv_char3 = new String[1] ;
      AV28MigrLegBanco = "" ;
      GXv_char4 = new String[1] ;
      AV45MigrLegSindicato = "" ;
      GXv_char5 = new String[1] ;
      AV41MigrLegObraSocial = "" ;
      GXv_char6 = new String[1] ;
      AV43MigrLegPlanMedico = "" ;
      GXv_char7 = new String[1] ;
      AV23MigrLegActividad = "" ;
      GXv_char8 = new String[1] ;
      AV38MigrLegModalidad = "" ;
      GXv_char9 = new String[1] ;
      AV51MigrLegZona = "" ;
      GXv_char10 = new String[1] ;
      AV49MigrLegSituacionRevista = "" ;
      GXv_char11 = new String[1] ;
      AV34MigrLegConvenio = "" ;
      GXv_char12 = new String[1] ;
      AV32MigrLegCondicion = "" ;
      GXv_char13 = new String[1] ;
      AV47MigrLegSiniestrado = "" ;
      GXv_char14 = new String[1] ;
      AV90MigrLegSexo = "" ;
      GXv_char15 = new String[1] ;
      AV195MigrLegModTra = "" ;
      GXv_char16 = new String[1] ;
      AV196MigrLegTipoTarifa = "" ;
      GXv_char17 = new String[1] ;
      AV94MigrLegClase = "" ;
      GXv_char18 = new String[1] ;
      AV105MigrLegEstadoCivil = "" ;
      GXv_char19 = new String[1] ;
      AV109MigrLegBanTipCuen = "" ;
      GXv_char20 = new String[1] ;
      AV106MigrLegDiscapacidad = "" ;
      GXv_char21 = new String[1] ;
      AV107MigrLegFormaPago = "" ;
      AV100MigrLegSCVO = "" ;
      AV101MigrTieneConyuge = "" ;
      AV181start_MigrLegConvenio = "" ;
      AV55WebSession = httpContext.getWebSession();
      AV56WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext27 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV54TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV69warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15ComboSelectedValue = "" ;
      AV153valorFiltro = "" ;
      AV186OsoDescrip = "" ;
      AV187OsoCod = "" ;
      AV183ConveCodigo = "" ;
      AV194ZonCod = "" ;
      GXv_objcol_svchar31 = new GXSimpleCollection[1] ;
      GXv_char22 = new String[1] ;
      AV193auxDependencia = "" ;
      GXt_objcol_SdtDVB_SDTComboData_Item33 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTComboData_Item34 = new GXBaseCollection[1] ;
      GXv_boolean26 = new boolean[1] ;
      GXv_boolean25 = new boolean[1] ;
      AV75claseError = "" ;
      AV204GXV1 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV197LegModTra = "" ;
      AV198modTraError = "" ;
      AV206GXV3 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV199modo_trabajo = "" ;
      AV200LegTipoTarifa = "" ;
      AV201tipoTarifaError = "" ;
      AV208GXV5 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV202tipo_tarifa = "" ;
      Z628MigrLegObs = "" ;
      Z629MigrLegErrores = "" ;
      Z633MigrLegWarnings = "" ;
      Z2206MigrOtrosDatos = "" ;
      T00285_A87MigrLegNumero = new int[1] ;
      T00285_A595MigrLegSexo = new String[] {""} ;
      T00285_A596MigrLegEstadoCivil = new String[] {""} ;
      T00285_A605MigrLegArea = new String[] {""} ;
      T00285_A613MigrLegSindicato = new String[] {""} ;
      T00285_A627MigrLegConvenio = new String[] {""} ;
      T00285_A604MigrLegCategoria = new String[] {""} ;
      T00285_A610MigrLegBanco = new String[] {""} ;
      T00285_A614MigrLegObraSocial = new String[] {""} ;
      T00285_A617MigrLegModalidad = new String[] {""} ;
      T00285_A620MigrLegZona = new String[] {""} ;
      T00285_A616MigrLegActividad = new String[] {""} ;
      T00285_A624MigrLegCondicion = new String[] {""} ;
      T00285_A592MigrLegApellido = new String[] {""} ;
      T00285_A593MigrLegNombre = new String[] {""} ;
      T00285_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00285_A597MigrLegCUIL = new String[] {""} ;
      T00285_A598MigrLegDiscapacidad = new String[] {""} ;
      T00285_A599MigrLegDomici = new String[] {""} ;
      T00285_A600MigrLegEmail = new String[] {""} ;
      T00285_A601MigrLegCodPos = new String[] {""} ;
      T00285_A602MigrLegTelefono = new String[] {""} ;
      T00285_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00285_A606MigrLegLugarDePago = new String[] {""} ;
      T00285_A2415MigrLegModTra = new String[] {""} ;
      T00285_A607MigrLegClase = new String[] {""} ;
      T00285_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00285_A609MigrLegFormaPago = new String[] {""} ;
      T00285_A611MigrLegBanSuc = new String[] {""} ;
      T00285_A612MigrLegBanTipCuen = new String[] {""} ;
      T00285_A634MigrLegOSAfip = new String[] {""} ;
      T00285_A615MigrLegPlanMedico = new String[] {""} ;
      T00285_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00285_A619MigrLegCuentaBanc = new String[] {""} ;
      T00285_A621MigrLegCBU = new String[] {""} ;
      T00285_A622MigrLegSCVO = new String[] {""} ;
      T00285_A623MigrLegSituacionRevista = new String[] {""} ;
      T00285_A2239MigrLegActLabClas = new String[] {""} ;
      T00285_A2240MigrLegPueAfip = new String[] {""} ;
      T00285_A625MigrLegSiniestrado = new String[] {""} ;
      T00285_A626MigrLegId = new String[] {""} ;
      T00285_A628MigrLegObs = new String[] {""} ;
      T00285_A629MigrLegErrores = new String[] {""} ;
      T00285_A633MigrLegWarnings = new String[] {""} ;
      T00285_A631MigrTieneConyuge = new String[] {""} ;
      T00285_A632MigrCantidadHijos = new short[1] ;
      T00285_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00285_A689MigrLegAreaDef = new boolean[] {false} ;
      T00285_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00285_A691MigrLegClaseDef = new boolean[] {false} ;
      T00285_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00285_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00285_A694MigrLegActividadDef = new boolean[] {false} ;
      T00285_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00285_A696MigrLegZonaDef = new boolean[] {false} ;
      T00285_A697MigrLegSCVODef = new boolean[] {false} ;
      T00285_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00285_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00285_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00285_A2216MigrPuesto = new String[] {""} ;
      T00285_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00285_A2206MigrOtrosDatos = new String[] {""} ;
      T00285_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00285_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00285_A3CliCod = new int[1] ;
      T00285_A1EmpCod = new short[1] ;
      T00284_A3CliCod = new int[1] ;
      T00286_A3CliCod = new int[1] ;
      T00287_A3CliCod = new int[1] ;
      T00287_A1EmpCod = new short[1] ;
      T00287_A87MigrLegNumero = new int[1] ;
      T00283_A87MigrLegNumero = new int[1] ;
      T00283_A595MigrLegSexo = new String[] {""} ;
      T00283_A596MigrLegEstadoCivil = new String[] {""} ;
      T00283_A605MigrLegArea = new String[] {""} ;
      T00283_A613MigrLegSindicato = new String[] {""} ;
      T00283_A627MigrLegConvenio = new String[] {""} ;
      T00283_A604MigrLegCategoria = new String[] {""} ;
      T00283_A610MigrLegBanco = new String[] {""} ;
      T00283_A614MigrLegObraSocial = new String[] {""} ;
      T00283_A617MigrLegModalidad = new String[] {""} ;
      T00283_A620MigrLegZona = new String[] {""} ;
      T00283_A616MigrLegActividad = new String[] {""} ;
      T00283_A624MigrLegCondicion = new String[] {""} ;
      T00283_A592MigrLegApellido = new String[] {""} ;
      T00283_A593MigrLegNombre = new String[] {""} ;
      T00283_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00283_A597MigrLegCUIL = new String[] {""} ;
      T00283_A598MigrLegDiscapacidad = new String[] {""} ;
      T00283_A599MigrLegDomici = new String[] {""} ;
      T00283_A600MigrLegEmail = new String[] {""} ;
      T00283_A601MigrLegCodPos = new String[] {""} ;
      T00283_A602MigrLegTelefono = new String[] {""} ;
      T00283_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00283_A606MigrLegLugarDePago = new String[] {""} ;
      T00283_A2415MigrLegModTra = new String[] {""} ;
      T00283_A607MigrLegClase = new String[] {""} ;
      T00283_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00283_A609MigrLegFormaPago = new String[] {""} ;
      T00283_A611MigrLegBanSuc = new String[] {""} ;
      T00283_A612MigrLegBanTipCuen = new String[] {""} ;
      T00283_A634MigrLegOSAfip = new String[] {""} ;
      T00283_A615MigrLegPlanMedico = new String[] {""} ;
      T00283_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00283_A619MigrLegCuentaBanc = new String[] {""} ;
      T00283_A621MigrLegCBU = new String[] {""} ;
      T00283_A622MigrLegSCVO = new String[] {""} ;
      T00283_A623MigrLegSituacionRevista = new String[] {""} ;
      T00283_A2239MigrLegActLabClas = new String[] {""} ;
      T00283_A2240MigrLegPueAfip = new String[] {""} ;
      T00283_A625MigrLegSiniestrado = new String[] {""} ;
      T00283_A626MigrLegId = new String[] {""} ;
      T00283_A628MigrLegObs = new String[] {""} ;
      T00283_A629MigrLegErrores = new String[] {""} ;
      T00283_A633MigrLegWarnings = new String[] {""} ;
      T00283_A631MigrTieneConyuge = new String[] {""} ;
      T00283_A632MigrCantidadHijos = new short[1] ;
      T00283_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00283_A689MigrLegAreaDef = new boolean[] {false} ;
      T00283_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00283_A691MigrLegClaseDef = new boolean[] {false} ;
      T00283_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00283_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00283_A694MigrLegActividadDef = new boolean[] {false} ;
      T00283_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00283_A696MigrLegZonaDef = new boolean[] {false} ;
      T00283_A697MigrLegSCVODef = new boolean[] {false} ;
      T00283_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00283_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00283_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00283_A2216MigrPuesto = new String[] {""} ;
      T00283_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00283_A2206MigrOtrosDatos = new String[] {""} ;
      T00283_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00283_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00283_A3CliCod = new int[1] ;
      T00283_A1EmpCod = new short[1] ;
      T00288_A3CliCod = new int[1] ;
      T00288_A1EmpCod = new short[1] ;
      T00288_A87MigrLegNumero = new int[1] ;
      T00289_A3CliCod = new int[1] ;
      T00289_A1EmpCod = new short[1] ;
      T00289_A87MigrLegNumero = new int[1] ;
      T00282_A87MigrLegNumero = new int[1] ;
      T00282_A595MigrLegSexo = new String[] {""} ;
      T00282_A596MigrLegEstadoCivil = new String[] {""} ;
      T00282_A605MigrLegArea = new String[] {""} ;
      T00282_A613MigrLegSindicato = new String[] {""} ;
      T00282_A627MigrLegConvenio = new String[] {""} ;
      T00282_A604MigrLegCategoria = new String[] {""} ;
      T00282_A610MigrLegBanco = new String[] {""} ;
      T00282_A614MigrLegObraSocial = new String[] {""} ;
      T00282_A617MigrLegModalidad = new String[] {""} ;
      T00282_A620MigrLegZona = new String[] {""} ;
      T00282_A616MigrLegActividad = new String[] {""} ;
      T00282_A624MigrLegCondicion = new String[] {""} ;
      T00282_A592MigrLegApellido = new String[] {""} ;
      T00282_A593MigrLegNombre = new String[] {""} ;
      T00282_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00282_A597MigrLegCUIL = new String[] {""} ;
      T00282_A598MigrLegDiscapacidad = new String[] {""} ;
      T00282_A599MigrLegDomici = new String[] {""} ;
      T00282_A600MigrLegEmail = new String[] {""} ;
      T00282_A601MigrLegCodPos = new String[] {""} ;
      T00282_A602MigrLegTelefono = new String[] {""} ;
      T00282_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00282_A606MigrLegLugarDePago = new String[] {""} ;
      T00282_A2415MigrLegModTra = new String[] {""} ;
      T00282_A607MigrLegClase = new String[] {""} ;
      T00282_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00282_A609MigrLegFormaPago = new String[] {""} ;
      T00282_A611MigrLegBanSuc = new String[] {""} ;
      T00282_A612MigrLegBanTipCuen = new String[] {""} ;
      T00282_A634MigrLegOSAfip = new String[] {""} ;
      T00282_A615MigrLegPlanMedico = new String[] {""} ;
      T00282_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00282_A619MigrLegCuentaBanc = new String[] {""} ;
      T00282_A621MigrLegCBU = new String[] {""} ;
      T00282_A622MigrLegSCVO = new String[] {""} ;
      T00282_A623MigrLegSituacionRevista = new String[] {""} ;
      T00282_A2239MigrLegActLabClas = new String[] {""} ;
      T00282_A2240MigrLegPueAfip = new String[] {""} ;
      T00282_A625MigrLegSiniestrado = new String[] {""} ;
      T00282_A626MigrLegId = new String[] {""} ;
      T00282_A628MigrLegObs = new String[] {""} ;
      T00282_A629MigrLegErrores = new String[] {""} ;
      T00282_A633MigrLegWarnings = new String[] {""} ;
      T00282_A631MigrTieneConyuge = new String[] {""} ;
      T00282_A632MigrCantidadHijos = new short[1] ;
      T00282_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00282_A689MigrLegAreaDef = new boolean[] {false} ;
      T00282_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00282_A691MigrLegClaseDef = new boolean[] {false} ;
      T00282_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00282_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00282_A694MigrLegActividadDef = new boolean[] {false} ;
      T00282_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00282_A696MigrLegZonaDef = new boolean[] {false} ;
      T00282_A697MigrLegSCVODef = new boolean[] {false} ;
      T00282_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00282_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00282_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00282_A2216MigrPuesto = new String[] {""} ;
      T00282_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00282_A2206MigrOtrosDatos = new String[] {""} ;
      T00282_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00282_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00282_A3CliCod = new int[1] ;
      T00282_A1EmpCod = new short[1] ;
      T002813_A3CliCod = new int[1] ;
      T002813_A1EmpCod = new short[1] ;
      T002813_A87MigrLegNumero = new int[1] ;
      T002813_A2078MigrLegFamSec = new short[1] ;
      T002814_A3CliCod = new int[1] ;
      T002814_A1EmpCod = new short[1] ;
      T002814_A87MigrLegNumero = new int[1] ;
      GXt_dtime43 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime44 = GXutil.resetTime( GXutil.nullDate() );
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXt_decimal45 = DecimalUtil.ZERO ;
      GXv_decimal46 = new java.math.BigDecimal[1] ;
      GXv_int42 = new short[1] ;
      GXv_int39 = new byte[1] ;
      GXv_boolean35 = new boolean[1] ;
      GXv_objcol_svchar32 = new GXSimpleCollection[1] ;
      GXv_char23 = new String[1] ;
      GXv_boolean36 = new boolean[1] ;
      T002815_A3CliCod = new int[1] ;
      ZV62LegNomApe = "" ;
      GXv_int38 = new int[1] ;
      ZV63LegIdNomApe = "" ;
      ZV64AuxMigrLegCategoria = "" ;
      ZV178modTexto = "" ;
      ZV175texto = "" ;
      ZV177actTexto = "" ;
      ZV180condTexto = "" ;
      ZV179sitRevTexto = "" ;
      GXt_char37 = "" ;
      GXv_char24 = new String[1] ;
      ZV176sinesTexto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.migrlegupd__default(),
         new Object[] {
             new Object[] {
            T00282_A87MigrLegNumero, T00282_A595MigrLegSexo, T00282_A596MigrLegEstadoCivil, T00282_A605MigrLegArea, T00282_A613MigrLegSindicato, T00282_A627MigrLegConvenio, T00282_A604MigrLegCategoria, T00282_A610MigrLegBanco, T00282_A614MigrLegObraSocial, T00282_A617MigrLegModalidad,
            T00282_A620MigrLegZona, T00282_A616MigrLegActividad, T00282_A624MigrLegCondicion, T00282_A592MigrLegApellido, T00282_A593MigrLegNombre, T00282_A594MigrLegFecNac, T00282_A597MigrLegCUIL, T00282_A598MigrLegDiscapacidad, T00282_A599MigrLegDomici, T00282_A600MigrLegEmail,
            T00282_A601MigrLegCodPos, T00282_A602MigrLegTelefono, T00282_A603MigrLegFecIngreso, T00282_A606MigrLegLugarDePago, T00282_A2415MigrLegModTra, T00282_A607MigrLegClase, T00282_A608MigrLegBasico, T00282_A609MigrLegFormaPago, T00282_A611MigrLegBanSuc, T00282_A612MigrLegBanTipCuen,
            T00282_A634MigrLegOSAfip, T00282_A615MigrLegPlanMedico, T00282_A618MigrLegFecUltMod, T00282_A619MigrLegCuentaBanc, T00282_A621MigrLegCBU, T00282_A622MigrLegSCVO, T00282_A623MigrLegSituacionRevista, T00282_A2239MigrLegActLabClas, T00282_A2240MigrLegPueAfip, T00282_A625MigrLegSiniestrado,
            T00282_A626MigrLegId, T00282_A628MigrLegObs, T00282_A629MigrLegErrores, T00282_A633MigrLegWarnings, T00282_A631MigrTieneConyuge, T00282_A632MigrCantidadHijos, T00282_A635MigrEncontroOsoSigla, T00282_A689MigrLegAreaDef, T00282_A690MigrLegEstadoCivilDef, T00282_A691MigrLegClaseDef,
            T00282_A692MigrLegFormaPagoDef, T00282_A693MigrLegTipoCuentaDef, T00282_A694MigrLegActividadDef, T00282_A695MigrLegModalidadDef, T00282_A696MigrLegZonaDef, T00282_A697MigrLegSCVODef, T00282_A698MigrLegSituacionDef, T00282_A699MigrLegCondicionDef, T00282_A700MigrLegSiniestradoDef, T00282_A2216MigrPuesto,
            T00282_A2205MigrLegFecEgreso, T00282_A2206MigrOtrosDatos, T00282_A2275MigrLegHorSem, T00282_A2427MigrLegTipoTarifa, T00282_A3CliCod, T00282_A1EmpCod
            }
            , new Object[] {
            T00283_A87MigrLegNumero, T00283_A595MigrLegSexo, T00283_A596MigrLegEstadoCivil, T00283_A605MigrLegArea, T00283_A613MigrLegSindicato, T00283_A627MigrLegConvenio, T00283_A604MigrLegCategoria, T00283_A610MigrLegBanco, T00283_A614MigrLegObraSocial, T00283_A617MigrLegModalidad,
            T00283_A620MigrLegZona, T00283_A616MigrLegActividad, T00283_A624MigrLegCondicion, T00283_A592MigrLegApellido, T00283_A593MigrLegNombre, T00283_A594MigrLegFecNac, T00283_A597MigrLegCUIL, T00283_A598MigrLegDiscapacidad, T00283_A599MigrLegDomici, T00283_A600MigrLegEmail,
            T00283_A601MigrLegCodPos, T00283_A602MigrLegTelefono, T00283_A603MigrLegFecIngreso, T00283_A606MigrLegLugarDePago, T00283_A2415MigrLegModTra, T00283_A607MigrLegClase, T00283_A608MigrLegBasico, T00283_A609MigrLegFormaPago, T00283_A611MigrLegBanSuc, T00283_A612MigrLegBanTipCuen,
            T00283_A634MigrLegOSAfip, T00283_A615MigrLegPlanMedico, T00283_A618MigrLegFecUltMod, T00283_A619MigrLegCuentaBanc, T00283_A621MigrLegCBU, T00283_A622MigrLegSCVO, T00283_A623MigrLegSituacionRevista, T00283_A2239MigrLegActLabClas, T00283_A2240MigrLegPueAfip, T00283_A625MigrLegSiniestrado,
            T00283_A626MigrLegId, T00283_A628MigrLegObs, T00283_A629MigrLegErrores, T00283_A633MigrLegWarnings, T00283_A631MigrTieneConyuge, T00283_A632MigrCantidadHijos, T00283_A635MigrEncontroOsoSigla, T00283_A689MigrLegAreaDef, T00283_A690MigrLegEstadoCivilDef, T00283_A691MigrLegClaseDef,
            T00283_A692MigrLegFormaPagoDef, T00283_A693MigrLegTipoCuentaDef, T00283_A694MigrLegActividadDef, T00283_A695MigrLegModalidadDef, T00283_A696MigrLegZonaDef, T00283_A697MigrLegSCVODef, T00283_A698MigrLegSituacionDef, T00283_A699MigrLegCondicionDef, T00283_A700MigrLegSiniestradoDef, T00283_A2216MigrPuesto,
            T00283_A2205MigrLegFecEgreso, T00283_A2206MigrOtrosDatos, T00283_A2275MigrLegHorSem, T00283_A2427MigrLegTipoTarifa, T00283_A3CliCod, T00283_A1EmpCod
            }
            , new Object[] {
            T00284_A3CliCod
            }
            , new Object[] {
            T00285_A87MigrLegNumero, T00285_A595MigrLegSexo, T00285_A596MigrLegEstadoCivil, T00285_A605MigrLegArea, T00285_A613MigrLegSindicato, T00285_A627MigrLegConvenio, T00285_A604MigrLegCategoria, T00285_A610MigrLegBanco, T00285_A614MigrLegObraSocial, T00285_A617MigrLegModalidad,
            T00285_A620MigrLegZona, T00285_A616MigrLegActividad, T00285_A624MigrLegCondicion, T00285_A592MigrLegApellido, T00285_A593MigrLegNombre, T00285_A594MigrLegFecNac, T00285_A597MigrLegCUIL, T00285_A598MigrLegDiscapacidad, T00285_A599MigrLegDomici, T00285_A600MigrLegEmail,
            T00285_A601MigrLegCodPos, T00285_A602MigrLegTelefono, T00285_A603MigrLegFecIngreso, T00285_A606MigrLegLugarDePago, T00285_A2415MigrLegModTra, T00285_A607MigrLegClase, T00285_A608MigrLegBasico, T00285_A609MigrLegFormaPago, T00285_A611MigrLegBanSuc, T00285_A612MigrLegBanTipCuen,
            T00285_A634MigrLegOSAfip, T00285_A615MigrLegPlanMedico, T00285_A618MigrLegFecUltMod, T00285_A619MigrLegCuentaBanc, T00285_A621MigrLegCBU, T00285_A622MigrLegSCVO, T00285_A623MigrLegSituacionRevista, T00285_A2239MigrLegActLabClas, T00285_A2240MigrLegPueAfip, T00285_A625MigrLegSiniestrado,
            T00285_A626MigrLegId, T00285_A628MigrLegObs, T00285_A629MigrLegErrores, T00285_A633MigrLegWarnings, T00285_A631MigrTieneConyuge, T00285_A632MigrCantidadHijos, T00285_A635MigrEncontroOsoSigla, T00285_A689MigrLegAreaDef, T00285_A690MigrLegEstadoCivilDef, T00285_A691MigrLegClaseDef,
            T00285_A692MigrLegFormaPagoDef, T00285_A693MigrLegTipoCuentaDef, T00285_A694MigrLegActividadDef, T00285_A695MigrLegModalidadDef, T00285_A696MigrLegZonaDef, T00285_A697MigrLegSCVODef, T00285_A698MigrLegSituacionDef, T00285_A699MigrLegCondicionDef, T00285_A700MigrLegSiniestradoDef, T00285_A2216MigrPuesto,
            T00285_A2205MigrLegFecEgreso, T00285_A2206MigrOtrosDatos, T00285_A2275MigrLegHorSem, T00285_A2427MigrLegTipoTarifa, T00285_A3CliCod, T00285_A1EmpCod
            }
            , new Object[] {
            T00286_A3CliCod
            }
            , new Object[] {
            T00287_A3CliCod, T00287_A1EmpCod, T00287_A87MigrLegNumero
            }
            , new Object[] {
            T00288_A3CliCod, T00288_A1EmpCod, T00288_A87MigrLegNumero
            }
            , new Object[] {
            T00289_A3CliCod, T00289_A1EmpCod, T00289_A87MigrLegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002813_A3CliCod, T002813_A1EmpCod, T002813_A87MigrLegNumero, T002813_A2078MigrLegFamSec
            }
            , new Object[] {
            T002814_A3CliCod, T002814_A1EmpCod, T002814_A87MigrLegNumero
            }
            , new Object[] {
            T002815_A3CliCod
            }
         }
      );
      AV203Pgmname = "MigrLegUPD" ;
      WebComp_Wcimportarlegajofamilia = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte lblTextblockmigrlegmodtra_Fontbold ;
   private byte lblTextblockmigrlegtipotarifa_Fontbold ;
   private byte lblTextblockmigrlegclase_Fontbold ;
   private byte lblTextblockmigrlegsexo_Fontbold ;
   private byte lblTextblockmigrlegestadocivil_Fontbold ;
   private byte lblTextblockmigrlegarea_Fontbold ;
   private byte lblTextblockmigrlegsindicato_Fontbold ;
   private byte lblTextblockmigrlegconvenio_Fontbold ;
   private byte lblTextblockmigrlegcategoria_Fontbold ;
   private byte lblTextblockmigrlegobrasocial_Fontbold ;
   private byte lblTextblockmigrlegmodalidad_Fontbold ;
   private byte AV92ClaseLeg ;
   private byte AV98FormaDePago ;
   private byte AV93LegClase ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte GXv_int39[] ;
   private short wcpOAV18EmpCod ;
   private short Z1EmpCod ;
   private short Z632MigrCantidadHijos ;
   private short A1EmpCod ;
   private short AV18EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A632MigrCantidadHijos ;
   private short AV95EstadoCivil ;
   private short RcdFound75 ;
   private short nCmpId ;
   private short nIsDirty_75 ;
   private short GXt_int41 ;
   private short GXv_int42[] ;
   private int wcpOAV7CliCod ;
   private int wcpOAV40MigrLegNumero ;
   private int Z3CliCod ;
   private int Z87MigrLegNumero ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int AV40MigrLegNumero ;
   private int trnEnded ;
   private int edtMigrLegId_Enabled ;
   private int edtMigrLegCUIL_Enabled ;
   private int edtMigrLegApellido_Enabled ;
   private int edtMigrLegNombre_Enabled ;
   private int edtMigrLegFecNac_Enabled ;
   private int edtMigrLegFecIngreso_Enabled ;
   private int edtMigrLegSexo_Visible ;
   private int edtMigrLegSexo_Enabled ;
   private int edtMigrLegDomici_Enabled ;
   private int edtMigrLegCodPos_Enabled ;
   private int edtMigrLegTelefono_Enabled ;
   private int edtMigrLegEmail_Enabled ;
   private int edtMigrLegEstadoCivil_Visible ;
   private int edtMigrLegEstadoCivil_Enabled ;
   private int edtMigrLegArea_Visible ;
   private int edtMigrLegArea_Enabled ;
   private int edtMigrLegSindicato_Visible ;
   private int edtMigrLegSindicato_Enabled ;
   private int edtMigrLegConvenio_Visible ;
   private int edtMigrLegConvenio_Enabled ;
   private int edtMigrLegCategoria_Visible ;
   private int edtMigrLegCategoria_Enabled ;
   private int edtMigrLegBanco_Visible ;
   private int edtMigrLegBanco_Enabled ;
   private int edtMigrLegBasico_Enabled ;
   private int edtMigrLegObraSocial_Visible ;
   private int edtMigrLegObraSocial_Enabled ;
   private int edtMigrLegCBU_Enabled ;
   private int edtMigrLegModalidad_Visible ;
   private int edtMigrLegModalidad_Enabled ;
   private int edtMigrLegHorSem_Enabled ;
   private int edtMigrLegZona_Visible ;
   private int edtMigrLegZona_Enabled ;
   private int edtMigrLegActividad_Visible ;
   private int edtMigrLegActividad_Enabled ;
   private int edtMigrLegCondicion_Visible ;
   private int edtMigrLegCondicion_Enabled ;
   private int edtMigrLegActLabClas_Enabled ;
   private int edtMigrLegPueAfip_Enabled ;
   private int edtMigrLegObs_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int edtavCombomigrlegsexo_Visible ;
   private int edtavCombomigrlegsexo_Enabled ;
   private int edtavCombomigrlegestadocivil_Visible ;
   private int edtavCombomigrlegestadocivil_Enabled ;
   private int edtavCombomigrlegarea_Visible ;
   private int edtavCombomigrlegarea_Enabled ;
   private int edtavCombomigrlegsindicato_Visible ;
   private int edtavCombomigrlegsindicato_Enabled ;
   private int edtavCombomigrlegconvenio_Visible ;
   private int edtavCombomigrlegconvenio_Enabled ;
   private int edtavCombomigrlegcategoria_Visible ;
   private int edtavCombomigrlegcategoria_Enabled ;
   private int edtavCombomigrlegbanco_Visible ;
   private int edtavCombomigrlegbanco_Enabled ;
   private int edtavCombomigrlegobrasocial_Visible ;
   private int edtavCombomigrlegobrasocial_Enabled ;
   private int edtavCombomigrlegmodalidad_Visible ;
   private int edtavCombomigrlegmodalidad_Enabled ;
   private int edtavCombomigrlegzona_Visible ;
   private int edtavCombomigrlegzona_Enabled ;
   private int edtavCombomigrlegactividad_Visible ;
   private int edtavCombomigrlegactividad_Enabled ;
   private int edtavCombomigrlegcondicion_Visible ;
   private int edtavCombomigrlegcondicion_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int A87MigrLegNumero ;
   private int edtMigrLegNumero_Visible ;
   private int edtMigrLegNumero_Enabled ;
   private int edtMigrLegDiscapacidad_Visible ;
   private int edtMigrLegDiscapacidad_Enabled ;
   private int edtMigrLegOSAfip_Visible ;
   private int edtMigrLegOSAfip_Enabled ;
   private int edtMigrLegLugarDePago_Visible ;
   private int edtMigrLegLugarDePago_Enabled ;
   private int edtMigrLegBanSuc_Visible ;
   private int edtMigrLegBanSuc_Enabled ;
   private int edtMigrLegBanTipCuen_Visible ;
   private int edtMigrLegBanTipCuen_Enabled ;
   private int edtMigrLegCuentaBanc_Visible ;
   private int edtMigrLegCuentaBanc_Enabled ;
   private int edtMigrLegFormaPago_Visible ;
   private int edtMigrLegFormaPago_Enabled ;
   private int edtMigrLegSituacionRevista_Visible ;
   private int edtMigrLegSituacionRevista_Enabled ;
   private int edtMigrLegSiniestrado_Visible ;
   private int edtMigrLegSiniestrado_Enabled ;
   private int edtMigrLegSCVO_Visible ;
   private int edtMigrLegSCVO_Enabled ;
   private int edtMigrLegPlanMedico_Visible ;
   private int edtMigrLegPlanMedico_Enabled ;
   private int edtMigrTieneConyuge_Visible ;
   private int edtMigrTieneConyuge_Enabled ;
   private int edtMigrCantidadHijos_Enabled ;
   private int edtMigrCantidadHijos_Visible ;
   private int AV65LegNumeroPorId ;
   private int AV66LegNumeroPorCUIL ;
   private int Combo_migrlegsexo_Datalistupdateminimumcharacters ;
   private int Combo_migrlegsexo_Gxcontroltype ;
   private int Combo_migrlegestadocivil_Datalistupdateminimumcharacters ;
   private int Combo_migrlegestadocivil_Gxcontroltype ;
   private int Combo_migrlegarea_Datalistupdateminimumcharacters ;
   private int Combo_migrlegarea_Gxcontroltype ;
   private int Combo_migrlegsindicato_Datalistupdateminimumcharacters ;
   private int Combo_migrlegsindicato_Gxcontroltype ;
   private int Combo_migrlegconvenio_Datalistupdateminimumcharacters ;
   private int Combo_migrlegconvenio_Gxcontroltype ;
   private int Combo_migrlegcategoria_Datalistupdateminimumcharacters ;
   private int Combo_migrlegcategoria_Gxcontroltype ;
   private int Combo_migrlegbanco_Datalistupdateminimumcharacters ;
   private int Combo_migrlegbanco_Gxcontroltype ;
   private int Combo_migrlegobrasocial_Datalistupdateminimumcharacters ;
   private int Combo_migrlegobrasocial_Gxcontroltype ;
   private int Combo_migrlegmodalidad_Datalistupdateminimumcharacters ;
   private int Combo_migrlegmodalidad_Gxcontroltype ;
   private int Combo_migrlegzona_Datalistupdateminimumcharacters ;
   private int Combo_migrlegzona_Gxcontroltype ;
   private int Combo_migrlegactividad_Datalistupdateminimumcharacters ;
   private int Combo_migrlegactividad_Gxcontroltype ;
   private int Combo_migrlegcondicion_Datalistupdateminimumcharacters ;
   private int Combo_migrlegcondicion_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV205GXV2 ;
   private int AV207GXV4 ;
   private int AV209GXV6 ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int40 ;
   private int ZV65LegNumeroPorId ;
   private int GXv_int38[] ;
   private int ZV66LegNumeroPorCUIL ;
   private java.math.BigDecimal Z608MigrLegBasico ;
   private java.math.BigDecimal Z2275MigrLegHorSem ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
   private java.math.BigDecimal AV154CatBasico ;
   private java.math.BigDecimal GXt_decimal45 ;
   private java.math.BigDecimal GXv_decimal46[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z595MigrLegSexo ;
   private String Z597MigrLegCUIL ;
   private String Z598MigrLegDiscapacidad ;
   private String Z634MigrLegOSAfip ;
   private String Z622MigrLegSCVO ;
   private String Z626MigrLegId ;
   private String Z631MigrTieneConyuge ;
   private String O634MigrLegOSAfip ;
   private String N634MigrLegOSAfip ;
   private String Combo_migrlegcondicion_Selectedvalue_get ;
   private String Combo_migrlegactividad_Selectedvalue_get ;
   private String Combo_migrlegzona_Selectedvalue_get ;
   private String Combo_migrlegmodalidad_Selectedvalue_get ;
   private String Combo_migrlegobrasocial_Selectedvalue_get ;
   private String Combo_migrlegbanco_Selectedvalue_get ;
   private String Combo_migrlegcategoria_Selectedvalue_get ;
   private String Combo_migrlegconvenio_Selectedvalue_get ;
   private String Combo_migrlegsindicato_Selectedvalue_get ;
   private String Combo_migrlegarea_Selectedvalue_get ;
   private String Combo_migrlegestadocivil_Selectedvalue_get ;
   private String Combo_migrlegsexo_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A626MigrLegId ;
   private String A595MigrLegSexo ;
   private String A598MigrLegDiscapacidad ;
   private String A622MigrLegSCVO ;
   private String A631MigrTieneConyuge ;
   private String AV156CatCodigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMigrLegId_Internalname ;
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
   private String edtMigrLegId_Jsonclick ;
   private String edtMigrLegCUIL_Internalname ;
   private String A597MigrLegCUIL ;
   private String edtMigrLegCUIL_Jsonclick ;
   private String edtMigrLegApellido_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtMigrLegNombre_Internalname ;
   private String divTablesplittedmigrlegmodtra_Internalname ;
   private String lblTextblockmigrlegmodtra_Internalname ;
   private String lblTextblockmigrlegmodtra_Jsonclick ;
   private String tblTablemergedmigrlegmodtra_Internalname ;
   private String lblMigrlegmodtra_righttext_Internalname ;
   private String lblMigrlegmodtra_righttext_Caption ;
   private String lblMigrlegmodtra_righttext_Jsonclick ;
   private String divTablesplittedmigrlegtipotarifa_Internalname ;
   private String lblTextblockmigrlegtipotarifa_Internalname ;
   private String lblTextblockmigrlegtipotarifa_Jsonclick ;
   private String tblTablemergedmigrlegtipotarifa_Internalname ;
   private String lblMigrlegtipotarifa_righttext_Internalname ;
   private String lblMigrlegtipotarifa_righttext_Caption ;
   private String lblMigrlegtipotarifa_righttext_Jsonclick ;
   private String divTablesplittedmigrlegclase_Internalname ;
   private String lblTextblockmigrlegclase_Internalname ;
   private String lblTextblockmigrlegclase_Jsonclick ;
   private String tblTablemergedmigrlegclase_Internalname ;
   private String lblMigrlegclase_righttext_Internalname ;
   private String lblMigrlegclase_righttext_Caption ;
   private String lblMigrlegclase_righttext_Jsonclick ;
   private String edtMigrLegFecNac_Internalname ;
   private String edtMigrLegFecNac_Jsonclick ;
   private String edtMigrLegFecIngreso_Internalname ;
   private String edtMigrLegFecIngreso_Jsonclick ;
   private String divTablesplittedmigrlegsexo_Internalname ;
   private String lblTextblockmigrlegsexo_Internalname ;
   private String lblTextblockmigrlegsexo_Jsonclick ;
   private String tblTablemergedmigrlegsexo_Internalname ;
   private String Combo_migrlegsexo_Caption ;
   private String Combo_migrlegsexo_Cls ;
   private String Combo_migrlegsexo_Internalname ;
   private String edtMigrLegSexo_Internalname ;
   private String edtMigrLegSexo_Jsonclick ;
   private String lblMigrlegsexo_righttext_Internalname ;
   private String lblMigrlegsexo_righttext_Caption ;
   private String lblMigrlegsexo_righttext_Jsonclick ;
   private String edtMigrLegDomici_Internalname ;
   private String edtMigrLegCodPos_Internalname ;
   private String edtMigrLegTelefono_Internalname ;
   private String edtMigrLegEmail_Internalname ;
   private String edtMigrLegEmail_Jsonclick ;
   private String divTablesplittedmigrlegestadocivil_Internalname ;
   private String lblTextblockmigrlegestadocivil_Internalname ;
   private String lblTextblockmigrlegestadocivil_Jsonclick ;
   private String tblTablemergedmigrlegestadocivil_Internalname ;
   private String Combo_migrlegestadocivil_Caption ;
   private String Combo_migrlegestadocivil_Cls ;
   private String Combo_migrlegestadocivil_Internalname ;
   private String edtMigrLegEstadoCivil_Internalname ;
   private String lblMigrlegestadocivil_righttext_Internalname ;
   private String lblMigrlegestadocivil_righttext_Caption ;
   private String lblMigrlegestadocivil_righttext_Jsonclick ;
   private String divTablesplittedmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Jsonclick ;
   private String tblTablemergedmigrlegarea_Internalname ;
   private String Combo_migrlegarea_Caption ;
   private String Combo_migrlegarea_Cls ;
   private String Combo_migrlegarea_Internalname ;
   private String edtMigrLegArea_Internalname ;
   private String lblMigrlegarea_righttext_Internalname ;
   private String lblMigrlegarea_righttext_Caption ;
   private String lblMigrlegarea_righttext_Jsonclick ;
   private String divTablesplittedmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Jsonclick ;
   private String tblTablemergedmigrlegsindicato_Internalname ;
   private String Combo_migrlegsindicato_Caption ;
   private String Combo_migrlegsindicato_Cls ;
   private String Combo_migrlegsindicato_Internalname ;
   private String edtMigrLegSindicato_Internalname ;
   private String lblMigrlegsindicato_righttext_Internalname ;
   private String lblMigrlegsindicato_righttext_Caption ;
   private String lblMigrlegsindicato_righttext_Jsonclick ;
   private String divTablesplittedmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Jsonclick ;
   private String tblTablemergedmigrlegconvenio_Internalname ;
   private String Combo_migrlegconvenio_Caption ;
   private String Combo_migrlegconvenio_Cls ;
   private String Combo_migrlegconvenio_Internalname ;
   private String edtMigrLegConvenio_Internalname ;
   private String lblMigrlegconvenio_righttext_Internalname ;
   private String lblMigrlegconvenio_righttext_Caption ;
   private String lblMigrlegconvenio_righttext_Jsonclick ;
   private String divTablesplittedmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Jsonclick ;
   private String tblTablemergedmigrlegcategoria_Internalname ;
   private String Combo_migrlegcategoria_Caption ;
   private String Combo_migrlegcategoria_Cls ;
   private String Combo_migrlegcategoria_Internalname ;
   private String edtMigrLegCategoria_Internalname ;
   private String lblMigrlegcategoria_righttext_Internalname ;
   private String lblMigrlegcategoria_righttext_Caption ;
   private String lblMigrlegcategoria_righttext_Jsonclick ;
   private String divTablesplittedmigrlegbanco_Internalname ;
   private String lblTextblockmigrlegbanco_Internalname ;
   private String lblTextblockmigrlegbanco_Jsonclick ;
   private String tblTablemergedmigrlegbanco_Internalname ;
   private String Combo_migrlegbanco_Caption ;
   private String Combo_migrlegbanco_Cls ;
   private String Combo_migrlegbanco_Internalname ;
   private String edtMigrLegBanco_Internalname ;
   private String lblMigrlegbanco_righttext_Internalname ;
   private String lblMigrlegbanco_righttext_Caption ;
   private String lblMigrlegbanco_righttext_Jsonclick ;
   private String edtMigrLegBasico_Internalname ;
   private String edtMigrLegBasico_Jsonclick ;
   private String divTablesplittedmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Jsonclick ;
   private String tblTablemergedmigrlegobrasocial_Internalname ;
   private String Combo_migrlegobrasocial_Caption ;
   private String Combo_migrlegobrasocial_Cls ;
   private String Combo_migrlegobrasocial_Internalname ;
   private String edtMigrLegObraSocial_Internalname ;
   private String lblMigrlegobrasocial_righttext_Internalname ;
   private String lblMigrlegobrasocial_righttext_Caption ;
   private String lblMigrlegobrasocial_righttext_Jsonclick ;
   private String edtMigrLegCBU_Internalname ;
   private String edtMigrLegCBU_Jsonclick ;
   private String divTablesplittedmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Jsonclick ;
   private String tblTablemergedmigrlegmodalidad_Internalname ;
   private String Combo_migrlegmodalidad_Caption ;
   private String Combo_migrlegmodalidad_Cls ;
   private String Combo_migrlegmodalidad_Internalname ;
   private String edtMigrLegModalidad_Internalname ;
   private String lblMigrlegmodalidad_righttext_Internalname ;
   private String lblMigrlegmodalidad_righttext_Caption ;
   private String lblMigrlegmodalidad_righttext_Jsonclick ;
   private String edtMigrLegHorSem_Internalname ;
   private String edtMigrLegHorSem_Jsonclick ;
   private String divTablesplittedmigrlegzona_Internalname ;
   private String lblTextblockmigrlegzona_Internalname ;
   private String lblTextblockmigrlegzona_Jsonclick ;
   private String tblTablemergedmigrlegzona_Internalname ;
   private String Combo_migrlegzona_Caption ;
   private String Combo_migrlegzona_Cls ;
   private String Combo_migrlegzona_Internalname ;
   private String edtMigrLegZona_Internalname ;
   private String lblMigrlegzona_righttext_Internalname ;
   private String lblMigrlegzona_righttext_Caption ;
   private String lblMigrlegzona_righttext_Jsonclick ;
   private String divTablesplittedmigrlegactividad_Internalname ;
   private String lblTextblockmigrlegactividad_Internalname ;
   private String lblTextblockmigrlegactividad_Jsonclick ;
   private String tblTablemergedmigrlegactividad_Internalname ;
   private String Combo_migrlegactividad_Caption ;
   private String Combo_migrlegactividad_Cls ;
   private String Combo_migrlegactividad_Internalname ;
   private String edtMigrLegActividad_Internalname ;
   private String edtMigrLegActividad_Jsonclick ;
   private String lblMigrlegactividad_righttext_Internalname ;
   private String lblMigrlegactividad_righttext_Caption ;
   private String lblMigrlegactividad_righttext_Jsonclick ;
   private String divTablesplittedmigrlegcondicion_Internalname ;
   private String lblTextblockmigrlegcondicion_Internalname ;
   private String lblTextblockmigrlegcondicion_Jsonclick ;
   private String tblTablemergedmigrlegcondicion_Internalname ;
   private String Combo_migrlegcondicion_Caption ;
   private String Combo_migrlegcondicion_Cls ;
   private String Combo_migrlegcondicion_Internalname ;
   private String edtMigrLegCondicion_Internalname ;
   private String edtMigrLegCondicion_Jsonclick ;
   private String lblMigrlegcondicion_righttext_Internalname ;
   private String lblMigrlegcondicion_righttext_Caption ;
   private String lblMigrlegcondicion_righttext_Jsonclick ;
   private String edtMigrLegActLabClas_Internalname ;
   private String edtMigrLegActLabClas_Jsonclick ;
   private String edtMigrLegPueAfip_Internalname ;
   private String edtMigrLegObs_Internalname ;
   private String WebComp_Wcimportarlegajofamilia_Component ;
   private String OldWcimportarlegajofamilia ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_migrlegsexo_Internalname ;
   private String edtavCombomigrlegsexo_Internalname ;
   private String AV190ComboMigrLegSexo ;
   private String edtavCombomigrlegsexo_Jsonclick ;
   private String divSectionattribute_migrlegestadocivil_Internalname ;
   private String edtavCombomigrlegestadocivil_Internalname ;
   private String divSectionattribute_migrlegarea_Internalname ;
   private String edtavCombomigrlegarea_Internalname ;
   private String divSectionattribute_migrlegsindicato_Internalname ;
   private String edtavCombomigrlegsindicato_Internalname ;
   private String divSectionattribute_migrlegconvenio_Internalname ;
   private String edtavCombomigrlegconvenio_Internalname ;
   private String divSectionattribute_migrlegcategoria_Internalname ;
   private String edtavCombomigrlegcategoria_Internalname ;
   private String divSectionattribute_migrlegbanco_Internalname ;
   private String edtavCombomigrlegbanco_Internalname ;
   private String divSectionattribute_migrlegobrasocial_Internalname ;
   private String edtavCombomigrlegobrasocial_Internalname ;
   private String divSectionattribute_migrlegmodalidad_Internalname ;
   private String edtavCombomigrlegmodalidad_Internalname ;
   private String divSectionattribute_migrlegzona_Internalname ;
   private String edtavCombomigrlegzona_Internalname ;
   private String divSectionattribute_migrlegactividad_Internalname ;
   private String edtavCombomigrlegactividad_Internalname ;
   private String edtavCombomigrlegactividad_Jsonclick ;
   private String divSectionattribute_migrlegcondicion_Internalname ;
   private String edtavCombomigrlegcondicion_Internalname ;
   private String edtavCombomigrlegcondicion_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtMigrLegNumero_Internalname ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegDiscapacidad_Internalname ;
   private String edtMigrLegDiscapacidad_Jsonclick ;
   private String edtMigrLegOSAfip_Internalname ;
   private String A634MigrLegOSAfip ;
   private String edtMigrLegOSAfip_Jsonclick ;
   private String edtMigrLegLugarDePago_Internalname ;
   private String edtMigrLegLugarDePago_Jsonclick ;
   private String edtMigrLegBanSuc_Internalname ;
   private String edtMigrLegBanTipCuen_Internalname ;
   private String edtMigrLegBanTipCuen_Jsonclick ;
   private String edtMigrLegCuentaBanc_Internalname ;
   private String edtMigrLegCuentaBanc_Jsonclick ;
   private String edtMigrLegFormaPago_Internalname ;
   private String edtMigrLegSituacionRevista_Internalname ;
   private String edtMigrLegSituacionRevista_Jsonclick ;
   private String edtMigrLegSiniestrado_Internalname ;
   private String edtMigrLegSCVO_Internalname ;
   private String edtMigrLegSCVO_Jsonclick ;
   private String edtMigrLegPlanMedico_Internalname ;
   private String edtMigrTieneConyuge_Internalname ;
   private String edtMigrTieneConyuge_Jsonclick ;
   private String edtMigrCantidadHijos_Internalname ;
   private String edtMigrCantidadHijos_Jsonclick ;
   private String AV111tipoCuentaBanco ;
   private String AV203Pgmname ;
   private String Combo_migrlegsexo_Objectcall ;
   private String Combo_migrlegsexo_Class ;
   private String Combo_migrlegsexo_Icontype ;
   private String Combo_migrlegsexo_Icon ;
   private String Combo_migrlegsexo_Tooltip ;
   private String Combo_migrlegsexo_Selectedvalue_set ;
   private String Combo_migrlegsexo_Selectedtext_set ;
   private String Combo_migrlegsexo_Selectedtext_get ;
   private String Combo_migrlegsexo_Gamoauthtoken ;
   private String Combo_migrlegsexo_Ddointernalname ;
   private String Combo_migrlegsexo_Titlecontrolalign ;
   private String Combo_migrlegsexo_Dropdownoptionstype ;
   private String Combo_migrlegsexo_Titlecontrolidtoreplace ;
   private String Combo_migrlegsexo_Datalisttype ;
   private String Combo_migrlegsexo_Datalistfixedvalues ;
   private String Combo_migrlegsexo_Datalistproc ;
   private String Combo_migrlegsexo_Datalistprocparametersprefix ;
   private String Combo_migrlegsexo_Remoteservicesparameters ;
   private String Combo_migrlegsexo_Htmltemplate ;
   private String Combo_migrlegsexo_Multiplevaluestype ;
   private String Combo_migrlegsexo_Loadingdata ;
   private String Combo_migrlegsexo_Noresultsfound ;
   private String Combo_migrlegsexo_Emptyitemtext ;
   private String Combo_migrlegsexo_Onlyselectedvalues ;
   private String Combo_migrlegsexo_Selectalltext ;
   private String Combo_migrlegsexo_Multiplevaluesseparator ;
   private String Combo_migrlegsexo_Addnewoptiontext ;
   private String Combo_migrlegestadocivil_Objectcall ;
   private String Combo_migrlegestadocivil_Class ;
   private String Combo_migrlegestadocivil_Icontype ;
   private String Combo_migrlegestadocivil_Icon ;
   private String Combo_migrlegestadocivil_Tooltip ;
   private String Combo_migrlegestadocivil_Selectedvalue_set ;
   private String Combo_migrlegestadocivil_Selectedtext_set ;
   private String Combo_migrlegestadocivil_Selectedtext_get ;
   private String Combo_migrlegestadocivil_Gamoauthtoken ;
   private String Combo_migrlegestadocivil_Ddointernalname ;
   private String Combo_migrlegestadocivil_Titlecontrolalign ;
   private String Combo_migrlegestadocivil_Dropdownoptionstype ;
   private String Combo_migrlegestadocivil_Titlecontrolidtoreplace ;
   private String Combo_migrlegestadocivil_Datalisttype ;
   private String Combo_migrlegestadocivil_Datalistfixedvalues ;
   private String Combo_migrlegestadocivil_Datalistproc ;
   private String Combo_migrlegestadocivil_Datalistprocparametersprefix ;
   private String Combo_migrlegestadocivil_Remoteservicesparameters ;
   private String Combo_migrlegestadocivil_Htmltemplate ;
   private String Combo_migrlegestadocivil_Multiplevaluestype ;
   private String Combo_migrlegestadocivil_Loadingdata ;
   private String Combo_migrlegestadocivil_Noresultsfound ;
   private String Combo_migrlegestadocivil_Emptyitemtext ;
   private String Combo_migrlegestadocivil_Onlyselectedvalues ;
   private String Combo_migrlegestadocivil_Selectalltext ;
   private String Combo_migrlegestadocivil_Multiplevaluesseparator ;
   private String Combo_migrlegestadocivil_Addnewoptiontext ;
   private String Combo_migrlegarea_Objectcall ;
   private String Combo_migrlegarea_Class ;
   private String Combo_migrlegarea_Icontype ;
   private String Combo_migrlegarea_Icon ;
   private String Combo_migrlegarea_Tooltip ;
   private String Combo_migrlegarea_Selectedvalue_set ;
   private String Combo_migrlegarea_Selectedtext_set ;
   private String Combo_migrlegarea_Selectedtext_get ;
   private String Combo_migrlegarea_Gamoauthtoken ;
   private String Combo_migrlegarea_Ddointernalname ;
   private String Combo_migrlegarea_Titlecontrolalign ;
   private String Combo_migrlegarea_Dropdownoptionstype ;
   private String Combo_migrlegarea_Titlecontrolidtoreplace ;
   private String Combo_migrlegarea_Datalisttype ;
   private String Combo_migrlegarea_Datalistfixedvalues ;
   private String Combo_migrlegarea_Datalistproc ;
   private String Combo_migrlegarea_Datalistprocparametersprefix ;
   private String Combo_migrlegarea_Remoteservicesparameters ;
   private String Combo_migrlegarea_Htmltemplate ;
   private String Combo_migrlegarea_Multiplevaluestype ;
   private String Combo_migrlegarea_Loadingdata ;
   private String Combo_migrlegarea_Noresultsfound ;
   private String Combo_migrlegarea_Emptyitemtext ;
   private String Combo_migrlegarea_Onlyselectedvalues ;
   private String Combo_migrlegarea_Selectalltext ;
   private String Combo_migrlegarea_Multiplevaluesseparator ;
   private String Combo_migrlegarea_Addnewoptiontext ;
   private String Combo_migrlegsindicato_Objectcall ;
   private String Combo_migrlegsindicato_Class ;
   private String Combo_migrlegsindicato_Icontype ;
   private String Combo_migrlegsindicato_Icon ;
   private String Combo_migrlegsindicato_Tooltip ;
   private String Combo_migrlegsindicato_Selectedvalue_set ;
   private String Combo_migrlegsindicato_Selectedtext_set ;
   private String Combo_migrlegsindicato_Selectedtext_get ;
   private String Combo_migrlegsindicato_Gamoauthtoken ;
   private String Combo_migrlegsindicato_Ddointernalname ;
   private String Combo_migrlegsindicato_Titlecontrolalign ;
   private String Combo_migrlegsindicato_Dropdownoptionstype ;
   private String Combo_migrlegsindicato_Titlecontrolidtoreplace ;
   private String Combo_migrlegsindicato_Datalisttype ;
   private String Combo_migrlegsindicato_Datalistfixedvalues ;
   private String Combo_migrlegsindicato_Datalistproc ;
   private String Combo_migrlegsindicato_Datalistprocparametersprefix ;
   private String Combo_migrlegsindicato_Remoteservicesparameters ;
   private String Combo_migrlegsindicato_Htmltemplate ;
   private String Combo_migrlegsindicato_Multiplevaluestype ;
   private String Combo_migrlegsindicato_Loadingdata ;
   private String Combo_migrlegsindicato_Noresultsfound ;
   private String Combo_migrlegsindicato_Emptyitemtext ;
   private String Combo_migrlegsindicato_Onlyselectedvalues ;
   private String Combo_migrlegsindicato_Selectalltext ;
   private String Combo_migrlegsindicato_Multiplevaluesseparator ;
   private String Combo_migrlegsindicato_Addnewoptiontext ;
   private String Combo_migrlegconvenio_Objectcall ;
   private String Combo_migrlegconvenio_Class ;
   private String Combo_migrlegconvenio_Icontype ;
   private String Combo_migrlegconvenio_Icon ;
   private String Combo_migrlegconvenio_Tooltip ;
   private String Combo_migrlegconvenio_Selectedvalue_set ;
   private String Combo_migrlegconvenio_Selectedtext_set ;
   private String Combo_migrlegconvenio_Selectedtext_get ;
   private String Combo_migrlegconvenio_Gamoauthtoken ;
   private String Combo_migrlegconvenio_Ddointernalname ;
   private String Combo_migrlegconvenio_Titlecontrolalign ;
   private String Combo_migrlegconvenio_Dropdownoptionstype ;
   private String Combo_migrlegconvenio_Titlecontrolidtoreplace ;
   private String Combo_migrlegconvenio_Datalisttype ;
   private String Combo_migrlegconvenio_Datalistfixedvalues ;
   private String Combo_migrlegconvenio_Datalistproc ;
   private String Combo_migrlegconvenio_Datalistprocparametersprefix ;
   private String Combo_migrlegconvenio_Remoteservicesparameters ;
   private String Combo_migrlegconvenio_Htmltemplate ;
   private String Combo_migrlegconvenio_Multiplevaluestype ;
   private String Combo_migrlegconvenio_Loadingdata ;
   private String Combo_migrlegconvenio_Noresultsfound ;
   private String Combo_migrlegconvenio_Emptyitemtext ;
   private String Combo_migrlegconvenio_Onlyselectedvalues ;
   private String Combo_migrlegconvenio_Selectalltext ;
   private String Combo_migrlegconvenio_Multiplevaluesseparator ;
   private String Combo_migrlegconvenio_Addnewoptiontext ;
   private String Combo_migrlegcategoria_Objectcall ;
   private String Combo_migrlegcategoria_Class ;
   private String Combo_migrlegcategoria_Icontype ;
   private String Combo_migrlegcategoria_Icon ;
   private String Combo_migrlegcategoria_Tooltip ;
   private String Combo_migrlegcategoria_Selectedvalue_set ;
   private String Combo_migrlegcategoria_Selectedtext_set ;
   private String Combo_migrlegcategoria_Selectedtext_get ;
   private String Combo_migrlegcategoria_Gamoauthtoken ;
   private String Combo_migrlegcategoria_Ddointernalname ;
   private String Combo_migrlegcategoria_Titlecontrolalign ;
   private String Combo_migrlegcategoria_Dropdownoptionstype ;
   private String Combo_migrlegcategoria_Titlecontrolidtoreplace ;
   private String Combo_migrlegcategoria_Datalisttype ;
   private String Combo_migrlegcategoria_Datalistfixedvalues ;
   private String Combo_migrlegcategoria_Datalistproc ;
   private String Combo_migrlegcategoria_Datalistprocparametersprefix ;
   private String Combo_migrlegcategoria_Remoteservicesparameters ;
   private String Combo_migrlegcategoria_Htmltemplate ;
   private String Combo_migrlegcategoria_Multiplevaluestype ;
   private String Combo_migrlegcategoria_Loadingdata ;
   private String Combo_migrlegcategoria_Noresultsfound ;
   private String Combo_migrlegcategoria_Emptyitemtext ;
   private String Combo_migrlegcategoria_Onlyselectedvalues ;
   private String Combo_migrlegcategoria_Selectalltext ;
   private String Combo_migrlegcategoria_Multiplevaluesseparator ;
   private String Combo_migrlegcategoria_Addnewoptiontext ;
   private String Combo_migrlegbanco_Objectcall ;
   private String Combo_migrlegbanco_Class ;
   private String Combo_migrlegbanco_Icontype ;
   private String Combo_migrlegbanco_Icon ;
   private String Combo_migrlegbanco_Tooltip ;
   private String Combo_migrlegbanco_Selectedvalue_set ;
   private String Combo_migrlegbanco_Selectedtext_set ;
   private String Combo_migrlegbanco_Selectedtext_get ;
   private String Combo_migrlegbanco_Gamoauthtoken ;
   private String Combo_migrlegbanco_Ddointernalname ;
   private String Combo_migrlegbanco_Titlecontrolalign ;
   private String Combo_migrlegbanco_Dropdownoptionstype ;
   private String Combo_migrlegbanco_Titlecontrolidtoreplace ;
   private String Combo_migrlegbanco_Datalisttype ;
   private String Combo_migrlegbanco_Datalistfixedvalues ;
   private String Combo_migrlegbanco_Datalistproc ;
   private String Combo_migrlegbanco_Datalistprocparametersprefix ;
   private String Combo_migrlegbanco_Remoteservicesparameters ;
   private String Combo_migrlegbanco_Htmltemplate ;
   private String Combo_migrlegbanco_Multiplevaluestype ;
   private String Combo_migrlegbanco_Loadingdata ;
   private String Combo_migrlegbanco_Noresultsfound ;
   private String Combo_migrlegbanco_Emptyitemtext ;
   private String Combo_migrlegbanco_Onlyselectedvalues ;
   private String Combo_migrlegbanco_Selectalltext ;
   private String Combo_migrlegbanco_Multiplevaluesseparator ;
   private String Combo_migrlegbanco_Addnewoptiontext ;
   private String Combo_migrlegobrasocial_Objectcall ;
   private String Combo_migrlegobrasocial_Class ;
   private String Combo_migrlegobrasocial_Icontype ;
   private String Combo_migrlegobrasocial_Icon ;
   private String Combo_migrlegobrasocial_Tooltip ;
   private String Combo_migrlegobrasocial_Selectedvalue_set ;
   private String Combo_migrlegobrasocial_Selectedtext_set ;
   private String Combo_migrlegobrasocial_Selectedtext_get ;
   private String Combo_migrlegobrasocial_Gamoauthtoken ;
   private String Combo_migrlegobrasocial_Ddointernalname ;
   private String Combo_migrlegobrasocial_Titlecontrolalign ;
   private String Combo_migrlegobrasocial_Dropdownoptionstype ;
   private String Combo_migrlegobrasocial_Titlecontrolidtoreplace ;
   private String Combo_migrlegobrasocial_Datalisttype ;
   private String Combo_migrlegobrasocial_Datalistfixedvalues ;
   private String Combo_migrlegobrasocial_Datalistproc ;
   private String Combo_migrlegobrasocial_Datalistprocparametersprefix ;
   private String Combo_migrlegobrasocial_Remoteservicesparameters ;
   private String Combo_migrlegobrasocial_Htmltemplate ;
   private String Combo_migrlegobrasocial_Multiplevaluestype ;
   private String Combo_migrlegobrasocial_Loadingdata ;
   private String Combo_migrlegobrasocial_Noresultsfound ;
   private String Combo_migrlegobrasocial_Emptyitemtext ;
   private String Combo_migrlegobrasocial_Onlyselectedvalues ;
   private String Combo_migrlegobrasocial_Selectalltext ;
   private String Combo_migrlegobrasocial_Multiplevaluesseparator ;
   private String Combo_migrlegobrasocial_Addnewoptiontext ;
   private String Combo_migrlegmodalidad_Objectcall ;
   private String Combo_migrlegmodalidad_Class ;
   private String Combo_migrlegmodalidad_Icontype ;
   private String Combo_migrlegmodalidad_Icon ;
   private String Combo_migrlegmodalidad_Tooltip ;
   private String Combo_migrlegmodalidad_Selectedvalue_set ;
   private String Combo_migrlegmodalidad_Selectedtext_set ;
   private String Combo_migrlegmodalidad_Selectedtext_get ;
   private String Combo_migrlegmodalidad_Gamoauthtoken ;
   private String Combo_migrlegmodalidad_Ddointernalname ;
   private String Combo_migrlegmodalidad_Titlecontrolalign ;
   private String Combo_migrlegmodalidad_Dropdownoptionstype ;
   private String Combo_migrlegmodalidad_Titlecontrolidtoreplace ;
   private String Combo_migrlegmodalidad_Datalisttype ;
   private String Combo_migrlegmodalidad_Datalistfixedvalues ;
   private String Combo_migrlegmodalidad_Datalistproc ;
   private String Combo_migrlegmodalidad_Datalistprocparametersprefix ;
   private String Combo_migrlegmodalidad_Remoteservicesparameters ;
   private String Combo_migrlegmodalidad_Htmltemplate ;
   private String Combo_migrlegmodalidad_Multiplevaluestype ;
   private String Combo_migrlegmodalidad_Loadingdata ;
   private String Combo_migrlegmodalidad_Noresultsfound ;
   private String Combo_migrlegmodalidad_Emptyitemtext ;
   private String Combo_migrlegmodalidad_Onlyselectedvalues ;
   private String Combo_migrlegmodalidad_Selectalltext ;
   private String Combo_migrlegmodalidad_Multiplevaluesseparator ;
   private String Combo_migrlegmodalidad_Addnewoptiontext ;
   private String Combo_migrlegzona_Objectcall ;
   private String Combo_migrlegzona_Class ;
   private String Combo_migrlegzona_Icontype ;
   private String Combo_migrlegzona_Icon ;
   private String Combo_migrlegzona_Tooltip ;
   private String Combo_migrlegzona_Selectedvalue_set ;
   private String Combo_migrlegzona_Selectedtext_set ;
   private String Combo_migrlegzona_Selectedtext_get ;
   private String Combo_migrlegzona_Gamoauthtoken ;
   private String Combo_migrlegzona_Ddointernalname ;
   private String Combo_migrlegzona_Titlecontrolalign ;
   private String Combo_migrlegzona_Dropdownoptionstype ;
   private String Combo_migrlegzona_Titlecontrolidtoreplace ;
   private String Combo_migrlegzona_Datalisttype ;
   private String Combo_migrlegzona_Datalistfixedvalues ;
   private String Combo_migrlegzona_Datalistproc ;
   private String Combo_migrlegzona_Datalistprocparametersprefix ;
   private String Combo_migrlegzona_Remoteservicesparameters ;
   private String Combo_migrlegzona_Htmltemplate ;
   private String Combo_migrlegzona_Multiplevaluestype ;
   private String Combo_migrlegzona_Loadingdata ;
   private String Combo_migrlegzona_Noresultsfound ;
   private String Combo_migrlegzona_Emptyitemtext ;
   private String Combo_migrlegzona_Onlyselectedvalues ;
   private String Combo_migrlegzona_Selectalltext ;
   private String Combo_migrlegzona_Multiplevaluesseparator ;
   private String Combo_migrlegzona_Addnewoptiontext ;
   private String Combo_migrlegactividad_Objectcall ;
   private String Combo_migrlegactividad_Class ;
   private String Combo_migrlegactividad_Icontype ;
   private String Combo_migrlegactividad_Icon ;
   private String Combo_migrlegactividad_Tooltip ;
   private String Combo_migrlegactividad_Selectedvalue_set ;
   private String Combo_migrlegactividad_Selectedtext_set ;
   private String Combo_migrlegactividad_Selectedtext_get ;
   private String Combo_migrlegactividad_Gamoauthtoken ;
   private String Combo_migrlegactividad_Ddointernalname ;
   private String Combo_migrlegactividad_Titlecontrolalign ;
   private String Combo_migrlegactividad_Dropdownoptionstype ;
   private String Combo_migrlegactividad_Titlecontrolidtoreplace ;
   private String Combo_migrlegactividad_Datalisttype ;
   private String Combo_migrlegactividad_Datalistfixedvalues ;
   private String Combo_migrlegactividad_Datalistproc ;
   private String Combo_migrlegactividad_Datalistprocparametersprefix ;
   private String Combo_migrlegactividad_Remoteservicesparameters ;
   private String Combo_migrlegactividad_Htmltemplate ;
   private String Combo_migrlegactividad_Multiplevaluestype ;
   private String Combo_migrlegactividad_Loadingdata ;
   private String Combo_migrlegactividad_Noresultsfound ;
   private String Combo_migrlegactividad_Emptyitemtext ;
   private String Combo_migrlegactividad_Onlyselectedvalues ;
   private String Combo_migrlegactividad_Selectalltext ;
   private String Combo_migrlegactividad_Multiplevaluesseparator ;
   private String Combo_migrlegactividad_Addnewoptiontext ;
   private String Combo_migrlegcondicion_Objectcall ;
   private String Combo_migrlegcondicion_Class ;
   private String Combo_migrlegcondicion_Icontype ;
   private String Combo_migrlegcondicion_Icon ;
   private String Combo_migrlegcondicion_Tooltip ;
   private String Combo_migrlegcondicion_Selectedvalue_set ;
   private String Combo_migrlegcondicion_Selectedtext_set ;
   private String Combo_migrlegcondicion_Selectedtext_get ;
   private String Combo_migrlegcondicion_Gamoauthtoken ;
   private String Combo_migrlegcondicion_Ddointernalname ;
   private String Combo_migrlegcondicion_Titlecontrolalign ;
   private String Combo_migrlegcondicion_Dropdownoptionstype ;
   private String Combo_migrlegcondicion_Titlecontrolidtoreplace ;
   private String Combo_migrlegcondicion_Datalisttype ;
   private String Combo_migrlegcondicion_Datalistfixedvalues ;
   private String Combo_migrlegcondicion_Datalistproc ;
   private String Combo_migrlegcondicion_Datalistprocparametersprefix ;
   private String Combo_migrlegcondicion_Remoteservicesparameters ;
   private String Combo_migrlegcondicion_Htmltemplate ;
   private String Combo_migrlegcondicion_Multiplevaluestype ;
   private String Combo_migrlegcondicion_Loadingdata ;
   private String Combo_migrlegcondicion_Noresultsfound ;
   private String Combo_migrlegcondicion_Emptyitemtext ;
   private String Combo_migrlegcondicion_Onlyselectedvalues ;
   private String Combo_migrlegcondicion_Selectalltext ;
   private String Combo_migrlegcondicion_Multiplevaluesseparator ;
   private String Combo_migrlegcondicion_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode75 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String GXv_char11[] ;
   private String GXv_char12[] ;
   private String GXv_char13[] ;
   private String GXv_char14[] ;
   private String AV90MigrLegSexo ;
   private String GXv_char15[] ;
   private String GXv_char16[] ;
   private String GXv_char17[] ;
   private String GXv_char18[] ;
   private String GXv_char19[] ;
   private String GXv_char20[] ;
   private String AV106MigrLegDiscapacidad ;
   private String GXv_char21[] ;
   private String AV100MigrLegSCVO ;
   private String AV101MigrTieneConyuge ;
   private String AV187OsoCod ;
   private String AV183ConveCodigo ;
   private String AV194ZonCod ;
   private String GXv_char22[] ;
   private String AV197LegModTra ;
   private String AV199modo_trabajo ;
   private String AV200LegTipoTarifa ;
   private String AV202tipo_tarifa ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXv_char23[] ;
   private String GXt_char37 ;
   private String GXv_char24[] ;
   private java.util.Date GXt_dtime43 ;
   private java.util.Date GXt_dtime44 ;
   private java.util.Date Z594MigrLegFecNac ;
   private java.util.Date Z603MigrLegFecIngreso ;
   private java.util.Date Z618MigrLegFecUltMod ;
   private java.util.Date Z2205MigrLegFecEgreso ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date A603MigrLegFecIngreso ;
   private java.util.Date A618MigrLegFecUltMod ;
   private java.util.Date A2205MigrLegFecEgreso ;
   private boolean Z635MigrEncontroOsoSigla ;
   private boolean Z689MigrLegAreaDef ;
   private boolean Z690MigrLegEstadoCivilDef ;
   private boolean Z691MigrLegClaseDef ;
   private boolean Z692MigrLegFormaPagoDef ;
   private boolean Z693MigrLegTipoCuentaDef ;
   private boolean Z694MigrLegActividadDef ;
   private boolean Z695MigrLegModalidadDef ;
   private boolean Z696MigrLegZonaDef ;
   private boolean Z697MigrLegSCVODef ;
   private boolean Z698MigrLegSituacionDef ;
   private boolean Z699MigrLegCondicionDef ;
   private boolean Z700MigrLegSiniestradoDef ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_migrlegsexo_Emptyitem ;
   private boolean Combo_migrlegestadocivil_Emptyitem ;
   private boolean Combo_migrlegarea_Emptyitem ;
   private boolean Combo_migrlegsindicato_Emptyitem ;
   private boolean Combo_migrlegconvenio_Emptyitem ;
   private boolean Combo_migrlegcategoria_Emptyitem ;
   private boolean Combo_migrlegbanco_Emptyitem ;
   private boolean Combo_migrlegobrasocial_Emptyitem ;
   private boolean Combo_migrlegmodalidad_Emptyitem ;
   private boolean Combo_migrlegzona_Emptyitem ;
   private boolean Combo_migrlegactividad_Emptyitem ;
   private boolean Combo_migrlegcondicion_Emptyitem ;
   private boolean A635MigrEncontroOsoSigla ;
   private boolean A689MigrLegAreaDef ;
   private boolean A690MigrLegEstadoCivilDef ;
   private boolean A691MigrLegClaseDef ;
   private boolean A692MigrLegFormaPagoDef ;
   private boolean A693MigrLegTipoCuentaDef ;
   private boolean A694MigrLegActividadDef ;
   private boolean A695MigrLegModalidadDef ;
   private boolean A696MigrLegZonaDef ;
   private boolean A697MigrLegSCVODef ;
   private boolean A698MigrLegSituacionDef ;
   private boolean A699MigrLegCondicionDef ;
   private boolean A700MigrLegSiniestradoDef ;
   private boolean AV155categoriaExiste ;
   private boolean AV157siniestradoExiste ;
   private boolean AV159actividadExiste ;
   private boolean AV160ModalidadExiste ;
   private boolean AV161ZonaExiste ;
   private boolean AV162SituacionExiste ;
   private boolean AV163CondicionExiste ;
   private boolean AV168sexoExiste ;
   private boolean AV173estadoCivilExiste ;
   private boolean AV172discapacidadExiste ;
   private boolean AV167formadepagoExiste ;
   private boolean AV171scvoExiste ;
   private boolean AV170tieneConyugeExiste ;
   private boolean AV169tipocuentaExiste ;
   private boolean Combo_migrlegsexo_Enabled ;
   private boolean Combo_migrlegsexo_Visible ;
   private boolean Combo_migrlegsexo_Allowmultipleselection ;
   private boolean Combo_migrlegsexo_Isgriditem ;
   private boolean Combo_migrlegsexo_Hasdescription ;
   private boolean Combo_migrlegsexo_Includeonlyselectedoption ;
   private boolean Combo_migrlegsexo_Includeselectalloption ;
   private boolean Combo_migrlegsexo_Includeaddnewoption ;
   private boolean Combo_migrlegestadocivil_Enabled ;
   private boolean Combo_migrlegestadocivil_Visible ;
   private boolean Combo_migrlegestadocivil_Allowmultipleselection ;
   private boolean Combo_migrlegestadocivil_Isgriditem ;
   private boolean Combo_migrlegestadocivil_Hasdescription ;
   private boolean Combo_migrlegestadocivil_Includeonlyselectedoption ;
   private boolean Combo_migrlegestadocivil_Includeselectalloption ;
   private boolean Combo_migrlegestadocivil_Includeaddnewoption ;
   private boolean Combo_migrlegarea_Enabled ;
   private boolean Combo_migrlegarea_Visible ;
   private boolean Combo_migrlegarea_Allowmultipleselection ;
   private boolean Combo_migrlegarea_Isgriditem ;
   private boolean Combo_migrlegarea_Hasdescription ;
   private boolean Combo_migrlegarea_Includeonlyselectedoption ;
   private boolean Combo_migrlegarea_Includeselectalloption ;
   private boolean Combo_migrlegarea_Includeaddnewoption ;
   private boolean Combo_migrlegsindicato_Enabled ;
   private boolean Combo_migrlegsindicato_Visible ;
   private boolean Combo_migrlegsindicato_Allowmultipleselection ;
   private boolean Combo_migrlegsindicato_Isgriditem ;
   private boolean Combo_migrlegsindicato_Hasdescription ;
   private boolean Combo_migrlegsindicato_Includeonlyselectedoption ;
   private boolean Combo_migrlegsindicato_Includeselectalloption ;
   private boolean Combo_migrlegsindicato_Includeaddnewoption ;
   private boolean Combo_migrlegconvenio_Enabled ;
   private boolean Combo_migrlegconvenio_Visible ;
   private boolean Combo_migrlegconvenio_Allowmultipleselection ;
   private boolean Combo_migrlegconvenio_Isgriditem ;
   private boolean Combo_migrlegconvenio_Hasdescription ;
   private boolean Combo_migrlegconvenio_Includeonlyselectedoption ;
   private boolean Combo_migrlegconvenio_Includeselectalloption ;
   private boolean Combo_migrlegconvenio_Includeaddnewoption ;
   private boolean Combo_migrlegcategoria_Enabled ;
   private boolean Combo_migrlegcategoria_Visible ;
   private boolean Combo_migrlegcategoria_Allowmultipleselection ;
   private boolean Combo_migrlegcategoria_Isgriditem ;
   private boolean Combo_migrlegcategoria_Hasdescription ;
   private boolean Combo_migrlegcategoria_Includeonlyselectedoption ;
   private boolean Combo_migrlegcategoria_Includeselectalloption ;
   private boolean Combo_migrlegcategoria_Includeaddnewoption ;
   private boolean Combo_migrlegbanco_Enabled ;
   private boolean Combo_migrlegbanco_Visible ;
   private boolean Combo_migrlegbanco_Allowmultipleselection ;
   private boolean Combo_migrlegbanco_Isgriditem ;
   private boolean Combo_migrlegbanco_Hasdescription ;
   private boolean Combo_migrlegbanco_Includeonlyselectedoption ;
   private boolean Combo_migrlegbanco_Includeselectalloption ;
   private boolean Combo_migrlegbanco_Includeaddnewoption ;
   private boolean Combo_migrlegobrasocial_Enabled ;
   private boolean Combo_migrlegobrasocial_Visible ;
   private boolean Combo_migrlegobrasocial_Allowmultipleselection ;
   private boolean Combo_migrlegobrasocial_Isgriditem ;
   private boolean Combo_migrlegobrasocial_Hasdescription ;
   private boolean Combo_migrlegobrasocial_Includeonlyselectedoption ;
   private boolean Combo_migrlegobrasocial_Includeselectalloption ;
   private boolean Combo_migrlegobrasocial_Includeaddnewoption ;
   private boolean Combo_migrlegmodalidad_Enabled ;
   private boolean Combo_migrlegmodalidad_Visible ;
   private boolean Combo_migrlegmodalidad_Allowmultipleselection ;
   private boolean Combo_migrlegmodalidad_Isgriditem ;
   private boolean Combo_migrlegmodalidad_Hasdescription ;
   private boolean Combo_migrlegmodalidad_Includeonlyselectedoption ;
   private boolean Combo_migrlegmodalidad_Includeselectalloption ;
   private boolean Combo_migrlegmodalidad_Includeaddnewoption ;
   private boolean Combo_migrlegzona_Enabled ;
   private boolean Combo_migrlegzona_Visible ;
   private boolean Combo_migrlegzona_Allowmultipleselection ;
   private boolean Combo_migrlegzona_Isgriditem ;
   private boolean Combo_migrlegzona_Hasdescription ;
   private boolean Combo_migrlegzona_Includeonlyselectedoption ;
   private boolean Combo_migrlegzona_Includeselectalloption ;
   private boolean Combo_migrlegzona_Includeaddnewoption ;
   private boolean Combo_migrlegactividad_Enabled ;
   private boolean Combo_migrlegactividad_Visible ;
   private boolean Combo_migrlegactividad_Allowmultipleselection ;
   private boolean Combo_migrlegactividad_Isgriditem ;
   private boolean Combo_migrlegactividad_Hasdescription ;
   private boolean Combo_migrlegactividad_Includeonlyselectedoption ;
   private boolean Combo_migrlegactividad_Includeselectalloption ;
   private boolean Combo_migrlegactividad_Includeaddnewoption ;
   private boolean Combo_migrlegcondicion_Enabled ;
   private boolean Combo_migrlegcondicion_Visible ;
   private boolean Combo_migrlegcondicion_Allowmultipleselection ;
   private boolean Combo_migrlegcondicion_Isgriditem ;
   private boolean Combo_migrlegcondicion_Hasdescription ;
   private boolean Combo_migrlegcondicion_Includeonlyselectedoption ;
   private boolean Combo_migrlegcondicion_Includeselectalloption ;
   private boolean Combo_migrlegcondicion_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV184MigrEncontroOsoAfip ;
   private boolean AV185MigrEncontroOsoSigla ;
   private boolean AV22IsAuthorized ;
   private boolean GXt_boolean30 ;
   private boolean bDynCreated_Wcimportarlegajofamilia ;
   private boolean AV57hayLike ;
   private boolean AV58existe ;
   private boolean AV115esCodigo ;
   private boolean AV128defaultEs ;
   private boolean GXv_boolean26[] ;
   private boolean GXv_boolean25[] ;
   private boolean Gx_longc ;
   private boolean GXv_boolean35[] ;
   private boolean GXv_boolean36[] ;
   private String A628MigrLegObs ;
   private String A629MigrLegErrores ;
   private String A633MigrLegWarnings ;
   private String A2206MigrOtrosDatos ;
   private String Z628MigrLegObs ;
   private String Z629MigrLegErrores ;
   private String Z633MigrLegWarnings ;
   private String Z2206MigrOtrosDatos ;
   private String Z596MigrLegEstadoCivil ;
   private String Z605MigrLegArea ;
   private String Z613MigrLegSindicato ;
   private String Z627MigrLegConvenio ;
   private String Z604MigrLegCategoria ;
   private String Z610MigrLegBanco ;
   private String Z614MigrLegObraSocial ;
   private String Z617MigrLegModalidad ;
   private String Z620MigrLegZona ;
   private String Z616MigrLegActividad ;
   private String Z624MigrLegCondicion ;
   private String Z592MigrLegApellido ;
   private String Z593MigrLegNombre ;
   private String Z599MigrLegDomici ;
   private String Z600MigrLegEmail ;
   private String Z601MigrLegCodPos ;
   private String Z602MigrLegTelefono ;
   private String Z606MigrLegLugarDePago ;
   private String Z2415MigrLegModTra ;
   private String Z607MigrLegClase ;
   private String Z609MigrLegFormaPago ;
   private String Z611MigrLegBanSuc ;
   private String Z612MigrLegBanTipCuen ;
   private String Z615MigrLegPlanMedico ;
   private String Z619MigrLegCuentaBanc ;
   private String Z621MigrLegCBU ;
   private String Z623MigrLegSituacionRevista ;
   private String Z2239MigrLegActLabClas ;
   private String Z2240MigrLegPueAfip ;
   private String Z625MigrLegSiniestrado ;
   private String Z2216MigrPuesto ;
   private String Z2427MigrLegTipoTarifa ;
   private String A627MigrLegConvenio ;
   private String A604MigrLegCategoria ;
   private String AV176sinesTexto ;
   private String AV177actTexto ;
   private String AV178modTexto ;
   private String AV175texto ;
   private String AV179sitRevTexto ;
   private String AV180condTexto ;
   private String A607MigrLegClase ;
   private String A596MigrLegEstadoCivil ;
   private String A609MigrLegFormaPago ;
   private String A612MigrLegBanTipCuen ;
   private String A625MigrLegSiniestrado ;
   private String A616MigrLegActividad ;
   private String A617MigrLegModalidad ;
   private String A620MigrLegZona ;
   private String A623MigrLegSituacionRevista ;
   private String A624MigrLegCondicion ;
   private String A2415MigrLegModTra ;
   private String A2427MigrLegTipoTarifa ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A599MigrLegDomici ;
   private String A601MigrLegCodPos ;
   private String A602MigrLegTelefono ;
   private String A600MigrLegEmail ;
   private String A605MigrLegArea ;
   private String A613MigrLegSindicato ;
   private String A610MigrLegBanco ;
   private String A614MigrLegObraSocial ;
   private String A621MigrLegCBU ;
   private String A2239MigrLegActLabClas ;
   private String A2240MigrLegPueAfip ;
   private String AV192ComboMigrLegEstadoCivil ;
   private String AV13ComboMigrLegArea ;
   private String AV134ComboMigrLegSindicato ;
   private String AV136ComboMigrLegConvenio ;
   private String AV127ComboMigrLegCategoria ;
   private String AV140ComboMigrLegBanco ;
   private String AV132ComboMigrLegObraSocial ;
   private String AV142ComboMigrLegModalidad ;
   private String AV130ComboMigrLegZona ;
   private String AV144ComboMigrLegActividad ;
   private String AV148ComboMigrLegCondicion ;
   private String A606MigrLegLugarDePago ;
   private String A611MigrLegBanSuc ;
   private String A619MigrLegCuentaBanc ;
   private String A615MigrLegPlanMedico ;
   private String A2216MigrPuesto ;
   private String AV64AuxMigrLegCategoria ;
   private String AV158mensaje ;
   private String AV164sexoError ;
   private String AV73estadocivilError ;
   private String AV74discapacidadError ;
   private String AV76formadepagoError ;
   private String AV77scvoError ;
   private String AV103tieneconyugeError ;
   private String AV166tipocuentaError ;
   private String AV62LegNomApe ;
   private String AV63LegIdNomApe ;
   private String AV25MigrLegArea ;
   private String AV36MigrLegLugarDePago ;
   private String AV30MigrLegCategoria ;
   private String AV28MigrLegBanco ;
   private String AV45MigrLegSindicato ;
   private String AV41MigrLegObraSocial ;
   private String AV43MigrLegPlanMedico ;
   private String AV23MigrLegActividad ;
   private String AV38MigrLegModalidad ;
   private String AV51MigrLegZona ;
   private String AV49MigrLegSituacionRevista ;
   private String AV34MigrLegConvenio ;
   private String AV32MigrLegCondicion ;
   private String AV47MigrLegSiniestrado ;
   private String AV195MigrLegModTra ;
   private String AV196MigrLegTipoTarifa ;
   private String AV94MigrLegClase ;
   private String AV105MigrLegEstadoCivil ;
   private String AV109MigrLegBanTipCuen ;
   private String AV107MigrLegFormaPago ;
   private String AV181start_MigrLegConvenio ;
   private String AV15ComboSelectedValue ;
   private String AV153valorFiltro ;
   private String AV186OsoDescrip ;
   private String AV193auxDependencia ;
   private String AV75claseError ;
   private String AV198modTraError ;
   private String AV201tipoTarifaError ;
   private String ZV62LegNomApe ;
   private String ZV63LegIdNomApe ;
   private String ZV64AuxMigrLegCategoria ;
   private String ZV178modTexto ;
   private String ZV175texto ;
   private String ZV177actTexto ;
   private String ZV180condTexto ;
   private String ZV179sitRevTexto ;
   private String ZV176sinesTexto ;
   private GXSimpleCollection<Byte> AV204GXV1 ;
   private GXWebComponent WebComp_Wcimportarlegajofamilia ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegsexo ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegestadocivil ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegarea ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegsindicato ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegconvenio ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegcategoria ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegbanco ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegobrasocial ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegmodalidad ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegzona ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegactividad ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegcondicion ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbMigrLegModTra ;
   private HTMLChoice cmbMigrLegTipoTarifa ;
   private HTMLChoice cmbMigrLegClase ;
   private IDataStoreProvider pr_default ;
   private int[] T00285_A87MigrLegNumero ;
   private String[] T00285_A595MigrLegSexo ;
   private String[] T00285_A596MigrLegEstadoCivil ;
   private String[] T00285_A605MigrLegArea ;
   private String[] T00285_A613MigrLegSindicato ;
   private String[] T00285_A627MigrLegConvenio ;
   private String[] T00285_A604MigrLegCategoria ;
   private String[] T00285_A610MigrLegBanco ;
   private String[] T00285_A614MigrLegObraSocial ;
   private String[] T00285_A617MigrLegModalidad ;
   private String[] T00285_A620MigrLegZona ;
   private String[] T00285_A616MigrLegActividad ;
   private String[] T00285_A624MigrLegCondicion ;
   private String[] T00285_A592MigrLegApellido ;
   private String[] T00285_A593MigrLegNombre ;
   private java.util.Date[] T00285_A594MigrLegFecNac ;
   private String[] T00285_A597MigrLegCUIL ;
   private String[] T00285_A598MigrLegDiscapacidad ;
   private String[] T00285_A599MigrLegDomici ;
   private String[] T00285_A600MigrLegEmail ;
   private String[] T00285_A601MigrLegCodPos ;
   private String[] T00285_A602MigrLegTelefono ;
   private java.util.Date[] T00285_A603MigrLegFecIngreso ;
   private String[] T00285_A606MigrLegLugarDePago ;
   private String[] T00285_A2415MigrLegModTra ;
   private String[] T00285_A607MigrLegClase ;
   private java.math.BigDecimal[] T00285_A608MigrLegBasico ;
   private String[] T00285_A609MigrLegFormaPago ;
   private String[] T00285_A611MigrLegBanSuc ;
   private String[] T00285_A612MigrLegBanTipCuen ;
   private String[] T00285_A634MigrLegOSAfip ;
   private String[] T00285_A615MigrLegPlanMedico ;
   private java.util.Date[] T00285_A618MigrLegFecUltMod ;
   private String[] T00285_A619MigrLegCuentaBanc ;
   private String[] T00285_A621MigrLegCBU ;
   private String[] T00285_A622MigrLegSCVO ;
   private String[] T00285_A623MigrLegSituacionRevista ;
   private String[] T00285_A2239MigrLegActLabClas ;
   private String[] T00285_A2240MigrLegPueAfip ;
   private String[] T00285_A625MigrLegSiniestrado ;
   private String[] T00285_A626MigrLegId ;
   private String[] T00285_A628MigrLegObs ;
   private String[] T00285_A629MigrLegErrores ;
   private String[] T00285_A633MigrLegWarnings ;
   private String[] T00285_A631MigrTieneConyuge ;
   private short[] T00285_A632MigrCantidadHijos ;
   private boolean[] T00285_A635MigrEncontroOsoSigla ;
   private boolean[] T00285_A689MigrLegAreaDef ;
   private boolean[] T00285_A690MigrLegEstadoCivilDef ;
   private boolean[] T00285_A691MigrLegClaseDef ;
   private boolean[] T00285_A692MigrLegFormaPagoDef ;
   private boolean[] T00285_A693MigrLegTipoCuentaDef ;
   private boolean[] T00285_A694MigrLegActividadDef ;
   private boolean[] T00285_A695MigrLegModalidadDef ;
   private boolean[] T00285_A696MigrLegZonaDef ;
   private boolean[] T00285_A697MigrLegSCVODef ;
   private boolean[] T00285_A698MigrLegSituacionDef ;
   private boolean[] T00285_A699MigrLegCondicionDef ;
   private boolean[] T00285_A700MigrLegSiniestradoDef ;
   private String[] T00285_A2216MigrPuesto ;
   private java.util.Date[] T00285_A2205MigrLegFecEgreso ;
   private String[] T00285_A2206MigrOtrosDatos ;
   private java.math.BigDecimal[] T00285_A2275MigrLegHorSem ;
   private String[] T00285_A2427MigrLegTipoTarifa ;
   private int[] T00285_A3CliCod ;
   private short[] T00285_A1EmpCod ;
   private int[] T00284_A3CliCod ;
   private int[] T00286_A3CliCod ;
   private int[] T00287_A3CliCod ;
   private short[] T00287_A1EmpCod ;
   private int[] T00287_A87MigrLegNumero ;
   private int[] T00283_A87MigrLegNumero ;
   private String[] T00283_A595MigrLegSexo ;
   private String[] T00283_A596MigrLegEstadoCivil ;
   private String[] T00283_A605MigrLegArea ;
   private String[] T00283_A613MigrLegSindicato ;
   private String[] T00283_A627MigrLegConvenio ;
   private String[] T00283_A604MigrLegCategoria ;
   private String[] T00283_A610MigrLegBanco ;
   private String[] T00283_A614MigrLegObraSocial ;
   private String[] T00283_A617MigrLegModalidad ;
   private String[] T00283_A620MigrLegZona ;
   private String[] T00283_A616MigrLegActividad ;
   private String[] T00283_A624MigrLegCondicion ;
   private String[] T00283_A592MigrLegApellido ;
   private String[] T00283_A593MigrLegNombre ;
   private java.util.Date[] T00283_A594MigrLegFecNac ;
   private String[] T00283_A597MigrLegCUIL ;
   private String[] T00283_A598MigrLegDiscapacidad ;
   private String[] T00283_A599MigrLegDomici ;
   private String[] T00283_A600MigrLegEmail ;
   private String[] T00283_A601MigrLegCodPos ;
   private String[] T00283_A602MigrLegTelefono ;
   private java.util.Date[] T00283_A603MigrLegFecIngreso ;
   private String[] T00283_A606MigrLegLugarDePago ;
   private String[] T00283_A2415MigrLegModTra ;
   private String[] T00283_A607MigrLegClase ;
   private java.math.BigDecimal[] T00283_A608MigrLegBasico ;
   private String[] T00283_A609MigrLegFormaPago ;
   private String[] T00283_A611MigrLegBanSuc ;
   private String[] T00283_A612MigrLegBanTipCuen ;
   private String[] T00283_A634MigrLegOSAfip ;
   private String[] T00283_A615MigrLegPlanMedico ;
   private java.util.Date[] T00283_A618MigrLegFecUltMod ;
   private String[] T00283_A619MigrLegCuentaBanc ;
   private String[] T00283_A621MigrLegCBU ;
   private String[] T00283_A622MigrLegSCVO ;
   private String[] T00283_A623MigrLegSituacionRevista ;
   private String[] T00283_A2239MigrLegActLabClas ;
   private String[] T00283_A2240MigrLegPueAfip ;
   private String[] T00283_A625MigrLegSiniestrado ;
   private String[] T00283_A626MigrLegId ;
   private String[] T00283_A628MigrLegObs ;
   private String[] T00283_A629MigrLegErrores ;
   private String[] T00283_A633MigrLegWarnings ;
   private String[] T00283_A631MigrTieneConyuge ;
   private short[] T00283_A632MigrCantidadHijos ;
   private boolean[] T00283_A635MigrEncontroOsoSigla ;
   private boolean[] T00283_A689MigrLegAreaDef ;
   private boolean[] T00283_A690MigrLegEstadoCivilDef ;
   private boolean[] T00283_A691MigrLegClaseDef ;
   private boolean[] T00283_A692MigrLegFormaPagoDef ;
   private boolean[] T00283_A693MigrLegTipoCuentaDef ;
   private boolean[] T00283_A694MigrLegActividadDef ;
   private boolean[] T00283_A695MigrLegModalidadDef ;
   private boolean[] T00283_A696MigrLegZonaDef ;
   private boolean[] T00283_A697MigrLegSCVODef ;
   private boolean[] T00283_A698MigrLegSituacionDef ;
   private boolean[] T00283_A699MigrLegCondicionDef ;
   private boolean[] T00283_A700MigrLegSiniestradoDef ;
   private String[] T00283_A2216MigrPuesto ;
   private java.util.Date[] T00283_A2205MigrLegFecEgreso ;
   private String[] T00283_A2206MigrOtrosDatos ;
   private java.math.BigDecimal[] T00283_A2275MigrLegHorSem ;
   private String[] T00283_A2427MigrLegTipoTarifa ;
   private int[] T00283_A3CliCod ;
   private short[] T00283_A1EmpCod ;
   private int[] T00288_A3CliCod ;
   private short[] T00288_A1EmpCod ;
   private int[] T00288_A87MigrLegNumero ;
   private int[] T00289_A3CliCod ;
   private short[] T00289_A1EmpCod ;
   private int[] T00289_A87MigrLegNumero ;
   private int[] T00282_A87MigrLegNumero ;
   private String[] T00282_A595MigrLegSexo ;
   private String[] T00282_A596MigrLegEstadoCivil ;
   private String[] T00282_A605MigrLegArea ;
   private String[] T00282_A613MigrLegSindicato ;
   private String[] T00282_A627MigrLegConvenio ;
   private String[] T00282_A604MigrLegCategoria ;
   private String[] T00282_A610MigrLegBanco ;
   private String[] T00282_A614MigrLegObraSocial ;
   private String[] T00282_A617MigrLegModalidad ;
   private String[] T00282_A620MigrLegZona ;
   private String[] T00282_A616MigrLegActividad ;
   private String[] T00282_A624MigrLegCondicion ;
   private String[] T00282_A592MigrLegApellido ;
   private String[] T00282_A593MigrLegNombre ;
   private java.util.Date[] T00282_A594MigrLegFecNac ;
   private String[] T00282_A597MigrLegCUIL ;
   private String[] T00282_A598MigrLegDiscapacidad ;
   private String[] T00282_A599MigrLegDomici ;
   private String[] T00282_A600MigrLegEmail ;
   private String[] T00282_A601MigrLegCodPos ;
   private String[] T00282_A602MigrLegTelefono ;
   private java.util.Date[] T00282_A603MigrLegFecIngreso ;
   private String[] T00282_A606MigrLegLugarDePago ;
   private String[] T00282_A2415MigrLegModTra ;
   private String[] T00282_A607MigrLegClase ;
   private java.math.BigDecimal[] T00282_A608MigrLegBasico ;
   private String[] T00282_A609MigrLegFormaPago ;
   private String[] T00282_A611MigrLegBanSuc ;
   private String[] T00282_A612MigrLegBanTipCuen ;
   private String[] T00282_A634MigrLegOSAfip ;
   private String[] T00282_A615MigrLegPlanMedico ;
   private java.util.Date[] T00282_A618MigrLegFecUltMod ;
   private String[] T00282_A619MigrLegCuentaBanc ;
   private String[] T00282_A621MigrLegCBU ;
   private String[] T00282_A622MigrLegSCVO ;
   private String[] T00282_A623MigrLegSituacionRevista ;
   private String[] T00282_A2239MigrLegActLabClas ;
   private String[] T00282_A2240MigrLegPueAfip ;
   private String[] T00282_A625MigrLegSiniestrado ;
   private String[] T00282_A626MigrLegId ;
   private String[] T00282_A628MigrLegObs ;
   private String[] T00282_A629MigrLegErrores ;
   private String[] T00282_A633MigrLegWarnings ;
   private String[] T00282_A631MigrTieneConyuge ;
   private short[] T00282_A632MigrCantidadHijos ;
   private boolean[] T00282_A635MigrEncontroOsoSigla ;
   private boolean[] T00282_A689MigrLegAreaDef ;
   private boolean[] T00282_A690MigrLegEstadoCivilDef ;
   private boolean[] T00282_A691MigrLegClaseDef ;
   private boolean[] T00282_A692MigrLegFormaPagoDef ;
   private boolean[] T00282_A693MigrLegTipoCuentaDef ;
   private boolean[] T00282_A694MigrLegActividadDef ;
   private boolean[] T00282_A695MigrLegModalidadDef ;
   private boolean[] T00282_A696MigrLegZonaDef ;
   private boolean[] T00282_A697MigrLegSCVODef ;
   private boolean[] T00282_A698MigrLegSituacionDef ;
   private boolean[] T00282_A699MigrLegCondicionDef ;
   private boolean[] T00282_A700MigrLegSiniestradoDef ;
   private String[] T00282_A2216MigrPuesto ;
   private java.util.Date[] T00282_A2205MigrLegFecEgreso ;
   private String[] T00282_A2206MigrOtrosDatos ;
   private java.math.BigDecimal[] T00282_A2275MigrLegHorSem ;
   private String[] T00282_A2427MigrLegTipoTarifa ;
   private int[] T00282_A3CliCod ;
   private short[] T00282_A1EmpCod ;
   private int[] T002813_A3CliCod ;
   private short[] T002813_A1EmpCod ;
   private int[] T002813_A87MigrLegNumero ;
   private short[] T002813_A2078MigrLegFamSec ;
   private int[] T002814_A3CliCod ;
   private short[] T002814_A1EmpCod ;
   private int[] T002814_A87MigrLegNumero ;
   private int[] T002815_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV55WebSession ;
   private GXSimpleCollection<String> AV206GXV3 ;
   private GXSimpleCollection<String> AV208GXV5 ;
   private GXSimpleCollection<String> AV104dummyErrores ;
   private GXSimpleCollection<String> AV69warnings ;
   private GXSimpleCollection<String> AV68errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar31[] ;
   private GXSimpleCollection<String> GXv_objcol_svchar32[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV189MigrLegSexo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV191MigrLegEstadoCivil_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV26MigrLegArea_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV133MigrLegSindicato_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV135MigrLegConvenio_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV126MigrLegCategoria_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV139MigrLegBanco_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV131MigrLegObraSocial_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV141MigrLegModalidad_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV129MigrLegZona_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV143MigrLegActividad_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV147MigrLegCondicion_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item33 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item34[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons28 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV54TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV56WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext27[] ;
}

final  class migrlegupd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00282", "SELECT MigrLegNumero, MigrLegSexo, MigrLegEstadoCivil, MigrLegArea, MigrLegSindicato, MigrLegConvenio, MigrLegCategoria, MigrLegBanco, MigrLegObraSocial, MigrLegModalidad, MigrLegZona, MigrLegActividad, MigrLegCondicion, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegLugarDePago, MigrLegModTra, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegOSAfip, MigrLegPlanMedico, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegActLabClas, MigrLegPueAfip, MigrLegSiniestrado, MigrLegId, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrLegAreaDef, MigrLegEstadoCivilDef, MigrLegClaseDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSCVODef, MigrLegSituacionDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrPuesto, MigrLegFecEgreso, MigrOtrosDatos, MigrLegHorSem, MigrLegTipoTarifa, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?  FOR UPDATE OF importacion_legajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00283", "SELECT MigrLegNumero, MigrLegSexo, MigrLegEstadoCivil, MigrLegArea, MigrLegSindicato, MigrLegConvenio, MigrLegCategoria, MigrLegBanco, MigrLegObraSocial, MigrLegModalidad, MigrLegZona, MigrLegActividad, MigrLegCondicion, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegLugarDePago, MigrLegModTra, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegOSAfip, MigrLegPlanMedico, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegActLabClas, MigrLegPueAfip, MigrLegSiniestrado, MigrLegId, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrLegAreaDef, MigrLegEstadoCivilDef, MigrLegClaseDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSCVODef, MigrLegSituacionDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrPuesto, MigrLegFecEgreso, MigrOtrosDatos, MigrLegHorSem, MigrLegTipoTarifa, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00284", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00285", "SELECT TM1.MigrLegNumero, TM1.MigrLegSexo, TM1.MigrLegEstadoCivil, TM1.MigrLegArea, TM1.MigrLegSindicato, TM1.MigrLegConvenio, TM1.MigrLegCategoria, TM1.MigrLegBanco, TM1.MigrLegObraSocial, TM1.MigrLegModalidad, TM1.MigrLegZona, TM1.MigrLegActividad, TM1.MigrLegCondicion, TM1.MigrLegApellido, TM1.MigrLegNombre, TM1.MigrLegFecNac, TM1.MigrLegCUIL, TM1.MigrLegDiscapacidad, TM1.MigrLegDomici, TM1.MigrLegEmail, TM1.MigrLegCodPos, TM1.MigrLegTelefono, TM1.MigrLegFecIngreso, TM1.MigrLegLugarDePago, TM1.MigrLegModTra, TM1.MigrLegClase, TM1.MigrLegBasico, TM1.MigrLegFormaPago, TM1.MigrLegBanSuc, TM1.MigrLegBanTipCuen, TM1.MigrLegOSAfip, TM1.MigrLegPlanMedico, TM1.MigrLegFecUltMod, TM1.MigrLegCuentaBanc, TM1.MigrLegCBU, TM1.MigrLegSCVO, TM1.MigrLegSituacionRevista, TM1.MigrLegActLabClas, TM1.MigrLegPueAfip, TM1.MigrLegSiniestrado, TM1.MigrLegId, TM1.MigrLegObs, TM1.MigrLegErrores, TM1.MigrLegWarnings, TM1.MigrTieneConyuge, TM1.MigrCantidadHijos, TM1.MigrEncontroOsoSigla, TM1.MigrLegAreaDef, TM1.MigrLegEstadoCivilDef, TM1.MigrLegClaseDef, TM1.MigrLegFormaPagoDef, TM1.MigrLegTipoCuentaDef, TM1.MigrLegActividadDef, TM1.MigrLegModalidadDef, TM1.MigrLegZonaDef, TM1.MigrLegSCVODef, TM1.MigrLegSituacionDef, TM1.MigrLegCondicionDef, TM1.MigrLegSiniestradoDef, TM1.MigrPuesto, TM1.MigrLegFecEgreso, TM1.MigrOtrosDatos, TM1.MigrLegHorSem, TM1.MigrLegTipoTarifa, TM1.CliCod, TM1.EmpCod FROM importacion_legajo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00286", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00287", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00288", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and MigrLegNumero > ?) ORDER BY CliCod, EmpCod, MigrLegNumero  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00289", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and MigrLegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002810", "SAVEPOINT gxupdate;INSERT INTO importacion_legajo(MigrLegNumero, MigrLegSexo, MigrLegEstadoCivil, MigrLegArea, MigrLegSindicato, MigrLegConvenio, MigrLegCategoria, MigrLegBanco, MigrLegObraSocial, MigrLegModalidad, MigrLegZona, MigrLegActividad, MigrLegCondicion, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegLugarDePago, MigrLegModTra, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegOSAfip, MigrLegPlanMedico, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegActLabClas, MigrLegPueAfip, MigrLegSiniestrado, MigrLegId, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrLegAreaDef, MigrLegEstadoCivilDef, MigrLegClaseDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSCVODef, MigrLegSituacionDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrPuesto, MigrLegFecEgreso, MigrOtrosDatos, MigrLegHorSem, MigrLegTipoTarifa, CliCod, EmpCod, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrValCadaSave, MigrLegMarcaCCT, MigrArchSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', FALSE, '', DATE '00010101', FALSE, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002811", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegSexo=?, MigrLegEstadoCivil=?, MigrLegArea=?, MigrLegSindicato=?, MigrLegConvenio=?, MigrLegCategoria=?, MigrLegBanco=?, MigrLegObraSocial=?, MigrLegModalidad=?, MigrLegZona=?, MigrLegActividad=?, MigrLegCondicion=?, MigrLegApellido=?, MigrLegNombre=?, MigrLegFecNac=?, MigrLegCUIL=?, MigrLegDiscapacidad=?, MigrLegDomici=?, MigrLegEmail=?, MigrLegCodPos=?, MigrLegTelefono=?, MigrLegFecIngreso=?, MigrLegLugarDePago=?, MigrLegModTra=?, MigrLegClase=?, MigrLegBasico=?, MigrLegFormaPago=?, MigrLegBanSuc=?, MigrLegBanTipCuen=?, MigrLegOSAfip=?, MigrLegPlanMedico=?, MigrLegFecUltMod=?, MigrLegCuentaBanc=?, MigrLegCBU=?, MigrLegSCVO=?, MigrLegSituacionRevista=?, MigrLegActLabClas=?, MigrLegPueAfip=?, MigrLegSiniestrado=?, MigrLegId=?, MigrLegObs=?, MigrLegErrores=?, MigrLegWarnings=?, MigrTieneConyuge=?, MigrCantidadHijos=?, MigrEncontroOsoSigla=?, MigrLegAreaDef=?, MigrLegEstadoCivilDef=?, MigrLegClaseDef=?, MigrLegFormaPagoDef=?, MigrLegTipoCuentaDef=?, MigrLegActividadDef=?, MigrLegModalidadDef=?, MigrLegZonaDef=?, MigrLegSCVODef=?, MigrLegSituacionDef=?, MigrLegCondicionDef=?, MigrLegSiniestradoDef=?, MigrPuesto=?, MigrLegFecEgreso=?, MigrOtrosDatos=?, MigrLegHorSem=?, MigrLegTipoTarifa=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002812", "SAVEPOINT gxupdate;DELETE FROM importacion_legajo  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002813", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002814", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo ORDER BY CliCod, EmpCod, MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002815", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 13);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getString(31, 20);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getVarchar(40);
               ((String[]) buf[40])[0] = rslt.getString(41, 20);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[48])[0] = rslt.getBoolean(49);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(52);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((String[]) buf[59])[0] = rslt.getVarchar(60);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(61);
               ((String[]) buf[61])[0] = rslt.getLongVarchar(62);
               ((java.math.BigDecimal[]) buf[62])[0] = rslt.getBigDecimal(63,1);
               ((String[]) buf[63])[0] = rslt.getVarchar(64);
               ((int[]) buf[64])[0] = rslt.getInt(65);
               ((short[]) buf[65])[0] = rslt.getShort(66);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 13);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getString(31, 20);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getVarchar(40);
               ((String[]) buf[40])[0] = rslt.getString(41, 20);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[48])[0] = rslt.getBoolean(49);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(52);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((String[]) buf[59])[0] = rslt.getVarchar(60);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(61);
               ((String[]) buf[61])[0] = rslt.getLongVarchar(62);
               ((java.math.BigDecimal[]) buf[62])[0] = rslt.getBigDecimal(63,1);
               ((String[]) buf[63])[0] = rslt.getVarchar(64);
               ((int[]) buf[64])[0] = rslt.getInt(65);
               ((short[]) buf[65])[0] = rslt.getShort(66);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 13);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getString(31, 20);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getVarchar(40);
               ((String[]) buf[40])[0] = rslt.getString(41, 20);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[48])[0] = rslt.getBoolean(49);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(52);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((String[]) buf[59])[0] = rslt.getVarchar(60);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(61);
               ((String[]) buf[61])[0] = rslt.getLongVarchar(62);
               ((java.math.BigDecimal[]) buf[62])[0] = rslt.getBigDecimal(63,1);
               ((String[]) buf[63])[0] = rslt.getVarchar(64);
               ((int[]) buf[64])[0] = rslt.getInt(65);
               ((short[]) buf[65])[0] = rslt.getShort(66);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 150, false);
               stmt.setVarchar(13, (String)parms[12], 40, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 400, false);
               stmt.setDate(16, (java.util.Date)parms[15]);
               stmt.setString(17, (String)parms[16], 13);
               stmt.setString(18, (String)parms[17], 2);
               stmt.setVarchar(19, (String)parms[18], 4000, false);
               stmt.setVarchar(20, (String)parms[19], 100, false);
               stmt.setVarchar(21, (String)parms[20], 400, false);
               stmt.setVarchar(22, (String)parms[21], 400, false);
               stmt.setDate(23, (java.util.Date)parms[22]);
               stmt.setVarchar(24, (String)parms[23], 20, false);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setVarchar(28, (String)parms[27], 400, false);
               stmt.setVarchar(29, (String)parms[28], 400, false);
               stmt.setVarchar(30, (String)parms[29], 20, false);
               stmt.setString(31, (String)parms[30], 20);
               stmt.setVarchar(32, (String)parms[31], 400, false);
               stmt.setDate(33, (java.util.Date)parms[32]);
               stmt.setVarchar(34, (String)parms[33], 20, false);
               stmt.setVarchar(35, (String)parms[34], 22, false);
               stmt.setString(36, (String)parms[35], 2);
               stmt.setVarchar(37, (String)parms[36], 40, false);
               stmt.setVarchar(38, (String)parms[37], 60, false);
               stmt.setVarchar(39, (String)parms[38], 255, false);
               stmt.setVarchar(40, (String)parms[39], 400, false);
               stmt.setString(41, (String)parms[40], 20);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setNLongVarchar(44, (String)parms[43], false);
               stmt.setString(45, (String)parms[44], 20);
               stmt.setShort(46, ((Number) parms[45]).shortValue());
               stmt.setBoolean(47, ((Boolean) parms[46]).booleanValue());
               stmt.setBoolean(48, ((Boolean) parms[47]).booleanValue());
               stmt.setBoolean(49, ((Boolean) parms[48]).booleanValue());
               stmt.setBoolean(50, ((Boolean) parms[49]).booleanValue());
               stmt.setBoolean(51, ((Boolean) parms[50]).booleanValue());
               stmt.setBoolean(52, ((Boolean) parms[51]).booleanValue());
               stmt.setBoolean(53, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(59, ((Boolean) parms[58]).booleanValue());
               stmt.setVarchar(60, (String)parms[59], 400, false);
               stmt.setDate(61, (java.util.Date)parms[60]);
               stmt.setNLongVarchar(62, (String)parms[61], false);
               stmt.setBigDecimal(63, (java.math.BigDecimal)parms[62], 1);
               stmt.setVarchar(64, (String)parms[63], 400, false);
               stmt.setInt(65, ((Number) parms[64]).intValue());
               stmt.setShort(66, ((Number) parms[65]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 150, false);
               stmt.setVarchar(12, (String)parms[11], 40, false);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setDate(15, (java.util.Date)parms[14]);
               stmt.setString(16, (String)parms[15], 13);
               stmt.setString(17, (String)parms[16], 2);
               stmt.setVarchar(18, (String)parms[17], 4000, false);
               stmt.setVarchar(19, (String)parms[18], 100, false);
               stmt.setVarchar(20, (String)parms[19], 400, false);
               stmt.setVarchar(21, (String)parms[20], 400, false);
               stmt.setDate(22, (java.util.Date)parms[21]);
               stmt.setVarchar(23, (String)parms[22], 20, false);
               stmt.setVarchar(24, (String)parms[23], 400, false);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setVarchar(27, (String)parms[26], 400, false);
               stmt.setVarchar(28, (String)parms[27], 400, false);
               stmt.setVarchar(29, (String)parms[28], 20, false);
               stmt.setString(30, (String)parms[29], 20);
               stmt.setVarchar(31, (String)parms[30], 400, false);
               stmt.setDate(32, (java.util.Date)parms[31]);
               stmt.setVarchar(33, (String)parms[32], 20, false);
               stmt.setVarchar(34, (String)parms[33], 22, false);
               stmt.setString(35, (String)parms[34], 2);
               stmt.setVarchar(36, (String)parms[35], 40, false);
               stmt.setVarchar(37, (String)parms[36], 60, false);
               stmt.setVarchar(38, (String)parms[37], 255, false);
               stmt.setVarchar(39, (String)parms[38], 400, false);
               stmt.setString(40, (String)parms[39], 20);
               stmt.setNLongVarchar(41, (String)parms[40], false);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setString(44, (String)parms[43], 20);
               stmt.setShort(45, ((Number) parms[44]).shortValue());
               stmt.setBoolean(46, ((Boolean) parms[45]).booleanValue());
               stmt.setBoolean(47, ((Boolean) parms[46]).booleanValue());
               stmt.setBoolean(48, ((Boolean) parms[47]).booleanValue());
               stmt.setBoolean(49, ((Boolean) parms[48]).booleanValue());
               stmt.setBoolean(50, ((Boolean) parms[49]).booleanValue());
               stmt.setBoolean(51, ((Boolean) parms[50]).booleanValue());
               stmt.setBoolean(52, ((Boolean) parms[51]).booleanValue());
               stmt.setBoolean(53, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setVarchar(59, (String)parms[58], 400, false);
               stmt.setDate(60, (java.util.Date)parms[59]);
               stmt.setNLongVarchar(61, (String)parms[60], false);
               stmt.setBigDecimal(62, (java.math.BigDecimal)parms[61], 1);
               stmt.setVarchar(63, (String)parms[62], 400, false);
               stmt.setInt(64, ((Number) parms[63]).intValue());
               stmt.setShort(65, ((Number) parms[64]).shortValue());
               stmt.setInt(66, ((Number) parms[65]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

