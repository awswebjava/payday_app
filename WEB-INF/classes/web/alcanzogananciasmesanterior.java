package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class alcanzogananciasmesanterior extends GXProcedure
{
   public alcanzogananciasmesanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( alcanzogananciasmesanterior.class ), "" );
   }

   public alcanzogananciasmesanterior( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           java.util.Date aP3 )
   {
      alcanzogananciasmesanterior.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             byte[] aP4 )
   {
      alcanzogananciasmesanterior.this.AV10CliCod = aP0;
      alcanzogananciasmesanterior.this.AV11EmpCod = aP1;
      alcanzogananciasmesanterior.this.AV12LegNumero = aP2;
      alcanzogananciasmesanterior.this.AV9LiqPeriodo = aP3;
      alcanzogananciasmesanterior.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8anteriorLiqPeriodo = GXutil.addmth( AV9LiqPeriodo, (short)(-1)) ;
      AV8anteriorLiqPeriodo = localUtil.ymdtod( GXutil.year( AV8anteriorLiqPeriodo), GXutil.month( AV8anteriorLiqPeriodo), 1) ;
      GXt_char1 = AV15retencionGananciasConCodigo ;
      GXt_char2 = AV15retencionGananciasConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      alcanzogananciasmesanterior.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      alcanzogananciasmesanterior.this.GXt_char1 = GXv_char4[0] ;
      AV15retencionGananciasConCodigo = GXt_char1 ;
      /* Using cursor P01092 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero), AV15retencionGananciasConCodigo, AV8anteriorLiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P01092_A31LiqNro[0] ;
         A2112LiqRelNro = P01092_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01092_n2112LiqRelNro[0] ;
         A394DConCodigo = P01092_A394DConCodigo[0] ;
         A397DLiqPeriodo = P01092_A397DLiqPeriodo[0] ;
         A6LegNumero = P01092_A6LegNumero[0] ;
         A1EmpCod = P01092_A1EmpCod[0] ;
         A3CliCod = P01092_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01092_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P01092_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01092_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01092_n2112LiqRelNro[0] ;
         if ( A764LiqDImpReCalcu.doubleValue() != 0 )
         {
            AV14alcanzaGanancias = (byte)(1) ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = alcanzogananciasmesanterior.this.AV14alcanzaGanancias;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8anteriorLiqPeriodo = GXutil.nullDate() ;
      AV15retencionGananciasConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P01092_A31LiqNro = new int[1] ;
      P01092_A2112LiqRelNro = new int[1] ;
      P01092_n2112LiqRelNro = new boolean[] {false} ;
      P01092_A394DConCodigo = new String[] {""} ;
      P01092_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01092_A6LegNumero = new int[1] ;
      P01092_A1EmpCod = new short[1] ;
      P01092_A3CliCod = new int[1] ;
      P01092_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01092_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.alcanzogananciasmesanterior__default(),
         new Object[] {
             new Object[] {
            P01092_A31LiqNro, P01092_A2112LiqRelNro, P01092_n2112LiqRelNro, P01092_A394DConCodigo, P01092_A397DLiqPeriodo, P01092_A6LegNumero, P01092_A1EmpCod, P01092_A3CliCod, P01092_A764LiqDImpReCalcu, P01092_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14alcanzaGanancias ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV15retencionGananciasConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private java.util.Date AV9LiqPeriodo ;
   private java.util.Date AV8anteriorLiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean n2112LiqRelNro ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01092_A31LiqNro ;
   private int[] P01092_A2112LiqRelNro ;
   private boolean[] P01092_n2112LiqRelNro ;
   private String[] P01092_A394DConCodigo ;
   private java.util.Date[] P01092_A397DLiqPeriodo ;
   private int[] P01092_A6LegNumero ;
   private short[] P01092_A1EmpCod ;
   private int[] P01092_A3CliCod ;
   private java.math.BigDecimal[] P01092_A764LiqDImpReCalcu ;
   private int[] P01092_A81LiqDSecuencial ;
}

final  class alcanzogananciasmesanterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01092", "SELECT T1.LiqNro, T2.LiqRelNro, T1.DConCodigo, T1.DLiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo = ?) AND (T2.LiqRelNro IS NULL) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

}

