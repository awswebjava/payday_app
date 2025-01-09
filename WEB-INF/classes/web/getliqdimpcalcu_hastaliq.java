package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcu_hastaliq extends GXProcedure
{
   public getliqdimpcalcu_hastaliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcu_hastaliq.class ), "" );
   }

   public getliqdimpcalcu_hastaliq( int remoteHandle ,
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
                                           java.util.Date aP5 ,
                                           String aP6 ,
                                           boolean aP7 ,
                                           String aP8 )
   {
      getliqdimpcalcu_hastaliq.this.aP9 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        java.math.BigDecimal[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 )
   {
      getliqdimpcalcu_hastaliq.this.AV13CliCod = aP0;
      getliqdimpcalcu_hastaliq.this.AV8EmpCod = aP1;
      getliqdimpcalcu_hastaliq.this.AV9LiqNro = aP2;
      getliqdimpcalcu_hastaliq.this.AV23LiqRelNro = aP3;
      getliqdimpcalcu_hastaliq.this.AV10LegNumero = aP4;
      getliqdimpcalcu_hastaliq.this.AV18LiqPeriodo = aP5;
      getliqdimpcalcu_hastaliq.this.AV11ConCodigo = aP6;
      getliqdimpcalcu_hastaliq.this.AV20excluirAguinaldo = aP7;
      getliqdimpcalcu_hastaliq.this.AV24TLiqCod = aP8;
      getliqdimpcalcu_hastaliq.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV21sacTLiqCod ;
      GXt_char2 = AV21sacTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getliqdimpcalcu_hastaliq.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
      getliqdimpcalcu_hastaliq.this.GXt_char1 = GXv_char4[0] ;
      AV21sacTLiqCod = GXt_char1 ;
      GXt_char2 = AV19egresoTLiqCod ;
      GXt_char1 = AV19egresoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      getliqdimpcalcu_hastaliq.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
      getliqdimpcalcu_hastaliq.this.GXt_char2 = GXv_char3[0] ;
      AV19egresoTLiqCod = GXt_char2 ;
      /* Using cursor P014D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, Integer.valueOf(AV9LiqNro), Integer.valueOf(AV23LiqRelNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P014D2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P014D2_n2112LiqRelNro[0] ;
         A31LiqNro = P014D2_A31LiqNro[0] ;
         A397DLiqPeriodo = P014D2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P014D2_A394DConCodigo[0] ;
         A6LegNumero = P014D2_A6LegNumero[0] ;
         A1EmpCod = P014D2_A1EmpCod[0] ;
         A3CliCod = P014D2_A3CliCod[0] ;
         A400DTLiqCod = P014D2_A400DTLiqCod[0] ;
         A764LiqDImpReCalcu = P014D2_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P014D2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P014D2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P014D2_n2112LiqRelNro[0] ;
         if ( ! AV20excluirAguinaldo )
         {
            AV22aplica = true ;
         }
         else
         {
            GXv_boolean5[0] = AV22aplica ;
            new web.gettipoliqacumula(remoteHandle, context).execute( AV13CliCod, A400DTLiqCod, GXv_boolean5) ;
            getliqdimpcalcu_hastaliq.this.AV22aplica = GXv_boolean5[0] ;
         }
         if ( AV22aplica )
         {
            AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getliqdimpcalcu_hastaliq.this.AV12LiqDImpCalcu;
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
      AV21sacTLiqCod = "" ;
      AV19egresoTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P014D2_A2112LiqRelNro = new int[1] ;
      P014D2_n2112LiqRelNro = new boolean[] {false} ;
      P014D2_A31LiqNro = new int[1] ;
      P014D2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P014D2_A394DConCodigo = new String[] {""} ;
      P014D2_A6LegNumero = new int[1] ;
      P014D2_A1EmpCod = new short[1] ;
      P014D2_A3CliCod = new int[1] ;
      P014D2_A400DTLiqCod = new String[] {""} ;
      P014D2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014D2_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A400DTLiqCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcu_hastaliq__default(),
         new Object[] {
             new Object[] {
            P014D2_A2112LiqRelNro, P014D2_n2112LiqRelNro, P014D2_A31LiqNro, P014D2_A397DLiqPeriodo, P014D2_A394DConCodigo, P014D2_A6LegNumero, P014D2_A1EmpCod, P014D2_A3CliCod, P014D2_A400DTLiqCod, P014D2_A764LiqDImpReCalcu,
            P014D2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV23LiqRelNro ;
   private int AV10LegNumero ;
   private int A2112LiqRelNro ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV11ConCodigo ;
   private String AV24TLiqCod ;
   private String AV21sacTLiqCod ;
   private String AV19egresoTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A400DTLiqCod ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV20excluirAguinaldo ;
   private boolean n2112LiqRelNro ;
   private boolean AV22aplica ;
   private boolean GXv_boolean5[] ;
   private java.math.BigDecimal[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P014D2_A2112LiqRelNro ;
   private boolean[] P014D2_n2112LiqRelNro ;
   private int[] P014D2_A31LiqNro ;
   private java.util.Date[] P014D2_A397DLiqPeriodo ;
   private String[] P014D2_A394DConCodigo ;
   private int[] P014D2_A6LegNumero ;
   private short[] P014D2_A1EmpCod ;
   private int[] P014D2_A3CliCod ;
   private String[] P014D2_A400DTLiqCod ;
   private java.math.BigDecimal[] P014D2_A764LiqDImpReCalcu ;
   private int[] P014D2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcu_hastaliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014D2", "SELECT T2.LiqRelNro, T1.LiqNro, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.DTLiqCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo = ?) AND (T1.LiqNro <= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
               return;
      }
   }

}

