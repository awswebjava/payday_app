package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcuacumulado2 extends GXProcedure
{
   public getliqdimpcalcuacumulado2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcuacumulado2.class ), "" );
   }

   public getliqdimpcalcuacumulado2( int remoteHandle ,
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
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 ,
                             short[] aP13 ,
                             byte[] aP14 ,
                             boolean[] aP15 ,
                             String[] aP16 )
   {
      getliqdimpcalcuacumulado2.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        boolean[] aP12 ,
                        short[] aP13 ,
                        byte[] aP14 ,
                        boolean[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 ,
                             short[] aP13 ,
                             byte[] aP14 ,
                             boolean[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 )
   {
      getliqdimpcalcuacumulado2.this.AV13CliCod = aP0;
      getliqdimpcalcuacumulado2.this.AV8EmpCod = aP1;
      getliqdimpcalcuacumulado2.this.AV9LiqNro = aP2;
      getliqdimpcalcuacumulado2.this.AV36LiqRelNro = aP3;
      getliqdimpcalcuacumulado2.this.AV10LegNumero = aP4;
      getliqdimpcalcuacumulado2.this.AV11ConCodigo = aP5;
      getliqdimpcalcuacumulado2.this.AV26LiqPeriodo = aP6;
      getliqdimpcalcuacumulado2.this.AV20ProcesoLiquidacion = aP7;
      getliqdimpcalcuacumulado2.this.AV25semestre = aP8;
      getliqdimpcalcuacumulado2.this.AV33existenciaObligada = aP9;
      getliqdimpcalcuacumulado2.this.aP10 = aP10;
      getliqdimpcalcuacumulado2.this.aP11 = aP11;
      getliqdimpcalcuacumulado2.this.aP12 = aP12;
      getliqdimpcalcuacumulado2.this.aP13 = aP13;
      getliqdimpcalcuacumulado2.this.aP14 = aP14;
      getliqdimpcalcuacumulado2.this.aP15 = aP15;
      getliqdimpcalcuacumulado2.this.aP16 = aP16;
      getliqdimpcalcuacumulado2.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! AV25semestre )
      {
         AV19comienzoFecha = localUtil.ymdtod( GXutil.year( AV26LiqPeriodo), 1, 1) ;
      }
      else
      {
         GXv_date1[0] = AV19comienzoFecha ;
         GXv_date2[0] = AV27date ;
         new web.rangofechassac(remoteHandle, context).execute( AV26LiqPeriodo, GXv_date1, GXv_date2) ;
         getliqdimpcalcuacumulado2.this.AV19comienzoFecha = GXv_date1[0] ;
         getliqdimpcalcuacumulado2.this.AV27date = GXv_date2[0] ;
      }
      AV34LiqDLog = "(" ;
      AV24agregoPeriodoPropio = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&ConCodigo ", "")+GXutil.trim( AV11ConCodigo)+" "+GXutil.trim( localUtil.dtoc( AV19comienzoFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV15LiqDCalculado = (byte)(1) ;
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      AV40GXLvl17 = (byte)(0) ;
      /* Using cursor P015X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV19comienzoFecha, Integer.valueOf(AV36LiqRelNro), AV26LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P015X2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P015X2_n2112LiqRelNro[0] ;
         A397DLiqPeriodo = P015X2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P015X2_A394DConCodigo[0] ;
         A6LegNumero = P015X2_A6LegNumero[0] ;
         A1EmpCod = P015X2_A1EmpCod[0] ;
         A3CliCod = P015X2_A3CliCod[0] ;
         A400DTLiqCod = P015X2_A400DTLiqCod[0] ;
         A31LiqNro = P015X2_A31LiqNro[0] ;
         A764LiqDImpReCalcu = P015X2_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P015X2_A269LiqDCanti[0] ;
         n269LiqDCanti = P015X2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P015X2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P015X2_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P015X2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P015X2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P015X2_n2112LiqRelNro[0] ;
         AV40GXLvl17 = (byte)(1) ;
         GXv_boolean3[0] = AV31aplica ;
         new web.gettipoliqacumula(remoteHandle, context).execute( AV13CliCod, A400DTLiqCod, GXv_boolean3) ;
         getliqdimpcalcuacumulado2.this.AV31aplica = GXv_boolean3[0] ;
         AV34LiqDLog += httpContext.getMessage( "LiqNro ", "") + GXutil.trim( GXutil.str( A31LiqNro, 8, 0)) + httpContext.getMessage( " DTLiqCod ", "") + GXutil.trim( A400DTLiqCod) + httpContext.getMessage( " &aplica ", "") + GXutil.trim( GXutil.booltostr( AV31aplica)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "LiqNro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " &aplica ", "")+GXutil.trim( GXutil.booltostr( AV31aplica))) ;
         if ( AV31aplica )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "1") ;
            AV22cantidadPeriodos = (short)(AV22cantidadPeriodos+1) ;
            AV14existe = true ;
            GXt_boolean4 = AV21ConRecalcular ;
            GXv_boolean3[0] = GXt_boolean4 ;
            new web.conceptorecalcula(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, GXv_boolean3) ;
            getliqdimpcalcuacumulado2.this.GXt_boolean4 = GXv_boolean3[0] ;
            AV21ConRecalcular = GXt_boolean4 ;
            AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
            AV32LiqDCanti = AV32LiqDCanti.add(A269LiqDCanti) ;
            GXt_int5 = AV15LiqDCalculado ;
            GXv_int6[0] = GXt_int5 ;
            new web.dependenciaresuelta(remoteHandle, context).execute( AV13CliCod, AV21ConRecalcular, AV20ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, A31LiqNro, 0, AV11ConCodigo, A394DConCodigo, GXv_int6) ;
            getliqdimpcalcuacumulado2.this.GXt_int5 = GXv_int6[0] ;
            AV15LiqDCalculado = (byte)(GXt_int5) ;
            AV34LiqDLog += httpContext.getMessage( " suma  &LiqDImpCalcu ", "") + GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " &LiqDCalculado ", "") + GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0)) ;
            if ( AV15LiqDCalculado == 0 )
            {
               AV28error = httpContext.getMessage( "No calculado en liquidación nro ", "") + GXutil.trim( GXutil.str( A31LiqNro, 8, 0)) ;
               AV34LiqDLog += GXutil.trim( AV28error) ;
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXv_decimal7[0] = AV12LiqDImpCalcu ;
            GXv_decimal8[0] = AV32LiqDCanti ;
            GXv_char9[0] = AV35ajusLiqDLog ;
            new web.ajustar(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, A394DConCodigo, GXv_decimal7, GXv_decimal8, GXv_char9) ;
            getliqdimpcalcuacumulado2.this.AV12LiqDImpCalcu = GXv_decimal7[0] ;
            getliqdimpcalcuacumulado2.this.AV32LiqDCanti = GXv_decimal8[0] ;
            getliqdimpcalcuacumulado2.this.AV35ajusLiqDLog = GXv_char9[0] ;
            if ( ! (GXutil.strcmp("", AV35ajusLiqDLog)==0) )
            {
               AV34LiqDLog += GXutil.trim( AV35ajusLiqDLog) ;
            }
            if ( A31LiqNro == AV9LiqNro )
            {
               AV24agregoPeriodoPropio = true ;
               AV34LiqDLog += httpContext.getMessage( " agrego propio", "") ;
            }
         }
         else
         {
            if ( A31LiqNro == AV9LiqNro )
            {
               AV24agregoPeriodoPropio = true ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV40GXLvl17 == 0 )
      {
         AV15LiqDCalculado = (byte)(0) ;
         AV34LiqDLog += httpContext.getMessage( " none", "") ;
         if ( AV33existenciaObligada )
         {
            AV28error = httpContext.getMessage( "Sin registro desde el ", "") + GXutil.trim( localUtil.dtoc( AV19comienzoFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el concepto ", "") + GXutil.trim( AV11ConCodigo) + httpContext.getMessage( " legajo ", "") + GXutil.trim( GXutil.str( AV13CliCod, 6, 0)) + "/" + GXutil.trim( GXutil.str( AV8EmpCod, 4, 0)) + "/" + GXutil.trim( GXutil.str( AV10LegNumero, 8, 0)) ;
            AV34LiqDLog += GXutil.trim( AV28error) ;
         }
         else
         {
            AV15LiqDCalculado = (byte)(1) ;
            AV24agregoPeriodoPropio = true ;
         }
      }
      AV34LiqDLog += httpContext.getMessage( " &LiqDCalculado ", "") + GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0)) + httpContext.getMessage( " &agregoPeriodoPropio ", "") + GXutil.trim( GXutil.booltostr( AV24agregoPeriodoPropio)) + httpContext.getMessage( " &ProcesoLiquidacion ", "") + GXutil.trim( AV20ProcesoLiquidacion) + httpContext.getMessage( " &existenciaObligada ", "") + GXutil.trim( GXutil.booltostr( AV33existenciaObligada)) ;
      if ( ( AV15LiqDCalculado == 1 ) && ! AV24agregoPeriodoPropio && ( GXutil.strcmp(AV20ProcesoLiquidacion, "Calculo") == 0 ) && ( AV33existenciaObligada ) )
      {
         AV15LiqDCalculado = (byte)(0) ;
         AV28error = httpContext.getMessage( "No se pudo calcular ", "") + GXutil.trim( AV11ConCodigo) + httpContext.getMessage( " en liquidación actual", "") ;
         AV34LiqDLog += httpContext.getMessage( " error", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getliqdimpcalcuacumulado2.this.AV12LiqDImpCalcu;
      this.aP11[0] = getliqdimpcalcuacumulado2.this.AV32LiqDCanti;
      this.aP12[0] = getliqdimpcalcuacumulado2.this.AV14existe;
      this.aP13[0] = getliqdimpcalcuacumulado2.this.AV22cantidadPeriodos;
      this.aP14[0] = getliqdimpcalcuacumulado2.this.AV15LiqDCalculado;
      this.aP15[0] = getliqdimpcalcuacumulado2.this.AV30actualEsCero;
      this.aP16[0] = getliqdimpcalcuacumulado2.this.AV28error;
      this.aP17[0] = getliqdimpcalcuacumulado2.this.AV34LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDImpCalcu = DecimalUtil.ZERO ;
      AV32LiqDCanti = DecimalUtil.ZERO ;
      AV28error = "" ;
      AV34LiqDLog = "" ;
      AV19comienzoFecha = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV27date = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV39Pgmname = "" ;
      scmdbuf = "" ;
      P015X2_A2112LiqRelNro = new int[1] ;
      P015X2_n2112LiqRelNro = new boolean[] {false} ;
      P015X2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P015X2_A394DConCodigo = new String[] {""} ;
      P015X2_A6LegNumero = new int[1] ;
      P015X2_A1EmpCod = new short[1] ;
      P015X2_A3CliCod = new int[1] ;
      P015X2_A400DTLiqCod = new String[] {""} ;
      P015X2_A31LiqNro = new int[1] ;
      P015X2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P015X2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P015X2_n269LiqDCanti = new boolean[] {false} ;
      P015X2_A507LiqDCalculado = new byte[1] ;
      P015X2_A763LiqDRecalculado = new short[1] ;
      P015X2_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A400DTLiqCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean3 = new boolean[1] ;
      GXv_int6 = new short[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV35ajusLiqDLog = "" ;
      GXv_char9 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcuacumulado2__default(),
         new Object[] {
             new Object[] {
            P015X2_A2112LiqRelNro, P015X2_n2112LiqRelNro, P015X2_A397DLiqPeriodo, P015X2_A394DConCodigo, P015X2_A6LegNumero, P015X2_A1EmpCod, P015X2_A3CliCod, P015X2_A400DTLiqCod, P015X2_A31LiqNro, P015X2_A764LiqDImpReCalcu,
            P015X2_A269LiqDCanti, P015X2_n269LiqDCanti, P015X2_A507LiqDCalculado, P015X2_A763LiqDRecalculado, P015X2_A81LiqDSecuencial
            }
         }
      );
      AV39Pgmname = "getLiqDImpCalcuAcumulado2" ;
      /* GeneXus formulas. */
      AV39Pgmname = "getLiqDImpCalcuAcumulado2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV40GXLvl17 ;
   private byte A507LiqDCalculado ;
   private short AV8EmpCod ;
   private short AV22cantidadPeriodos ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short GXt_int5 ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV36LiqRelNro ;
   private int AV10LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV32LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV11ConCodigo ;
   private String AV20ProcesoLiquidacion ;
   private String AV39Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A400DTLiqCod ;
   private String GXv_char9[] ;
   private java.util.Date AV26LiqPeriodo ;
   private java.util.Date AV19comienzoFecha ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV27date ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV25semestre ;
   private boolean AV33existenciaObligada ;
   private boolean AV14existe ;
   private boolean AV30actualEsCero ;
   private boolean AV24agregoPeriodoPropio ;
   private boolean n2112LiqRelNro ;
   private boolean n269LiqDCanti ;
   private boolean AV31aplica ;
   private boolean AV21ConRecalcular ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean3[] ;
   private boolean returnInSub ;
   private String AV34LiqDLog ;
   private String AV35ajusLiqDLog ;
   private String AV28error ;
   private String[] aP17 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private boolean[] aP12 ;
   private short[] aP13 ;
   private byte[] aP14 ;
   private boolean[] aP15 ;
   private String[] aP16 ;
   private IDataStoreProvider pr_default ;
   private int[] P015X2_A2112LiqRelNro ;
   private boolean[] P015X2_n2112LiqRelNro ;
   private java.util.Date[] P015X2_A397DLiqPeriodo ;
   private String[] P015X2_A394DConCodigo ;
   private int[] P015X2_A6LegNumero ;
   private short[] P015X2_A1EmpCod ;
   private int[] P015X2_A3CliCod ;
   private String[] P015X2_A400DTLiqCod ;
   private int[] P015X2_A31LiqNro ;
   private java.math.BigDecimal[] P015X2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P015X2_A269LiqDCanti ;
   private boolean[] P015X2_n269LiqDCanti ;
   private byte[] P015X2_A507LiqDCalculado ;
   private short[] P015X2_A763LiqDRecalculado ;
   private int[] P015X2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcuacumulado2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P015X2", "SELECT T2.LiqRelNro, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.DTLiqCod, T1.LiqNro, T1.LiqDImpReCalcu, T1.LiqDCanti, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DLiqPeriodo <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}

