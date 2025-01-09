package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class porcentajededuccionhijos extends GXProcedure
{
   public porcentajededuccionhijos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( porcentajededuccionhijos.class ), "" );
   }

   public porcentajededuccionhijos( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           boolean aP3 ,
                                           java.util.Date aP4 )
   {
      porcentajededuccionhijos.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      porcentajededuccionhijos.this.AV12CliCod = aP0;
      porcentajededuccionhijos.this.AV13EmpCod = aP1;
      porcentajededuccionhijos.this.AV14LegNumero = aP2;
      porcentajededuccionhijos.this.AV17FamDiscap = aP3;
      porcentajededuccionhijos.this.AV16Fecha = aP4;
      porcentajededuccionhijos.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00QH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV14LegNumero), Boolean.valueOf(AV17FamDiscap)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A30ParCod = P00QH2_A30ParCod[0] ;
         A205FamDiscap = P00QH2_A205FamDiscap[0] ;
         n205FamDiscap = P00QH2_n205FamDiscap[0] ;
         A2274ParenTipo = P00QH2_A2274ParenTipo[0] ;
         A6LegNumero = P00QH2_A6LegNumero[0] ;
         A1EmpCod = P00QH2_A1EmpCod[0] ;
         A3CliCod = P00QH2_A3CliCod[0] ;
         A209FamFecNac = P00QH2_A209FamFecNac[0] ;
         n209FamFecNac = P00QH2_n209FamFecNac[0] ;
         A220FamTomaDeducImpGan = P00QH2_A220FamTomaDeducImpGan[0] ;
         A29LegOrden = P00QH2_A29LegOrden[0] ;
         A2274ParenTipo = P00QH2_A2274ParenTipo[0] ;
         GXt_dtime1 = GXutil.resetTime( A209FamFecNac );
         GXt_dtime2 = GXutil.resetTime( AV16Fecha );
         AV15Edad = (short)(GXutil.age( GXt_dtime1, GXt_dtime2)) ;
         if ( AV15Edad <= 18 )
         {
            AV9sumaPorUnaje = AV9sumaPorUnaje.add(A220FamTomaDeducImpGan) ;
            AV10i = (short)(AV10i+1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV10i > 0 )
      {
         AV11porUnaje = AV9sumaPorUnaje.divide(DecimalUtil.doubleToDec(AV10i), 18, java.math.RoundingMode.DOWN) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = porcentajededuccionhijos.this.AV11porUnaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11porUnaje = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00QH2_A30ParCod = new String[] {""} ;
      P00QH2_A205FamDiscap = new boolean[] {false} ;
      P00QH2_n205FamDiscap = new boolean[] {false} ;
      P00QH2_A2274ParenTipo = new String[] {""} ;
      P00QH2_A6LegNumero = new int[1] ;
      P00QH2_A1EmpCod = new short[1] ;
      P00QH2_A3CliCod = new int[1] ;
      P00QH2_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P00QH2_n209FamFecNac = new boolean[] {false} ;
      P00QH2_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QH2_A29LegOrden = new short[1] ;
      A30ParCod = "" ;
      A2274ParenTipo = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      AV9sumaPorUnaje = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.porcentajededuccionhijos__default(),
         new Object[] {
             new Object[] {
            P00QH2_A30ParCod, P00QH2_A205FamDiscap, P00QH2_n205FamDiscap, P00QH2_A2274ParenTipo, P00QH2_A6LegNumero, P00QH2_A1EmpCod, P00QH2_A3CliCod, P00QH2_A209FamFecNac, P00QH2_n209FamFecNac, P00QH2_A220FamTomaDeducImpGan,
            P00QH2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short AV15Edad ;
   private short AV10i ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11porUnaje ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private java.math.BigDecimal AV9sumaPorUnaje ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String A2274ParenTipo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date AV16Fecha ;
   private java.util.Date A209FamFecNac ;
   private boolean AV17FamDiscap ;
   private boolean A205FamDiscap ;
   private boolean n205FamDiscap ;
   private boolean n209FamFecNac ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00QH2_A30ParCod ;
   private boolean[] P00QH2_A205FamDiscap ;
   private boolean[] P00QH2_n205FamDiscap ;
   private String[] P00QH2_A2274ParenTipo ;
   private int[] P00QH2_A6LegNumero ;
   private short[] P00QH2_A1EmpCod ;
   private int[] P00QH2_A3CliCod ;
   private java.util.Date[] P00QH2_A209FamFecNac ;
   private boolean[] P00QH2_n209FamFecNac ;
   private java.math.BigDecimal[] P00QH2_A220FamTomaDeducImpGan ;
   private short[] P00QH2_A29LegOrden ;
}

final  class porcentajededuccionhijos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QH2", "SELECT T1.ParCod, T1.FamDiscap, T2.ParenTipo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.FamFecNac, T1.FamTomaDeducImpGan, T1.LegOrden FROM (LegajoFamilia T1 INNER JOIN Parentesco T2 ON T2.CliCod = T1.CliCod AND T2.ParCod = T1.ParCod) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.ParenTipo = ( '2')) AND (T1.FamDiscap = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((short[]) buf[10])[0] = rslt.getShort(9);
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
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               return;
      }
   }

}

