package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextdedsec extends GXProcedure
{
   public getnextdedsec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextdedsec.class ), "" );
   }

   public getnextdedsec( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 )
   {
      getnextdedsec.this.aP3 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int[] aP3 )
   {
      getnextdedsec.this.AV11CliCod = aP0;
      getnextdedsec.this.AV10EmpCod = aP1;
      getnextdedsec.this.AV9LegNumero = aP2;
      getnextdedsec.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00222 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00222_A3CliCod[0] ;
         A1EmpCod = P00222_A1EmpCod[0] ;
         A6LegNumero = P00222_A6LegNumero[0] ;
         A83LegDedSec = P00222_A83LegDedSec[0] ;
         AV8LegDedSec = A83LegDedSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8LegDedSec = (int)(AV8LegDedSec+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getnextdedsec.this.AV8LegDedSec;
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
      P00222_A3CliCod = new int[1] ;
      P00222_A1EmpCod = new short[1] ;
      P00222_A6LegNumero = new int[1] ;
      P00222_A83LegDedSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextdedsec__default(),
         new Object[] {
             new Object[] {
            P00222_A3CliCod, P00222_A1EmpCod, P00222_A6LegNumero, P00222_A83LegDedSec
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
   private int AV8LegDedSec ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private String scmdbuf ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00222_A3CliCod ;
   private short[] P00222_A1EmpCod ;
   private int[] P00222_A6LegNumero ;
   private int[] P00222_A83LegDedSec ;
}

final  class getnextdedsec__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00222", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegDedSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

