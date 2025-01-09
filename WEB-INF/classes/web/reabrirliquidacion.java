package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reabrirliquidacion extends GXProcedure
{
   public reabrirliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reabrirliquidacion.class ), "" );
   }

   public reabrirliquidacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             int aP1 )
   {
      reabrirliquidacion.this.AV8EmpCod = aP0;
      reabrirliquidacion.this.AV9LiqNro = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      reabrirliquidacion.this.GXt_int1 = GXv_int2[0] ;
      AV10CliCod = GXt_int1 ;
      /* Optimized UPDATE. */
      /* Using cursor P009H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "reabrirliquidacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.reabrirliquidacion__default(),
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
   private int AV9LiqNro ;
   private int AV10CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private IDataStoreProvider pr_default ;
}

final  class reabrirliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P009H2", "UPDATE Liquidacion SET LiqEstado=3  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

