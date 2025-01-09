package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclireobs extends GXProcedure
{
   public getclireobs( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclireobs.class ), "" );
   }

   public getclireobs( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int aP1 )
   {
      getclireobs.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String[] aP2 )
   {
      getclireobs.this.AV10CliCod = aP0;
      getclireobs.this.AV9CliRelSec = aP1;
      getclireobs.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01T52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1885CliRelSec = P01T52_A1885CliRelSec[0] ;
         A3CliCod = P01T52_A3CliCod[0] ;
         A1878CliReObs = P01T52_A1878CliReObs[0] ;
         AV8CliReObs = A1878CliReObs ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getclireobs.this.AV8CliReObs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CliReObs = "" ;
      scmdbuf = "" ;
      P01T52_A1885CliRelSec = new int[1] ;
      P01T52_A3CliCod = new int[1] ;
      P01T52_A1878CliReObs = new String[] {""} ;
      A1878CliReObs = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getclireobs__default(),
         new Object[] {
             new Object[] {
            P01T52_A1885CliRelSec, P01T52_A3CliCod, P01T52_A1878CliReObs
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9CliRelSec ;
   private int A1885CliRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV8CliReObs ;
   private String A1878CliReObs ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01T52_A1885CliRelSec ;
   private int[] P01T52_A3CliCod ;
   private String[] P01T52_A1878CliReObs ;
}

final  class getclireobs__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01T52", "SELECT CliRelSec, CliCod, CliReObs FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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

