package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasocialafip extends GXProcedure
{
   public getobrasocialafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasocialafip.class ), "" );
   }

   public getobrasocialafip( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getobrasocialafip.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getobrasocialafip.this.AV9CliCod = aP0;
      getobrasocialafip.this.AV10OsoCod = aP1;
      getobrasocialafip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02742 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10OsoCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A5OsoCod = P02742_A5OsoCod[0] ;
         A3CliCod = P02742_A3CliCod[0] ;
         A306OsoC3992 = P02742_A306OsoC3992[0] ;
         n306OsoC3992 = P02742_n306OsoC3992[0] ;
         AV8OsoC3992 = A306OsoC3992 ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getobrasocialafip.this.AV8OsoC3992;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OsoC3992 = "" ;
      scmdbuf = "" ;
      P02742_A5OsoCod = new String[] {""} ;
      P02742_A3CliCod = new int[1] ;
      P02742_A306OsoC3992 = new String[] {""} ;
      P02742_n306OsoC3992 = new boolean[] {false} ;
      A5OsoCod = "" ;
      A306OsoC3992 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasocialafip__default(),
         new Object[] {
             new Object[] {
            P02742_A5OsoCod, P02742_A3CliCod, P02742_A306OsoC3992, P02742_n306OsoC3992
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10OsoCod ;
   private String AV8OsoC3992 ;
   private String scmdbuf ;
   private String A5OsoCod ;
   private String A306OsoC3992 ;
   private boolean n306OsoC3992 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02742_A5OsoCod ;
   private int[] P02742_A3CliCod ;
   private String[] P02742_A306OsoC3992 ;
   private boolean[] P02742_n306OsoC3992 ;
}

final  class getobrasocialafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02742", "SELECT OsoCod, CliCod, OsoC3992 FROM ObraSocial WHERE CliCod = ? and OsoCod = ( ?) ORDER BY CliCod, OsoCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

