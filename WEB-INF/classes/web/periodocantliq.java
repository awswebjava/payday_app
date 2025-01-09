package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class periodocantliq extends GXProcedure
{
   public periodocantliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodocantliq.class ), "" );
   }

   public periodocantliq( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            java.util.Date aP2 )
   {
      periodocantliq.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             short[] aP3 )
   {
      periodocantliq.this.AV8CliCod = aP0;
      periodocantliq.this.AV11EmpCod = aP1;
      periodocantliq.this.AV10PeriodoLiq = aP2;
      periodocantliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P01JL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod), AV10PeriodoLiq});
      cV9cantidad = P01JL2_AV9cantidad[0] ;
      pr_default.close(0);
      AV9cantidad = (short)(AV9cantidad+cV9cantidad*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = periodocantliq.this.AV9cantidad;
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
      P01JL2_AV9cantidad = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodocantliq__default(),
         new Object[] {
             new Object[] {
            P01JL2_AV9cantidad
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9cantidad ;
   private short cV9cantidad ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String scmdbuf ;
   private java.util.Date AV10PeriodoLiq ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P01JL2_AV9cantidad ;
}

final  class periodocantliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JL2", "SELECT COUNT(*) FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and PeriodoLiq = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

