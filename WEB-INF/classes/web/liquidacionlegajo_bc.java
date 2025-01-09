package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionlegajo_bc extends GXWebPanel implements IGxSilentTrn
{
   public liquidacionlegajo_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionlegajo_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionlegajo_bc.class ));
   }

   public liquidacionlegajo_bc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0V28( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0V28( ) ;
      standaloneModal( ) ;
      addRow0V28( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z31LiqNro = A31LiqNro ;
            Z6LegNumero = A6LegNumero ;
            SetMode( "UPD") ;
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

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0V0( )
   {
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0V28( ) ;
         }
         else
         {
            checkExtendedTable0V28( ) ;
            if ( AnyError == 0 )
            {
               zm0V28( 6) ;
               zm0V28( 7) ;
               zm0V28( 8) ;
               zm0V28( 9) ;
            }
            closeExtendedTableCursors0V28( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0V28( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z281LiqLegImpTotal = A281LiqLegImpTotal ;
         Z282LiqLegReciboNro = A282LiqLegReciboNro ;
         Z482LegLiqDatosHis = A482LegLiqDatosHis ;
         Z498LiqLegImpTotBruto = A498LiqLegImpTotBruto ;
         Z759LiqLegImpTotBruSinSAC = A759LiqLegImpTotBruSinSAC ;
         Z499LiqLegCntConc = A499LiqLegCntConc ;
         Z577LiqLegImpTotRemu = A577LiqLegImpTotRemu ;
         Z578LiqLegImpTotNoRemu = A578LiqLegImpTotNoRemu ;
         Z579LiqLegImpTotDescu = A579LiqLegImpTotDescu ;
         Z1157LiqLegImpContr = A1157LiqLegImpContr ;
         Z1158LiqLegImpCosto = A1158LiqLegImpCosto ;
         Z1131LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu ;
         Z1143LiqLegImpDescuNeg = A1143LiqLegImpDescuNeg ;
         Z757LiqLegImpTotRetGan = A757LiqLegImpTotRetGan ;
         Z775LiqLegImpPagosACuen = A775LiqLegImpPagosACuen ;
         Z758LiqLegImpTotBruProm = A758LiqLegImpTotBruProm ;
         Z760LiqLegImpBasico = A760LiqLegImpBasico ;
         Z761LiqLegGNSI = A761LiqLegGNSI ;
         Z590LiqRutaPDF = A590LiqRutaPDF ;
         Z774LiqRutaPDFVertical = A774LiqRutaPDFVertical ;
         Z883LIqLegIteraciones = A883LIqLegIteraciones ;
         Z884LiqLegSegundos = A884LiqLegSegundos ;
         Z1495LiqLegSegIns = A1495LiqLegSegIns ;
         Z1496LieqLegSegUpd = A1496LieqLegSegUpd ;
         Z891LiqLegError = A891LiqLegError ;
         Z961LiqNombrePDF = A961LiqNombrePDF ;
         Z962LiqNombrePDFVertical = A962LiqNombrePDFVertical ;
         Z1546LiqLegHorasSem = A1546LiqLegHorasSem ;
         Z1780LiqLegAuxEstado = A1780LiqLegAuxEstado ;
         Z1781LiqLegErrorAux = A1781LiqLegErrorAux ;
         Z1815LiqLegFecEgr = A1815LiqLegFecEgr ;
         Z1816LiqLegFecIng = A1816LiqLegFecIng ;
         Z2113LiqLegCatCodigo = A2113LiqLegCatCodigo ;
         Z2115LiqLegConvenio = A2115LiqLegConvenio ;
         Z2114LiqLegSueldo = A2114LiqLegSueldo ;
         Z2179LiqLegPDFEstado = A2179LiqLegPDFEstado ;
         Z2268LiqLegProcesado = A2268LiqLegProcesado ;
         Z2360LiqLegNivLiq = A2360LiqLegNivLiq ;
         Z2400LiqLegLSD = A2400LiqLegLSD ;
         Z2401LiqLegDaemonUUID = A2401LiqLegDaemonUUID ;
         Z2402LiqLegFecHor = A2402LiqLegFecHor ;
         Z34LiqSecCodigo = A34LiqSecCodigo ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z93LegId = A93LegId ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z32TLiqCod = A32TLiqCod ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z284LiqSecDescrip = A284LiqSecDescrip ;
      }
      if ( GX_JID == -5 )
      {
         Z281LiqLegImpTotal = A281LiqLegImpTotal ;
         Z282LiqLegReciboNro = A282LiqLegReciboNro ;
         Z482LegLiqDatosHis = A482LegLiqDatosHis ;
         Z498LiqLegImpTotBruto = A498LiqLegImpTotBruto ;
         Z759LiqLegImpTotBruSinSAC = A759LiqLegImpTotBruSinSAC ;
         Z499LiqLegCntConc = A499LiqLegCntConc ;
         Z577LiqLegImpTotRemu = A577LiqLegImpTotRemu ;
         Z578LiqLegImpTotNoRemu = A578LiqLegImpTotNoRemu ;
         Z579LiqLegImpTotDescu = A579LiqLegImpTotDescu ;
         Z1157LiqLegImpContr = A1157LiqLegImpContr ;
         Z1158LiqLegImpCosto = A1158LiqLegImpCosto ;
         Z1131LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu ;
         Z1143LiqLegImpDescuNeg = A1143LiqLegImpDescuNeg ;
         Z757LiqLegImpTotRetGan = A757LiqLegImpTotRetGan ;
         Z775LiqLegImpPagosACuen = A775LiqLegImpPagosACuen ;
         Z758LiqLegImpTotBruProm = A758LiqLegImpTotBruProm ;
         Z760LiqLegImpBasico = A760LiqLegImpBasico ;
         Z761LiqLegGNSI = A761LiqLegGNSI ;
         Z590LiqRutaPDF = A590LiqRutaPDF ;
         Z774LiqRutaPDFVertical = A774LiqRutaPDFVertical ;
         Z883LIqLegIteraciones = A883LIqLegIteraciones ;
         Z884LiqLegSegundos = A884LiqLegSegundos ;
         Z1495LiqLegSegIns = A1495LiqLegSegIns ;
         Z1496LieqLegSegUpd = A1496LieqLegSegUpd ;
         Z891LiqLegError = A891LiqLegError ;
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z961LiqNombrePDF = A961LiqNombrePDF ;
         Z962LiqNombrePDFVertical = A962LiqNombrePDFVertical ;
         Z32TLiqCod = A32TLiqCod ;
         Z1546LiqLegHorasSem = A1546LiqLegHorasSem ;
         Z1780LiqLegAuxEstado = A1780LiqLegAuxEstado ;
         Z1781LiqLegErrorAux = A1781LiqLegErrorAux ;
         Z1815LiqLegFecEgr = A1815LiqLegFecEgr ;
         Z1816LiqLegFecIng = A1816LiqLegFecIng ;
         Z2113LiqLegCatCodigo = A2113LiqLegCatCodigo ;
         Z2115LiqLegConvenio = A2115LiqLegConvenio ;
         Z2114LiqLegSueldo = A2114LiqLegSueldo ;
         Z2179LiqLegPDFEstado = A2179LiqLegPDFEstado ;
         Z2268LiqLegProcesado = A2268LiqLegProcesado ;
         Z2360LiqLegNivLiq = A2360LiqLegNivLiq ;
         Z2393LiqLegHtml = A2393LiqLegHtml ;
         Z2400LiqLegLSD = A2400LiqLegLSD ;
         Z2401LiqLegDaemonUUID = A2401LiqLegDaemonUUID ;
         Z2402LiqLegFecHor = A2402LiqLegFecHor ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z31LiqNro = A31LiqNro ;
         Z34LiqSecCodigo = A34LiqSecCodigo ;
         Z2EmpNom = A2EmpNom ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z93LegId = A93LegId ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z284LiqSecDescrip = A284LiqSecDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( false )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "asdf", ""), 0, "");
      }
   }

   public void standaloneModal( )
   {
   }

   public void load0V28( )
   {
      /* Using cursor BC000V8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A250LegIdNomApe = BC000V8_A250LegIdNomApe[0] ;
         A2EmpNom = BC000V8_A2EmpNom[0] ;
         A281LiqLegImpTotal = BC000V8_A281LiqLegImpTotal[0] ;
         A284LiqSecDescrip = BC000V8_A284LiqSecDescrip[0] ;
         A282LiqLegReciboNro = BC000V8_A282LiqLegReciboNro[0] ;
         A93LegId = BC000V8_A93LegId[0] ;
         n93LegId = BC000V8_n93LegId[0] ;
         A482LegLiqDatosHis = BC000V8_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = BC000V8_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = BC000V8_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = BC000V8_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = BC000V8_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = BC000V8_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = BC000V8_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = BC000V8_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = BC000V8_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = BC000V8_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = BC000V8_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = BC000V8_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = BC000V8_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = BC000V8_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = BC000V8_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = BC000V8_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = BC000V8_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = BC000V8_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = BC000V8_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = BC000V8_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = BC000V8_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = BC000V8_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = BC000V8_A891LiqLegError[0] ;
         A283LiqPeriodo = BC000V8_A283LiqPeriodo[0] ;
         A961LiqNombrePDF = BC000V8_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = BC000V8_A962LiqNombrePDFVertical[0] ;
         A32TLiqCod = BC000V8_A32TLiqCod[0] ;
         n32TLiqCod = BC000V8_n32TLiqCod[0] ;
         A1546LiqLegHorasSem = BC000V8_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = BC000V8_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = BC000V8_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = BC000V8_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = BC000V8_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = BC000V8_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = BC000V8_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = BC000V8_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = BC000V8_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = BC000V8_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = BC000V8_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = BC000V8_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = BC000V8_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = BC000V8_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = BC000V8_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = BC000V8_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = BC000V8_A2402LiqLegFecHor[0] ;
         A251LegNombre = BC000V8_A251LegNombre[0] ;
         A230LegApellido = BC000V8_A230LegApellido[0] ;
         A34LiqSecCodigo = BC000V8_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = BC000V8_n34LiqSecCodigo[0] ;
         zm0V28( -5) ;
      }
      pr_default.close(6);
      onLoadActions0V28( ) ;
   }

   public void onLoadActions0V28( )
   {
      /* Using cursor BC000V9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      A283LiqPeriodo = BC000V9_A283LiqPeriodo[0] ;
      A32TLiqCod = BC000V9_A32TLiqCod[0] ;
      n32TLiqCod = BC000V9_n32TLiqCod[0] ;
      pr_default.close(7);
   }

   public void checkExtendedTable0V28( )
   {
      nIsDirty_28 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000V10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A34LiqSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQSECCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A284LiqSecDescrip = BC000V10_A284LiqSecDescrip[0] ;
      pr_default.close(8);
      /* Using cursor BC000V11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      A2EmpNom = BC000V11_A2EmpNom[0] ;
      pr_default.close(9);
      /* Using cursor BC000V12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
         AnyError = (short)(1) ;
      }
      A283LiqPeriodo = BC000V12_A283LiqPeriodo[0] ;
      A32TLiqCod = BC000V12_A32TLiqCod[0] ;
      n32TLiqCod = BC000V12_n32TLiqCod[0] ;
      pr_default.close(10);
      /* Using cursor BC000V13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      A250LegIdNomApe = BC000V13_A250LegIdNomApe[0] ;
      A93LegId = BC000V13_A93LegId[0] ;
      n93LegId = BC000V13_n93LegId[0] ;
      A251LegNombre = BC000V13_A251LegNombre[0] ;
      A251LegNombre = BC000V13_A251LegNombre[0] ;
      A230LegApellido = BC000V13_A230LegApellido[0] ;
      A230LegApellido = BC000V13_A230LegApellido[0] ;
      pr_default.close(11);
      if ( ! ( ( A1780LiqLegAuxEstado == 0 ) || ( A1780LiqLegAuxEstado == 1 ) || ( A1780LiqLegAuxEstado == 2 ) || ( A1780LiqLegAuxEstado == 3 ) || ( A1780LiqLegAuxEstado == 4 ) || ( A1780LiqLegAuxEstado == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado conceptos auxiliares", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2179LiqLegPDFEstado, "Completo") == 0 ) || ( GXutil.strcmp(A2179LiqLegPDFEstado, "Enviado") == 0 ) || ( GXutil.strcmp(A2179LiqLegPDFEstado, "Pendiente") == 0 ) || ( GXutil.strcmp(A2179LiqLegPDFEstado, "Error") == 0 ) || ( GXutil.strcmp(A2179LiqLegPDFEstado, "Manual") == 0 ) || ( GXutil.strcmp(A2179LiqLegPDFEstado, "EnEspera") == 0 ) || (GXutil.strcmp("", A2179LiqLegPDFEstado)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado del PDF", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2360LiqLegNivLiq == 1 ) || ( A2360LiqLegNivLiq == 2 ) || ( A2360LiqLegNivLiq == 3 ) || ( A2360LiqLegNivLiq == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Liq Leg Niv Liq", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0V28( )
   {
      pr_default.close(8);
      pr_default.close(9);
      pr_default.close(10);
      pr_default.close(11);
   }

   public void enableDisable( )
   {
   }

   public void getKey0V28( )
   {
      /* Using cursor BC000V14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound28 = (short)(1) ;
      }
      else
      {
         RcdFound28 = (short)(0) ;
      }
      pr_default.close(12);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000V15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         zm0V28( 5) ;
         RcdFound28 = (short)(1) ;
         A281LiqLegImpTotal = BC000V15_A281LiqLegImpTotal[0] ;
         A282LiqLegReciboNro = BC000V15_A282LiqLegReciboNro[0] ;
         A482LegLiqDatosHis = BC000V15_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = BC000V15_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = BC000V15_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = BC000V15_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = BC000V15_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = BC000V15_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = BC000V15_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = BC000V15_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = BC000V15_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = BC000V15_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = BC000V15_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = BC000V15_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = BC000V15_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = BC000V15_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = BC000V15_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = BC000V15_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = BC000V15_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = BC000V15_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = BC000V15_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = BC000V15_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = BC000V15_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = BC000V15_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = BC000V15_A891LiqLegError[0] ;
         A961LiqNombrePDF = BC000V15_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = BC000V15_A962LiqNombrePDFVertical[0] ;
         A1546LiqLegHorasSem = BC000V15_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = BC000V15_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = BC000V15_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = BC000V15_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = BC000V15_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = BC000V15_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = BC000V15_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = BC000V15_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = BC000V15_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = BC000V15_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = BC000V15_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = BC000V15_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = BC000V15_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = BC000V15_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = BC000V15_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = BC000V15_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = BC000V15_A2402LiqLegFecHor[0] ;
         A3CliCod = BC000V15_A3CliCod[0] ;
         A1EmpCod = BC000V15_A1EmpCod[0] ;
         A6LegNumero = BC000V15_A6LegNumero[0] ;
         A31LiqNro = BC000V15_A31LiqNro[0] ;
         A34LiqSecCodigo = BC000V15_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = BC000V15_n34LiqSecCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0V28( ) ;
         if ( AnyError == 1 )
         {
            RcdFound28 = (short)(0) ;
            initializeNonKey0V28( ) ;
         }
         Gx_mode = sMode28 ;
      }
      else
      {
         RcdFound28 = (short)(0) ;
         initializeNonKey0V28( ) ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode28 ;
      }
      pr_default.close(13);
   }

   public void getEqualNoModal( )
   {
      getKey0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0V0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0V28( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000V16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(14) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionLegajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(14) == 101) || ( DecimalUtil.compareTo(Z281LiqLegImpTotal, BC000V16_A281LiqLegImpTotal[0]) != 0 ) || ( Z282LiqLegReciboNro != BC000V16_A282LiqLegReciboNro[0] ) || ( GXutil.strcmp(Z482LegLiqDatosHis, BC000V16_A482LegLiqDatosHis[0]) != 0 ) || ( DecimalUtil.compareTo(Z498LiqLegImpTotBruto, BC000V16_A498LiqLegImpTotBruto[0]) != 0 ) || ( DecimalUtil.compareTo(Z759LiqLegImpTotBruSinSAC, BC000V16_A759LiqLegImpTotBruSinSAC[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z499LiqLegCntConc != BC000V16_A499LiqLegCntConc[0] ) || ( DecimalUtil.compareTo(Z577LiqLegImpTotRemu, BC000V16_A577LiqLegImpTotRemu[0]) != 0 ) || ( DecimalUtil.compareTo(Z578LiqLegImpTotNoRemu, BC000V16_A578LiqLegImpTotNoRemu[0]) != 0 ) || ( DecimalUtil.compareTo(Z579LiqLegImpTotDescu, BC000V16_A579LiqLegImpTotDescu[0]) != 0 ) || ( DecimalUtil.compareTo(Z1157LiqLegImpContr, BC000V16_A1157LiqLegImpContr[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1158LiqLegImpCosto, BC000V16_A1158LiqLegImpCosto[0]) != 0 ) || ( DecimalUtil.compareTo(Z1131LiqLegImpOtrDescu, BC000V16_A1131LiqLegImpOtrDescu[0]) != 0 ) || ( DecimalUtil.compareTo(Z1143LiqLegImpDescuNeg, BC000V16_A1143LiqLegImpDescuNeg[0]) != 0 ) || ( DecimalUtil.compareTo(Z757LiqLegImpTotRetGan, BC000V16_A757LiqLegImpTotRetGan[0]) != 0 ) || ( DecimalUtil.compareTo(Z775LiqLegImpPagosACuen, BC000V16_A775LiqLegImpPagosACuen[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z758LiqLegImpTotBruProm, BC000V16_A758LiqLegImpTotBruProm[0]) != 0 ) || ( DecimalUtil.compareTo(Z760LiqLegImpBasico, BC000V16_A760LiqLegImpBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z761LiqLegGNSI, BC000V16_A761LiqLegGNSI[0]) != 0 ) || ( GXutil.strcmp(Z590LiqRutaPDF, BC000V16_A590LiqRutaPDF[0]) != 0 ) || ( GXutil.strcmp(Z774LiqRutaPDFVertical, BC000V16_A774LiqRutaPDFVertical[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z883LIqLegIteraciones != BC000V16_A883LIqLegIteraciones[0] ) || ( DecimalUtil.compareTo(Z884LiqLegSegundos, BC000V16_A884LiqLegSegundos[0]) != 0 ) || ( DecimalUtil.compareTo(Z1495LiqLegSegIns, BC000V16_A1495LiqLegSegIns[0]) != 0 ) || ( DecimalUtil.compareTo(Z1496LieqLegSegUpd, BC000V16_A1496LieqLegSegUpd[0]) != 0 ) || ( GXutil.strcmp(Z891LiqLegError, BC000V16_A891LiqLegError[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z961LiqNombrePDF, BC000V16_A961LiqNombrePDF[0]) != 0 ) || ( GXutil.strcmp(Z962LiqNombrePDFVertical, BC000V16_A962LiqNombrePDFVertical[0]) != 0 ) || ( DecimalUtil.compareTo(Z1546LiqLegHorasSem, BC000V16_A1546LiqLegHorasSem[0]) != 0 ) || ( Z1780LiqLegAuxEstado != BC000V16_A1780LiqLegAuxEstado[0] ) || ( GXutil.strcmp(Z1781LiqLegErrorAux, BC000V16_A1781LiqLegErrorAux[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z1815LiqLegFecEgr), GXutil.resetTime(BC000V16_A1815LiqLegFecEgr[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z1816LiqLegFecIng), GXutil.resetTime(BC000V16_A1816LiqLegFecIng[0])) ) || ( GXutil.strcmp(Z2113LiqLegCatCodigo, BC000V16_A2113LiqLegCatCodigo[0]) != 0 ) || ( GXutil.strcmp(Z2115LiqLegConvenio, BC000V16_A2115LiqLegConvenio[0]) != 0 ) || ( DecimalUtil.compareTo(Z2114LiqLegSueldo, BC000V16_A2114LiqLegSueldo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2179LiqLegPDFEstado, BC000V16_A2179LiqLegPDFEstado[0]) != 0 ) || ( Z2268LiqLegProcesado != BC000V16_A2268LiqLegProcesado[0] ) || ( Z2360LiqLegNivLiq != BC000V16_A2360LiqLegNivLiq[0] ) || ( Z2400LiqLegLSD != BC000V16_A2400LiqLegLSD[0] ) || ( GXutil.strcmp(Z2401LiqLegDaemonUUID, BC000V16_A2401LiqLegDaemonUUID[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z2402LiqLegFecHor, BC000V16_A2402LiqLegFecHor[0]) ) || ( GXutil.strcmp(Z34LiqSecCodigo, BC000V16_A34LiqSecCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiquidacionLegajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0V28( )
   {
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0V28( 0) ;
         checkOptimisticConcurrency0V28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V28( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0V28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000V17 */
                  pr_default.execute(15, new Object[] {A283LiqPeriodo, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A281LiqLegImpTotal, Integer.valueOf(A282LiqLegReciboNro), A482LegLiqDatosHis, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1157LiqLegImpContr, A1158LiqLegImpCosto, A1131LiqLegImpOtrDescu, A1143LiqLegImpDescuNeg, A757LiqLegImpTotRetGan, A775LiqLegImpPagosACuen, A758LiqLegImpTotBruProm, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A1495LiqLegSegIns, A1496LieqLegSegUpd, A891LiqLegError, A961LiqNombrePDF, A962LiqNombrePDFVertical, A1546LiqLegHorasSem, Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, A1815LiqLegFecEgr, A1816LiqLegFecIng, A2113LiqLegCatCodigo, A2115LiqLegConvenio, A2114LiqLegSueldo, Boolean.valueOf(n2179LiqLegPDFEstado), A2179LiqLegPDFEstado, Byte.valueOf(A2268LiqLegProcesado), Byte.valueOf(A2360LiqLegNivLiq), A2393LiqLegHtml, Byte.valueOf(A2400LiqLegLSD), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A2402LiqLegFecHor, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
                  if ( (pr_default.getStatus(15) == 1) )
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
            load0V28( ) ;
         }
         endLevel0V28( ) ;
      }
      closeExtendedTableCursors0V28( ) ;
   }

   public void update0V28( )
   {
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V28( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0V28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000V18 */
                  pr_default.execute(16, new Object[] {A283LiqPeriodo, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A281LiqLegImpTotal, Integer.valueOf(A282LiqLegReciboNro), A482LegLiqDatosHis, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1157LiqLegImpContr, A1158LiqLegImpCosto, A1131LiqLegImpOtrDescu, A1143LiqLegImpDescuNeg, A757LiqLegImpTotRetGan, A775LiqLegImpPagosACuen, A758LiqLegImpTotBruProm, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A1495LiqLegSegIns, A1496LieqLegSegUpd, A891LiqLegError, A961LiqNombrePDF, A962LiqNombrePDFVertical, A1546LiqLegHorasSem, Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, A1815LiqLegFecEgr, A1816LiqLegFecIng, A2113LiqLegCatCodigo, A2115LiqLegConvenio, A2114LiqLegSueldo, Boolean.valueOf(n2179LiqLegPDFEstado), A2179LiqLegPDFEstado, Byte.valueOf(A2268LiqLegProcesado), Byte.valueOf(A2360LiqLegNivLiq), A2393LiqLegHtml, Byte.valueOf(A2400LiqLegLSD), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A2402LiqLegFecHor, Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
                  if ( (pr_default.getStatus(16) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionLegajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0V28( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
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
         endLevel0V28( ) ;
      }
      closeExtendedTableCursors0V28( ) ;
   }

   public void deferredUpdate0V28( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0V28( ) ;
         afterConfirm0V28( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0V28( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000V19 */
               pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
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
      sMode28 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0V28( ) ;
      Gx_mode = sMode28 ;
   }

   public void onDeleteControls0V28( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000V20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = BC000V20_A2EmpNom[0] ;
         pr_default.close(18);
         /* Using cursor BC000V21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         A283LiqPeriodo = BC000V21_A283LiqPeriodo[0] ;
         A32TLiqCod = BC000V21_A32TLiqCod[0] ;
         n32TLiqCod = BC000V21_n32TLiqCod[0] ;
         pr_default.close(19);
         /* Using cursor BC000V22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = BC000V22_A250LegIdNomApe[0] ;
         A93LegId = BC000V22_A93LegId[0] ;
         n93LegId = BC000V22_n93LegId[0] ;
         A251LegNombre = BC000V22_A251LegNombre[0] ;
         A251LegNombre = BC000V22_A251LegNombre[0] ;
         A230LegApellido = BC000V22_A230LegApellido[0] ;
         A230LegApellido = BC000V22_A230LegApellido[0] ;
         pr_default.close(20);
         /* Using cursor BC000V23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
         A284LiqSecDescrip = BC000V23_A284LiqSecDescrip[0] ;
         pr_default.close(21);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000V24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasconsumos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor BC000V25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasaprobaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor BC000V26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor BC000V27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor BC000V28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacionLegajoCalculos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor BC000V29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Ajuste", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor BC000V30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor BC000V31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor BC000V32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor BC000V33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor BC000V34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor BC000V35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor BC000V36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Test Table", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor BC000V37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor BC000V38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
      }
   }

   public void endLevel0V28( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(14);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0V28( )
   {
      /* Using cursor BC000V39 */
      pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A250LegIdNomApe = BC000V39_A250LegIdNomApe[0] ;
         A2EmpNom = BC000V39_A2EmpNom[0] ;
         A281LiqLegImpTotal = BC000V39_A281LiqLegImpTotal[0] ;
         A284LiqSecDescrip = BC000V39_A284LiqSecDescrip[0] ;
         A282LiqLegReciboNro = BC000V39_A282LiqLegReciboNro[0] ;
         A93LegId = BC000V39_A93LegId[0] ;
         n93LegId = BC000V39_n93LegId[0] ;
         A482LegLiqDatosHis = BC000V39_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = BC000V39_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = BC000V39_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = BC000V39_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = BC000V39_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = BC000V39_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = BC000V39_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = BC000V39_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = BC000V39_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = BC000V39_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = BC000V39_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = BC000V39_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = BC000V39_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = BC000V39_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = BC000V39_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = BC000V39_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = BC000V39_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = BC000V39_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = BC000V39_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = BC000V39_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = BC000V39_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = BC000V39_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = BC000V39_A891LiqLegError[0] ;
         A283LiqPeriodo = BC000V39_A283LiqPeriodo[0] ;
         A961LiqNombrePDF = BC000V39_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = BC000V39_A962LiqNombrePDFVertical[0] ;
         A32TLiqCod = BC000V39_A32TLiqCod[0] ;
         n32TLiqCod = BC000V39_n32TLiqCod[0] ;
         A1546LiqLegHorasSem = BC000V39_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = BC000V39_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = BC000V39_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = BC000V39_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = BC000V39_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = BC000V39_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = BC000V39_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = BC000V39_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = BC000V39_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = BC000V39_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = BC000V39_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = BC000V39_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = BC000V39_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = BC000V39_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = BC000V39_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = BC000V39_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = BC000V39_A2402LiqLegFecHor[0] ;
         A251LegNombre = BC000V39_A251LegNombre[0] ;
         A230LegApellido = BC000V39_A230LegApellido[0] ;
         A3CliCod = BC000V39_A3CliCod[0] ;
         A1EmpCod = BC000V39_A1EmpCod[0] ;
         A6LegNumero = BC000V39_A6LegNumero[0] ;
         A31LiqNro = BC000V39_A31LiqNro[0] ;
         A34LiqSecCodigo = BC000V39_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = BC000V39_n34LiqSecCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0V28( )
   {
      /* Scan next routine */
      pr_default.readNext(37);
      RcdFound28 = (short)(0) ;
      scanKeyLoad0V28( ) ;
   }

   public void scanKeyLoad0V28( )
   {
      sMode28 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A250LegIdNomApe = BC000V39_A250LegIdNomApe[0] ;
         A2EmpNom = BC000V39_A2EmpNom[0] ;
         A281LiqLegImpTotal = BC000V39_A281LiqLegImpTotal[0] ;
         A284LiqSecDescrip = BC000V39_A284LiqSecDescrip[0] ;
         A282LiqLegReciboNro = BC000V39_A282LiqLegReciboNro[0] ;
         A93LegId = BC000V39_A93LegId[0] ;
         n93LegId = BC000V39_n93LegId[0] ;
         A482LegLiqDatosHis = BC000V39_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = BC000V39_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = BC000V39_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = BC000V39_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = BC000V39_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = BC000V39_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = BC000V39_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = BC000V39_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = BC000V39_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = BC000V39_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = BC000V39_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = BC000V39_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = BC000V39_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = BC000V39_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = BC000V39_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = BC000V39_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = BC000V39_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = BC000V39_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = BC000V39_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = BC000V39_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = BC000V39_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = BC000V39_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = BC000V39_A891LiqLegError[0] ;
         A283LiqPeriodo = BC000V39_A283LiqPeriodo[0] ;
         A961LiqNombrePDF = BC000V39_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = BC000V39_A962LiqNombrePDFVertical[0] ;
         A32TLiqCod = BC000V39_A32TLiqCod[0] ;
         n32TLiqCod = BC000V39_n32TLiqCod[0] ;
         A1546LiqLegHorasSem = BC000V39_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = BC000V39_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = BC000V39_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = BC000V39_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = BC000V39_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = BC000V39_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = BC000V39_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = BC000V39_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = BC000V39_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = BC000V39_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = BC000V39_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = BC000V39_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = BC000V39_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = BC000V39_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = BC000V39_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = BC000V39_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = BC000V39_A2402LiqLegFecHor[0] ;
         A251LegNombre = BC000V39_A251LegNombre[0] ;
         A230LegApellido = BC000V39_A230LegApellido[0] ;
         A3CliCod = BC000V39_A3CliCod[0] ;
         A1EmpCod = BC000V39_A1EmpCod[0] ;
         A6LegNumero = BC000V39_A6LegNumero[0] ;
         A31LiqNro = BC000V39_A31LiqNro[0] ;
         A34LiqSecCodigo = BC000V39_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = BC000V39_n34LiqSecCodigo[0] ;
      }
      Gx_mode = sMode28 ;
   }

   public void scanKeyEnd0V28( )
   {
      pr_default.close(37);
   }

   public void afterConfirm0V28( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0V28( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0V28( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0V28( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0V28( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0V28( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0V28( )
   {
   }

   public void send_integrity_lvl_hashes0V28( )
   {
   }

   public void addRow0V28( )
   {
      VarsToRow28( bcLiquidacionLegajo) ;
   }

   public void readRow0V28( )
   {
      RowToVars28( bcLiquidacionLegajo, 1) ;
   }

   public void initializeNonKey0V28( )
   {
      A250LegIdNomApe = "" ;
      A2EmpNom = "" ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A34LiqSecCodigo = "" ;
      n34LiqSecCodigo = false ;
      A284LiqSecDescrip = "" ;
      A282LiqLegReciboNro = 0 ;
      A93LegId = "" ;
      n93LegId = false ;
      A482LegLiqDatosHis = "" ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A499LiqLegCntConc = (short)(0) ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A883LIqLegIteraciones = (short)(0) ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A961LiqNombrePDF = "" ;
      A962LiqNombrePDFVertical = "" ;
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      A1780LiqLegAuxEstado = (byte)(0) ;
      A1781LiqLegErrorAux = "" ;
      A1815LiqLegFecEgr = GXutil.nullDate() ;
      A1816LiqLegFecIng = GXutil.nullDate() ;
      A2113LiqLegCatCodigo = "" ;
      A2115LiqLegConvenio = "" ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      A2179LiqLegPDFEstado = "" ;
      n2179LiqLegPDFEstado = false ;
      A2268LiqLegProcesado = (byte)(0) ;
      A2360LiqLegNivLiq = (byte)(0) ;
      A2393LiqLegHtml = "" ;
      A2400LiqLegLSD = (byte)(0) ;
      A2401LiqLegDaemonUUID = "" ;
      n2401LiqLegDaemonUUID = false ;
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      Z281LiqLegImpTotal = DecimalUtil.ZERO ;
      Z282LiqLegReciboNro = 0 ;
      Z482LegLiqDatosHis = "" ;
      Z498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      Z759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      Z499LiqLegCntConc = (short)(0) ;
      Z577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      Z578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      Z579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      Z1157LiqLegImpContr = DecimalUtil.ZERO ;
      Z1158LiqLegImpCosto = DecimalUtil.ZERO ;
      Z1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      Z1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      Z757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      Z775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      Z758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      Z760LiqLegImpBasico = DecimalUtil.ZERO ;
      Z761LiqLegGNSI = DecimalUtil.ZERO ;
      Z590LiqRutaPDF = "" ;
      Z774LiqRutaPDFVertical = "" ;
      Z883LIqLegIteraciones = (short)(0) ;
      Z884LiqLegSegundos = DecimalUtil.ZERO ;
      Z1495LiqLegSegIns = DecimalUtil.ZERO ;
      Z1496LieqLegSegUpd = DecimalUtil.ZERO ;
      Z891LiqLegError = "" ;
      Z961LiqNombrePDF = "" ;
      Z962LiqNombrePDFVertical = "" ;
      Z1546LiqLegHorasSem = DecimalUtil.ZERO ;
      Z1780LiqLegAuxEstado = (byte)(0) ;
      Z1781LiqLegErrorAux = "" ;
      Z1815LiqLegFecEgr = GXutil.nullDate() ;
      Z1816LiqLegFecIng = GXutil.nullDate() ;
      Z2113LiqLegCatCodigo = "" ;
      Z2115LiqLegConvenio = "" ;
      Z2114LiqLegSueldo = DecimalUtil.ZERO ;
      Z2179LiqLegPDFEstado = "" ;
      Z2268LiqLegProcesado = (byte)(0) ;
      Z2360LiqLegNivLiq = (byte)(0) ;
      Z2400LiqLegLSD = (byte)(0) ;
      Z2401LiqLegDaemonUUID = "" ;
      Z2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      Z34LiqSecCodigo = "" ;
   }

   public void initAll0V28( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A31LiqNro = 0 ;
      A6LegNumero = 0 ;
      initializeNonKey0V28( ) ;
   }

   public void standaloneModalInsert( )
   {
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

   public void VarsToRow28( web.SdtLiquidacionLegajo obj28 )
   {
      obj28.setgxTv_SdtLiquidacionLegajo_Mode( Gx_mode );
      obj28.setgxTv_SdtLiquidacionLegajo_Empnom( A2EmpNom );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal( A281LiqLegImpTotal );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqseccodigo( A34LiqSecCodigo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip( A284LiqSecDescrip );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro( A282LiqLegReciboNro );
      obj28.setgxTv_SdtLiquidacionLegajo_Legid( A93LegId );
      obj28.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis( A482LegLiqDatosHis );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto( A498LiqLegImpTotBruto );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac( A759LiqLegImpTotBruSinSAC );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc( A499LiqLegCntConc );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu( A577LiqLegImpTotRemu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu( A578LiqLegImpTotNoRemu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu( A579LiqLegImpTotDescu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr( A1157LiqLegImpContr );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto( A1158LiqLegImpCosto );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu( A1131LiqLegImpOtrDescu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg( A1143LiqLegImpDescuNeg );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan( A757LiqLegImpTotRetGan );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen( A775LiqLegImpPagosACuen );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom( A758LiqLegImpTotBruProm );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico( A760LiqLegImpBasico );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleggnsi( A761LiqLegGNSI );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqrutapdf( A590LiqRutaPDF );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical( A774LiqRutaPDFVertical );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones( A883LIqLegIteraciones );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos( A884LiqLegSegundos );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsegins( A1495LiqLegSegIns );
      obj28.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd( A1496LieqLegSegUpd );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegerror( A891LiqLegError );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqperiodo( A283LiqPeriodo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf( A961LiqNombrePDF );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical( A962LiqNombrePDFVertical );
      obj28.setgxTv_SdtLiquidacionLegajo_Tliqcod( A32TLiqCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleghorassem( A1546LiqLegHorasSem );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado( A1780LiqLegAuxEstado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux( A1781LiqLegErrorAux );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr( A1815LiqLegFecEgr );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfecing( A1816LiqLegFecIng );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo( A2113LiqLegCatCodigo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio( A2115LiqLegConvenio );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo( A2114LiqLegSueldo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado( A2179LiqLegPDFEstado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado( A2268LiqLegProcesado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq( A2360LiqLegNivLiq );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleghtml( A2393LiqLegHtml );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleglsd( A2400LiqLegLSD );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid( A2401LiqLegDaemonUUID );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfechor( A2402LiqLegFecHor );
      obj28.setgxTv_SdtLiquidacionLegajo_Clicod( A3CliCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Empcod( A1EmpCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnro( A31LiqNro );
      obj28.setgxTv_SdtLiquidacionLegajo_Legnumero( A6LegNumero );
      obj28.setgxTv_SdtLiquidacionLegajo_Clicod_Z( Z3CliCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Empcod_Z( Z1EmpCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Empnom_Z( Z2EmpNom );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnro_Z( Z31LiqNro );
      obj28.setgxTv_SdtLiquidacionLegajo_Legnumero_Z( Z6LegNumero );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z( Z281LiqLegImpTotal );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z( Z34LiqSecCodigo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z( Z284LiqSecDescrip );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z( Z282LiqLegReciboNro );
      obj28.setgxTv_SdtLiquidacionLegajo_Legid_Z( Z93LegId );
      obj28.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z( Z482LegLiqDatosHis );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z( Z498LiqLegImpTotBruto );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z( Z759LiqLegImpTotBruSinSAC );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z( Z499LiqLegCntConc );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z( Z577LiqLegImpTotRemu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z( Z578LiqLegImpTotNoRemu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z( Z579LiqLegImpTotDescu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z( Z1157LiqLegImpContr );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z( Z1158LiqLegImpCosto );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z( Z1131LiqLegImpOtrDescu );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z( Z1143LiqLegImpDescuNeg );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z( Z757LiqLegImpTotRetGan );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z( Z775LiqLegImpPagosACuen );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z( Z758LiqLegImpTotBruProm );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z( Z760LiqLegImpBasico );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z( Z761LiqLegGNSI );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z( Z590LiqRutaPDF );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z( Z774LiqRutaPDFVertical );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z( Z883LIqLegIteraciones );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z( Z884LiqLegSegundos );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z( Z1495LiqLegSegIns );
      obj28.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z( Z1496LieqLegSegUpd );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z( Z891LiqLegError );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z( Z283LiqPeriodo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z( Z961LiqNombrePDF );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z( Z962LiqNombrePDFVertical );
      obj28.setgxTv_SdtLiquidacionLegajo_Tliqcod_Z( Z32TLiqCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z( Z1546LiqLegHorasSem );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z( Z1780LiqLegAuxEstado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z( Z1781LiqLegErrorAux );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z( Z1815LiqLegFecEgr );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z( Z1816LiqLegFecIng );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z( Z2113LiqLegCatCodigo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z( Z2115LiqLegConvenio );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z( Z2114LiqLegSueldo );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z( Z2179LiqLegPDFEstado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z( Z2268LiqLegProcesado );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z( Z2360LiqLegNivLiq );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z( Z2400LiqLegLSD );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z( Z2401LiqLegDaemonUUID );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z( Z2402LiqLegFecHor );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_N( (byte)((byte)((n34LiqSecCodigo)?1:0)) );
      obj28.setgxTv_SdtLiquidacionLegajo_Legid_N( (byte)((byte)((n93LegId)?1:0)) );
      obj28.setgxTv_SdtLiquidacionLegajo_Tliqcod_N( (byte)((byte)((n32TLiqCod)?1:0)) );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N( (byte)((byte)((n2179LiqLegPDFEstado)?1:0)) );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N( (byte)((byte)((n2401LiqLegDaemonUUID)?1:0)) );
      obj28.setgxTv_SdtLiquidacionLegajo_Mode( Gx_mode );
   }

   public void KeyVarsToRow28( web.SdtLiquidacionLegajo obj28 )
   {
      obj28.setgxTv_SdtLiquidacionLegajo_Clicod( A3CliCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Empcod( A1EmpCod );
      obj28.setgxTv_SdtLiquidacionLegajo_Liqnro( A31LiqNro );
      obj28.setgxTv_SdtLiquidacionLegajo_Legnumero( A6LegNumero );
   }

   public void RowToVars28( web.SdtLiquidacionLegajo obj28 ,
                            int forceLoad )
   {
      Gx_mode = obj28.getgxTv_SdtLiquidacionLegajo_Mode() ;
      A2EmpNom = obj28.getgxTv_SdtLiquidacionLegajo_Empnom() ;
      A281LiqLegImpTotal = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotal() ;
      A34LiqSecCodigo = obj28.getgxTv_SdtLiquidacionLegajo_Liqseccodigo() ;
      n34LiqSecCodigo = false ;
      A284LiqSecDescrip = obj28.getgxTv_SdtLiquidacionLegajo_Liqsecdescrip() ;
      A282LiqLegReciboNro = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro() ;
      A93LegId = obj28.getgxTv_SdtLiquidacionLegajo_Legid() ;
      n93LegId = false ;
      A482LegLiqDatosHis = obj28.getgxTv_SdtLiquidacionLegajo_Legliqdatoshis() ;
      A498LiqLegImpTotBruto = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto() ;
      A759LiqLegImpTotBruSinSAC = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac() ;
      A499LiqLegCntConc = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegcntconc() ;
      A577LiqLegImpTotRemu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu() ;
      A578LiqLegImpTotNoRemu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu() ;
      A579LiqLegImpTotDescu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu() ;
      A1157LiqLegImpContr = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr() ;
      A1158LiqLegImpCosto = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto() ;
      A1131LiqLegImpOtrDescu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu() ;
      A1143LiqLegImpDescuNeg = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg() ;
      A757LiqLegImpTotRetGan = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan() ;
      A775LiqLegImpPagosACuen = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen() ;
      A758LiqLegImpTotBruProm = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom() ;
      A760LiqLegImpBasico = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico() ;
      A761LiqLegGNSI = obj28.getgxTv_SdtLiquidacionLegajo_Liqleggnsi() ;
      A590LiqRutaPDF = obj28.getgxTv_SdtLiquidacionLegajo_Liqrutapdf() ;
      A774LiqRutaPDFVertical = obj28.getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical() ;
      A883LIqLegIteraciones = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones() ;
      A884LiqLegSegundos = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsegundos() ;
      A1495LiqLegSegIns = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsegins() ;
      A1496LieqLegSegUpd = obj28.getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd() ;
      A891LiqLegError = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegerror() ;
      A283LiqPeriodo = obj28.getgxTv_SdtLiquidacionLegajo_Liqperiodo() ;
      A961LiqNombrePDF = obj28.getgxTv_SdtLiquidacionLegajo_Liqnombrepdf() ;
      A962LiqNombrePDFVertical = obj28.getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical() ;
      A32TLiqCod = obj28.getgxTv_SdtLiquidacionLegajo_Tliqcod() ;
      n32TLiqCod = false ;
      A1546LiqLegHorasSem = obj28.getgxTv_SdtLiquidacionLegajo_Liqleghorassem() ;
      A1780LiqLegAuxEstado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegauxestado() ;
      A1781LiqLegErrorAux = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegerroraux() ;
      A1815LiqLegFecEgr = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfecegr() ;
      A1816LiqLegFecIng = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfecing() ;
      A2113LiqLegCatCodigo = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo() ;
      A2115LiqLegConvenio = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegconvenio() ;
      A2114LiqLegSueldo = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsueldo() ;
      A2179LiqLegPDFEstado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado() ;
      n2179LiqLegPDFEstado = false ;
      A2268LiqLegProcesado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegprocesado() ;
      A2360LiqLegNivLiq = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegnivliq() ;
      A2393LiqLegHtml = obj28.getgxTv_SdtLiquidacionLegajo_Liqleghtml() ;
      A2400LiqLegLSD = obj28.getgxTv_SdtLiquidacionLegajo_Liqleglsd() ;
      A2401LiqLegDaemonUUID = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid() ;
      n2401LiqLegDaemonUUID = false ;
      A2402LiqLegFecHor = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfechor() ;
      A3CliCod = obj28.getgxTv_SdtLiquidacionLegajo_Clicod() ;
      A1EmpCod = obj28.getgxTv_SdtLiquidacionLegajo_Empcod() ;
      A31LiqNro = obj28.getgxTv_SdtLiquidacionLegajo_Liqnro() ;
      A6LegNumero = obj28.getgxTv_SdtLiquidacionLegajo_Legnumero() ;
      Z3CliCod = obj28.getgxTv_SdtLiquidacionLegajo_Clicod_Z() ;
      Z1EmpCod = obj28.getgxTv_SdtLiquidacionLegajo_Empcod_Z() ;
      Z2EmpNom = obj28.getgxTv_SdtLiquidacionLegajo_Empnom_Z() ;
      Z31LiqNro = obj28.getgxTv_SdtLiquidacionLegajo_Liqnro_Z() ;
      Z6LegNumero = obj28.getgxTv_SdtLiquidacionLegajo_Legnumero_Z() ;
      Z281LiqLegImpTotal = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z() ;
      Z34LiqSecCodigo = obj28.getgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z() ;
      Z284LiqSecDescrip = obj28.getgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z() ;
      Z282LiqLegReciboNro = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z() ;
      Z93LegId = obj28.getgxTv_SdtLiquidacionLegajo_Legid_Z() ;
      Z482LegLiqDatosHis = obj28.getgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z() ;
      Z498LiqLegImpTotBruto = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z() ;
      Z759LiqLegImpTotBruSinSAC = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z() ;
      Z499LiqLegCntConc = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z() ;
      Z577LiqLegImpTotRemu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z() ;
      Z578LiqLegImpTotNoRemu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z() ;
      Z579LiqLegImpTotDescu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z() ;
      Z1157LiqLegImpContr = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z() ;
      Z1158LiqLegImpCosto = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z() ;
      Z1131LiqLegImpOtrDescu = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z() ;
      Z1143LiqLegImpDescuNeg = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z() ;
      Z757LiqLegImpTotRetGan = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z() ;
      Z775LiqLegImpPagosACuen = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z() ;
      Z758LiqLegImpTotBruProm = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z() ;
      Z760LiqLegImpBasico = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z() ;
      Z761LiqLegGNSI = obj28.getgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z() ;
      Z590LiqRutaPDF = obj28.getgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z() ;
      Z774LiqRutaPDFVertical = obj28.getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z() ;
      Z883LIqLegIteraciones = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z() ;
      Z884LiqLegSegundos = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z() ;
      Z1495LiqLegSegIns = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z() ;
      Z1496LieqLegSegUpd = obj28.getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z() ;
      Z891LiqLegError = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegerror_Z() ;
      Z283LiqPeriodo = obj28.getgxTv_SdtLiquidacionLegajo_Liqperiodo_Z() ;
      Z961LiqNombrePDF = obj28.getgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z() ;
      Z962LiqNombrePDFVertical = obj28.getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z() ;
      Z32TLiqCod = obj28.getgxTv_SdtLiquidacionLegajo_Tliqcod_Z() ;
      Z1546LiqLegHorasSem = obj28.getgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z() ;
      Z1780LiqLegAuxEstado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z() ;
      Z1781LiqLegErrorAux = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z() ;
      Z1815LiqLegFecEgr = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z() ;
      Z1816LiqLegFecIng = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z() ;
      Z2113LiqLegCatCodigo = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z() ;
      Z2115LiqLegConvenio = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z() ;
      Z2114LiqLegSueldo = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z() ;
      Z2179LiqLegPDFEstado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z() ;
      Z2268LiqLegProcesado = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z() ;
      Z2360LiqLegNivLiq = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z() ;
      Z2400LiqLegLSD = obj28.getgxTv_SdtLiquidacionLegajo_Liqleglsd_Z() ;
      Z2401LiqLegDaemonUUID = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z() ;
      Z2402LiqLegFecHor = obj28.getgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z() ;
      n34LiqSecCodigo = (boolean)((obj28.getgxTv_SdtLiquidacionLegajo_Liqseccodigo_N()==0)?false:true) ;
      n93LegId = (boolean)((obj28.getgxTv_SdtLiquidacionLegajo_Legid_N()==0)?false:true) ;
      n32TLiqCod = (boolean)((obj28.getgxTv_SdtLiquidacionLegajo_Tliqcod_N()==0)?false:true) ;
      n2179LiqLegPDFEstado = (boolean)((obj28.getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N()==0)?false:true) ;
      n2401LiqLegDaemonUUID = (boolean)((obj28.getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N()==0)?false:true) ;
      Gx_mode = obj28.getgxTv_SdtLiquidacionLegajo_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A31LiqNro = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0V28( ) ;
      scanKeyStart0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000V40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(38) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000V40_A2EmpNom[0] ;
         pr_default.close(38);
         /* Using cursor BC000V41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(39) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
            AnyError = (short)(1) ;
         }
         A283LiqPeriodo = BC000V41_A283LiqPeriodo[0] ;
         A32TLiqCod = BC000V41_A32TLiqCod[0] ;
         n32TLiqCod = BC000V41_n32TLiqCod[0] ;
         pr_default.close(39);
         /* Using cursor BC000V42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(40) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC000V42_A250LegIdNomApe[0] ;
         A93LegId = BC000V42_A93LegId[0] ;
         n93LegId = BC000V42_n93LegId[0] ;
         A251LegNombre = BC000V42_A251LegNombre[0] ;
         A251LegNombre = BC000V42_A251LegNombre[0] ;
         A230LegApellido = BC000V42_A230LegApellido[0] ;
         A230LegApellido = BC000V42_A230LegApellido[0] ;
         pr_default.close(40);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
      }
      zm0V28( -5) ;
      onLoadActions0V28( ) ;
      addRow0V28( ) ;
      scanKeyEnd0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars28( bcLiquidacionLegajo, 0) ;
      scanKeyStart0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000V43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(41) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000V43_A2EmpNom[0] ;
         pr_default.close(41);
         /* Using cursor BC000V44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(42) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
            AnyError = (short)(1) ;
         }
         A283LiqPeriodo = BC000V44_A283LiqPeriodo[0] ;
         A32TLiqCod = BC000V44_A32TLiqCod[0] ;
         n32TLiqCod = BC000V44_n32TLiqCod[0] ;
         pr_default.close(42);
         /* Using cursor BC000V45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(43) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC000V45_A250LegIdNomApe[0] ;
         A93LegId = BC000V45_A93LegId[0] ;
         n93LegId = BC000V45_n93LegId[0] ;
         A251LegNombre = BC000V45_A251LegNombre[0] ;
         A251LegNombre = BC000V45_A251LegNombre[0] ;
         A230LegApellido = BC000V45_A230LegApellido[0] ;
         A230LegApellido = BC000V45_A230LegApellido[0] ;
         pr_default.close(43);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
      }
      zm0V28( -5) ;
      onLoadActions0V28( ) ;
      addRow0V28( ) ;
      scanKeyEnd0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0V28( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0V28( ) ;
      }
      else
      {
         if ( RcdFound28 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A31LiqNro = Z31LiqNro ;
               A6LegNumero = Z6LegNumero ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0V28( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0V28( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0V28( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars28( bcLiquidacionLegajo, 1) ;
      saveImpl( ) ;
      VarsToRow28( bcLiquidacionLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars28( bcLiquidacionLegajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0V28( ) ;
      afterTrn( ) ;
      VarsToRow28( bcLiquidacionLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.SdtLiquidacionLegajo auxBC = new web.SdtLiquidacionLegajo( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLiquidacionLegajo);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars28( bcLiquidacionLegajo, 1) ;
      updateImpl( ) ;
      VarsToRow28( bcLiquidacionLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars28( bcLiquidacionLegajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0V28( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow28( bcLiquidacionLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars28( bcLiquidacionLegajo, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0V28( ) ;
      if ( RcdFound28 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A31LiqNro = Z31LiqNro ;
            A6LegNumero = Z6LegNumero ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacionlegajo_bc");
      VarsToRow28( bcLiquidacionLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcLiquidacionLegajo.getgxTv_SdtLiquidacionLegajo_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLiquidacionLegajo.setgxTv_SdtLiquidacionLegajo_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLiquidacionLegajo sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLiquidacionLegajo )
      {
         bcLiquidacionLegajo = sdt ;
         if ( GXutil.strcmp(bcLiquidacionLegajo.getgxTv_SdtLiquidacionLegajo_Mode(), "") == 0 )
         {
            bcLiquidacionLegajo.setgxTv_SdtLiquidacionLegajo_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow28( bcLiquidacionLegajo) ;
         }
         else
         {
            RowToVars28( bcLiquidacionLegajo, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLiquidacionLegajo.getgxTv_SdtLiquidacionLegajo_Mode(), "") == 0 )
         {
            bcLiquidacionLegajo.setgxTv_SdtLiquidacionLegajo_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars28( bcLiquidacionLegajo, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLiquidacionLegajo getLiquidacionLegajo_BC( )
   {
      return bcLiquidacionLegajo ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z281LiqLegImpTotal = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      Z482LegLiqDatosHis = "" ;
      A482LegLiqDatosHis = "" ;
      Z498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      Z759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      Z577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      Z578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      Z579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      Z1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      Z1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      Z1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      Z1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      Z757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      Z775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      Z758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      Z760LiqLegImpBasico = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      Z761LiqLegGNSI = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      Z590LiqRutaPDF = "" ;
      A590LiqRutaPDF = "" ;
      Z774LiqRutaPDFVertical = "" ;
      A774LiqRutaPDFVertical = "" ;
      Z884LiqLegSegundos = DecimalUtil.ZERO ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      Z1495LiqLegSegIns = DecimalUtil.ZERO ;
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      Z1496LieqLegSegUpd = DecimalUtil.ZERO ;
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      Z891LiqLegError = "" ;
      A891LiqLegError = "" ;
      Z961LiqNombrePDF = "" ;
      A961LiqNombrePDF = "" ;
      Z962LiqNombrePDFVertical = "" ;
      A962LiqNombrePDFVertical = "" ;
      Z1546LiqLegHorasSem = DecimalUtil.ZERO ;
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      Z1781LiqLegErrorAux = "" ;
      A1781LiqLegErrorAux = "" ;
      Z1815LiqLegFecEgr = GXutil.nullDate() ;
      A1815LiqLegFecEgr = GXutil.nullDate() ;
      Z1816LiqLegFecIng = GXutil.nullDate() ;
      A1816LiqLegFecIng = GXutil.nullDate() ;
      Z2113LiqLegCatCodigo = "" ;
      A2113LiqLegCatCodigo = "" ;
      Z2115LiqLegConvenio = "" ;
      A2115LiqLegConvenio = "" ;
      Z2114LiqLegSueldo = DecimalUtil.ZERO ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      Z2179LiqLegPDFEstado = "" ;
      A2179LiqLegPDFEstado = "" ;
      Z2401LiqLegDaemonUUID = "" ;
      A2401LiqLegDaemonUUID = "" ;
      Z2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      Z34LiqSecCodigo = "" ;
      A34LiqSecCodigo = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z250LegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      Z93LegId = "" ;
      A93LegId = "" ;
      Z251LegNombre = "" ;
      A251LegNombre = "" ;
      Z230LegApellido = "" ;
      A230LegApellido = "" ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      Z32TLiqCod = "" ;
      A32TLiqCod = "" ;
      Z284LiqSecDescrip = "" ;
      A284LiqSecDescrip = "" ;
      Z2393LiqLegHtml = "" ;
      A2393LiqLegHtml = "" ;
      BC000V8_A250LegIdNomApe = new String[] {""} ;
      BC000V8_A2EmpNom = new String[] {""} ;
      BC000V8_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A284LiqSecDescrip = new String[] {""} ;
      BC000V8_A282LiqLegReciboNro = new int[1] ;
      BC000V8_A93LegId = new String[] {""} ;
      BC000V8_n93LegId = new boolean[] {false} ;
      BC000V8_A482LegLiqDatosHis = new String[] {""} ;
      BC000V8_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A499LiqLegCntConc = new short[1] ;
      BC000V8_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A590LiqRutaPDF = new String[] {""} ;
      BC000V8_A774LiqRutaPDFVertical = new String[] {""} ;
      BC000V8_A883LIqLegIteraciones = new short[1] ;
      BC000V8_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A891LiqLegError = new String[] {""} ;
      BC000V8_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A961LiqNombrePDF = new String[] {""} ;
      BC000V8_A962LiqNombrePDFVertical = new String[] {""} ;
      BC000V8_A32TLiqCod = new String[] {""} ;
      BC000V8_n32TLiqCod = new boolean[] {false} ;
      BC000V8_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A1780LiqLegAuxEstado = new byte[1] ;
      BC000V8_A1781LiqLegErrorAux = new String[] {""} ;
      BC000V8_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A2113LiqLegCatCodigo = new String[] {""} ;
      BC000V8_A2115LiqLegConvenio = new String[] {""} ;
      BC000V8_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V8_A2179LiqLegPDFEstado = new String[] {""} ;
      BC000V8_n2179LiqLegPDFEstado = new boolean[] {false} ;
      BC000V8_A2268LiqLegProcesado = new byte[1] ;
      BC000V8_A2360LiqLegNivLiq = new byte[1] ;
      BC000V8_A2393LiqLegHtml = new String[] {""} ;
      BC000V8_A2400LiqLegLSD = new byte[1] ;
      BC000V8_A2401LiqLegDaemonUUID = new String[] {""} ;
      BC000V8_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      BC000V8_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A251LegNombre = new String[] {""} ;
      BC000V8_A230LegApellido = new String[] {""} ;
      BC000V8_A3CliCod = new int[1] ;
      BC000V8_A1EmpCod = new short[1] ;
      BC000V8_A6LegNumero = new int[1] ;
      BC000V8_A31LiqNro = new int[1] ;
      BC000V8_A34LiqSecCodigo = new String[] {""} ;
      BC000V8_n34LiqSecCodigo = new boolean[] {false} ;
      BC000V9_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V9_A32TLiqCod = new String[] {""} ;
      BC000V9_n32TLiqCod = new boolean[] {false} ;
      BC000V10_A284LiqSecDescrip = new String[] {""} ;
      BC000V11_A2EmpNom = new String[] {""} ;
      BC000V12_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V12_A32TLiqCod = new String[] {""} ;
      BC000V12_n32TLiqCod = new boolean[] {false} ;
      BC000V13_A250LegIdNomApe = new String[] {""} ;
      BC000V13_A93LegId = new String[] {""} ;
      BC000V13_n93LegId = new boolean[] {false} ;
      BC000V13_A251LegNombre = new String[] {""} ;
      BC000V13_A230LegApellido = new String[] {""} ;
      BC000V14_A3CliCod = new int[1] ;
      BC000V14_A1EmpCod = new short[1] ;
      BC000V14_A31LiqNro = new int[1] ;
      BC000V14_A6LegNumero = new int[1] ;
      BC000V15_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A282LiqLegReciboNro = new int[1] ;
      BC000V15_A482LegLiqDatosHis = new String[] {""} ;
      BC000V15_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A499LiqLegCntConc = new short[1] ;
      BC000V15_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A590LiqRutaPDF = new String[] {""} ;
      BC000V15_A774LiqRutaPDFVertical = new String[] {""} ;
      BC000V15_A883LIqLegIteraciones = new short[1] ;
      BC000V15_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A891LiqLegError = new String[] {""} ;
      BC000V15_A961LiqNombrePDF = new String[] {""} ;
      BC000V15_A962LiqNombrePDFVertical = new String[] {""} ;
      BC000V15_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A1780LiqLegAuxEstado = new byte[1] ;
      BC000V15_A1781LiqLegErrorAux = new String[] {""} ;
      BC000V15_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V15_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V15_A2113LiqLegCatCodigo = new String[] {""} ;
      BC000V15_A2115LiqLegConvenio = new String[] {""} ;
      BC000V15_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V15_A2179LiqLegPDFEstado = new String[] {""} ;
      BC000V15_n2179LiqLegPDFEstado = new boolean[] {false} ;
      BC000V15_A2268LiqLegProcesado = new byte[1] ;
      BC000V15_A2360LiqLegNivLiq = new byte[1] ;
      BC000V15_A2393LiqLegHtml = new String[] {""} ;
      BC000V15_A2400LiqLegLSD = new byte[1] ;
      BC000V15_A2401LiqLegDaemonUUID = new String[] {""} ;
      BC000V15_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      BC000V15_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V15_A3CliCod = new int[1] ;
      BC000V15_A1EmpCod = new short[1] ;
      BC000V15_A6LegNumero = new int[1] ;
      BC000V15_A31LiqNro = new int[1] ;
      BC000V15_A34LiqSecCodigo = new String[] {""} ;
      BC000V15_n34LiqSecCodigo = new boolean[] {false} ;
      sMode28 = "" ;
      BC000V16_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A282LiqLegReciboNro = new int[1] ;
      BC000V16_A482LegLiqDatosHis = new String[] {""} ;
      BC000V16_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A499LiqLegCntConc = new short[1] ;
      BC000V16_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A590LiqRutaPDF = new String[] {""} ;
      BC000V16_A774LiqRutaPDFVertical = new String[] {""} ;
      BC000V16_A883LIqLegIteraciones = new short[1] ;
      BC000V16_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A891LiqLegError = new String[] {""} ;
      BC000V16_A961LiqNombrePDF = new String[] {""} ;
      BC000V16_A962LiqNombrePDFVertical = new String[] {""} ;
      BC000V16_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A1780LiqLegAuxEstado = new byte[1] ;
      BC000V16_A1781LiqLegErrorAux = new String[] {""} ;
      BC000V16_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V16_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V16_A2113LiqLegCatCodigo = new String[] {""} ;
      BC000V16_A2115LiqLegConvenio = new String[] {""} ;
      BC000V16_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V16_A2179LiqLegPDFEstado = new String[] {""} ;
      BC000V16_n2179LiqLegPDFEstado = new boolean[] {false} ;
      BC000V16_A2268LiqLegProcesado = new byte[1] ;
      BC000V16_A2360LiqLegNivLiq = new byte[1] ;
      BC000V16_A2393LiqLegHtml = new String[] {""} ;
      BC000V16_A2400LiqLegLSD = new byte[1] ;
      BC000V16_A2401LiqLegDaemonUUID = new String[] {""} ;
      BC000V16_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      BC000V16_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V16_A3CliCod = new int[1] ;
      BC000V16_A1EmpCod = new short[1] ;
      BC000V16_A6LegNumero = new int[1] ;
      BC000V16_A31LiqNro = new int[1] ;
      BC000V16_A34LiqSecCodigo = new String[] {""} ;
      BC000V16_n34LiqSecCodigo = new boolean[] {false} ;
      BC000V20_A2EmpNom = new String[] {""} ;
      BC000V21_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V21_A32TLiqCod = new String[] {""} ;
      BC000V21_n32TLiqCod = new boolean[] {false} ;
      BC000V22_A250LegIdNomApe = new String[] {""} ;
      BC000V22_A93LegId = new String[] {""} ;
      BC000V22_n93LegId = new boolean[] {false} ;
      BC000V22_A251LegNombre = new String[] {""} ;
      BC000V22_A230LegApellido = new String[] {""} ;
      BC000V23_A284LiqSecDescrip = new String[] {""} ;
      BC000V24_A3CliCod = new int[1] ;
      BC000V24_A1EmpCod = new short[1] ;
      BC000V24_A6LegNumero = new int[1] ;
      BC000V24_A2243LegCuenLicTpo = new String[] {""} ;
      BC000V24_A2266LegCuenAnio = new short[1] ;
      BC000V24_A2310LegCuLConsAnio = new short[1] ;
      BC000V24_A2311LegCuLConsSec = new short[1] ;
      BC000V25_A3CliCod = new int[1] ;
      BC000V25_A1EmpCod = new short[1] ;
      BC000V25_A6LegNumero = new int[1] ;
      BC000V25_A2243LegCuenLicTpo = new String[] {""} ;
      BC000V25_A2266LegCuenAnio = new short[1] ;
      BC000V25_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V26_A3CliCod = new int[1] ;
      BC000V26_A1EmpCod = new short[1] ;
      BC000V26_A6LegNumero = new int[1] ;
      BC000V26_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V27_A3CliCod = new int[1] ;
      BC000V27_A1EmpCod = new short[1] ;
      BC000V27_A31LiqNro = new int[1] ;
      BC000V27_A6LegNumero = new int[1] ;
      BC000V27_A2094LiqDetForCon = new String[] {""} ;
      BC000V27_A2095LiqDetForOpe = new String[] {""} ;
      BC000V27_A2096LiqDetForOpeCod = new String[] {""} ;
      BC000V28_A3CliCod = new int[1] ;
      BC000V28_A1EmpCod = new short[1] ;
      BC000V28_A31LiqNro = new int[1] ;
      BC000V28_A6LegNumero = new int[1] ;
      BC000V28_A1035LiqDOpeOrig = new String[] {""} ;
      BC000V29_A3CliCod = new int[1] ;
      BC000V29_A1EmpCod = new short[1] ;
      BC000V29_A31LiqNro = new int[1] ;
      BC000V29_A6LegNumero = new int[1] ;
      BC000V29_A1541LiqAjuNro = new short[1] ;
      BC000V30_A3CliCod = new int[1] ;
      BC000V30_A1EmpCod = new short[1] ;
      BC000V30_A6LegNumero = new int[1] ;
      BC000V30_A1172OblSecuencial = new short[1] ;
      BC000V30_A1184LiqOblAltaNro = new int[1] ;
      BC000V30_A1185LiqOblNuevaNro = new int[1] ;
      BC000V31_A3CliCod = new int[1] ;
      BC000V31_A1EmpCod = new short[1] ;
      BC000V31_A6LegNumero = new int[1] ;
      BC000V31_A1172OblSecuencial = new short[1] ;
      BC000V31_A1184LiqOblAltaNro = new int[1] ;
      BC000V31_A1185LiqOblNuevaNro = new int[1] ;
      BC000V32_A3CliCod = new int[1] ;
      BC000V32_A1EmpCod = new short[1] ;
      BC000V32_A6LegNumero = new int[1] ;
      BC000V32_A1172OblSecuencial = new short[1] ;
      BC000V33_A3CliCod = new int[1] ;
      BC000V33_A1EmpCod = new short[1] ;
      BC000V33_A1129LiqExAnio = new short[1] ;
      BC000V33_A31LiqNro = new int[1] ;
      BC000V33_A6LegNumero = new int[1] ;
      BC000V33_A1127LiqExenConCodigo = new String[] {""} ;
      BC000V33_A1128LiqExAplIIGG = new short[1] ;
      BC000V34_A3CliCod = new int[1] ;
      BC000V34_A1EmpCod = new short[1] ;
      BC000V34_A869LiqLegConAnio = new short[1] ;
      BC000V34_A6LegNumero = new int[1] ;
      BC000V34_A26ConCodigo = new String[] {""} ;
      BC000V34_A1097LiqAltaNro = new int[1] ;
      BC000V34_A1098LiqNuevaNro = new int[1] ;
      BC000V35_A3CliCod = new int[1] ;
      BC000V35_A1EmpCod = new short[1] ;
      BC000V35_A869LiqLegConAnio = new short[1] ;
      BC000V35_A6LegNumero = new int[1] ;
      BC000V35_A26ConCodigo = new String[] {""} ;
      BC000V35_A1097LiqAltaNro = new int[1] ;
      BC000V35_A1098LiqNuevaNro = new int[1] ;
      BC000V36_A3CliCod = new int[1] ;
      BC000V36_A1EmpCod = new short[1] ;
      BC000V36_A31LiqNro = new int[1] ;
      BC000V36_A6LegNumero = new int[1] ;
      BC000V36_A721TestLiqDSecuencial = new short[1] ;
      BC000V37_A3CliCod = new int[1] ;
      BC000V37_A1EmpCod = new short[1] ;
      BC000V37_A31LiqNro = new int[1] ;
      BC000V37_A6LegNumero = new int[1] ;
      BC000V37_A81LiqDSecuencial = new int[1] ;
      BC000V38_A3CliCod = new int[1] ;
      BC000V38_A1EmpCod = new short[1] ;
      BC000V38_A6LegNumero = new int[1] ;
      BC000V38_A25AgeOrden = new short[1] ;
      BC000V39_A250LegIdNomApe = new String[] {""} ;
      BC000V39_A2EmpNom = new String[] {""} ;
      BC000V39_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A284LiqSecDescrip = new String[] {""} ;
      BC000V39_A282LiqLegReciboNro = new int[1] ;
      BC000V39_A93LegId = new String[] {""} ;
      BC000V39_n93LegId = new boolean[] {false} ;
      BC000V39_A482LegLiqDatosHis = new String[] {""} ;
      BC000V39_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A499LiqLegCntConc = new short[1] ;
      BC000V39_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A590LiqRutaPDF = new String[] {""} ;
      BC000V39_A774LiqRutaPDFVertical = new String[] {""} ;
      BC000V39_A883LIqLegIteraciones = new short[1] ;
      BC000V39_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A891LiqLegError = new String[] {""} ;
      BC000V39_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V39_A961LiqNombrePDF = new String[] {""} ;
      BC000V39_A962LiqNombrePDFVertical = new String[] {""} ;
      BC000V39_A32TLiqCod = new String[] {""} ;
      BC000V39_n32TLiqCod = new boolean[] {false} ;
      BC000V39_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A1780LiqLegAuxEstado = new byte[1] ;
      BC000V39_A1781LiqLegErrorAux = new String[] {""} ;
      BC000V39_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V39_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V39_A2113LiqLegCatCodigo = new String[] {""} ;
      BC000V39_A2115LiqLegConvenio = new String[] {""} ;
      BC000V39_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000V39_A2179LiqLegPDFEstado = new String[] {""} ;
      BC000V39_n2179LiqLegPDFEstado = new boolean[] {false} ;
      BC000V39_A2268LiqLegProcesado = new byte[1] ;
      BC000V39_A2360LiqLegNivLiq = new byte[1] ;
      BC000V39_A2393LiqLegHtml = new String[] {""} ;
      BC000V39_A2400LiqLegLSD = new byte[1] ;
      BC000V39_A2401LiqLegDaemonUUID = new String[] {""} ;
      BC000V39_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      BC000V39_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V39_A251LegNombre = new String[] {""} ;
      BC000V39_A230LegApellido = new String[] {""} ;
      BC000V39_A3CliCod = new int[1] ;
      BC000V39_A1EmpCod = new short[1] ;
      BC000V39_A6LegNumero = new int[1] ;
      BC000V39_A31LiqNro = new int[1] ;
      BC000V39_A34LiqSecCodigo = new String[] {""} ;
      BC000V39_n34LiqSecCodigo = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000V40_A2EmpNom = new String[] {""} ;
      BC000V41_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V41_A32TLiqCod = new String[] {""} ;
      BC000V41_n32TLiqCod = new boolean[] {false} ;
      BC000V42_A250LegIdNomApe = new String[] {""} ;
      BC000V42_A93LegId = new String[] {""} ;
      BC000V42_n93LegId = new boolean[] {false} ;
      BC000V42_A251LegNombre = new String[] {""} ;
      BC000V42_A230LegApellido = new String[] {""} ;
      BC000V43_A2EmpNom = new String[] {""} ;
      BC000V44_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V44_A32TLiqCod = new String[] {""} ;
      BC000V44_n32TLiqCod = new boolean[] {false} ;
      BC000V45_A250LegIdNomApe = new String[] {""} ;
      BC000V45_A93LegId = new String[] {""} ;
      BC000V45_n93LegId = new boolean[] {false} ;
      BC000V45_A251LegNombre = new String[] {""} ;
      BC000V45_A230LegApellido = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionlegajo_bc__default(),
         new Object[] {
             new Object[] {
            BC000V2_A281LiqLegImpTotal, BC000V2_A282LiqLegReciboNro, BC000V2_A482LegLiqDatosHis, BC000V2_A498LiqLegImpTotBruto, BC000V2_A759LiqLegImpTotBruSinSAC, BC000V2_A499LiqLegCntConc, BC000V2_A577LiqLegImpTotRemu, BC000V2_A578LiqLegImpTotNoRemu, BC000V2_A579LiqLegImpTotDescu, BC000V2_A1157LiqLegImpContr,
            BC000V2_A1158LiqLegImpCosto, BC000V2_A1131LiqLegImpOtrDescu, BC000V2_A1143LiqLegImpDescuNeg, BC000V2_A757LiqLegImpTotRetGan, BC000V2_A775LiqLegImpPagosACuen, BC000V2_A758LiqLegImpTotBruProm, BC000V2_A760LiqLegImpBasico, BC000V2_A761LiqLegGNSI, BC000V2_A590LiqRutaPDF, BC000V2_A774LiqRutaPDFVertical,
            BC000V2_A883LIqLegIteraciones, BC000V2_A884LiqLegSegundos, BC000V2_A1495LiqLegSegIns, BC000V2_A1496LieqLegSegUpd, BC000V2_A891LiqLegError, BC000V2_A961LiqNombrePDF, BC000V2_A962LiqNombrePDFVertical, BC000V2_A1546LiqLegHorasSem, BC000V2_A1780LiqLegAuxEstado, BC000V2_A1781LiqLegErrorAux,
            BC000V2_A1815LiqLegFecEgr, BC000V2_A1816LiqLegFecIng, BC000V2_A2113LiqLegCatCodigo, BC000V2_A2115LiqLegConvenio, BC000V2_A2114LiqLegSueldo, BC000V2_A2179LiqLegPDFEstado, BC000V2_n2179LiqLegPDFEstado, BC000V2_A2268LiqLegProcesado, BC000V2_A2360LiqLegNivLiq, BC000V2_A2393LiqLegHtml,
            BC000V2_A2400LiqLegLSD, BC000V2_A2401LiqLegDaemonUUID, BC000V2_n2401LiqLegDaemonUUID, BC000V2_A2402LiqLegFecHor, BC000V2_A3CliCod, BC000V2_A1EmpCod, BC000V2_A6LegNumero, BC000V2_A31LiqNro, BC000V2_A34LiqSecCodigo, BC000V2_n34LiqSecCodigo,
            BC000V2_A283LiqPeriodo, BC000V2_A32TLiqCod, BC000V2_n32TLiqCod
            }
            , new Object[] {
            BC000V3_A281LiqLegImpTotal, BC000V3_A282LiqLegReciboNro, BC000V3_A482LegLiqDatosHis, BC000V3_A498LiqLegImpTotBruto, BC000V3_A759LiqLegImpTotBruSinSAC, BC000V3_A499LiqLegCntConc, BC000V3_A577LiqLegImpTotRemu, BC000V3_A578LiqLegImpTotNoRemu, BC000V3_A579LiqLegImpTotDescu, BC000V3_A1157LiqLegImpContr,
            BC000V3_A1158LiqLegImpCosto, BC000V3_A1131LiqLegImpOtrDescu, BC000V3_A1143LiqLegImpDescuNeg, BC000V3_A757LiqLegImpTotRetGan, BC000V3_A775LiqLegImpPagosACuen, BC000V3_A758LiqLegImpTotBruProm, BC000V3_A760LiqLegImpBasico, BC000V3_A761LiqLegGNSI, BC000V3_A590LiqRutaPDF, BC000V3_A774LiqRutaPDFVertical,
            BC000V3_A883LIqLegIteraciones, BC000V3_A884LiqLegSegundos, BC000V3_A1495LiqLegSegIns, BC000V3_A1496LieqLegSegUpd, BC000V3_A891LiqLegError, BC000V3_A961LiqNombrePDF, BC000V3_A962LiqNombrePDFVertical, BC000V3_A1546LiqLegHorasSem, BC000V3_A1780LiqLegAuxEstado, BC000V3_A1781LiqLegErrorAux,
            BC000V3_A1815LiqLegFecEgr, BC000V3_A1816LiqLegFecIng, BC000V3_A2113LiqLegCatCodigo, BC000V3_A2115LiqLegConvenio, BC000V3_A2114LiqLegSueldo, BC000V3_A2179LiqLegPDFEstado, BC000V3_n2179LiqLegPDFEstado, BC000V3_A2268LiqLegProcesado, BC000V3_A2360LiqLegNivLiq, BC000V3_A2393LiqLegHtml,
            BC000V3_A2400LiqLegLSD, BC000V3_A2401LiqLegDaemonUUID, BC000V3_n2401LiqLegDaemonUUID, BC000V3_A2402LiqLegFecHor, BC000V3_A3CliCod, BC000V3_A1EmpCod, BC000V3_A6LegNumero, BC000V3_A31LiqNro, BC000V3_A34LiqSecCodigo, BC000V3_n34LiqSecCodigo,
            BC000V3_A283LiqPeriodo, BC000V3_A32TLiqCod, BC000V3_n32TLiqCod
            }
            , new Object[] {
            BC000V4_A2EmpNom
            }
            , new Object[] {
            BC000V5_A250LegIdNomApe, BC000V5_A93LegId, BC000V5_n93LegId, BC000V5_A251LegNombre, BC000V5_A230LegApellido
            }
            , new Object[] {
            BC000V6_A283LiqPeriodo, BC000V6_A32TLiqCod, BC000V6_n32TLiqCod
            }
            , new Object[] {
            BC000V7_A284LiqSecDescrip
            }
            , new Object[] {
            BC000V8_A250LegIdNomApe, BC000V8_A2EmpNom, BC000V8_A281LiqLegImpTotal, BC000V8_A284LiqSecDescrip, BC000V8_A282LiqLegReciboNro, BC000V8_A93LegId, BC000V8_n93LegId, BC000V8_A482LegLiqDatosHis, BC000V8_A498LiqLegImpTotBruto, BC000V8_A759LiqLegImpTotBruSinSAC,
            BC000V8_A499LiqLegCntConc, BC000V8_A577LiqLegImpTotRemu, BC000V8_A578LiqLegImpTotNoRemu, BC000V8_A579LiqLegImpTotDescu, BC000V8_A1157LiqLegImpContr, BC000V8_A1158LiqLegImpCosto, BC000V8_A1131LiqLegImpOtrDescu, BC000V8_A1143LiqLegImpDescuNeg, BC000V8_A757LiqLegImpTotRetGan, BC000V8_A775LiqLegImpPagosACuen,
            BC000V8_A758LiqLegImpTotBruProm, BC000V8_A760LiqLegImpBasico, BC000V8_A761LiqLegGNSI, BC000V8_A590LiqRutaPDF, BC000V8_A774LiqRutaPDFVertical, BC000V8_A883LIqLegIteraciones, BC000V8_A884LiqLegSegundos, BC000V8_A1495LiqLegSegIns, BC000V8_A1496LieqLegSegUpd, BC000V8_A891LiqLegError,
            BC000V8_A283LiqPeriodo, BC000V8_A961LiqNombrePDF, BC000V8_A962LiqNombrePDFVertical, BC000V8_A32TLiqCod, BC000V8_n32TLiqCod, BC000V8_A1546LiqLegHorasSem, BC000V8_A1780LiqLegAuxEstado, BC000V8_A1781LiqLegErrorAux, BC000V8_A1815LiqLegFecEgr, BC000V8_A1816LiqLegFecIng,
            BC000V8_A2113LiqLegCatCodigo, BC000V8_A2115LiqLegConvenio, BC000V8_A2114LiqLegSueldo, BC000V8_A2179LiqLegPDFEstado, BC000V8_n2179LiqLegPDFEstado, BC000V8_A2268LiqLegProcesado, BC000V8_A2360LiqLegNivLiq, BC000V8_A2393LiqLegHtml, BC000V8_A2400LiqLegLSD, BC000V8_A2401LiqLegDaemonUUID,
            BC000V8_n2401LiqLegDaemonUUID, BC000V8_A2402LiqLegFecHor, BC000V8_A251LegNombre, BC000V8_A230LegApellido, BC000V8_A3CliCod, BC000V8_A1EmpCod, BC000V8_A6LegNumero, BC000V8_A31LiqNro, BC000V8_A34LiqSecCodigo, BC000V8_n34LiqSecCodigo
            }
            , new Object[] {
            BC000V9_A283LiqPeriodo, BC000V9_A32TLiqCod, BC000V9_n32TLiqCod
            }
            , new Object[] {
            BC000V10_A284LiqSecDescrip
            }
            , new Object[] {
            BC000V11_A2EmpNom
            }
            , new Object[] {
            BC000V12_A283LiqPeriodo, BC000V12_A32TLiqCod, BC000V12_n32TLiqCod
            }
            , new Object[] {
            BC000V13_A250LegIdNomApe, BC000V13_A93LegId, BC000V13_n93LegId, BC000V13_A251LegNombre, BC000V13_A230LegApellido
            }
            , new Object[] {
            BC000V14_A3CliCod, BC000V14_A1EmpCod, BC000V14_A31LiqNro, BC000V14_A6LegNumero
            }
            , new Object[] {
            BC000V15_A281LiqLegImpTotal, BC000V15_A282LiqLegReciboNro, BC000V15_A482LegLiqDatosHis, BC000V15_A498LiqLegImpTotBruto, BC000V15_A759LiqLegImpTotBruSinSAC, BC000V15_A499LiqLegCntConc, BC000V15_A577LiqLegImpTotRemu, BC000V15_A578LiqLegImpTotNoRemu, BC000V15_A579LiqLegImpTotDescu, BC000V15_A1157LiqLegImpContr,
            BC000V15_A1158LiqLegImpCosto, BC000V15_A1131LiqLegImpOtrDescu, BC000V15_A1143LiqLegImpDescuNeg, BC000V15_A757LiqLegImpTotRetGan, BC000V15_A775LiqLegImpPagosACuen, BC000V15_A758LiqLegImpTotBruProm, BC000V15_A760LiqLegImpBasico, BC000V15_A761LiqLegGNSI, BC000V15_A590LiqRutaPDF, BC000V15_A774LiqRutaPDFVertical,
            BC000V15_A883LIqLegIteraciones, BC000V15_A884LiqLegSegundos, BC000V15_A1495LiqLegSegIns, BC000V15_A1496LieqLegSegUpd, BC000V15_A891LiqLegError, BC000V15_A961LiqNombrePDF, BC000V15_A962LiqNombrePDFVertical, BC000V15_A1546LiqLegHorasSem, BC000V15_A1780LiqLegAuxEstado, BC000V15_A1781LiqLegErrorAux,
            BC000V15_A1815LiqLegFecEgr, BC000V15_A1816LiqLegFecIng, BC000V15_A2113LiqLegCatCodigo, BC000V15_A2115LiqLegConvenio, BC000V15_A2114LiqLegSueldo, BC000V15_A2179LiqLegPDFEstado, BC000V15_n2179LiqLegPDFEstado, BC000V15_A2268LiqLegProcesado, BC000V15_A2360LiqLegNivLiq, BC000V15_A2393LiqLegHtml,
            BC000V15_A2400LiqLegLSD, BC000V15_A2401LiqLegDaemonUUID, BC000V15_n2401LiqLegDaemonUUID, BC000V15_A2402LiqLegFecHor, BC000V15_A3CliCod, BC000V15_A1EmpCod, BC000V15_A6LegNumero, BC000V15_A31LiqNro, BC000V15_A34LiqSecCodigo, BC000V15_n34LiqSecCodigo
            }
            , new Object[] {
            BC000V16_A281LiqLegImpTotal, BC000V16_A282LiqLegReciboNro, BC000V16_A482LegLiqDatosHis, BC000V16_A498LiqLegImpTotBruto, BC000V16_A759LiqLegImpTotBruSinSAC, BC000V16_A499LiqLegCntConc, BC000V16_A577LiqLegImpTotRemu, BC000V16_A578LiqLegImpTotNoRemu, BC000V16_A579LiqLegImpTotDescu, BC000V16_A1157LiqLegImpContr,
            BC000V16_A1158LiqLegImpCosto, BC000V16_A1131LiqLegImpOtrDescu, BC000V16_A1143LiqLegImpDescuNeg, BC000V16_A757LiqLegImpTotRetGan, BC000V16_A775LiqLegImpPagosACuen, BC000V16_A758LiqLegImpTotBruProm, BC000V16_A760LiqLegImpBasico, BC000V16_A761LiqLegGNSI, BC000V16_A590LiqRutaPDF, BC000V16_A774LiqRutaPDFVertical,
            BC000V16_A883LIqLegIteraciones, BC000V16_A884LiqLegSegundos, BC000V16_A1495LiqLegSegIns, BC000V16_A1496LieqLegSegUpd, BC000V16_A891LiqLegError, BC000V16_A961LiqNombrePDF, BC000V16_A962LiqNombrePDFVertical, BC000V16_A1546LiqLegHorasSem, BC000V16_A1780LiqLegAuxEstado, BC000V16_A1781LiqLegErrorAux,
            BC000V16_A1815LiqLegFecEgr, BC000V16_A1816LiqLegFecIng, BC000V16_A2113LiqLegCatCodigo, BC000V16_A2115LiqLegConvenio, BC000V16_A2114LiqLegSueldo, BC000V16_A2179LiqLegPDFEstado, BC000V16_n2179LiqLegPDFEstado, BC000V16_A2268LiqLegProcesado, BC000V16_A2360LiqLegNivLiq, BC000V16_A2393LiqLegHtml,
            BC000V16_A2400LiqLegLSD, BC000V16_A2401LiqLegDaemonUUID, BC000V16_n2401LiqLegDaemonUUID, BC000V16_A2402LiqLegFecHor, BC000V16_A3CliCod, BC000V16_A1EmpCod, BC000V16_A6LegNumero, BC000V16_A31LiqNro, BC000V16_A34LiqSecCodigo, BC000V16_n34LiqSecCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000V20_A2EmpNom
            }
            , new Object[] {
            BC000V21_A283LiqPeriodo, BC000V21_A32TLiqCod, BC000V21_n32TLiqCod
            }
            , new Object[] {
            BC000V22_A250LegIdNomApe, BC000V22_A93LegId, BC000V22_n93LegId, BC000V22_A251LegNombre, BC000V22_A230LegApellido
            }
            , new Object[] {
            BC000V23_A284LiqSecDescrip
            }
            , new Object[] {
            BC000V24_A3CliCod, BC000V24_A1EmpCod, BC000V24_A6LegNumero, BC000V24_A2243LegCuenLicTpo, BC000V24_A2266LegCuenAnio, BC000V24_A2310LegCuLConsAnio, BC000V24_A2311LegCuLConsSec
            }
            , new Object[] {
            BC000V25_A3CliCod, BC000V25_A1EmpCod, BC000V25_A6LegNumero, BC000V25_A2243LegCuenLicTpo, BC000V25_A2266LegCuenAnio, BC000V25_A2324LegCuLAprLicFch
            }
            , new Object[] {
            BC000V26_A3CliCod, BC000V26_A1EmpCod, BC000V26_A6LegNumero, BC000V26_A2253LegHisFecIng
            }
            , new Object[] {
            BC000V27_A3CliCod, BC000V27_A1EmpCod, BC000V27_A31LiqNro, BC000V27_A6LegNumero, BC000V27_A2094LiqDetForCon, BC000V27_A2095LiqDetForOpe, BC000V27_A2096LiqDetForOpeCod
            }
            , new Object[] {
            BC000V28_A3CliCod, BC000V28_A1EmpCod, BC000V28_A31LiqNro, BC000V28_A6LegNumero, BC000V28_A1035LiqDOpeOrig
            }
            , new Object[] {
            BC000V29_A3CliCod, BC000V29_A1EmpCod, BC000V29_A31LiqNro, BC000V29_A6LegNumero, BC000V29_A1541LiqAjuNro
            }
            , new Object[] {
            BC000V30_A3CliCod, BC000V30_A1EmpCod, BC000V30_A6LegNumero, BC000V30_A1172OblSecuencial, BC000V30_A1184LiqOblAltaNro, BC000V30_A1185LiqOblNuevaNro
            }
            , new Object[] {
            BC000V31_A3CliCod, BC000V31_A1EmpCod, BC000V31_A6LegNumero, BC000V31_A1172OblSecuencial, BC000V31_A1184LiqOblAltaNro, BC000V31_A1185LiqOblNuevaNro
            }
            , new Object[] {
            BC000V32_A3CliCod, BC000V32_A1EmpCod, BC000V32_A6LegNumero, BC000V32_A1172OblSecuencial
            }
            , new Object[] {
            BC000V33_A3CliCod, BC000V33_A1EmpCod, BC000V33_A1129LiqExAnio, BC000V33_A31LiqNro, BC000V33_A6LegNumero, BC000V33_A1127LiqExenConCodigo, BC000V33_A1128LiqExAplIIGG
            }
            , new Object[] {
            BC000V34_A3CliCod, BC000V34_A1EmpCod, BC000V34_A869LiqLegConAnio, BC000V34_A6LegNumero, BC000V34_A26ConCodigo, BC000V34_A1097LiqAltaNro, BC000V34_A1098LiqNuevaNro
            }
            , new Object[] {
            BC000V35_A3CliCod, BC000V35_A1EmpCod, BC000V35_A869LiqLegConAnio, BC000V35_A6LegNumero, BC000V35_A26ConCodigo, BC000V35_A1097LiqAltaNro, BC000V35_A1098LiqNuevaNro
            }
            , new Object[] {
            BC000V36_A3CliCod, BC000V36_A1EmpCod, BC000V36_A31LiqNro, BC000V36_A6LegNumero, BC000V36_A721TestLiqDSecuencial
            }
            , new Object[] {
            BC000V37_A3CliCod, BC000V37_A1EmpCod, BC000V37_A31LiqNro, BC000V37_A6LegNumero, BC000V37_A81LiqDSecuencial
            }
            , new Object[] {
            BC000V38_A3CliCod, BC000V38_A1EmpCod, BC000V38_A6LegNumero, BC000V38_A25AgeOrden
            }
            , new Object[] {
            BC000V39_A250LegIdNomApe, BC000V39_A2EmpNom, BC000V39_A281LiqLegImpTotal, BC000V39_A284LiqSecDescrip, BC000V39_A282LiqLegReciboNro, BC000V39_A93LegId, BC000V39_n93LegId, BC000V39_A482LegLiqDatosHis, BC000V39_A498LiqLegImpTotBruto, BC000V39_A759LiqLegImpTotBruSinSAC,
            BC000V39_A499LiqLegCntConc, BC000V39_A577LiqLegImpTotRemu, BC000V39_A578LiqLegImpTotNoRemu, BC000V39_A579LiqLegImpTotDescu, BC000V39_A1157LiqLegImpContr, BC000V39_A1158LiqLegImpCosto, BC000V39_A1131LiqLegImpOtrDescu, BC000V39_A1143LiqLegImpDescuNeg, BC000V39_A757LiqLegImpTotRetGan, BC000V39_A775LiqLegImpPagosACuen,
            BC000V39_A758LiqLegImpTotBruProm, BC000V39_A760LiqLegImpBasico, BC000V39_A761LiqLegGNSI, BC000V39_A590LiqRutaPDF, BC000V39_A774LiqRutaPDFVertical, BC000V39_A883LIqLegIteraciones, BC000V39_A884LiqLegSegundos, BC000V39_A1495LiqLegSegIns, BC000V39_A1496LieqLegSegUpd, BC000V39_A891LiqLegError,
            BC000V39_A283LiqPeriodo, BC000V39_A961LiqNombrePDF, BC000V39_A962LiqNombrePDFVertical, BC000V39_A32TLiqCod, BC000V39_n32TLiqCod, BC000V39_A1546LiqLegHorasSem, BC000V39_A1780LiqLegAuxEstado, BC000V39_A1781LiqLegErrorAux, BC000V39_A1815LiqLegFecEgr, BC000V39_A1816LiqLegFecIng,
            BC000V39_A2113LiqLegCatCodigo, BC000V39_A2115LiqLegConvenio, BC000V39_A2114LiqLegSueldo, BC000V39_A2179LiqLegPDFEstado, BC000V39_n2179LiqLegPDFEstado, BC000V39_A2268LiqLegProcesado, BC000V39_A2360LiqLegNivLiq, BC000V39_A2393LiqLegHtml, BC000V39_A2400LiqLegLSD, BC000V39_A2401LiqLegDaemonUUID,
            BC000V39_n2401LiqLegDaemonUUID, BC000V39_A2402LiqLegFecHor, BC000V39_A251LegNombre, BC000V39_A230LegApellido, BC000V39_A3CliCod, BC000V39_A1EmpCod, BC000V39_A6LegNumero, BC000V39_A31LiqNro, BC000V39_A34LiqSecCodigo, BC000V39_n34LiqSecCodigo
            }
            , new Object[] {
            BC000V40_A2EmpNom
            }
            , new Object[] {
            BC000V41_A283LiqPeriodo, BC000V41_A32TLiqCod, BC000V41_n32TLiqCod
            }
            , new Object[] {
            BC000V42_A250LegIdNomApe, BC000V42_A93LegId, BC000V42_n93LegId, BC000V42_A251LegNombre, BC000V42_A230LegApellido
            }
            , new Object[] {
            BC000V43_A2EmpNom
            }
            , new Object[] {
            BC000V44_A283LiqPeriodo, BC000V44_A32TLiqCod, BC000V44_n32TLiqCod
            }
            , new Object[] {
            BC000V45_A250LegIdNomApe, BC000V45_A93LegId, BC000V45_n93LegId, BC000V45_A251LegNombre, BC000V45_A230LegApellido
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1780LiqLegAuxEstado ;
   private byte A1780LiqLegAuxEstado ;
   private byte Z2268LiqLegProcesado ;
   private byte A2268LiqLegProcesado ;
   private byte Z2360LiqLegNivLiq ;
   private byte A2360LiqLegNivLiq ;
   private byte Z2400LiqLegLSD ;
   private byte A2400LiqLegLSD ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z499LiqLegCntConc ;
   private short A499LiqLegCntConc ;
   private short Z883LIqLegIteraciones ;
   private short A883LIqLegIteraciones ;
   private short RcdFound28 ;
   private short nIsDirty_28 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z31LiqNro ;
   private int A31LiqNro ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int GX_JID ;
   private int Z282LiqLegReciboNro ;
   private int A282LiqLegReciboNro ;
   private java.math.BigDecimal Z281LiqLegImpTotal ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal Z498LiqLegImpTotBruto ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal Z759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal Z577LiqLegImpTotRemu ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal Z578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal Z579LiqLegImpTotDescu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal Z1157LiqLegImpContr ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal Z1158LiqLegImpCosto ;
   private java.math.BigDecimal A1158LiqLegImpCosto ;
   private java.math.BigDecimal Z1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal Z1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal Z757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal Z775LiqLegImpPagosACuen ;
   private java.math.BigDecimal A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal Z758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal Z760LiqLegImpBasico ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal Z761LiqLegGNSI ;
   private java.math.BigDecimal A761LiqLegGNSI ;
   private java.math.BigDecimal Z884LiqLegSegundos ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private java.math.BigDecimal Z1495LiqLegSegIns ;
   private java.math.BigDecimal A1495LiqLegSegIns ;
   private java.math.BigDecimal Z1496LieqLegSegUpd ;
   private java.math.BigDecimal A1496LieqLegSegUpd ;
   private java.math.BigDecimal Z1546LiqLegHorasSem ;
   private java.math.BigDecimal A1546LiqLegHorasSem ;
   private java.math.BigDecimal Z2114LiqLegSueldo ;
   private java.math.BigDecimal A2114LiqLegSueldo ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z961LiqNombrePDF ;
   private String A961LiqNombrePDF ;
   private String Z962LiqNombrePDFVertical ;
   private String A962LiqNombrePDFVertical ;
   private String Z2113LiqLegCatCodigo ;
   private String A2113LiqLegCatCodigo ;
   private String Z2115LiqLegConvenio ;
   private String A2115LiqLegConvenio ;
   private String Z2179LiqLegPDFEstado ;
   private String A2179LiqLegPDFEstado ;
   private String Z2401LiqLegDaemonUUID ;
   private String A2401LiqLegDaemonUUID ;
   private String Z34LiqSecCodigo ;
   private String A34LiqSecCodigo ;
   private String Z93LegId ;
   private String A93LegId ;
   private String Z32TLiqCod ;
   private String A32TLiqCod ;
   private String sMode28 ;
   private java.util.Date Z2402LiqLegFecHor ;
   private java.util.Date A2402LiqLegFecHor ;
   private java.util.Date Z1815LiqLegFecEgr ;
   private java.util.Date A1815LiqLegFecEgr ;
   private java.util.Date Z1816LiqLegFecIng ;
   private java.util.Date A1816LiqLegFecIng ;
   private java.util.Date Z283LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n93LegId ;
   private boolean n32TLiqCod ;
   private boolean n2179LiqLegPDFEstado ;
   private boolean n2401LiqLegDaemonUUID ;
   private boolean n34LiqSecCodigo ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z2393LiqLegHtml ;
   private String A2393LiqLegHtml ;
   private String Z482LegLiqDatosHis ;
   private String A482LegLiqDatosHis ;
   private String Z590LiqRutaPDF ;
   private String A590LiqRutaPDF ;
   private String Z774LiqRutaPDFVertical ;
   private String A774LiqRutaPDFVertical ;
   private String Z891LiqLegError ;
   private String A891LiqLegError ;
   private String Z1781LiqLegErrorAux ;
   private String A1781LiqLegErrorAux ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z250LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String Z251LegNombre ;
   private String A251LegNombre ;
   private String Z230LegApellido ;
   private String A230LegApellido ;
   private String Z284LiqSecDescrip ;
   private String A284LiqSecDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.SdtLiquidacionLegajo bcLiquidacionLegajo ;
   private IDataStoreProvider pr_default ;
   private String[] BC000V8_A250LegIdNomApe ;
   private String[] BC000V8_A2EmpNom ;
   private java.math.BigDecimal[] BC000V8_A281LiqLegImpTotal ;
   private String[] BC000V8_A284LiqSecDescrip ;
   private int[] BC000V8_A282LiqLegReciboNro ;
   private String[] BC000V8_A93LegId ;
   private boolean[] BC000V8_n93LegId ;
   private String[] BC000V8_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V8_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V8_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V8_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V8_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V8_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V8_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V8_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V8_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V8_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V8_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V8_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V8_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V8_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V8_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V8_A761LiqLegGNSI ;
   private String[] BC000V8_A590LiqRutaPDF ;
   private String[] BC000V8_A774LiqRutaPDFVertical ;
   private short[] BC000V8_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V8_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V8_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V8_A1496LieqLegSegUpd ;
   private String[] BC000V8_A891LiqLegError ;
   private java.util.Date[] BC000V8_A283LiqPeriodo ;
   private String[] BC000V8_A961LiqNombrePDF ;
   private String[] BC000V8_A962LiqNombrePDFVertical ;
   private String[] BC000V8_A32TLiqCod ;
   private boolean[] BC000V8_n32TLiqCod ;
   private java.math.BigDecimal[] BC000V8_A1546LiqLegHorasSem ;
   private byte[] BC000V8_A1780LiqLegAuxEstado ;
   private String[] BC000V8_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V8_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V8_A1816LiqLegFecIng ;
   private String[] BC000V8_A2113LiqLegCatCodigo ;
   private String[] BC000V8_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V8_A2114LiqLegSueldo ;
   private String[] BC000V8_A2179LiqLegPDFEstado ;
   private boolean[] BC000V8_n2179LiqLegPDFEstado ;
   private byte[] BC000V8_A2268LiqLegProcesado ;
   private byte[] BC000V8_A2360LiqLegNivLiq ;
   private String[] BC000V8_A2393LiqLegHtml ;
   private byte[] BC000V8_A2400LiqLegLSD ;
   private String[] BC000V8_A2401LiqLegDaemonUUID ;
   private boolean[] BC000V8_n2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V8_A2402LiqLegFecHor ;
   private String[] BC000V8_A251LegNombre ;
   private String[] BC000V8_A230LegApellido ;
   private int[] BC000V8_A3CliCod ;
   private short[] BC000V8_A1EmpCod ;
   private int[] BC000V8_A6LegNumero ;
   private int[] BC000V8_A31LiqNro ;
   private String[] BC000V8_A34LiqSecCodigo ;
   private boolean[] BC000V8_n34LiqSecCodigo ;
   private java.util.Date[] BC000V9_A283LiqPeriodo ;
   private String[] BC000V9_A32TLiqCod ;
   private boolean[] BC000V9_n32TLiqCod ;
   private String[] BC000V10_A284LiqSecDescrip ;
   private String[] BC000V11_A2EmpNom ;
   private java.util.Date[] BC000V12_A283LiqPeriodo ;
   private String[] BC000V12_A32TLiqCod ;
   private boolean[] BC000V12_n32TLiqCod ;
   private String[] BC000V13_A250LegIdNomApe ;
   private String[] BC000V13_A93LegId ;
   private boolean[] BC000V13_n93LegId ;
   private String[] BC000V13_A251LegNombre ;
   private String[] BC000V13_A230LegApellido ;
   private int[] BC000V14_A3CliCod ;
   private short[] BC000V14_A1EmpCod ;
   private int[] BC000V14_A31LiqNro ;
   private int[] BC000V14_A6LegNumero ;
   private java.math.BigDecimal[] BC000V15_A281LiqLegImpTotal ;
   private int[] BC000V15_A282LiqLegReciboNro ;
   private String[] BC000V15_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V15_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V15_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V15_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V15_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V15_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V15_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V15_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V15_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V15_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V15_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V15_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V15_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V15_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V15_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V15_A761LiqLegGNSI ;
   private String[] BC000V15_A590LiqRutaPDF ;
   private String[] BC000V15_A774LiqRutaPDFVertical ;
   private short[] BC000V15_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V15_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V15_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V15_A1496LieqLegSegUpd ;
   private String[] BC000V15_A891LiqLegError ;
   private String[] BC000V15_A961LiqNombrePDF ;
   private String[] BC000V15_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] BC000V15_A1546LiqLegHorasSem ;
   private byte[] BC000V15_A1780LiqLegAuxEstado ;
   private String[] BC000V15_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V15_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V15_A1816LiqLegFecIng ;
   private String[] BC000V15_A2113LiqLegCatCodigo ;
   private String[] BC000V15_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V15_A2114LiqLegSueldo ;
   private String[] BC000V15_A2179LiqLegPDFEstado ;
   private boolean[] BC000V15_n2179LiqLegPDFEstado ;
   private byte[] BC000V15_A2268LiqLegProcesado ;
   private byte[] BC000V15_A2360LiqLegNivLiq ;
   private String[] BC000V15_A2393LiqLegHtml ;
   private byte[] BC000V15_A2400LiqLegLSD ;
   private String[] BC000V15_A2401LiqLegDaemonUUID ;
   private boolean[] BC000V15_n2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V15_A2402LiqLegFecHor ;
   private int[] BC000V15_A3CliCod ;
   private short[] BC000V15_A1EmpCod ;
   private int[] BC000V15_A6LegNumero ;
   private int[] BC000V15_A31LiqNro ;
   private String[] BC000V15_A34LiqSecCodigo ;
   private boolean[] BC000V15_n34LiqSecCodigo ;
   private java.math.BigDecimal[] BC000V16_A281LiqLegImpTotal ;
   private int[] BC000V16_A282LiqLegReciboNro ;
   private String[] BC000V16_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V16_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V16_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V16_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V16_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V16_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V16_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V16_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V16_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V16_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V16_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V16_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V16_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V16_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V16_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V16_A761LiqLegGNSI ;
   private String[] BC000V16_A590LiqRutaPDF ;
   private String[] BC000V16_A774LiqRutaPDFVertical ;
   private short[] BC000V16_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V16_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V16_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V16_A1496LieqLegSegUpd ;
   private String[] BC000V16_A891LiqLegError ;
   private String[] BC000V16_A961LiqNombrePDF ;
   private String[] BC000V16_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] BC000V16_A1546LiqLegHorasSem ;
   private byte[] BC000V16_A1780LiqLegAuxEstado ;
   private String[] BC000V16_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V16_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V16_A1816LiqLegFecIng ;
   private String[] BC000V16_A2113LiqLegCatCodigo ;
   private String[] BC000V16_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V16_A2114LiqLegSueldo ;
   private String[] BC000V16_A2179LiqLegPDFEstado ;
   private boolean[] BC000V16_n2179LiqLegPDFEstado ;
   private byte[] BC000V16_A2268LiqLegProcesado ;
   private byte[] BC000V16_A2360LiqLegNivLiq ;
   private String[] BC000V16_A2393LiqLegHtml ;
   private byte[] BC000V16_A2400LiqLegLSD ;
   private String[] BC000V16_A2401LiqLegDaemonUUID ;
   private boolean[] BC000V16_n2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V16_A2402LiqLegFecHor ;
   private int[] BC000V16_A3CliCod ;
   private short[] BC000V16_A1EmpCod ;
   private int[] BC000V16_A6LegNumero ;
   private int[] BC000V16_A31LiqNro ;
   private String[] BC000V16_A34LiqSecCodigo ;
   private boolean[] BC000V16_n34LiqSecCodigo ;
   private String[] BC000V20_A2EmpNom ;
   private java.util.Date[] BC000V21_A283LiqPeriodo ;
   private String[] BC000V21_A32TLiqCod ;
   private boolean[] BC000V21_n32TLiqCod ;
   private String[] BC000V22_A250LegIdNomApe ;
   private String[] BC000V22_A93LegId ;
   private boolean[] BC000V22_n93LegId ;
   private String[] BC000V22_A251LegNombre ;
   private String[] BC000V22_A230LegApellido ;
   private String[] BC000V23_A284LiqSecDescrip ;
   private int[] BC000V24_A3CliCod ;
   private short[] BC000V24_A1EmpCod ;
   private int[] BC000V24_A6LegNumero ;
   private String[] BC000V24_A2243LegCuenLicTpo ;
   private short[] BC000V24_A2266LegCuenAnio ;
   private short[] BC000V24_A2310LegCuLConsAnio ;
   private short[] BC000V24_A2311LegCuLConsSec ;
   private int[] BC000V25_A3CliCod ;
   private short[] BC000V25_A1EmpCod ;
   private int[] BC000V25_A6LegNumero ;
   private String[] BC000V25_A2243LegCuenLicTpo ;
   private short[] BC000V25_A2266LegCuenAnio ;
   private java.util.Date[] BC000V25_A2324LegCuLAprLicFch ;
   private int[] BC000V26_A3CliCod ;
   private short[] BC000V26_A1EmpCod ;
   private int[] BC000V26_A6LegNumero ;
   private java.util.Date[] BC000V26_A2253LegHisFecIng ;
   private int[] BC000V27_A3CliCod ;
   private short[] BC000V27_A1EmpCod ;
   private int[] BC000V27_A31LiqNro ;
   private int[] BC000V27_A6LegNumero ;
   private String[] BC000V27_A2094LiqDetForCon ;
   private String[] BC000V27_A2095LiqDetForOpe ;
   private String[] BC000V27_A2096LiqDetForOpeCod ;
   private int[] BC000V28_A3CliCod ;
   private short[] BC000V28_A1EmpCod ;
   private int[] BC000V28_A31LiqNro ;
   private int[] BC000V28_A6LegNumero ;
   private String[] BC000V28_A1035LiqDOpeOrig ;
   private int[] BC000V29_A3CliCod ;
   private short[] BC000V29_A1EmpCod ;
   private int[] BC000V29_A31LiqNro ;
   private int[] BC000V29_A6LegNumero ;
   private short[] BC000V29_A1541LiqAjuNro ;
   private int[] BC000V30_A3CliCod ;
   private short[] BC000V30_A1EmpCod ;
   private int[] BC000V30_A6LegNumero ;
   private short[] BC000V30_A1172OblSecuencial ;
   private int[] BC000V30_A1184LiqOblAltaNro ;
   private int[] BC000V30_A1185LiqOblNuevaNro ;
   private int[] BC000V31_A3CliCod ;
   private short[] BC000V31_A1EmpCod ;
   private int[] BC000V31_A6LegNumero ;
   private short[] BC000V31_A1172OblSecuencial ;
   private int[] BC000V31_A1184LiqOblAltaNro ;
   private int[] BC000V31_A1185LiqOblNuevaNro ;
   private int[] BC000V32_A3CliCod ;
   private short[] BC000V32_A1EmpCod ;
   private int[] BC000V32_A6LegNumero ;
   private short[] BC000V32_A1172OblSecuencial ;
   private int[] BC000V33_A3CliCod ;
   private short[] BC000V33_A1EmpCod ;
   private short[] BC000V33_A1129LiqExAnio ;
   private int[] BC000V33_A31LiqNro ;
   private int[] BC000V33_A6LegNumero ;
   private String[] BC000V33_A1127LiqExenConCodigo ;
   private short[] BC000V33_A1128LiqExAplIIGG ;
   private int[] BC000V34_A3CliCod ;
   private short[] BC000V34_A1EmpCod ;
   private short[] BC000V34_A869LiqLegConAnio ;
   private int[] BC000V34_A6LegNumero ;
   private String[] BC000V34_A26ConCodigo ;
   private int[] BC000V34_A1097LiqAltaNro ;
   private int[] BC000V34_A1098LiqNuevaNro ;
   private int[] BC000V35_A3CliCod ;
   private short[] BC000V35_A1EmpCod ;
   private short[] BC000V35_A869LiqLegConAnio ;
   private int[] BC000V35_A6LegNumero ;
   private String[] BC000V35_A26ConCodigo ;
   private int[] BC000V35_A1097LiqAltaNro ;
   private int[] BC000V35_A1098LiqNuevaNro ;
   private int[] BC000V36_A3CliCod ;
   private short[] BC000V36_A1EmpCod ;
   private int[] BC000V36_A31LiqNro ;
   private int[] BC000V36_A6LegNumero ;
   private short[] BC000V36_A721TestLiqDSecuencial ;
   private int[] BC000V37_A3CliCod ;
   private short[] BC000V37_A1EmpCod ;
   private int[] BC000V37_A31LiqNro ;
   private int[] BC000V37_A6LegNumero ;
   private int[] BC000V37_A81LiqDSecuencial ;
   private int[] BC000V38_A3CliCod ;
   private short[] BC000V38_A1EmpCod ;
   private int[] BC000V38_A6LegNumero ;
   private short[] BC000V38_A25AgeOrden ;
   private String[] BC000V39_A250LegIdNomApe ;
   private String[] BC000V39_A2EmpNom ;
   private java.math.BigDecimal[] BC000V39_A281LiqLegImpTotal ;
   private String[] BC000V39_A284LiqSecDescrip ;
   private int[] BC000V39_A282LiqLegReciboNro ;
   private String[] BC000V39_A93LegId ;
   private boolean[] BC000V39_n93LegId ;
   private String[] BC000V39_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V39_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V39_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V39_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V39_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V39_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V39_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V39_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V39_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V39_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V39_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V39_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V39_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V39_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V39_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V39_A761LiqLegGNSI ;
   private String[] BC000V39_A590LiqRutaPDF ;
   private String[] BC000V39_A774LiqRutaPDFVertical ;
   private short[] BC000V39_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V39_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V39_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V39_A1496LieqLegSegUpd ;
   private String[] BC000V39_A891LiqLegError ;
   private java.util.Date[] BC000V39_A283LiqPeriodo ;
   private String[] BC000V39_A961LiqNombrePDF ;
   private String[] BC000V39_A962LiqNombrePDFVertical ;
   private String[] BC000V39_A32TLiqCod ;
   private boolean[] BC000V39_n32TLiqCod ;
   private java.math.BigDecimal[] BC000V39_A1546LiqLegHorasSem ;
   private byte[] BC000V39_A1780LiqLegAuxEstado ;
   private String[] BC000V39_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V39_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V39_A1816LiqLegFecIng ;
   private String[] BC000V39_A2113LiqLegCatCodigo ;
   private String[] BC000V39_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V39_A2114LiqLegSueldo ;
   private String[] BC000V39_A2179LiqLegPDFEstado ;
   private boolean[] BC000V39_n2179LiqLegPDFEstado ;
   private byte[] BC000V39_A2268LiqLegProcesado ;
   private byte[] BC000V39_A2360LiqLegNivLiq ;
   private String[] BC000V39_A2393LiqLegHtml ;
   private byte[] BC000V39_A2400LiqLegLSD ;
   private String[] BC000V39_A2401LiqLegDaemonUUID ;
   private boolean[] BC000V39_n2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V39_A2402LiqLegFecHor ;
   private String[] BC000V39_A251LegNombre ;
   private String[] BC000V39_A230LegApellido ;
   private int[] BC000V39_A3CliCod ;
   private short[] BC000V39_A1EmpCod ;
   private int[] BC000V39_A6LegNumero ;
   private int[] BC000V39_A31LiqNro ;
   private String[] BC000V39_A34LiqSecCodigo ;
   private boolean[] BC000V39_n34LiqSecCodigo ;
   private String[] BC000V40_A2EmpNom ;
   private java.util.Date[] BC000V41_A283LiqPeriodo ;
   private String[] BC000V41_A32TLiqCod ;
   private boolean[] BC000V41_n32TLiqCod ;
   private String[] BC000V42_A250LegIdNomApe ;
   private String[] BC000V42_A93LegId ;
   private boolean[] BC000V42_n93LegId ;
   private String[] BC000V42_A251LegNombre ;
   private String[] BC000V42_A230LegApellido ;
   private String[] BC000V43_A2EmpNom ;
   private java.util.Date[] BC000V44_A283LiqPeriodo ;
   private String[] BC000V44_A32TLiqCod ;
   private boolean[] BC000V44_n32TLiqCod ;
   private String[] BC000V45_A250LegIdNomApe ;
   private String[] BC000V45_A93LegId ;
   private boolean[] BC000V45_n93LegId ;
   private String[] BC000V45_A251LegNombre ;
   private String[] BC000V45_A230LegApellido ;
   private java.math.BigDecimal[] BC000V2_A281LiqLegImpTotal ;
   private int[] BC000V2_A282LiqLegReciboNro ;
   private String[] BC000V2_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V2_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V2_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V2_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V2_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V2_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V2_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V2_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V2_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V2_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V2_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V2_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V2_A761LiqLegGNSI ;
   private String[] BC000V2_A590LiqRutaPDF ;
   private String[] BC000V2_A774LiqRutaPDFVertical ;
   private short[] BC000V2_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V2_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V2_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V2_A1496LieqLegSegUpd ;
   private String[] BC000V2_A891LiqLegError ;
   private String[] BC000V2_A961LiqNombrePDF ;
   private String[] BC000V2_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] BC000V2_A1546LiqLegHorasSem ;
   private byte[] BC000V2_A1780LiqLegAuxEstado ;
   private String[] BC000V2_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V2_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V2_A1816LiqLegFecIng ;
   private String[] BC000V2_A2113LiqLegCatCodigo ;
   private String[] BC000V2_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V2_A2114LiqLegSueldo ;
   private String[] BC000V2_A2179LiqLegPDFEstado ;
   private byte[] BC000V2_A2268LiqLegProcesado ;
   private byte[] BC000V2_A2360LiqLegNivLiq ;
   private String[] BC000V2_A2393LiqLegHtml ;
   private byte[] BC000V2_A2400LiqLegLSD ;
   private String[] BC000V2_A2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V2_A2402LiqLegFecHor ;
   private int[] BC000V2_A3CliCod ;
   private short[] BC000V2_A1EmpCod ;
   private int[] BC000V2_A6LegNumero ;
   private int[] BC000V2_A31LiqNro ;
   private String[] BC000V2_A34LiqSecCodigo ;
   private java.util.Date[] BC000V2_A283LiqPeriodo ;
   private String[] BC000V2_A32TLiqCod ;
   private java.math.BigDecimal[] BC000V3_A281LiqLegImpTotal ;
   private int[] BC000V3_A282LiqLegReciboNro ;
   private String[] BC000V3_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] BC000V3_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] BC000V3_A759LiqLegImpTotBruSinSAC ;
   private short[] BC000V3_A499LiqLegCntConc ;
   private java.math.BigDecimal[] BC000V3_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] BC000V3_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] BC000V3_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] BC000V3_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] BC000V3_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] BC000V3_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] BC000V3_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] BC000V3_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] BC000V3_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] BC000V3_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] BC000V3_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] BC000V3_A761LiqLegGNSI ;
   private String[] BC000V3_A590LiqRutaPDF ;
   private String[] BC000V3_A774LiqRutaPDFVertical ;
   private short[] BC000V3_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] BC000V3_A884LiqLegSegundos ;
   private java.math.BigDecimal[] BC000V3_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] BC000V3_A1496LieqLegSegUpd ;
   private String[] BC000V3_A891LiqLegError ;
   private String[] BC000V3_A961LiqNombrePDF ;
   private String[] BC000V3_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] BC000V3_A1546LiqLegHorasSem ;
   private byte[] BC000V3_A1780LiqLegAuxEstado ;
   private String[] BC000V3_A1781LiqLegErrorAux ;
   private java.util.Date[] BC000V3_A1815LiqLegFecEgr ;
   private java.util.Date[] BC000V3_A1816LiqLegFecIng ;
   private String[] BC000V3_A2113LiqLegCatCodigo ;
   private String[] BC000V3_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] BC000V3_A2114LiqLegSueldo ;
   private String[] BC000V3_A2179LiqLegPDFEstado ;
   private byte[] BC000V3_A2268LiqLegProcesado ;
   private byte[] BC000V3_A2360LiqLegNivLiq ;
   private String[] BC000V3_A2393LiqLegHtml ;
   private byte[] BC000V3_A2400LiqLegLSD ;
   private String[] BC000V3_A2401LiqLegDaemonUUID ;
   private java.util.Date[] BC000V3_A2402LiqLegFecHor ;
   private int[] BC000V3_A3CliCod ;
   private short[] BC000V3_A1EmpCod ;
   private int[] BC000V3_A6LegNumero ;
   private int[] BC000V3_A31LiqNro ;
   private String[] BC000V3_A34LiqSecCodigo ;
   private java.util.Date[] BC000V3_A283LiqPeriodo ;
   private String[] BC000V3_A32TLiqCod ;
   private String[] BC000V4_A2EmpNom ;
   private String[] BC000V5_A250LegIdNomApe ;
   private String[] BC000V5_A93LegId ;
   private String[] BC000V5_A251LegNombre ;
   private String[] BC000V5_A230LegApellido ;
   private java.util.Date[] BC000V6_A283LiqPeriodo ;
   private String[] BC000V6_A32TLiqCod ;
   private String[] BC000V7_A284LiqSecDescrip ;
   private boolean[] BC000V2_n2179LiqLegPDFEstado ;
   private boolean[] BC000V2_n2401LiqLegDaemonUUID ;
   private boolean[] BC000V2_n34LiqSecCodigo ;
   private boolean[] BC000V2_n32TLiqCod ;
   private boolean[] BC000V3_n2179LiqLegPDFEstado ;
   private boolean[] BC000V3_n2401LiqLegDaemonUUID ;
   private boolean[] BC000V3_n34LiqSecCodigo ;
   private boolean[] BC000V3_n32TLiqCod ;
   private boolean[] BC000V5_n93LegId ;
   private boolean[] BC000V6_n32TLiqCod ;
}

final  class liquidacionlegajo_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000V2", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo, LiqPeriodo, TLiqCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V3", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo, LiqPeriodo, TLiqCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V4", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V5", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V6", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V7", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V8", "SELECT T3.LegIdNomApe, T2.EmpNom, TM1.LiqLegImpTotal, T4.SecDescrip AS LiqSecDescrip, TM1.LiqLegReciboNro, T3.LegId, TM1.LegLiqDatosHis, TM1.LiqLegImpTotBruto, TM1.LiqLegImpTotBruSinSAC, TM1.LiqLegCntConc, TM1.LiqLegImpTotRemu, TM1.LiqLegImpTotNoRemu, TM1.LiqLegImpTotDescu, TM1.LiqLegImpContr, TM1.LiqLegImpCosto, TM1.LiqLegImpOtrDescu, TM1.LiqLegImpDescuNeg, TM1.LiqLegImpTotRetGan, TM1.LiqLegImpPagosACuen, TM1.LiqLegImpTotBruProm, TM1.LiqLegImpBasico, TM1.LiqLegGNSI, TM1.LiqRutaPDF, TM1.LiqRutaPDFVertical, TM1.LIqLegIteraciones, TM1.LiqLegSegundos, TM1.LiqLegSegIns, TM1.LieqLegSegUpd, TM1.LiqLegError, TM1.LiqPeriodo, TM1.LiqNombrePDF, TM1.LiqNombrePDFVertical, TM1.TLiqCod, TM1.LiqLegHorasSem, TM1.LiqLegAuxEstado, TM1.LiqLegErrorAux, TM1.LiqLegFecEgr, TM1.LiqLegFecIng, TM1.LiqLegCatCodigo, TM1.LiqLegConvenio, TM1.LiqLegSueldo, TM1.LiqLegPDFEstado, TM1.LiqLegProcesado, TM1.LiqLegNivLiq, TM1.LiqLegHtml, TM1.LiqLegLSD, TM1.LiqLegDaemonUUID, TM1.LiqLegFecHor, T3.LegNombre, T3.LegApellido, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqNro, TM1.LiqSecCodigo AS LiqSecCodigo FROM (((LiquidacionLegajo TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) LEFT JOIN Seccion T4 ON T4.CliCod = TM1.CliCod AND T4.SecCodigo = TM1.LiqSecCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V9", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V10", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V11", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V12", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V13", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V14", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V15", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V16", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000V17", "SAVEPOINT gxupdate;INSERT INTO LiquidacionLegajo(LiqPeriodo, TLiqCod, LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000V18", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqPeriodo=?, TLiqCod=?, LiqLegImpTotal=?, LiqLegReciboNro=?, LegLiqDatosHis=?, LiqLegImpTotBruto=?, LiqLegImpTotBruSinSAC=?, LiqLegCntConc=?, LiqLegImpTotRemu=?, LiqLegImpTotNoRemu=?, LiqLegImpTotDescu=?, LiqLegImpContr=?, LiqLegImpCosto=?, LiqLegImpOtrDescu=?, LiqLegImpDescuNeg=?, LiqLegImpTotRetGan=?, LiqLegImpPagosACuen=?, LiqLegImpTotBruProm=?, LiqLegImpBasico=?, LiqLegGNSI=?, LiqRutaPDF=?, LiqRutaPDFVertical=?, LIqLegIteraciones=?, LiqLegSegundos=?, LiqLegSegIns=?, LieqLegSegUpd=?, LiqLegError=?, LiqNombrePDF=?, LiqNombrePDFVertical=?, LiqLegHorasSem=?, LiqLegAuxEstado=?, LiqLegErrorAux=?, LiqLegFecEgr=?, LiqLegFecIng=?, LiqLegCatCodigo=?, LiqLegConvenio=?, LiqLegSueldo=?, LiqLegPDFEstado=?, LiqLegProcesado=?, LiqLegNivLiq=?, LiqLegHtml=?, LiqLegLSD=?, LiqLegDaemonUUID=?, LiqLegFecHor=?, LiqSecCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000V19", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajo  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000V20", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V21", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V22", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V23", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V24", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegCulConsLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V25", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegCuLAprLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V26", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegHisLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V27", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDetForCon, LiqDetForOpe, LiqDetForOpeCod FROM LiqDetForOperandos WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V28", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDOpeOrig FROM liquidacionLegajoCalculos WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V29", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V30", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblNuevaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V31", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblAltaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V32", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND OblLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V33", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V34", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqNuevaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V35", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqAltaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V36", "SELECT CliCod, EmpCod, LiqNro, LegNumero, TestLiqDSecuencial FROM TestTable WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V37", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V38", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND AgeLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000V39", "SELECT T3.LegIdNomApe, T2.EmpNom, TM1.LiqLegImpTotal, T4.SecDescrip AS LiqSecDescrip, TM1.LiqLegReciboNro, T3.LegId, TM1.LegLiqDatosHis, TM1.LiqLegImpTotBruto, TM1.LiqLegImpTotBruSinSAC, TM1.LiqLegCntConc, TM1.LiqLegImpTotRemu, TM1.LiqLegImpTotNoRemu, TM1.LiqLegImpTotDescu, TM1.LiqLegImpContr, TM1.LiqLegImpCosto, TM1.LiqLegImpOtrDescu, TM1.LiqLegImpDescuNeg, TM1.LiqLegImpTotRetGan, TM1.LiqLegImpPagosACuen, TM1.LiqLegImpTotBruProm, TM1.LiqLegImpBasico, TM1.LiqLegGNSI, TM1.LiqRutaPDF, TM1.LiqRutaPDFVertical, TM1.LIqLegIteraciones, TM1.LiqLegSegundos, TM1.LiqLegSegIns, TM1.LieqLegSegUpd, TM1.LiqLegError, TM1.LiqPeriodo, TM1.LiqNombrePDF, TM1.LiqNombrePDFVertical, TM1.TLiqCod, TM1.LiqLegHorasSem, TM1.LiqLegAuxEstado, TM1.LiqLegErrorAux, TM1.LiqLegFecEgr, TM1.LiqLegFecIng, TM1.LiqLegCatCodigo, TM1.LiqLegConvenio, TM1.LiqLegSueldo, TM1.LiqLegPDFEstado, TM1.LiqLegProcesado, TM1.LiqLegNivLiq, TM1.LiqLegHtml, TM1.LiqLegLSD, TM1.LiqLegDaemonUUID, TM1.LiqLegFecHor, T3.LegNombre, T3.LegApellido, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqNro, TM1.LiqSecCodigo AS LiqSecCodigo FROM (((LiquidacionLegajo TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) LEFT JOIN Seccion T4 ON T4.CliCod = TM1.CliCod AND T4.SecCodigo = TM1.LiqSecCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V40", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V41", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V42", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V43", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V44", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V45", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(48);
               ((String[]) buf[51])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(48);
               ((String[]) buf[51])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((short[]) buf[25])[0] = rslt.getShort(25);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(26,6);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(27,6);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(28,6);
               ((String[]) buf[29])[0] = rslt.getVarchar(29);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(30);
               ((String[]) buf[31])[0] = rslt.getString(31, 200);
               ((String[]) buf[32])[0] = rslt.getString(32, 200);
               ((String[]) buf[33])[0] = rslt.getString(33, 20);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,1);
               ((byte[]) buf[36])[0] = rslt.getByte(35);
               ((String[]) buf[37])[0] = rslt.getVarchar(36);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(38);
               ((String[]) buf[40])[0] = rslt.getString(39, 40);
               ((String[]) buf[41])[0] = rslt.getString(40, 20);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(41,2);
               ((String[]) buf[43])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((byte[]) buf[45])[0] = rslt.getByte(43);
               ((byte[]) buf[46])[0] = rslt.getByte(44);
               ((String[]) buf[47])[0] = rslt.getLongVarchar(45);
               ((byte[]) buf[48])[0] = rslt.getByte(46);
               ((String[]) buf[49])[0] = rslt.getString(47, 36);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[51])[0] = rslt.getGXDateTime(48);
               ((String[]) buf[52])[0] = rslt.getVarchar(49);
               ((String[]) buf[53])[0] = rslt.getVarchar(50);
               ((int[]) buf[54])[0] = rslt.getInt(51);
               ((short[]) buf[55])[0] = rslt.getShort(52);
               ((int[]) buf[56])[0] = rslt.getInt(53);
               ((int[]) buf[57])[0] = rslt.getInt(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               return;
            case 7 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 10 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 13 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               return;
            case 14 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 100);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((short[]) buf[25])[0] = rslt.getShort(25);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(26,6);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(27,6);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(28,6);
               ((String[]) buf[29])[0] = rslt.getVarchar(29);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(30);
               ((String[]) buf[31])[0] = rslt.getString(31, 200);
               ((String[]) buf[32])[0] = rslt.getString(32, 200);
               ((String[]) buf[33])[0] = rslt.getString(33, 20);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,1);
               ((byte[]) buf[36])[0] = rslt.getByte(35);
               ((String[]) buf[37])[0] = rslt.getVarchar(36);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(38);
               ((String[]) buf[40])[0] = rslt.getString(39, 40);
               ((String[]) buf[41])[0] = rslt.getString(40, 20);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(41,2);
               ((String[]) buf[43])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((byte[]) buf[45])[0] = rslt.getByte(43);
               ((byte[]) buf[46])[0] = rslt.getByte(44);
               ((String[]) buf[47])[0] = rslt.getLongVarchar(45);
               ((byte[]) buf[48])[0] = rslt.getByte(46);
               ((String[]) buf[49])[0] = rslt.getString(47, 36);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[51])[0] = rslt.getGXDateTime(48);
               ((String[]) buf[52])[0] = rslt.getVarchar(49);
               ((String[]) buf[53])[0] = rslt.getVarchar(50);
               ((int[]) buf[54])[0] = rslt.getInt(51);
               ((short[]) buf[55])[0] = rslt.getShort(52);
               ((int[]) buf[56])[0] = rslt.getInt(53);
               ((int[]) buf[57])[0] = rslt.getInt(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               return;
            case 38 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 39 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 42 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 15 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setVarchar(5, (String)parms[5], 4000, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[20], 2);
               stmt.setVarchar(21, (String)parms[21], 400, false);
               stmt.setVarchar(22, (String)parms[22], 400, false);
               stmt.setShort(23, ((Number) parms[23]).shortValue());
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[24], 6);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[25], 6);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[26], 6);
               stmt.setVarchar(27, (String)parms[27], 400, false);
               stmt.setString(28, (String)parms[28], 200);
               stmt.setString(29, (String)parms[29], 200);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[30], 1);
               stmt.setByte(31, ((Number) parms[31]).byteValue());
               stmt.setVarchar(32, (String)parms[32], 400, false);
               stmt.setDate(33, (java.util.Date)parms[33]);
               stmt.setDate(34, (java.util.Date)parms[34]);
               stmt.setString(35, (String)parms[35], 40);
               stmt.setString(36, (String)parms[36], 20);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[37], 2);
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[39], 20);
               }
               stmt.setByte(39, ((Number) parms[40]).byteValue());
               stmt.setByte(40, ((Number) parms[41]).byteValue());
               stmt.setNLongVarchar(41, (String)parms[42], false);
               stmt.setByte(42, ((Number) parms[43]).byteValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[45], 36);
               }
               stmt.setDateTime(44, (java.util.Date)parms[46], false);
               stmt.setInt(45, ((Number) parms[47]).intValue());
               stmt.setShort(46, ((Number) parms[48]).shortValue());
               stmt.setInt(47, ((Number) parms[49]).intValue());
               stmt.setInt(48, ((Number) parms[50]).intValue());
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(49, (String)parms[52], 20);
               }
               return;
            case 16 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setVarchar(5, (String)parms[5], 4000, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[20], 2);
               stmt.setVarchar(21, (String)parms[21], 400, false);
               stmt.setVarchar(22, (String)parms[22], 400, false);
               stmt.setShort(23, ((Number) parms[23]).shortValue());
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[24], 6);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[25], 6);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[26], 6);
               stmt.setVarchar(27, (String)parms[27], 400, false);
               stmt.setString(28, (String)parms[28], 200);
               stmt.setString(29, (String)parms[29], 200);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[30], 1);
               stmt.setByte(31, ((Number) parms[31]).byteValue());
               stmt.setVarchar(32, (String)parms[32], 400, false);
               stmt.setDate(33, (java.util.Date)parms[33]);
               stmt.setDate(34, (java.util.Date)parms[34]);
               stmt.setString(35, (String)parms[35], 40);
               stmt.setString(36, (String)parms[36], 20);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[37], 2);
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[39], 20);
               }
               stmt.setByte(39, ((Number) parms[40]).byteValue());
               stmt.setByte(40, ((Number) parms[41]).byteValue());
               stmt.setNLongVarchar(41, (String)parms[42], false);
               stmt.setByte(42, ((Number) parms[43]).byteValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[45], 36);
               }
               stmt.setDateTime(44, (java.util.Date)parms[46], false);
               if ( ((Boolean) parms[47]).booleanValue() )
               {
                  stmt.setNull( 45 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(45, (String)parms[48], 20);
               }
               stmt.setInt(46, ((Number) parms[49]).intValue());
               stmt.setShort(47, ((Number) parms[50]).shortValue());
               stmt.setInt(48, ((Number) parms[51]).intValue());
               stmt.setInt(49, ((Number) parms[52]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 21 :
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
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

