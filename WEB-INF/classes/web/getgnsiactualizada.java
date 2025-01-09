package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getgnsiactualizada extends GXProcedure
{
   public getgnsiactualizada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getgnsiactualizada.class ), "" );
   }

   public getgnsiactualizada( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           int aP4 ,
                           java.util.Date aP5 ,
                           String aP6 ,
                           java.math.BigDecimal[] aP7 )
   {
      getgnsiactualizada.this.aP8 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        byte[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 )
   {
      getgnsiactualizada.this.AV11CliCod = aP0;
      getgnsiactualizada.this.AV10EmpCod = aP1;
      getgnsiactualizada.this.AV17LiqNro = aP2;
      getgnsiactualizada.this.AV30LiqRelNro = aP3;
      getgnsiactualizada.this.AV8LegNumero = aP4;
      getgnsiactualizada.this.AV16LiqPeriodo = aP5;
      getgnsiactualizada.this.AV26ProcesoLiquidacion = aP6;
      getgnsiactualizada.this.aP7 = aP7;
      getgnsiactualizada.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12gnsiConCodigo ;
      GXt_char2 = AV12gnsiConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.gannetsujimpmenosdedinc_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getgnsiactualizada.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
      getgnsiactualizada.this.GXt_char1 = GXv_char4[0] ;
      AV12gnsiConCodigo = GXt_char1 ;
      AV28eneroFecha = localUtil.ymdtod( GXutil.year( AV16LiqPeriodo), 1, 1) ;
      /* Using cursor P00SS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero), AV12gnsiConCodigo, AV28eneroFecha, Integer.valueOf(AV30LiqRelNro), AV16LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkSS2 = false ;
         A31LiqNro = P00SS2_A31LiqNro[0] ;
         A507LiqDCalculado = P00SS2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P00SS2_A763LiqDRecalculado[0] ;
         A764LiqDImpReCalcu = P00SS2_A764LiqDImpReCalcu[0] ;
         A397DLiqPeriodo = P00SS2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P00SS2_A394DConCodigo[0] ;
         A6LegNumero = P00SS2_A6LegNumero[0] ;
         A1EmpCod = P00SS2_A1EmpCod[0] ;
         A3CliCod = P00SS2_A3CliCod[0] ;
         A2112LiqRelNro = P00SS2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00SS2_n2112LiqRelNro[0] ;
         A81LiqDSecuencial = P00SS2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00SS2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00SS2_n2112LiqRelNro[0] ;
         AV29mesImportes = DecimalUtil.doubleToDec(0) ;
         while ( (pr_default.getStatus(0) != 101) && ( P00SS2_A3CliCod[0] == A3CliCod ) && ( P00SS2_A1EmpCod[0] == A1EmpCod ) && ( P00SS2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00SS2_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            if ( ! ( GXutil.dateCompare(GXutil.resetTime(P00SS2_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
            {
               if (true) break;
            }
            brkSS2 = false ;
            A31LiqNro = P00SS2_A31LiqNro[0] ;
            A507LiqDCalculado = P00SS2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P00SS2_A763LiqDRecalculado[0] ;
            A764LiqDImpReCalcu = P00SS2_A764LiqDImpReCalcu[0] ;
            A81LiqDSecuencial = P00SS2_A81LiqDSecuencial[0] ;
            if ( A31LiqNro == AV17LiqNro )
            {
               GXv_int5[0] = AV14LiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV11CliCod, AV12gnsiConCodigo, AV26ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
               getgnsiactualizada.this.AV14LiqDCalculado = GXv_int5[0] ;
               if ( AV14LiqDCalculado == 0 )
               {
                  GXt_char2 = AV25dependenciasNoResueltasTxt ;
                  GXv_char4[0] = GXt_char2 ;
                  new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char4) ;
                  getgnsiactualizada.this.GXt_char2 = GXv_char4[0] ;
                  AV25dependenciasNoResueltasTxt = GXt_char2 + GXutil.trim( AV12gnsiConCodigo) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, AV25dependenciasNoResueltasTxt) ;
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            AV29mesImportes = AV29mesImportes.add(A764LiqDImpReCalcu) ;
            brkSS2 = true ;
            pr_default.readNext(0);
         }
         if ( AV29mesImportes.doubleValue() > 0 )
         {
            AV9LiqDImpCalcu = AV9LiqDImpCalcu.add(AV29mesImportes) ;
         }
         if ( ! brkSS2 )
         {
            brkSS2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getgnsiactualizada.this.AV9LiqDImpCalcu;
      this.aP8[0] = getgnsiactualizada.this.AV14LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqDImpCalcu = DecimalUtil.ZERO ;
      AV12gnsiConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV28eneroFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00SS2_A31LiqNro = new int[1] ;
      P00SS2_A507LiqDCalculado = new byte[1] ;
      P00SS2_A763LiqDRecalculado = new short[1] ;
      P00SS2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00SS2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00SS2_A394DConCodigo = new String[] {""} ;
      P00SS2_A6LegNumero = new int[1] ;
      P00SS2_A1EmpCod = new short[1] ;
      P00SS2_A3CliCod = new int[1] ;
      P00SS2_A2112LiqRelNro = new int[1] ;
      P00SS2_n2112LiqRelNro = new boolean[] {false} ;
      P00SS2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      AV29mesImportes = DecimalUtil.ZERO ;
      GXv_int5 = new byte[1] ;
      AV25dependenciasNoResueltasTxt = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      AV35Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getgnsiactualizada__default(),
         new Object[] {
             new Object[] {
            P00SS2_A31LiqNro, P00SS2_A507LiqDCalculado, P00SS2_A763LiqDRecalculado, P00SS2_A764LiqDImpReCalcu, P00SS2_A397DLiqPeriodo, P00SS2_A394DConCodigo, P00SS2_A6LegNumero, P00SS2_A1EmpCod, P00SS2_A3CliCod, P00SS2_A2112LiqRelNro,
            P00SS2_n2112LiqRelNro, P00SS2_A81LiqDSecuencial
            }
         }
      );
      AV35Pgmname = "getGNSIActualizada" ;
      /* GeneXus formulas. */
      AV35Pgmname = "getGNSIActualizada" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte GXv_int5[] ;
   private short AV10EmpCod ;
   private short A763LiqDRecalculado ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV17LiqNro ;
   private int AV30LiqRelNro ;
   private int AV8LegNumero ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A2112LiqRelNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV9LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV29mesImportes ;
   private String AV26ProcesoLiquidacion ;
   private String AV12gnsiConCodigo ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String AV35Pgmname ;
   private java.util.Date AV16LiqPeriodo ;
   private java.util.Date AV28eneroFecha ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean brkSS2 ;
   private boolean n2112LiqRelNro ;
   private boolean returnInSub ;
   private String AV25dependenciasNoResueltasTxt ;
   private byte[] aP8 ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P00SS2_A31LiqNro ;
   private byte[] P00SS2_A507LiqDCalculado ;
   private short[] P00SS2_A763LiqDRecalculado ;
   private java.math.BigDecimal[] P00SS2_A764LiqDImpReCalcu ;
   private java.util.Date[] P00SS2_A397DLiqPeriodo ;
   private String[] P00SS2_A394DConCodigo ;
   private int[] P00SS2_A6LegNumero ;
   private short[] P00SS2_A1EmpCod ;
   private int[] P00SS2_A3CliCod ;
   private int[] P00SS2_A2112LiqRelNro ;
   private boolean[] P00SS2_n2112LiqRelNro ;
   private int[] P00SS2_A81LiqDSecuencial ;
}

final  class getgnsiactualizada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SS2", "SELECT T1.LiqNro, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqDImpReCalcu, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LiqRelNro, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DLiqPeriodo <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
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

