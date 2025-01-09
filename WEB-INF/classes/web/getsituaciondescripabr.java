package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituaciondescripabr extends GXProcedure
{
   public getsituaciondescripabr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituaciondescripabr.class ), "" );
   }

   public getsituaciondescripabr( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getsituaciondescripabr.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getsituaciondescripabr.this.AV8SitCodigo = aP0;
      getsituaciondescripabr.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00YV2 */
      pr_default.execute(0, new Object[] {AV8SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P00YV2_A16SitCodigo[0] ;
         A913sItDescAbrev = P00YV2_A913sItDescAbrev[0] ;
         AV12sItDescAbrev = A913sItDescAbrev ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsituaciondescripabr.this.AV12sItDescAbrev;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12sItDescAbrev = "" ;
      scmdbuf = "" ;
      P00YV2_A16SitCodigo = new String[] {""} ;
      P00YV2_A913sItDescAbrev = new String[] {""} ;
      A16SitCodigo = "" ;
      A913sItDescAbrev = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituaciondescripabr__default(),
         new Object[] {
             new Object[] {
            P00YV2_A16SitCodigo, P00YV2_A913sItDescAbrev
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SitCodigo ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private String AV12sItDescAbrev ;
   private String A913sItDescAbrev ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00YV2_A16SitCodigo ;
   private String[] P00YV2_A913sItDescAbrev ;
}

final  class getsituaciondescripabr__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YV2", "SELECT SitCodigo, sItDescAbrev FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

