package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtcuillegajo extends GXProcedure
{
   public obtcuillegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtcuillegajo.class ), "" );
   }

   public obtcuillegajo( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 )
   {
      obtcuillegajo.this.aP3 = new long[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        long[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             long[] aP3 )
   {
      obtcuillegajo.this.AV11CliCod = aP0;
      obtcuillegajo.this.AV10EmpCod = aP1;
      obtcuillegajo.this.AV8LegNumero = aP2;
      obtcuillegajo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9LegCUIL = 0 ;
      /* Using cursor P00DO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00DO2_A6LegNumero[0] ;
         A1EmpCod = P00DO2_A1EmpCod[0] ;
         A3CliCod = P00DO2_A3CliCod[0] ;
         A239LegCUIL = P00DO2_A239LegCUIL[0] ;
         AV9LegCUIL = A239LegCUIL ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = obtcuillegajo.this.AV9LegCUIL;
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
      P00DO2_A6LegNumero = new int[1] ;
      P00DO2_A1EmpCod = new short[1] ;
      P00DO2_A3CliCod = new int[1] ;
      P00DO2_A239LegCUIL = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtcuillegajo__default(),
         new Object[] {
             new Object[] {
            P00DO2_A6LegNumero, P00DO2_A1EmpCod, P00DO2_A3CliCod, P00DO2_A239LegCUIL
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
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private long AV9LegCUIL ;
   private long A239LegCUIL ;
   private String scmdbuf ;
   private long[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00DO2_A6LegNumero ;
   private short[] P00DO2_A1EmpCod ;
   private int[] P00DO2_A3CliCod ;
   private long[] P00DO2_A239LegCUIL ;
}

final  class obtcuillegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00DO2", "SELECT LegNumero, EmpCod, CliCod, LegCUIL FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((long[]) buf[3])[0] = rslt.getLong(4);
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

