package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setliqlegerror extends GXProcedure
{
   public setliqlegerror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setliqlegerror.class ), "" );
   }

   public setliqlegerror( int remoteHandle ,
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
      setliqlegerror.this.AV12CliCod = aP0;
      setliqlegerror.this.AV8EmpCod = aP1;
      setliqlegerror.this.AV11LiqNro = aP2;
      setliqlegerror.this.AV10LegNumero = aP3;
      setliqlegerror.this.AV9LiqLegError = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P01OB2 */
      pr_default.execute(0, new Object[] {AV9LiqLegError, Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setliqlegerror");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A891LiqLegError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setliqlegerror__default(),
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
   private int AV12CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private String AV9LiqLegError ;
   private String A891LiqLegError ;
   private IDataStoreProvider pr_default ;
}

final  class setliqlegerror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01OB2", "UPDATE LiquidacionLegajo SET LiqLegError=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

