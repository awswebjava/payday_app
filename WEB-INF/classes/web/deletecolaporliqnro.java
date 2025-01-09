package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletecolaporliqnro extends GXProcedure
{
   public deletecolaporliqnro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletecolaporliqnro.class ), "" );
   }

   public deletecolaporliqnro( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      deletecolaporliqnro.this.AV8CliCod = aP0;
      deletecolaporliqnro.this.AV10EmpCod = aP1;
      deletecolaporliqnro.this.AV9ColaLiqNro = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P02JC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9ColaLiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cola");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "deletecolaporliqnro");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletecolaporliqnro__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9ColaLiqNro ;
   private IDataStoreProvider pr_default ;
}

final  class deletecolaporliqnro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02JC2", "DELETE FROM Cola  WHERE (CliCod = ? and EmpCod = ? and ColaLiqNro = ?) AND (ColaEstado = 0)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

