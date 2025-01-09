package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class periodoanterior extends GXProcedure
{
   public periodoanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodoanterior.class ), "" );
   }

   public periodoanterior( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     java.util.Date aP2 )
   {
      periodoanterior.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 )
   {
      periodoanterior.this.AV10CliCod = aP0;
      periodoanterior.this.AV11EmpCod = aP1;
      periodoanterior.this.AV13fecha = aP2;
      periodoanterior.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00SH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV13fecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A283LiqPeriodo = P00SH2_A283LiqPeriodo[0] ;
         A1EmpCod = P00SH2_A1EmpCod[0] ;
         A3CliCod = P00SH2_A3CliCod[0] ;
         A31LiqNro = P00SH2_A31LiqNro[0] ;
         AV12LiqPeriodo = A283LiqPeriodo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = periodoanterior.this.AV12LiqPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00SH2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00SH2_A1EmpCod = new short[1] ;
      P00SH2_A3CliCod = new int[1] ;
      P00SH2_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodoanterior__default(),
         new Object[] {
             new Object[] {
            P00SH2_A283LiqPeriodo, P00SH2_A1EmpCod, P00SH2_A3CliCod, P00SH2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private java.util.Date AV13fecha ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00SH2_A283LiqPeriodo ;
   private short[] P00SH2_A1EmpCod ;
   private int[] P00SH2_A3CliCod ;
   private int[] P00SH2_A31LiqNro ;
}

final  class periodoanterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SH2", "SELECT LiqPeriodo, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPeriodo < ? ORDER BY CliCod, EmpCod, LiqPeriodo DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

