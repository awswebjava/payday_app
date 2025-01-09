package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class desasignarliqpermanencia extends GXProcedure
{
   public desasignarliqpermanencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( desasignarliqpermanencia.class ), "" );
   }

   public desasignarliqpermanencia( int remoteHandle ,
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
      desasignarliqpermanencia.this.AV8CliCod = aP0;
      desasignarliqpermanencia.this.AV9EmpCod = aP1;
      desasignarliqpermanencia.this.AV10LegNumero = aP2;
      desasignarliqpermanencia.this.AV12LiqNro = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P029E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Integer.valueOf(AV12LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2252LegHisLiqNro = P029E2_A2252LegHisLiqNro[0] ;
         n2252LegHisLiqNro = P029E2_n2252LegHisLiqNro[0] ;
         A6LegNumero = P029E2_A6LegNumero[0] ;
         A1EmpCod = P029E2_A1EmpCod[0] ;
         A3CliCod = P029E2_A3CliCod[0] ;
         A2253LegHisFecIng = P029E2_A2253LegHisFecIng[0] ;
         A2252LegHisLiqNro = 0 ;
         n2252LegHisLiqNro = false ;
         n2252LegHisLiqNro = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P029E3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         if (true) break;
         /* Using cursor P029E4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         pr_default.readNext(0);
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
      P029E2_A2252LegHisLiqNro = new int[1] ;
      P029E2_n2252LegHisLiqNro = new boolean[] {false} ;
      P029E2_A6LegNumero = new int[1] ;
      P029E2_A1EmpCod = new short[1] ;
      P029E2_A3CliCod = new int[1] ;
      P029E2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.desasignarliqpermanencia__default(),
         new Object[] {
             new Object[] {
            P029E2_A2252LegHisLiqNro, P029E2_n2252LegHisLiqNro, P029E2_A6LegNumero, P029E2_A1EmpCod, P029E2_A3CliCod, P029E2_A2253LegHisFecIng
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
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int AV12LiqNro ;
   private int A2252LegHisLiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date A2253LegHisFecIng ;
   private boolean n2252LegHisLiqNro ;
   private IDataStoreProvider pr_default ;
   private int[] P029E2_A2252LegHisLiqNro ;
   private boolean[] P029E2_n2252LegHisLiqNro ;
   private int[] P029E2_A6LegNumero ;
   private short[] P029E2_A1EmpCod ;
   private int[] P029E2_A3CliCod ;
   private java.util.Date[] P029E2_A2253LegHisFecIng ;
}

final  class desasignarliqpermanencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P029E2", "SELECT LegHisLiqNro, LegNumero, EmpCod, CliCod, LegHisFecIng FROM legajo_permanencia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegHisLiqNro = ?) ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng  LIMIT 1 FOR UPDATE OF legajo_permanencia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P029E3", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P029E4", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setDate(5, (java.util.Date)parms[5]);
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setDate(5, (java.util.Date)parms[5]);
               return;
      }
   }

}

