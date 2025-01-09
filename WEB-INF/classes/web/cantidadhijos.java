package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantidadhijos extends GXProcedure
{
   public cantidadhijos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantidadhijos.class ), "" );
   }

   public cantidadhijos( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            boolean aP3 ,
                            java.util.Date aP4 ,
                            short aP5 ,
                            short aP6 ,
                            java.math.BigDecimal aP7 )
   {
      cantidadhijos.this.aP8 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        short aP6 ,
                        java.math.BigDecimal aP7 ,
                        short[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             short aP6 ,
                             java.math.BigDecimal aP7 ,
                             short[] aP8 )
   {
      cantidadhijos.this.AV12CliCod = aP0;
      cantidadhijos.this.AV13EmpCod = aP1;
      cantidadhijos.this.AV14LegNumero = aP2;
      cantidadhijos.this.AV15FamDiscap = aP3;
      cantidadhijos.this.AV16Fecha = aP4;
      cantidadhijos.this.AV20edadDesde = aP5;
      cantidadhijos.this.AV18EdadLimite = aP6;
      cantidadhijos.this.AV19porcentajeParametro = aP7;
      cantidadhijos.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV23GXLvl4 = (byte)(0) ;
      /* Using cursor P00QI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV14LegNumero), Boolean.valueOf(AV15FamDiscap)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A30ParCod = P00QI2_A30ParCod[0] ;
         A205FamDiscap = P00QI2_A205FamDiscap[0] ;
         n205FamDiscap = P00QI2_n205FamDiscap[0] ;
         A2274ParenTipo = P00QI2_A2274ParenTipo[0] ;
         A6LegNumero = P00QI2_A6LegNumero[0] ;
         A1EmpCod = P00QI2_A1EmpCod[0] ;
         A3CliCod = P00QI2_A3CliCod[0] ;
         A209FamFecNac = P00QI2_A209FamFecNac[0] ;
         n209FamFecNac = P00QI2_n209FamFecNac[0] ;
         A220FamTomaDeducImpGan = P00QI2_A220FamTomaDeducImpGan[0] ;
         A29LegOrden = P00QI2_A29LegOrden[0] ;
         A2274ParenTipo = P00QI2_A2274ParenTipo[0] ;
         AV23GXLvl4 = (byte)(1) ;
         GXt_dtime1 = GXutil.resetTime( A209FamFecNac );
         GXt_dtime2 = GXutil.resetTime( AV16Fecha );
         AV17Edad = (short)(GXutil.age( GXt_dtime1, GXt_dtime2)) ;
         if ( ( AV17Edad >= AV20edadDesde ) && ( AV17Edad <= AV18EdadLimite ) )
         {
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19porcentajeParametro)==0) || ( DecimalUtil.compareTo(A220FamTomaDeducImpGan, AV19porcentajeParametro) == 0 ) )
            {
               AV10i = (short)(AV10i+1) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV23GXLvl4 == 0 )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = cantidadhijos.this.AV10i;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00QI2_A30ParCod = new String[] {""} ;
      P00QI2_A205FamDiscap = new boolean[] {false} ;
      P00QI2_n205FamDiscap = new boolean[] {false} ;
      P00QI2_A2274ParenTipo = new String[] {""} ;
      P00QI2_A6LegNumero = new int[1] ;
      P00QI2_A1EmpCod = new short[1] ;
      P00QI2_A3CliCod = new int[1] ;
      P00QI2_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P00QI2_n209FamFecNac = new boolean[] {false} ;
      P00QI2_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QI2_A29LegOrden = new short[1] ;
      A30ParCod = "" ;
      A2274ParenTipo = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cantidadhijos__default(),
         new Object[] {
             new Object[] {
            P00QI2_A30ParCod, P00QI2_A205FamDiscap, P00QI2_n205FamDiscap, P00QI2_A2274ParenTipo, P00QI2_A6LegNumero, P00QI2_A1EmpCod, P00QI2_A3CliCod, P00QI2_A209FamFecNac, P00QI2_n209FamFecNac, P00QI2_A220FamTomaDeducImpGan,
            P00QI2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV23GXLvl4 ;
   private short AV13EmpCod ;
   private short AV20edadDesde ;
   private short AV18EdadLimite ;
   private short AV10i ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short AV17Edad ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV19porcentajeParametro ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String A2274ParenTipo ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date AV16Fecha ;
   private java.util.Date A209FamFecNac ;
   private boolean AV15FamDiscap ;
   private boolean A205FamDiscap ;
   private boolean n205FamDiscap ;
   private boolean n209FamFecNac ;
   private short[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P00QI2_A30ParCod ;
   private boolean[] P00QI2_A205FamDiscap ;
   private boolean[] P00QI2_n205FamDiscap ;
   private String[] P00QI2_A2274ParenTipo ;
   private int[] P00QI2_A6LegNumero ;
   private short[] P00QI2_A1EmpCod ;
   private int[] P00QI2_A3CliCod ;
   private java.util.Date[] P00QI2_A209FamFecNac ;
   private boolean[] P00QI2_n209FamFecNac ;
   private java.math.BigDecimal[] P00QI2_A220FamTomaDeducImpGan ;
   private short[] P00QI2_A29LegOrden ;
}

final  class cantidadhijos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QI2", "SELECT T1.ParCod, T1.FamDiscap, T2.ParenTipo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.FamFecNac, T1.FamTomaDeducImpGan, T1.LegOrden FROM (LegajoFamilia T1 INNER JOIN Parentesco T2 ON T2.CliCod = T1.CliCod AND T2.ParCod = T1.ParCod) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.ParenTipo = ( '2')) AND (T1.FamDiscap = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

