package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcuporperiodo extends GXProcedure
{
   public getliqdimpcalcuporperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcuporperiodo.class ), "" );
   }

   public getliqdimpcalcuporperiodo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           int aP5 ,
                           String aP6 ,
                           String aP7 ,
                           boolean aP8 ,
                           boolean aP9 ,
                           java.math.BigDecimal[] aP10 ,
                           java.math.BigDecimal[] aP11 ,
                           boolean[] aP12 )
   {
      getliqdimpcalcuporperiodo.this.aP13 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        int aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        boolean[] aP12 ,
                        byte[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             int aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 ,
                             byte[] aP13 )
   {
      getliqdimpcalcuporperiodo.this.AV13CliCod = aP0;
      getliqdimpcalcuporperiodo.this.AV8EmpCod = aP1;
      getliqdimpcalcuporperiodo.this.AV9LiqNro = aP2;
      getliqdimpcalcuporperiodo.this.AV25LiqRelNro = aP3;
      getliqdimpcalcuporperiodo.this.AV18LiqPeriodo = aP4;
      getliqdimpcalcuporperiodo.this.AV10LegNumero = aP5;
      getliqdimpcalcuporperiodo.this.AV11ConCodigo = aP6;
      getliqdimpcalcuporperiodo.this.AV22ProcesoLiquidacion = aP7;
      getliqdimpcalcuporperiodo.this.AV24insertandoConceptos = aP8;
      getliqdimpcalcuporperiodo.this.AV23validarExistencia = aP9;
      getliqdimpcalcuporperiodo.this.aP10 = aP10;
      getliqdimpcalcuporperiodo.this.aP11 = aP11;
      getliqdimpcalcuporperiodo.this.aP12 = aP12;
      getliqdimpcalcuporperiodo.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      AV29GXLvl3 = (byte)(0) ;
      /* Using cursor P010T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, Integer.valueOf(AV25LiqRelNro), AV18LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P010T2_A31LiqNro[0] ;
         A2112LiqRelNro = P010T2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P010T2_n2112LiqRelNro[0] ;
         A394DConCodigo = P010T2_A394DConCodigo[0] ;
         A6LegNumero = P010T2_A6LegNumero[0] ;
         A283LiqPeriodo = P010T2_A283LiqPeriodo[0] ;
         A1EmpCod = P010T2_A1EmpCod[0] ;
         A3CliCod = P010T2_A3CliCod[0] ;
         A764LiqDImpReCalcu = P010T2_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P010T2_A269LiqDCanti[0] ;
         n269LiqDCanti = P010T2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P010T2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P010T2_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P010T2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P010T2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P010T2_n2112LiqRelNro[0] ;
         A283LiqPeriodo = P010T2_A283LiqPeriodo[0] ;
         AV29GXLvl3 = (byte)(1) ;
         AV14existe = true ;
         AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
         AV19LiqDCanti = AV19LiqDCanti.add(A269LiqDCanti) ;
         GXv_int1[0] = AV26auxLiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, AV22ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int1) ;
         getliqdimpcalcuporperiodo.this.AV26auxLiqDCalculado = GXv_int1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&ConCodigo ", "")+GXutil.trim( AV11ConCodigo)+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &&auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV26auxLiqDCalculado, 1, 0))) ;
         if ( AV26auxLiqDCalculado == 0 )
         {
            AV15LiqDCalculado = (byte)(0) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "sale", "")) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV29GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "fin &liqdcalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))) ;
      if ( false )
      {
         new web.pendientescrearindices(remoteHandle, context).execute( ) ;
      }
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getliqdimpcalcuporperiodo.this.AV12LiqDImpCalcu;
      this.aP11[0] = getliqdimpcalcuporperiodo.this.AV19LiqDCanti;
      this.aP12[0] = getliqdimpcalcuporperiodo.this.AV14existe;
      this.aP13[0] = getliqdimpcalcuporperiodo.this.AV15LiqDCalculado;
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
      AV19LiqDCanti = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P010T2_A31LiqNro = new int[1] ;
      P010T2_A2112LiqRelNro = new int[1] ;
      P010T2_n2112LiqRelNro = new boolean[] {false} ;
      P010T2_A394DConCodigo = new String[] {""} ;
      P010T2_A6LegNumero = new int[1] ;
      P010T2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P010T2_A1EmpCod = new short[1] ;
      P010T2_A3CliCod = new int[1] ;
      P010T2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P010T2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P010T2_n269LiqDCanti = new boolean[] {false} ;
      P010T2_A507LiqDCalculado = new byte[1] ;
      P010T2_A763LiqDRecalculado = new short[1] ;
      P010T2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      GXv_int1 = new byte[1] ;
      AV30Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcuporperiodo__default(),
         new Object[] {
             new Object[] {
            P010T2_A31LiqNro, P010T2_A2112LiqRelNro, P010T2_n2112LiqRelNro, P010T2_A394DConCodigo, P010T2_A6LegNumero, P010T2_A283LiqPeriodo, P010T2_A1EmpCod, P010T2_A3CliCod, P010T2_A764LiqDImpReCalcu, P010T2_A269LiqDCanti,
            P010T2_n269LiqDCanti, P010T2_A507LiqDCalculado, P010T2_A763LiqDRecalculado, P010T2_A81LiqDSecuencial
            }
         }
      );
      AV30Pgmname = "getLiqDImpCalcuPorPeriodo" ;
      /* GeneXus formulas. */
      AV30Pgmname = "getLiqDImpCalcuPorPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV29GXLvl3 ;
   private byte A507LiqDCalculado ;
   private byte AV26auxLiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV25LiqRelNro ;
   private int AV10LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV19LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV11ConCodigo ;
   private String AV22ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV30Pgmname ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV24insertandoConceptos ;
   private boolean AV23validarExistencia ;
   private boolean AV14existe ;
   private boolean n2112LiqRelNro ;
   private boolean n269LiqDCanti ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private boolean[] aP12 ;
   private IDataStoreProvider pr_default ;
   private int[] P010T2_A31LiqNro ;
   private int[] P010T2_A2112LiqRelNro ;
   private boolean[] P010T2_n2112LiqRelNro ;
   private String[] P010T2_A394DConCodigo ;
   private int[] P010T2_A6LegNumero ;
   private java.util.Date[] P010T2_A283LiqPeriodo ;
   private short[] P010T2_A1EmpCod ;
   private int[] P010T2_A3CliCod ;
   private java.math.BigDecimal[] P010T2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P010T2_A269LiqDCanti ;
   private boolean[] P010T2_n269LiqDCanti ;
   private byte[] P010T2_A507LiqDCalculado ;
   private short[] P010T2_A763LiqDRecalculado ;
   private int[] P010T2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcuporperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P010T2", "SELECT T1.LiqNro, T2.LiqRelNro, T1.DConCodigo, T1.LegNumero, T2.LiqPeriodo, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDCanti, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?)) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T2.LiqPeriodo = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
      }
   }

}

