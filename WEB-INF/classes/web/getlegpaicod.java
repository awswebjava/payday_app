package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegpaicod extends GXProcedure
{
   public getlegpaicod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegpaicod.class ), "" );
   }

   public getlegpaicod( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getlegpaicod.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      getlegpaicod.this.AV11CliCod = aP0;
      getlegpaicod.this.AV10EmpCod = aP1;
      getlegpaicod.this.AV9LegNumero = aP2;
      getlegpaicod.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02LN2_A6LegNumero[0] ;
         A1EmpCod = P02LN2_A1EmpCod[0] ;
         A3CliCod = P02LN2_A3CliCod[0] ;
         A22LegPaiCod = P02LN2_A22LegPaiCod[0] ;
         n22LegPaiCod = P02LN2_n22LegPaiCod[0] ;
         AV12LegPaiCod = A22LegPaiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegpaicod.this.AV12LegPaiCod;
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
      P02LN2_A6LegNumero = new int[1] ;
      P02LN2_A1EmpCod = new short[1] ;
      P02LN2_A3CliCod = new int[1] ;
      P02LN2_A22LegPaiCod = new short[1] ;
      P02LN2_n22LegPaiCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegpaicod__default(),
         new Object[] {
             new Object[] {
            P02LN2_A6LegNumero, P02LN2_A1EmpCod, P02LN2_A3CliCod, P02LN2_A22LegPaiCod, P02LN2_n22LegPaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV12LegPaiCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n22LegPaiCod ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LN2_A6LegNumero ;
   private short[] P02LN2_A1EmpCod ;
   private int[] P02LN2_A3CliCod ;
   private short[] P02LN2_A22LegPaiCod ;
   private boolean[] P02LN2_n22LegPaiCod ;
}

final  class getlegpaicod__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LN2", "SELECT LegNumero, EmpCod, CliCod, LegPaiCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

