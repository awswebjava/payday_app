package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqestadoaux extends GXProcedure
{
   public setliqestadoaux( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqestadoaux.class ), "" );
   }

   public setliqestadoaux( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 )
   {
      setliqestadoaux.this.AV10CliCod = aP0;
      setliqestadoaux.this.AV11EmpCod = aP1;
      setliqestadoaux.this.AV8LiqNro = aP2;
      setliqestadoaux.this.AV12LiqAuxEstado = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "CliCod: ", "")+GXutil.str( AV10CliCod, 6, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "EmpCod: ", "")+GXutil.str( AV11EmpCod, 4, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "LiqNro: ", "")+GXutil.str( AV8LiqNro, 8, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "LiqAuxEstado: ", "")+GXutil.str( AV12LiqAuxEstado, 1, 0)) ;
      AV16GXLvl8 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P01MC2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV12LiqAuxEstado), Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV8LiqNro)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV16GXLvl8 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      if ( AV16GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqestadoaux");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqestadoaux__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV15Pgmname = "setLiqEstadoAux" ;
      /* GeneXus formulas. */
      AV15Pgmname = "setLiqEstadoAux" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqAuxEstado ;
   private byte AV16GXLvl8 ;
   private byte A1403LiqAuxEstado ;
   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LiqNro ;
   private String AV15Pgmname ;
   private IDataStoreProvider pr_default ;
}

final  class setliqestadoaux__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01MC2", "UPDATE Liquidacion SET LiqAuxEstado=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

