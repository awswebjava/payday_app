package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getreleasedatetime extends GXProcedure
{
   public getreleasedatetime( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getreleasedatetime.class ), "" );
   }

   public getreleasedatetime( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     int aP1 )
   {
      getreleasedatetime.this.aP2 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        java.util.Date[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             java.util.Date[] aP2 )
   {
      getreleasedatetime.this.AV10CliCod = aP0;
      getreleasedatetime.this.AV9CliRelSec = aP1;
      getreleasedatetime.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01SG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1885CliRelSec = P01SG2_A1885CliRelSec[0] ;
         A3CliCod = P01SG2_A3CliCod[0] ;
         A1876CliRelease = P01SG2_A1876CliRelease[0] ;
         AV8CliRelease = A1876CliRelease ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getreleasedatetime.this.AV8CliRelease;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CliRelease = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P01SG2_A1885CliRelSec = new int[1] ;
      P01SG2_A3CliCod = new int[1] ;
      P01SG2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getreleasedatetime__default(),
         new Object[] {
             new Object[] {
            P01SG2_A1885CliRelSec, P01SG2_A3CliCod, P01SG2_A1876CliRelease
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
   private java.util.Date AV8CliRelease ;
   private java.util.Date A1876CliRelease ;
   private java.util.Date[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01SG2_A1885CliRelSec ;
   private int[] P01SG2_A3CliCod ;
   private java.util.Date[] P01SG2_A1876CliRelease ;
}

final  class getreleasedatetime__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SG2", "SELECT CliRelSec, CliCod, CliRelease FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
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

