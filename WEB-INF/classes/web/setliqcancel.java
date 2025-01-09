package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqcancel extends GXProcedure
{
   public setliqcancel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqcancel.class ), "" );
   }

   public setliqcancel( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 )
   {
      setliqcancel.this.AV11CliCod = aP0;
      setliqcancel.this.AV8EmpCod = aP1;
      setliqcancel.this.AV10LiqNro = aP2;
      setliqcancel.this.AV9LiqCancel = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P02BJ2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV9LiqCancel), Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqcancel");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqcancel__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV10LiqNro ;
   private boolean AV9LiqCancel ;
   private boolean A2298LiqCancel ;
   private IDataStoreProvider pr_default ;
}

final  class setliqcancel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02BJ2", "UPDATE Liquidacion SET LiqCancel=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

