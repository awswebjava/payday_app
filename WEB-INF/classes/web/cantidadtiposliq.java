package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantidadtiposliq extends GXProcedure
{
   public cantidadtiposliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantidadtiposliq.class ), "" );
   }

   public cantidadtiposliq( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      cantidadtiposliq.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      cantidadtiposliq.this.AV8CliCod = aP0;
      cantidadtiposliq.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P01OS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      cV9cant = P01OS2_AV9cant[0] ;
      pr_default.close(0);
      AV9cant = (short)(AV9cant+cV9cant*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = cantidadtiposliq.this.AV9cant;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01OS2_AV9cant = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cantidadtiposliq__default(),
         new Object[] {
             new Object[] {
            P01OS2_AV9cant
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9cant ;
   private short cV9cant ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String scmdbuf ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01OS2_AV9cant ;
}

final  class cantidadtiposliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OS2", "SELECT COUNT(*) FROM TipoLiquidacion WHERE (CliCod = ?) AND (TLiqHabilitada = TRUE) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
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
      }
   }

}

