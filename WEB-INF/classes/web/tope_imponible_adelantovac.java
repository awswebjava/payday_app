package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tope_imponible_adelantovac extends GXProcedure
{
   public tope_imponible_adelantovac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tope_imponible_adelantovac.class ), "" );
   }

   public tope_imponible_adelantovac( int remoteHandle ,
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
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 )
   {
      tope_imponible_adelantovac.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        byte[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        short[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      tope_imponible_adelantovac.this.AV19CliCod = aP0;
      tope_imponible_adelantovac.this.AV23EmpCod = aP1;
      tope_imponible_adelantovac.this.AV25LiqNro = aP2;
      tope_imponible_adelantovac.this.AV70LiqRelNro = aP3;
      tope_imponible_adelantovac.this.AV24LegNumero = aP4;
      tope_imponible_adelantovac.this.AV21LiqPeriodo = aP5;
      tope_imponible_adelantovac.this.AV65ProcesoLiquidacion = aP6;
      tope_imponible_adelantovac.this.aP7 = aP7;
      tope_imponible_adelantovac.this.aP8 = aP8;
      tope_imponible_adelantovac.this.aP9 = aP9;
      tope_imponible_adelantovac.this.aP10 = aP10;
      tope_imponible_adelantovac.this.aP11 = aP11;
      tope_imponible_adelantovac.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV45esAporte = true ;
      AV9LiqDCalculado = (byte)(1) ;
      AV10desdeTipoConCod = "NRE_ARG" ;
      AV11hastaTipoConCod = "REM_ARG" ;
      GXt_char1 = AV28subtipoVacaciones ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_adelantovac.this.GXt_char1 = GXv_char2[0] ;
      AV28subtipoVacaciones = GXt_char1 ;
      GXt_char1 = AV50subtipo2AdelantoVacaciones ;
      GXv_char2[0] = GXt_char1 ;
      new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char2) ;
      tope_imponible_adelantovac.this.GXt_char1 = GXv_char2[0] ;
      AV50subtipo2AdelantoVacaciones = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, "1") ;
      AV75GXLvl27 = (byte)(0) ;
      /* Using cursor P01582 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod), Short.valueOf(AV23EmpCod), Integer.valueOf(AV24LegNumero), Integer.valueOf(AV25LiqNro), AV10desdeTipoConCod, AV11hastaTipoConCod, Integer.valueOf(AV70LiqRelNro), AV21LiqPeriodo, AV28subtipoVacaciones, AV50subtipo2AdelantoVacaciones});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01582_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01582_n2112LiqRelNro[0] ;
         A732DSubTipoConCod2 = P01582_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01582_n732DSubTipoConCod2[0] ;
         A468DSubTipoConCod1 = P01582_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01582_n468DSubTipoConCod1[0] ;
         A464DTipoConCod = P01582_A464DTipoConCod[0] ;
         A6LegNumero = P01582_A6LegNumero[0] ;
         A283LiqPeriodo = P01582_A283LiqPeriodo[0] ;
         A31LiqNro = P01582_A31LiqNro[0] ;
         A1EmpCod = P01582_A1EmpCod[0] ;
         A3CliCod = P01582_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01582_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P01582_A269LiqDCanti[0] ;
         n269LiqDCanti = P01582_n269LiqDCanti[0] ;
         A394DConCodigo = P01582_A394DConCodigo[0] ;
         A507LiqDCalculado = P01582_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01582_A763LiqDRecalculado[0] ;
         A393DConDescrip = P01582_A393DConDescrip[0] ;
         A81LiqDSecuencial = P01582_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01582_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01582_n2112LiqRelNro[0] ;
         A283LiqPeriodo = P01582_A283LiqPeriodo[0] ;
         AV75GXLvl27 = (byte)(1) ;
         AV29adelantoVacImportes = AV29adelantoVacImportes.add(A764LiqDImpReCalcu) ;
         AV42dias_vacaciones = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV42dias_vacaciones).add(A269LiqDCanti))) ;
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         GXv_int3[0] = AV68auxLiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV19CliCod, A394DConCodigo, AV65ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
         tope_imponible_adelantovac.this.AV68auxLiqDCalculado = GXv_int3[0] ;
         if ( AV68auxLiqDCalculado == 0 )
         {
            AV9LiqDCalculado = (byte)(0) ;
            AV35error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV75GXLvl27 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "none", "")) ;
      }
      GXv_int4[0] = AV17dias_mes ;
      new web.diasmes(remoteHandle, context).execute( AV19CliCod, AV21LiqPeriodo, GXv_int4) ;
      tope_imponible_adelantovac.this.AV17dias_mes = GXv_int4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&adelantoVacImportes ", "")+GXutil.trim( GXutil.str( AV29adelantoVacImportes, 14, 2))+httpContext.getMessage( " &adelantoVacImportes ", "")+GXutil.trim( GXutil.str( AV29adelantoVacImportes, 14, 2))) ;
      GXv_char2[0] = AV69auxLiqDLog ;
      GXv_decimal5[0] = AV55baseImportes ;
      GXv_decimal6[0] = AV8Importe ;
      GXv_int4[0] = AV56cantidadCalculada ;
      GXv_char7[0] = AV71auxError ;
      new web.maximo_imponible_adelvac(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV21LiqPeriodo, AV17dias_mes, AV29adelantoVacImportes, AV65ProcesoLiquidacion, AV42dias_vacaciones, GXv_char2, GXv_decimal5, GXv_decimal6, GXv_int4, GXv_char7) ;
      tope_imponible_adelantovac.this.AV69auxLiqDLog = GXv_char2[0] ;
      tope_imponible_adelantovac.this.AV55baseImportes = GXv_decimal5[0] ;
      tope_imponible_adelantovac.this.AV8Importe = GXv_decimal6[0] ;
      tope_imponible_adelantovac.this.AV56cantidadCalculada = GXv_int4[0] ;
      tope_imponible_adelantovac.this.AV71auxError = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV71auxError)==0) )
      {
         AV35error = AV71auxError ;
         AV57LiqDLog = AV35error ;
         AV9LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&&Importe ", "")+GXutil.trim( GXutil.str( AV8Importe, 14, 2))+httpContext.getMessage( " &auxLiqDLog ", "")+AV69auxLiqDLog) ;
      if ( AV8Importe.doubleValue() > 0 )
      {
         AV57LiqDLog = AV69auxLiqDLog ;
         GXt_char1 = AV63baseImpVacConCodigo ;
         GXt_char8 = AV63baseImpVacConCodigo ;
         GXv_char7[0] = GXt_char8 ;
         new web.concepto_topeimponibleadelvac_codigoparam(remoteHandle, context).execute( GXv_char7) ;
         tope_imponible_adelantovac.this.GXt_char8 = GXv_char7[0] ;
         GXv_char2[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char8, GXv_char2) ;
         tope_imponible_adelantovac.this.GXt_char1 = GXv_char2[0] ;
         AV63baseImpVacConCodigo = GXt_char1 ;
         GXv_decimal6[0] = AV64baseImpVacLiqDImpCalcu ;
         new web.getliqdimpcalcu_periodoliqant(remoteHandle, context).execute( AV19CliCod, AV23EmpCod, AV25LiqNro, AV24LegNumero, AV21LiqPeriodo, AV63baseImpVacConCodigo, false, GXv_decimal6) ;
         tope_imponible_adelantovac.this.AV64baseImpVacLiqDImpCalcu = GXv_decimal6[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64baseImpVacLiqDImpCalcu)==0) )
         {
            AV8Importe = AV8Importe.subtract(AV64baseImpVacLiqDImpCalcu) ;
            AV57LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV64baseImpVacLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a liquidaciones anteriores del periodo", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = tope_imponible_adelantovac.this.AV8Importe;
      this.aP8[0] = tope_imponible_adelantovac.this.AV9LiqDCalculado;
      this.aP9[0] = tope_imponible_adelantovac.this.AV55baseImportes;
      this.aP10[0] = tope_imponible_adelantovac.this.AV56cantidadCalculada;
      this.aP11[0] = tope_imponible_adelantovac.this.AV35error;
      this.aP12[0] = tope_imponible_adelantovac.this.AV57LiqDLog;
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
      AV28subtipoVacaciones = "" ;
      AV50subtipo2AdelantoVacaciones = "" ;
      AV74Pgmname = "" ;
      scmdbuf = "" ;
      P01582_A2112LiqRelNro = new int[1] ;
      P01582_n2112LiqRelNro = new boolean[] {false} ;
      P01582_A732DSubTipoConCod2 = new String[] {""} ;
      P01582_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01582_A468DSubTipoConCod1 = new String[] {""} ;
      P01582_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01582_A464DTipoConCod = new String[] {""} ;
      P01582_A6LegNumero = new int[1] ;
      P01582_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01582_A31LiqNro = new int[1] ;
      P01582_A1EmpCod = new short[1] ;
      P01582_A3CliCod = new int[1] ;
      P01582_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01582_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01582_n269LiqDCanti = new boolean[] {false} ;
      P01582_A394DConCodigo = new String[] {""} ;
      P01582_A507LiqDCalculado = new byte[1] ;
      P01582_A763LiqDRecalculado = new short[1] ;
      P01582_A393DConDescrip = new String[] {""} ;
      P01582_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A464DTipoConCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV29adelantoVacImportes = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV69auxLiqDLog = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_int4 = new short[1] ;
      AV71auxError = "" ;
      AV63baseImpVacConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char8 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV64baseImpVacLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tope_imponible_adelantovac__default(),
         new Object[] {
             new Object[] {
            P01582_A2112LiqRelNro, P01582_n2112LiqRelNro, P01582_A732DSubTipoConCod2, P01582_n732DSubTipoConCod2, P01582_A468DSubTipoConCod1, P01582_n468DSubTipoConCod1, P01582_A464DTipoConCod, P01582_A6LegNumero, P01582_A283LiqPeriodo, P01582_A31LiqNro,
            P01582_A1EmpCod, P01582_A3CliCod, P01582_A764LiqDImpReCalcu, P01582_A269LiqDCanti, P01582_n269LiqDCanti, P01582_A394DConCodigo, P01582_A507LiqDCalculado, P01582_A763LiqDRecalculado, P01582_A393DConDescrip, P01582_A81LiqDSecuencial
            }
         }
      );
      AV74Pgmname = "tope_imponible_adelantovac" ;
      /* GeneXus formulas. */
      AV74Pgmname = "tope_imponible_adelantovac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private byte AV75GXLvl27 ;
   private byte A507LiqDCalculado ;
   private byte AV68auxLiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV23EmpCod ;
   private short AV56cantidadCalculada ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV42dias_vacaciones ;
   private short AV17dias_mes ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV25LiqNro ;
   private int AV70LiqRelNro ;
   private int AV24LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV8Importe ;
   private java.math.BigDecimal AV55baseImportes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV29adelantoVacImportes ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV64baseImpVacLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV65ProcesoLiquidacion ;
   private String AV10desdeTipoConCod ;
   private String AV11hastaTipoConCod ;
   private String AV28subtipoVacaciones ;
   private String AV50subtipo2AdelantoVacaciones ;
   private String AV74Pgmname ;
   private String scmdbuf ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String AV63baseImpVacConCodigo ;
   private String GXt_char1 ;
   private String GXt_char8 ;
   private String GXv_char7[] ;
   private String GXv_char2[] ;
   private java.util.Date AV21LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV45esAporte ;
   private boolean n2112LiqRelNro ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean returnInSub ;
   private String AV57LiqDLog ;
   private String AV69auxLiqDLog ;
   private String AV35error ;
   private String A393DConDescrip ;
   private String AV71auxError ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP7 ;
   private byte[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private short[] aP10 ;
   private String[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P01582_A2112LiqRelNro ;
   private boolean[] P01582_n2112LiqRelNro ;
   private String[] P01582_A732DSubTipoConCod2 ;
   private boolean[] P01582_n732DSubTipoConCod2 ;
   private String[] P01582_A468DSubTipoConCod1 ;
   private boolean[] P01582_n468DSubTipoConCod1 ;
   private String[] P01582_A464DTipoConCod ;
   private int[] P01582_A6LegNumero ;
   private java.util.Date[] P01582_A283LiqPeriodo ;
   private int[] P01582_A31LiqNro ;
   private short[] P01582_A1EmpCod ;
   private int[] P01582_A3CliCod ;
   private java.math.BigDecimal[] P01582_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01582_A269LiqDCanti ;
   private boolean[] P01582_n269LiqDCanti ;
   private String[] P01582_A394DConCodigo ;
   private byte[] P01582_A507LiqDCalculado ;
   private short[] P01582_A763LiqDRecalculado ;
   private String[] P01582_A393DConDescrip ;
   private int[] P01582_A81LiqDSecuencial ;
}

final  class tope_imponible_adelantovac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01582", "SELECT T2.LiqRelNro, T1.DSubTipoConCod2, T1.DSubTipoConCod1, T1.DTipoConCod, T1.LegNumero, T2.LiqPeriodo, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDCanti, T1.DConCodigo, T1.LiqDCalculado, T1.LiqDRecalculado, T1.DConDescrip, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T1.LiqNro <= ?) AND (T1.DTipoConCod >= ( ?)) AND (T1.DTipoConCod <= ( ?)) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T2.LiqPeriodo = ?) AND (T1.DSubTipoConCod1 = ( ?)) AND (T1.DSubTipoConCod2 = ( ?)) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 10);
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((short[]) buf[17])[0] = rslt.getShort(14);
               ((String[]) buf[18])[0] = rslt.getVarchar(15);
               ((int[]) buf[19])[0] = rslt.getInt(16);
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
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setString(10, (String)parms[9], 20);
               return;
      }
   }

}

