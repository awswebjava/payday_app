package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculaimporteliquidacionlegajoasync extends GXProcedure
{
   public calculaimporteliquidacionlegajoasync( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculaimporteliquidacionlegajoasync.class ), "" );
   }

   public calculaimporteliquidacionlegajoasync( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 )
   {
      calculaimporteliquidacionlegajoasync.this.AV12CliCod = aP0;
      calculaimporteliquidacionlegajoasync.this.AV25EmpCod = aP1;
      calculaimporteliquidacionlegajoasync.this.AV48LiqNro = aP2;
      calculaimporteliquidacionlegajoasync.this.AV71coll_LegNumero = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13completa = true ;
      GXt_char1 = AV53retGanConCodigo ;
      GXt_char2 = AV53retGanConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char2, GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char1 = GXv_char4[0] ;
      AV53retGanConCodigo = GXt_char1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "&retGanConCodigo ", "")+AV53retGanConCodigo) ;
      GXt_char2 = AV8adelantoRetGanConCodigo ;
      GXt_char1 = AV8adelantoRetGanConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char3[0] ;
      AV8adelantoRetGanConCodigo = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "&adelantoRetGanConCodigo  ", "")+AV8adelantoRetGanConCodigo) ;
      GXt_char2 = AV22DevGanConCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.conceptodevolucionganancias(remoteHandle, context).execute( AV12CliCod, GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char4[0] ;
      AV22DevGanConCodigo = GXt_char2 ;
      GXt_char2 = AV22DevGanConCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.conceptodevolucionganancias(remoteHandle, context).execute( AV12CliCod, GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char4[0] ;
      AV22DevGanConCodigo = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "&&DevGanConCodigo  ", "")+AV22DevGanConCodigo) ;
      GXt_char2 = AV50pagosAcuentaConCodigo ;
      GXt_char1 = AV50pagosAcuentaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char3[0] ;
      AV50pagosAcuentaConCodigo = GXt_char2 ;
      GXv_char4[0] = AV54sacConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.concepto_sac_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.AV54sacConCodigo = GXv_char4[0] ;
      GXv_char4[0] = AV56sacproporConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.concepto_sacpropor_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.AV56sacproporConCodigo = GXv_char4[0] ;
      GXv_char4[0] = AV57sobregiro ;
      GXv_char3[0] = AV27errorSobreGiro ;
      new web.conceptosobregiro(remoteHandle, context).execute( AV12CliCod, GXv_char4, GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.AV57sobregiro = GXv_char4[0] ;
      calculaimporteliquidacionlegajoasync.this.AV27errorSobreGiro = GXv_char3[0] ;
      GXt_char2 = AV62TliqCodAguinaldo ;
      GXt_char1 = AV62TliqCodAguinaldo ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char3[0] ;
      AV62TliqCodAguinaldo = GXt_char2 ;
      GXt_char2 = AV63TLiqCodVacaciones ;
      GXt_char1 = AV63TLiqCodVacaciones ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char3[0] ;
      AV63TLiqCodVacaciones = GXt_char2 ;
      AV36LiqImpNeto = DecimalUtil.ZERO ;
      AV35LiqImpBruto = DecimalUtil.ZERO ;
      AV83GXLvl35 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(A6LegNumero) ,
                                           AV71coll_LegNumero ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV25EmpCod) ,
                                           Integer.valueOf(AV48LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02DG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV48LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02DG2_A6LegNumero[0] ;
         A31LiqNro = P02DG2_A31LiqNro[0] ;
         A1EmpCod = P02DG2_A1EmpCod[0] ;
         A3CliCod = P02DG2_A3CliCod[0] ;
         A760LiqLegImpBasico = P02DG2_A760LiqLegImpBasico[0] ;
         A281LiqLegImpTotal = P02DG2_A281LiqLegImpTotal[0] ;
         A498LiqLegImpTotBruto = P02DG2_A498LiqLegImpTotBruto[0] ;
         A32TLiqCod = P02DG2_A32TLiqCod[0] ;
         n32TLiqCod = P02DG2_n32TLiqCod[0] ;
         A759LiqLegImpTotBruSinSAC = P02DG2_A759LiqLegImpTotBruSinSAC[0] ;
         A577LiqLegImpTotRemu = P02DG2_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = P02DG2_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = P02DG2_A579LiqLegImpTotDescu[0] ;
         A1143LiqLegImpDescuNeg = P02DG2_A1143LiqLegImpDescuNeg[0] ;
         A1131LiqLegImpOtrDescu = P02DG2_A1131LiqLegImpOtrDescu[0] ;
         A775LiqLegImpPagosACuen = P02DG2_A775LiqLegImpPagosACuen[0] ;
         A757LiqLegImpTotRetGan = P02DG2_A757LiqLegImpTotRetGan[0] ;
         A758LiqLegImpTotBruProm = P02DG2_A758LiqLegImpTotBruProm[0] ;
         A499LiqLegCntConc = P02DG2_A499LiqLegCntConc[0] ;
         A891LiqLegError = P02DG2_A891LiqLegError[0] ;
         A2268LiqLegProcesado = P02DG2_A2268LiqLegProcesado[0] ;
         AV83GXLvl35 = (byte)(1) ;
         AV32LegNumero = A6LegNumero ;
         AV39LiqLegImpBasico = DecimalUtil.ZERO ;
         AV77LiqLegImpTotRemu = DecimalUtil.ZERO ;
         AV78LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
         AV79LiqLegImpTotDescu = DecimalUtil.ZERO ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "---> iniciliza cero", "")) ;
         AV37LiqLegCntConc = (short)(0) ;
         AV47LiqLegImpTotRetGan = DecimalUtil.ZERO ;
         AV41LiqLegImpCosto = DecimalUtil.ZERO ;
         AV43LiqLegImpOtrDescu = DecimalUtil.ZERO ;
         AV44LiqLegImpPagosACuen = DecimalUtil.ZERO ;
         AV55sacImportes = DecimalUtil.ZERO ;
         AV65totalRestanImportes = DecimalUtil.ZERO ;
         AV66totalSumanImportes = DecimalUtil.ZERO ;
         AV18descuentosNegativos = DecimalUtil.ZERO ;
         /* Execute user subroutine: 'CALCULALEGAJO' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV10bruto = AV77LiqLegImpTotRemu.add(AV78LiqLegImpTotNoRemu) ;
         AV64TotalNeto = AV77LiqLegImpTotRemu.add(AV78LiqLegImpTotNoRemu).subtract(AV79LiqLegImpTotDescu).add(AV18descuentosNegativos) ;
         AV46LiqLegImpTotBruto = AV77LiqLegImpTotRemu.add(AV78LiqLegImpTotNoRemu).add(AV18descuentosNegativos) ;
         if ( AV64TotalNeto.doubleValue() >= 0 )
         {
            AV31ImporteRedondeado = AV64TotalNeto ;
         }
         else
         {
            AV23diferencia = AV65totalRestanImportes.add(AV66totalSumanImportes) ;
            if ( AV23diferencia.doubleValue() < 0 )
            {
               AV23diferencia = AV23diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "diferencia ", "")+GXutil.trim( GXutil.str( AV23diferencia, 14, 2))+httpContext.getMessage( " total restan ", "")+GXutil.trim( GXutil.str( AV65totalRestanImportes, 14, 2))+httpContext.getMessage( " total suman ", "")+GXutil.trim( GXutil.str( AV66totalSumanImportes, 14, 2))) ;
            /* Execute user subroutine: 'CARGACONCEPTOSOBREGIRO' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         A760LiqLegImpBasico = AV39LiqLegImpBasico ;
         A281LiqLegImpTotal = AV31ImporteRedondeado ;
         A498LiqLegImpTotBruto = AV46LiqLegImpTotBruto ;
         if ( ( GXutil.strcmp(A32TLiqCod, AV62TliqCodAguinaldo) != 0 ) && ( GXutil.strcmp(A32TLiqCod, AV63TLiqCodVacaciones) != 0 ) )
         {
            A759LiqLegImpTotBruSinSAC = AV46LiqLegImpTotBruto.subtract(AV55sacImportes) ;
         }
         else
         {
            A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
         }
         A577LiqLegImpTotRemu = AV77LiqLegImpTotRemu ;
         A578LiqLegImpTotNoRemu = AV78LiqLegImpTotNoRemu ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "---> &&LiqLegImpTotRemu ", "")+GXutil.trim( GXutil.str( AV77LiqLegImpTotRemu, 14, 2))) ;
         A579LiqLegImpTotDescu = AV79LiqLegImpTotDescu ;
         A1143LiqLegImpDescuNeg = AV18descuentosNegativos ;
         A1131LiqLegImpOtrDescu = AV43LiqLegImpOtrDescu ;
         A775LiqLegImpPagosACuen = AV44LiqLegImpPagosACuen ;
         A757LiqLegImpTotRetGan = AV47LiqLegImpTotRetGan ;
         GXv_char4[0] = AV60SueldoBrutoPromedioConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.concepto_brutopromedio_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         calculaimporteliquidacionlegajoasync.this.AV60SueldoBrutoPromedioConCodigo = GXv_char4[0] ;
         GXv_decimal5[0] = AV45LiqLegImpTotBruProm ;
         GXv_boolean6[0] = false ;
         GXv_int7[0] = (byte)(0) ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, AV32LegNumero, AV60SueldoBrutoPromedioConCodigo, "Calculo", false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         calculaimporteliquidacionlegajoasync.this.AV45LiqLegImpTotBruProm = GXv_decimal5[0] ;
         A758LiqLegImpTotBruProm = AV45LiqLegImpTotBruProm ;
         A499LiqLegCntConc = AV37LiqLegCntConc ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "&LiqLegCntConc ", "")+GXutil.trim( GXutil.str( AV37LiqLegCntConc, 4, 0))) ;
         if ( (0==AV37LiqLegCntConc) )
         {
            AV13completa = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV82Pgmname, httpContext.getMessage( "&completa = false", "")) ;
            if ( (GXutil.strcmp("", A891LiqLegError)==0) )
            {
               GXt_char2 = A891LiqLegError ;
               GXv_char4[0] = GXt_char2 ;
               new web.textoerrornohayimprimibles(remoteHandle, context).execute( AV12CliCod, GXv_char4) ;
               calculaimporteliquidacionlegajoasync.this.GXt_char2 = GXv_char4[0] ;
               A891LiqLegError = GXt_char2 ;
            }
            A2268LiqLegProcesado = (byte)(2) ;
         }
         AV36LiqImpNeto = AV36LiqImpNeto.add(AV31ImporteRedondeado) ;
         AV35LiqImpBruto = AV35LiqImpBruto.add(AV46LiqLegImpTotBruto) ;
         AV33LiqCntLeg = (short)(AV33LiqCntLeg+1) ;
         /* Using cursor P02DG3 */
         pr_default.execute(1, new Object[] {A760LiqLegImpBasico, A281LiqLegImpTotal, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1143LiqLegImpDescuNeg, A1131LiqLegImpOtrDescu, A775LiqLegImpPagosACuen, A757LiqLegImpTotRetGan, A758LiqLegImpTotBruProm, Short.valueOf(A499LiqLegCntConc), A891LiqLegError, Byte.valueOf(A2268LiqLegProcesado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV83GXLvl35 == 0 )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CALCULALEGAJO' Routine */
      returnInSub = false ;
      GXv_decimal5[0] = AV66totalSumanImportes ;
      GXv_decimal8[0] = AV18descuentosNegativos ;
      GXv_decimal9[0] = AV65totalRestanImportes ;
      GXv_decimal10[0] = AV47LiqLegImpTotRetGan ;
      GXv_decimal11[0] = AV43LiqLegImpOtrDescu ;
      GXv_decimal12[0] = AV44LiqLegImpPagosACuen ;
      GXv_decimal13[0] = AV55sacImportes ;
      GXv_decimal14[0] = AV39LiqLegImpBasico ;
      GXv_decimal15[0] = AV77LiqLegImpTotRemu ;
      GXv_decimal16[0] = AV78LiqLegImpTotNoRemu ;
      GXv_decimal17[0] = AV79LiqLegImpTotDescu ;
      GXv_int18[0] = AV37LiqLegCntConc ;
      new web.calculaimportesliqleg(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, AV32LegNumero, AV50pagosAcuentaConCodigo, AV54sacConCodigo, AV56sacproporConCodigo, GXv_decimal5, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_decimal12, GXv_decimal13, GXv_decimal14, GXv_decimal15, GXv_decimal16, GXv_decimal17, GXv_int18) ;
      calculaimporteliquidacionlegajoasync.this.AV66totalSumanImportes = GXv_decimal5[0] ;
      calculaimporteliquidacionlegajoasync.this.AV18descuentosNegativos = GXv_decimal8[0] ;
      calculaimporteliquidacionlegajoasync.this.AV65totalRestanImportes = GXv_decimal9[0] ;
      calculaimporteliquidacionlegajoasync.this.AV47LiqLegImpTotRetGan = GXv_decimal10[0] ;
      calculaimporteliquidacionlegajoasync.this.AV43LiqLegImpOtrDescu = GXv_decimal11[0] ;
      calculaimporteliquidacionlegajoasync.this.AV44LiqLegImpPagosACuen = GXv_decimal12[0] ;
      calculaimporteliquidacionlegajoasync.this.AV55sacImportes = GXv_decimal13[0] ;
      calculaimporteliquidacionlegajoasync.this.AV39LiqLegImpBasico = GXv_decimal14[0] ;
      calculaimporteliquidacionlegajoasync.this.AV77LiqLegImpTotRemu = GXv_decimal15[0] ;
      calculaimporteliquidacionlegajoasync.this.AV78LiqLegImpTotNoRemu = GXv_decimal16[0] ;
      calculaimporteliquidacionlegajoasync.this.AV79LiqLegImpTotDescu = GXv_decimal17[0] ;
      calculaimporteliquidacionlegajoasync.this.AV37LiqLegCntConc = GXv_int18[0] ;
   }

   public void S121( )
   {
      /* 'CARGACONCEPTOSOBREGIRO' Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV27errorSobreGiro)==0) )
      {
         AV84GXLvl145 = (byte)(0) ;
         /* Using cursor P02DG4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV48LiqNro), Integer.valueOf(AV32LegNumero), AV57sobregiro});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A394DConCodigo = P02DG4_A394DConCodigo[0] ;
            A6LegNumero = P02DG4_A6LegNumero[0] ;
            A31LiqNro = P02DG4_A31LiqNro[0] ;
            A1EmpCod = P02DG4_A1EmpCod[0] ;
            A3CliCod = P02DG4_A3CliCod[0] ;
            A502LiqDMostrar = P02DG4_A502LiqDMostrar[0] ;
            A275LiqDImpCalcu = P02DG4_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P02DG4_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P02DG4_A764LiqDImpReCalcu[0] ;
            A274LiqDFormula = P02DG4_A274LiqDFormula[0] ;
            n274LiqDFormula = P02DG4_n274LiqDFormula[0] ;
            A270LiqDErrorDesc = P02DG4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P02DG4_n270LiqDErrorDesc[0] ;
            A1072LiqDLogRecal = P02DG4_A1072LiqDLogRecal[0] ;
            A81LiqDSecuencial = P02DG4_A81LiqDSecuencial[0] ;
            AV84GXLvl145 = (byte)(1) ;
            A502LiqDMostrar = (byte)(3) ;
            A275LiqDImpCalcu = AV23diferencia ;
            n275LiqDImpCalcu = false ;
            A764LiqDImpReCalcu = AV23diferencia ;
            A274LiqDFormula = GXutil.trim( GXutil.str( AV23diferencia, 14, 2)) ;
            n274LiqDFormula = false ;
            A270LiqDErrorDesc = "" ;
            n270LiqDErrorDesc = false ;
            A1072LiqDLogRecal = httpContext.getMessage( "TotalNeto ", "") + GXutil.trim( GXutil.str( AV64TotalNeto, 14, 4)) + " (" + GXutil.trim( GXutil.str( AV77LiqLegImpTotRemu, 14, 2)) + " + " + GXutil.trim( GXutil.str( AV78LiqLegImpTotNoRemu, 14, 2)) + " - " + GXutil.trim( GXutil.str( AV79LiqLegImpTotDescu, 14, 2)) + ")" ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            /* Using cursor P02DG5 */
            pr_default.execute(3, new Object[] {Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1072LiqDLogRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            if (true) break;
            new web.msgdebug(remoteHandle, context).execute( AV82Pgmname, httpContext.getMessage( "GRABO SOBREGIRO ", "")+GXutil.trim( GXutil.str( AV23diferencia, 14, 2))) ;
            /* Using cursor P02DG6 */
            pr_default.execute(4, new Object[] {Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1072LiqDLogRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV84GXLvl145 == 0 )
         {
            new web.msgdebug(remoteHandle, context).execute( AV82Pgmname, httpContext.getMessage( "NONE SOBREGIRO", "")) ;
            GXv_int19[0] = AV72LiqDSecuencial ;
            new web.ultimoliqdsecuencial(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, AV32LegNumero, GXv_int19) ;
            calculaimporteliquidacionlegajoasync.this.AV72LiqDSecuencial = GXv_int19[0] ;
            AV72LiqDSecuencial = (int)(AV72LiqDSecuencial+1) ;
            GXv_date20[0] = AV74LiqPeriodo ;
            new web.getperiodoliquidacion(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, GXv_date20) ;
            calculaimporteliquidacionlegajoasync.this.AV74LiqPeriodo = GXv_date20[0] ;
            GXv_char4[0] = AV75TLiqCod ;
            new web.gettipoliq(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, GXv_char4) ;
            calculaimporteliquidacionlegajoasync.this.AV75TLiqCod = GXv_char4[0] ;
            GXv_decimal17[0] = AV23diferencia ;
            GXv_boolean6[0] = true ;
            GXv_char4[0] = "" ;
            GXv_char3[0] = "" ;
            new web.newliquidaciondetalle3(remoteHandle, context).execute( AV12CliCod, AV25EmpCod, AV48LiqNro, 0, AV32LegNumero, AV57sobregiro, false, AV72LiqDSecuencial, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(0), AV73vaciaFecha, AV73vaciaFecha, AV23diferencia, false, (byte)(3), AV74LiqPeriodo, AV75TLiqCod, false, (byte)(0), false, "", GXv_decimal17, GXv_boolean6, GXv_char4, GXv_char3) ;
            calculaimporteliquidacionlegajoasync.this.AV23diferencia = GXv_decimal17[0] ;
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "calculaimporteliquidacionlegajoasync");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV53retGanConCodigo = "" ;
      AV82Pgmname = "" ;
      AV8adelantoRetGanConCodigo = "" ;
      AV22DevGanConCodigo = "" ;
      AV50pagosAcuentaConCodigo = "" ;
      AV54sacConCodigo = "" ;
      AV56sacproporConCodigo = "" ;
      AV57sobregiro = "" ;
      AV27errorSobreGiro = "" ;
      AV62TliqCodAguinaldo = "" ;
      AV63TLiqCodVacaciones = "" ;
      GXt_char1 = "" ;
      AV36LiqImpNeto = DecimalUtil.ZERO ;
      AV35LiqImpBruto = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02DG2_A6LegNumero = new int[1] ;
      P02DG2_A31LiqNro = new int[1] ;
      P02DG2_A1EmpCod = new short[1] ;
      P02DG2_A3CliCod = new int[1] ;
      P02DG2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A32TLiqCod = new String[] {""} ;
      P02DG2_n32TLiqCod = new boolean[] {false} ;
      P02DG2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG2_A499LiqLegCntConc = new short[1] ;
      P02DG2_A891LiqLegError = new String[] {""} ;
      P02DG2_A2268LiqLegProcesado = new byte[1] ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A32TLiqCod = "" ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      AV39LiqLegImpBasico = DecimalUtil.ZERO ;
      AV77LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV78LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV79LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV47LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV41LiqLegImpCosto = DecimalUtil.ZERO ;
      AV43LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV44LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      AV55sacImportes = DecimalUtil.ZERO ;
      AV65totalRestanImportes = DecimalUtil.ZERO ;
      AV66totalSumanImportes = DecimalUtil.ZERO ;
      AV18descuentosNegativos = DecimalUtil.ZERO ;
      AV10bruto = DecimalUtil.ZERO ;
      AV64TotalNeto = DecimalUtil.ZERO ;
      AV46LiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV31ImporteRedondeado = DecimalUtil.ZERO ;
      AV23diferencia = DecimalUtil.ZERO ;
      AV60SueldoBrutoPromedioConCodigo = "" ;
      AV45LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      GXv_int7 = new byte[1] ;
      GXt_char2 = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_decimal16 = new java.math.BigDecimal[1] ;
      GXv_int18 = new short[1] ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A274LiqDFormula = "" ;
      A270LiqDErrorDesc = "" ;
      A1072LiqDLogRecal = "" ;
      P02DG4_A394DConCodigo = new String[] {""} ;
      P02DG4_A6LegNumero = new int[1] ;
      P02DG4_A31LiqNro = new int[1] ;
      P02DG4_A1EmpCod = new short[1] ;
      P02DG4_A3CliCod = new int[1] ;
      P02DG4_A502LiqDMostrar = new byte[1] ;
      P02DG4_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG4_n275LiqDImpCalcu = new boolean[] {false} ;
      P02DG4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02DG4_A274LiqDFormula = new String[] {""} ;
      P02DG4_n274LiqDFormula = new boolean[] {false} ;
      P02DG4_A270LiqDErrorDesc = new String[] {""} ;
      P02DG4_n270LiqDErrorDesc = new boolean[] {false} ;
      P02DG4_A1072LiqDLogRecal = new String[] {""} ;
      P02DG4_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      GXv_int19 = new int[1] ;
      AV74LiqPeriodo = GXutil.nullDate() ;
      GXv_date20 = new java.util.Date[1] ;
      AV75TLiqCod = "" ;
      AV73vaciaFecha = GXutil.nullDate() ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculaimporteliquidacionlegajoasync__default(),
         new Object[] {
             new Object[] {
            P02DG2_A6LegNumero, P02DG2_A31LiqNro, P02DG2_A1EmpCod, P02DG2_A3CliCod, P02DG2_A760LiqLegImpBasico, P02DG2_A281LiqLegImpTotal, P02DG2_A498LiqLegImpTotBruto, P02DG2_A32TLiqCod, P02DG2_n32TLiqCod, P02DG2_A759LiqLegImpTotBruSinSAC,
            P02DG2_A577LiqLegImpTotRemu, P02DG2_A578LiqLegImpTotNoRemu, P02DG2_A579LiqLegImpTotDescu, P02DG2_A1143LiqLegImpDescuNeg, P02DG2_A1131LiqLegImpOtrDescu, P02DG2_A775LiqLegImpPagosACuen, P02DG2_A757LiqLegImpTotRetGan, P02DG2_A758LiqLegImpTotBruProm, P02DG2_A499LiqLegCntConc, P02DG2_A891LiqLegError,
            P02DG2_A2268LiqLegProcesado
            }
            , new Object[] {
            }
            , new Object[] {
            P02DG4_A394DConCodigo, P02DG4_A6LegNumero, P02DG4_A31LiqNro, P02DG4_A1EmpCod, P02DG4_A3CliCod, P02DG4_A502LiqDMostrar, P02DG4_A275LiqDImpCalcu, P02DG4_n275LiqDImpCalcu, P02DG4_A764LiqDImpReCalcu, P02DG4_A274LiqDFormula,
            P02DG4_n274LiqDFormula, P02DG4_A270LiqDErrorDesc, P02DG4_n270LiqDErrorDesc, P02DG4_A1072LiqDLogRecal, P02DG4_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV82Pgmname = "CalculaImporteLiquidacionLegajoAsync" ;
      /* GeneXus formulas. */
      AV82Pgmname = "CalculaImporteLiquidacionLegajoAsync" ;
      Gx_err = (short)(0) ;
   }

   private byte AV83GXLvl35 ;
   private byte A2268LiqLegProcesado ;
   private byte GXv_int7[] ;
   private byte A502LiqDMostrar ;
   private byte AV84GXLvl145 ;
   private short AV25EmpCod ;
   private short A1EmpCod ;
   private short A499LiqLegCntConc ;
   private short AV37LiqLegCntConc ;
   private short AV33LiqCntLeg ;
   private short GXv_int18[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV48LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int AV32LegNumero ;
   private int A81LiqDSecuencial ;
   private int AV72LiqDSecuencial ;
   private int GXv_int19[] ;
   private java.math.BigDecimal AV36LiqImpNeto ;
   private java.math.BigDecimal AV35LiqImpBruto ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal AV39LiqLegImpBasico ;
   private java.math.BigDecimal AV77LiqLegImpTotRemu ;
   private java.math.BigDecimal AV78LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV79LiqLegImpTotDescu ;
   private java.math.BigDecimal AV47LiqLegImpTotRetGan ;
   private java.math.BigDecimal AV41LiqLegImpCosto ;
   private java.math.BigDecimal AV43LiqLegImpOtrDescu ;
   private java.math.BigDecimal AV44LiqLegImpPagosACuen ;
   private java.math.BigDecimal AV55sacImportes ;
   private java.math.BigDecimal AV65totalRestanImportes ;
   private java.math.BigDecimal AV66totalSumanImportes ;
   private java.math.BigDecimal AV18descuentosNegativos ;
   private java.math.BigDecimal AV10bruto ;
   private java.math.BigDecimal AV64TotalNeto ;
   private java.math.BigDecimal AV46LiqLegImpTotBruto ;
   private java.math.BigDecimal AV31ImporteRedondeado ;
   private java.math.BigDecimal AV23diferencia ;
   private java.math.BigDecimal AV45LiqLegImpTotBruProm ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private java.math.BigDecimal GXv_decimal16[] ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private String AV53retGanConCodigo ;
   private String AV82Pgmname ;
   private String AV8adelantoRetGanConCodigo ;
   private String AV22DevGanConCodigo ;
   private String AV50pagosAcuentaConCodigo ;
   private String AV54sacConCodigo ;
   private String AV56sacproporConCodigo ;
   private String AV57sobregiro ;
   private String AV62TliqCodAguinaldo ;
   private String AV63TLiqCodVacaciones ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV60SueldoBrutoPromedioConCodigo ;
   private String GXt_char2 ;
   private String A394DConCodigo ;
   private String AV75TLiqCod ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV74LiqPeriodo ;
   private java.util.Date GXv_date20[] ;
   private java.util.Date AV73vaciaFecha ;
   private boolean AV13completa ;
   private boolean n32TLiqCod ;
   private boolean returnInSub ;
   private boolean n275LiqDImpCalcu ;
   private boolean n274LiqDFormula ;
   private boolean n270LiqDErrorDesc ;
   private boolean GXv_boolean6[] ;
   private String A274LiqDFormula ;
   private String A1072LiqDLogRecal ;
   private String AV27errorSobreGiro ;
   private String A891LiqLegError ;
   private String A270LiqDErrorDesc ;
   private GXSimpleCollection<Integer> AV71coll_LegNumero ;
   private IDataStoreProvider pr_default ;
   private int[] P02DG2_A6LegNumero ;
   private int[] P02DG2_A31LiqNro ;
   private short[] P02DG2_A1EmpCod ;
   private int[] P02DG2_A3CliCod ;
   private java.math.BigDecimal[] P02DG2_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] P02DG2_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] P02DG2_A498LiqLegImpTotBruto ;
   private String[] P02DG2_A32TLiqCod ;
   private boolean[] P02DG2_n32TLiqCod ;
   private java.math.BigDecimal[] P02DG2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P02DG2_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] P02DG2_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] P02DG2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P02DG2_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] P02DG2_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] P02DG2_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] P02DG2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P02DG2_A758LiqLegImpTotBruProm ;
   private short[] P02DG2_A499LiqLegCntConc ;
   private String[] P02DG2_A891LiqLegError ;
   private byte[] P02DG2_A2268LiqLegProcesado ;
   private String[] P02DG4_A394DConCodigo ;
   private int[] P02DG4_A6LegNumero ;
   private int[] P02DG4_A31LiqNro ;
   private short[] P02DG4_A1EmpCod ;
   private int[] P02DG4_A3CliCod ;
   private byte[] P02DG4_A502LiqDMostrar ;
   private java.math.BigDecimal[] P02DG4_A275LiqDImpCalcu ;
   private boolean[] P02DG4_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P02DG4_A764LiqDImpReCalcu ;
   private String[] P02DG4_A274LiqDFormula ;
   private boolean[] P02DG4_n274LiqDFormula ;
   private String[] P02DG4_A270LiqDErrorDesc ;
   private boolean[] P02DG4_n270LiqDErrorDesc ;
   private String[] P02DG4_A1072LiqDLogRecal ;
   private int[] P02DG4_A81LiqDSecuencial ;
}

final  class calculaimporteliquidacionlegajoasync__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02DG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A6LegNumero ,
                                          GXSimpleCollection<Integer> AV71coll_LegNumero ,
                                          int AV12CliCod ,
                                          short AV25EmpCod ,
                                          int AV48LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[3];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegImpBasico, LiqLegImpTotal, LiqLegImpTotBruto, TLiqCod, LiqLegImpTotBruSinSAC, LiqLegImpTotRemu, LiqLegImpTotNoRemu," ;
      scmdbuf += " LiqLegImpTotDescu, LiqLegImpDescuNeg, LiqLegImpOtrDescu, LiqLegImpPagosACuen, LiqLegImpTotRetGan, LiqLegImpTotBruProm, LiqLegCntConc, LiqLegError, LiqLegProcesado" ;
      scmdbuf += " FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71coll_LegNumero, "LegNumero IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLegajo" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
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
                  return conditional_P02DG2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DG2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02DG3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegImpBasico=?, LiqLegImpTotal=?, LiqLegImpTotBruto=?, LiqLegImpTotBruSinSAC=?, LiqLegImpTotRemu=?, LiqLegImpTotNoRemu=?, LiqLegImpTotDescu=?, LiqLegImpDescuNeg=?, LiqLegImpOtrDescu=?, LiqLegImpPagosACuen=?, LiqLegImpTotRetGan=?, LiqLegImpTotBruProm=?, LiqLegCntConc=?, LiqLegError=?, LiqLegProcesado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02DG4", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDMostrar, LiqDImpCalcu, LiqDImpReCalcu, LiqDFormula, LiqDErrorDesc, LiqDLogRecal, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02DG5", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDMostrar=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDFormula=?, LiqDErrorDesc=?, LiqDLogRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02DG6", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDMostrar=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDFormula=?, LiqDErrorDesc=?, LiqDLogRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((short[]) buf[18])[0] = rslt.getShort(18);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((byte[]) buf[20])[0] = rslt.getByte(20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getLongVarchar(11);
               ((int[]) buf[14])[0] = rslt.getInt(12);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setInt(19, ((Number) parms[18]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[2], 2);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[7], 400);
               }
               stmt.setNLongVarchar(6, (String)parms[8], false);
               stmt.setInt(7, ((Number) parms[9]).intValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setInt(11, ((Number) parms[13]).intValue());
               return;
            case 4 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[2], 2);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[7], 400);
               }
               stmt.setNLongVarchar(6, (String)parms[8], false);
               stmt.setInt(7, ((Number) parms[9]).intValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setInt(11, ((Number) parms[13]).intValue());
               return;
      }
   }

}

