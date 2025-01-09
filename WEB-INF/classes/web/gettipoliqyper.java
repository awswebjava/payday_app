package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqyper extends GXProcedure
{
   public gettipoliqyper( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqyper.class ), "" );
   }

   public gettipoliqyper( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     String[] aP3 )
   {
      gettipoliqyper.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             java.util.Date[] aP4 )
   {
      gettipoliqyper.this.AV8CliCod = aP0;
      gettipoliqyper.this.AV9EmpCod = aP1;
      gettipoliqyper.this.AV10LiqNro = aP2;
      gettipoliqyper.this.aP3 = aP3;
      gettipoliqyper.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02EK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02EK2_A31LiqNro[0] ;
         A1EmpCod = P02EK2_A1EmpCod[0] ;
         A3CliCod = P02EK2_A3CliCod[0] ;
         A32TLiqCod = P02EK2_A32TLiqCod[0] ;
         n32TLiqCod = P02EK2_n32TLiqCod[0] ;
         A283LiqPeriodo = P02EK2_A283LiqPeriodo[0] ;
         AV11TLiqCod = A32TLiqCod ;
         AV12LiqPeriodo = A283LiqPeriodo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gettipoliqyper.this.AV11TLiqCod;
      this.aP4[0] = gettipoliqyper.this.AV12LiqPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11TLiqCod = "" ;
      AV12LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02EK2_A31LiqNro = new int[1] ;
      P02EK2_A1EmpCod = new short[1] ;
      P02EK2_A3CliCod = new int[1] ;
      P02EK2_A32TLiqCod = new String[] {""} ;
      P02EK2_n32TLiqCod = new boolean[] {false} ;
      P02EK2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqyper__default(),
         new Object[] {
             new Object[] {
            P02EK2_A31LiqNro, P02EK2_A1EmpCod, P02EK2_A3CliCod, P02EK2_A32TLiqCod, P02EK2_n32TLiqCod, P02EK2_A283LiqPeriodo
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
   private String AV11TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n32TLiqCod ;
   private java.util.Date[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02EK2_A31LiqNro ;
   private short[] P02EK2_A1EmpCod ;
   private int[] P02EK2_A3CliCod ;
   private String[] P02EK2_A32TLiqCod ;
   private boolean[] P02EK2_n32TLiqCod ;
   private java.util.Date[] P02EK2_A283LiqPeriodo ;
}

final  class gettipoliqyper__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EK2", "SELECT LiqNro, EmpCod, CliCod, TLiqCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
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

