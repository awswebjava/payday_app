package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminaliquidacionlegajo extends GXProcedure
{
   public eliminaliquidacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminaliquidacionlegajo.class ), "" );
   }

   public eliminaliquidacionlegajo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 )
   {
      eliminaliquidacionlegajo.this.AV11CliCod = aP0;
      eliminaliquidacionlegajo.this.AV9EmpCod = aP1;
      eliminaliquidacionlegajo.this.AV10LiqNro = aP2;
      eliminaliquidacionlegajo.this.AV8LegNumero = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P009I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P009I2_A6LegNumero[0] ;
         A31LiqNro = P009I2_A31LiqNro[0] ;
         A1EmpCod = P009I2_A1EmpCod[0] ;
         A3CliCod = P009I2_A3CliCod[0] ;
         /* Optimized DELETE. */
         /* Using cursor P009I3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         /* End optimized DELETE. */
         /* Using cursor P009I4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminaliquidacionlegajo");
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
      P009I2_A6LegNumero = new int[1] ;
      P009I2_A31LiqNro = new int[1] ;
      P009I2_A1EmpCod = new short[1] ;
      P009I2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminaliquidacionlegajo__default(),
         new Object[] {
             new Object[] {
            P009I2_A6LegNumero, P009I2_A31LiqNro, P009I2_A1EmpCod, P009I2_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV10LiqNro ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private int[] P009I2_A6LegNumero ;
   private int[] P009I2_A31LiqNro ;
   private short[] P009I2_A1EmpCod ;
   private int[] P009I2_A3CliCod ;
}

final  class eliminaliquidacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009I2", "SELECT LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P009I3", "DELETE FROM LiquidacionDetalle  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P009I4", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajo  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

