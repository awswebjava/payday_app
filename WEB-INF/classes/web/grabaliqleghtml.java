package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaliqleghtml extends GXProcedure
{
   public grabaliqleghtml( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaliqleghtml.class ), "" );
   }

   public grabaliqleghtml( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      grabaliqleghtml.this.AV12CliCod = aP0;
      grabaliqleghtml.this.AV11EmpCod = aP1;
      grabaliqleghtml.this.AV10liqnro = aP2;
      grabaliqleghtml.this.AV9LegNumero = aP3;
      grabaliqleghtml.this.AV8LiqLegHtml = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P02JJ2 */
      pr_default.execute(0, new Object[] {AV8LiqLegHtml, Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10liqnro), Integer.valueOf(AV9LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaliqleghtml");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2393LiqLegHtml = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaliqleghtml__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10liqnro ;
   private int AV9LegNumero ;
   private String AV8LiqLegHtml ;
   private String A2393LiqLegHtml ;
   private IDataStoreProvider pr_default ;
}

final  class grabaliqleghtml__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02JJ2", "UPDATE LiquidacionLegajo SET LiqLegHtml=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

