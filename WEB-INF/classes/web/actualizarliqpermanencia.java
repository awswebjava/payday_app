package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarliqpermanencia extends GXProcedure
{
   public actualizarliqpermanencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarliqpermanencia.class ), "" );
   }

   public actualizarliqpermanencia( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        int aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 )
   {
      actualizarliqpermanencia.this.AV8CliCod = aP0;
      actualizarliqpermanencia.this.AV9EmpCod = aP1;
      actualizarliqpermanencia.this.AV10LegNumero = aP2;
      actualizarliqpermanencia.this.AV11LegHisFecEgr = aP3;
      actualizarliqpermanencia.this.AV12LiqNro = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02AH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegHisFecEgr});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2332LegHisManual = P02AH2_A2332LegHisManual[0] ;
         A2254LegHisFecEgr = P02AH2_A2254LegHisFecEgr[0] ;
         A6LegNumero = P02AH2_A6LegNumero[0] ;
         A1EmpCod = P02AH2_A1EmpCod[0] ;
         A3CliCod = P02AH2_A3CliCod[0] ;
         A2252LegHisLiqNro = P02AH2_A2252LegHisLiqNro[0] ;
         n2252LegHisLiqNro = P02AH2_n2252LegHisLiqNro[0] ;
         A2253LegHisFecIng = P02AH2_A2253LegHisFecIng[0] ;
         A2252LegHisLiqNro = AV12LiqNro ;
         n2252LegHisLiqNro = false ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P02AH3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         if (true) break;
         /* Using cursor P02AH4 */
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
      P02AH2_A2332LegHisManual = new boolean[] {false} ;
      P02AH2_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02AH2_A6LegNumero = new int[1] ;
      P02AH2_A1EmpCod = new short[1] ;
      P02AH2_A3CliCod = new int[1] ;
      P02AH2_A2252LegHisLiqNro = new int[1] ;
      P02AH2_n2252LegHisLiqNro = new boolean[] {false} ;
      P02AH2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarliqpermanencia__default(),
         new Object[] {
             new Object[] {
            P02AH2_A2332LegHisManual, P02AH2_A2254LegHisFecEgr, P02AH2_A6LegNumero, P02AH2_A1EmpCod, P02AH2_A3CliCod, P02AH2_A2252LegHisLiqNro, P02AH2_n2252LegHisLiqNro, P02AH2_A2253LegHisFecIng
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
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A2252LegHisLiqNro ;
   private String scmdbuf ;
   private java.util.Date AV11LegHisFecEgr ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date A2253LegHisFecIng ;
   private boolean A2332LegHisManual ;
   private boolean n2252LegHisLiqNro ;
   private IDataStoreProvider pr_default ;
   private boolean[] P02AH2_A2332LegHisManual ;
   private java.util.Date[] P02AH2_A2254LegHisFecEgr ;
   private int[] P02AH2_A6LegNumero ;
   private short[] P02AH2_A1EmpCod ;
   private int[] P02AH2_A3CliCod ;
   private int[] P02AH2_A2252LegHisLiqNro ;
   private boolean[] P02AH2_n2252LegHisLiqNro ;
   private java.util.Date[] P02AH2_A2253LegHisFecIng ;
}

final  class actualizarliqpermanencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AH2", "SELECT LegHisManual, LegHisFecEgr, LegNumero, EmpCod, CliCod, LegHisLiqNro, LegHisFecIng FROM legajo_permanencia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegHisFecEgr = ?) AND (LegHisManual = FALSE) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1 FOR UPDATE OF legajo_permanencia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02AH3", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02AH4", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
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

