package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class baseimponible_v3 extends GXProcedure
{
   public baseimponible_v3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( baseimponible_v3.class ), "" );
   }

   public baseimponible_v3( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             short aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             short[] aP13 ,
                             String[] aP14 )
   {
      baseimponible_v3.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        short aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        byte[] aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        short[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             short aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             short[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 )
   {
      baseimponible_v3.this.AV19CliCod = aP0;
      baseimponible_v3.this.AV23EmpCod = aP1;
      baseimponible_v3.this.AV25LiqNro = aP2;
      baseimponible_v3.this.AV94LiqRelNro = aP3;
      baseimponible_v3.this.AV24LegNumero = aP4;
      baseimponible_v3.this.AV93ConCodigo = aP5;
      baseimponible_v3.this.AV21LiqPeriodo = aP6;
      baseimponible_v3.this.AV43baseImponibleNro = aP7;
      baseimponible_v3.this.AV79ProcesoLiquidacion = aP8;
      baseimponible_v3.this.AV80insertandoConceptos = aP9;
      baseimponible_v3.this.aP10 = aP10;
      baseimponible_v3.this.aP11 = aP11;
      baseimponible_v3.this.aP12 = aP12;
      baseimponible_v3.this.aP13 = aP13;
      baseimponible_v3.this.aP14 = aP14;
      baseimponible_v3.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( AV43baseImponibleNro == 1 ) || ( AV43baseImponibleNro == 4 ) || ( AV43baseImponibleNro == 5 ) || ( AV43baseImponibleNro == 6 ) || ( AV43baseImponibleNro == 7 ) || ( AV43baseImponibleNro == 24 ) )
      {
         AV45esAporte = true ;
      }
      AV9LiqDCalculado = (byte)(1) ;
      AV10desdeTipoConCod = "NRE_ARG" ;
      AV11hastaTipoConCod = "REM_ARG" ;
      GXt_char1 = AV27subtipoSAC ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
      baseimponible_v3.this.GXt_char1 = GXv_char2[0] ;
      AV27subtipoSAC = GXt_char1 ;
      GXt_char1 = AV28subtipoVacaciones ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
      baseimponible_v3.this.GXt_char1 = GXv_char2[0] ;
      AV28subtipoVacaciones = GXt_char1 ;
      GXt_char1 = AV50subtipo2AdelantoVacaciones ;
      GXv_char2[0] = GXt_char1 ;
      new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char2) ;
      baseimponible_v3.this.GXt_char1 = GXv_char2[0] ;
      AV50subtipo2AdelantoVacaciones = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "1 &baseImponibleNro ", "")+GXutil.trim( GXutil.str( AV43baseImponibleNro, 4, 0))) ;
      if ( ( AV43baseImponibleNro == 24 ) || ( AV43baseImponibleNro == 28 ) )
      {
         GXv_char2[0] = AV97tipo_tarifa ;
         new web.gettipodetarifa(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, (short)(0), "", "", GXv_char2) ;
         baseimponible_v3.this.AV97tipo_tarifa = GXv_char2[0] ;
         if ( GXutil.strcmp(AV97tipo_tarifa, "H") == 0 )
         {
            AV57LiqDLog = httpContext.getMessage( "Al tener configurado tipo de tarifa \"Por hora\" no realiza cálculo", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            GXv_decimal3[0] = AV86LegHorasSem ;
            new web.getleghorassemana(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV24LegNumero, GXv_decimal3) ;
            baseimponible_v3.this.AV86LegHorasSem = GXv_decimal3[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&&LegHorasSem ", "")+GXutil.trim( GXutil.str( AV86LegHorasSem, 4, 1))+httpContext.getMessage( " &Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))) ;
            GXv_decimal3[0] = AV47horasSemanaNormales ;
            new web.gethorassemananormalporlegajo(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV24LegNumero, GXv_decimal3) ;
            baseimponible_v3.this.AV47horasSemanaNormales = GXv_decimal3[0] ;
            if ( DecimalUtil.compareTo(AV86LegHorasSem, AV47horasSemanaNormales) == 0 )
            {
               AV57LiqDLog = httpContext.getMessage( "Al ser jornada completa no realiza cálculo", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      GXt_char1 = AV63adelVacTLiqCod ;
      GXt_char4 = AV63adelVacTLiqCod ;
      GXv_char2[0] = GXt_char4 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
      GXv_char5[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char4, GXv_char5) ;
      baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
      AV63adelVacTLiqCod = GXt_char1 ;
      GXt_char4 = AV64sacTLiqCod ;
      GXt_char1 = AV64sacTLiqCod ;
      GXv_char5[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
      GXv_char2[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
      baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
      AV64sacTLiqCod = GXt_char4 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&esAporte  ", "")+GXutil.trim( GXutil.booltostr( AV45esAporte))) ;
      if ( ! AV45esAporte )
      {
         AV101GXLvl44 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV43baseImponibleNro) ,
                                              Byte.valueOf(A1051LiqDSIPAApo) ,
                                              Byte.valueOf(A1059LiqDRenateaApo) ,
                                              Byte.valueOf(A1053LiqDINSSJyPApo) ,
                                              Byte.valueOf(A1055LiqDObraSocApo) ,
                                              Byte.valueOf(A1057LiqDFonSolRedApo) ,
                                              Byte.valueOf(A1064LiqDRegDifApo) ,
                                              Byte.valueOf(A1065LiqDRegEspApo) ,
                                              Byte.valueOf(A1052LiqDSIPACont) ,
                                              Byte.valueOf(A1054LiqDINSSJyPCont) ,
                                              Byte.valueOf(A1056LiqDObraSocCont) ,
                                              Byte.valueOf(A1058LiqDFonSolRedCont) ,
                                              Byte.valueOf(A1060LiqDRenateaCont) ,
                                              Byte.valueOf(A1061LiqDAsigFamCont) ,
                                              Byte.valueOf(A1062LiqDFonNacEmpCont) ,
                                              Byte.valueOf(A1063LiqDLeyRieTrabCont) ,
                                              A464DTipoConCod ,
                                              AV10desdeTipoConCod ,
                                              AV11hastaTipoConCod ,
                                              Integer.valueOf(AV19CliCod) ,
                                              Short.valueOf(AV23EmpCod) ,
                                              Integer.valueOf(AV25LiqNro) ,
                                              Integer.valueOf(AV24LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P015C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod), Short.valueOf(AV23EmpCod), Integer.valueOf(AV25LiqNro), Integer.valueOf(AV24LegNumero), AV10desdeTipoConCod, AV11hastaTipoConCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1063LiqDLeyRieTrabCont = P015C2_A1063LiqDLeyRieTrabCont[0] ;
            A1062LiqDFonNacEmpCont = P015C2_A1062LiqDFonNacEmpCont[0] ;
            A1061LiqDAsigFamCont = P015C2_A1061LiqDAsigFamCont[0] ;
            A1060LiqDRenateaCont = P015C2_A1060LiqDRenateaCont[0] ;
            A1058LiqDFonSolRedCont = P015C2_A1058LiqDFonSolRedCont[0] ;
            A1056LiqDObraSocCont = P015C2_A1056LiqDObraSocCont[0] ;
            A1054LiqDINSSJyPCont = P015C2_A1054LiqDINSSJyPCont[0] ;
            A1052LiqDSIPACont = P015C2_A1052LiqDSIPACont[0] ;
            A1065LiqDRegEspApo = P015C2_A1065LiqDRegEspApo[0] ;
            A1064LiqDRegDifApo = P015C2_A1064LiqDRegDifApo[0] ;
            A1057LiqDFonSolRedApo = P015C2_A1057LiqDFonSolRedApo[0] ;
            A1055LiqDObraSocApo = P015C2_A1055LiqDObraSocApo[0] ;
            A1053LiqDINSSJyPApo = P015C2_A1053LiqDINSSJyPApo[0] ;
            A1059LiqDRenateaApo = P015C2_A1059LiqDRenateaApo[0] ;
            A1051LiqDSIPAApo = P015C2_A1051LiqDSIPAApo[0] ;
            A464DTipoConCod = P015C2_A464DTipoConCod[0] ;
            A6LegNumero = P015C2_A6LegNumero[0] ;
            A31LiqNro = P015C2_A31LiqNro[0] ;
            A1EmpCod = P015C2_A1EmpCod[0] ;
            A3CliCod = P015C2_A3CliCod[0] ;
            A732DSubTipoConCod2 = P015C2_A732DSubTipoConCod2[0] ;
            n732DSubTipoConCod2 = P015C2_n732DSubTipoConCod2[0] ;
            A468DSubTipoConCod1 = P015C2_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P015C2_n468DSubTipoConCod1[0] ;
            A764LiqDImpReCalcu = P015C2_A764LiqDImpReCalcu[0] ;
            A269LiqDCanti = P015C2_A269LiqDCanti[0] ;
            n269LiqDCanti = P015C2_n269LiqDCanti[0] ;
            A394DConCodigo = P015C2_A394DConCodigo[0] ;
            A507LiqDCalculado = P015C2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P015C2_A763LiqDRecalculado[0] ;
            A393DConDescrip = P015C2_A393DConDescrip[0] ;
            A81LiqDSecuencial = P015C2_A81LiqDSecuencial[0] ;
            AV101GXLvl44 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "DSubTipoConCod1 ", "")+A468DSubTipoConCod1+httpContext.getMessage( " &subtipoSAC ", "")+AV27subtipoSAC+httpContext.getMessage( " DSubTipoConCod2 ", "")+A732DSubTipoConCod2+httpContext.getMessage( " &subtipo2AdelantoVacaciones ", "")+AV50subtipo2AdelantoVacaciones) ;
            if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV27subtipoSAC) != 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV50subtipo2AdelantoVacaciones) != 0 ) )
            {
               AV14SueldoImporte = AV14SueldoImporte.add(A764LiqDImpReCalcu) ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "es algo distinto ", "")) ;
               if ( GXutil.strcmp(A732DSubTipoConCod2, AV50subtipo2AdelantoVacaciones) == 0 )
               {
                  AV29adelantoVacImportes = AV29adelantoVacImportes.add(A764LiqDImpReCalcu) ;
                  AV42dias_vacaciones = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV42dias_vacaciones).add(A269LiqDCanti))) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "es vacaciones ", "")) ;
               }
               else
               {
                  GXt_char4 = AV30subtipo2SACPropor ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.subtipo2sacpropor(remoteHandle, context).execute( GXv_char5) ;
                  baseimponible_v3.this.GXt_char4 = GXv_char5[0] ;
                  AV30subtipo2SACPropor = GXt_char4 ;
                  if ( GXutil.strcmp(A732DSubTipoConCod2, AV30subtipo2SACPropor) == 0 )
                  {
                     AV31sacProporcionalImportes = AV31sacProporcionalImportes.add(A764LiqDImpReCalcu) ;
                  }
                  else
                  {
                     AV32sacImportes = AV32sacImportes.add(A764LiqDImpReCalcu) ;
                  }
               }
            }
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            GXv_int6[0] = AV89auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV19CliCod, A394DConCodigo, AV79ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int6) ;
            baseimponible_v3.this.AV89auxLiqDCalculado = GXv_int6[0] ;
            if ( AV89auxLiqDCalculado == 0 )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
               AV57LiqDLog = AV35error ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "error ", "")+AV35error) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV101GXLvl44 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "none", "")) ;
         }
         if ( AV14SueldoImporte.doubleValue() > 0 )
         {
            AV8Importe = AV14SueldoImporte ;
            AV55baseImportes = AV55baseImportes.add(AV14SueldoImporte) ;
            AV57LiqDLog = httpContext.getMessage( "Inicializa con ", "") + GXutil.trim( GXutil.str( AV14SueldoImporte, 14, 2)) + httpContext.getMessage( " resultado de la suma de los conceptos relacionados a la contribución", "") ;
         }
         if ( AV32sacImportes.doubleValue() > 0 )
         {
            AV8Importe = AV8Importe.add(AV32sacImportes) ;
            AV55baseImportes = AV55baseImportes.add(AV32sacImportes) ;
            if ( AV14SueldoImporte.doubleValue() > 0 )
            {
               AV57LiqDLog += httpContext.getMessage( ". Agrega el SAC por ", "") + GXutil.trim( GXutil.str( AV32sacImportes, 14, 2)) ;
            }
            else
            {
               AV57LiqDLog += httpContext.getMessage( "Inicializa con SAC por ", "") + GXutil.trim( GXutil.str( AV32sacImportes, 14, 2)) ;
            }
         }
         if ( AV31sacProporcionalImportes.doubleValue() > 0 )
         {
            AV8Importe = AV8Importe.add(AV31sacProporcionalImportes) ;
            AV55baseImportes = AV55baseImportes.add(AV31sacProporcionalImportes) ;
            if ( AV14SueldoImporte.doubleValue() > 0 )
            {
               AV57LiqDLog += httpContext.getMessage( ". Agrega el SAC proporcional por ", "") + GXutil.trim( GXutil.str( AV31sacProporcionalImportes, 14, 2)) ;
            }
            else
            {
               AV57LiqDLog += httpContext.getMessage( ". Inicializa con SAC proporcional por ", "") + GXutil.trim( GXutil.str( AV31sacProporcionalImportes, 14, 2)) ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&adelantoVacImportes   ", "")+GXutil.trim( GXutil.str( AV29adelantoVacImportes, 14, 2))) ;
         if ( AV29adelantoVacImportes.doubleValue() > 0 )
         {
            AV8Importe = AV8Importe.add(AV29adelantoVacImportes) ;
            AV55baseImportes = AV55baseImportes.add(AV29adelantoVacImportes) ;
            if ( AV14SueldoImporte.doubleValue() > 0 )
            {
               AV57LiqDLog += httpContext.getMessage( ". Agrega ", "") ;
            }
            else
            {
               /* Execute user subroutine: 'SEPARAR LOG' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV57LiqDLog += httpContext.getMessage( "Inicializa ", "") ;
            }
            AV57LiqDLog += httpContext.getMessage( "valor por adelanto de vacaciones mes próximo ", "") + GXutil.trim( GXutil.str( AV29adelantoVacImportes, 14, 2)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, AV57LiqDLog) ;
         }
      }
      else
      {
         GXv_char5[0] = AV66TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, GXv_char5) ;
         baseimponible_v3.this.AV66TLiqCod = GXv_char5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&TLiqCod ", "")+AV66TLiqCod+httpContext.getMessage( " &adelVacTLiqCod ", "")+AV63adelVacTLiqCod) ;
         if ( GXutil.strcmp(AV66TLiqCod, AV63adelVacTLiqCod) == 0 )
         {
            GXt_char4 = AV77AdelVacProxConCodigo ;
            GXt_char1 = AV77AdelVacProxConCodigo ;
            GXv_char5[0] = GXt_char1 ;
            new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char5) ;
            baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
            baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
            AV77AdelVacProxConCodigo = GXt_char4 ;
            GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean7[0] = AV53existe ;
            GXv_int6[0] = (byte)(0) ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV77AdelVacProxConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal3, GXv_boolean7, GXv_int6) ;
            baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
            AV76adelVacProxEs = AV53existe ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&adelVacProxEs ", "")+GXutil.trim( GXutil.booltostr( AV76adelVacProxEs))) ;
         }
         else
         {
            AV76adelVacProxEs = false ;
         }
         if ( ! AV76adelVacProxEs && ( GXutil.strcmp(AV66TLiqCod, AV64sacTLiqCod) != 0 ) )
         {
            GXv_decimal3[0] = AV68baseImp1SueldoLiqDImpCalcu ;
            GXv_int6[0] = AV89auxLiqDCalculado ;
            GXv_decimal8[0] = AV55baseImportes ;
            GXv_int9[0] = AV56cantidadCalculada ;
            GXv_char5[0] = AV91auxError ;
            GXv_char2[0] = AV92auxLiqDLog ;
            new web.tope_imponible_sueldo(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV94LiqRelNro, AV66TLiqCod, AV64sacTLiqCod, AV63adelVacTLiqCod, AV24LegNumero, AV93ConCodigo, AV21LiqPeriodo, AV43baseImponibleNro, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal3, GXv_int6, GXv_decimal8, GXv_int9, GXv_char5, GXv_char2) ;
            baseimponible_v3.this.AV68baseImp1SueldoLiqDImpCalcu = GXv_decimal3[0] ;
            baseimponible_v3.this.AV89auxLiqDCalculado = GXv_int6[0] ;
            baseimponible_v3.this.AV55baseImportes = GXv_decimal8[0] ;
            baseimponible_v3.this.AV56cantidadCalculada = GXv_int9[0] ;
            baseimponible_v3.this.AV91auxError = GXv_char5[0] ;
            baseimponible_v3.this.AV92auxLiqDLog = GXv_char2[0] ;
            if ( AV89auxLiqDCalculado == 0 )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = GXutil.trim( AV91auxError) ;
               AV57LiqDLog = GXutil.trim( AV35error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV57LiqDLog += AV92auxLiqDLog ;
            AV8Importe = AV8Importe.add(AV68baseImp1SueldoLiqDImpCalcu) ;
         }
         GXv_char5[0] = AV88liquidaSacConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_liquidasac_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         baseimponible_v3.this.AV88liquidaSacConCodigo = GXv_char5[0] ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(AV87liquidaSac) ;
         GXv_boolean7[0] = AV53existe ;
         GXv_int6[0] = AV89auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV88liquidaSacConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal8, GXv_boolean7, GXv_int6) ;
         baseimponible_v3.this.AV87liquidaSac = (short)(DecimalUtil.decToDouble(GXv_decimal8[0])) ;
         baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
         baseimponible_v3.this.AV89auxLiqDCalculado = GXv_int6[0] ;
         if ( AV53existe )
         {
            if ( AV89auxLiqDCalculado == 0 )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV88liquidaSacConCodigo) ;
               AV57LiqDLog = AV35error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            GXv_int6[0] = (byte)(AV87liquidaSac) ;
            GXv_char5[0] = "" ;
            new web.liquidar_sac(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV66TLiqCod, AV21LiqPeriodo, GXv_int6, GXv_char5) ;
            baseimponible_v3.this.AV87liquidaSac = GXv_int6[0] ;
         }
         if ( AV87liquidaSac == 1 )
         {
            GXt_char4 = AV70baseImpSacConCodigo ;
            GXt_char1 = AV70baseImpSacConCodigo ;
            GXv_char5[0] = GXt_char1 ;
            new web.concepto_topeimponiblesac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
            baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
            baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
            AV70baseImpSacConCodigo = GXt_char4 ;
            GXv_decimal8[0] = AV71baseImpSacLiqDImpCalcu ;
            GXv_boolean7[0] = AV53existe ;
            GXv_int6[0] = AV72baseImpSacLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV70baseImpSacConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal8, GXv_boolean7, GXv_int6) ;
            baseimponible_v3.this.AV71baseImpSacLiqDImpCalcu = GXv_decimal8[0] ;
            baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
            baseimponible_v3.this.AV72baseImpSacLiqDCalculado = GXv_int6[0] ;
            if ( ( AV72baseImpSacLiqDCalculado == 0 ) && ( AV53existe ) )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV70baseImpSacConCodigo) + httpContext.getMessage( " para base imponible SAC", "") ;
               AV57LiqDLog = AV35error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV71baseImpSacLiqDImpCalcu.doubleValue() > 0 )
            {
               if ( (GXutil.strcmp("", AV57LiqDLog)==0) )
               {
                  AV57LiqDLog = httpContext.getMessage( "Inicializa ", "") ;
               }
               else
               {
                  AV57LiqDLog += httpContext.getMessage( ". Suma ", "") ;
               }
               AV57LiqDLog += httpContext.getMessage( "valor ", "") + GXutil.trim( GXutil.str( AV71baseImpSacLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( AV70baseImpSacConCodigo) + httpContext.getMessage( " base imponible SAC", "") ;
            }
            AV8Importe = AV8Importe.add(AV71baseImpSacLiqDImpCalcu) ;
         }
         GXv_char5[0] = AV77AdelVacProxConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         baseimponible_v3.this.AV77AdelVacProxConCodigo = GXv_char5[0] ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean7[0] = AV53existe ;
         GXv_int6[0] = AV89auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV77AdelVacProxConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal8, GXv_boolean7, GXv_int6) ;
         baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
         baseimponible_v3.this.AV89auxLiqDCalculado = GXv_int6[0] ;
         if ( ( AV89auxLiqDCalculado == 0 ) && ( AV53existe ) )
         {
            AV9LiqDCalculado = (byte)(0) ;
            AV35error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV77AdelVacProxConCodigo) ;
            AV57LiqDLog = AV35error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "asasdfdasfd &existe ", "")+GXutil.trim( GXutil.booltostr( AV53existe))) ;
         if ( AV53existe )
         {
            GXt_char4 = AV73baseImpVacConCodigo ;
            GXt_char1 = AV73baseImpVacConCodigo ;
            GXv_char5[0] = GXt_char1 ;
            new web.concepto_topeimponibleadelvac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
            baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
            baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
            AV73baseImpVacConCodigo = GXt_char4 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&baseImpVacConCodigo ", "")+AV73baseImpVacConCodigo) ;
            GXv_decimal8[0] = AV74baseImpVacLiqDImpCalcu ;
            GXv_boolean7[0] = AV53existe ;
            GXv_int6[0] = AV75baseImpVacLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV73baseImpVacConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal8, GXv_boolean7, GXv_int6) ;
            baseimponible_v3.this.AV74baseImpVacLiqDImpCalcu = GXv_decimal8[0] ;
            baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
            baseimponible_v3.this.AV75baseImpVacLiqDCalculado = GXv_int6[0] ;
            AV78logAuxTexto = httpContext.getMessage( "&baseImpVacConCodigo ", "") + AV73baseImpVacConCodigo + httpContext.getMessage( " &baseImpVacLiqDImpCalcu ", "") + GXutil.trim( GXutil.str( AV74baseImpVacLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " &baseImpVacLiqDCalculado ", "") + GXutil.trim( GXutil.str( AV75baseImpVacLiqDCalculado, 1, 0)) ;
            if ( ( AV75baseImpVacLiqDCalculado == 0 ) && ( AV53existe ) )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV73baseImpVacConCodigo) + httpContext.getMessage( " para base imponible adelanto de vacaciones", "") ;
               AV78logAuxTexto += httpContext.getMessage( " error", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV74baseImpVacLiqDImpCalcu.doubleValue() > 0 )
            {
               if ( (GXutil.strcmp("", AV57LiqDLog)==0) )
               {
                  AV57LiqDLog = httpContext.getMessage( "Inicializa ", "") ;
               }
               else
               {
                  AV57LiqDLog += httpContext.getMessage( ". Suma ", "") ;
               }
               AV57LiqDLog += httpContext.getMessage( "valor ", "") + GXutil.trim( GXutil.str( AV74baseImpVacLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( AV73baseImpVacConCodigo) + httpContext.getMessage( " base imponible adelanto de vacaciones", "") ;
            }
            AV8Importe = AV8Importe.add(AV74baseImpVacLiqDImpCalcu) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "suma ", "")+GXutil.trim( GXutil.str( AV74baseImpVacLiqDImpCalcu, 14, 2))) ;
         }
      }
      if ( ( AV43baseImponibleNro == 24 ) || ( AV43baseImponibleNro == 28 ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&baseImponibleNro ", "")+GXutil.trim( GXutil.str( AV43baseImponibleNro, 4, 0))+httpContext.getMessage( " &Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))) ;
         AV8Importe = AV8Importe.divide(AV86LegHorasSem, 18, java.math.RoundingMode.DOWN) ;
         AV8Importe = AV8Importe.multiply(AV47horasSemanaNormales) ;
         if ( DecimalUtil.compareTo(AV86LegHorasSem, AV47horasSemanaNormales) != 0 )
         {
            AV57LiqDLog += httpContext.getMessage( ". Por ser jornada parcial se divide entre ", "") + GXutil.trim( GXutil.str( AV86LegHorasSem, 4, 1)) + httpContext.getMessage( " de las horas semanales y se multiplica por ", "") + GXutil.trim( GXutil.str( AV47horasSemanaNormales, 5, 1)) + httpContext.getMessage( " que son las horas semanales normales", "") ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&horasSemanaNormales ", "")+GXutil.trim( GXutil.str( AV47horasSemanaNormales, 5, 1))+httpContext.getMessage( " &Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))) ;
         if ( AV43baseImponibleNro == 24 )
         {
            GXt_char4 = AV49baseImp4ConCodigo ;
            GXt_char1 = AV49baseImp4ConCodigo ;
            GXv_char5[0] = GXt_char1 ;
            new web.parametro_concepto_lsd_baseimponible4(remoteHandle, context).execute( GXv_char5) ;
            baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
            baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
            AV49baseImp4ConCodigo = GXt_char4 ;
         }
         else
         {
            GXt_char4 = AV49baseImp4ConCodigo ;
            GXt_char1 = AV49baseImp4ConCodigo ;
            GXv_char5[0] = GXt_char1 ;
            new web.parametro_concepto_lsd_baseimponible8(remoteHandle, context).execute( GXv_char5) ;
            baseimponible_v3.this.GXt_char1 = GXv_char5[0] ;
            GXv_char2[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
            baseimponible_v3.this.GXt_char4 = GXv_char2[0] ;
            AV49baseImp4ConCodigo = GXt_char4 ;
         }
         GXv_decimal8[0] = AV48baseImp4LiqDImpCalcu ;
         GXv_boolean7[0] = AV53existe ;
         GXv_int6[0] = AV89auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV49baseImp4ConCodigo, AV79ProcesoLiquidacion, AV80insertandoConceptos, GXv_decimal8, GXv_boolean7, GXv_int6) ;
         baseimponible_v3.this.AV48baseImp4LiqDImpCalcu = GXv_decimal8[0] ;
         baseimponible_v3.this.AV53existe = GXv_boolean7[0] ;
         baseimponible_v3.this.AV89auxLiqDCalculado = GXv_int6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, "11") ;
         if ( ( AV89auxLiqDCalculado == 0 ) && ( AV53existe ) )
         {
            AV9LiqDCalculado = (byte)(0) ;
            AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( AV49baseImp4ConCodigo) ;
            AV57LiqDLog = GXutil.trim( AV35error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, "12") ;
         AV8Importe = AV8Importe.subtract(AV48baseImp4LiqDImpCalcu) ;
         AV57LiqDLog += httpContext.getMessage( ". Se resta el valor de la base imponible 4 ", "") + GXutil.trim( GXutil.str( AV48baseImp4LiqDImpCalcu, 14, 2)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV100Pgmname, httpContext.getMessage( "&baseImp4LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV48baseImp4LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))) ;
      }
      else
      {
      }
      GXv_char5[0] = AV35error ;
      GXv_char2[0] = AV57LiqDLog ;
      GXv_int6[0] = AV9LiqDCalculado ;
      new web.darerrormenorcero(remoteHandle, context).execute( AV8Importe, GXv_char5, GXv_char2, GXv_int6) ;
      baseimponible_v3.this.AV35error = GXv_char5[0] ;
      baseimponible_v3.this.AV57LiqDLog = GXv_char2[0] ;
      baseimponible_v3.this.AV9LiqDCalculado = GXv_int6[0] ;
      cleanup();
   }

   public void S111( )
   {
      /* 'SEPARAR LOG' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV57LiqDLog)==0) )
      {
         AV57LiqDLog += ". " ;
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = baseimponible_v3.this.AV8Importe;
      this.aP11[0] = baseimponible_v3.this.AV9LiqDCalculado;
      this.aP12[0] = baseimponible_v3.this.AV55baseImportes;
      this.aP13[0] = baseimponible_v3.this.AV56cantidadCalculada;
      this.aP14[0] = baseimponible_v3.this.AV35error;
      this.aP15[0] = baseimponible_v3.this.AV57LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Importe = DecimalUtil.ZERO ;
      AV55baseImportes = DecimalUtil.ZERO ;
      AV35error = "" ;
      AV57LiqDLog = "" ;
      AV10desdeTipoConCod = "" ;
      AV11hastaTipoConCod = "" ;
      AV27subtipoSAC = "" ;
      AV28subtipoVacaciones = "" ;
      AV50subtipo2AdelantoVacaciones = "" ;
      AV100Pgmname = "" ;
      AV97tipo_tarifa = "" ;
      AV86LegHorasSem = DecimalUtil.ZERO ;
      AV47horasSemanaNormales = DecimalUtil.ZERO ;
      AV63adelVacTLiqCod = "" ;
      AV64sacTLiqCod = "" ;
      scmdbuf = "" ;
      A464DTipoConCod = "" ;
      P015C2_A1063LiqDLeyRieTrabCont = new byte[1] ;
      P015C2_A1062LiqDFonNacEmpCont = new byte[1] ;
      P015C2_A1061LiqDAsigFamCont = new byte[1] ;
      P015C2_A1060LiqDRenateaCont = new byte[1] ;
      P015C2_A1058LiqDFonSolRedCont = new byte[1] ;
      P015C2_A1056LiqDObraSocCont = new byte[1] ;
      P015C2_A1054LiqDINSSJyPCont = new byte[1] ;
      P015C2_A1052LiqDSIPACont = new byte[1] ;
      P015C2_A1065LiqDRegEspApo = new byte[1] ;
      P015C2_A1064LiqDRegDifApo = new byte[1] ;
      P015C2_A1057LiqDFonSolRedApo = new byte[1] ;
      P015C2_A1055LiqDObraSocApo = new byte[1] ;
      P015C2_A1053LiqDINSSJyPApo = new byte[1] ;
      P015C2_A1059LiqDRenateaApo = new byte[1] ;
      P015C2_A1051LiqDSIPAApo = new byte[1] ;
      P015C2_A464DTipoConCod = new String[] {""} ;
      P015C2_A6LegNumero = new int[1] ;
      P015C2_A31LiqNro = new int[1] ;
      P015C2_A1EmpCod = new short[1] ;
      P015C2_A3CliCod = new int[1] ;
      P015C2_A732DSubTipoConCod2 = new String[] {""} ;
      P015C2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P015C2_A468DSubTipoConCod1 = new String[] {""} ;
      P015C2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P015C2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P015C2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P015C2_n269LiqDCanti = new boolean[] {false} ;
      P015C2_A394DConCodigo = new String[] {""} ;
      P015C2_A507LiqDCalculado = new byte[1] ;
      P015C2_A763LiqDRecalculado = new short[1] ;
      P015C2_A393DConDescrip = new String[] {""} ;
      P015C2_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV14SueldoImporte = DecimalUtil.ZERO ;
      AV29adelantoVacImportes = DecimalUtil.ZERO ;
      AV30subtipo2SACPropor = "" ;
      AV31sacProporcionalImportes = DecimalUtil.ZERO ;
      AV32sacImportes = DecimalUtil.ZERO ;
      AV66TLiqCod = "" ;
      AV77AdelVacProxConCodigo = "" ;
      AV68baseImp1SueldoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_int9 = new short[1] ;
      AV91auxError = "" ;
      AV92auxLiqDLog = "" ;
      AV88liquidaSacConCodigo = "" ;
      AV70baseImpSacConCodigo = "" ;
      AV71baseImpSacLiqDImpCalcu = DecimalUtil.ZERO ;
      AV73baseImpVacConCodigo = "" ;
      AV74baseImpVacLiqDImpCalcu = DecimalUtil.ZERO ;
      AV78logAuxTexto = "" ;
      AV49baseImp4ConCodigo = "" ;
      GXt_char4 = "" ;
      GXt_char1 = "" ;
      AV48baseImp4LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_char5 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_int6 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.baseimponible_v3__default(),
         new Object[] {
             new Object[] {
            P015C2_A1063LiqDLeyRieTrabCont, P015C2_A1062LiqDFonNacEmpCont, P015C2_A1061LiqDAsigFamCont, P015C2_A1060LiqDRenateaCont, P015C2_A1058LiqDFonSolRedCont, P015C2_A1056LiqDObraSocCont, P015C2_A1054LiqDINSSJyPCont, P015C2_A1052LiqDSIPACont, P015C2_A1065LiqDRegEspApo, P015C2_A1064LiqDRegDifApo,
            P015C2_A1057LiqDFonSolRedApo, P015C2_A1055LiqDObraSocApo, P015C2_A1053LiqDINSSJyPApo, P015C2_A1059LiqDRenateaApo, P015C2_A1051LiqDSIPAApo, P015C2_A464DTipoConCod, P015C2_A6LegNumero, P015C2_A31LiqNro, P015C2_A1EmpCod, P015C2_A3CliCod,
            P015C2_A732DSubTipoConCod2, P015C2_n732DSubTipoConCod2, P015C2_A468DSubTipoConCod1, P015C2_n468DSubTipoConCod1, P015C2_A764LiqDImpReCalcu, P015C2_A269LiqDCanti, P015C2_n269LiqDCanti, P015C2_A394DConCodigo, P015C2_A507LiqDCalculado, P015C2_A763LiqDRecalculado,
            P015C2_A393DConDescrip, P015C2_A81LiqDSecuencial
            }
         }
      );
      AV100Pgmname = "baseImponible_v3" ;
      /* GeneXus formulas. */
      AV100Pgmname = "baseImponible_v3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private byte AV101GXLvl44 ;
   private byte A1051LiqDSIPAApo ;
   private byte A1059LiqDRenateaApo ;
   private byte A1053LiqDINSSJyPApo ;
   private byte A1055LiqDObraSocApo ;
   private byte A1057LiqDFonSolRedApo ;
   private byte A1064LiqDRegDifApo ;
   private byte A1065LiqDRegEspApo ;
   private byte A1052LiqDSIPACont ;
   private byte A1054LiqDINSSJyPCont ;
   private byte A1056LiqDObraSocCont ;
   private byte A1058LiqDFonSolRedCont ;
   private byte A1060LiqDRenateaCont ;
   private byte A1061LiqDAsigFamCont ;
   private byte A1062LiqDFonNacEmpCont ;
   private byte A1063LiqDLeyRieTrabCont ;
   private byte A507LiqDCalculado ;
   private byte AV89auxLiqDCalculado ;
   private byte AV72baseImpSacLiqDCalculado ;
   private byte AV75baseImpVacLiqDCalculado ;
   private byte GXv_int6[] ;
   private short AV23EmpCod ;
   private short AV43baseImponibleNro ;
   private short AV56cantidadCalculada ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV42dias_vacaciones ;
   private short GXv_int9[] ;
   private short AV87liquidaSac ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV25LiqNro ;
   private int AV94LiqRelNro ;
   private int AV24LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV8Importe ;
   private java.math.BigDecimal AV55baseImportes ;
   private java.math.BigDecimal AV86LegHorasSem ;
   private java.math.BigDecimal AV47horasSemanaNormales ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV14SueldoImporte ;
   private java.math.BigDecimal AV29adelantoVacImportes ;
   private java.math.BigDecimal AV31sacProporcionalImportes ;
   private java.math.BigDecimal AV32sacImportes ;
   private java.math.BigDecimal AV68baseImp1SueldoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV71baseImpSacLiqDImpCalcu ;
   private java.math.BigDecimal AV74baseImpVacLiqDImpCalcu ;
   private java.math.BigDecimal AV48baseImp4LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV93ConCodigo ;
   private String AV79ProcesoLiquidacion ;
   private String AV10desdeTipoConCod ;
   private String AV11hastaTipoConCod ;
   private String AV27subtipoSAC ;
   private String AV28subtipoVacaciones ;
   private String AV50subtipo2AdelantoVacaciones ;
   private String AV100Pgmname ;
   private String AV97tipo_tarifa ;
   private String AV63adelVacTLiqCod ;
   private String AV64sacTLiqCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private String AV30subtipo2SACPropor ;
   private String AV66TLiqCod ;
   private String AV77AdelVacProxConCodigo ;
   private String AV88liquidaSacConCodigo ;
   private String AV70baseImpSacConCodigo ;
   private String AV73baseImpVacConCodigo ;
   private String AV49baseImp4ConCodigo ;
   private String GXt_char4 ;
   private String GXt_char1 ;
   private String GXv_char5[] ;
   private String GXv_char2[] ;
   private java.util.Date AV21LiqPeriodo ;
   private boolean AV80insertandoConceptos ;
   private boolean AV45esAporte ;
   private boolean returnInSub ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean AV53existe ;
   private boolean AV76adelVacProxEs ;
   private boolean GXv_boolean7[] ;
   private String AV57LiqDLog ;
   private String AV92auxLiqDLog ;
   private String AV35error ;
   private String A393DConDescrip ;
   private String AV91auxError ;
   private String AV78logAuxTexto ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP10 ;
   private byte[] aP11 ;
   private java.math.BigDecimal[] aP12 ;
   private short[] aP13 ;
   private String[] aP14 ;
   private IDataStoreProvider pr_default ;
   private byte[] P015C2_A1063LiqDLeyRieTrabCont ;
   private byte[] P015C2_A1062LiqDFonNacEmpCont ;
   private byte[] P015C2_A1061LiqDAsigFamCont ;
   private byte[] P015C2_A1060LiqDRenateaCont ;
   private byte[] P015C2_A1058LiqDFonSolRedCont ;
   private byte[] P015C2_A1056LiqDObraSocCont ;
   private byte[] P015C2_A1054LiqDINSSJyPCont ;
   private byte[] P015C2_A1052LiqDSIPACont ;
   private byte[] P015C2_A1065LiqDRegEspApo ;
   private byte[] P015C2_A1064LiqDRegDifApo ;
   private byte[] P015C2_A1057LiqDFonSolRedApo ;
   private byte[] P015C2_A1055LiqDObraSocApo ;
   private byte[] P015C2_A1053LiqDINSSJyPApo ;
   private byte[] P015C2_A1059LiqDRenateaApo ;
   private byte[] P015C2_A1051LiqDSIPAApo ;
   private String[] P015C2_A464DTipoConCod ;
   private int[] P015C2_A6LegNumero ;
   private int[] P015C2_A31LiqNro ;
   private short[] P015C2_A1EmpCod ;
   private int[] P015C2_A3CliCod ;
   private String[] P015C2_A732DSubTipoConCod2 ;
   private boolean[] P015C2_n732DSubTipoConCod2 ;
   private String[] P015C2_A468DSubTipoConCod1 ;
   private boolean[] P015C2_n468DSubTipoConCod1 ;
   private java.math.BigDecimal[] P015C2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P015C2_A269LiqDCanti ;
   private boolean[] P015C2_n269LiqDCanti ;
   private String[] P015C2_A394DConCodigo ;
   private byte[] P015C2_A507LiqDCalculado ;
   private short[] P015C2_A763LiqDRecalculado ;
   private String[] P015C2_A393DConDescrip ;
   private int[] P015C2_A81LiqDSecuencial ;
}

final  class baseimponible_v3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P015C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV43baseImponibleNro ,
                                          byte A1051LiqDSIPAApo ,
                                          byte A1059LiqDRenateaApo ,
                                          byte A1053LiqDINSSJyPApo ,
                                          byte A1055LiqDObraSocApo ,
                                          byte A1057LiqDFonSolRedApo ,
                                          byte A1064LiqDRegDifApo ,
                                          byte A1065LiqDRegEspApo ,
                                          byte A1052LiqDSIPACont ,
                                          byte A1054LiqDINSSJyPCont ,
                                          byte A1056LiqDObraSocCont ,
                                          byte A1058LiqDFonSolRedCont ,
                                          byte A1060LiqDRenateaCont ,
                                          byte A1061LiqDAsigFamCont ,
                                          byte A1062LiqDFonNacEmpCont ,
                                          byte A1063LiqDLeyRieTrabCont ,
                                          String A464DTipoConCod ,
                                          String AV10desdeTipoConCod ,
                                          String AV11hastaTipoConCod ,
                                          int AV19CliCod ,
                                          short AV23EmpCod ,
                                          int AV25LiqNro ,
                                          int AV24LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[6];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT LiqDLeyRieTrabCont, LiqDFonNacEmpCont, LiqDAsigFamCont, LiqDRenateaCont, LiqDFonSolRedCont, LiqDObraSocCont, LiqDINSSJyPCont, LiqDSIPACont, LiqDRegEspApo," ;
      scmdbuf += " LiqDRegDifApo, LiqDFonSolRedApo, LiqDObraSocApo, LiqDINSSJyPApo, LiqDRenateaApo, LiqDSIPAApo, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, DSubTipoConCod2, DSubTipoConCod1," ;
      scmdbuf += " LiqDImpReCalcu, LiqDCanti, DConCodigo, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(DTipoConCod >= ( ?))");
      addWhere(sWhereString, "(DTipoConCod <= ( ?))");
      if ( AV43baseImponibleNro == 1 )
      {
         addWhere(sWhereString, "(LiqDSIPAApo = 1 or LiqDRenateaApo = 1)");
      }
      if ( AV43baseImponibleNro == 5 )
      {
         addWhere(sWhereString, "(LiqDINSSJyPApo = 1)");
      }
      if ( ( AV43baseImponibleNro == 4 ) || ( AV43baseImponibleNro == 24 ) )
      {
         addWhere(sWhereString, "(LiqDObraSocApo = 1 or LiqDFonSolRedApo = 1)");
      }
      if ( AV43baseImponibleNro == 6 )
      {
         addWhere(sWhereString, "(LiqDRegDifApo = 1)");
      }
      if ( AV43baseImponibleNro == 7 )
      {
         addWhere(sWhereString, "(LiqDRegEspApo = 1)");
      }
      if ( AV43baseImponibleNro == 2 )
      {
         addWhere(sWhereString, "(LiqDSIPACont = 1 or LiqDINSSJyPCont = 1)");
      }
      if ( ( AV43baseImponibleNro == 8 ) || ( AV43baseImponibleNro == 28 ) )
      {
         addWhere(sWhereString, "(LiqDObraSocCont = 1 or LiqDFonSolRedCont = 1)");
      }
      if ( AV43baseImponibleNro == 3 )
      {
         addWhere(sWhereString, "(LiqDRenateaCont = 1 or LiqDAsigFamCont = 1 or LiqDFonNacEmpCont = 1)");
      }
      if ( AV43baseImponibleNro == 9 )
      {
         addWhere(sWhereString, "(LiqDLeyRieTrabCont = 1)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P015C2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).byteValue() , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P015C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(24,2);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getString(25, 10);
               ((byte[]) buf[28])[0] = rslt.getByte(26);
               ((short[]) buf[29])[0] = rslt.getShort(27);
               ((String[]) buf[30])[0] = rslt.getVarchar(28);
               ((int[]) buf[31])[0] = rslt.getInt(29);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

