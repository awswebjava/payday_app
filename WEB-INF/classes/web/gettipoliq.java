package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliq extends GXProcedure
{
   public gettipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliq.class ), "" );
   }

   public gettipoliq( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      gettipoliq.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      gettipoliq.this.AV8CliCod = aP0;
      gettipoliq.this.AV9EmpCod = aP1;
      gettipoliq.this.AV10LiqNro = aP2;
      gettipoliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00J62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00J62_A31LiqNro[0] ;
         A1EmpCod = P00J62_A1EmpCod[0] ;
         A3CliCod = P00J62_A3CliCod[0] ;
         A32TLiqCod = P00J62_A32TLiqCod[0] ;
         n32TLiqCod = P00J62_n32TLiqCod[0] ;
         AV11TLiqCod = A32TLiqCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.pruebaharcode(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gettipoliq.this.AV11TLiqCod;
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
      scmdbuf = "" ;
      P00J62_A31LiqNro = new int[1] ;
      P00J62_A1EmpCod = new short[1] ;
      P00J62_A3CliCod = new int[1] ;
      P00J62_A32TLiqCod = new String[] {""} ;
      P00J62_n32TLiqCod = new boolean[] {false} ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliq__default(),
         new Object[] {
             new Object[] {
            P00J62_A31LiqNro, P00J62_A1EmpCod, P00J62_A3CliCod, P00J62_A32TLiqCod, P00J62_n32TLiqCod
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
   private boolean n32TLiqCod ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00J62_A31LiqNro ;
   private short[] P00J62_A1EmpCod ;
   private int[] P00J62_A3CliCod ;
   private String[] P00J62_A32TLiqCod ;
   private boolean[] P00J62_n32TLiqCod ;
}

final  class gettipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00J62", "SELECT LiqNro, EmpCod, CliCod, TLiqCod FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

