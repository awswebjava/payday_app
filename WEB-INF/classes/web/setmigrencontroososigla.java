package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setmigrencontroososigla extends GXProcedure
{
   public setmigrencontroososigla( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setmigrencontroososigla.class ), "" );
   }

   public setmigrencontroososigla( int remoteHandle ,
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
      setmigrencontroososigla.this.AV11CliCod = aP0;
      setmigrencontroososigla.this.AV10EmpCod = aP1;
      setmigrencontroososigla.this.AV8MigrLegNumero = aP2;
      setmigrencontroososigla.this.AV9MigrEncontroOsoSigla = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00M22 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV9MigrEncontroOsoSigla), Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8MigrLegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
      /* End optimized UPDATE. */
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setmigrencontroososigla__default(),
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
   private int AV11CliCod ;
   private int AV8MigrLegNumero ;
   private boolean AV9MigrEncontroOsoSigla ;
   private boolean A635MigrEncontroOsoSigla ;
   private IDataStoreProvider pr_default ;
}

final  class setmigrencontroososigla__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00M22", "UPDATE importacion_legajo SET MigrEncontroOsoSigla=?  WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

