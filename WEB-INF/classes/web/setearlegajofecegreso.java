package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearlegajofecegreso extends GXProcedure
{
   public setearlegajofecegreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearlegajofecegreso.class ), "" );
   }

   public setearlegajofecegreso( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 )
   {
      setearlegajofecegreso.this.AV8CliCod = aP0;
      setearlegajofecegreso.this.AV9EmpCod = aP1;
      setearlegajofecegreso.this.AV11LegNumero = aP2;
      setearlegajofecegreso.this.AV10LegFecEgreso = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n244LegFecEgreso = false ;
      /* Optimized UPDATE. */
      /* Using cursor P02CW2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n244LegFecEgreso), AV10LegFecEgreso, Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setearlegajofecegreso");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A244LegFecEgreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setearlegajofecegreso__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private java.util.Date AV10LegFecEgreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n244LegFecEgreso ;
   private IDataStoreProvider pr_default ;
}

final  class setearlegajofecegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02CW2", "UPDATE Legajo SET LegFecEgreso=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.DATE );
               }
               else
               {
                  stmt.setDate(1, (java.util.Date)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
      }
   }

}

