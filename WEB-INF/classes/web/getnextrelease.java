package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextrelease extends GXProcedure
{
   public getnextrelease( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextrelease.class ), "" );
   }

   public getnextrelease( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 )
   {
      getnextrelease.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int[] aP1 )
   {
      getnextrelease.this.AV8CliCod = aP0;
      getnextrelease.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01R92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01R92_A3CliCod[0] ;
         A1885CliRelSec = P01R92_A1885CliRelSec[0] ;
         AV9CliRelSec = A1885CliRelSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV9CliRelSec = (int)(AV9CliRelSec+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnextrelease.this.AV9CliRelSec;
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
      P01R92_A3CliCod = new int[1] ;
      P01R92_A1885CliRelSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextrelease__default(),
         new Object[] {
             new Object[] {
            P01R92_A3CliCod, P01R92_A1885CliRelSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private String scmdbuf ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P01R92_A3CliCod ;
   private int[] P01R92_A1885CliRelSec ;
}

final  class getnextrelease__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R92", "SELECT CliCod, CliRelSec FROM Cliente_Release WHERE CliCod = ? ORDER BY CliCod, CliRelSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

}

