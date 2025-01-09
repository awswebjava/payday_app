package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cliente_releaseupdateredundancy extends GXProcedure
{
   public cliente_releaseupdateredundancy( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_releaseupdateredundancy.class ), "" );
   }

   public cliente_releaseupdateredundancy( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int[] aP0 )
   {
      cliente_releaseupdateredundancy.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int[] aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int[] aP0 ,
                             int[] aP1 )
   {
      cliente_releaseupdateredundancy.this.A3CliCod = aP0[0];
      this.aP0 = aP0;
      cliente_releaseupdateredundancy.this.A1885CliRelSec = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor CLIENTE_RE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1973CliRelNombre = CLIENTE_RE2_A1973CliRelNombre[0] ;
         A1876CliRelease = CLIENTE_RE2_A1876CliRelease[0] ;
         AV2GXV1876 = A1876CliRelease ;
         AV3GXV1962 = AV2GXV1876 ;
         /* Optimized UPDATE. */
         /* Using cursor CLIENTE_RE3 */
         pr_default.execute(1, new Object[] {AV3GXV1962, Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
         /* End optimized UPDATE. */
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = cliente_releaseupdateredundancy.this.A3CliCod;
      this.aP1[0] = cliente_releaseupdateredundancy.this.A1885CliRelSec;
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
      CLIENTE_RE2_A3CliCod = new int[1] ;
      CLIENTE_RE2_A1885CliRelSec = new int[1] ;
      CLIENTE_RE2_A1973CliRelNombre = new String[] {""} ;
      CLIENTE_RE2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      A1973CliRelNombre = "" ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV2GXV1876 = GXutil.resetTime( GXutil.nullDate() );
      AV3GXV1962 = GXutil.resetTime( GXutil.nullDate() );
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_releaseupdateredundancy__default(),
         new Object[] {
             new Object[] {
            CLIENTE_RE2_A3CliCod, CLIENTE_RE2_A1885CliRelSec, CLIENTE_RE2_A1973CliRelNombre, CLIENTE_RE2_A1876CliRelease
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private String scmdbuf ;
   private java.util.Date A1876CliRelease ;
   private java.util.Date AV2GXV1876 ;
   private java.util.Date AV3GXV1962 ;
   private java.util.Date A1962CliUpdFecRel ;
   private String A1973CliRelNombre ;
   private int[] aP1 ;
   private int[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] CLIENTE_RE2_A3CliCod ;
   private int[] CLIENTE_RE2_A1885CliRelSec ;
   private String[] CLIENTE_RE2_A1973CliRelNombre ;
   private java.util.Date[] CLIENTE_RE2_A1876CliRelease ;
}

final  class cliente_releaseupdateredundancy__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("CLIENTE_RE2", "SELECT CliCod, CliRelSec, CliRelNombre, CliRelease FROM Cliente_Release WHERE CliCod = ? and CliRelSec = ? ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("CLIENTE_RE3", "UPDATE Cliente_Update SET CliUpdFecRel=?  WHERE CliUpdCliCod = ? and CliUpdRelSec = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4);
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
            case 1 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

