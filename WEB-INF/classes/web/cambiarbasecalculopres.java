package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cambiarbasecalculopres extends GXProcedure
{
   public cambiarbasecalculopres( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cambiarbasecalculopres.class ), "" );
   }

   public cambiarbasecalculopres( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte aP2 )
   {
      cambiarbasecalculopres.this.AV9CliCod = aP0;
      cambiarbasecalculopres.this.AV8ConCodigo = aP1;
      cambiarbasecalculopres.this.AV10ConBasePres = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P01NQ2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV10ConBasePres), Integer.valueOf(AV9CliCod), AV8ConCodigo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "cambiarbasecalculopres");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cambiarbasecalculopres__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10ConBasePres ;
   private byte A1800ConBasePres ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8ConCodigo ;
   private IDataStoreProvider pr_default ;
}

final  class cambiarbasecalculopres__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01NQ2", "UPDATE Concepto SET ConBasePres=?  WHERE CliCod = ? and ConCodigo = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

