package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarferiadosagenda extends GXProcedure
{
   public eliminarferiadosagenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarferiadosagenda.class ), "" );
   }

   public eliminarferiadosagenda( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             short aP1 )
   {
      eliminarferiadosagenda.this.AV8PaiCod = aP0;
      eliminarferiadosagenda.this.AV9FerAnio = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P01YM2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), Short.valueOf(AV9FerAnio)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarferiadosagenda");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarferiadosagenda__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short AV9FerAnio ;
   private short Gx_err ;
   private IDataStoreProvider pr_default ;
}

final  class eliminarferiadosagenda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01YM2", "DELETE FROM feriado_agenda  WHERE (PaiCod = ?) AND (FerAnio = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

