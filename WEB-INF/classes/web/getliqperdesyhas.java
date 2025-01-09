package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqperdesyhas extends GXProcedure
{
   public getliqperdesyhas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqperdesyhas.class ), "" );
   }

   public getliqperdesyhas( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     java.util.Date[] aP3 )
   {
      getliqperdesyhas.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 ,
                             java.util.Date[] aP4 )
   {
      getliqperdesyhas.this.AV12CliCod = aP0;
      getliqperdesyhas.this.AV8EmpCod = aP1;
      getliqperdesyhas.this.AV11LiqNro = aP2;
      getliqperdesyhas.this.aP3 = aP3;
      getliqperdesyhas.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV11LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02L92_A31LiqNro[0] ;
         A1EmpCod = P02L92_A1EmpCod[0] ;
         A3CliCod = P02L92_A3CliCod[0] ;
         A2410LiqPerDes = P02L92_A2410LiqPerDes[0] ;
         A2411LiqPerHas = P02L92_A2411LiqPerHas[0] ;
         AV9LiqPerDes = A2410LiqPerDes ;
         AV10LiqPerHas = A2411LiqPerHas ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqperdesyhas.this.AV9LiqPerDes;
      this.aP4[0] = getliqperdesyhas.this.AV10LiqPerHas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqPerDes = GXutil.nullDate() ;
      AV10LiqPerHas = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02L92_A31LiqNro = new int[1] ;
      P02L92_A1EmpCod = new short[1] ;
      P02L92_A3CliCod = new int[1] ;
      P02L92_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02L92_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqperdesyhas__default(),
         new Object[] {
             new Object[] {
            P02L92_A31LiqNro, P02L92_A1EmpCod, P02L92_A3CliCod, P02L92_A2410LiqPerDes, P02L92_A2411LiqPerHas
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV9LiqPerDes ;
   private java.util.Date AV10LiqPerHas ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date[] aP4 ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02L92_A31LiqNro ;
   private short[] P02L92_A1EmpCod ;
   private int[] P02L92_A3CliCod ;
   private java.util.Date[] P02L92_A2410LiqPerDes ;
   private java.util.Date[] P02L92_A2411LiqPerHas ;
}

final  class getliqperdesyhas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L92", "SELECT LiqNro, EmpCod, CliCod, LiqPerDes, LiqPerHas FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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

