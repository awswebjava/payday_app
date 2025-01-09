package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqlegdaemon extends GXProcedure
{
   public getliqlegdaemon( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqlegdaemon.class ), "" );
   }

   public getliqlegdaemon( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 )
   {
      getliqlegdaemon.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 )
   {
      getliqlegdaemon.this.AV11clicod = aP0;
      getliqlegdaemon.this.AV10empcod = aP1;
      getliqlegdaemon.this.AV12LiqNro = aP2;
      getliqlegdaemon.this.AV9legnumero = aP3;
      getliqlegdaemon.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02KS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11clicod), Short.valueOf(AV10empcod), Integer.valueOf(AV12LiqNro), Integer.valueOf(AV9legnumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02KS2_A6LegNumero[0] ;
         A31LiqNro = P02KS2_A31LiqNro[0] ;
         A1EmpCod = P02KS2_A1EmpCod[0] ;
         A3CliCod = P02KS2_A3CliCod[0] ;
         A2401LiqLegDaemonUUID = P02KS2_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = P02KS2_n2401LiqLegDaemonUUID[0] ;
         AV8LiqLegDaemonUUID = A2401LiqLegDaemonUUID ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getliqlegdaemon.this.AV8LiqLegDaemonUUID;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqLegDaemonUUID = "" ;
      scmdbuf = "" ;
      P02KS2_A6LegNumero = new int[1] ;
      P02KS2_A31LiqNro = new int[1] ;
      P02KS2_A1EmpCod = new short[1] ;
      P02KS2_A3CliCod = new int[1] ;
      P02KS2_A2401LiqLegDaemonUUID = new String[] {""} ;
      P02KS2_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      A2401LiqLegDaemonUUID = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqlegdaemon__default(),
         new Object[] {
             new Object[] {
            P02KS2_A6LegNumero, P02KS2_A31LiqNro, P02KS2_A1EmpCod, P02KS2_A3CliCod, P02KS2_A2401LiqLegDaemonUUID, P02KS2_n2401LiqLegDaemonUUID
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11clicod ;
   private int AV12LiqNro ;
   private int AV9legnumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV8LiqLegDaemonUUID ;
   private String scmdbuf ;
   private String A2401LiqLegDaemonUUID ;
   private boolean n2401LiqLegDaemonUUID ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02KS2_A6LegNumero ;
   private int[] P02KS2_A31LiqNro ;
   private short[] P02KS2_A1EmpCod ;
   private int[] P02KS2_A3CliCod ;
   private String[] P02KS2_A2401LiqLegDaemonUUID ;
   private boolean[] P02KS2_n2401LiqLegDaemonUUID ;
}

final  class getliqlegdaemon__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02KS2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegDaemonUUID FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 36);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

