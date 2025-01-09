package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerlegajoporcuit extends GXProcedure
{
   public obtenerlegajoporcuit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerlegajoporcuit.class ), "" );
   }

   public obtenerlegajoporcuit( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          long aP2 )
   {
      obtenerlegajoporcuit.this.aP3 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        long aP2 ,
                        int[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             long aP2 ,
                             int[] aP3 )
   {
      obtenerlegajoporcuit.this.AV11CliCod = aP0;
      obtenerlegajoporcuit.this.AV10EmpCod = aP1;
      obtenerlegajoporcuit.this.AV8LegCUIL = aP2;
      obtenerlegajoporcuit.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00KB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Long.valueOf(AV8LegCUIL)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A239LegCUIL = P00KB2_A239LegCUIL[0] ;
         A1EmpCod = P00KB2_A1EmpCod[0] ;
         A3CliCod = P00KB2_A3CliCod[0] ;
         A6LegNumero = P00KB2_A6LegNumero[0] ;
         AV9LegNumero = A6LegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = obtenerlegajoporcuit.this.AV9LegNumero;
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
      P00KB2_A239LegCUIL = new long[1] ;
      P00KB2_A1EmpCod = new short[1] ;
      P00KB2_A3CliCod = new int[1] ;
      P00KB2_A6LegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtenerlegajoporcuit__default(),
         new Object[] {
             new Object[] {
            P00KB2_A239LegCUIL, P00KB2_A1EmpCod, P00KB2_A3CliCod, P00KB2_A6LegNumero
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
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV8LegCUIL ;
   private long A239LegCUIL ;
   private String scmdbuf ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private long[] P00KB2_A239LegCUIL ;
   private short[] P00KB2_A1EmpCod ;
   private int[] P00KB2_A3CliCod ;
   private int[] P00KB2_A6LegNumero ;
}

final  class obtenerlegajoporcuit__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KB2", "SELECT LegCUIL, EmpCod, CliCod, LegNumero FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegCUIL = ?) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

