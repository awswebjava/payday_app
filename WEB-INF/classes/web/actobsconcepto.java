package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actobsconcepto extends GXProcedure
{
   public actobsconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actobsconcepto.class ), "" );
   }

   public actobsconcepto( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      actobsconcepto.this.AV10CliCod = aP0;
      actobsconcepto.this.AV8ConCodigo = aP1;
      actobsconcepto.this.AV11ConObservacion = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00RG2 */
      pr_default.execute(0, new Object[] {AV11ConObservacion, Integer.valueOf(AV10CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actobsconcepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A153ConObservacion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actobsconcepto__default(),
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
   private String AV11ConObservacion ;
   private String A153ConObservacion ;
   private IDataStoreProvider pr_default ;
}

final  class actobsconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00RG2", "UPDATE Concepto SET ConObservacion=?  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

