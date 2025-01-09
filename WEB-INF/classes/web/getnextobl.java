package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextobl extends GXProcedure
{
   public getnextobl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextobl.class ), "" );
   }

   public getnextobl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getnextobl.this.aP3 = new short[] {0};
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
      getnextobl.this.AV9CliCod = aP0;
      getnextobl.this.AV10EmpCod = aP1;
      getnextobl.this.AV11LegNumero = aP2;
      getnextobl.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01AH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01AH2_A3CliCod[0] ;
         A1EmpCod = P01AH2_A1EmpCod[0] ;
         A6LegNumero = P01AH2_A6LegNumero[0] ;
         A1172OblSecuencial = P01AH2_A1172OblSecuencial[0] ;
         AV8OblSecuencial = A1172OblSecuencial ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8OblSecuencial = (short)(AV8OblSecuencial+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getnextobl.this.AV8OblSecuencial;
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
      P01AH2_A3CliCod = new int[1] ;
      P01AH2_A1EmpCod = new short[1] ;
      P01AH2_A6LegNumero = new int[1] ;
      P01AH2_A1172OblSecuencial = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextobl__default(),
         new Object[] {
             new Object[] {
            P01AH2_A3CliCod, P01AH2_A1EmpCod, P01AH2_A6LegNumero, P01AH2_A1172OblSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8OblSecuencial ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01AH2_A3CliCod ;
   private short[] P01AH2_A1EmpCod ;
   private int[] P01AH2_A6LegNumero ;
   private short[] P01AH2_A1172OblSecuencial ;
}

final  class getnextobl__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AH2", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

