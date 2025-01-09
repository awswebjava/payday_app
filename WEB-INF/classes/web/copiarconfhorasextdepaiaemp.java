package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class copiarconfhorasextdepaiaemp extends GXProcedure
{
   public copiarconfhorasextdepaiaemp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( copiarconfhorasextdepaiaemp.class ), "" );
   }

   public copiarconfhorasextdepaiaemp( int remoteHandle ,
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
      copiarconfhorasextdepaiaemp.this.AV19PaiCod = aP0;
      copiarconfhorasextdepaiaemp.this.AV8CliCod = aP1;
      copiarconfhorasextdepaiaemp.this.AV9EmpCod = aP2;
      copiarconfhorasextdepaiaemp.this.AV36CliRelSec = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV45paisCliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclientepais(remoteHandle, context).execute( AV19PaiCod, GXv_int2) ;
      copiarconfhorasextdepaiaemp.this.GXt_int1 = GXv_int2[0] ;
      AV45paisCliCod = GXt_int1 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV36CliRelSec) ,
                                           Integer.valueOf(A2055PaiTipoTraRelSec) ,
                                           Short.valueOf(AV19PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01RR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV19PaiCod), Integer.valueOf(AV36CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2055PaiTipoTraRelSec = P01RR2_A2055PaiTipoTraRelSec[0] ;
         A46PaiCod = P01RR2_A46PaiCod[0] ;
         A1294PaiTipoTraId = P01RR2_A1294PaiTipoTraId[0] ;
         A1336PaiTipoHsDia = P01RR2_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = P01RR2_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = P01RR2_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = P01RR2_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = P01RR2_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = P01RR2_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = P01RR2_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = P01RR2_A1390PaiTipoHsMaxAnu[0] ;
         A2070PaiTipoTraOld = P01RR2_A2070PaiTipoTraOld[0] ;
         AV37importar = false ;
         AV38liberacionPendiente = false ;
         if ( ! (0==AV36CliRelSec) )
         {
            AV37importar = true ;
         }
         else
         {
            if ( (0==A2055PaiTipoTraRelSec) )
            {
               AV37importar = true ;
            }
            else
            {
               GXv_dtime3[0] = AV39CliRelease ;
               GXv_boolean4[0] = AV40CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( AV45paisCliCod, A2055PaiTipoTraRelSec, GXv_dtime3, GXv_boolean4) ;
               copiarconfhorasextdepaiaemp.this.AV39CliRelease = GXv_dtime3[0] ;
               copiarconfhorasextdepaiaemp.this.AV40CliReHabilitado = GXv_boolean4[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV40CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV39CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV40CliReHabilitado ) && (( AV39CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV39CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV37importar = true ;
               }
               else
               {
                  GXv_boolean4[0] = AV41alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( AV45paisCliCod, A2055PaiTipoTraRelSec, GXv_boolean4) ;
                  copiarconfhorasextdepaiaemp.this.AV41alguienYaActualizo = GXv_boolean4[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV41alguienYaActualizo))) ;
                  if ( AV41alguienYaActualizo )
                  {
                     AV37importar = true ;
                  }
                  else
                  {
                     AV38liberacionPendiente = true ;
                  }
               }
            }
         }
         if ( AV37importar )
         {
            AV10PaiTipoTraId = A1294PaiTipoTraId ;
            AV11EmpHsDia = A1336PaiTipoHsDia ;
            AV12EmpHsSem = A1337PaiTipoHsSem ;
            AV13EmpTarifaXLim = A1338PaiTipoTarifaXLim ;
            AV14EmpTarifaRec = A1347PaiTipoTarifaRec ;
            AV15EmpHsMaxDia = A1383PaiTipoHsMaxDia ;
            AV16EmpHsMaxSem = A1384PaiTipoHsMaxSem ;
            AV17EmpHsMaxMes = A1385PaiTipoHsMaxMes ;
            AV18EmpHsMaxAnu = A1390PaiTipoHsMaxAnu ;
            /* Execute user subroutine: 'HIJO TIPO TRA' */
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
            if ( AV38liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2070PaiTipoTraOld)==0) )
               {
                  AV10PaiTipoTraId = A1294PaiTipoTraId ;
                  GXv_decimal5[0] = AV11EmpHsDia ;
                  GXv_decimal6[0] = AV12EmpHsSem ;
                  GXv_decimal7[0] = AV13EmpTarifaXLim ;
                  GXv_decimal8[0] = AV14EmpTarifaRec ;
                  GXv_decimal9[0] = AV15EmpHsMaxDia ;
                  GXv_decimal10[0] = AV16EmpHsMaxSem ;
                  GXv_decimal11[0] = AV17EmpHsMaxMes ;
                  GXv_decimal12[0] = AV18EmpHsMaxAnu ;
                  new web.getpaitipotraoldcampos(remoteHandle, context).execute( A2070PaiTipoTraOld, GXv_decimal5, GXv_decimal6, GXv_decimal7, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_decimal12) ;
                  copiarconfhorasextdepaiaemp.this.AV11EmpHsDia = GXv_decimal5[0] ;
                  copiarconfhorasextdepaiaemp.this.AV12EmpHsSem = GXv_decimal6[0] ;
                  copiarconfhorasextdepaiaemp.this.AV13EmpTarifaXLim = GXv_decimal7[0] ;
                  copiarconfhorasextdepaiaemp.this.AV14EmpTarifaRec = GXv_decimal8[0] ;
                  copiarconfhorasextdepaiaemp.this.AV15EmpHsMaxDia = GXv_decimal9[0] ;
                  copiarconfhorasextdepaiaemp.this.AV16EmpHsMaxSem = GXv_decimal10[0] ;
                  copiarconfhorasextdepaiaemp.this.AV17EmpHsMaxMes = GXv_decimal11[0] ;
                  copiarconfhorasextdepaiaemp.this.AV18EmpHsMaxAnu = GXv_decimal12[0] ;
                  /* Execute user subroutine: 'HIJO TIPO TRA' */
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
         pr_default.readNext(0);
      }
      pr_default.close(0);
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV36CliRelSec) ,
                                           Integer.valueOf(A2057PaiExtraordRelSec) ,
                                           Short.valueOf(AV19PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01RR3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV19PaiCod), Integer.valueOf(AV36CliRelSec)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2057PaiExtraordRelSec = P01RR3_A2057PaiExtraordRelSec[0] ;
         A46PaiCod = P01RR3_A46PaiCod[0] ;
         A1332PaiHsExSec = P01RR3_A1332PaiHsExSec[0] ;
         A1331PaiHsPDiaTipTra = P01RR3_A1331PaiHsPDiaTipTra[0] ;
         A1333PaiHsPDiaDia = P01RR3_A1333PaiHsPDiaDia[0] ;
         A1334PaiHsPDiaDesde = P01RR3_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P01RR3_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = P01RR3_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = P01RR3_A1348PaiTarifaPDRec[0] ;
         A2434PaiTarifaPDCri = P01RR3_A2434PaiTarifaPDCri[0] ;
         A2071PaiExtraordOld = P01RR3_A2071PaiExtraordOld[0] ;
         AV37importar = false ;
         AV38liberacionPendiente = false ;
         if ( ! (0==AV36CliRelSec) )
         {
            AV37importar = true ;
         }
         else
         {
            if ( (0==A2057PaiExtraordRelSec) )
            {
               AV37importar = true ;
            }
            else
            {
               GXv_dtime3[0] = AV39CliRelease ;
               GXv_boolean4[0] = AV40CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( AV45paisCliCod, A2057PaiExtraordRelSec, GXv_dtime3, GXv_boolean4) ;
               copiarconfhorasextdepaiaemp.this.AV39CliRelease = GXv_dtime3[0] ;
               copiarconfhorasextdepaiaemp.this.AV40CliReHabilitado = GXv_boolean4[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV40CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV39CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV40CliReHabilitado ) && (( AV39CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV39CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV37importar = true ;
               }
               else
               {
                  GXv_boolean4[0] = AV41alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( AV45paisCliCod, A2057PaiExtraordRelSec, GXv_boolean4) ;
                  copiarconfhorasextdepaiaemp.this.AV41alguienYaActualizo = GXv_boolean4[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV41alguienYaActualizo))) ;
                  if ( AV41alguienYaActualizo )
                  {
                     AV37importar = true ;
                  }
                  else
                  {
                     AV38liberacionPendiente = true ;
                  }
               }
            }
         }
         if ( AV37importar )
         {
            AV25EmpHsExSec = A1332PaiHsExSec ;
            AV24EmpHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
            AV23EmpHsPDiaDia = A1333PaiHsPDiaDia ;
            AV22EmpHsPDiaDesde = A1334PaiHsPDiaDesde ;
            AV20EmpTarifaPDia = A1335PaiTarifaPDia ;
            AV21EmpTarfaPDRec = A1348PaiTarifaPDRec ;
            AV46EmpTarifaPDCri = A2434PaiTarifaPDCri ;
            /* Execute user subroutine: 'HIJO EXTRAORD' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            if ( AV38liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2071PaiExtraordOld)==0) )
               {
                  AV42PaisExtraOrdinarias_old.fromJSonString(GXutil.trim( A2071PaiExtraordOld), null);
                  AV25EmpHsExSec = A1332PaiHsExSec ;
                  AV24EmpHsPDiaTipTra = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra() ;
                  AV23EmpHsPDiaDia = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia() ;
                  AV22EmpHsPDiaDesde = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde() ;
                  AV20EmpTarifaPDia = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia() ;
                  AV21EmpTarfaPDRec = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec() ;
                  AV46EmpTarifaPDCri = AV42PaisExtraOrdinarias_old.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri() ;
                  /* Execute user subroutine: 'HIJO EXTRAORD' */
                  S121 ();
                  if ( returnInSub )
                  {
                     pr_default.close(1);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO TIPO TRA' Routine */
      returnInSub = false ;
      /*
         INSERT RECORD ON TABLE Empresatipo_trabajo

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A1294PaiTipoTraId = AV10PaiTipoTraId ;
      A1344EmpHsDia = AV11EmpHsDia ;
      A1345EmpHsSem = AV12EmpHsSem ;
      A1346EmpTarifaXLim = AV13EmpTarifaXLim ;
      A1352EmpTarifaRec = AV14EmpTarifaRec ;
      A1386EmpHsMaxDia = AV15EmpHsMaxDia ;
      A1387EmpHsMaxSem = AV16EmpHsMaxSem ;
      A1388EmpHsMaxMes = AV17EmpHsMaxMes ;
      A1389EmpHsMaxAnu = AV18EmpHsMaxAnu ;
      A2005EmpHsRelSec = AV36CliRelSec ;
      /* Using cursor P01RR4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId, A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A2005EmpHsRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
      if ( (pr_default.getStatus(2) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         /* Using cursor P01RR5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A3CliCod = P01RR5_A3CliCod[0] ;
            A1EmpCod = P01RR5_A1EmpCod[0] ;
            A1294PaiTipoTraId = P01RR5_A1294PaiTipoTraId[0] ;
            A1344EmpHsDia = P01RR5_A1344EmpHsDia[0] ;
            A1345EmpHsSem = P01RR5_A1345EmpHsSem[0] ;
            A1346EmpTarifaXLim = P01RR5_A1346EmpTarifaXLim[0] ;
            A1352EmpTarifaRec = P01RR5_A1352EmpTarifaRec[0] ;
            A1386EmpHsMaxDia = P01RR5_A1386EmpHsMaxDia[0] ;
            A1387EmpHsMaxSem = P01RR5_A1387EmpHsMaxSem[0] ;
            A1388EmpHsMaxMes = P01RR5_A1388EmpHsMaxMes[0] ;
            A1389EmpHsMaxAnu = P01RR5_A1389EmpHsMaxAnu[0] ;
            A2005EmpHsRelSec = P01RR5_A2005EmpHsRelSec[0] ;
            GXv_SdtPaisTipoTrabajo_old13[0] = AV26PaisTipoTrabajo_old_def;
            new web.paistipotrabajogetolddef(remoteHandle, context).execute( AV19PaiCod, AV10PaiTipoTraId, GXv_SdtPaisTipoTrabajo_old13) ;
            AV26PaisTipoTrabajo_old_def = GXv_SdtPaisTipoTrabajo_old13[0] ;
            if ( ( DecimalUtil.compareTo(AV11EmpHsDia, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia()) != 0 ) && ( DecimalUtil.compareTo(A1344EmpHsDia, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia()) == 0 ) )
            {
               A1344EmpHsDia = AV11EmpHsDia ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV12EmpHsSem, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohssem()) != 0 ) && ( DecimalUtil.compareTo(A1345EmpHsSem, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohssem()) == 0 ) )
            {
               A1345EmpHsSem = AV12EmpHsSem ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV13EmpTarifaXLim, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim()) != 0 ) && ( DecimalUtil.compareTo(A1346EmpTarifaXLim, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim()) == 0 ) )
            {
               A1346EmpTarifaXLim = AV13EmpTarifaXLim ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV14EmpTarifaRec, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec()) != 0 ) && ( DecimalUtil.compareTo(A1352EmpTarifaRec, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec()) == 0 ) )
            {
               A1352EmpTarifaRec = AV14EmpTarifaRec ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV15EmpHsMaxDia, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia()) != 0 ) && ( DecimalUtil.compareTo(A1386EmpHsMaxDia, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia()) == 0 ) )
            {
               A1386EmpHsMaxDia = AV15EmpHsMaxDia ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV16EmpHsMaxSem, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem()) != 0 ) && ( DecimalUtil.compareTo(A1387EmpHsMaxSem, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem()) == 0 ) )
            {
               A1387EmpHsMaxSem = AV16EmpHsMaxSem ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV17EmpHsMaxMes, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes()) != 0 ) && ( DecimalUtil.compareTo(A1388EmpHsMaxMes, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes()) == 0 ) )
            {
               A1388EmpHsMaxMes = AV17EmpHsMaxMes ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV18EmpHsMaxAnu, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu()) != 0 ) && ( DecimalUtil.compareTo(A1389EmpHsMaxAnu, AV26PaisTipoTrabajo_old_def.getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu()) == 0 ) )
            {
               A1389EmpHsMaxAnu = AV18EmpHsMaxAnu ;
               AV44actualizo = true ;
            }
            if ( AV44actualizo )
            {
               A2005EmpHsRelSec = AV36CliRelSec ;
            }
            /* Using cursor P01RR6 */
            pr_default.execute(4, new Object[] {A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A2005EmpHsRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
   }

   public void S121( )
   {
      /* 'HIJO EXTRAORD' Routine */
      returnInSub = false ;
      /*
         INSERT RECORD ON TABLE Empresahorasextras_pordia

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A1340EmpHsExSec = AV25EmpHsExSec ;
      A1339EmpHsPDiaTipTra = AV24EmpHsPDiaTipTra ;
      A1341EmpHsPDiaDia = AV23EmpHsPDiaDia ;
      A1342EmpHsPDiaDesde = AV22EmpHsPDiaDesde ;
      n1342EmpHsPDiaDesde = false ;
      A1343EmpTarifaPDia = AV20EmpTarifaPDia ;
      A1351EmpTarfaPDRec = AV21EmpTarfaPDRec ;
      A2433EmpTarifaPDCri = AV46EmpTarifaPDCri ;
      A2004EmpHsPDiaRelSec = AV36CliRelSec ;
      /* Using cursor P01RR7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, Integer.valueOf(A2004EmpHsPDiaRelSec), A2433EmpTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
      if ( (pr_default.getStatus(5) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         GXv_SdtPaisExtraOrdinarias_old14[0] = AV35PaisExtraOrdinarias_old_def;
         new web.paisextraordinariasgetolddef(remoteHandle, context).execute( AV19PaiCod, AV25EmpHsExSec, GXv_SdtPaisExtraOrdinarias_old14) ;
         AV35PaisExtraOrdinarias_old_def = GXv_SdtPaisExtraOrdinarias_old14[0] ;
         AV44actualizo = false ;
         /* Using cursor P01RR8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A3CliCod = P01RR8_A3CliCod[0] ;
            A1EmpCod = P01RR8_A1EmpCod[0] ;
            A1340EmpHsExSec = P01RR8_A1340EmpHsExSec[0] ;
            A1339EmpHsPDiaTipTra = P01RR8_A1339EmpHsPDiaTipTra[0] ;
            A1341EmpHsPDiaDia = P01RR8_A1341EmpHsPDiaDia[0] ;
            A1342EmpHsPDiaDesde = P01RR8_A1342EmpHsPDiaDesde[0] ;
            n1342EmpHsPDiaDesde = P01RR8_n1342EmpHsPDiaDesde[0] ;
            A1343EmpTarifaPDia = P01RR8_A1343EmpTarifaPDia[0] ;
            A1351EmpTarfaPDRec = P01RR8_A1351EmpTarfaPDRec[0] ;
            A2433EmpTarifaPDCri = P01RR8_A2433EmpTarifaPDCri[0] ;
            A2004EmpHsPDiaRelSec = P01RR8_A2004EmpHsPDiaRelSec[0] ;
            if ( ( GXutil.strcmp(AV24EmpHsPDiaTipTra, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra()) != 0 ) && ( GXutil.strcmp(A1339EmpHsPDiaTipTra, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra()) == 0 ) )
            {
               A1339EmpHsPDiaTipTra = AV24EmpHsPDiaTipTra ;
               AV44actualizo = true ;
            }
            if ( ( AV23EmpHsPDiaDia != AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia() ) && ( A1341EmpHsPDiaDia == AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia() ) )
            {
               A1341EmpHsPDiaDia = AV23EmpHsPDiaDia ;
               AV44actualizo = true ;
            }
            if ( ( GXutil.strcmp(AV22EmpHsPDiaDesde, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde()) != 0 ) && ( GXutil.strcmp(A1342EmpHsPDiaDesde, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde()) == 0 ) )
            {
               A1342EmpHsPDiaDesde = AV22EmpHsPDiaDesde ;
               n1342EmpHsPDiaDesde = false ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV20EmpTarifaPDia, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia()) != 0 ) && ( DecimalUtil.compareTo(A1343EmpTarifaPDia, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia()) == 0 ) )
            {
               A1343EmpTarifaPDia = AV20EmpTarifaPDia ;
               AV44actualizo = true ;
            }
            if ( ( DecimalUtil.compareTo(AV21EmpTarfaPDRec, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec()) != 0 ) && ( DecimalUtil.compareTo(A1351EmpTarfaPDRec, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec()) == 0 ) )
            {
               A1351EmpTarfaPDRec = AV21EmpTarfaPDRec ;
               AV44actualizo = true ;
            }
            if ( ( GXutil.strcmp(AV46EmpTarifaPDCri, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri()) != 0 ) && ( GXutil.strcmp(A2433EmpTarifaPDCri, AV35PaisExtraOrdinarias_old_def.getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri()) == 0 ) )
            {
               A2433EmpTarifaPDCri = AV46EmpTarifaPDCri ;
               AV44actualizo = true ;
            }
            if ( AV44actualizo )
            {
               A2004EmpHsPDiaRelSec = AV36CliRelSec ;
            }
            /* Using cursor P01RR9 */
            pr_default.execute(7, new Object[] {A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri, Integer.valueOf(A2004EmpHsPDiaRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(6);
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
      Application.commitDataStores(context, remoteHandle, pr_default, "copiarconfhorasextdepaiaemp");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P01RR2_A2055PaiTipoTraRelSec = new int[1] ;
      P01RR2_A46PaiCod = new short[1] ;
      P01RR2_A1294PaiTipoTraId = new String[] {""} ;
      P01RR2_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR2_A2070PaiTipoTraOld = new String[] {""} ;
      A1294PaiTipoTraId = "" ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      A2070PaiTipoTraOld = "" ;
      AV39CliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV50Pgmname = "" ;
      AV10PaiTipoTraId = "" ;
      AV11EmpHsDia = DecimalUtil.ZERO ;
      AV12EmpHsSem = DecimalUtil.ZERO ;
      AV13EmpTarifaXLim = DecimalUtil.ZERO ;
      AV14EmpTarifaRec = DecimalUtil.ZERO ;
      AV15EmpHsMaxDia = DecimalUtil.ZERO ;
      AV16EmpHsMaxSem = DecimalUtil.ZERO ;
      AV17EmpHsMaxMes = DecimalUtil.ZERO ;
      AV18EmpHsMaxAnu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      P01RR3_A2057PaiExtraordRelSec = new int[1] ;
      P01RR3_A46PaiCod = new short[1] ;
      P01RR3_A1332PaiHsExSec = new short[1] ;
      P01RR3_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P01RR3_A1333PaiHsPDiaDia = new byte[1] ;
      P01RR3_A1334PaiHsPDiaDesde = new String[] {""} ;
      P01RR3_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P01RR3_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR3_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR3_A2434PaiTarifaPDCri = new String[] {""} ;
      P01RR3_A2071PaiExtraordOld = new String[] {""} ;
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      A2071PaiExtraordOld = "" ;
      GXv_dtime3 = new java.util.Date[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV24EmpHsPDiaTipTra = "" ;
      AV22EmpHsPDiaDesde = "" ;
      AV20EmpTarifaPDia = DecimalUtil.ZERO ;
      AV21EmpTarfaPDRec = DecimalUtil.ZERO ;
      AV46EmpTarifaPDCri = "" ;
      AV42PaisExtraOrdinarias_old = new web.SdtPaisExtraOrdinarias_old(remoteHandle, context);
      A1344EmpHsDia = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      P01RR5_A3CliCod = new int[1] ;
      P01RR5_A1EmpCod = new short[1] ;
      P01RR5_A1294PaiTipoTraId = new String[] {""} ;
      P01RR5_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR5_A2005EmpHsRelSec = new int[1] ;
      AV26PaisTipoTrabajo_old_def = new web.SdtPaisTipoTrabajo_old(remoteHandle, context);
      GXv_SdtPaisTipoTrabajo_old13 = new web.SdtPaisTipoTrabajo_old[1] ;
      A1339EmpHsPDiaTipTra = "" ;
      A1342EmpHsPDiaDesde = "" ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      A2433EmpTarifaPDCri = "" ;
      AV35PaisExtraOrdinarias_old_def = new web.SdtPaisExtraOrdinarias_old(remoteHandle, context);
      GXv_SdtPaisExtraOrdinarias_old14 = new web.SdtPaisExtraOrdinarias_old[1] ;
      P01RR8_A3CliCod = new int[1] ;
      P01RR8_A1EmpCod = new short[1] ;
      P01RR8_A1340EmpHsExSec = new short[1] ;
      P01RR8_A1339EmpHsPDiaTipTra = new String[] {""} ;
      P01RR8_A1341EmpHsPDiaDia = new byte[1] ;
      P01RR8_A1342EmpHsPDiaDesde = new String[] {""} ;
      P01RR8_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      P01RR8_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR8_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RR8_A2433EmpTarifaPDCri = new String[] {""} ;
      P01RR8_A2004EmpHsPDiaRelSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.copiarconfhorasextdepaiaemp__default(),
         new Object[] {
             new Object[] {
            P01RR2_A2055PaiTipoTraRelSec, P01RR2_A46PaiCod, P01RR2_A1294PaiTipoTraId, P01RR2_A1336PaiTipoHsDia, P01RR2_A1337PaiTipoHsSem, P01RR2_A1338PaiTipoTarifaXLim, P01RR2_A1347PaiTipoTarifaRec, P01RR2_A1383PaiTipoHsMaxDia, P01RR2_A1384PaiTipoHsMaxSem, P01RR2_A1385PaiTipoHsMaxMes,
            P01RR2_A1390PaiTipoHsMaxAnu, P01RR2_A2070PaiTipoTraOld
            }
            , new Object[] {
            P01RR3_A2057PaiExtraordRelSec, P01RR3_A46PaiCod, P01RR3_A1332PaiHsExSec, P01RR3_A1331PaiHsPDiaTipTra, P01RR3_A1333PaiHsPDiaDia, P01RR3_A1334PaiHsPDiaDesde, P01RR3_n1334PaiHsPDiaDesde, P01RR3_A1335PaiTarifaPDia, P01RR3_A1348PaiTarifaPDRec, P01RR3_A2434PaiTarifaPDCri,
            P01RR3_A2071PaiExtraordOld
            }
            , new Object[] {
            }
            , new Object[] {
            P01RR5_A3CliCod, P01RR5_A1EmpCod, P01RR5_A1294PaiTipoTraId, P01RR5_A1344EmpHsDia, P01RR5_A1345EmpHsSem, P01RR5_A1346EmpTarifaXLim, P01RR5_A1352EmpTarifaRec, P01RR5_A1386EmpHsMaxDia, P01RR5_A1387EmpHsMaxSem, P01RR5_A1388EmpHsMaxMes,
            P01RR5_A1389EmpHsMaxAnu, P01RR5_A2005EmpHsRelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01RR8_A3CliCod, P01RR8_A1EmpCod, P01RR8_A1340EmpHsExSec, P01RR8_A1339EmpHsPDiaTipTra, P01RR8_A1341EmpHsPDiaDia, P01RR8_A1342EmpHsPDiaDesde, P01RR8_n1342EmpHsPDiaDesde, P01RR8_A1343EmpTarifaPDia, P01RR8_A1351EmpTarfaPDRec, P01RR8_A2433EmpTarifaPDCri,
            P01RR8_A2004EmpHsPDiaRelSec
            }
            , new Object[] {
            }
         }
      );
      AV50Pgmname = "copiarConfHorasExtDePaiAEmp" ;
      /* GeneXus formulas. */
      AV50Pgmname = "copiarConfHorasExtDePaiAEmp" ;
      Gx_err = (short)(0) ;
   }

   private byte A1333PaiHsPDiaDia ;
   private byte AV23EmpHsPDiaDia ;
   private byte A1341EmpHsPDiaDia ;
   private short AV19PaiCod ;
   private short AV9EmpCod ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short AV25EmpHsExSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private short A1340EmpHsExSec ;
   private int AV8CliCod ;
   private int AV36CliRelSec ;
   private int AV45paisCliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A2055PaiTipoTraRelSec ;
   private int A2057PaiExtraordRelSec ;
   private int GX_INS166 ;
   private int A3CliCod ;
   private int A2005EmpHsRelSec ;
   private int GX_INS165 ;
   private int A2004EmpHsPDiaRelSec ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal AV11EmpHsDia ;
   private java.math.BigDecimal AV12EmpHsSem ;
   private java.math.BigDecimal AV13EmpTarifaXLim ;
   private java.math.BigDecimal AV14EmpTarifaRec ;
   private java.math.BigDecimal AV15EmpHsMaxDia ;
   private java.math.BigDecimal AV16EmpHsMaxSem ;
   private java.math.BigDecimal AV17EmpHsMaxMes ;
   private java.math.BigDecimal AV18EmpHsMaxAnu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private java.math.BigDecimal AV20EmpTarifaPDia ;
   private java.math.BigDecimal AV21EmpTarfaPDRec ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private java.math.BigDecimal A1345EmpHsSem ;
   private java.math.BigDecimal A1346EmpTarifaXLim ;
   private java.math.BigDecimal A1352EmpTarifaRec ;
   private java.math.BigDecimal A1386EmpHsMaxDia ;
   private java.math.BigDecimal A1387EmpHsMaxSem ;
   private java.math.BigDecimal A1388EmpHsMaxMes ;
   private java.math.BigDecimal A1389EmpHsMaxAnu ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String AV50Pgmname ;
   private String AV10PaiTipoTraId ;
   private String A1331PaiHsPDiaTipTra ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private String AV24EmpHsPDiaTipTra ;
   private String AV22EmpHsPDiaDesde ;
   private String AV46EmpTarifaPDCri ;
   private String Gx_emsg ;
   private String A1339EmpHsPDiaTipTra ;
   private String A1342EmpHsPDiaDesde ;
   private String A2433EmpTarifaPDCri ;
   private java.util.Date AV39CliRelease ;
   private java.util.Date GXv_dtime3[] ;
   private boolean AV37importar ;
   private boolean AV38liberacionPendiente ;
   private boolean AV40CliReHabilitado ;
   private boolean AV41alguienYaActualizo ;
   private boolean returnInSub ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean GXv_boolean4[] ;
   private boolean AV44actualizo ;
   private boolean n1342EmpHsPDiaDesde ;
   private String A2070PaiTipoTraOld ;
   private String A2071PaiExtraordOld ;
   private IDataStoreProvider pr_default ;
   private int[] P01RR2_A2055PaiTipoTraRelSec ;
   private short[] P01RR2_A46PaiCod ;
   private String[] P01RR2_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] P01RR2_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] P01RR2_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] P01RR2_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] P01RR2_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] P01RR2_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] P01RR2_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] P01RR2_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] P01RR2_A1390PaiTipoHsMaxAnu ;
   private String[] P01RR2_A2070PaiTipoTraOld ;
   private int[] P01RR3_A2057PaiExtraordRelSec ;
   private short[] P01RR3_A46PaiCod ;
   private short[] P01RR3_A1332PaiHsExSec ;
   private String[] P01RR3_A1331PaiHsPDiaTipTra ;
   private byte[] P01RR3_A1333PaiHsPDiaDia ;
   private String[] P01RR3_A1334PaiHsPDiaDesde ;
   private boolean[] P01RR3_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] P01RR3_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] P01RR3_A1348PaiTarifaPDRec ;
   private String[] P01RR3_A2434PaiTarifaPDCri ;
   private String[] P01RR3_A2071PaiExtraordOld ;
   private int[] P01RR5_A3CliCod ;
   private short[] P01RR5_A1EmpCod ;
   private String[] P01RR5_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] P01RR5_A1344EmpHsDia ;
   private java.math.BigDecimal[] P01RR5_A1345EmpHsSem ;
   private java.math.BigDecimal[] P01RR5_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] P01RR5_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] P01RR5_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] P01RR5_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] P01RR5_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] P01RR5_A1389EmpHsMaxAnu ;
   private int[] P01RR5_A2005EmpHsRelSec ;
   private int[] P01RR8_A3CliCod ;
   private short[] P01RR8_A1EmpCod ;
   private short[] P01RR8_A1340EmpHsExSec ;
   private String[] P01RR8_A1339EmpHsPDiaTipTra ;
   private byte[] P01RR8_A1341EmpHsPDiaDia ;
   private String[] P01RR8_A1342EmpHsPDiaDesde ;
   private boolean[] P01RR8_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] P01RR8_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] P01RR8_A1351EmpTarfaPDRec ;
   private String[] P01RR8_A2433EmpTarifaPDCri ;
   private int[] P01RR8_A2004EmpHsPDiaRelSec ;
   private web.SdtPaisTipoTrabajo_old AV26PaisTipoTrabajo_old_def ;
   private web.SdtPaisTipoTrabajo_old GXv_SdtPaisTipoTrabajo_old13[] ;
   private web.SdtPaisExtraOrdinarias_old AV42PaisExtraOrdinarias_old ;
   private web.SdtPaisExtraOrdinarias_old AV35PaisExtraOrdinarias_old_def ;
   private web.SdtPaisExtraOrdinarias_old GXv_SdtPaisExtraOrdinarias_old14[] ;
}

final  class copiarconfhorasextdepaiaemp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV36CliRelSec ,
                                          int A2055PaiTipoTraRelSec ,
                                          short AV19PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[2];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT PaiTipoTraRelSec, PaiCod, PaiTipoTraId, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes," ;
      scmdbuf += " PaiTipoHsMaxAnu, PaiTipoTraOld FROM PaisTipoTrabajo" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (0==AV36CliRelSec) )
      {
         addWhere(sWhereString, "(PaiTipoTraRelSec = ?)");
      }
      else
      {
         GXv_int15[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_P01RR3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV36CliRelSec ,
                                          int A2057PaiExtraordRelSec ,
                                          short AV19PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[2];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT PaiExtraordRelSec, PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiTarifaPDCri, PaiExtraordOld FROM Paishorasextras_pordia" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (0==AV36CliRelSec) )
      {
         addWhere(sWhereString, "(PaiExtraordRelSec = ?)");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P01RR2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
            case 1 :
                  return conditional_P01RR3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RR3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01RR4", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, PaiTipoTraId, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01RR5", "SELECT CliCod, EmpCod, PaiTipoTraId, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RR6", "SAVEPOINT gxupdate;UPDATE Empresatipo_trabajo SET EmpHsDia=?, EmpHsSem=?, EmpTarifaXLim=?, EmpTarifaRec=?, EmpHsMaxDia=?, EmpHsMaxSem=?, EmpHsMaxMes=?, EmpHsMaxAnu=?, EmpHsRelSec=?  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01RR7", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpHsPDiaRelSec, EmpTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01RR8", "SELECT CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? and EmpHsExSec = ? ORDER BY CliCod, EmpCod, EmpHsExSec  FOR UPDATE OF Empresahorasextras_pordia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RR9", "SAVEPOINT gxupdate;UPDATE Empresahorasextras_pordia SET EmpHsPDiaTipTra=?, EmpHsPDiaDia=?, EmpHsPDiaDesde=?, EmpTarifaPDia=?, EmpTarfaPDRec=?, EmpTarifaPDCri=?, EmpHsPDiaRelSec=?  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 1);
               stmt.setInt(12, ((Number) parms[11]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setString(12, (String)parms[11], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 5);
               }
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 4);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setString(10, (String)parms[10], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setString(6, (String)parms[6], 20);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setShort(10, ((Number) parms[10]).shortValue());
               return;
      }
   }

}

