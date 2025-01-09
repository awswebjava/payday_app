package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class concepto_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SUBTIPOCONCOD1") == 0 )
      {
         A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlasubtipoconcod10A7( A37TipoConCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SUBTIPOCONCOD2") == 0 )
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
         gxdlasubtipoconcod20A7( A37TipoConCod, A38SubTipoConCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCUENDEBE") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV13EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaconcuendebe0A7( AV7CliCod, AV13EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCUENHABER") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV13EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaconcuenhaber0A7( AV7CliCod, AV13EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TLIQCOD") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlatliqcod0A8( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"CLICOD") == 0 )
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
         gx11asaclicod0A7( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel39"+"_"+"CONFCHMODFOR") == 0 )
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
         gx39asaconfchmodfor0A7( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel40"+"_"+"CONUSUMODFOR") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx40asaconusumodfor0A7( Gx_mode) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel52"+"_"+"CONOLDVALUES") == 0 )
      {
         A1797ConBaseLicProm = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseLicProm"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         A1621ConBaseFer = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseFer"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1798ConBaseFerProm = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseFerProm"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         A1622ConBaseHorExt = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseHorExt"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1799ConBaseHorExtProm = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseHorExtProm"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         A1800ConBasePres = (byte)(GXutil.lval( httpContext.GetPar( "ConBasePres"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         A1801ConBaseAnt = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseAnt"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         A1827ConBaseOSDif = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseOSDif"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         A2191ConBaseAus = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseAus"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         A2192ConBaseAusProm = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseAusProm"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         A41ConDescrip = httpContext.GetPar( "ConDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1620ConBaseLic = (byte)(GXutil.lval( httpContext.GetPar( "ConBaseLic"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx52asaconoldvalues0A7( A1797ConBaseLicProm, A1621ConBaseFer, A1798ConBaseFerProm, A1622ConBaseHorExt, A1799ConBaseHorExtProm, A1800ConBasePres, A1801ConBaseAnt, A1827ConBaseOSDif, A2191ConBaseAus, A2192ConBaseAusProm, A41ConDescrip, Gx_mode, A1620ConBaseLic) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_92") == 0 )
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
         gxload_92( A3CliCod, A1112AplIIGG) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_94") == 0 )
      {
         A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_94( A37TipoConCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_95") == 0 )
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
         gxload_95( A37TipoConCod, A38SubTipoConCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_96") == 0 )
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
         gxload_96( A37TipoConCod, A38SubTipoConCod1, A39SubTipoConCod2) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_93") == 0 )
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
         gxload_93( A1822CliPadre, A1112AplIIGG) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_99") == 0 )
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
         gxload_99( A1822CliPadre, A921ConPadre) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_97") == 0 )
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
         gxload_97( A953ConCondicion) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_98") == 0 )
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
         gxload_98( A1644ConceptoPais, A1645ConceptoConveCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_101") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = httpContext.GetPar( "TLiqCod") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_101( A3CliCod, A32TLiqCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_104") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_104( A3CliCod, A11MegCodigo) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_tipoliquidacion") == 0 )
      {
         gxnrgridlevel_tipoliquidacion_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
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
            AV11ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ConCodigo", AV11ConCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Concepto", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_tipoliquidacion_newrow_invoke( )
   {
      nRC_GXsfl_128 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_128"))) ;
      nGXsfl_128_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_128_idx"))) ;
      sGXsfl_128_idx = httpContext.GetPar( "sGXsfl_128_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV17permiteModificacion = GXutil.strtobool( httpContext.GetPar( "permiteModificacion")) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_tipoliquidacion_newrow( ) ;
      /* End function gxnrGridlevel_tipoliquidacion_newrow_invoke */
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_134 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_134"))) ;
      nGXsfl_134_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_134_idx"))) ;
      sGXsfl_134_idx = httpContext.GetPar( "sGXsfl_134_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public concepto_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public concepto_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( concepto_impl.class ));
   }

   public concepto_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynTipoConCod = new HTMLChoice();
      chkConVariable = UIFactory.getCheckbox(this);
      cmbConAplicGan = new HTMLChoice();
      dynSubTipoConCod1 = new HTMLChoice();
      dynSubTipoConCod2 = new HTMLChoice();
      chkConHabilitado = UIFactory.getCheckbox(this);
      chkConCanti = UIFactory.getCheckbox(this);
      chkConValUni = UIFactory.getCheckbox(this);
      chkConImporte = UIFactory.getCheckbox(this);
      cmbConVigencia = new HTMLChoice();
      chkConRecalcular = UIFactory.getCheckbox(this);
      cmbConPreReq = new HTMLChoice();
      cmbConAdelDescu = new HTMLChoice();
      dynConCuenDebe = new HTMLChoice();
      dynConCuenHaber = new HTMLChoice();
      dynTLiqCod = new HTMLChoice();
      chkConTLiqSinCausa = UIFactory.getCheckbox(this);
      chkConTLiqSinPre = UIFactory.getCheckbox(this);
      cmbMegPreaTipo = new HTMLChoice();
      cmbConMegDura = new HTMLChoice();
      chkavEssistemaconceptosdefault = UIFactory.getCheckbox(this);
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
      if ( dynTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = dynTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Values", dynTipoConCod.ToJavascriptSource(), true);
      }
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      if ( cmbConAplicGan.getItemCount() > 0 )
      {
         A735ConAplicGan = (byte)(GXutil.lval( cmbConAplicGan.getValidValue(GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0))))) ;
         n735ConAplicGan = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAplicGan.setValue( GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Values", cmbConAplicGan.ToJavascriptSource(), true);
      }
      if ( dynSubTipoConCod1.getItemCount() > 0 )
      {
         A38SubTipoConCod1 = dynSubTipoConCod1.getValidValue(A38SubTipoConCod1) ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
         httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Values", dynSubTipoConCod1.ToJavascriptSource(), true);
      }
      if ( dynSubTipoConCod2.getItemCount() > 0 )
      {
         A39SubTipoConCod2 = dynSubTipoConCod2.getValidValue(A39SubTipoConCod2) ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
         httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
      }
      A150ConHabilitado = GXutil.strtobool( GXutil.booltostr( A150ConHabilitado)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
      A143ConCanti = GXutil.strtobool( GXutil.booltostr( A143ConCanti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
      A158ConValUni = GXutil.strtobool( GXutil.booltostr( A158ConValUni)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
      A152ConImporte = GXutil.strtobool( GXutil.booltostr( A152ConImporte)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
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
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      if ( cmbConPreReq.getItemCount() > 0 )
      {
         A1066ConPreReq = cmbConPreReq.getValidValue(A1066ConPreReq) ;
         n1066ConPreReq = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConPreReq.setValue( GXutil.rtrim( A1066ConPreReq) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConPreReq.getInternalname(), "Values", cmbConPreReq.ToJavascriptSource(), true);
      }
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
      if ( dynConCuenDebe.getItemCount() > 0 )
      {
         A487ConCuenDebe = dynConCuenDebe.getValidValue(A487ConCuenDebe) ;
         n487ConCuenDebe = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A487ConCuenDebe", A487ConCuenDebe);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConCuenDebe.setValue( GXutil.rtrim( A487ConCuenDebe) );
         httpContext.ajax_rsp_assign_prop("", false, dynConCuenDebe.getInternalname(), "Values", dynConCuenDebe.ToJavascriptSource(), true);
      }
      if ( dynConCuenHaber.getItemCount() > 0 )
      {
         A488ConCuenHaber = dynConCuenHaber.getValidValue(A488ConCuenHaber) ;
         n488ConCuenHaber = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A488ConCuenHaber", A488ConCuenHaber);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConCuenHaber.setValue( GXutil.rtrim( A488ConCuenHaber) );
         httpContext.ajax_rsp_assign_prop("", false, dynConCuenHaber.getInternalname(), "Values", dynConCuenHaber.ToJavascriptSource(), true);
      }
      AV14esSistemaConceptosDefault = GXutil.strtobool( GXutil.booltostr( AV14esSistemaConceptosDefault)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14esSistemaConceptosDefault", AV14esSistemaConceptosDefault);
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
      web.GxWebStd.gx_div_start( httpContext, divConformula_cell_Internalname, 1, 0, "px", 0, "px", divConformula_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConFormula_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormula_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFormula_Internalname, httpContext.getMessage( "Fórmula", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConFormula_Internalname, A148ConFormula, "", "", (short)(0), edtConFormula_Visible, edtConFormula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipoConCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynTipoConCod.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipoConCod, dynTipoConCod.getInternalname(), GXutil.rtrim( A37TipoConCod), 1, dynTipoConCod.getJsonclick(), 7, "'"+""+"'"+",false,"+"'"+"e110a7_client"+"'", "char", "", 1, dynTipoConCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      dynTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Values", dynTipoConCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvariable_cell_Internalname, 1, 0, "px", 0, "px", divConvariable_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConVariable.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConVariable.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConVariable.getInternalname(), httpContext.getMessage( "Remuneración Variable", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConVariable.getInternalname(), GXutil.booltostr( A159ConVariable), "", httpContext.getMessage( "Remuneración Variable", ""), chkConVariable.getVisible(), chkConVariable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(32, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConaplicgan_cell_Internalname, 1, 0, "px", 0, "px", divConaplicgan_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", cmbConAplicGan.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAplicGan.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAplicGan.getInternalname(), httpContext.getMessage( "Sujeto a ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAplicGan, cmbConAplicGan.getInternalname(), GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)), 1, cmbConAplicGan.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbConAplicGan.getVisible(), cmbConAplicGan.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      cmbConAplicGan.setValue( GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Values", cmbConAplicGan.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSubTipoConCod1.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynSubTipoConCod1.getInternalname(), httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSubTipoConCod1, dynSubTipoConCod1.getInternalname(), GXutil.rtrim( A38SubTipoConCod1), 1, dynSubTipoConCod1.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynSubTipoConCod1.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Values", dynSubTipoConCod1.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSubTipoConCod2.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynSubTipoConCod2.getInternalname(), httpContext.getMessage( "Sub Clasif.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSubTipoConCod2, dynSubTipoConCod2.getInternalname(), GXutil.rtrim( A39SubTipoConCod2), 1, dynSubTipoConCod2.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynSubTipoConCod2.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", edtConCodigo_Invitemessage, edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConDescrip_Internalname, A41ConDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", (short)(0), 1, edtConDescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConHabilitado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConHabilitado.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConHabilitado.getInternalname(), GXutil.booltostr( A150ConHabilitado), "", httpContext.getMessage( "Habilitado", ""), 1, chkConHabilitado.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(62, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,62);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConcanti_cell_Internalname, 1, 0, "px", 0, "px", divConcanti_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConCanti.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConCanti.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConCanti.getInternalname(), httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConCanti.getInternalname(), GXutil.booltostr( A143ConCanti), "", httpContext.getMessage( "Cantidad", ""), chkConCanti.getVisible(), chkConCanti.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(67, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,67);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvaluni_cell_Internalname, 1, 0, "px", 0, "px", divConvaluni_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConValUni.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConValUni.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConValUni.getInternalname(), httpContext.getMessage( "Valor Unitario", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConValUni.getInternalname(), GXutil.booltostr( A158ConValUni), "", httpContext.getMessage( "Valor Unitario", ""), chkConValUni.getVisible(), chkConValUni.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(72, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,72);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConimporte_cell_Internalname, 1, 0, "px", 0, "px", divConimporte_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConImporte.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConImporte.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConImporte.getInternalname(), httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConImporte.getInternalname(), GXutil.booltostr( A152ConImporte), "", httpContext.getMessage( "Importe", ""), chkConImporte.getVisible(), chkConImporte.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(77, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,77);\"");
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
      web.GxWebStd.gx_label_element( httpContext, cmbConVigencia.getInternalname(), httpContext.getMessage( "Aplicación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConVigencia, cmbConVigencia.getInternalname(), GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)), 1, cmbConVigencia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConVigencia.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(0), "HLP_Concepto.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObservacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConObservacion_Internalname, httpContext.getMessage( "Observacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConObservacion_Internalname, A153ConObservacion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", (short)(0), 1, edtConObservacion_Enabled, 1, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Concepto.htm");
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
      web.GxWebStd.gx_label_element( httpContext, chkConRecalcular.getInternalname(), httpContext.getMessage( "Recalcular retroactivamente", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConRecalcular.getInternalname(), GXutil.booltostr( A762ConRecalcular), "", httpContext.getMessage( "Recalcular retroactivamente", ""), 1, chkConRecalcular.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(92, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,92);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConRangoCant_Internalname, A1018ConRangoCant, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", (short)(0), 1, edtConRangoCant_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConPreReq.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConPreReq.getInternalname(), httpContext.getMessage( "Prerequisito para cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConPreReq, cmbConPreReq.getInternalname(), GXutil.rtrim( A1066ConPreReq), 1, cmbConPreReq.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConPreReq.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      cmbConPreReq.setValue( GXutil.rtrim( A1066ConPreReq) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConPreReq.getInternalname(), "Values", cmbConPreReq.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAdelDescu, cmbConAdelDescu.getInternalname(), GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)), 1, cmbConAdelDescu.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConAdelDescu.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
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
      ucDvpanel_cuentas.setProperty("Width", Dvpanel_cuentas_Width);
      ucDvpanel_cuentas.setProperty("AutoWidth", Dvpanel_cuentas_Autowidth);
      ucDvpanel_cuentas.setProperty("AutoHeight", Dvpanel_cuentas_Autoheight);
      ucDvpanel_cuentas.setProperty("Cls", Dvpanel_cuentas_Cls);
      ucDvpanel_cuentas.setProperty("Title", Dvpanel_cuentas_Title);
      ucDvpanel_cuentas.setProperty("Collapsible", Dvpanel_cuentas_Collapsible);
      ucDvpanel_cuentas.setProperty("Collapsed", Dvpanel_cuentas_Collapsed);
      ucDvpanel_cuentas.setProperty("ShowCollapseIcon", Dvpanel_cuentas_Showcollapseicon);
      ucDvpanel_cuentas.setProperty("IconPosition", Dvpanel_cuentas_Iconposition);
      ucDvpanel_cuentas.setProperty("AutoScroll", Dvpanel_cuentas_Autoscroll);
      ucDvpanel_cuentas.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_cuentas_Internalname, "DVPANEL_CUENTASContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_CUENTASContainer"+"Cuentas"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCuentas_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConCuenDebe.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConCuenDebe.getInternalname(), httpContext.getMessage( "Cuenta Debe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConCuenDebe, dynConCuenDebe.getInternalname(), GXutil.rtrim( A487ConCuenDebe), 1, dynConCuenDebe.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConCuenDebe.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      dynConCuenDebe.setValue( GXutil.rtrim( A487ConCuenDebe) );
      httpContext.ajax_rsp_assign_prop("", false, dynConCuenDebe.getInternalname(), "Values", dynConCuenDebe.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConCuenHaber.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConCuenHaber.getInternalname(), httpContext.getMessage( "Cuenta Haber", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConCuenHaber, dynConCuenHaber.getInternalname(), GXutil.rtrim( A488ConCuenHaber), 1, dynConCuenHaber.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConCuenHaber.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,122);\"", "", true, (byte)(0), "HLP_Concepto.htm");
      dynConCuenHaber.setValue( GXutil.rtrim( A488ConCuenHaber) );
      httpContext.ajax_rsp_assign_prop("", false, dynConCuenHaber.getInternalname(), "Values", dynConCuenHaber.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol128( ) ;
      nGXsfl_128_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount8 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_8 = (short)(1) ;
            scanStart0A8( ) ;
            while ( RcdFound8 != 0 )
            {
               init_level_properties8( ) ;
               getByPrimaryKey0A8( ) ;
               addRow0A8( ) ;
               scanNext0A8( ) ;
            }
            scanEnd0A8( ) ;
            nBlankRcdCount8 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B41ConDescrip = A41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         B2192ConBaseAusProm = A2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         B2191ConBaseAus = A2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         B1827ConBaseOSDif = A1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         B1801ConBaseAnt = A1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         B1800ConBasePres = A1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         B1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         B1622ConBaseHorExt = A1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         B1798ConBaseFerProm = A1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         B1621ConBaseFer = A1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         B1797ConBaseLicProm = A1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         B1620ConBaseLic = A1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         B762ConRecalcular = A762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         B1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         standaloneNotModal0A8( ) ;
         standaloneModal0A8( ) ;
         sMode8 = Gx_mode ;
         while ( nGXsfl_128_idx < nRC_GXsfl_128 )
         {
            bGXsfl_128_Refreshing = true ;
            readRow0A8( ) ;
            dynTLiqCod.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQCOD_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
            chkConTLiqSinCausa.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONTLIQSINCAUSA_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinCausa.getInternalname(), "Enabled", GXutil.ltrimstr( chkConTLiqSinCausa.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
            chkConTLiqSinPre.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONTLIQSINPRE_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinPre.getInternalname(), "Enabled", GXutil.ltrimstr( chkConTLiqSinPre.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
            if ( ( nRcdExists_8 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0A8( ) ;
            }
            sendRow0A8( ) ;
            bGXsfl_128_Refreshing = false ;
         }
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A41ConDescrip = B41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A2192ConBaseAusProm = B2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         A2191ConBaseAus = B2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         A1827ConBaseOSDif = B1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         A1801ConBaseAnt = B1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         A1800ConBasePres = B1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         A1799ConBaseHorExtProm = B1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         A1622ConBaseHorExt = B1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1798ConBaseFerProm = B1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         A1621ConBaseFer = B1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1797ConBaseLicProm = B1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         A1620ConBaseLic = B1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A762ConRecalcular = B762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1112AplIIGG = B1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount8 = (short)(5) ;
         nRcdExists_8 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0A8( ) ;
            while ( RcdFound8 != 0 )
            {
               sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_1288( ) ;
               init_level_properties8( ) ;
               standaloneNotModal0A8( ) ;
               getByPrimaryKey0A8( ) ;
               standaloneModal0A8( ) ;
               addRow0A8( ) ;
               scanNext0A8( ) ;
            }
            scanEnd0A8( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode8 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_1288( ) ;
         initAll0A8( ) ;
         init_level_properties8( ) ;
         B41ConDescrip = A41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         B2192ConBaseAusProm = A2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         B2191ConBaseAus = A2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         B1827ConBaseOSDif = A1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         B1801ConBaseAnt = A1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         B1800ConBasePres = A1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         B1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         B1622ConBaseHorExt = A1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         B1798ConBaseFerProm = A1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         B1621ConBaseFer = A1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         B1797ConBaseLicProm = A1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         B1620ConBaseLic = A1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         B762ConRecalcular = A762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         B1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         nRcdExists_8 = (short)(0) ;
         nIsMod_8 = (short)(0) ;
         nRcdDeleted_8 = (short)(0) ;
         nBlankRcdCount8 = (short)(nBlankRcdUsr8+nBlankRcdCount8) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount8 > 0 )
         {
            standaloneNotModal0A8( ) ;
            standaloneModal0A8( ) ;
            addRow0A8( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = dynTLiqCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount8 = (short)(nBlankRcdCount8-1) ;
         }
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A41ConDescrip = B41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A2192ConBaseAusProm = B2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         A2191ConBaseAus = B2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         A1827ConBaseOSDif = B1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         A1801ConBaseAnt = B1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         A1800ConBasePres = B1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         A1799ConBaseHorExtProm = B1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         A1622ConBaseHorExt = B1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1798ConBaseFerProm = B1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         A1621ConBaseFer = B1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1797ConBaseLicProm = B1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         A1620ConBaseLic = B1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A762ConRecalcular = B762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1112AplIIGG = B1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_tipoliquidacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_tipoliquidacion", Gridlevel_tipoliquidacionContainer, subGridlevel_tipoliquidacion_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_tipoliquidacionContainerData", Gridlevel_tipoliquidacionContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_tipoliquidacionContainerData"+"V", Gridlevel_tipoliquidacionContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_tipoliquidacionContainerData"+"V"+"\" value='"+Gridlevel_tipoliquidacionContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol134( ) ;
      nGXsfl_134_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount261 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_261 = (short)(1) ;
            scanStart0A261( ) ;
            while ( RcdFound261 != 0 )
            {
               init_level_properties261( ) ;
               getByPrimaryKey0A261( ) ;
               addRow0A261( ) ;
               scanNext0A261( ) ;
            }
            scanEnd0A261( ) ;
            nBlankRcdCount261 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B41ConDescrip = A41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         B2192ConBaseAusProm = A2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         B2191ConBaseAus = A2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         B1827ConBaseOSDif = A1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         B1801ConBaseAnt = A1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         B1800ConBasePres = A1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         B1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         B1622ConBaseHorExt = A1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         B1798ConBaseFerProm = A1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         B1621ConBaseFer = A1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         B1797ConBaseLicProm = A1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         B1620ConBaseLic = A1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         B762ConRecalcular = A762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         B1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         standaloneNotModal0A261( ) ;
         standaloneModal0A261( ) ;
         sMode261 = Gx_mode ;
         while ( nGXsfl_134_idx < nRC_GXsfl_134 )
         {
            bGXsfl_134_Refreshing = true ;
            readRow0A261( ) ;
            edtMegCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MEGCODIGO_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), !bGXsfl_134_Refreshing);
            cmbMegPreaTipo.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGPREATIPO_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMegPreaTipo.getEnabled(), 5, 0), !bGXsfl_134_Refreshing);
            cmbConMegDura.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGDURA_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConMegDura.getEnabled(), 5, 0), !bGXsfl_134_Refreshing);
            edtConMegMeses_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGMESES_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConMegMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegMeses_Enabled), 5, 0), !bGXsfl_134_Refreshing);
            edtConMegSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGSEC_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConMegSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegSec_Enabled), 5, 0), !bGXsfl_134_Refreshing);
            if ( ( nRcdExists_261 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0A261( ) ;
            }
            sendRow0A261( ) ;
            bGXsfl_134_Refreshing = false ;
         }
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A41ConDescrip = B41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A2192ConBaseAusProm = B2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         A2191ConBaseAus = B2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         A1827ConBaseOSDif = B1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         A1801ConBaseAnt = B1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         A1800ConBasePres = B1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         A1799ConBaseHorExtProm = B1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         A1622ConBaseHorExt = B1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1798ConBaseFerProm = B1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         A1621ConBaseFer = B1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1797ConBaseLicProm = B1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         A1620ConBaseLic = B1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A762ConRecalcular = B762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1112AplIIGG = B1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount261 = (short)(5) ;
         nRcdExists_261 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0A261( ) ;
            while ( RcdFound261 != 0 )
            {
               sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_134261( ) ;
               init_level_properties261( ) ;
               standaloneNotModal0A261( ) ;
               getByPrimaryKey0A261( ) ;
               standaloneModal0A261( ) ;
               addRow0A261( ) ;
               scanNext0A261( ) ;
            }
            scanEnd0A261( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode261 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_134261( ) ;
         initAll0A261( ) ;
         init_level_properties261( ) ;
         B41ConDescrip = A41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         B2192ConBaseAusProm = A2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         B2191ConBaseAus = A2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         B1827ConBaseOSDif = A1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         B1801ConBaseAnt = A1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         B1800ConBasePres = A1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         B1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         B1622ConBaseHorExt = A1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         B1798ConBaseFerProm = A1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         B1621ConBaseFer = A1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         B1797ConBaseLicProm = A1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         B1620ConBaseLic = A1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         B762ConRecalcular = A762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         B1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         nRcdExists_261 = (short)(0) ;
         nIsMod_261 = (short)(0) ;
         nRcdDeleted_261 = (short)(0) ;
         nBlankRcdCount261 = (short)(nBlankRcdUsr261+nBlankRcdCount261) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount261 > 0 )
         {
            standaloneNotModal0A261( ) ;
            standaloneModal0A261( ) ;
            addRow0A261( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtMegCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount261 = (short)(nBlankRcdCount261-1) ;
         }
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A41ConDescrip = B41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A2192ConBaseAusProm = B2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         A2191ConBaseAus = B2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         A1827ConBaseOSDif = B1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         A1801ConBaseAnt = B1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         A1800ConBasePres = B1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         A1799ConBaseHorExtProm = B1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         A1622ConBaseHorExt = B1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1798ConBaseFerProm = B1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         A1621ConBaseFer = B1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1797ConBaseLicProm = B1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         A1620ConBaseLic = B1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A762ConRecalcular = B762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1112AplIIGG = B1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Concepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Concepto.htm");
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
      /* User Defined Control */
      ucCombo_megcodigo.setProperty("Caption", Combo_megcodigo_Caption);
      ucCombo_megcodigo.setProperty("Cls", Combo_megcodigo_Cls);
      ucCombo_megcodigo.setProperty("IsGridItem", Combo_megcodigo_Isgriditem);
      ucCombo_megcodigo.setProperty("HasDescription", Combo_megcodigo_Hasdescription);
      ucCombo_megcodigo.setProperty("DataListProc", Combo_megcodigo_Datalistproc);
      ucCombo_megcodigo.setProperty("EmptyItem", Combo_megcodigo_Emptyitem);
      ucCombo_megcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV12DDO_TitleSettingsIcons);
      ucCombo_megcodigo.setProperty("DropDownOptionsData", AV31MegCodigo_Data);
      ucCombo_megcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_megcodigo_Internalname, "COMBO_MEGCODIGOContainer");
      /* Check box */
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEssistemaconceptosdefault.getInternalname(), GXutil.booltostr( AV14esSistemaConceptosDefault), "", "", chkavEssistemaconceptosdefault.getVisible(), chkavEssistemaconceptosdefault.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConRetGanPropor_Internalname, GXutil.booltostr( A734ConRetGanPropor), GXutil.booltostr( A734ConRetGanPropor), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,157);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRetGanPropor_Jsonclick, 0, "Attribute", "", "", "", "", edtConRetGanPropor_Visible, edtConRetGanPropor_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_Concepto.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,158);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Concepto.htm");
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
      e120A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV12DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEGCODIGO_DATA"), AV31MegCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
            Z42ConCodYDesc = httpContext.cgiGet( "Z42ConCodYDesc") ;
            Z145ConFchModFor = localUtil.ctot( httpContext.cgiGet( "Z145ConFchModFor"), 0) ;
            n145ConFchModFor = (GXutil.dateCompare(GXutil.nullDate(), A145ConFchModFor) ? true : false) ;
            Z156ConUsuModFor = httpContext.cgiGet( "Z156ConUsuModFor") ;
            n156ConUsuModFor = ((GXutil.strcmp("", A156ConUsuModFor)==0) ? true : false) ;
            Z143ConCanti = GXutil.strtobool( httpContext.cgiGet( "Z143ConCanti")) ;
            Z158ConValUni = GXutil.strtobool( httpContext.cgiGet( "Z158ConValUni")) ;
            Z152ConImporte = GXutil.strtobool( httpContext.cgiGet( "Z152ConImporte")) ;
            Z159ConVariable = GXutil.strtobool( httpContext.cgiGet( "Z159ConVariable")) ;
            Z1905ConRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1905ConRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z41ConDescrip = httpContext.cgiGet( "Z41ConDescrip") ;
            Z150ConHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z150ConHabilitado")) ;
            Z40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "Z40ConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z162ConVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z162ConVigencia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1488ConLiqBasica"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z157ConValorGen = localUtil.ctond( httpContext.cgiGet( "Z157ConValorGen")) ;
            n157ConValorGen = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A157ConValorGen)==0) ? true : false) ;
            Z155ConTipoLiqGanancias = httpContext.cgiGet( "Z155ConTipoLiqGanancias") ;
            n155ConTipoLiqGanancias = ((GXutil.strcmp("", A155ConTipoLiqGanancias)==0) ? true : false) ;
            Z154ConTipo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z154ConTipo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z469ConCodOld = httpContext.cgiGet( "Z469ConCodOld") ;
            Z487ConCuenDebe = httpContext.cgiGet( "Z487ConCuenDebe") ;
            n487ConCuenDebe = ((GXutil.strcmp("", A487ConCuenDebe)==0) ? true : false) ;
            Z488ConCuenHaber = httpContext.cgiGet( "Z488ConCuenHaber") ;
            n488ConCuenHaber = ((GXutil.strcmp("", A488ConCuenHaber)==0) ? true : false) ;
            Z503ConTipoLiqAux = httpContext.cgiGet( "Z503ConTipoLiqAux") ;
            n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
            Z969ConConveAux = httpContext.cgiGet( "Z969ConConveAux") ;
            n969ConConveAux = ((GXutil.strcmp("", A969ConConveAux)==0) ? true : false) ;
            Z970ConClasifAux = httpContext.cgiGet( "Z970ConClasifAux") ;
            n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
            Z510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( "Z510ConOrdEjec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z734ConRetGanPropor = GXutil.strtobool( httpContext.cgiGet( "Z734ConRetGanPropor")) ;
            Z735ConAplicGan = (byte)(localUtil.ctol( httpContext.cgiGet( "Z735ConAplicGan"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n735ConAplicGan = ((0==A735ConAplicGan) ? true : false) ;
            Z762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( "Z762ConRecalcular")) ;
            Z894ConImportado = GXutil.strtobool( httpContext.cgiGet( "Z894ConImportado")) ;
            Z895ConTipoOrden = (short)(localUtil.ctol( httpContext.cgiGet( "Z895ConTipoOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1017ConEdiEnRec = GXutil.strtobool( httpContext.cgiGet( "Z1017ConEdiEnRec")) ;
            Z1018ConRangoCant = httpContext.cgiGet( "Z1018ConRangoCant") ;
            Z922ConUsado = GXutil.strtobool( httpContext.cgiGet( "Z922ConUsado")) ;
            Z951ConObliga = GXutil.strtobool( httpContext.cgiGet( "Z951ConObliga")) ;
            n951ConObliga = ((false==A951ConObliga) ? true : false) ;
            Z952ConObligaSiSac = GXutil.strtobool( httpContext.cgiGet( "Z952ConObligaSiSac")) ;
            n952ConObligaSiSac = ((false==A952ConObligaSiSac) ? true : false) ;
            Z954ConCondCodigo = httpContext.cgiGet( "Z954ConCondCodigo") ;
            Z1066ConPreReq = httpContext.cgiGet( "Z1066ConPreReq") ;
            n1066ConPreReq = ((GXutil.strcmp("", A1066ConPreReq)==0) ? true : false) ;
            Z1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( "Z1068ConMostrarPos")) ;
            Z1077ConAdelDescu = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1077ConAdelDescu"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1077ConAdelDescu = ((0==A1077ConAdelDescu) ? true : false) ;
            Z1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( "Z1194ConSegunPla")) ;
            Z1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1471ConNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            Z2191ConBaseAus = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2191ConBaseAus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2192ConBaseAusProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2192ConBaseAusProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1648ConCodAfip = httpContext.cgiGet( "Z1648ConCodAfip") ;
            Z1769ConCntPa = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1769ConCntPa"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "Z1821ConErrorSiCero")) ;
            Z1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "Z1826ConPueNov")) ;
            Z1886ConRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1886ConRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2013ConRelRef = httpContext.cgiGet( "Z2013ConRelRef") ;
            Z2185ConDescripSinAc = httpContext.cgiGet( "Z2185ConDescripSinAc") ;
            Z2187ConOblPalabra = httpContext.cgiGet( "Z2187ConOblPalabra") ;
            n2187ConOblPalabra = ((GXutil.strcmp("", A2187ConOblPalabra)==0) ? true : false) ;
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
            A145ConFchModFor = localUtil.ctot( httpContext.cgiGet( "Z145ConFchModFor"), 0) ;
            n145ConFchModFor = false ;
            n145ConFchModFor = (GXutil.dateCompare(GXutil.nullDate(), A145ConFchModFor) ? true : false) ;
            A156ConUsuModFor = httpContext.cgiGet( "Z156ConUsuModFor") ;
            n156ConUsuModFor = false ;
            n156ConUsuModFor = ((GXutil.strcmp("", A156ConUsuModFor)==0) ? true : false) ;
            A1905ConRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1905ConRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "Z40ConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1488ConLiqBasica"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A157ConValorGen = localUtil.ctond( httpContext.cgiGet( "Z157ConValorGen")) ;
            n157ConValorGen = false ;
            n157ConValorGen = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A157ConValorGen)==0) ? true : false) ;
            A155ConTipoLiqGanancias = httpContext.cgiGet( "Z155ConTipoLiqGanancias") ;
            n155ConTipoLiqGanancias = false ;
            n155ConTipoLiqGanancias = ((GXutil.strcmp("", A155ConTipoLiqGanancias)==0) ? true : false) ;
            A154ConTipo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z154ConTipo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A469ConCodOld = httpContext.cgiGet( "Z469ConCodOld") ;
            A503ConTipoLiqAux = httpContext.cgiGet( "Z503ConTipoLiqAux") ;
            n503ConTipoLiqAux = false ;
            n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
            A969ConConveAux = httpContext.cgiGet( "Z969ConConveAux") ;
            n969ConConveAux = false ;
            n969ConConveAux = ((GXutil.strcmp("", A969ConConveAux)==0) ? true : false) ;
            A970ConClasifAux = httpContext.cgiGet( "Z970ConClasifAux") ;
            n970ConClasifAux = false ;
            n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
            A510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( "Z510ConOrdEjec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A894ConImportado = GXutil.strtobool( httpContext.cgiGet( "Z894ConImportado")) ;
            A895ConTipoOrden = (short)(localUtil.ctol( httpContext.cgiGet( "Z895ConTipoOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1017ConEdiEnRec = GXutil.strtobool( httpContext.cgiGet( "Z1017ConEdiEnRec")) ;
            A922ConUsado = GXutil.strtobool( httpContext.cgiGet( "Z922ConUsado")) ;
            A951ConObliga = GXutil.strtobool( httpContext.cgiGet( "Z951ConObliga")) ;
            n951ConObliga = false ;
            n951ConObliga = ((false==A951ConObliga) ? true : false) ;
            A952ConObligaSiSac = GXutil.strtobool( httpContext.cgiGet( "Z952ConObligaSiSac")) ;
            n952ConObligaSiSac = false ;
            n952ConObligaSiSac = ((false==A952ConObligaSiSac) ? true : false) ;
            A954ConCondCodigo = httpContext.cgiGet( "Z954ConCondCodigo") ;
            A1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( "Z1068ConMostrarPos")) ;
            A1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( "Z1194ConSegunPla")) ;
            A1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1471ConNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1472ConSIPAApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1473ConSIPACont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1474ConINSSJyPApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1475ConINSSJyPCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1476ConObraSocApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1477ConObraSocCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1478ConFonSolRedApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1479ConFonSolRedCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1480ConRenateaApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1481ConRenateaCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1482ConAsigFamCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1483ConFonNacEmpCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1484ConLeyRieTrabCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1485ConRegDifApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1486ConRegEspApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1539ConSacDeven = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1539ConSacDeven"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1620ConBaseLic = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1620ConBaseLic"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1797ConBaseLicProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1621ConBaseFer = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1621ConBaseFer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1798ConBaseFerProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1622ConBaseHorExt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1622ConBaseHorExt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1799ConBaseHorExtProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1800ConBasePres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1801ConBaseAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1827ConBaseOSDif"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2191ConBaseAus = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2191ConBaseAus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2192ConBaseAusProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2192ConBaseAusProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1648ConCodAfip = httpContext.cgiGet( "Z1648ConCodAfip") ;
            A1769ConCntPa = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1769ConCntPa"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "Z1821ConErrorSiCero")) ;
            A1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "Z1826ConPueNov")) ;
            A1886ConRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1886ConRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2013ConRelRef = httpContext.cgiGet( "Z2013ConRelRef") ;
            A2185ConDescripSinAc = httpContext.cgiGet( "Z2185ConDescripSinAc") ;
            A2187ConOblPalabra = httpContext.cgiGet( "Z2187ConOblPalabra") ;
            n2187ConOblPalabra = false ;
            n2187ConOblPalabra = ((GXutil.strcmp("", A2187ConOblPalabra)==0) ? true : false) ;
            A1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "Z1822CliPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = false ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "Z1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1112AplIIGG = false ;
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            A953ConCondicion = httpContext.cgiGet( "Z953ConCondicion") ;
            n953ConCondicion = false ;
            n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
            A1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "Z1644ConceptoPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1644ConceptoPais = false ;
            n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
            A1645ConceptoConveCodigo = httpContext.cgiGet( "Z1645ConceptoConveCodigo") ;
            n1645ConceptoConveCodigo = false ;
            n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
            A921ConPadre = httpContext.cgiGet( "Z921ConPadre") ;
            n921ConPadre = false ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            O41ConDescrip = httpContext.cgiGet( "O41ConDescrip") ;
            O2192ConBaseAusProm = (byte)(localUtil.ctol( httpContext.cgiGet( "O2192ConBaseAusProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O2191ConBaseAus = (byte)(localUtil.ctol( httpContext.cgiGet( "O2191ConBaseAus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "O1827ConBaseOSDif"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "O1801ConBaseAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "O1800ConBasePres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "O1799ConBaseHorExtProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1622ConBaseHorExt = (byte)(localUtil.ctol( httpContext.cgiGet( "O1622ConBaseHorExt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "O1798ConBaseFerProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1621ConBaseFer = (byte)(localUtil.ctol( httpContext.cgiGet( "O1621ConBaseFer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "O1797ConBaseLicProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1620ConBaseLic = (byte)(localUtil.ctol( httpContext.cgiGet( "O1620ConBaseLic"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( "O762ConRecalcular")) ;
            O1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "O1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_128 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_128"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_134 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_134"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            N762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( "N762ConRecalcular")) ;
            N41ConDescrip = httpContext.cgiGet( "N41ConDescrip") ;
            N40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "N40ConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N162ConVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( "N162ConVigencia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N157ConValorGen = localUtil.ctond( httpContext.cgiGet( "N157ConValorGen")) ;
            n157ConValorGen = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A157ConValorGen)==0) ? true : false) ;
            N155ConTipoLiqGanancias = httpContext.cgiGet( "N155ConTipoLiqGanancias") ;
            n155ConTipoLiqGanancias = ((GXutil.strcmp("", A155ConTipoLiqGanancias)==0) ? true : false) ;
            N153ConObservacion = httpContext.cgiGet( "N153ConObservacion") ;
            N159ConVariable = GXutil.strtobool( httpContext.cgiGet( "N159ConVariable")) ;
            N735ConAplicGan = (byte)(localUtil.ctol( httpContext.cgiGet( "N735ConAplicGan"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n735ConAplicGan = ((0==A735ConAplicGan) ? true : false) ;
            AV27defaultConCodigo = httpContext.cgiGet( "vDEFAULTCONCODIGO") ;
            A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
            A149ConFormulaAbr = httpContext.cgiGet( "CONFORMULAABR") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11ConCodigo = httpContext.cgiGet( "vCONCODIGO") ;
            AV23Insert_TipoConCod = httpContext.cgiGet( "vINSERT_TIPOCONCOD") ;
            AV17permiteModificacion = GXutil.strtobool( httpContext.cgiGet( "vPERMITEMODIFICACION")) ;
            AV24Insert_SubTipoConCod1 = httpContext.cgiGet( "vINSERT_SUBTIPOCONCOD1") ;
            AV25Insert_SubTipoConCod2 = httpContext.cgiGet( "vINSERT_SUBTIPOCONCOD2") ;
            AV34Insert_ConCondicion = httpContext.cgiGet( "vINSERT_CONCONDICION") ;
            A953ConCondicion = httpContext.cgiGet( "CONCONDICION") ;
            n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
            AV30Insert_AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_APLIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "APLIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            AV32Insert_ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CONCEPTOPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "CONCEPTOPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
            AV33Insert_ConceptoConveCodigo = httpContext.cgiGet( "vINSERT_CONCEPTOCONVECODIGO") ;
            A1645ConceptoConveCodigo = httpContext.cgiGet( "CONCEPTOCONVECODIGO") ;
            n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
            AV35Insert_CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLIPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "CLIPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            AV29Insert_ConPadre = httpContext.cgiGet( "vINSERT_CONPADRE") ;
            A921ConPadre = httpContext.cgiGet( "CONPADRE") ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            A145ConFchModFor = localUtil.ctot( httpContext.cgiGet( "CONFCHMODFOR"), 0) ;
            n145ConFchModFor = (GXutil.dateCompare(GXutil.nullDate(), A145ConFchModFor) ? true : false) ;
            A156ConUsuModFor = httpContext.cgiGet( "CONUSUMODFOR") ;
            n156ConUsuModFor = ((GXutil.strcmp("", A156ConUsuModFor)==0) ? true : false) ;
            A1905ConRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "CONRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1620ConBaseLic = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASELIC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASELICPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1621ConBaseFer = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEFER"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEFERPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1622ConBaseHorExt = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEHOREXT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEHOREXTPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEPRES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEANT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEOSDIF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2191ConBaseAus = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEAUS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2192ConBaseAusProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEAUSPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1974ConOldValues = httpContext.cgiGet( "CONOLDVALUES") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A155ConTipoLiqGanancias = httpContext.cgiGet( "CONTIPOLIQGANANCIAS") ;
            n155ConTipoLiqGanancias = ((GXutil.strcmp("", A155ConTipoLiqGanancias)==0) ? true : false) ;
            AV13EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "CONORDEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( "CONLIQBASICA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A729ConFormulaPreResuelta = httpContext.cgiGet( "CONFORMULAPRERESUELTA") ;
            A157ConValorGen = localUtil.ctond( httpContext.cgiGet( "CONVALORGEN")) ;
            n157ConValorGen = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A157ConValorGen)==0) ? true : false) ;
            A151ConHisFormula = httpContext.cgiGet( "CONHISFORMULA") ;
            n151ConHisFormula = false ;
            n151ConHisFormula = ((GXutil.strcmp("", A151ConHisFormula)==0) ? true : false) ;
            A154ConTipo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONTIPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A469ConCodOld = httpContext.cgiGet( "CONCODOLD") ;
            A503ConTipoLiqAux = httpContext.cgiGet( "CONTIPOLIQAUX") ;
            n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
            A969ConConveAux = httpContext.cgiGet( "CONCONVEAUX") ;
            n969ConConveAux = ((GXutil.strcmp("", A969ConConveAux)==0) ? true : false) ;
            A970ConClasifAux = httpContext.cgiGet( "CONCLASIFAUX") ;
            n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
            A510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( "CONORDEJEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A569ConFormulaExpl = httpContext.cgiGet( "CONFORMULAEXPL") ;
            A720ConFormulaObs2 = httpContext.cgiGet( "CONFORMULAOBS2") ;
            A894ConImportado = GXutil.strtobool( httpContext.cgiGet( "CONIMPORTADO")) ;
            A895ConTipoOrden = (short)(localUtil.ctol( httpContext.cgiGet( "CONTIPOORDEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1017ConEdiEnRec = GXutil.strtobool( httpContext.cgiGet( "CONEDIENREC")) ;
            A922ConUsado = GXutil.strtobool( httpContext.cgiGet( "CONUSADO")) ;
            A951ConObliga = GXutil.strtobool( httpContext.cgiGet( "CONOBLIGA")) ;
            n951ConObliga = ((false==A951ConObliga) ? true : false) ;
            A952ConObligaSiSac = GXutil.strtobool( httpContext.cgiGet( "CONOBLIGASISAC")) ;
            n952ConObligaSiSac = ((false==A952ConObligaSiSac) ? true : false) ;
            A954ConCondCodigo = httpContext.cgiGet( "CONCONDCODIGO") ;
            A1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( "CONMOSTRARPOS")) ;
            A1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( "CONSEGUNPLA")) ;
            A1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( "CONNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONSIPAAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONSIPACONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONINSSJYPAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONINSSJYPCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONOBRASOCAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONOBRASOCCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONFONSOLREDAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONFONSOLREDCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONRENATEAAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONRENATEACONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONASIGFAMCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONFONNACEMPCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( "CONLEYRIETRABCONT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONREGDIFAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( "CONREGESPAPO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1539ConSacDeven = (byte)(localUtil.ctol( httpContext.cgiGet( "CONSACDEVEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1648ConCodAfip = httpContext.cgiGet( "CONCODAFIP") ;
            A1769ConCntPa = (byte)(localUtil.ctol( httpContext.cgiGet( "CONCNTPA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "CONERRORSICERO")) ;
            A1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "CONPUENOV")) ;
            A1886ConRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "CONRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2013ConRelRef = httpContext.cgiGet( "CONRELREF") ;
            A2185ConDescripSinAc = httpContext.cgiGet( "CONDESCRIPSINAC") ;
            A2187ConOblPalabra = httpContext.cgiGet( "CONOBLPALABRA") ;
            n2187ConOblPalabra = ((GXutil.strcmp("", A2187ConOblPalabra)==0) ? true : false) ;
            AV37Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A950ConTLTipEgr = httpContext.cgiGet( "CONTLTIPEGR") ;
            A1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( "CONTLORDEJEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A1407ConTLConOrd = (short)(localUtil.ctol( httpContext.cgiGet( "CONTLCONORD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1409ConTLVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( "CONTLVIGENCIA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1409ConTLVigencia = false ;
            n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
            A1410ConTLCondicion = httpContext.cgiGet( "CONTLCONDICION") ;
            n1410ConTLCondicion = false ;
            n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
            A1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( "CONTLCONHAB"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1788ConTLTipoCon = httpContext.cgiGet( "CONTLTIPOCON") ;
            n1788ConTLTipoCon = false ;
            n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
            A1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( "CONTLSEGPLA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1789CONTLSegPla = false ;
            n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
            A340TliqDesc = httpContext.cgiGet( "TLIQDESC") ;
            A1529ConMegPropor = localUtil.ctond( httpContext.cgiGet( "CONMEGPROPOR")) ;
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
            Dvpanel_cuentas_Objectcall = httpContext.cgiGet( "DVPANEL_CUENTAS_Objectcall") ;
            Dvpanel_cuentas_Class = httpContext.cgiGet( "DVPANEL_CUENTAS_Class") ;
            Dvpanel_cuentas_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Enabled")) ;
            Dvpanel_cuentas_Width = httpContext.cgiGet( "DVPANEL_CUENTAS_Width") ;
            Dvpanel_cuentas_Height = httpContext.cgiGet( "DVPANEL_CUENTAS_Height") ;
            Dvpanel_cuentas_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Autowidth")) ;
            Dvpanel_cuentas_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Autoheight")) ;
            Dvpanel_cuentas_Cls = httpContext.cgiGet( "DVPANEL_CUENTAS_Cls") ;
            Dvpanel_cuentas_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Showheader")) ;
            Dvpanel_cuentas_Title = httpContext.cgiGet( "DVPANEL_CUENTAS_Title") ;
            Dvpanel_cuentas_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Collapsible")) ;
            Dvpanel_cuentas_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Collapsed")) ;
            Dvpanel_cuentas_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Showcollapseicon")) ;
            Dvpanel_cuentas_Iconposition = httpContext.cgiGet( "DVPANEL_CUENTAS_Iconposition") ;
            Dvpanel_cuentas_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Autoscroll")) ;
            Dvpanel_cuentas_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_CUENTAS_Visible")) ;
            Dvpanel_cuentas_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_CUENTAS_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_megcodigo_Objectcall = httpContext.cgiGet( "COMBO_MEGCODIGO_Objectcall") ;
            Combo_megcodigo_Class = httpContext.cgiGet( "COMBO_MEGCODIGO_Class") ;
            Combo_megcodigo_Icontype = httpContext.cgiGet( "COMBO_MEGCODIGO_Icontype") ;
            Combo_megcodigo_Icon = httpContext.cgiGet( "COMBO_MEGCODIGO_Icon") ;
            Combo_megcodigo_Caption = httpContext.cgiGet( "COMBO_MEGCODIGO_Caption") ;
            Combo_megcodigo_Tooltip = httpContext.cgiGet( "COMBO_MEGCODIGO_Tooltip") ;
            Combo_megcodigo_Cls = httpContext.cgiGet( "COMBO_MEGCODIGO_Cls") ;
            Combo_megcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_set") ;
            Combo_megcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_get") ;
            Combo_megcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_set") ;
            Combo_megcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_get") ;
            Combo_megcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_MEGCODIGO_Gamoauthtoken") ;
            Combo_megcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_MEGCODIGO_Ddointernalname") ;
            Combo_megcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolalign") ;
            Combo_megcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MEGCODIGO_Dropdownoptionstype") ;
            Combo_megcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Enabled")) ;
            Combo_megcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Visible")) ;
            Combo_megcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolidtoreplace") ;
            Combo_megcodigo_Datalisttype = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalisttype") ;
            Combo_megcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Allowmultipleselection")) ;
            Combo_megcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistfixedvalues") ;
            Combo_megcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Isgriditem")) ;
            Combo_megcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Hasdescription")) ;
            Combo_megcodigo_Datalistproc = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistproc") ;
            Combo_megcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistprocparametersprefix") ;
            Combo_megcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MEGCODIGO_Remoteservicesparameters") ;
            Combo_megcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_megcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeonlyselectedoption")) ;
            Combo_megcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeselectalloption")) ;
            Combo_megcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitem")) ;
            Combo_megcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeaddnewoption")) ;
            Combo_megcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_MEGCODIGO_Htmltemplate") ;
            Combo_megcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluestype") ;
            Combo_megcodigo_Loadingdata = httpContext.cgiGet( "COMBO_MEGCODIGO_Loadingdata") ;
            Combo_megcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_MEGCODIGO_Noresultsfound") ;
            Combo_megcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitemtext") ;
            Combo_megcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Onlyselectedvalues") ;
            Combo_megcodigo_Selectalltext = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectalltext") ;
            Combo_megcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluesseparator") ;
            Combo_megcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_MEGCODIGO_Addnewoptiontext") ;
            Combo_megcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
            n148ConFormula = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
            dynTipoConCod.setName( dynTipoConCod.getInternalname() );
            dynTipoConCod.setValue( httpContext.cgiGet( dynTipoConCod.getInternalname()) );
            A37TipoConCod = httpContext.cgiGet( dynTipoConCod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
            A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
            cmbConAplicGan.setName( cmbConAplicGan.getInternalname() );
            cmbConAplicGan.setValue( httpContext.cgiGet( cmbConAplicGan.getInternalname()) );
            A735ConAplicGan = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAplicGan.getInternalname()))) ;
            n735ConAplicGan = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
            n735ConAplicGan = ((0==A735ConAplicGan) ? true : false) ;
            dynSubTipoConCod1.setName( dynSubTipoConCod1.getInternalname() );
            dynSubTipoConCod1.setValue( httpContext.cgiGet( dynSubTipoConCod1.getInternalname()) );
            A38SubTipoConCod1 = httpContext.cgiGet( dynSubTipoConCod1.getInternalname()) ;
            n38SubTipoConCod1 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
            n38SubTipoConCod1 = ((GXutil.strcmp("", A38SubTipoConCod1)==0) ? true : false) ;
            dynSubTipoConCod2.setName( dynSubTipoConCod2.getInternalname() );
            dynSubTipoConCod2.setValue( httpContext.cgiGet( dynSubTipoConCod2.getInternalname()) );
            A39SubTipoConCod2 = httpContext.cgiGet( dynSubTipoConCod2.getInternalname()) ;
            n39SubTipoConCod2 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
            n39SubTipoConCod2 = ((GXutil.strcmp("", A39SubTipoConCod2)==0) ? true : false) ;
            A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
            A150ConHabilitado = GXutil.strtobool( httpContext.cgiGet( chkConHabilitado.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
            A143ConCanti = GXutil.strtobool( httpContext.cgiGet( chkConCanti.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
            A158ConValUni = GXutil.strtobool( httpContext.cgiGet( chkConValUni.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
            A152ConImporte = GXutil.strtobool( httpContext.cgiGet( chkConImporte.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
            cmbConVigencia.setName( cmbConVigencia.getInternalname() );
            cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
            A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
            A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
            A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
            A1018ConRangoCant = httpContext.cgiGet( edtConRangoCant_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
            cmbConPreReq.setName( cmbConPreReq.getInternalname() );
            cmbConPreReq.setValue( httpContext.cgiGet( cmbConPreReq.getInternalname()) );
            A1066ConPreReq = httpContext.cgiGet( cmbConPreReq.getInternalname()) ;
            n1066ConPreReq = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
            n1066ConPreReq = ((GXutil.strcmp("", A1066ConPreReq)==0) ? true : false) ;
            cmbConAdelDescu.setName( cmbConAdelDescu.getInternalname() );
            cmbConAdelDescu.setValue( httpContext.cgiGet( cmbConAdelDescu.getInternalname()) );
            A1077ConAdelDescu = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAdelDescu.getInternalname()))) ;
            n1077ConAdelDescu = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
            n1077ConAdelDescu = ((0==A1077ConAdelDescu) ? true : false) ;
            dynConCuenDebe.setName( dynConCuenDebe.getInternalname() );
            dynConCuenDebe.setValue( httpContext.cgiGet( dynConCuenDebe.getInternalname()) );
            A487ConCuenDebe = httpContext.cgiGet( dynConCuenDebe.getInternalname()) ;
            n487ConCuenDebe = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A487ConCuenDebe", A487ConCuenDebe);
            n487ConCuenDebe = ((GXutil.strcmp("", A487ConCuenDebe)==0) ? true : false) ;
            dynConCuenHaber.setName( dynConCuenHaber.getInternalname() );
            dynConCuenHaber.setValue( httpContext.cgiGet( dynConCuenHaber.getInternalname()) );
            A488ConCuenHaber = httpContext.cgiGet( dynConCuenHaber.getInternalname()) ;
            n488ConCuenHaber = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A488ConCuenHaber", A488ConCuenHaber);
            n488ConCuenHaber = ((GXutil.strcmp("", A488ConCuenHaber)==0) ? true : false) ;
            AV14esSistemaConceptosDefault = GXutil.strtobool( httpContext.cgiGet( chkavEssistemaconceptosdefault.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14esSistemaConceptosDefault", AV14esSistemaConceptosDefault);
            A734ConRetGanPropor = GXutil.strtobool( httpContext.cgiGet( edtConRetGanPropor_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A734ConRetGanPropor", A734ConRetGanPropor);
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Concepto");
            A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
            n148ConFormula = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
            forbiddenHiddens.add("ConFormula", A148ConFormula);
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1905ConRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("ConFormulaAbr", GXutil.rtrim( localUtil.format( A149ConFormulaAbr, "")));
            forbiddenHiddens.add("ConLiqBasica", localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9"));
            forbiddenHiddens.add("ConTipo", localUtil.format( DecimalUtil.doubleToDec(A154ConTipo), "9"));
            forbiddenHiddens.add("ConCodOld", GXutil.rtrim( localUtil.format( A469ConCodOld, "")));
            forbiddenHiddens.add("ConTipoLiqAux", GXutil.rtrim( localUtil.format( A503ConTipoLiqAux, "")));
            forbiddenHiddens.add("ConConveAux", GXutil.rtrim( localUtil.format( A969ConConveAux, "")));
            forbiddenHiddens.add("ConClasifAux", GXutil.rtrim( localUtil.format( A970ConClasifAux, "")));
            forbiddenHiddens.add("ConOrdEjec", localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9"));
            forbiddenHiddens.add("ConImportado", GXutil.booltostr( A894ConImportado));
            forbiddenHiddens.add("ConTipoOrden", localUtil.format( DecimalUtil.doubleToDec(A895ConTipoOrden), "ZZZ9"));
            forbiddenHiddens.add("ConEdiEnRec", GXutil.booltostr( A1017ConEdiEnRec));
            forbiddenHiddens.add("ConUsado", GXutil.booltostr( A922ConUsado));
            forbiddenHiddens.add("ConObliga", GXutil.booltostr( A951ConObliga));
            forbiddenHiddens.add("ConObligaSiSac", GXutil.booltostr( A952ConObligaSiSac));
            forbiddenHiddens.add("ConCondCodigo", GXutil.rtrim( localUtil.format( A954ConCondCodigo, "")));
            forbiddenHiddens.add("ConMostrarPos", GXutil.booltostr( A1068ConMostrarPos));
            forbiddenHiddens.add("ConSegunPla", GXutil.booltostr( A1194ConSegunPla));
            forbiddenHiddens.add("ConNumero", localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9"));
            forbiddenHiddens.add("ConSIPAApo", localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9"));
            forbiddenHiddens.add("ConSIPACont", localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9"));
            forbiddenHiddens.add("ConINSSJyPApo", localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9"));
            forbiddenHiddens.add("ConINSSJyPCont", localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9"));
            forbiddenHiddens.add("ConObraSocApo", localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9"));
            forbiddenHiddens.add("ConObraSocCont", localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9"));
            forbiddenHiddens.add("ConFonSolRedApo", localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9"));
            forbiddenHiddens.add("ConFonSolRedCont", localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9"));
            forbiddenHiddens.add("ConRenateaApo", localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9"));
            forbiddenHiddens.add("ConRenateaCont", localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9"));
            forbiddenHiddens.add("ConAsigFamCont", localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9"));
            forbiddenHiddens.add("ConFonNacEmpCont", localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9"));
            forbiddenHiddens.add("ConLeyRieTrabCont", localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9"));
            forbiddenHiddens.add("ConRegDifApo", localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9"));
            forbiddenHiddens.add("ConRegEspApo", localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9"));
            forbiddenHiddens.add("ConSacDeven", localUtil.format( DecimalUtil.doubleToDec(A1539ConSacDeven), "Z9"));
            forbiddenHiddens.add("ConBaseLic", localUtil.format( DecimalUtil.doubleToDec(A1620ConBaseLic), "9"));
            forbiddenHiddens.add("ConBaseLicProm", localUtil.format( DecimalUtil.doubleToDec(A1797ConBaseLicProm), "9"));
            forbiddenHiddens.add("ConBaseFer", localUtil.format( DecimalUtil.doubleToDec(A1621ConBaseFer), "9"));
            forbiddenHiddens.add("ConBaseFerProm", localUtil.format( DecimalUtil.doubleToDec(A1798ConBaseFerProm), "9"));
            forbiddenHiddens.add("ConBaseHorExt", localUtil.format( DecimalUtil.doubleToDec(A1622ConBaseHorExt), "9"));
            forbiddenHiddens.add("ConBaseHorExtProm", localUtil.format( DecimalUtil.doubleToDec(A1799ConBaseHorExtProm), "9"));
            forbiddenHiddens.add("ConBasePres", localUtil.format( DecimalUtil.doubleToDec(A1800ConBasePres), "9"));
            forbiddenHiddens.add("ConBaseAnt", localUtil.format( DecimalUtil.doubleToDec(A1801ConBaseAnt), "9"));
            forbiddenHiddens.add("ConBaseOSDif", localUtil.format( DecimalUtil.doubleToDec(A1827ConBaseOSDif), "9"));
            forbiddenHiddens.add("ConBaseAus", localUtil.format( DecimalUtil.doubleToDec(A2191ConBaseAus), "9"));
            forbiddenHiddens.add("ConBaseAusProm", localUtil.format( DecimalUtil.doubleToDec(A2192ConBaseAusProm), "9"));
            forbiddenHiddens.add("ConCodAfip", GXutil.rtrim( localUtil.format( A1648ConCodAfip, "")));
            forbiddenHiddens.add("ConCntPa", localUtil.format( DecimalUtil.doubleToDec(A1769ConCntPa), "Z9"));
            forbiddenHiddens.add("ConErrorSiCero", GXutil.booltostr( A1821ConErrorSiCero));
            forbiddenHiddens.add("ConPueNov", GXutil.booltostr( A1826ConPueNov));
            forbiddenHiddens.add("ConRelSec", localUtil.format( DecimalUtil.doubleToDec(A1886ConRelSec), "ZZZZZ9"));
            forbiddenHiddens.add("ConRelRef", GXutil.rtrim( localUtil.format( A2013ConRelRef, "")));
            forbiddenHiddens.add("ConDescripSinAc", GXutil.rtrim( localUtil.format( A2185ConDescripSinAc, "")));
            forbiddenHiddens.add("ConOblPalabra", GXutil.rtrim( localUtil.format( A2187ConOblPalabra, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("concepto:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
                        confirm_0A0( ) ;
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
                        e120A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e130A2 ();
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
         e130A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0A7( ) ;
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
         disableAttributes0A7( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, chkavEssistemaconceptosdefault.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getEnabled(), 5, 0), true);
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

   public void confirm_0A0( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0A7( ) ;
         }
         else
         {
            checkExtendedTable0A7( ) ;
            closeExtendedTableCursors0A7( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode7 = Gx_mode ;
         confirm_0A8( ) ;
         if ( AnyError == 0 )
         {
            confirm_0A261( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode7 ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               IsConfirmed = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0A261( )
   {
      nGXsfl_134_idx = 0 ;
      while ( nGXsfl_134_idx < nRC_GXsfl_134 )
      {
         readRow0A261( ) ;
         if ( ( nRcdExists_261 != 0 ) || ( nIsMod_261 != 0 ) )
         {
            getKey0A261( ) ;
            if ( ( nRcdExists_261 == 0 ) && ( nRcdDeleted_261 == 0 ) )
            {
               if ( RcdFound261 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0A261( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0A261( ) ;
                     closeExtendedTableCursors0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "MEGCODIGO_" + sGXsfl_134_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtMegCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound261 != 0 )
               {
                  if ( nRcdDeleted_261 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0A261( ) ;
                     load0A261( ) ;
                     beforeValidate0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0A261( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_261 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0A261( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0A261( ) ;
                           closeExtendedTableCursors0A261( ) ;
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
                  if ( nRcdDeleted_261 == 0 )
                  {
                     GXCCtl = "MEGCODIGO_" + sGXsfl_134_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMegCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMegCodigo_Internalname, GXutil.rtrim( A11MegCodigo)) ;
         httpContext.changePostValue( cmbMegPreaTipo.getInternalname(), GXutil.rtrim( A1532MegPreaTipo)) ;
         httpContext.changePostValue( cmbConMegDura.getInternalname(), GXutil.rtrim( A1534ConMegDura)) ;
         httpContext.changePostValue( edtConMegMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConMegSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z11MegCodigo_"+sGXsfl_134_idx, GXutil.rtrim( Z11MegCodigo)) ;
         httpContext.changePostValue( "ZT_"+"Z2077ConMegSec_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1532MegPreaTipo_"+sGXsfl_134_idx, GXutil.rtrim( Z1532MegPreaTipo)) ;
         httpContext.changePostValue( "ZT_"+"Z1530ConMegMeses_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1534ConMegDura_"+sGXsfl_134_idx, GXutil.rtrim( Z1534ConMegDura)) ;
         httpContext.changePostValue( "ZT_"+"Z1529ConMegPropor_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_261 != 0 )
         {
            httpContext.changePostValue( "MEGCODIGO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGPREATIPO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbMegPreaTipo.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGDURA_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbConMegDura.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGMESES_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegMeses_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGSEC_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0A8( )
   {
      nGXsfl_128_idx = 0 ;
      while ( nGXsfl_128_idx < nRC_GXsfl_128 )
      {
         readRow0A8( ) ;
         if ( ( nRcdExists_8 != 0 ) || ( nIsMod_8 != 0 ) )
         {
            getKey0A8( ) ;
            if ( ( nRcdExists_8 == 0 ) && ( nRcdDeleted_8 == 0 ) )
            {
               if ( RcdFound8 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0A8( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0A8( ) ;
                     closeExtendedTableCursors0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = dynTLiqCod.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound8 != 0 )
               {
                  if ( nRcdDeleted_8 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0A8( ) ;
                     load0A8( ) ;
                     beforeValidate0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0A8( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_8 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0A8( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0A8( ) ;
                           closeExtendedTableCursors0A8( ) ;
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
                  if ( nRcdDeleted_8 == 0 )
                  {
                     GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = dynTLiqCod.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( dynTLiqCod.getInternalname(), GXutil.rtrim( A32TLiqCod)) ;
         httpContext.changePostValue( chkConTLiqSinCausa.getInternalname(), GXutil.booltostr( A925ConTLiqSinCausa)) ;
         httpContext.changePostValue( chkConTLiqSinPre.getInternalname(), GXutil.booltostr( A926ConTLiqSinPre)) ;
         httpContext.changePostValue( "ZT_"+"Z32TLiqCod_"+sGXsfl_128_idx, GXutil.rtrim( Z32TLiqCod)) ;
         httpContext.changePostValue( "ZT_"+"Z925ConTLiqSinCausa_"+sGXsfl_128_idx, GXutil.booltostr( Z925ConTLiqSinCausa)) ;
         httpContext.changePostValue( "ZT_"+"Z926ConTLiqSinPre_"+sGXsfl_128_idx, GXutil.booltostr( Z926ConTLiqSinPre)) ;
         httpContext.changePostValue( "ZT_"+"Z950ConTLTipEgr_"+sGXsfl_128_idx, GXutil.rtrim( Z950ConTLTipEgr)) ;
         httpContext.changePostValue( "ZT_"+"Z1406ConTLOrdejec_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1407ConTLConOrd_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1407ConTLConOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1409ConTLVigencia_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1409ConTLVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1410ConTLCondicion_"+sGXsfl_128_idx, GXutil.rtrim( Z1410ConTLCondicion)) ;
         httpContext.changePostValue( "ZT_"+"Z1470ConTLConHab_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1788ConTLTipoCon_"+sGXsfl_128_idx, GXutil.rtrim( Z1788ConTLTipoCon)) ;
         httpContext.changePostValue( "ZT_"+"Z1789CONTLSegPla_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "N32TLiqCod_"+sGXsfl_128_idx, GXutil.rtrim( A32TLiqCod)) ;
         if ( nIsMod_8 != 0 )
         {
            httpContext.changePostValue( "TLIQCOD_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynTLiqCod.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONTLIQSINCAUSA_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinCausa.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONTLIQSINPRE_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinPre.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0A0( )
   {
   }

   public void e120A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV22WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV22WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV12DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV12DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      Combo_megcodigo_Titlecontrolidtoreplace = edtMegCodigo_Internalname ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "TitleControlIdToReplace", Combo_megcodigo_Titlecontrolidtoreplace);
      /* Execute user subroutine: 'LOADCOMBOMEGCODIGO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(15);
         pr_default.close(14);
         pr_default.close(13);
         pr_default.close(12);
         pr_default.close(11);
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(7);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV15IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV15IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Insert", GXv_boolean5) ;
         concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV15IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV15IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Update", GXv_boolean5) ;
         concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV15IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV15IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Delete", GXv_boolean5) ;
         concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV15IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( ! AV15IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV37Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(15);
         pr_default.close(14);
         pr_default.close(13);
         pr_default.close(12);
         pr_default.close(11);
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(7);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV20TrnContext.fromxml(AV21WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV20TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV37Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV38GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GXV1), 8, 0));
         while ( AV38GXV1 <= AV20TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV26TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV20TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV38GXV1));
            if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoConCod") == 0 )
            {
               AV23Insert_TipoConCod = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23Insert_TipoConCod", AV23Insert_TipoConCod);
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod1") == 0 )
            {
               AV24Insert_SubTipoConCod1 = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24Insert_SubTipoConCod1", AV24Insert_SubTipoConCod1);
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod2") == 0 )
            {
               AV25Insert_SubTipoConCod2 = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25Insert_SubTipoConCod2", AV25Insert_SubTipoConCod2);
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCondicion") == 0 )
            {
               AV34Insert_ConCondicion = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV34Insert_ConCondicion", AV34Insert_ConCondicion);
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGG") == 0 )
            {
               AV30Insert_AplIIGG = (short)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV30Insert_AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30Insert_AplIIGG), 4, 0));
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoPais") == 0 )
            {
               AV32Insert_ConceptoPais = (short)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV32Insert_ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32Insert_ConceptoPais), 4, 0));
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoConveCodigo") == 0 )
            {
               AV33Insert_ConceptoConveCodigo = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33Insert_ConceptoConveCodigo", AV33Insert_ConceptoConveCodigo);
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliPadre") == 0 )
            {
               AV35Insert_CliPadre = (int)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV35Insert_CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35Insert_CliPadre), 6, 0));
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConPadre") == 0 )
            {
               AV29Insert_ConPadre = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29Insert_ConPadre", AV29Insert_ConPadre);
            }
            AV38GXV1 = (int)(AV38GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GXV1), 8, 0));
         }
      }
      chkavEssistemaconceptosdefault.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavEssistemaconceptosdefault.getInternalname(), "Visible", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getVisible(), 5, 0), true);
      edtConRetGanPropor_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRetGanPropor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRetGanPropor_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      GXt_int6 = AV7CliCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
      concepto_impl.this.GXt_int6 = GXv_int7[0] ;
      AV7CliCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      GXt_boolean4 = AV14esSistemaConceptosDefault ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV14esSistemaConceptosDefault = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14esSistemaConceptosDefault", AV14esSistemaConceptosDefault);
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
         AV17permiteModificacion = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17permiteModificacion", AV17permiteModificacion);
      }
      else
      {
         GXt_boolean4 = AV17permiteModificacion ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.permitemodificacionformula(remoteHandle, context).execute( AV7CliCod, AV11ConCodigo, GXv_boolean5) ;
         concepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV17permiteModificacion = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17permiteModificacion", AV17permiteModificacion);
      }
      if ( AV14esSistemaConceptosDefault )
      {
         AV16mostrarEditable = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16mostrarEditable", AV16mostrarEditable);
      }
      else
      {
         AV16mostrarEditable = (boolean)(((GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", ""))!=0))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16mostrarEditable", AV16mostrarEditable);
      }
      GXt_int8 = AV13EmpCod ;
      GXv_int9[0] = GXt_int8 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int9) ;
      concepto_impl.this.GXt_int8 = GXv_int9[0] ;
      AV13EmpCod = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
      AV27defaultConCodigo = httpContext.getMessage( "CALXXX", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27defaultConCodigo", AV27defaultConCodigo);
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
         edtConCodigo_Invitemessage = AV27defaultConCodigo ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Invitemessage", edtConCodigo_Invitemessage, true);
      }
   }

   public void e130A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
         new web.grabasesionformula(remoteHandle, context).execute( 0, 0, httpContext.getMessage( "remove", "")) ;
      }
      new web.grabatipoliqaux(remoteHandle, context).execute( AV7CliCod, A26ConCodigo) ;
      new web.actualizarrecalculaendetalles(remoteHandle, context).execute( AV7CliCod, A26ConCodigo, O762ConRecalcular, A762ConRecalcular, O1112AplIIGG, A1112AplIIGG) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(15);
      pr_default.close(14);
      pr_default.close(13);
      pr_default.close(12);
      pr_default.close(11);
      pr_default.close(10);
      pr_default.close(9);
      pr_default.close(7);
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
      edtConFormula_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Visible), 5, 0), true);
      divConformula_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConformula_cell_Internalname, "Class", divConformula_cell_Class, true);
      chkConVariable.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
      divConvariable_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      divConaplicgan_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      chkConCanti.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConCanti.getInternalname(), "Visible", GXutil.ltrimstr( chkConCanti.getVisible(), 5, 0), true);
      divConcanti_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
      chkConValUni.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConValUni.getInternalname(), "Visible", GXutil.ltrimstr( chkConValUni.getVisible(), 5, 0), true);
      divConvaluni_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
      chkConImporte.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConImporte.getInternalname(), "Visible", GXutil.ltrimstr( chkConImporte.getVisible(), 5, 0), true);
      divConimporte_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOMEGCODIGO' Routine */
      returnInSub = false ;
      Combo_megcodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"MegCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "DataListProcParametersPrefix", Combo_megcodigo_Datalistprocparametersprefix);
   }

   public void zm0A7( int GX_JID )
   {
      if ( ( GX_JID == 91 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z42ConCodYDesc = T000A9_A42ConCodYDesc[0] ;
            Z145ConFchModFor = T000A9_A145ConFchModFor[0] ;
            Z156ConUsuModFor = T000A9_A156ConUsuModFor[0] ;
            Z143ConCanti = T000A9_A143ConCanti[0] ;
            Z158ConValUni = T000A9_A158ConValUni[0] ;
            Z152ConImporte = T000A9_A152ConImporte[0] ;
            Z159ConVariable = T000A9_A159ConVariable[0] ;
            Z1905ConRelSecCli = T000A9_A1905ConRelSecCli[0] ;
            Z41ConDescrip = T000A9_A41ConDescrip[0] ;
            Z150ConHabilitado = T000A9_A150ConHabilitado[0] ;
            Z40ConOrden = T000A9_A40ConOrden[0] ;
            Z162ConVigencia = T000A9_A162ConVigencia[0] ;
            Z1488ConLiqBasica = T000A9_A1488ConLiqBasica[0] ;
            Z157ConValorGen = T000A9_A157ConValorGen[0] ;
            Z155ConTipoLiqGanancias = T000A9_A155ConTipoLiqGanancias[0] ;
            Z154ConTipo = T000A9_A154ConTipo[0] ;
            Z469ConCodOld = T000A9_A469ConCodOld[0] ;
            Z487ConCuenDebe = T000A9_A487ConCuenDebe[0] ;
            Z488ConCuenHaber = T000A9_A488ConCuenHaber[0] ;
            Z503ConTipoLiqAux = T000A9_A503ConTipoLiqAux[0] ;
            Z969ConConveAux = T000A9_A969ConConveAux[0] ;
            Z970ConClasifAux = T000A9_A970ConClasifAux[0] ;
            Z510ConOrdEjec = T000A9_A510ConOrdEjec[0] ;
            Z734ConRetGanPropor = T000A9_A734ConRetGanPropor[0] ;
            Z735ConAplicGan = T000A9_A735ConAplicGan[0] ;
            Z762ConRecalcular = T000A9_A762ConRecalcular[0] ;
            Z894ConImportado = T000A9_A894ConImportado[0] ;
            Z895ConTipoOrden = T000A9_A895ConTipoOrden[0] ;
            Z1017ConEdiEnRec = T000A9_A1017ConEdiEnRec[0] ;
            Z1018ConRangoCant = T000A9_A1018ConRangoCant[0] ;
            Z922ConUsado = T000A9_A922ConUsado[0] ;
            Z951ConObliga = T000A9_A951ConObliga[0] ;
            Z952ConObligaSiSac = T000A9_A952ConObligaSiSac[0] ;
            Z954ConCondCodigo = T000A9_A954ConCondCodigo[0] ;
            Z1066ConPreReq = T000A9_A1066ConPreReq[0] ;
            Z1068ConMostrarPos = T000A9_A1068ConMostrarPos[0] ;
            Z1077ConAdelDescu = T000A9_A1077ConAdelDescu[0] ;
            Z1194ConSegunPla = T000A9_A1194ConSegunPla[0] ;
            Z1471ConNumero = T000A9_A1471ConNumero[0] ;
            Z1472ConSIPAApo = T000A9_A1472ConSIPAApo[0] ;
            Z1473ConSIPACont = T000A9_A1473ConSIPACont[0] ;
            Z1474ConINSSJyPApo = T000A9_A1474ConINSSJyPApo[0] ;
            Z1475ConINSSJyPCont = T000A9_A1475ConINSSJyPCont[0] ;
            Z1476ConObraSocApo = T000A9_A1476ConObraSocApo[0] ;
            Z1477ConObraSocCont = T000A9_A1477ConObraSocCont[0] ;
            Z1478ConFonSolRedApo = T000A9_A1478ConFonSolRedApo[0] ;
            Z1479ConFonSolRedCont = T000A9_A1479ConFonSolRedCont[0] ;
            Z1480ConRenateaApo = T000A9_A1480ConRenateaApo[0] ;
            Z1481ConRenateaCont = T000A9_A1481ConRenateaCont[0] ;
            Z1482ConAsigFamCont = T000A9_A1482ConAsigFamCont[0] ;
            Z1483ConFonNacEmpCont = T000A9_A1483ConFonNacEmpCont[0] ;
            Z1484ConLeyRieTrabCont = T000A9_A1484ConLeyRieTrabCont[0] ;
            Z1485ConRegDifApo = T000A9_A1485ConRegDifApo[0] ;
            Z1486ConRegEspApo = T000A9_A1486ConRegEspApo[0] ;
            Z1539ConSacDeven = T000A9_A1539ConSacDeven[0] ;
            Z1620ConBaseLic = T000A9_A1620ConBaseLic[0] ;
            Z1797ConBaseLicProm = T000A9_A1797ConBaseLicProm[0] ;
            Z1621ConBaseFer = T000A9_A1621ConBaseFer[0] ;
            Z1798ConBaseFerProm = T000A9_A1798ConBaseFerProm[0] ;
            Z1622ConBaseHorExt = T000A9_A1622ConBaseHorExt[0] ;
            Z1799ConBaseHorExtProm = T000A9_A1799ConBaseHorExtProm[0] ;
            Z1800ConBasePres = T000A9_A1800ConBasePres[0] ;
            Z1801ConBaseAnt = T000A9_A1801ConBaseAnt[0] ;
            Z1827ConBaseOSDif = T000A9_A1827ConBaseOSDif[0] ;
            Z2191ConBaseAus = T000A9_A2191ConBaseAus[0] ;
            Z2192ConBaseAusProm = T000A9_A2192ConBaseAusProm[0] ;
            Z1648ConCodAfip = T000A9_A1648ConCodAfip[0] ;
            Z1769ConCntPa = T000A9_A1769ConCntPa[0] ;
            Z1821ConErrorSiCero = T000A9_A1821ConErrorSiCero[0] ;
            Z1826ConPueNov = T000A9_A1826ConPueNov[0] ;
            Z1886ConRelSec = T000A9_A1886ConRelSec[0] ;
            Z2013ConRelRef = T000A9_A2013ConRelRef[0] ;
            Z2185ConDescripSinAc = T000A9_A2185ConDescripSinAc[0] ;
            Z2187ConOblPalabra = T000A9_A2187ConOblPalabra[0] ;
            Z1822CliPadre = T000A9_A1822CliPadre[0] ;
            Z1112AplIIGG = T000A9_A1112AplIIGG[0] ;
            Z37TipoConCod = T000A9_A37TipoConCod[0] ;
            Z38SubTipoConCod1 = T000A9_A38SubTipoConCod1[0] ;
            Z39SubTipoConCod2 = T000A9_A39SubTipoConCod2[0] ;
            Z953ConCondicion = T000A9_A953ConCondicion[0] ;
            Z1644ConceptoPais = T000A9_A1644ConceptoPais[0] ;
            Z1645ConceptoConveCodigo = T000A9_A1645ConceptoConveCodigo[0] ;
            Z921ConPadre = T000A9_A921ConPadre[0] ;
         }
         else
         {
            Z42ConCodYDesc = A42ConCodYDesc ;
            Z145ConFchModFor = A145ConFchModFor ;
            Z156ConUsuModFor = A156ConUsuModFor ;
            Z143ConCanti = A143ConCanti ;
            Z158ConValUni = A158ConValUni ;
            Z152ConImporte = A152ConImporte ;
            Z159ConVariable = A159ConVariable ;
            Z1905ConRelSecCli = A1905ConRelSecCli ;
            Z41ConDescrip = A41ConDescrip ;
            Z150ConHabilitado = A150ConHabilitado ;
            Z40ConOrden = A40ConOrden ;
            Z162ConVigencia = A162ConVigencia ;
            Z1488ConLiqBasica = A1488ConLiqBasica ;
            Z157ConValorGen = A157ConValorGen ;
            Z155ConTipoLiqGanancias = A155ConTipoLiqGanancias ;
            Z154ConTipo = A154ConTipo ;
            Z469ConCodOld = A469ConCodOld ;
            Z487ConCuenDebe = A487ConCuenDebe ;
            Z488ConCuenHaber = A488ConCuenHaber ;
            Z503ConTipoLiqAux = A503ConTipoLiqAux ;
            Z969ConConveAux = A969ConConveAux ;
            Z970ConClasifAux = A970ConClasifAux ;
            Z510ConOrdEjec = A510ConOrdEjec ;
            Z734ConRetGanPropor = A734ConRetGanPropor ;
            Z735ConAplicGan = A735ConAplicGan ;
            Z762ConRecalcular = A762ConRecalcular ;
            Z894ConImportado = A894ConImportado ;
            Z895ConTipoOrden = A895ConTipoOrden ;
            Z1017ConEdiEnRec = A1017ConEdiEnRec ;
            Z1018ConRangoCant = A1018ConRangoCant ;
            Z922ConUsado = A922ConUsado ;
            Z951ConObliga = A951ConObliga ;
            Z952ConObligaSiSac = A952ConObligaSiSac ;
            Z954ConCondCodigo = A954ConCondCodigo ;
            Z1066ConPreReq = A1066ConPreReq ;
            Z1068ConMostrarPos = A1068ConMostrarPos ;
            Z1077ConAdelDescu = A1077ConAdelDescu ;
            Z1194ConSegunPla = A1194ConSegunPla ;
            Z1471ConNumero = A1471ConNumero ;
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
            Z2191ConBaseAus = A2191ConBaseAus ;
            Z2192ConBaseAusProm = A2192ConBaseAusProm ;
            Z1648ConCodAfip = A1648ConCodAfip ;
            Z1769ConCntPa = A1769ConCntPa ;
            Z1821ConErrorSiCero = A1821ConErrorSiCero ;
            Z1826ConPueNov = A1826ConPueNov ;
            Z1886ConRelSec = A1886ConRelSec ;
            Z2013ConRelRef = A2013ConRelRef ;
            Z2185ConDescripSinAc = A2185ConDescripSinAc ;
            Z2187ConOblPalabra = A2187ConOblPalabra ;
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
      if ( GX_JID == -91 )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z26ConCodigo = A26ConCodigo ;
         Z145ConFchModFor = A145ConFchModFor ;
         Z156ConUsuModFor = A156ConUsuModFor ;
         Z143ConCanti = A143ConCanti ;
         Z158ConValUni = A158ConValUni ;
         Z152ConImporte = A152ConImporte ;
         Z159ConVariable = A159ConVariable ;
         Z1905ConRelSecCli = A1905ConRelSecCli ;
         Z1974ConOldValues = A1974ConOldValues ;
         Z41ConDescrip = A41ConDescrip ;
         Z150ConHabilitado = A150ConHabilitado ;
         Z40ConOrden = A40ConOrden ;
         Z162ConVigencia = A162ConVigencia ;
         Z1488ConLiqBasica = A1488ConLiqBasica ;
         Z148ConFormula = A148ConFormula ;
         Z729ConFormulaPreResuelta = A729ConFormulaPreResuelta ;
         Z157ConValorGen = A157ConValorGen ;
         Z155ConTipoLiqGanancias = A155ConTipoLiqGanancias ;
         Z153ConObservacion = A153ConObservacion ;
         Z151ConHisFormula = A151ConHisFormula ;
         Z154ConTipo = A154ConTipo ;
         Z469ConCodOld = A469ConCodOld ;
         Z487ConCuenDebe = A487ConCuenDebe ;
         Z488ConCuenHaber = A488ConCuenHaber ;
         Z503ConTipoLiqAux = A503ConTipoLiqAux ;
         Z969ConConveAux = A969ConConveAux ;
         Z970ConClasifAux = A970ConClasifAux ;
         Z510ConOrdEjec = A510ConOrdEjec ;
         Z569ConFormulaExpl = A569ConFormulaExpl ;
         Z720ConFormulaObs2 = A720ConFormulaObs2 ;
         Z734ConRetGanPropor = A734ConRetGanPropor ;
         Z735ConAplicGan = A735ConAplicGan ;
         Z762ConRecalcular = A762ConRecalcular ;
         Z894ConImportado = A894ConImportado ;
         Z895ConTipoOrden = A895ConTipoOrden ;
         Z1017ConEdiEnRec = A1017ConEdiEnRec ;
         Z1018ConRangoCant = A1018ConRangoCant ;
         Z922ConUsado = A922ConUsado ;
         Z951ConObliga = A951ConObliga ;
         Z952ConObligaSiSac = A952ConObligaSiSac ;
         Z954ConCondCodigo = A954ConCondCodigo ;
         Z1066ConPreReq = A1066ConPreReq ;
         Z1068ConMostrarPos = A1068ConMostrarPos ;
         Z1077ConAdelDescu = A1077ConAdelDescu ;
         Z1194ConSegunPla = A1194ConSegunPla ;
         Z1471ConNumero = A1471ConNumero ;
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
         Z2191ConBaseAus = A2191ConBaseAus ;
         Z2192ConBaseAusProm = A2192ConBaseAusProm ;
         Z1648ConCodAfip = A1648ConCodAfip ;
         Z1769ConCntPa = A1769ConCntPa ;
         Z1821ConErrorSiCero = A1821ConErrorSiCero ;
         Z1826ConPueNov = A1826ConPueNov ;
         Z1886ConRelSec = A1886ConRelSec ;
         Z2013ConRelRef = A2013ConRelRef ;
         Z2185ConDescripSinAc = A2185ConDescripSinAc ;
         Z2187ConOblPalabra = A2187ConOblPalabra ;
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
      edtConFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Enabled), 5, 0), true);
      edtConFormula_Visible = ((GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), ""))!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) ) )
      {
         divConformula_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConformula_cell_Internalname, "Class", divConformula_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 )
         {
            divConformula_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConformula_cell_Internalname, "Class", divConformula_cell_Class, true);
         }
      }
      chkConCanti.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConCanti.getInternalname(), "Visible", GXutil.ltrimstr( chkConCanti.getVisible(), 5, 0), true);
      if ( ! ( false ) )
      {
         divConcanti_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
      }
      else
      {
         if ( false )
         {
            divConcanti_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConcanti_cell_Internalname, "Class", divConcanti_cell_Class, true);
         }
      }
      chkConValUni.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConValUni.getInternalname(), "Visible", GXutil.ltrimstr( chkConValUni.getVisible(), 5, 0), true);
      if ( ! ( false ) )
      {
         divConvaluni_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
      }
      else
      {
         if ( false )
         {
            divConvaluni_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvaluni_cell_Internalname, "Class", divConvaluni_cell_Class, true);
         }
      }
      chkConImporte.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConImporte.getInternalname(), "Visible", GXutil.ltrimstr( chkConImporte.getVisible(), 5, 0), true);
      if ( ! ( false ) )
      {
         divConimporte_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
      }
      else
      {
         if ( false )
         {
            divConimporte_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConimporte_cell_Internalname, "Class", divConimporte_cell_Class, true);
         }
      }
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtConFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Enabled), 5, 0), true);
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
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            concepto_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
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
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         A26ConCodigo = AV11ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV23Insert_TipoConCod)==0) )
      {
         dynTipoConCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoConCod.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
         {
            dynTipoConCod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoConCod.getEnabled(), 5, 0), true);
         }
         else
         {
            dynTipoConCod.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoConCod.getEnabled(), 5, 0), true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV24Insert_SubTipoConCod1)==0) )
      {
         dynSubTipoConCod1.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod1.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
         {
            dynSubTipoConCod1.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod1.getEnabled(), 5, 0), true);
         }
         else
         {
            dynSubTipoConCod1.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod1.getEnabled(), 5, 0), true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV25Insert_SubTipoConCod2)==0) )
      {
         dynSubTipoConCod2.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod2.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
         {
            dynSubTipoConCod2.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod2.getEnabled(), 5, 0), true);
         }
         else
         {
            dynSubTipoConCod2.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod2.getEnabled(), 5, 0), true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         chkConRecalcular.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkConRecalcular.getEnabled(), 5, 0), true);
      }
      else
      {
         chkConRecalcular.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkConRecalcular.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         edtConDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtConDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         cmbConVigencia.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConVigencia.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConVigencia.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConVigencia.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         edtConObservacion_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Enabled), 5, 0), true);
      }
      else
      {
         edtConObservacion_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         chkConVariable.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkConVariable.getEnabled(), 5, 0), true);
      }
      else
      {
         chkConVariable.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkConVariable.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         cmbConAplicGan.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAplicGan.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAplicGan.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAplicGan.getEnabled(), 5, 0), true);
      }
      gxaconcuendebe_html0A7( AV7CliCod, AV13EmpCod) ;
      gxaconcuenhaber_html0A7( AV7CliCod, AV13EmpCod) ;
   }

   public void standaloneModal( )
   {
      A149ConFormulaAbr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A149ConFormulaAbr", A149ConFormulaAbr);
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A143ConCanti = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
      }
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A158ConValUni = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
      }
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A152ConImporte = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV29Insert_ConPadre)==0) )
      {
         A921ConPadre = AV29Insert_ConPadre ;
         n921ConPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A921ConPadre", A921ConPadre);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV35Insert_CliPadre) )
      {
         A1822CliPadre = AV35Insert_CliPadre ;
         n1822CliPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV33Insert_ConceptoConveCodigo)==0) )
      {
         A1645ConceptoConveCodigo = AV33Insert_ConceptoConveCodigo ;
         n1645ConceptoConveCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV32Insert_ConceptoPais) )
      {
         A1644ConceptoPais = AV32Insert_ConceptoPais ;
         n1644ConceptoPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV30Insert_AplIIGG) )
      {
         A1112AplIIGG = AV30Insert_AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV34Insert_ConCondicion)==0) )
      {
         A953ConCondicion = AV34Insert_ConCondicion ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV25Insert_SubTipoConCod2)==0) )
      {
         A39SubTipoConCod2 = AV25Insert_SubTipoConCod2 ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV24Insert_SubTipoConCod1)==0) )
      {
         A38SubTipoConCod1 = AV24Insert_SubTipoConCod1 ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV23Insert_TipoConCod)==0) )
      {
         A37TipoConCod = AV23Insert_TipoConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( isIns( )  || isUpd( )  )
      {
         A1905ConRelSecCli = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1905ConRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1905ConRelSecCli), 6, 0));
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
      if ( isIns( )  && (false==A150ConHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A150ConHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
      }
      if ( isIns( )  && (GXutil.strcmp("", A155ConTipoLiqGanancias)==0) && ( Gx_BScreen == 0 ) )
      {
         A155ConTipoLiqGanancias = "N" ;
         n155ConTipoLiqGanancias = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A155ConTipoLiqGanancias", A155ConTipoLiqGanancias);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV37Pgmname = "Concepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
         gxasubtipoconcod1_html0A7( A37TipoConCod) ;
         gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
         chkConVariable.setVisible( ((GXutil.strcmp(A37TipoConCod, "REM_ARG")==0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
         {
            divConvariable_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
            {
               divConvariable_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
            }
         }
         cmbConAplicGan.setVisible( ((GXutil.strcmp(A37TipoConCod, "DES_ARG")!=0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
         if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
         {
            divConaplicgan_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 )
            {
               divConaplicgan_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
            }
         }
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
         {
            A159ConVariable = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
         }
      }
   }

   public void load0A7( )
   {
      /* Using cursor T000A18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = T000A18_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T000A18_n42ConCodYDesc[0] ;
         A145ConFchModFor = T000A18_A145ConFchModFor[0] ;
         n145ConFchModFor = T000A18_n145ConFchModFor[0] ;
         A156ConUsuModFor = T000A18_A156ConUsuModFor[0] ;
         n156ConUsuModFor = T000A18_n156ConUsuModFor[0] ;
         A143ConCanti = T000A18_A143ConCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
         A158ConValUni = T000A18_A158ConValUni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
         A152ConImporte = T000A18_A152ConImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
         A159ConVariable = T000A18_A159ConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
         A1905ConRelSecCli = T000A18_A1905ConRelSecCli[0] ;
         A1974ConOldValues = T000A18_A1974ConOldValues[0] ;
         A41ConDescrip = T000A18_A41ConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A150ConHabilitado = T000A18_A150ConHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
         A40ConOrden = T000A18_A40ConOrden[0] ;
         A162ConVigencia = T000A18_A162ConVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A1488ConLiqBasica = T000A18_A1488ConLiqBasica[0] ;
         A148ConFormula = T000A18_A148ConFormula[0] ;
         n148ConFormula = T000A18_n148ConFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
         A729ConFormulaPreResuelta = T000A18_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = T000A18_A157ConValorGen[0] ;
         n157ConValorGen = T000A18_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = T000A18_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = T000A18_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = T000A18_A153ConObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
         A151ConHisFormula = T000A18_A151ConHisFormula[0] ;
         n151ConHisFormula = T000A18_n151ConHisFormula[0] ;
         A154ConTipo = T000A18_A154ConTipo[0] ;
         A469ConCodOld = T000A18_A469ConCodOld[0] ;
         A487ConCuenDebe = T000A18_A487ConCuenDebe[0] ;
         n487ConCuenDebe = T000A18_n487ConCuenDebe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A487ConCuenDebe", A487ConCuenDebe);
         A488ConCuenHaber = T000A18_A488ConCuenHaber[0] ;
         n488ConCuenHaber = T000A18_n488ConCuenHaber[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A488ConCuenHaber", A488ConCuenHaber);
         A503ConTipoLiqAux = T000A18_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = T000A18_n503ConTipoLiqAux[0] ;
         A969ConConveAux = T000A18_A969ConConveAux[0] ;
         n969ConConveAux = T000A18_n969ConConveAux[0] ;
         A970ConClasifAux = T000A18_A970ConClasifAux[0] ;
         n970ConClasifAux = T000A18_n970ConClasifAux[0] ;
         A510ConOrdEjec = T000A18_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = T000A18_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = T000A18_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = T000A18_A734ConRetGanPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A734ConRetGanPropor", A734ConRetGanPropor);
         A735ConAplicGan = T000A18_A735ConAplicGan[0] ;
         n735ConAplicGan = T000A18_n735ConAplicGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
         A762ConRecalcular = T000A18_A762ConRecalcular[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A894ConImportado = T000A18_A894ConImportado[0] ;
         A895ConTipoOrden = T000A18_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = T000A18_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = T000A18_A1018ConRangoCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
         A922ConUsado = T000A18_A922ConUsado[0] ;
         A951ConObliga = T000A18_A951ConObliga[0] ;
         n951ConObliga = T000A18_n951ConObliga[0] ;
         A952ConObligaSiSac = T000A18_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = T000A18_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = T000A18_A954ConCondCodigo[0] ;
         A1066ConPreReq = T000A18_A1066ConPreReq[0] ;
         n1066ConPreReq = T000A18_n1066ConPreReq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
         A1068ConMostrarPos = T000A18_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = T000A18_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = T000A18_n1077ConAdelDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         A1194ConSegunPla = T000A18_A1194ConSegunPla[0] ;
         A1471ConNumero = T000A18_A1471ConNumero[0] ;
         A1472ConSIPAApo = T000A18_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = T000A18_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = T000A18_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = T000A18_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = T000A18_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = T000A18_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = T000A18_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = T000A18_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = T000A18_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = T000A18_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = T000A18_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = T000A18_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = T000A18_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = T000A18_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = T000A18_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = T000A18_A1539ConSacDeven[0] ;
         A1620ConBaseLic = T000A18_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = T000A18_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = T000A18_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = T000A18_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = T000A18_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = T000A18_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = T000A18_A1800ConBasePres[0] ;
         A1801ConBaseAnt = T000A18_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = T000A18_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = T000A18_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = T000A18_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = T000A18_A1648ConCodAfip[0] ;
         A1769ConCntPa = T000A18_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = T000A18_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = T000A18_A1826ConPueNov[0] ;
         A1886ConRelSec = T000A18_A1886ConRelSec[0] ;
         A2013ConRelRef = T000A18_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = T000A18_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = T000A18_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = T000A18_n2187ConOblPalabra[0] ;
         A1822CliPadre = T000A18_A1822CliPadre[0] ;
         n1822CliPadre = T000A18_n1822CliPadre[0] ;
         A1112AplIIGG = T000A18_A1112AplIIGG[0] ;
         n1112AplIIGG = T000A18_n1112AplIIGG[0] ;
         A37TipoConCod = T000A18_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = T000A18_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T000A18_n38SubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         A39SubTipoConCod2 = T000A18_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T000A18_n39SubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         A953ConCondicion = T000A18_A953ConCondicion[0] ;
         n953ConCondicion = T000A18_n953ConCondicion[0] ;
         A1644ConceptoPais = T000A18_A1644ConceptoPais[0] ;
         n1644ConceptoPais = T000A18_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = T000A18_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = T000A18_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = T000A18_A921ConPadre[0] ;
         n921ConPadre = T000A18_n921ConPadre[0] ;
         zm0A7( -91) ;
      }
      pr_default.close(16);
      onLoadActions0A7( ) ;
   }

   public void onLoadActions0A7( )
   {
      AV37Pgmname = "Concepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      if ( isUpd( )  )
      {
         GXt_char10 = A1974ConOldValues ;
         GXv_char11[0] = GXt_char10 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char11) ;
         concepto_impl.this.GXt_char10 = GXv_char11[0] ;
         A1974ConOldValues = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1974ConOldValues", A1974ConOldValues);
      }
      gxasubtipoconcod1_html0A7( A37TipoConCod) ;
      gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      chkConVariable.setVisible( ((GXutil.strcmp(A37TipoConCod, "REM_ARG")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
      {
         divConvariable_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
         {
            divConvariable_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
         }
      }
      cmbConAplicGan.setVisible( ((GXutil.strcmp(A37TipoConCod, "DES_ARG")!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
      {
         divConaplicgan_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 )
         {
            divConaplicgan_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
      {
         A159ConVariable = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      }
   }

   public void checkExtendedTable0A7( )
   {
      nIsDirty_7 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV37Pgmname = "Concepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
      /* Using cursor T000A10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(9);
      nIsDirty_7 = (short)(1) ;
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      if ( (GXutil.strcmp("", A26ConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  )
      {
         nIsDirty_7 = (short)(1) ;
         GXt_char10 = A1974ConOldValues ;
         GXv_char11[0] = GXt_char10 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char11) ;
         concepto_impl.this.GXt_char10 = GXv_char11[0] ;
         A1974ConOldValues = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1974ConOldValues", A1974ConOldValues);
      }
      if ( (GXutil.strcmp("", A41ConDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "CONDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A162ConVigencia == 0 ) || ( A162ConVigencia == 1 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Vigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConVigencia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000A12 */
      pr_default.execute(10, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(10);
      /* Using cursor T000A13 */
      pr_default.execute(11, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(11);
      /* Using cursor T000A14 */
      pr_default.execute(12, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(12);
      gxasubtipoconcod1_html0A7( A37TipoConCod) ;
      gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      chkConVariable.setVisible( ((GXutil.strcmp(A37TipoConCod, "REM_ARG")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
      {
         divConvariable_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
         {
            divConvariable_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
         }
      }
      cmbConAplicGan.setVisible( ((GXutil.strcmp(A37TipoConCod, "DES_ARG")!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
      {
         divConaplicgan_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 )
         {
            divConaplicgan_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
      {
         nIsDirty_7 = (short)(1) ;
         A159ConVariable = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      }
      if ( (GXutil.strcmp("", A37TipoConCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A38SubTipoConCod1)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Clasificación", ""), "", "", "", "", "", "", "", ""), 1, "SUBTIPOCONCOD1");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSubTipoConCod1.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A735ConAplicGan == 1 ) || ( A735ConAplicGan == 2 ) || ( A735ConAplicGan == 4 ) || ( A735ConAplicGan == 5 ) || ( A735ConAplicGan == 6 ) || ( A735ConAplicGan == 7 ) || ( A735ConAplicGan == 8 ) || ( A735ConAplicGan == 9 ) || (0==A735ConAplicGan) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Sujeto a Ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAPLICGAN");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAplicGan.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1066ConPreReq, "APO_SIPA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_SIPA_NoSacNiVac") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_INSSJyP") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_OS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_DIF") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_ESP") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_SIPA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_OS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_FNE") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_LRT") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "BRUTA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "REM") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "NRE") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "REMNOSAC") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "EXENTOS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "LICENCIAS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "FIJAS") == 0 ) || (GXutil.strcmp("", A1066ConPreReq)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Prerequisito para cálculo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONPREREQ");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConPreReq.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1077ConAdelDescu == 1 ) || ( A1077ConAdelDescu == 2 ) || (0==A1077ConAdelDescu) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Adelanto/Descuento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONADELDESCU");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAdelDescu.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000A11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(9);
      /* Using cursor T000A17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (GXutil.strcmp("", A921ConPadre)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto Padre Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONPADRE");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(15);
      /* Using cursor T000A15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(13);
      /* Using cursor T000A16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void closeExtendedTableCursors0A7( )
   {
      pr_default.close(8);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(9);
      pr_default.close(15);
      pr_default.close(13);
      pr_default.close(14);
   }

   public void enableDisable( )
   {
   }

   public void gxload_92( int A3CliCod ,
                          short A1112AplIIGG )
   {
      /* Using cursor T000A19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(17) == 101) )
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
      if ( (pr_default.getStatus(17) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(17);
   }

   public void gxload_94( String A37TipoConCod )
   {
      /* Using cursor T000A20 */
      pr_default.execute(18, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void gxload_95( String A37TipoConCod ,
                          String A38SubTipoConCod1 )
   {
      /* Using cursor T000A21 */
      pr_default.execute(19, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(19) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(19);
   }

   public void gxload_96( String A37TipoConCod ,
                          String A38SubTipoConCod1 ,
                          String A39SubTipoConCod2 )
   {
      /* Using cursor T000A22 */
      pr_default.execute(20, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(20) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(20);
   }

   public void gxload_93( int A1822CliPadre ,
                          short A1112AplIIGG )
   {
      /* Using cursor T000A23 */
      pr_default.execute(21, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(21) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(21);
   }

   public void gxload_99( int A1822CliPadre ,
                          String A921ConPadre )
   {
      /* Using cursor T000A24 */
      pr_default.execute(22, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre});
      if ( (pr_default.getStatus(22) == 101) )
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
      if ( (pr_default.getStatus(22) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(22);
   }

   public void gxload_97( String A953ConCondicion )
   {
      /* Using cursor T000A25 */
      pr_default.execute(23, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(23) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(23);
   }

   public void gxload_98( short A1644ConceptoPais ,
                          String A1645ConceptoConveCodigo )
   {
      /* Using cursor T000A26 */
      pr_default.execute(24, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(24) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(24) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(24);
   }

   public void getKey0A7( )
   {
      /* Using cursor T000A27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000A9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         zm0A7( 91) ;
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = T000A9_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T000A9_n42ConCodYDesc[0] ;
         A26ConCodigo = T000A9_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A145ConFchModFor = T000A9_A145ConFchModFor[0] ;
         n145ConFchModFor = T000A9_n145ConFchModFor[0] ;
         A156ConUsuModFor = T000A9_A156ConUsuModFor[0] ;
         n156ConUsuModFor = T000A9_n156ConUsuModFor[0] ;
         A143ConCanti = T000A9_A143ConCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
         A158ConValUni = T000A9_A158ConValUni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
         A152ConImporte = T000A9_A152ConImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
         A159ConVariable = T000A9_A159ConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
         A1905ConRelSecCli = T000A9_A1905ConRelSecCli[0] ;
         A1974ConOldValues = T000A9_A1974ConOldValues[0] ;
         A41ConDescrip = T000A9_A41ConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A150ConHabilitado = T000A9_A150ConHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
         A40ConOrden = T000A9_A40ConOrden[0] ;
         A162ConVigencia = T000A9_A162ConVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A1488ConLiqBasica = T000A9_A1488ConLiqBasica[0] ;
         A148ConFormula = T000A9_A148ConFormula[0] ;
         n148ConFormula = T000A9_n148ConFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
         A729ConFormulaPreResuelta = T000A9_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = T000A9_A157ConValorGen[0] ;
         n157ConValorGen = T000A9_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = T000A9_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = T000A9_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = T000A9_A153ConObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
         A151ConHisFormula = T000A9_A151ConHisFormula[0] ;
         n151ConHisFormula = T000A9_n151ConHisFormula[0] ;
         A154ConTipo = T000A9_A154ConTipo[0] ;
         A469ConCodOld = T000A9_A469ConCodOld[0] ;
         A487ConCuenDebe = T000A9_A487ConCuenDebe[0] ;
         n487ConCuenDebe = T000A9_n487ConCuenDebe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A487ConCuenDebe", A487ConCuenDebe);
         A488ConCuenHaber = T000A9_A488ConCuenHaber[0] ;
         n488ConCuenHaber = T000A9_n488ConCuenHaber[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A488ConCuenHaber", A488ConCuenHaber);
         A503ConTipoLiqAux = T000A9_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = T000A9_n503ConTipoLiqAux[0] ;
         A969ConConveAux = T000A9_A969ConConveAux[0] ;
         n969ConConveAux = T000A9_n969ConConveAux[0] ;
         A970ConClasifAux = T000A9_A970ConClasifAux[0] ;
         n970ConClasifAux = T000A9_n970ConClasifAux[0] ;
         A510ConOrdEjec = T000A9_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = T000A9_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = T000A9_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = T000A9_A734ConRetGanPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A734ConRetGanPropor", A734ConRetGanPropor);
         A735ConAplicGan = T000A9_A735ConAplicGan[0] ;
         n735ConAplicGan = T000A9_n735ConAplicGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
         A762ConRecalcular = T000A9_A762ConRecalcular[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A894ConImportado = T000A9_A894ConImportado[0] ;
         A895ConTipoOrden = T000A9_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = T000A9_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = T000A9_A1018ConRangoCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
         A922ConUsado = T000A9_A922ConUsado[0] ;
         A951ConObliga = T000A9_A951ConObliga[0] ;
         n951ConObliga = T000A9_n951ConObliga[0] ;
         A952ConObligaSiSac = T000A9_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = T000A9_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = T000A9_A954ConCondCodigo[0] ;
         A1066ConPreReq = T000A9_A1066ConPreReq[0] ;
         n1066ConPreReq = T000A9_n1066ConPreReq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
         A1068ConMostrarPos = T000A9_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = T000A9_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = T000A9_n1077ConAdelDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         A1194ConSegunPla = T000A9_A1194ConSegunPla[0] ;
         A1471ConNumero = T000A9_A1471ConNumero[0] ;
         A1472ConSIPAApo = T000A9_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = T000A9_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = T000A9_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = T000A9_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = T000A9_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = T000A9_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = T000A9_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = T000A9_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = T000A9_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = T000A9_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = T000A9_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = T000A9_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = T000A9_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = T000A9_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = T000A9_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = T000A9_A1539ConSacDeven[0] ;
         A1620ConBaseLic = T000A9_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = T000A9_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = T000A9_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = T000A9_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = T000A9_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = T000A9_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = T000A9_A1800ConBasePres[0] ;
         A1801ConBaseAnt = T000A9_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = T000A9_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = T000A9_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = T000A9_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = T000A9_A1648ConCodAfip[0] ;
         A1769ConCntPa = T000A9_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = T000A9_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = T000A9_A1826ConPueNov[0] ;
         A1886ConRelSec = T000A9_A1886ConRelSec[0] ;
         A2013ConRelRef = T000A9_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = T000A9_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = T000A9_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = T000A9_n2187ConOblPalabra[0] ;
         A1822CliPadre = T000A9_A1822CliPadre[0] ;
         n1822CliPadre = T000A9_n1822CliPadre[0] ;
         A3CliCod = T000A9_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = T000A9_A1112AplIIGG[0] ;
         n1112AplIIGG = T000A9_n1112AplIIGG[0] ;
         A37TipoConCod = T000A9_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = T000A9_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T000A9_n38SubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         A39SubTipoConCod2 = T000A9_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T000A9_n39SubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         A953ConCondicion = T000A9_A953ConCondicion[0] ;
         n953ConCondicion = T000A9_n953ConCondicion[0] ;
         A1644ConceptoPais = T000A9_A1644ConceptoPais[0] ;
         n1644ConceptoPais = T000A9_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = T000A9_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = T000A9_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = T000A9_A921ConPadre[0] ;
         n921ConPadre = T000A9_n921ConPadre[0] ;
         O41ConDescrip = A41ConDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         O2192ConBaseAusProm = A2192ConBaseAusProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
         O2191ConBaseAus = A2191ConBaseAus ;
         httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
         O1827ConBaseOSDif = A1827ConBaseOSDif ;
         httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
         O1801ConBaseAnt = A1801ConBaseAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
         O1800ConBasePres = A1800ConBasePres ;
         httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
         O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
         O1622ConBaseHorExt = A1622ConBaseHorExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         O1798ConBaseFerProm = A1798ConBaseFerProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
         O1621ConBaseFer = A1621ConBaseFer ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         O1797ConBaseLicProm = A1797ConBaseLicProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
         O1620ConBaseLic = A1620ConBaseLic ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         O762ConRecalcular = A762ConRecalcular ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         O1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0A7( ) ;
         if ( AnyError == 1 )
         {
            RcdFound7 = (short)(0) ;
            initializeNonKey0A7( ) ;
         }
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey0A7( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(7);
   }

   public void getEqualNoModal( )
   {
      getKey0A7( ) ;
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
      /* Using cursor T000A28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(26) != 101) )
      {
         while ( (pr_default.getStatus(26) != 101) && ( ( T000A28_A3CliCod[0] < A3CliCod ) || ( T000A28_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000A28_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(26);
         }
         if ( (pr_default.getStatus(26) != 101) && ( ( T000A28_A3CliCod[0] > A3CliCod ) || ( T000A28_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000A28_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A3CliCod = T000A28_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T000A28_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(26);
   }

   public void move_previous( )
   {
      RcdFound7 = (short)(0) ;
      /* Using cursor T000A29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(27) != 101) )
      {
         while ( (pr_default.getStatus(27) != 101) && ( ( T000A29_A3CliCod[0] > A3CliCod ) || ( T000A29_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000A29_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(27);
         }
         if ( (pr_default.getStatus(27) != 101) && ( ( T000A29_A3CliCod[0] < A3CliCod ) || ( T000A29_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000A29_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A3CliCod = T000A29_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T000A29_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(27);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0A7( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0A7( ) ;
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
               GX_FocusControl = dynTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0A7( ) ;
               GX_FocusControl = dynTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = dynTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0A7( ) ;
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
                  GX_FocusControl = dynTipoConCod.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0A7( ) ;
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
         GX_FocusControl = dynTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0A7( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000A8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(6) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(6) == 101) || ( GXutil.strcmp(Z42ConCodYDesc, T000A8_A42ConCodYDesc[0]) != 0 ) || !( GXutil.dateCompare(Z145ConFchModFor, T000A8_A145ConFchModFor[0]) ) || ( GXutil.strcmp(Z156ConUsuModFor, T000A8_A156ConUsuModFor[0]) != 0 ) || ( Z143ConCanti != T000A8_A143ConCanti[0] ) || ( Z158ConValUni != T000A8_A158ConValUni[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z152ConImporte != T000A8_A152ConImporte[0] ) || ( Z159ConVariable != T000A8_A159ConVariable[0] ) || ( Z1905ConRelSecCli != T000A8_A1905ConRelSecCli[0] ) || ( GXutil.strcmp(Z41ConDescrip, T000A8_A41ConDescrip[0]) != 0 ) || ( Z150ConHabilitado != T000A8_A150ConHabilitado[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z40ConOrden != T000A8_A40ConOrden[0] ) || ( Z162ConVigencia != T000A8_A162ConVigencia[0] ) || ( Z1488ConLiqBasica != T000A8_A1488ConLiqBasica[0] ) || ( DecimalUtil.compareTo(Z157ConValorGen, T000A8_A157ConValorGen[0]) != 0 ) || ( GXutil.strcmp(Z155ConTipoLiqGanancias, T000A8_A155ConTipoLiqGanancias[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z154ConTipo != T000A8_A154ConTipo[0] ) || ( GXutil.strcmp(Z469ConCodOld, T000A8_A469ConCodOld[0]) != 0 ) || ( GXutil.strcmp(Z487ConCuenDebe, T000A8_A487ConCuenDebe[0]) != 0 ) || ( GXutil.strcmp(Z488ConCuenHaber, T000A8_A488ConCuenHaber[0]) != 0 ) || ( GXutil.strcmp(Z503ConTipoLiqAux, T000A8_A503ConTipoLiqAux[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z969ConConveAux, T000A8_A969ConConveAux[0]) != 0 ) || ( GXutil.strcmp(Z970ConClasifAux, T000A8_A970ConClasifAux[0]) != 0 ) || ( Z510ConOrdEjec != T000A8_A510ConOrdEjec[0] ) || ( Z734ConRetGanPropor != T000A8_A734ConRetGanPropor[0] ) || ( Z735ConAplicGan != T000A8_A735ConAplicGan[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z762ConRecalcular != T000A8_A762ConRecalcular[0] ) || ( Z894ConImportado != T000A8_A894ConImportado[0] ) || ( Z895ConTipoOrden != T000A8_A895ConTipoOrden[0] ) || ( Z1017ConEdiEnRec != T000A8_A1017ConEdiEnRec[0] ) || ( GXutil.strcmp(Z1018ConRangoCant, T000A8_A1018ConRangoCant[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z922ConUsado != T000A8_A922ConUsado[0] ) || ( Z951ConObliga != T000A8_A951ConObliga[0] ) || ( Z952ConObligaSiSac != T000A8_A952ConObligaSiSac[0] ) || ( GXutil.strcmp(Z954ConCondCodigo, T000A8_A954ConCondCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1066ConPreReq, T000A8_A1066ConPreReq[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1068ConMostrarPos != T000A8_A1068ConMostrarPos[0] ) || ( Z1077ConAdelDescu != T000A8_A1077ConAdelDescu[0] ) || ( Z1194ConSegunPla != T000A8_A1194ConSegunPla[0] ) || ( Z1471ConNumero != T000A8_A1471ConNumero[0] ) || ( Z1472ConSIPAApo != T000A8_A1472ConSIPAApo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1473ConSIPACont != T000A8_A1473ConSIPACont[0] ) || ( Z1474ConINSSJyPApo != T000A8_A1474ConINSSJyPApo[0] ) || ( Z1475ConINSSJyPCont != T000A8_A1475ConINSSJyPCont[0] ) || ( Z1476ConObraSocApo != T000A8_A1476ConObraSocApo[0] ) || ( Z1477ConObraSocCont != T000A8_A1477ConObraSocCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1478ConFonSolRedApo != T000A8_A1478ConFonSolRedApo[0] ) || ( Z1479ConFonSolRedCont != T000A8_A1479ConFonSolRedCont[0] ) || ( Z1480ConRenateaApo != T000A8_A1480ConRenateaApo[0] ) || ( Z1481ConRenateaCont != T000A8_A1481ConRenateaCont[0] ) || ( Z1482ConAsigFamCont != T000A8_A1482ConAsigFamCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1483ConFonNacEmpCont != T000A8_A1483ConFonNacEmpCont[0] ) || ( Z1484ConLeyRieTrabCont != T000A8_A1484ConLeyRieTrabCont[0] ) || ( Z1485ConRegDifApo != T000A8_A1485ConRegDifApo[0] ) || ( Z1486ConRegEspApo != T000A8_A1486ConRegEspApo[0] ) || ( Z1539ConSacDeven != T000A8_A1539ConSacDeven[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1620ConBaseLic != T000A8_A1620ConBaseLic[0] ) || ( Z1797ConBaseLicProm != T000A8_A1797ConBaseLicProm[0] ) || ( Z1621ConBaseFer != T000A8_A1621ConBaseFer[0] ) || ( Z1798ConBaseFerProm != T000A8_A1798ConBaseFerProm[0] ) || ( Z1622ConBaseHorExt != T000A8_A1622ConBaseHorExt[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1799ConBaseHorExtProm != T000A8_A1799ConBaseHorExtProm[0] ) || ( Z1800ConBasePres != T000A8_A1800ConBasePres[0] ) || ( Z1801ConBaseAnt != T000A8_A1801ConBaseAnt[0] ) || ( Z1827ConBaseOSDif != T000A8_A1827ConBaseOSDif[0] ) || ( Z2191ConBaseAus != T000A8_A2191ConBaseAus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2192ConBaseAusProm != T000A8_A2192ConBaseAusProm[0] ) || ( GXutil.strcmp(Z1648ConCodAfip, T000A8_A1648ConCodAfip[0]) != 0 ) || ( Z1769ConCntPa != T000A8_A1769ConCntPa[0] ) || ( Z1821ConErrorSiCero != T000A8_A1821ConErrorSiCero[0] ) || ( Z1826ConPueNov != T000A8_A1826ConPueNov[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1886ConRelSec != T000A8_A1886ConRelSec[0] ) || ( GXutil.strcmp(Z2013ConRelRef, T000A8_A2013ConRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2185ConDescripSinAc, T000A8_A2185ConDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z2187ConOblPalabra, T000A8_A2187ConOblPalabra[0]) != 0 ) || ( Z1822CliPadre != T000A8_A1822CliPadre[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1112AplIIGG != T000A8_A1112AplIIGG[0] ) || ( GXutil.strcmp(Z37TipoConCod, T000A8_A37TipoConCod[0]) != 0 ) || ( GXutil.strcmp(Z38SubTipoConCod1, T000A8_A38SubTipoConCod1[0]) != 0 ) || ( GXutil.strcmp(Z39SubTipoConCod2, T000A8_A39SubTipoConCod2[0]) != 0 ) || ( GXutil.strcmp(Z953ConCondicion, T000A8_A953ConCondicion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1644ConceptoPais != T000A8_A1644ConceptoPais[0] ) || ( GXutil.strcmp(Z1645ConceptoConveCodigo, T000A8_A1645ConceptoConveCodigo[0]) != 0 ) || ( GXutil.strcmp(Z921ConPadre, T000A8_A921ConPadre[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z42ConCodYDesc, T000A8_A42ConCodYDesc[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCodYDesc");
               GXutil.writeLogRaw("Old: ",Z42ConCodYDesc);
               GXutil.writeLogRaw("Current: ",T000A8_A42ConCodYDesc[0]);
            }
            if ( !( GXutil.dateCompare(Z145ConFchModFor, T000A8_A145ConFchModFor[0]) ) )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConFchModFor");
               GXutil.writeLogRaw("Old: ",Z145ConFchModFor);
               GXutil.writeLogRaw("Current: ",T000A8_A145ConFchModFor[0]);
            }
            if ( GXutil.strcmp(Z156ConUsuModFor, T000A8_A156ConUsuModFor[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConUsuModFor");
               GXutil.writeLogRaw("Old: ",Z156ConUsuModFor);
               GXutil.writeLogRaw("Current: ",T000A8_A156ConUsuModFor[0]);
            }
            if ( Z143ConCanti != T000A8_A143ConCanti[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCanti");
               GXutil.writeLogRaw("Old: ",Z143ConCanti);
               GXutil.writeLogRaw("Current: ",T000A8_A143ConCanti[0]);
            }
            if ( Z158ConValUni != T000A8_A158ConValUni[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConValUni");
               GXutil.writeLogRaw("Old: ",Z158ConValUni);
               GXutil.writeLogRaw("Current: ",T000A8_A158ConValUni[0]);
            }
            if ( Z152ConImporte != T000A8_A152ConImporte[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConImporte");
               GXutil.writeLogRaw("Old: ",Z152ConImporte);
               GXutil.writeLogRaw("Current: ",T000A8_A152ConImporte[0]);
            }
            if ( Z159ConVariable != T000A8_A159ConVariable[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConVariable");
               GXutil.writeLogRaw("Old: ",Z159ConVariable);
               GXutil.writeLogRaw("Current: ",T000A8_A159ConVariable[0]);
            }
            if ( Z1905ConRelSecCli != T000A8_A1905ConRelSecCli[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1905ConRelSecCli);
               GXutil.writeLogRaw("Current: ",T000A8_A1905ConRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z41ConDescrip, T000A8_A41ConDescrip[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConDescrip");
               GXutil.writeLogRaw("Old: ",Z41ConDescrip);
               GXutil.writeLogRaw("Current: ",T000A8_A41ConDescrip[0]);
            }
            if ( Z150ConHabilitado != T000A8_A150ConHabilitado[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConHabilitado");
               GXutil.writeLogRaw("Old: ",Z150ConHabilitado);
               GXutil.writeLogRaw("Current: ",T000A8_A150ConHabilitado[0]);
            }
            if ( Z40ConOrden != T000A8_A40ConOrden[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConOrden");
               GXutil.writeLogRaw("Old: ",Z40ConOrden);
               GXutil.writeLogRaw("Current: ",T000A8_A40ConOrden[0]);
            }
            if ( Z162ConVigencia != T000A8_A162ConVigencia[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConVigencia");
               GXutil.writeLogRaw("Old: ",Z162ConVigencia);
               GXutil.writeLogRaw("Current: ",T000A8_A162ConVigencia[0]);
            }
            if ( Z1488ConLiqBasica != T000A8_A1488ConLiqBasica[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConLiqBasica");
               GXutil.writeLogRaw("Old: ",Z1488ConLiqBasica);
               GXutil.writeLogRaw("Current: ",T000A8_A1488ConLiqBasica[0]);
            }
            if ( DecimalUtil.compareTo(Z157ConValorGen, T000A8_A157ConValorGen[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConValorGen");
               GXutil.writeLogRaw("Old: ",Z157ConValorGen);
               GXutil.writeLogRaw("Current: ",T000A8_A157ConValorGen[0]);
            }
            if ( GXutil.strcmp(Z155ConTipoLiqGanancias, T000A8_A155ConTipoLiqGanancias[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTipoLiqGanancias");
               GXutil.writeLogRaw("Old: ",Z155ConTipoLiqGanancias);
               GXutil.writeLogRaw("Current: ",T000A8_A155ConTipoLiqGanancias[0]);
            }
            if ( Z154ConTipo != T000A8_A154ConTipo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTipo");
               GXutil.writeLogRaw("Old: ",Z154ConTipo);
               GXutil.writeLogRaw("Current: ",T000A8_A154ConTipo[0]);
            }
            if ( GXutil.strcmp(Z469ConCodOld, T000A8_A469ConCodOld[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCodOld");
               GXutil.writeLogRaw("Old: ",Z469ConCodOld);
               GXutil.writeLogRaw("Current: ",T000A8_A469ConCodOld[0]);
            }
            if ( GXutil.strcmp(Z487ConCuenDebe, T000A8_A487ConCuenDebe[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCuenDebe");
               GXutil.writeLogRaw("Old: ",Z487ConCuenDebe);
               GXutil.writeLogRaw("Current: ",T000A8_A487ConCuenDebe[0]);
            }
            if ( GXutil.strcmp(Z488ConCuenHaber, T000A8_A488ConCuenHaber[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCuenHaber");
               GXutil.writeLogRaw("Old: ",Z488ConCuenHaber);
               GXutil.writeLogRaw("Current: ",T000A8_A488ConCuenHaber[0]);
            }
            if ( GXutil.strcmp(Z503ConTipoLiqAux, T000A8_A503ConTipoLiqAux[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTipoLiqAux");
               GXutil.writeLogRaw("Old: ",Z503ConTipoLiqAux);
               GXutil.writeLogRaw("Current: ",T000A8_A503ConTipoLiqAux[0]);
            }
            if ( GXutil.strcmp(Z969ConConveAux, T000A8_A969ConConveAux[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConConveAux");
               GXutil.writeLogRaw("Old: ",Z969ConConveAux);
               GXutil.writeLogRaw("Current: ",T000A8_A969ConConveAux[0]);
            }
            if ( GXutil.strcmp(Z970ConClasifAux, T000A8_A970ConClasifAux[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConClasifAux");
               GXutil.writeLogRaw("Old: ",Z970ConClasifAux);
               GXutil.writeLogRaw("Current: ",T000A8_A970ConClasifAux[0]);
            }
            if ( Z510ConOrdEjec != T000A8_A510ConOrdEjec[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConOrdEjec");
               GXutil.writeLogRaw("Old: ",Z510ConOrdEjec);
               GXutil.writeLogRaw("Current: ",T000A8_A510ConOrdEjec[0]);
            }
            if ( Z734ConRetGanPropor != T000A8_A734ConRetGanPropor[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRetGanPropor");
               GXutil.writeLogRaw("Old: ",Z734ConRetGanPropor);
               GXutil.writeLogRaw("Current: ",T000A8_A734ConRetGanPropor[0]);
            }
            if ( Z735ConAplicGan != T000A8_A735ConAplicGan[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConAplicGan");
               GXutil.writeLogRaw("Old: ",Z735ConAplicGan);
               GXutil.writeLogRaw("Current: ",T000A8_A735ConAplicGan[0]);
            }
            if ( Z762ConRecalcular != T000A8_A762ConRecalcular[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRecalcular");
               GXutil.writeLogRaw("Old: ",Z762ConRecalcular);
               GXutil.writeLogRaw("Current: ",T000A8_A762ConRecalcular[0]);
            }
            if ( Z894ConImportado != T000A8_A894ConImportado[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConImportado");
               GXutil.writeLogRaw("Old: ",Z894ConImportado);
               GXutil.writeLogRaw("Current: ",T000A8_A894ConImportado[0]);
            }
            if ( Z895ConTipoOrden != T000A8_A895ConTipoOrden[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTipoOrden");
               GXutil.writeLogRaw("Old: ",Z895ConTipoOrden);
               GXutil.writeLogRaw("Current: ",T000A8_A895ConTipoOrden[0]);
            }
            if ( Z1017ConEdiEnRec != T000A8_A1017ConEdiEnRec[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConEdiEnRec");
               GXutil.writeLogRaw("Old: ",Z1017ConEdiEnRec);
               GXutil.writeLogRaw("Current: ",T000A8_A1017ConEdiEnRec[0]);
            }
            if ( GXutil.strcmp(Z1018ConRangoCant, T000A8_A1018ConRangoCant[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRangoCant");
               GXutil.writeLogRaw("Old: ",Z1018ConRangoCant);
               GXutil.writeLogRaw("Current: ",T000A8_A1018ConRangoCant[0]);
            }
            if ( Z922ConUsado != T000A8_A922ConUsado[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConUsado");
               GXutil.writeLogRaw("Old: ",Z922ConUsado);
               GXutil.writeLogRaw("Current: ",T000A8_A922ConUsado[0]);
            }
            if ( Z951ConObliga != T000A8_A951ConObliga[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConObliga");
               GXutil.writeLogRaw("Old: ",Z951ConObliga);
               GXutil.writeLogRaw("Current: ",T000A8_A951ConObliga[0]);
            }
            if ( Z952ConObligaSiSac != T000A8_A952ConObligaSiSac[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConObligaSiSac");
               GXutil.writeLogRaw("Old: ",Z952ConObligaSiSac);
               GXutil.writeLogRaw("Current: ",T000A8_A952ConObligaSiSac[0]);
            }
            if ( GXutil.strcmp(Z954ConCondCodigo, T000A8_A954ConCondCodigo[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCondCodigo");
               GXutil.writeLogRaw("Old: ",Z954ConCondCodigo);
               GXutil.writeLogRaw("Current: ",T000A8_A954ConCondCodigo[0]);
            }
            if ( GXutil.strcmp(Z1066ConPreReq, T000A8_A1066ConPreReq[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConPreReq");
               GXutil.writeLogRaw("Old: ",Z1066ConPreReq);
               GXutil.writeLogRaw("Current: ",T000A8_A1066ConPreReq[0]);
            }
            if ( Z1068ConMostrarPos != T000A8_A1068ConMostrarPos[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConMostrarPos");
               GXutil.writeLogRaw("Old: ",Z1068ConMostrarPos);
               GXutil.writeLogRaw("Current: ",T000A8_A1068ConMostrarPos[0]);
            }
            if ( Z1077ConAdelDescu != T000A8_A1077ConAdelDescu[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConAdelDescu");
               GXutil.writeLogRaw("Old: ",Z1077ConAdelDescu);
               GXutil.writeLogRaw("Current: ",T000A8_A1077ConAdelDescu[0]);
            }
            if ( Z1194ConSegunPla != T000A8_A1194ConSegunPla[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConSegunPla");
               GXutil.writeLogRaw("Old: ",Z1194ConSegunPla);
               GXutil.writeLogRaw("Current: ",T000A8_A1194ConSegunPla[0]);
            }
            if ( Z1471ConNumero != T000A8_A1471ConNumero[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConNumero");
               GXutil.writeLogRaw("Old: ",Z1471ConNumero);
               GXutil.writeLogRaw("Current: ",T000A8_A1471ConNumero[0]);
            }
            if ( Z1472ConSIPAApo != T000A8_A1472ConSIPAApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConSIPAApo");
               GXutil.writeLogRaw("Old: ",Z1472ConSIPAApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1472ConSIPAApo[0]);
            }
            if ( Z1473ConSIPACont != T000A8_A1473ConSIPACont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConSIPACont");
               GXutil.writeLogRaw("Old: ",Z1473ConSIPACont);
               GXutil.writeLogRaw("Current: ",T000A8_A1473ConSIPACont[0]);
            }
            if ( Z1474ConINSSJyPApo != T000A8_A1474ConINSSJyPApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConINSSJyPApo");
               GXutil.writeLogRaw("Old: ",Z1474ConINSSJyPApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1474ConINSSJyPApo[0]);
            }
            if ( Z1475ConINSSJyPCont != T000A8_A1475ConINSSJyPCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConINSSJyPCont");
               GXutil.writeLogRaw("Old: ",Z1475ConINSSJyPCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1475ConINSSJyPCont[0]);
            }
            if ( Z1476ConObraSocApo != T000A8_A1476ConObraSocApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConObraSocApo");
               GXutil.writeLogRaw("Old: ",Z1476ConObraSocApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1476ConObraSocApo[0]);
            }
            if ( Z1477ConObraSocCont != T000A8_A1477ConObraSocCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConObraSocCont");
               GXutil.writeLogRaw("Old: ",Z1477ConObraSocCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1477ConObraSocCont[0]);
            }
            if ( Z1478ConFonSolRedApo != T000A8_A1478ConFonSolRedApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConFonSolRedApo");
               GXutil.writeLogRaw("Old: ",Z1478ConFonSolRedApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1478ConFonSolRedApo[0]);
            }
            if ( Z1479ConFonSolRedCont != T000A8_A1479ConFonSolRedCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConFonSolRedCont");
               GXutil.writeLogRaw("Old: ",Z1479ConFonSolRedCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1479ConFonSolRedCont[0]);
            }
            if ( Z1480ConRenateaApo != T000A8_A1480ConRenateaApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRenateaApo");
               GXutil.writeLogRaw("Old: ",Z1480ConRenateaApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1480ConRenateaApo[0]);
            }
            if ( Z1481ConRenateaCont != T000A8_A1481ConRenateaCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRenateaCont");
               GXutil.writeLogRaw("Old: ",Z1481ConRenateaCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1481ConRenateaCont[0]);
            }
            if ( Z1482ConAsigFamCont != T000A8_A1482ConAsigFamCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConAsigFamCont");
               GXutil.writeLogRaw("Old: ",Z1482ConAsigFamCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1482ConAsigFamCont[0]);
            }
            if ( Z1483ConFonNacEmpCont != T000A8_A1483ConFonNacEmpCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConFonNacEmpCont");
               GXutil.writeLogRaw("Old: ",Z1483ConFonNacEmpCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1483ConFonNacEmpCont[0]);
            }
            if ( Z1484ConLeyRieTrabCont != T000A8_A1484ConLeyRieTrabCont[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConLeyRieTrabCont");
               GXutil.writeLogRaw("Old: ",Z1484ConLeyRieTrabCont);
               GXutil.writeLogRaw("Current: ",T000A8_A1484ConLeyRieTrabCont[0]);
            }
            if ( Z1485ConRegDifApo != T000A8_A1485ConRegDifApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRegDifApo");
               GXutil.writeLogRaw("Old: ",Z1485ConRegDifApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1485ConRegDifApo[0]);
            }
            if ( Z1486ConRegEspApo != T000A8_A1486ConRegEspApo[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRegEspApo");
               GXutil.writeLogRaw("Old: ",Z1486ConRegEspApo);
               GXutil.writeLogRaw("Current: ",T000A8_A1486ConRegEspApo[0]);
            }
            if ( Z1539ConSacDeven != T000A8_A1539ConSacDeven[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConSacDeven");
               GXutil.writeLogRaw("Old: ",Z1539ConSacDeven);
               GXutil.writeLogRaw("Current: ",T000A8_A1539ConSacDeven[0]);
            }
            if ( Z1620ConBaseLic != T000A8_A1620ConBaseLic[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseLic");
               GXutil.writeLogRaw("Old: ",Z1620ConBaseLic);
               GXutil.writeLogRaw("Current: ",T000A8_A1620ConBaseLic[0]);
            }
            if ( Z1797ConBaseLicProm != T000A8_A1797ConBaseLicProm[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseLicProm");
               GXutil.writeLogRaw("Old: ",Z1797ConBaseLicProm);
               GXutil.writeLogRaw("Current: ",T000A8_A1797ConBaseLicProm[0]);
            }
            if ( Z1621ConBaseFer != T000A8_A1621ConBaseFer[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseFer");
               GXutil.writeLogRaw("Old: ",Z1621ConBaseFer);
               GXutil.writeLogRaw("Current: ",T000A8_A1621ConBaseFer[0]);
            }
            if ( Z1798ConBaseFerProm != T000A8_A1798ConBaseFerProm[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseFerProm");
               GXutil.writeLogRaw("Old: ",Z1798ConBaseFerProm);
               GXutil.writeLogRaw("Current: ",T000A8_A1798ConBaseFerProm[0]);
            }
            if ( Z1622ConBaseHorExt != T000A8_A1622ConBaseHorExt[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseHorExt");
               GXutil.writeLogRaw("Old: ",Z1622ConBaseHorExt);
               GXutil.writeLogRaw("Current: ",T000A8_A1622ConBaseHorExt[0]);
            }
            if ( Z1799ConBaseHorExtProm != T000A8_A1799ConBaseHorExtProm[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseHorExtProm");
               GXutil.writeLogRaw("Old: ",Z1799ConBaseHorExtProm);
               GXutil.writeLogRaw("Current: ",T000A8_A1799ConBaseHorExtProm[0]);
            }
            if ( Z1800ConBasePres != T000A8_A1800ConBasePres[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBasePres");
               GXutil.writeLogRaw("Old: ",Z1800ConBasePres);
               GXutil.writeLogRaw("Current: ",T000A8_A1800ConBasePres[0]);
            }
            if ( Z1801ConBaseAnt != T000A8_A1801ConBaseAnt[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseAnt");
               GXutil.writeLogRaw("Old: ",Z1801ConBaseAnt);
               GXutil.writeLogRaw("Current: ",T000A8_A1801ConBaseAnt[0]);
            }
            if ( Z1827ConBaseOSDif != T000A8_A1827ConBaseOSDif[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseOSDif");
               GXutil.writeLogRaw("Old: ",Z1827ConBaseOSDif);
               GXutil.writeLogRaw("Current: ",T000A8_A1827ConBaseOSDif[0]);
            }
            if ( Z2191ConBaseAus != T000A8_A2191ConBaseAus[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseAus");
               GXutil.writeLogRaw("Old: ",Z2191ConBaseAus);
               GXutil.writeLogRaw("Current: ",T000A8_A2191ConBaseAus[0]);
            }
            if ( Z2192ConBaseAusProm != T000A8_A2192ConBaseAusProm[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConBaseAusProm");
               GXutil.writeLogRaw("Old: ",Z2192ConBaseAusProm);
               GXutil.writeLogRaw("Current: ",T000A8_A2192ConBaseAusProm[0]);
            }
            if ( GXutil.strcmp(Z1648ConCodAfip, T000A8_A1648ConCodAfip[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCodAfip");
               GXutil.writeLogRaw("Old: ",Z1648ConCodAfip);
               GXutil.writeLogRaw("Current: ",T000A8_A1648ConCodAfip[0]);
            }
            if ( Z1769ConCntPa != T000A8_A1769ConCntPa[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCntPa");
               GXutil.writeLogRaw("Old: ",Z1769ConCntPa);
               GXutil.writeLogRaw("Current: ",T000A8_A1769ConCntPa[0]);
            }
            if ( Z1821ConErrorSiCero != T000A8_A1821ConErrorSiCero[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConErrorSiCero");
               GXutil.writeLogRaw("Old: ",Z1821ConErrorSiCero);
               GXutil.writeLogRaw("Current: ",T000A8_A1821ConErrorSiCero[0]);
            }
            if ( Z1826ConPueNov != T000A8_A1826ConPueNov[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConPueNov");
               GXutil.writeLogRaw("Old: ",Z1826ConPueNov);
               GXutil.writeLogRaw("Current: ",T000A8_A1826ConPueNov[0]);
            }
            if ( Z1886ConRelSec != T000A8_A1886ConRelSec[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRelSec");
               GXutil.writeLogRaw("Old: ",Z1886ConRelSec);
               GXutil.writeLogRaw("Current: ",T000A8_A1886ConRelSec[0]);
            }
            if ( GXutil.strcmp(Z2013ConRelRef, T000A8_A2013ConRelRef[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConRelRef");
               GXutil.writeLogRaw("Old: ",Z2013ConRelRef);
               GXutil.writeLogRaw("Current: ",T000A8_A2013ConRelRef[0]);
            }
            if ( GXutil.strcmp(Z2185ConDescripSinAc, T000A8_A2185ConDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z2185ConDescripSinAc);
               GXutil.writeLogRaw("Current: ",T000A8_A2185ConDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z2187ConOblPalabra, T000A8_A2187ConOblPalabra[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConOblPalabra");
               GXutil.writeLogRaw("Old: ",Z2187ConOblPalabra);
               GXutil.writeLogRaw("Current: ",T000A8_A2187ConOblPalabra[0]);
            }
            if ( Z1822CliPadre != T000A8_A1822CliPadre[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"CliPadre");
               GXutil.writeLogRaw("Old: ",Z1822CliPadre);
               GXutil.writeLogRaw("Current: ",T000A8_A1822CliPadre[0]);
            }
            if ( Z1112AplIIGG != T000A8_A1112AplIIGG[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"AplIIGG");
               GXutil.writeLogRaw("Old: ",Z1112AplIIGG);
               GXutil.writeLogRaw("Current: ",T000A8_A1112AplIIGG[0]);
            }
            if ( GXutil.strcmp(Z37TipoConCod, T000A8_A37TipoConCod[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"TipoConCod");
               GXutil.writeLogRaw("Old: ",Z37TipoConCod);
               GXutil.writeLogRaw("Current: ",T000A8_A37TipoConCod[0]);
            }
            if ( GXutil.strcmp(Z38SubTipoConCod1, T000A8_A38SubTipoConCod1[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"SubTipoConCod1");
               GXutil.writeLogRaw("Old: ",Z38SubTipoConCod1);
               GXutil.writeLogRaw("Current: ",T000A8_A38SubTipoConCod1[0]);
            }
            if ( GXutil.strcmp(Z39SubTipoConCod2, T000A8_A39SubTipoConCod2[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"SubTipoConCod2");
               GXutil.writeLogRaw("Old: ",Z39SubTipoConCod2);
               GXutil.writeLogRaw("Current: ",T000A8_A39SubTipoConCod2[0]);
            }
            if ( GXutil.strcmp(Z953ConCondicion, T000A8_A953ConCondicion[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConCondicion");
               GXutil.writeLogRaw("Old: ",Z953ConCondicion);
               GXutil.writeLogRaw("Current: ",T000A8_A953ConCondicion[0]);
            }
            if ( Z1644ConceptoPais != T000A8_A1644ConceptoPais[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConceptoPais");
               GXutil.writeLogRaw("Old: ",Z1644ConceptoPais);
               GXutil.writeLogRaw("Current: ",T000A8_A1644ConceptoPais[0]);
            }
            if ( GXutil.strcmp(Z1645ConceptoConveCodigo, T000A8_A1645ConceptoConveCodigo[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConceptoConveCodigo");
               GXutil.writeLogRaw("Old: ",Z1645ConceptoConveCodigo);
               GXutil.writeLogRaw("Current: ",T000A8_A1645ConceptoConveCodigo[0]);
            }
            if ( GXutil.strcmp(Z921ConPadre, T000A8_A921ConPadre[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConPadre");
               GXutil.writeLogRaw("Old: ",Z921ConPadre);
               GXutil.writeLogRaw("Current: ",T000A8_A921ConPadre[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Concepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A7( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A7( 0) ;
         checkOptimisticConcurrency0A7( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A7( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A7( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A30 */
                  pr_default.execute(28, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A26ConCodigo, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Boolean.valueOf(A159ConVariable), Integer.valueOf(A1905ConRelSecCli), A1974ConOldValues, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A729ConFormulaPreResuelta, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Boolean.valueOf(n155ConTipoLiqGanancias), A155ConTipoLiqGanancias, A153ConObservacion, Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Byte.valueOf(A154ConTipo), A469ConCodOld, Boolean.valueOf(n487ConCuenDebe), A487ConCuenDebe, Boolean.valueOf(n488ConCuenHaber), A488ConCuenHaber, Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n969ConConveAux), A969ConConveAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, A720ConFormulaObs2, Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(n735ConAplicGan), Byte.valueOf(A735ConAplicGan), Boolean.valueOf(A762ConRecalcular), Boolean.valueOf(A894ConImportado), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(A922ConUsado), Boolean.valueOf(n951ConObliga), Boolean.valueOf(A951ConObliga), Boolean.valueOf(n952ConObligaSiSac), Boolean.valueOf(A952ConObligaSiSac), A954ConCondCodigo, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A1648ConCodAfip, Byte.valueOf(A1769ConCntPa), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Integer.valueOf(A1886ConRelSec), A2013ConRelRef, A2185ConDescripSinAc, Boolean.valueOf(n2187ConOblPalabra), A2187ConOblPalabra, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(28) == 1) )
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
                        processLevel0A7( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0A0( ) ;
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
            load0A7( ) ;
         }
         endLevel0A7( ) ;
      }
      closeExtendedTableCursors0A7( ) ;
   }

   public void update0A7( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A7( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A7( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A7( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A31 */
                  pr_default.execute(29, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Boolean.valueOf(A159ConVariable), Integer.valueOf(A1905ConRelSecCli), A1974ConOldValues, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A729ConFormulaPreResuelta, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Boolean.valueOf(n155ConTipoLiqGanancias), A155ConTipoLiqGanancias, A153ConObservacion, Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Byte.valueOf(A154ConTipo), A469ConCodOld, Boolean.valueOf(n487ConCuenDebe), A487ConCuenDebe, Boolean.valueOf(n488ConCuenHaber), A488ConCuenHaber, Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n969ConConveAux), A969ConConveAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, A720ConFormulaObs2, Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(n735ConAplicGan), Byte.valueOf(A735ConAplicGan), Boolean.valueOf(A762ConRecalcular), Boolean.valueOf(A894ConImportado), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(A922ConUsado), Boolean.valueOf(n951ConObliga), Boolean.valueOf(A951ConObliga), Boolean.valueOf(n952ConObligaSiSac), Boolean.valueOf(A952ConObligaSiSac), A954ConCondCodigo, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A1648ConCodAfip, Byte.valueOf(A1769ConCntPa), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Integer.valueOf(A1886ConRelSec), A2013ConRelRef, A2185ConDescripSinAc, Boolean.valueOf(n2187ConOblPalabra), A2187ConOblPalabra, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre, Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(29) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A7( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0A7( ) ;
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
         endLevel0A7( ) ;
      }
      closeExtendedTableCursors0A7( ) ;
   }

   public void deferredUpdate0A7( )
   {
   }

   public void delete( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A7( ) ;
         afterConfirm0A7( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A7( ) ;
            if ( AnyError == 0 )
            {
               scanStart0A261( ) ;
               while ( RcdFound261 != 0 )
               {
                  getByPrimaryKey0A261( ) ;
                  delete0A261( ) ;
                  scanNext0A261( ) ;
               }
               scanEnd0A261( ) ;
               scanStart0A8( ) ;
               while ( RcdFound8 != 0 )
               {
                  getByPrimaryKey0A8( ) ;
                  delete0A8( ) ;
                  scanNext0A8( ) ;
               }
               scanEnd0A8( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A32 */
                  pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
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
      }
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0A7( ) ;
      Gx_mode = sMode7 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0A7( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV37Pgmname = "Concepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
         gxasubtipoconcod1_html0A7( A37TipoConCod) ;
         chkConVariable.setVisible( ((GXutil.strcmp(A37TipoConCod, "REM_ARG")==0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
         if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
         {
            divConvariable_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
            {
               divConvariable_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
            }
         }
         cmbConAplicGan.setVisible( ((GXutil.strcmp(A37TipoConCod, "DES_ARG")!=0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
         if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
         {
            divConaplicgan_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 )
            {
               divConaplicgan_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
            }
         }
         gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000A33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T000A34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos remuneración actual", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T000A35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T000A36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T000A37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo_sueldosConceptos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T000A38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "concepto_operandos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T000A39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T000A40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_horasextras_por Dia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T000A41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T000A42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T000A43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T000A44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T000A45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Excepciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T000A46 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obligacion Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T000A47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obl Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T000A48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T000A49 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGOtros Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T000A50 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGCon Exen Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T000A51 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Tipo Apl IIGGConc Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor T000A52 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "condicion_exencion_iigg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor T000A53 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "siradig_codigos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor T000A54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor T000A55 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_dedducciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor T000A56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formula Historico", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor T000A57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
      }
   }

   public void processNestedLevel0A8( )
   {
      nGXsfl_128_idx = 0 ;
      while ( nGXsfl_128_idx < nRC_GXsfl_128 )
      {
         readRow0A8( ) ;
         if ( ( nRcdExists_8 != 0 ) || ( nIsMod_8 != 0 ) )
         {
            standaloneNotModal0A8( ) ;
            getKey0A8( ) ;
            if ( ( nRcdExists_8 == 0 ) && ( nRcdDeleted_8 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0A8( ) ;
            }
            else
            {
               if ( RcdFound8 != 0 )
               {
                  if ( ( nRcdDeleted_8 != 0 ) && ( nRcdExists_8 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0A8( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_8 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0A8( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_8 == 0 )
                  {
                     GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = dynTLiqCod.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( dynTLiqCod.getInternalname(), GXutil.rtrim( A32TLiqCod)) ;
         httpContext.changePostValue( chkConTLiqSinCausa.getInternalname(), GXutil.booltostr( A925ConTLiqSinCausa)) ;
         httpContext.changePostValue( chkConTLiqSinPre.getInternalname(), GXutil.booltostr( A926ConTLiqSinPre)) ;
         httpContext.changePostValue( "ZT_"+"Z32TLiqCod_"+sGXsfl_128_idx, GXutil.rtrim( Z32TLiqCod)) ;
         httpContext.changePostValue( "ZT_"+"Z925ConTLiqSinCausa_"+sGXsfl_128_idx, GXutil.booltostr( Z925ConTLiqSinCausa)) ;
         httpContext.changePostValue( "ZT_"+"Z926ConTLiqSinPre_"+sGXsfl_128_idx, GXutil.booltostr( Z926ConTLiqSinPre)) ;
         httpContext.changePostValue( "ZT_"+"Z950ConTLTipEgr_"+sGXsfl_128_idx, GXutil.rtrim( Z950ConTLTipEgr)) ;
         httpContext.changePostValue( "ZT_"+"Z1406ConTLOrdejec_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1407ConTLConOrd_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1407ConTLConOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1409ConTLVigencia_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1409ConTLVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1410ConTLCondicion_"+sGXsfl_128_idx, GXutil.rtrim( Z1410ConTLCondicion)) ;
         httpContext.changePostValue( "ZT_"+"Z1470ConTLConHab_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1788ConTLTipoCon_"+sGXsfl_128_idx, GXutil.rtrim( Z1788ConTLTipoCon)) ;
         httpContext.changePostValue( "ZT_"+"Z1789CONTLSegPla_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( Z1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_8_"+sGXsfl_128_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "N32TLiqCod_"+sGXsfl_128_idx, GXutil.rtrim( A32TLiqCod)) ;
         if ( nIsMod_8 != 0 )
         {
            httpContext.changePostValue( "TLIQCOD_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynTLiqCod.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONTLIQSINCAUSA_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinCausa.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONTLIQSINPRE_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinPre.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0A8( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_8 = (short)(0) ;
      nIsMod_8 = (short)(0) ;
      nRcdDeleted_8 = (short)(0) ;
   }

   public void processNestedLevel0A261( )
   {
      nGXsfl_134_idx = 0 ;
      while ( nGXsfl_134_idx < nRC_GXsfl_134 )
      {
         readRow0A261( ) ;
         if ( ( nRcdExists_261 != 0 ) || ( nIsMod_261 != 0 ) )
         {
            standaloneNotModal0A261( ) ;
            getKey0A261( ) ;
            if ( ( nRcdExists_261 == 0 ) && ( nRcdDeleted_261 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0A261( ) ;
            }
            else
            {
               if ( RcdFound261 != 0 )
               {
                  if ( ( nRcdDeleted_261 != 0 ) && ( nRcdExists_261 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0A261( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_261 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0A261( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_261 == 0 )
                  {
                     GXCCtl = "MEGCODIGO_" + sGXsfl_134_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMegCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMegCodigo_Internalname, GXutil.rtrim( A11MegCodigo)) ;
         httpContext.changePostValue( cmbMegPreaTipo.getInternalname(), GXutil.rtrim( A1532MegPreaTipo)) ;
         httpContext.changePostValue( cmbConMegDura.getInternalname(), GXutil.rtrim( A1534ConMegDura)) ;
         httpContext.changePostValue( edtConMegMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConMegSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z11MegCodigo_"+sGXsfl_134_idx, GXutil.rtrim( Z11MegCodigo)) ;
         httpContext.changePostValue( "ZT_"+"Z2077ConMegSec_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1532MegPreaTipo_"+sGXsfl_134_idx, GXutil.rtrim( Z1532MegPreaTipo)) ;
         httpContext.changePostValue( "ZT_"+"Z1530ConMegMeses_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1534ConMegDura_"+sGXsfl_134_idx, GXutil.rtrim( Z1534ConMegDura)) ;
         httpContext.changePostValue( "ZT_"+"Z1529ConMegPropor_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( Z1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_261_"+sGXsfl_134_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_261 != 0 )
         {
            httpContext.changePostValue( "MEGCODIGO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGPREATIPO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbMegPreaTipo.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGDURA_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbConMegDura.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGMESES_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegMeses_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONMEGSEC_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0A261( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_261 = (short)(0) ;
      nIsMod_261 = (short)(0) ;
      nRcdDeleted_261 = (short)(0) ;
   }

   public void processLevel0A7( )
   {
      /* Save parent mode. */
      sMode7 = Gx_mode ;
      processNestedLevel0A8( ) ;
      processNestedLevel0A261( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode7 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0A7( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(6);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "concepto");
         if ( AnyError == 0 )
         {
            confirmValues0A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "concepto");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0A7( )
   {
      /* Scan By routine */
      /* Using cursor T000A58 */
      pr_default.execute(56);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3CliCod = T000A58_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T000A58_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0A7( )
   {
      /* Scan next routine */
      pr_default.readNext(56);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3CliCod = T000A58_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T000A58_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
   }

   public void scanEnd0A7( )
   {
      pr_default.close(56);
   }

   public void afterConfirm0A7( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A7( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A7( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A7( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A7( )
   {
      /* Before Complete Rules */
      GXt_char10 = A156ConUsuModFor ;
      GXv_char11[0] = GXt_char10 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char11) ;
      concepto_impl.this.GXt_char10 = GXv_char11[0] ;
      A156ConUsuModFor = GXt_char10 ;
      n156ConUsuModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A156ConUsuModFor", A156ConUsuModFor);
      GXt_dtime12 = A145ConFchModFor ;
      GXv_dtime13[0] = GXt_dtime12 ;
      new web.getahora(remoteHandle, context).execute( AV7CliCod, GXv_dtime13) ;
      concepto_impl.this.GXt_dtime12 = GXv_dtime13[0] ;
      A145ConFchModFor = GXutil.resetMillis(GXt_dtime12) ;
      n145ConFchModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A145ConFchModFor", localUtil.ttoc( A145ConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
   }

   public void beforeValidate0A7( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A7( )
   {
      edtConFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Enabled), 5, 0), true);
      dynTipoConCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoConCod.getEnabled(), 5, 0), true);
      chkConVariable.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkConVariable.getEnabled(), 5, 0), true);
      cmbConAplicGan.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAplicGan.getEnabled(), 5, 0), true);
      dynSubTipoConCod1.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod1.getEnabled(), 5, 0), true);
      dynSubTipoConCod2.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Enabled", GXutil.ltrimstr( dynSubTipoConCod2.getEnabled(), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtConDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Enabled), 5, 0), true);
      chkConHabilitado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConHabilitado.getInternalname(), "Enabled", GXutil.ltrimstr( chkConHabilitado.getEnabled(), 5, 0), true);
      chkConCanti.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConCanti.getInternalname(), "Enabled", GXutil.ltrimstr( chkConCanti.getEnabled(), 5, 0), true);
      chkConValUni.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConValUni.getInternalname(), "Enabled", GXutil.ltrimstr( chkConValUni.getEnabled(), 5, 0), true);
      chkConImporte.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConImporte.getInternalname(), "Enabled", GXutil.ltrimstr( chkConImporte.getEnabled(), 5, 0), true);
      cmbConVigencia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConVigencia.getEnabled(), 5, 0), true);
      edtConObservacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Enabled), 5, 0), true);
      chkConRecalcular.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkConRecalcular.getEnabled(), 5, 0), true);
      edtConRangoCant_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRangoCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRangoCant_Enabled), 5, 0), true);
      cmbConPreReq.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConPreReq.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConPreReq.getEnabled(), 5, 0), true);
      cmbConAdelDescu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAdelDescu.getEnabled(), 5, 0), true);
      dynConCuenDebe.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConCuenDebe.getInternalname(), "Enabled", GXutil.ltrimstr( dynConCuenDebe.getEnabled(), 5, 0), true);
      dynConCuenHaber.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConCuenHaber.getInternalname(), "Enabled", GXutil.ltrimstr( dynConCuenHaber.getEnabled(), 5, 0), true);
      chkavEssistemaconceptosdefault.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavEssistemaconceptosdefault.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEssistemaconceptosdefault.getEnabled(), 5, 0), true);
      edtConRetGanPropor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRetGanPropor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRetGanPropor_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm0A8( int GX_JID )
   {
      if ( ( GX_JID == 100 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z925ConTLiqSinCausa = T000A6_A925ConTLiqSinCausa[0] ;
            Z926ConTLiqSinPre = T000A6_A926ConTLiqSinPre[0] ;
            Z950ConTLTipEgr = T000A6_A950ConTLTipEgr[0] ;
            Z1406ConTLOrdejec = T000A6_A1406ConTLOrdejec[0] ;
            Z1407ConTLConOrd = T000A6_A1407ConTLConOrd[0] ;
            Z1409ConTLVigencia = T000A6_A1409ConTLVigencia[0] ;
            Z1410ConTLCondicion = T000A6_A1410ConTLCondicion[0] ;
            Z1470ConTLConHab = T000A6_A1470ConTLConHab[0] ;
            Z1788ConTLTipoCon = T000A6_A1788ConTLTipoCon[0] ;
            Z1789CONTLSegPla = T000A6_A1789CONTLSegPla[0] ;
         }
         else
         {
            Z925ConTLiqSinCausa = A925ConTLiqSinCausa ;
            Z926ConTLiqSinPre = A926ConTLiqSinPre ;
            Z950ConTLTipEgr = A950ConTLTipEgr ;
            Z1406ConTLOrdejec = A1406ConTLOrdejec ;
            Z1407ConTLConOrd = A1407ConTLConOrd ;
            Z1409ConTLVigencia = A1409ConTLVigencia ;
            Z1410ConTLCondicion = A1410ConTLCondicion ;
            Z1470ConTLConHab = A1470ConTLConHab ;
            Z1788ConTLTipoCon = A1788ConTLTipoCon ;
            Z1789CONTLSegPla = A1789CONTLSegPla ;
         }
      }
      if ( GX_JID == -100 )
      {
         Z26ConCodigo = A26ConCodigo ;
         Z925ConTLiqSinCausa = A925ConTLiqSinCausa ;
         Z926ConTLiqSinPre = A926ConTLiqSinPre ;
         Z950ConTLTipEgr = A950ConTLTipEgr ;
         Z1406ConTLOrdejec = A1406ConTLOrdejec ;
         Z1407ConTLConOrd = A1407ConTLConOrd ;
         Z1409ConTLVigencia = A1409ConTLVigencia ;
         Z1410ConTLCondicion = A1410ConTLCondicion ;
         Z1470ConTLConHab = A1470ConTLConHab ;
         Z1788ConTLTipoCon = A1788ConTLTipoCon ;
         Z1789CONTLSegPla = A1789CONTLSegPla ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z340TliqDesc = A340TliqDesc ;
      }
   }

   public void standaloneNotModal0A8( )
   {
      gxatliqcod_html0A8( A3CliCod) ;
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) != 0 ) && ! AV17permiteModificacion )
      {
         dynTLiqCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      }
      else
      {
         dynTLiqCod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      }
   }

   public void standaloneModal0A8( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         dynTLiqCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T000A7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
         A340TliqDesc = T000A7_A340TliqDesc[0] ;
         pr_default.close(5);
      }
   }

   public void load0A8( )
   {
      /* Using cursor T000A59 */
      pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(57) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A340TliqDesc = T000A59_A340TliqDesc[0] ;
         A925ConTLiqSinCausa = T000A59_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = T000A59_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = T000A59_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = T000A59_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = T000A59_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = T000A59_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = T000A59_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = T000A59_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = T000A59_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = T000A59_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = T000A59_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = T000A59_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = T000A59_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = T000A59_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = T000A59_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = T000A59_n1789CONTLSegPla[0] ;
         zm0A8( -100) ;
      }
      pr_default.close(57);
      onLoadActions0A8( ) ;
   }

   public void onLoadActions0A8( )
   {
   }

   public void checkExtendedTable0A8( )
   {
      nIsDirty_8 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0A8( ) ;
      /* Using cursor T000A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(5) == 101) )
      {
         GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynTLiqCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A340TliqDesc = T000A7_A340TliqDesc[0] ;
      pr_default.close(5);
   }

   public void closeExtendedTableCursors0A8( )
   {
      pr_default.close(5);
   }

   public void enableDisable0A8( )
   {
   }

   public void gxload_101( int A3CliCod ,
                           String A32TLiqCod )
   {
      /* Using cursor T000A60 */
      pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(58) == 101) )
      {
         GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynTLiqCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A340TliqDesc = T000A60_A340TliqDesc[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A340TliqDesc)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(58) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(58);
   }

   public void getKey0A8( )
   {
      /* Using cursor T000A61 */
      pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(59) != 101) )
      {
         RcdFound8 = (short)(1) ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
      }
      pr_default.close(59);
   }

   public void getByPrimaryKey0A8( )
   {
      /* Using cursor T000A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0A8( 100) ;
         RcdFound8 = (short)(1) ;
         initializeNonKey0A8( ) ;
         A925ConTLiqSinCausa = T000A6_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = T000A6_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = T000A6_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = T000A6_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = T000A6_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = T000A6_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = T000A6_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = T000A6_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = T000A6_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = T000A6_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = T000A6_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = T000A6_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = T000A6_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = T000A6_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = T000A6_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = T000A6_n1789CONTLSegPla[0] ;
         A32TLiqCod = T000A6_A32TLiqCod[0] ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z32TLiqCod = A32TLiqCod ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0A8( ) ;
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound8 = (short)(0) ;
         initializeNonKey0A8( ) ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0A8( ) ;
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0A8( ) ;
      }
      pr_default.close(4);
   }

   public void checkOptimisticConcurrency0A8( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000A5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( Z925ConTLiqSinCausa != T000A5_A925ConTLiqSinCausa[0] ) || ( Z926ConTLiqSinPre != T000A5_A926ConTLiqSinPre[0] ) || ( GXutil.strcmp(Z950ConTLTipEgr, T000A5_A950ConTLTipEgr[0]) != 0 ) || ( Z1406ConTLOrdejec != T000A5_A1406ConTLOrdejec[0] ) || ( Z1407ConTLConOrd != T000A5_A1407ConTLConOrd[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1409ConTLVigencia != T000A5_A1409ConTLVigencia[0] ) || ( GXutil.strcmp(Z1410ConTLCondicion, T000A5_A1410ConTLCondicion[0]) != 0 ) || ( Z1470ConTLConHab != T000A5_A1470ConTLConHab[0] ) || ( GXutil.strcmp(Z1788ConTLTipoCon, T000A5_A1788ConTLTipoCon[0]) != 0 ) || ( Z1789CONTLSegPla != T000A5_A1789CONTLSegPla[0] ) )
         {
            if ( Z925ConTLiqSinCausa != T000A5_A925ConTLiqSinCausa[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLiqSinCausa");
               GXutil.writeLogRaw("Old: ",Z925ConTLiqSinCausa);
               GXutil.writeLogRaw("Current: ",T000A5_A925ConTLiqSinCausa[0]);
            }
            if ( Z926ConTLiqSinPre != T000A5_A926ConTLiqSinPre[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLiqSinPre");
               GXutil.writeLogRaw("Old: ",Z926ConTLiqSinPre);
               GXutil.writeLogRaw("Current: ",T000A5_A926ConTLiqSinPre[0]);
            }
            if ( GXutil.strcmp(Z950ConTLTipEgr, T000A5_A950ConTLTipEgr[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLTipEgr");
               GXutil.writeLogRaw("Old: ",Z950ConTLTipEgr);
               GXutil.writeLogRaw("Current: ",T000A5_A950ConTLTipEgr[0]);
            }
            if ( Z1406ConTLOrdejec != T000A5_A1406ConTLOrdejec[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLOrdejec");
               GXutil.writeLogRaw("Old: ",Z1406ConTLOrdejec);
               GXutil.writeLogRaw("Current: ",T000A5_A1406ConTLOrdejec[0]);
            }
            if ( Z1407ConTLConOrd != T000A5_A1407ConTLConOrd[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLConOrd");
               GXutil.writeLogRaw("Old: ",Z1407ConTLConOrd);
               GXutil.writeLogRaw("Current: ",T000A5_A1407ConTLConOrd[0]);
            }
            if ( Z1409ConTLVigencia != T000A5_A1409ConTLVigencia[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLVigencia");
               GXutil.writeLogRaw("Old: ",Z1409ConTLVigencia);
               GXutil.writeLogRaw("Current: ",T000A5_A1409ConTLVigencia[0]);
            }
            if ( GXutil.strcmp(Z1410ConTLCondicion, T000A5_A1410ConTLCondicion[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLCondicion");
               GXutil.writeLogRaw("Old: ",Z1410ConTLCondicion);
               GXutil.writeLogRaw("Current: ",T000A5_A1410ConTLCondicion[0]);
            }
            if ( Z1470ConTLConHab != T000A5_A1470ConTLConHab[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLConHab");
               GXutil.writeLogRaw("Old: ",Z1470ConTLConHab);
               GXutil.writeLogRaw("Current: ",T000A5_A1470ConTLConHab[0]);
            }
            if ( GXutil.strcmp(Z1788ConTLTipoCon, T000A5_A1788ConTLTipoCon[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConTLTipoCon");
               GXutil.writeLogRaw("Old: ",Z1788ConTLTipoCon);
               GXutil.writeLogRaw("Current: ",T000A5_A1788ConTLTipoCon[0]);
            }
            if ( Z1789CONTLSegPla != T000A5_A1789CONTLSegPla[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"CONTLSegPla");
               GXutil.writeLogRaw("Old: ",Z1789CONTLSegPla);
               GXutil.writeLogRaw("Current: ",T000A5_A1789CONTLSegPla[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoTipoLiquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A8( )
   {
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A8( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A8( 0) ;
         checkOptimisticConcurrency0A8( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A8( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A8( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A62 */
                  pr_default.execute(60, new Object[] {A26ConCodigo, Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(60) == 1) )
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
            load0A8( ) ;
         }
         endLevel0A8( ) ;
      }
      closeExtendedTableCursors0A8( ) ;
   }

   public void update0A8( )
   {
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A8( ) ;
      }
      if ( ( nIsMod_8 != 0 ) || ( nIsDirty_8 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0A8( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0A8( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0A8( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000A63 */
                     pr_default.execute(61, new Object[] {Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                     if ( (pr_default.getStatus(61) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0A8( ) ;
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
            endLevel0A8( ) ;
         }
      }
      closeExtendedTableCursors0A8( ) ;
   }

   public void deferredUpdate0A8( )
   {
   }

   public void delete0A8( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A8( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A8( ) ;
         afterConfirm0A8( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A8( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000A64 */
               pr_default.execute(62, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
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
      sMode8 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0A8( ) ;
      Gx_mode = sMode8 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0A8( )
   {
      standaloneModal0A8( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000A65 */
         pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
         A340TliqDesc = T000A65_A340TliqDesc[0] ;
         pr_default.close(63);
      }
   }

   public void endLevel0A8( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0A8( )
   {
      /* Scan By routine */
      /* Using cursor T000A66 */
      pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(64) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A32TLiqCod = T000A66_A32TLiqCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0A8( )
   {
      /* Scan next routine */
      pr_default.readNext(64);
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(64) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A32TLiqCod = T000A66_A32TLiqCod[0] ;
      }
   }

   public void scanEnd0A8( )
   {
      pr_default.close(64);
   }

   public void afterConfirm0A8( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A8( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A8( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A8( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A8( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A8( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A8( )
   {
      dynTLiqCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      chkConTLiqSinCausa.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinCausa.getInternalname(), "Enabled", GXutil.ltrimstr( chkConTLiqSinCausa.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      chkConTLiqSinPre.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinPre.getInternalname(), "Enabled", GXutil.ltrimstr( chkConTLiqSinPre.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
   }

   public void send_integrity_lvl_hashes0A8( )
   {
   }

   public void zm0A261( int GX_JID )
   {
      if ( ( GX_JID == 102 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1532MegPreaTipo = T000A3_A1532MegPreaTipo[0] ;
            Z1530ConMegMeses = T000A3_A1530ConMegMeses[0] ;
            Z1534ConMegDura = T000A3_A1534ConMegDura[0] ;
            Z1529ConMegPropor = T000A3_A1529ConMegPropor[0] ;
         }
         else
         {
            Z1532MegPreaTipo = A1532MegPreaTipo ;
            Z1530ConMegMeses = A1530ConMegMeses ;
            Z1534ConMegDura = A1534ConMegDura ;
            Z1529ConMegPropor = A1529ConMegPropor ;
         }
      }
      if ( GX_JID == -102 )
      {
         Z26ConCodigo = A26ConCodigo ;
         Z2077ConMegSec = A2077ConMegSec ;
         Z1532MegPreaTipo = A1532MegPreaTipo ;
         Z1530ConMegMeses = A1530ConMegMeses ;
         Z1534ConMegDura = A1534ConMegDura ;
         Z1529ConMegPropor = A1529ConMegPropor ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
      }
   }

   public void standaloneNotModal0A261( )
   {
   }

   public void standaloneModal0A261( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      }
      else
      {
         edtMegCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtConMegSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConMegSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegSec_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      }
      else
      {
         edtConMegSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConMegSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegSec_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      }
   }

   public void load0A261( )
   {
      /* Using cursor T000A67 */
      pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(65) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A1532MegPreaTipo = T000A67_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = T000A67_A1530ConMegMeses[0] ;
         A1534ConMegDura = T000A67_A1534ConMegDura[0] ;
         A1529ConMegPropor = T000A67_A1529ConMegPropor[0] ;
         zm0A261( -102) ;
      }
      pr_default.close(65);
      onLoadActions0A261( ) ;
   }

   public void onLoadActions0A261( )
   {
   }

   public void checkExtendedTable0A261( )
   {
      nIsDirty_261 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0A261( ) ;
      /* Using cursor T000A4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "MEGCODIGO_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000A68 */
      pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(66) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Código", "")+","+httpContext.getMessage( "Motivo Egreso", "")+","+httpContext.getMessage( "Preaviso", "")+","+httpContext.getMessage( "Con antiguedad mayor a", "")+","+httpContext.getMessage( "meses o años", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(66);
      if ( ! ( ( GXutil.strcmp(A1532MegPreaTipo, "CON") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "SIN") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "") == 0 ) ) )
      {
         GXCCtl = "MEGPREATIPO_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Preaviso", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMegPreaTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1534ConMegDura, "años") == 0 ) || ( GXutil.strcmp(A1534ConMegDura, "meses") == 0 ) ) )
      {
         GXCCtl = "CONMEGDURA_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "meses o años", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConMegDura.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0A261( )
   {
      pr_default.close(2);
   }

   public void enableDisable0A261( )
   {
   }

   public void gxload_104( int A3CliCod ,
                           String A11MegCodigo )
   {
      /* Using cursor T000A69 */
      pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(67) == 101) )
      {
         GXCCtl = "MEGCODIGO_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(67) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(67);
   }

   public void getKey0A261( )
   {
      /* Using cursor T000A70 */
      pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound261 = (short)(1) ;
      }
      else
      {
         RcdFound261 = (short)(0) ;
      }
      pr_default.close(68);
   }

   public void getByPrimaryKey0A261( )
   {
      /* Using cursor T000A3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0A261( 102) ;
         RcdFound261 = (short)(1) ;
         initializeNonKey0A261( ) ;
         A2077ConMegSec = T000A3_A2077ConMegSec[0] ;
         A1532MegPreaTipo = T000A3_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = T000A3_A1530ConMegMeses[0] ;
         A1534ConMegDura = T000A3_A1534ConMegDura[0] ;
         A1529ConMegPropor = T000A3_A1529ConMegPropor[0] ;
         A11MegCodigo = T000A3_A11MegCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z11MegCodigo = A11MegCodigo ;
         Z2077ConMegSec = A2077ConMegSec ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0A261( ) ;
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound261 = (short)(0) ;
         initializeNonKey0A261( ) ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0A261( ) ;
         Gx_mode = sMode261 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0A261( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0A261( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000A2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1532MegPreaTipo, T000A2_A1532MegPreaTipo[0]) != 0 ) || ( Z1530ConMegMeses != T000A2_A1530ConMegMeses[0] ) || ( GXutil.strcmp(Z1534ConMegDura, T000A2_A1534ConMegDura[0]) != 0 ) || ( DecimalUtil.compareTo(Z1529ConMegPropor, T000A2_A1529ConMegPropor[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1532MegPreaTipo, T000A2_A1532MegPreaTipo[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"MegPreaTipo");
               GXutil.writeLogRaw("Old: ",Z1532MegPreaTipo);
               GXutil.writeLogRaw("Current: ",T000A2_A1532MegPreaTipo[0]);
            }
            if ( Z1530ConMegMeses != T000A2_A1530ConMegMeses[0] )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConMegMeses");
               GXutil.writeLogRaw("Old: ",Z1530ConMegMeses);
               GXutil.writeLogRaw("Current: ",T000A2_A1530ConMegMeses[0]);
            }
            if ( GXutil.strcmp(Z1534ConMegDura, T000A2_A1534ConMegDura[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConMegDura");
               GXutil.writeLogRaw("Old: ",Z1534ConMegDura);
               GXutil.writeLogRaw("Current: ",T000A2_A1534ConMegDura[0]);
            }
            if ( DecimalUtil.compareTo(Z1529ConMegPropor, T000A2_A1529ConMegPropor[0]) != 0 )
            {
               GXutil.writeLogln("concepto:[seudo value changed for attri]"+"ConMegPropor");
               GXutil.writeLogRaw("Old: ",Z1529ConMegPropor);
               GXutil.writeLogRaw("Current: ",T000A2_A1529ConMegPropor[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoMotivosEgreso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A261( )
   {
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A261( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A261( 0) ;
         checkOptimisticConcurrency0A261( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A261( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A261( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A71 */
                  pr_default.execute(69, new Object[] {A26ConCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                  if ( (pr_default.getStatus(69) == 1) )
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
            load0A261( ) ;
         }
         endLevel0A261( ) ;
      }
      closeExtendedTableCursors0A261( ) ;
   }

   public void update0A261( )
   {
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A261( ) ;
      }
      if ( ( nIsMod_261 != 0 ) || ( nIsDirty_261 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0A261( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0A261( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0A261( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000A72 */
                     pr_default.execute(70, new Object[] {A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                     if ( (pr_default.getStatus(70) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0A261( ) ;
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
            endLevel0A261( ) ;
         }
      }
      closeExtendedTableCursors0A261( ) ;
   }

   public void deferredUpdate0A261( )
   {
   }

   public void delete0A261( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A261( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A261( ) ;
         afterConfirm0A261( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A261( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000A73 */
               pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
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
      sMode261 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0A261( ) ;
      Gx_mode = sMode261 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0A261( )
   {
      standaloneModal0A261( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0A261( )
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

   public void scanStart0A261( )
   {
      /* Scan By routine */
      /* Using cursor T000A74 */
      pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      RcdFound261 = (short)(0) ;
      if ( (pr_default.getStatus(72) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A11MegCodigo = T000A74_A11MegCodigo[0] ;
         A2077ConMegSec = T000A74_A2077ConMegSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0A261( )
   {
      /* Scan next routine */
      pr_default.readNext(72);
      RcdFound261 = (short)(0) ;
      if ( (pr_default.getStatus(72) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A11MegCodigo = T000A74_A11MegCodigo[0] ;
         A2077ConMegSec = T000A74_A2077ConMegSec[0] ;
      }
   }

   public void scanEnd0A261( )
   {
      pr_default.close(72);
   }

   public void afterConfirm0A261( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A261( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A261( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A261( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A261( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A261( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A261( )
   {
      edtMegCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      cmbMegPreaTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMegPreaTipo.getEnabled(), 5, 0), !bGXsfl_134_Refreshing);
      cmbConMegDura.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConMegDura.getEnabled(), 5, 0), !bGXsfl_134_Refreshing);
      edtConMegMeses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConMegMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegMeses_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      edtConMegSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConMegSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegSec_Enabled), 5, 0), !bGXsfl_134_Refreshing);
   }

   public void send_integrity_lvl_hashes0A261( )
   {
   }

   public void send_integrity_lvl_hashes0A7( )
   {
   }

   public void subsflControlProps_1288( )
   {
      dynTLiqCod.setInternalname( "TLIQCOD_"+sGXsfl_128_idx );
      chkConTLiqSinCausa.setInternalname( "CONTLIQSINCAUSA_"+sGXsfl_128_idx );
      chkConTLiqSinPre.setInternalname( "CONTLIQSINPRE_"+sGXsfl_128_idx );
   }

   public void subsflControlProps_fel_1288( )
   {
      dynTLiqCod.setInternalname( "TLIQCOD_"+sGXsfl_128_fel_idx );
      chkConTLiqSinCausa.setInternalname( "CONTLIQSINCAUSA_"+sGXsfl_128_fel_idx );
      chkConTLiqSinPre.setInternalname( "CONTLIQSINPRE_"+sGXsfl_128_fel_idx );
   }

   public void addRow0A8( )
   {
      nGXsfl_128_idx = (int)(nGXsfl_128_idx+1) ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1288( ) ;
      sendRow0A8( ) ;
   }

   public void sendRow0A8( )
   {
      Gridlevel_tipoliquidacionRow = GXWebRow.GetNew(context) ;
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
         if ( ((int)((nGXsfl_128_idx) % (2))) == 0 )
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
      gxatliqcod_html0A8( A3CliCod) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_8_" + sGXsfl_128_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 129,'',false,'" + sGXsfl_128_idx + "',128)\"" ;
      GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
      dynTLiqCod.setName( GXCCtl );
      dynTLiqCod.setWebtags( "" );
      /* ComboBox */
      Gridlevel_tipoliquidacionRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynTLiqCod,dynTLiqCod.getInternalname(),GXutil.rtrim( A32TLiqCod),Integer.valueOf(1),dynTLiqCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(dynTLiqCod.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,129);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynTLiqCod.setValue( GXutil.rtrim( A32TLiqCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Values", dynTLiqCod.ToJavascriptSource(), !bGXsfl_128_Refreshing);
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_8_" + sGXsfl_128_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 130,'',false,'" + sGXsfl_128_idx + "',128)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "CONTLIQSINCAUSA_" + sGXsfl_128_idx ;
      chkConTLiqSinCausa.setName( GXCCtl );
      chkConTLiqSinCausa.setWebtags( "" );
      chkConTLiqSinCausa.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinCausa.getInternalname(), "TitleCaption", chkConTLiqSinCausa.getCaption(), !bGXsfl_128_Refreshing);
      chkConTLiqSinCausa.setCheckedValue( "false" );
      A925ConTLiqSinCausa = GXutil.strtobool( GXutil.booltostr( A925ConTLiqSinCausa)) ;
      n925ConTLiqSinCausa = false ;
      Gridlevel_tipoliquidacionRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConTLiqSinCausa.getInternalname(),GXutil.booltostr( A925ConTLiqSinCausa),"","",Integer.valueOf(-1),Integer.valueOf(chkConTLiqSinCausa.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(130, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,130);\""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_8_" + sGXsfl_128_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 131,'',false,'" + sGXsfl_128_idx + "',128)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "CONTLIQSINPRE_" + sGXsfl_128_idx ;
      chkConTLiqSinPre.setName( GXCCtl );
      chkConTLiqSinPre.setWebtags( "" );
      chkConTLiqSinPre.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinPre.getInternalname(), "TitleCaption", chkConTLiqSinPre.getCaption(), !bGXsfl_128_Refreshing);
      chkConTLiqSinPre.setCheckedValue( "false" );
      A926ConTLiqSinPre = GXutil.strtobool( GXutil.booltostr( A926ConTLiqSinPre)) ;
      n926ConTLiqSinPre = false ;
      Gridlevel_tipoliquidacionRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConTLiqSinPre.getInternalname(),GXutil.booltostr( A926ConTLiqSinPre),"","",Integer.valueOf(-1),Integer.valueOf(chkConTLiqSinPre.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(131, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,131);\""});
      httpContext.ajax_sending_grid_row(Gridlevel_tipoliquidacionRow);
      send_integrity_lvl_hashes0A8( ) ;
      GXCCtl = "Z32TLiqCod_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z32TLiqCod));
      GXCCtl = "Z925ConTLiqSinCausa_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z925ConTLiqSinCausa);
      GXCCtl = "Z926ConTLiqSinPre_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z926ConTLiqSinPre);
      GXCCtl = "Z950ConTLTipEgr_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z950ConTLTipEgr));
      GXCCtl = "Z1406ConTLOrdejec_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1407ConTLConOrd_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1407ConTLConOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1409ConTLVigencia_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1409ConTLVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1410ConTLCondicion_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1410ConTLCondicion));
      GXCCtl = "Z1470ConTLConHab_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1788ConTLTipoCon_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1788ConTLTipoCon));
      GXCCtl = "Z1789CONTLSegPla_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_8_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_8_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_8_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_8, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "N32TLiqCod_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A32TLiqCod));
      GXCCtl = "vMODE_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "APLIIGG_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vDEFAULTCONCODIGO_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV27defaultConCodigo));
      GXCCtl = "vCONCODIGO_" + sGXsfl_128_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV11ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQCOD_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynTLiqCod.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLIQSINCAUSA_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinCausa.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLIQSINPRE_"+sGXsfl_128_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinPre.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_tipoliquidacionContainer.AddRow(Gridlevel_tipoliquidacionRow);
   }

   public void readRow0A8( )
   {
      nGXsfl_128_idx = (int)(nGXsfl_128_idx+1) ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1288( ) ;
      dynTLiqCod.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQCOD_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkConTLiqSinCausa.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONTLIQSINCAUSA_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkConTLiqSinPre.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONTLIQSINPRE_"+sGXsfl_128_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynTLiqCod.setName( dynTLiqCod.getInternalname() );
      dynTLiqCod.setValue( httpContext.cgiGet( dynTLiqCod.getInternalname()) );
      A32TLiqCod = httpContext.cgiGet( dynTLiqCod.getInternalname()) ;
      A925ConTLiqSinCausa = GXutil.strtobool( httpContext.cgiGet( chkConTLiqSinCausa.getInternalname())) ;
      n925ConTLiqSinCausa = false ;
      n925ConTLiqSinCausa = ((false==A925ConTLiqSinCausa) ? true : false) ;
      A926ConTLiqSinPre = GXutil.strtobool( httpContext.cgiGet( chkConTLiqSinPre.getInternalname())) ;
      n926ConTLiqSinPre = false ;
      n926ConTLiqSinPre = ((false==A926ConTLiqSinPre) ? true : false) ;
      GXCCtl = "Z32TLiqCod_" + sGXsfl_128_idx ;
      Z32TLiqCod = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z925ConTLiqSinCausa_" + sGXsfl_128_idx ;
      Z925ConTLiqSinCausa = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      n925ConTLiqSinCausa = ((false==A925ConTLiqSinCausa) ? true : false) ;
      GXCCtl = "Z926ConTLiqSinPre_" + sGXsfl_128_idx ;
      Z926ConTLiqSinPre = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      n926ConTLiqSinPre = ((false==A926ConTLiqSinPre) ? true : false) ;
      GXCCtl = "Z950ConTLTipEgr_" + sGXsfl_128_idx ;
      Z950ConTLTipEgr = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1406ConTLOrdejec_" + sGXsfl_128_idx ;
      Z1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z1407ConTLConOrd_" + sGXsfl_128_idx ;
      Z1407ConTLConOrd = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1409ConTLVigencia_" + sGXsfl_128_idx ;
      Z1409ConTLVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
      GXCCtl = "Z1410ConTLCondicion_" + sGXsfl_128_idx ;
      Z1410ConTLCondicion = httpContext.cgiGet( GXCCtl) ;
      n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
      GXCCtl = "Z1470ConTLConHab_" + sGXsfl_128_idx ;
      Z1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1788ConTLTipoCon_" + sGXsfl_128_idx ;
      Z1788ConTLTipoCon = httpContext.cgiGet( GXCCtl) ;
      n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
      GXCCtl = "Z1789CONTLSegPla_" + sGXsfl_128_idx ;
      Z1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
      GXCCtl = "Z950ConTLTipEgr_" + sGXsfl_128_idx ;
      A950ConTLTipEgr = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1406ConTLOrdejec_" + sGXsfl_128_idx ;
      A1406ConTLOrdejec = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z1407ConTLConOrd_" + sGXsfl_128_idx ;
      A1407ConTLConOrd = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1409ConTLVigencia_" + sGXsfl_128_idx ;
      A1409ConTLVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n1409ConTLVigencia = false ;
      n1409ConTLVigencia = ((0==A1409ConTLVigencia) ? true : false) ;
      GXCCtl = "Z1410ConTLCondicion_" + sGXsfl_128_idx ;
      A1410ConTLCondicion = httpContext.cgiGet( GXCCtl) ;
      n1410ConTLCondicion = false ;
      n1410ConTLCondicion = ((GXutil.strcmp("", A1410ConTLCondicion)==0) ? true : false) ;
      GXCCtl = "Z1470ConTLConHab_" + sGXsfl_128_idx ;
      A1470ConTLConHab = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1788ConTLTipoCon_" + sGXsfl_128_idx ;
      A1788ConTLTipoCon = httpContext.cgiGet( GXCCtl) ;
      n1788ConTLTipoCon = false ;
      n1788ConTLTipoCon = ((GXutil.strcmp("", A1788ConTLTipoCon)==0) ? true : false) ;
      GXCCtl = "Z1789CONTLSegPla_" + sGXsfl_128_idx ;
      A1789CONTLSegPla = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n1789CONTLSegPla = false ;
      n1789CONTLSegPla = ((0==A1789CONTLSegPla) ? true : false) ;
      GXCCtl = "nRcdDeleted_8_" + sGXsfl_128_idx ;
      nRcdDeleted_8 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_8_" + sGXsfl_128_idx ;
      nRcdExists_8 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_8_" + sGXsfl_128_idx ;
      nIsMod_8 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "N32TLiqCod_" + sGXsfl_128_idx ;
      N32TLiqCod = httpContext.cgiGet( GXCCtl) ;
   }

   public void subsflControlProps_134261( )
   {
      edtMegCodigo_Internalname = "MEGCODIGO_"+sGXsfl_134_idx ;
      cmbMegPreaTipo.setInternalname( "MEGPREATIPO_"+sGXsfl_134_idx );
      cmbConMegDura.setInternalname( "CONMEGDURA_"+sGXsfl_134_idx );
      edtConMegMeses_Internalname = "CONMEGMESES_"+sGXsfl_134_idx ;
      edtConMegSec_Internalname = "CONMEGSEC_"+sGXsfl_134_idx ;
   }

   public void subsflControlProps_fel_134261( )
   {
      edtMegCodigo_Internalname = "MEGCODIGO_"+sGXsfl_134_fel_idx ;
      cmbMegPreaTipo.setInternalname( "MEGPREATIPO_"+sGXsfl_134_fel_idx );
      cmbConMegDura.setInternalname( "CONMEGDURA_"+sGXsfl_134_fel_idx );
      edtConMegMeses_Internalname = "CONMEGMESES_"+sGXsfl_134_fel_idx ;
      edtConMegSec_Internalname = "CONMEGSEC_"+sGXsfl_134_fel_idx ;
   }

   public void addRow0A261( )
   {
      nGXsfl_134_idx = (int)(nGXsfl_134_idx+1) ;
      sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_134261( ) ;
      sendRow0A261( ) ;
   }

   public void sendRow0A261( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_134_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_261_" + sGXsfl_134_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 135,'',false,'" + sGXsfl_134_idx + "',134)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMegCodigo_Internalname,GXutil.rtrim( A11MegCodigo),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,135);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMegCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMegCodigo_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(134),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_261_" + sGXsfl_134_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 136,'',false,'" + sGXsfl_134_idx + "',134)\"" ;
      if ( ( cmbMegPreaTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "MEGPREATIPO_" + sGXsfl_134_idx ;
         cmbMegPreaTipo.setName( GXCCtl );
         cmbMegPreaTipo.setWebtags( "" );
         cmbMegPreaTipo.addItem("CON", httpContext.getMessage( "Con preaviso", ""), (short)(0));
         cmbMegPreaTipo.addItem("SIN", httpContext.getMessage( "Sin preaviso", ""), (short)(0));
         cmbMegPreaTipo.addItem("", httpContext.getMessage( "Ambos (Con o sin preaviso)", ""), (short)(0));
         if ( cmbMegPreaTipo.getItemCount() > 0 )
         {
            A1532MegPreaTipo = cmbMegPreaTipo.getValidValue(A1532MegPreaTipo) ;
         }
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbMegPreaTipo,cmbMegPreaTipo.getInternalname(),GXutil.rtrim( A1532MegPreaTipo),Integer.valueOf(1),cmbMegPreaTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbMegPreaTipo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,136);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbMegPreaTipo.setValue( GXutil.rtrim( A1532MegPreaTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMegPreaTipo.getInternalname(), "Values", cmbMegPreaTipo.ToJavascriptSource(), !bGXsfl_134_Refreshing);
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_261_" + sGXsfl_134_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 137,'',false,'" + sGXsfl_134_idx + "',134)\"" ;
      if ( ( cmbConMegDura.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CONMEGDURA_" + sGXsfl_134_idx ;
         cmbConMegDura.setName( GXCCtl );
         cmbConMegDura.setWebtags( "" );
         cmbConMegDura.addItem("años", httpContext.getMessage( "años", ""), (short)(0));
         cmbConMegDura.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
         if ( cmbConMegDura.getItemCount() > 0 )
         {
            A1534ConMegDura = cmbConMegDura.getValidValue(A1534ConMegDura) ;
         }
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConMegDura,cmbConMegDura.getInternalname(),GXutil.rtrim( A1534ConMegDura),Integer.valueOf(1),cmbConMegDura.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbConMegDura.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,137);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbConMegDura.setValue( GXutil.rtrim( A1534ConMegDura) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConMegDura.getInternalname(), "Values", cmbConMegDura.ToJavascriptSource(), !bGXsfl_134_Refreshing);
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_261_" + sGXsfl_134_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 138,'',false,'" + sGXsfl_134_idx + "',134)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConMegMeses_Internalname,GXutil.ltrim( localUtil.ntoc( A1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConMegMeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1530ConMegMeses), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1530ConMegMeses), "Z9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,138);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConMegMeses_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConMegMeses_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(134),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_261_" + sGXsfl_134_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 139,'',false,'" + sGXsfl_134_idx + "',134)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConMegSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2077ConMegSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,139);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConMegSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConMegSec_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(134),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes0A261( ) ;
      GXCCtl = "Z11MegCodigo_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z11MegCodigo));
      GXCCtl = "Z2077ConMegSec_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2077ConMegSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1532MegPreaTipo_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1532MegPreaTipo));
      GXCCtl = "Z1530ConMegMeses_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1530ConMegMeses, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1534ConMegDura_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1534ConMegDura));
      GXCCtl = "Z1529ConMegPropor_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_261_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_261_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_261_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_261, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "APLIIGG_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vDEFAULTCONCODIGO_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV27defaultConCodigo));
      GXCCtl = "vCONCODIGO_" + sGXsfl_134_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV11ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGCODIGO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGPREATIPO_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbMegPreaTipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONMEGDURA_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbConMegDura.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONMEGMESES_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegMeses_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONMEGSEC_"+sGXsfl_134_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow0A261( )
   {
      nGXsfl_134_idx = (int)(nGXsfl_134_idx+1) ;
      sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_134261( ) ;
      edtMegCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MEGCODIGO_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbMegPreaTipo.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGPREATIPO_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      cmbConMegDura.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGDURA_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtConMegMeses_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGMESES_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConMegSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONMEGSEC_"+sGXsfl_134_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A11MegCodigo = httpContext.cgiGet( edtMegCodigo_Internalname) ;
      cmbMegPreaTipo.setName( cmbMegPreaTipo.getInternalname() );
      cmbMegPreaTipo.setValue( httpContext.cgiGet( cmbMegPreaTipo.getInternalname()) );
      A1532MegPreaTipo = httpContext.cgiGet( cmbMegPreaTipo.getInternalname()) ;
      cmbConMegDura.setName( cmbConMegDura.getInternalname() );
      cmbConMegDura.setValue( httpContext.cgiGet( cmbConMegDura.getInternalname()) );
      A1534ConMegDura = httpContext.cgiGet( cmbConMegDura.getInternalname()) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
      {
         GXCCtl = "CONMEGMESES_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConMegMeses_Internalname ;
         wbErr = true ;
         A1530ConMegMeses = (byte)(0) ;
      }
      else
      {
         A1530ConMegMeses = (byte)(localUtil.ctol( httpContext.cgiGet( edtConMegMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConMegSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConMegSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CONMEGSEC_" + sGXsfl_134_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConMegSec_Internalname ;
         wbErr = true ;
         A2077ConMegSec = (short)(0) ;
      }
      else
      {
         A2077ConMegSec = (short)(localUtil.ctol( httpContext.cgiGet( edtConMegSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z11MegCodigo_" + sGXsfl_134_idx ;
      Z11MegCodigo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2077ConMegSec_" + sGXsfl_134_idx ;
      Z2077ConMegSec = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1532MegPreaTipo_" + sGXsfl_134_idx ;
      Z1532MegPreaTipo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1530ConMegMeses_" + sGXsfl_134_idx ;
      Z1530ConMegMeses = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1534ConMegDura_" + sGXsfl_134_idx ;
      Z1534ConMegDura = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1529ConMegPropor_" + sGXsfl_134_idx ;
      Z1529ConMegPropor = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1529ConMegPropor_" + sGXsfl_134_idx ;
      A1529ConMegPropor = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_261_" + sGXsfl_134_idx ;
      nRcdDeleted_261 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_261_" + sGXsfl_134_idx ;
      nRcdExists_261 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_261_" + sGXsfl_134_idx ;
      nIsMod_261 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtConMegSec_Enabled = edtConMegSec_Enabled ;
      defedtMegCodigo_Enabled = edtMegCodigo_Enabled ;
      defdynTLiqCod_Enabled = dynTLiqCod.getEnabled() ;
      defdynTLiqCod_Enabled = dynTLiqCod.getEnabled() ;
   }

   public void confirmValues0A0( )
   {
      nGXsfl_128_idx = 0 ;
      sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1288( ) ;
      while ( nGXsfl_128_idx < nRC_GXsfl_128 )
      {
         nGXsfl_128_idx = (int)(nGXsfl_128_idx+1) ;
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1288( ) ;
         httpContext.changePostValue( "Z32TLiqCod_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z32TLiqCod_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z32TLiqCod_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z925ConTLiqSinCausa_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z925ConTLiqSinCausa_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z925ConTLiqSinCausa_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z926ConTLiqSinPre_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z926ConTLiqSinPre_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z926ConTLiqSinPre_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z950ConTLTipEgr_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z950ConTLTipEgr_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z950ConTLTipEgr_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1406ConTLOrdejec_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1406ConTLOrdejec_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1406ConTLOrdejec_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1407ConTLConOrd_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1407ConTLConOrd_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1407ConTLConOrd_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1409ConTLVigencia_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1409ConTLVigencia_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1409ConTLVigencia_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1410ConTLCondicion_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1410ConTLCondicion_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1410ConTLCondicion_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1470ConTLConHab_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1470ConTLConHab_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1470ConTLConHab_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1788ConTLTipoCon_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1788ConTLTipoCon_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1788ConTLTipoCon_"+sGXsfl_128_idx) ;
         httpContext.changePostValue( "Z1789CONTLSegPla_"+sGXsfl_128_idx, httpContext.cgiGet( "ZT_"+"Z1789CONTLSegPla_"+sGXsfl_128_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1789CONTLSegPla_"+sGXsfl_128_idx) ;
      }
      nGXsfl_134_idx = 0 ;
      sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_134261( ) ;
      while ( nGXsfl_134_idx < nRC_GXsfl_134 )
      {
         nGXsfl_134_idx = (int)(nGXsfl_134_idx+1) ;
         sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_134261( ) ;
         httpContext.changePostValue( "Z11MegCodigo_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z11MegCodigo_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z11MegCodigo_"+sGXsfl_134_idx) ;
         httpContext.changePostValue( "Z2077ConMegSec_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z2077ConMegSec_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2077ConMegSec_"+sGXsfl_134_idx) ;
         httpContext.changePostValue( "Z1532MegPreaTipo_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z1532MegPreaTipo_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1532MegPreaTipo_"+sGXsfl_134_idx) ;
         httpContext.changePostValue( "Z1530ConMegMeses_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z1530ConMegMeses_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1530ConMegMeses_"+sGXsfl_134_idx) ;
         httpContext.changePostValue( "Z1534ConMegDura_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z1534ConMegDura_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1534ConMegDura_"+sGXsfl_134_idx) ;
         httpContext.changePostValue( "Z1529ConMegPropor_"+sGXsfl_134_idx, httpContext.cgiGet( "ZT_"+"Z1529ConMegPropor_"+sGXsfl_134_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1529ConMegPropor_"+sGXsfl_134_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.concepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV11ConCodigo))}, new String[] {"Gx_mode","CliCod","ConCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Concepto");
      forbiddenHiddens.add("ConFormula", A148ConFormula);
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1905ConRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("ConFormulaAbr", GXutil.rtrim( localUtil.format( A149ConFormulaAbr, "")));
      forbiddenHiddens.add("ConLiqBasica", localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9"));
      forbiddenHiddens.add("ConTipo", localUtil.format( DecimalUtil.doubleToDec(A154ConTipo), "9"));
      forbiddenHiddens.add("ConCodOld", GXutil.rtrim( localUtil.format( A469ConCodOld, "")));
      forbiddenHiddens.add("ConTipoLiqAux", GXutil.rtrim( localUtil.format( A503ConTipoLiqAux, "")));
      forbiddenHiddens.add("ConConveAux", GXutil.rtrim( localUtil.format( A969ConConveAux, "")));
      forbiddenHiddens.add("ConClasifAux", GXutil.rtrim( localUtil.format( A970ConClasifAux, "")));
      forbiddenHiddens.add("ConOrdEjec", localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9"));
      forbiddenHiddens.add("ConImportado", GXutil.booltostr( A894ConImportado));
      forbiddenHiddens.add("ConTipoOrden", localUtil.format( DecimalUtil.doubleToDec(A895ConTipoOrden), "ZZZ9"));
      forbiddenHiddens.add("ConEdiEnRec", GXutil.booltostr( A1017ConEdiEnRec));
      forbiddenHiddens.add("ConUsado", GXutil.booltostr( A922ConUsado));
      forbiddenHiddens.add("ConObliga", GXutil.booltostr( A951ConObliga));
      forbiddenHiddens.add("ConObligaSiSac", GXutil.booltostr( A952ConObligaSiSac));
      forbiddenHiddens.add("ConCondCodigo", GXutil.rtrim( localUtil.format( A954ConCondCodigo, "")));
      forbiddenHiddens.add("ConMostrarPos", GXutil.booltostr( A1068ConMostrarPos));
      forbiddenHiddens.add("ConSegunPla", GXutil.booltostr( A1194ConSegunPla));
      forbiddenHiddens.add("ConNumero", localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9"));
      forbiddenHiddens.add("ConSIPAApo", localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9"));
      forbiddenHiddens.add("ConSIPACont", localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9"));
      forbiddenHiddens.add("ConINSSJyPApo", localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9"));
      forbiddenHiddens.add("ConINSSJyPCont", localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9"));
      forbiddenHiddens.add("ConObraSocApo", localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9"));
      forbiddenHiddens.add("ConObraSocCont", localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9"));
      forbiddenHiddens.add("ConFonSolRedApo", localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9"));
      forbiddenHiddens.add("ConFonSolRedCont", localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9"));
      forbiddenHiddens.add("ConRenateaApo", localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9"));
      forbiddenHiddens.add("ConRenateaCont", localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9"));
      forbiddenHiddens.add("ConAsigFamCont", localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9"));
      forbiddenHiddens.add("ConFonNacEmpCont", localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9"));
      forbiddenHiddens.add("ConLeyRieTrabCont", localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9"));
      forbiddenHiddens.add("ConRegDifApo", localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9"));
      forbiddenHiddens.add("ConRegEspApo", localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9"));
      forbiddenHiddens.add("ConSacDeven", localUtil.format( DecimalUtil.doubleToDec(A1539ConSacDeven), "Z9"));
      forbiddenHiddens.add("ConBaseLic", localUtil.format( DecimalUtil.doubleToDec(A1620ConBaseLic), "9"));
      forbiddenHiddens.add("ConBaseLicProm", localUtil.format( DecimalUtil.doubleToDec(A1797ConBaseLicProm), "9"));
      forbiddenHiddens.add("ConBaseFer", localUtil.format( DecimalUtil.doubleToDec(A1621ConBaseFer), "9"));
      forbiddenHiddens.add("ConBaseFerProm", localUtil.format( DecimalUtil.doubleToDec(A1798ConBaseFerProm), "9"));
      forbiddenHiddens.add("ConBaseHorExt", localUtil.format( DecimalUtil.doubleToDec(A1622ConBaseHorExt), "9"));
      forbiddenHiddens.add("ConBaseHorExtProm", localUtil.format( DecimalUtil.doubleToDec(A1799ConBaseHorExtProm), "9"));
      forbiddenHiddens.add("ConBasePres", localUtil.format( DecimalUtil.doubleToDec(A1800ConBasePres), "9"));
      forbiddenHiddens.add("ConBaseAnt", localUtil.format( DecimalUtil.doubleToDec(A1801ConBaseAnt), "9"));
      forbiddenHiddens.add("ConBaseOSDif", localUtil.format( DecimalUtil.doubleToDec(A1827ConBaseOSDif), "9"));
      forbiddenHiddens.add("ConBaseAus", localUtil.format( DecimalUtil.doubleToDec(A2191ConBaseAus), "9"));
      forbiddenHiddens.add("ConBaseAusProm", localUtil.format( DecimalUtil.doubleToDec(A2192ConBaseAusProm), "9"));
      forbiddenHiddens.add("ConCodAfip", GXutil.rtrim( localUtil.format( A1648ConCodAfip, "")));
      forbiddenHiddens.add("ConCntPa", localUtil.format( DecimalUtil.doubleToDec(A1769ConCntPa), "Z9"));
      forbiddenHiddens.add("ConErrorSiCero", GXutil.booltostr( A1821ConErrorSiCero));
      forbiddenHiddens.add("ConPueNov", GXutil.booltostr( A1826ConPueNov));
      forbiddenHiddens.add("ConRelSec", localUtil.format( DecimalUtil.doubleToDec(A1886ConRelSec), "ZZZZZ9"));
      forbiddenHiddens.add("ConRelRef", GXutil.rtrim( localUtil.format( A2013ConRelRef, "")));
      forbiddenHiddens.add("ConDescripSinAc", GXutil.rtrim( localUtil.format( A2185ConDescripSinAc, "")));
      forbiddenHiddens.add("ConOblPalabra", GXutil.rtrim( localUtil.format( A2187ConOblPalabra, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("concepto:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z42ConCodYDesc", Z42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z145ConFchModFor", localUtil.ttoc( Z145ConFchModFor, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z156ConUsuModFor", GXutil.rtrim( Z156ConUsuModFor));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z143ConCanti", Z143ConCanti);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z158ConValUni", Z158ConValUni);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z152ConImporte", Z152ConImporte);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z159ConVariable", Z159ConVariable);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1905ConRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1905ConRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z41ConDescrip", Z41ConDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z150ConHabilitado", Z150ConHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z40ConOrden", GXutil.ltrim( localUtil.ntoc( Z40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z162ConVigencia", GXutil.ltrim( localUtil.ntoc( Z162ConVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1488ConLiqBasica", GXutil.ltrim( localUtil.ntoc( Z1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z157ConValorGen", GXutil.ltrim( localUtil.ntoc( Z157ConValorGen, (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z155ConTipoLiqGanancias", GXutil.rtrim( Z155ConTipoLiqGanancias));
      web.GxWebStd.gx_hidden_field( httpContext, "Z154ConTipo", GXutil.ltrim( localUtil.ntoc( Z154ConTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z469ConCodOld", GXutil.rtrim( Z469ConCodOld));
      web.GxWebStd.gx_hidden_field( httpContext, "Z487ConCuenDebe", GXutil.rtrim( Z487ConCuenDebe));
      web.GxWebStd.gx_hidden_field( httpContext, "Z488ConCuenHaber", GXutil.rtrim( Z488ConCuenHaber));
      web.GxWebStd.gx_hidden_field( httpContext, "Z503ConTipoLiqAux", Z503ConTipoLiqAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z969ConConveAux", Z969ConConveAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z970ConClasifAux", Z970ConClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z510ConOrdEjec", GXutil.ltrim( localUtil.ntoc( Z510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z734ConRetGanPropor", Z734ConRetGanPropor);
      web.GxWebStd.gx_hidden_field( httpContext, "Z735ConAplicGan", GXutil.ltrim( localUtil.ntoc( Z735ConAplicGan, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z762ConRecalcular", Z762ConRecalcular);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z894ConImportado", Z894ConImportado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z895ConTipoOrden", GXutil.ltrim( localUtil.ntoc( Z895ConTipoOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1017ConEdiEnRec", Z1017ConEdiEnRec);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1018ConRangoCant", Z1018ConRangoCant);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z922ConUsado", Z922ConUsado);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z951ConObliga", Z951ConObliga);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z952ConObligaSiSac", Z952ConObligaSiSac);
      web.GxWebStd.gx_hidden_field( httpContext, "Z954ConCondCodigo", GXutil.rtrim( Z954ConCondCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1066ConPreReq", GXutil.rtrim( Z1066ConPreReq));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1068ConMostrarPos", Z1068ConMostrarPos);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1077ConAdelDescu", GXutil.ltrim( localUtil.ntoc( Z1077ConAdelDescu, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1194ConSegunPla", Z1194ConSegunPla);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1471ConNumero", GXutil.ltrim( localUtil.ntoc( Z1471ConNumero, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z2191ConBaseAus", GXutil.ltrim( localUtil.ntoc( Z2191ConBaseAus, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2192ConBaseAusProm", GXutil.ltrim( localUtil.ntoc( Z2192ConBaseAusProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1648ConCodAfip", GXutil.rtrim( Z1648ConCodAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1769ConCntPa", GXutil.ltrim( localUtil.ntoc( Z1769ConCntPa, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1821ConErrorSiCero", Z1821ConErrorSiCero);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1826ConPueNov", Z1826ConPueNov);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1886ConRelSec", GXutil.ltrim( localUtil.ntoc( Z1886ConRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2013ConRelRef", Z2013ConRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2185ConDescripSinAc", Z2185ConDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2187ConOblPalabra", GXutil.rtrim( Z2187ConOblPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1822CliPadre", GXutil.ltrim( localUtil.ntoc( Z1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1112AplIIGG", GXutil.ltrim( localUtil.ntoc( Z1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z37TipoConCod", GXutil.rtrim( Z37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z38SubTipoConCod1", GXutil.rtrim( Z38SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z39SubTipoConCod2", GXutil.rtrim( Z39SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z953ConCondicion", GXutil.rtrim( Z953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1644ConceptoPais", GXutil.ltrim( localUtil.ntoc( Z1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1645ConceptoConveCodigo", GXutil.rtrim( Z1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z921ConPadre", GXutil.rtrim( Z921ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "O41ConDescrip", O41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O2192ConBaseAusProm", GXutil.ltrim( localUtil.ntoc( O2192ConBaseAusProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O2191ConBaseAus", GXutil.ltrim( localUtil.ntoc( O2191ConBaseAus, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1827ConBaseOSDif", GXutil.ltrim( localUtil.ntoc( O1827ConBaseOSDif, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1801ConBaseAnt", GXutil.ltrim( localUtil.ntoc( O1801ConBaseAnt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1800ConBasePres", GXutil.ltrim( localUtil.ntoc( O1800ConBasePres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1799ConBaseHorExtProm", GXutil.ltrim( localUtil.ntoc( O1799ConBaseHorExtProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1622ConBaseHorExt", GXutil.ltrim( localUtil.ntoc( O1622ConBaseHorExt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1798ConBaseFerProm", GXutil.ltrim( localUtil.ntoc( O1798ConBaseFerProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1621ConBaseFer", GXutil.ltrim( localUtil.ntoc( O1621ConBaseFer, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1797ConBaseLicProm", GXutil.ltrim( localUtil.ntoc( O1797ConBaseLicProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1620ConBaseLic", GXutil.ltrim( localUtil.ntoc( O1620ConBaseLic, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O762ConRecalcular", O762ConRecalcular);
      web.GxWebStd.gx_hidden_field( httpContext, "O1112AplIIGG", GXutil.ltrim( localUtil.ntoc( O1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_128", GXutil.ltrim( localUtil.ntoc( nGXsfl_128_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_134", GXutil.ltrim( localUtil.ntoc( nGXsfl_134_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N37TipoConCod", GXutil.rtrim( A37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N38SubTipoConCod1", GXutil.rtrim( A38SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "N39SubTipoConCod2", GXutil.rtrim( A39SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "N953ConCondicion", GXutil.rtrim( A953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "N1112AplIIGG", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1644ConceptoPais", GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1645ConceptoConveCodigo", GXutil.rtrim( A1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "N1822CliPadre", GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N921ConPadre", GXutil.rtrim( A921ConPadre));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "N762ConRecalcular", A762ConRecalcular);
      web.GxWebStd.gx_hidden_field( httpContext, "N41ConDescrip", A41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "N40ConOrden", GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N162ConVigencia", GXutil.ltrim( localUtil.ntoc( A162ConVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N157ConValorGen", GXutil.ltrim( localUtil.ntoc( A157ConValorGen, (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N155ConTipoLiqGanancias", GXutil.rtrim( A155ConTipoLiqGanancias));
      web.GxWebStd.gx_hidden_field( httpContext, "N153ConObservacion", A153ConObservacion);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "N159ConVariable", A159ConVariable);
      web.GxWebStd.gx_hidden_field( httpContext, "N735ConAplicGan", GXutil.ltrim( localUtil.ntoc( A735ConAplicGan, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV12DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV12DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEGCODIGO_DATA", AV31MegCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEGCODIGO_DATA", AV31MegCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vDEFAULTCONCODIGO", GXutil.rtrim( AV27defaultConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONFORMULAABR", GXutil.rtrim( A149ConFormulaAbr));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV11ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOCONCOD", GXutil.rtrim( AV23Insert_TipoConCod));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vPERMITEMODIFICACION", AV17permiteModificacion);
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SUBTIPOCONCOD1", GXutil.rtrim( AV24Insert_SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SUBTIPOCONCOD2", GXutil.rtrim( AV25Insert_SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCONDICION", GXutil.rtrim( AV34Insert_ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCONDICION", GXutil.rtrim( A953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGG", GXutil.ltrim( localUtil.ntoc( AV30Insert_AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "APLIIGG", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCEPTOPAIS", GXutil.ltrim( localUtil.ntoc( AV32Insert_ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCEPTOPAIS", GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCEPTOCONVECODIGO", GXutil.rtrim( AV33Insert_ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCEPTOCONVECODIGO", GXutil.rtrim( A1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLIPADRE", GXutil.ltrim( localUtil.ntoc( AV35Insert_CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPADRE", GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONPADRE", GXutil.rtrim( AV29Insert_ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "CONPADRE", GXutil.rtrim( A921ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFCHMODFOR", localUtil.ttoc( A145ConFchModFor, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "CONUSUMODFOR", GXutil.rtrim( A156ConUsuModFor));
      web.GxWebStd.gx_hidden_field( httpContext, "CONRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1905ConRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASELIC", GXutil.ltrim( localUtil.ntoc( A1620ConBaseLic, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASELICPROM", GXutil.ltrim( localUtil.ntoc( A1797ConBaseLicProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEFER", GXutil.ltrim( localUtil.ntoc( A1621ConBaseFer, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEFERPROM", GXutil.ltrim( localUtil.ntoc( A1798ConBaseFerProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEHOREXT", GXutil.ltrim( localUtil.ntoc( A1622ConBaseHorExt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEHOREXTPROM", GXutil.ltrim( localUtil.ntoc( A1799ConBaseHorExtProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEPRES", GXutil.ltrim( localUtil.ntoc( A1800ConBasePres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEANT", GXutil.ltrim( localUtil.ntoc( A1801ConBaseAnt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEOSDIF", GXutil.ltrim( localUtil.ntoc( A1827ConBaseOSDif, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEAUS", GXutil.ltrim( localUtil.ntoc( A2191ConBaseAus, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEAUSPROM", GXutil.ltrim( localUtil.ntoc( A2192ConBaseAusProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONOLDVALUES", A1974ConOldValues);
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTIPOLIQGANANCIAS", GXutil.rtrim( A155ConTipoLiqGanancias));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV13EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONORDEN", GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONLIQBASICA", GXutil.ltrim( localUtil.ntoc( A1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFORMULAPRERESUELTA", A729ConFormulaPreResuelta);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVALORGEN", GXutil.ltrim( localUtil.ntoc( A157ConValorGen, (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONHISFORMULA", A151ConHisFormula);
      web.GxWebStd.gx_hidden_field( httpContext, "CONTIPO", GXutil.ltrim( localUtil.ntoc( A154ConTipo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODOLD", GXutil.rtrim( A469ConCodOld));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTIPOLIQAUX", A503ConTipoLiqAux);
      web.GxWebStd.gx_hidden_field( httpContext, "CONCONVEAUX", A969ConConveAux);
      web.GxWebStd.gx_hidden_field( httpContext, "CONCLASIFAUX", A970ConClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "CONORDEJEC", GXutil.ltrim( localUtil.ntoc( A510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFORMULAEXPL", A569ConFormulaExpl);
      web.GxWebStd.gx_hidden_field( httpContext, "CONFORMULAOBS2", A720ConFormulaObs2);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONIMPORTADO", A894ConImportado);
      web.GxWebStd.gx_hidden_field( httpContext, "CONTIPOORDEN", GXutil.ltrim( localUtil.ntoc( A895ConTipoOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONEDIENREC", A1017ConEdiEnRec);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONUSADO", A922ConUsado);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONOBLIGA", A951ConObliga);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONOBLIGASISAC", A952ConObligaSiSac);
      web.GxWebStd.gx_hidden_field( httpContext, "CONCONDCODIGO", GXutil.rtrim( A954ConCondCodigo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONMOSTRARPOS", A1068ConMostrarPos);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONSEGUNPLA", A1194ConSegunPla);
      web.GxWebStd.gx_hidden_field( httpContext, "CONNUMERO", GXutil.ltrim( localUtil.ntoc( A1471ConNumero, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONSIPAAPO", GXutil.ltrim( localUtil.ntoc( A1472ConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONSIPACONT", GXutil.ltrim( localUtil.ntoc( A1473ConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONINSSJYPAPO", GXutil.ltrim( localUtil.ntoc( A1474ConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONINSSJYPCONT", GXutil.ltrim( localUtil.ntoc( A1475ConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONOBRASOCAPO", GXutil.ltrim( localUtil.ntoc( A1476ConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONOBRASOCCONT", GXutil.ltrim( localUtil.ntoc( A1477ConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFONSOLREDAPO", GXutil.ltrim( localUtil.ntoc( A1478ConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFONSOLREDCONT", GXutil.ltrim( localUtil.ntoc( A1479ConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONRENATEAAPO", GXutil.ltrim( localUtil.ntoc( A1480ConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONRENATEACONT", GXutil.ltrim( localUtil.ntoc( A1481ConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONASIGFAMCONT", GXutil.ltrim( localUtil.ntoc( A1482ConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONFONNACEMPCONT", GXutil.ltrim( localUtil.ntoc( A1483ConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONLEYRIETRABCONT", GXutil.ltrim( localUtil.ntoc( A1484ConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONREGDIFAPO", GXutil.ltrim( localUtil.ntoc( A1485ConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONREGESPAPO", GXutil.ltrim( localUtil.ntoc( A1486ConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONSACDEVEN", GXutil.ltrim( localUtil.ntoc( A1539ConSacDeven, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODAFIP", GXutil.rtrim( A1648ConCodAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCNTPA", GXutil.ltrim( localUtil.ntoc( A1769ConCntPa, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONERRORSICERO", A1821ConErrorSiCero);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONPUENOV", A1826ConPueNov);
      web.GxWebStd.gx_hidden_field( httpContext, "CONRELSEC", GXutil.ltrim( localUtil.ntoc( A1886ConRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONRELREF", A2013ConRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDESCRIPSINAC", A2185ConDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONOBLPALABRA", GXutil.rtrim( A2187ConOblPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV37Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLTIPEGR", GXutil.rtrim( A950ConTLTipEgr));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLORDEJEC", GXutil.ltrim( localUtil.ntoc( A1406ConTLOrdejec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLCONORD", GXutil.ltrim( localUtil.ntoc( A1407ConTLConOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLVIGENCIA", GXutil.ltrim( localUtil.ntoc( A1409ConTLVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLCONDICION", GXutil.rtrim( A1410ConTLCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLCONHAB", GXutil.ltrim( localUtil.ntoc( A1470ConTLConHab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLTIPOCON", GXutil.rtrim( A1788ConTLTipoCon));
      web.GxWebStd.gx_hidden_field( httpContext, "CONTLSEGPLA", GXutil.ltrim( localUtil.ntoc( A1789CONTLSegPla, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQDESC", A340TliqDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONMEGPROPOR", GXutil.ltrim( localUtil.ntoc( A1529ConMegPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Objectcall", GXutil.rtrim( Dvpanel_cuentas_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Enabled", GXutil.booltostr( Dvpanel_cuentas_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Width", GXutil.rtrim( Dvpanel_cuentas_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Autowidth", GXutil.booltostr( Dvpanel_cuentas_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Autoheight", GXutil.booltostr( Dvpanel_cuentas_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Cls", GXutil.rtrim( Dvpanel_cuentas_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Title", GXutil.rtrim( Dvpanel_cuentas_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Collapsible", GXutil.booltostr( Dvpanel_cuentas_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Collapsed", GXutil.booltostr( Dvpanel_cuentas_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Showcollapseicon", GXutil.booltostr( Dvpanel_cuentas_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Iconposition", GXutil.rtrim( Dvpanel_cuentas_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_CUENTAS_Autoscroll", GXutil.booltostr( Dvpanel_cuentas_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Objectcall", GXutil.rtrim( Combo_megcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Cls", GXutil.rtrim( Combo_megcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Enabled", GXutil.booltostr( Combo_megcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Titlecontrolidtoreplace", GXutil.rtrim( Combo_megcodigo_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Isgriditem", GXutil.booltostr( Combo_megcodigo_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Hasdescription", GXutil.booltostr( Combo_megcodigo_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistproc", GXutil.rtrim( Combo_megcodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_megcodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Emptyitem", GXutil.booltostr( Combo_megcodigo_Emptyitem));
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
      return formatLink("web.concepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV11ConCodigo))}, new String[] {"Gx_mode","CliCod","ConCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Concepto" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto", "") ;
   }

   public void initializeNonKey0A7( )
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
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      A1644ConceptoPais = (short)(0) ;
      n1644ConceptoPais = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
      A1645ConceptoConveCodigo = "" ;
      n1645ConceptoConveCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
      A1822CliPadre = 0 ;
      n1822CliPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
      A921ConPadre = "" ;
      n921ConPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A921ConPadre", A921ConPadre);
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      n145ConFchModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A145ConFchModFor", localUtil.ttoc( A145ConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A156ConUsuModFor = "" ;
      n156ConUsuModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A156ConUsuModFor", A156ConUsuModFor);
      A143ConCanti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
      A158ConValUni = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
      A152ConImporte = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
      A159ConVariable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      A1905ConRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1905ConRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1905ConRelSecCli), 6, 0));
      A1974ConOldValues = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1974ConOldValues", A1974ConOldValues);
      A149ConFormulaAbr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A149ConFormulaAbr", A149ConFormulaAbr);
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
      A729ConFormulaPreResuelta = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A729ConFormulaPreResuelta", A729ConFormulaPreResuelta);
      A157ConValorGen = DecimalUtil.ZERO ;
      n157ConValorGen = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A157ConValorGen", GXutil.ltrimstr( A157ConValorGen, 14, 4));
      A153ConObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
      A151ConHisFormula = "" ;
      n151ConHisFormula = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A151ConHisFormula", A151ConHisFormula);
      A154ConTipo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A154ConTipo", GXutil.str( A154ConTipo, 1, 0));
      A469ConCodOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A469ConCodOld", A469ConCodOld);
      A487ConCuenDebe = "" ;
      n487ConCuenDebe = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A487ConCuenDebe", A487ConCuenDebe);
      n487ConCuenDebe = ((GXutil.strcmp("", A487ConCuenDebe)==0) ? true : false) ;
      A488ConCuenHaber = "" ;
      n488ConCuenHaber = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A488ConCuenHaber", A488ConCuenHaber);
      n488ConCuenHaber = ((GXutil.strcmp("", A488ConCuenHaber)==0) ? true : false) ;
      A503ConTipoLiqAux = "" ;
      n503ConTipoLiqAux = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
      A969ConConveAux = "" ;
      n969ConConveAux = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A969ConConveAux", A969ConConveAux);
      A970ConClasifAux = "" ;
      n970ConClasifAux = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A970ConClasifAux", A970ConClasifAux);
      A510ConOrdEjec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
      A569ConFormulaExpl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A569ConFormulaExpl", A569ConFormulaExpl);
      A720ConFormulaObs2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A720ConFormulaObs2", A720ConFormulaObs2);
      A734ConRetGanPropor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A734ConRetGanPropor", A734ConRetGanPropor);
      A735ConAplicGan = (byte)(0) ;
      n735ConAplicGan = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
      n735ConAplicGan = ((0==A735ConAplicGan) ? true : false) ;
      A762ConRecalcular = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      A894ConImportado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A894ConImportado", A894ConImportado);
      A895ConTipoOrden = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A895ConTipoOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A895ConTipoOrden), 4, 0));
      A1017ConEdiEnRec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1017ConEdiEnRec", A1017ConEdiEnRec);
      A1018ConRangoCant = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
      A922ConUsado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A922ConUsado", A922ConUsado);
      A951ConObliga = false ;
      n951ConObliga = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A951ConObliga", A951ConObliga);
      A952ConObligaSiSac = false ;
      n952ConObligaSiSac = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A952ConObligaSiSac", A952ConObligaSiSac);
      A954ConCondCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A954ConCondCodigo", A954ConCondCodigo);
      A1066ConPreReq = "" ;
      n1066ConPreReq = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
      n1066ConPreReq = ((GXutil.strcmp("", A1066ConPreReq)==0) ? true : false) ;
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
      A2191ConBaseAus = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
      A2192ConBaseAusProm = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
      A1648ConCodAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1648ConCodAfip", A1648ConCodAfip);
      A1769ConCntPa = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1769ConCntPa", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1769ConCntPa), 2, 0));
      A1821ConErrorSiCero = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1821ConErrorSiCero", A1821ConErrorSiCero);
      A1826ConPueNov = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1826ConPueNov", A1826ConPueNov);
      A1886ConRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1886ConRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1886ConRelSec), 6, 0));
      A2013ConRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2013ConRelRef", A2013ConRelRef);
      A2185ConDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2185ConDescripSinAc", A2185ConDescripSinAc);
      A2187ConOblPalabra = "" ;
      n2187ConOblPalabra = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2187ConOblPalabra", A2187ConOblPalabra);
      A150ConHabilitado = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
      A155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A155ConTipoLiqGanancias", A155ConTipoLiqGanancias);
      O41ConDescrip = A41ConDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      O2192ConBaseAusProm = A2192ConBaseAusProm ;
      httpContext.ajax_rsp_assign_attri("", false, "A2192ConBaseAusProm", GXutil.str( A2192ConBaseAusProm, 1, 0));
      O2191ConBaseAus = A2191ConBaseAus ;
      httpContext.ajax_rsp_assign_attri("", false, "A2191ConBaseAus", GXutil.str( A2191ConBaseAus, 1, 0));
      O1827ConBaseOSDif = A1827ConBaseOSDif ;
      httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
      O1801ConBaseAnt = A1801ConBaseAnt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
      O1800ConBasePres = A1800ConBasePres ;
      httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
      O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
      httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
      O1622ConBaseHorExt = A1622ConBaseHorExt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
      O1798ConBaseFerProm = A1798ConBaseFerProm ;
      httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
      O1621ConBaseFer = A1621ConBaseFer ;
      httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
      O1797ConBaseLicProm = A1797ConBaseLicProm ;
      httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
      O1620ConBaseLic = A1620ConBaseLic ;
      httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
      O762ConRecalcular = A762ConRecalcular ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      O1112AplIIGG = A1112AplIIGG ;
      n1112AplIIGG = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      Z42ConCodYDesc = "" ;
      Z145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      Z156ConUsuModFor = "" ;
      Z143ConCanti = false ;
      Z158ConValUni = false ;
      Z152ConImporte = false ;
      Z159ConVariable = false ;
      Z1905ConRelSecCli = 0 ;
      Z41ConDescrip = "" ;
      Z150ConHabilitado = false ;
      Z40ConOrden = 0 ;
      Z162ConVigencia = (byte)(0) ;
      Z1488ConLiqBasica = (byte)(0) ;
      Z157ConValorGen = DecimalUtil.ZERO ;
      Z155ConTipoLiqGanancias = "" ;
      Z154ConTipo = (byte)(0) ;
      Z469ConCodOld = "" ;
      Z487ConCuenDebe = "" ;
      Z488ConCuenHaber = "" ;
      Z503ConTipoLiqAux = "" ;
      Z969ConConveAux = "" ;
      Z970ConClasifAux = "" ;
      Z510ConOrdEjec = 0 ;
      Z734ConRetGanPropor = false ;
      Z735ConAplicGan = (byte)(0) ;
      Z762ConRecalcular = false ;
      Z894ConImportado = false ;
      Z895ConTipoOrden = (short)(0) ;
      Z1017ConEdiEnRec = false ;
      Z1018ConRangoCant = "" ;
      Z922ConUsado = false ;
      Z951ConObliga = false ;
      Z952ConObligaSiSac = false ;
      Z954ConCondCodigo = "" ;
      Z1066ConPreReq = "" ;
      Z1068ConMostrarPos = false ;
      Z1077ConAdelDescu = (byte)(0) ;
      Z1194ConSegunPla = false ;
      Z1471ConNumero = (byte)(0) ;
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
      Z2191ConBaseAus = (byte)(0) ;
      Z2192ConBaseAusProm = (byte)(0) ;
      Z1648ConCodAfip = "" ;
      Z1769ConCntPa = (byte)(0) ;
      Z1821ConErrorSiCero = false ;
      Z1826ConPueNov = false ;
      Z1886ConRelSec = 0 ;
      Z2013ConRelRef = "" ;
      Z2185ConDescripSinAc = "" ;
      Z2187ConOblPalabra = "" ;
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

   public void initAll0A7( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      initializeNonKey0A7( ) ;
   }

   public void standaloneModalInsert( )
   {
      A149ConFormulaAbr = i149ConFormulaAbr ;
      httpContext.ajax_rsp_assign_attri("", false, "A149ConFormulaAbr", A149ConFormulaAbr);
      A1905ConRelSecCli = i1905ConRelSecCli ;
      httpContext.ajax_rsp_assign_attri("", false, "A1905ConRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1905ConRelSecCli), 6, 0));
      A150ConHabilitado = i150ConHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
      A155ConTipoLiqGanancias = i155ConTipoLiqGanancias ;
      n155ConTipoLiqGanancias = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A155ConTipoLiqGanancias", A155ConTipoLiqGanancias);
   }

   public void initializeNonKey0A8( )
   {
      A340TliqDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
      A925ConTLiqSinCausa = false ;
      n925ConTLiqSinCausa = false ;
      A926ConTLiqSinPre = false ;
      n926ConTLiqSinPre = false ;
      A950ConTLTipEgr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A950ConTLTipEgr", A950ConTLTipEgr);
      A1406ConTLOrdejec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1406ConTLOrdejec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1406ConTLOrdejec), 12, 0));
      A1407ConTLConOrd = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1407ConTLConOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1407ConTLConOrd), 4, 0));
      A1409ConTLVigencia = (byte)(0) ;
      n1409ConTLVigencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1409ConTLVigencia", GXutil.str( A1409ConTLVigencia, 1, 0));
      A1410ConTLCondicion = "" ;
      n1410ConTLCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1410ConTLCondicion", A1410ConTLCondicion);
      A1470ConTLConHab = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1470ConTLConHab", GXutil.str( A1470ConTLConHab, 1, 0));
      A1788ConTLTipoCon = "" ;
      n1788ConTLTipoCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1788ConTLTipoCon", A1788ConTLTipoCon);
      A1789CONTLSegPla = (byte)(0) ;
      n1789CONTLSegPla = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1789CONTLSegPla", GXutil.str( A1789CONTLSegPla, 1, 0));
      Z925ConTLiqSinCausa = false ;
      Z926ConTLiqSinPre = false ;
      Z950ConTLTipEgr = "" ;
      Z1406ConTLOrdejec = 0 ;
      Z1407ConTLConOrd = (short)(0) ;
      Z1409ConTLVigencia = (byte)(0) ;
      Z1410ConTLCondicion = "" ;
      Z1470ConTLConHab = (byte)(0) ;
      Z1788ConTLTipoCon = "" ;
      Z1789CONTLSegPla = (byte)(0) ;
   }

   public void initAll0A8( )
   {
      A32TLiqCod = "" ;
      initializeNonKey0A8( ) ;
   }

   public void standaloneModalInsert0A8( )
   {
   }

   public void initializeNonKey0A261( )
   {
      A1532MegPreaTipo = "" ;
      A1530ConMegMeses = (byte)(0) ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1529ConMegPropor", GXutil.ltrimstr( A1529ConMegPropor, 6, 4));
      Z1532MegPreaTipo = "" ;
      Z1530ConMegMeses = (byte)(0) ;
      Z1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
   }

   public void initAll0A261( )
   {
      A11MegCodigo = "" ;
      A2077ConMegSec = (short)(0) ;
      initializeNonKey0A261( ) ;
   }

   public void standaloneModalInsert0A261( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251817472215", true, true);
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
      httpContext.AddJavascriptSource("concepto.js", "?20251817472215", false, true);
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

   public void init_level_properties8( )
   {
      dynTLiqCod.setEnabled( defdynTLiqCod_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
      dynTLiqCod.setEnabled( defdynTLiqCod_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), !bGXsfl_128_Refreshing);
   }

   public void init_level_properties261( )
   {
      edtConMegSec_Enabled = defedtConMegSec_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtConMegSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConMegSec_Enabled), 5, 0), !bGXsfl_134_Refreshing);
      edtMegCodigo_Enabled = defedtMegCodigo_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), !bGXsfl_134_Refreshing);
   }

   public void startgridcontrol128( )
   {
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("GridName", "Gridlevel_tipoliquidacion");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Header", subGridlevel_tipoliquidacion_Header);
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynTLiqCod.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
      Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Value", GXutil.booltostr( A925ConTLiqSinCausa));
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinCausa.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
      Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Value", GXutil.booltostr( A926ConTLiqSinPre));
      Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkConTLiqSinPre.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol134( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A11MegCodigo));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMegCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A1532MegPreaTipo));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbMegPreaTipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A1534ConMegDura));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbConMegDura.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1530ConMegMeses, (byte)(2), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegMeses_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2077ConMegSec, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConMegSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtConFormula_Internalname = "CONFORMULA" ;
      divConformula_cell_Internalname = "CONFORMULA_CELL" ;
      dynTipoConCod.setInternalname( "TIPOCONCOD" );
      chkConVariable.setInternalname( "CONVARIABLE" );
      divConvariable_cell_Internalname = "CONVARIABLE_CELL" ;
      cmbConAplicGan.setInternalname( "CONAPLICGAN" );
      divConaplicgan_cell_Internalname = "CONAPLICGAN_CELL" ;
      dynSubTipoConCod1.setInternalname( "SUBTIPOCONCOD1" );
      dynSubTipoConCod2.setInternalname( "SUBTIPOCONCOD2" );
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtConDescrip_Internalname = "CONDESCRIP" ;
      chkConHabilitado.setInternalname( "CONHABILITADO" );
      chkConCanti.setInternalname( "CONCANTI" );
      divConcanti_cell_Internalname = "CONCANTI_CELL" ;
      chkConValUni.setInternalname( "CONVALUNI" );
      divConvaluni_cell_Internalname = "CONVALUNI_CELL" ;
      chkConImporte.setInternalname( "CONIMPORTE" );
      divConimporte_cell_Internalname = "CONIMPORTE_CELL" ;
      cmbConVigencia.setInternalname( "CONVIGENCIA" );
      edtConObservacion_Internalname = "CONOBSERVACION" ;
      chkConRecalcular.setInternalname( "CONRECALCULAR" );
      edtConRangoCant_Internalname = "CONRANGOCANT" ;
      cmbConPreReq.setInternalname( "CONPREREQ" );
      cmbConAdelDescu.setInternalname( "CONADELDESCU" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      dynConCuenDebe.setInternalname( "CONCUENDEBE" );
      dynConCuenHaber.setInternalname( "CONCUENHABER" );
      divCuentas_Internalname = "CUENTAS" ;
      Dvpanel_cuentas_Internalname = "DVPANEL_CUENTAS" ;
      dynTLiqCod.setInternalname( "TLIQCOD" );
      chkConTLiqSinCausa.setInternalname( "CONTLIQSINCAUSA" );
      chkConTLiqSinPre.setInternalname( "CONTLIQSINPRE" );
      divTableleaflevel_tipoliquidacion_Internalname = "TABLELEAFLEVEL_TIPOLIQUIDACION" ;
      edtMegCodigo_Internalname = "MEGCODIGO" ;
      cmbMegPreaTipo.setInternalname( "MEGPREATIPO" );
      cmbConMegDura.setInternalname( "CONMEGDURA" );
      edtConMegMeses_Internalname = "CONMEGMESES" ;
      edtConMegSec_Internalname = "CONMEGSEC" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_megcodigo_Internalname = "COMBO_MEGCODIGO" ;
      chkavEssistemaconceptosdefault.setInternalname( "vESSISTEMACONCEPTOSDEFAULT" );
      edtConRetGanPropor_Internalname = "CONRETGANPROPOR" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_tipoliquidacion_Internalname = "GRIDLEVEL_TIPOLIQUIDACION" ;
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      subGridlevel_tipoliquidacion_Allowcollapsing = (byte)(0) ;
      subGridlevel_tipoliquidacion_Allowselection = (byte)(0) ;
      subGridlevel_tipoliquidacion_Header = "" ;
      Combo_megcodigo_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Concepto", "") );
      edtConMegSec_Jsonclick = "" ;
      edtConMegMeses_Jsonclick = "" ;
      cmbConMegDura.setJsonclick( "" );
      cmbMegPreaTipo.setJsonclick( "" );
      edtMegCodigo_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      chkConTLiqSinPre.setCaption( "" );
      chkConTLiqSinCausa.setCaption( "" );
      dynTLiqCod.setJsonclick( "" );
      subGridlevel_tipoliquidacion_Class = "WorkWith" ;
      subGridlevel_tipoliquidacion_Backcolorstyle = (byte)(0) ;
      Combo_megcodigo_Datalistprocparametersprefix = "" ;
      Combo_megcodigo_Titlecontrolidtoreplace = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtConRetGanPropor_Jsonclick = "" ;
      edtConRetGanPropor_Enabled = 1 ;
      edtConRetGanPropor_Visible = 1 ;
      chkavEssistemaconceptosdefault.setEnabled( 0 );
      chkavEssistemaconceptosdefault.setVisible( 1 );
      Combo_megcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_megcodigo_Datalistproc = "ConceptoLoadDVCombo" ;
      Combo_megcodigo_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_megcodigo_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_megcodigo_Cls = "ExtendedCombo" ;
      Combo_megcodigo_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConMegSec_Enabled = 1 ;
      edtConMegMeses_Enabled = 1 ;
      cmbConMegDura.setEnabled( 1 );
      cmbMegPreaTipo.setEnabled( 1 );
      edtMegCodigo_Enabled = 1 ;
      chkConTLiqSinPre.setEnabled( 1 );
      chkConTLiqSinCausa.setEnabled( 1 );
      dynTLiqCod.setEnabled( 1 );
      dynConCuenHaber.setJsonclick( "" );
      dynConCuenHaber.setEnabled( 1 );
      dynConCuenDebe.setJsonclick( "" );
      dynConCuenDebe.setEnabled( 1 );
      Dvpanel_cuentas_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_cuentas_Iconposition = "Right" ;
      Dvpanel_cuentas_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_cuentas_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_cuentas_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_cuentas_Title = httpContext.getMessage( "Cuentas Contables", "") ;
      Dvpanel_cuentas_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_cuentas_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_cuentas_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_cuentas_Width = "100%" ;
      cmbConAdelDescu.setJsonclick( "" );
      cmbConAdelDescu.setEnabled( 1 );
      cmbConPreReq.setJsonclick( "" );
      cmbConPreReq.setEnabled( 1 );
      edtConRangoCant_Enabled = 1 ;
      chkConRecalcular.setEnabled( 1 );
      edtConObservacion_Enabled = 1 ;
      cmbConVigencia.setJsonclick( "" );
      cmbConVigencia.setEnabled( 1 );
      chkConImporte.setEnabled( 1 );
      chkConImporte.setVisible( 1 );
      divConimporte_cell_Class = "col-xs-12" ;
      chkConValUni.setEnabled( 1 );
      chkConValUni.setVisible( 1 );
      divConvaluni_cell_Class = "col-xs-12" ;
      chkConCanti.setEnabled( 1 );
      chkConCanti.setVisible( 1 );
      divConcanti_cell_Class = "col-xs-12" ;
      chkConHabilitado.setEnabled( 1 );
      edtConDescrip_Enabled = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Invitemessage = "" ;
      edtConCodigo_Enabled = 1 ;
      dynSubTipoConCod2.setJsonclick( "" );
      dynSubTipoConCod2.setEnabled( 1 );
      dynSubTipoConCod1.setJsonclick( "" );
      dynSubTipoConCod1.setEnabled( 1 );
      cmbConAplicGan.setJsonclick( "" );
      cmbConAplicGan.setEnabled( 1 );
      cmbConAplicGan.setVisible( 1 );
      divConaplicgan_cell_Class = "col-xs-12" ;
      chkConVariable.setEnabled( 1 );
      chkConVariable.setVisible( 1 );
      divConvariable_cell_Class = "col-xs-12" ;
      dynTipoConCod.setJsonclick( "" );
      dynTipoConCod.setEnabled( 1 );
      edtConFormula_Enabled = 0 ;
      edtConFormula_Visible = 1 ;
      divConformula_cell_Class = "col-xs-12" ;
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
      gxasubtipoconcod1_html0A7( A37TipoConCod) ;
      gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      /* End function dynload_actions */
   }

   public void gxdlatipoconcod0A1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipoconcod_data0A1( ) ;
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

   public void gxatipoconcod_html0A1( )
   {
      String gxdynajaxvalue;
      gxdlatipoconcod_data0A1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipoConCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTipoConCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatipoconcod_data0A1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T000A75 */
      pr_default.execute(73);
      while ( (pr_default.getStatus(73) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A75_A37TipoConCod[0]));
         gxdynajaxctrldescr.add(T000A75_A370TipoConDescrip[0]);
         pr_default.readNext(73);
      }
      pr_default.close(73);
   }

   public void gxdlasubtipoconcod10A7( String A37TipoConCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasubtipoconcod1_data0A7( A37TipoConCod) ;
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

   public void gxasubtipoconcod1_html0A7( String A37TipoConCod )
   {
      String gxdynajaxvalue;
      gxdlasubtipoconcod1_data0A7( A37TipoConCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSubTipoConCod1.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynSubTipoConCod1.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasubtipoconcod1_data0A7( String A37TipoConCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000A76 */
      pr_default.execute(74, new Object[] {A37TipoConCod});
      while ( (pr_default.getStatus(74) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A76_A38SubTipoConCod1[0]));
         gxdynajaxctrldescr.add(T000A76_A371SubTipoConDes1[0]);
         pr_default.readNext(74);
      }
      pr_default.close(74);
   }

   public void gxdlasubtipoconcod20A7( String A37TipoConCod ,
                                       String A38SubTipoConCod1 )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasubtipoconcod2_data0A7( A37TipoConCod, A38SubTipoConCod1) ;
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

   public void gxasubtipoconcod2_html0A7( String A37TipoConCod ,
                                          String A38SubTipoConCod1 )
   {
      String gxdynajaxvalue;
      gxdlasubtipoconcod2_data0A7( A37TipoConCod, A38SubTipoConCod1) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSubTipoConCod2.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynSubTipoConCod2.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasubtipoconcod2_data0A7( String A37TipoConCod ,
                                               String A38SubTipoConCod1 )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000A77 */
      pr_default.execute(75, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      while ( (pr_default.getStatus(75) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A77_A39SubTipoConCod2[0]));
         gxdynajaxctrldescr.add(T000A77_A372SubTipoConDes2[0]);
         pr_default.readNext(75);
      }
      pr_default.close(75);
   }

   public void gxdlaconcuendebe0A7( int AV7CliCod ,
                                    short AV13EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconcuendebe_data0A7( AV7CliCod, AV13EmpCod) ;
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

   public void gxaconcuendebe_html0A7( int AV7CliCod ,
                                       short AV13EmpCod )
   {
      String gxdynajaxvalue;
      gxdlaconcuendebe_data0A7( AV7CliCod, AV13EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConCuenDebe.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConCuenDebe.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconcuendebe_data0A7( int AV7CliCod ,
                                            short AV13EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000A78 */
      pr_default.execute(76, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV13EmpCod)});
      while ( (pr_default.getStatus(76) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A78_A78CuenCodigo[0]));
         gxdynajaxctrldescr.add(T000A78_A485CuenDescrip[0]);
         pr_default.readNext(76);
      }
      pr_default.close(76);
   }

   public void gxdlaconcuenhaber0A7( int AV7CliCod ,
                                     short AV13EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconcuenhaber_data0A7( AV7CliCod, AV13EmpCod) ;
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

   public void gxaconcuenhaber_html0A7( int AV7CliCod ,
                                        short AV13EmpCod )
   {
      String gxdynajaxvalue;
      gxdlaconcuenhaber_data0A7( AV7CliCod, AV13EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConCuenHaber.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConCuenHaber.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconcuenhaber_data0A7( int AV7CliCod ,
                                             short AV13EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000A79 */
      pr_default.execute(77, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV13EmpCod)});
      while ( (pr_default.getStatus(77) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A79_A78CuenCodigo[0]));
         gxdynajaxctrldescr.add(T000A79_A485CuenDescrip[0]);
         pr_default.readNext(77);
      }
      pr_default.close(77);
   }

   public void gxdlatliqcod0A8( int A3CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatliqcod_data0A8( A3CliCod) ;
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

   public void gxatliqcod_html0A8( int A3CliCod )
   {
      String gxdynajaxvalue;
      gxdlatliqcod_data0A8( A3CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTLiqCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTLiqCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatliqcod_data0A8( int A3CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000A80 */
      pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod)});
      while ( (pr_default.getStatus(78) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000A80_A32TLiqCod[0]));
         gxdynajaxctrldescr.add(T000A80_A340TliqDesc[0]);
         pr_default.readNext(78);
      }
      pr_default.close(78);
   }

   public void gx11asaclicod0A7( int AV7CliCod )
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
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            concepto_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
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

   public void gx39asaconfchmodfor0A7( int AV7CliCod )
   {
      GXt_dtime12 = A145ConFchModFor ;
      GXv_dtime13[0] = GXt_dtime12 ;
      new web.getahora(remoteHandle, context).execute( AV7CliCod, GXv_dtime13) ;
      concepto_impl.this.GXt_dtime12 = GXv_dtime13[0] ;
      A145ConFchModFor = GXutil.resetMillis(GXt_dtime12) ;
      n145ConFchModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A145ConFchModFor", localUtil.ttoc( A145ConFchModFor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A145ConFchModFor, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx40asaconusumodfor0A7( String Gx_mode )
   {
      GXt_char10 = A156ConUsuModFor ;
      GXv_char11[0] = GXt_char10 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char11) ;
      concepto_impl.this.GXt_char10 = GXv_char11[0] ;
      A156ConUsuModFor = GXt_char10 ;
      n156ConUsuModFor = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A156ConUsuModFor", A156ConUsuModFor);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A156ConUsuModFor))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx52asaconoldvalues0A7( byte A1797ConBaseLicProm ,
                                       byte A1621ConBaseFer ,
                                       byte A1798ConBaseFerProm ,
                                       byte A1622ConBaseHorExt ,
                                       byte A1799ConBaseHorExtProm ,
                                       byte A1800ConBasePres ,
                                       byte A1801ConBaseAnt ,
                                       byte A1827ConBaseOSDif ,
                                       byte A2191ConBaseAus ,
                                       byte A2192ConBaseAusProm ,
                                       String A41ConDescrip ,
                                       String Gx_mode ,
                                       byte A1620ConBaseLic )
   {
      if ( isUpd( )  )
      {
         GXt_char10 = A1974ConOldValues ;
         GXv_char11[0] = GXt_char10 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char11) ;
         concepto_impl.this.GXt_char10 = GXv_char11[0] ;
         A1974ConOldValues = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1974ConOldValues", A1974ConOldValues);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1974ConOldValues)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_tipoliquidacion_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_1288( ) ;
      while ( nGXsfl_128_idx <= nRC_GXsfl_128 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0A8( ) ;
         standaloneModal0A8( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0A8( ) ;
         nGXsfl_128_idx = (int)(nGXsfl_128_idx+1) ;
         sGXsfl_128_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_128_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1288( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_tipoliquidacionContainer)) ;
      /* End function gxnrGridlevel_tipoliquidacion_newrow */
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_134261( ) ;
      while ( nGXsfl_134_idx <= nRC_GXsfl_134 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0A261( ) ;
         standaloneModal0A261( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0A261( ) ;
         nGXsfl_134_idx = (int)(nGXsfl_134_idx+1) ;
         sGXsfl_134_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_134_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_134261( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      dynTipoConCod.setName( "TIPOCONCOD" );
      dynTipoConCod.setWebtags( "" );
      dynTipoConCod.removeAllItems();
      /* Using cursor T000A81 */
      pr_default.execute(79);
      while ( (pr_default.getStatus(79) != 101) )
      {
         dynTipoConCod.addItem(T000A81_A37TipoConCod[0], T000A81_A370TipoConDescrip[0], (short)(0));
         pr_default.readNext(79);
      }
      pr_default.close(79);
      if ( dynTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = dynTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      chkConVariable.setName( "CONVARIABLE" );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), true);
      chkConVariable.setCheckedValue( "false" );
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      cmbConAplicGan.setName( "CONAPLICGAN" );
      cmbConAplicGan.setWebtags( "" );
      cmbConAplicGan.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "No Aplica", ""), (short)(0));
      cmbConAplicGan.addItem("1", httpContext.getMessage( "Totalmente Gravado", ""), (short)(0));
      cmbConAplicGan.addItem("2", httpContext.getMessage( "Totalmente Exento", ""), (short)(0));
      cmbConAplicGan.addItem("4", httpContext.getMessage( "Exento parcialmente por ser horas extras de feriado y fines de semana", ""), (short)(0));
      cmbConAplicGan.addItem("5", httpContext.getMessage( "Exento hasta el 40% del Mínimo no imponible", ""), (short)(0));
      cmbConAplicGan.addItem("6", httpContext.getMessage( "SAC (puede ser gravado, exento, o parcialmente exento)", ""), (short)(0));
      cmbConAplicGan.addItem("7", httpContext.getMessage( "Bono de productividad. Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      cmbConAplicGan.addItem("8", httpContext.getMessage( "Fallo de caja. Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      cmbConAplicGan.addItem("9", httpContext.getMessage( "Similar naturaleza (similar a bono de prod y fallo de caja).  Exento parcialmente, prorrateable y condicionado al promedio del sueldo", ""), (short)(0));
      if ( cmbConAplicGan.getItemCount() > 0 )
      {
         A735ConAplicGan = (byte)(GXutil.lval( cmbConAplicGan.getValidValue(GXutil.trim( GXutil.str( A735ConAplicGan, 2, 0))))) ;
         n735ConAplicGan = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A735ConAplicGan", GXutil.ltrimstr( DecimalUtil.doubleToDec(A735ConAplicGan), 2, 0));
      }
      dynSubTipoConCod1.setName( "SUBTIPOCONCOD1" );
      dynSubTipoConCod1.setWebtags( "" );
      dynSubTipoConCod2.setName( "SUBTIPOCONCOD2" );
      dynSubTipoConCod2.setWebtags( "" );
      chkConHabilitado.setName( "CONHABILITADO" );
      chkConHabilitado.setWebtags( "" );
      chkConHabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConHabilitado.getInternalname(), "TitleCaption", chkConHabilitado.getCaption(), true);
      chkConHabilitado.setCheckedValue( "false" );
      if ( isIns( ) && (false==A150ConHabilitado) )
      {
         A150ConHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A150ConHabilitado", A150ConHabilitado);
      }
      chkConCanti.setName( "CONCANTI" );
      chkConCanti.setWebtags( "" );
      chkConCanti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConCanti.getInternalname(), "TitleCaption", chkConCanti.getCaption(), true);
      chkConCanti.setCheckedValue( "false" );
      A143ConCanti = GXutil.strtobool( GXutil.booltostr( A143ConCanti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A143ConCanti", A143ConCanti);
      chkConValUni.setName( "CONVALUNI" );
      chkConValUni.setWebtags( "" );
      chkConValUni.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConValUni.getInternalname(), "TitleCaption", chkConValUni.getCaption(), true);
      chkConValUni.setCheckedValue( "false" );
      A158ConValUni = GXutil.strtobool( GXutil.booltostr( A158ConValUni)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A158ConValUni", A158ConValUni);
      chkConImporte.setName( "CONIMPORTE" );
      chkConImporte.setWebtags( "" );
      chkConImporte.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConImporte.getInternalname(), "TitleCaption", chkConImporte.getCaption(), true);
      chkConImporte.setCheckedValue( "false" );
      A152ConImporte = GXutil.strtobool( GXutil.booltostr( A152ConImporte)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A152ConImporte", A152ConImporte);
      cmbConVigencia.setName( "CONVIGENCIA" );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
      }
      chkConRecalcular.setName( "CONRECALCULAR" );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), true);
      chkConRecalcular.setCheckedValue( "false" );
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      cmbConPreReq.setName( "CONPREREQ" );
      cmbConPreReq.setWebtags( "" );
      cmbConPreReq.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConPreReq.addItem("APO_SIPA", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre", ""), (short)(0));
      cmbConPreReq.addItem("APO_SIPA_NoSacNiVac", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre distintos a SAC y vacaciones", ""), (short)(0));
      cmbConPreReq.addItem("APO_INSSJyP", httpContext.getMessage( "Conceptos que aporten a INSSJyP", ""), (short)(0));
      cmbConPreReq.addItem("APO_OS", httpContext.getMessage( "Conceptos que aporten a Obra Social o FSR", ""), (short)(0));
      cmbConPreReq.addItem("APO_DIF", httpContext.getMessage( "Conceptos que aporten a Diferenciales", ""), (short)(0));
      cmbConPreReq.addItem("APO_ESP", httpContext.getMessage( "Conceptos que aporten a Especiales", ""), (short)(0));
      cmbConPreReq.addItem("CON_SIPA", httpContext.getMessage( "Conceptos que contribuyan a SIPA o INSSJyP", ""), (short)(0));
      cmbConPreReq.addItem("CON_OS", httpContext.getMessage( "Conceptos que contribuyan a Obra social o FSR", ""), (short)(0));
      cmbConPreReq.addItem("CON_FNE", httpContext.getMessage( "Conceptos que contribuyan a AAFF, Renatre,o FNE", ""), (short)(0));
      cmbConPreReq.addItem("CON_LRT", httpContext.getMessage( "Conceptos que contribuyan a LRT", ""), (short)(0));
      cmbConPreReq.addItem("BRUTA", httpContext.getMessage( "Conceptos remunerativos y no remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("REM", httpContext.getMessage( "Conceptos remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("NRE", httpContext.getMessage( "Conceptos no remunerativos", ""), (short)(0));
      cmbConPreReq.addItem("REMNOSAC", httpContext.getMessage( "Conceptos remunerativos exceptuando SAC", ""), (short)(0));
      cmbConPreReq.addItem("EXENTOS", httpContext.getMessage( "Conceptos totalmente exentos de IIGG (excepto sac) y conceptos prorrateables", ""), (short)(0));
      cmbConPreReq.addItem("LICENCIAS", httpContext.getMessage( "Conceptos relacionados a licencias o feriados", ""), (short)(0));
      cmbConPreReq.addItem("FIJAS", httpContext.getMessage( "Conceptos de remuneración fija de tipo remunerativos y no remunerativos con clasificacion distinta a vacaciones", ""), (short)(0));
      if ( cmbConPreReq.getItemCount() > 0 )
      {
         A1066ConPreReq = cmbConPreReq.getValidValue(A1066ConPreReq) ;
         n1066ConPreReq = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1066ConPreReq", A1066ConPreReq);
      }
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
      dynConCuenDebe.setName( "CONCUENDEBE" );
      dynConCuenDebe.setWebtags( "" );
      dynConCuenHaber.setName( "CONCUENHABER" );
      dynConCuenHaber.setWebtags( "" );
      GXCCtl = "TLIQCOD_" + sGXsfl_128_idx ;
      dynTLiqCod.setName( GXCCtl );
      dynTLiqCod.setWebtags( "" );
      GXCCtl = "CONTLIQSINCAUSA_" + sGXsfl_128_idx ;
      chkConTLiqSinCausa.setName( GXCCtl );
      chkConTLiqSinCausa.setWebtags( "" );
      chkConTLiqSinCausa.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinCausa.getInternalname(), "TitleCaption", chkConTLiqSinCausa.getCaption(), !bGXsfl_128_Refreshing);
      chkConTLiqSinCausa.setCheckedValue( "false" );
      A925ConTLiqSinCausa = GXutil.strtobool( GXutil.booltostr( A925ConTLiqSinCausa)) ;
      n925ConTLiqSinCausa = false ;
      GXCCtl = "CONTLIQSINPRE_" + sGXsfl_128_idx ;
      chkConTLiqSinPre.setName( GXCCtl );
      chkConTLiqSinPre.setWebtags( "" );
      chkConTLiqSinPre.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConTLiqSinPre.getInternalname(), "TitleCaption", chkConTLiqSinPre.getCaption(), !bGXsfl_128_Refreshing);
      chkConTLiqSinPre.setCheckedValue( "false" );
      A926ConTLiqSinPre = GXutil.strtobool( GXutil.booltostr( A926ConTLiqSinPre)) ;
      n926ConTLiqSinPre = false ;
      GXCCtl = "MEGPREATIPO_" + sGXsfl_134_idx ;
      cmbMegPreaTipo.setName( GXCCtl );
      cmbMegPreaTipo.setWebtags( "" );
      cmbMegPreaTipo.addItem("CON", httpContext.getMessage( "Con preaviso", ""), (short)(0));
      cmbMegPreaTipo.addItem("SIN", httpContext.getMessage( "Sin preaviso", ""), (short)(0));
      cmbMegPreaTipo.addItem("", httpContext.getMessage( "Ambos (Con o sin preaviso)", ""), (short)(0));
      if ( cmbMegPreaTipo.getItemCount() > 0 )
      {
         A1532MegPreaTipo = cmbMegPreaTipo.getValidValue(A1532MegPreaTipo) ;
      }
      GXCCtl = "CONMEGDURA_" + sGXsfl_134_idx ;
      cmbConMegDura.setName( GXCCtl );
      cmbConMegDura.setWebtags( "" );
      cmbConMegDura.addItem("años", httpContext.getMessage( "años", ""), (short)(0));
      cmbConMegDura.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbConMegDura.getItemCount() > 0 )
      {
         A1534ConMegDura = cmbConMegDura.getValidValue(A1534ConMegDura) ;
      }
      chkavEssistemaconceptosdefault.setName( "vESSISTEMACONCEPTOSDEFAULT" );
      chkavEssistemaconceptosdefault.setWebtags( "" );
      chkavEssistemaconceptosdefault.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEssistemaconceptosdefault.getInternalname(), "TitleCaption", chkavEssistemaconceptosdefault.getCaption(), true);
      chkavEssistemaconceptosdefault.setCheckedValue( "false" );
      AV14esSistemaConceptosDefault = GXutil.strtobool( GXutil.booltostr( AV14esSistemaConceptosDefault)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14esSistemaConceptosDefault", AV14esSistemaConceptosDefault);
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
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Tipoconcod( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A82 */
      pr_default.execute(80, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(80) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
      }
      pr_default.close(80);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
      }
      chkConVariable.setVisible( ((GXutil.strcmp(A37TipoConCod, "REM_ARG")==0) ? 1 : 0) );
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) ) )
      {
         divConvariable_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 )
         {
            divConvariable_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
      }
      cmbConAplicGan.setVisible( ((GXutil.strcmp(A37TipoConCod, "DES_ARG")!=0) ? 1 : 0) );
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 ) ) )
      {
         divConaplicgan_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         if ( GXutil.strcmp(A37TipoConCod, "DES_ARG") != 0 )
         {
            divConaplicgan_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
      {
         A159ConVariable = false ;
      }
      if ( (GXutil.strcmp("", A37TipoConCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoConCod.getInternalname() ;
      }
      gxasubtipoconcod1_html0A7( A37TipoConCod) ;
      gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      dynload_actions( ) ;
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      if ( dynSubTipoConCod1.getItemCount() > 0 )
      {
         A38SubTipoConCod1 = dynSubTipoConCod1.getValidValue(A38SubTipoConCod1) ;
         n38SubTipoConCod1 = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
      }
      if ( dynSubTipoConCod2.getItemCount() > 0 )
      {
         A39SubTipoConCod2 = dynSubTipoConCod2.getValidValue(A39SubTipoConCod2) ;
         n39SubTipoConCod2 = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divConvariable_cell_Internalname, "Class", divConvariable_cell_Class, true);
      httpContext.ajax_rsp_assign_prop("", false, cmbConAplicGan.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAplicGan.getVisible(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divConaplicgan_cell_Internalname, "Class", divConaplicgan_cell_Class, true);
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", GXutil.rtrim( A38SubTipoConCod1));
      dynSubTipoConCod1.setValue( GXutil.rtrim( A38SubTipoConCod1) );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod1.getInternalname(), "Values", dynSubTipoConCod1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", GXutil.rtrim( A39SubTipoConCod2));
      dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
   }

   public void valid_Subtipoconcod1( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A83 */
      pr_default.execute(81, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(81) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
         }
      }
      pr_default.close(81);
      if ( (GXutil.strcmp("", A38SubTipoConCod1)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Clasificación", ""), "", "", "", "", "", "", "", ""), 1, "SUBTIPOCONCOD1");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSubTipoConCod1.getInternalname() ;
      }
      gxasubtipoconcod2_html0A7( A37TipoConCod, A38SubTipoConCod1) ;
      dynload_actions( ) ;
      if ( dynSubTipoConCod2.getItemCount() > 0 )
      {
         A39SubTipoConCod2 = dynSubTipoConCod2.getValidValue(A39SubTipoConCod2) ;
         n39SubTipoConCod2 = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", GXutil.rtrim( A39SubTipoConCod2));
      dynSubTipoConCod2.setValue( GXutil.rtrim( A39SubTipoConCod2) );
      httpContext.ajax_rsp_assign_prop("", false, dynSubTipoConCod2.getInternalname(), "Values", dynSubTipoConCod2.ToJavascriptSource(), true);
   }

   public void valid_Subtipoconcod2( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A84 */
      pr_default.execute(82, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(82) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTipoConCod.getInternalname() ;
         }
      }
      pr_default.close(82);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Condescrip( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      n42ConCodYDesc = false ;
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      if ( isUpd( )  )
      {
         GXt_char10 = A1974ConOldValues ;
         GXv_char11[0] = GXt_char10 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char11) ;
         concepto_impl.this.GXt_char10 = GXv_char11[0] ;
         A1974ConOldValues = GXt_char10 ;
      }
      if ( (GXutil.strcmp("", A41ConDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "CONDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A1974ConOldValues", A1974ConOldValues);
   }

   public void valid_Tliqcod( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A65 */
      pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(63) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTLiqCod.getInternalname() ;
      }
      A340TliqDesc = T000A65_A340TliqDesc[0] ;
      pr_default.close(63);
      dynload_actions( ) ;
      if ( dynTLiqCod.getItemCount() > 0 )
      {
         A32TLiqCod = dynTLiqCod.getValidValue(A32TLiqCod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTLiqCod.setValue( GXutil.rtrim( A32TLiqCod) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
   }

   public void valid_Megcodigo( )
   {
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A85 */
      pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(83) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
      }
      pr_default.close(83);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Conmegsec( )
   {
      A1532MegPreaTipo = cmbMegPreaTipo.getValue() ;
      A1534ConMegDura = cmbConMegDura.getValue() ;
      A37TipoConCod = dynTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      A38SubTipoConCod1 = dynSubTipoConCod1.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      A39SubTipoConCod2 = dynSubTipoConCod2.getValue() ;
      n39SubTipoConCod2 = false ;
      n487ConCuenDebe = false ;
      A487ConCuenDebe = dynConCuenDebe.getValue() ;
      n487ConCuenDebe = false ;
      n488ConCuenHaber = false ;
      A488ConCuenHaber = dynConCuenHaber.getValue() ;
      n488ConCuenHaber = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      /* Using cursor T000A86 */
      pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(84) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Código", "")+","+httpContext.getMessage( "Motivo Egreso", "")+","+httpContext.getMessage( "Preaviso", "")+","+httpContext.getMessage( "Con antiguedad mayor a", "")+","+httpContext.getMessage( "meses o años", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(84);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'A148ConFormula',fld:'CONFORMULA',pic:''},{av:'A1905ConRelSecCli',fld:'CONRELSECCLI',pic:'ZZZZZ9'},{av:'A149ConFormulaAbr',fld:'CONFORMULAABR',pic:''},{av:'A1488ConLiqBasica',fld:'CONLIQBASICA',pic:'9'},{av:'A154ConTipo',fld:'CONTIPO',pic:'9'},{av:'A469ConCodOld',fld:'CONCODOLD',pic:''},{av:'A503ConTipoLiqAux',fld:'CONTIPOLIQAUX',pic:''},{av:'A969ConConveAux',fld:'CONCONVEAUX',pic:''},{av:'A970ConClasifAux',fld:'CONCLASIFAUX',pic:''},{av:'A510ConOrdEjec',fld:'CONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'A894ConImportado',fld:'CONIMPORTADO',pic:''},{av:'A895ConTipoOrden',fld:'CONTIPOORDEN',pic:'ZZZ9'},{av:'A1017ConEdiEnRec',fld:'CONEDIENREC',pic:''},{av:'A922ConUsado',fld:'CONUSADO',pic:''},{av:'A951ConObliga',fld:'CONOBLIGA',pic:''},{av:'A952ConObligaSiSac',fld:'CONOBLIGASISAC',pic:''},{av:'A954ConCondCodigo',fld:'CONCONDCODIGO',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''},{av:'A1471ConNumero',fld:'CONNUMERO',pic:'9'},{av:'A1472ConSIPAApo',fld:'CONSIPAAPO',pic:'9'},{av:'A1473ConSIPACont',fld:'CONSIPACONT',pic:'9'},{av:'A1474ConINSSJyPApo',fld:'CONINSSJYPAPO',pic:'9'},{av:'A1475ConINSSJyPCont',fld:'CONINSSJYPCONT',pic:'9'},{av:'A1476ConObraSocApo',fld:'CONOBRASOCAPO',pic:'9'},{av:'A1477ConObraSocCont',fld:'CONOBRASOCCONT',pic:'9'},{av:'A1478ConFonSolRedApo',fld:'CONFONSOLREDAPO',pic:'9'},{av:'A1479ConFonSolRedCont',fld:'CONFONSOLREDCONT',pic:'9'},{av:'A1480ConRenateaApo',fld:'CONRENATEAAPO',pic:'9'},{av:'A1481ConRenateaCont',fld:'CONRENATEACONT',pic:'9'},{av:'A1482ConAsigFamCont',fld:'CONASIGFAMCONT',pic:'9'},{av:'A1483ConFonNacEmpCont',fld:'CONFONNACEMPCONT',pic:'9'},{av:'A1484ConLeyRieTrabCont',fld:'CONLEYRIETRABCONT',pic:'9'},{av:'A1485ConRegDifApo',fld:'CONREGDIFAPO',pic:'9'},{av:'A1486ConRegEspApo',fld:'CONREGESPAPO',pic:'9'},{av:'A1539ConSacDeven',fld:'CONSACDEVEN',pic:'Z9'},{av:'A1620ConBaseLic',fld:'CONBASELIC',pic:'9'},{av:'A1797ConBaseLicProm',fld:'CONBASELICPROM',pic:'9'},{av:'A1621ConBaseFer',fld:'CONBASEFER',pic:'9'},{av:'A1798ConBaseFerProm',fld:'CONBASEFERPROM',pic:'9'},{av:'A1622ConBaseHorExt',fld:'CONBASEHOREXT',pic:'9'},{av:'A1799ConBaseHorExtProm',fld:'CONBASEHOREXTPROM',pic:'9'},{av:'A1800ConBasePres',fld:'CONBASEPRES',pic:'9'},{av:'A1801ConBaseAnt',fld:'CONBASEANT',pic:'9'},{av:'A1827ConBaseOSDif',fld:'CONBASEOSDIF',pic:'9'},{av:'A2191ConBaseAus',fld:'CONBASEAUS',pic:'9'},{av:'A2192ConBaseAusProm',fld:'CONBASEAUSPROM',pic:'9'},{av:'A1648ConCodAfip',fld:'CONCODAFIP',pic:''},{av:'A1769ConCntPa',fld:'CONCNTPA',pic:'Z9'},{av:'A1821ConErrorSiCero',fld:'CONERRORSICERO',pic:''},{av:'A1826ConPueNov',fld:'CONPUENOV',pic:''},{av:'A1886ConRelSec',fld:'CONRELSEC',pic:'ZZZZZ9'},{av:'A2013ConRelRef',fld:'CONRELREF',pic:''},{av:'A2185ConDescripSinAc',fld:'CONDESCRIPSINAC',pic:''},{av:'A2187ConOblPalabra',fld:'CONOBLPALABRA',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e130A2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'O762ConRecalcular'},{av:'O1112AplIIGG'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("TIPOCONCOD.CLICK","{handler:'e110A7',iparms:[{av:'AV27defaultConCodigo',fld:'vDEFAULTCONCODIGO',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("TIPOCONCOD.CLICK",",oparms:[{av:'AV27defaultConCodigo',fld:'vDEFAULTCONCODIGO',pic:''},{av:'edtConCodigo_Invitemessage',ctrl:'CONCODIGO',prop:'Invitemessage'},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_TIPOCONCOD","{handler:'valid_Tipoconcod',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_TIPOCONCOD",",oparms:[{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'divConvariable_cell_Class',ctrl:'CONVARIABLE_CELL',prop:'Class'},{av:'cmbConAplicGan'},{av:'divConaplicgan_cell_Class',ctrl:'CONAPLICGAN_CELL',prop:'Class'},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONAPLICGAN","{handler:'valid_Conaplicgan',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONAPLICGAN",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_SUBTIPOCONCOD1","{handler:'valid_Subtipoconcod1',iparms:[{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_SUBTIPOCONCOD1",",oparms:[{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_SUBTIPOCONCOD2","{handler:'valid_Subtipoconcod2',iparms:[{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_SUBTIPOCONCOD2",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONDESCRIP","{handler:'valid_Condescrip',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O41ConDescrip'},{av:'O2192ConBaseAusProm'},{av:'O2191ConBaseAus'},{av:'O1827ConBaseOSDif'},{av:'O1801ConBaseAnt'},{av:'O1800ConBasePres'},{av:'O1799ConBaseHorExtProm'},{av:'O1622ConBaseHorExt'},{av:'O1798ConBaseFerProm'},{av:'O1621ConBaseFer'},{av:'O1797ConBaseLicProm'},{av:'O1620ConBaseLic'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'A1620ConBaseLic',fld:'CONBASELIC',pic:'9'},{av:'A1797ConBaseLicProm',fld:'CONBASELICPROM',pic:'9'},{av:'A1621ConBaseFer',fld:'CONBASEFER',pic:'9'},{av:'A1798ConBaseFerProm',fld:'CONBASEFERPROM',pic:'9'},{av:'A1622ConBaseHorExt',fld:'CONBASEHOREXT',pic:'9'},{av:'A1799ConBaseHorExtProm',fld:'CONBASEHOREXTPROM',pic:'9'},{av:'A1800ConBasePres',fld:'CONBASEPRES',pic:'9'},{av:'A1801ConBaseAnt',fld:'CONBASEANT',pic:'9'},{av:'A1827ConBaseOSDif',fld:'CONBASEOSDIF',pic:'9'},{av:'A2191ConBaseAus',fld:'CONBASEAUS',pic:'9'},{av:'A2192ConBaseAusProm',fld:'CONBASEAUSPROM',pic:'9'},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A1974ConOldValues',fld:'CONOLDVALUES',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONDESCRIP",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A1974ConOldValues',fld:'CONOLDVALUES',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONVIGENCIA","{handler:'valid_Convigencia',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONVIGENCIA",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONPREREQ","{handler:'valid_Conprereq',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONPREREQ",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONADELDESCU","{handler:'valid_Conadeldescu',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONADELDESCU",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALIDV_ESSISTEMACONCEPTOSDEFAULT","{handler:'validv_Essistemaconceptosdefault',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALIDV_ESSISTEMACONCEPTOSDEFAULT",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Contliqsinpre',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_MEGCODIGO","{handler:'valid_Megcodigo',iparms:[{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_MEGCODIGO",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_MEGPREATIPO","{handler:'valid_Megpreatipo',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_MEGPREATIPO",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONMEGDURA","{handler:'valid_Conmegdura',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONMEGDURA",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONMEGMESES","{handler:'valid_Conmegmeses',iparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONMEGMESES",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
      setEventMetadata("VALID_CONMEGSEC","{handler:'valid_Conmegsec',iparms:[{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'cmbMegPreaTipo'},{av:'A1532MegPreaTipo',fld:'MEGPREATIPO',pic:''},{av:'A1530ConMegMeses',fld:'CONMEGMESES',pic:'Z9'},{av:'cmbConMegDura'},{av:'A1534ConMegDura',fld:'CONMEGDURA',pic:''},{av:'A2077ConMegSec',fld:'CONMEGSEC',pic:'ZZZ9'},{av:'dynSubTipoConCod1'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'dynSubTipoConCod2'},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynConCuenDebe'},{av:'A487ConCuenDebe',fld:'CONCUENDEBE',pic:''},{av:'dynConCuenHaber'},{av:'A488ConCuenHaber',fld:'CONCUENHABER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]");
      setEventMetadata("VALID_CONMEGSEC",",oparms:[{av:'dynTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A150ConHabilitado',fld:'CONHABILITADO',pic:''},{av:'A143ConCanti',fld:'CONCANTI',pic:''},{av:'A158ConValUni',fld:'CONVALUNI',pic:''},{av:'A152ConImporte',fld:'CONIMPORTE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'AV14esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''}]}");
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
      return "concepto_Execute";
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
      pr_default.close(83);
      pr_default.close(63);
      pr_default.close(81);
      pr_default.close(82);
      pr_default.close(80);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV11ConCodigo = "" ;
      Z26ConCodigo = "" ;
      Z42ConCodYDesc = "" ;
      Z145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      Z156ConUsuModFor = "" ;
      Z41ConDescrip = "" ;
      Z157ConValorGen = DecimalUtil.ZERO ;
      Z155ConTipoLiqGanancias = "" ;
      Z469ConCodOld = "" ;
      Z487ConCuenDebe = "" ;
      Z488ConCuenHaber = "" ;
      Z503ConTipoLiqAux = "" ;
      Z969ConConveAux = "" ;
      Z970ConClasifAux = "" ;
      Z1018ConRangoCant = "" ;
      Z954ConCondCodigo = "" ;
      Z1066ConPreReq = "" ;
      Z1648ConCodAfip = "" ;
      Z2013ConRelRef = "" ;
      Z2185ConDescripSinAc = "" ;
      Z2187ConOblPalabra = "" ;
      Z37TipoConCod = "" ;
      Z38SubTipoConCod1 = "" ;
      Z39SubTipoConCod2 = "" ;
      Z953ConCondicion = "" ;
      Z1645ConceptoConveCodigo = "" ;
      Z921ConPadre = "" ;
      O41ConDescrip = "" ;
      N37TipoConCod = "" ;
      N38SubTipoConCod1 = "" ;
      N39SubTipoConCod2 = "" ;
      N953ConCondicion = "" ;
      N1645ConceptoConveCodigo = "" ;
      N921ConPadre = "" ;
      N41ConDescrip = "" ;
      N157ConValorGen = DecimalUtil.ZERO ;
      N155ConTipoLiqGanancias = "" ;
      N153ConObservacion = "" ;
      Z32TLiqCod = "" ;
      Z950ConTLTipEgr = "" ;
      Z1410ConTLCondicion = "" ;
      Z1788ConTLTipoCon = "" ;
      N32TLiqCod = "" ;
      Z11MegCodigo = "" ;
      Z1532MegPreaTipo = "" ;
      Z1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      Gx_mode = "" ;
      A41ConDescrip = "" ;
      A39SubTipoConCod2 = "" ;
      A921ConPadre = "" ;
      A953ConCondicion = "" ;
      A1645ConceptoConveCodigo = "" ;
      A32TLiqCod = "" ;
      A11MegCodigo = "" ;
      AV11ConCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1066ConPreReq = "" ;
      A487ConCuenDebe = "" ;
      A488ConCuenHaber = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      A148ConFormula = "" ;
      TempTags = "" ;
      A26ConCodigo = "" ;
      A153ConObservacion = "" ;
      A1018ConRangoCant = "" ;
      ucDvpanel_cuentas = new com.genexus.webpanels.GXUserControl();
      Gridlevel_tipoliquidacionContainer = new com.genexus.webpanels.GXWebGrid(context);
      B41ConDescrip = "" ;
      sMode8 = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode261 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_megcodigo = new com.genexus.webpanels.GXUserControl();
      AV12DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV31MegCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A156ConUsuModFor = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A155ConTipoLiqGanancias = "" ;
      A503ConTipoLiqAux = "" ;
      A969ConConveAux = "" ;
      A970ConClasifAux = "" ;
      A2187ConOblPalabra = "" ;
      A42ConCodYDesc = "" ;
      A469ConCodOld = "" ;
      A954ConCondCodigo = "" ;
      A1648ConCodAfip = "" ;
      A2013ConRelRef = "" ;
      A2185ConDescripSinAc = "" ;
      AV27defaultConCodigo = "" ;
      A149ConFormulaAbr = "" ;
      AV23Insert_TipoConCod = "" ;
      AV24Insert_SubTipoConCod1 = "" ;
      AV25Insert_SubTipoConCod2 = "" ;
      AV34Insert_ConCondicion = "" ;
      AV33Insert_ConceptoConveCodigo = "" ;
      AV29Insert_ConPadre = "" ;
      A1974ConOldValues = "" ;
      A729ConFormulaPreResuelta = "" ;
      A151ConHisFormula = "" ;
      A569ConFormulaExpl = "" ;
      A720ConFormulaObs2 = "" ;
      AV37Pgmname = "" ;
      A950ConTLTipEgr = "" ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      A340TliqDesc = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_cuentas_Objectcall = "" ;
      Dvpanel_cuentas_Class = "" ;
      Dvpanel_cuentas_Height = "" ;
      Combo_megcodigo_Objectcall = "" ;
      Combo_megcodigo_Class = "" ;
      Combo_megcodigo_Icontype = "" ;
      Combo_megcodigo_Icon = "" ;
      Combo_megcodigo_Tooltip = "" ;
      Combo_megcodigo_Selectedvalue_set = "" ;
      Combo_megcodigo_Selectedvalue_get = "" ;
      Combo_megcodigo_Selectedtext_set = "" ;
      Combo_megcodigo_Selectedtext_get = "" ;
      Combo_megcodigo_Gamoauthtoken = "" ;
      Combo_megcodigo_Ddointernalname = "" ;
      Combo_megcodigo_Titlecontrolalign = "" ;
      Combo_megcodigo_Dropdownoptionstype = "" ;
      Combo_megcodigo_Datalisttype = "" ;
      Combo_megcodigo_Datalistfixedvalues = "" ;
      Combo_megcodigo_Remoteservicesparameters = "" ;
      Combo_megcodigo_Htmltemplate = "" ;
      Combo_megcodigo_Multiplevaluestype = "" ;
      Combo_megcodigo_Loadingdata = "" ;
      Combo_megcodigo_Noresultsfound = "" ;
      Combo_megcodigo_Emptyitemtext = "" ;
      Combo_megcodigo_Onlyselectedvalues = "" ;
      Combo_megcodigo_Selectalltext = "" ;
      Combo_megcodigo_Multiplevaluesseparator = "" ;
      Combo_megcodigo_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode7 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      AV22WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV20TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV21WebSession = httpContext.getWebSession();
      AV26TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXv_boolean5 = new boolean[1] ;
      GXv_int9 = new short[1] ;
      Z1974ConOldValues = "" ;
      Z148ConFormula = "" ;
      Z729ConFormulaPreResuelta = "" ;
      Z153ConObservacion = "" ;
      Z151ConHisFormula = "" ;
      Z569ConFormulaExpl = "" ;
      Z720ConFormulaObs2 = "" ;
      T000A18_A42ConCodYDesc = new String[] {""} ;
      T000A18_n42ConCodYDesc = new boolean[] {false} ;
      T000A18_A26ConCodigo = new String[] {""} ;
      T000A18_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      T000A18_n145ConFchModFor = new boolean[] {false} ;
      T000A18_A156ConUsuModFor = new String[] {""} ;
      T000A18_n156ConUsuModFor = new boolean[] {false} ;
      T000A18_A143ConCanti = new boolean[] {false} ;
      T000A18_A158ConValUni = new boolean[] {false} ;
      T000A18_A152ConImporte = new boolean[] {false} ;
      T000A18_A159ConVariable = new boolean[] {false} ;
      T000A18_A1905ConRelSecCli = new int[1] ;
      T000A18_A1974ConOldValues = new String[] {""} ;
      T000A18_A41ConDescrip = new String[] {""} ;
      T000A18_A150ConHabilitado = new boolean[] {false} ;
      T000A18_A40ConOrden = new int[1] ;
      T000A18_A162ConVigencia = new byte[1] ;
      T000A18_A1488ConLiqBasica = new byte[1] ;
      T000A18_A148ConFormula = new String[] {""} ;
      T000A18_n148ConFormula = new boolean[] {false} ;
      T000A18_A729ConFormulaPreResuelta = new String[] {""} ;
      T000A18_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A18_n157ConValorGen = new boolean[] {false} ;
      T000A18_A155ConTipoLiqGanancias = new String[] {""} ;
      T000A18_n155ConTipoLiqGanancias = new boolean[] {false} ;
      T000A18_A153ConObservacion = new String[] {""} ;
      T000A18_A151ConHisFormula = new String[] {""} ;
      T000A18_n151ConHisFormula = new boolean[] {false} ;
      T000A18_A154ConTipo = new byte[1] ;
      T000A18_A469ConCodOld = new String[] {""} ;
      T000A18_A487ConCuenDebe = new String[] {""} ;
      T000A18_n487ConCuenDebe = new boolean[] {false} ;
      T000A18_A488ConCuenHaber = new String[] {""} ;
      T000A18_n488ConCuenHaber = new boolean[] {false} ;
      T000A18_A503ConTipoLiqAux = new String[] {""} ;
      T000A18_n503ConTipoLiqAux = new boolean[] {false} ;
      T000A18_A969ConConveAux = new String[] {""} ;
      T000A18_n969ConConveAux = new boolean[] {false} ;
      T000A18_A970ConClasifAux = new String[] {""} ;
      T000A18_n970ConClasifAux = new boolean[] {false} ;
      T000A18_A510ConOrdEjec = new long[1] ;
      T000A18_A569ConFormulaExpl = new String[] {""} ;
      T000A18_A720ConFormulaObs2 = new String[] {""} ;
      T000A18_A734ConRetGanPropor = new boolean[] {false} ;
      T000A18_A735ConAplicGan = new byte[1] ;
      T000A18_n735ConAplicGan = new boolean[] {false} ;
      T000A18_A762ConRecalcular = new boolean[] {false} ;
      T000A18_A894ConImportado = new boolean[] {false} ;
      T000A18_A895ConTipoOrden = new short[1] ;
      T000A18_A1017ConEdiEnRec = new boolean[] {false} ;
      T000A18_A1018ConRangoCant = new String[] {""} ;
      T000A18_A922ConUsado = new boolean[] {false} ;
      T000A18_A951ConObliga = new boolean[] {false} ;
      T000A18_n951ConObliga = new boolean[] {false} ;
      T000A18_A952ConObligaSiSac = new boolean[] {false} ;
      T000A18_n952ConObligaSiSac = new boolean[] {false} ;
      T000A18_A954ConCondCodigo = new String[] {""} ;
      T000A18_A1066ConPreReq = new String[] {""} ;
      T000A18_n1066ConPreReq = new boolean[] {false} ;
      T000A18_A1068ConMostrarPos = new boolean[] {false} ;
      T000A18_A1077ConAdelDescu = new byte[1] ;
      T000A18_n1077ConAdelDescu = new boolean[] {false} ;
      T000A18_A1194ConSegunPla = new boolean[] {false} ;
      T000A18_A1471ConNumero = new byte[1] ;
      T000A18_A1472ConSIPAApo = new byte[1] ;
      T000A18_A1473ConSIPACont = new byte[1] ;
      T000A18_A1474ConINSSJyPApo = new byte[1] ;
      T000A18_A1475ConINSSJyPCont = new byte[1] ;
      T000A18_A1476ConObraSocApo = new byte[1] ;
      T000A18_A1477ConObraSocCont = new byte[1] ;
      T000A18_A1478ConFonSolRedApo = new byte[1] ;
      T000A18_A1479ConFonSolRedCont = new byte[1] ;
      T000A18_A1480ConRenateaApo = new byte[1] ;
      T000A18_A1481ConRenateaCont = new byte[1] ;
      T000A18_A1482ConAsigFamCont = new byte[1] ;
      T000A18_A1483ConFonNacEmpCont = new byte[1] ;
      T000A18_A1484ConLeyRieTrabCont = new byte[1] ;
      T000A18_A1485ConRegDifApo = new byte[1] ;
      T000A18_A1486ConRegEspApo = new byte[1] ;
      T000A18_A1539ConSacDeven = new byte[1] ;
      T000A18_A1620ConBaseLic = new byte[1] ;
      T000A18_A1797ConBaseLicProm = new byte[1] ;
      T000A18_A1621ConBaseFer = new byte[1] ;
      T000A18_A1798ConBaseFerProm = new byte[1] ;
      T000A18_A1622ConBaseHorExt = new byte[1] ;
      T000A18_A1799ConBaseHorExtProm = new byte[1] ;
      T000A18_A1800ConBasePres = new byte[1] ;
      T000A18_A1801ConBaseAnt = new byte[1] ;
      T000A18_A1827ConBaseOSDif = new byte[1] ;
      T000A18_A2191ConBaseAus = new byte[1] ;
      T000A18_A2192ConBaseAusProm = new byte[1] ;
      T000A18_A1648ConCodAfip = new String[] {""} ;
      T000A18_A1769ConCntPa = new byte[1] ;
      T000A18_A1821ConErrorSiCero = new boolean[] {false} ;
      T000A18_A1826ConPueNov = new boolean[] {false} ;
      T000A18_A1886ConRelSec = new int[1] ;
      T000A18_A2013ConRelRef = new String[] {""} ;
      T000A18_A2185ConDescripSinAc = new String[] {""} ;
      T000A18_A2187ConOblPalabra = new String[] {""} ;
      T000A18_n2187ConOblPalabra = new boolean[] {false} ;
      T000A18_A1822CliPadre = new int[1] ;
      T000A18_n1822CliPadre = new boolean[] {false} ;
      T000A18_A3CliCod = new int[1] ;
      T000A18_A1112AplIIGG = new short[1] ;
      T000A18_n1112AplIIGG = new boolean[] {false} ;
      T000A18_A37TipoConCod = new String[] {""} ;
      T000A18_A38SubTipoConCod1 = new String[] {""} ;
      T000A18_n38SubTipoConCod1 = new boolean[] {false} ;
      T000A18_A39SubTipoConCod2 = new String[] {""} ;
      T000A18_n39SubTipoConCod2 = new boolean[] {false} ;
      T000A18_A953ConCondicion = new String[] {""} ;
      T000A18_n953ConCondicion = new boolean[] {false} ;
      T000A18_A1644ConceptoPais = new short[1] ;
      T000A18_n1644ConceptoPais = new boolean[] {false} ;
      T000A18_A1645ConceptoConveCodigo = new String[] {""} ;
      T000A18_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T000A18_A921ConPadre = new String[] {""} ;
      T000A18_n921ConPadre = new boolean[] {false} ;
      T000A10_A3CliCod = new int[1] ;
      T000A12_A37TipoConCod = new String[] {""} ;
      T000A13_A37TipoConCod = new String[] {""} ;
      T000A14_A37TipoConCod = new String[] {""} ;
      T000A11_A3CliCod = new int[1] ;
      T000A17_A1822CliPadre = new int[1] ;
      T000A17_n1822CliPadre = new boolean[] {false} ;
      T000A15_A953ConCondicion = new String[] {""} ;
      T000A15_n953ConCondicion = new boolean[] {false} ;
      T000A16_A1644ConceptoPais = new short[1] ;
      T000A16_n1644ConceptoPais = new boolean[] {false} ;
      T000A19_A3CliCod = new int[1] ;
      T000A20_A37TipoConCod = new String[] {""} ;
      T000A21_A37TipoConCod = new String[] {""} ;
      T000A22_A37TipoConCod = new String[] {""} ;
      T000A23_A3CliCod = new int[1] ;
      T000A24_A1822CliPadre = new int[1] ;
      T000A24_n1822CliPadre = new boolean[] {false} ;
      T000A25_A953ConCondicion = new String[] {""} ;
      T000A25_n953ConCondicion = new boolean[] {false} ;
      T000A26_A1644ConceptoPais = new short[1] ;
      T000A26_n1644ConceptoPais = new boolean[] {false} ;
      T000A27_A3CliCod = new int[1] ;
      T000A27_A26ConCodigo = new String[] {""} ;
      T000A9_A42ConCodYDesc = new String[] {""} ;
      T000A9_n42ConCodYDesc = new boolean[] {false} ;
      T000A9_A26ConCodigo = new String[] {""} ;
      T000A9_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      T000A9_n145ConFchModFor = new boolean[] {false} ;
      T000A9_A156ConUsuModFor = new String[] {""} ;
      T000A9_n156ConUsuModFor = new boolean[] {false} ;
      T000A9_A143ConCanti = new boolean[] {false} ;
      T000A9_A158ConValUni = new boolean[] {false} ;
      T000A9_A152ConImporte = new boolean[] {false} ;
      T000A9_A159ConVariable = new boolean[] {false} ;
      T000A9_A1905ConRelSecCli = new int[1] ;
      T000A9_A1974ConOldValues = new String[] {""} ;
      T000A9_A41ConDescrip = new String[] {""} ;
      T000A9_A150ConHabilitado = new boolean[] {false} ;
      T000A9_A40ConOrden = new int[1] ;
      T000A9_A162ConVigencia = new byte[1] ;
      T000A9_A1488ConLiqBasica = new byte[1] ;
      T000A9_A148ConFormula = new String[] {""} ;
      T000A9_n148ConFormula = new boolean[] {false} ;
      T000A9_A729ConFormulaPreResuelta = new String[] {""} ;
      T000A9_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A9_n157ConValorGen = new boolean[] {false} ;
      T000A9_A155ConTipoLiqGanancias = new String[] {""} ;
      T000A9_n155ConTipoLiqGanancias = new boolean[] {false} ;
      T000A9_A153ConObservacion = new String[] {""} ;
      T000A9_A151ConHisFormula = new String[] {""} ;
      T000A9_n151ConHisFormula = new boolean[] {false} ;
      T000A9_A154ConTipo = new byte[1] ;
      T000A9_A469ConCodOld = new String[] {""} ;
      T000A9_A487ConCuenDebe = new String[] {""} ;
      T000A9_n487ConCuenDebe = new boolean[] {false} ;
      T000A9_A488ConCuenHaber = new String[] {""} ;
      T000A9_n488ConCuenHaber = new boolean[] {false} ;
      T000A9_A503ConTipoLiqAux = new String[] {""} ;
      T000A9_n503ConTipoLiqAux = new boolean[] {false} ;
      T000A9_A969ConConveAux = new String[] {""} ;
      T000A9_n969ConConveAux = new boolean[] {false} ;
      T000A9_A970ConClasifAux = new String[] {""} ;
      T000A9_n970ConClasifAux = new boolean[] {false} ;
      T000A9_A510ConOrdEjec = new long[1] ;
      T000A9_A569ConFormulaExpl = new String[] {""} ;
      T000A9_A720ConFormulaObs2 = new String[] {""} ;
      T000A9_A734ConRetGanPropor = new boolean[] {false} ;
      T000A9_A735ConAplicGan = new byte[1] ;
      T000A9_n735ConAplicGan = new boolean[] {false} ;
      T000A9_A762ConRecalcular = new boolean[] {false} ;
      T000A9_A894ConImportado = new boolean[] {false} ;
      T000A9_A895ConTipoOrden = new short[1] ;
      T000A9_A1017ConEdiEnRec = new boolean[] {false} ;
      T000A9_A1018ConRangoCant = new String[] {""} ;
      T000A9_A922ConUsado = new boolean[] {false} ;
      T000A9_A951ConObliga = new boolean[] {false} ;
      T000A9_n951ConObliga = new boolean[] {false} ;
      T000A9_A952ConObligaSiSac = new boolean[] {false} ;
      T000A9_n952ConObligaSiSac = new boolean[] {false} ;
      T000A9_A954ConCondCodigo = new String[] {""} ;
      T000A9_A1066ConPreReq = new String[] {""} ;
      T000A9_n1066ConPreReq = new boolean[] {false} ;
      T000A9_A1068ConMostrarPos = new boolean[] {false} ;
      T000A9_A1077ConAdelDescu = new byte[1] ;
      T000A9_n1077ConAdelDescu = new boolean[] {false} ;
      T000A9_A1194ConSegunPla = new boolean[] {false} ;
      T000A9_A1471ConNumero = new byte[1] ;
      T000A9_A1472ConSIPAApo = new byte[1] ;
      T000A9_A1473ConSIPACont = new byte[1] ;
      T000A9_A1474ConINSSJyPApo = new byte[1] ;
      T000A9_A1475ConINSSJyPCont = new byte[1] ;
      T000A9_A1476ConObraSocApo = new byte[1] ;
      T000A9_A1477ConObraSocCont = new byte[1] ;
      T000A9_A1478ConFonSolRedApo = new byte[1] ;
      T000A9_A1479ConFonSolRedCont = new byte[1] ;
      T000A9_A1480ConRenateaApo = new byte[1] ;
      T000A9_A1481ConRenateaCont = new byte[1] ;
      T000A9_A1482ConAsigFamCont = new byte[1] ;
      T000A9_A1483ConFonNacEmpCont = new byte[1] ;
      T000A9_A1484ConLeyRieTrabCont = new byte[1] ;
      T000A9_A1485ConRegDifApo = new byte[1] ;
      T000A9_A1486ConRegEspApo = new byte[1] ;
      T000A9_A1539ConSacDeven = new byte[1] ;
      T000A9_A1620ConBaseLic = new byte[1] ;
      T000A9_A1797ConBaseLicProm = new byte[1] ;
      T000A9_A1621ConBaseFer = new byte[1] ;
      T000A9_A1798ConBaseFerProm = new byte[1] ;
      T000A9_A1622ConBaseHorExt = new byte[1] ;
      T000A9_A1799ConBaseHorExtProm = new byte[1] ;
      T000A9_A1800ConBasePres = new byte[1] ;
      T000A9_A1801ConBaseAnt = new byte[1] ;
      T000A9_A1827ConBaseOSDif = new byte[1] ;
      T000A9_A2191ConBaseAus = new byte[1] ;
      T000A9_A2192ConBaseAusProm = new byte[1] ;
      T000A9_A1648ConCodAfip = new String[] {""} ;
      T000A9_A1769ConCntPa = new byte[1] ;
      T000A9_A1821ConErrorSiCero = new boolean[] {false} ;
      T000A9_A1826ConPueNov = new boolean[] {false} ;
      T000A9_A1886ConRelSec = new int[1] ;
      T000A9_A2013ConRelRef = new String[] {""} ;
      T000A9_A2185ConDescripSinAc = new String[] {""} ;
      T000A9_A2187ConOblPalabra = new String[] {""} ;
      T000A9_n2187ConOblPalabra = new boolean[] {false} ;
      T000A9_A1822CliPadre = new int[1] ;
      T000A9_n1822CliPadre = new boolean[] {false} ;
      T000A9_A3CliCod = new int[1] ;
      T000A9_A1112AplIIGG = new short[1] ;
      T000A9_n1112AplIIGG = new boolean[] {false} ;
      T000A9_A37TipoConCod = new String[] {""} ;
      T000A9_A38SubTipoConCod1 = new String[] {""} ;
      T000A9_n38SubTipoConCod1 = new boolean[] {false} ;
      T000A9_A39SubTipoConCod2 = new String[] {""} ;
      T000A9_n39SubTipoConCod2 = new boolean[] {false} ;
      T000A9_A953ConCondicion = new String[] {""} ;
      T000A9_n953ConCondicion = new boolean[] {false} ;
      T000A9_A1644ConceptoPais = new short[1] ;
      T000A9_n1644ConceptoPais = new boolean[] {false} ;
      T000A9_A1645ConceptoConveCodigo = new String[] {""} ;
      T000A9_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T000A9_A921ConPadre = new String[] {""} ;
      T000A9_n921ConPadre = new boolean[] {false} ;
      T000A28_A3CliCod = new int[1] ;
      T000A28_A26ConCodigo = new String[] {""} ;
      T000A29_A3CliCod = new int[1] ;
      T000A29_A26ConCodigo = new String[] {""} ;
      T000A8_A42ConCodYDesc = new String[] {""} ;
      T000A8_n42ConCodYDesc = new boolean[] {false} ;
      T000A8_A26ConCodigo = new String[] {""} ;
      T000A8_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      T000A8_n145ConFchModFor = new boolean[] {false} ;
      T000A8_A156ConUsuModFor = new String[] {""} ;
      T000A8_n156ConUsuModFor = new boolean[] {false} ;
      T000A8_A143ConCanti = new boolean[] {false} ;
      T000A8_A158ConValUni = new boolean[] {false} ;
      T000A8_A152ConImporte = new boolean[] {false} ;
      T000A8_A159ConVariable = new boolean[] {false} ;
      T000A8_A1905ConRelSecCli = new int[1] ;
      T000A8_A1974ConOldValues = new String[] {""} ;
      T000A8_A41ConDescrip = new String[] {""} ;
      T000A8_A150ConHabilitado = new boolean[] {false} ;
      T000A8_A40ConOrden = new int[1] ;
      T000A8_A162ConVigencia = new byte[1] ;
      T000A8_A1488ConLiqBasica = new byte[1] ;
      T000A8_A148ConFormula = new String[] {""} ;
      T000A8_n148ConFormula = new boolean[] {false} ;
      T000A8_A729ConFormulaPreResuelta = new String[] {""} ;
      T000A8_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A8_n157ConValorGen = new boolean[] {false} ;
      T000A8_A155ConTipoLiqGanancias = new String[] {""} ;
      T000A8_n155ConTipoLiqGanancias = new boolean[] {false} ;
      T000A8_A153ConObservacion = new String[] {""} ;
      T000A8_A151ConHisFormula = new String[] {""} ;
      T000A8_n151ConHisFormula = new boolean[] {false} ;
      T000A8_A154ConTipo = new byte[1] ;
      T000A8_A469ConCodOld = new String[] {""} ;
      T000A8_A487ConCuenDebe = new String[] {""} ;
      T000A8_n487ConCuenDebe = new boolean[] {false} ;
      T000A8_A488ConCuenHaber = new String[] {""} ;
      T000A8_n488ConCuenHaber = new boolean[] {false} ;
      T000A8_A503ConTipoLiqAux = new String[] {""} ;
      T000A8_n503ConTipoLiqAux = new boolean[] {false} ;
      T000A8_A969ConConveAux = new String[] {""} ;
      T000A8_n969ConConveAux = new boolean[] {false} ;
      T000A8_A970ConClasifAux = new String[] {""} ;
      T000A8_n970ConClasifAux = new boolean[] {false} ;
      T000A8_A510ConOrdEjec = new long[1] ;
      T000A8_A569ConFormulaExpl = new String[] {""} ;
      T000A8_A720ConFormulaObs2 = new String[] {""} ;
      T000A8_A734ConRetGanPropor = new boolean[] {false} ;
      T000A8_A735ConAplicGan = new byte[1] ;
      T000A8_n735ConAplicGan = new boolean[] {false} ;
      T000A8_A762ConRecalcular = new boolean[] {false} ;
      T000A8_A894ConImportado = new boolean[] {false} ;
      T000A8_A895ConTipoOrden = new short[1] ;
      T000A8_A1017ConEdiEnRec = new boolean[] {false} ;
      T000A8_A1018ConRangoCant = new String[] {""} ;
      T000A8_A922ConUsado = new boolean[] {false} ;
      T000A8_A951ConObliga = new boolean[] {false} ;
      T000A8_n951ConObliga = new boolean[] {false} ;
      T000A8_A952ConObligaSiSac = new boolean[] {false} ;
      T000A8_n952ConObligaSiSac = new boolean[] {false} ;
      T000A8_A954ConCondCodigo = new String[] {""} ;
      T000A8_A1066ConPreReq = new String[] {""} ;
      T000A8_n1066ConPreReq = new boolean[] {false} ;
      T000A8_A1068ConMostrarPos = new boolean[] {false} ;
      T000A8_A1077ConAdelDescu = new byte[1] ;
      T000A8_n1077ConAdelDescu = new boolean[] {false} ;
      T000A8_A1194ConSegunPla = new boolean[] {false} ;
      T000A8_A1471ConNumero = new byte[1] ;
      T000A8_A1472ConSIPAApo = new byte[1] ;
      T000A8_A1473ConSIPACont = new byte[1] ;
      T000A8_A1474ConINSSJyPApo = new byte[1] ;
      T000A8_A1475ConINSSJyPCont = new byte[1] ;
      T000A8_A1476ConObraSocApo = new byte[1] ;
      T000A8_A1477ConObraSocCont = new byte[1] ;
      T000A8_A1478ConFonSolRedApo = new byte[1] ;
      T000A8_A1479ConFonSolRedCont = new byte[1] ;
      T000A8_A1480ConRenateaApo = new byte[1] ;
      T000A8_A1481ConRenateaCont = new byte[1] ;
      T000A8_A1482ConAsigFamCont = new byte[1] ;
      T000A8_A1483ConFonNacEmpCont = new byte[1] ;
      T000A8_A1484ConLeyRieTrabCont = new byte[1] ;
      T000A8_A1485ConRegDifApo = new byte[1] ;
      T000A8_A1486ConRegEspApo = new byte[1] ;
      T000A8_A1539ConSacDeven = new byte[1] ;
      T000A8_A1620ConBaseLic = new byte[1] ;
      T000A8_A1797ConBaseLicProm = new byte[1] ;
      T000A8_A1621ConBaseFer = new byte[1] ;
      T000A8_A1798ConBaseFerProm = new byte[1] ;
      T000A8_A1622ConBaseHorExt = new byte[1] ;
      T000A8_A1799ConBaseHorExtProm = new byte[1] ;
      T000A8_A1800ConBasePres = new byte[1] ;
      T000A8_A1801ConBaseAnt = new byte[1] ;
      T000A8_A1827ConBaseOSDif = new byte[1] ;
      T000A8_A2191ConBaseAus = new byte[1] ;
      T000A8_A2192ConBaseAusProm = new byte[1] ;
      T000A8_A1648ConCodAfip = new String[] {""} ;
      T000A8_A1769ConCntPa = new byte[1] ;
      T000A8_A1821ConErrorSiCero = new boolean[] {false} ;
      T000A8_A1826ConPueNov = new boolean[] {false} ;
      T000A8_A1886ConRelSec = new int[1] ;
      T000A8_A2013ConRelRef = new String[] {""} ;
      T000A8_A2185ConDescripSinAc = new String[] {""} ;
      T000A8_A2187ConOblPalabra = new String[] {""} ;
      T000A8_n2187ConOblPalabra = new boolean[] {false} ;
      T000A8_A1822CliPadre = new int[1] ;
      T000A8_n1822CliPadre = new boolean[] {false} ;
      T000A8_A3CliCod = new int[1] ;
      T000A8_A1112AplIIGG = new short[1] ;
      T000A8_n1112AplIIGG = new boolean[] {false} ;
      T000A8_A37TipoConCod = new String[] {""} ;
      T000A8_A38SubTipoConCod1 = new String[] {""} ;
      T000A8_n38SubTipoConCod1 = new boolean[] {false} ;
      T000A8_A39SubTipoConCod2 = new String[] {""} ;
      T000A8_n39SubTipoConCod2 = new boolean[] {false} ;
      T000A8_A953ConCondicion = new String[] {""} ;
      T000A8_n953ConCondicion = new boolean[] {false} ;
      T000A8_A1644ConceptoPais = new short[1] ;
      T000A8_n1644ConceptoPais = new boolean[] {false} ;
      T000A8_A1645ConceptoConveCodigo = new String[] {""} ;
      T000A8_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T000A8_A921ConPadre = new String[] {""} ;
      T000A8_n921ConPadre = new boolean[] {false} ;
      T000A33_A1822CliPadre = new int[1] ;
      T000A33_n1822CliPadre = new boolean[] {false} ;
      T000A33_A921ConPadre = new String[] {""} ;
      T000A33_n921ConPadre = new boolean[] {false} ;
      T000A34_A46PaiCod = new short[1] ;
      T000A34_A1440PaiBaseClaseLeg = new byte[1] ;
      T000A34_A1441PaiBaseTipo = new String[] {""} ;
      T000A34_A1442PaiBaseCod1 = new String[] {""} ;
      T000A34_A1443PaiBaseCod2 = new String[] {""} ;
      T000A34_A1445PaiBaseCliCod = new int[1] ;
      T000A34_A1446PaiBaseConCodigo = new String[] {""} ;
      T000A35_A46PaiCod = new short[1] ;
      T000A35_A1356PaiMenCliCod = new int[1] ;
      T000A35_A1358PaiMesConCodigo = new String[] {""} ;
      T000A36_A46PaiCod = new short[1] ;
      T000A36_A1354PaiJorCliCod = new int[1] ;
      T000A36_A1355PaiJorConCodigo = new String[] {""} ;
      T000A37_A3CliCod = new int[1] ;
      T000A37_A1EmpCod = new short[1] ;
      T000A37_A6LegNumero = new int[1] ;
      T000A37_A1135LegSuelSec = new short[1] ;
      T000A37_A2349LegSuelConcepto = new String[] {""} ;
      T000A38_A3CliCod = new int[1] ;
      T000A38_A26ConCodigo = new String[] {""} ;
      T000A38_A2119ConOpeId = new String[] {""} ;
      T000A38_A923ConOperFor = new String[] {""} ;
      T000A39_A3CliCod = new int[1] ;
      T000A39_A1EmpCod = new short[1] ;
      T000A39_A6LegNumero = new int[1] ;
      T000A39_A1829PreliqTLiqCod = new String[] {""} ;
      T000A39_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000A39_A1831PreliqConcepto = new String[] {""} ;
      T000A40_A3CliCod = new int[1] ;
      T000A40_A1564CliPaiConve = new short[1] ;
      T000A40_A1565CliConvenio = new String[] {""} ;
      T000A40_A1327ConveHsExSec = new short[1] ;
      T000A41_A3CliCod = new int[1] ;
      T000A41_A1564CliPaiConve = new short[1] ;
      T000A41_A1565CliConvenio = new String[] {""} ;
      T000A41_A1381ConveMenCliCod = new int[1] ;
      T000A41_A1375ConveMenConCodigo = new String[] {""} ;
      T000A42_A3CliCod = new int[1] ;
      T000A42_A1EmpCod = new short[1] ;
      T000A42_A31LiqNro = new int[1] ;
      T000A42_A6LegNumero = new int[1] ;
      T000A42_A1541LiqAjuNro = new short[1] ;
      T000A42_A1543LiqAjuSec = new short[1] ;
      T000A43_A3CliCod = new int[1] ;
      T000A43_A1EmpCod = new short[1] ;
      T000A43_A1366EmpJorConCodigo = new String[] {""} ;
      T000A44_A3CliCod = new int[1] ;
      T000A44_A1EmpCod = new short[1] ;
      T000A44_A1368EmpMenConCodigo = new String[] {""} ;
      T000A45_A3CliCod = new int[1] ;
      T000A45_A1EmpCod = new short[1] ;
      T000A45_A6LegNumero = new int[1] ;
      T000A45_A1172OblSecuencial = new short[1] ;
      T000A45_A1170OblExcConCOdigo = new String[] {""} ;
      T000A46_A3CliCod = new int[1] ;
      T000A46_A1EmpCod = new short[1] ;
      T000A46_A6LegNumero = new int[1] ;
      T000A46_A1172OblSecuencial = new short[1] ;
      T000A47_A3CliCod = new int[1] ;
      T000A47_A1EmpCod = new short[1] ;
      T000A47_A6LegNumero = new int[1] ;
      T000A47_A1172OblSecuencial = new short[1] ;
      T000A48_A3CliCod = new int[1] ;
      T000A48_A1EmpCod = new short[1] ;
      T000A48_A1129LiqExAnio = new short[1] ;
      T000A48_A31LiqNro = new int[1] ;
      T000A48_A6LegNumero = new int[1] ;
      T000A48_A1127LiqExenConCodigo = new String[] {""} ;
      T000A48_A1128LiqExAplIIGG = new short[1] ;
      T000A49_A3CliCod = new int[1] ;
      T000A49_A1112AplIIGG = new short[1] ;
      T000A49_n1112AplIIGG = new boolean[] {false} ;
      T000A50_A3CliCod = new int[1] ;
      T000A50_A1112AplIIGG = new short[1] ;
      T000A50_n1112AplIIGG = new boolean[] {false} ;
      T000A51_A3CliCod = new int[1] ;
      T000A51_A1112AplIIGG = new short[1] ;
      T000A51_n1112AplIIGG = new boolean[] {false} ;
      T000A52_A3CliCod = new int[1] ;
      T000A52_A1105CondExenIIGG = new String[] {""} ;
      T000A53_A3CliCod = new int[1] ;
      T000A53_A1101SiraTipo = new String[] {""} ;
      T000A53_A1102SiraCodigo = new String[] {""} ;
      T000A54_A3CliCod = new int[1] ;
      T000A54_A1EmpCod = new short[1] ;
      T000A54_A869LiqLegConAnio = new short[1] ;
      T000A54_A6LegNumero = new int[1] ;
      T000A54_A26ConCodigo = new String[] {""} ;
      T000A54_A1097LiqAltaNro = new int[1] ;
      T000A54_A1098LiqNuevaNro = new int[1] ;
      T000A55_A3CliCod = new int[1] ;
      T000A55_A1EmpCod = new short[1] ;
      T000A55_A6LegNumero = new int[1] ;
      T000A55_A83LegDedSec = new int[1] ;
      T000A56_A3CliCod = new int[1] ;
      T000A56_A26ConCodigo = new String[] {""} ;
      T000A56_A51ForHisNum = new short[1] ;
      T000A57_A3CliCod = new int[1] ;
      T000A57_A1EmpCod = new short[1] ;
      T000A57_A6LegNumero = new int[1] ;
      T000A57_A25AgeOrden = new short[1] ;
      T000A58_A3CliCod = new int[1] ;
      T000A58_A26ConCodigo = new String[] {""} ;
      Z340TliqDesc = "" ;
      T000A7_A340TliqDesc = new String[] {""} ;
      T000A59_A26ConCodigo = new String[] {""} ;
      T000A59_A340TliqDesc = new String[] {""} ;
      T000A59_A925ConTLiqSinCausa = new boolean[] {false} ;
      T000A59_n925ConTLiqSinCausa = new boolean[] {false} ;
      T000A59_A926ConTLiqSinPre = new boolean[] {false} ;
      T000A59_n926ConTLiqSinPre = new boolean[] {false} ;
      T000A59_A950ConTLTipEgr = new String[] {""} ;
      T000A59_A1406ConTLOrdejec = new long[1] ;
      T000A59_A1407ConTLConOrd = new short[1] ;
      T000A59_A1409ConTLVigencia = new byte[1] ;
      T000A59_n1409ConTLVigencia = new boolean[] {false} ;
      T000A59_A1410ConTLCondicion = new String[] {""} ;
      T000A59_n1410ConTLCondicion = new boolean[] {false} ;
      T000A59_A1470ConTLConHab = new byte[1] ;
      T000A59_A1788ConTLTipoCon = new String[] {""} ;
      T000A59_n1788ConTLTipoCon = new boolean[] {false} ;
      T000A59_A1789CONTLSegPla = new byte[1] ;
      T000A59_n1789CONTLSegPla = new boolean[] {false} ;
      T000A59_A3CliCod = new int[1] ;
      T000A59_A32TLiqCod = new String[] {""} ;
      T000A60_A340TliqDesc = new String[] {""} ;
      T000A61_A3CliCod = new int[1] ;
      T000A61_A26ConCodigo = new String[] {""} ;
      T000A61_A32TLiqCod = new String[] {""} ;
      T000A6_A26ConCodigo = new String[] {""} ;
      T000A6_A925ConTLiqSinCausa = new boolean[] {false} ;
      T000A6_n925ConTLiqSinCausa = new boolean[] {false} ;
      T000A6_A926ConTLiqSinPre = new boolean[] {false} ;
      T000A6_n926ConTLiqSinPre = new boolean[] {false} ;
      T000A6_A950ConTLTipEgr = new String[] {""} ;
      T000A6_A1406ConTLOrdejec = new long[1] ;
      T000A6_A1407ConTLConOrd = new short[1] ;
      T000A6_A1409ConTLVigencia = new byte[1] ;
      T000A6_n1409ConTLVigencia = new boolean[] {false} ;
      T000A6_A1410ConTLCondicion = new String[] {""} ;
      T000A6_n1410ConTLCondicion = new boolean[] {false} ;
      T000A6_A1470ConTLConHab = new byte[1] ;
      T000A6_A1788ConTLTipoCon = new String[] {""} ;
      T000A6_n1788ConTLTipoCon = new boolean[] {false} ;
      T000A6_A1789CONTLSegPla = new byte[1] ;
      T000A6_n1789CONTLSegPla = new boolean[] {false} ;
      T000A6_A3CliCod = new int[1] ;
      T000A6_A32TLiqCod = new String[] {""} ;
      T000A5_A26ConCodigo = new String[] {""} ;
      T000A5_A925ConTLiqSinCausa = new boolean[] {false} ;
      T000A5_n925ConTLiqSinCausa = new boolean[] {false} ;
      T000A5_A926ConTLiqSinPre = new boolean[] {false} ;
      T000A5_n926ConTLiqSinPre = new boolean[] {false} ;
      T000A5_A950ConTLTipEgr = new String[] {""} ;
      T000A5_A1406ConTLOrdejec = new long[1] ;
      T000A5_A1407ConTLConOrd = new short[1] ;
      T000A5_A1409ConTLVigencia = new byte[1] ;
      T000A5_n1409ConTLVigencia = new boolean[] {false} ;
      T000A5_A1410ConTLCondicion = new String[] {""} ;
      T000A5_n1410ConTLCondicion = new boolean[] {false} ;
      T000A5_A1470ConTLConHab = new byte[1] ;
      T000A5_A1788ConTLTipoCon = new String[] {""} ;
      T000A5_n1788ConTLTipoCon = new boolean[] {false} ;
      T000A5_A1789CONTLSegPla = new byte[1] ;
      T000A5_n1789CONTLSegPla = new boolean[] {false} ;
      T000A5_A3CliCod = new int[1] ;
      T000A5_A32TLiqCod = new String[] {""} ;
      T000A65_A340TliqDesc = new String[] {""} ;
      T000A66_A3CliCod = new int[1] ;
      T000A66_A26ConCodigo = new String[] {""} ;
      T000A66_A32TLiqCod = new String[] {""} ;
      T000A67_A26ConCodigo = new String[] {""} ;
      T000A67_A2077ConMegSec = new short[1] ;
      T000A67_A1532MegPreaTipo = new String[] {""} ;
      T000A67_A1530ConMegMeses = new byte[1] ;
      T000A67_A1534ConMegDura = new String[] {""} ;
      T000A67_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A67_A3CliCod = new int[1] ;
      T000A67_A11MegCodigo = new String[] {""} ;
      T000A4_A3CliCod = new int[1] ;
      T000A68_A3CliCod = new int[1] ;
      T000A69_A3CliCod = new int[1] ;
      T000A70_A3CliCod = new int[1] ;
      T000A70_A26ConCodigo = new String[] {""} ;
      T000A70_A11MegCodigo = new String[] {""} ;
      T000A70_A2077ConMegSec = new short[1] ;
      T000A3_A26ConCodigo = new String[] {""} ;
      T000A3_A2077ConMegSec = new short[1] ;
      T000A3_A1532MegPreaTipo = new String[] {""} ;
      T000A3_A1530ConMegMeses = new byte[1] ;
      T000A3_A1534ConMegDura = new String[] {""} ;
      T000A3_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A3_A3CliCod = new int[1] ;
      T000A3_A11MegCodigo = new String[] {""} ;
      T000A2_A26ConCodigo = new String[] {""} ;
      T000A2_A2077ConMegSec = new short[1] ;
      T000A2_A1532MegPreaTipo = new String[] {""} ;
      T000A2_A1530ConMegMeses = new byte[1] ;
      T000A2_A1534ConMegDura = new String[] {""} ;
      T000A2_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A2_A3CliCod = new int[1] ;
      T000A2_A11MegCodigo = new String[] {""} ;
      T000A74_A3CliCod = new int[1] ;
      T000A74_A26ConCodigo = new String[] {""} ;
      T000A74_A11MegCodigo = new String[] {""} ;
      T000A74_A2077ConMegSec = new short[1] ;
      Gridlevel_tipoliquidacionRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_tipoliquidacion_Linesclass = "" ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i149ConFormulaAbr = "" ;
      i155ConTipoLiqGanancias = "" ;
      Gridlevel_tipoliquidacionColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T000A75_A37TipoConCod = new String[] {""} ;
      T000A75_A370TipoConDescrip = new String[] {""} ;
      T000A76_A37TipoConCod = new String[] {""} ;
      T000A76_A38SubTipoConCod1 = new String[] {""} ;
      T000A76_n38SubTipoConCod1 = new boolean[] {false} ;
      T000A76_A371SubTipoConDes1 = new String[] {""} ;
      T000A77_A37TipoConCod = new String[] {""} ;
      T000A77_A38SubTipoConCod1 = new String[] {""} ;
      T000A77_n38SubTipoConCod1 = new boolean[] {false} ;
      T000A77_A39SubTipoConCod2 = new String[] {""} ;
      T000A77_n39SubTipoConCod2 = new boolean[] {false} ;
      T000A77_A372SubTipoConDes2 = new String[] {""} ;
      T000A78_A3CliCod = new int[1] ;
      T000A78_A78CuenCodigo = new String[] {""} ;
      T000A78_A485CuenDescrip = new String[] {""} ;
      T000A78_A1EmpCod = new short[1] ;
      T000A78_A486CuenTipo = new String[] {""} ;
      T000A79_A3CliCod = new int[1] ;
      T000A79_A78CuenCodigo = new String[] {""} ;
      T000A79_A485CuenDescrip = new String[] {""} ;
      T000A79_A1EmpCod = new short[1] ;
      T000A79_A486CuenTipo = new String[] {""} ;
      T000A80_A3CliCod = new int[1] ;
      T000A80_A32TLiqCod = new String[] {""} ;
      T000A80_A340TliqDesc = new String[] {""} ;
      T000A80_A341TLiqHabilitada = new boolean[] {false} ;
      GXv_int7 = new int[1] ;
      GXt_dtime12 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime13 = new java.util.Date[1] ;
      T000A81_A37TipoConCod = new String[] {""} ;
      T000A81_A370TipoConDescrip = new String[] {""} ;
      T000A82_A37TipoConCod = new String[] {""} ;
      T000A83_A37TipoConCod = new String[] {""} ;
      T000A84_A37TipoConCod = new String[] {""} ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      T000A85_A3CliCod = new int[1] ;
      T000A86_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.concepto__default(),
         new Object[] {
             new Object[] {
            T000A2_A26ConCodigo, T000A2_A2077ConMegSec, T000A2_A1532MegPreaTipo, T000A2_A1530ConMegMeses, T000A2_A1534ConMegDura, T000A2_A1529ConMegPropor, T000A2_A3CliCod, T000A2_A11MegCodigo
            }
            , new Object[] {
            T000A3_A26ConCodigo, T000A3_A2077ConMegSec, T000A3_A1532MegPreaTipo, T000A3_A1530ConMegMeses, T000A3_A1534ConMegDura, T000A3_A1529ConMegPropor, T000A3_A3CliCod, T000A3_A11MegCodigo
            }
            , new Object[] {
            T000A4_A3CliCod
            }
            , new Object[] {
            T000A5_A26ConCodigo, T000A5_A925ConTLiqSinCausa, T000A5_n925ConTLiqSinCausa, T000A5_A926ConTLiqSinPre, T000A5_n926ConTLiqSinPre, T000A5_A950ConTLTipEgr, T000A5_A1406ConTLOrdejec, T000A5_A1407ConTLConOrd, T000A5_A1409ConTLVigencia, T000A5_n1409ConTLVigencia,
            T000A5_A1410ConTLCondicion, T000A5_n1410ConTLCondicion, T000A5_A1470ConTLConHab, T000A5_A1788ConTLTipoCon, T000A5_n1788ConTLTipoCon, T000A5_A1789CONTLSegPla, T000A5_n1789CONTLSegPla, T000A5_A3CliCod, T000A5_A32TLiqCod
            }
            , new Object[] {
            T000A6_A26ConCodigo, T000A6_A925ConTLiqSinCausa, T000A6_n925ConTLiqSinCausa, T000A6_A926ConTLiqSinPre, T000A6_n926ConTLiqSinPre, T000A6_A950ConTLTipEgr, T000A6_A1406ConTLOrdejec, T000A6_A1407ConTLConOrd, T000A6_A1409ConTLVigencia, T000A6_n1409ConTLVigencia,
            T000A6_A1410ConTLCondicion, T000A6_n1410ConTLCondicion, T000A6_A1470ConTLConHab, T000A6_A1788ConTLTipoCon, T000A6_n1788ConTLTipoCon, T000A6_A1789CONTLSegPla, T000A6_n1789CONTLSegPla, T000A6_A3CliCod, T000A6_A32TLiqCod
            }
            , new Object[] {
            T000A7_A340TliqDesc
            }
            , new Object[] {
            T000A8_A42ConCodYDesc, T000A8_n42ConCodYDesc, T000A8_A26ConCodigo, T000A8_A145ConFchModFor, T000A8_n145ConFchModFor, T000A8_A156ConUsuModFor, T000A8_n156ConUsuModFor, T000A8_A143ConCanti, T000A8_A158ConValUni, T000A8_A152ConImporte,
            T000A8_A159ConVariable, T000A8_A1905ConRelSecCli, T000A8_A1974ConOldValues, T000A8_A41ConDescrip, T000A8_A150ConHabilitado, T000A8_A40ConOrden, T000A8_A162ConVigencia, T000A8_A1488ConLiqBasica, T000A8_A148ConFormula, T000A8_n148ConFormula,
            T000A8_A729ConFormulaPreResuelta, T000A8_A157ConValorGen, T000A8_n157ConValorGen, T000A8_A155ConTipoLiqGanancias, T000A8_n155ConTipoLiqGanancias, T000A8_A153ConObservacion, T000A8_A151ConHisFormula, T000A8_n151ConHisFormula, T000A8_A154ConTipo, T000A8_A469ConCodOld,
            T000A8_A487ConCuenDebe, T000A8_n487ConCuenDebe, T000A8_A488ConCuenHaber, T000A8_n488ConCuenHaber, T000A8_A503ConTipoLiqAux, T000A8_n503ConTipoLiqAux, T000A8_A969ConConveAux, T000A8_n969ConConveAux, T000A8_A970ConClasifAux, T000A8_n970ConClasifAux,
            T000A8_A510ConOrdEjec, T000A8_A569ConFormulaExpl, T000A8_A720ConFormulaObs2, T000A8_A734ConRetGanPropor, T000A8_A735ConAplicGan, T000A8_n735ConAplicGan, T000A8_A762ConRecalcular, T000A8_A894ConImportado, T000A8_A895ConTipoOrden, T000A8_A1017ConEdiEnRec,
            T000A8_A1018ConRangoCant, T000A8_A922ConUsado, T000A8_A951ConObliga, T000A8_n951ConObliga, T000A8_A952ConObligaSiSac, T000A8_n952ConObligaSiSac, T000A8_A954ConCondCodigo, T000A8_A1066ConPreReq, T000A8_n1066ConPreReq, T000A8_A1068ConMostrarPos,
            T000A8_A1077ConAdelDescu, T000A8_n1077ConAdelDescu, T000A8_A1194ConSegunPla, T000A8_A1471ConNumero, T000A8_A1472ConSIPAApo, T000A8_A1473ConSIPACont, T000A8_A1474ConINSSJyPApo, T000A8_A1475ConINSSJyPCont, T000A8_A1476ConObraSocApo, T000A8_A1477ConObraSocCont,
            T000A8_A1478ConFonSolRedApo, T000A8_A1479ConFonSolRedCont, T000A8_A1480ConRenateaApo, T000A8_A1481ConRenateaCont, T000A8_A1482ConAsigFamCont, T000A8_A1483ConFonNacEmpCont, T000A8_A1484ConLeyRieTrabCont, T000A8_A1485ConRegDifApo, T000A8_A1486ConRegEspApo, T000A8_A1539ConSacDeven,
            T000A8_A1620ConBaseLic, T000A8_A1797ConBaseLicProm, T000A8_A1621ConBaseFer, T000A8_A1798ConBaseFerProm, T000A8_A1622ConBaseHorExt, T000A8_A1799ConBaseHorExtProm, T000A8_A1800ConBasePres, T000A8_A1801ConBaseAnt, T000A8_A1827ConBaseOSDif, T000A8_A2191ConBaseAus,
            T000A8_A2192ConBaseAusProm, T000A8_A1648ConCodAfip, T000A8_A1769ConCntPa, T000A8_A1821ConErrorSiCero, T000A8_A1826ConPueNov, T000A8_A1886ConRelSec, T000A8_A2013ConRelRef, T000A8_A2185ConDescripSinAc, T000A8_A2187ConOblPalabra, T000A8_n2187ConOblPalabra,
            T000A8_A1822CliPadre, T000A8_n1822CliPadre, T000A8_A3CliCod, T000A8_A1112AplIIGG, T000A8_n1112AplIIGG, T000A8_A37TipoConCod, T000A8_A38SubTipoConCod1, T000A8_n38SubTipoConCod1, T000A8_A39SubTipoConCod2, T000A8_n39SubTipoConCod2,
            T000A8_A953ConCondicion, T000A8_n953ConCondicion, T000A8_A1644ConceptoPais, T000A8_n1644ConceptoPais, T000A8_A1645ConceptoConveCodigo, T000A8_n1645ConceptoConveCodigo, T000A8_A921ConPadre, T000A8_n921ConPadre
            }
            , new Object[] {
            T000A9_A42ConCodYDesc, T000A9_n42ConCodYDesc, T000A9_A26ConCodigo, T000A9_A145ConFchModFor, T000A9_n145ConFchModFor, T000A9_A156ConUsuModFor, T000A9_n156ConUsuModFor, T000A9_A143ConCanti, T000A9_A158ConValUni, T000A9_A152ConImporte,
            T000A9_A159ConVariable, T000A9_A1905ConRelSecCli, T000A9_A1974ConOldValues, T000A9_A41ConDescrip, T000A9_A150ConHabilitado, T000A9_A40ConOrden, T000A9_A162ConVigencia, T000A9_A1488ConLiqBasica, T000A9_A148ConFormula, T000A9_n148ConFormula,
            T000A9_A729ConFormulaPreResuelta, T000A9_A157ConValorGen, T000A9_n157ConValorGen, T000A9_A155ConTipoLiqGanancias, T000A9_n155ConTipoLiqGanancias, T000A9_A153ConObservacion, T000A9_A151ConHisFormula, T000A9_n151ConHisFormula, T000A9_A154ConTipo, T000A9_A469ConCodOld,
            T000A9_A487ConCuenDebe, T000A9_n487ConCuenDebe, T000A9_A488ConCuenHaber, T000A9_n488ConCuenHaber, T000A9_A503ConTipoLiqAux, T000A9_n503ConTipoLiqAux, T000A9_A969ConConveAux, T000A9_n969ConConveAux, T000A9_A970ConClasifAux, T000A9_n970ConClasifAux,
            T000A9_A510ConOrdEjec, T000A9_A569ConFormulaExpl, T000A9_A720ConFormulaObs2, T000A9_A734ConRetGanPropor, T000A9_A735ConAplicGan, T000A9_n735ConAplicGan, T000A9_A762ConRecalcular, T000A9_A894ConImportado, T000A9_A895ConTipoOrden, T000A9_A1017ConEdiEnRec,
            T000A9_A1018ConRangoCant, T000A9_A922ConUsado, T000A9_A951ConObliga, T000A9_n951ConObliga, T000A9_A952ConObligaSiSac, T000A9_n952ConObligaSiSac, T000A9_A954ConCondCodigo, T000A9_A1066ConPreReq, T000A9_n1066ConPreReq, T000A9_A1068ConMostrarPos,
            T000A9_A1077ConAdelDescu, T000A9_n1077ConAdelDescu, T000A9_A1194ConSegunPla, T000A9_A1471ConNumero, T000A9_A1472ConSIPAApo, T000A9_A1473ConSIPACont, T000A9_A1474ConINSSJyPApo, T000A9_A1475ConINSSJyPCont, T000A9_A1476ConObraSocApo, T000A9_A1477ConObraSocCont,
            T000A9_A1478ConFonSolRedApo, T000A9_A1479ConFonSolRedCont, T000A9_A1480ConRenateaApo, T000A9_A1481ConRenateaCont, T000A9_A1482ConAsigFamCont, T000A9_A1483ConFonNacEmpCont, T000A9_A1484ConLeyRieTrabCont, T000A9_A1485ConRegDifApo, T000A9_A1486ConRegEspApo, T000A9_A1539ConSacDeven,
            T000A9_A1620ConBaseLic, T000A9_A1797ConBaseLicProm, T000A9_A1621ConBaseFer, T000A9_A1798ConBaseFerProm, T000A9_A1622ConBaseHorExt, T000A9_A1799ConBaseHorExtProm, T000A9_A1800ConBasePres, T000A9_A1801ConBaseAnt, T000A9_A1827ConBaseOSDif, T000A9_A2191ConBaseAus,
            T000A9_A2192ConBaseAusProm, T000A9_A1648ConCodAfip, T000A9_A1769ConCntPa, T000A9_A1821ConErrorSiCero, T000A9_A1826ConPueNov, T000A9_A1886ConRelSec, T000A9_A2013ConRelRef, T000A9_A2185ConDescripSinAc, T000A9_A2187ConOblPalabra, T000A9_n2187ConOblPalabra,
            T000A9_A1822CliPadre, T000A9_n1822CliPadre, T000A9_A3CliCod, T000A9_A1112AplIIGG, T000A9_n1112AplIIGG, T000A9_A37TipoConCod, T000A9_A38SubTipoConCod1, T000A9_n38SubTipoConCod1, T000A9_A39SubTipoConCod2, T000A9_n39SubTipoConCod2,
            T000A9_A953ConCondicion, T000A9_n953ConCondicion, T000A9_A1644ConceptoPais, T000A9_n1644ConceptoPais, T000A9_A1645ConceptoConveCodigo, T000A9_n1645ConceptoConveCodigo, T000A9_A921ConPadre, T000A9_n921ConPadre
            }
            , new Object[] {
            T000A10_A3CliCod
            }
            , new Object[] {
            T000A11_A3CliCod
            }
            , new Object[] {
            T000A12_A37TipoConCod
            }
            , new Object[] {
            T000A13_A37TipoConCod
            }
            , new Object[] {
            T000A14_A37TipoConCod
            }
            , new Object[] {
            T000A15_A953ConCondicion
            }
            , new Object[] {
            T000A16_A1644ConceptoPais
            }
            , new Object[] {
            T000A17_A1822CliPadre
            }
            , new Object[] {
            T000A18_A42ConCodYDesc, T000A18_n42ConCodYDesc, T000A18_A26ConCodigo, T000A18_A145ConFchModFor, T000A18_n145ConFchModFor, T000A18_A156ConUsuModFor, T000A18_n156ConUsuModFor, T000A18_A143ConCanti, T000A18_A158ConValUni, T000A18_A152ConImporte,
            T000A18_A159ConVariable, T000A18_A1905ConRelSecCli, T000A18_A1974ConOldValues, T000A18_A41ConDescrip, T000A18_A150ConHabilitado, T000A18_A40ConOrden, T000A18_A162ConVigencia, T000A18_A1488ConLiqBasica, T000A18_A148ConFormula, T000A18_n148ConFormula,
            T000A18_A729ConFormulaPreResuelta, T000A18_A157ConValorGen, T000A18_n157ConValorGen, T000A18_A155ConTipoLiqGanancias, T000A18_n155ConTipoLiqGanancias, T000A18_A153ConObservacion, T000A18_A151ConHisFormula, T000A18_n151ConHisFormula, T000A18_A154ConTipo, T000A18_A469ConCodOld,
            T000A18_A487ConCuenDebe, T000A18_n487ConCuenDebe, T000A18_A488ConCuenHaber, T000A18_n488ConCuenHaber, T000A18_A503ConTipoLiqAux, T000A18_n503ConTipoLiqAux, T000A18_A969ConConveAux, T000A18_n969ConConveAux, T000A18_A970ConClasifAux, T000A18_n970ConClasifAux,
            T000A18_A510ConOrdEjec, T000A18_A569ConFormulaExpl, T000A18_A720ConFormulaObs2, T000A18_A734ConRetGanPropor, T000A18_A735ConAplicGan, T000A18_n735ConAplicGan, T000A18_A762ConRecalcular, T000A18_A894ConImportado, T000A18_A895ConTipoOrden, T000A18_A1017ConEdiEnRec,
            T000A18_A1018ConRangoCant, T000A18_A922ConUsado, T000A18_A951ConObliga, T000A18_n951ConObliga, T000A18_A952ConObligaSiSac, T000A18_n952ConObligaSiSac, T000A18_A954ConCondCodigo, T000A18_A1066ConPreReq, T000A18_n1066ConPreReq, T000A18_A1068ConMostrarPos,
            T000A18_A1077ConAdelDescu, T000A18_n1077ConAdelDescu, T000A18_A1194ConSegunPla, T000A18_A1471ConNumero, T000A18_A1472ConSIPAApo, T000A18_A1473ConSIPACont, T000A18_A1474ConINSSJyPApo, T000A18_A1475ConINSSJyPCont, T000A18_A1476ConObraSocApo, T000A18_A1477ConObraSocCont,
            T000A18_A1478ConFonSolRedApo, T000A18_A1479ConFonSolRedCont, T000A18_A1480ConRenateaApo, T000A18_A1481ConRenateaCont, T000A18_A1482ConAsigFamCont, T000A18_A1483ConFonNacEmpCont, T000A18_A1484ConLeyRieTrabCont, T000A18_A1485ConRegDifApo, T000A18_A1486ConRegEspApo, T000A18_A1539ConSacDeven,
            T000A18_A1620ConBaseLic, T000A18_A1797ConBaseLicProm, T000A18_A1621ConBaseFer, T000A18_A1798ConBaseFerProm, T000A18_A1622ConBaseHorExt, T000A18_A1799ConBaseHorExtProm, T000A18_A1800ConBasePres, T000A18_A1801ConBaseAnt, T000A18_A1827ConBaseOSDif, T000A18_A2191ConBaseAus,
            T000A18_A2192ConBaseAusProm, T000A18_A1648ConCodAfip, T000A18_A1769ConCntPa, T000A18_A1821ConErrorSiCero, T000A18_A1826ConPueNov, T000A18_A1886ConRelSec, T000A18_A2013ConRelRef, T000A18_A2185ConDescripSinAc, T000A18_A2187ConOblPalabra, T000A18_n2187ConOblPalabra,
            T000A18_A1822CliPadre, T000A18_n1822CliPadre, T000A18_A3CliCod, T000A18_A1112AplIIGG, T000A18_n1112AplIIGG, T000A18_A37TipoConCod, T000A18_A38SubTipoConCod1, T000A18_n38SubTipoConCod1, T000A18_A39SubTipoConCod2, T000A18_n39SubTipoConCod2,
            T000A18_A953ConCondicion, T000A18_n953ConCondicion, T000A18_A1644ConceptoPais, T000A18_n1644ConceptoPais, T000A18_A1645ConceptoConveCodigo, T000A18_n1645ConceptoConveCodigo, T000A18_A921ConPadre, T000A18_n921ConPadre
            }
            , new Object[] {
            T000A19_A3CliCod
            }
            , new Object[] {
            T000A20_A37TipoConCod
            }
            , new Object[] {
            T000A21_A37TipoConCod
            }
            , new Object[] {
            T000A22_A37TipoConCod
            }
            , new Object[] {
            T000A23_A3CliCod
            }
            , new Object[] {
            T000A24_A1822CliPadre
            }
            , new Object[] {
            T000A25_A953ConCondicion
            }
            , new Object[] {
            T000A26_A1644ConceptoPais
            }
            , new Object[] {
            T000A27_A3CliCod, T000A27_A26ConCodigo
            }
            , new Object[] {
            T000A28_A3CliCod, T000A28_A26ConCodigo
            }
            , new Object[] {
            T000A29_A3CliCod, T000A29_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000A33_A1822CliPadre, T000A33_A921ConPadre
            }
            , new Object[] {
            T000A34_A46PaiCod, T000A34_A1440PaiBaseClaseLeg, T000A34_A1441PaiBaseTipo, T000A34_A1442PaiBaseCod1, T000A34_A1443PaiBaseCod2, T000A34_A1445PaiBaseCliCod, T000A34_A1446PaiBaseConCodigo
            }
            , new Object[] {
            T000A35_A46PaiCod, T000A35_A1356PaiMenCliCod, T000A35_A1358PaiMesConCodigo
            }
            , new Object[] {
            T000A36_A46PaiCod, T000A36_A1354PaiJorCliCod, T000A36_A1355PaiJorConCodigo
            }
            , new Object[] {
            T000A37_A3CliCod, T000A37_A1EmpCod, T000A37_A6LegNumero, T000A37_A1135LegSuelSec, T000A37_A2349LegSuelConcepto
            }
            , new Object[] {
            T000A38_A3CliCod, T000A38_A26ConCodigo, T000A38_A2119ConOpeId, T000A38_A923ConOperFor
            }
            , new Object[] {
            T000A39_A3CliCod, T000A39_A1EmpCod, T000A39_A6LegNumero, T000A39_A1829PreliqTLiqCod, T000A39_A1830PreliqPeriodo, T000A39_A1831PreliqConcepto
            }
            , new Object[] {
            T000A40_A3CliCod, T000A40_A1564CliPaiConve, T000A40_A1565CliConvenio, T000A40_A1327ConveHsExSec
            }
            , new Object[] {
            T000A41_A3CliCod, T000A41_A1564CliPaiConve, T000A41_A1565CliConvenio, T000A41_A1381ConveMenCliCod, T000A41_A1375ConveMenConCodigo
            }
            , new Object[] {
            T000A42_A3CliCod, T000A42_A1EmpCod, T000A42_A31LiqNro, T000A42_A6LegNumero, T000A42_A1541LiqAjuNro, T000A42_A1543LiqAjuSec
            }
            , new Object[] {
            T000A43_A3CliCod, T000A43_A1EmpCod, T000A43_A1366EmpJorConCodigo
            }
            , new Object[] {
            T000A44_A3CliCod, T000A44_A1EmpCod, T000A44_A1368EmpMenConCodigo
            }
            , new Object[] {
            T000A45_A3CliCod, T000A45_A1EmpCod, T000A45_A6LegNumero, T000A45_A1172OblSecuencial, T000A45_A1170OblExcConCOdigo
            }
            , new Object[] {
            T000A46_A3CliCod, T000A46_A1EmpCod, T000A46_A6LegNumero, T000A46_A1172OblSecuencial
            }
            , new Object[] {
            T000A47_A3CliCod, T000A47_A1EmpCod, T000A47_A6LegNumero, T000A47_A1172OblSecuencial
            }
            , new Object[] {
            T000A48_A3CliCod, T000A48_A1EmpCod, T000A48_A1129LiqExAnio, T000A48_A31LiqNro, T000A48_A6LegNumero, T000A48_A1127LiqExenConCodigo, T000A48_A1128LiqExAplIIGG
            }
            , new Object[] {
            T000A49_A3CliCod, T000A49_A1112AplIIGG
            }
            , new Object[] {
            T000A50_A3CliCod, T000A50_A1112AplIIGG
            }
            , new Object[] {
            T000A51_A3CliCod, T000A51_A1112AplIIGG
            }
            , new Object[] {
            T000A52_A3CliCod, T000A52_A1105CondExenIIGG
            }
            , new Object[] {
            T000A53_A3CliCod, T000A53_A1101SiraTipo, T000A53_A1102SiraCodigo
            }
            , new Object[] {
            T000A54_A3CliCod, T000A54_A1EmpCod, T000A54_A869LiqLegConAnio, T000A54_A6LegNumero, T000A54_A26ConCodigo, T000A54_A1097LiqAltaNro, T000A54_A1098LiqNuevaNro
            }
            , new Object[] {
            T000A55_A3CliCod, T000A55_A1EmpCod, T000A55_A6LegNumero, T000A55_A83LegDedSec
            }
            , new Object[] {
            T000A56_A3CliCod, T000A56_A26ConCodigo, T000A56_A51ForHisNum
            }
            , new Object[] {
            T000A57_A3CliCod, T000A57_A1EmpCod, T000A57_A6LegNumero, T000A57_A25AgeOrden
            }
            , new Object[] {
            T000A58_A3CliCod, T000A58_A26ConCodigo
            }
            , new Object[] {
            T000A59_A26ConCodigo, T000A59_A340TliqDesc, T000A59_A925ConTLiqSinCausa, T000A59_n925ConTLiqSinCausa, T000A59_A926ConTLiqSinPre, T000A59_n926ConTLiqSinPre, T000A59_A950ConTLTipEgr, T000A59_A1406ConTLOrdejec, T000A59_A1407ConTLConOrd, T000A59_A1409ConTLVigencia,
            T000A59_n1409ConTLVigencia, T000A59_A1410ConTLCondicion, T000A59_n1410ConTLCondicion, T000A59_A1470ConTLConHab, T000A59_A1788ConTLTipoCon, T000A59_n1788ConTLTipoCon, T000A59_A1789CONTLSegPla, T000A59_n1789CONTLSegPla, T000A59_A3CliCod, T000A59_A32TLiqCod
            }
            , new Object[] {
            T000A60_A340TliqDesc
            }
            , new Object[] {
            T000A61_A3CliCod, T000A61_A26ConCodigo, T000A61_A32TLiqCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000A65_A340TliqDesc
            }
            , new Object[] {
            T000A66_A3CliCod, T000A66_A26ConCodigo, T000A66_A32TLiqCod
            }
            , new Object[] {
            T000A67_A26ConCodigo, T000A67_A2077ConMegSec, T000A67_A1532MegPreaTipo, T000A67_A1530ConMegMeses, T000A67_A1534ConMegDura, T000A67_A1529ConMegPropor, T000A67_A3CliCod, T000A67_A11MegCodigo
            }
            , new Object[] {
            T000A68_A3CliCod
            }
            , new Object[] {
            T000A69_A3CliCod
            }
            , new Object[] {
            T000A70_A3CliCod, T000A70_A26ConCodigo, T000A70_A11MegCodigo, T000A70_A2077ConMegSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000A74_A3CliCod, T000A74_A26ConCodigo, T000A74_A11MegCodigo, T000A74_A2077ConMegSec
            }
            , new Object[] {
            T000A75_A37TipoConCod, T000A75_A370TipoConDescrip
            }
            , new Object[] {
            T000A76_A37TipoConCod, T000A76_A38SubTipoConCod1, T000A76_A371SubTipoConDes1
            }
            , new Object[] {
            T000A77_A37TipoConCod, T000A77_A38SubTipoConCod1, T000A77_A39SubTipoConCod2, T000A77_A372SubTipoConDes2
            }
            , new Object[] {
            T000A78_A3CliCod, T000A78_A78CuenCodigo, T000A78_A485CuenDescrip, T000A78_A1EmpCod, T000A78_A486CuenTipo
            }
            , new Object[] {
            T000A79_A3CliCod, T000A79_A78CuenCodigo, T000A79_A485CuenDescrip, T000A79_A1EmpCod, T000A79_A486CuenTipo
            }
            , new Object[] {
            T000A80_A3CliCod, T000A80_A32TLiqCod, T000A80_A340TliqDesc, T000A80_A341TLiqHabilitada
            }
            , new Object[] {
            T000A81_A37TipoConCod, T000A81_A370TipoConDescrip
            }
            , new Object[] {
            T000A82_A37TipoConCod
            }
            , new Object[] {
            T000A83_A37TipoConCod
            }
            , new Object[] {
            T000A84_A37TipoConCod
            }
            , new Object[] {
            T000A85_A3CliCod
            }
            , new Object[] {
            T000A86_A3CliCod
            }
         }
      );
      AV37Pgmname = "Concepto" ;
      Z155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      N155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      A155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      i155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      Z150ConHabilitado = true ;
      A150ConHabilitado = true ;
      i150ConHabilitado = true ;
   }

   private byte Z162ConVigencia ;
   private byte Z1488ConLiqBasica ;
   private byte Z154ConTipo ;
   private byte Z735ConAplicGan ;
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
   private byte Z2191ConBaseAus ;
   private byte Z2192ConBaseAusProm ;
   private byte Z1769ConCntPa ;
   private byte O2192ConBaseAusProm ;
   private byte O2191ConBaseAus ;
   private byte O1827ConBaseOSDif ;
   private byte O1801ConBaseAnt ;
   private byte O1800ConBasePres ;
   private byte O1799ConBaseHorExtProm ;
   private byte O1622ConBaseHorExt ;
   private byte O1798ConBaseFerProm ;
   private byte O1621ConBaseFer ;
   private byte O1797ConBaseLicProm ;
   private byte O1620ConBaseLic ;
   private byte N162ConVigencia ;
   private byte N735ConAplicGan ;
   private byte Z1409ConTLVigencia ;
   private byte Z1470ConTLConHab ;
   private byte Z1789CONTLSegPla ;
   private byte Z1530ConMegMeses ;
   private byte GxWebError ;
   private byte A1797ConBaseLicProm ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1827ConBaseOSDif ;
   private byte A2191ConBaseAus ;
   private byte A2192ConBaseAusProm ;
   private byte A1620ConBaseLic ;
   private byte nKeyPressed ;
   private byte A735ConAplicGan ;
   private byte A162ConVigencia ;
   private byte A1077ConAdelDescu ;
   private byte B2192ConBaseAusProm ;
   private byte B2191ConBaseAus ;
   private byte B1827ConBaseOSDif ;
   private byte B1801ConBaseAnt ;
   private byte B1800ConBasePres ;
   private byte B1799ConBaseHorExtProm ;
   private byte B1622ConBaseHorExt ;
   private byte B1798ConBaseFerProm ;
   private byte B1621ConBaseFer ;
   private byte B1797ConBaseLicProm ;
   private byte B1620ConBaseLic ;
   private byte A1488ConLiqBasica ;
   private byte A154ConTipo ;
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
   private byte A1539ConSacDeven ;
   private byte A1769ConCntPa ;
   private byte Gx_BScreen ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte A1789CONTLSegPla ;
   private byte A1530ConMegMeses ;
   private byte subGridlevel_tipoliquidacion_Backcolorstyle ;
   private byte subGridlevel_tipoliquidacion_Backstyle ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_tipoliquidacion_Allowselection ;
   private byte subGridlevel_tipoliquidacion_Allowhovering ;
   private byte subGridlevel_tipoliquidacion_Allowcollapsing ;
   private byte subGridlevel_tipoliquidacion_Collapsed ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short Z895ConTipoOrden ;
   private short Z1112AplIIGG ;
   private short Z1644ConceptoPais ;
   private short O1112AplIIGG ;
   private short N1112AplIIGG ;
   private short N1644ConceptoPais ;
   private short Z1407ConTLConOrd ;
   private short nRcdDeleted_8 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short Z2077ConMegSec ;
   private short nRcdDeleted_261 ;
   private short nRcdExists_261 ;
   private short nIsMod_261 ;
   private short AV13EmpCod ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount8 ;
   private short RcdFound8 ;
   private short B1112AplIIGG ;
   private short nBlankRcdUsr8 ;
   private short nBlankRcdCount261 ;
   private short RcdFound261 ;
   private short nBlankRcdUsr261 ;
   private short A895ConTipoOrden ;
   private short AV30Insert_AplIIGG ;
   private short AV32Insert_ConceptoPais ;
   private short A1407ConTLConOrd ;
   private short RcdFound7 ;
   private short A2077ConMegSec ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short nIsDirty_7 ;
   private short nIsDirty_8 ;
   private short nIsDirty_261 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1905ConRelSecCli ;
   private int Z40ConOrden ;
   private int Z1886ConRelSec ;
   private int Z1822CliPadre ;
   private int nRC_GXsfl_128 ;
   private int nGXsfl_128_idx=1 ;
   private int nRC_GXsfl_134 ;
   private int nGXsfl_134_idx=1 ;
   private int N1822CliPadre ;
   private int N40ConOrden ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A1822CliPadre ;
   private int trnEnded ;
   private int edtConFormula_Visible ;
   private int edtConFormula_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtConDescrip_Enabled ;
   private int edtConObservacion_Enabled ;
   private int edtConRangoCant_Enabled ;
   private int fRowAdded ;
   private int edtMegCodigo_Enabled ;
   private int edtConMegMeses_Enabled ;
   private int edtConMegSec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtConRetGanPropor_Visible ;
   private int edtConRetGanPropor_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1905ConRelSecCli ;
   private int A40ConOrden ;
   private int A1886ConRelSec ;
   private int AV35Insert_CliPadre ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_cuentas_Gxcontroltype ;
   private int Combo_megcodigo_Datalistupdateminimumcharacters ;
   private int Combo_megcodigo_Gxcontroltype ;
   private int AV38GXV1 ;
   private int GX_JID ;
   private int subGridlevel_tipoliquidacion_Backcolor ;
   private int subGridlevel_tipoliquidacion_Allbackcolor ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtConMegSec_Enabled ;
   private int defedtMegCodigo_Enabled ;
   private int defdynTLiqCod_Enabled ;
   private int i1905ConRelSecCli ;
   private int idxLst ;
   private int subGridlevel_tipoliquidacion_Selectedindex ;
   private int subGridlevel_tipoliquidacion_Selectioncolor ;
   private int subGridlevel_tipoliquidacion_Hoveringcolor ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private long Z510ConOrdEjec ;
   private long Z1406ConTLOrdejec ;
   private long A510ConOrdEjec ;
   private long A1406ConTLOrdejec ;
   private long GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private java.math.BigDecimal Z157ConValorGen ;
   private java.math.BigDecimal N157ConValorGen ;
   private java.math.BigDecimal Z1529ConMegPropor ;
   private java.math.BigDecimal A157ConValorGen ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV11ConCodigo ;
   private String Z26ConCodigo ;
   private String Z156ConUsuModFor ;
   private String Z155ConTipoLiqGanancias ;
   private String Z469ConCodOld ;
   private String Z487ConCuenDebe ;
   private String Z488ConCuenHaber ;
   private String Z954ConCondCodigo ;
   private String Z1066ConPreReq ;
   private String Z1648ConCodAfip ;
   private String Z2187ConOblPalabra ;
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
   private String N155ConTipoLiqGanancias ;
   private String Z32TLiqCod ;
   private String Z950ConTLTipEgr ;
   private String Z1410ConTLCondicion ;
   private String Z1788ConTLTipoCon ;
   private String N32TLiqCod ;
   private String Z11MegCodigo ;
   private String Z1532MegPreaTipo ;
   private String Z1534ConMegDura ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String Gx_mode ;
   private String A39SubTipoConCod2 ;
   private String A921ConPadre ;
   private String A953ConCondicion ;
   private String A1645ConceptoConveCodigo ;
   private String A32TLiqCod ;
   private String A11MegCodigo ;
   private String AV11ConCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String sGXsfl_128_idx="0001" ;
   private String sGXsfl_134_idx="0001" ;
   private String A1066ConPreReq ;
   private String A487ConCuenDebe ;
   private String A488ConCuenHaber ;
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
   private String divConformula_cell_Internalname ;
   private String divConformula_cell_Class ;
   private String edtConFormula_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String divConvariable_cell_Internalname ;
   private String divConvariable_cell_Class ;
   private String divConaplicgan_cell_Internalname ;
   private String divConaplicgan_cell_Class ;
   private String edtConCodigo_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Invitemessage ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Internalname ;
   private String divConcanti_cell_Internalname ;
   private String divConcanti_cell_Class ;
   private String divConvaluni_cell_Internalname ;
   private String divConvaluni_cell_Class ;
   private String divConimporte_cell_Internalname ;
   private String divConimporte_cell_Class ;
   private String edtConObservacion_Internalname ;
   private String edtConRangoCant_Internalname ;
   private String Dvpanel_cuentas_Width ;
   private String Dvpanel_cuentas_Cls ;
   private String Dvpanel_cuentas_Title ;
   private String Dvpanel_cuentas_Iconposition ;
   private String Dvpanel_cuentas_Internalname ;
   private String divCuentas_Internalname ;
   private String divTableleaflevel_tipoliquidacion_Internalname ;
   private String sMode8 ;
   private String subGridlevel_tipoliquidacion_Internalname ;
   private String sMode261 ;
   private String edtMegCodigo_Internalname ;
   private String edtConMegMeses_Internalname ;
   private String edtConMegSec_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_megcodigo_Caption ;
   private String Combo_megcodigo_Cls ;
   private String Combo_megcodigo_Datalistproc ;
   private String Combo_megcodigo_Internalname ;
   private String edtConRetGanPropor_Internalname ;
   private String edtConRetGanPropor_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A156ConUsuModFor ;
   private String A155ConTipoLiqGanancias ;
   private String A2187ConOblPalabra ;
   private String A469ConCodOld ;
   private String A954ConCondCodigo ;
   private String A1648ConCodAfip ;
   private String AV27defaultConCodigo ;
   private String A149ConFormulaAbr ;
   private String AV23Insert_TipoConCod ;
   private String AV24Insert_SubTipoConCod1 ;
   private String AV25Insert_SubTipoConCod2 ;
   private String AV34Insert_ConCondicion ;
   private String AV33Insert_ConceptoConveCodigo ;
   private String AV29Insert_ConPadre ;
   private String AV37Pgmname ;
   private String A950ConTLTipEgr ;
   private String A1410ConTLCondicion ;
   private String A1788ConTLTipoCon ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_cuentas_Objectcall ;
   private String Dvpanel_cuentas_Class ;
   private String Dvpanel_cuentas_Height ;
   private String Combo_megcodigo_Objectcall ;
   private String Combo_megcodigo_Class ;
   private String Combo_megcodigo_Icontype ;
   private String Combo_megcodigo_Icon ;
   private String Combo_megcodigo_Tooltip ;
   private String Combo_megcodigo_Selectedvalue_set ;
   private String Combo_megcodigo_Selectedvalue_get ;
   private String Combo_megcodigo_Selectedtext_set ;
   private String Combo_megcodigo_Selectedtext_get ;
   private String Combo_megcodigo_Gamoauthtoken ;
   private String Combo_megcodigo_Ddointernalname ;
   private String Combo_megcodigo_Titlecontrolalign ;
   private String Combo_megcodigo_Dropdownoptionstype ;
   private String Combo_megcodigo_Titlecontrolidtoreplace ;
   private String Combo_megcodigo_Datalisttype ;
   private String Combo_megcodigo_Datalistfixedvalues ;
   private String Combo_megcodigo_Datalistprocparametersprefix ;
   private String Combo_megcodigo_Remoteservicesparameters ;
   private String Combo_megcodigo_Htmltemplate ;
   private String Combo_megcodigo_Multiplevaluestype ;
   private String Combo_megcodigo_Loadingdata ;
   private String Combo_megcodigo_Noresultsfound ;
   private String Combo_megcodigo_Emptyitemtext ;
   private String Combo_megcodigo_Onlyselectedvalues ;
   private String Combo_megcodigo_Selectalltext ;
   private String Combo_megcodigo_Multiplevaluesseparator ;
   private String Combo_megcodigo_Addnewoptiontext ;
   private String hsh ;
   private String sMode7 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
   private String sGXsfl_128_fel_idx="0001" ;
   private String subGridlevel_tipoliquidacion_Class ;
   private String subGridlevel_tipoliquidacion_Linesclass ;
   private String sGXsfl_134_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtMegCodigo_Jsonclick ;
   private String edtConMegMeses_Jsonclick ;
   private String edtConMegSec_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i149ConFormulaAbr ;
   private String i155ConTipoLiqGanancias ;
   private String subGridlevel_tipoliquidacion_Header ;
   private String subGridlevel1_Header ;
   private String gxwrpcisep ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private java.util.Date Z145ConFchModFor ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date GXt_dtime12 ;
   private java.util.Date GXv_dtime13[] ;
   private boolean Z143ConCanti ;
   private boolean Z158ConValUni ;
   private boolean Z152ConImporte ;
   private boolean Z159ConVariable ;
   private boolean Z150ConHabilitado ;
   private boolean Z734ConRetGanPropor ;
   private boolean Z762ConRecalcular ;
   private boolean Z894ConImportado ;
   private boolean Z1017ConEdiEnRec ;
   private boolean Z922ConUsado ;
   private boolean Z951ConObliga ;
   private boolean Z952ConObligaSiSac ;
   private boolean Z1068ConMostrarPos ;
   private boolean Z1194ConSegunPla ;
   private boolean Z1821ConErrorSiCero ;
   private boolean Z1826ConPueNov ;
   private boolean O762ConRecalcular ;
   private boolean N762ConRecalcular ;
   private boolean N159ConVariable ;
   private boolean Z925ConTLiqSinCausa ;
   private boolean Z926ConTLiqSinPre ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n38SubTipoConCod1 ;
   private boolean n1112AplIIGG ;
   private boolean n39SubTipoConCod2 ;
   private boolean n1822CliPadre ;
   private boolean n921ConPadre ;
   private boolean n953ConCondicion ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean wbErr ;
   private boolean AV17permiteModificacion ;
   private boolean A159ConVariable ;
   private boolean n735ConAplicGan ;
   private boolean A150ConHabilitado ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean A762ConRecalcular ;
   private boolean n1066ConPreReq ;
   private boolean n1077ConAdelDescu ;
   private boolean n487ConCuenDebe ;
   private boolean n488ConCuenHaber ;
   private boolean AV14esSistemaConceptosDefault ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_cuentas_Autowidth ;
   private boolean Dvpanel_cuentas_Autoheight ;
   private boolean Dvpanel_cuentas_Collapsible ;
   private boolean Dvpanel_cuentas_Collapsed ;
   private boolean Dvpanel_cuentas_Showcollapseicon ;
   private boolean Dvpanel_cuentas_Autoscroll ;
   private boolean B762ConRecalcular ;
   private boolean bGXsfl_128_Refreshing=false ;
   private boolean bGXsfl_134_Refreshing=false ;
   private boolean Combo_megcodigo_Isgriditem ;
   private boolean Combo_megcodigo_Hasdescription ;
   private boolean Combo_megcodigo_Emptyitem ;
   private boolean A734ConRetGanPropor ;
   private boolean n145ConFchModFor ;
   private boolean n156ConUsuModFor ;
   private boolean n157ConValorGen ;
   private boolean n155ConTipoLiqGanancias ;
   private boolean n503ConTipoLiqAux ;
   private boolean n969ConConveAux ;
   private boolean n970ConClasifAux ;
   private boolean n951ConObliga ;
   private boolean A951ConObliga ;
   private boolean n952ConObligaSiSac ;
   private boolean A952ConObligaSiSac ;
   private boolean n2187ConOblPalabra ;
   private boolean n42ConCodYDesc ;
   private boolean A894ConImportado ;
   private boolean A1017ConEdiEnRec ;
   private boolean A922ConUsado ;
   private boolean A1068ConMostrarPos ;
   private boolean A1194ConSegunPla ;
   private boolean A1821ConErrorSiCero ;
   private boolean A1826ConPueNov ;
   private boolean n151ConHisFormula ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1789CONTLSegPla ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_cuentas_Enabled ;
   private boolean Dvpanel_cuentas_Showheader ;
   private boolean Dvpanel_cuentas_Visible ;
   private boolean Combo_megcodigo_Enabled ;
   private boolean Combo_megcodigo_Visible ;
   private boolean Combo_megcodigo_Allowmultipleselection ;
   private boolean Combo_megcodigo_Includeonlyselectedoption ;
   private boolean Combo_megcodigo_Includeselectalloption ;
   private boolean Combo_megcodigo_Includeaddnewoption ;
   private boolean n148ConFormula ;
   private boolean A925ConTLiqSinCausa ;
   private boolean A926ConTLiqSinPre ;
   private boolean returnInSub ;
   private boolean AV15IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean AV16mostrarEditable ;
   private boolean Gx_longc ;
   private boolean n925ConTLiqSinCausa ;
   private boolean n926ConTLiqSinPre ;
   private boolean i150ConHabilitado ;
   private boolean gxdyncontrolsrefreshing ;
   private String N153ConObservacion ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A1974ConOldValues ;
   private String A729ConFormulaPreResuelta ;
   private String A151ConHisFormula ;
   private String A569ConFormulaExpl ;
   private String A720ConFormulaObs2 ;
   private String Z1974ConOldValues ;
   private String Z148ConFormula ;
   private String Z729ConFormulaPreResuelta ;
   private String Z153ConObservacion ;
   private String Z151ConHisFormula ;
   private String Z569ConFormulaExpl ;
   private String Z720ConFormulaObs2 ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String Z503ConTipoLiqAux ;
   private String Z969ConConveAux ;
   private String Z970ConClasifAux ;
   private String Z1018ConRangoCant ;
   private String Z2013ConRelRef ;
   private String Z2185ConDescripSinAc ;
   private String O41ConDescrip ;
   private String N41ConDescrip ;
   private String A41ConDescrip ;
   private String A1018ConRangoCant ;
   private String B41ConDescrip ;
   private String A503ConTipoLiqAux ;
   private String A969ConConveAux ;
   private String A970ConClasifAux ;
   private String A42ConCodYDesc ;
   private String A2013ConRelRef ;
   private String A2185ConDescripSinAc ;
   private String A340TliqDesc ;
   private String Z340TliqDesc ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_tipoliquidacionContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel_tipoliquidacionRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_tipoliquidacionColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV21WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_cuentas ;
   private com.genexus.webpanels.GXUserControl ucCombo_megcodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynTipoConCod ;
   private ICheckbox chkConVariable ;
   private HTMLChoice cmbConAplicGan ;
   private HTMLChoice dynSubTipoConCod1 ;
   private HTMLChoice dynSubTipoConCod2 ;
   private ICheckbox chkConHabilitado ;
   private ICheckbox chkConCanti ;
   private ICheckbox chkConValUni ;
   private ICheckbox chkConImporte ;
   private HTMLChoice cmbConVigencia ;
   private ICheckbox chkConRecalcular ;
   private HTMLChoice cmbConPreReq ;
   private HTMLChoice cmbConAdelDescu ;
   private HTMLChoice dynConCuenDebe ;
   private HTMLChoice dynConCuenHaber ;
   private HTMLChoice dynTLiqCod ;
   private ICheckbox chkConTLiqSinCausa ;
   private ICheckbox chkConTLiqSinPre ;
   private HTMLChoice cmbMegPreaTipo ;
   private HTMLChoice cmbConMegDura ;
   private ICheckbox chkavEssistemaconceptosdefault ;
   private IDataStoreProvider pr_default ;
   private String[] T000A18_A42ConCodYDesc ;
   private boolean[] T000A18_n42ConCodYDesc ;
   private String[] T000A18_A26ConCodigo ;
   private java.util.Date[] T000A18_A145ConFchModFor ;
   private boolean[] T000A18_n145ConFchModFor ;
   private String[] T000A18_A156ConUsuModFor ;
   private boolean[] T000A18_n156ConUsuModFor ;
   private boolean[] T000A18_A143ConCanti ;
   private boolean[] T000A18_A158ConValUni ;
   private boolean[] T000A18_A152ConImporte ;
   private boolean[] T000A18_A159ConVariable ;
   private int[] T000A18_A1905ConRelSecCli ;
   private String[] T000A18_A1974ConOldValues ;
   private String[] T000A18_A41ConDescrip ;
   private boolean[] T000A18_A150ConHabilitado ;
   private int[] T000A18_A40ConOrden ;
   private byte[] T000A18_A162ConVigencia ;
   private byte[] T000A18_A1488ConLiqBasica ;
   private String[] T000A18_A148ConFormula ;
   private boolean[] T000A18_n148ConFormula ;
   private String[] T000A18_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] T000A18_A157ConValorGen ;
   private boolean[] T000A18_n157ConValorGen ;
   private String[] T000A18_A155ConTipoLiqGanancias ;
   private boolean[] T000A18_n155ConTipoLiqGanancias ;
   private String[] T000A18_A153ConObservacion ;
   private String[] T000A18_A151ConHisFormula ;
   private boolean[] T000A18_n151ConHisFormula ;
   private byte[] T000A18_A154ConTipo ;
   private String[] T000A18_A469ConCodOld ;
   private String[] T000A18_A487ConCuenDebe ;
   private boolean[] T000A18_n487ConCuenDebe ;
   private String[] T000A18_A488ConCuenHaber ;
   private boolean[] T000A18_n488ConCuenHaber ;
   private String[] T000A18_A503ConTipoLiqAux ;
   private boolean[] T000A18_n503ConTipoLiqAux ;
   private String[] T000A18_A969ConConveAux ;
   private boolean[] T000A18_n969ConConveAux ;
   private String[] T000A18_A970ConClasifAux ;
   private boolean[] T000A18_n970ConClasifAux ;
   private long[] T000A18_A510ConOrdEjec ;
   private String[] T000A18_A569ConFormulaExpl ;
   private String[] T000A18_A720ConFormulaObs2 ;
   private boolean[] T000A18_A734ConRetGanPropor ;
   private byte[] T000A18_A735ConAplicGan ;
   private boolean[] T000A18_n735ConAplicGan ;
   private boolean[] T000A18_A762ConRecalcular ;
   private boolean[] T000A18_A894ConImportado ;
   private short[] T000A18_A895ConTipoOrden ;
   private boolean[] T000A18_A1017ConEdiEnRec ;
   private String[] T000A18_A1018ConRangoCant ;
   private boolean[] T000A18_A922ConUsado ;
   private boolean[] T000A18_A951ConObliga ;
   private boolean[] T000A18_n951ConObliga ;
   private boolean[] T000A18_A952ConObligaSiSac ;
   private boolean[] T000A18_n952ConObligaSiSac ;
   private String[] T000A18_A954ConCondCodigo ;
   private String[] T000A18_A1066ConPreReq ;
   private boolean[] T000A18_n1066ConPreReq ;
   private boolean[] T000A18_A1068ConMostrarPos ;
   private byte[] T000A18_A1077ConAdelDescu ;
   private boolean[] T000A18_n1077ConAdelDescu ;
   private boolean[] T000A18_A1194ConSegunPla ;
   private byte[] T000A18_A1471ConNumero ;
   private byte[] T000A18_A1472ConSIPAApo ;
   private byte[] T000A18_A1473ConSIPACont ;
   private byte[] T000A18_A1474ConINSSJyPApo ;
   private byte[] T000A18_A1475ConINSSJyPCont ;
   private byte[] T000A18_A1476ConObraSocApo ;
   private byte[] T000A18_A1477ConObraSocCont ;
   private byte[] T000A18_A1478ConFonSolRedApo ;
   private byte[] T000A18_A1479ConFonSolRedCont ;
   private byte[] T000A18_A1480ConRenateaApo ;
   private byte[] T000A18_A1481ConRenateaCont ;
   private byte[] T000A18_A1482ConAsigFamCont ;
   private byte[] T000A18_A1483ConFonNacEmpCont ;
   private byte[] T000A18_A1484ConLeyRieTrabCont ;
   private byte[] T000A18_A1485ConRegDifApo ;
   private byte[] T000A18_A1486ConRegEspApo ;
   private byte[] T000A18_A1539ConSacDeven ;
   private byte[] T000A18_A1620ConBaseLic ;
   private byte[] T000A18_A1797ConBaseLicProm ;
   private byte[] T000A18_A1621ConBaseFer ;
   private byte[] T000A18_A1798ConBaseFerProm ;
   private byte[] T000A18_A1622ConBaseHorExt ;
   private byte[] T000A18_A1799ConBaseHorExtProm ;
   private byte[] T000A18_A1800ConBasePres ;
   private byte[] T000A18_A1801ConBaseAnt ;
   private byte[] T000A18_A1827ConBaseOSDif ;
   private byte[] T000A18_A2191ConBaseAus ;
   private byte[] T000A18_A2192ConBaseAusProm ;
   private String[] T000A18_A1648ConCodAfip ;
   private byte[] T000A18_A1769ConCntPa ;
   private boolean[] T000A18_A1821ConErrorSiCero ;
   private boolean[] T000A18_A1826ConPueNov ;
   private int[] T000A18_A1886ConRelSec ;
   private String[] T000A18_A2013ConRelRef ;
   private String[] T000A18_A2185ConDescripSinAc ;
   private String[] T000A18_A2187ConOblPalabra ;
   private boolean[] T000A18_n2187ConOblPalabra ;
   private int[] T000A18_A1822CliPadre ;
   private boolean[] T000A18_n1822CliPadre ;
   private int[] T000A18_A3CliCod ;
   private short[] T000A18_A1112AplIIGG ;
   private boolean[] T000A18_n1112AplIIGG ;
   private String[] T000A18_A37TipoConCod ;
   private String[] T000A18_A38SubTipoConCod1 ;
   private boolean[] T000A18_n38SubTipoConCod1 ;
   private String[] T000A18_A39SubTipoConCod2 ;
   private boolean[] T000A18_n39SubTipoConCod2 ;
   private String[] T000A18_A953ConCondicion ;
   private boolean[] T000A18_n953ConCondicion ;
   private short[] T000A18_A1644ConceptoPais ;
   private boolean[] T000A18_n1644ConceptoPais ;
   private String[] T000A18_A1645ConceptoConveCodigo ;
   private boolean[] T000A18_n1645ConceptoConveCodigo ;
   private String[] T000A18_A921ConPadre ;
   private boolean[] T000A18_n921ConPadre ;
   private int[] T000A10_A3CliCod ;
   private String[] T000A12_A37TipoConCod ;
   private String[] T000A13_A37TipoConCod ;
   private String[] T000A14_A37TipoConCod ;
   private int[] T000A11_A3CliCod ;
   private int[] T000A17_A1822CliPadre ;
   private boolean[] T000A17_n1822CliPadre ;
   private String[] T000A15_A953ConCondicion ;
   private boolean[] T000A15_n953ConCondicion ;
   private short[] T000A16_A1644ConceptoPais ;
   private boolean[] T000A16_n1644ConceptoPais ;
   private int[] T000A19_A3CliCod ;
   private String[] T000A20_A37TipoConCod ;
   private String[] T000A21_A37TipoConCod ;
   private String[] T000A22_A37TipoConCod ;
   private int[] T000A23_A3CliCod ;
   private int[] T000A24_A1822CliPadre ;
   private boolean[] T000A24_n1822CliPadre ;
   private String[] T000A25_A953ConCondicion ;
   private boolean[] T000A25_n953ConCondicion ;
   private short[] T000A26_A1644ConceptoPais ;
   private boolean[] T000A26_n1644ConceptoPais ;
   private int[] T000A27_A3CliCod ;
   private String[] T000A27_A26ConCodigo ;
   private String[] T000A9_A42ConCodYDesc ;
   private boolean[] T000A9_n42ConCodYDesc ;
   private String[] T000A9_A26ConCodigo ;
   private java.util.Date[] T000A9_A145ConFchModFor ;
   private boolean[] T000A9_n145ConFchModFor ;
   private String[] T000A9_A156ConUsuModFor ;
   private boolean[] T000A9_n156ConUsuModFor ;
   private boolean[] T000A9_A143ConCanti ;
   private boolean[] T000A9_A158ConValUni ;
   private boolean[] T000A9_A152ConImporte ;
   private boolean[] T000A9_A159ConVariable ;
   private int[] T000A9_A1905ConRelSecCli ;
   private String[] T000A9_A1974ConOldValues ;
   private String[] T000A9_A41ConDescrip ;
   private boolean[] T000A9_A150ConHabilitado ;
   private int[] T000A9_A40ConOrden ;
   private byte[] T000A9_A162ConVigencia ;
   private byte[] T000A9_A1488ConLiqBasica ;
   private String[] T000A9_A148ConFormula ;
   private boolean[] T000A9_n148ConFormula ;
   private String[] T000A9_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] T000A9_A157ConValorGen ;
   private boolean[] T000A9_n157ConValorGen ;
   private String[] T000A9_A155ConTipoLiqGanancias ;
   private boolean[] T000A9_n155ConTipoLiqGanancias ;
   private String[] T000A9_A153ConObservacion ;
   private String[] T000A9_A151ConHisFormula ;
   private boolean[] T000A9_n151ConHisFormula ;
   private byte[] T000A9_A154ConTipo ;
   private String[] T000A9_A469ConCodOld ;
   private String[] T000A9_A487ConCuenDebe ;
   private boolean[] T000A9_n487ConCuenDebe ;
   private String[] T000A9_A488ConCuenHaber ;
   private boolean[] T000A9_n488ConCuenHaber ;
   private String[] T000A9_A503ConTipoLiqAux ;
   private boolean[] T000A9_n503ConTipoLiqAux ;
   private String[] T000A9_A969ConConveAux ;
   private boolean[] T000A9_n969ConConveAux ;
   private String[] T000A9_A970ConClasifAux ;
   private boolean[] T000A9_n970ConClasifAux ;
   private long[] T000A9_A510ConOrdEjec ;
   private String[] T000A9_A569ConFormulaExpl ;
   private String[] T000A9_A720ConFormulaObs2 ;
   private boolean[] T000A9_A734ConRetGanPropor ;
   private byte[] T000A9_A735ConAplicGan ;
   private boolean[] T000A9_n735ConAplicGan ;
   private boolean[] T000A9_A762ConRecalcular ;
   private boolean[] T000A9_A894ConImportado ;
   private short[] T000A9_A895ConTipoOrden ;
   private boolean[] T000A9_A1017ConEdiEnRec ;
   private String[] T000A9_A1018ConRangoCant ;
   private boolean[] T000A9_A922ConUsado ;
   private boolean[] T000A9_A951ConObliga ;
   private boolean[] T000A9_n951ConObliga ;
   private boolean[] T000A9_A952ConObligaSiSac ;
   private boolean[] T000A9_n952ConObligaSiSac ;
   private String[] T000A9_A954ConCondCodigo ;
   private String[] T000A9_A1066ConPreReq ;
   private boolean[] T000A9_n1066ConPreReq ;
   private boolean[] T000A9_A1068ConMostrarPos ;
   private byte[] T000A9_A1077ConAdelDescu ;
   private boolean[] T000A9_n1077ConAdelDescu ;
   private boolean[] T000A9_A1194ConSegunPla ;
   private byte[] T000A9_A1471ConNumero ;
   private byte[] T000A9_A1472ConSIPAApo ;
   private byte[] T000A9_A1473ConSIPACont ;
   private byte[] T000A9_A1474ConINSSJyPApo ;
   private byte[] T000A9_A1475ConINSSJyPCont ;
   private byte[] T000A9_A1476ConObraSocApo ;
   private byte[] T000A9_A1477ConObraSocCont ;
   private byte[] T000A9_A1478ConFonSolRedApo ;
   private byte[] T000A9_A1479ConFonSolRedCont ;
   private byte[] T000A9_A1480ConRenateaApo ;
   private byte[] T000A9_A1481ConRenateaCont ;
   private byte[] T000A9_A1482ConAsigFamCont ;
   private byte[] T000A9_A1483ConFonNacEmpCont ;
   private byte[] T000A9_A1484ConLeyRieTrabCont ;
   private byte[] T000A9_A1485ConRegDifApo ;
   private byte[] T000A9_A1486ConRegEspApo ;
   private byte[] T000A9_A1539ConSacDeven ;
   private byte[] T000A9_A1620ConBaseLic ;
   private byte[] T000A9_A1797ConBaseLicProm ;
   private byte[] T000A9_A1621ConBaseFer ;
   private byte[] T000A9_A1798ConBaseFerProm ;
   private byte[] T000A9_A1622ConBaseHorExt ;
   private byte[] T000A9_A1799ConBaseHorExtProm ;
   private byte[] T000A9_A1800ConBasePres ;
   private byte[] T000A9_A1801ConBaseAnt ;
   private byte[] T000A9_A1827ConBaseOSDif ;
   private byte[] T000A9_A2191ConBaseAus ;
   private byte[] T000A9_A2192ConBaseAusProm ;
   private String[] T000A9_A1648ConCodAfip ;
   private byte[] T000A9_A1769ConCntPa ;
   private boolean[] T000A9_A1821ConErrorSiCero ;
   private boolean[] T000A9_A1826ConPueNov ;
   private int[] T000A9_A1886ConRelSec ;
   private String[] T000A9_A2013ConRelRef ;
   private String[] T000A9_A2185ConDescripSinAc ;
   private String[] T000A9_A2187ConOblPalabra ;
   private boolean[] T000A9_n2187ConOblPalabra ;
   private int[] T000A9_A1822CliPadre ;
   private boolean[] T000A9_n1822CliPadre ;
   private int[] T000A9_A3CliCod ;
   private short[] T000A9_A1112AplIIGG ;
   private boolean[] T000A9_n1112AplIIGG ;
   private String[] T000A9_A37TipoConCod ;
   private String[] T000A9_A38SubTipoConCod1 ;
   private boolean[] T000A9_n38SubTipoConCod1 ;
   private String[] T000A9_A39SubTipoConCod2 ;
   private boolean[] T000A9_n39SubTipoConCod2 ;
   private String[] T000A9_A953ConCondicion ;
   private boolean[] T000A9_n953ConCondicion ;
   private short[] T000A9_A1644ConceptoPais ;
   private boolean[] T000A9_n1644ConceptoPais ;
   private String[] T000A9_A1645ConceptoConveCodigo ;
   private boolean[] T000A9_n1645ConceptoConveCodigo ;
   private String[] T000A9_A921ConPadre ;
   private boolean[] T000A9_n921ConPadre ;
   private int[] T000A28_A3CliCod ;
   private String[] T000A28_A26ConCodigo ;
   private int[] T000A29_A3CliCod ;
   private String[] T000A29_A26ConCodigo ;
   private String[] T000A8_A42ConCodYDesc ;
   private boolean[] T000A8_n42ConCodYDesc ;
   private String[] T000A8_A26ConCodigo ;
   private java.util.Date[] T000A8_A145ConFchModFor ;
   private boolean[] T000A8_n145ConFchModFor ;
   private String[] T000A8_A156ConUsuModFor ;
   private boolean[] T000A8_n156ConUsuModFor ;
   private boolean[] T000A8_A143ConCanti ;
   private boolean[] T000A8_A158ConValUni ;
   private boolean[] T000A8_A152ConImporte ;
   private boolean[] T000A8_A159ConVariable ;
   private int[] T000A8_A1905ConRelSecCli ;
   private String[] T000A8_A1974ConOldValues ;
   private String[] T000A8_A41ConDescrip ;
   private boolean[] T000A8_A150ConHabilitado ;
   private int[] T000A8_A40ConOrden ;
   private byte[] T000A8_A162ConVigencia ;
   private byte[] T000A8_A1488ConLiqBasica ;
   private String[] T000A8_A148ConFormula ;
   private boolean[] T000A8_n148ConFormula ;
   private String[] T000A8_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] T000A8_A157ConValorGen ;
   private boolean[] T000A8_n157ConValorGen ;
   private String[] T000A8_A155ConTipoLiqGanancias ;
   private boolean[] T000A8_n155ConTipoLiqGanancias ;
   private String[] T000A8_A153ConObservacion ;
   private String[] T000A8_A151ConHisFormula ;
   private boolean[] T000A8_n151ConHisFormula ;
   private byte[] T000A8_A154ConTipo ;
   private String[] T000A8_A469ConCodOld ;
   private String[] T000A8_A487ConCuenDebe ;
   private boolean[] T000A8_n487ConCuenDebe ;
   private String[] T000A8_A488ConCuenHaber ;
   private boolean[] T000A8_n488ConCuenHaber ;
   private String[] T000A8_A503ConTipoLiqAux ;
   private boolean[] T000A8_n503ConTipoLiqAux ;
   private String[] T000A8_A969ConConveAux ;
   private boolean[] T000A8_n969ConConveAux ;
   private String[] T000A8_A970ConClasifAux ;
   private boolean[] T000A8_n970ConClasifAux ;
   private long[] T000A8_A510ConOrdEjec ;
   private String[] T000A8_A569ConFormulaExpl ;
   private String[] T000A8_A720ConFormulaObs2 ;
   private boolean[] T000A8_A734ConRetGanPropor ;
   private byte[] T000A8_A735ConAplicGan ;
   private boolean[] T000A8_n735ConAplicGan ;
   private boolean[] T000A8_A762ConRecalcular ;
   private boolean[] T000A8_A894ConImportado ;
   private short[] T000A8_A895ConTipoOrden ;
   private boolean[] T000A8_A1017ConEdiEnRec ;
   private String[] T000A8_A1018ConRangoCant ;
   private boolean[] T000A8_A922ConUsado ;
   private boolean[] T000A8_A951ConObliga ;
   private boolean[] T000A8_n951ConObliga ;
   private boolean[] T000A8_A952ConObligaSiSac ;
   private boolean[] T000A8_n952ConObligaSiSac ;
   private String[] T000A8_A954ConCondCodigo ;
   private String[] T000A8_A1066ConPreReq ;
   private boolean[] T000A8_n1066ConPreReq ;
   private boolean[] T000A8_A1068ConMostrarPos ;
   private byte[] T000A8_A1077ConAdelDescu ;
   private boolean[] T000A8_n1077ConAdelDescu ;
   private boolean[] T000A8_A1194ConSegunPla ;
   private byte[] T000A8_A1471ConNumero ;
   private byte[] T000A8_A1472ConSIPAApo ;
   private byte[] T000A8_A1473ConSIPACont ;
   private byte[] T000A8_A1474ConINSSJyPApo ;
   private byte[] T000A8_A1475ConINSSJyPCont ;
   private byte[] T000A8_A1476ConObraSocApo ;
   private byte[] T000A8_A1477ConObraSocCont ;
   private byte[] T000A8_A1478ConFonSolRedApo ;
   private byte[] T000A8_A1479ConFonSolRedCont ;
   private byte[] T000A8_A1480ConRenateaApo ;
   private byte[] T000A8_A1481ConRenateaCont ;
   private byte[] T000A8_A1482ConAsigFamCont ;
   private byte[] T000A8_A1483ConFonNacEmpCont ;
   private byte[] T000A8_A1484ConLeyRieTrabCont ;
   private byte[] T000A8_A1485ConRegDifApo ;
   private byte[] T000A8_A1486ConRegEspApo ;
   private byte[] T000A8_A1539ConSacDeven ;
   private byte[] T000A8_A1620ConBaseLic ;
   private byte[] T000A8_A1797ConBaseLicProm ;
   private byte[] T000A8_A1621ConBaseFer ;
   private byte[] T000A8_A1798ConBaseFerProm ;
   private byte[] T000A8_A1622ConBaseHorExt ;
   private byte[] T000A8_A1799ConBaseHorExtProm ;
   private byte[] T000A8_A1800ConBasePres ;
   private byte[] T000A8_A1801ConBaseAnt ;
   private byte[] T000A8_A1827ConBaseOSDif ;
   private byte[] T000A8_A2191ConBaseAus ;
   private byte[] T000A8_A2192ConBaseAusProm ;
   private String[] T000A8_A1648ConCodAfip ;
   private byte[] T000A8_A1769ConCntPa ;
   private boolean[] T000A8_A1821ConErrorSiCero ;
   private boolean[] T000A8_A1826ConPueNov ;
   private int[] T000A8_A1886ConRelSec ;
   private String[] T000A8_A2013ConRelRef ;
   private String[] T000A8_A2185ConDescripSinAc ;
   private String[] T000A8_A2187ConOblPalabra ;
   private boolean[] T000A8_n2187ConOblPalabra ;
   private int[] T000A8_A1822CliPadre ;
   private boolean[] T000A8_n1822CliPadre ;
   private int[] T000A8_A3CliCod ;
   private short[] T000A8_A1112AplIIGG ;
   private boolean[] T000A8_n1112AplIIGG ;
   private String[] T000A8_A37TipoConCod ;
   private String[] T000A8_A38SubTipoConCod1 ;
   private boolean[] T000A8_n38SubTipoConCod1 ;
   private String[] T000A8_A39SubTipoConCod2 ;
   private boolean[] T000A8_n39SubTipoConCod2 ;
   private String[] T000A8_A953ConCondicion ;
   private boolean[] T000A8_n953ConCondicion ;
   private short[] T000A8_A1644ConceptoPais ;
   private boolean[] T000A8_n1644ConceptoPais ;
   private String[] T000A8_A1645ConceptoConveCodigo ;
   private boolean[] T000A8_n1645ConceptoConveCodigo ;
   private String[] T000A8_A921ConPadre ;
   private boolean[] T000A8_n921ConPadre ;
   private int[] T000A33_A1822CliPadre ;
   private boolean[] T000A33_n1822CliPadre ;
   private String[] T000A33_A921ConPadre ;
   private boolean[] T000A33_n921ConPadre ;
   private short[] T000A34_A46PaiCod ;
   private byte[] T000A34_A1440PaiBaseClaseLeg ;
   private String[] T000A34_A1441PaiBaseTipo ;
   private String[] T000A34_A1442PaiBaseCod1 ;
   private String[] T000A34_A1443PaiBaseCod2 ;
   private int[] T000A34_A1445PaiBaseCliCod ;
   private String[] T000A34_A1446PaiBaseConCodigo ;
   private short[] T000A35_A46PaiCod ;
   private int[] T000A35_A1356PaiMenCliCod ;
   private String[] T000A35_A1358PaiMesConCodigo ;
   private short[] T000A36_A46PaiCod ;
   private int[] T000A36_A1354PaiJorCliCod ;
   private String[] T000A36_A1355PaiJorConCodigo ;
   private int[] T000A37_A3CliCod ;
   private short[] T000A37_A1EmpCod ;
   private int[] T000A37_A6LegNumero ;
   private short[] T000A37_A1135LegSuelSec ;
   private String[] T000A37_A2349LegSuelConcepto ;
   private int[] T000A38_A3CliCod ;
   private String[] T000A38_A26ConCodigo ;
   private String[] T000A38_A2119ConOpeId ;
   private String[] T000A38_A923ConOperFor ;
   private int[] T000A39_A3CliCod ;
   private short[] T000A39_A1EmpCod ;
   private int[] T000A39_A6LegNumero ;
   private String[] T000A39_A1829PreliqTLiqCod ;
   private java.util.Date[] T000A39_A1830PreliqPeriodo ;
   private String[] T000A39_A1831PreliqConcepto ;
   private int[] T000A40_A3CliCod ;
   private short[] T000A40_A1564CliPaiConve ;
   private String[] T000A40_A1565CliConvenio ;
   private short[] T000A40_A1327ConveHsExSec ;
   private int[] T000A41_A3CliCod ;
   private short[] T000A41_A1564CliPaiConve ;
   private String[] T000A41_A1565CliConvenio ;
   private int[] T000A41_A1381ConveMenCliCod ;
   private String[] T000A41_A1375ConveMenConCodigo ;
   private int[] T000A42_A3CliCod ;
   private short[] T000A42_A1EmpCod ;
   private int[] T000A42_A31LiqNro ;
   private int[] T000A42_A6LegNumero ;
   private short[] T000A42_A1541LiqAjuNro ;
   private short[] T000A42_A1543LiqAjuSec ;
   private int[] T000A43_A3CliCod ;
   private short[] T000A43_A1EmpCod ;
   private String[] T000A43_A1366EmpJorConCodigo ;
   private int[] T000A44_A3CliCod ;
   private short[] T000A44_A1EmpCod ;
   private String[] T000A44_A1368EmpMenConCodigo ;
   private int[] T000A45_A3CliCod ;
   private short[] T000A45_A1EmpCod ;
   private int[] T000A45_A6LegNumero ;
   private short[] T000A45_A1172OblSecuencial ;
   private String[] T000A45_A1170OblExcConCOdigo ;
   private int[] T000A46_A3CliCod ;
   private short[] T000A46_A1EmpCod ;
   private int[] T000A46_A6LegNumero ;
   private short[] T000A46_A1172OblSecuencial ;
   private int[] T000A47_A3CliCod ;
   private short[] T000A47_A1EmpCod ;
   private int[] T000A47_A6LegNumero ;
   private short[] T000A47_A1172OblSecuencial ;
   private int[] T000A48_A3CliCod ;
   private short[] T000A48_A1EmpCod ;
   private short[] T000A48_A1129LiqExAnio ;
   private int[] T000A48_A31LiqNro ;
   private int[] T000A48_A6LegNumero ;
   private String[] T000A48_A1127LiqExenConCodigo ;
   private short[] T000A48_A1128LiqExAplIIGG ;
   private int[] T000A49_A3CliCod ;
   private short[] T000A49_A1112AplIIGG ;
   private boolean[] T000A49_n1112AplIIGG ;
   private int[] T000A50_A3CliCod ;
   private short[] T000A50_A1112AplIIGG ;
   private boolean[] T000A50_n1112AplIIGG ;
   private int[] T000A51_A3CliCod ;
   private short[] T000A51_A1112AplIIGG ;
   private boolean[] T000A51_n1112AplIIGG ;
   private int[] T000A52_A3CliCod ;
   private String[] T000A52_A1105CondExenIIGG ;
   private int[] T000A53_A3CliCod ;
   private String[] T000A53_A1101SiraTipo ;
   private String[] T000A53_A1102SiraCodigo ;
   private int[] T000A54_A3CliCod ;
   private short[] T000A54_A1EmpCod ;
   private short[] T000A54_A869LiqLegConAnio ;
   private int[] T000A54_A6LegNumero ;
   private String[] T000A54_A26ConCodigo ;
   private int[] T000A54_A1097LiqAltaNro ;
   private int[] T000A54_A1098LiqNuevaNro ;
   private int[] T000A55_A3CliCod ;
   private short[] T000A55_A1EmpCod ;
   private int[] T000A55_A6LegNumero ;
   private int[] T000A55_A83LegDedSec ;
   private int[] T000A56_A3CliCod ;
   private String[] T000A56_A26ConCodigo ;
   private short[] T000A56_A51ForHisNum ;
   private int[] T000A57_A3CliCod ;
   private short[] T000A57_A1EmpCod ;
   private int[] T000A57_A6LegNumero ;
   private short[] T000A57_A25AgeOrden ;
   private int[] T000A58_A3CliCod ;
   private String[] T000A58_A26ConCodigo ;
   private String[] T000A7_A340TliqDesc ;
   private String[] T000A59_A26ConCodigo ;
   private String[] T000A59_A340TliqDesc ;
   private boolean[] T000A59_A925ConTLiqSinCausa ;
   private boolean[] T000A59_n925ConTLiqSinCausa ;
   private boolean[] T000A59_A926ConTLiqSinPre ;
   private boolean[] T000A59_n926ConTLiqSinPre ;
   private String[] T000A59_A950ConTLTipEgr ;
   private long[] T000A59_A1406ConTLOrdejec ;
   private short[] T000A59_A1407ConTLConOrd ;
   private byte[] T000A59_A1409ConTLVigencia ;
   private boolean[] T000A59_n1409ConTLVigencia ;
   private String[] T000A59_A1410ConTLCondicion ;
   private boolean[] T000A59_n1410ConTLCondicion ;
   private byte[] T000A59_A1470ConTLConHab ;
   private String[] T000A59_A1788ConTLTipoCon ;
   private boolean[] T000A59_n1788ConTLTipoCon ;
   private byte[] T000A59_A1789CONTLSegPla ;
   private boolean[] T000A59_n1789CONTLSegPla ;
   private int[] T000A59_A3CliCod ;
   private String[] T000A59_A32TLiqCod ;
   private String[] T000A60_A340TliqDesc ;
   private int[] T000A61_A3CliCod ;
   private String[] T000A61_A26ConCodigo ;
   private String[] T000A61_A32TLiqCod ;
   private String[] T000A6_A26ConCodigo ;
   private boolean[] T000A6_A925ConTLiqSinCausa ;
   private boolean[] T000A6_n925ConTLiqSinCausa ;
   private boolean[] T000A6_A926ConTLiqSinPre ;
   private boolean[] T000A6_n926ConTLiqSinPre ;
   private String[] T000A6_A950ConTLTipEgr ;
   private long[] T000A6_A1406ConTLOrdejec ;
   private short[] T000A6_A1407ConTLConOrd ;
   private byte[] T000A6_A1409ConTLVigencia ;
   private boolean[] T000A6_n1409ConTLVigencia ;
   private String[] T000A6_A1410ConTLCondicion ;
   private boolean[] T000A6_n1410ConTLCondicion ;
   private byte[] T000A6_A1470ConTLConHab ;
   private String[] T000A6_A1788ConTLTipoCon ;
   private boolean[] T000A6_n1788ConTLTipoCon ;
   private byte[] T000A6_A1789CONTLSegPla ;
   private boolean[] T000A6_n1789CONTLSegPla ;
   private int[] T000A6_A3CliCod ;
   private String[] T000A6_A32TLiqCod ;
   private String[] T000A5_A26ConCodigo ;
   private boolean[] T000A5_A925ConTLiqSinCausa ;
   private boolean[] T000A5_n925ConTLiqSinCausa ;
   private boolean[] T000A5_A926ConTLiqSinPre ;
   private boolean[] T000A5_n926ConTLiqSinPre ;
   private String[] T000A5_A950ConTLTipEgr ;
   private long[] T000A5_A1406ConTLOrdejec ;
   private short[] T000A5_A1407ConTLConOrd ;
   private byte[] T000A5_A1409ConTLVigencia ;
   private boolean[] T000A5_n1409ConTLVigencia ;
   private String[] T000A5_A1410ConTLCondicion ;
   private boolean[] T000A5_n1410ConTLCondicion ;
   private byte[] T000A5_A1470ConTLConHab ;
   private String[] T000A5_A1788ConTLTipoCon ;
   private boolean[] T000A5_n1788ConTLTipoCon ;
   private byte[] T000A5_A1789CONTLSegPla ;
   private boolean[] T000A5_n1789CONTLSegPla ;
   private int[] T000A5_A3CliCod ;
   private String[] T000A5_A32TLiqCod ;
   private String[] T000A65_A340TliqDesc ;
   private int[] T000A66_A3CliCod ;
   private String[] T000A66_A26ConCodigo ;
   private String[] T000A66_A32TLiqCod ;
   private String[] T000A67_A26ConCodigo ;
   private short[] T000A67_A2077ConMegSec ;
   private String[] T000A67_A1532MegPreaTipo ;
   private byte[] T000A67_A1530ConMegMeses ;
   private String[] T000A67_A1534ConMegDura ;
   private java.math.BigDecimal[] T000A67_A1529ConMegPropor ;
   private int[] T000A67_A3CliCod ;
   private String[] T000A67_A11MegCodigo ;
   private int[] T000A4_A3CliCod ;
   private int[] T000A68_A3CliCod ;
   private int[] T000A69_A3CliCod ;
   private int[] T000A70_A3CliCod ;
   private String[] T000A70_A26ConCodigo ;
   private String[] T000A70_A11MegCodigo ;
   private short[] T000A70_A2077ConMegSec ;
   private String[] T000A3_A26ConCodigo ;
   private short[] T000A3_A2077ConMegSec ;
   private String[] T000A3_A1532MegPreaTipo ;
   private byte[] T000A3_A1530ConMegMeses ;
   private String[] T000A3_A1534ConMegDura ;
   private java.math.BigDecimal[] T000A3_A1529ConMegPropor ;
   private int[] T000A3_A3CliCod ;
   private String[] T000A3_A11MegCodigo ;
   private String[] T000A2_A26ConCodigo ;
   private short[] T000A2_A2077ConMegSec ;
   private String[] T000A2_A1532MegPreaTipo ;
   private byte[] T000A2_A1530ConMegMeses ;
   private String[] T000A2_A1534ConMegDura ;
   private java.math.BigDecimal[] T000A2_A1529ConMegPropor ;
   private int[] T000A2_A3CliCod ;
   private String[] T000A2_A11MegCodigo ;
   private int[] T000A74_A3CliCod ;
   private String[] T000A74_A26ConCodigo ;
   private String[] T000A74_A11MegCodigo ;
   private short[] T000A74_A2077ConMegSec ;
   private String[] T000A75_A37TipoConCod ;
   private String[] T000A75_A370TipoConDescrip ;
   private String[] T000A76_A37TipoConCod ;
   private String[] T000A76_A38SubTipoConCod1 ;
   private boolean[] T000A76_n38SubTipoConCod1 ;
   private String[] T000A76_A371SubTipoConDes1 ;
   private String[] T000A77_A37TipoConCod ;
   private String[] T000A77_A38SubTipoConCod1 ;
   private boolean[] T000A77_n38SubTipoConCod1 ;
   private String[] T000A77_A39SubTipoConCod2 ;
   private boolean[] T000A77_n39SubTipoConCod2 ;
   private String[] T000A77_A372SubTipoConDes2 ;
   private int[] T000A78_A3CliCod ;
   private String[] T000A78_A78CuenCodigo ;
   private String[] T000A78_A485CuenDescrip ;
   private short[] T000A78_A1EmpCod ;
   private String[] T000A78_A486CuenTipo ;
   private int[] T000A79_A3CliCod ;
   private String[] T000A79_A78CuenCodigo ;
   private String[] T000A79_A485CuenDescrip ;
   private short[] T000A79_A1EmpCod ;
   private String[] T000A79_A486CuenTipo ;
   private int[] T000A80_A3CliCod ;
   private String[] T000A80_A32TLiqCod ;
   private String[] T000A80_A340TliqDesc ;
   private boolean[] T000A80_A341TLiqHabilitada ;
   private String[] T000A81_A37TipoConCod ;
   private String[] T000A81_A370TipoConDescrip ;
   private String[] T000A82_A37TipoConCod ;
   private String[] T000A83_A37TipoConCod ;
   private String[] T000A84_A37TipoConCod ;
   private int[] T000A85_A3CliCod ;
   private int[] T000A86_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV31MegCodigo_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV12DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV20TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV26TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV22WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class concepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000A2", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?  FOR UPDATE OF ConceptoMotivosEgreso NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A3", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A4", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A5", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?  FOR UPDATE OF ConceptoTipoLiquidacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A6", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A7", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A8", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ?  FOR UPDATE OF Concepto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A9", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A10", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A11", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A12", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A13", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A14", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A15", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A16", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A17", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A18", "SELECT TM1.ConCodYDesc, TM1.ConCodigo, TM1.ConFchModFor, TM1.ConUsuModFor, TM1.ConCanti, TM1.ConValUni, TM1.ConImporte, TM1.ConVariable, TM1.ConRelSecCli, TM1.ConOldValues, TM1.ConDescrip, TM1.ConHabilitado, TM1.ConOrden, TM1.ConVigencia, TM1.ConLiqBasica, TM1.ConFormula, TM1.ConFormulaPreResuelta, TM1.ConValorGen, TM1.ConTipoLiqGanancias, TM1.ConObservacion, TM1.ConHisFormula, TM1.ConTipo, TM1.ConCodOld, TM1.ConCuenDebe, TM1.ConCuenHaber, TM1.ConTipoLiqAux, TM1.ConConveAux, TM1.ConClasifAux, TM1.ConOrdEjec, TM1.ConFormulaExpl, TM1.ConFormulaObs2, TM1.ConRetGanPropor, TM1.ConAplicGan, TM1.ConRecalcular, TM1.ConImportado, TM1.ConTipoOrden, TM1.ConEdiEnRec, TM1.ConRangoCant, TM1.ConUsado, TM1.ConObliga, TM1.ConObligaSiSac, TM1.ConCondCodigo, TM1.ConPreReq, TM1.ConMostrarPos, TM1.ConAdelDescu, TM1.ConSegunPla, TM1.ConNumero, TM1.ConSIPAApo, TM1.ConSIPACont, TM1.ConINSSJyPApo, TM1.ConINSSJyPCont, TM1.ConObraSocApo, TM1.ConObraSocCont, TM1.ConFonSolRedApo, TM1.ConFonSolRedCont, TM1.ConRenateaApo, TM1.ConRenateaCont, TM1.ConAsigFamCont, TM1.ConFonNacEmpCont, TM1.ConLeyRieTrabCont, TM1.ConRegDifApo, TM1.ConRegEspApo, TM1.ConSacDeven, TM1.ConBaseLic, TM1.ConBaseLicProm, TM1.ConBaseFer, TM1.ConBaseFerProm, TM1.ConBaseHorExt, TM1.ConBaseHorExtProm, TM1.ConBasePres, TM1.ConBaseAnt, TM1.ConBaseOSDif, TM1.ConBaseAus, TM1.ConBaseAusProm, TM1.ConCodAfip, TM1.ConCntPa, TM1.ConErrorSiCero, TM1.ConPueNov, TM1.ConRelSec, TM1.ConRelRef, TM1.ConDescripSinAc, TM1.ConOblPalabra, TM1.CliPadre AS CliPadre, TM1.CliCod, TM1.AplIIGG, TM1.TipoConCod, TM1.SubTipoConCod1, TM1.SubTipoConCod2, TM1.ConCondicion, TM1.ConceptoPais AS ConceptoPais, TM1.ConceptoConveCodigo AS ConceptoConveCodigo, TM1.ConPadre AS ConPadre FROM Concepto TM1 WHERE TM1.CliCod = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A19", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A20", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A21", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A22", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A23", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A24", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A25", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A26", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A27", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A28", "SELECT CliCod, ConCodigo FROM Concepto WHERE ( CliCod > ? or CliCod = ? and ConCodigo > ( ?)) ORDER BY CliCod, ConCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A29", "SELECT CliCod, ConCodigo FROM Concepto WHERE ( CliCod < ? or CliCod = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, ConCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000A30", "SAVEPOINT gxupdate;INSERT INTO Concepto(ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre, ConForEditable) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A31", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCodYDesc=?, ConFchModFor=?, ConUsuModFor=?, ConCanti=?, ConValUni=?, ConImporte=?, ConVariable=?, ConRelSecCli=?, ConOldValues=?, ConDescrip=?, ConHabilitado=?, ConOrden=?, ConVigencia=?, ConLiqBasica=?, ConFormula=?, ConFormulaPreResuelta=?, ConValorGen=?, ConTipoLiqGanancias=?, ConObservacion=?, ConHisFormula=?, ConTipo=?, ConCodOld=?, ConCuenDebe=?, ConCuenHaber=?, ConTipoLiqAux=?, ConConveAux=?, ConClasifAux=?, ConOrdEjec=?, ConFormulaExpl=?, ConFormulaObs2=?, ConRetGanPropor=?, ConAplicGan=?, ConRecalcular=?, ConImportado=?, ConTipoOrden=?, ConEdiEnRec=?, ConRangoCant=?, ConUsado=?, ConObliga=?, ConObligaSiSac=?, ConCondCodigo=?, ConPreReq=?, ConMostrarPos=?, ConAdelDescu=?, ConSegunPla=?, ConNumero=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?, ConSacDeven=?, ConBaseLic=?, ConBaseLicProm=?, ConBaseFer=?, ConBaseFerProm=?, ConBaseHorExt=?, ConBaseHorExtProm=?, ConBasePres=?, ConBaseAnt=?, ConBaseOSDif=?, ConBaseAus=?, ConBaseAusProm=?, ConCodAfip=?, ConCntPa=?, ConErrorSiCero=?, ConPueNov=?, ConRelSec=?, ConRelRef=?, ConDescripSinAc=?, ConOblPalabra=?, CliPadre=?, AplIIGG=?, TipoConCod=?, SubTipoConCod1=?, SubTipoConCod2=?, ConCondicion=?, ConceptoPais=?, ConceptoConveCodigo=?, ConPadre=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A32", "SAVEPOINT gxupdate;DELETE FROM Concepto  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000A33", "SELECT CliCod AS CliPadre, ConCodigo AS ConPadre FROM Concepto WHERE CliPadre = ? AND ConPadre = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A34", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiBaseCliCod = ? AND PaiBaseConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A35", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiMenCliCod = ? AND PaiMesConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A36", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiJorCliCod = ? AND PaiJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A37", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto FROM Legajo_sueldosConceptos WHERE CliCod = ? AND LegSuelConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A38", "SELECT CliCod, ConCodigo, ConOpeId, ConOperFor FROM concepto_operandos WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A39", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo, PreliqConcepto FROM LegPreliqConceptosExclu WHERE CliCod = ? AND PreliqConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A40", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND ConveHSPDiaConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A41", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE ConveMenCliCod = ? AND ConveMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A42", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE CliCod = ? AND LiqAjuConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A43", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A44", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A45", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? AND OblExcConCOdigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A46", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A47", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A48", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND LiqExenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A49", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND ApliIIGGExenOtr = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A50", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGExenCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A51", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGTopeCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A52", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGGCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A53", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A54", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A55", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND LegDedConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A56", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A57", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A58", "SELECT CliCod, ConCodigo FROM Concepto ORDER BY CliCod, ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A59", "SELECT T1.ConCodigo, T2.TliqDesc, T1.ConTLiqSinCausa, T1.ConTLiqSinPre, T1.ConTLTipEgr, T1.ConTLOrdejec, T1.ConTLConOrd, T1.ConTLVigencia, T1.ConTLCondicion, T1.ConTLConHab, T1.ConTLTipoCon, T1.CONTLSegPla, T1.CliCod, T1.TLiqCod FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A60", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A61", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000A62", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A63", "SAVEPOINT gxupdate;UPDATE ConceptoTipoLiquidacion SET ConTLiqSinCausa=?, ConTLiqSinPre=?, ConTLTipEgr=?, ConTLOrdejec=?, ConTLConOrd=?, ConTLVigencia=?, ConTLCondicion=?, ConTLConHab=?, ConTLTipoCon=?, CONTLSegPla=?  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A64", "SAVEPOINT gxupdate;DELETE FROM ConceptoTipoLiquidacion  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000A65", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A66", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo, TLiqCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A67", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ? ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A68", "SELECT CliCod FROM ConceptoMotivosEgreso WHERE (CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND MegPreaTipo = ? AND ConMegMeses = ? AND ConMegDura = ?) AND (Not ( CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A69", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A70", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000A71", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A72", "SAVEPOINT gxupdate;UPDATE ConceptoMotivosEgreso SET MegPreaTipo=?, ConMegMeses=?, ConMegDura=?, ConMegPropor=?  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000A73", "SAVEPOINT gxupdate;DELETE FROM ConceptoMotivosEgreso  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000A74", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A75", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A76", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) ORDER BY SubTipoConDes1 ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A77", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE (TipoConCod = ( ?)) AND (SubTipoConCod1 = ( ?)) ORDER BY SubTipoConDes2 ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A78", "SELECT CliCod, CuenCodigo, CuenDescrip, EmpCod, CuenTipo FROM CuentaContable WHERE (CliCod = ?) AND (EmpCod = ?) AND (CuenTipo = ( 'D')) ORDER BY CuenDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A79", "SELECT CliCod, CuenCodigo, CuenDescrip, EmpCod, CuenTipo FROM CuentaContable WHERE (CliCod = ?) AND (EmpCod = ?) AND (CuenTipo = ( 'H')) ORDER BY CuenDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A80", "SELECT CliCod, TLiqCod, TliqDesc, TLiqHabilitada FROM TipoLiquidacion WHERE (CliCod = ?) AND (TLiqHabilitada = TRUE) ORDER BY TliqDesc ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A81", "SELECT TipoConCod, TipoConDescrip FROM TipoDeConcepto ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A82", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A83", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A84", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A85", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A86", "SELECT CliCod FROM ConceptoMotivosEgreso WHERE (CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND MegPreaTipo = ? AND ConMegMeses = ? AND ConMegDura = ?) AND (Not ( CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 32 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 57 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((String[]) buf[14])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((int[]) buf[18])[0] = rslt.getInt(13);
               ((String[]) buf[19])[0] = rslt.getString(14, 20);
               return;
            case 58 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 63 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 65 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 73 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 74 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 75 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               return;
            case 79 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 80 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 81 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 82 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 84 :
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 8 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 11 :
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
            case 12 :
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
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 14 :
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
            case 15 :
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
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 17 :
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
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 19 :
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
            case 20 :
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
            case 21 :
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
            case 22 :
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
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 24 :
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
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               stmt.setString(2, (String)parms[2], 10);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[4], false);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[6], 20);
               }
               stmt.setBoolean(5, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[10]).booleanValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setNLongVarchar(10, (String)parms[12], false);
               stmt.setVarchar(11, (String)parms[13], 400, false);
               stmt.setBoolean(12, ((Boolean) parms[14]).booleanValue());
               stmt.setInt(13, ((Number) parms[15]).intValue());
               stmt.setByte(14, ((Number) parms[16]).byteValue());
               stmt.setByte(15, ((Number) parms[17]).byteValue());
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(16, (String)parms[19]);
               }
               stmt.setNLongVarchar(17, (String)parms[20], false);
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[22], 4);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(19, (String)parms[24], 1);
               }
               stmt.setNLongVarchar(20, (String)parms[25], false);
               if ( ((Boolean) parms[26]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(21, (String)parms[27]);
               }
               stmt.setByte(22, ((Number) parms[28]).byteValue());
               stmt.setString(23, (String)parms[29], 10);
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(24, (String)parms[31], 20);
               }
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(25, (String)parms[33], 20);
               }
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[35], 40);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[37], 40);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(28, (String)parms[39], 80);
               }
               stmt.setLong(29, ((Number) parms[40]).longValue());
               stmt.setNLongVarchar(30, (String)parms[41], false);
               stmt.setNLongVarchar(31, (String)parms[42], false);
               stmt.setBoolean(32, ((Boolean) parms[43]).booleanValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(33, ((Number) parms[45]).byteValue());
               }
               stmt.setBoolean(34, ((Boolean) parms[46]).booleanValue());
               stmt.setBoolean(35, ((Boolean) parms[47]).booleanValue());
               stmt.setShort(36, ((Number) parms[48]).shortValue());
               stmt.setBoolean(37, ((Boolean) parms[49]).booleanValue());
               stmt.setVarchar(38, (String)parms[50], 400, false);
               stmt.setBoolean(39, ((Boolean) parms[51]).booleanValue());
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(40, ((Boolean) parms[53]).booleanValue());
               }
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 41 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(41, ((Boolean) parms[55]).booleanValue());
               }
               stmt.setString(42, (String)parms[56], 20);
               if ( ((Boolean) parms[57]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[58], 20);
               }
               stmt.setBoolean(44, ((Boolean) parms[59]).booleanValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 45 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(45, ((Number) parms[61]).byteValue());
               }
               stmt.setBoolean(46, ((Boolean) parms[62]).booleanValue());
               stmt.setByte(47, ((Number) parms[63]).byteValue());
               stmt.setByte(48, ((Number) parms[64]).byteValue());
               stmt.setByte(49, ((Number) parms[65]).byteValue());
               stmt.setByte(50, ((Number) parms[66]).byteValue());
               stmt.setByte(51, ((Number) parms[67]).byteValue());
               stmt.setByte(52, ((Number) parms[68]).byteValue());
               stmt.setByte(53, ((Number) parms[69]).byteValue());
               stmt.setByte(54, ((Number) parms[70]).byteValue());
               stmt.setByte(55, ((Number) parms[71]).byteValue());
               stmt.setByte(56, ((Number) parms[72]).byteValue());
               stmt.setByte(57, ((Number) parms[73]).byteValue());
               stmt.setByte(58, ((Number) parms[74]).byteValue());
               stmt.setByte(59, ((Number) parms[75]).byteValue());
               stmt.setByte(60, ((Number) parms[76]).byteValue());
               stmt.setByte(61, ((Number) parms[77]).byteValue());
               stmt.setByte(62, ((Number) parms[78]).byteValue());
               stmt.setByte(63, ((Number) parms[79]).byteValue());
               stmt.setByte(64, ((Number) parms[80]).byteValue());
               stmt.setByte(65, ((Number) parms[81]).byteValue());
               stmt.setByte(66, ((Number) parms[82]).byteValue());
               stmt.setByte(67, ((Number) parms[83]).byteValue());
               stmt.setByte(68, ((Number) parms[84]).byteValue());
               stmt.setByte(69, ((Number) parms[85]).byteValue());
               stmt.setByte(70, ((Number) parms[86]).byteValue());
               stmt.setByte(71, ((Number) parms[87]).byteValue());
               stmt.setByte(72, ((Number) parms[88]).byteValue());
               stmt.setByte(73, ((Number) parms[89]).byteValue());
               stmt.setByte(74, ((Number) parms[90]).byteValue());
               stmt.setString(75, (String)parms[91], 6);
               stmt.setByte(76, ((Number) parms[92]).byteValue());
               stmt.setBoolean(77, ((Boolean) parms[93]).booleanValue());
               stmt.setBoolean(78, ((Boolean) parms[94]).booleanValue());
               stmt.setInt(79, ((Number) parms[95]).intValue());
               stmt.setVarchar(80, (String)parms[96], 40, false);
               stmt.setVarchar(81, (String)parms[97], 400, false);
               if ( ((Boolean) parms[98]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(82, (String)parms[99], 20);
               }
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(83, ((Number) parms[101]).intValue());
               }
               stmt.setInt(84, ((Number) parms[102]).intValue());
               if ( ((Boolean) parms[103]).booleanValue() )
               {
                  stmt.setNull( 85 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(85, ((Number) parms[104]).shortValue());
               }
               stmt.setString(86, (String)parms[105], 20);
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 87 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(87, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 88 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(88, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 89 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(89, (String)parms[111], 20);
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 90 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(90, ((Number) parms[113]).shortValue());
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 91 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(91, (String)parms[115], 20);
               }
               if ( ((Boolean) parms[116]).booleanValue() )
               {
                  stmt.setNull( 92 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(92, (String)parms[117], 10);
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(2, (java.util.Date)parms[3], false);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[5], 20);
               }
               stmt.setBoolean(4, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(8, ((Number) parms[10]).intValue());
               stmt.setNLongVarchar(9, (String)parms[11], false);
               stmt.setVarchar(10, (String)parms[12], 400, false);
               stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               stmt.setInt(12, ((Number) parms[14]).intValue());
               stmt.setByte(13, ((Number) parms[15]).byteValue());
               stmt.setByte(14, ((Number) parms[16]).byteValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(15, (String)parms[18]);
               }
               stmt.setNLongVarchar(16, (String)parms[19], false);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(17, (java.math.BigDecimal)parms[21], 4);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[23], 1);
               }
               stmt.setNLongVarchar(19, (String)parms[24], false);
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(20, (String)parms[26]);
               }
               stmt.setByte(21, ((Number) parms[27]).byteValue());
               stmt.setString(22, (String)parms[28], 10);
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[30], 20);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(24, (String)parms[32], 20);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(25, (String)parms[34], 40);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[36], 40);
               }
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[38], 80);
               }
               stmt.setLong(28, ((Number) parms[39]).longValue());
               stmt.setNLongVarchar(29, (String)parms[40], false);
               stmt.setNLongVarchar(30, (String)parms[41], false);
               stmt.setBoolean(31, ((Boolean) parms[42]).booleanValue());
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(32, ((Number) parms[44]).byteValue());
               }
               stmt.setBoolean(33, ((Boolean) parms[45]).booleanValue());
               stmt.setBoolean(34, ((Boolean) parms[46]).booleanValue());
               stmt.setShort(35, ((Number) parms[47]).shortValue());
               stmt.setBoolean(36, ((Boolean) parms[48]).booleanValue());
               stmt.setVarchar(37, (String)parms[49], 400, false);
               stmt.setBoolean(38, ((Boolean) parms[50]).booleanValue());
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(39, ((Boolean) parms[52]).booleanValue());
               }
               if ( ((Boolean) parms[53]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(40, ((Boolean) parms[54]).booleanValue());
               }
               stmt.setString(41, (String)parms[55], 20);
               if ( ((Boolean) parms[56]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[57], 20);
               }
               stmt.setBoolean(43, ((Boolean) parms[58]).booleanValue());
               if ( ((Boolean) parms[59]).booleanValue() )
               {
                  stmt.setNull( 44 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(44, ((Number) parms[60]).byteValue());
               }
               stmt.setBoolean(45, ((Boolean) parms[61]).booleanValue());
               stmt.setByte(46, ((Number) parms[62]).byteValue());
               stmt.setByte(47, ((Number) parms[63]).byteValue());
               stmt.setByte(48, ((Number) parms[64]).byteValue());
               stmt.setByte(49, ((Number) parms[65]).byteValue());
               stmt.setByte(50, ((Number) parms[66]).byteValue());
               stmt.setByte(51, ((Number) parms[67]).byteValue());
               stmt.setByte(52, ((Number) parms[68]).byteValue());
               stmt.setByte(53, ((Number) parms[69]).byteValue());
               stmt.setByte(54, ((Number) parms[70]).byteValue());
               stmt.setByte(55, ((Number) parms[71]).byteValue());
               stmt.setByte(56, ((Number) parms[72]).byteValue());
               stmt.setByte(57, ((Number) parms[73]).byteValue());
               stmt.setByte(58, ((Number) parms[74]).byteValue());
               stmt.setByte(59, ((Number) parms[75]).byteValue());
               stmt.setByte(60, ((Number) parms[76]).byteValue());
               stmt.setByte(61, ((Number) parms[77]).byteValue());
               stmt.setByte(62, ((Number) parms[78]).byteValue());
               stmt.setByte(63, ((Number) parms[79]).byteValue());
               stmt.setByte(64, ((Number) parms[80]).byteValue());
               stmt.setByte(65, ((Number) parms[81]).byteValue());
               stmt.setByte(66, ((Number) parms[82]).byteValue());
               stmt.setByte(67, ((Number) parms[83]).byteValue());
               stmt.setByte(68, ((Number) parms[84]).byteValue());
               stmt.setByte(69, ((Number) parms[85]).byteValue());
               stmt.setByte(70, ((Number) parms[86]).byteValue());
               stmt.setByte(71, ((Number) parms[87]).byteValue());
               stmt.setByte(72, ((Number) parms[88]).byteValue());
               stmt.setByte(73, ((Number) parms[89]).byteValue());
               stmt.setString(74, (String)parms[90], 6);
               stmt.setByte(75, ((Number) parms[91]).byteValue());
               stmt.setBoolean(76, ((Boolean) parms[92]).booleanValue());
               stmt.setBoolean(77, ((Boolean) parms[93]).booleanValue());
               stmt.setInt(78, ((Number) parms[94]).intValue());
               stmt.setVarchar(79, (String)parms[95], 40, false);
               stmt.setVarchar(80, (String)parms[96], 400, false);
               if ( ((Boolean) parms[97]).booleanValue() )
               {
                  stmt.setNull( 81 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(81, (String)parms[98], 20);
               }
               if ( ((Boolean) parms[99]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(82, ((Number) parms[100]).intValue());
               }
               if ( ((Boolean) parms[101]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(83, ((Number) parms[102]).shortValue());
               }
               stmt.setString(84, (String)parms[103], 20);
               if ( ((Boolean) parms[104]).booleanValue() )
               {
                  stmt.setNull( 85 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(85, (String)parms[105], 20);
               }
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 86 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(86, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 87 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(87, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 88 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(88, ((Number) parms[111]).shortValue());
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 89 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(89, (String)parms[113], 20);
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 90 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(90, (String)parms[115], 10);
               }
               stmt.setInt(91, ((Number) parms[116]).intValue());
               stmt.setString(92, (String)parms[117], 10);
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
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setString(1, (String)parms[0], 10);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[2]).booleanValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(3, ((Boolean) parms[4]).booleanValue());
               }
               stmt.setString(4, (String)parms[5], 20);
               stmt.setLong(5, ((Number) parms[6]).longValue());
               stmt.setShort(6, ((Number) parms[7]).shortValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(7, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               stmt.setByte(9, ((Number) parms[12]).byteValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 20);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[16]).byteValue());
               }
               stmt.setInt(12, ((Number) parms[17]).intValue());
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 61 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(1, ((Boolean) parms[1]).booleanValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[3]).booleanValue());
               }
               stmt.setString(3, (String)parms[4], 20);
               stmt.setLong(4, ((Number) parms[5]).longValue());
               stmt.setShort(5, ((Number) parms[6]).shortValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[8]).byteValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               stmt.setByte(8, ((Number) parms[11]).byteValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[13], 20);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[15]).byteValue());
               }
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setString(12, (String)parms[17], 10);
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 69 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 70 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 74 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 75 :
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
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 80 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 81 :
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
            case 82 :
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
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
      }
   }

}

