package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getreleasedtyhabilitado extends GXProcedure
{
   public getreleasedtyhabilitado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getreleasedtyhabilitado.class ), "" );
   }

   public getreleasedtyhabilitado( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 ,
                              java.util.Date[] aP2 )
   {
      getreleasedtyhabilitado.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        java.util.Date[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             java.util.Date[] aP2 ,
                             boolean[] aP3 )
   {
      getreleasedtyhabilitado.this.AV10CliCod = aP0;
      getreleasedtyhabilitado.this.AV9CliRelSec = aP1;
      getreleasedtyhabilitado.this.aP2 = aP2;
      getreleasedtyhabilitado.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1885CliRelSec = P01X22_A1885CliRelSec[0] ;
         A3CliCod = P01X22_A3CliCod[0] ;
         A1876CliRelease = P01X22_A1876CliRelease[0] ;
         A1877CliReHabilitado = P01X22_A1877CliReHabilitado[0] ;
         AV8CliRelease = A1876CliRelease ;
         AV11CliReHabilitado = A1877CliReHabilitado ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getreleasedtyhabilitado.this.AV8CliRelease;
      this.aP3[0] = getreleasedtyhabilitado.this.AV11CliReHabilitado;
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
      P01X22_A1885CliRelSec = new int[1] ;
      P01X22_A3CliCod = new int[1] ;
      P01X22_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P01X22_A1877CliReHabilitado = new boolean[] {false} ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getreleasedtyhabilitado__default(),
         new Object[] {
             new Object[] {
            P01X22_A1885CliRelSec, P01X22_A3CliCod, P01X22_A1876CliRelease, P01X22_A1877CliReHabilitado
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
   private boolean AV11CliReHabilitado ;
   private boolean A1877CliReHabilitado ;
   private boolean[] aP3 ;
   private java.util.Date[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01X22_A1885CliRelSec ;
   private int[] P01X22_A3CliCod ;
   private java.util.Date[] P01X22_A1876CliRelease ;
   private boolean[] P01X22_A1877CliReHabilitado ;
}

final  class getreleasedtyhabilitado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X22", "SELECT CliRelSec, CliCod, CliRelease, CliReHabilitado FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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

