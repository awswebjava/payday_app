package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionvariablevalor extends GXProcedure
{
   public hayliberacionvariablevalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionvariablevalor.class ), "" );
   }

   public hayliberacionvariablevalor( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionvariablevalor.this.aP2 = new boolean[] {false};
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
      hayliberacionvariablevalor.this.AV8CliCod = aP0;
      hayliberacionvariablevalor.this.AV9CliRelSec = aP1;
      hayliberacionvariablevalor.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1890OpeCliRelSec = P01VX2_A1890OpeCliRelSec[0] ;
         A3CliCod = P01VX2_A3CliCod[0] ;
         A82OpeCliId = P01VX2_A82OpeCliId[0] ;
         A754OpeCliVig = P01VX2_A754OpeCliVig[0] ;
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
      this.aP2[0] = hayliberacionvariablevalor.this.AV10hay;
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
      P01VX2_A1890OpeCliRelSec = new int[1] ;
      P01VX2_A3CliCod = new int[1] ;
      P01VX2_A82OpeCliId = new String[] {""} ;
      P01VX2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      A82OpeCliId = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionvariablevalor__default(),
         new Object[] {
             new Object[] {
            P01VX2_A1890OpeCliRelSec, P01VX2_A3CliCod, P01VX2_A82OpeCliId, P01VX2_A754OpeCliVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1890OpeCliRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date A754OpeCliVig ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VX2_A1890OpeCliRelSec ;
   private int[] P01VX2_A3CliCod ;
   private String[] P01VX2_A82OpeCliId ;
   private java.util.Date[] P01VX2_A754OpeCliVig ;
}

final  class hayliberacionvariablevalor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VX2", "SELECT OpeCliRelSec, CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE (CliCod = ?) AND (OpeCliRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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

