package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqgetultbancprevi extends GXProcedure
{
   public liqgetultbancprevi( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqgetultbancprevi.class ), "" );
   }

   public liqgetultbancprevi( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      liqgetultbancprevi.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      liqgetultbancprevi.this.AV8CliCod = aP0;
      liqgetultbancprevi.this.AV9EmpCod = aP1;
      liqgetultbancprevi.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00KZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00KZ2_A3CliCod[0] ;
         A1EmpCod = P00KZ2_A1EmpCod[0] ;
         A33LiqDepBanCod = P00KZ2_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = P00KZ2_n33LiqDepBanCod[0] ;
         A31LiqNro = P00KZ2_A31LiqNro[0] ;
         AV10LiqDepBanCod = A33LiqDepBanCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = liqgetultbancprevi.this.AV10LiqDepBanCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqDepBanCod = "" ;
      scmdbuf = "" ;
      P00KZ2_A3CliCod = new int[1] ;
      P00KZ2_A1EmpCod = new short[1] ;
      P00KZ2_A33LiqDepBanCod = new String[] {""} ;
      P00KZ2_n33LiqDepBanCod = new boolean[] {false} ;
      P00KZ2_A31LiqNro = new int[1] ;
      A33LiqDepBanCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqgetultbancprevi__default(),
         new Object[] {
             new Object[] {
            P00KZ2_A3CliCod, P00KZ2_A1EmpCod, P00KZ2_A33LiqDepBanCod, P00KZ2_n33LiqDepBanCod, P00KZ2_A31LiqNro
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
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV10LiqDepBanCod ;
   private String scmdbuf ;
   private String A33LiqDepBanCod ;
   private boolean n33LiqDepBanCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P00KZ2_A3CliCod ;
   private short[] P00KZ2_A1EmpCod ;
   private String[] P00KZ2_A33LiqDepBanCod ;
   private boolean[] P00KZ2_n33LiqDepBanCod ;
   private int[] P00KZ2_A31LiqNro ;
}

final  class liqgetultbancprevi__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KZ2", "SELECT CliCod, EmpCod, LiqDepBanCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LiqNro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
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

