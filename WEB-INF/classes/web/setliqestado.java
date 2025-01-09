package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqestado extends GXProcedure
{
   public setliqestado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqestado.class ), "" );
   }

   public setliqestado( int remoteHandle ,
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
      setliqestado.this.AV10CliCod = aP0;
      setliqestado.this.AV8EmpCod = aP1;
      setliqestado.this.AV9LiqNro = aP2;
      setliqestado.this.AV11LiqEstado = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXLvl2 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P003S2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV11LiqEstado), Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV14GXLvl2 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      if ( AV14GXLvl2 == 0 )
      {
         new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqestado");
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqestado__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV15Pgmname = "setLiqEstado" ;
      /* GeneXus formulas. */
      AV15Pgmname = "setLiqEstado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LiqEstado ;
   private byte AV14GXLvl2 ;
   private byte A278LiqEstado ;
   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LiqNro ;
   private String AV15Pgmname ;
   private IDataStoreProvider pr_default ;
}

final  class setliqestado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P003S2", "UPDATE Liquidacion SET LiqEstado=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

