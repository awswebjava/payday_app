package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class errorfecharelease extends GXProcedure
{
   public errorfecharelease( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( errorfecharelease.class ), "" );
   }

   public errorfecharelease( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     java.util.Date aP1 ,
                                     boolean[] aP2 )
   {
      errorfecharelease.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        boolean[] aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             boolean[] aP2 ,
                             java.util.Date[] aP3 )
   {
      errorfecharelease.this.AV11CliCod = aP0;
      errorfecharelease.this.AV8CliRelease = aP1;
      errorfecharelease.this.aP2 = aP2;
      errorfecharelease.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV8CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P01VI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8CliRelease});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1876CliRelease = P01VI2_A1876CliRelease[0] ;
         A3CliCod = P01VI2_A3CliCod[0] ;
         A1885CliRelSec = P01VI2_A1885CliRelSec[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV9errorHay = true ;
         AV10outCliRelease = A1876CliRelease ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "encuentra ", "")+GXutil.trim( localUtil.ttoc( AV10outCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = errorfecharelease.this.AV9errorHay;
      this.aP3[0] = errorfecharelease.this.AV10outCliRelease;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10outCliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P01VI2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P01VI2_A3CliCod = new int[1] ;
      P01VI2_A1885CliRelSec = new int[1] ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.errorfecharelease__default(),
         new Object[] {
             new Object[] {
            P01VI2_A1876CliRelease, P01VI2_A3CliCod, P01VI2_A1885CliRelSec
            }
         }
      );
      AV14Pgmname = "ErrorFechaRelease" ;
      /* GeneXus formulas. */
      AV14Pgmname = "ErrorFechaRelease" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private java.util.Date AV8CliRelease ;
   private java.util.Date AV10outCliRelease ;
   private java.util.Date A1876CliRelease ;
   private boolean AV9errorHay ;
   private java.util.Date[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01VI2_A1876CliRelease ;
   private int[] P01VI2_A3CliCod ;
   private int[] P01VI2_A1885CliRelSec ;
}

final  class errorfecharelease__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VI2", "SELECT CliRelease, CliCod, CliRelSec FROM Cliente_Release WHERE (CliCod = ?) AND (CliRelease >= ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               return;
      }
   }

}

