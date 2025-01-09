package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizartipoliqshabilitada extends GXProcedure
{
   public actualizartipoliqshabilitada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizartipoliqshabilitada.class ), "" );
   }

   public actualizartipoliqshabilitada( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> aP1 )
   {
      actualizartipoliqshabilitada.this.AV8CliCod = aP0;
      actualizartipoliqshabilitada.this.AV9sdt_tipo_liqs = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P01OQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
      /* End optimized UPDATE. */
      AV14GXV1 = 1 ;
      while ( AV14GXV1 <= AV9sdt_tipo_liqs.size() )
      {
         AV10item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)((web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)AV9sdt_tipo_liqs.elementAt(-1+AV14GXV1));
         /* Optimized UPDATE. */
         /* Using cursor P01OQ3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), AV10item.getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod()});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
         /* End optimized UPDATE. */
         AV14GXV1 = (int)(AV14GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizartipoliqshabilitada");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10item = new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizartipoliqshabilitada__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14GXV1 ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV9sdt_tipo_liqs ;
   private web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem AV10item ;
}

final  class actualizartipoliqshabilitada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01OQ2", "UPDATE TipoLiquidacion SET TLiqHabilitada=FALSE  WHERE CliCod = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01OQ3", "UPDATE TipoLiquidacion SET TLiqHabilitada=TRUE  WHERE CliCod = ? and TLiqCod = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

