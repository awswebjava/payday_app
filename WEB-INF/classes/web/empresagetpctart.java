package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresagetpctart extends GXProcedure
{
   public empresagetpctart( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresagetpctart.class ), "" );
   }

   public empresagetpctart( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 )
   {
      empresagetpctart.this.aP2 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.math.BigDecimal[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal[] aP2 )
   {
      empresagetpctart.this.AV10CliCod = aP0;
      empresagetpctart.this.AV8EmpCod = aP1;
      empresagetpctart.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00JH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1151ARTSec = P00JH2_A1151ARTSec[0] ;
         A1EmpCod = P00JH2_A1EmpCod[0] ;
         A3CliCod = P00JH2_A3CliCod[0] ;
         A1153ARTAli = P00JH2_A1153ARTAli[0] ;
         A1153ARTAli = P00JH2_A1153ARTAli[0] ;
         AV11ARTAli = A1153ARTAli ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = empresagetpctart.this.AV11ARTAli;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ARTAli = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00JH2_A1151ARTSec = new short[1] ;
      P00JH2_A1EmpCod = new short[1] ;
      P00JH2_A3CliCod = new int[1] ;
      P00JH2_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1153ARTAli = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresagetpctart__default(),
         new Object[] {
             new Object[] {
            P00JH2_A1151ARTSec, P00JH2_A1EmpCod, P00JH2_A3CliCod, P00JH2_A1153ARTAli
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1151ARTSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11ARTAli ;
   private java.math.BigDecimal A1153ARTAli ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00JH2_A1151ARTSec ;
   private short[] P00JH2_A1EmpCod ;
   private int[] P00JH2_A3CliCod ;
   private java.math.BigDecimal[] P00JH2_A1153ARTAli ;
}

final  class empresagetpctart__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JH2", "SELECT T1.ARTSec, T1.EmpCod, T1.CliCod, T2.ARTAli FROM (Empresa T1 INNER JOIN ART T2 ON T2.ARTSec = T1.ARTSec) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
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

