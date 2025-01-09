package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actrecalcconcepto extends GXProcedure
{
   public actrecalcconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actrecalcconcepto.class ), "" );
   }

   public actrecalcconcepto( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 )
   {
      actrecalcconcepto.this.AV10CliCod = aP0;
      actrecalcconcepto.this.AV8ConCodigo = aP1;
      actrecalcconcepto.this.AV14ConRecalcular = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00T72 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV14ConRecalcular), Integer.valueOf(AV10CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actrecalcconcepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actrecalcconcepto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8ConCodigo ;
   private boolean AV14ConRecalcular ;
   private boolean A762ConRecalcular ;
   private IDataStoreProvider pr_default ;
}

final  class actrecalcconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00T72", "UPDATE Concepto SET ConRecalcular=?  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

