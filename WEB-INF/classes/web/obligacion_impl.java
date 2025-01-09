package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obligacion_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGNUMERO") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlalegnumero3D134( AV7CliCod, AV8EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TIPOOBLSEC") == 0 )
      {
         AV36PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlatipooblsec3D134( AV36PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OBLLIQNRO") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaoblliqnro3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OBLCONCODIGO") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         AV43anticipoSubTipoConCod1 = httpContext.GetPar( "anticipoSubTipoConCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43anticipoSubTipoConCod1", AV43anticipoSubTipoConCod1);
         AV44desdeDTipoConCod = httpContext.GetPar( "desdeDTipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44desdeDTipoConCod", AV44desdeDTipoConCod);
         AV45hastaDTipoConCod = httpContext.GetPar( "hastaDTipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45hastaDTipoConCod", AV45hastaDTipoConCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaoblconcodigo3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CLICOD") == 0 )
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
         gx5asaclicod3D134( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"OBLSECUENCIAL") == 0 )
      {
         AV10OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10OblSecuencial), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOBLSECUENCIAL", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10OblSecuencial), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx11asaoblsecuencial3D134( AV10OblSecuencial) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"OBLSECUENCIAL") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx12asaoblsecuencial3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_58") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2343OblConcepto = httpContext.GetPar( "OblConcepto") ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_58( A3CliCod, A2343OblConcepto) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_62") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1169OblConCodigo = httpContext.GetPar( "OblConCodigo") ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_62( A3CliCod, A1169OblConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_60") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1195OblLiqNro = (int)(GXutil.lval( httpContext.GetPar( "OblLiqNro"))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_60( A3CliCod, A1EmpCod, A1195OblLiqNro) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_59") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_59( A3CliCod, A1EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_61") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1195OblLiqNro = (int)(GXutil.lval( httpContext.GetPar( "OblLiqNro"))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_61( A3CliCod, A1EmpCod, A1195OblLiqNro, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_63") == 0 )
      {
         A1163TipoOblSec = (short)(GXutil.lval( httpContext.GetPar( "TipoOblSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_63( A1163TipoOblSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_65") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1170OblExcConCOdigo = httpContext.GetPar( "OblExcConCOdigo") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_65( A3CliCod, A1170OblExcConCOdigo) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_excepciones") == 0 )
      {
         gxnrgridlevel_excepciones_newrow_invoke( ) ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
            AV10OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10OblSecuencial), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOBLSECUENCIAL", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10OblSecuencial), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Obligacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynLegNumero.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_excepciones_newrow_invoke( )
   {
      nRC_GXsfl_113 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_113"))) ;
      nGXsfl_113_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_113_idx"))) ;
      sGXsfl_113_idx = httpContext.GetPar( "sGXsfl_113_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_excepciones_newrow( ) ;
      /* End function gxnrGridlevel_excepciones_newrow_invoke */
   }

   public obligacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obligacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacion_impl.class ));
   }

   public obligacion_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynLegNumero = new HTMLChoice();
      dynTipoOblSec = new HTMLChoice();
      cmbOblEstado = new HTMLChoice();
      dynOblLiqNro = new HTMLChoice();
      dynOblConCodigo = new HTMLChoice();
      chkOblNoRemu = UIFactory.getCheckbox(this);
      chkOblDescu = UIFactory.getCheckbox(this);
      cmbOblConcepto = new HTMLChoice();
      cmbOblTipoMov = new HTMLChoice();
      cmbOblExcTipo = new HTMLChoice();
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
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Values", dynLegNumero.ToJavascriptSource(), true);
      }
      if ( dynTipoOblSec.getItemCount() > 0 )
      {
         A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValidValue(GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipoOblSec.setValue( GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoOblSec.getInternalname(), "Values", dynTipoOblSec.ToJavascriptSource(), true);
      }
      if ( cmbOblEstado.getItemCount() > 0 )
      {
         A1173OblEstado = (byte)(GXutil.lval( cmbOblEstado.getValidValue(GXutil.trim( GXutil.str( A1173OblEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblEstado.setValue( GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblEstado.getInternalname(), "Values", cmbOblEstado.ToJavascriptSource(), true);
      }
      if ( dynOblLiqNro.getItemCount() > 0 )
      {
         A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValidValue(GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0))))) ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
      }
      A1181OblNoRemu = GXutil.strtobool( GXutil.booltostr( A1181OblNoRemu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
      A1182OblDescu = GXutil.strtobool( GXutil.booltostr( A1182OblDescu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
      if ( cmbOblConcepto.getItemCount() > 0 )
      {
         A2343OblConcepto = cmbOblConcepto.getValidValue(A2343OblConcepto) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblConcepto.setValue( GXutil.rtrim( A2343OblConcepto) );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Values", cmbOblConcepto.ToJavascriptSource(), true);
      }
      if ( cmbOblTipoMov.getItemCount() > 0 )
      {
         A2345OblTipoMov = cmbOblTipoMov.getValidValue(A2345OblTipoMov) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Values", cmbOblTipoMov.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynLegNumero.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynLegNumero.getInternalname(), httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynLegNumero, dynLegNumero.getInternalname(), GXutil.trim( GXutil.str( A6LegNumero, 8, 0)), 1, dynLegNumero.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynLegNumero.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Values", dynLegNumero.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipoOblSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynTipoOblSec.getInternalname(), httpContext.getMessage( "Obligación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipoOblSec, dynTipoOblSec.getInternalname(), GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)), 1, dynTipoOblSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynTipoOblSec.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      dynTipoOblSec.setValue( GXutil.trim( GXutil.str( A1163TipoOblSec, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoOblSec.getInternalname(), "Values", dynTipoOblSec.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbOblEstado.getInternalname(), httpContext.getMessage( "Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblEstado, cmbOblEstado.getInternalname(), GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)), 1, cmbOblEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbOblEstado.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      cmbOblEstado.setValue( GXutil.trim( GXutil.str( A1173OblEstado, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblEstado.getInternalname(), "Values", cmbOblEstado.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOblObs_Internalname, A1174OblObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtOblObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divObltotal_cell_Internalname, 1, 0, "px", 0, "px", divObltotal_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtOblTotal_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblTotal_Internalname, httpContext.getMessage( "Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A1176OblTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblTotal_Enabled!=0) ? localUtil.format( A1176OblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1176OblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblTotal_Jsonclick, 0, "Attribute", "", "", "", "", edtOblTotal_Visible, edtOblTotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOblliqnro_cell_Internalname, 1, 0, "px", 0, "px", divOblliqnro_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynOblLiqNro.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOblLiqNro.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynOblLiqNro.getInternalname(), httpContext.getMessage( "Liquidación del anticipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOblLiqNro, dynOblLiqNro.getInternalname(), GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)), 1, dynOblLiqNro.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynOblLiqNro.getVisible(), dynOblLiqNro.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOblconcodigo_cell_Internalname, 1, 0, "px", 0, "px", divOblconcodigo_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynOblConCodigo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOblConCodigo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynOblConCodigo.getInternalname(), httpContext.getMessage( "Concepto del anticipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOblConCodigo, dynOblConCodigo.getInternalname(), GXutil.rtrim( A1169OblConCodigo), 1, dynOblConCodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", dynOblConCodigo.getVisible(), dynOblConCodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOblcancuo_cell_Internalname, 1, 0, "px", 0, "px", divOblcancuo_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtOblCanCuo_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblCanCuo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblCanCuo_Internalname, httpContext.getMessage( "Cantidad de cuotas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblCanCuo_Internalname, GXutil.ltrim( localUtil.ntoc( A1177OblCanCuo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblCanCuo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1177OblCanCuo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1177OblCanCuo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblCanCuo_Jsonclick, 0, "Attribute", "", "", "", "", edtOblCanCuo_Visible, edtOblCanCuo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblImpFij_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblImpFij_Internalname, httpContext.getMessage( "Importe de cuota fija", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblImpFij_Internalname, GXutil.ltrim( localUtil.ntoc( A1178OblImpFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblImpFij_Enabled!=0) ? localUtil.format( A1178OblImpFij, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1178OblImpFij, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblImpFij_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOblImpFij_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblPorc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblPorc_Internalname, httpContext.getMessage( "Porcentaje", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblPorc_Internalname, GXutil.ltrim( localUtil.ntoc( A1179OblPorc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblPorc_Enabled!=0) ? localUtil.format( A1179OblPorc, "9.9999") : localUtil.format( A1179OblPorc, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblPorc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOblPorc_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOblnoremu_cell_Internalname, 1, 0, "px", 0, "px", divOblnoremu_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkOblNoRemu.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOblNoRemu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOblNoRemu.getInternalname(), httpContext.getMessage( "Incluir conceptos de tipo no remunerativos para base de cálculo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOblNoRemu.getInternalname(), GXutil.booltostr( A1181OblNoRemu), "", httpContext.getMessage( "Incluir conceptos de tipo no remunerativos para base de cálculo", ""), chkOblNoRemu.getVisible(), chkOblNoRemu.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(72, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,72);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divObldescu_cell_Internalname, 1, 0, "px", 0, "px", divObldescu_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkOblDescu.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOblDescu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOblDescu.getInternalname(), httpContext.getMessage( "Incluir conceptos de tipo retencion para base de cálculo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOblDescu.getInternalname(), GXutil.booltostr( A1182OblDescu), "", httpContext.getMessage( "Incluir conceptos de tipo retencion para base de cálculo", ""), chkOblDescu.getVisible(), chkOblDescu.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(77, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,77);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblConcepto.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbOblConcepto.getInternalname(), httpContext.getMessage( "Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblConcepto, cmbOblConcepto.getInternalname(), GXutil.rtrim( A2343OblConcepto), 1, cmbOblConcepto.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbOblConcepto.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      cmbOblConcepto.setValue( GXutil.rtrim( A2343OblConcepto) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Values", cmbOblConcepto.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbOblTipoMov.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbOblTipoMov.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbOblTipoMov, cmbOblTipoMov.getInternalname(), GXutil.rtrim( A2345OblTipoMov), 1, cmbOblTipoMov.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbOblTipoMov.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "", true, (byte)(0), "HLP_Obligacion.htm");
      cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Values", cmbOblTipoMov.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Obligacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      if ( tblTblexc_Visible == 0 )
      {
         sStyleString += "display:none;" ;
      }
      web.GxWebStd.gx_table_start( httpContext, tblTblexc_Internalname, tblTblexc_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* User Defined Control */
      ucDvpanel_exc.setProperty("Width", Dvpanel_exc_Width);
      ucDvpanel_exc.setProperty("AutoWidth", Dvpanel_exc_Autowidth);
      ucDvpanel_exc.setProperty("AutoHeight", Dvpanel_exc_Autoheight);
      ucDvpanel_exc.setProperty("Cls", Dvpanel_exc_Cls);
      ucDvpanel_exc.setProperty("Title", Dvpanel_exc_Title);
      ucDvpanel_exc.setProperty("Collapsible", Dvpanel_exc_Collapsible);
      ucDvpanel_exc.setProperty("Collapsed", Dvpanel_exc_Collapsed);
      ucDvpanel_exc.setProperty("ShowCollapseIcon", Dvpanel_exc_Showcollapseicon);
      ucDvpanel_exc.setProperty("IconPosition", Dvpanel_exc_Iconposition);
      ucDvpanel_exc.setProperty("AutoScroll", Dvpanel_exc_Autoscroll);
      ucDvpanel_exc.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_exc_Internalname, "DVPANEL_EXCContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_EXCContainer"+"exc"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divExc_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_excepciones_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol113( ) ;
      nGXsfl_113_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount138 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_138 = (short)(1) ;
            scanStart3D138( ) ;
            while ( RcdFound138 != 0 )
            {
               init_level_properties138( ) ;
               getByPrimaryKey3D138( ) ;
               addRow3D138( ) ;
               scanNext3D138( ) ;
            }
            scanEnd3D138( ) ;
            nBlankRcdCount138 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal3D138( ) ;
         standaloneModal3D138( ) ;
         sMode138 = Gx_mode ;
         while ( nGXsfl_113_idx < nRC_GXsfl_113 )
         {
            bGXsfl_113_Refreshing = true ;
            readRow3D138( ) ;
            edtOblExcConCOdigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "OBLEXCCONCODIGO_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtOblExcConCOdigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblExcConCOdigo_Enabled), 5, 0), !bGXsfl_113_Refreshing);
            cmbOblExcTipo.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "OBLEXCTIPO_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbOblExcTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblExcTipo.getEnabled(), 5, 0), !bGXsfl_113_Refreshing);
            if ( ( nRcdExists_138 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal3D138( ) ;
            }
            sendRow3D138( ) ;
            bGXsfl_113_Refreshing = false ;
         }
         Gx_mode = sMode138 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount138 = (short)(5) ;
         nRcdExists_138 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart3D138( ) ;
            while ( RcdFound138 != 0 )
            {
               sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_113138( ) ;
               init_level_properties138( ) ;
               standaloneNotModal3D138( ) ;
               getByPrimaryKey3D138( ) ;
               standaloneModal3D138( ) ;
               addRow3D138( ) ;
               scanNext3D138( ) ;
            }
            scanEnd3D138( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode138 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_113138( ) ;
         initAll3D138( ) ;
         init_level_properties138( ) ;
         nRcdExists_138 = (short)(0) ;
         nIsMod_138 = (short)(0) ;
         nRcdDeleted_138 = (short)(0) ;
         nBlankRcdCount138 = (short)(nBlankRcdUsr138+nBlankRcdCount138) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount138 > 0 )
         {
            standaloneNotModal3D138( ) ;
            standaloneModal3D138( ) ;
            addRow3D138( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtOblExcConCOdigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount138 = (short)(nBlankRcdCount138-1) ;
         }
         Gx_mode = sMode138 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_excepcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_excepciones", Gridlevel_excepcionesContainer, subGridlevel_excepciones_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_excepcionesContainerData", Gridlevel_excepcionesContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_excepcionesContainerData"+"V", Gridlevel_excepcionesContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_excepcionesContainerData"+"V"+"\" value='"+Gridlevel_excepcionesContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      /* User Defined Control */
      ucCombo_oblexcconcodigo.setProperty("Caption", Combo_oblexcconcodigo_Caption);
      ucCombo_oblexcconcodigo.setProperty("Cls", Combo_oblexcconcodigo_Cls);
      ucCombo_oblexcconcodigo.setProperty("IsGridItem", Combo_oblexcconcodigo_Isgriditem);
      ucCombo_oblexcconcodigo.setProperty("EmptyItem", Combo_oblexcconcodigo_Emptyitem);
      ucCombo_oblexcconcodigo.setProperty("DropDownOptionsData", AV34OblExcConCOdigo_Data);
      ucCombo_oblexcconcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_oblexcconcodigo_Internalname, "COMBO_OBLEXCCONCODIGOContainer");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Obligacion.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,121);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Obligacion.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblSecuencial_Internalname, GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,122);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblSecuencial_Jsonclick, 0, "Attribute", "", "", "", "", edtOblSecuencial_Visible, edtOblSecuencial_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Obligacion.htm");
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
      e113D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vOBLEXCCONCODIGO_DATA"), AV34OblExcConCOdigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( "Z1172OblSecuencial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2345OblTipoMov = httpContext.cgiGet( "Z2345OblTipoMov") ;
            Z1173OblEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1173OblEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1175OblOriPer = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1175OblOriPer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1176OblTotal = localUtil.ctond( httpContext.cgiGet( "Z1176OblTotal")) ;
            Z1177OblCanCuo = (short)(localUtil.ctol( httpContext.cgiGet( "Z1177OblCanCuo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1178OblImpFij = localUtil.ctond( httpContext.cgiGet( "Z1178OblImpFij")) ;
            Z1179OblPorc = localUtil.ctond( httpContext.cgiGet( "Z1179OblPorc")) ;
            Z1181OblNoRemu = GXutil.strtobool( httpContext.cgiGet( "Z1181OblNoRemu")) ;
            Z1182OblDescu = GXutil.strtobool( httpContext.cgiGet( "Z1182OblDescu")) ;
            Z1196OblAntiRelaLiq = GXutil.strtobool( httpContext.cgiGet( "Z1196OblAntiRelaLiq")) ;
            Z2343OblConcepto = httpContext.cgiGet( "Z2343OblConcepto") ;
            Z1195OblLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1195OblLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1195OblLiqNro = ((0==A1195OblLiqNro) ? true : false) ;
            Z1169OblConCodigo = httpContext.cgiGet( "Z1169OblConCodigo") ;
            n1169OblConCodigo = ((GXutil.strcmp("", A1169OblConCodigo)==0) ? true : false) ;
            Z1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1163TipoOblSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1175OblOriPer = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1175OblOriPer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1196OblAntiRelaLiq = GXutil.strtobool( httpContext.cgiGet( "Z1196OblAntiRelaLiq")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_113 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_113"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "N1163TipoOblSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N1169OblConCodigo = httpContext.cgiGet( "N1169OblConCodigo") ;
            n1169OblConCodigo = ((GXutil.strcmp("", A1169OblConCodigo)==0) ? true : false) ;
            N1195OblLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "N1195OblLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1195OblLiqNro = ((0==A1195OblLiqNro) ? true : false) ;
            N2343OblConcepto = httpContext.cgiGet( "N2343OblConcepto") ;
            N2345OblTipoMov = httpContext.cgiGet( "N2345OblTipoMov") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( "vOBLSECUENCIAL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV16Insert_TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOOBLSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17Insert_OblConCodigo = httpContext.cgiGet( "vINSERT_OBLCONCODIGO") ;
            AV35Insert_OblLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_OBLLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV46Insert_OblConcepto = httpContext.cgiGet( "vINSERT_OBLCONCEPTO") ;
            A1168TipoOblTotTipo = (byte)(localUtil.ctol( httpContext.cgiGet( "TIPOOBLTOTTIPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV42anticipoTipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( "vANTICIPOTIPOOBLSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2346TipoOblSoloDescu = GXutil.strtobool( httpContext.cgiGet( "TIPOOBLSOLODESCU")) ;
            AV36PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV43anticipoSubTipoConCod1 = httpContext.cgiGet( "vANTICIPOSUBTIPOCONCOD1") ;
            AV44desdeDTipoConCod = httpContext.cgiGet( "vDESDEDTIPOCONCOD") ;
            AV45hastaDTipoConCod = httpContext.cgiGet( "vHASTADTIPOCONCOD") ;
            A1175OblOriPer = (byte)(localUtil.ctol( httpContext.cgiGet( "OBLORIPER"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1196OblAntiRelaLiq = GXutil.strtobool( httpContext.cgiGet( "OBLANTIRELALIQ")) ;
            A250LegIdNomApe = httpContext.cgiGet( "LEGIDNOMAPE") ;
            A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
            A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
            A93LegId = httpContext.cgiGet( "LEGID") ;
            n93LegId = false ;
            A1165TipoOblDescrip = httpContext.cgiGet( "TIPOOBLDESCRIP") ;
            A1164TipoOblCodigo = httpContext.cgiGet( "TIPOOBLCODIGO") ;
            A1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "EMBARGASEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1161EmbargaSec = false ;
            AV52Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Dvpanel_exc_Objectcall = httpContext.cgiGet( "DVPANEL_EXC_Objectcall") ;
            Dvpanel_exc_Class = httpContext.cgiGet( "DVPANEL_EXC_Class") ;
            Dvpanel_exc_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Enabled")) ;
            Dvpanel_exc_Width = httpContext.cgiGet( "DVPANEL_EXC_Width") ;
            Dvpanel_exc_Height = httpContext.cgiGet( "DVPANEL_EXC_Height") ;
            Dvpanel_exc_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Autowidth")) ;
            Dvpanel_exc_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Autoheight")) ;
            Dvpanel_exc_Cls = httpContext.cgiGet( "DVPANEL_EXC_Cls") ;
            Dvpanel_exc_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Showheader")) ;
            Dvpanel_exc_Title = httpContext.cgiGet( "DVPANEL_EXC_Title") ;
            Dvpanel_exc_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Collapsible")) ;
            Dvpanel_exc_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Collapsed")) ;
            Dvpanel_exc_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Showcollapseicon")) ;
            Dvpanel_exc_Iconposition = httpContext.cgiGet( "DVPANEL_EXC_Iconposition") ;
            Dvpanel_exc_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Autoscroll")) ;
            Dvpanel_exc_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXC_Visible")) ;
            Dvpanel_exc_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_EXC_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_oblexcconcodigo_Objectcall = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Objectcall") ;
            Combo_oblexcconcodigo_Class = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Class") ;
            Combo_oblexcconcodigo_Icontype = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Icontype") ;
            Combo_oblexcconcodigo_Icon = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Icon") ;
            Combo_oblexcconcodigo_Caption = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Caption") ;
            Combo_oblexcconcodigo_Tooltip = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Tooltip") ;
            Combo_oblexcconcodigo_Cls = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Cls") ;
            Combo_oblexcconcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Selectedvalue_set") ;
            Combo_oblexcconcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Selectedvalue_get") ;
            Combo_oblexcconcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Selectedtext_set") ;
            Combo_oblexcconcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Selectedtext_get") ;
            Combo_oblexcconcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Gamoauthtoken") ;
            Combo_oblexcconcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Ddointernalname") ;
            Combo_oblexcconcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Titlecontrolalign") ;
            Combo_oblexcconcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Dropdownoptionstype") ;
            Combo_oblexcconcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Enabled")) ;
            Combo_oblexcconcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Visible")) ;
            Combo_oblexcconcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Titlecontrolidtoreplace") ;
            Combo_oblexcconcodigo_Datalisttype = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Datalisttype") ;
            Combo_oblexcconcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Allowmultipleselection")) ;
            Combo_oblexcconcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Datalistfixedvalues") ;
            Combo_oblexcconcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Isgriditem")) ;
            Combo_oblexcconcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Hasdescription")) ;
            Combo_oblexcconcodigo_Datalistproc = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Datalistproc") ;
            Combo_oblexcconcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Datalistprocparametersprefix") ;
            Combo_oblexcconcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Remoteservicesparameters") ;
            Combo_oblexcconcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_oblexcconcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Includeonlyselectedoption")) ;
            Combo_oblexcconcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Includeselectalloption")) ;
            Combo_oblexcconcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Emptyitem")) ;
            Combo_oblexcconcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Includeaddnewoption")) ;
            Combo_oblexcconcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Htmltemplate") ;
            Combo_oblexcconcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Multiplevaluestype") ;
            Combo_oblexcconcodigo_Loadingdata = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Loadingdata") ;
            Combo_oblexcconcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Noresultsfound") ;
            Combo_oblexcconcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Emptyitemtext") ;
            Combo_oblexcconcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Onlyselectedvalues") ;
            Combo_oblexcconcodigo_Selectalltext = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Selectalltext") ;
            Combo_oblexcconcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Multiplevaluesseparator") ;
            Combo_oblexcconcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Addnewoptiontext") ;
            Combo_oblexcconcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_OBLEXCCONCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            dynLegNumero.setName( dynLegNumero.getInternalname() );
            dynLegNumero.setValue( httpContext.cgiGet( dynLegNumero.getInternalname()) );
            A6LegNumero = (int)(GXutil.lval( httpContext.cgiGet( dynLegNumero.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            dynTipoOblSec.setName( dynTipoOblSec.getInternalname() );
            dynTipoOblSec.setValue( httpContext.cgiGet( dynTipoOblSec.getInternalname()) );
            A1163TipoOblSec = (short)(GXutil.lval( httpContext.cgiGet( dynTipoOblSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
            cmbOblEstado.setName( cmbOblEstado.getInternalname() );
            cmbOblEstado.setValue( httpContext.cgiGet( cmbOblEstado.getInternalname()) );
            A1173OblEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbOblEstado.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
            A1174OblObs = httpContext.cgiGet( edtOblObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1174OblObs", A1174OblObs);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOblTotal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOblTotal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLTOTAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOblTotal_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1176OblTotal = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
            }
            else
            {
               A1176OblTotal = localUtil.ctond( httpContext.cgiGet( edtOblTotal_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
            }
            dynOblLiqNro.setName( dynOblLiqNro.getInternalname() );
            dynOblLiqNro.setValue( httpContext.cgiGet( dynOblLiqNro.getInternalname()) );
            A1195OblLiqNro = (int)(GXutil.lval( httpContext.cgiGet( dynOblLiqNro.getInternalname()))) ;
            n1195OblLiqNro = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
            n1195OblLiqNro = ((0==A1195OblLiqNro) ? true : false) ;
            dynOblConCodigo.setName( dynOblConCodigo.getInternalname() );
            dynOblConCodigo.setValue( httpContext.cgiGet( dynOblConCodigo.getInternalname()) );
            A1169OblConCodigo = httpContext.cgiGet( dynOblConCodigo.getInternalname()) ;
            n1169OblConCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
            n1169OblConCodigo = ((GXutil.strcmp("", A1169OblConCodigo)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtOblCanCuo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtOblCanCuo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLCANCUO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOblCanCuo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1177OblCanCuo = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
            }
            else
            {
               A1177OblCanCuo = (short)(localUtil.ctol( httpContext.cgiGet( edtOblCanCuo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
            }
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOblImpFij_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOblImpFij_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLIMPFIJ");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOblImpFij_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1178OblImpFij = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
            }
            else
            {
               A1178OblImpFij = localUtil.ctond( httpContext.cgiGet( edtOblImpFij_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLPORC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOblPorc_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1179OblPorc = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
            }
            else
            {
               A1179OblPorc = localUtil.ctond( httpContext.cgiGet( edtOblPorc_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
            }
            A1181OblNoRemu = GXutil.strtobool( httpContext.cgiGet( chkOblNoRemu.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
            A1182OblDescu = GXutil.strtobool( httpContext.cgiGet( chkOblDescu.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
            cmbOblConcepto.setName( cmbOblConcepto.getInternalname() );
            cmbOblConcepto.setValue( httpContext.cgiGet( cmbOblConcepto.getInternalname()) );
            A2343OblConcepto = httpContext.cgiGet( cmbOblConcepto.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
            cmbOblTipoMov.setName( cmbOblTipoMov.getInternalname() );
            cmbOblTipoMov.setValue( httpContext.cgiGet( cmbOblTipoMov.getInternalname()) );
            A2345OblTipoMov = httpContext.cgiGet( cmbOblTipoMov.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLSECUENCIAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOblSecuencial_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1172OblSecuencial = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            }
            else
            {
               A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Obligacion");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("OblOriPer", localUtil.format( DecimalUtil.doubleToDec(A1175OblOriPer), "Z9"));
            forbiddenHiddens.add("OblAntiRelaLiq", GXutil.booltostr( A1196OblAntiRelaLiq));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("obligacion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A1172OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
               getEqualNoModal( ) ;
               gxalegnumero_html3D134( AV7CliCod, AV8EmpCod) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode134 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxalegnumero_html3D134( AV7CliCod, AV8EmpCod) ;
                  Gx_mode = sMode134 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound134 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3D0( ) ;
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
                        e113D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "TIPOOBLSEC.CONTROLVALUECHANGED") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e133D2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e123D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3D134( ) ;
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
         disableAttributes3D134( ) ;
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

   public void confirm_3D0( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3D134( ) ;
         }
         else
         {
            checkExtendedTable3D134( ) ;
            closeExtendedTableCursors3D134( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode134 = Gx_mode ;
         confirm_3D138( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode134 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode134 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_3D138( )
   {
      nGXsfl_113_idx = 0 ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         readRow3D138( ) ;
         if ( ( nRcdExists_138 != 0 ) || ( nIsMod_138 != 0 ) )
         {
            getKey3D138( ) ;
            if ( ( nRcdExists_138 == 0 ) && ( nRcdDeleted_138 == 0 ) )
            {
               if ( RcdFound138 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate3D138( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable3D138( ) ;
                     closeExtendedTableCursors3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "OBLEXCCONCODIGO_" + sGXsfl_113_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtOblExcConCOdigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound138 != 0 )
               {
                  if ( nRcdDeleted_138 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey3D138( ) ;
                     load3D138( ) ;
                     beforeValidate3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls3D138( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_138 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate3D138( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable3D138( ) ;
                           closeExtendedTableCursors3D138( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_138 == 0 )
                  {
                     GXCCtl = "OBLEXCCONCODIGO_" + sGXsfl_113_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtOblExcConCOdigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtOblExcConCOdigo_Internalname, GXutil.rtrim( A1170OblExcConCOdigo)) ;
         httpContext.changePostValue( cmbOblExcTipo.getInternalname(), GXutil.rtrim( A1183OblExcTipo)) ;
         httpContext.changePostValue( "ZT_"+"Z1170OblExcConCOdigo_"+sGXsfl_113_idx, GXutil.rtrim( Z1170OblExcConCOdigo)) ;
         httpContext.changePostValue( "ZT_"+"Z1183OblExcTipo_"+sGXsfl_113_idx, GXutil.rtrim( Z1183OblExcTipo)) ;
         httpContext.changePostValue( "nRcdDeleted_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_138 != 0 )
         {
            httpContext.changePostValue( "OBLEXCCONCODIGO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtOblExcConCOdigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "OBLEXCTIPO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbOblExcTipo.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption3D0( )
   {
   }

   public void e113D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      Combo_oblexcconcodigo_Titlecontrolidtoreplace = edtOblExcConCOdigo_Internalname ;
      ucCombo_oblexcconcodigo.sendProperty(context, "", false, Combo_oblexcconcodigo_Internalname, "TitleControlIdToReplace", Combo_oblexcconcodigo_Titlecontrolidtoreplace);
      /* Execute user subroutine: 'LOADCOMBOOBLEXCCONCODIGO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Insert", GXv_boolean3) ;
         obligacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Update", GXv_boolean3) ;
         obligacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Delete", GXv_boolean3) ;
         obligacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV52Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV52Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV53GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53GXV1), 8, 0));
         while ( AV53GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV18TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV53GXV1));
            if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoOblSec") == 0 )
            {
               AV16Insert_TipoOblSec = (short)(GXutil.lval( AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_TipoOblSec), 4, 0));
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblConCodigo") == 0 )
            {
               AV17Insert_OblConCodigo = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_OblConCodigo", AV17Insert_OblConCodigo);
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblLiqNro") == 0 )
            {
               AV35Insert_OblLiqNro = (int)(GXutil.lval( AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV35Insert_OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35Insert_OblLiqNro), 8, 0));
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblConcepto") == 0 )
            {
               AV46Insert_OblConcepto = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV46Insert_OblConcepto", AV46Insert_OblConcepto);
            }
            AV53GXV1 = (int)(AV53GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtOblSecuencial_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Visible), 5, 0), true);
      GXt_int4 = AV36PaiCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int5) ;
      obligacion_impl.this.GXt_int4 = GXv_int5[0] ;
      AV36PaiCod = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaiCod), 4, 0));
      GXt_int4 = AV42anticipoTipoOblSec ;
      GXv_int5[0] = GXt_int4 ;
      new web.gettipoobligacionanticipo(remoteHandle, context).execute( AV7CliCod, GXv_int5) ;
      obligacion_impl.this.GXt_int4 = GXv_int5[0] ;
      AV42anticipoTipoOblSec = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42anticipoTipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42anticipoTipoOblSec), 4, 0));
      GXt_char6 = AV43anticipoSubTipoConCod1 ;
      GXv_char7[0] = GXt_char6 ;
      new web.subtipoanticipocuotas(remoteHandle, context).execute( GXv_char7) ;
      obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
      AV43anticipoSubTipoConCod1 = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43anticipoSubTipoConCod1", AV43anticipoSubTipoConCod1);
      GXt_char6 = AV44desdeDTipoConCod ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV36PaiCod, "NRE", GXv_char7) ;
      obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
      AV44desdeDTipoConCod = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44desdeDTipoConCod", AV44desdeDTipoConCod);
      GXt_char6 = AV45hastaDTipoConCod ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV36PaiCod, "REM", GXv_char7) ;
      obligacion_impl.this.GXt_char6 = GXv_char7[0] ;
      AV45hastaDTipoConCod = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45hastaDTipoConCod", AV45hastaDTipoConCod);
      AV50TipoOblSec = A1163TipoOblSec ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TipoOblSec), 4, 0));
      /* Execute user subroutine: 'COMBO CONCEPTOS' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e123D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV7CliCod, AV8EmpCod, A6LegNumero, httpContext.getMessage( "OBLIGACIONES", "")) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(10);
      pr_default.close(9);
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      edtOblTotal_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
      divObltotal_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      dynOblLiqNro.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
      divOblliqnro_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
      dynOblConCodigo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
      divOblconcodigo_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
      edtOblCanCuo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
      divOblcancuo_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      chkOblNoRemu.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
      divOblnoremu_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
      chkOblDescu.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
      divObldescu_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOOBLEXCCONCODIGO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item8 = AV34OblExcConCOdigo_Data ;
      GXv_char7[0] = AV21ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item9[0] = GXt_objcol_SdtDVB_SDTComboData_Item8 ;
      new web.obligacionloaddvcombo(remoteHandle, context).execute( "OblExcConCOdigo", Gx_mode, AV7CliCod, AV8EmpCod, AV9LegNumero, AV10OblSecuencial, GXv_char7, GXv_objcol_SdtDVB_SDTComboData_Item9) ;
      obligacion_impl.this.AV21ComboSelectedValue = GXv_char7[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item8 = GXv_objcol_SdtDVB_SDTComboData_Item9[0] ;
      AV34OblExcConCOdigo_Data = GXt_objcol_SdtDVB_SDTComboData_Item8 ;
   }

   public void e133D2( )
   {
      /* TipoOblSec_Controlvaluechanged Routine */
      returnInSub = false ;
      AV50TipoOblSec = A1163TipoOblSec ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TipoOblSec), 4, 0));
      /* Execute user subroutine: 'COMBO CONCEPTOS' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      cmbOblConcepto.setValue( GXutil.rtrim( A2343OblConcepto) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Values", cmbOblConcepto.ToJavascriptSource(), true);
   }

   public void S132( )
   {
      /* 'COMBO CONCEPTOS' Routine */
      returnInSub = false ;
      cmbOblConcepto.removeAllItems();
      GXv_objcol_char10[0] = AV33ConCodigo ;
      new web.obligacionconceptos(remoteHandle, context).execute( AV7CliCod, AV50TipoOblSec, GXv_objcol_char10) ;
      AV33ConCodigo = GXv_objcol_char10[0] ;
      AV48i = (short)(1) ;
      while ( AV48i <= AV33ConCodigo.size() )
      {
         GXv_char7[0] = AV49ConDescrip ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV7CliCod, (String)AV33ConCodigo.elementAt(-1+AV48i), GXv_char7) ;
         obligacion_impl.this.AV49ConDescrip = GXv_char7[0] ;
         cmbOblConcepto.addItem((String)AV33ConCodigo.elementAt(-1+AV48i), AV49ConDescrip, (short)(0));
         AV48i = (short)(AV48i+1) ;
      }
   }

   public void zm3D134( int GX_JID )
   {
      if ( ( GX_JID == 57 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2345OblTipoMov = T003D6_A2345OblTipoMov[0] ;
            Z1173OblEstado = T003D6_A1173OblEstado[0] ;
            Z1175OblOriPer = T003D6_A1175OblOriPer[0] ;
            Z1176OblTotal = T003D6_A1176OblTotal[0] ;
            Z1177OblCanCuo = T003D6_A1177OblCanCuo[0] ;
            Z1178OblImpFij = T003D6_A1178OblImpFij[0] ;
            Z1179OblPorc = T003D6_A1179OblPorc[0] ;
            Z1181OblNoRemu = T003D6_A1181OblNoRemu[0] ;
            Z1182OblDescu = T003D6_A1182OblDescu[0] ;
            Z1196OblAntiRelaLiq = T003D6_A1196OblAntiRelaLiq[0] ;
            Z2343OblConcepto = T003D6_A2343OblConcepto[0] ;
            Z1195OblLiqNro = T003D6_A1195OblLiqNro[0] ;
            Z1169OblConCodigo = T003D6_A1169OblConCodigo[0] ;
            Z1163TipoOblSec = T003D6_A1163TipoOblSec[0] ;
         }
         else
         {
            Z2345OblTipoMov = A2345OblTipoMov ;
            Z1173OblEstado = A1173OblEstado ;
            Z1175OblOriPer = A1175OblOriPer ;
            Z1176OblTotal = A1176OblTotal ;
            Z1177OblCanCuo = A1177OblCanCuo ;
            Z1178OblImpFij = A1178OblImpFij ;
            Z1179OblPorc = A1179OblPorc ;
            Z1181OblNoRemu = A1181OblNoRemu ;
            Z1182OblDescu = A1182OblDescu ;
            Z1196OblAntiRelaLiq = A1196OblAntiRelaLiq ;
            Z2343OblConcepto = A2343OblConcepto ;
            Z1195OblLiqNro = A1195OblLiqNro ;
            Z1169OblConCodigo = A1169OblConCodigo ;
            Z1163TipoOblSec = A1163TipoOblSec ;
         }
      }
      if ( GX_JID == -57 )
      {
         Z1172OblSecuencial = A1172OblSecuencial ;
         Z2345OblTipoMov = A2345OblTipoMov ;
         Z1173OblEstado = A1173OblEstado ;
         Z1174OblObs = A1174OblObs ;
         Z1175OblOriPer = A1175OblOriPer ;
         Z1176OblTotal = A1176OblTotal ;
         Z1177OblCanCuo = A1177OblCanCuo ;
         Z1178OblImpFij = A1178OblImpFij ;
         Z1179OblPorc = A1179OblPorc ;
         Z1181OblNoRemu = A1181OblNoRemu ;
         Z1182OblDescu = A1182OblDescu ;
         Z1196OblAntiRelaLiq = A1196OblAntiRelaLiq ;
         Z3CliCod = A3CliCod ;
         Z2343OblConcepto = A2343OblConcepto ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1195OblLiqNro = A1195OblLiqNro ;
         Z1169OblConCodigo = A1169OblConCodigo ;
         Z1163TipoOblSec = A1163TipoOblSec ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z1165TipoOblDescrip = A1165TipoOblDescrip ;
         Z1164TipoOblCodigo = A1164TipoOblCodigo ;
         Z1168TipoOblTotTipo = A1168TipoOblTotTipo ;
         Z2346TipoOblSoloDescu = A2346TipoOblSoloDescu ;
         Z1161EmbargaSec = A1161EmbargaSec ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
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
            GXt_int11 = A3CliCod ;
            GXv_int12[0] = GXt_int11 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int12) ;
            obligacion_impl.this.GXt_int11 = GXv_int12[0] ;
            A3CliCod = GXt_int11 ;
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
      gxalegnumero_html3D134( AV7CliCod, AV8EmpCod) ;
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ! (0==AV9LegNumero) )
      {
         dynLegNumero.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegNumero.getEnabled(), 5, 0), true);
      }
      else
      {
         dynLegNumero.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegNumero.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         dynLegNumero.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegNumero.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV10OblSecuencial) )
      {
         A1172OblSecuencial = AV10OblSecuencial ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
      if ( ! (0==AV10OblSecuencial) )
      {
         edtOblSecuencial_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Enabled), 5, 0), true);
      }
      else
      {
         edtOblSecuencial_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10OblSecuencial) )
      {
         edtOblSecuencial_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_TipoOblSec) )
      {
         dynTipoOblSec.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoOblSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoOblSec.getEnabled(), 5, 0), true);
      }
      else
      {
         dynTipoOblSec.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoOblSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoOblSec.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_OblConCodigo)==0) )
      {
         dynOblConCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblConCodigo.getEnabled(), 5, 0), true);
      }
      else
      {
         dynOblConCodigo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblConCodigo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV35Insert_OblLiqNro) )
      {
         dynOblLiqNro.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblLiqNro.getEnabled(), 5, 0), true);
      }
      else
      {
         dynOblLiqNro.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblLiqNro.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV46Insert_OblConcepto)==0) )
      {
         cmbOblConcepto.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblConcepto.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbOblConcepto.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblConcepto.getEnabled(), 5, 0), true);
      }
      gxatipooblsec_html3D134( AV36PaiCod) ;
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV46Insert_OblConcepto)==0) )
      {
         A2343OblConcepto = AV46Insert_OblConcepto ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV35Insert_OblLiqNro) )
      {
         A1195OblLiqNro = AV35Insert_OblLiqNro ;
         n1195OblLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_OblConCodigo)==0) )
      {
         A1169OblConCodigo = AV17Insert_OblConCodigo ;
         n1169OblConCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_TipoOblSec) )
      {
         A1163TipoOblSec = AV16Insert_TipoOblSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
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
      if ( isIns( )  && (0==A1173OblEstado) && ( Gx_BScreen == 0 ) )
      {
         A1173OblEstado = (byte)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV52Pgmname = "Obligacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52Pgmname", AV52Pgmname);
         /* Using cursor T003D8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T003D8_A250LegIdNomApe[0] ;
         A251LegNombre = T003D8_A251LegNombre[0] ;
         A251LegNombre = T003D8_A251LegNombre[0] ;
         A230LegApellido = T003D8_A230LegApellido[0] ;
         A230LegApellido = T003D8_A230LegApellido[0] ;
         A93LegId = T003D8_A93LegId[0] ;
         n93LegId = T003D8_n93LegId[0] ;
         A93LegId = T003D8_A93LegId[0] ;
         n93LegId = T003D8_n93LegId[0] ;
         pr_default.close(6);
         /* Using cursor T003D12 */
         pr_default.execute(10, new Object[] {Short.valueOf(A1163TipoOblSec)});
         A1165TipoOblDescrip = T003D12_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = T003D12_A1164TipoOblCodigo[0] ;
         A1168TipoOblTotTipo = T003D12_A1168TipoOblTotTipo[0] ;
         A2346TipoOblSoloDescu = T003D12_A2346TipoOblSoloDescu[0] ;
         A1161EmbargaSec = T003D12_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003D12_n1161EmbargaSec[0] ;
         pr_default.close(10);
         edtOblTotal_Visible = ((A1168TipoOblTotTipo==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
         {
            divObltotal_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
         }
         else
         {
            if ( A1168TipoOblTotTipo == 1 )
            {
               divObltotal_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
            }
         }
         dynOblLiqNro.setVisible( ((A1168TipoOblTotTipo==2) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
         edtOblCanCuo_Visible = ((A1168TipoOblTotTipo!=0) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
         {
            divOblcancuo_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
         }
         else
         {
            if ( A1168TipoOblTotTipo != 0 )
            {
               divOblcancuo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
            }
         }
         if ( A2346TipoOblSoloDescu )
         {
            cmbOblTipoMov.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbOblTipoMov.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
         }
         dynOblConCodigo.setVisible( ((A1168TipoOblTotTipo==2)&&!(0==A1195OblLiqNro) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
         {
            divOblliqnro_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
            }
            else
            {
               if ( ( A1168TipoOblTotTipo == 2 ) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
               {
                  divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
               }
            }
         }
         if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
         {
            divOblconcodigo_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
            }
            else
            {
               if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
               {
                  divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
               }
            }
         }
         gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
         gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      }
   }

   public void load3D134( )
   {
      /* Using cursor T003D13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A1172OblSecuencial), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A250LegIdNomApe = T003D13_A250LegIdNomApe[0] ;
         A2345OblTipoMov = T003D13_A2345OblTipoMov[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
         A1165TipoOblDescrip = T003D13_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = T003D13_A1164TipoOblCodigo[0] ;
         A1173OblEstado = T003D13_A1173OblEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
         A1174OblObs = T003D13_A1174OblObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1174OblObs", A1174OblObs);
         A1175OblOriPer = T003D13_A1175OblOriPer[0] ;
         A1168TipoOblTotTipo = T003D13_A1168TipoOblTotTipo[0] ;
         A1176OblTotal = T003D13_A1176OblTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
         A1177OblCanCuo = T003D13_A1177OblCanCuo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
         A1178OblImpFij = T003D13_A1178OblImpFij[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
         A1179OblPorc = T003D13_A1179OblPorc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
         A1181OblNoRemu = T003D13_A1181OblNoRemu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
         A1182OblDescu = T003D13_A1182OblDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
         A1196OblAntiRelaLiq = T003D13_A1196OblAntiRelaLiq[0] ;
         A2346TipoOblSoloDescu = T003D13_A2346TipoOblSoloDescu[0] ;
         A251LegNombre = T003D13_A251LegNombre[0] ;
         A230LegApellido = T003D13_A230LegApellido[0] ;
         A93LegId = T003D13_A93LegId[0] ;
         n93LegId = T003D13_n93LegId[0] ;
         A2343OblConcepto = T003D13_A2343OblConcepto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
         A1195OblLiqNro = T003D13_A1195OblLiqNro[0] ;
         n1195OblLiqNro = T003D13_n1195OblLiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         A1169OblConCodigo = T003D13_A1169OblConCodigo[0] ;
         n1169OblConCodigo = T003D13_n1169OblConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
         A1163TipoOblSec = T003D13_A1163TipoOblSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         A1161EmbargaSec = T003D13_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003D13_n1161EmbargaSec[0] ;
         zm3D134( -57) ;
      }
      pr_default.close(11);
      onLoadActions3D134( ) ;
   }

   public void onLoadActions3D134( )
   {
      AV52Pgmname = "Obligacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52Pgmname", AV52Pgmname);
      gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      edtOblTotal_Visible = ((A1168TipoOblTotTipo==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
      if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
      {
         divObltotal_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      }
      else
      {
         if ( A1168TipoOblTotTipo == 1 )
         {
            divObltotal_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
         }
      }
      dynOblLiqNro.setVisible( ((A1168TipoOblTotTipo==2) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
      dynOblConCodigo.setVisible( ((A1168TipoOblTotTipo==2)&&!(0==A1195OblLiqNro) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
      edtOblCanCuo_Visible = ((A1168TipoOblTotTipo!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
      if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
      {
         divOblcancuo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      }
      else
      {
         if ( A1168TipoOblTotTipo != 0 )
         {
            divOblcancuo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
         }
      }
      if ( A2346TipoOblSoloDescu )
      {
         cmbOblTipoMov.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbOblTipoMov.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
      {
         divOblliqnro_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
            }
         }
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
      {
         divOblconcodigo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
            }
         }
      }
      chkOblNoRemu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         divOblnoremu_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
      }
      else
      {
         if ( A1179OblPorc.doubleValue() > 0 )
         {
            divOblnoremu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
         }
      }
      chkOblDescu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         divObldescu_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
      }
      else
      {
         if ( A1179OblPorc.doubleValue() > 0 )
         {
            divObldescu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
         }
      }
      tblTblexc_Visible = ((!(DecimalUtil.compareTo(DecimalUtil.ZERO, A1179OblPorc)==0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTblexc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblexc_Visible), 5, 0), true);
      if ( isIns( )  && (GXutil.strcmp("", A2345OblTipoMov)==0) && ( Gx_BScreen == 0 ) )
      {
         A2345OblTipoMov = "Descuento" ;
         httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
      }
      else
      {
         if ( A2346TipoOblSoloDescu )
         {
            A2345OblTipoMov = "Descuento" ;
            httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
         }
      }
   }

   public void checkExtendedTable3D134( )
   {
      nIsDirty_134 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV52Pgmname = "Obligacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52Pgmname", AV52Pgmname);
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (0==A1195OblLiqNro) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liq Nro", ""), "", "", "", "", "", "", "", ""), 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (GXutil.strcmp("", A1169OblConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Origen concepto", ""), "", "", "", "", "", "", "", ""), 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T003D7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A2343OblConcepto});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      /* Using cursor T003D11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1169OblConCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(9);
      /* Using cursor T003D9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Anticipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(7);
      /* Using cursor T003D8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T003D8_A250LegIdNomApe[0] ;
      A251LegNombre = T003D8_A251LegNombre[0] ;
      A251LegNombre = T003D8_A251LegNombre[0] ;
      A230LegApellido = T003D8_A230LegApellido[0] ;
      A230LegApellido = T003D8_A230LegApellido[0] ;
      A93LegId = T003D8_A93LegId[0] ;
      n93LegId = T003D8_n93LegId[0] ;
      A93LegId = T003D8_A93LegId[0] ;
      n93LegId = T003D8_n93LegId[0] ;
      pr_default.close(6);
      /* Using cursor T003D10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(8);
      gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegNumero.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T003D12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo_obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1165TipoOblDescrip = T003D12_A1165TipoOblDescrip[0] ;
      A1164TipoOblCodigo = T003D12_A1164TipoOblCodigo[0] ;
      A1168TipoOblTotTipo = T003D12_A1168TipoOblTotTipo[0] ;
      A2346TipoOblSoloDescu = T003D12_A2346TipoOblSoloDescu[0] ;
      A1161EmbargaSec = T003D12_A1161EmbargaSec[0] ;
      n1161EmbargaSec = T003D12_n1161EmbargaSec[0] ;
      pr_default.close(10);
      edtOblTotal_Visible = ((A1168TipoOblTotTipo==1) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
      if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
      {
         divObltotal_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      }
      else
      {
         if ( A1168TipoOblTotTipo == 1 )
         {
            divObltotal_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
         }
      }
      dynOblLiqNro.setVisible( ((A1168TipoOblTotTipo==2) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
      dynOblConCodigo.setVisible( ((A1168TipoOblTotTipo==2)&&!(0==A1195OblLiqNro) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
      edtOblCanCuo_Visible = ((A1168TipoOblTotTipo!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
      if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
      {
         divOblcancuo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      }
      else
      {
         if ( A1168TipoOblTotTipo != 0 )
         {
            divOblcancuo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
         }
      }
      if ( A2346TipoOblSoloDescu )
      {
         cmbOblTipoMov.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbOblTipoMov.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
      {
         divOblliqnro_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
            }
         }
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
      {
         divOblconcodigo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
            }
         }
      }
      if ( (0==A1163TipoOblSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1173OblEstado == 0 ) || ( A1173OblEstado == 1 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "OBLESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbOblEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      chkOblNoRemu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         divOblnoremu_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
      }
      else
      {
         if ( A1179OblPorc.doubleValue() > 0 )
         {
            divOblnoremu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
         }
      }
      chkOblDescu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
      if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
      {
         divObldescu_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
      }
      else
      {
         if ( A1179OblPorc.doubleValue() > 0 )
         {
            divObldescu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
         }
      }
      tblTblexc_Visible = ((!(DecimalUtil.compareTo(DecimalUtil.ZERO, A1179OblPorc)==0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTblexc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblexc_Visible), 5, 0), true);
      if ( A1179OblPorc.doubleValue() >= 1 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El porcentaje debe estar entre los valores 0 y 1", ""), 1, "OBLPORC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOblPorc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A2343OblConcepto)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbOblConcepto.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isIns( )  && (GXutil.strcmp("", A2345OblTipoMov)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_134 = (short)(1) ;
         A2345OblTipoMov = "Descuento" ;
         httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
      }
      else
      {
         if ( A2346TipoOblSoloDescu )
         {
            nIsDirty_134 = (short)(1) ;
            A2345OblTipoMov = "Descuento" ;
            httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
         }
      }
      if ( ! ( ( GXutil.strcmp(A2345OblTipoMov, "Descuento") == 0 ) || ( GXutil.strcmp(A2345OblTipoMov, "Acreditacion") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "OBLTIPOMOV");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbOblTipoMov.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors3D134( )
   {
      pr_default.close(5);
      pr_default.close(9);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(8);
      pr_default.close(10);
   }

   public void enableDisable( )
   {
   }

   public void gxload_58( int A3CliCod ,
                          String A2343OblConcepto )
   {
      /* Using cursor T003D14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A2343OblConcepto});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
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

   public void gxload_62( int A3CliCod ,
                          String A1169OblConCodigo )
   {
      /* Using cursor T003D15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1169OblConCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
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

   public void gxload_60( int A3CliCod ,
                          short A1EmpCod ,
                          int A1195OblLiqNro )
   {
      /* Using cursor T003D16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Anticipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
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

   public void gxload_59( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T003D17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T003D17_A250LegIdNomApe[0] ;
      A251LegNombre = T003D17_A251LegNombre[0] ;
      A251LegNombre = T003D17_A251LegNombre[0] ;
      A230LegApellido = T003D17_A230LegApellido[0] ;
      A230LegApellido = T003D17_A230LegApellido[0] ;
      A93LegId = T003D17_A93LegId[0] ;
      n93LegId = T003D17_n93LegId[0] ;
      A93LegId = T003D17_A93LegId[0] ;
      n93LegId = T003D17_n93LegId[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A250LegIdNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void gxload_61( int A3CliCod ,
                          short A1EmpCod ,
                          int A1195OblLiqNro ,
                          int A6LegNumero )
   {
      /* Using cursor T003D18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
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

   public void gxload_63( short A1163TipoOblSec )
   {
      /* Using cursor T003D19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo_obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1165TipoOblDescrip = T003D19_A1165TipoOblDescrip[0] ;
      A1164TipoOblCodigo = T003D19_A1164TipoOblCodigo[0] ;
      A1168TipoOblTotTipo = T003D19_A1168TipoOblTotTipo[0] ;
      A2346TipoOblSoloDescu = T003D19_A2346TipoOblSoloDescu[0] ;
      A1161EmbargaSec = T003D19_A1161EmbargaSec[0] ;
      n1161EmbargaSec = T003D19_n1161EmbargaSec[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1165TipoOblDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1164TipoOblCodigo))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1168TipoOblTotTipo, (byte)(1), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( A2346TipoOblSoloDescu))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(17) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(17);
   }

   public void getKey3D134( )
   {
      /* Using cursor T003D20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound134 = (short)(1) ;
      }
      else
      {
         RcdFound134 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003D6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm3D134( 57) ;
         RcdFound134 = (short)(1) ;
         A1172OblSecuencial = T003D6_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         A2345OblTipoMov = T003D6_A2345OblTipoMov[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
         A1173OblEstado = T003D6_A1173OblEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
         A1174OblObs = T003D6_A1174OblObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1174OblObs", A1174OblObs);
         A1175OblOriPer = T003D6_A1175OblOriPer[0] ;
         A1176OblTotal = T003D6_A1176OblTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
         A1177OblCanCuo = T003D6_A1177OblCanCuo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
         A1178OblImpFij = T003D6_A1178OblImpFij[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
         A1179OblPorc = T003D6_A1179OblPorc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
         A1181OblNoRemu = T003D6_A1181OblNoRemu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
         A1182OblDescu = T003D6_A1182OblDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
         A1196OblAntiRelaLiq = T003D6_A1196OblAntiRelaLiq[0] ;
         A3CliCod = T003D6_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2343OblConcepto = T003D6_A2343OblConcepto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
         A1EmpCod = T003D6_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003D6_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1195OblLiqNro = T003D6_A1195OblLiqNro[0] ;
         n1195OblLiqNro = T003D6_n1195OblLiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
         A1169OblConCodigo = T003D6_A1169OblConCodigo[0] ;
         n1169OblConCodigo = T003D6_n1169OblConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
         A1163TipoOblSec = T003D6_A1163TipoOblSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
         sMode134 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3D134( ) ;
         if ( AnyError == 1 )
         {
            RcdFound134 = (short)(0) ;
            initializeNonKey3D134( ) ;
         }
         Gx_mode = sMode134 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound134 = (short)(0) ;
         initializeNonKey3D134( ) ;
         sMode134 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode134 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey3D134( ) ;
      if ( RcdFound134 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound134 = (short)(0) ;
      /* Using cursor T003D21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A1172OblSecuencial), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         while ( (pr_default.getStatus(19) != 101) && ( ( T003D21_A1172OblSecuencial[0] < A1172OblSecuencial ) || ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A3CliCod[0] < A3CliCod ) || ( T003D21_A3CliCod[0] == A3CliCod ) && ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A1EmpCod[0] < A1EmpCod ) || ( T003D21_A1EmpCod[0] == A1EmpCod ) && ( T003D21_A3CliCod[0] == A3CliCod ) && ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(19);
         }
         if ( (pr_default.getStatus(19) != 101) && ( ( T003D21_A1172OblSecuencial[0] > A1172OblSecuencial ) || ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A3CliCod[0] > A3CliCod ) || ( T003D21_A3CliCod[0] == A3CliCod ) && ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A1EmpCod[0] > A1EmpCod ) || ( T003D21_A1EmpCod[0] == A1EmpCod ) && ( T003D21_A3CliCod[0] == A3CliCod ) && ( T003D21_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D21_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A1172OblSecuencial = T003D21_A1172OblSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            A3CliCod = T003D21_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003D21_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003D21_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound134 = (short)(1) ;
         }
      }
      pr_default.close(19);
   }

   public void move_previous( )
   {
      RcdFound134 = (short)(0) ;
      /* Using cursor T003D22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A1172OblSecuencial), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         while ( (pr_default.getStatus(20) != 101) && ( ( T003D22_A1172OblSecuencial[0] > A1172OblSecuencial ) || ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A3CliCod[0] > A3CliCod ) || ( T003D22_A3CliCod[0] == A3CliCod ) && ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A1EmpCod[0] > A1EmpCod ) || ( T003D22_A1EmpCod[0] == A1EmpCod ) && ( T003D22_A3CliCod[0] == A3CliCod ) && ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(20);
         }
         if ( (pr_default.getStatus(20) != 101) && ( ( T003D22_A1172OblSecuencial[0] < A1172OblSecuencial ) || ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A3CliCod[0] < A3CliCod ) || ( T003D22_A3CliCod[0] == A3CliCod ) && ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A1EmpCod[0] < A1EmpCod ) || ( T003D22_A1EmpCod[0] == A1EmpCod ) && ( T003D22_A3CliCod[0] == A3CliCod ) && ( T003D22_A1172OblSecuencial[0] == A1172OblSecuencial ) && ( T003D22_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A1172OblSecuencial = T003D22_A1172OblSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            A3CliCod = T003D22_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003D22_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003D22_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound134 = (short)(1) ;
         }
      }
      pr_default.close(20);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3D134( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynLegNumero.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3D134( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound134 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A1172OblSecuencial = Z1172OblSecuencial ;
               httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynLegNumero.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3D134( ) ;
               GX_FocusControl = dynLegNumero.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
            {
               /* Insert record */
               GX_FocusControl = dynLegNumero.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3D134( ) ;
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
                  GX_FocusControl = dynLegNumero.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3D134( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = Z1172OblSecuencial ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynLegNumero.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3D134( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003D5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Obligacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( GXutil.strcmp(Z2345OblTipoMov, T003D5_A2345OblTipoMov[0]) != 0 ) || ( Z1173OblEstado != T003D5_A1173OblEstado[0] ) || ( Z1175OblOriPer != T003D5_A1175OblOriPer[0] ) || ( DecimalUtil.compareTo(Z1176OblTotal, T003D5_A1176OblTotal[0]) != 0 ) || ( Z1177OblCanCuo != T003D5_A1177OblCanCuo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1178OblImpFij, T003D5_A1178OblImpFij[0]) != 0 ) || ( DecimalUtil.compareTo(Z1179OblPorc, T003D5_A1179OblPorc[0]) != 0 ) || ( Z1181OblNoRemu != T003D5_A1181OblNoRemu[0] ) || ( Z1182OblDescu != T003D5_A1182OblDescu[0] ) || ( Z1196OblAntiRelaLiq != T003D5_A1196OblAntiRelaLiq[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2343OblConcepto, T003D5_A2343OblConcepto[0]) != 0 ) || ( Z1195OblLiqNro != T003D5_A1195OblLiqNro[0] ) || ( GXutil.strcmp(Z1169OblConCodigo, T003D5_A1169OblConCodigo[0]) != 0 ) || ( Z1163TipoOblSec != T003D5_A1163TipoOblSec[0] ) )
         {
            if ( GXutil.strcmp(Z2345OblTipoMov, T003D5_A2345OblTipoMov[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblTipoMov");
               GXutil.writeLogRaw("Old: ",Z2345OblTipoMov);
               GXutil.writeLogRaw("Current: ",T003D5_A2345OblTipoMov[0]);
            }
            if ( Z1173OblEstado != T003D5_A1173OblEstado[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblEstado");
               GXutil.writeLogRaw("Old: ",Z1173OblEstado);
               GXutil.writeLogRaw("Current: ",T003D5_A1173OblEstado[0]);
            }
            if ( Z1175OblOriPer != T003D5_A1175OblOriPer[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblOriPer");
               GXutil.writeLogRaw("Old: ",Z1175OblOriPer);
               GXutil.writeLogRaw("Current: ",T003D5_A1175OblOriPer[0]);
            }
            if ( DecimalUtil.compareTo(Z1176OblTotal, T003D5_A1176OblTotal[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblTotal");
               GXutil.writeLogRaw("Old: ",Z1176OblTotal);
               GXutil.writeLogRaw("Current: ",T003D5_A1176OblTotal[0]);
            }
            if ( Z1177OblCanCuo != T003D5_A1177OblCanCuo[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblCanCuo");
               GXutil.writeLogRaw("Old: ",Z1177OblCanCuo);
               GXutil.writeLogRaw("Current: ",T003D5_A1177OblCanCuo[0]);
            }
            if ( DecimalUtil.compareTo(Z1178OblImpFij, T003D5_A1178OblImpFij[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblImpFij");
               GXutil.writeLogRaw("Old: ",Z1178OblImpFij);
               GXutil.writeLogRaw("Current: ",T003D5_A1178OblImpFij[0]);
            }
            if ( DecimalUtil.compareTo(Z1179OblPorc, T003D5_A1179OblPorc[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblPorc");
               GXutil.writeLogRaw("Old: ",Z1179OblPorc);
               GXutil.writeLogRaw("Current: ",T003D5_A1179OblPorc[0]);
            }
            if ( Z1181OblNoRemu != T003D5_A1181OblNoRemu[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblNoRemu");
               GXutil.writeLogRaw("Old: ",Z1181OblNoRemu);
               GXutil.writeLogRaw("Current: ",T003D5_A1181OblNoRemu[0]);
            }
            if ( Z1182OblDescu != T003D5_A1182OblDescu[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblDescu");
               GXutil.writeLogRaw("Old: ",Z1182OblDescu);
               GXutil.writeLogRaw("Current: ",T003D5_A1182OblDescu[0]);
            }
            if ( Z1196OblAntiRelaLiq != T003D5_A1196OblAntiRelaLiq[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblAntiRelaLiq");
               GXutil.writeLogRaw("Old: ",Z1196OblAntiRelaLiq);
               GXutil.writeLogRaw("Current: ",T003D5_A1196OblAntiRelaLiq[0]);
            }
            if ( GXutil.strcmp(Z2343OblConcepto, T003D5_A2343OblConcepto[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblConcepto");
               GXutil.writeLogRaw("Old: ",Z2343OblConcepto);
               GXutil.writeLogRaw("Current: ",T003D5_A2343OblConcepto[0]);
            }
            if ( Z1195OblLiqNro != T003D5_A1195OblLiqNro[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblLiqNro");
               GXutil.writeLogRaw("Old: ",Z1195OblLiqNro);
               GXutil.writeLogRaw("Current: ",T003D5_A1195OblLiqNro[0]);
            }
            if ( GXutil.strcmp(Z1169OblConCodigo, T003D5_A1169OblConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblConCodigo");
               GXutil.writeLogRaw("Old: ",Z1169OblConCodigo);
               GXutil.writeLogRaw("Current: ",T003D5_A1169OblConCodigo[0]);
            }
            if ( Z1163TipoOblSec != T003D5_A1163TipoOblSec[0] )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"TipoOblSec");
               GXutil.writeLogRaw("Old: ",Z1163TipoOblSec);
               GXutil.writeLogRaw("Current: ",T003D5_A1163TipoOblSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Obligacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3D134( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3D134( 0) ;
         checkOptimisticConcurrency3D134( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D134( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3D134( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003D23 */
                  pr_default.execute(21, new Object[] {Short.valueOf(A1172OblSecuencial), A2345OblTipoMov, Byte.valueOf(A1173OblEstado), A1174OblObs, Byte.valueOf(A1175OblOriPer), A1176OblTotal, Short.valueOf(A1177OblCanCuo), A1178OblImpFij, A1179OblPorc, Boolean.valueOf(A1181OblNoRemu), Boolean.valueOf(A1182OblDescu), Boolean.valueOf(A1196OblAntiRelaLiq), Integer.valueOf(A3CliCod), A2343OblConcepto, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo, Short.valueOf(A1163TipoOblSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
                  if ( (pr_default.getStatus(21) == 1) )
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
                        processLevel3D134( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption3D0( ) ;
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
         else
         {
            load3D134( ) ;
         }
         endLevel3D134( ) ;
      }
      closeExtendedTableCursors3D134( ) ;
   }

   public void update3D134( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D134( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D134( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3D134( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003D24 */
                  pr_default.execute(22, new Object[] {A2345OblTipoMov, Byte.valueOf(A1173OblEstado), A1174OblObs, Byte.valueOf(A1175OblOriPer), A1176OblTotal, Short.valueOf(A1177OblCanCuo), A1178OblImpFij, A1179OblPorc, Boolean.valueOf(A1181OblNoRemu), Boolean.valueOf(A1182OblDescu), Boolean.valueOf(A1196OblAntiRelaLiq), A2343OblConcepto, Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo, Short.valueOf(A1163TipoOblSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
                  if ( (pr_default.getStatus(22) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Obligacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3D134( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel3D134( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel3D134( ) ;
      }
      closeExtendedTableCursors3D134( ) ;
   }

   public void deferredUpdate3D134( )
   {
   }

   public void delete( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3D134( ) ;
         afterConfirm3D134( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3D134( ) ;
            if ( AnyError == 0 )
            {
               scanStart3D138( ) ;
               while ( RcdFound138 != 0 )
               {
                  getByPrimaryKey3D138( ) ;
                  delete3D138( ) ;
                  scanNext3D138( ) ;
               }
               scanEnd3D138( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003D25 */
                  pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
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
      }
      sMode134 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3D134( ) ;
      Gx_mode = sMode134 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3D134( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV52Pgmname = "Obligacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52Pgmname", AV52Pgmname);
         /* Using cursor T003D26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T003D26_A250LegIdNomApe[0] ;
         A251LegNombre = T003D26_A251LegNombre[0] ;
         A251LegNombre = T003D26_A251LegNombre[0] ;
         A230LegApellido = T003D26_A230LegApellido[0] ;
         A230LegApellido = T003D26_A230LegApellido[0] ;
         A93LegId = T003D26_A93LegId[0] ;
         n93LegId = T003D26_n93LegId[0] ;
         A93LegId = T003D26_A93LegId[0] ;
         n93LegId = T003D26_n93LegId[0] ;
         pr_default.close(24);
         gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
         gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
         /* Using cursor T003D27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A1163TipoOblSec)});
         A1165TipoOblDescrip = T003D27_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = T003D27_A1164TipoOblCodigo[0] ;
         A1168TipoOblTotTipo = T003D27_A1168TipoOblTotTipo[0] ;
         A2346TipoOblSoloDescu = T003D27_A2346TipoOblSoloDescu[0] ;
         A1161EmbargaSec = T003D27_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003D27_n1161EmbargaSec[0] ;
         pr_default.close(25);
         edtOblTotal_Visible = ((A1168TipoOblTotTipo==1) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
         {
            divObltotal_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
         }
         else
         {
            if ( A1168TipoOblTotTipo == 1 )
            {
               divObltotal_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
            }
         }
         dynOblLiqNro.setVisible( ((A1168TipoOblTotTipo==2) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
         edtOblCanCuo_Visible = ((A1168TipoOblTotTipo!=0) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
         {
            divOblcancuo_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
         }
         else
         {
            if ( A1168TipoOblTotTipo != 0 )
            {
               divOblcancuo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
            }
         }
         if ( A2346TipoOblSoloDescu )
         {
            cmbOblTipoMov.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbOblTipoMov.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
         }
         if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
         {
            divOblliqnro_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
            }
            else
            {
               if ( ( A1168TipoOblTotTipo == 2 ) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
               {
                  divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
               }
            }
         }
         chkOblNoRemu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblNoRemu.getVisible(), 5, 0), true);
         if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
         {
            divOblnoremu_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
         }
         else
         {
            if ( A1179OblPorc.doubleValue() > 0 )
            {
               divOblnoremu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblnoremu_cell_Internalname, "Class", divOblnoremu_cell_Class, true);
            }
         }
         chkOblDescu.setVisible( ((A1179OblPorc.doubleValue()>0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Visible", GXutil.ltrimstr( chkOblDescu.getVisible(), 5, 0), true);
         if ( ! ( ( A1179OblPorc.doubleValue() > 0 ) ) )
         {
            divObldescu_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
         }
         else
         {
            if ( A1179OblPorc.doubleValue() > 0 )
            {
               divObldescu_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divObldescu_cell_Internalname, "Class", divObldescu_cell_Class, true);
            }
         }
         tblTblexc_Visible = ((!(DecimalUtil.compareTo(DecimalUtil.ZERO, A1179OblPorc)==0)) ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, tblTblexc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblexc_Visible), 5, 0), true);
         dynOblConCodigo.setVisible( ((A1168TipoOblTotTipo==2)&&!(0==A1195OblLiqNro) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
         if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
         {
            divOblconcodigo_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
            }
            else
            {
               if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
               {
                  divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
               }
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003D28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
      }
   }

   public void processNestedLevel3D138( )
   {
      nGXsfl_113_idx = 0 ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         readRow3D138( ) ;
         if ( ( nRcdExists_138 != 0 ) || ( nIsMod_138 != 0 ) )
         {
            standaloneNotModal3D138( ) ;
            getKey3D138( ) ;
            if ( ( nRcdExists_138 == 0 ) && ( nRcdDeleted_138 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert3D138( ) ;
            }
            else
            {
               if ( RcdFound138 != 0 )
               {
                  if ( ( nRcdDeleted_138 != 0 ) && ( nRcdExists_138 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete3D138( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_138 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update3D138( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_138 == 0 )
                  {
                     GXCCtl = "OBLEXCCONCODIGO_" + sGXsfl_113_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtOblExcConCOdigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtOblExcConCOdigo_Internalname, GXutil.rtrim( A1170OblExcConCOdigo)) ;
         httpContext.changePostValue( cmbOblExcTipo.getInternalname(), GXutil.rtrim( A1183OblExcTipo)) ;
         httpContext.changePostValue( "ZT_"+"Z1170OblExcConCOdigo_"+sGXsfl_113_idx, GXutil.rtrim( Z1170OblExcConCOdigo)) ;
         httpContext.changePostValue( "ZT_"+"Z1183OblExcTipo_"+sGXsfl_113_idx, GXutil.rtrim( Z1183OblExcTipo)) ;
         httpContext.changePostValue( "nRcdDeleted_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_138_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_138 != 0 )
         {
            httpContext.changePostValue( "OBLEXCCONCODIGO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtOblExcConCOdigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "OBLEXCTIPO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbOblExcTipo.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll3D138( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_138 = (short)(0) ;
      nIsMod_138 = (short)(0) ;
      nRcdDeleted_138 = (short)(0) ;
   }

   public void processLevel3D134( )
   {
      /* Save parent mode. */
      sMode134 = Gx_mode ;
      processNestedLevel3D138( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode134 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel3D134( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "obligacion");
         if ( AnyError == 0 )
         {
            confirmValues3D0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "obligacion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3D134( )
   {
      /* Scan By routine */
      /* Using cursor T003D29 */
      pr_default.execute(27);
      RcdFound134 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A3CliCod = T003D29_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003D29_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003D29_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = T003D29_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3D134( )
   {
      /* Scan next routine */
      pr_default.readNext(27);
      RcdFound134 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A3CliCod = T003D29_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003D29_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003D29_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = T003D29_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
   }

   public void scanEnd3D134( )
   {
      pr_default.close(27);
   }

   public void afterConfirm3D134( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3D134( )
   {
      /* Before Insert Rules */
      GXt_int4 = A1172OblSecuencial ;
      GXv_int5[0] = GXt_int4 ;
      new web.getnextobl(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int5) ;
      obligacion_impl.this.GXt_int4 = GXv_int5[0] ;
      A1172OblSecuencial = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
   }

   public void beforeUpdate3D134( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3D134( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3D134( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3D134( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3D134( )
   {
      dynLegNumero.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynLegNumero.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegNumero.getEnabled(), 5, 0), true);
      dynTipoOblSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoOblSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoOblSec.getEnabled(), 5, 0), true);
      cmbOblEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblEstado.getEnabled(), 5, 0), true);
      edtOblObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblObs_Enabled), 5, 0), true);
      edtOblTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Enabled), 5, 0), true);
      dynOblLiqNro.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblLiqNro.getEnabled(), 5, 0), true);
      dynOblConCodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynOblConCodigo.getEnabled(), 5, 0), true);
      edtOblCanCuo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Enabled), 5, 0), true);
      edtOblImpFij_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblImpFij_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblImpFij_Enabled), 5, 0), true);
      edtOblPorc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblPorc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblPorc_Enabled), 5, 0), true);
      chkOblNoRemu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "Enabled", GXutil.ltrimstr( chkOblNoRemu.getEnabled(), 5, 0), true);
      chkOblDescu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "Enabled", GXutil.ltrimstr( chkOblDescu.getEnabled(), 5, 0), true);
      cmbOblConcepto.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblConcepto.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblConcepto.getEnabled(), 5, 0), true);
      cmbOblTipoMov.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtOblSecuencial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Enabled), 5, 0), true);
   }

   public void zm3D138( int GX_JID )
   {
      if ( ( GX_JID == 64 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1183OblExcTipo = T003D3_A1183OblExcTipo[0] ;
         }
         else
         {
            Z1183OblExcTipo = A1183OblExcTipo ;
         }
      }
      if ( GX_JID == -64 )
      {
         Z1183OblExcTipo = A1183OblExcTipo ;
         Z3CliCod = A3CliCod ;
         Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
      }
   }

   public void standaloneNotModal3D138( )
   {
   }

   public void standaloneModal3D138( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtOblExcConCOdigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblExcConCOdigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblExcConCOdigo_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      }
      else
      {
         edtOblExcConCOdigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOblExcConCOdigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblExcConCOdigo_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      }
   }

   public void load3D138( )
   {
      /* Using cursor T003D30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1183OblExcTipo = T003D30_A1183OblExcTipo[0] ;
         zm3D138( -64) ;
      }
      pr_default.close(28);
      onLoadActions3D138( ) ;
   }

   public void onLoadActions3D138( )
   {
   }

   public void checkExtendedTable3D138( )
   {
      nIsDirty_138 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal3D138( ) ;
      /* Using cursor T003D4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "OBLEXCCONCODIGO_" + sGXsfl_113_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Excp Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtOblExcConCOdigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors3D138( )
   {
      pr_default.close(2);
   }

   public void enableDisable3D138( )
   {
   }

   public void gxload_65( int A3CliCod ,
                          String A1170OblExcConCOdigo )
   {
      /* Using cursor T003D31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(29) == 101) )
      {
         GXCCtl = "OBLEXCCONCODIGO_" + sGXsfl_113_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Excp Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtOblExcConCOdigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(29) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(29);
   }

   public void getKey3D138( )
   {
      /* Using cursor T003D32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound138 = (short)(1) ;
      }
      else
      {
         RcdFound138 = (short)(0) ;
      }
      pr_default.close(30);
   }

   public void getByPrimaryKey3D138( )
   {
      /* Using cursor T003D3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3D138( 64) ;
         RcdFound138 = (short)(1) ;
         initializeNonKey3D138( ) ;
         A1183OblExcTipo = T003D3_A1183OblExcTipo[0] ;
         A1170OblExcConCOdigo = T003D3_A1170OblExcConCOdigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
         Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
         sMode138 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3D138( ) ;
         Gx_mode = sMode138 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound138 = (short)(0) ;
         initializeNonKey3D138( ) ;
         sMode138 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal3D138( ) ;
         Gx_mode = sMode138 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes3D138( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency3D138( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003D2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObligacionExcepciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1183OblExcTipo, T003D2_A1183OblExcTipo[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1183OblExcTipo, T003D2_A1183OblExcTipo[0]) != 0 )
            {
               GXutil.writeLogln("obligacion:[seudo value changed for attri]"+"OblExcTipo");
               GXutil.writeLogRaw("Old: ",Z1183OblExcTipo);
               GXutil.writeLogRaw("Current: ",T003D2_A1183OblExcTipo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ObligacionExcepciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3D138( )
   {
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D138( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3D138( 0) ;
         checkOptimisticConcurrency3D138( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D138( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3D138( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003D33 */
                  pr_default.execute(31, new Object[] {A1183OblExcTipo, Integer.valueOf(A3CliCod), A1170OblExcConCOdigo, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
                  if ( (pr_default.getStatus(31) == 1) )
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
            load3D138( ) ;
         }
         endLevel3D138( ) ;
      }
      closeExtendedTableCursors3D138( ) ;
   }

   public void update3D138( )
   {
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D138( ) ;
      }
      if ( ( nIsMod_138 != 0 ) || ( nIsDirty_138 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency3D138( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm3D138( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate3D138( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T003D34 */
                     pr_default.execute(32, new Object[] {A1183OblExcTipo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
                     if ( (pr_default.getStatus(32) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObligacionExcepciones"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey3D138( ) ;
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
            endLevel3D138( ) ;
         }
      }
      closeExtendedTableCursors3D138( ) ;
   }

   public void deferredUpdate3D138( )
   {
   }

   public void delete3D138( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D138( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3D138( ) ;
         afterConfirm3D138( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3D138( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003D35 */
               pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode138 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3D138( ) ;
      Gx_mode = sMode138 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3D138( )
   {
      standaloneModal3D138( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel3D138( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3D138( )
   {
      /* Scan By routine */
      /* Using cursor T003D36 */
      pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      RcdFound138 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1170OblExcConCOdigo = T003D36_A1170OblExcConCOdigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3D138( )
   {
      /* Scan next routine */
      pr_default.readNext(34);
      RcdFound138 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1170OblExcConCOdigo = T003D36_A1170OblExcConCOdigo[0] ;
      }
   }

   public void scanEnd3D138( )
   {
      pr_default.close(34);
   }

   public void afterConfirm3D138( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3D138( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3D138( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3D138( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3D138( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3D138( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3D138( )
   {
      edtOblExcConCOdigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblExcConCOdigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblExcConCOdigo_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      cmbOblExcTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblExcTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblExcTipo.getEnabled(), 5, 0), !bGXsfl_113_Refreshing);
   }

   public void send_integrity_lvl_hashes3D138( )
   {
   }

   public void send_integrity_lvl_hashes3D134( )
   {
   }

   public void subsflControlProps_113138( )
   {
      edtOblExcConCOdigo_Internalname = "OBLEXCCONCODIGO_"+sGXsfl_113_idx ;
      cmbOblExcTipo.setInternalname( "OBLEXCTIPO_"+sGXsfl_113_idx );
   }

   public void subsflControlProps_fel_113138( )
   {
      edtOblExcConCOdigo_Internalname = "OBLEXCCONCODIGO_"+sGXsfl_113_fel_idx ;
      cmbOblExcTipo.setInternalname( "OBLEXCTIPO_"+sGXsfl_113_fel_idx );
   }

   public void addRow3D138( )
   {
      nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_113138( ) ;
      sendRow3D138( ) ;
   }

   public void sendRow3D138( )
   {
      Gridlevel_excepcionesRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_excepciones_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_excepciones_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_excepciones_Class, "") != 0 )
         {
            subGridlevel_excepciones_Linesclass = subGridlevel_excepciones_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_excepciones_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_excepciones_Backstyle = (byte)(0) ;
         subGridlevel_excepciones_Backcolor = subGridlevel_excepciones_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_excepciones_Class, "") != 0 )
         {
            subGridlevel_excepciones_Linesclass = subGridlevel_excepciones_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_excepciones_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_excepciones_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_excepciones_Class, "") != 0 )
         {
            subGridlevel_excepciones_Linesclass = subGridlevel_excepciones_Class+"Odd" ;
         }
         subGridlevel_excepciones_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_excepciones_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_excepciones_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_113_idx) % (2))) == 0 )
         {
            subGridlevel_excepciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_excepciones_Class, "") != 0 )
            {
               subGridlevel_excepciones_Linesclass = subGridlevel_excepciones_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_excepciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_excepciones_Class, "") != 0 )
            {
               subGridlevel_excepciones_Linesclass = subGridlevel_excepciones_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_138_" + sGXsfl_113_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 114,'',false,'" + sGXsfl_113_idx + "',113)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_excepcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblExcConCOdigo_Internalname,GXutil.rtrim( A1170OblExcConCOdigo),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,114);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOblExcConCOdigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtOblExcConCOdigo_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(113),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_138_" + sGXsfl_113_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 115,'',false,'" + sGXsfl_113_idx + "',113)\"" ;
      if ( ( cmbOblExcTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "OBLEXCTIPO_" + sGXsfl_113_idx ;
         cmbOblExcTipo.setName( GXCCtl );
         cmbOblExcTipo.setWebtags( "" );
         cmbOblExcTipo.addItem("E", httpContext.getMessage( "Excluir", ""), (short)(0));
         cmbOblExcTipo.addItem("I", httpContext.getMessage( "Incluir", ""), (short)(0));
         if ( cmbOblExcTipo.getItemCount() > 0 )
         {
            A1183OblExcTipo = cmbOblExcTipo.getValidValue(A1183OblExcTipo) ;
         }
      }
      /* ComboBox */
      Gridlevel_excepcionesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbOblExcTipo,cmbOblExcTipo.getInternalname(),GXutil.rtrim( A1183OblExcTipo),Integer.valueOf(1),cmbOblExcTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbOblExcTipo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,115);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbOblExcTipo.setValue( GXutil.rtrim( A1183OblExcTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblExcTipo.getInternalname(), "Values", cmbOblExcTipo.ToJavascriptSource(), !bGXsfl_113_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_excepcionesRow);
      send_integrity_lvl_hashes3D138( ) ;
      GXCCtl = "Z1170OblExcConCOdigo_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1170OblExcConCOdigo));
      GXCCtl = "Z1183OblExcTipo_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1183OblExcTipo));
      GXCCtl = "nRcdDeleted_138_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_138_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_138_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_138, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICOD_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vTIPOOBLSEC_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV50TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vLEGNUMERO_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vOBLSECUENCIAL_" + sGXsfl_113_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV10OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "OBLEXCCONCODIGO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtOblExcConCOdigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "OBLEXCTIPO_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbOblExcTipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_excepcionesContainer.AddRow(Gridlevel_excepcionesRow);
   }

   public void readRow3D138( )
   {
      nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_113138( ) ;
      edtOblExcConCOdigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "OBLEXCCONCODIGO_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbOblExcTipo.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "OBLEXCTIPO_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      A1170OblExcConCOdigo = httpContext.cgiGet( edtOblExcConCOdigo_Internalname) ;
      cmbOblExcTipo.setName( cmbOblExcTipo.getInternalname() );
      cmbOblExcTipo.setValue( httpContext.cgiGet( cmbOblExcTipo.getInternalname()) );
      A1183OblExcTipo = httpContext.cgiGet( cmbOblExcTipo.getInternalname()) ;
      GXCCtl = "Z1170OblExcConCOdigo_" + sGXsfl_113_idx ;
      Z1170OblExcConCOdigo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1183OblExcTipo_" + sGXsfl_113_idx ;
      Z1183OblExcTipo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_138_" + sGXsfl_113_idx ;
      nRcdDeleted_138 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_138_" + sGXsfl_113_idx ;
      nRcdExists_138 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_138_" + sGXsfl_113_idx ;
      nIsMod_138 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtOblExcConCOdigo_Enabled = edtOblExcConCOdigo_Enabled ;
   }

   public void confirmValues3D0( )
   {
      nGXsfl_113_idx = 0 ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_113138( ) ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
         sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_113138( ) ;
         httpContext.changePostValue( "Z1170OblExcConCOdigo_"+sGXsfl_113_idx, httpContext.cgiGet( "ZT_"+"Z1170OblExcConCOdigo_"+sGXsfl_113_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1170OblExcConCOdigo_"+sGXsfl_113_idx) ;
         httpContext.changePostValue( "Z1183OblExcTipo_"+sGXsfl_113_idx, httpContext.cgiGet( "ZT_"+"Z1183OblExcTipo_"+sGXsfl_113_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1183OblExcTipo_"+sGXsfl_113_idx) ;
      }
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10OblSecuencial,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","OblSecuencial"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Obligacion");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("OblOriPer", localUtil.format( DecimalUtil.doubleToDec(A1175OblOriPer), "Z9"));
      forbiddenHiddens.add("OblAntiRelaLiq", GXutil.booltostr( A1196OblAntiRelaLiq));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("obligacion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1172OblSecuencial", GXutil.ltrim( localUtil.ntoc( Z1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2345OblTipoMov", GXutil.rtrim( Z2345OblTipoMov));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1173OblEstado", GXutil.ltrim( localUtil.ntoc( Z1173OblEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1175OblOriPer", GXutil.ltrim( localUtil.ntoc( Z1175OblOriPer, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1176OblTotal", GXutil.ltrim( localUtil.ntoc( Z1176OblTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1177OblCanCuo", GXutil.ltrim( localUtil.ntoc( Z1177OblCanCuo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1178OblImpFij", GXutil.ltrim( localUtil.ntoc( Z1178OblImpFij, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1179OblPorc", GXutil.ltrim( localUtil.ntoc( Z1179OblPorc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1181OblNoRemu", Z1181OblNoRemu);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1182OblDescu", Z1182OblDescu);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1196OblAntiRelaLiq", Z1196OblAntiRelaLiq);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2343OblConcepto", GXutil.rtrim( Z2343OblConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1195OblLiqNro", GXutil.ltrim( localUtil.ntoc( Z1195OblLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1169OblConCodigo", GXutil.rtrim( Z1169OblConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1163TipoOblSec", GXutil.ltrim( localUtil.ntoc( Z1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_113", GXutil.ltrim( localUtil.ntoc( nGXsfl_113_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1163TipoOblSec", GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "N1195OblLiqNro", GXutil.ltrim( localUtil.ntoc( A1195OblLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N2343OblConcepto", GXutil.rtrim( A2343OblConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "N2345OblTipoMov", GXutil.rtrim( A2345OblTipoMov));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vOBLEXCCONCODIGO_DATA", AV34OblExcConCOdigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vOBLEXCCONCODIGO_DATA", AV34OblExcConCOdigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOOBLSEC", GXutil.ltrim( localUtil.ntoc( AV50TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOBLSECUENCIAL", GXutil.ltrim( localUtil.ntoc( AV10OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOBLSECUENCIAL", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10OblSecuencial), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOOBLSEC", GXutil.ltrim( localUtil.ntoc( AV16Insert_TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_OBLCONCODIGO", GXutil.rtrim( AV17Insert_OblConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_OBLLIQNRO", GXutil.ltrim( localUtil.ntoc( AV35Insert_OblLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_OBLCONCEPTO", GXutil.rtrim( AV46Insert_OblConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "TIPOOBLTOTTIPO", GXutil.ltrim( localUtil.ntoc( A1168TipoOblTotTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vANTICIPOTIPOOBLSEC", GXutil.ltrim( localUtil.ntoc( AV42anticipoTipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "TIPOOBLSOLODESCU", A2346TipoOblSoloDescu);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV36PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vANTICIPOSUBTIPOCONCOD1", GXutil.rtrim( AV43anticipoSubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "vDESDEDTIPOCONCOD", GXutil.rtrim( AV44desdeDTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vHASTADTIPOCONCOD", GXutil.rtrim( AV45hastaDTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "OBLORIPER", GXutil.ltrim( localUtil.ntoc( A1175OblOriPer, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "OBLANTIRELALIQ", A1196OblAntiRelaLiq);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "TIPOOBLDESCRIP", A1165TipoOblDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "TIPOOBLCODIGO", GXutil.rtrim( A1164TipoOblCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "EMBARGASEC", GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV52Pgmname));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Objectcall", GXutil.rtrim( Dvpanel_exc_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Enabled", GXutil.booltostr( Dvpanel_exc_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Width", GXutil.rtrim( Dvpanel_exc_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Autowidth", GXutil.booltostr( Dvpanel_exc_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Autoheight", GXutil.booltostr( Dvpanel_exc_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Cls", GXutil.rtrim( Dvpanel_exc_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Title", GXutil.rtrim( Dvpanel_exc_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Collapsible", GXutil.booltostr( Dvpanel_exc_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Collapsed", GXutil.booltostr( Dvpanel_exc_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Showcollapseicon", GXutil.booltostr( Dvpanel_exc_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Iconposition", GXutil.rtrim( Dvpanel_exc_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXC_Autoscroll", GXutil.booltostr( Dvpanel_exc_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Objectcall", GXutil.rtrim( Combo_oblexcconcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Cls", GXutil.rtrim( Combo_oblexcconcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Enabled", GXutil.booltostr( Combo_oblexcconcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Titlecontrolidtoreplace", GXutil.rtrim( Combo_oblexcconcodigo_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Isgriditem", GXutil.booltostr( Combo_oblexcconcodigo_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OBLEXCCONCODIGO_Emptyitem", GXutil.booltostr( Combo_oblexcconcodigo_Emptyitem));
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
      return formatLink("web.obligacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10OblSecuencial,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","OblSecuencial"})  ;
   }

   public String getPgmname( )
   {
      return "Obligacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Obligacion", "") ;
   }

   public void initializeNonKey3D134( )
   {
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A1163TipoOblSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      A1169OblConCodigo = "" ;
      n1169OblConCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", A1169OblConCodigo);
      n1169OblConCodigo = ((GXutil.strcmp("", A1169OblConCodigo)==0) ? true : false) ;
      A1195OblLiqNro = 0 ;
      n1195OblLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1195OblLiqNro), 8, 0));
      n1195OblLiqNro = ((0==A1195OblLiqNro) ? true : false) ;
      A2343OblConcepto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A1165TipoOblDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
      A1164TipoOblCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
      A1174OblObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1174OblObs", A1174OblObs);
      A1175OblOriPer = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1175OblOriPer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1175OblOriPer), 2, 0));
      A1168TipoOblTotTipo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      A1176OblTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1176OblTotal", GXutil.ltrimstr( A1176OblTotal, 14, 2));
      A1177OblCanCuo = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1177OblCanCuo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1177OblCanCuo), 4, 0));
      A1178OblImpFij = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1178OblImpFij", GXutil.ltrimstr( A1178OblImpFij, 14, 2));
      A1179OblPorc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1179OblPorc", GXutil.ltrimstr( A1179OblPorc, 6, 4));
      A1181OblNoRemu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
      A1182OblDescu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
      A1196OblAntiRelaLiq = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1196OblAntiRelaLiq", A1196OblAntiRelaLiq);
      A2346TipoOblSoloDescu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A2345OblTipoMov = "Descuento" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
      A1173OblEstado = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
      Z2345OblTipoMov = "" ;
      Z1173OblEstado = (byte)(0) ;
      Z1175OblOriPer = (byte)(0) ;
      Z1176OblTotal = DecimalUtil.ZERO ;
      Z1177OblCanCuo = (short)(0) ;
      Z1178OblImpFij = DecimalUtil.ZERO ;
      Z1179OblPorc = DecimalUtil.ZERO ;
      Z1181OblNoRemu = false ;
      Z1182OblDescu = false ;
      Z1196OblAntiRelaLiq = false ;
      Z2343OblConcepto = "" ;
      Z1195OblLiqNro = 0 ;
      Z1169OblConCodigo = "" ;
      Z1163TipoOblSec = (short)(0) ;
   }

   public void initAll3D134( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A1172OblSecuencial = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      initializeNonKey3D134( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1173OblEstado = i1173OblEstado ;
      httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
   }

   public void initializeNonKey3D138( )
   {
      A1183OblExcTipo = "" ;
      Z1183OblExcTipo = "" ;
   }

   public void initAll3D138( )
   {
      A1170OblExcConCOdigo = "" ;
      initializeNonKey3D138( ) ;
   }

   public void standaloneModalInsert3D138( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713555512", true, true);
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
      httpContext.AddJavascriptSource("obligacion.js", "?20251713555513", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties138( )
   {
      edtOblExcConCOdigo_Enabled = defedtOblExcConCOdigo_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblExcConCOdigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblExcConCOdigo_Enabled), 5, 0), !bGXsfl_113_Refreshing);
   }

   public void startgridcontrol113( )
   {
      Gridlevel_excepcionesContainer.AddObjectProperty("GridName", "Gridlevel_excepciones");
      Gridlevel_excepcionesContainer.AddObjectProperty("Header", subGridlevel_excepciones_Header);
      Gridlevel_excepcionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_excepcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_excepcionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_excepcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_excepcionesColumn.AddObjectProperty("Value", GXutil.rtrim( A1170OblExcConCOdigo));
      Gridlevel_excepcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtOblExcConCOdigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddColumnProperties(Gridlevel_excepcionesColumn);
      Gridlevel_excepcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_excepcionesColumn.AddObjectProperty("Value", GXutil.rtrim( A1183OblExcTipo));
      Gridlevel_excepcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbOblExcTipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddColumnProperties(Gridlevel_excepcionesColumn);
      Gridlevel_excepcionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_excepcionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_excepciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      dynLegNumero.setInternalname( "LEGNUMERO" );
      dynTipoOblSec.setInternalname( "TIPOOBLSEC" );
      cmbOblEstado.setInternalname( "OBLESTADO" );
      edtOblObs_Internalname = "OBLOBS" ;
      edtOblTotal_Internalname = "OBLTOTAL" ;
      divObltotal_cell_Internalname = "OBLTOTAL_CELL" ;
      dynOblLiqNro.setInternalname( "OBLLIQNRO" );
      divOblliqnro_cell_Internalname = "OBLLIQNRO_CELL" ;
      dynOblConCodigo.setInternalname( "OBLCONCODIGO" );
      divOblconcodigo_cell_Internalname = "OBLCONCODIGO_CELL" ;
      edtOblCanCuo_Internalname = "OBLCANCUO" ;
      divOblcancuo_cell_Internalname = "OBLCANCUO_CELL" ;
      edtOblImpFij_Internalname = "OBLIMPFIJ" ;
      edtOblPorc_Internalname = "OBLPORC" ;
      chkOblNoRemu.setInternalname( "OBLNOREMU" );
      divOblnoremu_cell_Internalname = "OBLNOREMU_CELL" ;
      chkOblDescu.setInternalname( "OBLDESCU" );
      divObldescu_cell_Internalname = "OBLDESCU_CELL" ;
      cmbOblConcepto.setInternalname( "OBLCONCEPTO" );
      cmbOblTipoMov.setInternalname( "OBLTIPOMOV" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      edtOblExcConCOdigo_Internalname = "OBLEXCCONCODIGO" ;
      cmbOblExcTipo.setInternalname( "OBLEXCTIPO" );
      divTableleaflevel_excepciones_Internalname = "TABLELEAFLEVEL_EXCEPCIONES" ;
      divExc_Internalname = "EXC" ;
      Dvpanel_exc_Internalname = "DVPANEL_EXC" ;
      tblTblexc_Internalname = "TBLEXC" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_oblexcconcodigo_Internalname = "COMBO_OBLEXCCONCODIGO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtOblSecuencial_Internalname = "OBLSECUENCIAL" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_excepciones_Internalname = "GRIDLEVEL_EXCEPCIONES" ;
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
      subGridlevel_excepciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_excepciones_Allowselection = (byte)(0) ;
      subGridlevel_excepciones_Header = "" ;
      Combo_oblexcconcodigo_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Obligacion", "") );
      cmbOblExcTipo.setJsonclick( "" );
      edtOblExcConCOdigo_Jsonclick = "" ;
      subGridlevel_excepciones_Class = "WorkWith" ;
      subGridlevel_excepciones_Backcolorstyle = (byte)(0) ;
      Combo_oblexcconcodigo_Titlecontrolidtoreplace = "" ;
      edtOblSecuencial_Jsonclick = "" ;
      edtOblSecuencial_Enabled = 1 ;
      edtOblSecuencial_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_oblexcconcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_oblexcconcodigo_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_oblexcconcodigo_Cls = "ExtendedCombo" ;
      cmbOblExcTipo.setEnabled( 1 );
      edtOblExcConCOdigo_Enabled = 1 ;
      Dvpanel_exc_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_exc_Iconposition = "Right" ;
      Dvpanel_exc_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_exc_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_exc_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_exc_Title = httpContext.getMessage( "Conceptos a excluir en base de cálculo", "") ;
      Dvpanel_exc_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_exc_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_exc_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_exc_Width = "100%" ;
      tblTblexc_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbOblTipoMov.setJsonclick( "" );
      cmbOblTipoMov.setEnabled( 1 );
      cmbOblConcepto.setJsonclick( "" );
      cmbOblConcepto.setEnabled( 1 );
      chkOblDescu.setEnabled( 1 );
      chkOblDescu.setVisible( 1 );
      divObldescu_cell_Class = "col-xs-12" ;
      chkOblNoRemu.setEnabled( 1 );
      chkOblNoRemu.setVisible( 1 );
      divOblnoremu_cell_Class = "col-xs-12" ;
      edtOblPorc_Jsonclick = "" ;
      edtOblPorc_Enabled = 1 ;
      edtOblImpFij_Jsonclick = "" ;
      edtOblImpFij_Enabled = 1 ;
      edtOblCanCuo_Jsonclick = "" ;
      edtOblCanCuo_Enabled = 1 ;
      edtOblCanCuo_Visible = 1 ;
      divOblcancuo_cell_Class = "col-xs-12" ;
      dynOblConCodigo.setJsonclick( "" );
      dynOblConCodigo.setEnabled( 1 );
      dynOblConCodigo.setVisible( 1 );
      divOblconcodigo_cell_Class = "col-xs-12" ;
      dynOblLiqNro.setJsonclick( "" );
      dynOblLiqNro.setEnabled( 1 );
      dynOblLiqNro.setVisible( 1 );
      divOblliqnro_cell_Class = "col-xs-12" ;
      edtOblTotal_Jsonclick = "" ;
      edtOblTotal_Enabled = 1 ;
      edtOblTotal_Visible = 1 ;
      divObltotal_cell_Class = "col-xs-12" ;
      edtOblObs_Enabled = 1 ;
      cmbOblEstado.setJsonclick( "" );
      cmbOblEstado.setEnabled( 1 );
      dynTipoOblSec.setJsonclick( "" );
      dynTipoOblSec.setEnabled( 1 );
      dynLegNumero.setJsonclick( "" );
      dynLegNumero.setEnabled( 1 );
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
      gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      /* End function dynload_actions */
   }

   public void gxdlalegnumero3D134( int AV7CliCod ,
                                    short AV8EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlalegnumero_data3D134( AV7CliCod, AV8EmpCod) ;
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

   public void gxalegnumero_html3D134( int AV7CliCod ,
                                       short AV8EmpCod )
   {
      int gxdynajaxvalue;
      gxdlalegnumero_data3D134( AV7CliCod, AV8EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynLegNumero.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynLegNumero.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlalegnumero_data3D134( int AV7CliCod ,
                                            short AV8EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003D37 */
      pr_default.execute(35, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(35) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003D37_A6LegNumero[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003D37_A250LegIdNomApe[0]);
         pr_default.readNext(35);
      }
      pr_default.close(35);
   }

   public void gxdlatipooblsec3D134( short AV36PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipooblsec_data3D134( AV36PaiCod) ;
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

   public void gxatipooblsec_html3D134( short AV36PaiCod )
   {
      short gxdynajaxvalue;
      gxdlatipooblsec_data3D134( AV36PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipoOblSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynTipoOblSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatipooblsec_data3D134( short AV36PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003D38 */
      pr_default.execute(36, new Object[] {Short.valueOf(AV36PaiCod)});
      while ( (pr_default.getStatus(36) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003D38_A1163TipoOblSec[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003D38_A1165TipoOblDescrip[0]);
         pr_default.readNext(36);
      }
      pr_default.close(36);
   }

   public void gxdlaoblliqnro3D134( int AV7CliCod ,
                                    short AV8EmpCod ,
                                    int A6LegNumero )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaoblliqnro_data3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
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

   public void gxaoblliqnro_html3D134( int AV7CliCod ,
                                       short AV8EmpCod ,
                                       int A6LegNumero )
   {
      int gxdynajaxvalue;
      gxdlaoblliqnro_data3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOblLiqNro.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynOblLiqNro.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaoblliqnro_data3D134( int AV7CliCod ,
                                            short AV8EmpCod ,
                                            int A6LegNumero )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003D39 */
      pr_default.execute(37, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(A6LegNumero)});
      while ( (pr_default.getStatus(37) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003D39_A31LiqNro[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003D39_A874LiqNombre[0]);
         pr_default.readNext(37);
      }
      pr_default.close(37);
   }

   public void gxdlaoblconcodigo3D134( int A3CliCod ,
                                       short A1EmpCod ,
                                       int A6LegNumero ,
                                       String AV43anticipoSubTipoConCod1 ,
                                       String AV44desdeDTipoConCod ,
                                       String AV45hastaDTipoConCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaoblconcodigo_data3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
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

   public void gxaoblconcodigo_html3D134( int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          String AV43anticipoSubTipoConCod1 ,
                                          String AV44desdeDTipoConCod ,
                                          String AV45hastaDTipoConCod )
   {
      String gxdynajaxvalue;
      gxdlaoblconcodigo_data3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOblConCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynOblConCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaoblconcodigo_data3D134( int A3CliCod ,
                                               short A1EmpCod ,
                                               int A6LegNumero ,
                                               String AV43anticipoSubTipoConCod1 ,
                                               String AV44desdeDTipoConCod ,
                                               String AV45hastaDTipoConCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T003D40 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), AV44desdeDTipoConCod, AV45hastaDTipoConCod, AV43anticipoSubTipoConCod1});
      while ( (pr_default.getStatus(38) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T003D40_A394DConCodigo[0]));
         gxdynajaxctrldescr.add(T003D40_A393DConDescrip[0]);
         pr_default.readNext(38);
      }
      pr_default.close(38);
   }

   public void gx5asaclicod3D134( int AV7CliCod )
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
            GXt_int11 = A3CliCod ;
            GXv_int12[0] = GXt_int11 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int12) ;
            obligacion_impl.this.GXt_int11 = GXv_int12[0] ;
            A3CliCod = GXt_int11 ;
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

   public void gx11asaoblsecuencial3D134( short AV10OblSecuencial )
   {
      if ( ! (0==AV10OblSecuencial) )
      {
         A1172OblSecuencial = AV10OblSecuencial ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx12asaoblsecuencial3D134( int AV7CliCod ,
                                          short AV8EmpCod ,
                                          int A6LegNumero )
   {
      GXt_int4 = A1172OblSecuencial ;
      GXv_int5[0] = GXt_int4 ;
      new web.getnextobl(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int5) ;
      obligacion_impl.this.GXt_int4 = GXv_int5[0] ;
      A1172OblSecuencial = GXt_int4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_excepciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_113138( ) ;
      while ( nGXsfl_113_idx <= nRC_GXsfl_113 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal3D138( ) ;
         standaloneModal3D138( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow3D138( ) ;
         nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
         sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_113138( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_excepcionesContainer)) ;
      /* End function gxnrGridlevel_excepciones_newrow */
   }

   public void init_web_controls( )
   {
      dynLegNumero.setName( "LEGNUMERO" );
      dynLegNumero.setWebtags( "" );
      dynTipoOblSec.setName( "TIPOOBLSEC" );
      dynTipoOblSec.setWebtags( "" );
      cmbOblEstado.setName( "OBLESTADO" );
      cmbOblEstado.setWebtags( "" );
      cmbOblEstado.addItem("0", httpContext.getMessage( "Inactivo", ""), (short)(0));
      cmbOblEstado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
      if ( cmbOblEstado.getItemCount() > 0 )
      {
         if ( isIns( ) && (0==A1173OblEstado) )
         {
            A1173OblEstado = (byte)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1173OblEstado", GXutil.str( A1173OblEstado, 1, 0));
         }
      }
      dynOblLiqNro.setName( "OBLLIQNRO" );
      dynOblLiqNro.setWebtags( "" );
      dynOblConCodigo.setName( "OBLCONCODIGO" );
      dynOblConCodigo.setWebtags( "" );
      chkOblNoRemu.setName( "OBLNOREMU" );
      chkOblNoRemu.setWebtags( "" );
      chkOblNoRemu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOblNoRemu.getInternalname(), "TitleCaption", chkOblNoRemu.getCaption(), true);
      chkOblNoRemu.setCheckedValue( "false" );
      A1181OblNoRemu = GXutil.strtobool( GXutil.booltostr( A1181OblNoRemu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1181OblNoRemu", A1181OblNoRemu);
      chkOblDescu.setName( "OBLDESCU" );
      chkOblDescu.setWebtags( "" );
      chkOblDescu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOblDescu.getInternalname(), "TitleCaption", chkOblDescu.getCaption(), true);
      chkOblDescu.setCheckedValue( "false" );
      A1182OblDescu = GXutil.strtobool( GXutil.booltostr( A1182OblDescu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1182OblDescu", A1182OblDescu);
      cmbOblConcepto.setName( "OBLCONCEPTO" );
      cmbOblConcepto.setWebtags( "" );
      if ( cmbOblConcepto.getItemCount() > 0 )
      {
         A2343OblConcepto = cmbOblConcepto.getValidValue(A2343OblConcepto) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2343OblConcepto", A2343OblConcepto);
      }
      cmbOblTipoMov.setName( "OBLTIPOMOV" );
      cmbOblTipoMov.setWebtags( "" );
      cmbOblTipoMov.addItem("Descuento", httpContext.getMessage( "Descuento", ""), (short)(0));
      cmbOblTipoMov.addItem("Acreditacion", httpContext.getMessage( "Acreditación", ""), (short)(0));
      if ( cmbOblTipoMov.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A2345OblTipoMov)==0) )
         {
            A2345OblTipoMov = "Descuento" ;
            httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", A2345OblTipoMov);
         }
      }
      GXCCtl = "OBLEXCTIPO_" + sGXsfl_113_idx ;
      cmbOblExcTipo.setName( GXCCtl );
      cmbOblExcTipo.setWebtags( "" );
      cmbOblExcTipo.addItem("E", httpContext.getMessage( "Excluir", ""), (short)(0));
      cmbOblExcTipo.addItem("I", httpContext.getMessage( "Incluir", ""), (short)(0));
      if ( cmbOblExcTipo.getItemCount() > 0 )
      {
         A1183OblExcTipo = cmbOblExcTipo.getValidValue(A1183OblExcTipo) ;
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

   public void valid_Legnumero( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegNumero.getInternalname() ;
      }
      gxaoblliqnro_html3D134( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      if ( dynOblLiqNro.getItemCount() > 0 )
      {
         A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValidValue(GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0))))) ;
         n1195OblLiqNro = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1195OblLiqNro", GXutil.ltrim( localUtil.ntoc( A1195OblLiqNro, (byte)(8), (byte)(0), ".", "")));
      dynOblLiqNro.setValue( GXutil.trim( GXutil.str( A1195OblLiqNro, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Values", dynOblLiqNro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public void valid_Clicod( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public void valid_Empcod( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      n93LegId = false ;
      /* Using cursor T003D41 */
      pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(39) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T003D41_A250LegIdNomApe[0] ;
      A251LegNombre = T003D41_A251LegNombre[0] ;
      A251LegNombre = T003D41_A251LegNombre[0] ;
      A230LegApellido = T003D41_A230LegApellido[0] ;
      A230LegApellido = T003D41_A230LegApellido[0] ;
      A93LegId = T003D41_A93LegId[0] ;
      n93LegId = T003D41_n93LegId[0] ;
      A93LegId = T003D41_A93LegId[0] ;
      n93LegId = T003D41_n93LegId[0] ;
      pr_default.close(39);
      gxaoblconcodigo_html3D134( A3CliCod, A1EmpCod, A6LegNumero, AV43anticipoSubTipoConCod1, AV44desdeDTipoConCod, AV45hastaDTipoConCod) ;
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      if ( dynOblConCodigo.getItemCount() > 0 )
      {
         A1169OblConCodigo = dynOblConCodigo.getValidValue(A1169OblConCodigo) ;
         n1169OblConCodigo = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
      httpContext.ajax_rsp_assign_attri("", false, "A1169OblConCodigo", GXutil.rtrim( A1169OblConCodigo));
      dynOblConCodigo.setValue( GXutil.rtrim( A1169OblConCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Values", dynOblConCodigo.ToJavascriptSource(), true);
   }

   public void valid_Tipooblsec( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      n1161EmbargaSec = false ;
      A2345OblTipoMov = cmbOblTipoMov.getValue() ;
      cmbOblTipoMov.setValue( A2345OblTipoMov );
      /* Using cursor T003D42 */
      pr_default.execute(40, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(40) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo_obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
      }
      A1165TipoOblDescrip = T003D42_A1165TipoOblDescrip[0] ;
      A1164TipoOblCodigo = T003D42_A1164TipoOblCodigo[0] ;
      A1168TipoOblTotTipo = T003D42_A1168TipoOblTotTipo[0] ;
      A2346TipoOblSoloDescu = T003D42_A2346TipoOblSoloDescu[0] ;
      A1161EmbargaSec = T003D42_A1161EmbargaSec[0] ;
      n1161EmbargaSec = T003D42_n1161EmbargaSec[0] ;
      pr_default.close(40);
      edtOblTotal_Visible = ((A1168TipoOblTotTipo==1) ? 1 : 0) ;
      if ( ! ( ( A1168TipoOblTotTipo == 1 ) ) )
      {
         divObltotal_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( A1168TipoOblTotTipo == 1 )
         {
            divObltotal_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
      }
      dynOblLiqNro.setVisible( ((A1168TipoOblTotTipo==2) ? 1 : 0) );
      edtOblCanCuo_Visible = ((A1168TipoOblTotTipo!=0) ? 1 : 0) ;
      if ( ! ( ( A1168TipoOblTotTipo != 0 ) ) )
      {
         divOblcancuo_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( A1168TipoOblTotTipo != 0 )
         {
            divOblcancuo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
      }
      if ( isIns( )  && (GXutil.strcmp("", A2345OblTipoMov)==0) && ( Gx_BScreen == 0 ) )
      {
         A2345OblTipoMov = "Descuento" ;
         cmbOblTipoMov.setValue( A2345OblTipoMov );
      }
      else
      {
         if ( A2346TipoOblSoloDescu )
         {
            A2345OblTipoMov = "Descuento" ;
            cmbOblTipoMov.setValue( A2345OblTipoMov );
         }
      }
      if ( A2346TipoOblSoloDescu )
      {
         cmbOblTipoMov.setEnabled( 0 );
      }
      else
      {
         cmbOblTipoMov.setEnabled( 1 );
      }
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) ) )
      {
         divOblliqnro_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblliqnro_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            }
         }
      }
      if ( (0==A1163TipoOblSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoOblSec.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      if ( cmbOblTipoMov.getItemCount() > 0 )
      {
         A2345OblTipoMov = cmbOblTipoMov.getValidValue(A2345OblTipoMov) ;
         cmbOblTipoMov.setValue( A2345OblTipoMov );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A1164TipoOblCodigo", GXutil.rtrim( A1164TipoOblCodigo));
      httpContext.ajax_rsp_assign_attri("", false, "A1168TipoOblTotTipo", GXutil.ltrim( localUtil.ntoc( A1168TipoOblTotTipo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
      httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_prop("", false, edtOblTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblTotal_Visible), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divObltotal_cell_Internalname, "Class", divObltotal_cell_Class, true);
      httpContext.ajax_rsp_assign_prop("", false, dynOblLiqNro.getInternalname(), "Visible", GXutil.ltrimstr( dynOblLiqNro.getVisible(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtOblCanCuo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblCanCuo_Visible), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divOblcancuo_cell_Internalname, "Class", divOblcancuo_cell_Class, true);
      httpContext.ajax_rsp_assign_attri("", false, "A2345OblTipoMov", GXutil.rtrim( A2345OblTipoMov));
      cmbOblTipoMov.setValue( GXutil.rtrim( A2345OblTipoMov) );
      httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Values", cmbOblTipoMov.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_prop("", false, cmbOblTipoMov.getInternalname(), "Enabled", GXutil.ltrimstr( cmbOblTipoMov.getEnabled(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divOblliqnro_cell_Internalname, "Class", divOblliqnro_cell_Class, true);
   }

   public void valid_Oblliqnro( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      /* Using cursor T003D43 */
      pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro)});
      if ( (pr_default.getStatus(41) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Anticipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(41);
      /* Using cursor T003D44 */
      pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(42);
      dynOblConCodigo.setVisible( ((A1168TipoOblTotTipo==2)&&!(0==A1195OblLiqNro) ? 1 : 0) );
      if ( ! ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) ) )
      {
         divOblconcodigo_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ! ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
         {
            divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
         else
         {
            if ( ( A1168TipoOblTotTipo == 2 ) && ! (0==A1195OblLiqNro) && ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) )
            {
               divOblconcodigo_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            }
         }
      }
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (0==A1195OblLiqNro) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liq Nro", ""), "", "", "", "", "", "", "", ""), 1, "OBLLIQNRO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOblLiqNro.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, dynOblConCodigo.getInternalname(), "Visible", GXutil.ltrimstr( dynOblConCodigo.getVisible(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divOblconcodigo_cell_Internalname, "Class", divOblconcodigo_cell_Class, true);
   }

   public void valid_Oblconcodigo( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      /* Using cursor T003D45 */
      pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo});
      if ( (pr_default.getStatus(43) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1169OblConCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(43);
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (GXutil.strcmp("", A1169OblConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Origen concepto", ""), "", "", "", "", "", "", "", ""), 1, "OBLCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOblConCodigo.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Oblconcepto( )
   {
      A2343OblConcepto = cmbOblConcepto.getValue() ;
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      /* Using cursor T003D46 */
      pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), A2343OblConcepto});
      if ( (pr_default.getStatus(44) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(44);
      if ( (GXutil.strcmp("", A2343OblConcepto)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbOblConcepto.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Oblexcconcodigo( )
   {
      A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValue())) ;
      A1163TipoOblSec = (short)(GXutil.lval( dynTipoOblSec.getValue())) ;
      n1195OblLiqNro = false ;
      A1195OblLiqNro = (int)(GXutil.lval( dynOblLiqNro.getValue())) ;
      n1195OblLiqNro = false ;
      n1169OblConCodigo = false ;
      A1169OblConCodigo = dynOblConCodigo.getValue() ;
      n1169OblConCodigo = false ;
      /* Using cursor T003D47 */
      pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(45) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Excp Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLEXCCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOblExcConCOdigo_Internalname ;
      }
      pr_default.close(45);
      dynload_actions( ) ;
      if ( dynLegNumero.getItemCount() > 0 )
      {
         A6LegNumero = (int)(GXutil.lval( dynLegNumero.getValidValue(GXutil.trim( GXutil.str( A6LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegNumero.setValue( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10OblSecuencial',fld:'vOBLSECUENCIAL',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10OblSecuencial',fld:'vOBLSECUENCIAL',pic:'ZZZ9',hsh:true},{av:'A1175OblOriPer',fld:'OBLORIPER',pic:'Z9'},{av:'A1196OblAntiRelaLiq',fld:'OBLANTIRELALIQ',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123D2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("TIPOOBLSEC.CONTROLVALUECHANGED","{handler:'e133D2',iparms:[{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'AV50TipoOblSec',fld:'vTIPOOBLSEC',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("TIPOOBLSEC.CONTROLVALUECHANGED",",oparms:[{av:'AV50TipoOblSec',fld:'vTIPOOBLSEC',pic:'ZZZ9'},{av:'cmbOblConcepto'},{av:'A2343OblConcepto',fld:'OBLCONCEPTO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_TIPOOBLSEC","{handler:'valid_Tipooblsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A1168TipoOblTotTipo',fld:'TIPOOBLTOTTIPO',pic:'9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''},{av:'AV42anticipoTipoOblSec',fld:'vANTICIPOTIPOOBLSEC',pic:'ZZZ9'},{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'A1165TipoOblDescrip',fld:'TIPOOBLDESCRIP',pic:''},{av:'A1164TipoOblCodigo',fld:'TIPOOBLCODIGO',pic:''},{av:'A1161EmbargaSec',fld:'EMBARGASEC',pic:'ZZZ9'},{av:'cmbOblTipoMov'},{av:'A2345OblTipoMov',fld:'OBLTIPOMOV',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_TIPOOBLSEC",",oparms:[{av:'A1165TipoOblDescrip',fld:'TIPOOBLDESCRIP',pic:''},{av:'A1164TipoOblCodigo',fld:'TIPOOBLCODIGO',pic:''},{av:'A1168TipoOblTotTipo',fld:'TIPOOBLTOTTIPO',pic:'9'},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''},{av:'A1161EmbargaSec',fld:'EMBARGASEC',pic:'ZZZ9'},{av:'edtOblTotal_Visible',ctrl:'OBLTOTAL',prop:'Visible'},{av:'divObltotal_cell_Class',ctrl:'OBLTOTAL_CELL',prop:'Class'},{av:'edtOblCanCuo_Visible',ctrl:'OBLCANCUO',prop:'Visible'},{av:'divOblcancuo_cell_Class',ctrl:'OBLCANCUO_CELL',prop:'Class'},{av:'cmbOblTipoMov'},{av:'A2345OblTipoMov',fld:'OBLTIPOMOV',pic:''},{av:'divOblliqnro_cell_Class',ctrl:'OBLLIQNRO_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLESTADO","{handler:'valid_Oblestado',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLESTADO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLLIQNRO","{handler:'valid_Oblliqnro',iparms:[{av:'A1168TipoOblTotTipo',fld:'TIPOOBLTOTTIPO',pic:'9'},{av:'AV42anticipoTipoOblSec',fld:'vANTICIPOTIPOOBLSEC',pic:'ZZZ9'},{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLLIQNRO",",oparms:[{av:'dynOblConCodigo'},{av:'divOblconcodigo_cell_Class',ctrl:'OBLCONCODIGO_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLCONCODIGO","{handler:'valid_Oblconcodigo',iparms:[{av:'AV42anticipoTipoOblSec',fld:'vANTICIPOTIPOOBLSEC',pic:'ZZZ9'},{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLCONCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLPORC","{handler:'valid_Oblporc',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLPORC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLCONCEPTO","{handler:'valid_Oblconcepto',iparms:[{av:'cmbOblConcepto'},{av:'A2343OblConcepto',fld:'OBLCONCEPTO',pic:''},{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLCONCEPTO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLTIPOMOV","{handler:'valid_Obltipomov',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLTIPOMOV",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLSECUENCIAL","{handler:'valid_Oblsecuencial',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLSECUENCIAL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("VALID_OBLEXCCONCODIGO","{handler:'valid_Oblexcconcodigo',iparms:[{av:'A1170OblExcConCOdigo',fld:'OBLEXCCONCODIGO',pic:''},{av:'AV36PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynTipoOblSec'},{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV43anticipoSubTipoConCod1',fld:'vANTICIPOSUBTIPOCONCOD1',pic:''},{av:'AV44desdeDTipoConCod',fld:'vDESDEDTIPOCONCOD',pic:''},{av:'AV45hastaDTipoConCod',fld:'vHASTADTIPOCONCOD',pic:''},{av:'dynOblConCodigo'},{av:'A1169OblConCodigo',fld:'OBLCONCODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("VALID_OBLEXCCONCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Oblexctipo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'dynLegNumero'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynOblLiqNro'},{av:'A1195OblLiqNro',fld:'OBLLIQNRO',pic:'ZZZZZZZ9'},{av:'A1181OblNoRemu',fld:'OBLNOREMU',pic:''},{av:'A1182OblDescu',fld:'OBLDESCU',pic:''}]}");
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
      pr_default.close(45);
      pr_default.close(44);
      pr_default.close(39);
      pr_default.close(24);
      pr_default.close(41);
      pr_default.close(42);
      pr_default.close(43);
      pr_default.close(40);
      pr_default.close(25);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z2345OblTipoMov = "" ;
      Z1176OblTotal = DecimalUtil.ZERO ;
      Z1178OblImpFij = DecimalUtil.ZERO ;
      Z1179OblPorc = DecimalUtil.ZERO ;
      Z2343OblConcepto = "" ;
      Z1169OblConCodigo = "" ;
      N1169OblConCodigo = "" ;
      N2343OblConcepto = "" ;
      N2345OblTipoMov = "" ;
      Z1170OblExcConCOdigo = "" ;
      Z1183OblExcTipo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV43anticipoSubTipoConCod1 = "" ;
      AV44desdeDTipoConCod = "" ;
      AV45hastaDTipoConCod = "" ;
      A2343OblConcepto = "" ;
      A1169OblConCodigo = "" ;
      A1170OblExcConCOdigo = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2345OblTipoMov = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1174OblObs = "" ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucDvpanel_exc = new com.genexus.webpanels.GXUserControl();
      Gridlevel_excepcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode138 = "" ;
      ucCombo_oblexcconcodigo = new com.genexus.webpanels.GXUserControl();
      Combo_oblexcconcodigo_Caption = "" ;
      AV34OblExcConCOdigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV17Insert_OblConCodigo = "" ;
      AV46Insert_OblConcepto = "" ;
      A250LegIdNomApe = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      A1165TipoOblDescrip = "" ;
      A1164TipoOblCodigo = "" ;
      AV52Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_exc_Objectcall = "" ;
      Dvpanel_exc_Class = "" ;
      Dvpanel_exc_Height = "" ;
      Combo_oblexcconcodigo_Objectcall = "" ;
      Combo_oblexcconcodigo_Class = "" ;
      Combo_oblexcconcodigo_Icontype = "" ;
      Combo_oblexcconcodigo_Icon = "" ;
      Combo_oblexcconcodigo_Tooltip = "" ;
      Combo_oblexcconcodigo_Selectedvalue_set = "" ;
      Combo_oblexcconcodigo_Selectedvalue_get = "" ;
      Combo_oblexcconcodigo_Selectedtext_set = "" ;
      Combo_oblexcconcodigo_Selectedtext_get = "" ;
      Combo_oblexcconcodigo_Gamoauthtoken = "" ;
      Combo_oblexcconcodigo_Ddointernalname = "" ;
      Combo_oblexcconcodigo_Titlecontrolalign = "" ;
      Combo_oblexcconcodigo_Dropdownoptionstype = "" ;
      Combo_oblexcconcodigo_Datalisttype = "" ;
      Combo_oblexcconcodigo_Datalistfixedvalues = "" ;
      Combo_oblexcconcodigo_Datalistproc = "" ;
      Combo_oblexcconcodigo_Datalistprocparametersprefix = "" ;
      Combo_oblexcconcodigo_Remoteservicesparameters = "" ;
      Combo_oblexcconcodigo_Htmltemplate = "" ;
      Combo_oblexcconcodigo_Multiplevaluestype = "" ;
      Combo_oblexcconcodigo_Loadingdata = "" ;
      Combo_oblexcconcodigo_Noresultsfound = "" ;
      Combo_oblexcconcodigo_Emptyitemtext = "" ;
      Combo_oblexcconcodigo_Onlyselectedvalues = "" ;
      Combo_oblexcconcodigo_Selectalltext = "" ;
      Combo_oblexcconcodigo_Multiplevaluesseparator = "" ;
      Combo_oblexcconcodigo_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode134 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1183OblExcTipo = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV18TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXt_char6 = "" ;
      GXt_objcol_SdtDVB_SDTComboData_Item8 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV21ComboSelectedValue = "" ;
      GXv_objcol_SdtDVB_SDTComboData_Item9 = new GXBaseCollection[1] ;
      AV33ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char10 = new GXSimpleCollection[1] ;
      AV49ConDescrip = "" ;
      GXv_char7 = new String[1] ;
      Z1174OblObs = "" ;
      Z250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      Z230LegApellido = "" ;
      Z93LegId = "" ;
      Z1165TipoOblDescrip = "" ;
      Z1164TipoOblCodigo = "" ;
      T003D8_A250LegIdNomApe = new String[] {""} ;
      T003D8_A251LegNombre = new String[] {""} ;
      T003D8_A230LegApellido = new String[] {""} ;
      T003D8_A93LegId = new String[] {""} ;
      T003D8_n93LegId = new boolean[] {false} ;
      T003D12_A1165TipoOblDescrip = new String[] {""} ;
      T003D12_A1164TipoOblCodigo = new String[] {""} ;
      T003D12_A1168TipoOblTotTipo = new byte[1] ;
      T003D12_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003D12_A1161EmbargaSec = new short[1] ;
      T003D12_n1161EmbargaSec = new boolean[] {false} ;
      T003D13_A250LegIdNomApe = new String[] {""} ;
      T003D13_A1172OblSecuencial = new short[1] ;
      T003D13_A2345OblTipoMov = new String[] {""} ;
      T003D13_A1165TipoOblDescrip = new String[] {""} ;
      T003D13_A1164TipoOblCodigo = new String[] {""} ;
      T003D13_A1173OblEstado = new byte[1] ;
      T003D13_A1174OblObs = new String[] {""} ;
      T003D13_A1175OblOriPer = new byte[1] ;
      T003D13_A1168TipoOblTotTipo = new byte[1] ;
      T003D13_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D13_A1177OblCanCuo = new short[1] ;
      T003D13_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D13_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D13_A1181OblNoRemu = new boolean[] {false} ;
      T003D13_A1182OblDescu = new boolean[] {false} ;
      T003D13_A1196OblAntiRelaLiq = new boolean[] {false} ;
      T003D13_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003D13_A251LegNombre = new String[] {""} ;
      T003D13_A230LegApellido = new String[] {""} ;
      T003D13_A93LegId = new String[] {""} ;
      T003D13_n93LegId = new boolean[] {false} ;
      T003D13_A3CliCod = new int[1] ;
      T003D13_A2343OblConcepto = new String[] {""} ;
      T003D13_A1EmpCod = new short[1] ;
      T003D13_A6LegNumero = new int[1] ;
      T003D13_A1195OblLiqNro = new int[1] ;
      T003D13_n1195OblLiqNro = new boolean[] {false} ;
      T003D13_A1169OblConCodigo = new String[] {""} ;
      T003D13_n1169OblConCodigo = new boolean[] {false} ;
      T003D13_A1163TipoOblSec = new short[1] ;
      T003D13_A1161EmbargaSec = new short[1] ;
      T003D13_n1161EmbargaSec = new boolean[] {false} ;
      T003D7_A3CliCod = new int[1] ;
      T003D11_A3CliCod = new int[1] ;
      T003D9_A3CliCod = new int[1] ;
      T003D10_A31LiqNro = new int[1] ;
      T003D14_A3CliCod = new int[1] ;
      T003D15_A3CliCod = new int[1] ;
      T003D16_A3CliCod = new int[1] ;
      T003D17_A250LegIdNomApe = new String[] {""} ;
      T003D17_A251LegNombre = new String[] {""} ;
      T003D17_A230LegApellido = new String[] {""} ;
      T003D17_A93LegId = new String[] {""} ;
      T003D17_n93LegId = new boolean[] {false} ;
      T003D18_A31LiqNro = new int[1] ;
      T003D19_A1165TipoOblDescrip = new String[] {""} ;
      T003D19_A1164TipoOblCodigo = new String[] {""} ;
      T003D19_A1168TipoOblTotTipo = new byte[1] ;
      T003D19_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003D19_A1161EmbargaSec = new short[1] ;
      T003D19_n1161EmbargaSec = new boolean[] {false} ;
      T003D20_A3CliCod = new int[1] ;
      T003D20_A1EmpCod = new short[1] ;
      T003D20_A6LegNumero = new int[1] ;
      T003D20_A1172OblSecuencial = new short[1] ;
      T003D6_A1172OblSecuencial = new short[1] ;
      T003D6_A2345OblTipoMov = new String[] {""} ;
      T003D6_A1173OblEstado = new byte[1] ;
      T003D6_A1174OblObs = new String[] {""} ;
      T003D6_A1175OblOriPer = new byte[1] ;
      T003D6_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D6_A1177OblCanCuo = new short[1] ;
      T003D6_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D6_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D6_A1181OblNoRemu = new boolean[] {false} ;
      T003D6_A1182OblDescu = new boolean[] {false} ;
      T003D6_A1196OblAntiRelaLiq = new boolean[] {false} ;
      T003D6_A3CliCod = new int[1] ;
      T003D6_A2343OblConcepto = new String[] {""} ;
      T003D6_A1EmpCod = new short[1] ;
      T003D6_A6LegNumero = new int[1] ;
      T003D6_A1195OblLiqNro = new int[1] ;
      T003D6_n1195OblLiqNro = new boolean[] {false} ;
      T003D6_A1169OblConCodigo = new String[] {""} ;
      T003D6_n1169OblConCodigo = new boolean[] {false} ;
      T003D6_A1163TipoOblSec = new short[1] ;
      T003D21_A1172OblSecuencial = new short[1] ;
      T003D21_A3CliCod = new int[1] ;
      T003D21_A1EmpCod = new short[1] ;
      T003D21_A6LegNumero = new int[1] ;
      T003D22_A1172OblSecuencial = new short[1] ;
      T003D22_A3CliCod = new int[1] ;
      T003D22_A1EmpCod = new short[1] ;
      T003D22_A6LegNumero = new int[1] ;
      T003D5_A1172OblSecuencial = new short[1] ;
      T003D5_A2345OblTipoMov = new String[] {""} ;
      T003D5_A1173OblEstado = new byte[1] ;
      T003D5_A1174OblObs = new String[] {""} ;
      T003D5_A1175OblOriPer = new byte[1] ;
      T003D5_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D5_A1177OblCanCuo = new short[1] ;
      T003D5_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D5_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003D5_A1181OblNoRemu = new boolean[] {false} ;
      T003D5_A1182OblDescu = new boolean[] {false} ;
      T003D5_A1196OblAntiRelaLiq = new boolean[] {false} ;
      T003D5_A3CliCod = new int[1] ;
      T003D5_A2343OblConcepto = new String[] {""} ;
      T003D5_A1EmpCod = new short[1] ;
      T003D5_A6LegNumero = new int[1] ;
      T003D5_A1195OblLiqNro = new int[1] ;
      T003D5_n1195OblLiqNro = new boolean[] {false} ;
      T003D5_A1169OblConCodigo = new String[] {""} ;
      T003D5_n1169OblConCodigo = new boolean[] {false} ;
      T003D5_A1163TipoOblSec = new short[1] ;
      T003D26_A250LegIdNomApe = new String[] {""} ;
      T003D26_A251LegNombre = new String[] {""} ;
      T003D26_A230LegApellido = new String[] {""} ;
      T003D26_A93LegId = new String[] {""} ;
      T003D26_n93LegId = new boolean[] {false} ;
      T003D27_A1165TipoOblDescrip = new String[] {""} ;
      T003D27_A1164TipoOblCodigo = new String[] {""} ;
      T003D27_A1168TipoOblTotTipo = new byte[1] ;
      T003D27_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003D27_A1161EmbargaSec = new short[1] ;
      T003D27_n1161EmbargaSec = new boolean[] {false} ;
      T003D28_A3CliCod = new int[1] ;
      T003D28_A1EmpCod = new short[1] ;
      T003D28_A6LegNumero = new int[1] ;
      T003D28_A1172OblSecuencial = new short[1] ;
      T003D28_A1184LiqOblAltaNro = new int[1] ;
      T003D28_A1185LiqOblNuevaNro = new int[1] ;
      T003D29_A3CliCod = new int[1] ;
      T003D29_A1EmpCod = new short[1] ;
      T003D29_A6LegNumero = new int[1] ;
      T003D29_A1172OblSecuencial = new short[1] ;
      T003D30_A1183OblExcTipo = new String[] {""} ;
      T003D30_A3CliCod = new int[1] ;
      T003D30_A1170OblExcConCOdigo = new String[] {""} ;
      T003D30_A1EmpCod = new short[1] ;
      T003D30_A6LegNumero = new int[1] ;
      T003D30_A1172OblSecuencial = new short[1] ;
      T003D4_A3CliCod = new int[1] ;
      T003D31_A3CliCod = new int[1] ;
      T003D32_A3CliCod = new int[1] ;
      T003D32_A1EmpCod = new short[1] ;
      T003D32_A6LegNumero = new int[1] ;
      T003D32_A1172OblSecuencial = new short[1] ;
      T003D32_A1170OblExcConCOdigo = new String[] {""} ;
      T003D3_A1183OblExcTipo = new String[] {""} ;
      T003D3_A3CliCod = new int[1] ;
      T003D3_A1170OblExcConCOdigo = new String[] {""} ;
      T003D3_A1EmpCod = new short[1] ;
      T003D3_A6LegNumero = new int[1] ;
      T003D3_A1172OblSecuencial = new short[1] ;
      T003D2_A1183OblExcTipo = new String[] {""} ;
      T003D2_A3CliCod = new int[1] ;
      T003D2_A1170OblExcConCOdigo = new String[] {""} ;
      T003D2_A1EmpCod = new short[1] ;
      T003D2_A6LegNumero = new int[1] ;
      T003D2_A1172OblSecuencial = new short[1] ;
      T003D36_A3CliCod = new int[1] ;
      T003D36_A1EmpCod = new short[1] ;
      T003D36_A6LegNumero = new int[1] ;
      T003D36_A1172OblSecuencial = new short[1] ;
      T003D36_A1170OblExcConCOdigo = new String[] {""} ;
      Gridlevel_excepcionesRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_excepciones_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_excepcionesColumn = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003D37_A3CliCod = new int[1] ;
      T003D37_A1EmpCod = new short[1] ;
      T003D37_A6LegNumero = new int[1] ;
      T003D37_A250LegIdNomApe = new String[] {""} ;
      T003D37_A1818LegEstado = new byte[1] ;
      T003D38_A1163TipoOblSec = new short[1] ;
      T003D38_A1165TipoOblDescrip = new String[] {""} ;
      T003D38_A1159TipoOblPaiCod = new short[1] ;
      T003D39_A3CliCod = new int[1] ;
      T003D39_A1EmpCod = new short[1] ;
      T003D39_A6LegNumero = new int[1] ;
      T003D39_A31LiqNro = new int[1] ;
      T003D39_A874LiqNombre = new String[] {""} ;
      T003D40_A3CliCod = new int[1] ;
      T003D40_A1EmpCod = new short[1] ;
      T003D40_A31LiqNro = new int[1] ;
      T003D40_A6LegNumero = new int[1] ;
      T003D40_A81LiqDSecuencial = new int[1] ;
      T003D40_A394DConCodigo = new String[] {""} ;
      T003D40_A393DConDescrip = new String[] {""} ;
      T003D40_A468DSubTipoConCod1 = new String[] {""} ;
      T003D40_n468DSubTipoConCod1 = new boolean[] {false} ;
      T003D40_A464DTipoConCod = new String[] {""} ;
      GXv_int12 = new int[1] ;
      GXv_int5 = new short[1] ;
      T003D41_A250LegIdNomApe = new String[] {""} ;
      T003D41_A251LegNombre = new String[] {""} ;
      T003D41_A230LegApellido = new String[] {""} ;
      T003D41_A93LegId = new String[] {""} ;
      T003D41_n93LegId = new boolean[] {false} ;
      T003D42_A1165TipoOblDescrip = new String[] {""} ;
      T003D42_A1164TipoOblCodigo = new String[] {""} ;
      T003D42_A1168TipoOblTotTipo = new byte[1] ;
      T003D42_A2346TipoOblSoloDescu = new boolean[] {false} ;
      T003D42_A1161EmbargaSec = new short[1] ;
      T003D42_n1161EmbargaSec = new boolean[] {false} ;
      T003D43_A3CliCod = new int[1] ;
      T003D44_A31LiqNro = new int[1] ;
      T003D45_A3CliCod = new int[1] ;
      T003D46_A3CliCod = new int[1] ;
      T003D47_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacion__default(),
         new Object[] {
             new Object[] {
            T003D2_A1183OblExcTipo, T003D2_A3CliCod, T003D2_A1170OblExcConCOdigo, T003D2_A1EmpCod, T003D2_A6LegNumero, T003D2_A1172OblSecuencial
            }
            , new Object[] {
            T003D3_A1183OblExcTipo, T003D3_A3CliCod, T003D3_A1170OblExcConCOdigo, T003D3_A1EmpCod, T003D3_A6LegNumero, T003D3_A1172OblSecuencial
            }
            , new Object[] {
            T003D4_A3CliCod
            }
            , new Object[] {
            T003D5_A1172OblSecuencial, T003D5_A2345OblTipoMov, T003D5_A1173OblEstado, T003D5_A1174OblObs, T003D5_A1175OblOriPer, T003D5_A1176OblTotal, T003D5_A1177OblCanCuo, T003D5_A1178OblImpFij, T003D5_A1179OblPorc, T003D5_A1181OblNoRemu,
            T003D5_A1182OblDescu, T003D5_A1196OblAntiRelaLiq, T003D5_A3CliCod, T003D5_A2343OblConcepto, T003D5_A1EmpCod, T003D5_A6LegNumero, T003D5_A1195OblLiqNro, T003D5_n1195OblLiqNro, T003D5_A1169OblConCodigo, T003D5_n1169OblConCodigo,
            T003D5_A1163TipoOblSec
            }
            , new Object[] {
            T003D6_A1172OblSecuencial, T003D6_A2345OblTipoMov, T003D6_A1173OblEstado, T003D6_A1174OblObs, T003D6_A1175OblOriPer, T003D6_A1176OblTotal, T003D6_A1177OblCanCuo, T003D6_A1178OblImpFij, T003D6_A1179OblPorc, T003D6_A1181OblNoRemu,
            T003D6_A1182OblDescu, T003D6_A1196OblAntiRelaLiq, T003D6_A3CliCod, T003D6_A2343OblConcepto, T003D6_A1EmpCod, T003D6_A6LegNumero, T003D6_A1195OblLiqNro, T003D6_n1195OblLiqNro, T003D6_A1169OblConCodigo, T003D6_n1169OblConCodigo,
            T003D6_A1163TipoOblSec
            }
            , new Object[] {
            T003D7_A3CliCod
            }
            , new Object[] {
            T003D8_A250LegIdNomApe, T003D8_A251LegNombre, T003D8_A230LegApellido, T003D8_A93LegId, T003D8_n93LegId
            }
            , new Object[] {
            T003D9_A3CliCod
            }
            , new Object[] {
            T003D10_A31LiqNro
            }
            , new Object[] {
            T003D11_A3CliCod
            }
            , new Object[] {
            T003D12_A1165TipoOblDescrip, T003D12_A1164TipoOblCodigo, T003D12_A1168TipoOblTotTipo, T003D12_A2346TipoOblSoloDescu, T003D12_A1161EmbargaSec, T003D12_n1161EmbargaSec
            }
            , new Object[] {
            T003D13_A250LegIdNomApe, T003D13_A1172OblSecuencial, T003D13_A2345OblTipoMov, T003D13_A1165TipoOblDescrip, T003D13_A1164TipoOblCodigo, T003D13_A1173OblEstado, T003D13_A1174OblObs, T003D13_A1175OblOriPer, T003D13_A1168TipoOblTotTipo, T003D13_A1176OblTotal,
            T003D13_A1177OblCanCuo, T003D13_A1178OblImpFij, T003D13_A1179OblPorc, T003D13_A1181OblNoRemu, T003D13_A1182OblDescu, T003D13_A1196OblAntiRelaLiq, T003D13_A2346TipoOblSoloDescu, T003D13_A251LegNombre, T003D13_A230LegApellido, T003D13_A93LegId,
            T003D13_n93LegId, T003D13_A3CliCod, T003D13_A2343OblConcepto, T003D13_A1EmpCod, T003D13_A6LegNumero, T003D13_A1195OblLiqNro, T003D13_n1195OblLiqNro, T003D13_A1169OblConCodigo, T003D13_n1169OblConCodigo, T003D13_A1163TipoOblSec,
            T003D13_A1161EmbargaSec, T003D13_n1161EmbargaSec
            }
            , new Object[] {
            T003D14_A3CliCod
            }
            , new Object[] {
            T003D15_A3CliCod
            }
            , new Object[] {
            T003D16_A3CliCod
            }
            , new Object[] {
            T003D17_A250LegIdNomApe, T003D17_A251LegNombre, T003D17_A230LegApellido, T003D17_A93LegId, T003D17_n93LegId
            }
            , new Object[] {
            T003D18_A31LiqNro
            }
            , new Object[] {
            T003D19_A1165TipoOblDescrip, T003D19_A1164TipoOblCodigo, T003D19_A1168TipoOblTotTipo, T003D19_A2346TipoOblSoloDescu, T003D19_A1161EmbargaSec, T003D19_n1161EmbargaSec
            }
            , new Object[] {
            T003D20_A3CliCod, T003D20_A1EmpCod, T003D20_A6LegNumero, T003D20_A1172OblSecuencial
            }
            , new Object[] {
            T003D21_A1172OblSecuencial, T003D21_A3CliCod, T003D21_A1EmpCod, T003D21_A6LegNumero
            }
            , new Object[] {
            T003D22_A1172OblSecuencial, T003D22_A3CliCod, T003D22_A1EmpCod, T003D22_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003D26_A250LegIdNomApe, T003D26_A251LegNombre, T003D26_A230LegApellido, T003D26_A93LegId, T003D26_n93LegId
            }
            , new Object[] {
            T003D27_A1165TipoOblDescrip, T003D27_A1164TipoOblCodigo, T003D27_A1168TipoOblTotTipo, T003D27_A2346TipoOblSoloDescu, T003D27_A1161EmbargaSec, T003D27_n1161EmbargaSec
            }
            , new Object[] {
            T003D28_A3CliCod, T003D28_A1EmpCod, T003D28_A6LegNumero, T003D28_A1172OblSecuencial, T003D28_A1184LiqOblAltaNro, T003D28_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T003D29_A3CliCod, T003D29_A1EmpCod, T003D29_A6LegNumero, T003D29_A1172OblSecuencial
            }
            , new Object[] {
            T003D30_A1183OblExcTipo, T003D30_A3CliCod, T003D30_A1170OblExcConCOdigo, T003D30_A1EmpCod, T003D30_A6LegNumero, T003D30_A1172OblSecuencial
            }
            , new Object[] {
            T003D31_A3CliCod
            }
            , new Object[] {
            T003D32_A3CliCod, T003D32_A1EmpCod, T003D32_A6LegNumero, T003D32_A1172OblSecuencial, T003D32_A1170OblExcConCOdigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003D36_A3CliCod, T003D36_A1EmpCod, T003D36_A6LegNumero, T003D36_A1172OblSecuencial, T003D36_A1170OblExcConCOdigo
            }
            , new Object[] {
            T003D37_A3CliCod, T003D37_A1EmpCod, T003D37_A6LegNumero, T003D37_A250LegIdNomApe, T003D37_A1818LegEstado
            }
            , new Object[] {
            T003D38_A1163TipoOblSec, T003D38_A1165TipoOblDescrip, T003D38_A1159TipoOblPaiCod
            }
            , new Object[] {
            T003D39_A3CliCod, T003D39_A1EmpCod, T003D39_A6LegNumero, T003D39_A31LiqNro, T003D39_A874LiqNombre
            }
            , new Object[] {
            T003D40_A3CliCod, T003D40_A1EmpCod, T003D40_A31LiqNro, T003D40_A6LegNumero, T003D40_A81LiqDSecuencial, T003D40_A394DConCodigo, T003D40_A393DConDescrip, T003D40_A468DSubTipoConCod1, T003D40_n468DSubTipoConCod1, T003D40_A464DTipoConCod
            }
            , new Object[] {
            T003D41_A250LegIdNomApe, T003D41_A251LegNombre, T003D41_A230LegApellido, T003D41_A93LegId, T003D41_n93LegId
            }
            , new Object[] {
            T003D42_A1165TipoOblDescrip, T003D42_A1164TipoOblCodigo, T003D42_A1168TipoOblTotTipo, T003D42_A2346TipoOblSoloDescu, T003D42_A1161EmbargaSec, T003D42_n1161EmbargaSec
            }
            , new Object[] {
            T003D43_A3CliCod
            }
            , new Object[] {
            T003D44_A31LiqNro
            }
            , new Object[] {
            T003D45_A3CliCod
            }
            , new Object[] {
            T003D46_A3CliCod
            }
            , new Object[] {
            T003D47_A3CliCod
            }
         }
      );
      AV52Pgmname = "Obligacion" ;
      Z2345OblTipoMov = "Descuento" ;
      N2345OblTipoMov = "Descuento" ;
      A2345OblTipoMov = "Descuento" ;
      Z1173OblEstado = (byte)(1) ;
      A1173OblEstado = (byte)(1) ;
      i1173OblEstado = (byte)(1) ;
   }

   private byte Z1173OblEstado ;
   private byte Z1175OblOriPer ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1173OblEstado ;
   private byte A1175OblOriPer ;
   private byte A1168TipoOblTotTipo ;
   private byte Gx_BScreen ;
   private byte Z1168TipoOblTotTipo ;
   private byte subGridlevel_excepciones_Backcolorstyle ;
   private byte subGridlevel_excepciones_Backstyle ;
   private byte gxajaxcallmode ;
   private byte i1173OblEstado ;
   private byte subGridlevel_excepciones_Allowselection ;
   private byte subGridlevel_excepciones_Allowhovering ;
   private byte subGridlevel_excepciones_Allowcollapsing ;
   private byte subGridlevel_excepciones_Collapsed ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV10OblSecuencial ;
   private short Z1EmpCod ;
   private short Z1172OblSecuencial ;
   private short Z1177OblCanCuo ;
   private short Z1163TipoOblSec ;
   private short N1163TipoOblSec ;
   private short nRcdDeleted_138 ;
   private short nRcdExists_138 ;
   private short nIsMod_138 ;
   private short AV8EmpCod ;
   private short AV36PaiCod ;
   private short A1EmpCod ;
   private short AV10OblSecuencial ;
   private short A1163TipoOblSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1177OblCanCuo ;
   private short nBlankRcdCount138 ;
   private short RcdFound138 ;
   private short nBlankRcdUsr138 ;
   private short A1172OblSecuencial ;
   private short AV16Insert_TipoOblSec ;
   private short AV42anticipoTipoOblSec ;
   private short A1161EmbargaSec ;
   private short RcdFound134 ;
   private short AV50TipoOblSec ;
   private short AV48i ;
   private short Z1161EmbargaSec ;
   private short nIsDirty_134 ;
   private short nIsDirty_138 ;
   private short GXt_int4 ;
   private short GXv_int5[] ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z1195OblLiqNro ;
   private int nRC_GXsfl_113 ;
   private int nGXsfl_113_idx=1 ;
   private int N1195OblLiqNro ;
   private int AV7CliCod ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1195OblLiqNro ;
   private int AV9LegNumero ;
   private int trnEnded ;
   private int edtOblObs_Enabled ;
   private int edtOblTotal_Visible ;
   private int edtOblTotal_Enabled ;
   private int edtOblCanCuo_Visible ;
   private int edtOblCanCuo_Enabled ;
   private int edtOblImpFij_Enabled ;
   private int edtOblPorc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int tblTblexc_Visible ;
   private int edtOblExcConCOdigo_Enabled ;
   private int fRowAdded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtOblSecuencial_Visible ;
   private int edtOblSecuencial_Enabled ;
   private int AV35Insert_OblLiqNro ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_exc_Gxcontroltype ;
   private int Combo_oblexcconcodigo_Datalistupdateminimumcharacters ;
   private int Combo_oblexcconcodigo_Gxcontroltype ;
   private int AV53GXV1 ;
   private int GX_JID ;
   private int subGridlevel_excepciones_Backcolor ;
   private int subGridlevel_excepciones_Allbackcolor ;
   private int defedtOblExcConCOdigo_Enabled ;
   private int A31LiqNro ;
   private int idxLst ;
   private int subGridlevel_excepciones_Selectedindex ;
   private int subGridlevel_excepciones_Selectioncolor ;
   private int subGridlevel_excepciones_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int11 ;
   private int GXv_int12[] ;
   private long GRIDLEVEL_EXCEPCIONES_nFirstRecordOnPage ;
   private java.math.BigDecimal Z1176OblTotal ;
   private java.math.BigDecimal Z1178OblImpFij ;
   private java.math.BigDecimal Z1179OblPorc ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2345OblTipoMov ;
   private String Z2343OblConcepto ;
   private String Z1169OblConCodigo ;
   private String N1169OblConCodigo ;
   private String N2343OblConcepto ;
   private String N2345OblTipoMov ;
   private String Z1170OblExcConCOdigo ;
   private String Z1183OblExcTipo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV43anticipoSubTipoConCod1 ;
   private String AV44desdeDTipoConCod ;
   private String AV45hastaDTipoConCod ;
   private String A2343OblConcepto ;
   private String A1169OblConCodigo ;
   private String A1170OblExcConCOdigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String sGXsfl_113_idx="0001" ;
   private String A2345OblTipoMov ;
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
   private String edtOblObs_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divObltotal_cell_Internalname ;
   private String divObltotal_cell_Class ;
   private String edtOblTotal_Internalname ;
   private String edtOblTotal_Jsonclick ;
   private String divOblliqnro_cell_Internalname ;
   private String divOblliqnro_cell_Class ;
   private String divOblconcodigo_cell_Internalname ;
   private String divOblconcodigo_cell_Class ;
   private String divOblcancuo_cell_Internalname ;
   private String divOblcancuo_cell_Class ;
   private String edtOblCanCuo_Internalname ;
   private String edtOblCanCuo_Jsonclick ;
   private String edtOblImpFij_Internalname ;
   private String edtOblImpFij_Jsonclick ;
   private String edtOblPorc_Internalname ;
   private String edtOblPorc_Jsonclick ;
   private String divOblnoremu_cell_Internalname ;
   private String divOblnoremu_cell_Class ;
   private String divObldescu_cell_Internalname ;
   private String divObldescu_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String tblTblexc_Internalname ;
   private String Dvpanel_exc_Width ;
   private String Dvpanel_exc_Cls ;
   private String Dvpanel_exc_Title ;
   private String Dvpanel_exc_Iconposition ;
   private String Dvpanel_exc_Internalname ;
   private String divExc_Internalname ;
   private String divTableleaflevel_excepciones_Internalname ;
   private String sMode138 ;
   private String edtOblExcConCOdigo_Internalname ;
   private String subGridlevel_excepciones_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_oblexcconcodigo_Caption ;
   private String Combo_oblexcconcodigo_Cls ;
   private String Combo_oblexcconcodigo_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtOblSecuencial_Internalname ;
   private String edtOblSecuencial_Jsonclick ;
   private String AV17Insert_OblConCodigo ;
   private String AV46Insert_OblConcepto ;
   private String A93LegId ;
   private String A1164TipoOblCodigo ;
   private String AV52Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_exc_Objectcall ;
   private String Dvpanel_exc_Class ;
   private String Dvpanel_exc_Height ;
   private String Combo_oblexcconcodigo_Objectcall ;
   private String Combo_oblexcconcodigo_Class ;
   private String Combo_oblexcconcodigo_Icontype ;
   private String Combo_oblexcconcodigo_Icon ;
   private String Combo_oblexcconcodigo_Tooltip ;
   private String Combo_oblexcconcodigo_Selectedvalue_set ;
   private String Combo_oblexcconcodigo_Selectedvalue_get ;
   private String Combo_oblexcconcodigo_Selectedtext_set ;
   private String Combo_oblexcconcodigo_Selectedtext_get ;
   private String Combo_oblexcconcodigo_Gamoauthtoken ;
   private String Combo_oblexcconcodigo_Ddointernalname ;
   private String Combo_oblexcconcodigo_Titlecontrolalign ;
   private String Combo_oblexcconcodigo_Dropdownoptionstype ;
   private String Combo_oblexcconcodigo_Titlecontrolidtoreplace ;
   private String Combo_oblexcconcodigo_Datalisttype ;
   private String Combo_oblexcconcodigo_Datalistfixedvalues ;
   private String Combo_oblexcconcodigo_Datalistproc ;
   private String Combo_oblexcconcodigo_Datalistprocparametersprefix ;
   private String Combo_oblexcconcodigo_Remoteservicesparameters ;
   private String Combo_oblexcconcodigo_Htmltemplate ;
   private String Combo_oblexcconcodigo_Multiplevaluestype ;
   private String Combo_oblexcconcodigo_Loadingdata ;
   private String Combo_oblexcconcodigo_Noresultsfound ;
   private String Combo_oblexcconcodigo_Emptyitemtext ;
   private String Combo_oblexcconcodigo_Onlyselectedvalues ;
   private String Combo_oblexcconcodigo_Selectalltext ;
   private String Combo_oblexcconcodigo_Multiplevaluesseparator ;
   private String Combo_oblexcconcodigo_Addnewoptiontext ;
   private String hsh ;
   private String sMode134 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A1183OblExcTipo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String Z93LegId ;
   private String Z1164TipoOblCodigo ;
   private String sGXsfl_113_fel_idx="0001" ;
   private String subGridlevel_excepciones_Class ;
   private String subGridlevel_excepciones_Linesclass ;
   private String ROClassString ;
   private String edtOblExcConCOdigo_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_excepciones_Header ;
   private String gxwrpcisep ;
   private boolean Z1181OblNoRemu ;
   private boolean Z1182OblDescu ;
   private boolean Z1196OblAntiRelaLiq ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1169OblConCodigo ;
   private boolean n1195OblLiqNro ;
   private boolean wbErr ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_exc_Autowidth ;
   private boolean Dvpanel_exc_Autoheight ;
   private boolean Dvpanel_exc_Collapsible ;
   private boolean Dvpanel_exc_Collapsed ;
   private boolean Dvpanel_exc_Showcollapseicon ;
   private boolean Dvpanel_exc_Autoscroll ;
   private boolean bGXsfl_113_Refreshing=false ;
   private boolean Combo_oblexcconcodigo_Isgriditem ;
   private boolean Combo_oblexcconcodigo_Emptyitem ;
   private boolean A1196OblAntiRelaLiq ;
   private boolean A2346TipoOblSoloDescu ;
   private boolean n93LegId ;
   private boolean n1161EmbargaSec ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_exc_Enabled ;
   private boolean Dvpanel_exc_Showheader ;
   private boolean Dvpanel_exc_Visible ;
   private boolean Combo_oblexcconcodigo_Enabled ;
   private boolean Combo_oblexcconcodigo_Visible ;
   private boolean Combo_oblexcconcodigo_Allowmultipleselection ;
   private boolean Combo_oblexcconcodigo_Hasdescription ;
   private boolean Combo_oblexcconcodigo_Includeonlyselectedoption ;
   private boolean Combo_oblexcconcodigo_Includeselectalloption ;
   private boolean Combo_oblexcconcodigo_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z2346TipoOblSoloDescu ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private String A1174OblObs ;
   private String Z1174OblObs ;
   private String A250LegIdNomApe ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String A1165TipoOblDescrip ;
   private String AV21ComboSelectedValue ;
   private String AV49ConDescrip ;
   private String Z250LegIdNomApe ;
   private String Z251LegNombre ;
   private String Z230LegApellido ;
   private String Z1165TipoOblDescrip ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_excepcionesContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_excepcionesRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_excepcionesColumn ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_exc ;
   private com.genexus.webpanels.GXUserControl ucCombo_oblexcconcodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynLegNumero ;
   private HTMLChoice dynTipoOblSec ;
   private HTMLChoice cmbOblEstado ;
   private HTMLChoice dynOblLiqNro ;
   private HTMLChoice dynOblConCodigo ;
   private ICheckbox chkOblNoRemu ;
   private ICheckbox chkOblDescu ;
   private HTMLChoice cmbOblConcepto ;
   private HTMLChoice cmbOblTipoMov ;
   private HTMLChoice cmbOblExcTipo ;
   private IDataStoreProvider pr_default ;
   private String[] T003D8_A250LegIdNomApe ;
   private String[] T003D8_A251LegNombre ;
   private String[] T003D8_A230LegApellido ;
   private String[] T003D8_A93LegId ;
   private boolean[] T003D8_n93LegId ;
   private String[] T003D12_A1165TipoOblDescrip ;
   private String[] T003D12_A1164TipoOblCodigo ;
   private byte[] T003D12_A1168TipoOblTotTipo ;
   private boolean[] T003D12_A2346TipoOblSoloDescu ;
   private short[] T003D12_A1161EmbargaSec ;
   private boolean[] T003D12_n1161EmbargaSec ;
   private String[] T003D13_A250LegIdNomApe ;
   private short[] T003D13_A1172OblSecuencial ;
   private String[] T003D13_A2345OblTipoMov ;
   private String[] T003D13_A1165TipoOblDescrip ;
   private String[] T003D13_A1164TipoOblCodigo ;
   private byte[] T003D13_A1173OblEstado ;
   private String[] T003D13_A1174OblObs ;
   private byte[] T003D13_A1175OblOriPer ;
   private byte[] T003D13_A1168TipoOblTotTipo ;
   private java.math.BigDecimal[] T003D13_A1176OblTotal ;
   private short[] T003D13_A1177OblCanCuo ;
   private java.math.BigDecimal[] T003D13_A1178OblImpFij ;
   private java.math.BigDecimal[] T003D13_A1179OblPorc ;
   private boolean[] T003D13_A1181OblNoRemu ;
   private boolean[] T003D13_A1182OblDescu ;
   private boolean[] T003D13_A1196OblAntiRelaLiq ;
   private boolean[] T003D13_A2346TipoOblSoloDescu ;
   private String[] T003D13_A251LegNombre ;
   private String[] T003D13_A230LegApellido ;
   private String[] T003D13_A93LegId ;
   private boolean[] T003D13_n93LegId ;
   private int[] T003D13_A3CliCod ;
   private String[] T003D13_A2343OblConcepto ;
   private short[] T003D13_A1EmpCod ;
   private int[] T003D13_A6LegNumero ;
   private int[] T003D13_A1195OblLiqNro ;
   private boolean[] T003D13_n1195OblLiqNro ;
   private String[] T003D13_A1169OblConCodigo ;
   private boolean[] T003D13_n1169OblConCodigo ;
   private short[] T003D13_A1163TipoOblSec ;
   private short[] T003D13_A1161EmbargaSec ;
   private boolean[] T003D13_n1161EmbargaSec ;
   private int[] T003D7_A3CliCod ;
   private int[] T003D11_A3CliCod ;
   private int[] T003D9_A3CliCod ;
   private int[] T003D10_A31LiqNro ;
   private int[] T003D14_A3CliCod ;
   private int[] T003D15_A3CliCod ;
   private int[] T003D16_A3CliCod ;
   private String[] T003D17_A250LegIdNomApe ;
   private String[] T003D17_A251LegNombre ;
   private String[] T003D17_A230LegApellido ;
   private String[] T003D17_A93LegId ;
   private boolean[] T003D17_n93LegId ;
   private int[] T003D18_A31LiqNro ;
   private String[] T003D19_A1165TipoOblDescrip ;
   private String[] T003D19_A1164TipoOblCodigo ;
   private byte[] T003D19_A1168TipoOblTotTipo ;
   private boolean[] T003D19_A2346TipoOblSoloDescu ;
   private short[] T003D19_A1161EmbargaSec ;
   private boolean[] T003D19_n1161EmbargaSec ;
   private int[] T003D20_A3CliCod ;
   private short[] T003D20_A1EmpCod ;
   private int[] T003D20_A6LegNumero ;
   private short[] T003D20_A1172OblSecuencial ;
   private short[] T003D6_A1172OblSecuencial ;
   private String[] T003D6_A2345OblTipoMov ;
   private byte[] T003D6_A1173OblEstado ;
   private String[] T003D6_A1174OblObs ;
   private byte[] T003D6_A1175OblOriPer ;
   private java.math.BigDecimal[] T003D6_A1176OblTotal ;
   private short[] T003D6_A1177OblCanCuo ;
   private java.math.BigDecimal[] T003D6_A1178OblImpFij ;
   private java.math.BigDecimal[] T003D6_A1179OblPorc ;
   private boolean[] T003D6_A1181OblNoRemu ;
   private boolean[] T003D6_A1182OblDescu ;
   private boolean[] T003D6_A1196OblAntiRelaLiq ;
   private int[] T003D6_A3CliCod ;
   private String[] T003D6_A2343OblConcepto ;
   private short[] T003D6_A1EmpCod ;
   private int[] T003D6_A6LegNumero ;
   private int[] T003D6_A1195OblLiqNro ;
   private boolean[] T003D6_n1195OblLiqNro ;
   private String[] T003D6_A1169OblConCodigo ;
   private boolean[] T003D6_n1169OblConCodigo ;
   private short[] T003D6_A1163TipoOblSec ;
   private short[] T003D21_A1172OblSecuencial ;
   private int[] T003D21_A3CliCod ;
   private short[] T003D21_A1EmpCod ;
   private int[] T003D21_A6LegNumero ;
   private short[] T003D22_A1172OblSecuencial ;
   private int[] T003D22_A3CliCod ;
   private short[] T003D22_A1EmpCod ;
   private int[] T003D22_A6LegNumero ;
   private short[] T003D5_A1172OblSecuencial ;
   private String[] T003D5_A2345OblTipoMov ;
   private byte[] T003D5_A1173OblEstado ;
   private String[] T003D5_A1174OblObs ;
   private byte[] T003D5_A1175OblOriPer ;
   private java.math.BigDecimal[] T003D5_A1176OblTotal ;
   private short[] T003D5_A1177OblCanCuo ;
   private java.math.BigDecimal[] T003D5_A1178OblImpFij ;
   private java.math.BigDecimal[] T003D5_A1179OblPorc ;
   private boolean[] T003D5_A1181OblNoRemu ;
   private boolean[] T003D5_A1182OblDescu ;
   private boolean[] T003D5_A1196OblAntiRelaLiq ;
   private int[] T003D5_A3CliCod ;
   private String[] T003D5_A2343OblConcepto ;
   private short[] T003D5_A1EmpCod ;
   private int[] T003D5_A6LegNumero ;
   private int[] T003D5_A1195OblLiqNro ;
   private boolean[] T003D5_n1195OblLiqNro ;
   private String[] T003D5_A1169OblConCodigo ;
   private boolean[] T003D5_n1169OblConCodigo ;
   private short[] T003D5_A1163TipoOblSec ;
   private String[] T003D26_A250LegIdNomApe ;
   private String[] T003D26_A251LegNombre ;
   private String[] T003D26_A230LegApellido ;
   private String[] T003D26_A93LegId ;
   private boolean[] T003D26_n93LegId ;
   private String[] T003D27_A1165TipoOblDescrip ;
   private String[] T003D27_A1164TipoOblCodigo ;
   private byte[] T003D27_A1168TipoOblTotTipo ;
   private boolean[] T003D27_A2346TipoOblSoloDescu ;
   private short[] T003D27_A1161EmbargaSec ;
   private boolean[] T003D27_n1161EmbargaSec ;
   private int[] T003D28_A3CliCod ;
   private short[] T003D28_A1EmpCod ;
   private int[] T003D28_A6LegNumero ;
   private short[] T003D28_A1172OblSecuencial ;
   private int[] T003D28_A1184LiqOblAltaNro ;
   private int[] T003D28_A1185LiqOblNuevaNro ;
   private int[] T003D29_A3CliCod ;
   private short[] T003D29_A1EmpCod ;
   private int[] T003D29_A6LegNumero ;
   private short[] T003D29_A1172OblSecuencial ;
   private String[] T003D30_A1183OblExcTipo ;
   private int[] T003D30_A3CliCod ;
   private String[] T003D30_A1170OblExcConCOdigo ;
   private short[] T003D30_A1EmpCod ;
   private int[] T003D30_A6LegNumero ;
   private short[] T003D30_A1172OblSecuencial ;
   private int[] T003D4_A3CliCod ;
   private int[] T003D31_A3CliCod ;
   private int[] T003D32_A3CliCod ;
   private short[] T003D32_A1EmpCod ;
   private int[] T003D32_A6LegNumero ;
   private short[] T003D32_A1172OblSecuencial ;
   private String[] T003D32_A1170OblExcConCOdigo ;
   private String[] T003D3_A1183OblExcTipo ;
   private int[] T003D3_A3CliCod ;
   private String[] T003D3_A1170OblExcConCOdigo ;
   private short[] T003D3_A1EmpCod ;
   private int[] T003D3_A6LegNumero ;
   private short[] T003D3_A1172OblSecuencial ;
   private String[] T003D2_A1183OblExcTipo ;
   private int[] T003D2_A3CliCod ;
   private String[] T003D2_A1170OblExcConCOdigo ;
   private short[] T003D2_A1EmpCod ;
   private int[] T003D2_A6LegNumero ;
   private short[] T003D2_A1172OblSecuencial ;
   private int[] T003D36_A3CliCod ;
   private short[] T003D36_A1EmpCod ;
   private int[] T003D36_A6LegNumero ;
   private short[] T003D36_A1172OblSecuencial ;
   private String[] T003D36_A1170OblExcConCOdigo ;
   private int[] T003D37_A3CliCod ;
   private short[] T003D37_A1EmpCod ;
   private int[] T003D37_A6LegNumero ;
   private String[] T003D37_A250LegIdNomApe ;
   private byte[] T003D37_A1818LegEstado ;
   private short[] T003D38_A1163TipoOblSec ;
   private String[] T003D38_A1165TipoOblDescrip ;
   private short[] T003D38_A1159TipoOblPaiCod ;
   private int[] T003D39_A3CliCod ;
   private short[] T003D39_A1EmpCod ;
   private int[] T003D39_A6LegNumero ;
   private int[] T003D39_A31LiqNro ;
   private String[] T003D39_A874LiqNombre ;
   private int[] T003D40_A3CliCod ;
   private short[] T003D40_A1EmpCod ;
   private int[] T003D40_A31LiqNro ;
   private int[] T003D40_A6LegNumero ;
   private int[] T003D40_A81LiqDSecuencial ;
   private String[] T003D40_A394DConCodigo ;
   private String[] T003D40_A393DConDescrip ;
   private String[] T003D40_A468DSubTipoConCod1 ;
   private boolean[] T003D40_n468DSubTipoConCod1 ;
   private String[] T003D40_A464DTipoConCod ;
   private String[] T003D41_A250LegIdNomApe ;
   private String[] T003D41_A251LegNombre ;
   private String[] T003D41_A230LegApellido ;
   private String[] T003D41_A93LegId ;
   private boolean[] T003D41_n93LegId ;
   private String[] T003D42_A1165TipoOblDescrip ;
   private String[] T003D42_A1164TipoOblCodigo ;
   private byte[] T003D42_A1168TipoOblTotTipo ;
   private boolean[] T003D42_A2346TipoOblSoloDescu ;
   private short[] T003D42_A1161EmbargaSec ;
   private boolean[] T003D42_n1161EmbargaSec ;
   private int[] T003D43_A3CliCod ;
   private int[] T003D44_A31LiqNro ;
   private int[] T003D45_A3CliCod ;
   private int[] T003D46_A3CliCod ;
   private int[] T003D47_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV33ConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char10[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV34OblExcConCOdigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item8 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item9[] ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV18TrnContextAtt ;
}

final  class obligacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003D2", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?  FOR UPDATE OF ObligacionExcepciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D3", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D4", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D5", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?  FOR UPDATE OF Obligacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D6", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D7", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D8", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D9", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D10", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D11", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D12", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D13", "SELECT T2.LegIdNomApe, TM1.OblSecuencial, TM1.OblTipoMov, T3.TipoOblDescrip, T3.TipoOblCodigo, TM1.OblEstado, TM1.OblObs, TM1.OblOriPer, T3.TipoOblTotTipo, TM1.OblTotal, TM1.OblCanCuo, TM1.OblImpFij, TM1.OblPorc, TM1.OblNoRemu, TM1.OblDescu, TM1.OblAntiRelaLiq, T3.TipoOblSoloDescu, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.OblConcepto AS OblConcepto, TM1.EmpCod, TM1.LegNumero, TM1.OblLiqNro AS OblLiqNro, TM1.OblConCodigo AS OblConCodigo, TM1.TipoOblSec, T3.EmbargaSec FROM ((Obligacion TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = TM1.TipoOblSec) WHERE TM1.OblSecuencial = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.OblSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D14", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D15", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D16", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D17", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D18", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D19", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D20", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D21", "SELECT OblSecuencial, CliCod, EmpCod, LegNumero FROM Obligacion WHERE ( OblSecuencial > ? or OblSecuencial = ? and CliCod > ? or CliCod = ? and OblSecuencial = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and OblSecuencial = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003D22", "SELECT OblSecuencial, CliCod, EmpCod, LegNumero FROM Obligacion WHERE ( OblSecuencial < ? or OblSecuencial = ? and CliCod < ? or CliCod = ? and OblSecuencial = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and OblSecuencial = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, OblSecuencial DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003D23", "SAVEPOINT gxupdate;INSERT INTO Obligacion(OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003D24", "SAVEPOINT gxupdate;UPDATE Obligacion SET OblTipoMov=?, OblEstado=?, OblObs=?, OblOriPer=?, OblTotal=?, OblCanCuo=?, OblImpFij=?, OblPorc=?, OblNoRemu=?, OblDescu=?, OblAntiRelaLiq=?, OblConcepto=?, OblLiqNro=?, OblConCodigo=?, TipoOblSec=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003D25", "SAVEPOINT gxupdate;DELETE FROM Obligacion  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003D26", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D27", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D28", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003D29", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D30", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? and OblExcConCOdigo = ( ?) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D31", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D32", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T003D33", "SAVEPOINT gxupdate;INSERT INTO ObligacionExcepciones(OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003D34", "SAVEPOINT gxupdate;UPDATE ObligacionExcepciones SET OblExcTipo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003D35", "SAVEPOINT gxupdate;DELETE FROM ObligacionExcepciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003D36", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D37", "SELECT CliCod, EmpCod, LegNumero, LegIdNomApe, LegEstado FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) AND (LegEstado = 1) ORDER BY LegIdNomApe ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D38", "SELECT TipoOblSec, TipoOblDescrip, TipoOblPaiCod FROM tipo_obligacion WHERE TipoOblPaiCod = ? ORDER BY TipoOblDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D39", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro, T2.LiqNombre FROM (LiquidacionLegajo T1 LEFT JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ?) AND (T1.EmpCod = ?) AND (T1.LegNumero = ?) ORDER BY T2.LiqNombre ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D40", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial, DConCodigo, DConDescrip, DSubTipoConCod1, DTipoConCod FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (DTipoConCod >= ( ?)) AND (DTipoConCod <= ( ?)) AND (DSubTipoConCod1 = ( ?)) ORDER BY DConDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D41", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D42", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D43", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D44", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D45", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D46", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003D47", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,4);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getString(22, 10);
               ((short[]) buf[23])[0] = rslt.getShort(23);
               ((int[]) buf[24])[0] = rslt.getInt(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(27);
               ((short[]) buf[30])[0] = rslt.getShort(28);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 36 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 45 :
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 4);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setString(14, (String)parms[13], 10);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(17, ((Number) parms[17]).intValue());
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[19], 10);
               }
               stmt.setShort(19, ((Number) parms[20]).shortValue());
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setString(12, (String)parms[11], 10);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(13, ((Number) parms[13]).intValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 10);
               }
               stmt.setShort(15, ((Number) parms[16]).shortValue());
               stmt.setInt(16, ((Number) parms[17]).intValue());
               stmt.setShort(17, ((Number) parms[18]).shortValue());
               stmt.setInt(18, ((Number) parms[19]).intValue());
               stmt.setShort(19, ((Number) parms[20]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 31 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 36 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 40 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

