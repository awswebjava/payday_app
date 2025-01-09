package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempvacmax extends GXProcedure
{
   public getempvacmax( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempvacmax.class ), "" );
   }

   public getempvacmax( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 )
   {
      getempvacmax.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int[] aP2 )
   {
      getempvacmax.this.AV9CliCod = aP0;
      getempvacmax.this.AV10EmpCod = aP1;
      getempvacmax.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02BX2_A1EmpCod[0] ;
         A3CliCod = P02BX2_A3CliCod[0] ;
         A2261EmpVacDisMax = P02BX2_A2261EmpVacDisMax[0] ;
         AV8EmpVacDisMax = A2261EmpVacDisMax ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempvacmax.this.AV8EmpVacDisMax;
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
      P02BX2_A1EmpCod = new short[1] ;
      P02BX2_A3CliCod = new int[1] ;
      P02BX2_A2261EmpVacDisMax = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempvacmax__default(),
         new Object[] {
             new Object[] {
            P02BX2_A1EmpCod, P02BX2_A3CliCod, P02BX2_A2261EmpVacDisMax
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV8EmpVacDisMax ;
   private int A3CliCod ;
   private int A2261EmpVacDisMax ;
   private String scmdbuf ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BX2_A1EmpCod ;
   private int[] P02BX2_A3CliCod ;
   private int[] P02BX2_A2261EmpVacDisMax ;
}

final  class getempvacmax__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BX2", "SELECT EmpCod, CliCod, EmpVacDisMax FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               return;
      }
   }

}

