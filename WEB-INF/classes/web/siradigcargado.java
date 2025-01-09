package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siradigcargado extends GXProcedure
{
   public siradigcargado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradigcargado.class ), "" );
   }

   public siradigcargado( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 )
   {
      siradigcargado.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 )
   {
      siradigcargado.this.AV13CliCod = aP0;
      siradigcargado.this.AV12EmpCod = aP1;
      siradigcargado.this.AV11LegNumero = aP2;
      siradigcargado.this.AV14LiqPeriodo = aP3;
      siradigcargado.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LegDedAnio = (short)(GXutil.year( AV14LiqPeriodo)) ;
      /* Using cursor P00ZR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), Short.valueOf(AV10LegDedAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A768LegDedAnio = P00ZR2_A768LegDedAnio[0] ;
         A6LegNumero = P00ZR2_A6LegNumero[0] ;
         A1EmpCod = P00ZR2_A1EmpCod[0] ;
         A3CliCod = P00ZR2_A3CliCod[0] ;
         A83LegDedSec = P00ZR2_A83LegDedSec[0] ;
         AV9hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = siradigcargado.this.AV9hay;
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
      P00ZR2_A768LegDedAnio = new short[1] ;
      P00ZR2_A6LegNumero = new int[1] ;
      P00ZR2_A1EmpCod = new short[1] ;
      P00ZR2_A3CliCod = new int[1] ;
      P00ZR2_A83LegDedSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradigcargado__default(),
         new Object[] {
             new Object[] {
            P00ZR2_A768LegDedAnio, P00ZR2_A6LegNumero, P00ZR2_A1EmpCod, P00ZR2_A3CliCod, P00ZR2_A83LegDedSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV10LegDedAnio ;
   private short A768LegDedAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A83LegDedSec ;
   private String scmdbuf ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV9hay ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00ZR2_A768LegDedAnio ;
   private int[] P00ZR2_A6LegNumero ;
   private short[] P00ZR2_A1EmpCod ;
   private int[] P00ZR2_A3CliCod ;
   private int[] P00ZR2_A83LegDedSec ;
}

final  class siradigcargado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZR2", "SELECT LegDedAnio, LegNumero, EmpCod, CliCod, LegDedSec FROM legajo_deducciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegDedAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegDedAnio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

