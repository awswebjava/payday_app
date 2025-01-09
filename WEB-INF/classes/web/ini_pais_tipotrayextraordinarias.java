package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_tipotrayextraordinarias extends GXProcedure
{
   public ini_pais_tipotrayextraordinarias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_tipotrayextraordinarias.class ), "" );
   }

   public ini_pais_tipotrayextraordinarias( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      ini_pais_tipotrayextraordinarias.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE PaisTipoTrabajo

      */
      A46PaiCod = AV8PaiCod ;
      A1294PaiTipoTraId = "diurno" ;
      A1297PaiTipoTraIns = false ;
      A1336PaiTipoHsDia = DecimalUtil.doubleToDec(8) ;
      A1337PaiTipoHsSem = DecimalUtil.doubleToDec(48) ;
      A1338PaiTipoTarifaXLim = DecimalUtil.stringToDec("1.5") ;
      A1347PaiTipoTarifaRec = DecimalUtil.doubleToDec(0) ;
      A1383PaiTipoHsMaxDia = DecimalUtil.doubleToDec(3) ;
      A1384PaiTipoHsMaxSem = DecimalUtil.doubleToDec(0) ;
      A1385PaiTipoHsMaxMes = DecimalUtil.doubleToDec(30) ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.doubleToDec(200) ;
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( A1336PaiTipoHsDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( A1337PaiTipoHsSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( A1338PaiTipoTarifaXLim );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( A1347PaiTipoTarifaRec );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( A1383PaiTipoHsMaxDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( A1384PaiTipoHsMaxSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( A1385PaiTipoHsMaxMes );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( A1390PaiTipoHsMaxAnu );
      A2070PaiTipoTraOld = AV9PaisTipoTrabajo_old.toJSonString(false, true) ;
      A1296PaiTipoTraHor = "" ;
      n1296PaiTipoTraHor = false ;
      A1976PaiTipoTraOldDefault = "" ;
      A2055PaiTipoTraRelSec = 0 ;
      A2056PaiTipoTraRelRef = "" ;
      /* Using cursor P01HT2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId, Boolean.valueOf(n1296PaiTipoTraHor), A1296PaiTipoTraHor, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, A1976PaiTipoTraOldDefault, Integer.valueOf(A2055PaiTipoTraRelSec), A2056PaiTipoTraRelRef, A2070PaiTipoTraOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
      if ( (pr_default.getStatus(0) == 1) )
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
         INSERT RECORD ON TABLE PaisTipoTrabajo

      */
      A46PaiCod = AV8PaiCod ;
      A1294PaiTipoTraId = "nocturno" ;
      A1297PaiTipoTraIns = false ;
      A1336PaiTipoHsDia = DecimalUtil.doubleToDec(7) ;
      A1337PaiTipoHsSem = DecimalUtil.doubleToDec(42) ;
      A1338PaiTipoTarifaXLim = DecimalUtil.stringToDec("1.5") ;
      A1347PaiTipoTarifaRec = DecimalUtil.stringToDec("1.1333") ;
      A1383PaiTipoHsMaxDia = DecimalUtil.doubleToDec(3) ;
      A1384PaiTipoHsMaxSem = DecimalUtil.doubleToDec(0) ;
      A1385PaiTipoHsMaxMes = DecimalUtil.doubleToDec(30) ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.doubleToDec(200) ;
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( A1336PaiTipoHsDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( A1337PaiTipoHsSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( A1338PaiTipoTarifaXLim );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( A1347PaiTipoTarifaRec );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( A1383PaiTipoHsMaxDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( A1384PaiTipoHsMaxSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( A1385PaiTipoHsMaxMes );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( A1390PaiTipoHsMaxAnu );
      A2070PaiTipoTraOld = AV9PaisTipoTrabajo_old.toJSonString(false, true) ;
      A1296PaiTipoTraHor = "" ;
      n1296PaiTipoTraHor = false ;
      A1976PaiTipoTraOldDefault = "" ;
      A2055PaiTipoTraRelSec = 0 ;
      A2056PaiTipoTraRelRef = "" ;
      /* Using cursor P01HT3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId, Boolean.valueOf(n1296PaiTipoTraHor), A1296PaiTipoTraHor, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, A1976PaiTipoTraOldDefault, Integer.valueOf(A2055PaiTipoTraRelSec), A2056PaiTipoTraRelRef, A2070PaiTipoTraOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
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
         INSERT RECORD ON TABLE PaisTipoTrabajo

      */
      A46PaiCod = AV8PaiCod ;
      A1294PaiTipoTraId = "insalubre" ;
      A1297PaiTipoTraIns = true ;
      A1336PaiTipoHsDia = DecimalUtil.doubleToDec(6) ;
      A1337PaiTipoHsSem = DecimalUtil.doubleToDec(36) ;
      A1338PaiTipoTarifaXLim = DecimalUtil.doubleToDec(0) ;
      A1347PaiTipoTarifaRec = DecimalUtil.doubleToDec(1) ;
      A1383PaiTipoHsMaxDia = DecimalUtil.doubleToDec(0) ;
      A1384PaiTipoHsMaxSem = DecimalUtil.doubleToDec(0) ;
      A1385PaiTipoHsMaxMes = DecimalUtil.doubleToDec(0) ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.doubleToDec(0) ;
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( A1336PaiTipoHsDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( A1337PaiTipoHsSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( A1338PaiTipoTarifaXLim );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( A1347PaiTipoTarifaRec );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( A1383PaiTipoHsMaxDia );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( A1384PaiTipoHsMaxSem );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( A1385PaiTipoHsMaxMes );
      AV9PaisTipoTrabajo_old.setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( A1390PaiTipoHsMaxAnu );
      A2070PaiTipoTraOld = AV9PaisTipoTrabajo_old.toJSonString(false, true) ;
      A1296PaiTipoTraHor = "" ;
      n1296PaiTipoTraHor = false ;
      A1976PaiTipoTraOldDefault = "" ;
      A2055PaiTipoTraRelSec = 0 ;
      A2056PaiTipoTraRelRef = "" ;
      /* Using cursor P01HT4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId, Boolean.valueOf(n1296PaiTipoTraHor), A1296PaiTipoTraHor, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, A1976PaiTipoTraOldDefault, Integer.valueOf(A2055PaiTipoTraRelSec), A2056PaiTipoTraRelRef, A2070PaiTipoTraOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(1) ;
      A1331PaiHsPDiaTipTra = "diurno" ;
      A1333PaiHsPDiaDia = (byte)(7) ;
      A1334PaiHsPDiaDesde = "13:00" ;
      n1334PaiHsPDiaDesde = false ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.doubleToDec(0) ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(2) ;
      A1331PaiHsPDiaTipTra = "nocturno" ;
      A1333PaiHsPDiaDia = (byte)(7) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      n1334PaiHsPDiaDesde = true ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.stringToDec("1.1333") ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(3) ;
      A1331PaiHsPDiaTipTra = "diurno" ;
      A1333PaiHsPDiaDia = (byte)(1) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      n1334PaiHsPDiaDesde = true ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.doubleToDec(0) ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(4) ;
      A1331PaiHsPDiaTipTra = "nocturno" ;
      A1333PaiHsPDiaDia = (byte)(1) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      n1334PaiHsPDiaDesde = true ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.stringToDec("1.1333") ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(5) ;
      A1331PaiHsPDiaTipTra = "diurno" ;
      A1333PaiHsPDiaDia = (byte)(8) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      n1334PaiHsPDiaDesde = true ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.doubleToDec(0) ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
         INSERT RECORD ON TABLE Paishorasextras_pordia

      */
      A46PaiCod = AV8PaiCod ;
      A1332PaiHsExSec = (short)(6) ;
      A1331PaiHsPDiaTipTra = "nocturno" ;
      A1333PaiHsPDiaDia = (byte)(8) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      n1334PaiHsPDiaDesde = true ;
      A1335PaiTarifaPDia = DecimalUtil.doubleToDec(2) ;
      A1348PaiTarifaPDRec = DecimalUtil.stringToDec("1.1333") ;
      A2434PaiTarifaPDCri = "horario" ;
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( A1333PaiHsPDiaDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( A1334PaiHsPDiaDesde );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( A1335PaiTarifaPDia );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( A1348PaiTarifaPDRec );
      AV10PaisExtraOrdinarias_old.setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( A2434PaiTarifaPDCri );
      A2071PaiExtraordOld = AV10PaisExtraOrdinarias_old.toJSonString(false, true) ;
      A1977PaiExtraordOldDefault = "" ;
      A2057PaiExtraordRelSec = 0 ;
      A2058PaiExtraordRelRef = "" ;
      /* Using cursor P01HT10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec), A1331PaiHsPDiaTipTra, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1977PaiExtraordOldDefault, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A2434PaiTarifaPDCri});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_tipotrayextraordinarias");
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
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV9PaisTipoTrabajo_old = new web.SdtPaisTipoTrabajo_old(remoteHandle, context);
      A2070PaiTipoTraOld = "" ;
      A1296PaiTipoTraHor = "" ;
      A1976PaiTipoTraOldDefault = "" ;
      A2056PaiTipoTraRelRef = "" ;
      Gx_emsg = "" ;
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      AV10PaisExtraOrdinarias_old = new web.SdtPaisExtraOrdinarias_old(remoteHandle, context);
      A2071PaiExtraordOld = "" ;
      A1977PaiExtraordOldDefault = "" ;
      A2058PaiExtraordRelRef = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_tipotrayextraordinarias__default(),
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
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1333PaiHsPDiaDia ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private short A1332PaiHsExSec ;
   private int GX_INS155 ;
   private int A2055PaiTipoTraRelSec ;
   private int GX_INS164 ;
   private int A2057PaiExtraordRelSec ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String A1294PaiTipoTraId ;
   private String A1296PaiTipoTraHor ;
   private String Gx_emsg ;
   private String A1331PaiHsPDiaTipTra ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private boolean A1297PaiTipoTraIns ;
   private boolean n1296PaiTipoTraHor ;
   private boolean n1334PaiHsPDiaDesde ;
   private String A2070PaiTipoTraOld ;
   private String A1976PaiTipoTraOldDefault ;
   private String A2071PaiExtraordOld ;
   private String A1977PaiExtraordOldDefault ;
   private String A2056PaiTipoTraRelRef ;
   private String A2058PaiExtraordRelRef ;
   private web.SdtPaisTipoTrabajo_old AV9PaisTipoTrabajo_old ;
   private web.SdtPaisExtraOrdinarias_old AV10PaisExtraOrdinarias_old ;
   private IDataStoreProvider pr_default ;
}

final  class ini_pais_tipotrayextraordinarias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HT2", "SAVEPOINT gxupdate;INSERT INTO PaisTipoTrabajo(PaiCod, PaiTipoTraId, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraOldDefault, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT3", "SAVEPOINT gxupdate;INSERT INTO PaisTipoTrabajo(PaiCod, PaiTipoTraId, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraOldDefault, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT4", "SAVEPOINT gxupdate;INSERT INTO PaisTipoTrabajo(PaiCod, PaiTipoTraId, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraOldDefault, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT5", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT6", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT7", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT8", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT9", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HT10", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiCod, PaiHsExSec, PaiHsPDiaTipTra, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 4);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 1);
               stmt.setNLongVarchar(13, (String)parms[13], false);
               stmt.setInt(14, ((Number) parms[14]).intValue());
               stmt.setVarchar(15, (String)parms[15], 40, false);
               stmt.setNLongVarchar(16, (String)parms[16], false);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 4);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 1);
               stmt.setNLongVarchar(13, (String)parms[13], false);
               stmt.setInt(14, ((Number) parms[14]).intValue());
               stmt.setVarchar(15, (String)parms[15], 40, false);
               stmt.setNLongVarchar(16, (String)parms[16], false);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 4);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 1);
               stmt.setNLongVarchar(13, (String)parms[13], false);
               stmt.setInt(14, ((Number) parms[14]).intValue());
               stmt.setVarchar(15, (String)parms[15], 40, false);
               stmt.setNLongVarchar(16, (String)parms[16], false);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 5);
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               stmt.setString(12, (String)parms[12], 20);
               return;
      }
   }

}

