package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresajornadalegal extends GXProcedure
{
   public empresajornadalegal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresajornadalegal.class ), "" );
   }

   public empresajornadalegal( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      empresajornadalegal.this.AV9CliCod = aP0;
      empresajornadalegal.this.AV8EmpCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n1303EmpDiaHsPExt = false ;
      n1302EmpMesHsPExt = false ;
      /* Optimized UPDATE. */
      /* Using cursor P01DZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      /* End optimized UPDATE. */
      if ( false )
      {
         /*
            INSERT RECORD ON TABLE Empresatipo_trabajo

         */
         A3CliCod = AV9CliCod ;
         A1EmpCod = AV8EmpCod ;
         A1294PaiTipoTraId = "diurno" ;
         A1344EmpHsDia = DecimalUtil.doubleToDec(8) ;
         A1345EmpHsSem = DecimalUtil.doubleToDec(48) ;
         A1346EmpTarifaXLim = DecimalUtil.stringToDec("1.5") ;
         A1352EmpTarifaRec = DecimalUtil.doubleToDec(0) ;
         A1386EmpHsMaxDia = DecimalUtil.doubleToDec(3) ;
         A1387EmpHsMaxSem = DecimalUtil.doubleToDec(0) ;
         A1388EmpHsMaxMes = DecimalUtil.doubleToDec(30) ;
         A1389EmpHsMaxAnu = DecimalUtil.doubleToDec(200) ;
         /* Using cursor P01DZ3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId, A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresatipo_trabajo

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1294PaiTipoTraId = "nocturno" ;
         A1344EmpHsDia = DecimalUtil.doubleToDec(7) ;
         A1345EmpHsSem = DecimalUtil.doubleToDec(42) ;
         A1346EmpTarifaXLim = DecimalUtil.stringToDec("1.5") ;
         A1352EmpTarifaRec = DecimalUtil.stringToDec("1.1333") ;
         A1386EmpHsMaxDia = DecimalUtil.doubleToDec(3) ;
         A1387EmpHsMaxSem = DecimalUtil.doubleToDec(0) ;
         A1388EmpHsMaxMes = DecimalUtil.doubleToDec(30) ;
         A1389EmpHsMaxAnu = DecimalUtil.doubleToDec(200) ;
         /* Using cursor P01DZ4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId, A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresatipo_trabajo

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1294PaiTipoTraId = "insalubre" ;
         A1344EmpHsDia = DecimalUtil.doubleToDec(6) ;
         A1345EmpHsSem = DecimalUtil.doubleToDec(36) ;
         A1346EmpTarifaXLim = DecimalUtil.doubleToDec(0) ;
         A1352EmpTarifaRec = DecimalUtil.doubleToDec(1) ;
         A1386EmpHsMaxDia = DecimalUtil.doubleToDec(0) ;
         A1387EmpHsMaxSem = DecimalUtil.doubleToDec(0) ;
         A1388EmpHsMaxMes = DecimalUtil.doubleToDec(0) ;
         A1389EmpHsMaxAnu = DecimalUtil.doubleToDec(0) ;
         /* Using cursor P01DZ5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId, A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(1) ;
         A1339EmpHsPDiaTipTra = "diurno" ;
         A1341EmpHsPDiaDia = (byte)(7) ;
         A1342EmpHsPDiaDesde = "13:00" ;
         n1342EmpHsPDiaDesde = false ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.doubleToDec(0) ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(4) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(2) ;
         A1339EmpHsPDiaTipTra = "nocturno" ;
         A1341EmpHsPDiaDia = (byte)(7) ;
         A1342EmpHsPDiaDesde = "" ;
         n1342EmpHsPDiaDesde = false ;
         n1342EmpHsPDiaDesde = true ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.stringToDec("1.1333") ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(5) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(3) ;
         A1339EmpHsPDiaTipTra = "diurno" ;
         A1341EmpHsPDiaDia = (byte)(1) ;
         A1342EmpHsPDiaDesde = "" ;
         n1342EmpHsPDiaDesde = false ;
         n1342EmpHsPDiaDesde = true ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.doubleToDec(0) ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(6) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(4) ;
         A1339EmpHsPDiaTipTra = "nocturno" ;
         A1341EmpHsPDiaDia = (byte)(1) ;
         A1342EmpHsPDiaDesde = "" ;
         n1342EmpHsPDiaDesde = false ;
         n1342EmpHsPDiaDesde = true ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.stringToDec("1.1333") ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(7) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(5) ;
         A1339EmpHsPDiaTipTra = "diurno" ;
         A1341EmpHsPDiaDia = (byte)(8) ;
         A1342EmpHsPDiaDesde = "" ;
         n1342EmpHsPDiaDesde = false ;
         n1342EmpHsPDiaDesde = true ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.doubleToDec(0) ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ10 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(8) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Empresahorasextras_pordia

         */
         A1EmpCod = AV8EmpCod ;
         A3CliCod = AV9CliCod ;
         A1340EmpHsExSec = (short)(6) ;
         A1339EmpHsPDiaTipTra = "nocturno" ;
         A1341EmpHsPDiaDia = (byte)(8) ;
         A1342EmpHsPDiaDesde = "" ;
         n1342EmpHsPDiaDesde = false ;
         n1342EmpHsPDiaDesde = true ;
         A1343EmpTarifaPDia = DecimalUtil.doubleToDec(2) ;
         A1351EmpTarfaPDRec = DecimalUtil.stringToDec("1.1333") ;
         A2433EmpTarifaPDCri = "horario" ;
         /* Using cursor P01DZ11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec), A1339EmpHsPDiaTipTra, Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A2433EmpTarifaPDCri});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
         if ( (pr_default.getStatus(9) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "empresajornadalegal");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1294PaiTipoTraId = "" ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      A1342EmpHsPDiaDesde = "" ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      A2433EmpTarifaPDCri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresajornadalegal__default(),
         new Object[] {
             new Object[] {
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
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1341EmpHsPDiaDia ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private short A1340EmpHsExSec ;
   private int AV9CliCod ;
   private int GX_INS166 ;
   private int A3CliCod ;
   private int GX_INS165 ;
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
   private String A1294PaiTipoTraId ;
   private String Gx_emsg ;
   private String A1339EmpHsPDiaTipTra ;
   private String A1342EmpHsPDiaDesde ;
   private String A2433EmpTarifaPDCri ;
   private boolean n1303EmpDiaHsPExt ;
   private boolean n1302EmpMesHsPExt ;
   private boolean n1342EmpHsPDiaDesde ;
   private IDataStoreProvider pr_default ;
}

final  class empresajornadalegal__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01DZ2", "UPDATE Empresa SET EmpDiaHsPExt='', EmpMesHsPExt=0  WHERE CliCod = ? and EmpCod = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ3", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, PaiTipoTraId, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ4", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, PaiTipoTraId, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ5", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, PaiTipoTraId, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ6", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ7", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ8", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ9", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ10", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01DZ11", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(CliCod, EmpCod, EmpHsExSec, EmpHsPDiaTipTra, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, EmpTarifaPDCri, EmpHsPDiaRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               return;
            case 1 :
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
               return;
            case 3 :
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
               return;
            case 4 :
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
               stmt.setString(9, (String)parms[9], 20);
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
               stmt.setString(9, (String)parms[9], 20);
               return;
            case 6 :
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
               stmt.setString(9, (String)parms[9], 20);
               return;
            case 7 :
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
               stmt.setString(9, (String)parms[9], 20);
               return;
            case 8 :
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
               stmt.setString(9, (String)parms[9], 20);
               return;
            case 9 :
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
               stmt.setString(9, (String)parms[9], 20);
               return;
      }
   }

}

