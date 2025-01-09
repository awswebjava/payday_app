package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpresentismoporempresa extends GXProcedure
{
   public getpresentismoporempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpresentismoporempresa.class ), "" );
   }

   public getpresentismoporempresa( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 )
   {
      getpresentismoporempresa.this.aP2 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
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
      getpresentismoporempresa.this.AV10CliCod = aP0;
      getpresentismoporempresa.this.AV9EmpCod = aP1;
      getpresentismoporempresa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P018R2_A1EmpCod[0] ;
         A3CliCod = P018R2_A3CliCod[0] ;
         A1141EmpPresentismo = P018R2_A1141EmpPresentismo[0] ;
         AV11EmpPresentismo = A1141EmpPresentismo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpresentismoporempresa.this.AV11EmpPresentismo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11EmpPresentismo = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P018R2_A1EmpCod = new short[1] ;
      P018R2_A3CliCod = new int[1] ;
      P018R2_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1141EmpPresentismo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpresentismoporempresa__default(),
         new Object[] {
             new Object[] {
            P018R2_A1EmpCod, P018R2_A3CliCod, P018R2_A1141EmpPresentismo
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
   private java.math.BigDecimal AV11EmpPresentismo ;
   private java.math.BigDecimal A1141EmpPresentismo ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P018R2_A1EmpCod ;
   private int[] P018R2_A3CliCod ;
   private java.math.BigDecimal[] P018R2_A1141EmpPresentismo ;
}

final  class getpresentismoporempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018R2", "SELECT EmpCod, CliCod, EmpPresentismo FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
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

