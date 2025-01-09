package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalityhaschildren extends GXProcedure
{
   public secfunctionalityhaschildren( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityhaschildren.class ), "" );
   }

   public secfunctionalityhaschildren( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( long aP0 )
   {
      secfunctionalityhaschildren.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( long aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             boolean[] aP1 )
   {
      secfunctionalityhaschildren.this.AV9SecFunctionalityId = aP0;
      secfunctionalityhaschildren.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8HasChildren = false ;
      /* Using cursor P00BQ2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV9SecFunctionalityId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A63SecParentFunctionalityId = P00BQ2_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BQ2_n63SecParentFunctionalityId[0] ;
         A62SecFunctionalityId = P00BQ2_A62SecFunctionalityId[0] ;
         AV8HasChildren = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secfunctionalityhaschildren.this.AV8HasChildren;
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
      P00BQ2_A63SecParentFunctionalityId = new long[1] ;
      P00BQ2_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BQ2_A62SecFunctionalityId = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalityhaschildren__default(),
         new Object[] {
             new Object[] {
            P00BQ2_A63SecParentFunctionalityId, P00BQ2_n63SecParentFunctionalityId, P00BQ2_A62SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV9SecFunctionalityId ;
   private long A63SecParentFunctionalityId ;
   private long A62SecFunctionalityId ;
   private String scmdbuf ;
   private boolean AV8HasChildren ;
   private boolean n63SecParentFunctionalityId ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P00BQ2_A63SecParentFunctionalityId ;
   private boolean[] P00BQ2_n63SecParentFunctionalityId ;
   private long[] P00BQ2_A62SecFunctionalityId ;
}

final  class secfunctionalityhaschildren__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BQ2", "SELECT SecParentFunctionalityId, SecFunctionalityId FROM SecFunctionality WHERE SecParentFunctionalityId = ? ORDER BY SecParentFunctionalityId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

