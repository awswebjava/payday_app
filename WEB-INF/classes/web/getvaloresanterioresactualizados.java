package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getvaloresanterioresactualizados extends GXProcedure
{
   public getvaloresanterioresactualizados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getvaloresanterioresactualizados.class ), "" );
   }

   public getvaloresanterioresactualizados( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           String aP5 ,
                                           java.util.Date aP6 )
   {
      getvaloresanterioresactualizados.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      getvaloresanterioresactualizados.this.AV11CliCod = aP0;
      getvaloresanterioresactualizados.this.AV10EmpCod = aP1;
      getvaloresanterioresactualizados.this.AV17LiqNro = aP2;
      getvaloresanterioresactualizados.this.AV20LiqRelNro = aP3;
      getvaloresanterioresactualizados.this.AV8LegNumero = aP4;
      getvaloresanterioresactualizados.this.AV18DConCodigo = aP5;
      getvaloresanterioresactualizados.this.AV16fecha = aP6;
      getvaloresanterioresactualizados.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15eneroFecha = localUtil.ymdtod( GXutil.year( AV16fecha), 1, 1) ;
      /* Using cursor P00T22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero), AV18DConCodigo, AV15eneroFecha, Integer.valueOf(AV17LiqNro), Integer.valueOf(AV20LiqRelNro), AV16fecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P00T22_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00T22_n2112LiqRelNro[0] ;
         A394DConCodigo = P00T22_A394DConCodigo[0] ;
         A31LiqNro = P00T22_A31LiqNro[0] ;
         A397DLiqPeriodo = P00T22_A397DLiqPeriodo[0] ;
         A6LegNumero = P00T22_A6LegNumero[0] ;
         A1EmpCod = P00T22_A1EmpCod[0] ;
         A3CliCod = P00T22_A3CliCod[0] ;
         A764LiqDImpReCalcu = P00T22_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P00T22_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00T22_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00T22_n2112LiqRelNro[0] ;
         AV19LiqDImpReCalcu = AV19LiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "anteriores liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( AV19LiqDImpReCalcu, 14, 2))) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getvaloresanterioresactualizados.this.AV19LiqDImpReCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV15eneroFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00T22_A2112LiqRelNro = new int[1] ;
      P00T22_n2112LiqRelNro = new boolean[] {false} ;
      P00T22_A394DConCodigo = new String[] {""} ;
      P00T22_A31LiqNro = new int[1] ;
      P00T22_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00T22_A6LegNumero = new int[1] ;
      P00T22_A1EmpCod = new short[1] ;
      P00T22_A3CliCod = new int[1] ;
      P00T22_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00T22_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV24Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getvaloresanterioresactualizados__default(),
         new Object[] {
             new Object[] {
            P00T22_A2112LiqRelNro, P00T22_n2112LiqRelNro, P00T22_A394DConCodigo, P00T22_A31LiqNro, P00T22_A397DLiqPeriodo, P00T22_A6LegNumero, P00T22_A1EmpCod, P00T22_A3CliCod, P00T22_A764LiqDImpReCalcu, P00T22_A81LiqDSecuencial
            }
         }
      );
      AV24Pgmname = "getValoresAnterioresActualizados" ;
      /* GeneXus formulas. */
      AV24Pgmname = "getValoresAnterioresActualizados" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV17LiqNro ;
   private int AV20LiqRelNro ;
   private int AV8LegNumero ;
   private int A2112LiqRelNro ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV19LiqDImpReCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV18DConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV24Pgmname ;
   private java.util.Date AV16fecha ;
   private java.util.Date AV15eneroFecha ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean n2112LiqRelNro ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P00T22_A2112LiqRelNro ;
   private boolean[] P00T22_n2112LiqRelNro ;
   private String[] P00T22_A394DConCodigo ;
   private int[] P00T22_A31LiqNro ;
   private java.util.Date[] P00T22_A397DLiqPeriodo ;
   private int[] P00T22_A6LegNumero ;
   private short[] P00T22_A1EmpCod ;
   private int[] P00T22_A3CliCod ;
   private java.math.BigDecimal[] P00T22_A764LiqDImpReCalcu ;
   private int[] P00T22_A81LiqDSecuencial ;
}

final  class getvaloresanterioresactualizados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00T22", "SELECT T2.LiqRelNro, T1.DConCodigo, T1.LiqNro, T1.DLiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T1.LiqNro < ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DLiqPeriodo <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
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
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setDate(8, (java.util.Date)parms[7]);
               return;
      }
   }

}

