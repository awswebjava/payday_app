package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getleghorassemana extends GXProcedure
{
   public getleghorassemana( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getleghorassemana.class ), "" );
   }

   public getleghorassemana( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      getleghorassemana.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
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
      getleghorassemana.this.AV11CliCod = aP0;
      getleghorassemana.this.AV10EmpCod = aP1;
      getleghorassemana.this.AV9LegNumero = aP2;
      getleghorassemana.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01BU2_A6LegNumero[0] ;
         A1EmpCod = P01BU2_A1EmpCod[0] ;
         A3CliCod = P01BU2_A3CliCod[0] ;
         A1268LegHorasSem = P01BU2_A1268LegHorasSem[0] ;
         AV12LegHorasSem = A1268LegHorasSem ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getleghorassemana.this.AV12LegHorasSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegHorasSem = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01BU2_A6LegNumero = new int[1] ;
      P01BU2_A1EmpCod = new short[1] ;
      P01BU2_A3CliCod = new int[1] ;
      P01BU2_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1268LegHorasSem = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getleghorassemana__default(),
         new Object[] {
             new Object[] {
            P01BU2_A6LegNumero, P01BU2_A1EmpCod, P01BU2_A3CliCod, P01BU2_A1268LegHorasSem
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
   private java.math.BigDecimal AV12LegHorasSem ;
   private java.math.BigDecimal A1268LegHorasSem ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01BU2_A6LegNumero ;
   private short[] P01BU2_A1EmpCod ;
   private int[] P01BU2_A3CliCod ;
   private java.math.BigDecimal[] P01BU2_A1268LegHorasSem ;
}

final  class getleghorassemana__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BU2", "SELECT LegNumero, EmpCod, CliCod, LegHorasSem FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
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

