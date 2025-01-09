package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class copiarbasecalcdepaiaemp extends GXProcedure
{
   public copiarbasecalcdepaiaemp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( copiarbasecalcdepaiaemp.class ), "" );
   }

   public copiarbasecalcdepaiaemp( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        short aP2 ,
                        int aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 )
   {
      copiarbasecalcdepaiaemp.this.AV32PaiCod = aP0;
      copiarbasecalcdepaiaemp.this.AV8CliCod = aP1;
      copiarbasecalcdepaiaemp.this.AV9EmpCod = aP2;
      copiarbasecalcdepaiaemp.this.AV48CliRelSec = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "paicod ", "")+GXutil.trim( GXutil.str( AV32PaiCod, 4, 0))) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV48CliRelSec) ,
                                           Integer.valueOf(A2053PaiBaseRelSec) ,
                                           Short.valueOf(AV32PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01RQ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV32PaiCod), Integer.valueOf(AV48CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2053PaiBaseRelSec = P01RQ2_A2053PaiBaseRelSec[0] ;
         A46PaiCod = P01RQ2_A46PaiCod[0] ;
         A1440PaiBaseClaseLeg = P01RQ2_A1440PaiBaseClaseLeg[0] ;
         A1441PaiBaseTipo = P01RQ2_A1441PaiBaseTipo[0] ;
         A1442PaiBaseCod1 = P01RQ2_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = P01RQ2_A1443PaiBaseCod2[0] ;
         A1444PaiBasePlus = P01RQ2_A1444PaiBasePlus[0] ;
         A1629PaiLicDLim = P01RQ2_A1629PaiLicDLim[0] ;
         A1630PaiLicDSeman = P01RQ2_A1630PaiLicDSeman[0] ;
         A1631PaiLicDMes = P01RQ2_A1631PaiLicDMes[0] ;
         A1632PaiLicDSemes = P01RQ2_A1632PaiLicDSemes[0] ;
         A1633PaiLicDAnual = P01RQ2_A1633PaiLicDAnual[0] ;
         A1634PaiLicAdju = P01RQ2_A1634PaiLicAdju[0] ;
         A1635PaiLicAdjuObl = P01RQ2_A1635PaiLicAdjuObl[0] ;
         A1636PaiLicNecAut = P01RQ2_A1636PaiLicNecAut[0] ;
         A1637PaiLicIngMot = P01RQ2_A1637PaiLicIngMot[0] ;
         A1638PaiLicMotObl = P01RQ2_A1638PaiLicMotObl[0] ;
         A1451PaiBasePromCnt1 = P01RQ2_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = P01RQ2_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = P01RQ2_A1453PaiBasePromTCnt[0] ;
         A2069PaiBaseOld = P01RQ2_A2069PaiBaseOld[0] ;
         AV49importar = false ;
         AV50liberacionPendiente = false ;
         if ( ! (0==AV48CliRelSec) )
         {
            AV49importar = true ;
         }
         else
         {
            if ( (0==A2053PaiBaseRelSec) )
            {
               AV49importar = true ;
            }
            else
            {
               GXt_int1 = AV56paisCliCod ;
               GXv_int2[0] = GXt_int1 ;
               new web.getclientepais(remoteHandle, context).execute( AV32PaiCod, GXv_int2) ;
               copiarbasecalcdepaiaemp.this.GXt_int1 = GXv_int2[0] ;
               AV56paisCliCod = GXt_int1 ;
               GXv_dtime3[0] = AV52CliRelease ;
               GXv_boolean4[0] = AV51CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( AV56paisCliCod, A2053PaiBaseRelSec, GXv_dtime3, GXv_boolean4) ;
               copiarbasecalcdepaiaemp.this.AV52CliRelease = GXv_dtime3[0] ;
               copiarbasecalcdepaiaemp.this.AV51CliReHabilitado = GXv_boolean4[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV51CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV52CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV51CliReHabilitado ) && (( AV52CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV52CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV49importar = true ;
               }
               else
               {
                  GXv_boolean4[0] = AV53alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( AV56paisCliCod, A2053PaiBaseRelSec, GXv_boolean4) ;
                  copiarbasecalcdepaiaemp.this.AV53alguienYaActualizo = GXv_boolean4[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV53alguienYaActualizo))) ;
                  if ( AV53alguienYaActualizo )
                  {
                     AV49importar = true ;
                  }
                  else
                  {
                     AV50liberacionPendiente = true ;
                  }
               }
            }
         }
         if ( AV49importar )
         {
            AV10EmpBaseClaseLeg = A1440PaiBaseClaseLeg ;
            AV11EmpBaseTipo = A1441PaiBaseTipo ;
            AV12EmpBaseCod1 = A1442PaiBaseCod1 ;
            AV14EmpBaseCod2 = A1443PaiBaseCod2 ;
            AV16EmpBasePlus = A1444PaiBasePlus ;
            AV17EmpLicDMin = (byte)(0) ;
            AV18EmpLicDLim = A1629PaiLicDLim ;
            AV19EmpLicDSeman = A1630PaiLicDSeman ;
            AV20EmpLicDMes = A1631PaiLicDMes ;
            AV21EmpLicDSemes = A1632PaiLicDSemes ;
            AV22EmpLicDAnual = A1633PaiLicDAnual ;
            AV23EmpLicAdju = A1634PaiLicAdju ;
            AV24EmpLicAdjuObl = A1635PaiLicAdjuObl ;
            AV25EmpLicNecAut = A1636PaiLicNecAut ;
            AV26EmpLicIngMot = A1637PaiLicIngMot ;
            AV27EmpLicMotObl = A1638PaiLicMotObl ;
            AV28EmpBaseOrd = (short)(0) ;
            AV29EmpBasePromCnt1 = A1451PaiBasePromCnt1 ;
            AV30EmpBasePromCnt2 = A1452PaiBasePromCnt2 ;
            AV31EmpBasePromTCnt = A1453PaiBasePromTCnt ;
            /* Execute user subroutine: 'HIJO' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "vengo", "")) ;
            if ( AV50liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2069PaiBaseOld)==0) )
               {
                  AV54Paisbase_old.fromJSonString(GXutil.trim( A2069PaiBaseOld), null);
                  AV10EmpBaseClaseLeg = A1440PaiBaseClaseLeg ;
                  AV11EmpBaseTipo = A1441PaiBaseTipo ;
                  AV12EmpBaseCod1 = A1442PaiBaseCod1 ;
                  AV14EmpBaseCod2 = A1443PaiBaseCod2 ;
                  AV16EmpBasePlus = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Paibaseplus() ;
                  AV18EmpLicDLim = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicdlim() ;
                  AV19EmpLicDSeman = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicdseman() ;
                  AV20EmpLicDMes = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicdmes() ;
                  AV21EmpLicDSemes = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicdsemes() ;
                  AV22EmpLicDAnual = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicdanual() ;
                  AV23EmpLicAdju = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicadju() ;
                  AV24EmpLicAdjuObl = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicadjuobl() ;
                  AV25EmpLicNecAut = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicnecaut() ;
                  AV26EmpLicIngMot = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicingmot() ;
                  AV27EmpLicMotObl = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Pailicmotobl() ;
                  AV28EmpBaseOrd = (short)(0) ;
                  AV29EmpBasePromCnt1 = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Paibasepromcnt1() ;
                  AV30EmpBasePromCnt2 = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Paibasepromcnt2() ;
                  AV31EmpBasePromTCnt = AV54Paisbase_old.getgxTv_SdtPaisbase_old_Paibasepromtcnt() ;
                  /* Execute user subroutine: 'HIJO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "new 2", "")) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "new 1", "")) ;
      /*
         INSERT RECORD ON TABLE Empresabase_calculo

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A1427EmpBaseClaseLeg = AV10EmpBaseClaseLeg ;
      A1429EmpBaseTipo = AV11EmpBaseTipo ;
      A1430EmpBaseCod1 = AV12EmpBaseCod1 ;
      A1431EmpBaseCod2 = AV14EmpBaseCod2 ;
      A1432EmpBasePlus = AV16EmpBasePlus ;
      A1502EmpLicDLim = AV18EmpLicDLim ;
      n1502EmpLicDLim = false ;
      A1503EmpLicDSeman = AV19EmpLicDSeman ;
      n1503EmpLicDSeman = false ;
      A1504EmpLicDMes = AV20EmpLicDMes ;
      n1504EmpLicDMes = false ;
      A1505EmpLicDSemes = AV21EmpLicDSemes ;
      n1505EmpLicDSemes = false ;
      A1506EmpLicDAnual = AV22EmpLicDAnual ;
      n1506EmpLicDAnual = false ;
      A1507EmpLicAdju = AV23EmpLicAdju ;
      n1507EmpLicAdju = false ;
      A1508EmpLicAdjuObl = AV24EmpLicAdjuObl ;
      n1508EmpLicAdjuObl = false ;
      A1509EmpLicNecAut = AV25EmpLicNecAut ;
      n1509EmpLicNecAut = false ;
      A1510EmpLicIngMot = AV26EmpLicIngMot ;
      n1510EmpLicIngMot = false ;
      A1511EmpLicMotObl = AV27EmpLicMotObl ;
      n1511EmpLicMotObl = false ;
      A1518EmpBaseOrd = AV28EmpBaseOrd ;
      n1518EmpBaseOrd = false ;
      A1437EmpBasePromCnt1 = AV29EmpBasePromCnt1 ;
      A1438EmpBasePromCnt2 = AV30EmpBasePromCnt2 ;
      A1439EmpBasePromTCnt = AV31EmpBasePromTCnt ;
      A2003EmpBaseRelSec = AV48CliRelSec ;
      /* Using cursor P01RQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, A1432EmpBasePlus, Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Boolean.valueOf(n1518EmpBaseOrd), Short.valueOf(A1518EmpBaseOrd), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
      if ( (pr_default.getStatus(1) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "new duplicato", "")) ;
         /* Using cursor P01RQ4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A3CliCod = P01RQ4_A3CliCod[0] ;
            A1EmpCod = P01RQ4_A1EmpCod[0] ;
            A1427EmpBaseClaseLeg = P01RQ4_A1427EmpBaseClaseLeg[0] ;
            A1429EmpBaseTipo = P01RQ4_A1429EmpBaseTipo[0] ;
            A1430EmpBaseCod1 = P01RQ4_A1430EmpBaseCod1[0] ;
            A1431EmpBaseCod2 = P01RQ4_A1431EmpBaseCod2[0] ;
            A1432EmpBasePlus = P01RQ4_A1432EmpBasePlus[0] ;
            A1502EmpLicDLim = P01RQ4_A1502EmpLicDLim[0] ;
            n1502EmpLicDLim = P01RQ4_n1502EmpLicDLim[0] ;
            A1503EmpLicDSeman = P01RQ4_A1503EmpLicDSeman[0] ;
            n1503EmpLicDSeman = P01RQ4_n1503EmpLicDSeman[0] ;
            A1504EmpLicDMes = P01RQ4_A1504EmpLicDMes[0] ;
            n1504EmpLicDMes = P01RQ4_n1504EmpLicDMes[0] ;
            A1505EmpLicDSemes = P01RQ4_A1505EmpLicDSemes[0] ;
            n1505EmpLicDSemes = P01RQ4_n1505EmpLicDSemes[0] ;
            A1506EmpLicDAnual = P01RQ4_A1506EmpLicDAnual[0] ;
            n1506EmpLicDAnual = P01RQ4_n1506EmpLicDAnual[0] ;
            A1507EmpLicAdju = P01RQ4_A1507EmpLicAdju[0] ;
            n1507EmpLicAdju = P01RQ4_n1507EmpLicAdju[0] ;
            A1508EmpLicAdjuObl = P01RQ4_A1508EmpLicAdjuObl[0] ;
            n1508EmpLicAdjuObl = P01RQ4_n1508EmpLicAdjuObl[0] ;
            A1509EmpLicNecAut = P01RQ4_A1509EmpLicNecAut[0] ;
            n1509EmpLicNecAut = P01RQ4_n1509EmpLicNecAut[0] ;
            A1510EmpLicIngMot = P01RQ4_A1510EmpLicIngMot[0] ;
            n1510EmpLicIngMot = P01RQ4_n1510EmpLicIngMot[0] ;
            A1511EmpLicMotObl = P01RQ4_A1511EmpLicMotObl[0] ;
            n1511EmpLicMotObl = P01RQ4_n1511EmpLicMotObl[0] ;
            A1437EmpBasePromCnt1 = P01RQ4_A1437EmpBasePromCnt1[0] ;
            A1438EmpBasePromCnt2 = P01RQ4_A1438EmpBasePromCnt2[0] ;
            A1439EmpBasePromTCnt = P01RQ4_A1439EmpBasePromTCnt[0] ;
            A2003EmpBaseRelSec = P01RQ4_A2003EmpBaseRelSec[0] ;
            GXv_SdtPaisbase_old5[0] = AV33Paisbase_old_def;
            new web.paisbase_getolddefault(remoteHandle, context).execute( AV32PaiCod, AV10EmpBaseClaseLeg, AV11EmpBaseTipo, AV12EmpBaseCod1, AV14EmpBaseCod2, GXv_SdtPaisbase_old5) ;
            AV33Paisbase_old_def = GXv_SdtPaisbase_old5[0] ;
            if ( ( DecimalUtil.compareTo(AV16EmpBasePlus, AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibaseplus()) != 0 ) && ( DecimalUtil.compareTo(A1432EmpBasePlus, AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibaseplus()) == 0 ) )
            {
               A1432EmpBasePlus = AV16EmpBasePlus ;
               AV55actualizo = true ;
            }
            if ( ( AV18EmpLicDLim != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdlim() ) && ( A1502EmpLicDLim == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdlim() ) )
            {
               A1502EmpLicDLim = AV18EmpLicDLim ;
               n1502EmpLicDLim = false ;
               AV55actualizo = true ;
            }
            if ( ( AV19EmpLicDSeman != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdseman() ) && ( A1503EmpLicDSeman == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdseman() ) )
            {
               A1503EmpLicDSeman = AV19EmpLicDSeman ;
               n1503EmpLicDSeman = false ;
               AV55actualizo = true ;
            }
            if ( ( AV20EmpLicDMes != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdmes() ) && ( A1504EmpLicDMes == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdmes() ) )
            {
               A1504EmpLicDMes = AV20EmpLicDMes ;
               n1504EmpLicDMes = false ;
               AV55actualizo = true ;
            }
            if ( ( AV21EmpLicDSemes != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdsemes() ) && ( A1505EmpLicDSemes == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdsemes() ) )
            {
               A1505EmpLicDSemes = AV21EmpLicDSemes ;
               n1505EmpLicDSemes = false ;
               AV55actualizo = true ;
            }
            if ( ( AV22EmpLicDAnual != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdanual() ) && ( A1506EmpLicDAnual == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicdanual() ) )
            {
               A1506EmpLicDAnual = AV22EmpLicDAnual ;
               n1506EmpLicDAnual = false ;
               AV55actualizo = true ;
            }
            if ( ( AV23EmpLicAdju != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicadju() ) && ( A1507EmpLicAdju == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicadju() ) )
            {
               A1507EmpLicAdju = AV23EmpLicAdju ;
               n1507EmpLicAdju = false ;
               AV55actualizo = true ;
            }
            if ( ( AV24EmpLicAdjuObl != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicadjuobl() ) && ( A1508EmpLicAdjuObl == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicadjuobl() ) )
            {
               A1508EmpLicAdjuObl = AV24EmpLicAdjuObl ;
               n1508EmpLicAdjuObl = false ;
               AV55actualizo = true ;
            }
            if ( ( AV25EmpLicNecAut != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicnecaut() ) && ( A1509EmpLicNecAut == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicnecaut() ) )
            {
               A1509EmpLicNecAut = AV25EmpLicNecAut ;
               n1509EmpLicNecAut = false ;
               AV55actualizo = true ;
            }
            if ( ( AV26EmpLicIngMot != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicingmot() ) && ( A1510EmpLicIngMot == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicingmot() ) )
            {
               A1510EmpLicIngMot = AV26EmpLicIngMot ;
               n1510EmpLicIngMot = false ;
               AV55actualizo = true ;
            }
            if ( ( AV27EmpLicMotObl != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicmotobl() ) && ( A1511EmpLicMotObl == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Pailicmotobl() ) )
            {
               A1511EmpLicMotObl = AV27EmpLicMotObl ;
               n1511EmpLicMotObl = false ;
               AV55actualizo = true ;
            }
            if ( ( AV29EmpBasePromCnt1 != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromcnt1() ) && ( A1437EmpBasePromCnt1 == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromcnt1() ) )
            {
               A1437EmpBasePromCnt1 = AV29EmpBasePromCnt1 ;
               AV55actualizo = true ;
            }
            if ( ( AV30EmpBasePromCnt2 != AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromcnt2() ) && ( A1438EmpBasePromCnt2 == AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromcnt2() ) )
            {
               A1438EmpBasePromCnt2 = AV30EmpBasePromCnt2 ;
               AV55actualizo = true ;
            }
            if ( ( GXutil.strcmp(AV31EmpBasePromTCnt, AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromtcnt()) != 0 ) && ( GXutil.strcmp(A1439EmpBasePromTCnt, AV33Paisbase_old_def.getgxTv_SdtPaisbase_old_Paibasepromtcnt()) == 0 ) )
            {
               A1439EmpBasePromTCnt = AV31EmpBasePromTCnt ;
               AV55actualizo = true ;
            }
            if ( AV55actualizo )
            {
               A2003EmpBaseRelSec = AV48CliRelSec ;
            }
            /* Using cursor P01RQ5 */
            pr_default.execute(3, new Object[] {A1432EmpBasePlus, Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "copiarbasecalcdepaiaemp");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV59Pgmname = "" ;
      scmdbuf = "" ;
      P01RQ2_A2053PaiBaseRelSec = new int[1] ;
      P01RQ2_A46PaiCod = new short[1] ;
      P01RQ2_A1440PaiBaseClaseLeg = new byte[1] ;
      P01RQ2_A1441PaiBaseTipo = new String[] {""} ;
      P01RQ2_A1442PaiBaseCod1 = new String[] {""} ;
      P01RQ2_A1443PaiBaseCod2 = new String[] {""} ;
      P01RQ2_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RQ2_A1629PaiLicDLim = new short[1] ;
      P01RQ2_A1630PaiLicDSeman = new byte[1] ;
      P01RQ2_A1631PaiLicDMes = new byte[1] ;
      P01RQ2_A1632PaiLicDSemes = new short[1] ;
      P01RQ2_A1633PaiLicDAnual = new short[1] ;
      P01RQ2_A1634PaiLicAdju = new boolean[] {false} ;
      P01RQ2_A1635PaiLicAdjuObl = new boolean[] {false} ;
      P01RQ2_A1636PaiLicNecAut = new boolean[] {false} ;
      P01RQ2_A1637PaiLicIngMot = new boolean[] {false} ;
      P01RQ2_A1638PaiLicMotObl = new boolean[] {false} ;
      P01RQ2_A1451PaiBasePromCnt1 = new short[1] ;
      P01RQ2_A1452PaiBasePromCnt2 = new short[1] ;
      P01RQ2_A1453PaiBasePromTCnt = new String[] {""} ;
      P01RQ2_A2069PaiBaseOld = new String[] {""} ;
      A1441PaiBaseTipo = "" ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1453PaiBasePromTCnt = "" ;
      A2069PaiBaseOld = "" ;
      GXv_int2 = new int[1] ;
      AV52CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime3 = new java.util.Date[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV11EmpBaseTipo = "" ;
      AV12EmpBaseCod1 = "" ;
      AV14EmpBaseCod2 = "" ;
      AV16EmpBasePlus = DecimalUtil.ZERO ;
      AV31EmpBasePromTCnt = "" ;
      AV54Paisbase_old = new web.SdtPaisbase_old(remoteHandle, context);
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      A1439EmpBasePromTCnt = "" ;
      Gx_emsg = "" ;
      P01RQ4_A3CliCod = new int[1] ;
      P01RQ4_A1EmpCod = new short[1] ;
      P01RQ4_A1427EmpBaseClaseLeg = new byte[1] ;
      P01RQ4_A1429EmpBaseTipo = new String[] {""} ;
      P01RQ4_A1430EmpBaseCod1 = new String[] {""} ;
      P01RQ4_A1431EmpBaseCod2 = new String[] {""} ;
      P01RQ4_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RQ4_A1502EmpLicDLim = new short[1] ;
      P01RQ4_n1502EmpLicDLim = new boolean[] {false} ;
      P01RQ4_A1503EmpLicDSeman = new byte[1] ;
      P01RQ4_n1503EmpLicDSeman = new boolean[] {false} ;
      P01RQ4_A1504EmpLicDMes = new byte[1] ;
      P01RQ4_n1504EmpLicDMes = new boolean[] {false} ;
      P01RQ4_A1505EmpLicDSemes = new short[1] ;
      P01RQ4_n1505EmpLicDSemes = new boolean[] {false} ;
      P01RQ4_A1506EmpLicDAnual = new short[1] ;
      P01RQ4_n1506EmpLicDAnual = new boolean[] {false} ;
      P01RQ4_A1507EmpLicAdju = new boolean[] {false} ;
      P01RQ4_n1507EmpLicAdju = new boolean[] {false} ;
      P01RQ4_A1508EmpLicAdjuObl = new boolean[] {false} ;
      P01RQ4_n1508EmpLicAdjuObl = new boolean[] {false} ;
      P01RQ4_A1509EmpLicNecAut = new boolean[] {false} ;
      P01RQ4_n1509EmpLicNecAut = new boolean[] {false} ;
      P01RQ4_A1510EmpLicIngMot = new boolean[] {false} ;
      P01RQ4_n1510EmpLicIngMot = new boolean[] {false} ;
      P01RQ4_A1511EmpLicMotObl = new boolean[] {false} ;
      P01RQ4_n1511EmpLicMotObl = new boolean[] {false} ;
      P01RQ4_A1437EmpBasePromCnt1 = new short[1] ;
      P01RQ4_A1438EmpBasePromCnt2 = new short[1] ;
      P01RQ4_A1439EmpBasePromTCnt = new String[] {""} ;
      P01RQ4_A2003EmpBaseRelSec = new int[1] ;
      AV33Paisbase_old_def = new web.SdtPaisbase_old(remoteHandle, context);
      GXv_SdtPaisbase_old5 = new web.SdtPaisbase_old[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.copiarbasecalcdepaiaemp__default(),
         new Object[] {
             new Object[] {
            P01RQ2_A2053PaiBaseRelSec, P01RQ2_A46PaiCod, P01RQ2_A1440PaiBaseClaseLeg, P01RQ2_A1441PaiBaseTipo, P01RQ2_A1442PaiBaseCod1, P01RQ2_A1443PaiBaseCod2, P01RQ2_A1444PaiBasePlus, P01RQ2_A1629PaiLicDLim, P01RQ2_A1630PaiLicDSeman, P01RQ2_A1631PaiLicDMes,
            P01RQ2_A1632PaiLicDSemes, P01RQ2_A1633PaiLicDAnual, P01RQ2_A1634PaiLicAdju, P01RQ2_A1635PaiLicAdjuObl, P01RQ2_A1636PaiLicNecAut, P01RQ2_A1637PaiLicIngMot, P01RQ2_A1638PaiLicMotObl, P01RQ2_A1451PaiBasePromCnt1, P01RQ2_A1452PaiBasePromCnt2, P01RQ2_A1453PaiBasePromTCnt,
            P01RQ2_A2069PaiBaseOld
            }
            , new Object[] {
            }
            , new Object[] {
            P01RQ4_A3CliCod, P01RQ4_A1EmpCod, P01RQ4_A1427EmpBaseClaseLeg, P01RQ4_A1429EmpBaseTipo, P01RQ4_A1430EmpBaseCod1, P01RQ4_A1431EmpBaseCod2, P01RQ4_A1432EmpBasePlus, P01RQ4_A1502EmpLicDLim, P01RQ4_n1502EmpLicDLim, P01RQ4_A1503EmpLicDSeman,
            P01RQ4_n1503EmpLicDSeman, P01RQ4_A1504EmpLicDMes, P01RQ4_n1504EmpLicDMes, P01RQ4_A1505EmpLicDSemes, P01RQ4_n1505EmpLicDSemes, P01RQ4_A1506EmpLicDAnual, P01RQ4_n1506EmpLicDAnual, P01RQ4_A1507EmpLicAdju, P01RQ4_n1507EmpLicAdju, P01RQ4_A1508EmpLicAdjuObl,
            P01RQ4_n1508EmpLicAdjuObl, P01RQ4_A1509EmpLicNecAut, P01RQ4_n1509EmpLicNecAut, P01RQ4_A1510EmpLicIngMot, P01RQ4_n1510EmpLicIngMot, P01RQ4_A1511EmpLicMotObl, P01RQ4_n1511EmpLicMotObl, P01RQ4_A1437EmpBasePromCnt1, P01RQ4_A1438EmpBasePromCnt2, P01RQ4_A1439EmpBasePromTCnt,
            P01RQ4_A2003EmpBaseRelSec
            }
            , new Object[] {
            }
         }
      );
      AV59Pgmname = "copiarBaseCalcDePaiAEmp" ;
      /* GeneXus formulas. */
      AV59Pgmname = "copiarBaseCalcDePaiAEmp" ;
      Gx_err = (short)(0) ;
   }

   private byte A1440PaiBaseClaseLeg ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte AV10EmpBaseClaseLeg ;
   private byte AV17EmpLicDMin ;
   private byte AV19EmpLicDSeman ;
   private byte AV20EmpLicDMes ;
   private byte A1427EmpBaseClaseLeg ;
   private byte A1503EmpLicDSeman ;
   private byte A1504EmpLicDMes ;
   private short AV32PaiCod ;
   private short AV9EmpCod ;
   private short A46PaiCod ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short AV18EmpLicDLim ;
   private short AV21EmpLicDSemes ;
   private short AV22EmpLicDAnual ;
   private short AV28EmpBaseOrd ;
   private short AV29EmpBasePromCnt1 ;
   private short AV30EmpBasePromCnt2 ;
   private short A1EmpCod ;
   private short A1502EmpLicDLim ;
   private short A1505EmpLicDSemes ;
   private short A1506EmpLicDAnual ;
   private short A1518EmpBaseOrd ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV48CliRelSec ;
   private int A2053PaiBaseRelSec ;
   private int AV56paisCliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int GX_INS191 ;
   private int A3CliCod ;
   private int A2003EmpBaseRelSec ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private java.math.BigDecimal AV16EmpBasePlus ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private String AV59Pgmname ;
   private String scmdbuf ;
   private String A1441PaiBaseTipo ;
   private String A1442PaiBaseCod1 ;
   private String A1443PaiBaseCod2 ;
   private String A1453PaiBasePromTCnt ;
   private String AV11EmpBaseTipo ;
   private String AV12EmpBaseCod1 ;
   private String AV14EmpBaseCod2 ;
   private String AV31EmpBasePromTCnt ;
   private String A1429EmpBaseTipo ;
   private String A1430EmpBaseCod1 ;
   private String A1431EmpBaseCod2 ;
   private String A1439EmpBasePromTCnt ;
   private String Gx_emsg ;
   private java.util.Date AV52CliRelease ;
   private java.util.Date GXv_dtime3[] ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
   private boolean AV49importar ;
   private boolean AV50liberacionPendiente ;
   private boolean AV51CliReHabilitado ;
   private boolean AV53alguienYaActualizo ;
   private boolean GXv_boolean4[] ;
   private boolean AV23EmpLicAdju ;
   private boolean AV24EmpLicAdjuObl ;
   private boolean AV25EmpLicNecAut ;
   private boolean AV26EmpLicIngMot ;
   private boolean AV27EmpLicMotObl ;
   private boolean returnInSub ;
   private boolean n1502EmpLicDLim ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1504EmpLicDMes ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1506EmpLicDAnual ;
   private boolean A1507EmpLicAdju ;
   private boolean n1507EmpLicAdju ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean A1509EmpLicNecAut ;
   private boolean n1509EmpLicNecAut ;
   private boolean A1510EmpLicIngMot ;
   private boolean n1510EmpLicIngMot ;
   private boolean A1511EmpLicMotObl ;
   private boolean n1511EmpLicMotObl ;
   private boolean n1518EmpBaseOrd ;
   private boolean AV55actualizo ;
   private String A2069PaiBaseOld ;
   private IDataStoreProvider pr_default ;
   private int[] P01RQ2_A2053PaiBaseRelSec ;
   private short[] P01RQ2_A46PaiCod ;
   private byte[] P01RQ2_A1440PaiBaseClaseLeg ;
   private String[] P01RQ2_A1441PaiBaseTipo ;
   private String[] P01RQ2_A1442PaiBaseCod1 ;
   private String[] P01RQ2_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] P01RQ2_A1444PaiBasePlus ;
   private short[] P01RQ2_A1629PaiLicDLim ;
   private byte[] P01RQ2_A1630PaiLicDSeman ;
   private byte[] P01RQ2_A1631PaiLicDMes ;
   private short[] P01RQ2_A1632PaiLicDSemes ;
   private short[] P01RQ2_A1633PaiLicDAnual ;
   private boolean[] P01RQ2_A1634PaiLicAdju ;
   private boolean[] P01RQ2_A1635PaiLicAdjuObl ;
   private boolean[] P01RQ2_A1636PaiLicNecAut ;
   private boolean[] P01RQ2_A1637PaiLicIngMot ;
   private boolean[] P01RQ2_A1638PaiLicMotObl ;
   private short[] P01RQ2_A1451PaiBasePromCnt1 ;
   private short[] P01RQ2_A1452PaiBasePromCnt2 ;
   private String[] P01RQ2_A1453PaiBasePromTCnt ;
   private String[] P01RQ2_A2069PaiBaseOld ;
   private int[] P01RQ4_A3CliCod ;
   private short[] P01RQ4_A1EmpCod ;
   private byte[] P01RQ4_A1427EmpBaseClaseLeg ;
   private String[] P01RQ4_A1429EmpBaseTipo ;
   private String[] P01RQ4_A1430EmpBaseCod1 ;
   private String[] P01RQ4_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] P01RQ4_A1432EmpBasePlus ;
   private short[] P01RQ4_A1502EmpLicDLim ;
   private boolean[] P01RQ4_n1502EmpLicDLim ;
   private byte[] P01RQ4_A1503EmpLicDSeman ;
   private boolean[] P01RQ4_n1503EmpLicDSeman ;
   private byte[] P01RQ4_A1504EmpLicDMes ;
   private boolean[] P01RQ4_n1504EmpLicDMes ;
   private short[] P01RQ4_A1505EmpLicDSemes ;
   private boolean[] P01RQ4_n1505EmpLicDSemes ;
   private short[] P01RQ4_A1506EmpLicDAnual ;
   private boolean[] P01RQ4_n1506EmpLicDAnual ;
   private boolean[] P01RQ4_A1507EmpLicAdju ;
   private boolean[] P01RQ4_n1507EmpLicAdju ;
   private boolean[] P01RQ4_A1508EmpLicAdjuObl ;
   private boolean[] P01RQ4_n1508EmpLicAdjuObl ;
   private boolean[] P01RQ4_A1509EmpLicNecAut ;
   private boolean[] P01RQ4_n1509EmpLicNecAut ;
   private boolean[] P01RQ4_A1510EmpLicIngMot ;
   private boolean[] P01RQ4_n1510EmpLicIngMot ;
   private boolean[] P01RQ4_A1511EmpLicMotObl ;
   private boolean[] P01RQ4_n1511EmpLicMotObl ;
   private short[] P01RQ4_A1437EmpBasePromCnt1 ;
   private short[] P01RQ4_A1438EmpBasePromCnt2 ;
   private String[] P01RQ4_A1439EmpBasePromTCnt ;
   private int[] P01RQ4_A2003EmpBaseRelSec ;
   private web.SdtPaisbase_old AV54Paisbase_old ;
   private web.SdtPaisbase_old AV33Paisbase_old_def ;
   private web.SdtPaisbase_old GXv_SdtPaisbase_old5[] ;
}

final  class copiarbasecalcdepaiaemp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV48CliRelSec ,
                                          int A2053PaiBaseRelSec ,
                                          short AV32PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT PaiBaseRelSec, PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual," ;
      scmdbuf += " PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseOld FROM Paisbase_calculo" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (0==AV48CliRelSec) )
      {
         addWhere(sWhereString, "(PaiBaseRelSec = ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P01RQ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01RQ3", "SAVEPOINT gxupdate;INSERT INTO Empresabase_calculo(CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, EmpLicDMin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01RQ4", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2  FOR UPDATE OF Empresabase_calculo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RQ5", "SAVEPOINT gxupdate;UPDATE Empresabase_calculo SET EmpBasePlus=?, EmpLicDLim=?, EmpLicDSeman=?, EmpLicDMes=?, EmpLicDSemes=?, EmpLicDAnual=?, EmpLicAdju=?, EmpLicAdjuObl=?, EmpLicNecAut=?, EmpLicIngMot=?, EmpLicMotObl=?, EmpBasePromCnt1=?, EmpBasePromCnt2=?, EmpBasePromTCnt=?, EmpBaseRelSec=?  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(21);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(18);
               ((short[]) buf[28])[0] = rslt.getShort(19);
               ((String[]) buf[29])[0] = rslt.getString(20, 20);
               ((int[]) buf[30])[0] = rslt.getInt(21);
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
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(8, ((Number) parms[8]).shortValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[10]).byteValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[14]).shortValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(12, ((Number) parms[16]).shortValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(13, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(14, ((Boolean) parms[20]).booleanValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[22]).booleanValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(16, ((Boolean) parms[24]).booleanValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(17, ((Boolean) parms[26]).booleanValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(18, ((Number) parms[28]).shortValue());
               }
               stmt.setShort(19, ((Number) parms[29]).shortValue());
               stmt.setShort(20, ((Number) parms[30]).shortValue());
               stmt.setString(21, (String)parms[31], 20);
               stmt.setInt(22, ((Number) parms[32]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 3 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[4]).byteValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[6]).byteValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[8]).shortValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[10]).shortValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(7, ((Boolean) parms[12]).booleanValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(8, ((Boolean) parms[14]).booleanValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(9, ((Boolean) parms[16]).booleanValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(10, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[20]).booleanValue());
               }
               stmt.setShort(12, ((Number) parms[21]).shortValue());
               stmt.setShort(13, ((Number) parms[22]).shortValue());
               stmt.setString(14, (String)parms[23], 20);
               stmt.setInt(15, ((Number) parms[24]).intValue());
               stmt.setInt(16, ((Number) parms[25]).intValue());
               stmt.setShort(17, ((Number) parms[26]).shortValue());
               stmt.setByte(18, ((Number) parms[27]).byteValue());
               stmt.setString(19, (String)parms[28], 20);
               stmt.setString(20, (String)parms[29], 20);
               stmt.setString(21, (String)parms[30], 20);
               return;
      }
   }

}

