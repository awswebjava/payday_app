package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class upddaemoncount extends GXProcedure
{
   public upddaemoncount( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( upddaemoncount.class ), "" );
   }

   public upddaemoncount( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      upddaemoncount.this.AV8CliCod = aP0;
      upddaemoncount.this.AV10daemonUUID = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P02KV2 */
      pr_default.execute(0, new Object[] {AV10daemonUUID});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("daemon");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "upddaemoncount");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.upddaemoncount__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV10daemonUUID ;
   private IDataStoreProvider pr_default ;
}

final  class upddaemoncount__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02KV2", "UPDATE daemon SET daemonCount=daemonCount + 1  WHERE daemonUUID = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 36);
               return;
      }
   }

}

