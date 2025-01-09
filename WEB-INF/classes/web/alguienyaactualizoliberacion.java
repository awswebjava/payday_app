package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class alguienyaactualizoliberacion extends GXProcedure
{
   public alguienyaactualizoliberacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( alguienyaactualizoliberacion.class ), "" );
   }

   public alguienyaactualizoliberacion( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      alguienyaactualizoliberacion.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             boolean[] aP2 )
   {
      alguienyaactualizoliberacion.this.AV8CliUpdCliCod = aP0;
      alguienyaactualizoliberacion.this.AV10CliUpdRelSec = aP1;
      alguienyaactualizoliberacion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01WN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliUpdCliCod), Integer.valueOf(AV10CliUpdRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1883CliUpdDTApl = P01WN2_A1883CliUpdDTApl[0] ;
         A1887CliUpdRelSec = P01WN2_A1887CliUpdRelSec[0] ;
         A1881CliUpdCliCod = P01WN2_A1881CliUpdCliCod[0] ;
         A3CliCod = P01WN2_A3CliCod[0] ;
         AV9alguienYaActualizo = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = alguienyaactualizoliberacion.this.AV9alguienYaActualizo;
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
      P01WN2_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      P01WN2_A1887CliUpdRelSec = new int[1] ;
      P01WN2_A1881CliUpdCliCod = new int[1] ;
      P01WN2_A3CliCod = new int[1] ;
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.alguienyaactualizoliberacion__default(),
         new Object[] {
             new Object[] {
            P01WN2_A1883CliUpdDTApl, P01WN2_A1887CliUpdRelSec, P01WN2_A1881CliUpdCliCod, P01WN2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliUpdCliCod ;
   private int AV10CliUpdRelSec ;
   private int A1887CliUpdRelSec ;
   private int A1881CliUpdCliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date A1883CliUpdDTApl ;
   private boolean AV9alguienYaActualizo ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01WN2_A1883CliUpdDTApl ;
   private int[] P01WN2_A1887CliUpdRelSec ;
   private int[] P01WN2_A1881CliUpdCliCod ;
   private int[] P01WN2_A3CliCod ;
}

final  class alguienyaactualizoliberacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WN2", "SELECT CliUpdDTApl, CliUpdRelSec, CliUpdCliCod, CliCod FROM Cliente_Update WHERE (CliUpdCliCod = ? and CliUpdRelSec = ?) AND (Not (CliUpdDTApl = DATE '00010101')) ORDER BY CliUpdCliCod, CliUpdRelSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

