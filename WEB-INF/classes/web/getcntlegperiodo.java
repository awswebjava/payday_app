package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcntlegperiodo extends GXProcedure
{
   public getcntlegperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcntlegperiodo.class ), "" );
   }

   public getcntlegperiodo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            java.util.Date aP2 )
   {
      getcntlegperiodo.this.aP3 = new short[] {0};
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
      getcntlegperiodo.this.AV11CliCod = aP0;
      getcntlegperiodo.this.AV8EmpCod = aP1;
      getcntlegperiodo.this.AV9LiqPeriodo = aP2;
      getcntlegperiodo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P02GE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), AV9LiqPeriodo});
      c495LiqCntLeg = P02GE2_A495LiqCntLeg[0] ;
      pr_default.close(0);
      AV10LiqCntLeg = (short)(AV10LiqCntLeg+c495LiqCntLeg) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getcntlegperiodo.this.AV10LiqCntLeg;
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
      P02GE2_A495LiqCntLeg = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcntlegperiodo__default(),
         new Object[] {
             new Object[] {
            P02GE2_A495LiqCntLeg
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV10LiqCntLeg ;
   private short c495LiqCntLeg ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String scmdbuf ;
   private java.util.Date AV9LiqPeriodo ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P02GE2_A495LiqCntLeg ;
}

final  class getcntlegperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GE2", "SELECT SUM(LiqCntLeg) FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPeriodo = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

