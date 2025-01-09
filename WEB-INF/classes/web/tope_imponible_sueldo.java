package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tope_imponible_sueldo extends GXProcedure
{
   public tope_imponible_sueldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tope_imponible_sueldo.class ), "" );
   }

   public tope_imponible_sueldo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             int aP7 ,
                             String aP8 ,
                             java.util.Date aP9 ,
                             short aP10 ,
                             String aP11 ,
                             boolean aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             short[] aP16 ,
                             String[] aP17 )
   {
      tope_imponible_sueldo.this.aP18 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        int aP7 ,
                        String aP8 ,
                        java.util.Date aP9 ,
                        short aP10 ,
                        String aP11 ,
                        boolean aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        byte[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        short[] aP16 ,
                        String[] aP17 ,
                        String[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             int aP7 ,
                             String aP8 ,
                             java.util.Date aP9 ,
                             short aP10 ,
                             String aP11 ,
                             boolean aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             short[] aP16 ,
                             String[] aP17 ,
                             String[] aP18 )
   {
      tope_imponible_sueldo.this.AV19CliCod = aP0;
      tope_imponible_sueldo.this.AV23EmpCod = aP1;
      tope_imponible_sueldo.this.AV25LiqNro = aP2;
      tope_imponible_sueldo.this.AV86LiqRelNro = aP3;
      tope_imponible_sueldo.this.AV83TLiqCod = aP4;
      tope_imponible_sueldo.this.AV84sacTLiqCod = aP5;
      tope_imponible_sueldo.this.AV85adelVacTLiqCod = aP6;
      tope_imponible_sueldo.this.AV24LegNumero = aP7;
      tope_imponible_sueldo.this.AV82ConCodigo = aP8;
      tope_imponible_sueldo.this.AV21LiqPeriodo = aP9;
      tope_imponible_sueldo.this.AV43baseImponibleNro = aP10;
      tope_imponible_sueldo.this.AV74ProcesoLiquidacion = aP11;
      tope_imponible_sueldo.this.AV75insertandoConceptos = aP12;
      tope_imponible_sueldo.this.aP13 = aP13;
      tope_imponible_sueldo.this.aP14 = aP14;
      tope_imponible_sueldo.this.aP15 = aP15;
      tope_imponible_sueldo.this.aP16 = aP16;
      tope_imponible_sueldo.this.aP17 = aP17;
      tope_imponible_sueldo.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV45esAporte = true ;
      AV9LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV78jubConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoconceptojubilacion(remoteHandle, context).execute( AV19CliCod, GXv_char2) ;
      tope_imponible_sueldo.this.GXt_char1 = GXv_char2[0] ;
      AV78jubConCodigo = GXt_char1 ;
      GXv_decimal3[0] = AV79LiqDValUni ;
      GXv_boolean4[0] = (boolean)((0==0)?false:true) ;
      GXv_int5[0] = AV77auxLiqDCalculado ;
      new web.getliqdimpbase(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV78jubConCodigo, AV74ProcesoLiquidacion, GXv_decimal3, GXv_boolean4, GXv_int5) ;
      tope_imponible_sueldo.this.AV79LiqDValUni = GXv_decimal3[0] ;
      tope_imponible_sueldo.this.AV77auxLiqDCalculado = GXv_int5[0] ;
      AV10desdeTipoConCod = "NRE_ARG" ;
      AV11hastaTipoConCod = "REM_ARG" ;
      if ( AV77auxLiqDCalculado == 1 )
      {
         if ( ( AV43baseImponibleNro == 1 ) || ( AV43baseImponibleNro == 4 ) || ( AV43baseImponibleNro == 5 ) )
         {
            AV8Importe = AV79LiqDValUni ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, "1") ;
            AV57LiqDLog = httpContext.getMessage( "Se inicializa con valor de importe de jubilación ", "") + GXutil.trim( GXutil.str( AV8Importe, 14, 2)) ;
            AV57LiqDLog += httpContext.getMessage( " por haberse calculado en modo de liquidación básica para optimizar performance", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV57LiqDLog = httpContext.getMessage( "No se calcula base imponible ", "") + GXutil.trim( GXutil.str( AV43baseImponibleNro, 4, 0)) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      GXt_char1 = AV27subtipoSAC ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_sueldo.this.GXt_char1 = GXv_char2[0] ;
      AV27subtipoSAC = GXt_char1 ;
      GXt_char1 = AV50subtipo2AdelantoVacaciones ;
      GXv_char2[0] = GXt_char1 ;
      new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_sueldo.this.GXt_char1 = GXv_char2[0] ;
      AV50subtipo2AdelantoVacaciones = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "1 &baseImponibleNro ", "")+GXutil.trim( GXutil.str( AV43baseImponibleNro, 4, 0))+httpContext.getMessage( " &desdeTipoConCod ", "")+GXutil.trim( AV10desdeTipoConCod)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV19CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV23EmpCod, 4, 0))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV21LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV24LegNumero, 8, 0))+httpContext.getMessage( " &hastaTipoConCod ", "")+GXutil.trim( AV11hastaTipoConCod)+httpContext.getMessage( " &subtipoSAC ", "")+AV27subtipoSAC+httpContext.getMessage( " &subtipo2AdelantoVacaciones ", "")+GXutil.trim( AV50subtipo2AdelantoVacaciones)+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV25LiqNro, 8, 0))) ;
      GXt_char1 = AV51DescuentoAdelanVacConCodigo ;
      GXt_char6 = AV51DescuentoAdelanVacConCodigo ;
      GXv_char2[0] = GXt_char6 ;
      new web.concepto_vacaciones_descu_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_sueldo.this.GXt_char6 = GXv_char2[0] ;
      GXv_char7[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char6, GXv_char7) ;
      tope_imponible_sueldo.this.GXt_char1 = GXv_char7[0] ;
      AV51DescuentoAdelanVacConCodigo = GXt_char1 ;
      AV68importesLog = "" ;
      AV91GXLvl59 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV43baseImponibleNro) ,
                                           Byte.valueOf(A1051LiqDSIPAApo) ,
                                           Byte.valueOf(A1059LiqDRenateaApo) ,
                                           Byte.valueOf(A1053LiqDINSSJyPApo) ,
                                           Byte.valueOf(A1055LiqDObraSocApo) ,
                                           Byte.valueOf(A1057LiqDFonSolRedApo) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV25LiqNro) ,
                                           A464DTipoConCod ,
                                           AV10desdeTipoConCod ,
                                           AV11hastaTipoConCod ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV86LiqRelNro) ,
                                           A397DLiqPeriodo ,
                                           AV21LiqPeriodo ,
                                           Integer.valueOf(AV19CliCod) ,
                                           Short.valueOf(AV23EmpCod) ,
                                           Integer.valueOf(AV24LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01562 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod), Short.valueOf(AV23EmpCod), Integer.valueOf(AV24LegNumero), Integer.valueOf(AV25LiqNro), AV10desdeTipoConCod, AV11hastaTipoConCod, Integer.valueOf(AV86LiqRelNro), AV21LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01562_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01562_n2112LiqRelNro[0] ;
         A1057LiqDFonSolRedApo = P01562_A1057LiqDFonSolRedApo[0] ;
         A1055LiqDObraSocApo = P01562_A1055LiqDObraSocApo[0] ;
         A1053LiqDINSSJyPApo = P01562_A1053LiqDINSSJyPApo[0] ;
         A1059LiqDRenateaApo = P01562_A1059LiqDRenateaApo[0] ;
         A1051LiqDSIPAApo = P01562_A1051LiqDSIPAApo[0] ;
         A464DTipoConCod = P01562_A464DTipoConCod[0] ;
         A6LegNumero = P01562_A6LegNumero[0] ;
         A397DLiqPeriodo = P01562_A397DLiqPeriodo[0] ;
         A31LiqNro = P01562_A31LiqNro[0] ;
         A1EmpCod = P01562_A1EmpCod[0] ;
         A3CliCod = P01562_A3CliCod[0] ;
         A732DSubTipoConCod2 = P01562_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01562_n732DSubTipoConCod2[0] ;
         A468DSubTipoConCod1 = P01562_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01562_n468DSubTipoConCod1[0] ;
         A507LiqDCalculado = P01562_A507LiqDCalculado[0] ;
         A764LiqDImpReCalcu = P01562_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P01562_A394DConCodigo[0] ;
         A763LiqDRecalculado = P01562_A763LiqDRecalculado[0] ;
         A393DConDescrip = P01562_A393DConDescrip[0] ;
         A81LiqDSecuencial = P01562_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01562_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01562_n2112LiqRelNro[0] ;
         AV91GXLvl59 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "hay", "")) ;
         if ( A31LiqNro < AV25LiqNro )
         {
            AV13aplica = true ;
         }
         else
         {
            if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV27subtipoSAC) != 0 ) && ( ( GXutil.strcmp(A732DSubTipoConCod2, AV50subtipo2AdelantoVacaciones) != 0 ) || P01562_n732DSubTipoConCod2[0] ) )
            {
               AV13aplica = true ;
            }
            else
            {
               AV13aplica = false ;
            }
         }
         if ( AV13aplica )
         {
            AV68importesLog += httpContext.getMessage( " recorre ", "") + A394DConCodigo + httpContext.getMessage( " por ", "") + GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2)) + httpContext.getMessage( " &aplica ", "") + GXutil.trim( GXutil.booltostr( AV13aplica)) + httpContext.getMessage( " LiqDCalculado ", "") + GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0)) ;
            AV14SueldoImporte = AV14SueldoImporte.add(A764LiqDImpReCalcu) ;
            AV68importesLog += httpContext.getMessage( " &SueldoImporte ", "") + GXutil.trim( GXutil.str( AV14SueldoImporte, 14, 2)) ;
            if ( GXutil.strcmp(A394DConCodigo, AV51DescuentoAdelanVacConCodigo) == 0 )
            {
               AV67descuHay = true ;
            }
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&&importesLog ", "")+AV68importesLog) ;
            GXv_int5[0] = AV77auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV19CliCod, A394DConCodigo, AV74ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
            tope_imponible_sueldo.this.AV77auxLiqDCalculado = GXv_int5[0] ;
            if ( AV77auxLiqDCalculado == 0 )
            {
               AV9LiqDCalculado = (byte)(0) ;
               AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
               AV68importesLog += httpContext.getMessage( " return ", "") + GXutil.trim( A394DConCodigo) ;
               AV57LiqDLog += GXutil.trim( AV35error) + " " + GXutil.trim( AV68importesLog) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&error ", "")+AV35error) ;
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV91GXLvl59 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "none", "")) ;
         AV57LiqDLog = httpContext.getMessage( "No hay remuneraciones", "") ;
      }
      GXv_int8[0] = AV17dias_mes ;
      new web.diasmes(remoteHandle, context).execute( AV19CliCod, AV21LiqPeriodo, GXv_int8) ;
      tope_imponible_sueldo.this.AV17dias_mes = GXv_int8[0] ;
      GXv_int5[0] = AV77auxLiqDCalculado ;
      GXv_char7[0] = AV80auxLiqDLog ;
      GXv_char2[0] = AV81auxError ;
      GXv_decimal3[0] = AV55baseImportes ;
      GXv_decimal9[0] = AV8Importe ;
      GXv_int8[0] = AV56cantidadCalculada ;
      new web.maximo_imponible_sueldo(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV21LiqPeriodo, AV17dias_mes, AV14SueldoImporte, AV74ProcesoLiquidacion, AV75insertandoConceptos, GXv_int5, GXv_char7, GXv_char2, GXv_decimal3, GXv_decimal9, GXv_int8) ;
      tope_imponible_sueldo.this.AV77auxLiqDCalculado = GXv_int5[0] ;
      tope_imponible_sueldo.this.AV80auxLiqDLog = GXv_char7[0] ;
      tope_imponible_sueldo.this.AV81auxError = GXv_char2[0] ;
      tope_imponible_sueldo.this.AV55baseImportes = GXv_decimal3[0] ;
      tope_imponible_sueldo.this.AV8Importe = GXv_decimal9[0] ;
      tope_imponible_sueldo.this.AV56cantidadCalculada = GXv_int8[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, "2 "+GXutil.trim( GXutil.str( AV8Importe, 14, 2))) ;
      if ( AV77auxLiqDCalculado == 0 )
      {
         AV9LiqDCalculado = (byte)(0) ;
         AV35error = GXutil.trim( AV81auxError) ;
         AV57LiqDLog = GXutil.trim( AV35error) ;
      }
      else
      {
         AV57LiqDLog += AV80auxLiqDLog ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&SueldoImporte ", "")+GXutil.trim( GXutil.str( AV14SueldoImporte, 14, 2))) ;
         if ( AV14SueldoImporte.doubleValue() > 0 )
         {
            GXv_decimal9[0] = AV65baseImp1SueldoLiqDImpCalcu ;
            new web.getliqdimpcalcu_periodoliqantmismotliq(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV21LiqPeriodo, AV82ConCodigo, false, AV83TLiqCod, AV84sacTLiqCod, AV85adelVacTLiqCod, GXv_decimal9) ;
            tope_imponible_sueldo.this.AV65baseImp1SueldoLiqDImpCalcu = GXv_decimal9[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&baseImp1SueldoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV65baseImp1SueldoLiqDImpCalcu, 14, 2))) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65baseImp1SueldoLiqDImpCalcu)==0) )
            {
               AV8Importe = AV8Importe.subtract(AV65baseImp1SueldoLiqDImpCalcu) ;
               AV57LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV65baseImp1SueldoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a liquidaciones anteriores del periodo", "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "resta &baseImp1SueldoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV65baseImp1SueldoLiqDImpCalcu, 14, 2))) ;
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))+httpContext.getMessage( " baseimportes ", "")+GXutil.trim( GXutil.str( AV55baseImportes, 14, 2))+httpContext.getMessage( " &LiqDLog ", "")+AV57LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP13[0] = tope_imponible_sueldo.this.AV8Importe;
      this.aP14[0] = tope_imponible_sueldo.this.AV9LiqDCalculado;
      this.aP15[0] = tope_imponible_sueldo.this.AV55baseImportes;
      this.aP16[0] = tope_imponible_sueldo.this.AV56cantidadCalculada;
      this.aP17[0] = tope_imponible_sueldo.this.AV35error;
      this.aP18[0] = tope_imponible_sueldo.this.AV57LiqDLog;
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
      AV78jubConCodigo = "" ;
      AV79LiqDValUni = DecimalUtil.ZERO ;
      GXv_boolean4 = new boolean[1] ;
      AV10desdeTipoConCod = "" ;
      AV11hastaTipoConCod = "" ;
      AV90Pgmname = "" ;
      AV27subtipoSAC = "" ;
      AV50subtipo2AdelantoVacaciones = "" ;
      AV51DescuentoAdelanVacConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char6 = "" ;
      AV68importesLog = "" ;
      scmdbuf = "" ;
      A464DTipoConCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P01562_A2112LiqRelNro = new int[1] ;
      P01562_n2112LiqRelNro = new boolean[] {false} ;
      P01562_A1057LiqDFonSolRedApo = new byte[1] ;
      P01562_A1055LiqDObraSocApo = new byte[1] ;
      P01562_A1053LiqDINSSJyPApo = new byte[1] ;
      P01562_A1059LiqDRenateaApo = new byte[1] ;
      P01562_A1051LiqDSIPAApo = new byte[1] ;
      P01562_A464DTipoConCod = new String[] {""} ;
      P01562_A6LegNumero = new int[1] ;
      P01562_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01562_A31LiqNro = new int[1] ;
      P01562_A1EmpCod = new short[1] ;
      P01562_A3CliCod = new int[1] ;
      P01562_A732DSubTipoConCod2 = new String[] {""} ;
      P01562_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01562_A468DSubTipoConCod1 = new String[] {""} ;
      P01562_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01562_A507LiqDCalculado = new byte[1] ;
      P01562_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01562_A394DConCodigo = new String[] {""} ;
      P01562_A763LiqDRecalculado = new short[1] ;
      P01562_A393DConDescrip = new String[] {""} ;
      P01562_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV14SueldoImporte = DecimalUtil.ZERO ;
      GXv_int5 = new byte[1] ;
      AV80auxLiqDLog = "" ;
      GXv_char7 = new String[1] ;
      AV81auxError = "" ;
      GXv_char2 = new String[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_int8 = new short[1] ;
      AV65baseImp1SueldoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tope_imponible_sueldo__default(),
         new Object[] {
             new Object[] {
            P01562_A2112LiqRelNro, P01562_n2112LiqRelNro, P01562_A1057LiqDFonSolRedApo, P01562_A1055LiqDObraSocApo, P01562_A1053LiqDINSSJyPApo, P01562_A1059LiqDRenateaApo, P01562_A1051LiqDSIPAApo, P01562_A464DTipoConCod, P01562_A6LegNumero, P01562_A397DLiqPeriodo,
            P01562_A31LiqNro, P01562_A1EmpCod, P01562_A3CliCod, P01562_A732DSubTipoConCod2, P01562_n732DSubTipoConCod2, P01562_A468DSubTipoConCod1, P01562_n468DSubTipoConCod1, P01562_A507LiqDCalculado, P01562_A764LiqDImpReCalcu, P01562_A394DConCodigo,
            P01562_A763LiqDRecalculado, P01562_A393DConDescrip, P01562_A81LiqDSecuencial
            }
         }
      );
      AV90Pgmname = "tope_imponible_sueldo" ;
      /* GeneXus formulas. */
      AV90Pgmname = "tope_imponible_sueldo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private byte AV77auxLiqDCalculado ;
   private byte AV91GXLvl59 ;
   private byte A1051LiqDSIPAApo ;
   private byte A1059LiqDRenateaApo ;
   private byte A1053LiqDINSSJyPApo ;
   private byte A1055LiqDObraSocApo ;
   private byte A1057LiqDFonSolRedApo ;
   private byte A507LiqDCalculado ;
   private byte GXv_int5[] ;
   private short AV23EmpCod ;
   private short AV43baseImponibleNro ;
   private short AV56cantidadCalculada ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV17dias_mes ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV25LiqNro ;
   private int AV86LiqRelNro ;
   private int AV24LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV8Importe ;
   private java.math.BigDecimal AV55baseImportes ;
   private java.math.BigDecimal AV79LiqDValUni ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV14SueldoImporte ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV65baseImp1SueldoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private String AV83TLiqCod ;
   private String AV84sacTLiqCod ;
   private String AV85adelVacTLiqCod ;
   private String AV82ConCodigo ;
   private String AV74ProcesoLiquidacion ;
   private String AV78jubConCodigo ;
   private String AV10desdeTipoConCod ;
   private String AV11hastaTipoConCod ;
   private String AV90Pgmname ;
   private String AV27subtipoSAC ;
   private String AV50subtipo2AdelantoVacaciones ;
   private String AV51DescuentoAdelanVacConCodigo ;
   private String GXt_char1 ;
   private String GXt_char6 ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private String GXv_char7[] ;
   private String GXv_char2[] ;
   private java.util.Date AV21LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV75insertandoConceptos ;
   private boolean AV45esAporte ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean n2112LiqRelNro ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV13aplica ;
   private boolean AV67descuHay ;
   private String AV57LiqDLog ;
   private String AV80auxLiqDLog ;
   private String AV35error ;
   private String AV68importesLog ;
   private String A393DConDescrip ;
   private String AV81auxError ;
   private String[] aP18 ;
   private java.math.BigDecimal[] aP13 ;
   private byte[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private short[] aP16 ;
   private String[] aP17 ;
   private IDataStoreProvider pr_default ;
   private int[] P01562_A2112LiqRelNro ;
   private boolean[] P01562_n2112LiqRelNro ;
   private byte[] P01562_A1057LiqDFonSolRedApo ;
   private byte[] P01562_A1055LiqDObraSocApo ;
   private byte[] P01562_A1053LiqDINSSJyPApo ;
   private byte[] P01562_A1059LiqDRenateaApo ;
   private byte[] P01562_A1051LiqDSIPAApo ;
   private String[] P01562_A464DTipoConCod ;
   private int[] P01562_A6LegNumero ;
   private java.util.Date[] P01562_A397DLiqPeriodo ;
   private int[] P01562_A31LiqNro ;
   private short[] P01562_A1EmpCod ;
   private int[] P01562_A3CliCod ;
   private String[] P01562_A732DSubTipoConCod2 ;
   private boolean[] P01562_n732DSubTipoConCod2 ;
   private String[] P01562_A468DSubTipoConCod1 ;
   private boolean[] P01562_n468DSubTipoConCod1 ;
   private byte[] P01562_A507LiqDCalculado ;
   private java.math.BigDecimal[] P01562_A764LiqDImpReCalcu ;
   private String[] P01562_A394DConCodigo ;
   private short[] P01562_A763LiqDRecalculado ;
   private String[] P01562_A393DConDescrip ;
   private int[] P01562_A81LiqDSecuencial ;
}

final  class tope_imponible_sueldo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01562( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV43baseImponibleNro ,
                                          byte A1051LiqDSIPAApo ,
                                          byte A1059LiqDRenateaApo ,
                                          byte A1053LiqDINSSJyPApo ,
                                          byte A1055LiqDObraSocApo ,
                                          byte A1057LiqDFonSolRedApo ,
                                          int A31LiqNro ,
                                          int AV25LiqNro ,
                                          String A464DTipoConCod ,
                                          String AV10desdeTipoConCod ,
                                          String AV11hastaTipoConCod ,
                                          int A2112LiqRelNro ,
                                          int AV86LiqRelNro ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV21LiqPeriodo ,
                                          int AV19CliCod ,
                                          short AV23EmpCod ,
                                          int AV24LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[8];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.LiqDFonSolRedApo, T1.LiqDObraSocApo, T1.LiqDINSSJyPApo, T1.LiqDRenateaApo, T1.LiqDSIPAApo, T1.DTipoConCod, T1.LegNumero, T1.DLiqPeriodo," ;
      scmdbuf += " T1.LiqNro, T1.EmpCod, T1.CliCod, T1.DSubTipoConCod2, T1.DSubTipoConCod1, T1.LiqDCalculado, T1.LiqDImpReCalcu, T1.DConCodigo, T1.LiqDRecalculado, T1.DConDescrip," ;
      scmdbuf += " T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.LiqNro <= ?)");
      addWhere(sWhereString, "(T1.DTipoConCod >= ( ?))");
      addWhere(sWhereString, "(T1.DTipoConCod <= ( ?))");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo = ?)");
      if ( AV43baseImponibleNro == 1 )
      {
         addWhere(sWhereString, "(T1.LiqDSIPAApo = 1 or T1.LiqDRenateaApo = 1)");
      }
      if ( AV43baseImponibleNro == 5 )
      {
         addWhere(sWhereString, "(T1.LiqDINSSJyPApo = 1)");
      }
      if ( ( AV43baseImponibleNro == 4 ) || ( AV43baseImponibleNro == 24 ) )
      {
         addWhere(sWhereString, "(T1.LiqDObraSocApo = 1 or T1.LiqDFonSolRedApo = 1)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
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
                  return conditional_P01562(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).byteValue() , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01562", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(16,2);
               ((String[]) buf[19])[0] = rslt.getString(17, 10);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((String[]) buf[21])[0] = rslt.getVarchar(19);
               ((int[]) buf[22])[0] = rslt.getInt(20);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               return;
      }
   }

}

