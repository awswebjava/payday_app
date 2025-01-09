package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayimpliqdet extends GXProcedure
{
   public hayimpliqdet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayimpliqdet.class ), "" );
   }

   public hayimpliqdet( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 )
   {
      hayimpliqdet.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             boolean[] aP3 )
   {
      hayimpliqdet.this.AV11CliCod = aP0;
      hayimpliqdet.this.AV8EmpCod = aP1;
      hayimpliqdet.this.AV9ImpLiqSec = aP2;
      hayimpliqdet.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00O12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV9ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A88ImpLiqSec = P00O12_A88ImpLiqSec[0] ;
         A1EmpCod = P00O12_A1EmpCod[0] ;
         A3CliCod = P00O12_A3CliCod[0] ;
         A90ImpLiqDetSec = P00O12_A90ImpLiqDetSec[0] ;
         AV10hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = hayimpliqdet.this.AV10hay;
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
      P00O12_A88ImpLiqSec = new short[1] ;
      P00O12_A1EmpCod = new short[1] ;
      P00O12_A3CliCod = new int[1] ;
      P00O12_A90ImpLiqDetSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayimpliqdet__default(),
         new Object[] {
             new Object[] {
            P00O12_A88ImpLiqSec, P00O12_A1EmpCod, P00O12_A3CliCod, P00O12_A90ImpLiqDetSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV9ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV10hay ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P00O12_A88ImpLiqSec ;
   private short[] P00O12_A1EmpCod ;
   private int[] P00O12_A3CliCod ;
   private short[] P00O12_A90ImpLiqDetSec ;
}

final  class hayimpliqdet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O12", "SELECT ImpLiqSec, EmpCod, CliCod, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

