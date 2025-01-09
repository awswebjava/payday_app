package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculaimporteliquidacionlegajo extends GXProcedure
{
   public calculaimporteliquidacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculaimporteliquidacionlegajo.class ), "" );
   }

   public calculaimporteliquidacionlegajo( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              GXSimpleCollection<Integer> aP3 ,
                              String aP4 ,
                              java.math.BigDecimal[] aP5 ,
                              java.math.BigDecimal[] aP6 ,
                              short[] aP7 )
   {
      calculaimporteliquidacionlegajo.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        short[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             short[] aP7 ,
                             boolean[] aP8 )
   {
      calculaimporteliquidacionlegajo.this.AV10CliCod = aP0;
      calculaimporteliquidacionlegajo.this.AV16EmpCod = aP1;
      calculaimporteliquidacionlegajo.this.AV20LiqNro = aP2;
      calculaimporteliquidacionlegajo.this.AV75coll_LegNumero = aP3;
      calculaimporteliquidacionlegajo.this.AV80preCalculada = aP4;
      calculaimporteliquidacionlegajo.this.aP5 = aP5;
      calculaimporteliquidacionlegajo.this.aP6 = aP6;
      calculaimporteliquidacionlegajo.this.aP7 = aP7;
      calculaimporteliquidacionlegajo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV44completa = true ;
      GXt_char1 = AV47retGanConCodigo ;
      GXt_char2 = AV47retGanConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char1 = GXv_char4[0] ;
      AV47retGanConCodigo = GXt_char1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&retGanConCodigo ", "")+AV47retGanConCodigo) ;
      GXt_char2 = AV65adelantoRetGanConCodigo ;
      GXt_char1 = AV65adelantoRetGanConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char3[0] ;
      AV65adelantoRetGanConCodigo = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&adelantoRetGanConCodigo  ", "")+AV65adelantoRetGanConCodigo) ;
      GXt_char2 = AV50DevGanConCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.conceptodevolucionganancias(remoteHandle, context).execute( AV10CliCod, GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char4[0] ;
      AV50DevGanConCodigo = GXt_char2 ;
      GXt_char2 = AV50DevGanConCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.conceptodevolucionganancias(remoteHandle, context).execute( AV10CliCod, GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char4[0] ;
      AV50DevGanConCodigo = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&DevGanConCodigo  ", "")+AV50DevGanConCodigo) ;
      GXt_char2 = AV59pagosAcuentaConCodigo ;
      GXt_char1 = AV59pagosAcuentaConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char3[0] ;
      AV59pagosAcuentaConCodigo = GXt_char2 ;
      GXv_char4[0] = AV54sacConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.concepto_sac_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      calculaimporteliquidacionlegajo.this.AV54sacConCodigo = GXv_char4[0] ;
      GXv_char4[0] = AV53sacproporConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.concepto_sacpropor_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      calculaimporteliquidacionlegajo.this.AV53sacproporConCodigo = GXv_char4[0] ;
      GXv_char4[0] = AV38sobregiro ;
      GXv_char3[0] = AV37errorSobreGiro ;
      new web.conceptosobregiro(remoteHandle, context).execute( AV10CliCod, GXv_char4, GXv_char3) ;
      calculaimporteliquidacionlegajo.this.AV38sobregiro = GXv_char4[0] ;
      calculaimporteliquidacionlegajo.this.AV37errorSobreGiro = GXv_char3[0] ;
      GXt_char2 = AV62TliqCodAguinaldo ;
      GXt_char1 = AV62TliqCodAguinaldo ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char3[0] ;
      AV62TliqCodAguinaldo = GXt_char2 ;
      GXt_char2 = AV63TLiqCodVacaciones ;
      GXt_char1 = AV63TLiqCodVacaciones ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculaimporteliquidacionlegajo.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char3[0] ;
      AV63TLiqCodVacaciones = GXt_char2 ;
      AV40LiqImpNeto = DecimalUtil.ZERO ;
      AV41LiqImpBruto = DecimalUtil.ZERO ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(A6LegNumero) ,
                                           AV75coll_LegNumero ,
                                           AV80preCalculada ,
                                           Byte.valueOf(A2360LiqLegNivLiq) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV16EmpCod) ,
                                           Integer.valueOf(AV20LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P003I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV20LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2360LiqLegNivLiq = P003I2_A2360LiqLegNivLiq[0] ;
         A6LegNumero = P003I2_A6LegNumero[0] ;
         A31LiqNro = P003I2_A31LiqNro[0] ;
         A1EmpCod = P003I2_A1EmpCod[0] ;
         A3CliCod = P003I2_A3CliCod[0] ;
         A760LiqLegImpBasico = P003I2_A760LiqLegImpBasico[0] ;
         A281LiqLegImpTotal = P003I2_A281LiqLegImpTotal[0] ;
         A498LiqLegImpTotBruto = P003I2_A498LiqLegImpTotBruto[0] ;
         A32TLiqCod = P003I2_A32TLiqCod[0] ;
         n32TLiqCod = P003I2_n32TLiqCod[0] ;
         A759LiqLegImpTotBruSinSAC = P003I2_A759LiqLegImpTotBruSinSAC[0] ;
         A577LiqLegImpTotRemu = P003I2_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = P003I2_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = P003I2_A579LiqLegImpTotDescu[0] ;
         A1143LiqLegImpDescuNeg = P003I2_A1143LiqLegImpDescuNeg[0] ;
         A1131LiqLegImpOtrDescu = P003I2_A1131LiqLegImpOtrDescu[0] ;
         A775LiqLegImpPagosACuen = P003I2_A775LiqLegImpPagosACuen[0] ;
         A757LiqLegImpTotRetGan = P003I2_A757LiqLegImpTotRetGan[0] ;
         A758LiqLegImpTotBruProm = P003I2_A758LiqLegImpTotBruProm[0] ;
         A499LiqLegCntConc = P003I2_A499LiqLegCntConc[0] ;
         A891LiqLegError = P003I2_A891LiqLegError[0] ;
         A2268LiqLegProcesado = P003I2_A2268LiqLegProcesado[0] ;
         AV18LegNumero = A6LegNumero ;
         AV55LiqLegImpBasico = DecimalUtil.ZERO ;
         AV81LiqLegImpTotRemu = DecimalUtil.ZERO ;
         AV82LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
         AV83LiqLegImpTotDescu = DecimalUtil.ZERO ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "---> iniciliza cero", "")) ;
         AV43LiqLegCntConc = (short)(0) ;
         AV46LiqLegImpTotRetGan = DecimalUtil.ZERO ;
         AV72LiqLegImpCosto = DecimalUtil.ZERO ;
         AV68LiqLegImpOtrDescu = DecimalUtil.ZERO ;
         AV60LiqLegImpPagosACuen = DecimalUtil.ZERO ;
         AV51sacImportes = DecimalUtil.ZERO ;
         AV67totalRestanImportes = DecimalUtil.ZERO ;
         AV66totalSumanImportes = DecimalUtil.ZERO ;
         AV69descuentosNegativos = DecimalUtil.ZERO ;
         /* Execute user subroutine: 'CALCULALEGAJO' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV73bruto = AV81LiqLegImpTotRemu.add(AV82LiqLegImpTotNoRemu) ;
         AV24TotalNeto = AV81LiqLegImpTotRemu.add(AV82LiqLegImpTotNoRemu).subtract(AV83LiqLegImpTotDescu).add(AV69descuentosNegativos) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&TotalNeto ", "")+GXutil.trim( GXutil.str( AV24TotalNeto, 14, 4))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&&LiqLegImpTotRemu ", "")+GXutil.trim( GXutil.str( AV81LiqLegImpTotRemu, 14, 2))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&&&LiqLegImpTotNoRemu ", "")+GXutil.trim( GXutil.str( AV82LiqLegImpTotNoRemu, 14, 2))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&&&&LiqLegImpTotDescu ", "")+GXutil.trim( GXutil.str( AV83LiqLegImpTotDescu, 14, 2))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&&&&&&descuentosNegativos ", "")+GXutil.trim( GXutil.str( AV69descuentosNegativos, 14, 2))) ;
         AV39LiqLegImpTotBruto = AV81LiqLegImpTotRemu.add(AV82LiqLegImpTotNoRemu).add(AV69descuentosNegativos) ;
         if ( AV24TotalNeto.doubleValue() >= 0 )
         {
            AV17ImporteRedondeado = AV24TotalNeto ;
         }
         else
         {
            AV36diferencia = AV67totalRestanImportes.add(AV66totalSumanImportes) ;
            if ( AV36diferencia.doubleValue() < 0 )
            {
               AV36diferencia = AV36diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "diferencia ", "")+GXutil.trim( GXutil.str( AV36diferencia, 14, 2))+httpContext.getMessage( " total restan ", "")+GXutil.trim( GXutil.str( AV67totalRestanImportes, 14, 2))+httpContext.getMessage( " total suman ", "")+GXutil.trim( GXutil.str( AV66totalSumanImportes, 14, 2))) ;
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
         A760LiqLegImpBasico = AV55LiqLegImpBasico ;
         A281LiqLegImpTotal = AV17ImporteRedondeado ;
         A498LiqLegImpTotBruto = AV39LiqLegImpTotBruto ;
         if ( ( GXutil.strcmp(A32TLiqCod, AV62TliqCodAguinaldo) != 0 ) && ( GXutil.strcmp(A32TLiqCod, AV63TLiqCodVacaciones) != 0 ) )
         {
            A759LiqLegImpTotBruSinSAC = AV39LiqLegImpTotBruto.subtract(AV51sacImportes) ;
         }
         else
         {
            A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
         }
         A577LiqLegImpTotRemu = AV81LiqLegImpTotRemu ;
         A578LiqLegImpTotNoRemu = AV82LiqLegImpTotNoRemu ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "---> &&LiqLegImpTotRemu ", "")+GXutil.trim( GXutil.str( AV81LiqLegImpTotRemu, 14, 2))) ;
         A579LiqLegImpTotDescu = AV83LiqLegImpTotDescu ;
         A1143LiqLegImpDescuNeg = AV69descuentosNegativos ;
         A1131LiqLegImpOtrDescu = AV68LiqLegImpOtrDescu ;
         A775LiqLegImpPagosACuen = AV60LiqLegImpPagosACuen ;
         A757LiqLegImpTotRetGan = AV46LiqLegImpTotRetGan ;
         GXv_char4[0] = AV48SueldoBrutoPromedioConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.concepto_brutopromedio_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         calculaimporteliquidacionlegajo.this.AV48SueldoBrutoPromedioConCodigo = GXv_char4[0] ;
         GXv_decimal5[0] = AV49LiqLegImpTotBruProm ;
         GXv_boolean6[0] = false ;
         GXv_int7[0] = (byte)(0) ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, AV18LegNumero, AV48SueldoBrutoPromedioConCodigo, "Calculo", false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         calculaimporteliquidacionlegajo.this.AV49LiqLegImpTotBruProm = GXv_decimal5[0] ;
         A758LiqLegImpTotBruProm = AV49LiqLegImpTotBruProm ;
         A499LiqLegCntConc = AV43LiqLegCntConc ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&LiqLegCntConc ", "")+GXutil.trim( GXutil.str( AV43LiqLegCntConc, 4, 0))) ;
         if ( (0==AV43LiqLegCntConc) )
         {
            AV44completa = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV86Pgmname, httpContext.getMessage( "&completa = false", "")) ;
            if ( (GXutil.strcmp("", A891LiqLegError)==0) )
            {
               GXt_char2 = A891LiqLegError ;
               GXv_char4[0] = GXt_char2 ;
               new web.textoerrornohayimprimibles(remoteHandle, context).execute( AV10CliCod, GXv_char4) ;
               calculaimporteliquidacionlegajo.this.GXt_char2 = GXv_char4[0] ;
               A891LiqLegError = GXt_char2 ;
            }
            A2268LiqLegProcesado = (byte)(2) ;
         }
         AV40LiqImpNeto = AV40LiqImpNeto.add(AV17ImporteRedondeado) ;
         AV41LiqImpBruto = AV41LiqImpBruto.add(AV39LiqLegImpTotBruto) ;
         AV42LiqCntLeg = (short)(AV42LiqCntLeg+1) ;
         /* Using cursor P003I3 */
         pr_default.execute(1, new Object[] {A760LiqLegImpBasico, A281LiqLegImpTotal, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1143LiqLegImpDescuNeg, A1131LiqLegImpOtrDescu, A775LiqLegImpPagosACuen, A757LiqLegImpTotRetGan, A758LiqLegImpTotBruProm, Short.valueOf(A499LiqLegCntConc), A891LiqLegError, Byte.valueOf(A2268LiqLegProcesado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'CALCULALEGAJO' Routine */
      returnInSub = false ;
      GXv_decimal5[0] = AV66totalSumanImportes ;
      GXv_decimal8[0] = AV69descuentosNegativos ;
      GXv_decimal9[0] = AV67totalRestanImportes ;
      GXv_decimal10[0] = AV46LiqLegImpTotRetGan ;
      GXv_decimal11[0] = AV68LiqLegImpOtrDescu ;
      GXv_decimal12[0] = AV60LiqLegImpPagosACuen ;
      GXv_decimal13[0] = AV51sacImportes ;
      GXv_decimal14[0] = AV55LiqLegImpBasico ;
      GXv_decimal15[0] = AV81LiqLegImpTotRemu ;
      GXv_decimal16[0] = AV82LiqLegImpTotNoRemu ;
      GXv_decimal17[0] = AV83LiqLegImpTotDescu ;
      GXv_int18[0] = AV43LiqLegCntConc ;
      new web.calculaimportesliqleg(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, AV18LegNumero, AV59pagosAcuentaConCodigo, AV54sacConCodigo, AV53sacproporConCodigo, GXv_decimal5, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_decimal12, GXv_decimal13, GXv_decimal14, GXv_decimal15, GXv_decimal16, GXv_decimal17, GXv_int18) ;
      calculaimporteliquidacionlegajo.this.AV66totalSumanImportes = GXv_decimal5[0] ;
      calculaimporteliquidacionlegajo.this.AV69descuentosNegativos = GXv_decimal8[0] ;
      calculaimporteliquidacionlegajo.this.AV67totalRestanImportes = GXv_decimal9[0] ;
      calculaimporteliquidacionlegajo.this.AV46LiqLegImpTotRetGan = GXv_decimal10[0] ;
      calculaimporteliquidacionlegajo.this.AV68LiqLegImpOtrDescu = GXv_decimal11[0] ;
      calculaimporteliquidacionlegajo.this.AV60LiqLegImpPagosACuen = GXv_decimal12[0] ;
      calculaimporteliquidacionlegajo.this.AV51sacImportes = GXv_decimal13[0] ;
      calculaimporteliquidacionlegajo.this.AV55LiqLegImpBasico = GXv_decimal14[0] ;
      calculaimporteliquidacionlegajo.this.AV81LiqLegImpTotRemu = GXv_decimal15[0] ;
      calculaimporteliquidacionlegajo.this.AV82LiqLegImpTotNoRemu = GXv_decimal16[0] ;
      calculaimporteliquidacionlegajo.this.AV83LiqLegImpTotDescu = GXv_decimal17[0] ;
      calculaimporteliquidacionlegajo.this.AV43LiqLegCntConc = GXv_int18[0] ;
   }

   public void S121( )
   {
      /* 'CARGACONCEPTOSOBREGIRO' Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV37errorSobreGiro)==0) )
      {
         AV88GXLvl150 = (byte)(0) ;
         /* Using cursor P003I4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV20LiqNro), Integer.valueOf(AV18LegNumero), AV38sobregiro});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A394DConCodigo = P003I4_A394DConCodigo[0] ;
            A6LegNumero = P003I4_A6LegNumero[0] ;
            A31LiqNro = P003I4_A31LiqNro[0] ;
            A1EmpCod = P003I4_A1EmpCod[0] ;
            A3CliCod = P003I4_A3CliCod[0] ;
            A502LiqDMostrar = P003I4_A502LiqDMostrar[0] ;
            A275LiqDImpCalcu = P003I4_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P003I4_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P003I4_A764LiqDImpReCalcu[0] ;
            A274LiqDFormula = P003I4_A274LiqDFormula[0] ;
            n274LiqDFormula = P003I4_n274LiqDFormula[0] ;
            A270LiqDErrorDesc = P003I4_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = P003I4_n270LiqDErrorDesc[0] ;
            A1072LiqDLogRecal = P003I4_A1072LiqDLogRecal[0] ;
            A81LiqDSecuencial = P003I4_A81LiqDSecuencial[0] ;
            AV88GXLvl150 = (byte)(1) ;
            A502LiqDMostrar = (byte)(3) ;
            A275LiqDImpCalcu = AV36diferencia ;
            n275LiqDImpCalcu = false ;
            A764LiqDImpReCalcu = AV36diferencia ;
            A274LiqDFormula = GXutil.trim( GXutil.str( AV36diferencia, 14, 2)) ;
            n274LiqDFormula = false ;
            A270LiqDErrorDesc = "" ;
            n270LiqDErrorDesc = false ;
            A1072LiqDLogRecal = httpContext.getMessage( "TotalNeto ", "") + GXutil.trim( GXutil.str( AV24TotalNeto, 14, 4)) + " (" + GXutil.trim( GXutil.str( AV81LiqLegImpTotRemu, 14, 2)) + " + " + GXutil.trim( GXutil.str( AV82LiqLegImpTotNoRemu, 14, 2)) + " - " + GXutil.trim( GXutil.str( AV83LiqLegImpTotDescu, 14, 2)) + ")" ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            /* Using cursor P003I5 */
            pr_default.execute(3, new Object[] {Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1072LiqDLogRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            if (true) break;
            new web.msgdebug(remoteHandle, context).execute( AV86Pgmname, httpContext.getMessage( "GRABO SOBREGIRO ", "")+GXutil.trim( GXutil.str( AV36diferencia, 14, 2))) ;
            /* Using cursor P003I6 */
            pr_default.execute(4, new Object[] {Byte.valueOf(A502LiqDMostrar), Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, A1072LiqDLogRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( AV88GXLvl150 == 0 )
         {
            new web.msgdebug(remoteHandle, context).execute( AV86Pgmname, httpContext.getMessage( "NONE SOBREGIRO", "")) ;
            GXv_int19[0] = AV76LiqDSecuencial ;
            new web.ultimoliqdsecuencial(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, AV18LegNumero, GXv_int19) ;
            calculaimporteliquidacionlegajo.this.AV76LiqDSecuencial = GXv_int19[0] ;
            AV76LiqDSecuencial = (int)(AV76LiqDSecuencial+1) ;
            GXv_date20[0] = AV78LiqPeriodo ;
            new web.getperiodoliquidacion(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, GXv_date20) ;
            calculaimporteliquidacionlegajo.this.AV78LiqPeriodo = GXv_date20[0] ;
            GXv_char4[0] = AV79TLiqCod ;
            new web.gettipoliq(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, GXv_char4) ;
            calculaimporteliquidacionlegajo.this.AV79TLiqCod = GXv_char4[0] ;
            GXv_decimal17[0] = AV36diferencia ;
            GXv_boolean6[0] = true ;
            GXv_char4[0] = "" ;
            GXv_char3[0] = "" ;
            new web.newliquidaciondetalle3(remoteHandle, context).execute( AV10CliCod, AV16EmpCod, AV20LiqNro, 0, AV18LegNumero, AV38sobregiro, false, AV76LiqDSecuencial, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(0), AV77vaciaFecha, AV77vaciaFecha, AV36diferencia, false, (byte)(3), AV78LiqPeriodo, AV79TLiqCod, false, (byte)(0), false, "", GXv_decimal17, GXv_boolean6, GXv_char4, GXv_char3) ;
            calculaimporteliquidacionlegajo.this.AV36diferencia = GXv_decimal17[0] ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = calculaimporteliquidacionlegajo.this.AV40LiqImpNeto;
      this.aP6[0] = calculaimporteliquidacionlegajo.this.AV41LiqImpBruto;
      this.aP7[0] = calculaimporteliquidacionlegajo.this.AV42LiqCntLeg;
      this.aP8[0] = calculaimporteliquidacionlegajo.this.AV44completa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40LiqImpNeto = DecimalUtil.ZERO ;
      AV41LiqImpBruto = DecimalUtil.ZERO ;
      AV47retGanConCodigo = "" ;
      AV86Pgmname = "" ;
      AV65adelantoRetGanConCodigo = "" ;
      AV50DevGanConCodigo = "" ;
      AV59pagosAcuentaConCodigo = "" ;
      AV54sacConCodigo = "" ;
      AV53sacproporConCodigo = "" ;
      AV38sobregiro = "" ;
      AV37errorSobreGiro = "" ;
      AV62TliqCodAguinaldo = "" ;
      AV63TLiqCodVacaciones = "" ;
      GXt_char1 = "" ;
      scmdbuf = "" ;
      P003I2_A2360LiqLegNivLiq = new byte[1] ;
      P003I2_A6LegNumero = new int[1] ;
      P003I2_A31LiqNro = new int[1] ;
      P003I2_A1EmpCod = new short[1] ;
      P003I2_A3CliCod = new int[1] ;
      P003I2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A32TLiqCod = new String[] {""} ;
      P003I2_n32TLiqCod = new boolean[] {false} ;
      P003I2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I2_A499LiqLegCntConc = new short[1] ;
      P003I2_A891LiqLegError = new String[] {""} ;
      P003I2_A2268LiqLegProcesado = new byte[1] ;
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
      AV55LiqLegImpBasico = DecimalUtil.ZERO ;
      AV81LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV82LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV83LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV46LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV72LiqLegImpCosto = DecimalUtil.ZERO ;
      AV68LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV60LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      AV51sacImportes = DecimalUtil.ZERO ;
      AV67totalRestanImportes = DecimalUtil.ZERO ;
      AV66totalSumanImportes = DecimalUtil.ZERO ;
      AV69descuentosNegativos = DecimalUtil.ZERO ;
      AV73bruto = DecimalUtil.ZERO ;
      AV24TotalNeto = DecimalUtil.ZERO ;
      AV39LiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV17ImporteRedondeado = DecimalUtil.ZERO ;
      AV36diferencia = DecimalUtil.ZERO ;
      AV48SueldoBrutoPromedioConCodigo = "" ;
      AV49LiqLegImpTotBruProm = DecimalUtil.ZERO ;
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
      P003I4_A394DConCodigo = new String[] {""} ;
      P003I4_A6LegNumero = new int[1] ;
      P003I4_A31LiqNro = new int[1] ;
      P003I4_A1EmpCod = new short[1] ;
      P003I4_A3CliCod = new int[1] ;
      P003I4_A502LiqDMostrar = new byte[1] ;
      P003I4_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I4_n275LiqDImpCalcu = new boolean[] {false} ;
      P003I4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003I4_A274LiqDFormula = new String[] {""} ;
      P003I4_n274LiqDFormula = new boolean[] {false} ;
      P003I4_A270LiqDErrorDesc = new String[] {""} ;
      P003I4_n270LiqDErrorDesc = new boolean[] {false} ;
      P003I4_A1072LiqDLogRecal = new String[] {""} ;
      P003I4_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      GXv_int19 = new int[1] ;
      AV78LiqPeriodo = GXutil.nullDate() ;
      GXv_date20 = new java.util.Date[1] ;
      AV79TLiqCod = "" ;
      AV77vaciaFecha = GXutil.nullDate() ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculaimporteliquidacionlegajo__default(),
         new Object[] {
             new Object[] {
            P003I2_A2360LiqLegNivLiq, P003I2_A6LegNumero, P003I2_A31LiqNro, P003I2_A1EmpCod, P003I2_A3CliCod, P003I2_A760LiqLegImpBasico, P003I2_A281LiqLegImpTotal, P003I2_A498LiqLegImpTotBruto, P003I2_A32TLiqCod, P003I2_n32TLiqCod,
            P003I2_A759LiqLegImpTotBruSinSAC, P003I2_A577LiqLegImpTotRemu, P003I2_A578LiqLegImpTotNoRemu, P003I2_A579LiqLegImpTotDescu, P003I2_A1143LiqLegImpDescuNeg, P003I2_A1131LiqLegImpOtrDescu, P003I2_A775LiqLegImpPagosACuen, P003I2_A757LiqLegImpTotRetGan, P003I2_A758LiqLegImpTotBruProm, P003I2_A499LiqLegCntConc,
            P003I2_A891LiqLegError, P003I2_A2268LiqLegProcesado
            }
            , new Object[] {
            }
            , new Object[] {
            P003I4_A394DConCodigo, P003I4_A6LegNumero, P003I4_A31LiqNro, P003I4_A1EmpCod, P003I4_A3CliCod, P003I4_A502LiqDMostrar, P003I4_A275LiqDImpCalcu, P003I4_n275LiqDImpCalcu, P003I4_A764LiqDImpReCalcu, P003I4_A274LiqDFormula,
            P003I4_n274LiqDFormula, P003I4_A270LiqDErrorDesc, P003I4_n270LiqDErrorDesc, P003I4_A1072LiqDLogRecal, P003I4_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV86Pgmname = "CalculaImporteLiquidacionLegajo" ;
      /* GeneXus formulas. */
      AV86Pgmname = "CalculaImporteLiquidacionLegajo" ;
      Gx_err = (short)(0) ;
   }

   private byte A2360LiqLegNivLiq ;
   private byte A2268LiqLegProcesado ;
   private byte GXv_int7[] ;
   private byte A502LiqDMostrar ;
   private byte AV88GXLvl150 ;
   private short AV16EmpCod ;
   private short AV42LiqCntLeg ;
   private short A1EmpCod ;
   private short A499LiqLegCntConc ;
   private short AV43LiqLegCntConc ;
   private short GXv_int18[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV20LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int AV18LegNumero ;
   private int A81LiqDSecuencial ;
   private int AV76LiqDSecuencial ;
   private int GXv_int19[] ;
   private java.math.BigDecimal AV40LiqImpNeto ;
   private java.math.BigDecimal AV41LiqImpBruto ;
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
   private java.math.BigDecimal AV55LiqLegImpBasico ;
   private java.math.BigDecimal AV81LiqLegImpTotRemu ;
   private java.math.BigDecimal AV82LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV83LiqLegImpTotDescu ;
   private java.math.BigDecimal AV46LiqLegImpTotRetGan ;
   private java.math.BigDecimal AV72LiqLegImpCosto ;
   private java.math.BigDecimal AV68LiqLegImpOtrDescu ;
   private java.math.BigDecimal AV60LiqLegImpPagosACuen ;
   private java.math.BigDecimal AV51sacImportes ;
   private java.math.BigDecimal AV67totalRestanImportes ;
   private java.math.BigDecimal AV66totalSumanImportes ;
   private java.math.BigDecimal AV69descuentosNegativos ;
   private java.math.BigDecimal AV73bruto ;
   private java.math.BigDecimal AV24TotalNeto ;
   private java.math.BigDecimal AV39LiqLegImpTotBruto ;
   private java.math.BigDecimal AV17ImporteRedondeado ;
   private java.math.BigDecimal AV36diferencia ;
   private java.math.BigDecimal AV49LiqLegImpTotBruProm ;
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
   private String AV80preCalculada ;
   private String AV47retGanConCodigo ;
   private String AV86Pgmname ;
   private String AV65adelantoRetGanConCodigo ;
   private String AV50DevGanConCodigo ;
   private String AV59pagosAcuentaConCodigo ;
   private String AV54sacConCodigo ;
   private String AV53sacproporConCodigo ;
   private String AV38sobregiro ;
   private String AV62TliqCodAguinaldo ;
   private String AV63TLiqCodVacaciones ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV48SueldoBrutoPromedioConCodigo ;
   private String GXt_char2 ;
   private String A394DConCodigo ;
   private String AV79TLiqCod ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV78LiqPeriodo ;
   private java.util.Date GXv_date20[] ;
   private java.util.Date AV77vaciaFecha ;
   private boolean AV44completa ;
   private boolean n32TLiqCod ;
   private boolean returnInSub ;
   private boolean n275LiqDImpCalcu ;
   private boolean n274LiqDFormula ;
   private boolean n270LiqDErrorDesc ;
   private boolean GXv_boolean6[] ;
   private String A274LiqDFormula ;
   private String A1072LiqDLogRecal ;
   private String AV37errorSobreGiro ;
   private String A891LiqLegError ;
   private String A270LiqDErrorDesc ;
   private GXSimpleCollection<Integer> AV75coll_LegNumero ;
   private boolean[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private short[] aP7 ;
   private IDataStoreProvider pr_default ;
   private byte[] P003I2_A2360LiqLegNivLiq ;
   private int[] P003I2_A6LegNumero ;
   private int[] P003I2_A31LiqNro ;
   private short[] P003I2_A1EmpCod ;
   private int[] P003I2_A3CliCod ;
   private java.math.BigDecimal[] P003I2_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] P003I2_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] P003I2_A498LiqLegImpTotBruto ;
   private String[] P003I2_A32TLiqCod ;
   private boolean[] P003I2_n32TLiqCod ;
   private java.math.BigDecimal[] P003I2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P003I2_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] P003I2_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] P003I2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P003I2_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] P003I2_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] P003I2_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] P003I2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P003I2_A758LiqLegImpTotBruProm ;
   private short[] P003I2_A499LiqLegCntConc ;
   private String[] P003I2_A891LiqLegError ;
   private byte[] P003I2_A2268LiqLegProcesado ;
   private String[] P003I4_A394DConCodigo ;
   private int[] P003I4_A6LegNumero ;
   private int[] P003I4_A31LiqNro ;
   private short[] P003I4_A1EmpCod ;
   private int[] P003I4_A3CliCod ;
   private byte[] P003I4_A502LiqDMostrar ;
   private java.math.BigDecimal[] P003I4_A275LiqDImpCalcu ;
   private boolean[] P003I4_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P003I4_A764LiqDImpReCalcu ;
   private String[] P003I4_A274LiqDFormula ;
   private boolean[] P003I4_n274LiqDFormula ;
   private String[] P003I4_A270LiqDErrorDesc ;
   private boolean[] P003I4_n270LiqDErrorDesc ;
   private String[] P003I4_A1072LiqDLogRecal ;
   private int[] P003I4_A81LiqDSecuencial ;
}

final  class calculaimporteliquidacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A6LegNumero ,
                                          GXSimpleCollection<Integer> AV75coll_LegNumero ,
                                          String AV80preCalculada ,
                                          byte A2360LiqLegNivLiq ,
                                          int AV10CliCod ,
                                          short AV16EmpCod ,
                                          int AV20LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[3];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT LiqLegNivLiq, LegNumero, LiqNro, EmpCod, CliCod, LiqLegImpBasico, LiqLegImpTotal, LiqLegImpTotBruto, TLiqCod, LiqLegImpTotBruSinSAC, LiqLegImpTotRemu, LiqLegImpTotNoRemu," ;
      scmdbuf += " LiqLegImpTotDescu, LiqLegImpDescuNeg, LiqLegImpOtrDescu, LiqLegImpPagosACuen, LiqLegImpTotRetGan, LiqLegImpTotBruProm, LiqLegCntConc, LiqLegError, LiqLegProcesado" ;
      scmdbuf += " FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75coll_LegNumero, "LegNumero IN (", ")")+")");
      if ( GXutil.strcmp(AV80preCalculada, httpContext.getMessage( "SI", "")) == 0 )
      {
         addWhere(sWhereString, "(LiqLegNivLiq = 1)");
      }
      if ( GXutil.strcmp(AV80preCalculada, httpContext.getMessage( "NO", "")) == 0 )
      {
         addWhere(sWhereString, "(LiqLegNivLiq <> 1)");
      }
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
                  return conditional_P003I2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003I2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P003I3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegImpBasico=?, LiqLegImpTotal=?, LiqLegImpTotBruto=?, LiqLegImpTotBruSinSAC=?, LiqLegImpTotRemu=?, LiqLegImpTotNoRemu=?, LiqLegImpTotDescu=?, LiqLegImpDescuNeg=?, LiqLegImpOtrDescu=?, LiqLegImpPagosACuen=?, LiqLegImpTotRetGan=?, LiqLegImpTotBruProm=?, LiqLegCntConc=?, LiqLegError=?, LiqLegProcesado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P003I4", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDMostrar, LiqDImpCalcu, LiqDImpReCalcu, LiqDFormula, LiqDErrorDesc, LiqDLogRecal, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P003I5", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDMostrar=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDFormula=?, LiqDErrorDesc=?, LiqDLogRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003I6", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDMostrar=?, LiqDImpCalcu=?, LiqDImpReCalcu=?, LiqDFormula=?, LiqDErrorDesc=?, LiqDLogRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((short[]) buf[19])[0] = rslt.getShort(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((byte[]) buf[21])[0] = rslt.getByte(21);
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

