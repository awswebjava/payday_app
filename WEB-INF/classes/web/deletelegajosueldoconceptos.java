package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletelegajosueldoconceptos extends GXProcedure
{
   public deletelegajosueldoconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletelegajosueldoconceptos.class ), "" );
   }

   public deletelegajosueldoconceptos( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      deletelegajosueldoconceptos.this.AV11CliCod = aP0;
      deletelegajosueldoconceptos.this.AV10EmpCod = aP1;
      deletelegajosueldoconceptos.this.AV9LegNumero = aP2;
      deletelegajosueldoconceptos.this.AV8LegSuelSec = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      /* Using cursor P02D62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero), Short.valueOf(AV8LegSuelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo_sueldosConceptos");
      /* End optimized DELETE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "deletelegajosueldoconceptos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletelegajosueldoconceptos__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8LegSuelSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private IDataStoreProvider pr_default ;
}

final  class deletelegajosueldoconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02D62", "DELETE FROM Legajo_sueldosConceptos  WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

