package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajos_impl extends GXWebComponent
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
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            Gx_mode = httpContext.GetPar( "Mode") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
            setjustcreated();
            componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,Integer.valueOf(AV7CliCod),Short.valueOf(AV8EmpCod),Integer.valueOf(AV10LegNumero)});
            componentstart();
            httpContext.ajax_rspStartCmp(sPrefix);
            componentdraw();
            httpContext.ajax_rspEndCmp();
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"SECDESCRIPSINAC") == 0 )
         {
            A329SecDescrip = httpContext.GetPar( "SecDescrip") ;
            n329SecDescrip = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A329SecDescrip", A329SecDescrip);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gx6asasecdescripsinac5K23( A329SecDescrip) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel7"+"_"+"LPGDESCRISINAC") == 0 )
         {
            A291LpgDescri = httpContext.GetPar( "LpgDescri") ;
            n291LpgDescri = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A291LpgDescri", A291LpgDescri);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gx7asalpgdescrisinac5K23( A291LpgDescri) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"BANDESCRIPSINAC") == 0 )
         {
            A117BanDescrip = httpContext.GetPar( "BanDescrip") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117BanDescrip", A117BanDescrip);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gx8asabandescripsinac5K23( A117BanDescrip) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel9"+"_"+"SINDESCRIPSINAC") == 0 )
         {
            A331SinDescrip = httpContext.GetPar( "SinDescrip") ;
            n331SinDescrip = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A331SinDescrip", A331SinDescrip);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gx9asasindescripsinac5K23( A331SinDescrip) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel10"+"_"+"OSODESCRIPSINAC") == 0 )
         {
            A307OsoDescrip = httpContext.GetPar( "OsoDescrip") ;
            n307OsoDescrip = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A307OsoDescrip", A307OsoDescrip);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gx10asaosodescripsinac5K23( A307OsoDescrip) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_63") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1582LegBanCod = httpContext.GetPar( "LegBanCod") ;
            n1582LegBanCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1582LegBanCod", A1582LegBanCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_63( A3CliCod, A1582LegBanCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_64") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1581LegLpgCodigo = httpContext.GetPar( "LegLpgCodigo") ;
            n1581LegLpgCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1581LegLpgCodigo", A1581LegLpgCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_64( A3CliCod, A1581LegLpgCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_65") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1583LegMegCodigo = httpContext.GetPar( "LegMegCodigo") ;
            n1583LegMegCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1583LegMegCodigo", A1583LegMegCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_65( A3CliCod, A1583LegMegCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_66") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1580LegOsoCod = httpContext.GetPar( "LegOsoCod") ;
            n1580LegOsoCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1580LegOsoCod", A1580LegOsoCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_66( A3CliCod, A1580LegOsoCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_67") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1579LegSecCodigo = httpContext.GetPar( "LegSecCodigo") ;
            n1579LegSecCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1579LegSecCodigo", A1579LegSecCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_67( A3CliCod, A1579LegSecCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_70") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1579LegSecCodigo = httpContext.GetPar( "LegSecCodigo") ;
            n1579LegSecCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1579LegSecCodigo", A1579LegSecCodigo);
            A1578LegPuesCodigo = httpContext.GetPar( "LegPuesCodigo") ;
            n1578LegPuesCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1578LegPuesCodigo", A1578LegPuesCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_70( A3CliCod, A1579LegSecCodigo, A1578LegPuesCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_68") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_68( A3CliCod, A1EmpCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_84") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1965EmpOsoCod = httpContext.GetPar( "EmpOsoCod") ;
            n1965EmpOsoCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1965EmpOsoCod", A1965EmpOsoCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_84( A3CliCod, A1965EmpOsoCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_69") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1577LegSucCodigo = httpContext.GetPar( "LegSucCodigo") ;
            n1577LegSucCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1577LegSucCodigo", A1577LegSucCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_69( A3CliCod, A1EmpCod, A1577LegSucCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_71") == 0 )
         {
            A18MprCod = httpContext.GetPar( "MprCod") ;
            n18MprCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18MprCod", A18MprCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_71( A18MprCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_72") == 0 )
         {
            A20ZonCod = httpContext.GetPar( "ZonCod") ;
            n20ZonCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20ZonCod", A20ZonCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_72( A20ZonCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_73") == 0 )
         {
            A17CondiCodigo = (short)(GXutil.lval( httpContext.GetPar( "CondiCodigo"))) ;
            n17CondiCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17CondiCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17CondiCodigo), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_73( A17CondiCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_74") == 0 )
         {
            A19SinieCodigo = httpContext.GetPar( "SinieCodigo") ;
            n19SinieCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19SinieCodigo", A19SinieCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_74( A19SinieCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_75") == 0 )
         {
            A263LegSexo = (byte)(GXutil.lval( httpContext.GetPar( "LegSexo"))) ;
            n263LegSexo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_75( A263LegSexo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_76") == 0 )
         {
            A243LegEstadoCivil = (short)(GXutil.lval( httpContext.GetPar( "LegEstadoCivil"))) ;
            n243LegEstadoCivil = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_76( A243LegEstadoCivil) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_77") == 0 )
         {
            A22LegPaiCod = (short)(GXutil.lval( httpContext.GetPar( "LegPaiCod"))) ;
            n22LegPaiCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_77( A22LegPaiCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_78") == 0 )
         {
            A22LegPaiCod = (short)(GXutil.lval( httpContext.GetPar( "LegPaiCod"))) ;
            n22LegPaiCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
            A23LegProvCod = (short)(GXutil.lval( httpContext.GetPar( "LegProvCod"))) ;
            n23LegProvCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23LegProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23LegProvCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_78( A22LegPaiCod, A23LegProvCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_79") == 0 )
         {
            A22LegPaiCod = (short)(GXutil.lval( httpContext.GetPar( "LegPaiCod"))) ;
            n22LegPaiCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
            A23LegProvCod = (short)(GXutil.lval( httpContext.GetPar( "LegProvCod"))) ;
            n23LegProvCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23LegProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23LegProvCod), 4, 0));
            A24LegLocCod = (short)(GXutil.lval( httpContext.GetPar( "LegLocCod"))) ;
            n24LegLocCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A24LegLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24LegLocCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_79( A22LegPaiCod, A23LegProvCod, A24LegLocCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_81") == 0 )
         {
            A22LegPaiCod = (short)(GXutil.lval( httpContext.GetPar( "LegPaiCod"))) ;
            n22LegPaiCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
            A910LegSinCod = httpContext.GetPar( "LegSinCod") ;
            n910LegSinCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A910LegSinCod", A910LegSinCod);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_81( A22LegPaiCod, A910LegSinCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_80") == 0 )
         {
            A21LegNacionCod = (short)(GXutil.lval( httpContext.GetPar( "LegNacionCod"))) ;
            n21LegNacionCod = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21LegNacionCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21LegNacionCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_80( A21LegNacionCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_82") == 0 )
         {
            A15LegActCodigo = httpContext.GetPar( "LegActCodigo") ;
            n15LegActCodigo = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A15LegActCodigo", A15LegActCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_82( A15LegActCodigo) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_83") == 0 )
         {
            A1603LegSitRevEgreso = (short)(GXutil.lval( httpContext.GetPar( "LegSitRevEgreso"))) ;
            n1603LegSitRevEgreso = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1603LegSitRevEgreso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1603LegSitRevEgreso), 3, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_83( A1603LegSitRevEgreso) ;
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
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Legajos", ""), (short)(0)) ;
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
         if ( nDynComponent == 0 )
         {
            httpContext.sendError( 404 );
            GXutil.writeLog("send_http_error_code 404");
            GxWebError = (byte)(1) ;
         }
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public legajos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajos_impl.class ));
   }

   public legajos_impl( int remoteHandle ,
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
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         userMain( ) ;
         if ( ! isFullAjaxMode( ) && ( nDynComponent == 0 ) )
         {
            draw( ) ;
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

   public void fix_multi_value_controls( )
   {
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
         renderHtmlCloseForm5K23( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         renderHtmlHeaders( ) ;
      }
      renderHtmlOpenForm( ) ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.legajos");
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPanelNoBorderSplitScreenTabs", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cliente", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCod_Internalname, httpContext.getMessage( "Empresa", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,26);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,31);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegApellido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegApellido_Internalname, A230LegApellido, GXutil.rtrim( localUtil.format( A230LegApellido, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegApellido_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegApellido_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 7, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e115k23_client"+"'", TempTags, "", 2, "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Legajos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            standaloneStartupServer( ) ;
         }
      }
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e125K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      nDoneStart = (byte)(1) ;
      if ( AnyError == 0 )
      {
         sXEvt = httpContext.cgiGet( "_EventName") ;
         if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDETAILWCINFO"), AV31DetailWCInfo);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z237LegConvenio = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z237LegConvenio")) ;
            Z250LegIdNomApe = httpContext.cgiGet( sPrefix+"Z250LegIdNomApe") ;
            Z591LegNomApe = httpContext.cgiGet( sPrefix+"Z591LegNomApe") ;
            Z230LegApellido = httpContext.cgiGet( sPrefix+"Z230LegApellido") ;
            Z251LegNombre = httpContext.cgiGet( sPrefix+"Z251LegNombre") ;
            Z266LegTipDoc = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z266LegTipDoc"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z257LegNumDoc = httpContext.cgiGet( sPrefix+"Z257LegNumDoc") ;
            Z246LegFecNac = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z246LegFecNac"), 0) ;
            Z239LegCUIL = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z239LegCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z241LegDiscapacidad = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z241LegDiscapacidad"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z242LegDomici = httpContext.cgiGet( sPrefix+"Z242LegDomici") ;
            Z479LegEmail = httpContext.cgiGet( sPrefix+"Z479LegEmail") ;
            Z236LegCodPos = httpContext.cgiGet( sPrefix+"Z236LegCodPos") ;
            Z265LegTelefono = httpContext.cgiGet( sPrefix+"Z265LegTelefono") ;
            n265LegTelefono = ((GXutil.strcmp("", A265LegTelefono)==0) ? true : false) ;
            Z245LegFecIngreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z245LegFecIngreso"), 0) ;
            Z244LegFecEgreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z244LegFecEgreso"), 0) ;
            n244LegFecEgreso = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A244LegFecEgreso)) ? true : false) ;
            Z939LegCatCodigo = httpContext.cgiGet( sPrefix+"Z939LegCatCodigo") ;
            n939LegCatCodigo = ((GXutil.strcmp("", A939LegCatCodigo)==0) ? true : false) ;
            Z235LegClase = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z235LegClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z248LegFormaPago = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z248LegFormaPago"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z231LegBanSuc = httpContext.cgiGet( sPrefix+"Z231LegBanSuc") ;
            n231LegBanSuc = ((GXutil.strcmp("", A231LegBanSuc)==0) ? true : false) ;
            Z232LegBanTipCuen = httpContext.cgiGet( sPrefix+"Z232LegBanTipCuen") ;
            n232LegBanTipCuen = ((GXutil.strcmp("", A232LegBanTipCuen)==0) ? true : false) ;
            Z247LegFecUltMod = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z247LegFecUltMod"), 0) ;
            Z238LegCuentaBanc = httpContext.cgiGet( sPrefix+"Z238LegCuentaBanc") ;
            n238LegCuentaBanc = ((GXutil.strcmp("", A238LegCuentaBanc)==0) ? true : false) ;
            Z253LegLicInicio = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z253LegLicInicio"), 0) ;
            n253LegLicInicio = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A253LegLicInicio)) ? true : false) ;
            Z252LegLicFinal = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z252LegLicFinal"), 0) ;
            n252LegLicFinal = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A252LegLicFinal)) ? true : false) ;
            Z234LegCBU = httpContext.cgiGet( sPrefix+"Z234LegCBU") ;
            n234LegCBU = ((GXutil.strcmp("", A234LegCBU)==0) ? true : false) ;
            Z262LegSCVO = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z262LegSCVO")) ;
            Z228LegActivo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z228LegActivo")) ;
            Z264LegSueldoFuera = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z264LegSueldoFuera")) ;
            Z93LegId = httpContext.cgiGet( sPrefix+"Z93LegId") ;
            n93LegId = ((GXutil.strcmp("", A93LegId)==0) ? true : false) ;
            Z937LegConveCodigo = httpContext.cgiGet( sPrefix+"Z937LegConveCodigo") ;
            n937LegConveCodigo = ((GXutil.strcmp("", A937LegConveCodigo)==0) ? true : false) ;
            Z630LegFecImportacion = localUtil.ctot( httpContext.cgiGet( sPrefix+"Z630LegFecImportacion"), 0) ;
            Z877LegAgenReten = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z877LegAgenReten")) ;
            Z879LegContinua = httpContext.cgiGet( sPrefix+"Z879LegContinua") ;
            Z942LegRecalcLiq = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z942LegRecalcLiq")) ;
            Z1016LegJubilado = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1016LegJubilado")) ;
            Z1023LegHorasDia = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z1023LegHorasDia")) ;
            Z1268LegHorasSem = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z1268LegHorasSem")) ;
            Z1245LegTrabLun = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1245LegTrabLun")) ;
            Z1246LegTrabMar = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1246LegTrabMar")) ;
            Z1247LegTrabMie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1247LegTrabMie")) ;
            Z1248LegTrabJue = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1248LegTrabJue")) ;
            Z1249LegTrabVie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1249LegTrabVie")) ;
            Z1250LegTrabSa = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1250LegTrabSa")) ;
            Z1251LegTrabDo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1251LegTrabDo")) ;
            Z1523LegVacPend = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1523LegVacPend"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1531LegFecPreAviso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z1531LegFecPreAviso"), 0) ;
            Z1576LegConveVersionCli = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1576LegConveVersionCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1576LegConveVersionCli = ((0==A1576LegConveVersionCli) ? true : false) ;
            Z1759LegPromDias = httpContext.cgiGet( sPrefix+"Z1759LegPromDias") ;
            Z1804LegTitulo = httpContext.cgiGet( sPrefix+"Z1804LegTitulo") ;
            Z1818LegEstado = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1818LegEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2267LegIncompleto = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z2267LegIncompleto")) ;
            Z1582LegBanCod = httpContext.cgiGet( sPrefix+"Z1582LegBanCod") ;
            n1582LegBanCod = ((GXutil.strcmp("", A1582LegBanCod)==0) ? true : false) ;
            Z1581LegLpgCodigo = httpContext.cgiGet( sPrefix+"Z1581LegLpgCodigo") ;
            n1581LegLpgCodigo = ((GXutil.strcmp("", A1581LegLpgCodigo)==0) ? true : false) ;
            Z1583LegMegCodigo = httpContext.cgiGet( sPrefix+"Z1583LegMegCodigo") ;
            n1583LegMegCodigo = ((GXutil.strcmp("", A1583LegMegCodigo)==0) ? true : false) ;
            Z1580LegOsoCod = httpContext.cgiGet( sPrefix+"Z1580LegOsoCod") ;
            n1580LegOsoCod = ((GXutil.strcmp("", A1580LegOsoCod)==0) ? true : false) ;
            Z1579LegSecCodigo = httpContext.cgiGet( sPrefix+"Z1579LegSecCodigo") ;
            n1579LegSecCodigo = ((GXutil.strcmp("", A1579LegSecCodigo)==0) ? true : false) ;
            Z1577LegSucCodigo = httpContext.cgiGet( sPrefix+"Z1577LegSucCodigo") ;
            n1577LegSucCodigo = ((GXutil.strcmp("", A1577LegSucCodigo)==0) ? true : false) ;
            Z1578LegPuesCodigo = httpContext.cgiGet( sPrefix+"Z1578LegPuesCodigo") ;
            n1578LegPuesCodigo = ((GXutil.strcmp("", A1578LegPuesCodigo)==0) ? true : false) ;
            Z18MprCod = httpContext.cgiGet( sPrefix+"Z18MprCod") ;
            n18MprCod = ((GXutil.strcmp("", A18MprCod)==0) ? true : false) ;
            Z20ZonCod = httpContext.cgiGet( sPrefix+"Z20ZonCod") ;
            n20ZonCod = ((GXutil.strcmp("", A20ZonCod)==0) ? true : false) ;
            Z17CondiCodigo = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z17CondiCodigo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n17CondiCodigo = ((0==A17CondiCodigo) ? true : false) ;
            Z19SinieCodigo = httpContext.cgiGet( sPrefix+"Z19SinieCodigo") ;
            n19SinieCodigo = ((GXutil.strcmp("", A19SinieCodigo)==0) ? true : false) ;
            Z263LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z263LegSexo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n263LegSexo = ((0==A263LegSexo) ? true : false) ;
            Z243LegEstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z243LegEstadoCivil"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n243LegEstadoCivil = ((0==A243LegEstadoCivil) ? true : false) ;
            Z22LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z22LegPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n22LegPaiCod = ((0==A22LegPaiCod) ? true : false) ;
            Z23LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z23LegProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n23LegProvCod = ((0==A23LegProvCod) ? true : false) ;
            Z24LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z24LegLocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n24LegLocCod = ((0==A24LegLocCod) ? true : false) ;
            Z21LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z21LegNacionCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n21LegNacionCod = ((0==A21LegNacionCod) ? true : false) ;
            Z910LegSinCod = httpContext.cgiGet( sPrefix+"Z910LegSinCod") ;
            n910LegSinCod = ((GXutil.strcmp("", A910LegSinCod)==0) ? true : false) ;
            Z15LegActCodigo = httpContext.cgiGet( sPrefix+"Z15LegActCodigo") ;
            n15LegActCodigo = ((GXutil.strcmp("", A15LegActCodigo)==0) ? true : false) ;
            Z1603LegSitRevEgreso = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1603LegSitRevEgreso"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1603LegSitRevEgreso = ((0==A1603LegSitRevEgreso) ? true : false) ;
            Z1235LegReligion = httpContext.cgiGet( sPrefix+"Z1235LegReligion") ;
            n1235LegReligion = ((GXutil.strcmp("", A1235LegReligion)==0) ? true : false) ;
            Z1236LegOrigen = httpContext.cgiGet( sPrefix+"Z1236LegOrigen") ;
            n1236LegOrigen = ((GXutil.strcmp("", A1236LegOrigen)==0) ? true : false) ;
            wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
            wcpOAV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            wcpOAV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            wcpOAV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A237LegConvenio = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z237LegConvenio")) ;
            A250LegIdNomApe = httpContext.cgiGet( sPrefix+"Z250LegIdNomApe") ;
            A591LegNomApe = httpContext.cgiGet( sPrefix+"Z591LegNomApe") ;
            A251LegNombre = httpContext.cgiGet( sPrefix+"Z251LegNombre") ;
            A266LegTipDoc = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z266LegTipDoc"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A257LegNumDoc = httpContext.cgiGet( sPrefix+"Z257LegNumDoc") ;
            A246LegFecNac = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z246LegFecNac"), 0) ;
            A239LegCUIL = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z239LegCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A241LegDiscapacidad = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z241LegDiscapacidad"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A242LegDomici = httpContext.cgiGet( sPrefix+"Z242LegDomici") ;
            A479LegEmail = httpContext.cgiGet( sPrefix+"Z479LegEmail") ;
            A236LegCodPos = httpContext.cgiGet( sPrefix+"Z236LegCodPos") ;
            A265LegTelefono = httpContext.cgiGet( sPrefix+"Z265LegTelefono") ;
            n265LegTelefono = false ;
            n265LegTelefono = ((GXutil.strcmp("", A265LegTelefono)==0) ? true : false) ;
            A245LegFecIngreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z245LegFecIngreso"), 0) ;
            A244LegFecEgreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z244LegFecEgreso"), 0) ;
            n244LegFecEgreso = false ;
            n244LegFecEgreso = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A244LegFecEgreso)) ? true : false) ;
            A939LegCatCodigo = httpContext.cgiGet( sPrefix+"Z939LegCatCodigo") ;
            n939LegCatCodigo = false ;
            n939LegCatCodigo = ((GXutil.strcmp("", A939LegCatCodigo)==0) ? true : false) ;
            A235LegClase = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z235LegClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A248LegFormaPago = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z248LegFormaPago"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A231LegBanSuc = httpContext.cgiGet( sPrefix+"Z231LegBanSuc") ;
            n231LegBanSuc = false ;
            n231LegBanSuc = ((GXutil.strcmp("", A231LegBanSuc)==0) ? true : false) ;
            A232LegBanTipCuen = httpContext.cgiGet( sPrefix+"Z232LegBanTipCuen") ;
            n232LegBanTipCuen = false ;
            n232LegBanTipCuen = ((GXutil.strcmp("", A232LegBanTipCuen)==0) ? true : false) ;
            A247LegFecUltMod = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z247LegFecUltMod"), 0) ;
            A238LegCuentaBanc = httpContext.cgiGet( sPrefix+"Z238LegCuentaBanc") ;
            n238LegCuentaBanc = false ;
            n238LegCuentaBanc = ((GXutil.strcmp("", A238LegCuentaBanc)==0) ? true : false) ;
            A253LegLicInicio = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z253LegLicInicio"), 0) ;
            n253LegLicInicio = false ;
            n253LegLicInicio = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A253LegLicInicio)) ? true : false) ;
            A252LegLicFinal = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z252LegLicFinal"), 0) ;
            n252LegLicFinal = false ;
            n252LegLicFinal = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A252LegLicFinal)) ? true : false) ;
            A234LegCBU = httpContext.cgiGet( sPrefix+"Z234LegCBU") ;
            n234LegCBU = false ;
            n234LegCBU = ((GXutil.strcmp("", A234LegCBU)==0) ? true : false) ;
            A262LegSCVO = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z262LegSCVO")) ;
            A228LegActivo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z228LegActivo")) ;
            A264LegSueldoFuera = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z264LegSueldoFuera")) ;
            A93LegId = httpContext.cgiGet( sPrefix+"Z93LegId") ;
            n93LegId = false ;
            n93LegId = ((GXutil.strcmp("", A93LegId)==0) ? true : false) ;
            A937LegConveCodigo = httpContext.cgiGet( sPrefix+"Z937LegConveCodigo") ;
            n937LegConveCodigo = false ;
            n937LegConveCodigo = ((GXutil.strcmp("", A937LegConveCodigo)==0) ? true : false) ;
            A630LegFecImportacion = localUtil.ctot( httpContext.cgiGet( sPrefix+"Z630LegFecImportacion"), 0) ;
            A877LegAgenReten = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z877LegAgenReten")) ;
            A879LegContinua = httpContext.cgiGet( sPrefix+"Z879LegContinua") ;
            A942LegRecalcLiq = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z942LegRecalcLiq")) ;
            A1016LegJubilado = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1016LegJubilado")) ;
            A1023LegHorasDia = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z1023LegHorasDia")) ;
            A1268LegHorasSem = localUtil.ctond( httpContext.cgiGet( sPrefix+"Z1268LegHorasSem")) ;
            A1245LegTrabLun = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1245LegTrabLun")) ;
            A1246LegTrabMar = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1246LegTrabMar")) ;
            A1247LegTrabMie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1247LegTrabMie")) ;
            A1248LegTrabJue = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1248LegTrabJue")) ;
            A1249LegTrabVie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1249LegTrabVie")) ;
            A1250LegTrabSa = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1250LegTrabSa")) ;
            A1251LegTrabDo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z1251LegTrabDo")) ;
            A1523LegVacPend = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1523LegVacPend"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1531LegFecPreAviso = localUtil.ctod( httpContext.cgiGet( sPrefix+"Z1531LegFecPreAviso"), 0) ;
            A1576LegConveVersionCli = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1576LegConveVersionCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1576LegConveVersionCli = false ;
            n1576LegConveVersionCli = ((0==A1576LegConveVersionCli) ? true : false) ;
            A1759LegPromDias = httpContext.cgiGet( sPrefix+"Z1759LegPromDias") ;
            A1804LegTitulo = httpContext.cgiGet( sPrefix+"Z1804LegTitulo") ;
            A1818LegEstado = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1818LegEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2267LegIncompleto = GXutil.strtobool( httpContext.cgiGet( sPrefix+"Z2267LegIncompleto")) ;
            A1582LegBanCod = httpContext.cgiGet( sPrefix+"Z1582LegBanCod") ;
            n1582LegBanCod = false ;
            n1582LegBanCod = ((GXutil.strcmp("", A1582LegBanCod)==0) ? true : false) ;
            A1581LegLpgCodigo = httpContext.cgiGet( sPrefix+"Z1581LegLpgCodigo") ;
            n1581LegLpgCodigo = false ;
            n1581LegLpgCodigo = ((GXutil.strcmp("", A1581LegLpgCodigo)==0) ? true : false) ;
            A1583LegMegCodigo = httpContext.cgiGet( sPrefix+"Z1583LegMegCodigo") ;
            n1583LegMegCodigo = false ;
            n1583LegMegCodigo = ((GXutil.strcmp("", A1583LegMegCodigo)==0) ? true : false) ;
            A1580LegOsoCod = httpContext.cgiGet( sPrefix+"Z1580LegOsoCod") ;
            n1580LegOsoCod = false ;
            n1580LegOsoCod = ((GXutil.strcmp("", A1580LegOsoCod)==0) ? true : false) ;
            A1579LegSecCodigo = httpContext.cgiGet( sPrefix+"Z1579LegSecCodigo") ;
            n1579LegSecCodigo = false ;
            n1579LegSecCodigo = ((GXutil.strcmp("", A1579LegSecCodigo)==0) ? true : false) ;
            A1577LegSucCodigo = httpContext.cgiGet( sPrefix+"Z1577LegSucCodigo") ;
            n1577LegSucCodigo = false ;
            n1577LegSucCodigo = ((GXutil.strcmp("", A1577LegSucCodigo)==0) ? true : false) ;
            A1578LegPuesCodigo = httpContext.cgiGet( sPrefix+"Z1578LegPuesCodigo") ;
            n1578LegPuesCodigo = false ;
            n1578LegPuesCodigo = ((GXutil.strcmp("", A1578LegPuesCodigo)==0) ? true : false) ;
            A18MprCod = httpContext.cgiGet( sPrefix+"Z18MprCod") ;
            n18MprCod = false ;
            n18MprCod = ((GXutil.strcmp("", A18MprCod)==0) ? true : false) ;
            A20ZonCod = httpContext.cgiGet( sPrefix+"Z20ZonCod") ;
            n20ZonCod = false ;
            n20ZonCod = ((GXutil.strcmp("", A20ZonCod)==0) ? true : false) ;
            A17CondiCodigo = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z17CondiCodigo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n17CondiCodigo = false ;
            n17CondiCodigo = ((0==A17CondiCodigo) ? true : false) ;
            A19SinieCodigo = httpContext.cgiGet( sPrefix+"Z19SinieCodigo") ;
            n19SinieCodigo = false ;
            n19SinieCodigo = ((GXutil.strcmp("", A19SinieCodigo)==0) ? true : false) ;
            A263LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z263LegSexo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n263LegSexo = false ;
            n263LegSexo = ((0==A263LegSexo) ? true : false) ;
            A243LegEstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z243LegEstadoCivil"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n243LegEstadoCivil = false ;
            n243LegEstadoCivil = ((0==A243LegEstadoCivil) ? true : false) ;
            A22LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z22LegPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n22LegPaiCod = false ;
            n22LegPaiCod = ((0==A22LegPaiCod) ? true : false) ;
            A23LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z23LegProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n23LegProvCod = false ;
            n23LegProvCod = ((0==A23LegProvCod) ? true : false) ;
            A24LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z24LegLocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n24LegLocCod = false ;
            n24LegLocCod = ((0==A24LegLocCod) ? true : false) ;
            A21LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z21LegNacionCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n21LegNacionCod = false ;
            n21LegNacionCod = ((0==A21LegNacionCod) ? true : false) ;
            A910LegSinCod = httpContext.cgiGet( sPrefix+"Z910LegSinCod") ;
            n910LegSinCod = false ;
            n910LegSinCod = ((GXutil.strcmp("", A910LegSinCod)==0) ? true : false) ;
            A15LegActCodigo = httpContext.cgiGet( sPrefix+"Z15LegActCodigo") ;
            n15LegActCodigo = false ;
            n15LegActCodigo = ((GXutil.strcmp("", A15LegActCodigo)==0) ? true : false) ;
            A1603LegSitRevEgreso = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z1603LegSitRevEgreso"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1603LegSitRevEgreso = false ;
            n1603LegSitRevEgreso = ((0==A1603LegSitRevEgreso) ? true : false) ;
            A1235LegReligion = httpContext.cgiGet( sPrefix+"Z1235LegReligion") ;
            n1235LegReligion = false ;
            n1235LegReligion = ((GXutil.strcmp("", A1235LegReligion)==0) ? true : false) ;
            A1236LegOrigen = httpContext.cgiGet( sPrefix+"Z1236LegOrigen") ;
            n1236LegOrigen = false ;
            n1236LegOrigen = ((GXutil.strcmp("", A1236LegOrigen)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( sPrefix+"Mode") ;
            N263LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N263LegSexo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n263LegSexo = ((0==A263LegSexo) ? true : false) ;
            N243LegEstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N243LegEstadoCivil"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n243LegEstadoCivil = ((0==A243LegEstadoCivil) ? true : false) ;
            N21LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N21LegNacionCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n21LegNacionCod = ((0==A21LegNacionCod) ? true : false) ;
            N22LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N22LegPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n22LegPaiCod = ((0==A22LegPaiCod) ? true : false) ;
            N23LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N23LegProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n23LegProvCod = ((0==A23LegProvCod) ? true : false) ;
            N24LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N24LegLocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n24LegLocCod = ((0==A24LegLocCod) ? true : false) ;
            N1583LegMegCodigo = httpContext.cgiGet( sPrefix+"N1583LegMegCodigo") ;
            n1583LegMegCodigo = ((GXutil.strcmp("", A1583LegMegCodigo)==0) ? true : false) ;
            N1579LegSecCodigo = httpContext.cgiGet( sPrefix+"N1579LegSecCodigo") ;
            n1579LegSecCodigo = ((GXutil.strcmp("", A1579LegSecCodigo)==0) ? true : false) ;
            N1581LegLpgCodigo = httpContext.cgiGet( sPrefix+"N1581LegLpgCodigo") ;
            n1581LegLpgCodigo = ((GXutil.strcmp("", A1581LegLpgCodigo)==0) ? true : false) ;
            N1582LegBanCod = httpContext.cgiGet( sPrefix+"N1582LegBanCod") ;
            n1582LegBanCod = ((GXutil.strcmp("", A1582LegBanCod)==0) ? true : false) ;
            N910LegSinCod = httpContext.cgiGet( sPrefix+"N910LegSinCod") ;
            n910LegSinCod = ((GXutil.strcmp("", A910LegSinCod)==0) ? true : false) ;
            N1580LegOsoCod = httpContext.cgiGet( sPrefix+"N1580LegOsoCod") ;
            n1580LegOsoCod = ((GXutil.strcmp("", A1580LegOsoCod)==0) ? true : false) ;
            N15LegActCodigo = httpContext.cgiGet( sPrefix+"N15LegActCodigo") ;
            n15LegActCodigo = ((GXutil.strcmp("", A15LegActCodigo)==0) ? true : false) ;
            N18MprCod = httpContext.cgiGet( sPrefix+"N18MprCod") ;
            n18MprCod = ((GXutil.strcmp("", A18MprCod)==0) ? true : false) ;
            N20ZonCod = httpContext.cgiGet( sPrefix+"N20ZonCod") ;
            n20ZonCod = ((GXutil.strcmp("", A20ZonCod)==0) ? true : false) ;
            N17CondiCodigo = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N17CondiCodigo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n17CondiCodigo = ((0==A17CondiCodigo) ? true : false) ;
            N19SinieCodigo = httpContext.cgiGet( sPrefix+"N19SinieCodigo") ;
            n19SinieCodigo = ((GXutil.strcmp("", A19SinieCodigo)==0) ? true : false) ;
            N1578LegPuesCodigo = httpContext.cgiGet( sPrefix+"N1578LegPuesCodigo") ;
            n1578LegPuesCodigo = ((GXutil.strcmp("", A1578LegPuesCodigo)==0) ? true : false) ;
            N1577LegSucCodigo = httpContext.cgiGet( sPrefix+"N1577LegSucCodigo") ;
            n1577LegSucCodigo = ((GXutil.strcmp("", A1577LegSucCodigo)==0) ? true : false) ;
            N1603LegSitRevEgreso = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"N1603LegSitRevEgreso"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1603LegSitRevEgreso = ((0==A1603LegSitRevEgreso) ? true : false) ;
            A251LegNombre = httpContext.cgiGet( sPrefix+"LEGNOMBRE") ;
            A591LegNomApe = httpContext.cgiGet( sPrefix+"LEGNOMAPE") ;
            A93LegId = httpContext.cgiGet( sPrefix+"LEGID") ;
            n93LegId = ((GXutil.strcmp("", A93LegId)==0) ? true : false) ;
            A250LegIdNomApe = httpContext.cgiGet( sPrefix+"LEGIDNOMAPE") ;
            A1576LegConveVersionCli = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGCONVEVERSIONCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1576LegConveVersionCli = ((0==A1576LegConveVersionCli) ? true : false) ;
            A22LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n22LegPaiCod = ((0==A22LegPaiCod) ? true : false) ;
            A937LegConveCodigo = httpContext.cgiGet( sPrefix+"LEGCONVECODIGO") ;
            n937LegConveCodigo = ((GXutil.strcmp("", A937LegConveCodigo)==0) ? true : false) ;
            A235LegClase = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGCLASE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A233LegBasico = localUtil.ctond( httpContext.cgiGet( sPrefix+"LEGBASICO")) ;
            A329SecDescrip = httpContext.cgiGet( sPrefix+"SECDESCRIP") ;
            A675SecDescripSinAc = httpContext.cgiGet( sPrefix+"SECDESCRIPSINAC") ;
            A291LpgDescri = httpContext.cgiGet( sPrefix+"LPGDESCRI") ;
            A677LpgDescriSinAc = httpContext.cgiGet( sPrefix+"LPGDESCRISINAC") ;
            A117BanDescrip = httpContext.cgiGet( sPrefix+"BANDESCRIP") ;
            A679BanDescripSinAc = httpContext.cgiGet( sPrefix+"BANDESCRIPSINAC") ;
            A331SinDescrip = httpContext.cgiGet( sPrefix+"SINDESCRIP") ;
            A680SinDescripSinAc = httpContext.cgiGet( sPrefix+"SINDESCRIPSINAC") ;
            A307OsoDescrip = httpContext.cgiGet( sPrefix+"OSODESCRIP") ;
            A681OsoDescripSinAc = httpContext.cgiGet( sPrefix+"OSODESCRIPSINAC") ;
            A392OsoSigla = httpContext.cgiGet( sPrefix+"OSOSIGLA") ;
            n392OsoSigla = false ;
            A306OsoC3992 = httpContext.cgiGet( sPrefix+"OSOC3992") ;
            n306OsoC3992 = false ;
            A555OsoSiglaYDesc = httpContext.cgiGet( sPrefix+"OSOSIGLAYDESC") ;
            A237LegConvenio = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGCONVENIO")) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV33Insert_LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGSEXO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A263LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGSEXO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n263LegSexo = ((0==A263LegSexo) ? true : false) ;
            AV34Insert_LegEstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGESTADOCIVIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A243LegEstadoCivil = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGESTADOCIVIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n243LegEstadoCivil = ((0==A243LegEstadoCivil) ? true : false) ;
            AV16Insert_LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGNACIONCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A21LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGNACIONCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n21LegNacionCod = ((0==A21LegNacionCod) ? true : false) ;
            AV35Insert_LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV36Insert_LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGPROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A23LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGPROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n23LegProvCod = ((0==A23LegProvCod) ? true : false) ;
            AV37Insert_LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGLOCCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A24LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGLOCCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n24LegLocCod = ((0==A24LegLocCod) ? true : false) ;
            AV17Insert_LegMegCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGMEGCODIGO") ;
            A1583LegMegCodigo = httpContext.cgiGet( sPrefix+"LEGMEGCODIGO") ;
            n1583LegMegCodigo = ((GXutil.strcmp("", A1583LegMegCodigo)==0) ? true : false) ;
            AV18Insert_LegSecCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGSECCODIGO") ;
            A1579LegSecCodigo = httpContext.cgiGet( sPrefix+"LEGSECCODIGO") ;
            n1579LegSecCodigo = ((GXutil.strcmp("", A1579LegSecCodigo)==0) ? true : false) ;
            AV19Insert_LegLpgCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGLPGCODIGO") ;
            A1581LegLpgCodigo = httpContext.cgiGet( sPrefix+"LEGLPGCODIGO") ;
            n1581LegLpgCodigo = ((GXutil.strcmp("", A1581LegLpgCodigo)==0) ? true : false) ;
            AV20Insert_LegBanCod = httpContext.cgiGet( sPrefix+"vINSERT_LEGBANCOD") ;
            A1582LegBanCod = httpContext.cgiGet( sPrefix+"LEGBANCOD") ;
            n1582LegBanCod = ((GXutil.strcmp("", A1582LegBanCod)==0) ? true : false) ;
            AV38Insert_LegSinCod = httpContext.cgiGet( sPrefix+"vINSERT_LEGSINCOD") ;
            A910LegSinCod = httpContext.cgiGet( sPrefix+"LEGSINCOD") ;
            n910LegSinCod = ((GXutil.strcmp("", A910LegSinCod)==0) ? true : false) ;
            AV21Insert_LegOsoCod = httpContext.cgiGet( sPrefix+"vINSERT_LEGOSOCOD") ;
            A1580LegOsoCod = httpContext.cgiGet( sPrefix+"LEGOSOCOD") ;
            n1580LegOsoCod = ((GXutil.strcmp("", A1580LegOsoCod)==0) ? true : false) ;
            AV22Insert_LegActCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGACTCODIGO") ;
            A15LegActCodigo = httpContext.cgiGet( sPrefix+"LEGACTCODIGO") ;
            n15LegActCodigo = ((GXutil.strcmp("", A15LegActCodigo)==0) ? true : false) ;
            AV23Insert_MprCod = httpContext.cgiGet( sPrefix+"vINSERT_MPRCOD") ;
            A18MprCod = httpContext.cgiGet( sPrefix+"MPRCOD") ;
            n18MprCod = ((GXutil.strcmp("", A18MprCod)==0) ? true : false) ;
            AV24Insert_ZonCod = httpContext.cgiGet( sPrefix+"vINSERT_ZONCOD") ;
            A20ZonCod = httpContext.cgiGet( sPrefix+"ZONCOD") ;
            n20ZonCod = ((GXutil.strcmp("", A20ZonCod)==0) ? true : false) ;
            AV25Insert_CondiCodigo = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_CONDICODIGO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A17CondiCodigo = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"CONDICODIGO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n17CondiCodigo = ((0==A17CondiCodigo) ? true : false) ;
            AV26Insert_SinieCodigo = httpContext.cgiGet( sPrefix+"vINSERT_SINIECODIGO") ;
            A19SinieCodigo = httpContext.cgiGet( sPrefix+"SINIECODIGO") ;
            n19SinieCodigo = ((GXutil.strcmp("", A19SinieCodigo)==0) ? true : false) ;
            AV27Insert_LegPuesCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGPUESCODIGO") ;
            A1578LegPuesCodigo = httpContext.cgiGet( sPrefix+"LEGPUESCODIGO") ;
            n1578LegPuesCodigo = ((GXutil.strcmp("", A1578LegPuesCodigo)==0) ? true : false) ;
            AV28Insert_LegSucCodigo = httpContext.cgiGet( sPrefix+"vINSERT_LEGSUCCODIGO") ;
            A1577LegSucCodigo = httpContext.cgiGet( sPrefix+"LEGSUCCODIGO") ;
            n1577LegSucCodigo = ((GXutil.strcmp("", A1577LegSucCodigo)==0) ? true : false) ;
            AV29Insert_LegSitRevEgreso = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vINSERT_LEGSITREVEGRESO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1603LegSitRevEgreso = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGSITREVEGRESO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1603LegSitRevEgreso = ((0==A1603LegSitRevEgreso) ? true : false) ;
            A249LegFoto = httpContext.cgiGet( sPrefix+"LEGFOTO") ;
            n249LegFoto = false ;
            n249LegFoto = ((GXutil.strcmp("", A249LegFoto)==0) ? true : false) ;
            A266LegTipDoc = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGTIPDOC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A257LegNumDoc = httpContext.cgiGet( sPrefix+"LEGNUMDOC") ;
            A246LegFecNac = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGFECNAC"), 0) ;
            A239LegCUIL = localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A241LegDiscapacidad = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGDISCAPACIDAD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A242LegDomici = httpContext.cgiGet( sPrefix+"LEGDOMICI") ;
            A479LegEmail = httpContext.cgiGet( sPrefix+"LEGEMAIL") ;
            A236LegCodPos = httpContext.cgiGet( sPrefix+"LEGCODPOS") ;
            A265LegTelefono = httpContext.cgiGet( sPrefix+"LEGTELEFONO") ;
            n265LegTelefono = ((GXutil.strcmp("", A265LegTelefono)==0) ? true : false) ;
            A245LegFecIngreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGFECINGRESO"), 0) ;
            A244LegFecEgreso = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGFECEGRESO"), 0) ;
            n244LegFecEgreso = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A244LegFecEgreso)) ? true : false) ;
            A939LegCatCodigo = httpContext.cgiGet( sPrefix+"LEGCATCODIGO") ;
            n939LegCatCodigo = ((GXutil.strcmp("", A939LegCatCodigo)==0) ? true : false) ;
            A248LegFormaPago = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGFORMAPAGO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A231LegBanSuc = httpContext.cgiGet( sPrefix+"LEGBANSUC") ;
            n231LegBanSuc = ((GXutil.strcmp("", A231LegBanSuc)==0) ? true : false) ;
            A232LegBanTipCuen = httpContext.cgiGet( sPrefix+"LEGBANTIPCUEN") ;
            n232LegBanTipCuen = ((GXutil.strcmp("", A232LegBanTipCuen)==0) ? true : false) ;
            A247LegFecUltMod = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGFECULTMOD"), 0) ;
            A238LegCuentaBanc = httpContext.cgiGet( sPrefix+"LEGCUENTABANC") ;
            n238LegCuentaBanc = ((GXutil.strcmp("", A238LegCuentaBanc)==0) ? true : false) ;
            A253LegLicInicio = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGLICINICIO"), 0) ;
            n253LegLicInicio = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A253LegLicInicio)) ? true : false) ;
            A252LegLicFinal = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGLICFINAL"), 0) ;
            n252LegLicFinal = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A252LegLicFinal)) ? true : false) ;
            A234LegCBU = httpContext.cgiGet( sPrefix+"LEGCBU") ;
            n234LegCBU = ((GXutil.strcmp("", A234LegCBU)==0) ? true : false) ;
            A262LegSCVO = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGSCVO")) ;
            A228LegActivo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGACTIVO")) ;
            A264LegSueldoFuera = localUtil.ctond( httpContext.cgiGet( sPrefix+"LEGSUELDOFUERA")) ;
            A515LegObs = httpContext.cgiGet( sPrefix+"LEGOBS") ;
            A630LegFecImportacion = localUtil.ctot( httpContext.cgiGet( sPrefix+"LEGFECIMPORTACION"), 0) ;
            A877LegAgenReten = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGAGENRETEN")) ;
            A879LegContinua = httpContext.cgiGet( sPrefix+"LEGCONTINUA") ;
            A942LegRecalcLiq = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGRECALCLIQ")) ;
            A1016LegJubilado = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGJUBILADO")) ;
            A1023LegHorasDia = localUtil.ctond( httpContext.cgiGet( sPrefix+"LEGHORASDIA")) ;
            A1268LegHorasSem = localUtil.ctond( httpContext.cgiGet( sPrefix+"LEGHORASSEM")) ;
            A1245LegTrabLun = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABLUN")) ;
            A1246LegTrabMar = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABMAR")) ;
            A1247LegTrabMie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABMIE")) ;
            A1248LegTrabJue = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABJUE")) ;
            A1249LegTrabVie = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABVIE")) ;
            A1250LegTrabSa = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABSA")) ;
            A1251LegTrabDo = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGTRABDO")) ;
            A1523LegVacPend = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGVACPEND"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1531LegFecPreAviso = localUtil.ctod( httpContext.cgiGet( sPrefix+"LEGFECPREAVISO"), 0) ;
            A1759LegPromDias = httpContext.cgiGet( sPrefix+"LEGPROMDIAS") ;
            A1804LegTitulo = httpContext.cgiGet( sPrefix+"LEGTITULO") ;
            A1818LegEstado = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LEGESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2267LegIncompleto = GXutil.strtobool( httpContext.cgiGet( sPrefix+"LEGINCOMPLETO")) ;
            A1031LegFotoExt = httpContext.cgiGet( sPrefix+"LEGFOTOEXT") ;
            A1030LegFotoNom = httpContext.cgiGet( sPrefix+"LEGFOTONOM") ;
            A1235LegReligion = httpContext.cgiGet( sPrefix+"LEGRELIGION") ;
            n1235LegReligion = ((GXutil.strcmp("", A1235LegReligion)==0) ? true : false) ;
            A1236LegOrigen = httpContext.cgiGet( sPrefix+"LEGORIGEN") ;
            n1236LegOrigen = ((GXutil.strcmp("", A1236LegOrigen)==0) ? true : false) ;
            A300MegDescrip = httpContext.cgiGet( sPrefix+"MEGDESCRIP") ;
            n300MegDescrip = false ;
            A1965EmpOsoCod = httpContext.cgiGet( sPrefix+"EMPOSOCOD") ;
            A2EmpNom = httpContext.cgiGet( sPrefix+"EMPNOM") ;
            A45TipEmpleCod = httpContext.cgiGet( sPrefix+"TIPEMPLECOD") ;
            n45TipEmpleCod = false ;
            A684MprDescripSinAc = httpContext.cgiGet( sPrefix+"MPRDESCRIPSINAC") ;
            A303MprDescrip = httpContext.cgiGet( sPrefix+"MPRDESCRIP") ;
            A678ZonDescripSinAc = httpContext.cgiGet( sPrefix+"ZONDESCRIPSINAC") ;
            A342ZonDescrip = httpContext.cgiGet( sPrefix+"ZONDESCRIP") ;
            A343ZonPorcReduc = localUtil.ctond( httpContext.cgiGet( sPrefix+"ZONPORCREDUC")) ;
            A686CondiDescriSinAc = httpContext.cgiGet( sPrefix+"CONDIDESCRISINAC") ;
            A144CondiDescri = httpContext.cgiGet( sPrefix+"CONDIDESCRI") ;
            A688SinieDescriSinAc = httpContext.cgiGet( sPrefix+"SINIEDESCRISINAC") ;
            A333SinieDescri = httpContext.cgiGet( sPrefix+"SINIEDESCRI") ;
            A258LegPaiNom = httpContext.cgiGet( sPrefix+"LEGPAINOM") ;
            A260LegProvNom = httpContext.cgiGet( sPrefix+"LEGPROVNOM") ;
            A255LegLocNom = httpContext.cgiGet( sPrefix+"LEGLOCNOM") ;
            A256LegNacionalidad = httpContext.cgiGet( sPrefix+"LEGNACIONALIDAD") ;
            A227LegActDescri = httpContext.cgiGet( sPrefix+"LEGACTDESCRI") ;
            AV39Pgmname = httpContext.cgiGet( sPrefix+"vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6LegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            else
            {
               A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            A230LegApellido = httpContext.cgiGet( edtLegApellido_Internalname) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Legajos");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LegNombre", GXutil.rtrim( localUtil.format( A251LegNombre, "")));
            forbiddenHiddens.add("LegTipDoc", localUtil.format( DecimalUtil.doubleToDec(A266LegTipDoc), "9"));
            forbiddenHiddens.add("LegNumDoc", GXutil.rtrim( localUtil.format( A257LegNumDoc, "@!")));
            forbiddenHiddens.add("LegFecNac", localUtil.format(A246LegFecNac, "99/99/9999"));
            forbiddenHiddens.add("LegCUIL", localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9"));
            forbiddenHiddens.add("LegDiscapacidad", localUtil.format( DecimalUtil.doubleToDec(A241LegDiscapacidad), "9"));
            forbiddenHiddens.add("LegDomici", GXutil.rtrim( localUtil.format( A242LegDomici, "")));
            forbiddenHiddens.add("LegEmail", GXutil.rtrim( localUtil.format( A479LegEmail, "")));
            forbiddenHiddens.add("LegCodPos", GXutil.rtrim( localUtil.format( A236LegCodPos, "@!")));
            forbiddenHiddens.add("LegTelefono", GXutil.rtrim( localUtil.format( A265LegTelefono, "@!")));
            forbiddenHiddens.add("LegFecIngreso", localUtil.format(A245LegFecIngreso, "99/99/9999"));
            forbiddenHiddens.add("LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
            forbiddenHiddens.add("LegCatCodigo", GXutil.rtrim( localUtil.format( A939LegCatCodigo, "")));
            forbiddenHiddens.add("LegClase", localUtil.format( DecimalUtil.doubleToDec(A235LegClase), "9"));
            forbiddenHiddens.add("LegFormaPago", localUtil.format( DecimalUtil.doubleToDec(A248LegFormaPago), "9"));
            forbiddenHiddens.add("LegBanSuc", GXutil.rtrim( localUtil.format( A231LegBanSuc, "@!")));
            forbiddenHiddens.add("LegBanTipCuen", GXutil.rtrim( localUtil.format( A232LegBanTipCuen, "")));
            forbiddenHiddens.add("LegFecUltMod", localUtil.format(A247LegFecUltMod, "99/99/9999"));
            forbiddenHiddens.add("LegCuentaBanc", GXutil.rtrim( localUtil.format( A238LegCuentaBanc, "@!")));
            forbiddenHiddens.add("LegLicInicio", localUtil.format(A253LegLicInicio, "99/99/9999"));
            forbiddenHiddens.add("LegLicFinal", localUtil.format(A252LegLicFinal, "99/99/9999"));
            forbiddenHiddens.add("LegCBU", GXutil.rtrim( localUtil.format( A234LegCBU, "")));
            forbiddenHiddens.add("LegSCVO", GXutil.booltostr( A262LegSCVO));
            forbiddenHiddens.add("LegActivo", GXutil.booltostr( A228LegActivo));
            forbiddenHiddens.add("LegSueldoFuera", localUtil.format( A264LegSueldoFuera, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LegId", GXutil.rtrim( localUtil.format( A93LegId, "")));
            forbiddenHiddens.add("LegConveCodigo", GXutil.rtrim( localUtil.format( A937LegConveCodigo, "")));
            forbiddenHiddens.add("LegFecImportacion", localUtil.format( A630LegFecImportacion, "99/99/99 99:99"));
            forbiddenHiddens.add("LegAgenReten", GXutil.booltostr( A877LegAgenReten));
            forbiddenHiddens.add("LegContinua", GXutil.rtrim( localUtil.format( A879LegContinua, "")));
            forbiddenHiddens.add("LegRecalcLiq", GXutil.booltostr( A942LegRecalcLiq));
            forbiddenHiddens.add("LegJubilado", GXutil.booltostr( A1016LegJubilado));
            forbiddenHiddens.add("LegHorasDia", localUtil.format( A1023LegHorasDia, "9.9"));
            forbiddenHiddens.add("LegHorasSem", localUtil.format( A1268LegHorasSem, "Z9.9"));
            forbiddenHiddens.add("LegReligion", GXutil.rtrim( localUtil.format( A1235LegReligion, "")));
            forbiddenHiddens.add("LegOrigen", GXutil.rtrim( localUtil.format( A1236LegOrigen, "")));
            forbiddenHiddens.add("LegTrabLun", GXutil.booltostr( A1245LegTrabLun));
            forbiddenHiddens.add("LegTrabMar", GXutil.booltostr( A1246LegTrabMar));
            forbiddenHiddens.add("LegTrabMie", GXutil.booltostr( A1247LegTrabMie));
            forbiddenHiddens.add("LegTrabJue", GXutil.booltostr( A1248LegTrabJue));
            forbiddenHiddens.add("LegTrabVie", GXutil.booltostr( A1249LegTrabVie));
            forbiddenHiddens.add("LegTrabSa", GXutil.booltostr( A1250LegTrabSa));
            forbiddenHiddens.add("LegTrabDo", GXutil.booltostr( A1251LegTrabDo));
            forbiddenHiddens.add("LegVacPend", localUtil.format( DecimalUtil.doubleToDec(A1523LegVacPend), "ZZZ9"));
            forbiddenHiddens.add("LegFecPreAviso", localUtil.format(A1531LegFecPreAviso, "99/99/99"));
            forbiddenHiddens.add("LegConveVersionCli", localUtil.format( DecimalUtil.doubleToDec(A1576LegConveVersionCli), "ZZZZZ9"));
            forbiddenHiddens.add("LegPromDias", GXutil.rtrim( localUtil.format( A1759LegPromDias, "")));
            forbiddenHiddens.add("LegTitulo", GXutil.rtrim( localUtil.format( A1804LegTitulo, "")));
            forbiddenHiddens.add("LegEstado", localUtil.format( DecimalUtil.doubleToDec(A1818LegEstado), "9"));
            forbiddenHiddens.add("LegIncompleto", GXutil.booltostr( A2267LegIncompleto));
            hsh = httpContext.cgiGet( sPrefix+"hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("legajos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode23 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode23 ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound23 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5K0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e125K2 ();
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              dynload_actions( ) ;
                              /* Execute user event: After Trn */
                              e135K2 ();
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              if ( ! isDsp( ) )
                              {
                                 btn_enter( ) ;
                              }
                           }
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
         e135K2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5K23( ) ;
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
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes5K23( ) ;
      }
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegApellido_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
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

   public void confirm_5K0( )
   {
      beforeValidate5K23( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5K23( ) ;
         }
         else
         {
            checkExtendedTable5K23( ) ;
            closeExtendedTableCursors5K23( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5K0( )
   {
   }

   public void e125K2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajos_Insert", GXv_boolean3) ;
         legajos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajos_Update", GXv_boolean3) ;
         legajos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajos_Delete", GXv_boolean3) ;
         legajos_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV39Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV39Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV40GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40GXV1), 8, 0));
         while ( AV40GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV30TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV40GXV1));
            if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSexo") == 0 )
            {
               AV33Insert_LegSexo = (byte)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Insert_LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33Insert_LegSexo), 2, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegEstadoCivil") == 0 )
            {
               AV34Insert_LegEstadoCivil = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Insert_LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34Insert_LegEstadoCivil), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegNacionCod") == 0 )
            {
               AV16Insert_LegNacionCod = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16Insert_LegNacionCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_LegNacionCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegPaiCod") == 0 )
            {
               AV35Insert_LegPaiCod = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35Insert_LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35Insert_LegPaiCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegProvCod") == 0 )
            {
               AV36Insert_LegProvCod = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36Insert_LegProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36Insert_LegProvCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLocCod") == 0 )
            {
               AV37Insert_LegLocCod = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37Insert_LegLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37Insert_LegLocCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegMegCodigo") == 0 )
            {
               AV17Insert_LegMegCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17Insert_LegMegCodigo", AV17Insert_LegMegCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSecCodigo") == 0 )
            {
               AV18Insert_LegSecCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18Insert_LegSecCodigo", AV18Insert_LegSecCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLpgCodigo") == 0 )
            {
               AV19Insert_LegLpgCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19Insert_LegLpgCodigo", AV19Insert_LegLpgCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegBanCod") == 0 )
            {
               AV20Insert_LegBanCod = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Insert_LegBanCod", AV20Insert_LegBanCod);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSinCod") == 0 )
            {
               AV38Insert_LegSinCod = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38Insert_LegSinCod", AV38Insert_LegSinCod);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegOsoCod") == 0 )
            {
               AV21Insert_LegOsoCod = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21Insert_LegOsoCod", AV21Insert_LegOsoCod);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegActCodigo") == 0 )
            {
               AV22Insert_LegActCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22Insert_LegActCodigo", AV22Insert_LegActCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MprCod") == 0 )
            {
               AV23Insert_MprCod = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23Insert_MprCod", AV23Insert_MprCod);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ZonCod") == 0 )
            {
               AV24Insert_ZonCod = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24Insert_ZonCod", AV24Insert_ZonCod);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CondiCodigo") == 0 )
            {
               AV25Insert_CondiCodigo = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25Insert_CondiCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25Insert_CondiCodigo), 4, 0));
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SinieCodigo") == 0 )
            {
               AV26Insert_SinieCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26Insert_SinieCodigo", AV26Insert_SinieCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegPuesCodigo") == 0 )
            {
               AV27Insert_LegPuesCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27Insert_LegPuesCodigo", AV27Insert_LegPuesCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSucCodigo") == 0 )
            {
               AV28Insert_LegSucCodigo = AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28Insert_LegSucCodigo", AV28Insert_LegSucCodigo);
            }
            else if ( GXutil.strcmp(AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSitRevEgreso") == 0 )
            {
               AV29Insert_LegSitRevEgreso = (short)(GXutil.lval( AV30TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29Insert_LegSitRevEgreso", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29Insert_LegSitRevEgreso), 3, 0));
            }
            AV40GXV1 = (int)(AV40GXV1+1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40GXV1), 8, 0));
         }
      }
   }

   public void e135K2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         AV31DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  );
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "SplitScreen_LoadDetail", new Object[] {Integer.valueOf(3),AV31DetailWCInfo,Boolean.valueOf(true),"legajo"}, true);
      }
      else if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "SplitScreen_LoadDetail", new Object[] {Integer.valueOf(2),AV31DetailWCInfo,Boolean.valueOf(true),"legajo"}, true);
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV31DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  );
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "SplitScreen_LoadDetail", new Object[] {Integer.valueOf(4),AV31DetailWCInfo,Boolean.valueOf(true),"legajo"}, true);
      }
      else
      {
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "SplitScreen_LoadDetail", new Object[] {Integer.valueOf(2),AV31DetailWCInfo,Boolean.valueOf(false),"legajo"}, true);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV31DetailWCInfo", AV31DetailWCInfo);
   }

   public void zm5K23( int GX_JID )
   {
      if ( ( GX_JID == 62 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z237LegConvenio = T005K3_A237LegConvenio[0] ;
            Z250LegIdNomApe = T005K3_A250LegIdNomApe[0] ;
            Z591LegNomApe = T005K3_A591LegNomApe[0] ;
            Z230LegApellido = T005K3_A230LegApellido[0] ;
            Z251LegNombre = T005K3_A251LegNombre[0] ;
            Z266LegTipDoc = T005K3_A266LegTipDoc[0] ;
            Z257LegNumDoc = T005K3_A257LegNumDoc[0] ;
            Z246LegFecNac = T005K3_A246LegFecNac[0] ;
            Z239LegCUIL = T005K3_A239LegCUIL[0] ;
            Z241LegDiscapacidad = T005K3_A241LegDiscapacidad[0] ;
            Z242LegDomici = T005K3_A242LegDomici[0] ;
            Z479LegEmail = T005K3_A479LegEmail[0] ;
            Z236LegCodPos = T005K3_A236LegCodPos[0] ;
            Z265LegTelefono = T005K3_A265LegTelefono[0] ;
            Z245LegFecIngreso = T005K3_A245LegFecIngreso[0] ;
            Z244LegFecEgreso = T005K3_A244LegFecEgreso[0] ;
            Z939LegCatCodigo = T005K3_A939LegCatCodigo[0] ;
            Z235LegClase = T005K3_A235LegClase[0] ;
            Z248LegFormaPago = T005K3_A248LegFormaPago[0] ;
            Z231LegBanSuc = T005K3_A231LegBanSuc[0] ;
            Z232LegBanTipCuen = T005K3_A232LegBanTipCuen[0] ;
            Z247LegFecUltMod = T005K3_A247LegFecUltMod[0] ;
            Z238LegCuentaBanc = T005K3_A238LegCuentaBanc[0] ;
            Z253LegLicInicio = T005K3_A253LegLicInicio[0] ;
            Z252LegLicFinal = T005K3_A252LegLicFinal[0] ;
            Z234LegCBU = T005K3_A234LegCBU[0] ;
            Z262LegSCVO = T005K3_A262LegSCVO[0] ;
            Z228LegActivo = T005K3_A228LegActivo[0] ;
            Z264LegSueldoFuera = T005K3_A264LegSueldoFuera[0] ;
            Z93LegId = T005K3_A93LegId[0] ;
            Z937LegConveCodigo = T005K3_A937LegConveCodigo[0] ;
            Z630LegFecImportacion = T005K3_A630LegFecImportacion[0] ;
            Z877LegAgenReten = T005K3_A877LegAgenReten[0] ;
            Z879LegContinua = T005K3_A879LegContinua[0] ;
            Z942LegRecalcLiq = T005K3_A942LegRecalcLiq[0] ;
            Z1016LegJubilado = T005K3_A1016LegJubilado[0] ;
            Z1023LegHorasDia = T005K3_A1023LegHorasDia[0] ;
            Z1268LegHorasSem = T005K3_A1268LegHorasSem[0] ;
            Z1245LegTrabLun = T005K3_A1245LegTrabLun[0] ;
            Z1246LegTrabMar = T005K3_A1246LegTrabMar[0] ;
            Z1247LegTrabMie = T005K3_A1247LegTrabMie[0] ;
            Z1248LegTrabJue = T005K3_A1248LegTrabJue[0] ;
            Z1249LegTrabVie = T005K3_A1249LegTrabVie[0] ;
            Z1250LegTrabSa = T005K3_A1250LegTrabSa[0] ;
            Z1251LegTrabDo = T005K3_A1251LegTrabDo[0] ;
            Z1523LegVacPend = T005K3_A1523LegVacPend[0] ;
            Z1531LegFecPreAviso = T005K3_A1531LegFecPreAviso[0] ;
            Z1576LegConveVersionCli = T005K3_A1576LegConveVersionCli[0] ;
            Z1759LegPromDias = T005K3_A1759LegPromDias[0] ;
            Z1804LegTitulo = T005K3_A1804LegTitulo[0] ;
            Z1818LegEstado = T005K3_A1818LegEstado[0] ;
            Z2267LegIncompleto = T005K3_A2267LegIncompleto[0] ;
            Z1582LegBanCod = T005K3_A1582LegBanCod[0] ;
            Z1581LegLpgCodigo = T005K3_A1581LegLpgCodigo[0] ;
            Z1583LegMegCodigo = T005K3_A1583LegMegCodigo[0] ;
            Z1580LegOsoCod = T005K3_A1580LegOsoCod[0] ;
            Z1579LegSecCodigo = T005K3_A1579LegSecCodigo[0] ;
            Z1577LegSucCodigo = T005K3_A1577LegSucCodigo[0] ;
            Z1578LegPuesCodigo = T005K3_A1578LegPuesCodigo[0] ;
            Z18MprCod = T005K3_A18MprCod[0] ;
            Z20ZonCod = T005K3_A20ZonCod[0] ;
            Z17CondiCodigo = T005K3_A17CondiCodigo[0] ;
            Z19SinieCodigo = T005K3_A19SinieCodigo[0] ;
            Z263LegSexo = T005K3_A263LegSexo[0] ;
            Z243LegEstadoCivil = T005K3_A243LegEstadoCivil[0] ;
            Z22LegPaiCod = T005K3_A22LegPaiCod[0] ;
            Z23LegProvCod = T005K3_A23LegProvCod[0] ;
            Z24LegLocCod = T005K3_A24LegLocCod[0] ;
            Z21LegNacionCod = T005K3_A21LegNacionCod[0] ;
            Z910LegSinCod = T005K3_A910LegSinCod[0] ;
            Z15LegActCodigo = T005K3_A15LegActCodigo[0] ;
            Z1603LegSitRevEgreso = T005K3_A1603LegSitRevEgreso[0] ;
            Z1235LegReligion = T005K3_A1235LegReligion[0] ;
            Z1236LegOrigen = T005K3_A1236LegOrigen[0] ;
         }
         else
         {
            Z237LegConvenio = A237LegConvenio ;
            Z250LegIdNomApe = A250LegIdNomApe ;
            Z591LegNomApe = A591LegNomApe ;
            Z230LegApellido = A230LegApellido ;
            Z251LegNombre = A251LegNombre ;
            Z266LegTipDoc = A266LegTipDoc ;
            Z257LegNumDoc = A257LegNumDoc ;
            Z246LegFecNac = A246LegFecNac ;
            Z239LegCUIL = A239LegCUIL ;
            Z241LegDiscapacidad = A241LegDiscapacidad ;
            Z242LegDomici = A242LegDomici ;
            Z479LegEmail = A479LegEmail ;
            Z236LegCodPos = A236LegCodPos ;
            Z265LegTelefono = A265LegTelefono ;
            Z245LegFecIngreso = A245LegFecIngreso ;
            Z244LegFecEgreso = A244LegFecEgreso ;
            Z939LegCatCodigo = A939LegCatCodigo ;
            Z235LegClase = A235LegClase ;
            Z248LegFormaPago = A248LegFormaPago ;
            Z231LegBanSuc = A231LegBanSuc ;
            Z232LegBanTipCuen = A232LegBanTipCuen ;
            Z247LegFecUltMod = A247LegFecUltMod ;
            Z238LegCuentaBanc = A238LegCuentaBanc ;
            Z253LegLicInicio = A253LegLicInicio ;
            Z252LegLicFinal = A252LegLicFinal ;
            Z234LegCBU = A234LegCBU ;
            Z262LegSCVO = A262LegSCVO ;
            Z228LegActivo = A228LegActivo ;
            Z264LegSueldoFuera = A264LegSueldoFuera ;
            Z93LegId = A93LegId ;
            Z937LegConveCodigo = A937LegConveCodigo ;
            Z630LegFecImportacion = A630LegFecImportacion ;
            Z877LegAgenReten = A877LegAgenReten ;
            Z879LegContinua = A879LegContinua ;
            Z942LegRecalcLiq = A942LegRecalcLiq ;
            Z1016LegJubilado = A1016LegJubilado ;
            Z1023LegHorasDia = A1023LegHorasDia ;
            Z1268LegHorasSem = A1268LegHorasSem ;
            Z1245LegTrabLun = A1245LegTrabLun ;
            Z1246LegTrabMar = A1246LegTrabMar ;
            Z1247LegTrabMie = A1247LegTrabMie ;
            Z1248LegTrabJue = A1248LegTrabJue ;
            Z1249LegTrabVie = A1249LegTrabVie ;
            Z1250LegTrabSa = A1250LegTrabSa ;
            Z1251LegTrabDo = A1251LegTrabDo ;
            Z1523LegVacPend = A1523LegVacPend ;
            Z1531LegFecPreAviso = A1531LegFecPreAviso ;
            Z1576LegConveVersionCli = A1576LegConveVersionCli ;
            Z1759LegPromDias = A1759LegPromDias ;
            Z1804LegTitulo = A1804LegTitulo ;
            Z1818LegEstado = A1818LegEstado ;
            Z2267LegIncompleto = A2267LegIncompleto ;
            Z1582LegBanCod = A1582LegBanCod ;
            Z1581LegLpgCodigo = A1581LegLpgCodigo ;
            Z1583LegMegCodigo = A1583LegMegCodigo ;
            Z1580LegOsoCod = A1580LegOsoCod ;
            Z1579LegSecCodigo = A1579LegSecCodigo ;
            Z1577LegSucCodigo = A1577LegSucCodigo ;
            Z1578LegPuesCodigo = A1578LegPuesCodigo ;
            Z18MprCod = A18MprCod ;
            Z20ZonCod = A20ZonCod ;
            Z17CondiCodigo = A17CondiCodigo ;
            Z19SinieCodigo = A19SinieCodigo ;
            Z263LegSexo = A263LegSexo ;
            Z243LegEstadoCivil = A243LegEstadoCivil ;
            Z22LegPaiCod = A22LegPaiCod ;
            Z23LegProvCod = A23LegProvCod ;
            Z24LegLocCod = A24LegLocCod ;
            Z21LegNacionCod = A21LegNacionCod ;
            Z910LegSinCod = A910LegSinCod ;
            Z15LegActCodigo = A15LegActCodigo ;
            Z1603LegSitRevEgreso = A1603LegSitRevEgreso ;
            Z1235LegReligion = A1235LegReligion ;
            Z1236LegOrigen = A1236LegOrigen ;
         }
      }
      if ( GX_JID == -62 )
      {
         Z15LegActCodigo = A15LegActCodigo ;
         Z1603LegSitRevEgreso = A1603LegSitRevEgreso ;
         Z1235LegReligion = A1235LegReligion ;
         Z1236LegOrigen = A1236LegOrigen ;
         Z237LegConvenio = A237LegConvenio ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z6LegNumero = A6LegNumero ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z249LegFoto = A249LegFoto ;
         Z266LegTipDoc = A266LegTipDoc ;
         Z257LegNumDoc = A257LegNumDoc ;
         Z246LegFecNac = A246LegFecNac ;
         Z239LegCUIL = A239LegCUIL ;
         Z241LegDiscapacidad = A241LegDiscapacidad ;
         Z242LegDomici = A242LegDomici ;
         Z479LegEmail = A479LegEmail ;
         Z236LegCodPos = A236LegCodPos ;
         Z265LegTelefono = A265LegTelefono ;
         Z245LegFecIngreso = A245LegFecIngreso ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z939LegCatCodigo = A939LegCatCodigo ;
         Z235LegClase = A235LegClase ;
         Z248LegFormaPago = A248LegFormaPago ;
         Z231LegBanSuc = A231LegBanSuc ;
         Z232LegBanTipCuen = A232LegBanTipCuen ;
         Z247LegFecUltMod = A247LegFecUltMod ;
         Z238LegCuentaBanc = A238LegCuentaBanc ;
         Z253LegLicInicio = A253LegLicInicio ;
         Z252LegLicFinal = A252LegLicFinal ;
         Z234LegCBU = A234LegCBU ;
         Z262LegSCVO = A262LegSCVO ;
         Z228LegActivo = A228LegActivo ;
         Z264LegSueldoFuera = A264LegSueldoFuera ;
         Z93LegId = A93LegId ;
         Z937LegConveCodigo = A937LegConveCodigo ;
         Z515LegObs = A515LegObs ;
         Z630LegFecImportacion = A630LegFecImportacion ;
         Z877LegAgenReten = A877LegAgenReten ;
         Z879LegContinua = A879LegContinua ;
         Z942LegRecalcLiq = A942LegRecalcLiq ;
         Z1016LegJubilado = A1016LegJubilado ;
         Z1023LegHorasDia = A1023LegHorasDia ;
         Z1268LegHorasSem = A1268LegHorasSem ;
         Z1245LegTrabLun = A1245LegTrabLun ;
         Z1246LegTrabMar = A1246LegTrabMar ;
         Z1247LegTrabMie = A1247LegTrabMie ;
         Z1248LegTrabJue = A1248LegTrabJue ;
         Z1249LegTrabVie = A1249LegTrabVie ;
         Z1250LegTrabSa = A1250LegTrabSa ;
         Z1251LegTrabDo = A1251LegTrabDo ;
         Z1523LegVacPend = A1523LegVacPend ;
         Z1531LegFecPreAviso = A1531LegFecPreAviso ;
         Z1576LegConveVersionCli = A1576LegConveVersionCli ;
         Z1759LegPromDias = A1759LegPromDias ;
         Z1804LegTitulo = A1804LegTitulo ;
         Z1818LegEstado = A1818LegEstado ;
         Z2267LegIncompleto = A2267LegIncompleto ;
         Z1031LegFotoExt = A1031LegFotoExt ;
         Z1030LegFotoNom = A1030LegFotoNom ;
         Z3CliCod = A3CliCod ;
         Z1582LegBanCod = A1582LegBanCod ;
         Z1581LegLpgCodigo = A1581LegLpgCodigo ;
         Z1583LegMegCodigo = A1583LegMegCodigo ;
         Z1580LegOsoCod = A1580LegOsoCod ;
         Z1579LegSecCodigo = A1579LegSecCodigo ;
         Z1EmpCod = A1EmpCod ;
         Z1577LegSucCodigo = A1577LegSucCodigo ;
         Z1578LegPuesCodigo = A1578LegPuesCodigo ;
         Z18MprCod = A18MprCod ;
         Z20ZonCod = A20ZonCod ;
         Z17CondiCodigo = A17CondiCodigo ;
         Z19SinieCodigo = A19SinieCodigo ;
         Z263LegSexo = A263LegSexo ;
         Z243LegEstadoCivil = A243LegEstadoCivil ;
         Z22LegPaiCod = A22LegPaiCod ;
         Z23LegProvCod = A23LegProvCod ;
         Z24LegLocCod = A24LegLocCod ;
         Z21LegNacionCod = A21LegNacionCod ;
         Z910LegSinCod = A910LegSinCod ;
         Z684MprDescripSinAc = A684MprDescripSinAc ;
         Z303MprDescrip = A303MprDescrip ;
         Z678ZonDescripSinAc = A678ZonDescripSinAc ;
         Z342ZonDescrip = A342ZonDescrip ;
         Z343ZonPorcReduc = A343ZonPorcReduc ;
         Z686CondiDescriSinAc = A686CondiDescriSinAc ;
         Z144CondiDescri = A144CondiDescri ;
         Z688SinieDescriSinAc = A688SinieDescriSinAc ;
         Z333SinieDescri = A333SinieDescri ;
         Z258LegPaiNom = A258LegPaiNom ;
         Z260LegProvNom = A260LegProvNom ;
         Z255LegLocNom = A255LegLocNom ;
         Z256LegNacionalidad = A256LegNacionalidad ;
         Z331SinDescrip = A331SinDescrip ;
         Z227LegActDescri = A227LegActDescri ;
         Z291LpgDescri = A291LpgDescri ;
         Z300MegDescrip = A300MegDescrip ;
         Z392OsoSigla = A392OsoSigla ;
         Z329SecDescrip = A329SecDescrip ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z1965EmpOsoCod = A1965EmpOsoCod ;
         Z2EmpNom = A2EmpNom ;
         Z307OsoDescrip = A307OsoDescrip ;
         Z306OsoC3992 = A306OsoC3992 ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegNumero) )
      {
         A6LegNumero = AV10LegNumero ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ! (0==AV10LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV29Insert_LegSitRevEgreso) )
      {
         A1603LegSitRevEgreso = AV29Insert_LegSitRevEgreso ;
         n1603LegSitRevEgreso = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1603LegSitRevEgreso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1603LegSitRevEgreso), 3, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV28Insert_LegSucCodigo)==0) )
      {
         A1577LegSucCodigo = AV28Insert_LegSucCodigo ;
         n1577LegSucCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1577LegSucCodigo", A1577LegSucCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV27Insert_LegPuesCodigo)==0) )
      {
         A1578LegPuesCodigo = AV27Insert_LegPuesCodigo ;
         n1578LegPuesCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1578LegPuesCodigo", A1578LegPuesCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV26Insert_SinieCodigo)==0) )
      {
         A19SinieCodigo = AV26Insert_SinieCodigo ;
         n19SinieCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19SinieCodigo", A19SinieCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV25Insert_CondiCodigo) )
      {
         A17CondiCodigo = AV25Insert_CondiCodigo ;
         n17CondiCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17CondiCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17CondiCodigo), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV24Insert_ZonCod)==0) )
      {
         A20ZonCod = AV24Insert_ZonCod ;
         n20ZonCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20ZonCod", A20ZonCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV23Insert_MprCod)==0) )
      {
         A18MprCod = AV23Insert_MprCod ;
         n18MprCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18MprCod", A18MprCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV22Insert_LegActCodigo)==0) )
      {
         A15LegActCodigo = AV22Insert_LegActCodigo ;
         n15LegActCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A15LegActCodigo", A15LegActCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV21Insert_LegOsoCod)==0) )
      {
         A1580LegOsoCod = AV21Insert_LegOsoCod ;
         n1580LegOsoCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1580LegOsoCod", A1580LegOsoCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV38Insert_LegSinCod)==0) )
      {
         A910LegSinCod = AV38Insert_LegSinCod ;
         n910LegSinCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A910LegSinCod", A910LegSinCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV20Insert_LegBanCod)==0) )
      {
         A1582LegBanCod = AV20Insert_LegBanCod ;
         n1582LegBanCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1582LegBanCod", A1582LegBanCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV19Insert_LegLpgCodigo)==0) )
      {
         A1581LegLpgCodigo = AV19Insert_LegLpgCodigo ;
         n1581LegLpgCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1581LegLpgCodigo", A1581LegLpgCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV18Insert_LegSecCodigo)==0) )
      {
         A1579LegSecCodigo = AV18Insert_LegSecCodigo ;
         n1579LegSecCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1579LegSecCodigo", A1579LegSecCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_LegMegCodigo)==0) )
      {
         A1583LegMegCodigo = AV17Insert_LegMegCodigo ;
         n1583LegMegCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1583LegMegCodigo", A1583LegMegCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV37Insert_LegLocCod) )
      {
         A24LegLocCod = AV37Insert_LegLocCod ;
         n24LegLocCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A24LegLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24LegLocCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV36Insert_LegProvCod) )
      {
         A23LegProvCod = AV36Insert_LegProvCod ;
         n23LegProvCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23LegProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23LegProvCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV35Insert_LegPaiCod) )
      {
         A22LegPaiCod = AV35Insert_LegPaiCod ;
         n22LegPaiCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_LegNacionCod) )
      {
         A21LegNacionCod = AV16Insert_LegNacionCod ;
         n21LegNacionCod = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21LegNacionCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21LegNacionCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV34Insert_LegEstadoCivil) )
      {
         A243LegEstadoCivil = AV34Insert_LegEstadoCivil ;
         n243LegEstadoCivil = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV33Insert_LegSexo) )
      {
         A263LegSexo = AV33Insert_LegSexo ;
         n263LegSexo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV39Pgmname = "Legajos" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Pgmname", AV39Pgmname);
         /* Using cursor T005K9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A45TipEmpleCod = T005K9_A45TipEmpleCod[0] ;
         n45TipEmpleCod = T005K9_n45TipEmpleCod[0] ;
         A1965EmpOsoCod = T005K9_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = T005K9_n1965EmpOsoCod[0] ;
         A2EmpNom = T005K9_A2EmpNom[0] ;
         pr_default.close(7);
         /* Using cursor T005K25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
         A307OsoDescrip = T005K25_A307OsoDescrip[0] ;
         n307OsoDescrip = T005K25_n307OsoDescrip[0] ;
         A306OsoC3992 = T005K25_A306OsoC3992[0] ;
         n306OsoC3992 = T005K25_n306OsoC3992[0] ;
         pr_default.close(23);
         GXt_char4 = A681OsoDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A681OsoDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
         /* Using cursor T005K15 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         A688SinieDescriSinAc = T005K15_A688SinieDescriSinAc[0] ;
         A333SinieDescri = T005K15_A333SinieDescri[0] ;
         pr_default.close(13);
         /* Using cursor T005K14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         A686CondiDescriSinAc = T005K14_A686CondiDescriSinAc[0] ;
         A144CondiDescri = T005K14_A144CondiDescri[0] ;
         pr_default.close(12);
         /* Using cursor T005K13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         A678ZonDescripSinAc = T005K13_A678ZonDescripSinAc[0] ;
         A342ZonDescrip = T005K13_A342ZonDescrip[0] ;
         A343ZonPorcReduc = T005K13_A343ZonPorcReduc[0] ;
         pr_default.close(11);
         /* Using cursor T005K12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
         A684MprDescripSinAc = T005K12_A684MprDescripSinAc[0] ;
         A303MprDescrip = T005K12_A303MprDescrip[0] ;
         pr_default.close(10);
         /* Using cursor T005K23 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
         A227LegActDescri = T005K23_A227LegActDescri[0] ;
         pr_default.close(21);
         /* Using cursor T005K7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
         A392OsoSigla = T005K7_A392OsoSigla[0] ;
         n392OsoSigla = T005K7_n392OsoSigla[0] ;
         pr_default.close(5);
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
               {
                  A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
               }
               else
               {
                  A555OsoSiglaYDesc = A307OsoDescrip ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
               }
            }
         }
         /* Using cursor T005K5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
         A291LpgDescri = T005K5_A291LpgDescri[0] ;
         n291LpgDescri = T005K5_n291LpgDescri[0] ;
         pr_default.close(3);
         GXt_char4 = A677LpgDescriSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A677LpgDescriSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
         /* Using cursor T005K8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
         A329SecDescrip = T005K8_A329SecDescrip[0] ;
         n329SecDescrip = T005K8_n329SecDescrip[0] ;
         pr_default.close(6);
         GXt_char4 = A675SecDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A675SecDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
         /* Using cursor T005K6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
         A300MegDescrip = T005K6_A300MegDescrip[0] ;
         n300MegDescrip = T005K6_n300MegDescrip[0] ;
         pr_default.close(4);
         /* Using cursor T005K18 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
         A258LegPaiNom = T005K18_A258LegPaiNom[0] ;
         pr_default.close(16);
         /* Using cursor T005K19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
         A260LegProvNom = T005K19_A260LegProvNom[0] ;
         pr_default.close(17);
         /* Using cursor T005K20 */
         pr_default.execute(18, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
         A255LegLocNom = T005K20_A255LegLocNom[0] ;
         pr_default.close(18);
         /* Using cursor T005K22 */
         pr_default.execute(20, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
         A331SinDescrip = T005K22_A331SinDescrip[0] ;
         n331SinDescrip = T005K22_n331SinDescrip[0] ;
         pr_default.close(20);
         GXt_char4 = A680SinDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A680SinDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
         /* Using cursor T005K21 */
         pr_default.execute(19, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
         A256LegNacionalidad = T005K21_A256LegNacionalidad[0] ;
         pr_default.close(19);
      }
   }

   public void load5K23( )
   {
      /* Using cursor T005K26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A15LegActCodigo = T005K26_A15LegActCodigo[0] ;
         n15LegActCodigo = T005K26_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = T005K26_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = T005K26_n1603LegSitRevEgreso[0] ;
         A45TipEmpleCod = T005K26_A45TipEmpleCod[0] ;
         n45TipEmpleCod = T005K26_n45TipEmpleCod[0] ;
         A1235LegReligion = T005K26_A1235LegReligion[0] ;
         n1235LegReligion = T005K26_n1235LegReligion[0] ;
         A1236LegOrigen = T005K26_A1236LegOrigen[0] ;
         n1236LegOrigen = T005K26_n1236LegOrigen[0] ;
         A1965EmpOsoCod = T005K26_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = T005K26_n1965EmpOsoCod[0] ;
         A237LegConvenio = T005K26_A237LegConvenio[0] ;
         A688SinieDescriSinAc = T005K26_A688SinieDescriSinAc[0] ;
         A686CondiDescriSinAc = T005K26_A686CondiDescriSinAc[0] ;
         A678ZonDescripSinAc = T005K26_A678ZonDescripSinAc[0] ;
         A684MprDescripSinAc = T005K26_A684MprDescripSinAc[0] ;
         A250LegIdNomApe = T005K26_A250LegIdNomApe[0] ;
         A591LegNomApe = T005K26_A591LegNomApe[0] ;
         A2EmpNom = T005K26_A2EmpNom[0] ;
         A230LegApellido = T005K26_A230LegApellido[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
         A251LegNombre = T005K26_A251LegNombre[0] ;
         A249LegFoto = T005K26_A249LegFoto[0] ;
         n249LegFoto = T005K26_n249LegFoto[0] ;
         A266LegTipDoc = T005K26_A266LegTipDoc[0] ;
         A257LegNumDoc = T005K26_A257LegNumDoc[0] ;
         A246LegFecNac = T005K26_A246LegFecNac[0] ;
         A256LegNacionalidad = T005K26_A256LegNacionalidad[0] ;
         A239LegCUIL = T005K26_A239LegCUIL[0] ;
         A241LegDiscapacidad = T005K26_A241LegDiscapacidad[0] ;
         A242LegDomici = T005K26_A242LegDomici[0] ;
         A479LegEmail = T005K26_A479LegEmail[0] ;
         A236LegCodPos = T005K26_A236LegCodPos[0] ;
         A258LegPaiNom = T005K26_A258LegPaiNom[0] ;
         A260LegProvNom = T005K26_A260LegProvNom[0] ;
         A255LegLocNom = T005K26_A255LegLocNom[0] ;
         A265LegTelefono = T005K26_A265LegTelefono[0] ;
         n265LegTelefono = T005K26_n265LegTelefono[0] ;
         A245LegFecIngreso = T005K26_A245LegFecIngreso[0] ;
         A244LegFecEgreso = T005K26_A244LegFecEgreso[0] ;
         n244LegFecEgreso = T005K26_n244LegFecEgreso[0] ;
         A300MegDescrip = T005K26_A300MegDescrip[0] ;
         n300MegDescrip = T005K26_n300MegDescrip[0] ;
         A939LegCatCodigo = T005K26_A939LegCatCodigo[0] ;
         n939LegCatCodigo = T005K26_n939LegCatCodigo[0] ;
         A329SecDescrip = T005K26_A329SecDescrip[0] ;
         n329SecDescrip = T005K26_n329SecDescrip[0] ;
         A291LpgDescri = T005K26_A291LpgDescri[0] ;
         n291LpgDescri = T005K26_n291LpgDescri[0] ;
         A235LegClase = T005K26_A235LegClase[0] ;
         A248LegFormaPago = T005K26_A248LegFormaPago[0] ;
         A231LegBanSuc = T005K26_A231LegBanSuc[0] ;
         n231LegBanSuc = T005K26_n231LegBanSuc[0] ;
         A232LegBanTipCuen = T005K26_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = T005K26_n232LegBanTipCuen[0] ;
         A331SinDescrip = T005K26_A331SinDescrip[0] ;
         n331SinDescrip = T005K26_n331SinDescrip[0] ;
         A307OsoDescrip = T005K26_A307OsoDescrip[0] ;
         n307OsoDescrip = T005K26_n307OsoDescrip[0] ;
         A227LegActDescri = T005K26_A227LegActDescri[0] ;
         A303MprDescrip = T005K26_A303MprDescrip[0] ;
         A247LegFecUltMod = T005K26_A247LegFecUltMod[0] ;
         A238LegCuentaBanc = T005K26_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = T005K26_n238LegCuentaBanc[0] ;
         A253LegLicInicio = T005K26_A253LegLicInicio[0] ;
         n253LegLicInicio = T005K26_n253LegLicInicio[0] ;
         A252LegLicFinal = T005K26_A252LegLicFinal[0] ;
         n252LegLicFinal = T005K26_n252LegLicFinal[0] ;
         A342ZonDescrip = T005K26_A342ZonDescrip[0] ;
         A343ZonPorcReduc = T005K26_A343ZonPorcReduc[0] ;
         A234LegCBU = T005K26_A234LegCBU[0] ;
         n234LegCBU = T005K26_n234LegCBU[0] ;
         A262LegSCVO = T005K26_A262LegSCVO[0] ;
         A144CondiDescri = T005K26_A144CondiDescri[0] ;
         A333SinieDescri = T005K26_A333SinieDescri[0] ;
         A228LegActivo = T005K26_A228LegActivo[0] ;
         A264LegSueldoFuera = T005K26_A264LegSueldoFuera[0] ;
         A93LegId = T005K26_A93LegId[0] ;
         n93LegId = T005K26_n93LegId[0] ;
         A937LegConveCodigo = T005K26_A937LegConveCodigo[0] ;
         n937LegConveCodigo = T005K26_n937LegConveCodigo[0] ;
         A306OsoC3992 = T005K26_A306OsoC3992[0] ;
         n306OsoC3992 = T005K26_n306OsoC3992[0] ;
         A515LegObs = T005K26_A515LegObs[0] ;
         A630LegFecImportacion = T005K26_A630LegFecImportacion[0] ;
         A877LegAgenReten = T005K26_A877LegAgenReten[0] ;
         A879LegContinua = T005K26_A879LegContinua[0] ;
         A942LegRecalcLiq = T005K26_A942LegRecalcLiq[0] ;
         A1016LegJubilado = T005K26_A1016LegJubilado[0] ;
         A1023LegHorasDia = T005K26_A1023LegHorasDia[0] ;
         A1268LegHorasSem = T005K26_A1268LegHorasSem[0] ;
         A1245LegTrabLun = T005K26_A1245LegTrabLun[0] ;
         A1246LegTrabMar = T005K26_A1246LegTrabMar[0] ;
         A1247LegTrabMie = T005K26_A1247LegTrabMie[0] ;
         A1248LegTrabJue = T005K26_A1248LegTrabJue[0] ;
         A1249LegTrabVie = T005K26_A1249LegTrabVie[0] ;
         A1250LegTrabSa = T005K26_A1250LegTrabSa[0] ;
         A1251LegTrabDo = T005K26_A1251LegTrabDo[0] ;
         A1523LegVacPend = T005K26_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = T005K26_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = T005K26_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = T005K26_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = T005K26_A1759LegPromDias[0] ;
         A1804LegTitulo = T005K26_A1804LegTitulo[0] ;
         A1818LegEstado = T005K26_A1818LegEstado[0] ;
         A2267LegIncompleto = T005K26_A2267LegIncompleto[0] ;
         A1031LegFotoExt = T005K26_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = T005K26_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A392OsoSigla = T005K26_A392OsoSigla[0] ;
         n392OsoSigla = T005K26_n392OsoSigla[0] ;
         A1582LegBanCod = T005K26_A1582LegBanCod[0] ;
         n1582LegBanCod = T005K26_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = T005K26_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = T005K26_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = T005K26_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = T005K26_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = T005K26_A1580LegOsoCod[0] ;
         n1580LegOsoCod = T005K26_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = T005K26_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = T005K26_n1579LegSecCodigo[0] ;
         A1577LegSucCodigo = T005K26_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = T005K26_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = T005K26_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = T005K26_n1578LegPuesCodigo[0] ;
         A18MprCod = T005K26_A18MprCod[0] ;
         n18MprCod = T005K26_n18MprCod[0] ;
         A20ZonCod = T005K26_A20ZonCod[0] ;
         n20ZonCod = T005K26_n20ZonCod[0] ;
         A17CondiCodigo = T005K26_A17CondiCodigo[0] ;
         n17CondiCodigo = T005K26_n17CondiCodigo[0] ;
         A19SinieCodigo = T005K26_A19SinieCodigo[0] ;
         n19SinieCodigo = T005K26_n19SinieCodigo[0] ;
         A263LegSexo = T005K26_A263LegSexo[0] ;
         n263LegSexo = T005K26_n263LegSexo[0] ;
         A243LegEstadoCivil = T005K26_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = T005K26_n243LegEstadoCivil[0] ;
         A22LegPaiCod = T005K26_A22LegPaiCod[0] ;
         n22LegPaiCod = T005K26_n22LegPaiCod[0] ;
         A23LegProvCod = T005K26_A23LegProvCod[0] ;
         n23LegProvCod = T005K26_n23LegProvCod[0] ;
         A24LegLocCod = T005K26_A24LegLocCod[0] ;
         n24LegLocCod = T005K26_n24LegLocCod[0] ;
         A21LegNacionCod = T005K26_A21LegNacionCod[0] ;
         n21LegNacionCod = T005K26_n21LegNacionCod[0] ;
         A910LegSinCod = T005K26_A910LegSinCod[0] ;
         n910LegSinCod = T005K26_n910LegSinCod[0] ;
         zm5K23( -62) ;
      }
      pr_default.close(24);
      onLoadActions5K23( ) ;
   }

   public void onLoadActions5K23( )
   {
      AV39Pgmname = "Legajos" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Pgmname", AV39Pgmname);
      GXt_char4 = A677LpgDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A677LpgDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
      GXt_char4 = A675SecDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A675SecDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               A555OsoSiglaYDesc = A307OsoDescrip ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
         }
      }
      A591LegNomApe = GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A591LegNomApe", A591LegNomApe);
      A250LegIdNomApe = GXutil.trim( A93LegId) + " - " + GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250LegIdNomApe", A250LegIdNomApe);
      if ( ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
      {
         A237LegConvenio = true ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237LegConvenio", A237LegConvenio);
      }
      else
      {
         A237LegConvenio = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237LegConvenio", A237LegConvenio);
      }
      GXt_char4 = A680SinDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A680SinDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
   }

   public void checkExtendedTable5K23( )
   {
      nIsDirty_23 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV39Pgmname = "Legajos" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Pgmname", AV39Pgmname);
      /* Using cursor T005K4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1582LegBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Banco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGBANCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      /* Using cursor T005K5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1581LegLpgCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Lugar Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLPGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A291LpgDescri = T005K5_A291LpgDescri[0] ;
      n291LpgDescri = T005K5_n291LpgDescri[0] ;
      pr_default.close(3);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A677LpgDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A677LpgDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
      /* Using cursor T005K6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1583LegMegCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGMEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A300MegDescrip = T005K6_A300MegDescrip[0] ;
      n300MegDescrip = T005K6_n300MegDescrip[0] ;
      pr_default.close(4);
      /* Using cursor T005K7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1580LegOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGOSOCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A392OsoSigla = T005K7_A392OsoSigla[0] ;
      n392OsoSigla = T005K7_n392OsoSigla[0] ;
      pr_default.close(5);
      /* Using cursor T005K8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSECCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A329SecDescrip = T005K8_A329SecDescrip[0] ;
      n329SecDescrip = T005K8_n329SecDescrip[0] ;
      pr_default.close(6);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A675SecDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A675SecDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
      /* Using cursor T005K11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) || (GXutil.strcmp("", A1578LegPuesCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Puesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPUESCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(9);
      /* Using cursor T005K9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A45TipEmpleCod = T005K9_A45TipEmpleCod[0] ;
      n45TipEmpleCod = T005K9_n45TipEmpleCod[0] ;
      A1965EmpOsoCod = T005K9_A1965EmpOsoCod[0] ;
      n1965EmpOsoCod = T005K9_n1965EmpOsoCod[0] ;
      A2EmpNom = T005K9_A2EmpNom[0] ;
      pr_default.close(7);
      /* Using cursor T005K25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A307OsoDescrip = T005K25_A307OsoDescrip[0] ;
      n307OsoDescrip = T005K25_n307OsoDescrip[0] ;
      A306OsoC3992 = T005K25_A306OsoC3992[0] ;
      n306OsoC3992 = T005K25_n306OsoC3992[0] ;
      pr_default.close(23);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         nIsDirty_23 = (short)(1) ;
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            nIsDirty_23 = (short)(1) ;
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               nIsDirty_23 = (short)(1) ;
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               nIsDirty_23 = (short)(1) ;
               A555OsoSiglaYDesc = A307OsoDescrip ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
         }
      }
      /* Using cursor T005K10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (GXutil.strcmp("", A1577LegSucCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sucursal", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSUCCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(8);
      nIsDirty_23 = (short)(1) ;
      A591LegNomApe = GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A591LegNomApe", A591LegNomApe);
      nIsDirty_23 = (short)(1) ;
      A250LegIdNomApe = GXutil.trim( A93LegId) + " - " + GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250LegIdNomApe", A250LegIdNomApe);
      if ( ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
      {
         nIsDirty_23 = (short)(1) ;
         A237LegConvenio = true ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237LegConvenio", A237LegConvenio);
      }
      else
      {
         nIsDirty_23 = (short)(1) ;
         A237LegConvenio = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237LegConvenio", A237LegConvenio);
      }
      /* Using cursor T005K12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A18MprCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Modalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MPRCOD");
            AnyError = (short)(1) ;
         }
      }
      A684MprDescripSinAc = T005K12_A684MprDescripSinAc[0] ;
      A303MprDescrip = T005K12_A303MprDescrip[0] ;
      pr_default.close(10);
      /* Using cursor T005K13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A20ZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A678ZonDescripSinAc = T005K13_A678ZonDescripSinAc[0] ;
      A342ZonDescrip = T005K13_A342ZonDescrip[0] ;
      A343ZonPorcReduc = T005K13_A343ZonPorcReduc[0] ;
      pr_default.close(11);
      /* Using cursor T005K14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A17CondiCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICODIGO");
            AnyError = (short)(1) ;
         }
      }
      A686CondiDescriSinAc = T005K14_A686CondiDescriSinAc[0] ;
      A144CondiDescri = T005K14_A144CondiDescri[0] ;
      pr_default.close(12);
      /* Using cursor T005K15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A19SinieCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Siniestrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SINIECODIGO");
            AnyError = (short)(1) ;
         }
      }
      A688SinieDescriSinAc = T005K15_A688SinieDescriSinAc[0] ;
      A333SinieDescri = T005K15_A333SinieDescri[0] ;
      pr_default.close(13);
      /* Using cursor T005K16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A263LegSexo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sexo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSEXO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(14);
      /* Using cursor T005K17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A243LegEstadoCivil) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Estado Civil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGESTADOCIVIL");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(15);
      /* Using cursor T005K18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPAICOD");
            AnyError = (short)(1) ;
         }
      }
      A258LegPaiNom = T005K18_A258LegPaiNom[0] ;
      pr_default.close(16);
      /* Using cursor T005K19 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A260LegProvNom = T005K19_A260LegProvNom[0] ;
      pr_default.close(17);
      /* Using cursor T005K20 */
      pr_default.execute(18, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) || (0==A24LegLocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A255LegLocNom = T005K20_A255LegLocNom[0] ;
      pr_default.close(18);
      /* Using cursor T005K22 */
      pr_default.execute(20, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (GXutil.strcmp("", A910LegSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sindicato", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSINCOD");
            AnyError = (short)(1) ;
         }
      }
      A331SinDescrip = T005K22_A331SinDescrip[0] ;
      n331SinDescrip = T005K22_n331SinDescrip[0] ;
      pr_default.close(20);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A680SinDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A680SinDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
      /* Using cursor T005K21 */
      pr_default.execute(19, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (0==A21LegNacionCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Nacionalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNACIONCOD");
            AnyError = (short)(1) ;
         }
      }
      A256LegNacionalidad = T005K21_A256LegNacionalidad[0] ;
      pr_default.close(19);
      /* Using cursor T005K23 */
      pr_default.execute(21, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
      if ( (pr_default.getStatus(21) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A15LegActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A227LegActDescri = T005K23_A227LegActDescri[0] ;
      pr_default.close(21);
      /* Using cursor T005K24 */
      pr_default.execute(22, new Object[] {Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         if ( ! ( (0==A1603LegSitRevEgreso) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Situacion Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSITREVEGRESO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(22);
   }

   public void closeExtendedTableCursors5K23( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(9);
      pr_default.close(7);
      pr_default.close(23);
      pr_default.close(8);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
      pr_default.close(15);
      pr_default.close(16);
      pr_default.close(17);
      pr_default.close(18);
      pr_default.close(20);
      pr_default.close(19);
      pr_default.close(21);
      pr_default.close(22);
   }

   public void enableDisable( )
   {
   }

   public void gxload_63( int A3CliCod ,
                          String A1582LegBanCod )
   {
      /* Using cursor T005K27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod});
      if ( (pr_default.getStatus(25) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1582LegBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Banco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGBANCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(25) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(25);
   }

   public void gxload_64( int A3CliCod ,
                          String A1581LegLpgCodigo )
   {
      /* Using cursor T005K28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
      if ( (pr_default.getStatus(26) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1581LegLpgCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Lugar Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLPGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A291LpgDescri = T005K28_A291LpgDescri[0] ;
      n291LpgDescri = T005K28_n291LpgDescri[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A291LpgDescri)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(26) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(26);
   }

   public void gxload_65( int A3CliCod ,
                          String A1583LegMegCodigo )
   {
      /* Using cursor T005K29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
      if ( (pr_default.getStatus(27) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1583LegMegCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGMEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A300MegDescrip = T005K29_A300MegDescrip[0] ;
      n300MegDescrip = T005K29_n300MegDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A300MegDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(27) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(27);
   }

   public void gxload_66( int A3CliCod ,
                          String A1580LegOsoCod )
   {
      /* Using cursor T005K30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
      if ( (pr_default.getStatus(28) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1580LegOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGOSOCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A392OsoSigla = T005K30_A392OsoSigla[0] ;
      n392OsoSigla = T005K30_n392OsoSigla[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A392OsoSigla))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(28) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(28);
   }

   public void gxload_67( int A3CliCod ,
                          String A1579LegSecCodigo )
   {
      /* Using cursor T005K31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
      if ( (pr_default.getStatus(29) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSECCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A329SecDescrip = T005K31_A329SecDescrip[0] ;
      n329SecDescrip = T005K31_n329SecDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A329SecDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(29) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(29);
   }

   public void gxload_70( int A3CliCod ,
                          String A1579LegSecCodigo ,
                          String A1578LegPuesCodigo )
   {
      /* Using cursor T005K32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo});
      if ( (pr_default.getStatus(30) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) || (GXutil.strcmp("", A1578LegPuesCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Puesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPUESCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(30) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(30);
   }

   public void gxload_68( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T005K33 */
      pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(31) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A45TipEmpleCod = T005K33_A45TipEmpleCod[0] ;
      n45TipEmpleCod = T005K33_n45TipEmpleCod[0] ;
      A1965EmpOsoCod = T005K33_A1965EmpOsoCod[0] ;
      n1965EmpOsoCod = T005K33_n1965EmpOsoCod[0] ;
      A2EmpNom = T005K33_A2EmpNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1965EmpOsoCod))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A2EmpNom)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A45TipEmpleCod))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(31) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(31);
   }

   public void gxload_84( int A3CliCod ,
                          String A1965EmpOsoCod )
   {
      /* Using cursor T005K34 */
      pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(32) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A307OsoDescrip = T005K34_A307OsoDescrip[0] ;
      n307OsoDescrip = T005K34_n307OsoDescrip[0] ;
      A306OsoC3992 = T005K34_A306OsoC3992[0] ;
      n306OsoC3992 = T005K34_n306OsoC3992[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A307OsoDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A306OsoC3992))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(32) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(32);
   }

   public void gxload_69( int A3CliCod ,
                          short A1EmpCod ,
                          String A1577LegSucCodigo )
   {
      /* Using cursor T005K35 */
      pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo});
      if ( (pr_default.getStatus(33) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (GXutil.strcmp("", A1577LegSucCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sucursal", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSUCCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(33) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(33);
   }

   public void gxload_71( String A18MprCod )
   {
      /* Using cursor T005K36 */
      pr_default.execute(34, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(34) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A18MprCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Modalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MPRCOD");
            AnyError = (short)(1) ;
         }
      }
      A684MprDescripSinAc = T005K36_A684MprDescripSinAc[0] ;
      A303MprDescrip = T005K36_A303MprDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A684MprDescripSinAc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A303MprDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(34) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(34);
   }

   public void gxload_72( String A20ZonCod )
   {
      /* Using cursor T005K37 */
      pr_default.execute(35, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(35) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A20ZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A678ZonDescripSinAc = T005K37_A678ZonDescripSinAc[0] ;
      A342ZonDescrip = T005K37_A342ZonDescrip[0] ;
      A343ZonPorcReduc = T005K37_A343ZonPorcReduc[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A678ZonDescripSinAc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A342ZonDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A343ZonPorcReduc, (byte)(6), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(35) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(35);
   }

   public void gxload_73( short A17CondiCodigo )
   {
      /* Using cursor T005K38 */
      pr_default.execute(36, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(36) == 101) )
      {
         if ( ! ( (0==A17CondiCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICODIGO");
            AnyError = (short)(1) ;
         }
      }
      A686CondiDescriSinAc = T005K38_A686CondiDescriSinAc[0] ;
      A144CondiDescri = T005K38_A144CondiDescri[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A686CondiDescriSinAc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A144CondiDescri)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(36) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(36);
   }

   public void gxload_74( String A19SinieCodigo )
   {
      /* Using cursor T005K39 */
      pr_default.execute(37, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(37) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A19SinieCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Siniestrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SINIECODIGO");
            AnyError = (short)(1) ;
         }
      }
      A688SinieDescriSinAc = T005K39_A688SinieDescriSinAc[0] ;
      A333SinieDescri = T005K39_A333SinieDescri[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A688SinieDescriSinAc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A333SinieDescri)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(37) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(37);
   }

   public void gxload_75( byte A263LegSexo )
   {
      /* Using cursor T005K40 */
      pr_default.execute(38, new Object[] {Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo)});
      if ( (pr_default.getStatus(38) == 101) )
      {
         if ( ! ( (0==A263LegSexo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sexo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSEXO");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(38) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(38);
   }

   public void gxload_76( short A243LegEstadoCivil )
   {
      /* Using cursor T005K41 */
      pr_default.execute(39, new Object[] {Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil)});
      if ( (pr_default.getStatus(39) == 101) )
      {
         if ( ! ( (0==A243LegEstadoCivil) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Estado Civil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGESTADOCIVIL");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(39) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(39);
   }

   public void gxload_77( short A22LegPaiCod )
   {
      /* Using cursor T005K42 */
      pr_default.execute(40, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
      if ( (pr_default.getStatus(40) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPAICOD");
            AnyError = (short)(1) ;
         }
      }
      A258LegPaiNom = T005K42_A258LegPaiNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A258LegPaiNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(40) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(40);
   }

   public void gxload_78( short A22LegPaiCod ,
                          short A23LegProvCod )
   {
      /* Using cursor T005K43 */
      pr_default.execute(41, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
      if ( (pr_default.getStatus(41) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A260LegProvNom = T005K43_A260LegProvNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A260LegProvNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(41) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(41);
   }

   public void gxload_79( short A22LegPaiCod ,
                          short A23LegProvCod ,
                          short A24LegLocCod )
   {
      /* Using cursor T005K44 */
      pr_default.execute(42, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) || (0==A24LegLocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A255LegLocNom = T005K44_A255LegLocNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A255LegLocNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(42) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(42);
   }

   public void gxload_81( short A22LegPaiCod ,
                          String A910LegSinCod )
   {
      /* Using cursor T005K45 */
      pr_default.execute(43, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
      if ( (pr_default.getStatus(43) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (GXutil.strcmp("", A910LegSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sindicato", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSINCOD");
            AnyError = (short)(1) ;
         }
      }
      A331SinDescrip = T005K45_A331SinDescrip[0] ;
      n331SinDescrip = T005K45_n331SinDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A331SinDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(43) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(43);
   }

   public void gxload_80( short A21LegNacionCod )
   {
      /* Using cursor T005K46 */
      pr_default.execute(44, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
      if ( (pr_default.getStatus(44) == 101) )
      {
         if ( ! ( (0==A21LegNacionCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Nacionalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNACIONCOD");
            AnyError = (short)(1) ;
         }
      }
      A256LegNacionalidad = T005K46_A256LegNacionalidad[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A256LegNacionalidad)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(44) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(44);
   }

   public void gxload_82( String A15LegActCodigo )
   {
      /* Using cursor T005K47 */
      pr_default.execute(45, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
      if ( (pr_default.getStatus(45) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A15LegActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A227LegActDescri = T005K47_A227LegActDescri[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A227LegActDescri)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(45) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(45);
   }

   public void gxload_83( short A1603LegSitRevEgreso )
   {
      /* Using cursor T005K48 */
      pr_default.execute(46, new Object[] {Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso)});
      if ( (pr_default.getStatus(46) == 101) )
      {
         if ( ! ( (0==A1603LegSitRevEgreso) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Situacion Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSITREVEGRESO");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(46) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(46);
   }

   public void getKey5K23( )
   {
      /* Using cursor T005K49 */
      pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(47) != 101) )
      {
         RcdFound23 = (short)(1) ;
      }
      else
      {
         RcdFound23 = (short)(0) ;
      }
      pr_default.close(47);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005K3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5K23( 62) ;
         RcdFound23 = (short)(1) ;
         A15LegActCodigo = T005K3_A15LegActCodigo[0] ;
         n15LegActCodigo = T005K3_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = T005K3_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = T005K3_n1603LegSitRevEgreso[0] ;
         A1235LegReligion = T005K3_A1235LegReligion[0] ;
         n1235LegReligion = T005K3_n1235LegReligion[0] ;
         A1236LegOrigen = T005K3_A1236LegOrigen[0] ;
         n1236LegOrigen = T005K3_n1236LegOrigen[0] ;
         A237LegConvenio = T005K3_A237LegConvenio[0] ;
         A250LegIdNomApe = T005K3_A250LegIdNomApe[0] ;
         A591LegNomApe = T005K3_A591LegNomApe[0] ;
         A6LegNumero = T005K3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A230LegApellido = T005K3_A230LegApellido[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
         A251LegNombre = T005K3_A251LegNombre[0] ;
         A249LegFoto = T005K3_A249LegFoto[0] ;
         n249LegFoto = T005K3_n249LegFoto[0] ;
         A266LegTipDoc = T005K3_A266LegTipDoc[0] ;
         A257LegNumDoc = T005K3_A257LegNumDoc[0] ;
         A246LegFecNac = T005K3_A246LegFecNac[0] ;
         A239LegCUIL = T005K3_A239LegCUIL[0] ;
         A241LegDiscapacidad = T005K3_A241LegDiscapacidad[0] ;
         A242LegDomici = T005K3_A242LegDomici[0] ;
         A479LegEmail = T005K3_A479LegEmail[0] ;
         A236LegCodPos = T005K3_A236LegCodPos[0] ;
         A265LegTelefono = T005K3_A265LegTelefono[0] ;
         n265LegTelefono = T005K3_n265LegTelefono[0] ;
         A245LegFecIngreso = T005K3_A245LegFecIngreso[0] ;
         A244LegFecEgreso = T005K3_A244LegFecEgreso[0] ;
         n244LegFecEgreso = T005K3_n244LegFecEgreso[0] ;
         A939LegCatCodigo = T005K3_A939LegCatCodigo[0] ;
         n939LegCatCodigo = T005K3_n939LegCatCodigo[0] ;
         A235LegClase = T005K3_A235LegClase[0] ;
         A248LegFormaPago = T005K3_A248LegFormaPago[0] ;
         A231LegBanSuc = T005K3_A231LegBanSuc[0] ;
         n231LegBanSuc = T005K3_n231LegBanSuc[0] ;
         A232LegBanTipCuen = T005K3_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = T005K3_n232LegBanTipCuen[0] ;
         A247LegFecUltMod = T005K3_A247LegFecUltMod[0] ;
         A238LegCuentaBanc = T005K3_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = T005K3_n238LegCuentaBanc[0] ;
         A253LegLicInicio = T005K3_A253LegLicInicio[0] ;
         n253LegLicInicio = T005K3_n253LegLicInicio[0] ;
         A252LegLicFinal = T005K3_A252LegLicFinal[0] ;
         n252LegLicFinal = T005K3_n252LegLicFinal[0] ;
         A234LegCBU = T005K3_A234LegCBU[0] ;
         n234LegCBU = T005K3_n234LegCBU[0] ;
         A262LegSCVO = T005K3_A262LegSCVO[0] ;
         A228LegActivo = T005K3_A228LegActivo[0] ;
         A264LegSueldoFuera = T005K3_A264LegSueldoFuera[0] ;
         A93LegId = T005K3_A93LegId[0] ;
         n93LegId = T005K3_n93LegId[0] ;
         A937LegConveCodigo = T005K3_A937LegConveCodigo[0] ;
         n937LegConveCodigo = T005K3_n937LegConveCodigo[0] ;
         A515LegObs = T005K3_A515LegObs[0] ;
         A630LegFecImportacion = T005K3_A630LegFecImportacion[0] ;
         A877LegAgenReten = T005K3_A877LegAgenReten[0] ;
         A879LegContinua = T005K3_A879LegContinua[0] ;
         A942LegRecalcLiq = T005K3_A942LegRecalcLiq[0] ;
         A1016LegJubilado = T005K3_A1016LegJubilado[0] ;
         A1023LegHorasDia = T005K3_A1023LegHorasDia[0] ;
         A1268LegHorasSem = T005K3_A1268LegHorasSem[0] ;
         A1245LegTrabLun = T005K3_A1245LegTrabLun[0] ;
         A1246LegTrabMar = T005K3_A1246LegTrabMar[0] ;
         A1247LegTrabMie = T005K3_A1247LegTrabMie[0] ;
         A1248LegTrabJue = T005K3_A1248LegTrabJue[0] ;
         A1249LegTrabVie = T005K3_A1249LegTrabVie[0] ;
         A1250LegTrabSa = T005K3_A1250LegTrabSa[0] ;
         A1251LegTrabDo = T005K3_A1251LegTrabDo[0] ;
         A1523LegVacPend = T005K3_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = T005K3_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = T005K3_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = T005K3_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = T005K3_A1759LegPromDias[0] ;
         A1804LegTitulo = T005K3_A1804LegTitulo[0] ;
         A1818LegEstado = T005K3_A1818LegEstado[0] ;
         A2267LegIncompleto = T005K3_A2267LegIncompleto[0] ;
         A1031LegFotoExt = T005K3_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = T005K3_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A3CliCod = T005K3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1582LegBanCod = T005K3_A1582LegBanCod[0] ;
         n1582LegBanCod = T005K3_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = T005K3_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = T005K3_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = T005K3_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = T005K3_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = T005K3_A1580LegOsoCod[0] ;
         n1580LegOsoCod = T005K3_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = T005K3_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = T005K3_n1579LegSecCodigo[0] ;
         A1EmpCod = T005K3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1577LegSucCodigo = T005K3_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = T005K3_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = T005K3_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = T005K3_n1578LegPuesCodigo[0] ;
         A18MprCod = T005K3_A18MprCod[0] ;
         n18MprCod = T005K3_n18MprCod[0] ;
         A20ZonCod = T005K3_A20ZonCod[0] ;
         n20ZonCod = T005K3_n20ZonCod[0] ;
         A17CondiCodigo = T005K3_A17CondiCodigo[0] ;
         n17CondiCodigo = T005K3_n17CondiCodigo[0] ;
         A19SinieCodigo = T005K3_A19SinieCodigo[0] ;
         n19SinieCodigo = T005K3_n19SinieCodigo[0] ;
         A263LegSexo = T005K3_A263LegSexo[0] ;
         n263LegSexo = T005K3_n263LegSexo[0] ;
         A243LegEstadoCivil = T005K3_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = T005K3_n243LegEstadoCivil[0] ;
         A22LegPaiCod = T005K3_A22LegPaiCod[0] ;
         n22LegPaiCod = T005K3_n22LegPaiCod[0] ;
         A23LegProvCod = T005K3_A23LegProvCod[0] ;
         n23LegProvCod = T005K3_n23LegProvCod[0] ;
         A24LegLocCod = T005K3_A24LegLocCod[0] ;
         n24LegLocCod = T005K3_n24LegLocCod[0] ;
         A21LegNacionCod = T005K3_A21LegNacionCod[0] ;
         n21LegNacionCod = T005K3_n21LegNacionCod[0] ;
         A910LegSinCod = T005K3_A910LegSinCod[0] ;
         n910LegSinCod = T005K3_n910LegSinCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         load5K23( ) ;
         if ( AnyError == 1 )
         {
            RcdFound23 = (short)(0) ;
            initializeNonKey5K23( ) ;
         }
         Gx_mode = sMode23 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound23 = (short)(0) ;
         initializeNonKey5K23( ) ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode23 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5K23( ) ;
      if ( RcdFound23 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound23 = (short)(0) ;
      /* Using cursor T005K50 */
      pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(48) != 101) )
      {
         while ( (pr_default.getStatus(48) != 101) && ( ( T005K50_A3CliCod[0] < A3CliCod ) || ( T005K50_A3CliCod[0] == A3CliCod ) && ( T005K50_A1EmpCod[0] < A1EmpCod ) || ( T005K50_A1EmpCod[0] == A1EmpCod ) && ( T005K50_A3CliCod[0] == A3CliCod ) && ( T005K50_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(48);
         }
         if ( (pr_default.getStatus(48) != 101) && ( ( T005K50_A3CliCod[0] > A3CliCod ) || ( T005K50_A3CliCod[0] == A3CliCod ) && ( T005K50_A1EmpCod[0] > A1EmpCod ) || ( T005K50_A1EmpCod[0] == A1EmpCod ) && ( T005K50_A3CliCod[0] == A3CliCod ) && ( T005K50_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A3CliCod = T005K50_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005K50_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T005K50_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound23 = (short)(1) ;
         }
      }
      pr_default.close(48);
   }

   public void move_previous( )
   {
      RcdFound23 = (short)(0) ;
      /* Using cursor T005K51 */
      pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(49) != 101) )
      {
         while ( (pr_default.getStatus(49) != 101) && ( ( T005K51_A3CliCod[0] > A3CliCod ) || ( T005K51_A3CliCod[0] == A3CliCod ) && ( T005K51_A1EmpCod[0] > A1EmpCod ) || ( T005K51_A1EmpCod[0] == A1EmpCod ) && ( T005K51_A3CliCod[0] == A3CliCod ) && ( T005K51_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(49);
         }
         if ( (pr_default.getStatus(49) != 101) && ( ( T005K51_A3CliCod[0] < A3CliCod ) || ( T005K51_A3CliCod[0] == A3CliCod ) && ( T005K51_A1EmpCod[0] < A1EmpCod ) || ( T005K51_A1EmpCod[0] == A1EmpCod ) && ( T005K51_A3CliCod[0] == A3CliCod ) && ( T005K51_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A3CliCod = T005K51_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T005K51_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T005K51_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound23 = (short)(1) ;
         }
      }
      pr_default.close(49);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5K23( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         insert5K23( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound23 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5K23( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               insert5K23( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  insert5K23( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5K23( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005K2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z237LegConvenio != T005K2_A237LegConvenio[0] ) || ( GXutil.strcmp(Z250LegIdNomApe, T005K2_A250LegIdNomApe[0]) != 0 ) || ( GXutil.strcmp(Z591LegNomApe, T005K2_A591LegNomApe[0]) != 0 ) || ( GXutil.strcmp(Z230LegApellido, T005K2_A230LegApellido[0]) != 0 ) || ( GXutil.strcmp(Z251LegNombre, T005K2_A251LegNombre[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z266LegTipDoc != T005K2_A266LegTipDoc[0] ) || ( GXutil.strcmp(Z257LegNumDoc, T005K2_A257LegNumDoc[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z246LegFecNac), GXutil.resetTime(T005K2_A246LegFecNac[0])) ) || ( Z239LegCUIL != T005K2_A239LegCUIL[0] ) || ( Z241LegDiscapacidad != T005K2_A241LegDiscapacidad[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z242LegDomici, T005K2_A242LegDomici[0]) != 0 ) || ( GXutil.strcmp(Z479LegEmail, T005K2_A479LegEmail[0]) != 0 ) || ( GXutil.strcmp(Z236LegCodPos, T005K2_A236LegCodPos[0]) != 0 ) || ( GXutil.strcmp(Z265LegTelefono, T005K2_A265LegTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z245LegFecIngreso), GXutil.resetTime(T005K2_A245LegFecIngreso[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z244LegFecEgreso), GXutil.resetTime(T005K2_A244LegFecEgreso[0])) ) || ( GXutil.strcmp(Z939LegCatCodigo, T005K2_A939LegCatCodigo[0]) != 0 ) || ( Z235LegClase != T005K2_A235LegClase[0] ) || ( Z248LegFormaPago != T005K2_A248LegFormaPago[0] ) || ( GXutil.strcmp(Z231LegBanSuc, T005K2_A231LegBanSuc[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z232LegBanTipCuen, T005K2_A232LegBanTipCuen[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z247LegFecUltMod), GXutil.resetTime(T005K2_A247LegFecUltMod[0])) ) || ( GXutil.strcmp(Z238LegCuentaBanc, T005K2_A238LegCuentaBanc[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z253LegLicInicio), GXutil.resetTime(T005K2_A253LegLicInicio[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z252LegLicFinal), GXutil.resetTime(T005K2_A252LegLicFinal[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z234LegCBU, T005K2_A234LegCBU[0]) != 0 ) || ( Z262LegSCVO != T005K2_A262LegSCVO[0] ) || ( Z228LegActivo != T005K2_A228LegActivo[0] ) || ( DecimalUtil.compareTo(Z264LegSueldoFuera, T005K2_A264LegSueldoFuera[0]) != 0 ) || ( GXutil.strcmp(Z93LegId, T005K2_A93LegId[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z937LegConveCodigo, T005K2_A937LegConveCodigo[0]) != 0 ) || !( GXutil.dateCompare(Z630LegFecImportacion, T005K2_A630LegFecImportacion[0]) ) || ( Z877LegAgenReten != T005K2_A877LegAgenReten[0] ) || ( GXutil.strcmp(Z879LegContinua, T005K2_A879LegContinua[0]) != 0 ) || ( Z942LegRecalcLiq != T005K2_A942LegRecalcLiq[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1016LegJubilado != T005K2_A1016LegJubilado[0] ) || ( DecimalUtil.compareTo(Z1023LegHorasDia, T005K2_A1023LegHorasDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1268LegHorasSem, T005K2_A1268LegHorasSem[0]) != 0 ) || ( Z1245LegTrabLun != T005K2_A1245LegTrabLun[0] ) || ( Z1246LegTrabMar != T005K2_A1246LegTrabMar[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1247LegTrabMie != T005K2_A1247LegTrabMie[0] ) || ( Z1248LegTrabJue != T005K2_A1248LegTrabJue[0] ) || ( Z1249LegTrabVie != T005K2_A1249LegTrabVie[0] ) || ( Z1250LegTrabSa != T005K2_A1250LegTrabSa[0] ) || ( Z1251LegTrabDo != T005K2_A1251LegTrabDo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1523LegVacPend != T005K2_A1523LegVacPend[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z1531LegFecPreAviso), GXutil.resetTime(T005K2_A1531LegFecPreAviso[0])) ) || ( Z1576LegConveVersionCli != T005K2_A1576LegConveVersionCli[0] ) || ( GXutil.strcmp(Z1759LegPromDias, T005K2_A1759LegPromDias[0]) != 0 ) || ( GXutil.strcmp(Z1804LegTitulo, T005K2_A1804LegTitulo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1818LegEstado != T005K2_A1818LegEstado[0] ) || ( Z2267LegIncompleto != T005K2_A2267LegIncompleto[0] ) || ( GXutil.strcmp(Z1582LegBanCod, T005K2_A1582LegBanCod[0]) != 0 ) || ( GXutil.strcmp(Z1581LegLpgCodigo, T005K2_A1581LegLpgCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1583LegMegCodigo, T005K2_A1583LegMegCodigo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1580LegOsoCod, T005K2_A1580LegOsoCod[0]) != 0 ) || ( GXutil.strcmp(Z1579LegSecCodigo, T005K2_A1579LegSecCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1577LegSucCodigo, T005K2_A1577LegSucCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1578LegPuesCodigo, T005K2_A1578LegPuesCodigo[0]) != 0 ) || ( GXutil.strcmp(Z18MprCod, T005K2_A18MprCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z20ZonCod, T005K2_A20ZonCod[0]) != 0 ) || ( Z17CondiCodigo != T005K2_A17CondiCodigo[0] ) || ( GXutil.strcmp(Z19SinieCodigo, T005K2_A19SinieCodigo[0]) != 0 ) || ( Z263LegSexo != T005K2_A263LegSexo[0] ) || ( Z243LegEstadoCivil != T005K2_A243LegEstadoCivil[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z22LegPaiCod != T005K2_A22LegPaiCod[0] ) || ( Z23LegProvCod != T005K2_A23LegProvCod[0] ) || ( Z24LegLocCod != T005K2_A24LegLocCod[0] ) || ( Z21LegNacionCod != T005K2_A21LegNacionCod[0] ) || ( GXutil.strcmp(Z910LegSinCod, T005K2_A910LegSinCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z15LegActCodigo, T005K2_A15LegActCodigo[0]) != 0 ) || ( Z1603LegSitRevEgreso != T005K2_A1603LegSitRevEgreso[0] ) || ( GXutil.strcmp(Z1235LegReligion, T005K2_A1235LegReligion[0]) != 0 ) || ( GXutil.strcmp(Z1236LegOrigen, T005K2_A1236LegOrigen[0]) != 0 ) )
         {
            if ( Z237LegConvenio != T005K2_A237LegConvenio[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegConvenio");
               GXutil.writeLogRaw("Old: ",Z237LegConvenio);
               GXutil.writeLogRaw("Current: ",T005K2_A237LegConvenio[0]);
            }
            if ( GXutil.strcmp(Z250LegIdNomApe, T005K2_A250LegIdNomApe[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegIdNomApe");
               GXutil.writeLogRaw("Old: ",Z250LegIdNomApe);
               GXutil.writeLogRaw("Current: ",T005K2_A250LegIdNomApe[0]);
            }
            if ( GXutil.strcmp(Z591LegNomApe, T005K2_A591LegNomApe[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegNomApe");
               GXutil.writeLogRaw("Old: ",Z591LegNomApe);
               GXutil.writeLogRaw("Current: ",T005K2_A591LegNomApe[0]);
            }
            if ( GXutil.strcmp(Z230LegApellido, T005K2_A230LegApellido[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegApellido");
               GXutil.writeLogRaw("Old: ",Z230LegApellido);
               GXutil.writeLogRaw("Current: ",T005K2_A230LegApellido[0]);
            }
            if ( GXutil.strcmp(Z251LegNombre, T005K2_A251LegNombre[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegNombre");
               GXutil.writeLogRaw("Old: ",Z251LegNombre);
               GXutil.writeLogRaw("Current: ",T005K2_A251LegNombre[0]);
            }
            if ( Z266LegTipDoc != T005K2_A266LegTipDoc[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTipDoc");
               GXutil.writeLogRaw("Old: ",Z266LegTipDoc);
               GXutil.writeLogRaw("Current: ",T005K2_A266LegTipDoc[0]);
            }
            if ( GXutil.strcmp(Z257LegNumDoc, T005K2_A257LegNumDoc[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegNumDoc");
               GXutil.writeLogRaw("Old: ",Z257LegNumDoc);
               GXutil.writeLogRaw("Current: ",T005K2_A257LegNumDoc[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z246LegFecNac), GXutil.resetTime(T005K2_A246LegFecNac[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecNac");
               GXutil.writeLogRaw("Old: ",Z246LegFecNac);
               GXutil.writeLogRaw("Current: ",T005K2_A246LegFecNac[0]);
            }
            if ( Z239LegCUIL != T005K2_A239LegCUIL[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegCUIL");
               GXutil.writeLogRaw("Old: ",Z239LegCUIL);
               GXutil.writeLogRaw("Current: ",T005K2_A239LegCUIL[0]);
            }
            if ( Z241LegDiscapacidad != T005K2_A241LegDiscapacidad[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegDiscapacidad");
               GXutil.writeLogRaw("Old: ",Z241LegDiscapacidad);
               GXutil.writeLogRaw("Current: ",T005K2_A241LegDiscapacidad[0]);
            }
            if ( GXutil.strcmp(Z242LegDomici, T005K2_A242LegDomici[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegDomici");
               GXutil.writeLogRaw("Old: ",Z242LegDomici);
               GXutil.writeLogRaw("Current: ",T005K2_A242LegDomici[0]);
            }
            if ( GXutil.strcmp(Z479LegEmail, T005K2_A479LegEmail[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegEmail");
               GXutil.writeLogRaw("Old: ",Z479LegEmail);
               GXutil.writeLogRaw("Current: ",T005K2_A479LegEmail[0]);
            }
            if ( GXutil.strcmp(Z236LegCodPos, T005K2_A236LegCodPos[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegCodPos");
               GXutil.writeLogRaw("Old: ",Z236LegCodPos);
               GXutil.writeLogRaw("Current: ",T005K2_A236LegCodPos[0]);
            }
            if ( GXutil.strcmp(Z265LegTelefono, T005K2_A265LegTelefono[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTelefono");
               GXutil.writeLogRaw("Old: ",Z265LegTelefono);
               GXutil.writeLogRaw("Current: ",T005K2_A265LegTelefono[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z245LegFecIngreso), GXutil.resetTime(T005K2_A245LegFecIngreso[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecIngreso");
               GXutil.writeLogRaw("Old: ",Z245LegFecIngreso);
               GXutil.writeLogRaw("Current: ",T005K2_A245LegFecIngreso[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z244LegFecEgreso), GXutil.resetTime(T005K2_A244LegFecEgreso[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecEgreso");
               GXutil.writeLogRaw("Old: ",Z244LegFecEgreso);
               GXutil.writeLogRaw("Current: ",T005K2_A244LegFecEgreso[0]);
            }
            if ( GXutil.strcmp(Z939LegCatCodigo, T005K2_A939LegCatCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegCatCodigo");
               GXutil.writeLogRaw("Old: ",Z939LegCatCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A939LegCatCodigo[0]);
            }
            if ( Z235LegClase != T005K2_A235LegClase[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegClase");
               GXutil.writeLogRaw("Old: ",Z235LegClase);
               GXutil.writeLogRaw("Current: ",T005K2_A235LegClase[0]);
            }
            if ( Z248LegFormaPago != T005K2_A248LegFormaPago[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFormaPago");
               GXutil.writeLogRaw("Old: ",Z248LegFormaPago);
               GXutil.writeLogRaw("Current: ",T005K2_A248LegFormaPago[0]);
            }
            if ( GXutil.strcmp(Z231LegBanSuc, T005K2_A231LegBanSuc[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegBanSuc");
               GXutil.writeLogRaw("Old: ",Z231LegBanSuc);
               GXutil.writeLogRaw("Current: ",T005K2_A231LegBanSuc[0]);
            }
            if ( GXutil.strcmp(Z232LegBanTipCuen, T005K2_A232LegBanTipCuen[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegBanTipCuen");
               GXutil.writeLogRaw("Old: ",Z232LegBanTipCuen);
               GXutil.writeLogRaw("Current: ",T005K2_A232LegBanTipCuen[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z247LegFecUltMod), GXutil.resetTime(T005K2_A247LegFecUltMod[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecUltMod");
               GXutil.writeLogRaw("Old: ",Z247LegFecUltMod);
               GXutil.writeLogRaw("Current: ",T005K2_A247LegFecUltMod[0]);
            }
            if ( GXutil.strcmp(Z238LegCuentaBanc, T005K2_A238LegCuentaBanc[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegCuentaBanc");
               GXutil.writeLogRaw("Old: ",Z238LegCuentaBanc);
               GXutil.writeLogRaw("Current: ",T005K2_A238LegCuentaBanc[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z253LegLicInicio), GXutil.resetTime(T005K2_A253LegLicInicio[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegLicInicio");
               GXutil.writeLogRaw("Old: ",Z253LegLicInicio);
               GXutil.writeLogRaw("Current: ",T005K2_A253LegLicInicio[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z252LegLicFinal), GXutil.resetTime(T005K2_A252LegLicFinal[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegLicFinal");
               GXutil.writeLogRaw("Old: ",Z252LegLicFinal);
               GXutil.writeLogRaw("Current: ",T005K2_A252LegLicFinal[0]);
            }
            if ( GXutil.strcmp(Z234LegCBU, T005K2_A234LegCBU[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegCBU");
               GXutil.writeLogRaw("Old: ",Z234LegCBU);
               GXutil.writeLogRaw("Current: ",T005K2_A234LegCBU[0]);
            }
            if ( Z262LegSCVO != T005K2_A262LegSCVO[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSCVO");
               GXutil.writeLogRaw("Old: ",Z262LegSCVO);
               GXutil.writeLogRaw("Current: ",T005K2_A262LegSCVO[0]);
            }
            if ( Z228LegActivo != T005K2_A228LegActivo[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegActivo");
               GXutil.writeLogRaw("Old: ",Z228LegActivo);
               GXutil.writeLogRaw("Current: ",T005K2_A228LegActivo[0]);
            }
            if ( DecimalUtil.compareTo(Z264LegSueldoFuera, T005K2_A264LegSueldoFuera[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSueldoFuera");
               GXutil.writeLogRaw("Old: ",Z264LegSueldoFuera);
               GXutil.writeLogRaw("Current: ",T005K2_A264LegSueldoFuera[0]);
            }
            if ( GXutil.strcmp(Z93LegId, T005K2_A93LegId[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegId");
               GXutil.writeLogRaw("Old: ",Z93LegId);
               GXutil.writeLogRaw("Current: ",T005K2_A93LegId[0]);
            }
            if ( GXutil.strcmp(Z937LegConveCodigo, T005K2_A937LegConveCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegConveCodigo");
               GXutil.writeLogRaw("Old: ",Z937LegConveCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A937LegConveCodigo[0]);
            }
            if ( !( GXutil.dateCompare(Z630LegFecImportacion, T005K2_A630LegFecImportacion[0]) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecImportacion");
               GXutil.writeLogRaw("Old: ",Z630LegFecImportacion);
               GXutil.writeLogRaw("Current: ",T005K2_A630LegFecImportacion[0]);
            }
            if ( Z877LegAgenReten != T005K2_A877LegAgenReten[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegAgenReten");
               GXutil.writeLogRaw("Old: ",Z877LegAgenReten);
               GXutil.writeLogRaw("Current: ",T005K2_A877LegAgenReten[0]);
            }
            if ( GXutil.strcmp(Z879LegContinua, T005K2_A879LegContinua[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegContinua");
               GXutil.writeLogRaw("Old: ",Z879LegContinua);
               GXutil.writeLogRaw("Current: ",T005K2_A879LegContinua[0]);
            }
            if ( Z942LegRecalcLiq != T005K2_A942LegRecalcLiq[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegRecalcLiq");
               GXutil.writeLogRaw("Old: ",Z942LegRecalcLiq);
               GXutil.writeLogRaw("Current: ",T005K2_A942LegRecalcLiq[0]);
            }
            if ( Z1016LegJubilado != T005K2_A1016LegJubilado[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegJubilado");
               GXutil.writeLogRaw("Old: ",Z1016LegJubilado);
               GXutil.writeLogRaw("Current: ",T005K2_A1016LegJubilado[0]);
            }
            if ( DecimalUtil.compareTo(Z1023LegHorasDia, T005K2_A1023LegHorasDia[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegHorasDia");
               GXutil.writeLogRaw("Old: ",Z1023LegHorasDia);
               GXutil.writeLogRaw("Current: ",T005K2_A1023LegHorasDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1268LegHorasSem, T005K2_A1268LegHorasSem[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegHorasSem");
               GXutil.writeLogRaw("Old: ",Z1268LegHorasSem);
               GXutil.writeLogRaw("Current: ",T005K2_A1268LegHorasSem[0]);
            }
            if ( Z1245LegTrabLun != T005K2_A1245LegTrabLun[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabLun");
               GXutil.writeLogRaw("Old: ",Z1245LegTrabLun);
               GXutil.writeLogRaw("Current: ",T005K2_A1245LegTrabLun[0]);
            }
            if ( Z1246LegTrabMar != T005K2_A1246LegTrabMar[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabMar");
               GXutil.writeLogRaw("Old: ",Z1246LegTrabMar);
               GXutil.writeLogRaw("Current: ",T005K2_A1246LegTrabMar[0]);
            }
            if ( Z1247LegTrabMie != T005K2_A1247LegTrabMie[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabMie");
               GXutil.writeLogRaw("Old: ",Z1247LegTrabMie);
               GXutil.writeLogRaw("Current: ",T005K2_A1247LegTrabMie[0]);
            }
            if ( Z1248LegTrabJue != T005K2_A1248LegTrabJue[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabJue");
               GXutil.writeLogRaw("Old: ",Z1248LegTrabJue);
               GXutil.writeLogRaw("Current: ",T005K2_A1248LegTrabJue[0]);
            }
            if ( Z1249LegTrabVie != T005K2_A1249LegTrabVie[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabVie");
               GXutil.writeLogRaw("Old: ",Z1249LegTrabVie);
               GXutil.writeLogRaw("Current: ",T005K2_A1249LegTrabVie[0]);
            }
            if ( Z1250LegTrabSa != T005K2_A1250LegTrabSa[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabSa");
               GXutil.writeLogRaw("Old: ",Z1250LegTrabSa);
               GXutil.writeLogRaw("Current: ",T005K2_A1250LegTrabSa[0]);
            }
            if ( Z1251LegTrabDo != T005K2_A1251LegTrabDo[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTrabDo");
               GXutil.writeLogRaw("Old: ",Z1251LegTrabDo);
               GXutil.writeLogRaw("Current: ",T005K2_A1251LegTrabDo[0]);
            }
            if ( Z1523LegVacPend != T005K2_A1523LegVacPend[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegVacPend");
               GXutil.writeLogRaw("Old: ",Z1523LegVacPend);
               GXutil.writeLogRaw("Current: ",T005K2_A1523LegVacPend[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1531LegFecPreAviso), GXutil.resetTime(T005K2_A1531LegFecPreAviso[0])) ) )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegFecPreAviso");
               GXutil.writeLogRaw("Old: ",Z1531LegFecPreAviso);
               GXutil.writeLogRaw("Current: ",T005K2_A1531LegFecPreAviso[0]);
            }
            if ( Z1576LegConveVersionCli != T005K2_A1576LegConveVersionCli[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegConveVersionCli");
               GXutil.writeLogRaw("Old: ",Z1576LegConveVersionCli);
               GXutil.writeLogRaw("Current: ",T005K2_A1576LegConveVersionCli[0]);
            }
            if ( GXutil.strcmp(Z1759LegPromDias, T005K2_A1759LegPromDias[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegPromDias");
               GXutil.writeLogRaw("Old: ",Z1759LegPromDias);
               GXutil.writeLogRaw("Current: ",T005K2_A1759LegPromDias[0]);
            }
            if ( GXutil.strcmp(Z1804LegTitulo, T005K2_A1804LegTitulo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegTitulo");
               GXutil.writeLogRaw("Old: ",Z1804LegTitulo);
               GXutil.writeLogRaw("Current: ",T005K2_A1804LegTitulo[0]);
            }
            if ( Z1818LegEstado != T005K2_A1818LegEstado[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegEstado");
               GXutil.writeLogRaw("Old: ",Z1818LegEstado);
               GXutil.writeLogRaw("Current: ",T005K2_A1818LegEstado[0]);
            }
            if ( Z2267LegIncompleto != T005K2_A2267LegIncompleto[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegIncompleto");
               GXutil.writeLogRaw("Old: ",Z2267LegIncompleto);
               GXutil.writeLogRaw("Current: ",T005K2_A2267LegIncompleto[0]);
            }
            if ( GXutil.strcmp(Z1582LegBanCod, T005K2_A1582LegBanCod[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegBanCod");
               GXutil.writeLogRaw("Old: ",Z1582LegBanCod);
               GXutil.writeLogRaw("Current: ",T005K2_A1582LegBanCod[0]);
            }
            if ( GXutil.strcmp(Z1581LegLpgCodigo, T005K2_A1581LegLpgCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegLpgCodigo");
               GXutil.writeLogRaw("Old: ",Z1581LegLpgCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A1581LegLpgCodigo[0]);
            }
            if ( GXutil.strcmp(Z1583LegMegCodigo, T005K2_A1583LegMegCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegMegCodigo");
               GXutil.writeLogRaw("Old: ",Z1583LegMegCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A1583LegMegCodigo[0]);
            }
            if ( GXutil.strcmp(Z1580LegOsoCod, T005K2_A1580LegOsoCod[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegOsoCod");
               GXutil.writeLogRaw("Old: ",Z1580LegOsoCod);
               GXutil.writeLogRaw("Current: ",T005K2_A1580LegOsoCod[0]);
            }
            if ( GXutil.strcmp(Z1579LegSecCodigo, T005K2_A1579LegSecCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSecCodigo");
               GXutil.writeLogRaw("Old: ",Z1579LegSecCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A1579LegSecCodigo[0]);
            }
            if ( GXutil.strcmp(Z1577LegSucCodigo, T005K2_A1577LegSucCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSucCodigo");
               GXutil.writeLogRaw("Old: ",Z1577LegSucCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A1577LegSucCodigo[0]);
            }
            if ( GXutil.strcmp(Z1578LegPuesCodigo, T005K2_A1578LegPuesCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegPuesCodigo");
               GXutil.writeLogRaw("Old: ",Z1578LegPuesCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A1578LegPuesCodigo[0]);
            }
            if ( GXutil.strcmp(Z18MprCod, T005K2_A18MprCod[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"MprCod");
               GXutil.writeLogRaw("Old: ",Z18MprCod);
               GXutil.writeLogRaw("Current: ",T005K2_A18MprCod[0]);
            }
            if ( GXutil.strcmp(Z20ZonCod, T005K2_A20ZonCod[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"ZonCod");
               GXutil.writeLogRaw("Old: ",Z20ZonCod);
               GXutil.writeLogRaw("Current: ",T005K2_A20ZonCod[0]);
            }
            if ( Z17CondiCodigo != T005K2_A17CondiCodigo[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"CondiCodigo");
               GXutil.writeLogRaw("Old: ",Z17CondiCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A17CondiCodigo[0]);
            }
            if ( GXutil.strcmp(Z19SinieCodigo, T005K2_A19SinieCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"SinieCodigo");
               GXutil.writeLogRaw("Old: ",Z19SinieCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A19SinieCodigo[0]);
            }
            if ( Z263LegSexo != T005K2_A263LegSexo[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSexo");
               GXutil.writeLogRaw("Old: ",Z263LegSexo);
               GXutil.writeLogRaw("Current: ",T005K2_A263LegSexo[0]);
            }
            if ( Z243LegEstadoCivil != T005K2_A243LegEstadoCivil[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegEstadoCivil");
               GXutil.writeLogRaw("Old: ",Z243LegEstadoCivil);
               GXutil.writeLogRaw("Current: ",T005K2_A243LegEstadoCivil[0]);
            }
            if ( Z22LegPaiCod != T005K2_A22LegPaiCod[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegPaiCod");
               GXutil.writeLogRaw("Old: ",Z22LegPaiCod);
               GXutil.writeLogRaw("Current: ",T005K2_A22LegPaiCod[0]);
            }
            if ( Z23LegProvCod != T005K2_A23LegProvCod[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegProvCod");
               GXutil.writeLogRaw("Old: ",Z23LegProvCod);
               GXutil.writeLogRaw("Current: ",T005K2_A23LegProvCod[0]);
            }
            if ( Z24LegLocCod != T005K2_A24LegLocCod[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegLocCod");
               GXutil.writeLogRaw("Old: ",Z24LegLocCod);
               GXutil.writeLogRaw("Current: ",T005K2_A24LegLocCod[0]);
            }
            if ( Z21LegNacionCod != T005K2_A21LegNacionCod[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegNacionCod");
               GXutil.writeLogRaw("Old: ",Z21LegNacionCod);
               GXutil.writeLogRaw("Current: ",T005K2_A21LegNacionCod[0]);
            }
            if ( GXutil.strcmp(Z910LegSinCod, T005K2_A910LegSinCod[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSinCod");
               GXutil.writeLogRaw("Old: ",Z910LegSinCod);
               GXutil.writeLogRaw("Current: ",T005K2_A910LegSinCod[0]);
            }
            if ( GXutil.strcmp(Z15LegActCodigo, T005K2_A15LegActCodigo[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegActCodigo");
               GXutil.writeLogRaw("Old: ",Z15LegActCodigo);
               GXutil.writeLogRaw("Current: ",T005K2_A15LegActCodigo[0]);
            }
            if ( Z1603LegSitRevEgreso != T005K2_A1603LegSitRevEgreso[0] )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegSitRevEgreso");
               GXutil.writeLogRaw("Old: ",Z1603LegSitRevEgreso);
               GXutil.writeLogRaw("Current: ",T005K2_A1603LegSitRevEgreso[0]);
            }
            if ( GXutil.strcmp(Z1235LegReligion, T005K2_A1235LegReligion[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegReligion");
               GXutil.writeLogRaw("Old: ",Z1235LegReligion);
               GXutil.writeLogRaw("Current: ",T005K2_A1235LegReligion[0]);
            }
            if ( GXutil.strcmp(Z1236LegOrigen, T005K2_A1236LegOrigen[0]) != 0 )
            {
               GXutil.writeLogln("legajos:[seudo value changed for attri]"+"LegOrigen");
               GXutil.writeLogRaw("Old: ",Z1236LegOrigen);
               GXutil.writeLogRaw("Current: ",T005K2_A1236LegOrigen[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Legajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5K23( )
   {
      beforeValidate5K23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5K23( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5K23( 0) ;
         checkOptimisticConcurrency5K23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5K23( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5K23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005K52 */
                  A1031LegFotoExt = A249LegFoto_Filetype ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1031LegFotoExt", A1031LegFotoExt);
                  A1030LegFotoNom = A249LegFoto_Filename ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1030LegFotoNom", A1030LegFotoNom);
                  pr_default.execute(50, new Object[] {Boolean.valueOf(A237LegConvenio), A250LegIdNomApe, A591LegNomApe, Integer.valueOf(A6LegNumero), A230LegApellido, A251LegNombre, Boolean.valueOf(n249LegFoto), A249LegFoto, Byte.valueOf(A266LegTipDoc), A257LegNumDoc, A246LegFecNac, Long.valueOf(A239LegCUIL), Byte.valueOf(A241LegDiscapacidad), A242LegDomici, A479LegEmail, A236LegCodPos, Boolean.valueOf(n265LegTelefono), A265LegTelefono, A245LegFecIngreso, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Byte.valueOf(A235LegClase), Byte.valueOf(A248LegFormaPago), Boolean.valueOf(n231LegBanSuc), A231LegBanSuc, Boolean.valueOf(n232LegBanTipCuen), A232LegBanTipCuen, A247LegFecUltMod, Boolean.valueOf(n238LegCuentaBanc), A238LegCuentaBanc, Boolean.valueOf(n253LegLicInicio), A253LegLicInicio, Boolean.valueOf(n252LegLicFinal), A252LegLicFinal, Boolean.valueOf(n234LegCBU), A234LegCBU, Boolean.valueOf(A262LegSCVO), Boolean.valueOf(A228LegActivo), A264LegSueldoFuera, Boolean.valueOf(n93LegId), A93LegId, Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, A515LegObs, A630LegFecImportacion, Boolean.valueOf(A877LegAgenReten), A879LegContinua, Boolean.valueOf(A942LegRecalcLiq), Boolean.valueOf(A1016LegJubilado), A1023LegHorasDia, A1268LegHorasSem, Boolean.valueOf(A1245LegTrabLun), Boolean.valueOf(A1246LegTrabMar), Boolean.valueOf(A1247LegTrabMie), Boolean.valueOf(A1248LegTrabJue), Boolean.valueOf(A1249LegTrabVie), Boolean.valueOf(A1250LegTrabSa), Boolean.valueOf(A1251LegTrabDo), Short.valueOf(A1523LegVacPend), A1531LegFecPreAviso, Boolean.valueOf(n1576LegConveVersionCli), Integer.valueOf(A1576LegConveVersionCli), A1759LegPromDias, A1804LegTitulo, Byte.valueOf(A1818LegEstado), Boolean.valueOf(A2267LegIncompleto), A1031LegFotoExt, A1030LegFotoNom, Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod, Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo, Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo, Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod, Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Short.valueOf(A1EmpCod), Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo, Boolean.valueOf(n18MprCod), A18MprCod, Boolean.valueOf(n20ZonCod), A20ZonCod, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo), Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil), Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod), Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n15LegActCodigo), A15LegActCodigo, Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso), Boolean.valueOf(n1235LegReligion), A1235LegReligion, Boolean.valueOf(n1236LegOrigen), A1236LegOrigen});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
                  if ( (pr_default.getStatus(50) == 1) )
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
                        resetCaption5K0( ) ;
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
            load5K23( ) ;
         }
         endLevel5K23( ) ;
      }
      closeExtendedTableCursors5K23( ) ;
   }

   public void update5K23( )
   {
      beforeValidate5K23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5K23( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5K23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5K23( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5K23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005K53 */
                  A1031LegFotoExt = A249LegFoto_Filetype ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1031LegFotoExt", A1031LegFotoExt);
                  A1030LegFotoNom = A249LegFoto_Filename ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1030LegFotoNom", A1030LegFotoNom);
                  pr_default.execute(51, new Object[] {Boolean.valueOf(A237LegConvenio), A250LegIdNomApe, A591LegNomApe, A230LegApellido, A251LegNombre, Byte.valueOf(A266LegTipDoc), A257LegNumDoc, A246LegFecNac, Long.valueOf(A239LegCUIL), Byte.valueOf(A241LegDiscapacidad), A242LegDomici, A479LegEmail, A236LegCodPos, Boolean.valueOf(n265LegTelefono), A265LegTelefono, A245LegFecIngreso, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Byte.valueOf(A235LegClase), Byte.valueOf(A248LegFormaPago), Boolean.valueOf(n231LegBanSuc), A231LegBanSuc, Boolean.valueOf(n232LegBanTipCuen), A232LegBanTipCuen, A247LegFecUltMod, Boolean.valueOf(n238LegCuentaBanc), A238LegCuentaBanc, Boolean.valueOf(n253LegLicInicio), A253LegLicInicio, Boolean.valueOf(n252LegLicFinal), A252LegLicFinal, Boolean.valueOf(n234LegCBU), A234LegCBU, Boolean.valueOf(A262LegSCVO), Boolean.valueOf(A228LegActivo), A264LegSueldoFuera, Boolean.valueOf(n93LegId), A93LegId, Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, A515LegObs, A630LegFecImportacion, Boolean.valueOf(A877LegAgenReten), A879LegContinua, Boolean.valueOf(A942LegRecalcLiq), Boolean.valueOf(A1016LegJubilado), A1023LegHorasDia, A1268LegHorasSem, Boolean.valueOf(A1245LegTrabLun), Boolean.valueOf(A1246LegTrabMar), Boolean.valueOf(A1247LegTrabMie), Boolean.valueOf(A1248LegTrabJue), Boolean.valueOf(A1249LegTrabVie), Boolean.valueOf(A1250LegTrabSa), Boolean.valueOf(A1251LegTrabDo), Short.valueOf(A1523LegVacPend), A1531LegFecPreAviso, Boolean.valueOf(n1576LegConveVersionCli), Integer.valueOf(A1576LegConveVersionCli), A1759LegPromDias, A1804LegTitulo, Byte.valueOf(A1818LegEstado), Boolean.valueOf(A2267LegIncompleto), A1031LegFotoExt, A1030LegFotoNom, Boolean.valueOf(n1582LegBanCod), A1582LegBanCod, Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo, Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo, Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod, Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo, Boolean.valueOf(n18MprCod), A18MprCod, Boolean.valueOf(n20ZonCod), A20ZonCod, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo), Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil), Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod), Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n15LegActCodigo), A15LegActCodigo, Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso), Boolean.valueOf(n1235LegReligion), A1235LegReligion, Boolean.valueOf(n1236LegOrigen), A1236LegOrigen, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
                  if ( (pr_default.getStatus(51) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5K23( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
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
         endLevel5K23( ) ;
      }
      closeExtendedTableCursors5K23( ) ;
   }

   public void deferredUpdate5K23( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T005K54 */
         pr_default.execute(52, new Object[] {Boolean.valueOf(n249LegFoto), A249LegFoto, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      }
   }

   public void delete( )
   {
      beforeValidate5K23( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5K23( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5K23( ) ;
         afterConfirm5K23( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5K23( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005K55 */
               pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
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
      sMode23 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      endLevel5K23( ) ;
      Gx_mode = sMode23 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5K23( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV39Pgmname = "Legajos" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Pgmname", AV39Pgmname);
         /* Using cursor T005K56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A1965EmpOsoCod = T005K56_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = T005K56_n1965EmpOsoCod[0] ;
         A2EmpNom = T005K56_A2EmpNom[0] ;
         A45TipEmpleCod = T005K56_A45TipEmpleCod[0] ;
         n45TipEmpleCod = T005K56_n45TipEmpleCod[0] ;
         pr_default.close(54);
         /* Using cursor T005K57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
         A307OsoDescrip = T005K57_A307OsoDescrip[0] ;
         n307OsoDescrip = T005K57_n307OsoDescrip[0] ;
         A306OsoC3992 = T005K57_A306OsoC3992[0] ;
         n306OsoC3992 = T005K57_n306OsoC3992[0] ;
         pr_default.close(55);
         GXt_char4 = A681OsoDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A681OsoDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
         /* Using cursor T005K58 */
         pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
         A291LpgDescri = T005K58_A291LpgDescri[0] ;
         n291LpgDescri = T005K58_n291LpgDescri[0] ;
         pr_default.close(56);
         GXt_char4 = A677LpgDescriSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A677LpgDescriSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
         /* Using cursor T005K59 */
         pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
         A300MegDescrip = T005K59_A300MegDescrip[0] ;
         n300MegDescrip = T005K59_n300MegDescrip[0] ;
         pr_default.close(57);
         /* Using cursor T005K60 */
         pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
         A392OsoSigla = T005K60_A392OsoSigla[0] ;
         n392OsoSigla = T005K60_n392OsoSigla[0] ;
         pr_default.close(58);
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
               {
                  A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
               }
               else
               {
                  A555OsoSiglaYDesc = A307OsoDescrip ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
               }
            }
         }
         /* Using cursor T005K61 */
         pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
         A329SecDescrip = T005K61_A329SecDescrip[0] ;
         n329SecDescrip = T005K61_n329SecDescrip[0] ;
         pr_default.close(59);
         GXt_char4 = A675SecDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A675SecDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
         /* Using cursor T005K62 */
         pr_default.execute(60, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
         A684MprDescripSinAc = T005K62_A684MprDescripSinAc[0] ;
         A303MprDescrip = T005K62_A303MprDescrip[0] ;
         pr_default.close(60);
         /* Using cursor T005K63 */
         pr_default.execute(61, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         A678ZonDescripSinAc = T005K63_A678ZonDescripSinAc[0] ;
         A342ZonDescrip = T005K63_A342ZonDescrip[0] ;
         A343ZonPorcReduc = T005K63_A343ZonPorcReduc[0] ;
         pr_default.close(61);
         /* Using cursor T005K64 */
         pr_default.execute(62, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         A686CondiDescriSinAc = T005K64_A686CondiDescriSinAc[0] ;
         A144CondiDescri = T005K64_A144CondiDescri[0] ;
         pr_default.close(62);
         /* Using cursor T005K65 */
         pr_default.execute(63, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         A688SinieDescriSinAc = T005K65_A688SinieDescriSinAc[0] ;
         A333SinieDescri = T005K65_A333SinieDescri[0] ;
         pr_default.close(63);
         /* Using cursor T005K66 */
         pr_default.execute(64, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
         A258LegPaiNom = T005K66_A258LegPaiNom[0] ;
         pr_default.close(64);
         /* Using cursor T005K67 */
         pr_default.execute(65, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
         A260LegProvNom = T005K67_A260LegProvNom[0] ;
         pr_default.close(65);
         /* Using cursor T005K68 */
         pr_default.execute(66, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
         A255LegLocNom = T005K68_A255LegLocNom[0] ;
         pr_default.close(66);
         /* Using cursor T005K69 */
         pr_default.execute(67, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
         A256LegNacionalidad = T005K69_A256LegNacionalidad[0] ;
         pr_default.close(67);
         /* Using cursor T005K70 */
         pr_default.execute(68, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
         A331SinDescrip = T005K70_A331SinDescrip[0] ;
         n331SinDescrip = T005K70_n331SinDescrip[0] ;
         pr_default.close(68);
         GXt_char4 = A680SinDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
         legajos_impl.this.GXt_char4 = GXv_char5[0] ;
         A680SinDescripSinAc = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
         /* Using cursor T005K71 */
         pr_default.execute(69, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
         A227LegActDescri = T005K71_A227LegActDescri[0] ;
         pr_default.close(69);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005K72 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor T005K73 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor T005K74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LegajoPropiedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor T005K75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LegPreliqCab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor T005K76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipos_de_trabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor T005K77 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor T005K78 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sueldos por fecha", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor T005K79 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Remu", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor T005K80 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Ded Gen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor T005K81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor T005K82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LDed Per", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor T005K83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LCalculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor T005K84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_dedducciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor T005K85 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centros de Costo de Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor T005K86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
         /* Using cursor T005K87 */
         pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(85) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(85);
         /* Using cursor T005K88 */
         pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(86) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Familia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(86);
         /* Using cursor T005K89 */
         pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(87) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(87);
      }
   }

   public void endLevel5K23( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5K23( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "legajos");
         if ( AnyError == 0 )
         {
            confirmValues5K0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "legajos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5K23( )
   {
      /* Scan By routine */
      /* Using cursor T005K90 */
      pr_default.execute(88);
      RcdFound23 = (short)(0) ;
      if ( (pr_default.getStatus(88) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A3CliCod = T005K90_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005K90_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T005K90_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5K23( )
   {
      /* Scan next routine */
      pr_default.readNext(88);
      RcdFound23 = (short)(0) ;
      if ( (pr_default.getStatus(88) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A3CliCod = T005K90_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005K90_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T005K90_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
   }

   public void scanEnd5K23( )
   {
      pr_default.close(88);
   }

   public void afterConfirm5K23( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5K23( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5K23( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5K23( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5K23( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5K23( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5K23( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLegApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegApellido_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5K23( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5K0( )
   {
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
         httpContext.writeValue( httpContext.getMessage( "Legajos", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
         httpContext.writeText( " "+"class=\"form-horizontal FormSplitScreen\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormSplitScreen\" data-gx-class=\"form-horizontal FormSplitScreen\" novalidate action=\""+formatLink("web.legajos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal FormSplitScreen", true);
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
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormSplitScreen" : Form.getThemeClass())+"-fx");
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Legajos");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LegNombre", GXutil.rtrim( localUtil.format( A251LegNombre, "")));
      forbiddenHiddens.add("LegTipDoc", localUtil.format( DecimalUtil.doubleToDec(A266LegTipDoc), "9"));
      forbiddenHiddens.add("LegNumDoc", GXutil.rtrim( localUtil.format( A257LegNumDoc, "@!")));
      forbiddenHiddens.add("LegFecNac", localUtil.format(A246LegFecNac, "99/99/9999"));
      forbiddenHiddens.add("LegCUIL", localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9"));
      forbiddenHiddens.add("LegDiscapacidad", localUtil.format( DecimalUtil.doubleToDec(A241LegDiscapacidad), "9"));
      forbiddenHiddens.add("LegDomici", GXutil.rtrim( localUtil.format( A242LegDomici, "")));
      forbiddenHiddens.add("LegEmail", GXutil.rtrim( localUtil.format( A479LegEmail, "")));
      forbiddenHiddens.add("LegCodPos", GXutil.rtrim( localUtil.format( A236LegCodPos, "@!")));
      forbiddenHiddens.add("LegTelefono", GXutil.rtrim( localUtil.format( A265LegTelefono, "@!")));
      forbiddenHiddens.add("LegFecIngreso", localUtil.format(A245LegFecIngreso, "99/99/9999"));
      forbiddenHiddens.add("LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
      forbiddenHiddens.add("LegCatCodigo", GXutil.rtrim( localUtil.format( A939LegCatCodigo, "")));
      forbiddenHiddens.add("LegClase", localUtil.format( DecimalUtil.doubleToDec(A235LegClase), "9"));
      forbiddenHiddens.add("LegFormaPago", localUtil.format( DecimalUtil.doubleToDec(A248LegFormaPago), "9"));
      forbiddenHiddens.add("LegBanSuc", GXutil.rtrim( localUtil.format( A231LegBanSuc, "@!")));
      forbiddenHiddens.add("LegBanTipCuen", GXutil.rtrim( localUtil.format( A232LegBanTipCuen, "")));
      forbiddenHiddens.add("LegFecUltMod", localUtil.format(A247LegFecUltMod, "99/99/9999"));
      forbiddenHiddens.add("LegCuentaBanc", GXutil.rtrim( localUtil.format( A238LegCuentaBanc, "@!")));
      forbiddenHiddens.add("LegLicInicio", localUtil.format(A253LegLicInicio, "99/99/9999"));
      forbiddenHiddens.add("LegLicFinal", localUtil.format(A252LegLicFinal, "99/99/9999"));
      forbiddenHiddens.add("LegCBU", GXutil.rtrim( localUtil.format( A234LegCBU, "")));
      forbiddenHiddens.add("LegSCVO", GXutil.booltostr( A262LegSCVO));
      forbiddenHiddens.add("LegActivo", GXutil.booltostr( A228LegActivo));
      forbiddenHiddens.add("LegSueldoFuera", localUtil.format( A264LegSueldoFuera, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LegId", GXutil.rtrim( localUtil.format( A93LegId, "")));
      forbiddenHiddens.add("LegConveCodigo", GXutil.rtrim( localUtil.format( A937LegConveCodigo, "")));
      forbiddenHiddens.add("LegFecImportacion", localUtil.format( A630LegFecImportacion, "99/99/99 99:99"));
      forbiddenHiddens.add("LegAgenReten", GXutil.booltostr( A877LegAgenReten));
      forbiddenHiddens.add("LegContinua", GXutil.rtrim( localUtil.format( A879LegContinua, "")));
      forbiddenHiddens.add("LegRecalcLiq", GXutil.booltostr( A942LegRecalcLiq));
      forbiddenHiddens.add("LegJubilado", GXutil.booltostr( A1016LegJubilado));
      forbiddenHiddens.add("LegHorasDia", localUtil.format( A1023LegHorasDia, "9.9"));
      forbiddenHiddens.add("LegHorasSem", localUtil.format( A1268LegHorasSem, "Z9.9"));
      forbiddenHiddens.add("LegReligion", GXutil.rtrim( localUtil.format( A1235LegReligion, "")));
      forbiddenHiddens.add("LegOrigen", GXutil.rtrim( localUtil.format( A1236LegOrigen, "")));
      forbiddenHiddens.add("LegTrabLun", GXutil.booltostr( A1245LegTrabLun));
      forbiddenHiddens.add("LegTrabMar", GXutil.booltostr( A1246LegTrabMar));
      forbiddenHiddens.add("LegTrabMie", GXutil.booltostr( A1247LegTrabMie));
      forbiddenHiddens.add("LegTrabJue", GXutil.booltostr( A1248LegTrabJue));
      forbiddenHiddens.add("LegTrabVie", GXutil.booltostr( A1249LegTrabVie));
      forbiddenHiddens.add("LegTrabSa", GXutil.booltostr( A1250LegTrabSa));
      forbiddenHiddens.add("LegTrabDo", GXutil.booltostr( A1251LegTrabDo));
      forbiddenHiddens.add("LegVacPend", localUtil.format( DecimalUtil.doubleToDec(A1523LegVacPend), "ZZZ9"));
      forbiddenHiddens.add("LegFecPreAviso", localUtil.format(A1531LegFecPreAviso, "99/99/99"));
      forbiddenHiddens.add("LegConveVersionCli", localUtil.format( DecimalUtil.doubleToDec(A1576LegConveVersionCli), "ZZZZZ9"));
      forbiddenHiddens.add("LegPromDias", GXutil.rtrim( localUtil.format( A1759LegPromDias, "")));
      forbiddenHiddens.add("LegTitulo", GXutil.rtrim( localUtil.format( A1804LegTitulo, "")));
      forbiddenHiddens.add("LegEstado", localUtil.format( DecimalUtil.doubleToDec(A1818LegEstado), "9"));
      forbiddenHiddens.add("LegIncompleto", GXutil.booltostr( A2267LegIncompleto));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("legajos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z237LegConvenio", Z237LegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z250LegIdNomApe", Z250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z591LegNomApe", Z591LegNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z230LegApellido", Z230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z251LegNombre", Z251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z266LegTipDoc", GXutil.ltrim( localUtil.ntoc( Z266LegTipDoc, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z257LegNumDoc", Z257LegNumDoc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z246LegFecNac", localUtil.dtoc( Z246LegFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z239LegCUIL", GXutil.ltrim( localUtil.ntoc( Z239LegCUIL, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z241LegDiscapacidad", GXutil.ltrim( localUtil.ntoc( Z241LegDiscapacidad, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z242LegDomici", Z242LegDomici);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z479LegEmail", Z479LegEmail);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z236LegCodPos", GXutil.rtrim( Z236LegCodPos));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z265LegTelefono", Z265LegTelefono);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z245LegFecIngreso", localUtil.dtoc( Z245LegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z244LegFecEgreso", localUtil.dtoc( Z244LegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z939LegCatCodigo", GXutil.rtrim( Z939LegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z235LegClase", GXutil.ltrim( localUtil.ntoc( Z235LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z248LegFormaPago", GXutil.ltrim( localUtil.ntoc( Z248LegFormaPago, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z231LegBanSuc", Z231LegBanSuc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z232LegBanTipCuen", GXutil.rtrim( Z232LegBanTipCuen));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z247LegFecUltMod", localUtil.dtoc( Z247LegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z238LegCuentaBanc", Z238LegCuentaBanc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z253LegLicInicio", localUtil.dtoc( Z253LegLicInicio, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z252LegLicFinal", localUtil.dtoc( Z252LegLicFinal, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z234LegCBU", Z234LegCBU);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z262LegSCVO", Z262LegSCVO);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z228LegActivo", Z228LegActivo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z264LegSueldoFuera", GXutil.ltrim( localUtil.ntoc( Z264LegSueldoFuera, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z93LegId", GXutil.rtrim( Z93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z937LegConveCodigo", GXutil.rtrim( Z937LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z630LegFecImportacion", localUtil.ttoc( Z630LegFecImportacion, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z877LegAgenReten", Z877LegAgenReten);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z879LegContinua", GXutil.rtrim( Z879LegContinua));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z942LegRecalcLiq", Z942LegRecalcLiq);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1016LegJubilado", Z1016LegJubilado);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1023LegHorasDia", GXutil.ltrim( localUtil.ntoc( Z1023LegHorasDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1268LegHorasSem", GXutil.ltrim( localUtil.ntoc( Z1268LegHorasSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1245LegTrabLun", Z1245LegTrabLun);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1246LegTrabMar", Z1246LegTrabMar);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1247LegTrabMie", Z1247LegTrabMie);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1248LegTrabJue", Z1248LegTrabJue);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1249LegTrabVie", Z1249LegTrabVie);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1250LegTrabSa", Z1250LegTrabSa);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z1251LegTrabDo", Z1251LegTrabDo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1523LegVacPend", GXutil.ltrim( localUtil.ntoc( Z1523LegVacPend, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1531LegFecPreAviso", localUtil.dtoc( Z1531LegFecPreAviso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1576LegConveVersionCli", GXutil.ltrim( localUtil.ntoc( Z1576LegConveVersionCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1759LegPromDias", Z1759LegPromDias);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1804LegTitulo", GXutil.rtrim( Z1804LegTitulo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1818LegEstado", GXutil.ltrim( localUtil.ntoc( Z1818LegEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"Z2267LegIncompleto", Z2267LegIncompleto);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1582LegBanCod", GXutil.rtrim( Z1582LegBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1581LegLpgCodigo", GXutil.rtrim( Z1581LegLpgCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1583LegMegCodigo", GXutil.rtrim( Z1583LegMegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1580LegOsoCod", GXutil.rtrim( Z1580LegOsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1579LegSecCodigo", GXutil.rtrim( Z1579LegSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1577LegSucCodigo", GXutil.rtrim( Z1577LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1578LegPuesCodigo", GXutil.rtrim( Z1578LegPuesCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z18MprCod", GXutil.rtrim( Z18MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z20ZonCod", GXutil.rtrim( Z20ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z17CondiCodigo", GXutil.ltrim( localUtil.ntoc( Z17CondiCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z19SinieCodigo", GXutil.rtrim( Z19SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z263LegSexo", GXutil.ltrim( localUtil.ntoc( Z263LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z243LegEstadoCivil", GXutil.ltrim( localUtil.ntoc( Z243LegEstadoCivil, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z22LegPaiCod", GXutil.ltrim( localUtil.ntoc( Z22LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z23LegProvCod", GXutil.ltrim( localUtil.ntoc( Z23LegProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z24LegLocCod", GXutil.ltrim( localUtil.ntoc( Z24LegLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z21LegNacionCod", GXutil.ltrim( localUtil.ntoc( Z21LegNacionCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z910LegSinCod", GXutil.rtrim( Z910LegSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z15LegActCodigo", GXutil.rtrim( Z15LegActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1603LegSitRevEgreso", GXutil.ltrim( localUtil.ntoc( Z1603LegSitRevEgreso, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1235LegReligion", GXutil.rtrim( Z1235LegReligion));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z1236LegOrigen", GXutil.rtrim( Z1236LegOrigen));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N263LegSexo", GXutil.ltrim( localUtil.ntoc( A263LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N243LegEstadoCivil", GXutil.ltrim( localUtil.ntoc( A243LegEstadoCivil, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N21LegNacionCod", GXutil.ltrim( localUtil.ntoc( A21LegNacionCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N22LegPaiCod", GXutil.ltrim( localUtil.ntoc( A22LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N23LegProvCod", GXutil.ltrim( localUtil.ntoc( A23LegProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N24LegLocCod", GXutil.ltrim( localUtil.ntoc( A24LegLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1583LegMegCodigo", GXutil.rtrim( A1583LegMegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1579LegSecCodigo", GXutil.rtrim( A1579LegSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1581LegLpgCodigo", GXutil.rtrim( A1581LegLpgCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1582LegBanCod", GXutil.rtrim( A1582LegBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N910LegSinCod", GXutil.rtrim( A910LegSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1580LegOsoCod", GXutil.rtrim( A1580LegOsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N15LegActCodigo", GXutil.rtrim( A15LegActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N18MprCod", GXutil.rtrim( A18MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N20ZonCod", GXutil.rtrim( A20ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N17CondiCodigo", GXutil.ltrim( localUtil.ntoc( A17CondiCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N19SinieCodigo", GXutil.rtrim( A19SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1578LegPuesCodigo", GXutil.rtrim( A1578LegPuesCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1577LegSucCodigo", GXutil.rtrim( A1577LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"N1603LegSitRevEgreso", GXutil.ltrim( localUtil.ntoc( A1603LegSitRevEgreso, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDETAILWCINFO", AV31DetailWCInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDETAILWCINFO", AV31DetailWCInfo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDETAILWCINFO", getSecureSignedToken( sPrefix, AV31DetailWCInfo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNOMAPE", A591LegNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONVEVERSIONCLI", GXutil.ltrim( localUtil.ntoc( A1576LegConveVersionCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPAICOD", GXutil.ltrim( localUtil.ntoc( A22LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONVECODIGO", GXutil.rtrim( A937LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCLASE", GXutil.ltrim( localUtil.ntoc( A235LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGBASICO", GXutil.ltrim( localUtil.ntoc( A233LegBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SECDESCRIP", A329SecDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SECDESCRIPSINAC", A675SecDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LPGDESCRI", A291LpgDescri);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LPGDESCRISINAC", A677LpgDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BANDESCRIP", A117BanDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BANDESCRIPSINAC", A679BanDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SINDESCRIP", A331SinDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SINDESCRIPSINAC", A680SinDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"OSODESCRIP", A307OsoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"OSODESCRIPSINAC", A681OsoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"OSOSIGLA", GXutil.rtrim( A392OsoSigla));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"OSOC3992", GXutil.rtrim( A306OsoC3992));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"OSOSIGLAYDESC", A555OsoSiglaYDesc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGCONVENIO", A237LegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGSEXO", GXutil.ltrim( localUtil.ntoc( AV33Insert_LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSEXO", GXutil.ltrim( localUtil.ntoc( A263LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGESTADOCIVIL", GXutil.ltrim( localUtil.ntoc( AV34Insert_LegEstadoCivil, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGESTADOCIVIL", GXutil.ltrim( localUtil.ntoc( A243LegEstadoCivil, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGNACIONCOD", GXutil.ltrim( localUtil.ntoc( AV16Insert_LegNacionCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNACIONCOD", GXutil.ltrim( localUtil.ntoc( A21LegNacionCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGPAICOD", GXutil.ltrim( localUtil.ntoc( AV35Insert_LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGPROVCOD", GXutil.ltrim( localUtil.ntoc( AV36Insert_LegProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPROVCOD", GXutil.ltrim( localUtil.ntoc( A23LegProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGLOCCOD", GXutil.ltrim( localUtil.ntoc( AV37Insert_LegLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGLOCCOD", GXutil.ltrim( localUtil.ntoc( A24LegLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGMEGCODIGO", GXutil.rtrim( AV17Insert_LegMegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGMEGCODIGO", GXutil.rtrim( A1583LegMegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGSECCODIGO", GXutil.rtrim( AV18Insert_LegSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSECCODIGO", GXutil.rtrim( A1579LegSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGLPGCODIGO", GXutil.rtrim( AV19Insert_LegLpgCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGLPGCODIGO", GXutil.rtrim( A1581LegLpgCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGBANCOD", GXutil.rtrim( AV20Insert_LegBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGBANCOD", GXutil.rtrim( A1582LegBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGSINCOD", GXutil.rtrim( AV38Insert_LegSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSINCOD", GXutil.rtrim( A910LegSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGOSOCOD", GXutil.rtrim( AV21Insert_LegOsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGOSOCOD", GXutil.rtrim( A1580LegOsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGACTCODIGO", GXutil.rtrim( AV22Insert_LegActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGACTCODIGO", GXutil.rtrim( A15LegActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_MPRCOD", GXutil.rtrim( AV23Insert_MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MPRCOD", GXutil.rtrim( A18MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_ZONCOD", GXutil.rtrim( AV24Insert_ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ZONCOD", GXutil.rtrim( A20ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_CONDICODIGO", GXutil.ltrim( localUtil.ntoc( AV25Insert_CondiCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONDICODIGO", GXutil.ltrim( localUtil.ntoc( A17CondiCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_SINIECODIGO", GXutil.rtrim( AV26Insert_SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SINIECODIGO", GXutil.rtrim( A19SinieCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGPUESCODIGO", GXutil.rtrim( AV27Insert_LegPuesCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPUESCODIGO", GXutil.rtrim( A1578LegPuesCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGSUCCODIGO", GXutil.rtrim( AV28Insert_LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSUCCODIGO", GXutil.rtrim( A1577LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINSERT_LEGSITREVEGRESO", GXutil.ltrim( localUtil.ntoc( AV29Insert_LegSitRevEgreso, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSITREVEGRESO", GXutil.ltrim( localUtil.ntoc( A1603LegSitRevEgreso, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFOTO", A249LegFoto);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGTIPDOC", GXutil.ltrim( localUtil.ntoc( A266LegTipDoc, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNUMDOC", A257LegNumDoc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECNAC", localUtil.dtoc( A246LegFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCUIL", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGDISCAPACIDAD", GXutil.ltrim( localUtil.ntoc( A241LegDiscapacidad, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGDOMICI", A242LegDomici);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGEMAIL", A479LegEmail);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCODPOS", GXutil.rtrim( A236LegCodPos));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGTELEFONO", A265LegTelefono);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECINGRESO", localUtil.dtoc( A245LegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECEGRESO", localUtil.dtoc( A244LegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCATCODIGO", GXutil.rtrim( A939LegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFORMAPAGO", GXutil.ltrim( localUtil.ntoc( A248LegFormaPago, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGBANSUC", A231LegBanSuc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGBANTIPCUEN", GXutil.rtrim( A232LegBanTipCuen));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECULTMOD", localUtil.dtoc( A247LegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCUENTABANC", A238LegCuentaBanc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGLICINICIO", localUtil.dtoc( A253LegLicInicio, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGLICFINAL", localUtil.dtoc( A252LegLicFinal, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCBU", A234LegCBU);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGSCVO", A262LegSCVO);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGACTIVO", A228LegActivo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSUELDOFUERA", GXutil.ltrim( localUtil.ntoc( A264LegSueldoFuera, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGOBS", A515LegObs);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECIMPORTACION", localUtil.ttoc( A630LegFecImportacion, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGAGENRETEN", A877LegAgenReten);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONTINUA", GXutil.rtrim( A879LegContinua));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGRECALCLIQ", A942LegRecalcLiq);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGJUBILADO", A1016LegJubilado);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGHORASDIA", GXutil.ltrim( localUtil.ntoc( A1023LegHorasDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGHORASSEM", GXutil.ltrim( localUtil.ntoc( A1268LegHorasSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABLUN", A1245LegTrabLun);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABMAR", A1246LegTrabMar);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABMIE", A1247LegTrabMie);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABJUE", A1248LegTrabJue);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABVIE", A1249LegTrabVie);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABSA", A1250LegTrabSa);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGTRABDO", A1251LegTrabDo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGVACPEND", GXutil.ltrim( localUtil.ntoc( A1523LegVacPend, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECPREAVISO", localUtil.dtoc( A1531LegFecPreAviso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPROMDIAS", A1759LegPromDias);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGTITULO", GXutil.rtrim( A1804LegTitulo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGESTADO", GXutil.ltrim( localUtil.ntoc( A1818LegEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LEGINCOMPLETO", A2267LegIncompleto);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFOTOEXT", GXutil.rtrim( A1031LegFotoExt));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFOTONOM", A1030LegFotoNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGRELIGION", GXutil.rtrim( A1235LegReligion));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGORIGEN", GXutil.rtrim( A1236LegOrigen));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MEGDESCRIP", A300MegDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPOSOCOD", GXutil.rtrim( A1965EmpOsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPNOM", A2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TIPEMPLECOD", GXutil.rtrim( A45TipEmpleCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MPRDESCRIPSINAC", A684MprDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MPRDESCRIP", A303MprDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ZONDESCRIPSINAC", A678ZonDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ZONDESCRIP", A342ZonDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ZONPORCREDUC", GXutil.ltrim( localUtil.ntoc( A343ZonPorcReduc, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONDIDESCRISINAC", A686CondiDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONDIDESCRI", A144CondiDescri);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SINIEDESCRISINAC", A688SinieDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SINIEDESCRI", A333SinieDescri);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPAINOM", A258LegPaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPROVNOM", A260LegProvNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGLOCNOM", A255LegLocNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNACIONALIDAD", A256LegNacionalidad);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGACTDESCRI", A227LegActDescri);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV39Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
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
   }

   public void renderHtmlCloseForm5K23( )
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
      return "Legajos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajos", "") ;
   }

   public void initializeNonKey5K23( )
   {
      A1965EmpOsoCod = "" ;
      n1965EmpOsoCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1965EmpOsoCod", A1965EmpOsoCod);
      A263LegSexo = (byte)(0) ;
      n263LegSexo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A263LegSexo), 2, 0));
      A243LegEstadoCivil = (short)(0) ;
      n243LegEstadoCivil = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243LegEstadoCivil", GXutil.ltrimstr( DecimalUtil.doubleToDec(A243LegEstadoCivil), 4, 0));
      A21LegNacionCod = (short)(0) ;
      n21LegNacionCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21LegNacionCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21LegNacionCod), 4, 0));
      A22LegPaiCod = (short)(0) ;
      n22LegPaiCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A22LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22LegPaiCod), 4, 0));
      A23LegProvCod = (short)(0) ;
      n23LegProvCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A23LegProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23LegProvCod), 4, 0));
      A24LegLocCod = (short)(0) ;
      n24LegLocCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A24LegLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24LegLocCod), 4, 0));
      A1583LegMegCodigo = "" ;
      n1583LegMegCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1583LegMegCodigo", A1583LegMegCodigo);
      A1579LegSecCodigo = "" ;
      n1579LegSecCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1579LegSecCodigo", A1579LegSecCodigo);
      A1581LegLpgCodigo = "" ;
      n1581LegLpgCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1581LegLpgCodigo", A1581LegLpgCodigo);
      A1582LegBanCod = "" ;
      n1582LegBanCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1582LegBanCod", A1582LegBanCod);
      A910LegSinCod = "" ;
      n910LegSinCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A910LegSinCod", A910LegSinCod);
      A1580LegOsoCod = "" ;
      n1580LegOsoCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1580LegOsoCod", A1580LegOsoCod);
      A15LegActCodigo = "" ;
      n15LegActCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A15LegActCodigo", A15LegActCodigo);
      A18MprCod = "" ;
      n18MprCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18MprCod", A18MprCod);
      A20ZonCod = "" ;
      n20ZonCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20ZonCod", A20ZonCod);
      A17CondiCodigo = (short)(0) ;
      n17CondiCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17CondiCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17CondiCodigo), 4, 0));
      A19SinieCodigo = "" ;
      n19SinieCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19SinieCodigo", A19SinieCodigo);
      A1578LegPuesCodigo = "" ;
      n1578LegPuesCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1578LegPuesCodigo", A1578LegPuesCodigo);
      A1577LegSucCodigo = "" ;
      n1577LegSucCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1577LegSucCodigo", A1577LegSucCodigo);
      A1603LegSitRevEgreso = (short)(0) ;
      n1603LegSitRevEgreso = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1603LegSitRevEgreso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1603LegSitRevEgreso), 3, 0));
      A237LegConvenio = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237LegConvenio", A237LegConvenio);
      A688SinieDescriSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A688SinieDescriSinAc", A688SinieDescriSinAc);
      A686CondiDescriSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A686CondiDescriSinAc", A686CondiDescriSinAc);
      A678ZonDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A678ZonDescripSinAc", A678ZonDescripSinAc);
      A684MprDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A684MprDescripSinAc", A684MprDescripSinAc);
      A555OsoSiglaYDesc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      A681OsoDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      A680SinDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
      A679BanDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A679BanDescripSinAc", A679BanDescripSinAc);
      A677LpgDescriSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
      A675SecDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
      A233LegBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A233LegBasico", GXutil.ltrimstr( A233LegBasico, 14, 2));
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250LegIdNomApe", A250LegIdNomApe);
      A591LegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A591LegNomApe", A591LegNomApe);
      A2EmpNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2EmpNom", A2EmpNom);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230LegApellido", A230LegApellido);
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251LegNombre", A251LegNombre);
      A249LegFoto = "" ;
      n249LegFoto = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A249LegFoto", A249LegFoto);
      A266LegTipDoc = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A266LegTipDoc", GXutil.str( A266LegTipDoc, 1, 0));
      A257LegNumDoc = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A257LegNumDoc", A257LegNumDoc);
      A246LegFecNac = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246LegFecNac", localUtil.format(A246LegFecNac, "99/99/9999"));
      A256LegNacionalidad = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A256LegNacionalidad", A256LegNacionalidad);
      A239LegCUIL = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239LegCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(A239LegCUIL), 11, 0));
      A241LegDiscapacidad = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241LegDiscapacidad", GXutil.str( A241LegDiscapacidad, 1, 0));
      A242LegDomici = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242LegDomici", A242LegDomici);
      A479LegEmail = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A479LegEmail", A479LegEmail);
      A236LegCodPos = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236LegCodPos", A236LegCodPos);
      A258LegPaiNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A258LegPaiNom", A258LegPaiNom);
      A260LegProvNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A260LegProvNom", A260LegProvNom);
      A255LegLocNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A255LegLocNom", A255LegLocNom);
      A265LegTelefono = "" ;
      n265LegTelefono = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265LegTelefono", A265LegTelefono);
      A245LegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A245LegFecIngreso", localUtil.format(A245LegFecIngreso, "99/99/9999"));
      A244LegFecEgreso = GXutil.nullDate() ;
      n244LegFecEgreso = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
      A300MegDescrip = "" ;
      n300MegDescrip = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A300MegDescrip", A300MegDescrip);
      A939LegCatCodigo = "" ;
      n939LegCatCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A939LegCatCodigo", A939LegCatCodigo);
      A329SecDescrip = "" ;
      n329SecDescrip = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A329SecDescrip", A329SecDescrip);
      A291LpgDescri = "" ;
      n291LpgDescri = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A291LpgDescri", A291LpgDescri);
      A235LegClase = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235LegClase", GXutil.str( A235LegClase, 1, 0));
      A248LegFormaPago = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248LegFormaPago", GXutil.str( A248LegFormaPago, 1, 0));
      A117BanDescrip = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117BanDescrip", A117BanDescrip);
      A231LegBanSuc = "" ;
      n231LegBanSuc = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231LegBanSuc", A231LegBanSuc);
      A232LegBanTipCuen = "" ;
      n232LegBanTipCuen = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A232LegBanTipCuen", A232LegBanTipCuen);
      A331SinDescrip = "" ;
      n331SinDescrip = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A331SinDescrip", A331SinDescrip);
      A307OsoDescrip = "" ;
      n307OsoDescrip = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A307OsoDescrip", A307OsoDescrip);
      A227LegActDescri = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227LegActDescri", A227LegActDescri);
      A303MprDescrip = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A303MprDescrip", A303MprDescrip);
      A247LegFecUltMod = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A247LegFecUltMod", localUtil.format(A247LegFecUltMod, "99/99/9999"));
      A238LegCuentaBanc = "" ;
      n238LegCuentaBanc = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238LegCuentaBanc", A238LegCuentaBanc);
      A253LegLicInicio = GXutil.nullDate() ;
      n253LegLicInicio = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A253LegLicInicio", localUtil.format(A253LegLicInicio, "99/99/9999"));
      A252LegLicFinal = GXutil.nullDate() ;
      n252LegLicFinal = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A252LegLicFinal", localUtil.format(A252LegLicFinal, "99/99/9999"));
      A342ZonDescrip = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ZonDescrip", A342ZonDescrip);
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A343ZonPorcReduc", GXutil.ltrimstr( A343ZonPorcReduc, 6, 2));
      A234LegCBU = "" ;
      n234LegCBU = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A234LegCBU", A234LegCBU);
      A262LegSCVO = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262LegSCVO", A262LegSCVO);
      A144CondiDescri = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A144CondiDescri", A144CondiDescri);
      A333SinieDescri = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333SinieDescri", A333SinieDescri);
      A228LegActivo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A228LegActivo", A228LegActivo);
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A264LegSueldoFuera", GXutil.ltrimstr( A264LegSueldoFuera, 14, 2));
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A93LegId", A93LegId);
      A937LegConveCodigo = "" ;
      n937LegConveCodigo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A937LegConveCodigo", A937LegConveCodigo);
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", A45TipEmpleCod);
      A306OsoC3992 = "" ;
      n306OsoC3992 = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306OsoC3992", A306OsoC3992);
      A515LegObs = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A515LegObs", A515LegObs);
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A630LegFecImportacion", localUtil.ttoc( A630LegFecImportacion, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A877LegAgenReten = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A877LegAgenReten", A877LegAgenReten);
      A879LegContinua = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A879LegContinua", A879LegContinua);
      A942LegRecalcLiq = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A942LegRecalcLiq", A942LegRecalcLiq);
      A1016LegJubilado = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1016LegJubilado", A1016LegJubilado);
      A1023LegHorasDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1023LegHorasDia", GXutil.ltrimstr( A1023LegHorasDia, 3, 1));
      A1268LegHorasSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1268LegHorasSem", GXutil.ltrimstr( A1268LegHorasSem, 4, 1));
      A1235LegReligion = "" ;
      n1235LegReligion = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1235LegReligion", A1235LegReligion);
      A1236LegOrigen = "" ;
      n1236LegOrigen = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1236LegOrigen", A1236LegOrigen);
      A1245LegTrabLun = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1245LegTrabLun", A1245LegTrabLun);
      A1246LegTrabMar = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1246LegTrabMar", A1246LegTrabMar);
      A1247LegTrabMie = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1247LegTrabMie", A1247LegTrabMie);
      A1248LegTrabJue = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1248LegTrabJue", A1248LegTrabJue);
      A1249LegTrabVie = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1249LegTrabVie", A1249LegTrabVie);
      A1250LegTrabSa = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1250LegTrabSa", A1250LegTrabSa);
      A1251LegTrabDo = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1251LegTrabDo", A1251LegTrabDo);
      A1523LegVacPend = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1523LegVacPend", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1523LegVacPend), 4, 0));
      A1531LegFecPreAviso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1531LegFecPreAviso", localUtil.format(A1531LegFecPreAviso, "99/99/99"));
      A1576LegConveVersionCli = 0 ;
      n1576LegConveVersionCli = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1576LegConveVersionCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1576LegConveVersionCli), 6, 0));
      A1759LegPromDias = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1759LegPromDias", A1759LegPromDias);
      A1804LegTitulo = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1804LegTitulo", A1804LegTitulo);
      A1818LegEstado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1818LegEstado", GXutil.str( A1818LegEstado, 1, 0));
      A2267LegIncompleto = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2267LegIncompleto", A2267LegIncompleto);
      A1031LegFotoExt = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1031LegFotoExt", A1031LegFotoExt);
      A1030LegFotoNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1030LegFotoNom", A1030LegFotoNom);
      A392OsoSigla = "" ;
      n392OsoSigla = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A392OsoSigla", A392OsoSigla);
      Z237LegConvenio = false ;
      Z250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      Z230LegApellido = "" ;
      Z251LegNombre = "" ;
      Z266LegTipDoc = (byte)(0) ;
      Z257LegNumDoc = "" ;
      Z246LegFecNac = GXutil.nullDate() ;
      Z239LegCUIL = 0 ;
      Z241LegDiscapacidad = (byte)(0) ;
      Z242LegDomici = "" ;
      Z479LegEmail = "" ;
      Z236LegCodPos = "" ;
      Z265LegTelefono = "" ;
      Z245LegFecIngreso = GXutil.nullDate() ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      Z939LegCatCodigo = "" ;
      Z235LegClase = (byte)(0) ;
      Z248LegFormaPago = (byte)(0) ;
      Z231LegBanSuc = "" ;
      Z232LegBanTipCuen = "" ;
      Z247LegFecUltMod = GXutil.nullDate() ;
      Z238LegCuentaBanc = "" ;
      Z253LegLicInicio = GXutil.nullDate() ;
      Z252LegLicFinal = GXutil.nullDate() ;
      Z234LegCBU = "" ;
      Z262LegSCVO = false ;
      Z228LegActivo = false ;
      Z264LegSueldoFuera = DecimalUtil.ZERO ;
      Z93LegId = "" ;
      Z937LegConveCodigo = "" ;
      Z630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      Z877LegAgenReten = false ;
      Z879LegContinua = "" ;
      Z942LegRecalcLiq = false ;
      Z1016LegJubilado = false ;
      Z1023LegHorasDia = DecimalUtil.ZERO ;
      Z1268LegHorasSem = DecimalUtil.ZERO ;
      Z1245LegTrabLun = false ;
      Z1246LegTrabMar = false ;
      Z1247LegTrabMie = false ;
      Z1248LegTrabJue = false ;
      Z1249LegTrabVie = false ;
      Z1250LegTrabSa = false ;
      Z1251LegTrabDo = false ;
      Z1523LegVacPend = (short)(0) ;
      Z1531LegFecPreAviso = GXutil.nullDate() ;
      Z1576LegConveVersionCli = 0 ;
      Z1759LegPromDias = "" ;
      Z1804LegTitulo = "" ;
      Z1818LegEstado = (byte)(0) ;
      Z2267LegIncompleto = false ;
      Z1582LegBanCod = "" ;
      Z1581LegLpgCodigo = "" ;
      Z1583LegMegCodigo = "" ;
      Z1580LegOsoCod = "" ;
      Z1579LegSecCodigo = "" ;
      Z1577LegSucCodigo = "" ;
      Z1578LegPuesCodigo = "" ;
      Z18MprCod = "" ;
      Z20ZonCod = "" ;
      Z17CondiCodigo = (short)(0) ;
      Z19SinieCodigo = "" ;
      Z263LegSexo = (byte)(0) ;
      Z243LegEstadoCivil = (short)(0) ;
      Z22LegPaiCod = (short)(0) ;
      Z23LegProvCod = (short)(0) ;
      Z24LegLocCod = (short)(0) ;
      Z21LegNacionCod = (short)(0) ;
      Z910LegSinCod = "" ;
      Z15LegActCodigo = "" ;
      Z1603LegSitRevEgreso = (short)(0) ;
      Z1235LegReligion = "" ;
      Z1236LegOrigen = "" ;
   }

   public void initAll5K23( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      initializeNonKey5K23( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlGx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV8EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10LegNumero = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         initialize_properties( ) ;
      }
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      if ( nDoneStart == 0 )
      {
      }
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "legajos", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initenv( ) ;
         inittrn( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV7CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         AV8EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         AV10LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( AV7CliCod != wcpOAV7CliCod ) || ( AV8EmpCod != wcpOAV8EmpCod ) || ( AV10LegNumero != wcpOAV10LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV7CliCod = AV7CliCod ;
      wcpOAV8EmpCod = AV8EmpCod ;
      wcpOAV10LegNumero = AV10LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlGx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_CTRL") ;
      if ( GXutil.len( sCtrlGx_mode) > 0 )
      {
         Gx_mode = httpContext.cgiGet( sCtrlGx_mode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_PARM") ;
      }
      sCtrlAV7CliCod = httpContext.cgiGet( sPrefix+"AV7CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV7CliCod) > 0 )
      {
         AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV7CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      }
      else
      {
         AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV7CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV8EmpCod = httpContext.cgiGet( sPrefix+"AV8EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV8EmpCod) > 0 )
      {
         AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
      }
      else
      {
         AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV10LegNumero = httpContext.cgiGet( sPrefix+"AV10LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV10LegNumero) > 0 )
      {
         AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      }
      else
      {
         AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      initenv( ) ;
      inittrn( ) ;
      nDraw = (byte)(0) ;
      sEvt = sCompEvt ;
      if ( isFullAjaxMode( ) )
      {
         userMain( ) ;
      }
      else
      {
         wcparametersget( ) ;
      }
      process( ) ;
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
      userMain( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_PARM", GXutil.rtrim( Gx_mode));
      if ( GXutil.len( GXutil.rtrim( sCtrlGx_mode)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_CTRL", GXutil.rtrim( sCtrlGx_mode));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7CliCod_CTRL", GXutil.rtrim( sCtrlAV7CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8EmpCod_CTRL", GXutil.rtrim( sCtrlAV8EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegNumero_CTRL", GXutil.rtrim( sCtrlAV10LegNumero));
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
      draw( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713473768", true, true);
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
      httpContext.AddJavascriptSource("legajos.js", "?20251713473769", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtLegApellido_Internalname = sPrefix+"LEGAPELLIDO" ;
      bttBtntrn_enter_Internalname = sPrefix+"BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = sPrefix+"BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = sPrefix+"BTNTRN_DELETE" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLegApellido_Jsonclick = "" ;
      edtLegApellido_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx6asasecdescripsinac5K23( String A329SecDescrip )
   {
      GXt_char4 = A675SecDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A675SecDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A675SecDescripSinAc", A675SecDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A675SecDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx7asalpgdescrisinac5K23( String A291LpgDescri )
   {
      GXt_char4 = A677LpgDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A677LpgDescriSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A677LpgDescriSinAc", A677LpgDescriSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A677LpgDescriSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx8asabandescripsinac5K23( String A117BanDescrip )
   {
      GXt_char4 = A679BanDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A679BanDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A679BanDescripSinAc", A679BanDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A679BanDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx9asasindescripsinac5K23( String A331SinDescrip )
   {
      GXt_char4 = A680SinDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A680SinDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A680SinDescripSinAc", A680SinDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A680SinDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx10asaosodescripsinac5K23( String A307OsoDescrip )
   {
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A681OsoDescripSinAc)+"\"") ;
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
      n1965EmpOsoCod = false ;
      n307OsoDescrip = false ;
      n45TipEmpleCod = false ;
      n306OsoC3992 = false ;
      /* Using cursor T005K56 */
      pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(54) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A1965EmpOsoCod = T005K56_A1965EmpOsoCod[0] ;
      n1965EmpOsoCod = T005K56_n1965EmpOsoCod[0] ;
      A2EmpNom = T005K56_A2EmpNom[0] ;
      A45TipEmpleCod = T005K56_A45TipEmpleCod[0] ;
      n45TipEmpleCod = T005K56_n45TipEmpleCod[0] ;
      pr_default.close(54);
      /* Using cursor T005K57 */
      pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(55) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      A307OsoDescrip = T005K57_A307OsoDescrip[0] ;
      n307OsoDescrip = T005K57_n307OsoDescrip[0] ;
      A306OsoC3992 = T005K57_A306OsoC3992[0] ;
      n306OsoC3992 = T005K57_n306OsoC3992[0] ;
      pr_default.close(55);
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajos_impl.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1965EmpOsoCod", GXutil.rtrim( A1965EmpOsoCod));
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2EmpNom", A2EmpNom);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A45TipEmpleCod", GXutil.rtrim( A45TipEmpleCod));
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A307OsoDescrip", A307OsoDescrip);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306OsoC3992", GXutil.rtrim( A306OsoC3992));
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'componentprocess',iparms:[{postForm:true},{sPrefix:true},{sSFPrefix:true},{sCompEvt:true},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV31DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A266LegTipDoc',fld:'LEGTIPDOC',pic:'9'},{av:'A257LegNumDoc',fld:'LEGNUMDOC',pic:'@!'},{av:'A246LegFecNac',fld:'LEGFECNAC',pic:''},{av:'A239LegCUIL',fld:'LEGCUIL',pic:'ZZ-ZZZZZZZZ-9'},{av:'A241LegDiscapacidad',fld:'LEGDISCAPACIDAD',pic:'9'},{av:'A242LegDomici',fld:'LEGDOMICI',pic:''},{av:'A479LegEmail',fld:'LEGEMAIL',pic:''},{av:'A236LegCodPos',fld:'LEGCODPOS',pic:'@!'},{av:'A265LegTelefono',fld:'LEGTELEFONO',pic:'@!'},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'A248LegFormaPago',fld:'LEGFORMAPAGO',pic:'9'},{av:'A231LegBanSuc',fld:'LEGBANSUC',pic:'@!'},{av:'A232LegBanTipCuen',fld:'LEGBANTIPCUEN',pic:''},{av:'A247LegFecUltMod',fld:'LEGFECULTMOD',pic:''},{av:'A238LegCuentaBanc',fld:'LEGCUENTABANC',pic:'@!'},{av:'A253LegLicInicio',fld:'LEGLICINICIO',pic:''},{av:'A252LegLicFinal',fld:'LEGLICFINAL',pic:''},{av:'A234LegCBU',fld:'LEGCBU',pic:''},{av:'A262LegSCVO',fld:'LEGSCVO',pic:''},{av:'A228LegActivo',fld:'LEGACTIVO',pic:''},{av:'A264LegSueldoFuera',fld:'LEGSUELDOFUERA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A630LegFecImportacion',fld:'LEGFECIMPORTACION',pic:'99/99/99 99:99'},{av:'A877LegAgenReten',fld:'LEGAGENRETEN',pic:''},{av:'A879LegContinua',fld:'LEGCONTINUA',pic:''},{av:'A942LegRecalcLiq',fld:'LEGRECALCLIQ',pic:''},{av:'A1016LegJubilado',fld:'LEGJUBILADO',pic:''},{av:'A1023LegHorasDia',fld:'LEGHORASDIA',pic:'9.9'},{av:'A1268LegHorasSem',fld:'LEGHORASSEM',pic:'Z9.9'},{av:'A1235LegReligion',fld:'LEGRELIGION',pic:''},{av:'A1236LegOrigen',fld:'LEGORIGEN',pic:''},{av:'A1245LegTrabLun',fld:'LEGTRABLUN',pic:''},{av:'A1246LegTrabMar',fld:'LEGTRABMAR',pic:''},{av:'A1247LegTrabMie',fld:'LEGTRABMIE',pic:''},{av:'A1248LegTrabJue',fld:'LEGTRABJUE',pic:''},{av:'A1249LegTrabVie',fld:'LEGTRABVIE',pic:''},{av:'A1250LegTrabSa',fld:'LEGTRABSA',pic:''},{av:'A1251LegTrabDo',fld:'LEGTRABDO',pic:''},{av:'A1523LegVacPend',fld:'LEGVACPEND',pic:'ZZZ9'},{av:'A1531LegFecPreAviso',fld:'LEGFECPREAVISO',pic:''},{av:'A1576LegConveVersionCli',fld:'LEGCONVEVERSIONCLI',pic:'ZZZZZ9'},{av:'A1759LegPromDias',fld:'LEGPROMDIAS',pic:''},{av:'A1804LegTitulo',fld:'LEGTITULO',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A2267LegIncompleto',fld:'LEGINCOMPLETO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e135K2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV31DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV31DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true}]}");
      setEventMetadata("'CANCEL'","{handler:'e115K23',iparms:[{av:'AV31DetailWCInfo',fld:'vDETAILWCINFO',pic:'',hsh:true}]");
      setEventMetadata("'CANCEL'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1965EmpOsoCod',fld:'EMPOSOCOD',pic:''},{av:'A307OsoDescrip',fld:'OSODESCRIP',pic:''},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A45TipEmpleCod',fld:'TIPEMPLECOD',pic:''},{av:'A306OsoC3992',fld:'OSOC3992',pic:''},{av:'A681OsoDescripSinAc',fld:'OSODESCRIPSINAC',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A1965EmpOsoCod',fld:'EMPOSOCOD',pic:''},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A45TipEmpleCod',fld:'TIPEMPLECOD',pic:''},{av:'A307OsoDescrip',fld:'OSODESCRIP',pic:''},{av:'A306OsoC3992',fld:'OSOC3992',pic:''},{av:'A681OsoDescripSinAc',fld:'OSODESCRIPSINAC',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_LEGAPELLIDO","{handler:'valid_Legapellido',iparms:[]");
      setEventMetadata("VALID_LEGAPELLIDO",",oparms:[]}");
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
      pr_default.close(56);
      pr_default.close(57);
      pr_default.close(58);
      pr_default.close(59);
      pr_default.close(60);
      pr_default.close(61);
      pr_default.close(62);
      pr_default.close(54);
      pr_default.close(63);
      pr_default.close(66);
      pr_default.close(67);
      pr_default.close(64);
      pr_default.close(65);
      pr_default.close(68);
      pr_default.close(69);
      pr_default.close(55);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      Z230LegApellido = "" ;
      Z251LegNombre = "" ;
      Z257LegNumDoc = "" ;
      Z246LegFecNac = GXutil.nullDate() ;
      Z242LegDomici = "" ;
      Z479LegEmail = "" ;
      Z236LegCodPos = "" ;
      Z265LegTelefono = "" ;
      Z245LegFecIngreso = GXutil.nullDate() ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      Z939LegCatCodigo = "" ;
      Z231LegBanSuc = "" ;
      Z232LegBanTipCuen = "" ;
      Z247LegFecUltMod = GXutil.nullDate() ;
      Z238LegCuentaBanc = "" ;
      Z253LegLicInicio = GXutil.nullDate() ;
      Z252LegLicFinal = GXutil.nullDate() ;
      Z234LegCBU = "" ;
      Z264LegSueldoFuera = DecimalUtil.ZERO ;
      Z93LegId = "" ;
      Z937LegConveCodigo = "" ;
      Z630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      Z879LegContinua = "" ;
      Z1023LegHorasDia = DecimalUtil.ZERO ;
      Z1268LegHorasSem = DecimalUtil.ZERO ;
      Z1531LegFecPreAviso = GXutil.nullDate() ;
      Z1759LegPromDias = "" ;
      Z1804LegTitulo = "" ;
      Z1582LegBanCod = "" ;
      Z1581LegLpgCodigo = "" ;
      Z1583LegMegCodigo = "" ;
      Z1580LegOsoCod = "" ;
      Z1579LegSecCodigo = "" ;
      Z1577LegSucCodigo = "" ;
      Z1578LegPuesCodigo = "" ;
      Z18MprCod = "" ;
      Z20ZonCod = "" ;
      Z19SinieCodigo = "" ;
      Z910LegSinCod = "" ;
      Z15LegActCodigo = "" ;
      Z1235LegReligion = "" ;
      Z1236LegOrigen = "" ;
      N1583LegMegCodigo = "" ;
      N1579LegSecCodigo = "" ;
      N1581LegLpgCodigo = "" ;
      N1582LegBanCod = "" ;
      N910LegSinCod = "" ;
      N1580LegOsoCod = "" ;
      N15LegActCodigo = "" ;
      N18MprCod = "" ;
      N20ZonCod = "" ;
      N19SinieCodigo = "" ;
      N1578LegPuesCodigo = "" ;
      N1577LegSucCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A329SecDescrip = "" ;
      A291LpgDescri = "" ;
      A117BanDescrip = "" ;
      A331SinDescrip = "" ;
      A307OsoDescrip = "" ;
      A1582LegBanCod = "" ;
      A1581LegLpgCodigo = "" ;
      A1583LegMegCodigo = "" ;
      A1580LegOsoCod = "" ;
      A1579LegSecCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A1965EmpOsoCod = "" ;
      A1577LegSucCodigo = "" ;
      A18MprCod = "" ;
      A20ZonCod = "" ;
      A19SinieCodigo = "" ;
      A910LegSinCod = "" ;
      A15LegActCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sXEvt = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A230LegApellido = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV31DetailWCInfo = new web.wwpbaseobjects.SdtSplitScreenDetailInfo(remoteHandle, context);
      A265LegTelefono = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A939LegCatCodigo = "" ;
      A231LegBanSuc = "" ;
      A232LegBanTipCuen = "" ;
      A238LegCuentaBanc = "" ;
      A253LegLicInicio = GXutil.nullDate() ;
      A252LegLicFinal = GXutil.nullDate() ;
      A234LegCBU = "" ;
      A93LegId = "" ;
      A937LegConveCodigo = "" ;
      A1235LegReligion = "" ;
      A1236LegOrigen = "" ;
      A250LegIdNomApe = "" ;
      A591LegNomApe = "" ;
      A251LegNombre = "" ;
      A257LegNumDoc = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A242LegDomici = "" ;
      A479LegEmail = "" ;
      A236LegCodPos = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A247LegFecUltMod = GXutil.nullDate() ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      A879LegContinua = "" ;
      A1023LegHorasDia = DecimalUtil.ZERO ;
      A1268LegHorasSem = DecimalUtil.ZERO ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      A1759LegPromDias = "" ;
      A1804LegTitulo = "" ;
      A233LegBasico = DecimalUtil.ZERO ;
      A675SecDescripSinAc = "" ;
      A677LpgDescriSinAc = "" ;
      A679BanDescripSinAc = "" ;
      A680SinDescripSinAc = "" ;
      A681OsoDescripSinAc = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A555OsoSiglaYDesc = "" ;
      AV17Insert_LegMegCodigo = "" ;
      AV18Insert_LegSecCodigo = "" ;
      AV19Insert_LegLpgCodigo = "" ;
      AV20Insert_LegBanCod = "" ;
      AV38Insert_LegSinCod = "" ;
      AV21Insert_LegOsoCod = "" ;
      AV22Insert_LegActCodigo = "" ;
      AV23Insert_MprCod = "" ;
      AV24Insert_ZonCod = "" ;
      AV26Insert_SinieCodigo = "" ;
      AV27Insert_LegPuesCodigo = "" ;
      AV28Insert_LegSucCodigo = "" ;
      A249LegFoto = "" ;
      A515LegObs = "" ;
      A1031LegFotoExt = "" ;
      A1030LegFotoNom = "" ;
      A300MegDescrip = "" ;
      A2EmpNom = "" ;
      A45TipEmpleCod = "" ;
      A684MprDescripSinAc = "" ;
      A303MprDescrip = "" ;
      A678ZonDescripSinAc = "" ;
      A342ZonDescrip = "" ;
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      A686CondiDescriSinAc = "" ;
      A144CondiDescri = "" ;
      A688SinieDescriSinAc = "" ;
      A333SinieDescri = "" ;
      A258LegPaiNom = "" ;
      A260LegProvNom = "" ;
      A255LegLocNom = "" ;
      A256LegNacionalidad = "" ;
      A227LegActDescri = "" ;
      AV39Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode23 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV30TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z249LegFoto = "" ;
      Z515LegObs = "" ;
      Z1031LegFotoExt = "" ;
      Z1030LegFotoNom = "" ;
      Z684MprDescripSinAc = "" ;
      Z303MprDescrip = "" ;
      Z678ZonDescripSinAc = "" ;
      Z342ZonDescrip = "" ;
      Z343ZonPorcReduc = DecimalUtil.ZERO ;
      Z686CondiDescriSinAc = "" ;
      Z144CondiDescri = "" ;
      Z688SinieDescriSinAc = "" ;
      Z333SinieDescri = "" ;
      Z258LegPaiNom = "" ;
      Z260LegProvNom = "" ;
      Z255LegLocNom = "" ;
      Z256LegNacionalidad = "" ;
      Z331SinDescrip = "" ;
      Z227LegActDescri = "" ;
      Z291LpgDescri = "" ;
      Z300MegDescrip = "" ;
      Z392OsoSigla = "" ;
      Z329SecDescrip = "" ;
      Z45TipEmpleCod = "" ;
      Z1965EmpOsoCod = "" ;
      Z2EmpNom = "" ;
      Z307OsoDescrip = "" ;
      Z306OsoC3992 = "" ;
      T005K9_A45TipEmpleCod = new String[] {""} ;
      T005K9_n45TipEmpleCod = new boolean[] {false} ;
      T005K9_A1965EmpOsoCod = new String[] {""} ;
      T005K9_n1965EmpOsoCod = new boolean[] {false} ;
      T005K9_A2EmpNom = new String[] {""} ;
      T005K25_A307OsoDescrip = new String[] {""} ;
      T005K25_n307OsoDescrip = new boolean[] {false} ;
      T005K25_A306OsoC3992 = new String[] {""} ;
      T005K25_n306OsoC3992 = new boolean[] {false} ;
      T005K15_A688SinieDescriSinAc = new String[] {""} ;
      T005K15_A333SinieDescri = new String[] {""} ;
      T005K14_A686CondiDescriSinAc = new String[] {""} ;
      T005K14_A144CondiDescri = new String[] {""} ;
      T005K13_A678ZonDescripSinAc = new String[] {""} ;
      T005K13_A342ZonDescrip = new String[] {""} ;
      T005K13_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K12_A684MprDescripSinAc = new String[] {""} ;
      T005K12_A303MprDescrip = new String[] {""} ;
      T005K23_A227LegActDescri = new String[] {""} ;
      T005K7_A392OsoSigla = new String[] {""} ;
      T005K7_n392OsoSigla = new boolean[] {false} ;
      T005K5_A291LpgDescri = new String[] {""} ;
      T005K5_n291LpgDescri = new boolean[] {false} ;
      T005K8_A329SecDescrip = new String[] {""} ;
      T005K8_n329SecDescrip = new boolean[] {false} ;
      T005K6_A300MegDescrip = new String[] {""} ;
      T005K6_n300MegDescrip = new boolean[] {false} ;
      T005K18_A258LegPaiNom = new String[] {""} ;
      T005K19_A260LegProvNom = new String[] {""} ;
      T005K20_A255LegLocNom = new String[] {""} ;
      T005K22_A331SinDescrip = new String[] {""} ;
      T005K22_n331SinDescrip = new boolean[] {false} ;
      T005K21_A256LegNacionalidad = new String[] {""} ;
      T005K26_A15LegActCodigo = new String[] {""} ;
      T005K26_n15LegActCodigo = new boolean[] {false} ;
      T005K26_A1603LegSitRevEgreso = new short[1] ;
      T005K26_n1603LegSitRevEgreso = new boolean[] {false} ;
      T005K26_A45TipEmpleCod = new String[] {""} ;
      T005K26_n45TipEmpleCod = new boolean[] {false} ;
      T005K26_A1235LegReligion = new String[] {""} ;
      T005K26_n1235LegReligion = new boolean[] {false} ;
      T005K26_A1236LegOrigen = new String[] {""} ;
      T005K26_n1236LegOrigen = new boolean[] {false} ;
      T005K26_A1965EmpOsoCod = new String[] {""} ;
      T005K26_n1965EmpOsoCod = new boolean[] {false} ;
      T005K26_A237LegConvenio = new boolean[] {false} ;
      T005K26_A688SinieDescriSinAc = new String[] {""} ;
      T005K26_A686CondiDescriSinAc = new String[] {""} ;
      T005K26_A678ZonDescripSinAc = new String[] {""} ;
      T005K26_A684MprDescripSinAc = new String[] {""} ;
      T005K26_A250LegIdNomApe = new String[] {""} ;
      T005K26_A591LegNomApe = new String[] {""} ;
      T005K26_A6LegNumero = new int[1] ;
      T005K26_A2EmpNom = new String[] {""} ;
      T005K26_A230LegApellido = new String[] {""} ;
      T005K26_A251LegNombre = new String[] {""} ;
      T005K26_A249LegFoto = new String[] {""} ;
      T005K26_n249LegFoto = new boolean[] {false} ;
      T005K26_A266LegTipDoc = new byte[1] ;
      T005K26_A257LegNumDoc = new String[] {""} ;
      T005K26_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_A256LegNacionalidad = new String[] {""} ;
      T005K26_A239LegCUIL = new long[1] ;
      T005K26_A241LegDiscapacidad = new byte[1] ;
      T005K26_A242LegDomici = new String[] {""} ;
      T005K26_A479LegEmail = new String[] {""} ;
      T005K26_A236LegCodPos = new String[] {""} ;
      T005K26_A258LegPaiNom = new String[] {""} ;
      T005K26_A260LegProvNom = new String[] {""} ;
      T005K26_A255LegLocNom = new String[] {""} ;
      T005K26_A265LegTelefono = new String[] {""} ;
      T005K26_n265LegTelefono = new boolean[] {false} ;
      T005K26_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_n244LegFecEgreso = new boolean[] {false} ;
      T005K26_A300MegDescrip = new String[] {""} ;
      T005K26_n300MegDescrip = new boolean[] {false} ;
      T005K26_A939LegCatCodigo = new String[] {""} ;
      T005K26_n939LegCatCodigo = new boolean[] {false} ;
      T005K26_A329SecDescrip = new String[] {""} ;
      T005K26_n329SecDescrip = new boolean[] {false} ;
      T005K26_A291LpgDescri = new String[] {""} ;
      T005K26_n291LpgDescri = new boolean[] {false} ;
      T005K26_A235LegClase = new byte[1] ;
      T005K26_A248LegFormaPago = new byte[1] ;
      T005K26_A231LegBanSuc = new String[] {""} ;
      T005K26_n231LegBanSuc = new boolean[] {false} ;
      T005K26_A232LegBanTipCuen = new String[] {""} ;
      T005K26_n232LegBanTipCuen = new boolean[] {false} ;
      T005K26_A331SinDescrip = new String[] {""} ;
      T005K26_n331SinDescrip = new boolean[] {false} ;
      T005K26_A307OsoDescrip = new String[] {""} ;
      T005K26_n307OsoDescrip = new boolean[] {false} ;
      T005K26_A227LegActDescri = new String[] {""} ;
      T005K26_A303MprDescrip = new String[] {""} ;
      T005K26_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_A238LegCuentaBanc = new String[] {""} ;
      T005K26_n238LegCuentaBanc = new boolean[] {false} ;
      T005K26_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_n253LegLicInicio = new boolean[] {false} ;
      T005K26_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_n252LegLicFinal = new boolean[] {false} ;
      T005K26_A342ZonDescrip = new String[] {""} ;
      T005K26_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K26_A234LegCBU = new String[] {""} ;
      T005K26_n234LegCBU = new boolean[] {false} ;
      T005K26_A262LegSCVO = new boolean[] {false} ;
      T005K26_A144CondiDescri = new String[] {""} ;
      T005K26_A333SinieDescri = new String[] {""} ;
      T005K26_A228LegActivo = new boolean[] {false} ;
      T005K26_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K26_A93LegId = new String[] {""} ;
      T005K26_n93LegId = new boolean[] {false} ;
      T005K26_A937LegConveCodigo = new String[] {""} ;
      T005K26_n937LegConveCodigo = new boolean[] {false} ;
      T005K26_A306OsoC3992 = new String[] {""} ;
      T005K26_n306OsoC3992 = new boolean[] {false} ;
      T005K26_A515LegObs = new String[] {""} ;
      T005K26_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_A877LegAgenReten = new boolean[] {false} ;
      T005K26_A879LegContinua = new String[] {""} ;
      T005K26_A942LegRecalcLiq = new boolean[] {false} ;
      T005K26_A1016LegJubilado = new boolean[] {false} ;
      T005K26_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K26_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K26_A1245LegTrabLun = new boolean[] {false} ;
      T005K26_A1246LegTrabMar = new boolean[] {false} ;
      T005K26_A1247LegTrabMie = new boolean[] {false} ;
      T005K26_A1248LegTrabJue = new boolean[] {false} ;
      T005K26_A1249LegTrabVie = new boolean[] {false} ;
      T005K26_A1250LegTrabSa = new boolean[] {false} ;
      T005K26_A1251LegTrabDo = new boolean[] {false} ;
      T005K26_A1523LegVacPend = new short[1] ;
      T005K26_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K26_A1576LegConveVersionCli = new int[1] ;
      T005K26_n1576LegConveVersionCli = new boolean[] {false} ;
      T005K26_A1759LegPromDias = new String[] {""} ;
      T005K26_A1804LegTitulo = new String[] {""} ;
      T005K26_A1818LegEstado = new byte[1] ;
      T005K26_A2267LegIncompleto = new boolean[] {false} ;
      T005K26_A1031LegFotoExt = new String[] {""} ;
      T005K26_A1030LegFotoNom = new String[] {""} ;
      T005K26_A392OsoSigla = new String[] {""} ;
      T005K26_n392OsoSigla = new boolean[] {false} ;
      T005K26_A3CliCod = new int[1] ;
      T005K26_A1582LegBanCod = new String[] {""} ;
      T005K26_n1582LegBanCod = new boolean[] {false} ;
      T005K26_A1581LegLpgCodigo = new String[] {""} ;
      T005K26_n1581LegLpgCodigo = new boolean[] {false} ;
      T005K26_A1583LegMegCodigo = new String[] {""} ;
      T005K26_n1583LegMegCodigo = new boolean[] {false} ;
      T005K26_A1580LegOsoCod = new String[] {""} ;
      T005K26_n1580LegOsoCod = new boolean[] {false} ;
      T005K26_A1579LegSecCodigo = new String[] {""} ;
      T005K26_n1579LegSecCodigo = new boolean[] {false} ;
      T005K26_A1EmpCod = new short[1] ;
      T005K26_A1577LegSucCodigo = new String[] {""} ;
      T005K26_n1577LegSucCodigo = new boolean[] {false} ;
      T005K26_A1578LegPuesCodigo = new String[] {""} ;
      T005K26_n1578LegPuesCodigo = new boolean[] {false} ;
      T005K26_A18MprCod = new String[] {""} ;
      T005K26_n18MprCod = new boolean[] {false} ;
      T005K26_A20ZonCod = new String[] {""} ;
      T005K26_n20ZonCod = new boolean[] {false} ;
      T005K26_A17CondiCodigo = new short[1] ;
      T005K26_n17CondiCodigo = new boolean[] {false} ;
      T005K26_A19SinieCodigo = new String[] {""} ;
      T005K26_n19SinieCodigo = new boolean[] {false} ;
      T005K26_A263LegSexo = new byte[1] ;
      T005K26_n263LegSexo = new boolean[] {false} ;
      T005K26_A243LegEstadoCivil = new short[1] ;
      T005K26_n243LegEstadoCivil = new boolean[] {false} ;
      T005K26_A22LegPaiCod = new short[1] ;
      T005K26_n22LegPaiCod = new boolean[] {false} ;
      T005K26_A23LegProvCod = new short[1] ;
      T005K26_n23LegProvCod = new boolean[] {false} ;
      T005K26_A24LegLocCod = new short[1] ;
      T005K26_n24LegLocCod = new boolean[] {false} ;
      T005K26_A21LegNacionCod = new short[1] ;
      T005K26_n21LegNacionCod = new boolean[] {false} ;
      T005K26_A910LegSinCod = new String[] {""} ;
      T005K26_n910LegSinCod = new boolean[] {false} ;
      A249LegFoto_Filetype = "" ;
      A249LegFoto_Filename = "" ;
      T005K4_A3CliCod = new int[1] ;
      T005K11_A3CliCod = new int[1] ;
      T005K10_A3CliCod = new int[1] ;
      T005K16_A263LegSexo = new byte[1] ;
      T005K16_n263LegSexo = new boolean[] {false} ;
      T005K17_A243LegEstadoCivil = new short[1] ;
      T005K17_n243LegEstadoCivil = new boolean[] {false} ;
      T005K24_A1603LegSitRevEgreso = new short[1] ;
      T005K24_n1603LegSitRevEgreso = new boolean[] {false} ;
      T005K27_A3CliCod = new int[1] ;
      T005K28_A291LpgDescri = new String[] {""} ;
      T005K28_n291LpgDescri = new boolean[] {false} ;
      T005K29_A300MegDescrip = new String[] {""} ;
      T005K29_n300MegDescrip = new boolean[] {false} ;
      T005K30_A392OsoSigla = new String[] {""} ;
      T005K30_n392OsoSigla = new boolean[] {false} ;
      T005K31_A329SecDescrip = new String[] {""} ;
      T005K31_n329SecDescrip = new boolean[] {false} ;
      T005K32_A3CliCod = new int[1] ;
      T005K33_A45TipEmpleCod = new String[] {""} ;
      T005K33_n45TipEmpleCod = new boolean[] {false} ;
      T005K33_A1965EmpOsoCod = new String[] {""} ;
      T005K33_n1965EmpOsoCod = new boolean[] {false} ;
      T005K33_A2EmpNom = new String[] {""} ;
      T005K34_A307OsoDescrip = new String[] {""} ;
      T005K34_n307OsoDescrip = new boolean[] {false} ;
      T005K34_A306OsoC3992 = new String[] {""} ;
      T005K34_n306OsoC3992 = new boolean[] {false} ;
      T005K35_A3CliCod = new int[1] ;
      T005K36_A684MprDescripSinAc = new String[] {""} ;
      T005K36_A303MprDescrip = new String[] {""} ;
      T005K37_A678ZonDescripSinAc = new String[] {""} ;
      T005K37_A342ZonDescrip = new String[] {""} ;
      T005K37_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K38_A686CondiDescriSinAc = new String[] {""} ;
      T005K38_A144CondiDescri = new String[] {""} ;
      T005K39_A688SinieDescriSinAc = new String[] {""} ;
      T005K39_A333SinieDescri = new String[] {""} ;
      T005K40_A263LegSexo = new byte[1] ;
      T005K40_n263LegSexo = new boolean[] {false} ;
      T005K41_A243LegEstadoCivil = new short[1] ;
      T005K41_n243LegEstadoCivil = new boolean[] {false} ;
      T005K42_A258LegPaiNom = new String[] {""} ;
      T005K43_A260LegProvNom = new String[] {""} ;
      T005K44_A255LegLocNom = new String[] {""} ;
      T005K45_A331SinDescrip = new String[] {""} ;
      T005K45_n331SinDescrip = new boolean[] {false} ;
      T005K46_A256LegNacionalidad = new String[] {""} ;
      T005K47_A227LegActDescri = new String[] {""} ;
      T005K48_A1603LegSitRevEgreso = new short[1] ;
      T005K48_n1603LegSitRevEgreso = new boolean[] {false} ;
      T005K49_A3CliCod = new int[1] ;
      T005K49_A1EmpCod = new short[1] ;
      T005K49_A6LegNumero = new int[1] ;
      T005K3_A15LegActCodigo = new String[] {""} ;
      T005K3_n15LegActCodigo = new boolean[] {false} ;
      T005K3_A1603LegSitRevEgreso = new short[1] ;
      T005K3_n1603LegSitRevEgreso = new boolean[] {false} ;
      T005K3_A1235LegReligion = new String[] {""} ;
      T005K3_n1235LegReligion = new boolean[] {false} ;
      T005K3_A1236LegOrigen = new String[] {""} ;
      T005K3_n1236LegOrigen = new boolean[] {false} ;
      T005K3_A237LegConvenio = new boolean[] {false} ;
      T005K3_A250LegIdNomApe = new String[] {""} ;
      T005K3_A591LegNomApe = new String[] {""} ;
      T005K3_A6LegNumero = new int[1] ;
      T005K3_A230LegApellido = new String[] {""} ;
      T005K3_A251LegNombre = new String[] {""} ;
      T005K3_A249LegFoto = new String[] {""} ;
      T005K3_n249LegFoto = new boolean[] {false} ;
      T005K3_A266LegTipDoc = new byte[1] ;
      T005K3_A257LegNumDoc = new String[] {""} ;
      T005K3_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_A239LegCUIL = new long[1] ;
      T005K3_A241LegDiscapacidad = new byte[1] ;
      T005K3_A242LegDomici = new String[] {""} ;
      T005K3_A479LegEmail = new String[] {""} ;
      T005K3_A236LegCodPos = new String[] {""} ;
      T005K3_A265LegTelefono = new String[] {""} ;
      T005K3_n265LegTelefono = new boolean[] {false} ;
      T005K3_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_n244LegFecEgreso = new boolean[] {false} ;
      T005K3_A939LegCatCodigo = new String[] {""} ;
      T005K3_n939LegCatCodigo = new boolean[] {false} ;
      T005K3_A235LegClase = new byte[1] ;
      T005K3_A248LegFormaPago = new byte[1] ;
      T005K3_A231LegBanSuc = new String[] {""} ;
      T005K3_n231LegBanSuc = new boolean[] {false} ;
      T005K3_A232LegBanTipCuen = new String[] {""} ;
      T005K3_n232LegBanTipCuen = new boolean[] {false} ;
      T005K3_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_A238LegCuentaBanc = new String[] {""} ;
      T005K3_n238LegCuentaBanc = new boolean[] {false} ;
      T005K3_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_n253LegLicInicio = new boolean[] {false} ;
      T005K3_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_n252LegLicFinal = new boolean[] {false} ;
      T005K3_A234LegCBU = new String[] {""} ;
      T005K3_n234LegCBU = new boolean[] {false} ;
      T005K3_A262LegSCVO = new boolean[] {false} ;
      T005K3_A228LegActivo = new boolean[] {false} ;
      T005K3_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K3_A93LegId = new String[] {""} ;
      T005K3_n93LegId = new boolean[] {false} ;
      T005K3_A937LegConveCodigo = new String[] {""} ;
      T005K3_n937LegConveCodigo = new boolean[] {false} ;
      T005K3_A515LegObs = new String[] {""} ;
      T005K3_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_A877LegAgenReten = new boolean[] {false} ;
      T005K3_A879LegContinua = new String[] {""} ;
      T005K3_A942LegRecalcLiq = new boolean[] {false} ;
      T005K3_A1016LegJubilado = new boolean[] {false} ;
      T005K3_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K3_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K3_A1245LegTrabLun = new boolean[] {false} ;
      T005K3_A1246LegTrabMar = new boolean[] {false} ;
      T005K3_A1247LegTrabMie = new boolean[] {false} ;
      T005K3_A1248LegTrabJue = new boolean[] {false} ;
      T005K3_A1249LegTrabVie = new boolean[] {false} ;
      T005K3_A1250LegTrabSa = new boolean[] {false} ;
      T005K3_A1251LegTrabDo = new boolean[] {false} ;
      T005K3_A1523LegVacPend = new short[1] ;
      T005K3_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K3_A1576LegConveVersionCli = new int[1] ;
      T005K3_n1576LegConveVersionCli = new boolean[] {false} ;
      T005K3_A1759LegPromDias = new String[] {""} ;
      T005K3_A1804LegTitulo = new String[] {""} ;
      T005K3_A1818LegEstado = new byte[1] ;
      T005K3_A2267LegIncompleto = new boolean[] {false} ;
      T005K3_A1031LegFotoExt = new String[] {""} ;
      T005K3_A1030LegFotoNom = new String[] {""} ;
      T005K3_A3CliCod = new int[1] ;
      T005K3_A1582LegBanCod = new String[] {""} ;
      T005K3_n1582LegBanCod = new boolean[] {false} ;
      T005K3_A1581LegLpgCodigo = new String[] {""} ;
      T005K3_n1581LegLpgCodigo = new boolean[] {false} ;
      T005K3_A1583LegMegCodigo = new String[] {""} ;
      T005K3_n1583LegMegCodigo = new boolean[] {false} ;
      T005K3_A1580LegOsoCod = new String[] {""} ;
      T005K3_n1580LegOsoCod = new boolean[] {false} ;
      T005K3_A1579LegSecCodigo = new String[] {""} ;
      T005K3_n1579LegSecCodigo = new boolean[] {false} ;
      T005K3_A1EmpCod = new short[1] ;
      T005K3_A1577LegSucCodigo = new String[] {""} ;
      T005K3_n1577LegSucCodigo = new boolean[] {false} ;
      T005K3_A1578LegPuesCodigo = new String[] {""} ;
      T005K3_n1578LegPuesCodigo = new boolean[] {false} ;
      T005K3_A18MprCod = new String[] {""} ;
      T005K3_n18MprCod = new boolean[] {false} ;
      T005K3_A20ZonCod = new String[] {""} ;
      T005K3_n20ZonCod = new boolean[] {false} ;
      T005K3_A17CondiCodigo = new short[1] ;
      T005K3_n17CondiCodigo = new boolean[] {false} ;
      T005K3_A19SinieCodigo = new String[] {""} ;
      T005K3_n19SinieCodigo = new boolean[] {false} ;
      T005K3_A263LegSexo = new byte[1] ;
      T005K3_n263LegSexo = new boolean[] {false} ;
      T005K3_A243LegEstadoCivil = new short[1] ;
      T005K3_n243LegEstadoCivil = new boolean[] {false} ;
      T005K3_A22LegPaiCod = new short[1] ;
      T005K3_n22LegPaiCod = new boolean[] {false} ;
      T005K3_A23LegProvCod = new short[1] ;
      T005K3_n23LegProvCod = new boolean[] {false} ;
      T005K3_A24LegLocCod = new short[1] ;
      T005K3_n24LegLocCod = new boolean[] {false} ;
      T005K3_A21LegNacionCod = new short[1] ;
      T005K3_n21LegNacionCod = new boolean[] {false} ;
      T005K3_A910LegSinCod = new String[] {""} ;
      T005K3_n910LegSinCod = new boolean[] {false} ;
      T005K50_A3CliCod = new int[1] ;
      T005K50_A1EmpCod = new short[1] ;
      T005K50_A6LegNumero = new int[1] ;
      T005K51_A3CliCod = new int[1] ;
      T005K51_A1EmpCod = new short[1] ;
      T005K51_A6LegNumero = new int[1] ;
      T005K2_A15LegActCodigo = new String[] {""} ;
      T005K2_n15LegActCodigo = new boolean[] {false} ;
      T005K2_A1603LegSitRevEgreso = new short[1] ;
      T005K2_n1603LegSitRevEgreso = new boolean[] {false} ;
      T005K2_A1235LegReligion = new String[] {""} ;
      T005K2_n1235LegReligion = new boolean[] {false} ;
      T005K2_A1236LegOrigen = new String[] {""} ;
      T005K2_n1236LegOrigen = new boolean[] {false} ;
      T005K2_A237LegConvenio = new boolean[] {false} ;
      T005K2_A250LegIdNomApe = new String[] {""} ;
      T005K2_A591LegNomApe = new String[] {""} ;
      T005K2_A6LegNumero = new int[1] ;
      T005K2_A230LegApellido = new String[] {""} ;
      T005K2_A251LegNombre = new String[] {""} ;
      T005K2_A249LegFoto = new String[] {""} ;
      T005K2_n249LegFoto = new boolean[] {false} ;
      T005K2_A266LegTipDoc = new byte[1] ;
      T005K2_A257LegNumDoc = new String[] {""} ;
      T005K2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_A239LegCUIL = new long[1] ;
      T005K2_A241LegDiscapacidad = new byte[1] ;
      T005K2_A242LegDomici = new String[] {""} ;
      T005K2_A479LegEmail = new String[] {""} ;
      T005K2_A236LegCodPos = new String[] {""} ;
      T005K2_A265LegTelefono = new String[] {""} ;
      T005K2_n265LegTelefono = new boolean[] {false} ;
      T005K2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_n244LegFecEgreso = new boolean[] {false} ;
      T005K2_A939LegCatCodigo = new String[] {""} ;
      T005K2_n939LegCatCodigo = new boolean[] {false} ;
      T005K2_A235LegClase = new byte[1] ;
      T005K2_A248LegFormaPago = new byte[1] ;
      T005K2_A231LegBanSuc = new String[] {""} ;
      T005K2_n231LegBanSuc = new boolean[] {false} ;
      T005K2_A232LegBanTipCuen = new String[] {""} ;
      T005K2_n232LegBanTipCuen = new boolean[] {false} ;
      T005K2_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_A238LegCuentaBanc = new String[] {""} ;
      T005K2_n238LegCuentaBanc = new boolean[] {false} ;
      T005K2_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_n253LegLicInicio = new boolean[] {false} ;
      T005K2_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_n252LegLicFinal = new boolean[] {false} ;
      T005K2_A234LegCBU = new String[] {""} ;
      T005K2_n234LegCBU = new boolean[] {false} ;
      T005K2_A262LegSCVO = new boolean[] {false} ;
      T005K2_A228LegActivo = new boolean[] {false} ;
      T005K2_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K2_A93LegId = new String[] {""} ;
      T005K2_n93LegId = new boolean[] {false} ;
      T005K2_A937LegConveCodigo = new String[] {""} ;
      T005K2_n937LegConveCodigo = new boolean[] {false} ;
      T005K2_A515LegObs = new String[] {""} ;
      T005K2_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_A877LegAgenReten = new boolean[] {false} ;
      T005K2_A879LegContinua = new String[] {""} ;
      T005K2_A942LegRecalcLiq = new boolean[] {false} ;
      T005K2_A1016LegJubilado = new boolean[] {false} ;
      T005K2_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K2_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K2_A1245LegTrabLun = new boolean[] {false} ;
      T005K2_A1246LegTrabMar = new boolean[] {false} ;
      T005K2_A1247LegTrabMie = new boolean[] {false} ;
      T005K2_A1248LegTrabJue = new boolean[] {false} ;
      T005K2_A1249LegTrabVie = new boolean[] {false} ;
      T005K2_A1250LegTrabSa = new boolean[] {false} ;
      T005K2_A1251LegTrabDo = new boolean[] {false} ;
      T005K2_A1523LegVacPend = new short[1] ;
      T005K2_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      T005K2_A1576LegConveVersionCli = new int[1] ;
      T005K2_n1576LegConveVersionCli = new boolean[] {false} ;
      T005K2_A1759LegPromDias = new String[] {""} ;
      T005K2_A1804LegTitulo = new String[] {""} ;
      T005K2_A1818LegEstado = new byte[1] ;
      T005K2_A2267LegIncompleto = new boolean[] {false} ;
      T005K2_A1031LegFotoExt = new String[] {""} ;
      T005K2_A1030LegFotoNom = new String[] {""} ;
      T005K2_A3CliCod = new int[1] ;
      T005K2_A1582LegBanCod = new String[] {""} ;
      T005K2_n1582LegBanCod = new boolean[] {false} ;
      T005K2_A1581LegLpgCodigo = new String[] {""} ;
      T005K2_n1581LegLpgCodigo = new boolean[] {false} ;
      T005K2_A1583LegMegCodigo = new String[] {""} ;
      T005K2_n1583LegMegCodigo = new boolean[] {false} ;
      T005K2_A1580LegOsoCod = new String[] {""} ;
      T005K2_n1580LegOsoCod = new boolean[] {false} ;
      T005K2_A1579LegSecCodigo = new String[] {""} ;
      T005K2_n1579LegSecCodigo = new boolean[] {false} ;
      T005K2_A1EmpCod = new short[1] ;
      T005K2_A1577LegSucCodigo = new String[] {""} ;
      T005K2_n1577LegSucCodigo = new boolean[] {false} ;
      T005K2_A1578LegPuesCodigo = new String[] {""} ;
      T005K2_n1578LegPuesCodigo = new boolean[] {false} ;
      T005K2_A18MprCod = new String[] {""} ;
      T005K2_n18MprCod = new boolean[] {false} ;
      T005K2_A20ZonCod = new String[] {""} ;
      T005K2_n20ZonCod = new boolean[] {false} ;
      T005K2_A17CondiCodigo = new short[1] ;
      T005K2_n17CondiCodigo = new boolean[] {false} ;
      T005K2_A19SinieCodigo = new String[] {""} ;
      T005K2_n19SinieCodigo = new boolean[] {false} ;
      T005K2_A263LegSexo = new byte[1] ;
      T005K2_n263LegSexo = new boolean[] {false} ;
      T005K2_A243LegEstadoCivil = new short[1] ;
      T005K2_n243LegEstadoCivil = new boolean[] {false} ;
      T005K2_A22LegPaiCod = new short[1] ;
      T005K2_n22LegPaiCod = new boolean[] {false} ;
      T005K2_A23LegProvCod = new short[1] ;
      T005K2_n23LegProvCod = new boolean[] {false} ;
      T005K2_A24LegLocCod = new short[1] ;
      T005K2_n24LegLocCod = new boolean[] {false} ;
      T005K2_A21LegNacionCod = new short[1] ;
      T005K2_n21LegNacionCod = new boolean[] {false} ;
      T005K2_A910LegSinCod = new String[] {""} ;
      T005K2_n910LegSinCod = new boolean[] {false} ;
      T005K56_A1965EmpOsoCod = new String[] {""} ;
      T005K56_n1965EmpOsoCod = new boolean[] {false} ;
      T005K56_A2EmpNom = new String[] {""} ;
      T005K56_A45TipEmpleCod = new String[] {""} ;
      T005K56_n45TipEmpleCod = new boolean[] {false} ;
      T005K57_A307OsoDescrip = new String[] {""} ;
      T005K57_n307OsoDescrip = new boolean[] {false} ;
      T005K57_A306OsoC3992 = new String[] {""} ;
      T005K57_n306OsoC3992 = new boolean[] {false} ;
      T005K58_A291LpgDescri = new String[] {""} ;
      T005K58_n291LpgDescri = new boolean[] {false} ;
      T005K59_A300MegDescrip = new String[] {""} ;
      T005K59_n300MegDescrip = new boolean[] {false} ;
      T005K60_A392OsoSigla = new String[] {""} ;
      T005K60_n392OsoSigla = new boolean[] {false} ;
      T005K61_A329SecDescrip = new String[] {""} ;
      T005K61_n329SecDescrip = new boolean[] {false} ;
      T005K62_A684MprDescripSinAc = new String[] {""} ;
      T005K62_A303MprDescrip = new String[] {""} ;
      T005K63_A678ZonDescripSinAc = new String[] {""} ;
      T005K63_A342ZonDescrip = new String[] {""} ;
      T005K63_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005K64_A686CondiDescriSinAc = new String[] {""} ;
      T005K64_A144CondiDescri = new String[] {""} ;
      T005K65_A688SinieDescriSinAc = new String[] {""} ;
      T005K65_A333SinieDescri = new String[] {""} ;
      T005K66_A258LegPaiNom = new String[] {""} ;
      T005K67_A260LegProvNom = new String[] {""} ;
      T005K68_A255LegLocNom = new String[] {""} ;
      T005K69_A256LegNacionalidad = new String[] {""} ;
      T005K70_A331SinDescrip = new String[] {""} ;
      T005K70_n331SinDescrip = new boolean[] {false} ;
      T005K71_A227LegActDescri = new String[] {""} ;
      T005K72_A3CliCod = new int[1] ;
      T005K72_A1EmpCod = new short[1] ;
      T005K72_A6LegNumero = new int[1] ;
      T005K72_A2243LegCuenLicTpo = new String[] {""} ;
      T005K72_A2266LegCuenAnio = new short[1] ;
      T005K73_A3CliCod = new int[1] ;
      T005K73_A1EmpCod = new short[1] ;
      T005K73_A6LegNumero = new int[1] ;
      T005K73_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T005K74_A3CliCod = new int[1] ;
      T005K74_A1EmpCod = new short[1] ;
      T005K74_A6LegNumero = new int[1] ;
      T005K74_A2230LegPropCod = new String[] {""} ;
      T005K75_A3CliCod = new int[1] ;
      T005K75_A1EmpCod = new short[1] ;
      T005K75_A6LegNumero = new int[1] ;
      T005K75_A1829PreliqTLiqCod = new String[] {""} ;
      T005K75_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T005K76_A3CliCod = new int[1] ;
      T005K76_A1EmpCod = new short[1] ;
      T005K76_A6LegNumero = new int[1] ;
      T005K76_A1319LegTipoTra = new String[] {""} ;
      T005K77_A3CliCod = new int[1] ;
      T005K77_A1EmpCod = new short[1] ;
      T005K77_A6LegNumero = new int[1] ;
      T005K77_A1172OblSecuencial = new short[1] ;
      T005K78_A3CliCod = new int[1] ;
      T005K78_A1EmpCod = new short[1] ;
      T005K78_A6LegNumero = new int[1] ;
      T005K78_A1135LegSuelSec = new short[1] ;
      T005K79_A3CliCod = new int[1] ;
      T005K79_A1EmpCod = new short[1] ;
      T005K79_A784F1357CTipoPre = new byte[1] ;
      T005K79_A777F1357CPer = new String[] {""} ;
      T005K79_A778F1357CSec = new byte[1] ;
      T005K79_A6LegNumero = new int[1] ;
      T005K79_A797F1357LRTipReg = new String[] {""} ;
      T005K80_A3CliCod = new int[1] ;
      T005K80_A1EmpCod = new short[1] ;
      T005K80_A784F1357CTipoPre = new byte[1] ;
      T005K80_A777F1357CPer = new String[] {""} ;
      T005K80_A778F1357CSec = new byte[1] ;
      T005K80_A6LegNumero = new int[1] ;
      T005K80_A863F1357LDGTipReg = new String[] {""} ;
      T005K81_A3CliCod = new int[1] ;
      T005K81_A1EmpCod = new short[1] ;
      T005K81_A784F1357CTipoPre = new byte[1] ;
      T005K81_A777F1357CPer = new String[] {""} ;
      T005K81_A778F1357CSec = new byte[1] ;
      T005K81_A6LegNumero = new int[1] ;
      T005K81_A786F1357LTipoReg = new String[] {""} ;
      T005K82_A3CliCod = new int[1] ;
      T005K82_A1EmpCod = new short[1] ;
      T005K82_A784F1357CTipoPre = new byte[1] ;
      T005K82_A777F1357CPer = new String[] {""} ;
      T005K82_A778F1357CSec = new byte[1] ;
      T005K82_A6LegNumero = new int[1] ;
      T005K82_A862F1357LDPTipReg = new String[] {""} ;
      T005K83_A3CliCod = new int[1] ;
      T005K83_A1EmpCod = new short[1] ;
      T005K83_A784F1357CTipoPre = new byte[1] ;
      T005K83_A777F1357CPer = new String[] {""} ;
      T005K83_A778F1357CSec = new byte[1] ;
      T005K83_A6LegNumero = new int[1] ;
      T005K83_A861F1357LCTipReg = new String[] {""} ;
      T005K84_A3CliCod = new int[1] ;
      T005K84_A1EmpCod = new short[1] ;
      T005K84_A6LegNumero = new int[1] ;
      T005K84_A83LegDedSec = new int[1] ;
      T005K85_A3CliCod = new int[1] ;
      T005K85_A1EmpCod = new short[1] ;
      T005K85_A6LegNumero = new int[1] ;
      T005K85_A77CenCodigo = new short[1] ;
      T005K86_A3CliCod = new int[1] ;
      T005K86_A1EmpCod = new short[1] ;
      T005K86_A6LegNumero = new int[1] ;
      T005K86_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T005K87_A3CliCod = new int[1] ;
      T005K87_A1EmpCod = new short[1] ;
      T005K87_A31LiqNro = new int[1] ;
      T005K87_A6LegNumero = new int[1] ;
      T005K88_A3CliCod = new int[1] ;
      T005K88_A1EmpCod = new short[1] ;
      T005K88_A6LegNumero = new int[1] ;
      T005K88_A29LegOrden = new short[1] ;
      T005K89_A3CliCod = new int[1] ;
      T005K89_A1EmpCod = new short[1] ;
      T005K89_A6LegNumero = new int[1] ;
      T005K89_A25AgeOrden = new short[1] ;
      T005K90_A3CliCod = new int[1] ;
      T005K90_A1EmpCod = new short[1] ;
      T005K90_A6LegNumero = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      sCtrlGx_mode = "" ;
      sCtrlAV7CliCod = "" ;
      sCtrlAV8EmpCod = "" ;
      sCtrlAV10LegNumero = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      Z681OsoDescripSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajos__default(),
         new Object[] {
             new Object[] {
            T005K2_A15LegActCodigo, T005K2_n15LegActCodigo, T005K2_A1603LegSitRevEgreso, T005K2_n1603LegSitRevEgreso, T005K2_A1235LegReligion, T005K2_n1235LegReligion, T005K2_A1236LegOrigen, T005K2_n1236LegOrigen, T005K2_A237LegConvenio, T005K2_A250LegIdNomApe,
            T005K2_A591LegNomApe, T005K2_A6LegNumero, T005K2_A230LegApellido, T005K2_A251LegNombre, T005K2_A249LegFoto, T005K2_n249LegFoto, T005K2_A266LegTipDoc, T005K2_A257LegNumDoc, T005K2_A246LegFecNac, T005K2_A239LegCUIL,
            T005K2_A241LegDiscapacidad, T005K2_A242LegDomici, T005K2_A479LegEmail, T005K2_A236LegCodPos, T005K2_A265LegTelefono, T005K2_n265LegTelefono, T005K2_A245LegFecIngreso, T005K2_A244LegFecEgreso, T005K2_n244LegFecEgreso, T005K2_A939LegCatCodigo,
            T005K2_n939LegCatCodigo, T005K2_A235LegClase, T005K2_A248LegFormaPago, T005K2_A231LegBanSuc, T005K2_n231LegBanSuc, T005K2_A232LegBanTipCuen, T005K2_n232LegBanTipCuen, T005K2_A247LegFecUltMod, T005K2_A238LegCuentaBanc, T005K2_n238LegCuentaBanc,
            T005K2_A253LegLicInicio, T005K2_n253LegLicInicio, T005K2_A252LegLicFinal, T005K2_n252LegLicFinal, T005K2_A234LegCBU, T005K2_n234LegCBU, T005K2_A262LegSCVO, T005K2_A228LegActivo, T005K2_A264LegSueldoFuera, T005K2_A93LegId,
            T005K2_n93LegId, T005K2_A937LegConveCodigo, T005K2_n937LegConveCodigo, T005K2_A515LegObs, T005K2_A630LegFecImportacion, T005K2_A877LegAgenReten, T005K2_A879LegContinua, T005K2_A942LegRecalcLiq, T005K2_A1016LegJubilado, T005K2_A1023LegHorasDia,
            T005K2_A1268LegHorasSem, T005K2_A1245LegTrabLun, T005K2_A1246LegTrabMar, T005K2_A1247LegTrabMie, T005K2_A1248LegTrabJue, T005K2_A1249LegTrabVie, T005K2_A1250LegTrabSa, T005K2_A1251LegTrabDo, T005K2_A1523LegVacPend, T005K2_A1531LegFecPreAviso,
            T005K2_A1576LegConveVersionCli, T005K2_n1576LegConveVersionCli, T005K2_A1759LegPromDias, T005K2_A1804LegTitulo, T005K2_A1818LegEstado, T005K2_A2267LegIncompleto, T005K2_A1031LegFotoExt, T005K2_A1030LegFotoNom, T005K2_A3CliCod, T005K2_A1582LegBanCod,
            T005K2_n1582LegBanCod, T005K2_A1581LegLpgCodigo, T005K2_n1581LegLpgCodigo, T005K2_A1583LegMegCodigo, T005K2_n1583LegMegCodigo, T005K2_A1580LegOsoCod, T005K2_n1580LegOsoCod, T005K2_A1579LegSecCodigo, T005K2_n1579LegSecCodigo, T005K2_A1EmpCod,
            T005K2_A1577LegSucCodigo, T005K2_n1577LegSucCodigo, T005K2_A1578LegPuesCodigo, T005K2_n1578LegPuesCodigo, T005K2_A18MprCod, T005K2_n18MprCod, T005K2_A20ZonCod, T005K2_n20ZonCod, T005K2_A17CondiCodigo, T005K2_n17CondiCodigo,
            T005K2_A19SinieCodigo, T005K2_n19SinieCodigo, T005K2_A263LegSexo, T005K2_n263LegSexo, T005K2_A243LegEstadoCivil, T005K2_n243LegEstadoCivil, T005K2_A22LegPaiCod, T005K2_n22LegPaiCod, T005K2_A23LegProvCod, T005K2_n23LegProvCod,
            T005K2_A24LegLocCod, T005K2_n24LegLocCod, T005K2_A21LegNacionCod, T005K2_n21LegNacionCod, T005K2_A910LegSinCod, T005K2_n910LegSinCod
            }
            , new Object[] {
            T005K3_A15LegActCodigo, T005K3_n15LegActCodigo, T005K3_A1603LegSitRevEgreso, T005K3_n1603LegSitRevEgreso, T005K3_A1235LegReligion, T005K3_n1235LegReligion, T005K3_A1236LegOrigen, T005K3_n1236LegOrigen, T005K3_A237LegConvenio, T005K3_A250LegIdNomApe,
            T005K3_A591LegNomApe, T005K3_A6LegNumero, T005K3_A230LegApellido, T005K3_A251LegNombre, T005K3_A249LegFoto, T005K3_n249LegFoto, T005K3_A266LegTipDoc, T005K3_A257LegNumDoc, T005K3_A246LegFecNac, T005K3_A239LegCUIL,
            T005K3_A241LegDiscapacidad, T005K3_A242LegDomici, T005K3_A479LegEmail, T005K3_A236LegCodPos, T005K3_A265LegTelefono, T005K3_n265LegTelefono, T005K3_A245LegFecIngreso, T005K3_A244LegFecEgreso, T005K3_n244LegFecEgreso, T005K3_A939LegCatCodigo,
            T005K3_n939LegCatCodigo, T005K3_A235LegClase, T005K3_A248LegFormaPago, T005K3_A231LegBanSuc, T005K3_n231LegBanSuc, T005K3_A232LegBanTipCuen, T005K3_n232LegBanTipCuen, T005K3_A247LegFecUltMod, T005K3_A238LegCuentaBanc, T005K3_n238LegCuentaBanc,
            T005K3_A253LegLicInicio, T005K3_n253LegLicInicio, T005K3_A252LegLicFinal, T005K3_n252LegLicFinal, T005K3_A234LegCBU, T005K3_n234LegCBU, T005K3_A262LegSCVO, T005K3_A228LegActivo, T005K3_A264LegSueldoFuera, T005K3_A93LegId,
            T005K3_n93LegId, T005K3_A937LegConveCodigo, T005K3_n937LegConveCodigo, T005K3_A515LegObs, T005K3_A630LegFecImportacion, T005K3_A877LegAgenReten, T005K3_A879LegContinua, T005K3_A942LegRecalcLiq, T005K3_A1016LegJubilado, T005K3_A1023LegHorasDia,
            T005K3_A1268LegHorasSem, T005K3_A1245LegTrabLun, T005K3_A1246LegTrabMar, T005K3_A1247LegTrabMie, T005K3_A1248LegTrabJue, T005K3_A1249LegTrabVie, T005K3_A1250LegTrabSa, T005K3_A1251LegTrabDo, T005K3_A1523LegVacPend, T005K3_A1531LegFecPreAviso,
            T005K3_A1576LegConveVersionCli, T005K3_n1576LegConveVersionCli, T005K3_A1759LegPromDias, T005K3_A1804LegTitulo, T005K3_A1818LegEstado, T005K3_A2267LegIncompleto, T005K3_A1031LegFotoExt, T005K3_A1030LegFotoNom, T005K3_A3CliCod, T005K3_A1582LegBanCod,
            T005K3_n1582LegBanCod, T005K3_A1581LegLpgCodigo, T005K3_n1581LegLpgCodigo, T005K3_A1583LegMegCodigo, T005K3_n1583LegMegCodigo, T005K3_A1580LegOsoCod, T005K3_n1580LegOsoCod, T005K3_A1579LegSecCodigo, T005K3_n1579LegSecCodigo, T005K3_A1EmpCod,
            T005K3_A1577LegSucCodigo, T005K3_n1577LegSucCodigo, T005K3_A1578LegPuesCodigo, T005K3_n1578LegPuesCodigo, T005K3_A18MprCod, T005K3_n18MprCod, T005K3_A20ZonCod, T005K3_n20ZonCod, T005K3_A17CondiCodigo, T005K3_n17CondiCodigo,
            T005K3_A19SinieCodigo, T005K3_n19SinieCodigo, T005K3_A263LegSexo, T005K3_n263LegSexo, T005K3_A243LegEstadoCivil, T005K3_n243LegEstadoCivil, T005K3_A22LegPaiCod, T005K3_n22LegPaiCod, T005K3_A23LegProvCod, T005K3_n23LegProvCod,
            T005K3_A24LegLocCod, T005K3_n24LegLocCod, T005K3_A21LegNacionCod, T005K3_n21LegNacionCod, T005K3_A910LegSinCod, T005K3_n910LegSinCod
            }
            , new Object[] {
            T005K4_A3CliCod
            }
            , new Object[] {
            T005K5_A291LpgDescri, T005K5_n291LpgDescri
            }
            , new Object[] {
            T005K6_A300MegDescrip, T005K6_n300MegDescrip
            }
            , new Object[] {
            T005K7_A392OsoSigla, T005K7_n392OsoSigla
            }
            , new Object[] {
            T005K8_A329SecDescrip, T005K8_n329SecDescrip
            }
            , new Object[] {
            T005K9_A45TipEmpleCod, T005K9_n45TipEmpleCod, T005K9_A1965EmpOsoCod, T005K9_n1965EmpOsoCod, T005K9_A2EmpNom
            }
            , new Object[] {
            T005K10_A3CliCod
            }
            , new Object[] {
            T005K11_A3CliCod
            }
            , new Object[] {
            T005K12_A684MprDescripSinAc, T005K12_A303MprDescrip
            }
            , new Object[] {
            T005K13_A678ZonDescripSinAc, T005K13_A342ZonDescrip, T005K13_A343ZonPorcReduc
            }
            , new Object[] {
            T005K14_A686CondiDescriSinAc, T005K14_A144CondiDescri
            }
            , new Object[] {
            T005K15_A688SinieDescriSinAc, T005K15_A333SinieDescri
            }
            , new Object[] {
            T005K16_A263LegSexo
            }
            , new Object[] {
            T005K17_A243LegEstadoCivil
            }
            , new Object[] {
            T005K18_A258LegPaiNom
            }
            , new Object[] {
            T005K19_A260LegProvNom
            }
            , new Object[] {
            T005K20_A255LegLocNom
            }
            , new Object[] {
            T005K21_A256LegNacionalidad
            }
            , new Object[] {
            T005K22_A331SinDescrip, T005K22_n331SinDescrip
            }
            , new Object[] {
            T005K23_A227LegActDescri
            }
            , new Object[] {
            T005K24_A1603LegSitRevEgreso
            }
            , new Object[] {
            T005K25_A307OsoDescrip, T005K25_n307OsoDescrip, T005K25_A306OsoC3992, T005K25_n306OsoC3992
            }
            , new Object[] {
            T005K26_A15LegActCodigo, T005K26_n15LegActCodigo, T005K26_A1603LegSitRevEgreso, T005K26_n1603LegSitRevEgreso, T005K26_A45TipEmpleCod, T005K26_n45TipEmpleCod, T005K26_A1235LegReligion, T005K26_n1235LegReligion, T005K26_A1236LegOrigen, T005K26_n1236LegOrigen,
            T005K26_A1965EmpOsoCod, T005K26_n1965EmpOsoCod, T005K26_A237LegConvenio, T005K26_A688SinieDescriSinAc, T005K26_A686CondiDescriSinAc, T005K26_A678ZonDescripSinAc, T005K26_A684MprDescripSinAc, T005K26_A250LegIdNomApe, T005K26_A591LegNomApe, T005K26_A6LegNumero,
            T005K26_A2EmpNom, T005K26_A230LegApellido, T005K26_A251LegNombre, T005K26_A249LegFoto, T005K26_n249LegFoto, T005K26_A266LegTipDoc, T005K26_A257LegNumDoc, T005K26_A246LegFecNac, T005K26_A256LegNacionalidad, T005K26_A239LegCUIL,
            T005K26_A241LegDiscapacidad, T005K26_A242LegDomici, T005K26_A479LegEmail, T005K26_A236LegCodPos, T005K26_A258LegPaiNom, T005K26_A260LegProvNom, T005K26_A255LegLocNom, T005K26_A265LegTelefono, T005K26_n265LegTelefono, T005K26_A245LegFecIngreso,
            T005K26_A244LegFecEgreso, T005K26_n244LegFecEgreso, T005K26_A300MegDescrip, T005K26_n300MegDescrip, T005K26_A939LegCatCodigo, T005K26_n939LegCatCodigo, T005K26_A329SecDescrip, T005K26_n329SecDescrip, T005K26_A291LpgDescri, T005K26_n291LpgDescri,
            T005K26_A235LegClase, T005K26_A248LegFormaPago, T005K26_A231LegBanSuc, T005K26_n231LegBanSuc, T005K26_A232LegBanTipCuen, T005K26_n232LegBanTipCuen, T005K26_A331SinDescrip, T005K26_n331SinDescrip, T005K26_A307OsoDescrip, T005K26_n307OsoDescrip,
            T005K26_A227LegActDescri, T005K26_A303MprDescrip, T005K26_A247LegFecUltMod, T005K26_A238LegCuentaBanc, T005K26_n238LegCuentaBanc, T005K26_A253LegLicInicio, T005K26_n253LegLicInicio, T005K26_A252LegLicFinal, T005K26_n252LegLicFinal, T005K26_A342ZonDescrip,
            T005K26_A343ZonPorcReduc, T005K26_A234LegCBU, T005K26_n234LegCBU, T005K26_A262LegSCVO, T005K26_A144CondiDescri, T005K26_A333SinieDescri, T005K26_A228LegActivo, T005K26_A264LegSueldoFuera, T005K26_A93LegId, T005K26_n93LegId,
            T005K26_A937LegConveCodigo, T005K26_n937LegConveCodigo, T005K26_A306OsoC3992, T005K26_n306OsoC3992, T005K26_A515LegObs, T005K26_A630LegFecImportacion, T005K26_A877LegAgenReten, T005K26_A879LegContinua, T005K26_A942LegRecalcLiq, T005K26_A1016LegJubilado,
            T005K26_A1023LegHorasDia, T005K26_A1268LegHorasSem, T005K26_A1245LegTrabLun, T005K26_A1246LegTrabMar, T005K26_A1247LegTrabMie, T005K26_A1248LegTrabJue, T005K26_A1249LegTrabVie, T005K26_A1250LegTrabSa, T005K26_A1251LegTrabDo, T005K26_A1523LegVacPend,
            T005K26_A1531LegFecPreAviso, T005K26_A1576LegConveVersionCli, T005K26_n1576LegConveVersionCli, T005K26_A1759LegPromDias, T005K26_A1804LegTitulo, T005K26_A1818LegEstado, T005K26_A2267LegIncompleto, T005K26_A1031LegFotoExt, T005K26_A1030LegFotoNom, T005K26_A392OsoSigla,
            T005K26_n392OsoSigla, T005K26_A3CliCod, T005K26_A1582LegBanCod, T005K26_n1582LegBanCod, T005K26_A1581LegLpgCodigo, T005K26_n1581LegLpgCodigo, T005K26_A1583LegMegCodigo, T005K26_n1583LegMegCodigo, T005K26_A1580LegOsoCod, T005K26_n1580LegOsoCod,
            T005K26_A1579LegSecCodigo, T005K26_n1579LegSecCodigo, T005K26_A1EmpCod, T005K26_A1577LegSucCodigo, T005K26_n1577LegSucCodigo, T005K26_A1578LegPuesCodigo, T005K26_n1578LegPuesCodigo, T005K26_A18MprCod, T005K26_n18MprCod, T005K26_A20ZonCod,
            T005K26_n20ZonCod, T005K26_A17CondiCodigo, T005K26_n17CondiCodigo, T005K26_A19SinieCodigo, T005K26_n19SinieCodigo, T005K26_A263LegSexo, T005K26_n263LegSexo, T005K26_A243LegEstadoCivil, T005K26_n243LegEstadoCivil, T005K26_A22LegPaiCod,
            T005K26_n22LegPaiCod, T005K26_A23LegProvCod, T005K26_n23LegProvCod, T005K26_A24LegLocCod, T005K26_n24LegLocCod, T005K26_A21LegNacionCod, T005K26_n21LegNacionCod, T005K26_A910LegSinCod, T005K26_n910LegSinCod
            }
            , new Object[] {
            T005K27_A3CliCod
            }
            , new Object[] {
            T005K28_A291LpgDescri, T005K28_n291LpgDescri
            }
            , new Object[] {
            T005K29_A300MegDescrip, T005K29_n300MegDescrip
            }
            , new Object[] {
            T005K30_A392OsoSigla, T005K30_n392OsoSigla
            }
            , new Object[] {
            T005K31_A329SecDescrip, T005K31_n329SecDescrip
            }
            , new Object[] {
            T005K32_A3CliCod
            }
            , new Object[] {
            T005K33_A45TipEmpleCod, T005K33_n45TipEmpleCod, T005K33_A1965EmpOsoCod, T005K33_n1965EmpOsoCod, T005K33_A2EmpNom
            }
            , new Object[] {
            T005K34_A307OsoDescrip, T005K34_n307OsoDescrip, T005K34_A306OsoC3992, T005K34_n306OsoC3992
            }
            , new Object[] {
            T005K35_A3CliCod
            }
            , new Object[] {
            T005K36_A684MprDescripSinAc, T005K36_A303MprDescrip
            }
            , new Object[] {
            T005K37_A678ZonDescripSinAc, T005K37_A342ZonDescrip, T005K37_A343ZonPorcReduc
            }
            , new Object[] {
            T005K38_A686CondiDescriSinAc, T005K38_A144CondiDescri
            }
            , new Object[] {
            T005K39_A688SinieDescriSinAc, T005K39_A333SinieDescri
            }
            , new Object[] {
            T005K40_A263LegSexo
            }
            , new Object[] {
            T005K41_A243LegEstadoCivil
            }
            , new Object[] {
            T005K42_A258LegPaiNom
            }
            , new Object[] {
            T005K43_A260LegProvNom
            }
            , new Object[] {
            T005K44_A255LegLocNom
            }
            , new Object[] {
            T005K45_A331SinDescrip, T005K45_n331SinDescrip
            }
            , new Object[] {
            T005K46_A256LegNacionalidad
            }
            , new Object[] {
            T005K47_A227LegActDescri
            }
            , new Object[] {
            T005K48_A1603LegSitRevEgreso
            }
            , new Object[] {
            T005K49_A3CliCod, T005K49_A1EmpCod, T005K49_A6LegNumero
            }
            , new Object[] {
            T005K50_A3CliCod, T005K50_A1EmpCod, T005K50_A6LegNumero
            }
            , new Object[] {
            T005K51_A3CliCod, T005K51_A1EmpCod, T005K51_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005K56_A1965EmpOsoCod, T005K56_n1965EmpOsoCod, T005K56_A2EmpNom, T005K56_A45TipEmpleCod, T005K56_n45TipEmpleCod
            }
            , new Object[] {
            T005K57_A307OsoDescrip, T005K57_n307OsoDescrip, T005K57_A306OsoC3992, T005K57_n306OsoC3992
            }
            , new Object[] {
            T005K58_A291LpgDescri, T005K58_n291LpgDescri
            }
            , new Object[] {
            T005K59_A300MegDescrip, T005K59_n300MegDescrip
            }
            , new Object[] {
            T005K60_A392OsoSigla, T005K60_n392OsoSigla
            }
            , new Object[] {
            T005K61_A329SecDescrip, T005K61_n329SecDescrip
            }
            , new Object[] {
            T005K62_A684MprDescripSinAc, T005K62_A303MprDescrip
            }
            , new Object[] {
            T005K63_A678ZonDescripSinAc, T005K63_A342ZonDescrip, T005K63_A343ZonPorcReduc
            }
            , new Object[] {
            T005K64_A686CondiDescriSinAc, T005K64_A144CondiDescri
            }
            , new Object[] {
            T005K65_A688SinieDescriSinAc, T005K65_A333SinieDescri
            }
            , new Object[] {
            T005K66_A258LegPaiNom
            }
            , new Object[] {
            T005K67_A260LegProvNom
            }
            , new Object[] {
            T005K68_A255LegLocNom
            }
            , new Object[] {
            T005K69_A256LegNacionalidad
            }
            , new Object[] {
            T005K70_A331SinDescrip, T005K70_n331SinDescrip
            }
            , new Object[] {
            T005K71_A227LegActDescri
            }
            , new Object[] {
            T005K72_A3CliCod, T005K72_A1EmpCod, T005K72_A6LegNumero, T005K72_A2243LegCuenLicTpo, T005K72_A2266LegCuenAnio
            }
            , new Object[] {
            T005K73_A3CliCod, T005K73_A1EmpCod, T005K73_A6LegNumero, T005K73_A2253LegHisFecIng
            }
            , new Object[] {
            T005K74_A3CliCod, T005K74_A1EmpCod, T005K74_A6LegNumero, T005K74_A2230LegPropCod
            }
            , new Object[] {
            T005K75_A3CliCod, T005K75_A1EmpCod, T005K75_A6LegNumero, T005K75_A1829PreliqTLiqCod, T005K75_A1830PreliqPeriodo
            }
            , new Object[] {
            T005K76_A3CliCod, T005K76_A1EmpCod, T005K76_A6LegNumero, T005K76_A1319LegTipoTra
            }
            , new Object[] {
            T005K77_A3CliCod, T005K77_A1EmpCod, T005K77_A6LegNumero, T005K77_A1172OblSecuencial
            }
            , new Object[] {
            T005K78_A3CliCod, T005K78_A1EmpCod, T005K78_A6LegNumero, T005K78_A1135LegSuelSec
            }
            , new Object[] {
            T005K79_A3CliCod, T005K79_A1EmpCod, T005K79_A784F1357CTipoPre, T005K79_A777F1357CPer, T005K79_A778F1357CSec, T005K79_A6LegNumero, T005K79_A797F1357LRTipReg
            }
            , new Object[] {
            T005K80_A3CliCod, T005K80_A1EmpCod, T005K80_A784F1357CTipoPre, T005K80_A777F1357CPer, T005K80_A778F1357CSec, T005K80_A6LegNumero, T005K80_A863F1357LDGTipReg
            }
            , new Object[] {
            T005K81_A3CliCod, T005K81_A1EmpCod, T005K81_A784F1357CTipoPre, T005K81_A777F1357CPer, T005K81_A778F1357CSec, T005K81_A6LegNumero, T005K81_A786F1357LTipoReg
            }
            , new Object[] {
            T005K82_A3CliCod, T005K82_A1EmpCod, T005K82_A784F1357CTipoPre, T005K82_A777F1357CPer, T005K82_A778F1357CSec, T005K82_A6LegNumero, T005K82_A862F1357LDPTipReg
            }
            , new Object[] {
            T005K83_A3CliCod, T005K83_A1EmpCod, T005K83_A784F1357CTipoPre, T005K83_A777F1357CPer, T005K83_A778F1357CSec, T005K83_A6LegNumero, T005K83_A861F1357LCTipReg
            }
            , new Object[] {
            T005K84_A3CliCod, T005K84_A1EmpCod, T005K84_A6LegNumero, T005K84_A83LegDedSec
            }
            , new Object[] {
            T005K85_A3CliCod, T005K85_A1EmpCod, T005K85_A6LegNumero, T005K85_A77CenCodigo
            }
            , new Object[] {
            T005K86_A3CliCod, T005K86_A1EmpCod, T005K86_A6LegNumero, T005K86_A76LegLicenIni
            }
            , new Object[] {
            T005K87_A3CliCod, T005K87_A1EmpCod, T005K87_A31LiqNro, T005K87_A6LegNumero
            }
            , new Object[] {
            T005K88_A3CliCod, T005K88_A1EmpCod, T005K88_A6LegNumero, T005K88_A29LegOrden
            }
            , new Object[] {
            T005K89_A3CliCod, T005K89_A1EmpCod, T005K89_A6LegNumero, T005K89_A25AgeOrden
            }
            , new Object[] {
            T005K90_A3CliCod, T005K90_A1EmpCod, T005K90_A6LegNumero
            }
         }
      );
      AV39Pgmname = "Legajos" ;
   }

   private byte Z266LegTipDoc ;
   private byte Z241LegDiscapacidad ;
   private byte Z235LegClase ;
   private byte Z248LegFormaPago ;
   private byte Z1818LegEstado ;
   private byte Z263LegSexo ;
   private byte N263LegSexo ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A263LegSexo ;
   private byte nKeyPressed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A266LegTipDoc ;
   private byte A241LegDiscapacidad ;
   private byte A235LegClase ;
   private byte A248LegFormaPago ;
   private byte A1818LegEstado ;
   private byte AV33Insert_LegSexo ;
   private byte Gx_BScreen ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z1523LegVacPend ;
   private short Z17CondiCodigo ;
   private short Z243LegEstadoCivil ;
   private short Z22LegPaiCod ;
   private short Z23LegProvCod ;
   private short Z24LegLocCod ;
   private short Z21LegNacionCod ;
   private short Z1603LegSitRevEgreso ;
   private short N243LegEstadoCivil ;
   private short N21LegNacionCod ;
   private short N22LegPaiCod ;
   private short N23LegProvCod ;
   private short N24LegLocCod ;
   private short N17CondiCodigo ;
   private short N1603LegSitRevEgreso ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A17CondiCodigo ;
   private short A243LegEstadoCivil ;
   private short A22LegPaiCod ;
   private short A23LegProvCod ;
   private short A24LegLocCod ;
   private short A21LegNacionCod ;
   private short A1603LegSitRevEgreso ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1523LegVacPend ;
   private short AV34Insert_LegEstadoCivil ;
   private short AV16Insert_LegNacionCod ;
   private short AV35Insert_LegPaiCod ;
   private short AV36Insert_LegProvCod ;
   private short AV37Insert_LegLocCod ;
   private short AV25Insert_CondiCodigo ;
   private short AV29Insert_LegSitRevEgreso ;
   private short RcdFound23 ;
   private short nIsDirty_23 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV10LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z1576LegConveVersionCli ;
   private int AV7CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int A6LegNumero ;
   private int edtLegNumero_Enabled ;
   private int edtLegApellido_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int A1576LegConveVersionCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV40GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long Z239LegCUIL ;
   private long A239LegCUIL ;
   private java.math.BigDecimal Z264LegSueldoFuera ;
   private java.math.BigDecimal Z1023LegHorasDia ;
   private java.math.BigDecimal Z1268LegHorasSem ;
   private java.math.BigDecimal A264LegSueldoFuera ;
   private java.math.BigDecimal A1023LegHorasDia ;
   private java.math.BigDecimal A1268LegHorasSem ;
   private java.math.BigDecimal A233LegBasico ;
   private java.math.BigDecimal A343ZonPorcReduc ;
   private java.math.BigDecimal Z343ZonPorcReduc ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z236LegCodPos ;
   private String Z939LegCatCodigo ;
   private String Z232LegBanTipCuen ;
   private String Z93LegId ;
   private String Z937LegConveCodigo ;
   private String Z879LegContinua ;
   private String Z1804LegTitulo ;
   private String Z1582LegBanCod ;
   private String Z1581LegLpgCodigo ;
   private String Z1583LegMegCodigo ;
   private String Z1580LegOsoCod ;
   private String Z1579LegSecCodigo ;
   private String Z1577LegSucCodigo ;
   private String Z1578LegPuesCodigo ;
   private String Z18MprCod ;
   private String Z20ZonCod ;
   private String Z19SinieCodigo ;
   private String Z910LegSinCod ;
   private String Z15LegActCodigo ;
   private String Z1235LegReligion ;
   private String Z1236LegOrigen ;
   private String N1583LegMegCodigo ;
   private String N1579LegSecCodigo ;
   private String N1581LegLpgCodigo ;
   private String N1582LegBanCod ;
   private String N910LegSinCod ;
   private String N1580LegOsoCod ;
   private String N15LegActCodigo ;
   private String N18MprCod ;
   private String N20ZonCod ;
   private String N19SinieCodigo ;
   private String N1578LegPuesCodigo ;
   private String N1577LegSucCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String A1582LegBanCod ;
   private String A1581LegLpgCodigo ;
   private String A1583LegMegCodigo ;
   private String A1580LegOsoCod ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private String A1965EmpOsoCod ;
   private String A1577LegSucCodigo ;
   private String A18MprCod ;
   private String A20ZonCod ;
   private String A19SinieCodigo ;
   private String A910LegSinCod ;
   private String A15LegActCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String sXEvt ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegApellido_Internalname ;
   private String edtLegApellido_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String A939LegCatCodigo ;
   private String A232LegBanTipCuen ;
   private String A93LegId ;
   private String A937LegConveCodigo ;
   private String A1235LegReligion ;
   private String A1236LegOrigen ;
   private String A236LegCodPos ;
   private String A879LegContinua ;
   private String A1804LegTitulo ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String AV17Insert_LegMegCodigo ;
   private String AV18Insert_LegSecCodigo ;
   private String AV19Insert_LegLpgCodigo ;
   private String AV20Insert_LegBanCod ;
   private String AV38Insert_LegSinCod ;
   private String AV21Insert_LegOsoCod ;
   private String AV22Insert_LegActCodigo ;
   private String AV23Insert_MprCod ;
   private String AV24Insert_ZonCod ;
   private String AV26Insert_SinieCodigo ;
   private String AV27Insert_LegPuesCodigo ;
   private String AV28Insert_LegSucCodigo ;
   private String A1031LegFotoExt ;
   private String A45TipEmpleCod ;
   private String AV39Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode23 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1031LegFotoExt ;
   private String Z392OsoSigla ;
   private String Z45TipEmpleCod ;
   private String Z1965EmpOsoCod ;
   private String Z306OsoC3992 ;
   private String A249LegFoto_Filetype ;
   private String A249LegFoto_Filename ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String sCtrlGx_mode ;
   private String sCtrlAV7CliCod ;
   private String sCtrlAV8EmpCod ;
   private String sCtrlAV10LegNumero ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date Z630LegFecImportacion ;
   private java.util.Date A630LegFecImportacion ;
   private java.util.Date Z246LegFecNac ;
   private java.util.Date Z245LegFecIngreso ;
   private java.util.Date Z244LegFecEgreso ;
   private java.util.Date Z247LegFecUltMod ;
   private java.util.Date Z253LegLicInicio ;
   private java.util.Date Z252LegLicFinal ;
   private java.util.Date Z1531LegFecPreAviso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A253LegLicInicio ;
   private java.util.Date A252LegLicFinal ;
   private java.util.Date A246LegFecNac ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A247LegFecUltMod ;
   private java.util.Date A1531LegFecPreAviso ;
   private boolean Z237LegConvenio ;
   private boolean Z262LegSCVO ;
   private boolean Z228LegActivo ;
   private boolean Z877LegAgenReten ;
   private boolean Z942LegRecalcLiq ;
   private boolean Z1016LegJubilado ;
   private boolean Z1245LegTrabLun ;
   private boolean Z1246LegTrabMar ;
   private boolean Z1247LegTrabMie ;
   private boolean Z1248LegTrabJue ;
   private boolean Z1249LegTrabVie ;
   private boolean Z1250LegTrabSa ;
   private boolean Z1251LegTrabDo ;
   private boolean Z2267LegIncompleto ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n329SecDescrip ;
   private boolean n291LpgDescri ;
   private boolean n331SinDescrip ;
   private boolean n307OsoDescrip ;
   private boolean n1582LegBanCod ;
   private boolean n1581LegLpgCodigo ;
   private boolean n1583LegMegCodigo ;
   private boolean n1580LegOsoCod ;
   private boolean n1579LegSecCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1965EmpOsoCod ;
   private boolean n1577LegSucCodigo ;
   private boolean n18MprCod ;
   private boolean n20ZonCod ;
   private boolean n17CondiCodigo ;
   private boolean n19SinieCodigo ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private boolean n22LegPaiCod ;
   private boolean n23LegProvCod ;
   private boolean n24LegLocCod ;
   private boolean n910LegSinCod ;
   private boolean n21LegNacionCod ;
   private boolean n15LegActCodigo ;
   private boolean n1603LegSitRevEgreso ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n265LegTelefono ;
   private boolean n244LegFecEgreso ;
   private boolean n939LegCatCodigo ;
   private boolean n231LegBanSuc ;
   private boolean n232LegBanTipCuen ;
   private boolean n238LegCuentaBanc ;
   private boolean n253LegLicInicio ;
   private boolean n252LegLicFinal ;
   private boolean n234LegCBU ;
   private boolean n93LegId ;
   private boolean n937LegConveCodigo ;
   private boolean n1576LegConveVersionCli ;
   private boolean n1235LegReligion ;
   private boolean n1236LegOrigen ;
   private boolean A237LegConvenio ;
   private boolean A262LegSCVO ;
   private boolean A228LegActivo ;
   private boolean A877LegAgenReten ;
   private boolean A942LegRecalcLiq ;
   private boolean A1016LegJubilado ;
   private boolean A1245LegTrabLun ;
   private boolean A1246LegTrabMar ;
   private boolean A1247LegTrabMie ;
   private boolean A1248LegTrabJue ;
   private boolean A1249LegTrabVie ;
   private boolean A1250LegTrabSa ;
   private boolean A1251LegTrabDo ;
   private boolean A2267LegIncompleto ;
   private boolean n392OsoSigla ;
   private boolean n306OsoC3992 ;
   private boolean n249LegFoto ;
   private boolean n300MegDescrip ;
   private boolean n45TipEmpleCod ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String A515LegObs ;
   private String Z515LegObs ;
   private String A249LegFoto ;
   private String Z249LegFoto ;
   private String Z250LegIdNomApe ;
   private String Z591LegNomApe ;
   private String Z230LegApellido ;
   private String Z251LegNombre ;
   private String Z257LegNumDoc ;
   private String Z242LegDomici ;
   private String Z479LegEmail ;
   private String Z265LegTelefono ;
   private String Z231LegBanSuc ;
   private String Z238LegCuentaBanc ;
   private String Z234LegCBU ;
   private String Z1759LegPromDias ;
   private String A329SecDescrip ;
   private String A291LpgDescri ;
   private String A117BanDescrip ;
   private String A331SinDescrip ;
   private String A307OsoDescrip ;
   private String A230LegApellido ;
   private String A265LegTelefono ;
   private String A231LegBanSuc ;
   private String A238LegCuentaBanc ;
   private String A234LegCBU ;
   private String A250LegIdNomApe ;
   private String A591LegNomApe ;
   private String A251LegNombre ;
   private String A257LegNumDoc ;
   private String A242LegDomici ;
   private String A479LegEmail ;
   private String A1759LegPromDias ;
   private String A675SecDescripSinAc ;
   private String A677LpgDescriSinAc ;
   private String A679BanDescripSinAc ;
   private String A680SinDescripSinAc ;
   private String A681OsoDescripSinAc ;
   private String A555OsoSiglaYDesc ;
   private String A1030LegFotoNom ;
   private String A300MegDescrip ;
   private String A2EmpNom ;
   private String A684MprDescripSinAc ;
   private String A303MprDescrip ;
   private String A678ZonDescripSinAc ;
   private String A342ZonDescrip ;
   private String A686CondiDescriSinAc ;
   private String A144CondiDescri ;
   private String A688SinieDescriSinAc ;
   private String A333SinieDescri ;
   private String A258LegPaiNom ;
   private String A260LegProvNom ;
   private String A255LegLocNom ;
   private String A256LegNacionalidad ;
   private String A227LegActDescri ;
   private String Z1030LegFotoNom ;
   private String Z684MprDescripSinAc ;
   private String Z303MprDescrip ;
   private String Z678ZonDescripSinAc ;
   private String Z342ZonDescrip ;
   private String Z686CondiDescriSinAc ;
   private String Z144CondiDescri ;
   private String Z688SinieDescriSinAc ;
   private String Z333SinieDescri ;
   private String Z258LegPaiNom ;
   private String Z260LegProvNom ;
   private String Z255LegLocNom ;
   private String Z256LegNacionalidad ;
   private String Z331SinDescrip ;
   private String Z227LegActDescri ;
   private String Z291LpgDescri ;
   private String Z300MegDescrip ;
   private String Z329SecDescrip ;
   private String Z2EmpNom ;
   private String Z307OsoDescrip ;
   private String Z681OsoDescripSinAc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T005K9_A45TipEmpleCod ;
   private boolean[] T005K9_n45TipEmpleCod ;
   private String[] T005K9_A1965EmpOsoCod ;
   private boolean[] T005K9_n1965EmpOsoCod ;
   private String[] T005K9_A2EmpNom ;
   private String[] T005K25_A307OsoDescrip ;
   private boolean[] T005K25_n307OsoDescrip ;
   private String[] T005K25_A306OsoC3992 ;
   private boolean[] T005K25_n306OsoC3992 ;
   private String[] T005K15_A688SinieDescriSinAc ;
   private String[] T005K15_A333SinieDescri ;
   private String[] T005K14_A686CondiDescriSinAc ;
   private String[] T005K14_A144CondiDescri ;
   private String[] T005K13_A678ZonDescripSinAc ;
   private String[] T005K13_A342ZonDescrip ;
   private java.math.BigDecimal[] T005K13_A343ZonPorcReduc ;
   private String[] T005K12_A684MprDescripSinAc ;
   private String[] T005K12_A303MprDescrip ;
   private String[] T005K23_A227LegActDescri ;
   private String[] T005K7_A392OsoSigla ;
   private boolean[] T005K7_n392OsoSigla ;
   private String[] T005K5_A291LpgDescri ;
   private boolean[] T005K5_n291LpgDescri ;
   private String[] T005K8_A329SecDescrip ;
   private boolean[] T005K8_n329SecDescrip ;
   private String[] T005K6_A300MegDescrip ;
   private boolean[] T005K6_n300MegDescrip ;
   private String[] T005K18_A258LegPaiNom ;
   private String[] T005K19_A260LegProvNom ;
   private String[] T005K20_A255LegLocNom ;
   private String[] T005K22_A331SinDescrip ;
   private boolean[] T005K22_n331SinDescrip ;
   private String[] T005K21_A256LegNacionalidad ;
   private String[] T005K26_A15LegActCodigo ;
   private boolean[] T005K26_n15LegActCodigo ;
   private short[] T005K26_A1603LegSitRevEgreso ;
   private boolean[] T005K26_n1603LegSitRevEgreso ;
   private String[] T005K26_A45TipEmpleCod ;
   private boolean[] T005K26_n45TipEmpleCod ;
   private String[] T005K26_A1235LegReligion ;
   private boolean[] T005K26_n1235LegReligion ;
   private String[] T005K26_A1236LegOrigen ;
   private boolean[] T005K26_n1236LegOrigen ;
   private String[] T005K26_A1965EmpOsoCod ;
   private boolean[] T005K26_n1965EmpOsoCod ;
   private boolean[] T005K26_A237LegConvenio ;
   private String[] T005K26_A688SinieDescriSinAc ;
   private String[] T005K26_A686CondiDescriSinAc ;
   private String[] T005K26_A678ZonDescripSinAc ;
   private String[] T005K26_A684MprDescripSinAc ;
   private String[] T005K26_A250LegIdNomApe ;
   private String[] T005K26_A591LegNomApe ;
   private int[] T005K26_A6LegNumero ;
   private String[] T005K26_A2EmpNom ;
   private String[] T005K26_A230LegApellido ;
   private String[] T005K26_A251LegNombre ;
   private String[] T005K26_A249LegFoto ;
   private boolean[] T005K26_n249LegFoto ;
   private byte[] T005K26_A266LegTipDoc ;
   private String[] T005K26_A257LegNumDoc ;
   private java.util.Date[] T005K26_A246LegFecNac ;
   private String[] T005K26_A256LegNacionalidad ;
   private long[] T005K26_A239LegCUIL ;
   private byte[] T005K26_A241LegDiscapacidad ;
   private String[] T005K26_A242LegDomici ;
   private String[] T005K26_A479LegEmail ;
   private String[] T005K26_A236LegCodPos ;
   private String[] T005K26_A258LegPaiNom ;
   private String[] T005K26_A260LegProvNom ;
   private String[] T005K26_A255LegLocNom ;
   private String[] T005K26_A265LegTelefono ;
   private boolean[] T005K26_n265LegTelefono ;
   private java.util.Date[] T005K26_A245LegFecIngreso ;
   private java.util.Date[] T005K26_A244LegFecEgreso ;
   private boolean[] T005K26_n244LegFecEgreso ;
   private String[] T005K26_A300MegDescrip ;
   private boolean[] T005K26_n300MegDescrip ;
   private String[] T005K26_A939LegCatCodigo ;
   private boolean[] T005K26_n939LegCatCodigo ;
   private String[] T005K26_A329SecDescrip ;
   private boolean[] T005K26_n329SecDescrip ;
   private String[] T005K26_A291LpgDescri ;
   private boolean[] T005K26_n291LpgDescri ;
   private byte[] T005K26_A235LegClase ;
   private byte[] T005K26_A248LegFormaPago ;
   private String[] T005K26_A231LegBanSuc ;
   private boolean[] T005K26_n231LegBanSuc ;
   private String[] T005K26_A232LegBanTipCuen ;
   private boolean[] T005K26_n232LegBanTipCuen ;
   private String[] T005K26_A331SinDescrip ;
   private boolean[] T005K26_n331SinDescrip ;
   private String[] T005K26_A307OsoDescrip ;
   private boolean[] T005K26_n307OsoDescrip ;
   private String[] T005K26_A227LegActDescri ;
   private String[] T005K26_A303MprDescrip ;
   private java.util.Date[] T005K26_A247LegFecUltMod ;
   private String[] T005K26_A238LegCuentaBanc ;
   private boolean[] T005K26_n238LegCuentaBanc ;
   private java.util.Date[] T005K26_A253LegLicInicio ;
   private boolean[] T005K26_n253LegLicInicio ;
   private java.util.Date[] T005K26_A252LegLicFinal ;
   private boolean[] T005K26_n252LegLicFinal ;
   private String[] T005K26_A342ZonDescrip ;
   private java.math.BigDecimal[] T005K26_A343ZonPorcReduc ;
   private String[] T005K26_A234LegCBU ;
   private boolean[] T005K26_n234LegCBU ;
   private boolean[] T005K26_A262LegSCVO ;
   private String[] T005K26_A144CondiDescri ;
   private String[] T005K26_A333SinieDescri ;
   private boolean[] T005K26_A228LegActivo ;
   private java.math.BigDecimal[] T005K26_A264LegSueldoFuera ;
   private String[] T005K26_A93LegId ;
   private boolean[] T005K26_n93LegId ;
   private String[] T005K26_A937LegConveCodigo ;
   private boolean[] T005K26_n937LegConveCodigo ;
   private String[] T005K26_A306OsoC3992 ;
   private boolean[] T005K26_n306OsoC3992 ;
   private String[] T005K26_A515LegObs ;
   private java.util.Date[] T005K26_A630LegFecImportacion ;
   private boolean[] T005K26_A877LegAgenReten ;
   private String[] T005K26_A879LegContinua ;
   private boolean[] T005K26_A942LegRecalcLiq ;
   private boolean[] T005K26_A1016LegJubilado ;
   private java.math.BigDecimal[] T005K26_A1023LegHorasDia ;
   private java.math.BigDecimal[] T005K26_A1268LegHorasSem ;
   private boolean[] T005K26_A1245LegTrabLun ;
   private boolean[] T005K26_A1246LegTrabMar ;
   private boolean[] T005K26_A1247LegTrabMie ;
   private boolean[] T005K26_A1248LegTrabJue ;
   private boolean[] T005K26_A1249LegTrabVie ;
   private boolean[] T005K26_A1250LegTrabSa ;
   private boolean[] T005K26_A1251LegTrabDo ;
   private short[] T005K26_A1523LegVacPend ;
   private java.util.Date[] T005K26_A1531LegFecPreAviso ;
   private int[] T005K26_A1576LegConveVersionCli ;
   private boolean[] T005K26_n1576LegConveVersionCli ;
   private String[] T005K26_A1759LegPromDias ;
   private String[] T005K26_A1804LegTitulo ;
   private byte[] T005K26_A1818LegEstado ;
   private boolean[] T005K26_A2267LegIncompleto ;
   private String[] T005K26_A1031LegFotoExt ;
   private String[] T005K26_A1030LegFotoNom ;
   private String[] T005K26_A392OsoSigla ;
   private boolean[] T005K26_n392OsoSigla ;
   private int[] T005K26_A3CliCod ;
   private String[] T005K26_A1582LegBanCod ;
   private boolean[] T005K26_n1582LegBanCod ;
   private String[] T005K26_A1581LegLpgCodigo ;
   private boolean[] T005K26_n1581LegLpgCodigo ;
   private String[] T005K26_A1583LegMegCodigo ;
   private boolean[] T005K26_n1583LegMegCodigo ;
   private String[] T005K26_A1580LegOsoCod ;
   private boolean[] T005K26_n1580LegOsoCod ;
   private String[] T005K26_A1579LegSecCodigo ;
   private boolean[] T005K26_n1579LegSecCodigo ;
   private short[] T005K26_A1EmpCod ;
   private String[] T005K26_A1577LegSucCodigo ;
   private boolean[] T005K26_n1577LegSucCodigo ;
   private String[] T005K26_A1578LegPuesCodigo ;
   private boolean[] T005K26_n1578LegPuesCodigo ;
   private String[] T005K26_A18MprCod ;
   private boolean[] T005K26_n18MprCod ;
   private String[] T005K26_A20ZonCod ;
   private boolean[] T005K26_n20ZonCod ;
   private short[] T005K26_A17CondiCodigo ;
   private boolean[] T005K26_n17CondiCodigo ;
   private String[] T005K26_A19SinieCodigo ;
   private boolean[] T005K26_n19SinieCodigo ;
   private byte[] T005K26_A263LegSexo ;
   private boolean[] T005K26_n263LegSexo ;
   private short[] T005K26_A243LegEstadoCivil ;
   private boolean[] T005K26_n243LegEstadoCivil ;
   private short[] T005K26_A22LegPaiCod ;
   private boolean[] T005K26_n22LegPaiCod ;
   private short[] T005K26_A23LegProvCod ;
   private boolean[] T005K26_n23LegProvCod ;
   private short[] T005K26_A24LegLocCod ;
   private boolean[] T005K26_n24LegLocCod ;
   private short[] T005K26_A21LegNacionCod ;
   private boolean[] T005K26_n21LegNacionCod ;
   private String[] T005K26_A910LegSinCod ;
   private boolean[] T005K26_n910LegSinCod ;
   private int[] T005K4_A3CliCod ;
   private int[] T005K11_A3CliCod ;
   private int[] T005K10_A3CliCod ;
   private byte[] T005K16_A263LegSexo ;
   private boolean[] T005K16_n263LegSexo ;
   private short[] T005K17_A243LegEstadoCivil ;
   private boolean[] T005K17_n243LegEstadoCivil ;
   private short[] T005K24_A1603LegSitRevEgreso ;
   private boolean[] T005K24_n1603LegSitRevEgreso ;
   private int[] T005K27_A3CliCod ;
   private String[] T005K28_A291LpgDescri ;
   private boolean[] T005K28_n291LpgDescri ;
   private String[] T005K29_A300MegDescrip ;
   private boolean[] T005K29_n300MegDescrip ;
   private String[] T005K30_A392OsoSigla ;
   private boolean[] T005K30_n392OsoSigla ;
   private String[] T005K31_A329SecDescrip ;
   private boolean[] T005K31_n329SecDescrip ;
   private int[] T005K32_A3CliCod ;
   private String[] T005K33_A45TipEmpleCod ;
   private boolean[] T005K33_n45TipEmpleCod ;
   private String[] T005K33_A1965EmpOsoCod ;
   private boolean[] T005K33_n1965EmpOsoCod ;
   private String[] T005K33_A2EmpNom ;
   private String[] T005K34_A307OsoDescrip ;
   private boolean[] T005K34_n307OsoDescrip ;
   private String[] T005K34_A306OsoC3992 ;
   private boolean[] T005K34_n306OsoC3992 ;
   private int[] T005K35_A3CliCod ;
   private String[] T005K36_A684MprDescripSinAc ;
   private String[] T005K36_A303MprDescrip ;
   private String[] T005K37_A678ZonDescripSinAc ;
   private String[] T005K37_A342ZonDescrip ;
   private java.math.BigDecimal[] T005K37_A343ZonPorcReduc ;
   private String[] T005K38_A686CondiDescriSinAc ;
   private String[] T005K38_A144CondiDescri ;
   private String[] T005K39_A688SinieDescriSinAc ;
   private String[] T005K39_A333SinieDescri ;
   private byte[] T005K40_A263LegSexo ;
   private boolean[] T005K40_n263LegSexo ;
   private short[] T005K41_A243LegEstadoCivil ;
   private boolean[] T005K41_n243LegEstadoCivil ;
   private String[] T005K42_A258LegPaiNom ;
   private String[] T005K43_A260LegProvNom ;
   private String[] T005K44_A255LegLocNom ;
   private String[] T005K45_A331SinDescrip ;
   private boolean[] T005K45_n331SinDescrip ;
   private String[] T005K46_A256LegNacionalidad ;
   private String[] T005K47_A227LegActDescri ;
   private short[] T005K48_A1603LegSitRevEgreso ;
   private boolean[] T005K48_n1603LegSitRevEgreso ;
   private int[] T005K49_A3CliCod ;
   private short[] T005K49_A1EmpCod ;
   private int[] T005K49_A6LegNumero ;
   private String[] T005K3_A15LegActCodigo ;
   private boolean[] T005K3_n15LegActCodigo ;
   private short[] T005K3_A1603LegSitRevEgreso ;
   private boolean[] T005K3_n1603LegSitRevEgreso ;
   private String[] T005K3_A1235LegReligion ;
   private boolean[] T005K3_n1235LegReligion ;
   private String[] T005K3_A1236LegOrigen ;
   private boolean[] T005K3_n1236LegOrigen ;
   private boolean[] T005K3_A237LegConvenio ;
   private String[] T005K3_A250LegIdNomApe ;
   private String[] T005K3_A591LegNomApe ;
   private int[] T005K3_A6LegNumero ;
   private String[] T005K3_A230LegApellido ;
   private String[] T005K3_A251LegNombre ;
   private String[] T005K3_A249LegFoto ;
   private boolean[] T005K3_n249LegFoto ;
   private byte[] T005K3_A266LegTipDoc ;
   private String[] T005K3_A257LegNumDoc ;
   private java.util.Date[] T005K3_A246LegFecNac ;
   private long[] T005K3_A239LegCUIL ;
   private byte[] T005K3_A241LegDiscapacidad ;
   private String[] T005K3_A242LegDomici ;
   private String[] T005K3_A479LegEmail ;
   private String[] T005K3_A236LegCodPos ;
   private String[] T005K3_A265LegTelefono ;
   private boolean[] T005K3_n265LegTelefono ;
   private java.util.Date[] T005K3_A245LegFecIngreso ;
   private java.util.Date[] T005K3_A244LegFecEgreso ;
   private boolean[] T005K3_n244LegFecEgreso ;
   private String[] T005K3_A939LegCatCodigo ;
   private boolean[] T005K3_n939LegCatCodigo ;
   private byte[] T005K3_A235LegClase ;
   private byte[] T005K3_A248LegFormaPago ;
   private String[] T005K3_A231LegBanSuc ;
   private boolean[] T005K3_n231LegBanSuc ;
   private String[] T005K3_A232LegBanTipCuen ;
   private boolean[] T005K3_n232LegBanTipCuen ;
   private java.util.Date[] T005K3_A247LegFecUltMod ;
   private String[] T005K3_A238LegCuentaBanc ;
   private boolean[] T005K3_n238LegCuentaBanc ;
   private java.util.Date[] T005K3_A253LegLicInicio ;
   private boolean[] T005K3_n253LegLicInicio ;
   private java.util.Date[] T005K3_A252LegLicFinal ;
   private boolean[] T005K3_n252LegLicFinal ;
   private String[] T005K3_A234LegCBU ;
   private boolean[] T005K3_n234LegCBU ;
   private boolean[] T005K3_A262LegSCVO ;
   private boolean[] T005K3_A228LegActivo ;
   private java.math.BigDecimal[] T005K3_A264LegSueldoFuera ;
   private String[] T005K3_A93LegId ;
   private boolean[] T005K3_n93LegId ;
   private String[] T005K3_A937LegConveCodigo ;
   private boolean[] T005K3_n937LegConveCodigo ;
   private String[] T005K3_A515LegObs ;
   private java.util.Date[] T005K3_A630LegFecImportacion ;
   private boolean[] T005K3_A877LegAgenReten ;
   private String[] T005K3_A879LegContinua ;
   private boolean[] T005K3_A942LegRecalcLiq ;
   private boolean[] T005K3_A1016LegJubilado ;
   private java.math.BigDecimal[] T005K3_A1023LegHorasDia ;
   private java.math.BigDecimal[] T005K3_A1268LegHorasSem ;
   private boolean[] T005K3_A1245LegTrabLun ;
   private boolean[] T005K3_A1246LegTrabMar ;
   private boolean[] T005K3_A1247LegTrabMie ;
   private boolean[] T005K3_A1248LegTrabJue ;
   private boolean[] T005K3_A1249LegTrabVie ;
   private boolean[] T005K3_A1250LegTrabSa ;
   private boolean[] T005K3_A1251LegTrabDo ;
   private short[] T005K3_A1523LegVacPend ;
   private java.util.Date[] T005K3_A1531LegFecPreAviso ;
   private int[] T005K3_A1576LegConveVersionCli ;
   private boolean[] T005K3_n1576LegConveVersionCli ;
   private String[] T005K3_A1759LegPromDias ;
   private String[] T005K3_A1804LegTitulo ;
   private byte[] T005K3_A1818LegEstado ;
   private boolean[] T005K3_A2267LegIncompleto ;
   private String[] T005K3_A1031LegFotoExt ;
   private String[] T005K3_A1030LegFotoNom ;
   private int[] T005K3_A3CliCod ;
   private String[] T005K3_A1582LegBanCod ;
   private boolean[] T005K3_n1582LegBanCod ;
   private String[] T005K3_A1581LegLpgCodigo ;
   private boolean[] T005K3_n1581LegLpgCodigo ;
   private String[] T005K3_A1583LegMegCodigo ;
   private boolean[] T005K3_n1583LegMegCodigo ;
   private String[] T005K3_A1580LegOsoCod ;
   private boolean[] T005K3_n1580LegOsoCod ;
   private String[] T005K3_A1579LegSecCodigo ;
   private boolean[] T005K3_n1579LegSecCodigo ;
   private short[] T005K3_A1EmpCod ;
   private String[] T005K3_A1577LegSucCodigo ;
   private boolean[] T005K3_n1577LegSucCodigo ;
   private String[] T005K3_A1578LegPuesCodigo ;
   private boolean[] T005K3_n1578LegPuesCodigo ;
   private String[] T005K3_A18MprCod ;
   private boolean[] T005K3_n18MprCod ;
   private String[] T005K3_A20ZonCod ;
   private boolean[] T005K3_n20ZonCod ;
   private short[] T005K3_A17CondiCodigo ;
   private boolean[] T005K3_n17CondiCodigo ;
   private String[] T005K3_A19SinieCodigo ;
   private boolean[] T005K3_n19SinieCodigo ;
   private byte[] T005K3_A263LegSexo ;
   private boolean[] T005K3_n263LegSexo ;
   private short[] T005K3_A243LegEstadoCivil ;
   private boolean[] T005K3_n243LegEstadoCivil ;
   private short[] T005K3_A22LegPaiCod ;
   private boolean[] T005K3_n22LegPaiCod ;
   private short[] T005K3_A23LegProvCod ;
   private boolean[] T005K3_n23LegProvCod ;
   private short[] T005K3_A24LegLocCod ;
   private boolean[] T005K3_n24LegLocCod ;
   private short[] T005K3_A21LegNacionCod ;
   private boolean[] T005K3_n21LegNacionCod ;
   private String[] T005K3_A910LegSinCod ;
   private boolean[] T005K3_n910LegSinCod ;
   private int[] T005K50_A3CliCod ;
   private short[] T005K50_A1EmpCod ;
   private int[] T005K50_A6LegNumero ;
   private int[] T005K51_A3CliCod ;
   private short[] T005K51_A1EmpCod ;
   private int[] T005K51_A6LegNumero ;
   private String[] T005K2_A15LegActCodigo ;
   private boolean[] T005K2_n15LegActCodigo ;
   private short[] T005K2_A1603LegSitRevEgreso ;
   private boolean[] T005K2_n1603LegSitRevEgreso ;
   private String[] T005K2_A1235LegReligion ;
   private boolean[] T005K2_n1235LegReligion ;
   private String[] T005K2_A1236LegOrigen ;
   private boolean[] T005K2_n1236LegOrigen ;
   private boolean[] T005K2_A237LegConvenio ;
   private String[] T005K2_A250LegIdNomApe ;
   private String[] T005K2_A591LegNomApe ;
   private int[] T005K2_A6LegNumero ;
   private String[] T005K2_A230LegApellido ;
   private String[] T005K2_A251LegNombre ;
   private String[] T005K2_A249LegFoto ;
   private boolean[] T005K2_n249LegFoto ;
   private byte[] T005K2_A266LegTipDoc ;
   private String[] T005K2_A257LegNumDoc ;
   private java.util.Date[] T005K2_A246LegFecNac ;
   private long[] T005K2_A239LegCUIL ;
   private byte[] T005K2_A241LegDiscapacidad ;
   private String[] T005K2_A242LegDomici ;
   private String[] T005K2_A479LegEmail ;
   private String[] T005K2_A236LegCodPos ;
   private String[] T005K2_A265LegTelefono ;
   private boolean[] T005K2_n265LegTelefono ;
   private java.util.Date[] T005K2_A245LegFecIngreso ;
   private java.util.Date[] T005K2_A244LegFecEgreso ;
   private boolean[] T005K2_n244LegFecEgreso ;
   private String[] T005K2_A939LegCatCodigo ;
   private boolean[] T005K2_n939LegCatCodigo ;
   private byte[] T005K2_A235LegClase ;
   private byte[] T005K2_A248LegFormaPago ;
   private String[] T005K2_A231LegBanSuc ;
   private boolean[] T005K2_n231LegBanSuc ;
   private String[] T005K2_A232LegBanTipCuen ;
   private boolean[] T005K2_n232LegBanTipCuen ;
   private java.util.Date[] T005K2_A247LegFecUltMod ;
   private String[] T005K2_A238LegCuentaBanc ;
   private boolean[] T005K2_n238LegCuentaBanc ;
   private java.util.Date[] T005K2_A253LegLicInicio ;
   private boolean[] T005K2_n253LegLicInicio ;
   private java.util.Date[] T005K2_A252LegLicFinal ;
   private boolean[] T005K2_n252LegLicFinal ;
   private String[] T005K2_A234LegCBU ;
   private boolean[] T005K2_n234LegCBU ;
   private boolean[] T005K2_A262LegSCVO ;
   private boolean[] T005K2_A228LegActivo ;
   private java.math.BigDecimal[] T005K2_A264LegSueldoFuera ;
   private String[] T005K2_A93LegId ;
   private boolean[] T005K2_n93LegId ;
   private String[] T005K2_A937LegConveCodigo ;
   private boolean[] T005K2_n937LegConveCodigo ;
   private String[] T005K2_A515LegObs ;
   private java.util.Date[] T005K2_A630LegFecImportacion ;
   private boolean[] T005K2_A877LegAgenReten ;
   private String[] T005K2_A879LegContinua ;
   private boolean[] T005K2_A942LegRecalcLiq ;
   private boolean[] T005K2_A1016LegJubilado ;
   private java.math.BigDecimal[] T005K2_A1023LegHorasDia ;
   private java.math.BigDecimal[] T005K2_A1268LegHorasSem ;
   private boolean[] T005K2_A1245LegTrabLun ;
   private boolean[] T005K2_A1246LegTrabMar ;
   private boolean[] T005K2_A1247LegTrabMie ;
   private boolean[] T005K2_A1248LegTrabJue ;
   private boolean[] T005K2_A1249LegTrabVie ;
   private boolean[] T005K2_A1250LegTrabSa ;
   private boolean[] T005K2_A1251LegTrabDo ;
   private short[] T005K2_A1523LegVacPend ;
   private java.util.Date[] T005K2_A1531LegFecPreAviso ;
   private int[] T005K2_A1576LegConveVersionCli ;
   private boolean[] T005K2_n1576LegConveVersionCli ;
   private String[] T005K2_A1759LegPromDias ;
   private String[] T005K2_A1804LegTitulo ;
   private byte[] T005K2_A1818LegEstado ;
   private boolean[] T005K2_A2267LegIncompleto ;
   private String[] T005K2_A1031LegFotoExt ;
   private String[] T005K2_A1030LegFotoNom ;
   private int[] T005K2_A3CliCod ;
   private String[] T005K2_A1582LegBanCod ;
   private boolean[] T005K2_n1582LegBanCod ;
   private String[] T005K2_A1581LegLpgCodigo ;
   private boolean[] T005K2_n1581LegLpgCodigo ;
   private String[] T005K2_A1583LegMegCodigo ;
   private boolean[] T005K2_n1583LegMegCodigo ;
   private String[] T005K2_A1580LegOsoCod ;
   private boolean[] T005K2_n1580LegOsoCod ;
   private String[] T005K2_A1579LegSecCodigo ;
   private boolean[] T005K2_n1579LegSecCodigo ;
   private short[] T005K2_A1EmpCod ;
   private String[] T005K2_A1577LegSucCodigo ;
   private boolean[] T005K2_n1577LegSucCodigo ;
   private String[] T005K2_A1578LegPuesCodigo ;
   private boolean[] T005K2_n1578LegPuesCodigo ;
   private String[] T005K2_A18MprCod ;
   private boolean[] T005K2_n18MprCod ;
   private String[] T005K2_A20ZonCod ;
   private boolean[] T005K2_n20ZonCod ;
   private short[] T005K2_A17CondiCodigo ;
   private boolean[] T005K2_n17CondiCodigo ;
   private String[] T005K2_A19SinieCodigo ;
   private boolean[] T005K2_n19SinieCodigo ;
   private byte[] T005K2_A263LegSexo ;
   private boolean[] T005K2_n263LegSexo ;
   private short[] T005K2_A243LegEstadoCivil ;
   private boolean[] T005K2_n243LegEstadoCivil ;
   private short[] T005K2_A22LegPaiCod ;
   private boolean[] T005K2_n22LegPaiCod ;
   private short[] T005K2_A23LegProvCod ;
   private boolean[] T005K2_n23LegProvCod ;
   private short[] T005K2_A24LegLocCod ;
   private boolean[] T005K2_n24LegLocCod ;
   private short[] T005K2_A21LegNacionCod ;
   private boolean[] T005K2_n21LegNacionCod ;
   private String[] T005K2_A910LegSinCod ;
   private boolean[] T005K2_n910LegSinCod ;
   private String[] T005K56_A1965EmpOsoCod ;
   private boolean[] T005K56_n1965EmpOsoCod ;
   private String[] T005K56_A2EmpNom ;
   private String[] T005K56_A45TipEmpleCod ;
   private boolean[] T005K56_n45TipEmpleCod ;
   private String[] T005K57_A307OsoDescrip ;
   private boolean[] T005K57_n307OsoDescrip ;
   private String[] T005K57_A306OsoC3992 ;
   private boolean[] T005K57_n306OsoC3992 ;
   private String[] T005K58_A291LpgDescri ;
   private boolean[] T005K58_n291LpgDescri ;
   private String[] T005K59_A300MegDescrip ;
   private boolean[] T005K59_n300MegDescrip ;
   private String[] T005K60_A392OsoSigla ;
   private boolean[] T005K60_n392OsoSigla ;
   private String[] T005K61_A329SecDescrip ;
   private boolean[] T005K61_n329SecDescrip ;
   private String[] T005K62_A684MprDescripSinAc ;
   private String[] T005K62_A303MprDescrip ;
   private String[] T005K63_A678ZonDescripSinAc ;
   private String[] T005K63_A342ZonDescrip ;
   private java.math.BigDecimal[] T005K63_A343ZonPorcReduc ;
   private String[] T005K64_A686CondiDescriSinAc ;
   private String[] T005K64_A144CondiDescri ;
   private String[] T005K65_A688SinieDescriSinAc ;
   private String[] T005K65_A333SinieDescri ;
   private String[] T005K66_A258LegPaiNom ;
   private String[] T005K67_A260LegProvNom ;
   private String[] T005K68_A255LegLocNom ;
   private String[] T005K69_A256LegNacionalidad ;
   private String[] T005K70_A331SinDescrip ;
   private boolean[] T005K70_n331SinDescrip ;
   private String[] T005K71_A227LegActDescri ;
   private int[] T005K72_A3CliCod ;
   private short[] T005K72_A1EmpCod ;
   private int[] T005K72_A6LegNumero ;
   private String[] T005K72_A2243LegCuenLicTpo ;
   private short[] T005K72_A2266LegCuenAnio ;
   private int[] T005K73_A3CliCod ;
   private short[] T005K73_A1EmpCod ;
   private int[] T005K73_A6LegNumero ;
   private java.util.Date[] T005K73_A2253LegHisFecIng ;
   private int[] T005K74_A3CliCod ;
   private short[] T005K74_A1EmpCod ;
   private int[] T005K74_A6LegNumero ;
   private String[] T005K74_A2230LegPropCod ;
   private int[] T005K75_A3CliCod ;
   private short[] T005K75_A1EmpCod ;
   private int[] T005K75_A6LegNumero ;
   private String[] T005K75_A1829PreliqTLiqCod ;
   private java.util.Date[] T005K75_A1830PreliqPeriodo ;
   private int[] T005K76_A3CliCod ;
   private short[] T005K76_A1EmpCod ;
   private int[] T005K76_A6LegNumero ;
   private String[] T005K76_A1319LegTipoTra ;
   private int[] T005K77_A3CliCod ;
   private short[] T005K77_A1EmpCod ;
   private int[] T005K77_A6LegNumero ;
   private short[] T005K77_A1172OblSecuencial ;
   private int[] T005K78_A3CliCod ;
   private short[] T005K78_A1EmpCod ;
   private int[] T005K78_A6LegNumero ;
   private short[] T005K78_A1135LegSuelSec ;
   private int[] T005K79_A3CliCod ;
   private short[] T005K79_A1EmpCod ;
   private byte[] T005K79_A784F1357CTipoPre ;
   private String[] T005K79_A777F1357CPer ;
   private byte[] T005K79_A778F1357CSec ;
   private int[] T005K79_A6LegNumero ;
   private String[] T005K79_A797F1357LRTipReg ;
   private int[] T005K80_A3CliCod ;
   private short[] T005K80_A1EmpCod ;
   private byte[] T005K80_A784F1357CTipoPre ;
   private String[] T005K80_A777F1357CPer ;
   private byte[] T005K80_A778F1357CSec ;
   private int[] T005K80_A6LegNumero ;
   private String[] T005K80_A863F1357LDGTipReg ;
   private int[] T005K81_A3CliCod ;
   private short[] T005K81_A1EmpCod ;
   private byte[] T005K81_A784F1357CTipoPre ;
   private String[] T005K81_A777F1357CPer ;
   private byte[] T005K81_A778F1357CSec ;
   private int[] T005K81_A6LegNumero ;
   private String[] T005K81_A786F1357LTipoReg ;
   private int[] T005K82_A3CliCod ;
   private short[] T005K82_A1EmpCod ;
   private byte[] T005K82_A784F1357CTipoPre ;
   private String[] T005K82_A777F1357CPer ;
   private byte[] T005K82_A778F1357CSec ;
   private int[] T005K82_A6LegNumero ;
   private String[] T005K82_A862F1357LDPTipReg ;
   private int[] T005K83_A3CliCod ;
   private short[] T005K83_A1EmpCod ;
   private byte[] T005K83_A784F1357CTipoPre ;
   private String[] T005K83_A777F1357CPer ;
   private byte[] T005K83_A778F1357CSec ;
   private int[] T005K83_A6LegNumero ;
   private String[] T005K83_A861F1357LCTipReg ;
   private int[] T005K84_A3CliCod ;
   private short[] T005K84_A1EmpCod ;
   private int[] T005K84_A6LegNumero ;
   private int[] T005K84_A83LegDedSec ;
   private int[] T005K85_A3CliCod ;
   private short[] T005K85_A1EmpCod ;
   private int[] T005K85_A6LegNumero ;
   private short[] T005K85_A77CenCodigo ;
   private int[] T005K86_A3CliCod ;
   private short[] T005K86_A1EmpCod ;
   private int[] T005K86_A6LegNumero ;
   private java.util.Date[] T005K86_A76LegLicenIni ;
   private int[] T005K87_A3CliCod ;
   private short[] T005K87_A1EmpCod ;
   private int[] T005K87_A31LiqNro ;
   private int[] T005K87_A6LegNumero ;
   private int[] T005K88_A3CliCod ;
   private short[] T005K88_A1EmpCod ;
   private int[] T005K88_A6LegNumero ;
   private short[] T005K88_A29LegOrden ;
   private int[] T005K89_A3CliCod ;
   private short[] T005K89_A1EmpCod ;
   private int[] T005K89_A6LegNumero ;
   private short[] T005K89_A25AgeOrden ;
   private int[] T005K90_A3CliCod ;
   private short[] T005K90_A1EmpCod ;
   private int[] T005K90_A6LegNumero ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV30TrnContextAtt ;
   private web.wwpbaseobjects.SdtSplitScreenDetailInfo AV31DetailWCInfo ;
}

final  class legajos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005K2", "SELECT LegActCodigo, LegSitRevEgreso, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegFecUltMod, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegIncompleto, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo, SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  FOR UPDATE OF Legajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K3", "SELECT LegActCodigo, LegSitRevEgreso, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegFecUltMod, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegIncompleto, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo, SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K4", "SELECT CliCod FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K5", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K6", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K7", "SELECT OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K8", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K9", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K10", "SELECT CliCod FROM Sucursal WHERE CliCod = ? AND EmpCod = ? AND SucCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K11", "SELECT CliCod FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K12", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K13", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K14", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K15", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K16", "SELECT SexoId AS LegSexo FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K17", "SELECT EstaCivilCod AS LegEstadoCivil FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K18", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K19", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K20", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K21", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K22", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K23", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K24", "SELECT SitRevCodigo AS LegSitRevEgreso FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K25", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K26", "SELECT TM1.LegActCodigo AS LegActCodigo, TM1.LegSitRevEgreso AS LegSitRevEgreso, T16.TipEmpleCod, TM1.LegReligion, TM1.LegOrigen, T16.EmpOsoCod AS EmpOsoCod, TM1.LegConvenio, T5.SinieDescriSinAc, T4.CondiDescriSinAc, T3.ZonDescripSinAc, T2.MprDescripSinAc, TM1.LegIdNomApe, TM1.LegNomApe, TM1.LegNumero, T16.EmpNom, TM1.LegApellido, TM1.LegNombre, TM1.LegFoto, TM1.LegTipDoc, TM1.LegNumDoc, TM1.LegFecNac, T9.PaiNom AS LegNacionalidad, TM1.LegCUIL, TM1.LegDiscapacidad, TM1.LegDomici, TM1.LegEmail, TM1.LegCodPos, T6.PaiNom AS LegPaiNom, T7.ProvNom AS LegProvNom, T8.LocNom AS LegLocNom, TM1.LegTelefono, TM1.LegFecIngreso, TM1.LegFecEgreso, T13.MegDescrip, TM1.LegCatCodigo, T15.SecDescrip, T12.LpgDescri, TM1.LegClase, TM1.LegFormaPago, TM1.LegBanSuc, TM1.LegBanTipCuen, T10.SinDescrip, T17.OsoDescrip, T11.ActDescrip AS LegActDescri, T2.MprDescrip, TM1.LegFecUltMod, TM1.LegCuentaBanc, TM1.LegLicInicio, TM1.LegLicFinal, T3.ZonDescrip, T3.ZonPorcReduc, TM1.LegCBU, TM1.LegSCVO, T4.CondiDescri, T5.SinieDescri, TM1.LegActivo, TM1.LegSueldoFuera, TM1.LegId, TM1.LegConveCodigo, T17.OsoC3992, TM1.LegObs, TM1.LegFecImportacion, TM1.LegAgenReten, TM1.LegContinua, TM1.LegRecalcLiq, TM1.LegJubilado, TM1.LegHorasDia, TM1.LegHorasSem, TM1.LegTrabLun, TM1.LegTrabMar, TM1.LegTrabMie, TM1.LegTrabJue, TM1.LegTrabVie, TM1.LegTrabSa, TM1.LegTrabDo, TM1.LegVacPend, TM1.LegFecPreAviso, TM1.LegConveVersionCli, TM1.LegPromDias, TM1.LegTitulo, TM1.LegEstado, TM1.LegIncompleto, TM1.LegFotoExt, TM1.LegFotoNom, T14.OsoSigla, TM1.CliCod, TM1.LegBanCod AS LegBanCod, TM1.LegLpgCodigo AS LegLpgCodigo, TM1.LegMegCodigo AS LegMegCodigo, TM1.LegOsoCod AS LegOsoCod, TM1.LegSecCodigo AS LegSecCodigo, TM1.EmpCod, TM1.LegSucCodigo AS LegSucCodigo, TM1.LegPuesCodigo AS LegPuesCodigo, TM1.MprCod, TM1.ZonCod, TM1.CondiCodigo, TM1.SinieCodigo, TM1.LegSexo AS LegSexo, TM1.LegEstadoCivil AS LegEstadoCivil, TM1.LegPaiCod AS LegPaiCod, TM1.LegProvCod AS LegProvCod, TM1.LegLocCod AS LegLocCod, TM1.LegNacionCod AS LegNacionCod, TM1.LegSinCod AS LegSinCod FROM ((((((((((((((((Legajo TM1 LEFT JOIN ModalidadAFIP T2 ON T2.MprCod = TM1.MprCod) LEFT JOIN Zona T3 ON T3.ZonCod = TM1.ZonCod) LEFT JOIN CondicionAFIP T4 ON T4.CondiCodigo = TM1.CondiCodigo) LEFT JOIN Siniestrado T5 ON T5.SinieCodigo = TM1.SinieCodigo) LEFT JOIN Pais T6 ON T6.PaiCod = TM1.LegPaiCod) LEFT JOIN Provincia T7 ON T7.PaiCod = TM1.LegPaiCod AND T7.ProvCod = TM1.LegProvCod) LEFT JOIN Localidad T8 ON T8.PaiCod = TM1.LegPaiCod AND T8.ProvCod = TM1.LegProvCod AND T8.LocCod = TM1.LegLocCod) LEFT JOIN Pais T9 ON T9.PaiCod = TM1.LegNacionCod) LEFT JOIN Sindicato T10 ON T10.PaiCod = TM1.LegPaiCod AND T10.SinCod = TM1.LegSinCod) LEFT JOIN Actividad T11 ON T11.ActCodigo = TM1.LegActCodigo) LEFT JOIN LugardePago T12 ON T12.CliCod = TM1.CliCod AND T12.LpgCodigo = TM1.LegLpgCodigo) LEFT JOIN MotivoEgreso T13 ON T13.CliCod = TM1.CliCod AND T13.MegCodigo = TM1.LegMegCodigo) LEFT JOIN ObraSocial T14 ON T14.CliCod = TM1.CliCod AND T14.OsoCod = TM1.LegOsoCod) LEFT JOIN Seccion T15 ON T15.CliCod = TM1.CliCod AND T15.SecCodigo = TM1.LegSecCodigo) INNER JOIN Empresa T16 ON T16.CliCod = TM1.CliCod AND T16.EmpCod = TM1.EmpCod) LEFT JOIN ObraSocial T17 ON T17.CliCod = TM1.CliCod AND T17.OsoCod = T16.EmpOsoCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K27", "SELECT CliCod FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K28", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K29", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K30", "SELECT OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K31", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K32", "SELECT CliCod FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K33", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K34", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K35", "SELECT CliCod FROM Sucursal WHERE CliCod = ? AND EmpCod = ? AND SucCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K36", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K37", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K38", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K39", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K40", "SELECT SexoId AS LegSexo FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K41", "SELECT EstaCivilCod AS LegEstadoCivil FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K42", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K43", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K44", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K45", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K46", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K47", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K48", "SELECT SitRevCodigo AS LegSitRevEgreso FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K49", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K50", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K51", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005K52", "SAVEPOINT gxupdate;INSERT INTO Legajo(LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegFecUltMod, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegIncompleto, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo, SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActCodigo, LegSitRevEgreso, LegReligion, LegOrigen, LegCatPueCod, LegActClasNro, LegPueAfiCod, LegMigrWarn, LegLiqApo, LegModTra, LegTipoTarifa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, '', '', FALSE, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005K53", "SAVEPOINT gxupdate;UPDATE Legajo SET LegConvenio=?, LegIdNomApe=?, LegNomApe=?, LegApellido=?, LegNombre=?, LegTipDoc=?, LegNumDoc=?, LegFecNac=?, LegCUIL=?, LegDiscapacidad=?, LegDomici=?, LegEmail=?, LegCodPos=?, LegTelefono=?, LegFecIngreso=?, LegFecEgreso=?, LegCatCodigo=?, LegClase=?, LegFormaPago=?, LegBanSuc=?, LegBanTipCuen=?, LegFecUltMod=?, LegCuentaBanc=?, LegLicInicio=?, LegLicFinal=?, LegCBU=?, LegSCVO=?, LegActivo=?, LegSueldoFuera=?, LegId=?, LegConveCodigo=?, LegObs=?, LegFecImportacion=?, LegAgenReten=?, LegContinua=?, LegRecalcLiq=?, LegJubilado=?, LegHorasDia=?, LegHorasSem=?, LegTrabLun=?, LegTrabMar=?, LegTrabMie=?, LegTrabJue=?, LegTrabVie=?, LegTrabSa=?, LegTrabDo=?, LegVacPend=?, LegFecPreAviso=?, LegConveVersionCli=?, LegPromDias=?, LegTitulo=?, LegEstado=?, LegIncompleto=?, LegFotoExt=?, LegFotoNom=?, LegBanCod=?, LegLpgCodigo=?, LegMegCodigo=?, LegOsoCod=?, LegSecCodigo=?, LegSucCodigo=?, LegPuesCodigo=?, MprCod=?, ZonCod=?, CondiCodigo=?, SinieCodigo=?, LegSexo=?, LegEstadoCivil=?, LegPaiCod=?, LegProvCod=?, LegLocCod=?, LegNacionCod=?, LegSinCod=?, LegActCodigo=?, LegSitRevEgreso=?, LegReligion=?, LegOrigen=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005K54", "SAVEPOINT gxupdate;UPDATE Legajo SET LegFoto=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005K55", "SAVEPOINT gxupdate;DELETE FROM Legajo  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005K56", "SELECT EmpOsoCod, EmpNom, TipEmpleCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K57", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K58", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K59", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K60", "SELECT OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K61", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K62", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K63", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K64", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K65", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K66", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K67", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K68", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K69", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K70", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K71", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005K72", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio FROM legajo_cuenta_licencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K73", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K74", "SELECT CliCod, EmpCod, LegNumero, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K75", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo FROM LegPreliqCab WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K76", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K77", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K78", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K79", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K80", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K81", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K82", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K83", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K84", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K85", "SELECT CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K86", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K87", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K88", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K89", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005K90", "SELECT CliCod, EmpCod, LegNumero FROM Legajo ORDER BY CliCod, EmpCod, LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(5);
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getBLOBFile(11, rslt.getString(60, 20), rslt.getVarchar(61));
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDate(14);
               ((long[]) buf[19])[0] = rslt.getLong(15);
               ((byte[]) buf[20])[0] = rslt.getByte(16);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 20);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(21);
               ((java.util.Date[]) buf[27])[0] = rslt.getGXDate(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(23, 40);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((byte[]) buf[32])[0] = rslt.getByte(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[37])[0] = rslt.getGXDate(28);
               ((String[]) buf[38])[0] = rslt.getVarchar(29);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[42])[0] = rslt.getGXDate(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(33);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(34);
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[49])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getString(37, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getLongVarchar(38);
               ((java.util.Date[]) buf[54])[0] = rslt.getGXDateTime(39);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(40);
               ((String[]) buf[56])[0] = rslt.getString(41, 2);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(42);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(43);
               ((java.math.BigDecimal[]) buf[59])[0] = rslt.getBigDecimal(44,1);
               ((java.math.BigDecimal[]) buf[60])[0] = rslt.getBigDecimal(45,1);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(46);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[63])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[64])[0] = rslt.getBoolean(49);
               ((boolean[]) buf[65])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[66])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[67])[0] = rslt.getBoolean(52);
               ((short[]) buf[68])[0] = rslt.getShort(53);
               ((java.util.Date[]) buf[69])[0] = rslt.getGXDate(54);
               ((int[]) buf[70])[0] = rslt.getInt(55);
               ((boolean[]) buf[71])[0] = rslt.wasNull();
               ((String[]) buf[72])[0] = rslt.getVarchar(56);
               ((String[]) buf[73])[0] = rslt.getString(57, 20);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((boolean[]) buf[75])[0] = rslt.getBoolean(59);
               ((String[]) buf[76])[0] = rslt.getString(60, 20);
               ((String[]) buf[77])[0] = rslt.getVarchar(61);
               ((int[]) buf[78])[0] = rslt.getInt(62);
               ((String[]) buf[79])[0] = rslt.getString(63, 6);
               ((boolean[]) buf[80])[0] = rslt.wasNull();
               ((String[]) buf[81])[0] = rslt.getString(64, 20);
               ((boolean[]) buf[82])[0] = rslt.wasNull();
               ((String[]) buf[83])[0] = rslt.getString(65, 20);
               ((boolean[]) buf[84])[0] = rslt.wasNull();
               ((String[]) buf[85])[0] = rslt.getString(66, 20);
               ((boolean[]) buf[86])[0] = rslt.wasNull();
               ((String[]) buf[87])[0] = rslt.getString(67, 20);
               ((boolean[]) buf[88])[0] = rslt.wasNull();
               ((short[]) buf[89])[0] = rslt.getShort(68);
               ((String[]) buf[90])[0] = rslt.getString(69, 20);
               ((boolean[]) buf[91])[0] = rslt.wasNull();
               ((String[]) buf[92])[0] = rslt.getString(70, 20);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getString(71, 20);
               ((boolean[]) buf[95])[0] = rslt.wasNull();
               ((String[]) buf[96])[0] = rslt.getString(72, 20);
               ((boolean[]) buf[97])[0] = rslt.wasNull();
               ((short[]) buf[98])[0] = rslt.getShort(73);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((String[]) buf[100])[0] = rslt.getString(74, 4);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((byte[]) buf[102])[0] = rslt.getByte(75);
               ((boolean[]) buf[103])[0] = rslt.wasNull();
               ((short[]) buf[104])[0] = rslt.getShort(76);
               ((boolean[]) buf[105])[0] = rslt.wasNull();
               ((short[]) buf[106])[0] = rslt.getShort(77);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((short[]) buf[108])[0] = rslt.getShort(78);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((short[]) buf[110])[0] = rslt.getShort(79);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(80);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(5);
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getBLOBFile(11, rslt.getString(60, 20), rslt.getVarchar(61));
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDate(14);
               ((long[]) buf[19])[0] = rslt.getLong(15);
               ((byte[]) buf[20])[0] = rslt.getByte(16);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 20);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(21);
               ((java.util.Date[]) buf[27])[0] = rslt.getGXDate(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(23, 40);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((byte[]) buf[32])[0] = rslt.getByte(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[37])[0] = rslt.getGXDate(28);
               ((String[]) buf[38])[0] = rslt.getVarchar(29);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[42])[0] = rslt.getGXDate(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(33);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(34);
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[49])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getString(37, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getLongVarchar(38);
               ((java.util.Date[]) buf[54])[0] = rslt.getGXDateTime(39);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(40);
               ((String[]) buf[56])[0] = rslt.getString(41, 2);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(42);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(43);
               ((java.math.BigDecimal[]) buf[59])[0] = rslt.getBigDecimal(44,1);
               ((java.math.BigDecimal[]) buf[60])[0] = rslt.getBigDecimal(45,1);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(46);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[63])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[64])[0] = rslt.getBoolean(49);
               ((boolean[]) buf[65])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[66])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[67])[0] = rslt.getBoolean(52);
               ((short[]) buf[68])[0] = rslt.getShort(53);
               ((java.util.Date[]) buf[69])[0] = rslt.getGXDate(54);
               ((int[]) buf[70])[0] = rslt.getInt(55);
               ((boolean[]) buf[71])[0] = rslt.wasNull();
               ((String[]) buf[72])[0] = rslt.getVarchar(56);
               ((String[]) buf[73])[0] = rslt.getString(57, 20);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((boolean[]) buf[75])[0] = rslt.getBoolean(59);
               ((String[]) buf[76])[0] = rslt.getString(60, 20);
               ((String[]) buf[77])[0] = rslt.getVarchar(61);
               ((int[]) buf[78])[0] = rslt.getInt(62);
               ((String[]) buf[79])[0] = rslt.getString(63, 6);
               ((boolean[]) buf[80])[0] = rslt.wasNull();
               ((String[]) buf[81])[0] = rslt.getString(64, 20);
               ((boolean[]) buf[82])[0] = rslt.wasNull();
               ((String[]) buf[83])[0] = rslt.getString(65, 20);
               ((boolean[]) buf[84])[0] = rslt.wasNull();
               ((String[]) buf[85])[0] = rslt.getString(66, 20);
               ((boolean[]) buf[86])[0] = rslt.wasNull();
               ((String[]) buf[87])[0] = rslt.getString(67, 20);
               ((boolean[]) buf[88])[0] = rslt.wasNull();
               ((short[]) buf[89])[0] = rslt.getShort(68);
               ((String[]) buf[90])[0] = rslt.getString(69, 20);
               ((boolean[]) buf[91])[0] = rslt.wasNull();
               ((String[]) buf[92])[0] = rslt.getString(70, 20);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getString(71, 20);
               ((boolean[]) buf[95])[0] = rslt.wasNull();
               ((String[]) buf[96])[0] = rslt.getString(72, 20);
               ((boolean[]) buf[97])[0] = rslt.wasNull();
               ((short[]) buf[98])[0] = rslt.getShort(73);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((String[]) buf[100])[0] = rslt.getString(74, 4);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((byte[]) buf[102])[0] = rslt.getByte(75);
               ((boolean[]) buf[103])[0] = rslt.wasNull();
               ((short[]) buf[104])[0] = rslt.getShort(76);
               ((boolean[]) buf[105])[0] = rslt.wasNull();
               ((short[]) buf[106])[0] = rslt.getShort(77);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((short[]) buf[108])[0] = rslt.getShort(78);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((short[]) buf[110])[0] = rslt.getShort(79);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(80);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(7);
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((String[]) buf[18])[0] = rslt.getVarchar(13);
               ((int[]) buf[19])[0] = rslt.getInt(14);
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getBLOBFile(18, rslt.getString(83, 20), rslt.getVarchar(84));
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((byte[]) buf[25])[0] = rslt.getByte(19);
               ((String[]) buf[26])[0] = rslt.getVarchar(20);
               ((java.util.Date[]) buf[27])[0] = rslt.getGXDate(21);
               ((String[]) buf[28])[0] = rslt.getVarchar(22);
               ((long[]) buf[29])[0] = rslt.getLong(23);
               ((byte[]) buf[30])[0] = rslt.getByte(24);
               ((String[]) buf[31])[0] = rslt.getVarchar(25);
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getString(27, 20);
               ((String[]) buf[34])[0] = rslt.getVarchar(28);
               ((String[]) buf[35])[0] = rslt.getVarchar(29);
               ((String[]) buf[36])[0] = rslt.getVarchar(30);
               ((String[]) buf[37])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(32);
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(33);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getString(35, 40);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getVarchar(36);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getVarchar(37);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((byte[]) buf[50])[0] = rslt.getByte(38);
               ((byte[]) buf[51])[0] = rslt.getByte(39);
               ((String[]) buf[52])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getString(41, 20);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(42);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(44);
               ((String[]) buf[61])[0] = rslt.getVarchar(45);
               ((java.util.Date[]) buf[62])[0] = rslt.getGXDate(46);
               ((String[]) buf[63])[0] = rslt.getVarchar(47);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(48);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[67])[0] = rslt.getGXDate(49);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getVarchar(50);
               ((java.math.BigDecimal[]) buf[70])[0] = rslt.getBigDecimal(51,2);
               ((String[]) buf[71])[0] = rslt.getVarchar(52);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((boolean[]) buf[73])[0] = rslt.getBoolean(53);
               ((String[]) buf[74])[0] = rslt.getVarchar(54);
               ((String[]) buf[75])[0] = rslt.getVarchar(55);
               ((boolean[]) buf[76])[0] = rslt.getBoolean(56);
               ((java.math.BigDecimal[]) buf[77])[0] = rslt.getBigDecimal(57,2);
               ((String[]) buf[78])[0] = rslt.getString(58, 20);
               ((boolean[]) buf[79])[0] = rslt.wasNull();
               ((String[]) buf[80])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[81])[0] = rslt.wasNull();
               ((String[]) buf[82])[0] = rslt.getString(60, 20);
               ((boolean[]) buf[83])[0] = rslt.wasNull();
               ((String[]) buf[84])[0] = rslt.getLongVarchar(61);
               ((java.util.Date[]) buf[85])[0] = rslt.getGXDateTime(62);
               ((boolean[]) buf[86])[0] = rslt.getBoolean(63);
               ((String[]) buf[87])[0] = rslt.getString(64, 2);
               ((boolean[]) buf[88])[0] = rslt.getBoolean(65);
               ((boolean[]) buf[89])[0] = rslt.getBoolean(66);
               ((java.math.BigDecimal[]) buf[90])[0] = rslt.getBigDecimal(67,1);
               ((java.math.BigDecimal[]) buf[91])[0] = rslt.getBigDecimal(68,1);
               ((boolean[]) buf[92])[0] = rslt.getBoolean(69);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(70);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(71);
               ((boolean[]) buf[95])[0] = rslt.getBoolean(72);
               ((boolean[]) buf[96])[0] = rslt.getBoolean(73);
               ((boolean[]) buf[97])[0] = rslt.getBoolean(74);
               ((boolean[]) buf[98])[0] = rslt.getBoolean(75);
               ((short[]) buf[99])[0] = rslt.getShort(76);
               ((java.util.Date[]) buf[100])[0] = rslt.getGXDate(77);
               ((int[]) buf[101])[0] = rslt.getInt(78);
               ((boolean[]) buf[102])[0] = rslt.wasNull();
               ((String[]) buf[103])[0] = rslt.getVarchar(79);
               ((String[]) buf[104])[0] = rslt.getString(80, 20);
               ((byte[]) buf[105])[0] = rslt.getByte(81);
               ((boolean[]) buf[106])[0] = rslt.getBoolean(82);
               ((String[]) buf[107])[0] = rslt.getString(83, 20);
               ((String[]) buf[108])[0] = rslt.getVarchar(84);
               ((String[]) buf[109])[0] = rslt.getString(85, 20);
               ((boolean[]) buf[110])[0] = rslt.wasNull();
               ((int[]) buf[111])[0] = rslt.getInt(86);
               ((String[]) buf[112])[0] = rslt.getString(87, 6);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               ((String[]) buf[118])[0] = rslt.getString(90, 20);
               ((boolean[]) buf[119])[0] = rslt.wasNull();
               ((String[]) buf[120])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[121])[0] = rslt.wasNull();
               ((short[]) buf[122])[0] = rslt.getShort(92);
               ((String[]) buf[123])[0] = rslt.getString(93, 20);
               ((boolean[]) buf[124])[0] = rslt.wasNull();
               ((String[]) buf[125])[0] = rslt.getString(94, 20);
               ((boolean[]) buf[126])[0] = rslt.wasNull();
               ((String[]) buf[127])[0] = rslt.getString(95, 20);
               ((boolean[]) buf[128])[0] = rslt.wasNull();
               ((String[]) buf[129])[0] = rslt.getString(96, 20);
               ((boolean[]) buf[130])[0] = rslt.wasNull();
               ((short[]) buf[131])[0] = rslt.getShort(97);
               ((boolean[]) buf[132])[0] = rslt.wasNull();
               ((String[]) buf[133])[0] = rslt.getString(98, 4);
               ((boolean[]) buf[134])[0] = rslt.wasNull();
               ((byte[]) buf[135])[0] = rslt.getByte(99);
               ((boolean[]) buf[136])[0] = rslt.wasNull();
               ((short[]) buf[137])[0] = rslt.getShort(100);
               ((boolean[]) buf[138])[0] = rslt.wasNull();
               ((short[]) buf[139])[0] = rslt.getShort(101);
               ((boolean[]) buf[140])[0] = rslt.wasNull();
               ((short[]) buf[141])[0] = rslt.getShort(102);
               ((boolean[]) buf[142])[0] = rslt.wasNull();
               ((short[]) buf[143])[0] = rslt.getShort(103);
               ((boolean[]) buf[144])[0] = rslt.wasNull();
               ((short[]) buf[145])[0] = rslt.getShort(104);
               ((boolean[]) buf[146])[0] = rslt.wasNull();
               ((String[]) buf[147])[0] = rslt.getString(105, 20);
               ((boolean[]) buf[148])[0] = rslt.wasNull();
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 35 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 36 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 38 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 39 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 44 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 45 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 46 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 54 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 55 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 56 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 57 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 58 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 59 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 61 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 62 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 63 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 64 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 65 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 66 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 67 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 68 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 69 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 88 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 18 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 19 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 20 :
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
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 22 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
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
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 34 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 35 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 36 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 37 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 38 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 39 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 40 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 41 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 42 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 43 :
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
            case 44 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 45 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 46 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 50 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setVarchar(6, (String)parms[5], 30, false);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(7, (String)parms[7]);
               }
               stmt.setByte(8, ((Number) parms[8]).byteValue());
               stmt.setVarchar(9, (String)parms[9], 20, false);
               stmt.setDate(10, (java.util.Date)parms[10]);
               stmt.setLong(11, ((Number) parms[11]).longValue());
               stmt.setByte(12, ((Number) parms[12]).byteValue());
               stmt.setVarchar(13, (String)parms[13], 4000, false);
               stmt.setVarchar(14, (String)parms[14], 100, false);
               stmt.setString(15, (String)parms[15], 20);
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(16, (String)parms[17], 30);
               }
               stmt.setDate(17, (java.util.Date)parms[18]);
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DATE );
               }
               else
               {
                  stmt.setDate(18, (java.util.Date)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(19, (String)parms[22], 40);
               }
               stmt.setByte(20, ((Number) parms[23]).byteValue());
               stmt.setByte(21, ((Number) parms[24]).byteValue());
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(22, (String)parms[26], 30);
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[28], 20);
               }
               stmt.setDate(24, (java.util.Date)parms[29]);
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(25, (String)parms[31], 20);
               }
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.DATE );
               }
               else
               {
                  stmt.setDate(26, (java.util.Date)parms[33]);
               }
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.DATE );
               }
               else
               {
                  stmt.setDate(27, (java.util.Date)parms[35]);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(28, (String)parms[37], 22);
               }
               stmt.setBoolean(29, ((Boolean) parms[38]).booleanValue());
               stmt.setBoolean(30, ((Boolean) parms[39]).booleanValue());
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[40], 2);
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(32, (String)parms[42], 20);
               }
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(33, (String)parms[44], 20);
               }
               stmt.setNLongVarchar(34, (String)parms[45], false);
               stmt.setDateTime(35, (java.util.Date)parms[46], false);
               stmt.setBoolean(36, ((Boolean) parms[47]).booleanValue());
               stmt.setString(37, (String)parms[48], 2);
               stmt.setBoolean(38, ((Boolean) parms[49]).booleanValue());
               stmt.setBoolean(39, ((Boolean) parms[50]).booleanValue());
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[51], 1);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[52], 1);
               stmt.setBoolean(42, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(43, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(44, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(45, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(46, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(47, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(48, ((Boolean) parms[59]).booleanValue());
               stmt.setShort(49, ((Number) parms[60]).shortValue());
               stmt.setDate(50, (java.util.Date)parms[61]);
               if ( ((Boolean) parms[62]).booleanValue() )
               {
                  stmt.setNull( 51 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(51, ((Number) parms[63]).intValue());
               }
               stmt.setVarchar(52, (String)parms[64], 4000, false);
               stmt.setString(53, (String)parms[65], 20);
               stmt.setByte(54, ((Number) parms[66]).byteValue());
               stmt.setBoolean(55, ((Boolean) parms[67]).booleanValue());
               stmt.setString(56, (String)parms[68], 20);
               stmt.setVarchar(57, (String)parms[69], 1000, false);
               stmt.setInt(58, ((Number) parms[70]).intValue());
               if ( ((Boolean) parms[71]).booleanValue() )
               {
                  stmt.setNull( 59 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(59, (String)parms[72], 6);
               }
               if ( ((Boolean) parms[73]).booleanValue() )
               {
                  stmt.setNull( 60 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(60, (String)parms[74], 20);
               }
               if ( ((Boolean) parms[75]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(61, (String)parms[76], 20);
               }
               if ( ((Boolean) parms[77]).booleanValue() )
               {
                  stmt.setNull( 62 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(62, (String)parms[78], 20);
               }
               if ( ((Boolean) parms[79]).booleanValue() )
               {
                  stmt.setNull( 63 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(63, (String)parms[80], 20);
               }
               stmt.setShort(64, ((Number) parms[81]).shortValue());
               if ( ((Boolean) parms[82]).booleanValue() )
               {
                  stmt.setNull( 65 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(65, (String)parms[83], 20);
               }
               if ( ((Boolean) parms[84]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[85], 20);
               }
               if ( ((Boolean) parms[86]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(67, (String)parms[87], 20);
               }
               if ( ((Boolean) parms[88]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(68, (String)parms[89], 20);
               }
               if ( ((Boolean) parms[90]).booleanValue() )
               {
                  stmt.setNull( 69 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(69, ((Number) parms[91]).shortValue());
               }
               if ( ((Boolean) parms[92]).booleanValue() )
               {
                  stmt.setNull( 70 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(70, (String)parms[93], 4);
               }
               if ( ((Boolean) parms[94]).booleanValue() )
               {
                  stmt.setNull( 71 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(71, ((Number) parms[95]).byteValue());
               }
               if ( ((Boolean) parms[96]).booleanValue() )
               {
                  stmt.setNull( 72 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(72, ((Number) parms[97]).shortValue());
               }
               if ( ((Boolean) parms[98]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(73, ((Number) parms[99]).shortValue());
               }
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(74, ((Number) parms[101]).shortValue());
               }
               if ( ((Boolean) parms[102]).booleanValue() )
               {
                  stmt.setNull( 75 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(75, ((Number) parms[103]).shortValue());
               }
               if ( ((Boolean) parms[104]).booleanValue() )
               {
                  stmt.setNull( 76 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(76, ((Number) parms[105]).shortValue());
               }
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 77 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(77, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 78 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(78, (String)parms[109], 8);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 79 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(79, ((Number) parms[111]).shortValue());
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 80 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(80, (String)parms[113], 20);
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 81 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(81, (String)parms[115], 20);
               }
               return;
            case 51 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setVarchar(4, (String)parms[3], 30, false);
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setVarchar(7, (String)parms[6], 20, false);
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setLong(9, ((Number) parms[8]).longValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setVarchar(11, (String)parms[10], 4000, false);
               stmt.setVarchar(12, (String)parms[11], 100, false);
               stmt.setString(13, (String)parms[12], 20);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[14], 30);
               }
               stmt.setDate(15, (java.util.Date)parms[15]);
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.DATE );
               }
               else
               {
                  stmt.setDate(16, (java.util.Date)parms[17]);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(17, (String)parms[19], 40);
               }
               stmt.setByte(18, ((Number) parms[20]).byteValue());
               stmt.setByte(19, ((Number) parms[21]).byteValue());
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(20, (String)parms[23], 30);
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(21, (String)parms[25], 20);
               }
               stmt.setDate(22, (java.util.Date)parms[26]);
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(23, (String)parms[28], 20);
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.DATE );
               }
               else
               {
                  stmt.setDate(24, (java.util.Date)parms[30]);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.DATE );
               }
               else
               {
                  stmt.setDate(25, (java.util.Date)parms[32]);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[34], 22);
               }
               stmt.setBoolean(27, ((Boolean) parms[35]).booleanValue());
               stmt.setBoolean(28, ((Boolean) parms[36]).booleanValue());
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[37], 2);
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(30, (String)parms[39], 20);
               }
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(31, (String)parms[41], 20);
               }
               stmt.setNLongVarchar(32, (String)parms[42], false);
               stmt.setDateTime(33, (java.util.Date)parms[43], false);
               stmt.setBoolean(34, ((Boolean) parms[44]).booleanValue());
               stmt.setString(35, (String)parms[45], 2);
               stmt.setBoolean(36, ((Boolean) parms[46]).booleanValue());
               stmt.setBoolean(37, ((Boolean) parms[47]).booleanValue());
               stmt.setBigDecimal(38, (java.math.BigDecimal)parms[48], 1);
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[49], 1);
               stmt.setBoolean(40, ((Boolean) parms[50]).booleanValue());
               stmt.setBoolean(41, ((Boolean) parms[51]).booleanValue());
               stmt.setBoolean(42, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(43, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(44, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(45, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(46, ((Boolean) parms[56]).booleanValue());
               stmt.setShort(47, ((Number) parms[57]).shortValue());
               stmt.setDate(48, (java.util.Date)parms[58]);
               if ( ((Boolean) parms[59]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(49, ((Number) parms[60]).intValue());
               }
               stmt.setVarchar(50, (String)parms[61], 4000, false);
               stmt.setString(51, (String)parms[62], 20);
               stmt.setByte(52, ((Number) parms[63]).byteValue());
               stmt.setBoolean(53, ((Boolean) parms[64]).booleanValue());
               stmt.setString(54, (String)parms[65], 20);
               stmt.setVarchar(55, (String)parms[66], 1000, false);
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(56, (String)parms[68], 6);
               }
               if ( ((Boolean) parms[69]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(57, (String)parms[70], 20);
               }
               if ( ((Boolean) parms[71]).booleanValue() )
               {
                  stmt.setNull( 58 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(58, (String)parms[72], 20);
               }
               if ( ((Boolean) parms[73]).booleanValue() )
               {
                  stmt.setNull( 59 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(59, (String)parms[74], 20);
               }
               if ( ((Boolean) parms[75]).booleanValue() )
               {
                  stmt.setNull( 60 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(60, (String)parms[76], 20);
               }
               if ( ((Boolean) parms[77]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(61, (String)parms[78], 20);
               }
               if ( ((Boolean) parms[79]).booleanValue() )
               {
                  stmt.setNull( 62 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(62, (String)parms[80], 20);
               }
               if ( ((Boolean) parms[81]).booleanValue() )
               {
                  stmt.setNull( 63 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(63, (String)parms[82], 20);
               }
               if ( ((Boolean) parms[83]).booleanValue() )
               {
                  stmt.setNull( 64 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(64, (String)parms[84], 20);
               }
               if ( ((Boolean) parms[85]).booleanValue() )
               {
                  stmt.setNull( 65 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(65, ((Number) parms[86]).shortValue());
               }
               if ( ((Boolean) parms[87]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[88], 4);
               }
               if ( ((Boolean) parms[89]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(67, ((Number) parms[90]).byteValue());
               }
               if ( ((Boolean) parms[91]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(68, ((Number) parms[92]).shortValue());
               }
               if ( ((Boolean) parms[93]).booleanValue() )
               {
                  stmt.setNull( 69 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(69, ((Number) parms[94]).shortValue());
               }
               if ( ((Boolean) parms[95]).booleanValue() )
               {
                  stmt.setNull( 70 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(70, ((Number) parms[96]).shortValue());
               }
               if ( ((Boolean) parms[97]).booleanValue() )
               {
                  stmt.setNull( 71 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(71, ((Number) parms[98]).shortValue());
               }
               if ( ((Boolean) parms[99]).booleanValue() )
               {
                  stmt.setNull( 72 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(72, ((Number) parms[100]).shortValue());
               }
               if ( ((Boolean) parms[101]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(73, (String)parms[102], 20);
               }
               if ( ((Boolean) parms[103]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(74, (String)parms[104], 8);
               }
               if ( ((Boolean) parms[105]).booleanValue() )
               {
                  stmt.setNull( 75 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(75, ((Number) parms[106]).shortValue());
               }
               if ( ((Boolean) parms[107]).booleanValue() )
               {
                  stmt.setNull( 76 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(76, (String)parms[108], 20);
               }
               if ( ((Boolean) parms[109]).booleanValue() )
               {
                  stmt.setNull( 77 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(77, (String)parms[110], 20);
               }
               stmt.setInt(78, ((Number) parms[111]).intValue());
               stmt.setShort(79, ((Number) parms[112]).shortValue());
               stmt.setInt(80, ((Number) parms[113]).intValue());
               return;
            case 52 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 61 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 62 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 63 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 64 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 65 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 66 :
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
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 67 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 68 :
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
            case 69 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

