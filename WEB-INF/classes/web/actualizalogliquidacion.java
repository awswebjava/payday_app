package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizalogliquidacion extends GXProcedure
{
   public actualizalogliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizalogliquidacion.class ), "" );
   }

   public actualizalogliquidacion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      actualizalogliquidacion.this.AV10clicod = aP0;
      actualizalogliquidacion.this.AV11empcod = aP1;
      actualizalogliquidacion.this.AV8liqnro = aP2;
      actualizalogliquidacion.this.AV12LiqLog = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10clicod), Short.valueOf(AV11empcod), Integer.valueOf(AV8liqnro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P018T2_A31LiqNro[0] ;
         A1EmpCod = P018T2_A1EmpCod[0] ;
         A3CliCod = P018T2_A3CliCod[0] ;
         A1142LiqLog = P018T2_A1142LiqLog[0] ;
         A1142LiqLog += AV12LiqLog + httpContext.getMessage( "<br>", "") ;
         /* Using cursor P018T3 */
         pr_default.execute(1, new Object[] {A1142LiqLog, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      P018T2_A31LiqNro = new int[1] ;
      P018T2_A1EmpCod = new short[1] ;
      P018T2_A3CliCod = new int[1] ;
      P018T2_A1142LiqLog = new String[] {""} ;
      A1142LiqLog = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizalogliquidacion__default(),
         new Object[] {
             new Object[] {
            P018T2_A31LiqNro, P018T2_A1EmpCod, P018T2_A3CliCod, P018T2_A1142LiqLog
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10clicod ;
   private int AV8liqnro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV12LiqLog ;
   private String A1142LiqLog ;
   private IDataStoreProvider pr_default ;
   private int[] P018T2_A31LiqNro ;
   private short[] P018T2_A1EmpCod ;
   private int[] P018T2_A3CliCod ;
   private String[] P018T2_A1142LiqLog ;
}

final  class actualizalogliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018T2", "SELECT LiqNro, EmpCod, CliCod, LiqLog FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P018T3", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqLog=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

