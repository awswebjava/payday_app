package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearlegajopruebaegreso extends GXProcedure
{
   public setearlegajopruebaegreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearlegajopruebaegreso.class ), "" );
   }

   public setearlegajopruebaegreso( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        java.util.Date aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             java.util.Date aP5 )
   {
      setearlegajopruebaegreso.this.AV10CliCod = aP0;
      setearlegajopruebaegreso.this.AV8EmpCod = aP1;
      setearlegajopruebaegreso.this.AV9LegNumero = aP2;
      setearlegajopruebaegreso.this.AV11LegFecEgreso = aP3;
      setearlegajopruebaegreso.this.AV13LegMegCodigo = aP4;
      setearlegajopruebaegreso.this.AV12LegFecPreAviso = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n1583LegMegCodigo = false ;
      n244LegFecEgreso = false ;
      /* Optimized UPDATE. */
      /* Using cursor P01LF2 */
      pr_default.execute(0, new Object[] {AV12LegFecPreAviso, Boolean.valueOf(n1583LegMegCodigo), AV13LegMegCodigo, Boolean.valueOf(n244LegFecEgreso), AV11LegFecEgreso, Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setearlegajopruebaegreso");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1531LegFecPreAviso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setearlegajopruebaegreso__default(),
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
   private int AV10CliCod ;
   private int AV9LegNumero ;
   private String AV13LegMegCodigo ;
   private String A1583LegMegCodigo ;
   private java.util.Date AV11LegFecEgreso ;
   private java.util.Date AV12LegFecPreAviso ;
   private java.util.Date A1531LegFecPreAviso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n1583LegMegCodigo ;
   private boolean n244LegFecEgreso ;
   private IDataStoreProvider pr_default ;
}

final  class setearlegajopruebaegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01LF2", "UPDATE Legajo SET LegContinua='SI', LegFecPreAviso=?, LegMegCodigo=?, LegFecEgreso=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DATE );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[4]);
               }
               stmt.setInt(4, ((Number) parms[5]).intValue());
               stmt.setShort(5, ((Number) parms[6]).shortValue());
               stmt.setInt(6, ((Number) parms[7]).intValue());
               return;
      }
   }

}

