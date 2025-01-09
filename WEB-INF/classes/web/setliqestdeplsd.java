package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqestdeplsd extends GXProcedure
{
   public setliqestdeplsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqestdeplsd.class ), "" );
   }

   public setliqestdeplsd( int remoteHandle ,
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
      setliqestdeplsd.this.AV8CliCod = aP0;
      setliqestdeplsd.this.AV9EmpCod = aP1;
      setliqestdeplsd.this.AV11LiqNro = aP2;
      setliqestdeplsd.this.AV10LiqLSDDepEst = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV14Pgmname, httpContext.getMessage( "CliCod: ", "")+GXutil.str( AV8CliCod, 6, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV14Pgmname, httpContext.getMessage( "EmpCod: ", "")+GXutil.str( AV9EmpCod, 4, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV14Pgmname, httpContext.getMessage( "LiqNro: ", "")+GXutil.str( AV11LiqNro, 8, 0)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV14Pgmname, httpContext.getMessage( "&LiqLSDDepEst: ", "")+GXutil.str( AV10LiqLSDDepEst, 1, 0)) ;
      AV15GXLvl8 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P029R2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV10LiqLSDDepEst), Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LiqNro)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV15GXLvl8 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      /* End optimized UPDATE. */
      if ( AV15GXLvl8 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV14Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqestdeplsd");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqestdeplsd__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV14Pgmname = "setLiqEstDepLSD" ;
      /* GeneXus formulas. */
      AV14Pgmname = "setLiqEstDepLSD" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqLSDDepEst ;
   private byte AV15GXLvl8 ;
   private byte A2292LiqLSDDepEst ;
   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private String AV14Pgmname ;
   private IDataStoreProvider pr_default ;
}

final  class setliqestdeplsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P029R2", "UPDATE Liquidacion SET LiqLSDDepEst=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

