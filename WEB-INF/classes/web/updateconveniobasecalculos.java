package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconveniobasecalculos extends GXProcedure
{
   public updateconveniobasecalculos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconveniobasecalculos.class ), "" );
   }

   public updateconveniobasecalculos( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updateconveniobasecalculos.this.AV12ClientePadre = aP0;
      updateconveniobasecalculos.this.AV10CliCod = aP1;
      updateconveniobasecalculos.this.AV17CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV44padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV12ClientePadre), AV17CliRelSec, GXv_dtime1) ;
      updateconveniobasecalculos.this.AV44padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV12ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV17CliRelSec, 6, 0))) ;
      AV49GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV17CliRelSec) ,
                                           Integer.valueOf(A2060ConveBaseRelSec) ,
                                           Long.valueOf(AV12ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01WQ2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV12ClientePadre), Integer.valueOf(AV17CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2060ConveBaseRelSec = P01WQ2_A2060ConveBaseRelSec[0] ;
         A3CliCod = P01WQ2_A3CliCod[0] ;
         A1564CliPaiConve = P01WQ2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01WQ2_A1565CliConvenio[0] ;
         A1454ConveBaseClaseLeg = P01WQ2_A1454ConveBaseClaseLeg[0] ;
         A1455ConveBaseTipo = P01WQ2_A1455ConveBaseTipo[0] ;
         A1456ConveBaseCod1 = P01WQ2_A1456ConveBaseCod1[0] ;
         A1457ConveBaseCod2 = P01WQ2_A1457ConveBaseCod2[0] ;
         A1458ConveBasePlus = P01WQ2_A1458ConveBasePlus[0] ;
         A1610ConveLicDLim = P01WQ2_A1610ConveLicDLim[0] ;
         A1611ConveLicDSeman = P01WQ2_A1611ConveLicDSeman[0] ;
         A1612ConveLicDMes = P01WQ2_A1612ConveLicDMes[0] ;
         A1613ConveLicDSemes = P01WQ2_A1613ConveLicDSemes[0] ;
         A1614ConveLicDAnual = P01WQ2_A1614ConveLicDAnual[0] ;
         A1615ConveLicAdju = P01WQ2_A1615ConveLicAdju[0] ;
         A1616ConveLicAdjuObl = P01WQ2_A1616ConveLicAdjuObl[0] ;
         A1617ConveLicNecAut = P01WQ2_A1617ConveLicNecAut[0] ;
         A1618ConveLicIngMot = P01WQ2_A1618ConveLicIngMot[0] ;
         A1619ConveLicMotObl = P01WQ2_A1619ConveLicMotObl[0] ;
         A1465ConveBasePromCnt1 = P01WQ2_A1465ConveBasePromCnt1[0] ;
         A1466ConveBasePromCnt2 = P01WQ2_A1466ConveBasePromCnt2[0] ;
         A1467ConveBasePromTCnt = P01WQ2_A1467ConveBasePromTCnt[0] ;
         A2062ConveBaseOld = P01WQ2_A2062ConveBaseOld[0] ;
         AV49GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV45clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV10CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconveniobasecalculos.this.AV45clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV45clienteConvenioTiene )
         {
            AV42importar = false ;
            AV43liberacionPendiente = false ;
            if ( ! (0==AV17CliRelSec) )
            {
               AV42importar = true ;
            }
            else
            {
               if ( (0==A2060ConveBaseRelSec) )
               {
                  AV42importar = true ;
               }
               else
               {
                  GXv_dtime1[0] = AV16CliRelease ;
                  GXv_boolean2[0] = AV15CliReHabilitado ;
                  new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A2060ConveBaseRelSec, GXv_dtime1, GXv_boolean2) ;
                  updateconveniobasecalculos.this.AV16CliRelease = GXv_dtime1[0] ;
                  updateconveniobasecalculos.this.AV15CliReHabilitado = GXv_boolean2[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV15CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV16CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
                  if ( ( AV15CliReHabilitado ) && (( AV16CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV16CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
                  {
                     AV42importar = true ;
                  }
                  else
                  {
                     GXv_boolean2[0] = AV8alguienYaActualizo ;
                     new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A2060ConveBaseRelSec, GXv_boolean2) ;
                     updateconveniobasecalculos.this.AV8alguienYaActualizo = GXv_boolean2[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV8alguienYaActualizo))) ;
                     if ( AV8alguienYaActualizo )
                     {
                        AV42importar = true ;
                     }
                     else
                     {
                        AV43liberacionPendiente = true ;
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV42importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV43liberacionPendiente))) ;
            if ( AV42importar )
            {
               AV14CliPaiConve = A1564CliPaiConve ;
               AV11CliConvenio = A1565CliConvenio ;
               AV18ConveBaseClaseLeg = A1454ConveBaseClaseLeg ;
               AV25ConveBaseTipo = A1455ConveBaseTipo ;
               AV19ConveBaseCod1 = A1456ConveBaseCod1 ;
               AV20ConveBaseCod2 = A1457ConveBaseCod2 ;
               AV21ConveBasePlus = A1458ConveBasePlus ;
               AV29ConveLicDLim = A1610ConveLicDLim ;
               AV31ConveLicDSeman = A1611ConveLicDSeman ;
               AV30ConveLicDMes = A1612ConveLicDMes ;
               AV32ConveLicDSemes = A1613ConveLicDSemes ;
               AV28ConveLicDAnual = A1614ConveLicDAnual ;
               AV26ConveLicAdju = A1615ConveLicAdju ;
               AV27ConveLicAdjuObl = A1616ConveLicAdjuObl ;
               AV35ConveLicNecAut = A1617ConveLicNecAut ;
               AV33ConveLicIngMot = A1618ConveLicIngMot ;
               AV34ConveLicMotObl = A1619ConveLicMotObl ;
               AV22ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
               AV23ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
               AV24ConveBasePromTCnt = A1467ConveBasePromTCnt ;
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
               new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "vengo", "")) ;
               if ( AV43liberacionPendiente )
               {
                  if ( ! (GXutil.strcmp("", A2062ConveBaseOld)==0) )
                  {
                     AV36Convenio_base_calculo_old.fromJSonString(GXutil.trim( A2062ConveBaseOld), null);
                     AV14CliPaiConve = A1564CliPaiConve ;
                     AV11CliConvenio = A1565CliConvenio ;
                     AV18ConveBaseClaseLeg = A1454ConveBaseClaseLeg ;
                     AV25ConveBaseTipo = A1455ConveBaseTipo ;
                     AV19ConveBaseCod1 = A1456ConveBaseCod1 ;
                     AV20ConveBaseCod2 = A1457ConveBaseCod2 ;
                     AV21ConveBasePlus = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convebaseplus() ;
                     AV29ConveLicDLim = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicdlim() ;
                     AV31ConveLicDSeman = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicdseman() ;
                     AV30ConveLicDMes = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicdmes() ;
                     AV32ConveLicDSemes = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicdsemes() ;
                     AV28ConveLicDAnual = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicdanual() ;
                     AV26ConveLicAdju = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicadju() ;
                     AV27ConveLicAdjuObl = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicadjuobl() ;
                     AV35ConveLicNecAut = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicnecaut() ;
                     AV33ConveLicIngMot = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicingmot() ;
                     AV34ConveLicMotObl = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convelicmotobl() ;
                     AV22ConveBasePromCnt1 = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1() ;
                     AV23ConveBasePromCnt2 = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2() ;
                     AV24ConveBasePromTCnt = AV36Convenio_base_calculo_old.getgxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt() ;
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
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV49GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, "4") ;
      AV50GXLvl108 = (byte)(0) ;
      /* Using cursor P01WQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV14CliPaiConve), AV11CliConvenio, Byte.valueOf(AV18ConveBaseClaseLeg), AV25ConveBaseTipo, AV19ConveBaseCod1, AV20ConveBaseCod2});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1457ConveBaseCod2 = P01WQ3_A1457ConveBaseCod2[0] ;
         A1456ConveBaseCod1 = P01WQ3_A1456ConveBaseCod1[0] ;
         A1455ConveBaseTipo = P01WQ3_A1455ConveBaseTipo[0] ;
         A1454ConveBaseClaseLeg = P01WQ3_A1454ConveBaseClaseLeg[0] ;
         A1565CliConvenio = P01WQ3_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01WQ3_A1564CliPaiConve[0] ;
         A3CliCod = P01WQ3_A3CliCod[0] ;
         A2060ConveBaseRelSec = P01WQ3_A2060ConveBaseRelSec[0] ;
         A1458ConveBasePlus = P01WQ3_A1458ConveBasePlus[0] ;
         A1610ConveLicDLim = P01WQ3_A1610ConveLicDLim[0] ;
         A1611ConveLicDSeman = P01WQ3_A1611ConveLicDSeman[0] ;
         A1612ConveLicDMes = P01WQ3_A1612ConveLicDMes[0] ;
         A1613ConveLicDSemes = P01WQ3_A1613ConveLicDSemes[0] ;
         A1614ConveLicDAnual = P01WQ3_A1614ConveLicDAnual[0] ;
         A1615ConveLicAdju = P01WQ3_A1615ConveLicAdju[0] ;
         A1616ConveLicAdjuObl = P01WQ3_A1616ConveLicAdjuObl[0] ;
         A1617ConveLicNecAut = P01WQ3_A1617ConveLicNecAut[0] ;
         A1618ConveLicIngMot = P01WQ3_A1618ConveLicIngMot[0] ;
         A1619ConveLicMotObl = P01WQ3_A1619ConveLicMotObl[0] ;
         A1465ConveBasePromCnt1 = P01WQ3_A1465ConveBasePromCnt1[0] ;
         A1466ConveBasePromCnt2 = P01WQ3_A1466ConveBasePromCnt2[0] ;
         A1467ConveBasePromTCnt = P01WQ3_A1467ConveBasePromTCnt[0] ;
         AV50GXLvl108 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, "5") ;
         if ( ! (0==AV17CliRelSec) )
         {
            GXv_dtime1[0] = AV40hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A2060ConveBaseRelSec, GXv_dtime1) ;
            updateconveniobasecalculos.this.AV40hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, "6") ;
            if ( AV44padreReleaseDateTime.after( AV40hijoReleaseDateTime ) )
            {
               A1458ConveBasePlus = AV21ConveBasePlus ;
               A1610ConveLicDLim = AV29ConveLicDLim ;
               A1611ConveLicDSeman = AV31ConveLicDSeman ;
               A1612ConveLicDMes = AV30ConveLicDMes ;
               A1613ConveLicDSemes = AV32ConveLicDSemes ;
               A1614ConveLicDAnual = AV28ConveLicDAnual ;
               A1615ConveLicAdju = AV26ConveLicAdju ;
               A1616ConveLicAdjuObl = AV27ConveLicAdjuObl ;
               A1617ConveLicNecAut = AV35ConveLicNecAut ;
               A1618ConveLicIngMot = AV33ConveLicIngMot ;
               A1619ConveLicMotObl = AV34ConveLicMotObl ;
               A1465ConveBasePromCnt1 = AV22ConveBasePromCnt1 ;
               A1466ConveBasePromCnt2 = AV23ConveBasePromCnt2 ;
               A1467ConveBasePromTCnt = AV24ConveBasePromTCnt ;
               A2060ConveBaseRelSec = AV17CliRelSec ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01WQ4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A2060ConveBaseRelSec), A1458ConveBasePlus, Short.valueOf(A1610ConveLicDLim), Byte.valueOf(A1611ConveLicDSeman), Byte.valueOf(A1612ConveLicDMes), Short.valueOf(A1613ConveLicDSemes), Short.valueOf(A1614ConveLicDAnual), Boolean.valueOf(A1615ConveLicAdju), Boolean.valueOf(A1616ConveLicAdjuObl), Boolean.valueOf(A1617ConveLicNecAut), Boolean.valueOf(A1618ConveLicIngMot), Boolean.valueOf(A1619ConveLicMotObl), Short.valueOf(A1465ConveBasePromCnt1), Short.valueOf(A1466ConveBasePromCnt2), A1467ConveBasePromTCnt, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
         if (true) break;
         /* Using cursor P01WQ5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A2060ConveBaseRelSec), A1458ConveBasePlus, Short.valueOf(A1610ConveLicDLim), Byte.valueOf(A1611ConveLicDSeman), Byte.valueOf(A1612ConveLicDMes), Short.valueOf(A1613ConveLicDSemes), Short.valueOf(A1614ConveLicDAnual), Boolean.valueOf(A1615ConveLicAdju), Boolean.valueOf(A1616ConveLicAdjuObl), Boolean.valueOf(A1617ConveLicNecAut), Boolean.valueOf(A1618ConveLicIngMot), Boolean.valueOf(A1619ConveLicMotObl), Short.valueOf(A1465ConveBasePromCnt1), Short.valueOf(A1466ConveBasePromCnt2), A1467ConveBasePromTCnt, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV50GXLvl108 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV43liberacionPendiente))) ;
         new web.newconvenio_base_calculo(remoteHandle, context).execute( AV10CliCod, AV14CliPaiConve, AV11CliConvenio, AV18ConveBaseClaseLeg, AV25ConveBaseTipo, AV19ConveBaseCod1, AV20ConveBaseCod2, AV21ConveBasePlus, AV29ConveLicDLim, AV31ConveLicDSeman, AV30ConveLicDMes, AV32ConveLicDSemes, AV28ConveLicDAnual, AV26ConveLicAdju, AV27ConveLicAdjuObl, AV35ConveLicNecAut, AV33ConveLicIngMot, AV34ConveLicMotObl, AV22ConveBasePromCnt1, AV23ConveBasePromCnt2, AV24ConveBasePromTCnt, AV17CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconveniobasecalculos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV44padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV48Pgmname = "" ;
      scmdbuf = "" ;
      P01WQ2_A2060ConveBaseRelSec = new int[1] ;
      P01WQ2_A3CliCod = new int[1] ;
      P01WQ2_A1564CliPaiConve = new short[1] ;
      P01WQ2_A1565CliConvenio = new String[] {""} ;
      P01WQ2_A1454ConveBaseClaseLeg = new byte[1] ;
      P01WQ2_A1455ConveBaseTipo = new String[] {""} ;
      P01WQ2_A1456ConveBaseCod1 = new String[] {""} ;
      P01WQ2_A1457ConveBaseCod2 = new String[] {""} ;
      P01WQ2_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WQ2_A1610ConveLicDLim = new short[1] ;
      P01WQ2_A1611ConveLicDSeman = new byte[1] ;
      P01WQ2_A1612ConveLicDMes = new byte[1] ;
      P01WQ2_A1613ConveLicDSemes = new short[1] ;
      P01WQ2_A1614ConveLicDAnual = new short[1] ;
      P01WQ2_A1615ConveLicAdju = new boolean[] {false} ;
      P01WQ2_A1616ConveLicAdjuObl = new boolean[] {false} ;
      P01WQ2_A1617ConveLicNecAut = new boolean[] {false} ;
      P01WQ2_A1618ConveLicIngMot = new boolean[] {false} ;
      P01WQ2_A1619ConveLicMotObl = new boolean[] {false} ;
      P01WQ2_A1465ConveBasePromCnt1 = new short[1] ;
      P01WQ2_A1466ConveBasePromCnt2 = new short[1] ;
      P01WQ2_A1467ConveBasePromTCnt = new String[] {""} ;
      P01WQ2_A2062ConveBaseOld = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1455ConveBaseTipo = "" ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1467ConveBasePromTCnt = "" ;
      A2062ConveBaseOld = "" ;
      AV16CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV11CliConvenio = "" ;
      AV25ConveBaseTipo = "" ;
      AV19ConveBaseCod1 = "" ;
      AV20ConveBaseCod2 = "" ;
      AV21ConveBasePlus = DecimalUtil.ZERO ;
      AV24ConveBasePromTCnt = "" ;
      AV36Convenio_base_calculo_old = new web.SdtConvenio_base_calculo_old(remoteHandle, context);
      P01WQ3_A1457ConveBaseCod2 = new String[] {""} ;
      P01WQ3_A1456ConveBaseCod1 = new String[] {""} ;
      P01WQ3_A1455ConveBaseTipo = new String[] {""} ;
      P01WQ3_A1454ConveBaseClaseLeg = new byte[1] ;
      P01WQ3_A1565CliConvenio = new String[] {""} ;
      P01WQ3_A1564CliPaiConve = new short[1] ;
      P01WQ3_A3CliCod = new int[1] ;
      P01WQ3_A2060ConveBaseRelSec = new int[1] ;
      P01WQ3_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WQ3_A1610ConveLicDLim = new short[1] ;
      P01WQ3_A1611ConveLicDSeman = new byte[1] ;
      P01WQ3_A1612ConveLicDMes = new byte[1] ;
      P01WQ3_A1613ConveLicDSemes = new short[1] ;
      P01WQ3_A1614ConveLicDAnual = new short[1] ;
      P01WQ3_A1615ConveLicAdju = new boolean[] {false} ;
      P01WQ3_A1616ConveLicAdjuObl = new boolean[] {false} ;
      P01WQ3_A1617ConveLicNecAut = new boolean[] {false} ;
      P01WQ3_A1618ConveLicIngMot = new boolean[] {false} ;
      P01WQ3_A1619ConveLicMotObl = new boolean[] {false} ;
      P01WQ3_A1465ConveBasePromCnt1 = new short[1] ;
      P01WQ3_A1466ConveBasePromCnt2 = new short[1] ;
      P01WQ3_A1467ConveBasePromTCnt = new String[] {""} ;
      AV40hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconveniobasecalculos__default(),
         new Object[] {
             new Object[] {
            P01WQ2_A2060ConveBaseRelSec, P01WQ2_A3CliCod, P01WQ2_A1564CliPaiConve, P01WQ2_A1565CliConvenio, P01WQ2_A1454ConveBaseClaseLeg, P01WQ2_A1455ConveBaseTipo, P01WQ2_A1456ConveBaseCod1, P01WQ2_A1457ConveBaseCod2, P01WQ2_A1458ConveBasePlus, P01WQ2_A1610ConveLicDLim,
            P01WQ2_A1611ConveLicDSeman, P01WQ2_A1612ConveLicDMes, P01WQ2_A1613ConveLicDSemes, P01WQ2_A1614ConveLicDAnual, P01WQ2_A1615ConveLicAdju, P01WQ2_A1616ConveLicAdjuObl, P01WQ2_A1617ConveLicNecAut, P01WQ2_A1618ConveLicIngMot, P01WQ2_A1619ConveLicMotObl, P01WQ2_A1465ConveBasePromCnt1,
            P01WQ2_A1466ConveBasePromCnt2, P01WQ2_A1467ConveBasePromTCnt, P01WQ2_A2062ConveBaseOld
            }
            , new Object[] {
            P01WQ3_A1457ConveBaseCod2, P01WQ3_A1456ConveBaseCod1, P01WQ3_A1455ConveBaseTipo, P01WQ3_A1454ConveBaseClaseLeg, P01WQ3_A1565CliConvenio, P01WQ3_A1564CliPaiConve, P01WQ3_A3CliCod, P01WQ3_A2060ConveBaseRelSec, P01WQ3_A1458ConveBasePlus, P01WQ3_A1610ConveLicDLim,
            P01WQ3_A1611ConveLicDSeman, P01WQ3_A1612ConveLicDMes, P01WQ3_A1613ConveLicDSemes, P01WQ3_A1614ConveLicDAnual, P01WQ3_A1615ConveLicAdju, P01WQ3_A1616ConveLicAdjuObl, P01WQ3_A1617ConveLicNecAut, P01WQ3_A1618ConveLicIngMot, P01WQ3_A1619ConveLicMotObl, P01WQ3_A1465ConveBasePromCnt1,
            P01WQ3_A1466ConveBasePromCnt2, P01WQ3_A1467ConveBasePromTCnt
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV48Pgmname = "updateConvenioBaseCalculos" ;
      /* GeneXus formulas. */
      AV48Pgmname = "updateConvenioBaseCalculos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV49GXLvl4 ;
   private byte A1454ConveBaseClaseLeg ;
   private byte A1611ConveLicDSeman ;
   private byte A1612ConveLicDMes ;
   private byte AV18ConveBaseClaseLeg ;
   private byte AV31ConveLicDSeman ;
   private byte AV30ConveLicDMes ;
   private byte AV50GXLvl108 ;
   private short A1564CliPaiConve ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short AV14CliPaiConve ;
   private short AV29ConveLicDLim ;
   private short AV32ConveLicDSemes ;
   private short AV28ConveLicDAnual ;
   private short AV22ConveBasePromCnt1 ;
   private short AV23ConveBasePromCnt2 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV17CliRelSec ;
   private int A2060ConveBaseRelSec ;
   private int A3CliCod ;
   private long AV12ClientePadre ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private java.math.BigDecimal AV21ConveBasePlus ;
   private String AV48Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private String A1467ConveBasePromTCnt ;
   private String AV11CliConvenio ;
   private String AV25ConveBaseTipo ;
   private String AV19ConveBaseCod1 ;
   private String AV20ConveBaseCod2 ;
   private String AV24ConveBasePromTCnt ;
   private java.util.Date AV44padreReleaseDateTime ;
   private java.util.Date AV16CliRelease ;
   private java.util.Date AV40hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private boolean AV45clienteConvenioTiene ;
   private boolean AV42importar ;
   private boolean AV43liberacionPendiente ;
   private boolean AV15CliReHabilitado ;
   private boolean AV8alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean AV26ConveLicAdju ;
   private boolean AV27ConveLicAdjuObl ;
   private boolean AV35ConveLicNecAut ;
   private boolean AV33ConveLicIngMot ;
   private boolean AV34ConveLicMotObl ;
   private boolean returnInSub ;
   private String A2062ConveBaseOld ;
   private IDataStoreProvider pr_default ;
   private int[] P01WQ2_A2060ConveBaseRelSec ;
   private int[] P01WQ2_A3CliCod ;
   private short[] P01WQ2_A1564CliPaiConve ;
   private String[] P01WQ2_A1565CliConvenio ;
   private byte[] P01WQ2_A1454ConveBaseClaseLeg ;
   private String[] P01WQ2_A1455ConveBaseTipo ;
   private String[] P01WQ2_A1456ConveBaseCod1 ;
   private String[] P01WQ2_A1457ConveBaseCod2 ;
   private java.math.BigDecimal[] P01WQ2_A1458ConveBasePlus ;
   private short[] P01WQ2_A1610ConveLicDLim ;
   private byte[] P01WQ2_A1611ConveLicDSeman ;
   private byte[] P01WQ2_A1612ConveLicDMes ;
   private short[] P01WQ2_A1613ConveLicDSemes ;
   private short[] P01WQ2_A1614ConveLicDAnual ;
   private boolean[] P01WQ2_A1615ConveLicAdju ;
   private boolean[] P01WQ2_A1616ConveLicAdjuObl ;
   private boolean[] P01WQ2_A1617ConveLicNecAut ;
   private boolean[] P01WQ2_A1618ConveLicIngMot ;
   private boolean[] P01WQ2_A1619ConveLicMotObl ;
   private short[] P01WQ2_A1465ConveBasePromCnt1 ;
   private short[] P01WQ2_A1466ConveBasePromCnt2 ;
   private String[] P01WQ2_A1467ConveBasePromTCnt ;
   private String[] P01WQ2_A2062ConveBaseOld ;
   private String[] P01WQ3_A1457ConveBaseCod2 ;
   private String[] P01WQ3_A1456ConveBaseCod1 ;
   private String[] P01WQ3_A1455ConveBaseTipo ;
   private byte[] P01WQ3_A1454ConveBaseClaseLeg ;
   private String[] P01WQ3_A1565CliConvenio ;
   private short[] P01WQ3_A1564CliPaiConve ;
   private int[] P01WQ3_A3CliCod ;
   private int[] P01WQ3_A2060ConveBaseRelSec ;
   private java.math.BigDecimal[] P01WQ3_A1458ConveBasePlus ;
   private short[] P01WQ3_A1610ConveLicDLim ;
   private byte[] P01WQ3_A1611ConveLicDSeman ;
   private byte[] P01WQ3_A1612ConveLicDMes ;
   private short[] P01WQ3_A1613ConveLicDSemes ;
   private short[] P01WQ3_A1614ConveLicDAnual ;
   private boolean[] P01WQ3_A1615ConveLicAdju ;
   private boolean[] P01WQ3_A1616ConveLicAdjuObl ;
   private boolean[] P01WQ3_A1617ConveLicNecAut ;
   private boolean[] P01WQ3_A1618ConveLicIngMot ;
   private boolean[] P01WQ3_A1619ConveLicMotObl ;
   private short[] P01WQ3_A1465ConveBasePromCnt1 ;
   private short[] P01WQ3_A1466ConveBasePromCnt2 ;
   private String[] P01WQ3_A1467ConveBasePromTCnt ;
   private web.SdtConvenio_base_calculo_old AV36Convenio_base_calculo_old ;
}

final  class updateconveniobasecalculos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01WQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV17CliRelSec ,
                                          int A2060ConveBaseRelSec ,
                                          long AV12ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveBaseRelSec, CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBasePlus, ConveLicDLim, ConveLicDSeman," ;
      scmdbuf += " ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2," ;
      scmdbuf += " ConveBasePromTCnt, ConveBaseOld FROM Convenio_base_calculo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV17CliRelSec) )
      {
         addWhere(sWhereString, "(ConveBaseRelSec = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P01WQ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01WQ3", "SELECT ConveBaseCod2, ConveBaseCod1, ConveBaseTipo, ConveBaseClaseLeg, CliConvenio, CliPaiConve, CliCod, ConveBaseRelSec, ConveBasePlus, ConveLicDLim, ConveLicDSeman, ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt FROM Convenio_base_calculo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveBaseClaseLeg = ? and ConveBaseTipo = ( ?) and ConveBaseCod1 = ( ?) and ConveBaseCod2 = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2  LIMIT 1 FOR UPDATE OF Convenio_base_calculo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WQ4", "SAVEPOINT gxupdate;UPDATE Convenio_base_calculo SET ConveBaseRelSec=?, ConveBasePlus=?, ConveLicDLim=?, ConveLicDSeman=?, ConveLicDMes=?, ConveLicDSemes=?, ConveLicDAnual=?, ConveLicAdju=?, ConveLicAdjuObl=?, ConveLicNecAut=?, ConveLicIngMot=?, ConveLicMotObl=?, ConveBasePromCnt1=?, ConveBasePromCnt2=?, ConveBasePromTCnt=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01WQ5", "SAVEPOINT gxupdate;UPDATE Convenio_base_calculo SET ConveBaseRelSec=?, ConveBasePlus=?, ConveLicDLim=?, ConveLicDSeman=?, ConveLicDMes=?, ConveLicDSemes=?, ConveLicDAnual=?, ConveLicAdju=?, ConveLicAdjuObl=?, ConveLicNecAut=?, ConveLicIngMot=?, ConveLicMotObl=?, ConveBasePromCnt1=?, ConveBasePromCnt2=?, ConveBasePromTCnt=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((short[]) buf[19])[0] = rslt.getShort(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((String[]) buf[22])[0] = rslt.getLongVarchar(23);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((short[]) buf[19])[0] = rslt.getShort(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
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
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setString(18, (String)parms[17], 20);
               stmt.setByte(19, ((Number) parms[18]).byteValue());
               stmt.setString(20, (String)parms[19], 20);
               stmt.setString(21, (String)parms[20], 20);
               stmt.setString(22, (String)parms[21], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setString(18, (String)parms[17], 20);
               stmt.setByte(19, ((Number) parms[18]).byteValue());
               stmt.setString(20, (String)parms[19], 20);
               stmt.setString(21, (String)parms[20], 20);
               stmt.setString(22, (String)parms[21], 20);
               return;
      }
   }

}

