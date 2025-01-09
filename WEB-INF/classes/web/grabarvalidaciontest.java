package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabarvalidaciontest extends GXProcedure
{
   public grabarvalidaciontest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabarvalidaciontest.class ), "" );
   }

   public grabarvalidaciontest( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        boolean aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             boolean aP1 ,
                             String aP2 )
   {
      grabarvalidaciontest.this.AV8TestNro = aP0;
      grabarvalidaciontest.this.AV10TestOK = aP1;
      grabarvalidaciontest.this.AV9TestError = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P016M2 */
      pr_default.execute(0, new Object[] {AV9TestError, Boolean.valueOf(AV10TestOK), Short.valueOf(AV8TestNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabarvalidaciontest");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1091TestError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabarvalidaciontest__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8TestNro ;
   private short Gx_err ;
   private boolean AV10TestOK ;
   private boolean A1084TestOK ;
   private String AV9TestError ;
   private String A1091TestError ;
   private IDataStoreProvider pr_default ;
}

final  class grabarvalidaciontest__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P016M2", "UPDATE Test SET TestError=?, TestFechaHora=timezone('UTC', NOW()), TestOK=?  WHERE TestNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

