package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletemotivosconcepto extends GXProcedure
{
   public deletemotivosconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletemotivosconcepto.class ), "" );
   }

   public deletemotivosconcepto( int remoteHandle ,
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
      deletemotivosconcepto.this.AV9CliCod = aP0;
      deletemotivosconcepto.this.AV8ConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P01SH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletemotivosconcepto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8ConCodigo ;
   private IDataStoreProvider pr_default ;
}

final  class deletemotivosconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01SH2", "DELETE FROM ConceptoMotivosEgreso  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

