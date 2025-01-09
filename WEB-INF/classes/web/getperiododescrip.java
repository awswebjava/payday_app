package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiododescrip extends GXProcedure
{
   public getperiododescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiododescrip.class ), "" );
   }

   public getperiododescrip( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 )
   {
      getperiododescrip.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 )
   {
      getperiododescrip.this.AV10CliCod = aP0;
      getperiododescrip.this.AV9EmpCod = aP1;
      getperiododescrip.this.AV8PeriodoLiq = aP2;
      getperiododescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01V72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), AV8PeriodoLiq});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1729PeriodoLiq = P01V72_A1729PeriodoLiq[0] ;
         A1EmpCod = P01V72_A1EmpCod[0] ;
         A3CliCod = P01V72_A3CliCod[0] ;
         A1732PeriodoDescrip = P01V72_A1732PeriodoDescrip[0] ;
         AV11PeriodoDescrip = A1732PeriodoDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiododescrip.this.AV11PeriodoDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PeriodoDescrip = "" ;
      scmdbuf = "" ;
      P01V72_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P01V72_A1EmpCod = new short[1] ;
      P01V72_A3CliCod = new int[1] ;
      P01V72_A1732PeriodoDescrip = new String[] {""} ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      A1732PeriodoDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiododescrip__default(),
         new Object[] {
             new Object[] {
            P01V72_A1729PeriodoLiq, P01V72_A1EmpCod, P01V72_A3CliCod, P01V72_A1732PeriodoDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV8PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private String AV11PeriodoDescrip ;
   private String A1732PeriodoDescrip ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01V72_A1729PeriodoLiq ;
   private short[] P01V72_A1EmpCod ;
   private int[] P01V72_A3CliCod ;
   private String[] P01V72_A1732PeriodoDescrip ;
}

final  class getperiododescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01V72", "SELECT PeriodoLiq, EmpCod, CliCod, PeriodoDescrip FROM Periodo WHERE CliCod = ? and EmpCod = ? and PeriodoLiq = ? ORDER BY CliCod, EmpCod, PeriodoLiq ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

