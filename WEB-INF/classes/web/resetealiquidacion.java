package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resetealiquidacion extends GXProcedure
{
   public resetealiquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resetealiquidacion.class ), "" );
   }

   public resetealiquidacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      resetealiquidacion.this.AV23CliCod = aP0;
      resetealiquidacion.this.AV12EmpCod = aP1;
      resetealiquidacion.this.AV13LiqNro = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.deletecolaporliqnro(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, AV13LiqNro) ;
      GXv_char1[0] = AV25error ;
      new web.resetearecibos(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, AV13LiqNro, 0, GXv_char1) ;
      resetealiquidacion.this.AV25error = GXv_char1[0] ;
      if ( ! (GXutil.strcmp("", AV25error)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Error al eliminar recibo. ", "")+GXutil.trim( AV25error)) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.eliminarliquisretroactivas(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, AV13LiqNro) ;
      /* Using cursor P00842 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00842_A31LiqNro[0] ;
         A1EmpCod = P00842_A1EmpCod[0] ;
         A3CliCod = P00842_A3CliCod[0] ;
         A283LiqPeriodo = P00842_A283LiqPeriodo[0] ;
         A32TLiqCod = P00842_A32TLiqCod[0] ;
         n32TLiqCod = P00842_n32TLiqCod[0] ;
         A268LiqClase = P00842_A268LiqClase[0] ;
         n268LiqClase = P00842_n268LiqClase[0] ;
         A2298LiqCancel = P00842_A2298LiqCancel[0] ;
         A496LiqImpNeto = P00842_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = P00842_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = P00842_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = P00842_A497LiqImpBruto[0] ;
         A719LiqFecImp = P00842_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = P00842_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = P00842_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = P00842_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = P00842_A746LiqPerUltNorm[0] ;
         A885LiqSegundos = P00842_A885LiqSegundos[0] ;
         A1142LiqLog = P00842_A1142LiqLog[0] ;
         A963LiqRutaPDFTodosVertical = P00842_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = P00842_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = P00842_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = P00842_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A766LiqError = P00842_A766LiqError[0] ;
         A278LiqEstado = P00842_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = P00842_A2292LiqLSDDepEst[0] ;
         A2293LiqContrEst = P00842_A2293LiqContrEst[0] ;
         A1403LiqAuxEstado = P00842_A1403LiqAuxEstado[0] ;
         A2180LiqPDFEstado = P00842_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = P00842_n2180LiqPDFEstado[0] ;
         AV28LiqPeriodo = A283LiqPeriodo ;
         AV20aplicaA = httpContext.getMessage( "ALGUNOS", "") ;
         AV40TliqCod = A32TLiqCod ;
         AV46LiqClase = A268LiqClase ;
         A2298LiqCancel = false ;
         A496LiqImpNeto = DecimalUtil.ZERO ;
         A755LiqImpDescuentos = DecimalUtil.ZERO ;
         A756LiqImpRetenGan = DecimalUtil.ZERO ;
         A497LiqImpBruto = DecimalUtil.ZERO ;
         A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
         A743LiqPisoGanancias = DecimalUtil.ZERO ;
         A744LiqPisGanSAC = DecimalUtil.ZERO ;
         A745LiqTopeDedInc = DecimalUtil.ZERO ;
         A746LiqPerUltNorm = GXutil.nullDate() ;
         A885LiqSegundos = DecimalUtil.ZERO ;
         A1142LiqLog = "" ;
         A963LiqRutaPDFTodosVertical = "" ;
         A964LiqRutaPDFTodosHorizontal = "" ;
         A965LiqRutaPDFTodosNombreVertical = "" ;
         A966LiqRutaPDFTodosNombreHorizonta = "" ;
         A766LiqError = "" ;
         A278LiqEstado = (byte)(1) ;
         A2292LiqLSDDepEst = (byte)(0) ;
         A2293LiqContrEst = (byte)(0) ;
         A1403LiqAuxEstado = (byte)(0) ;
         A2180LiqPDFEstado = "Pendiente" ;
         n2180LiqPDFEstado = false ;
         /* Using cursor P00843 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A2298LiqCancel), A496LiqImpNeto, A755LiqImpDescuentos, A756LiqImpRetenGan, A497LiqImpBruto, A719LiqFecImp, A743LiqPisoGanancias, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A885LiqSegundos, A1142LiqLog, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A766LiqError, Byte.valueOf(A278LiqEstado), Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A2293LiqContrEst), Byte.valueOf(A1403LiqAuxEstado), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV27LiqLegConAnio = (short)(GXutil.year( AV28LiqPeriodo)) ;
      /* Using cursor P00844 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1649LSDSec = P00844_A1649LSDSec[0] ;
         A1EmpCod = P00844_A1EmpCod[0] ;
         A3CliCod = P00844_A3CliCod[0] ;
         A1733LSD1LiqNro = P00844_A1733LSD1LiqNro[0] ;
         /* Using cursor P00845 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1657LSD2Sec = P00845_A1657LSD2Sec[0] ;
            /* Optimized DELETE. */
            /* Using cursor P00846 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
            /* End optimized DELETE. */
            /* Optimized DELETE. */
            /* Using cursor P00847 */
            pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
            /* End optimized DELETE. */
            /* Using cursor P00848 */
            pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
            pr_default.readNext(3);
         }
         pr_default.close(3);
         /* Optimized DELETE. */
         /* Using cursor P00849 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg5");
         /* End optimized DELETE. */
         /* Using cursor P008410 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg1");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /* Optimized DELETE. */
      /* Using cursor P008411 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P008412 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajoLinkPdf");
      /* End optimized DELETE. */
      new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV59Pgmname, httpContext.getMessage( "bora liqlote cli ", "")+GXutil.trim( GXutil.str( AV23CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV13LiqNro, 8, 0))) ;
      AV60GXLvl92 = (byte)(0) ;
      /* Using cursor P008413 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      while ( (pr_default.getStatus(11) != 101) )
      {
         A2373LiqBatchSeccion = P008413_A2373LiqBatchSeccion[0] ;
         A2372LiqBatchCod = P008413_A2372LiqBatchCod[0] ;
         A2371LiqBatchLiqNro = P008413_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P008413_A1EmpCod[0] ;
         A3CliCod = P008413_A3CliCod[0] ;
         AV60GXLvl92 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV59Pgmname, httpContext.getMessage( "delete liqlote", "")) ;
         /* Optimized DELETE. */
         /* Using cursor P008414 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A2371LiqBatchLiqNro), A2372LiqBatchCod, A2373LiqBatchSeccion});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3Leg");
         /* End optimized DELETE. */
         /* Using cursor P008415 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A2371LiqBatchLiqNro), A2372LiqBatchCod, A2373LiqBatchSeccion});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3");
         pr_default.readNext(11);
      }
      pr_default.close(11);
      if ( AV60GXLvl92 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV59Pgmname, httpContext.getMessage( "NONE delete liqlote", "")) ;
      }
      /* Using cursor P008416 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A31LiqNro = P008416_A31LiqNro[0] ;
         A1EmpCod = P008416_A1EmpCod[0] ;
         A3CliCod = P008416_A3CliCod[0] ;
         A6LegNumero = P008416_A6LegNumero[0] ;
         AV48updLegNumero.add((int)(A6LegNumero), 0);
         pr_default.readNext(14);
      }
      pr_default.close(14);
      AV21i = (short)(1) ;
      while ( AV21i <= AV48updLegNumero.size() )
      {
         AV63GXLvl121 = (byte)(0) ;
         /* Using cursor P008417 */
         pr_default.execute(15, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
         while ( (pr_default.getStatus(15) != 101) )
         {
            A6LegNumero = P008417_A6LegNumero[0] ;
            A31LiqNro = P008417_A31LiqNro[0] ;
            A1EmpCod = P008417_A1EmpCod[0] ;
            A3CliCod = P008417_A3CliCod[0] ;
            A2268LiqLegProcesado = P008417_A2268LiqLegProcesado[0] ;
            A2401LiqLegDaemonUUID = P008417_A2401LiqLegDaemonUUID[0] ;
            n2401LiqLegDaemonUUID = P008417_n2401LiqLegDaemonUUID[0] ;
            A2402LiqLegFecHor = P008417_A2402LiqLegFecHor[0] ;
            A482LegLiqDatosHis = P008417_A482LegLiqDatosHis[0] ;
            A498LiqLegImpTotBruto = P008417_A498LiqLegImpTotBruto[0] ;
            A759LiqLegImpTotBruSinSAC = P008417_A759LiqLegImpTotBruSinSAC[0] ;
            A499LiqLegCntConc = P008417_A499LiqLegCntConc[0] ;
            A577LiqLegImpTotRemu = P008417_A577LiqLegImpTotRemu[0] ;
            A578LiqLegImpTotNoRemu = P008417_A578LiqLegImpTotNoRemu[0] ;
            A579LiqLegImpTotDescu = P008417_A579LiqLegImpTotDescu[0] ;
            A757LiqLegImpTotRetGan = P008417_A757LiqLegImpTotRetGan[0] ;
            A775LiqLegImpPagosACuen = P008417_A775LiqLegImpPagosACuen[0] ;
            A758LiqLegImpTotBruProm = P008417_A758LiqLegImpTotBruProm[0] ;
            A760LiqLegImpBasico = P008417_A760LiqLegImpBasico[0] ;
            A761LiqLegGNSI = P008417_A761LiqLegGNSI[0] ;
            A590LiqRutaPDF = P008417_A590LiqRutaPDF[0] ;
            A774LiqRutaPDFVertical = P008417_A774LiqRutaPDFVertical[0] ;
            A883LIqLegIteraciones = P008417_A883LIqLegIteraciones[0] ;
            A884LiqLegSegundos = P008417_A884LiqLegSegundos[0] ;
            A891LiqLegError = P008417_A891LiqLegError[0] ;
            A961LiqNombrePDF = P008417_A961LiqNombrePDF[0] ;
            A2393LiqLegHtml = P008417_A2393LiqLegHtml[0] ;
            A962LiqNombrePDFVertical = P008417_A962LiqNombrePDFVertical[0] ;
            A2114LiqLegSueldo = P008417_A2114LiqLegSueldo[0] ;
            A2115LiqLegConvenio = P008417_A2115LiqLegConvenio[0] ;
            A2113LiqLegCatCodigo = P008417_A2113LiqLegCatCodigo[0] ;
            if ( A6LegNumero == ((Number) AV48updLegNumero.elementAt(-1+AV21i)).intValue() )
            {
               AV63GXLvl121 = (byte)(1) ;
               A2268LiqLegProcesado = (byte)(0) ;
               GXv_char1[0] = AV47LiqLegDaemonUUID ;
               new web.getpdfdaemon(remoteHandle, context).execute( AV23CliCod, GXv_char1) ;
               resetealiquidacion.this.AV47LiqLegDaemonUUID = GXv_char1[0] ;
               A2401LiqLegDaemonUUID = AV47LiqLegDaemonUUID ;
               n2401LiqLegDaemonUUID = false ;
               GXt_dtime2 = A2402LiqLegFecHor ;
               GXv_dtime3[0] = GXt_dtime2 ;
               new web.getahora(remoteHandle, context).execute( AV23CliCod, GXv_dtime3) ;
               resetealiquidacion.this.GXt_dtime2 = GXv_dtime3[0] ;
               A2402LiqLegFecHor = GXutil.resetMillis(GXt_dtime2) ;
               A482LegLiqDatosHis = "" ;
               A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
               A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
               A499LiqLegCntConc = (short)(0) ;
               A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
               A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
               A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
               A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
               A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
               A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
               A760LiqLegImpBasico = DecimalUtil.ZERO ;
               A761LiqLegGNSI = DecimalUtil.ZERO ;
               A590LiqRutaPDF = "" ;
               A774LiqRutaPDFVertical = "" ;
               A883LIqLegIteraciones = (short)(0) ;
               A884LiqLegSegundos = DecimalUtil.ZERO ;
               A891LiqLegError = "" ;
               A961LiqNombrePDF = "" ;
               A2393LiqLegHtml = "" ;
               A962LiqNombrePDFVertical = "" ;
               if ( AV46LiqClase == 0 )
               {
                  AV41LegClase = (byte)(1) ;
               }
               else
               {
                  AV41LegClase = (byte)(2) ;
               }
               GXv_date4[0] = AV42fecha ;
               GXv_date5[0] = AV43finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, AV40TliqCod, AV41LegClase, AV28LiqPeriodo, false, GXv_date4, GXv_date5) ;
               resetealiquidacion.this.AV42fecha = GXv_date4[0] ;
               resetealiquidacion.this.AV43finPeriodo = GXv_date5[0] ;
               GXv_decimal6[0] = AV37LiqLegSueldo ;
               GXv_char1[0] = AV45LegSuelTipo ;
               GXv_int7[0] = (short)(0) ;
               GXv_boolean8[0] = false ;
               new web.getlegajosueldoultimo(remoteHandle, context).execute( A3CliCod, A1EmpCod, 0, A6LegNumero, AV43finPeriodo, GXv_decimal6, GXv_char1, GXv_int7, GXv_boolean8) ;
               resetealiquidacion.this.AV37LiqLegSueldo = GXv_decimal6[0] ;
               resetealiquidacion.this.AV45LegSuelTipo = GXv_char1[0] ;
               A2114LiqLegSueldo = AV37LiqLegSueldo ;
               GXv_char1[0] = AV38LiqLegCatCodigo ;
               GXv_char9[0] = AV39LiqLegConvenio ;
               new web.obtcategorialegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, 0, A6LegNumero, GXv_char1, GXv_char9) ;
               resetealiquidacion.this.AV38LiqLegCatCodigo = GXv_char1[0] ;
               resetealiquidacion.this.AV39LiqLegConvenio = GXv_char9[0] ;
               A2115LiqLegConvenio = AV39LiqLegConvenio ;
               A2113LiqLegCatCodigo = AV38LiqLegCatCodigo ;
               AV29cuentaLegNumero = A6LegNumero ;
               /* Execute user subroutine: 'DELETE LIQUIDACIONCALCULO' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(15);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Execute user subroutine: 'DELETE LIQLEGCONCEPTOCUENTA' */
               S131 ();
               if ( returnInSub )
               {
                  pr_default.close(15);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Execute user subroutine: 'DELETE LIQLEGOBLIGACIONCUENTA' */
               S141 ();
               if ( returnInSub )
               {
                  pr_default.close(15);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV22LegNumero.add((int)(A6LegNumero), 0);
               GXt_char10 = AV40TliqCod ;
               GXv_char9[0] = GXt_char10 ;
               new web.gettipoliq(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, A31LiqNro, GXv_char9) ;
               resetealiquidacion.this.GXt_char10 = GXv_char9[0] ;
               AV40TliqCod = GXt_char10 ;
               if ( GXutil.strcmp(AV40TliqCod, AV44egresoTLiqCod) == 0 )
               {
                  new web.desasignarconsumoslicegr(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, A31LiqNro, A6LegNumero) ;
               }
               /* Using cursor P008418 */
               pr_default.execute(16, new Object[] {Byte.valueOf(A2268LiqLegProcesado), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A2402LiqLegFecHor, A482LegLiqDatosHis, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A757LiqLegImpTotRetGan, A775LiqLegImpPagosACuen, A758LiqLegImpTotBruProm, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A891LiqLegError, A961LiqNombrePDF, A2393LiqLegHtml, A962LiqNombrePDFVertical, A2114LiqLegSueldo, A2115LiqLegConvenio, A2113LiqLegCatCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            }
            pr_default.readNext(15);
         }
         pr_default.close(15);
         if ( AV63GXLvl121 == 0 )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Error, liquidación sin legajos", "")) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV23CliCod, AV59Pgmname, GXutil.trim( GXutil.str( AV21i, 4, 0))+httpContext.getMessage( " llama a update count de ", "")+AV47LiqLegDaemonUUID+httpContext.getMessage( ", legajo ", "")+GXutil.trim( GXutil.str( ((Number) AV48updLegNumero.elementAt(-1+AV21i)).intValue(), 8, 0))) ;
         new web.upddaemoncount(remoteHandle, context).execute( AV23CliCod, AV47LiqLegDaemonUUID) ;
         AV21i = (short)(AV21i+1) ;
      }
      if ( GXutil.strcmp(AV40TliqCod, AV44egresoTLiqCod) == 0 )
      {
         AV21i = (short)(1) ;
         while ( AV21i <= AV22LegNumero.size() )
         {
            new web.inicializarperiodoscclic(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, ((Number) AV22LegNumero.elementAt(-1+AV21i)).intValue(), (short)(0)) ;
            AV21i = (short)(AV21i+1) ;
         }
      }
      /* Using cursor P008419 */
      pr_default.execute(17, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      while ( (pr_default.getStatus(17) != 101) )
      {
         A31LiqNro = P008419_A31LiqNro[0] ;
         A1EmpCod = P008419_A1EmpCod[0] ;
         A3CliCod = P008419_A3CliCod[0] ;
         A268LiqClase = P008419_A268LiqClase[0] ;
         n268LiqClase = P008419_n268LiqClase[0] ;
         A2409LiqModTra = P008419_A2409LiqModTra[0] ;
         A2414LiqFrecPag = P008419_A2414LiqFrecPag[0] ;
         A2426LiqTipoTarifa = P008419_A2426LiqTipoTarifa[0] ;
         A2410LiqPerDes = P008419_A2410LiqPerDes[0] ;
         A2411LiqPerHas = P008419_A2411LiqPerHas[0] ;
         A32TLiqCod = P008419_A32TLiqCod[0] ;
         n32TLiqCod = P008419_n32TLiqCod[0] ;
         A586LiqPerMes = P008419_A586LiqPerMes[0] ;
         A585LiqPerAno = P008419_A585LiqPerAno[0] ;
         /* Execute user subroutine: 'DESVINCULAR NOVEDADES' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(17);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV33ClientId = AV34ServerSocket.getgxTv_SdtSocket_Clientid() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "&ClientId.Trim() ", "")+GXutil.trim( AV33ClientId)) ;
         new web.liquidacionporlotes(remoteHandle, context).execute( AV23CliCod, AV12EmpCod, AV13LiqNro, AV22LegNumero, A268LiqClase, A2409LiqModTra, A2414LiqFrecPag, A2426LiqTipoTarifa, A2410LiqPerDes, A2411LiqPerHas, A32TLiqCod, A586LiqPerMes, A585LiqPerAno, AV33ClientId, true) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(17);
      cleanup();
   }

   public void S111( )
   {
      /* 'DESVINCULAR NOVEDADES' Routine */
      returnInSub = false ;
      /* Optimized UPDATE. */
      /* Using cursor P008420 */
      pr_default.execute(18, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
      /* End optimized UPDATE. */
   }

   public void S121( )
   {
      /* 'DELETE LIQUIDACIONCALCULO' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P008421 */
      pr_default.execute(19, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV29cuentaLegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacionLegajoCalculos");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P008422 */
      pr_default.execute(20, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV29cuentaLegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqDetForOperandos");
      /* End optimized DELETE. */
   }

   public void S131( )
   {
      /* 'DELETE LIQLEGCONCEPTOCUENTA' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P008423 */
      pr_default.execute(21, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV27LiqLegConAnio), Integer.valueOf(AV29cuentaLegNumero), Integer.valueOf(AV13LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P008424 */
      pr_default.execute(22, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV27LiqLegConAnio), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV29cuentaLegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacion_exencion");
      /* End optimized DELETE. */
   }

   public void S141( )
   {
      /* 'DELETE LIQLEGOBLIGACIONCUENTA' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P008425 */
      pr_default.execute(23, new Object[] {Integer.valueOf(AV23CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV29cuentaLegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
      /* End optimized DELETE. */
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "resetealiquidacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25error = "" ;
      scmdbuf = "" ;
      P00842_A31LiqNro = new int[1] ;
      P00842_A1EmpCod = new short[1] ;
      P00842_A3CliCod = new int[1] ;
      P00842_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00842_A32TLiqCod = new String[] {""} ;
      P00842_n32TLiqCod = new boolean[] {false} ;
      P00842_A268LiqClase = new byte[1] ;
      P00842_n268LiqClase = new boolean[] {false} ;
      P00842_A2298LiqCancel = new boolean[] {false} ;
      P00842_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      P00842_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      P00842_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00842_A1142LiqLog = new String[] {""} ;
      P00842_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      P00842_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      P00842_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      P00842_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      P00842_A766LiqError = new String[] {""} ;
      P00842_A278LiqEstado = new byte[1] ;
      P00842_A2292LiqLSDDepEst = new byte[1] ;
      P00842_A2293LiqContrEst = new byte[1] ;
      P00842_A1403LiqAuxEstado = new byte[1] ;
      P00842_A2180LiqPDFEstado = new String[] {""} ;
      P00842_n2180LiqPDFEstado = new boolean[] {false} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A1142LiqLog = "" ;
      A963LiqRutaPDFTodosVertical = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A766LiqError = "" ;
      A2180LiqPDFEstado = "" ;
      AV28LiqPeriodo = GXutil.nullDate() ;
      AV20aplicaA = "" ;
      AV40TliqCod = "" ;
      P00844_A1649LSDSec = new int[1] ;
      P00844_A1EmpCod = new short[1] ;
      P00844_A3CliCod = new int[1] ;
      P00844_A1733LSD1LiqNro = new int[1] ;
      P00845_A3CliCod = new int[1] ;
      P00845_A1EmpCod = new short[1] ;
      P00845_A1649LSDSec = new int[1] ;
      P00845_A1657LSD2Sec = new int[1] ;
      AV59Pgmname = "" ;
      P008413_A2373LiqBatchSeccion = new String[] {""} ;
      P008413_A2372LiqBatchCod = new String[] {""} ;
      P008413_A2371LiqBatchLiqNro = new int[1] ;
      P008413_A1EmpCod = new short[1] ;
      P008413_A3CliCod = new int[1] ;
      A2373LiqBatchSeccion = "" ;
      A2372LiqBatchCod = "" ;
      P008416_A31LiqNro = new int[1] ;
      P008416_A1EmpCod = new short[1] ;
      P008416_A3CliCod = new int[1] ;
      P008416_A6LegNumero = new int[1] ;
      AV48updLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      P008417_A6LegNumero = new int[1] ;
      P008417_A31LiqNro = new int[1] ;
      P008417_A1EmpCod = new short[1] ;
      P008417_A3CliCod = new int[1] ;
      P008417_A2268LiqLegProcesado = new byte[1] ;
      P008417_A2401LiqLegDaemonUUID = new String[] {""} ;
      P008417_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      P008417_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      P008417_A482LegLiqDatosHis = new String[] {""} ;
      P008417_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A499LiqLegCntConc = new short[1] ;
      P008417_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A590LiqRutaPDF = new String[] {""} ;
      P008417_A774LiqRutaPDFVertical = new String[] {""} ;
      P008417_A883LIqLegIteraciones = new short[1] ;
      P008417_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A891LiqLegError = new String[] {""} ;
      P008417_A961LiqNombrePDF = new String[] {""} ;
      P008417_A2393LiqLegHtml = new String[] {""} ;
      P008417_A962LiqNombrePDFVertical = new String[] {""} ;
      P008417_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008417_A2115LiqLegConvenio = new String[] {""} ;
      P008417_A2113LiqLegCatCodigo = new String[] {""} ;
      A2401LiqLegDaemonUUID = "" ;
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      A482LegLiqDatosHis = "" ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A961LiqNombrePDF = "" ;
      A2393LiqLegHtml = "" ;
      A962LiqNombrePDFVertical = "" ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      A2115LiqLegConvenio = "" ;
      A2113LiqLegCatCodigo = "" ;
      AV47LiqLegDaemonUUID = "" ;
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime3 = new java.util.Date[1] ;
      AV42fecha = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      AV43finPeriodo = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV37LiqLegSueldo = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV45LegSuelTipo = "" ;
      GXv_int7 = new short[1] ;
      GXv_boolean8 = new boolean[1] ;
      AV38LiqLegCatCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV39LiqLegConvenio = "" ;
      AV22LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXt_char10 = "" ;
      GXv_char9 = new String[1] ;
      AV44egresoTLiqCod = "" ;
      P008419_A31LiqNro = new int[1] ;
      P008419_A1EmpCod = new short[1] ;
      P008419_A3CliCod = new int[1] ;
      P008419_A268LiqClase = new byte[1] ;
      P008419_n268LiqClase = new boolean[] {false} ;
      P008419_A2409LiqModTra = new String[] {""} ;
      P008419_A2414LiqFrecPag = new byte[1] ;
      P008419_A2426LiqTipoTarifa = new String[] {""} ;
      P008419_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      P008419_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      P008419_A32TLiqCod = new String[] {""} ;
      P008419_n32TLiqCod = new boolean[] {false} ;
      P008419_A586LiqPerMes = new byte[1] ;
      P008419_A585LiqPerAno = new short[1] ;
      A2409LiqModTra = "" ;
      A2426LiqTipoTarifa = "" ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      AV33ClientId = "" ;
      AV34ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.resetealiquidacion__default(),
         new Object[] {
             new Object[] {
            P00842_A31LiqNro, P00842_A1EmpCod, P00842_A3CliCod, P00842_A283LiqPeriodo, P00842_A32TLiqCod, P00842_n32TLiqCod, P00842_A268LiqClase, P00842_n268LiqClase, P00842_A2298LiqCancel, P00842_A496LiqImpNeto,
            P00842_A755LiqImpDescuentos, P00842_A756LiqImpRetenGan, P00842_A497LiqImpBruto, P00842_A719LiqFecImp, P00842_A743LiqPisoGanancias, P00842_A744LiqPisGanSAC, P00842_A745LiqTopeDedInc, P00842_A746LiqPerUltNorm, P00842_A885LiqSegundos, P00842_A1142LiqLog,
            P00842_A963LiqRutaPDFTodosVertical, P00842_A964LiqRutaPDFTodosHorizontal, P00842_A965LiqRutaPDFTodosNombreVertical, P00842_A966LiqRutaPDFTodosNombreHorizonta, P00842_A766LiqError, P00842_A278LiqEstado, P00842_A2292LiqLSDDepEst, P00842_A2293LiqContrEst, P00842_A1403LiqAuxEstado, P00842_A2180LiqPDFEstado,
            P00842_n2180LiqPDFEstado
            }
            , new Object[] {
            }
            , new Object[] {
            P00844_A1649LSDSec, P00844_A1EmpCod, P00844_A3CliCod, P00844_A1733LSD1LiqNro
            }
            , new Object[] {
            P00845_A3CliCod, P00845_A1EmpCod, P00845_A1649LSDSec, P00845_A1657LSD2Sec
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
            P008413_A2373LiqBatchSeccion, P008413_A2372LiqBatchCod, P008413_A2371LiqBatchLiqNro, P008413_A1EmpCod, P008413_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P008416_A31LiqNro, P008416_A1EmpCod, P008416_A3CliCod, P008416_A6LegNumero
            }
            , new Object[] {
            P008417_A6LegNumero, P008417_A31LiqNro, P008417_A1EmpCod, P008417_A3CliCod, P008417_A2268LiqLegProcesado, P008417_A2401LiqLegDaemonUUID, P008417_n2401LiqLegDaemonUUID, P008417_A2402LiqLegFecHor, P008417_A482LegLiqDatosHis, P008417_A498LiqLegImpTotBruto,
            P008417_A759LiqLegImpTotBruSinSAC, P008417_A499LiqLegCntConc, P008417_A577LiqLegImpTotRemu, P008417_A578LiqLegImpTotNoRemu, P008417_A579LiqLegImpTotDescu, P008417_A757LiqLegImpTotRetGan, P008417_A775LiqLegImpPagosACuen, P008417_A758LiqLegImpTotBruProm, P008417_A760LiqLegImpBasico, P008417_A761LiqLegGNSI,
            P008417_A590LiqRutaPDF, P008417_A774LiqRutaPDFVertical, P008417_A883LIqLegIteraciones, P008417_A884LiqLegSegundos, P008417_A891LiqLegError, P008417_A961LiqNombrePDF, P008417_A2393LiqLegHtml, P008417_A962LiqNombrePDFVertical, P008417_A2114LiqLegSueldo, P008417_A2115LiqLegConvenio,
            P008417_A2113LiqLegCatCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P008419_A31LiqNro, P008419_A1EmpCod, P008419_A3CliCod, P008419_A268LiqClase, P008419_n268LiqClase, P008419_A2409LiqModTra, P008419_A2414LiqFrecPag, P008419_A2426LiqTipoTarifa, P008419_A2410LiqPerDes, P008419_A2411LiqPerHas,
            P008419_A32TLiqCod, P008419_n32TLiqCod, P008419_A586LiqPerMes, P008419_A585LiqPerAno
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
      AV59Pgmname = "reseteaLiquidacion" ;
      /* GeneXus formulas. */
      AV59Pgmname = "reseteaLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private byte A268LiqClase ;
   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A2293LiqContrEst ;
   private byte A1403LiqAuxEstado ;
   private byte AV46LiqClase ;
   private byte AV60GXLvl92 ;
   private byte AV63GXLvl121 ;
   private byte A2268LiqLegProcesado ;
   private byte AV41LegClase ;
   private byte A2414LiqFrecPag ;
   private byte A586LiqPerMes ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short AV27LiqLegConAnio ;
   private short AV21i ;
   private short A499LiqLegCntConc ;
   private short A883LIqLegIteraciones ;
   private short GXv_int7[] ;
   private short A585LiqPerAno ;
   private short Gx_err ;
   private int AV23CliCod ;
   private int AV13LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1733LSD1LiqNro ;
   private int A1657LSD2Sec ;
   private int A2371LiqBatchLiqNro ;
   private int A6LegNumero ;
   private int AV29cuentaLegNumero ;
   private int A1254AgeLiqNro ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal A755LiqImpDescuentos ;
   private java.math.BigDecimal A756LiqImpRetenGan ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A743LiqPisoGanancias ;
   private java.math.BigDecimal A744LiqPisGanSAC ;
   private java.math.BigDecimal A745LiqTopeDedInc ;
   private java.math.BigDecimal A885LiqSegundos ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A761LiqLegGNSI ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private java.math.BigDecimal A2114LiqLegSueldo ;
   private java.math.BigDecimal AV37LiqLegSueldo ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String A2180LiqPDFEstado ;
   private String AV20aplicaA ;
   private String AV40TliqCod ;
   private String AV59Pgmname ;
   private String A2373LiqBatchSeccion ;
   private String A2401LiqLegDaemonUUID ;
   private String A961LiqNombrePDF ;
   private String A962LiqNombrePDFVertical ;
   private String A2115LiqLegConvenio ;
   private String A2113LiqLegCatCodigo ;
   private String AV47LiqLegDaemonUUID ;
   private String AV45LegSuelTipo ;
   private String AV38LiqLegCatCodigo ;
   private String GXv_char1[] ;
   private String AV39LiqLegConvenio ;
   private String GXt_char10 ;
   private String GXv_char9[] ;
   private String AV44egresoTLiqCod ;
   private String A2409LiqModTra ;
   private String A2426LiqTipoTarifa ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date A2402LiqLegFecHor ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date GXv_dtime3[] ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date AV28LiqPeriodo ;
   private java.util.Date AV42fecha ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date AV43finPeriodo ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private boolean returnInSub ;
   private boolean n32TLiqCod ;
   private boolean n268LiqClase ;
   private boolean A2298LiqCancel ;
   private boolean n2180LiqPDFEstado ;
   private boolean n2401LiqLegDaemonUUID ;
   private boolean GXv_boolean8[] ;
   private String A1142LiqLog ;
   private String A2393LiqLegHtml ;
   private String AV25error ;
   private String A963LiqRutaPDFTodosVertical ;
   private String A964LiqRutaPDFTodosHorizontal ;
   private String A766LiqError ;
   private String A2372LiqBatchCod ;
   private String A482LegLiqDatosHis ;
   private String A590LiqRutaPDF ;
   private String A774LiqRutaPDFVertical ;
   private String A891LiqLegError ;
   private String AV33ClientId ;
   private GXSimpleCollection<Integer> AV48updLegNumero ;
   private GXSimpleCollection<Integer> AV22LegNumero ;
   private com.genexuscore.genexus.server.SdtSocket AV34ServerSocket ;
   private IDataStoreProvider pr_default ;
   private int[] P00842_A31LiqNro ;
   private short[] P00842_A1EmpCod ;
   private int[] P00842_A3CliCod ;
   private java.util.Date[] P00842_A283LiqPeriodo ;
   private String[] P00842_A32TLiqCod ;
   private boolean[] P00842_n32TLiqCod ;
   private byte[] P00842_A268LiqClase ;
   private boolean[] P00842_n268LiqClase ;
   private boolean[] P00842_A2298LiqCancel ;
   private java.math.BigDecimal[] P00842_A496LiqImpNeto ;
   private java.math.BigDecimal[] P00842_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] P00842_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] P00842_A497LiqImpBruto ;
   private java.util.Date[] P00842_A719LiqFecImp ;
   private java.math.BigDecimal[] P00842_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] P00842_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] P00842_A745LiqTopeDedInc ;
   private java.util.Date[] P00842_A746LiqPerUltNorm ;
   private java.math.BigDecimal[] P00842_A885LiqSegundos ;
   private String[] P00842_A1142LiqLog ;
   private String[] P00842_A963LiqRutaPDFTodosVertical ;
   private String[] P00842_A964LiqRutaPDFTodosHorizontal ;
   private String[] P00842_A965LiqRutaPDFTodosNombreVertical ;
   private String[] P00842_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] P00842_A766LiqError ;
   private byte[] P00842_A278LiqEstado ;
   private byte[] P00842_A2292LiqLSDDepEst ;
   private byte[] P00842_A2293LiqContrEst ;
   private byte[] P00842_A1403LiqAuxEstado ;
   private String[] P00842_A2180LiqPDFEstado ;
   private boolean[] P00842_n2180LiqPDFEstado ;
   private int[] P00844_A1649LSDSec ;
   private short[] P00844_A1EmpCod ;
   private int[] P00844_A3CliCod ;
   private int[] P00844_A1733LSD1LiqNro ;
   private int[] P00845_A3CliCod ;
   private short[] P00845_A1EmpCod ;
   private int[] P00845_A1649LSDSec ;
   private int[] P00845_A1657LSD2Sec ;
   private String[] P008413_A2373LiqBatchSeccion ;
   private String[] P008413_A2372LiqBatchCod ;
   private int[] P008413_A2371LiqBatchLiqNro ;
   private short[] P008413_A1EmpCod ;
   private int[] P008413_A3CliCod ;
   private int[] P008416_A31LiqNro ;
   private short[] P008416_A1EmpCod ;
   private int[] P008416_A3CliCod ;
   private int[] P008416_A6LegNumero ;
   private int[] P008417_A6LegNumero ;
   private int[] P008417_A31LiqNro ;
   private short[] P008417_A1EmpCod ;
   private int[] P008417_A3CliCod ;
   private byte[] P008417_A2268LiqLegProcesado ;
   private String[] P008417_A2401LiqLegDaemonUUID ;
   private boolean[] P008417_n2401LiqLegDaemonUUID ;
   private java.util.Date[] P008417_A2402LiqLegFecHor ;
   private String[] P008417_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] P008417_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P008417_A759LiqLegImpTotBruSinSAC ;
   private short[] P008417_A499LiqLegCntConc ;
   private java.math.BigDecimal[] P008417_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] P008417_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] P008417_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P008417_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P008417_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] P008417_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P008417_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] P008417_A761LiqLegGNSI ;
   private String[] P008417_A590LiqRutaPDF ;
   private String[] P008417_A774LiqRutaPDFVertical ;
   private short[] P008417_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] P008417_A884LiqLegSegundos ;
   private String[] P008417_A891LiqLegError ;
   private String[] P008417_A961LiqNombrePDF ;
   private String[] P008417_A2393LiqLegHtml ;
   private String[] P008417_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] P008417_A2114LiqLegSueldo ;
   private String[] P008417_A2115LiqLegConvenio ;
   private String[] P008417_A2113LiqLegCatCodigo ;
   private int[] P008419_A31LiqNro ;
   private short[] P008419_A1EmpCod ;
   private int[] P008419_A3CliCod ;
   private byte[] P008419_A268LiqClase ;
   private boolean[] P008419_n268LiqClase ;
   private String[] P008419_A2409LiqModTra ;
   private byte[] P008419_A2414LiqFrecPag ;
   private String[] P008419_A2426LiqTipoTarifa ;
   private java.util.Date[] P008419_A2410LiqPerDes ;
   private java.util.Date[] P008419_A2411LiqPerHas ;
   private String[] P008419_A32TLiqCod ;
   private boolean[] P008419_n32TLiqCod ;
   private byte[] P008419_A586LiqPerMes ;
   private short[] P008419_A585LiqPerAno ;
}

final  class resetealiquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00842", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo, TLiqCod, LiqClase, LiqCancel, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqSegundos, LiqLog, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqError, LiqEstado, LiqLSDDepEst, LiqContrEst, LiqAuxEstado, LiqPDFEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00843", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqCancel=?, LiqImpNeto=?, LiqImpDescuentos=?, LiqImpRetenGan=?, LiqImpBruto=?, LiqFecImp=?, LiqPisoGanancias=?, LiqPisGanSAC=?, LiqTopeDedInc=?, LiqPerUltNorm=?, LiqSegundos=?, LiqLog=?, LiqRutaPDFTodosVertical=?, LiqRutaPDFTodosHorizontal=?, LiqRutaPDFTodosNombreVertical=?, LiqRutaPDFTodosNombreHorizonta=?, LiqError=?, LiqEstado=?, LiqLSDDepEst=?, LiqContrEst=?, LiqAuxEstado=?, LiqPDFEstado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00844", "SELECT LSDSec, EmpCod, CliCod, LSD1LiqNro FROM LSD_reg1 WHERE CliCod = ? and EmpCod = ? and LSD1LiqNro = ? ORDER BY CliCod, EmpCod, LSD1LiqNro  FOR UPDATE OF LSD_reg1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00845", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? ORDER BY CliCod, EmpCod, LSDSec  FOR UPDATE OF LSD_reg2",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00846", "DELETE FROM LSD_reg3  WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00847", "DELETE FROM LSD_reg4  WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00848", "SAVEPOINT gxupdate;DELETE FROM LSD_reg2  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00849", "DELETE FROM LSD_reg5  WHERE CliCod = ? and EmpCod = ? and LSDSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008410", "SAVEPOINT gxupdate;DELETE FROM LSD_reg1  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008411", "DELETE FROM LiquidacionDetalle  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008412", "DELETE FROM LiquidacionLegajoLinkPdf  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P008413", "SELECT LiqBatchSeccion, LiqBatchCod, LiqBatchLiqNro, EmpCod, CliCod FROM LiquidacionLotes3 WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? ORDER BY CliCod, EmpCod, LiqBatchLiqNro  FOR UPDATE OF LiquidacionLotes3",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P008414", "DELETE FROM LiquidacionLotes3Leg  WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchCod = ( ?) and LiqBatchSeccion = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008415", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLotes3  WHERE CliCod = ? AND EmpCod = ? AND LiqBatchLiqNro = ? AND LiqBatchCod = ? AND LiqBatchSeccion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P008416", "SELECT LiqNro, EmpCod, CliCod, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008417", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegProcesado, LiqLegDaemonUUID, LiqLegFecHor, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegError, LiqNombrePDF, LiqLegHtml, LiqNombrePDFVertical, LiqLegSueldo, LiqLegConvenio, LiqLegCatCodigo FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P008418", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegProcesado=?, LiqLegDaemonUUID=?, LiqLegFecHor=?, LegLiqDatosHis=?, LiqLegImpTotBruto=?, LiqLegImpTotBruSinSAC=?, LiqLegCntConc=?, LiqLegImpTotRemu=?, LiqLegImpTotNoRemu=?, LiqLegImpTotDescu=?, LiqLegImpTotRetGan=?, LiqLegImpPagosACuen=?, LiqLegImpTotBruProm=?, LiqLegImpBasico=?, LiqLegGNSI=?, LiqRutaPDF=?, LiqRutaPDFVertical=?, LIqLegIteraciones=?, LiqLegSegundos=?, LiqLegError=?, LiqNombrePDF=?, LiqLegHtml=?, LiqNombrePDFVertical=?, LiqLegSueldo=?, LiqLegConvenio=?, LiqLegCatCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P008419", "SELECT LiqNro, EmpCod, CliCod, LiqClase, LiqModTra, LiqFrecPag, LiqTipoTarifa, LiqPerDes, LiqPerHas, TLiqCod, LiqPerMes, LiqPerAno FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P008420", "UPDATE AgendaNovedades SET AgeLiqNro=NULL  WHERE (CliCod = ? and EmpCod = ?) AND (AgeLiqNro = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008421", "DELETE FROM liquidacionLegajoCalculos  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008422", "DELETE FROM LiqDetForOperandos  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008423", "DELETE FROM LiqLegConceptoCuenta  WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ?) AND (LiqAltaNro = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008424", "DELETE FROM liquidacion_exencion  WHERE CliCod = ? and EmpCod = ? and LiqExAnio = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P008425", "DELETE FROM LiqLegObligacionCuenta  WHERE CliCod = ? and EmpCod = ? and LiqOblAltaNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(11,2);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(12);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(15,2);
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(16);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(17,2);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(18);
               ((String[]) buf[20])[0] = rslt.getVarchar(19);
               ((String[]) buf[21])[0] = rslt.getVarchar(20);
               ((String[]) buf[22])[0] = rslt.getString(21, 200);
               ((String[]) buf[23])[0] = rslt.getString(22, 200);
               ((String[]) buf[24])[0] = rslt.getVarchar(23);
               ((byte[]) buf[25])[0] = rslt.getByte(24);
               ((byte[]) buf[26])[0] = rslt.getByte(25);
               ((byte[]) buf[27])[0] = rslt.getByte(26);
               ((byte[]) buf[28])[0] = rslt.getByte(27);
               ((String[]) buf[29])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 36);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((String[]) buf[21])[0] = rslt.getVarchar(21);
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(23,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((String[]) buf[25])[0] = rslt.getString(25, 200);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(26);
               ((String[]) buf[27])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(28,2);
               ((String[]) buf[29])[0] = rslt.getString(29, 20);
               ((String[]) buf[30])[0] = rslt.getString(30, 40);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
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
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setDateTime(6, (java.util.Date)parms[5], false);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setString(15, (String)parms[14], 200);
               stmt.setString(16, (String)parms[15], 200);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setByte(19, ((Number) parms[18]).byteValue());
               stmt.setByte(20, ((Number) parms[19]).byteValue());
               stmt.setByte(21, ((Number) parms[20]).byteValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(22, (String)parms[22], 20);
               }
               stmt.setInt(23, ((Number) parms[23]).intValue());
               stmt.setShort(24, ((Number) parms[24]).shortValue());
               stmt.setInt(25, ((Number) parms[25]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
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
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 36);
               }
               stmt.setDateTime(3, (java.util.Date)parms[3], false);
               stmt.setVarchar(4, (String)parms[4], 4000, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setVarchar(16, (String)parms[16], 400, false);
               stmt.setVarchar(17, (String)parms[17], 400, false);
               stmt.setShort(18, ((Number) parms[18]).shortValue());
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 6);
               stmt.setVarchar(20, (String)parms[20], 400, false);
               stmt.setString(21, (String)parms[21], 200);
               stmt.setNLongVarchar(22, (String)parms[22], false);
               stmt.setString(23, (String)parms[23], 200);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[24], 2);
               stmt.setString(25, (String)parms[25], 20);
               stmt.setString(26, (String)parms[26], 40);
               stmt.setInt(27, ((Number) parms[27]).intValue());
               stmt.setShort(28, ((Number) parms[28]).shortValue());
               stmt.setInt(29, ((Number) parms[29]).intValue());
               stmt.setInt(30, ((Number) parms[30]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

