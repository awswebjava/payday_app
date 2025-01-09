package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionvariable extends GXProcedure
{
   public hayliberacionvariable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionvariable.class ), "" );
   }

   public hayliberacionvariable( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionvariable.this.aP2 = new boolean[] {false};
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
      hayliberacionvariable.this.AV8CliCod = aP0;
      hayliberacionvariable.this.AV9CliRelSec = aP1;
      hayliberacionvariable.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1895VarRelSec = P01VY2_A1895VarRelSec[0] ;
         A3CliCod = P01VY2_A3CliCod[0] ;
         A82OpeCliId = P01VY2_A82OpeCliId[0] ;
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
      this.aP2[0] = hayliberacionvariable.this.AV10hay;
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
      P01VY2_A1895VarRelSec = new int[1] ;
      P01VY2_A3CliCod = new int[1] ;
      P01VY2_A82OpeCliId = new String[] {""} ;
      A82OpeCliId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionvariable__default(),
         new Object[] {
             new Object[] {
            P01VY2_A1895VarRelSec, P01VY2_A3CliCod, P01VY2_A82OpeCliId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1895VarRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VY2_A1895VarRelSec ;
   private int[] P01VY2_A3CliCod ;
   private String[] P01VY2_A82OpeCliId ;
}

final  class hayliberacionvariable__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VY2", "SELECT VarRelSec, CliCod, OpeCliId FROM Variable WHERE (CliCod = ?) AND (VarRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
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

