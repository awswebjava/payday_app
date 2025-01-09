package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqperiodoliq extends GXProcedure
{
   public getliqperiodoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqperiodoliq.class ), "" );
   }

   public getliqperiodoliq( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 )
   {
      getliqperiodoliq.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 )
   {
      getliqperiodoliq.this.AV8CliCod = aP0;
      getliqperiodoliq.this.AV9EmpCod = aP1;
      getliqperiodoliq.this.AV10LiqNro = aP2;
      getliqperiodoliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P01MT2_A31LiqNro[0] ;
         A1EmpCod = P01MT2_A1EmpCod[0] ;
         A3CliCod = P01MT2_A3CliCod[0] ;
         A1729PeriodoLiq = P01MT2_A1729PeriodoLiq[0] ;
         AV11PeriodoLiq = A1729PeriodoLiq ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqperiodoliq.this.AV11PeriodoLiq;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PeriodoLiq = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01MT2_A31LiqNro = new int[1] ;
      P01MT2_A1EmpCod = new short[1] ;
      P01MT2_A3CliCod = new int[1] ;
      P01MT2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqperiodoliq__default(),
         new Object[] {
             new Object[] {
            P01MT2_A31LiqNro, P01MT2_A1EmpCod, P01MT2_A3CliCod, P01MT2_A1729PeriodoLiq
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
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV11PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01MT2_A31LiqNro ;
   private short[] P01MT2_A1EmpCod ;
   private int[] P01MT2_A3CliCod ;
   private java.util.Date[] P01MT2_A1729PeriodoLiq ;
}

final  class getliqperiodoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MT2", "SELECT LiqNro, EmpCod, CliCod, PeriodoLiq FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
      }
   }

}

