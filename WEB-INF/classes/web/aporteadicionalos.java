package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class aporteadicionalos extends GXProcedure
{
   public aporteadicionalos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aporteadicionalos.class ), "" );
   }

   public aporteadicionalos( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      aporteadicionalos.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      aporteadicionalos.this.AV11CliCod = aP0;
      aporteadicionalos.this.AV10EmpCod = aP1;
      aporteadicionalos.this.AV9LegNumero = aP2;
      aporteadicionalos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00XO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1580LegOsoCod = P00XO2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P00XO2_n1580LegOsoCod[0] ;
         A6LegNumero = P00XO2_A6LegNumero[0] ;
         A1EmpCod = P00XO2_A1EmpCod[0] ;
         A3CliCod = P00XO2_A3CliCod[0] ;
         A893OsoAporteAdic = P00XO2_A893OsoAporteAdic[0] ;
         n893OsoAporteAdic = P00XO2_n893OsoAporteAdic[0] ;
         A893OsoAporteAdic = P00XO2_A893OsoAporteAdic[0] ;
         n893OsoAporteAdic = P00XO2_n893OsoAporteAdic[0] ;
         AV8OsoAporteAdic = A893OsoAporteAdic ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = aporteadicionalos.this.AV8OsoAporteAdic;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OsoAporteAdic = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00XO2_A1580LegOsoCod = new String[] {""} ;
      P00XO2_n1580LegOsoCod = new boolean[] {false} ;
      P00XO2_A6LegNumero = new int[1] ;
      P00XO2_A1EmpCod = new short[1] ;
      P00XO2_A3CliCod = new int[1] ;
      P00XO2_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00XO2_n893OsoAporteAdic = new boolean[] {false} ;
      A1580LegOsoCod = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.aporteadicionalos__default(),
         new Object[] {
             new Object[] {
            P00XO2_A1580LegOsoCod, P00XO2_n1580LegOsoCod, P00XO2_A6LegNumero, P00XO2_A1EmpCod, P00XO2_A3CliCod, P00XO2_A893OsoAporteAdic, P00XO2_n893OsoAporteAdic
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8OsoAporteAdic ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private String scmdbuf ;
   private String A1580LegOsoCod ;
   private boolean n1580LegOsoCod ;
   private boolean n893OsoAporteAdic ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00XO2_A1580LegOsoCod ;
   private boolean[] P00XO2_n1580LegOsoCod ;
   private int[] P00XO2_A6LegNumero ;
   private short[] P00XO2_A1EmpCod ;
   private int[] P00XO2_A3CliCod ;
   private java.math.BigDecimal[] P00XO2_A893OsoAporteAdic ;
   private boolean[] P00XO2_n893OsoAporteAdic ;
}

final  class aporteadicionalos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00XO2", "SELECT T1.LegOsoCod AS LegOsoCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.OsoAporteAdic FROM (Legajo T1 LEFT JOIN ObraSocial T2 ON T2.CliCod = T1.CliCod AND T2.OsoCod = T1.LegOsoCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               return;
      }
   }

}

