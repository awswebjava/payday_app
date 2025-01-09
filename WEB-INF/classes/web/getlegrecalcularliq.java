package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegrecalcularliq extends GXProcedure
{
   public getlegrecalcularliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegrecalcularliq.class ), "" );
   }

   public getlegrecalcularliq( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 )
   {
      getlegrecalcularliq.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 )
   {
      getlegrecalcularliq.this.AV10CliCod = aP0;
      getlegrecalcularliq.this.AV9EmpCod = aP1;
      getlegrecalcularliq.this.AV8LegNumero = aP2;
      getlegrecalcularliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P011N2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P011N2_A6LegNumero[0] ;
         A1EmpCod = P011N2_A1EmpCod[0] ;
         A3CliCod = P011N2_A3CliCod[0] ;
         A942LegRecalcLiq = P011N2_A942LegRecalcLiq[0] ;
         AV11LegRecalcLiq = A942LegRecalcLiq ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegrecalcularliq.this.AV11LegRecalcLiq;
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
      P011N2_A6LegNumero = new int[1] ;
      P011N2_A1EmpCod = new short[1] ;
      P011N2_A3CliCod = new int[1] ;
      P011N2_A942LegRecalcLiq = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegrecalcularliq__default(),
         new Object[] {
             new Object[] {
            P011N2_A6LegNumero, P011N2_A1EmpCod, P011N2_A3CliCod, P011N2_A942LegRecalcLiq
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV11LegRecalcLiq ;
   private boolean A942LegRecalcLiq ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P011N2_A6LegNumero ;
   private short[] P011N2_A1EmpCod ;
   private int[] P011N2_A3CliCod ;
   private boolean[] P011N2_A942LegRecalcLiq ;
}

final  class getlegrecalcularliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011N2", "SELECT LegNumero, EmpCod, CliCod, LegRecalcLiq FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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

