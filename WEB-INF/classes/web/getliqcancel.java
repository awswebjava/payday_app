package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqcancel extends GXProcedure
{
   public getliqcancel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqcancel.class ), "" );
   }

   public getliqcancel( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 )
   {
      getliqcancel.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 )
   {
      getliqcancel.this.AV11CliCod = aP0;
      getliqcancel.this.AV8EmpCod = aP1;
      getliqcancel.this.AV10LiqNro = aP2;
      getliqcancel.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02JG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02JG2_A31LiqNro[0] ;
         A1EmpCod = P02JG2_A1EmpCod[0] ;
         A3CliCod = P02JG2_A3CliCod[0] ;
         A2298LiqCancel = P02JG2_A2298LiqCancel[0] ;
         AV9LiqCancel = A2298LiqCancel ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqcancel.this.AV9LiqCancel;
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
      P02JG2_A31LiqNro = new int[1] ;
      P02JG2_A1EmpCod = new short[1] ;
      P02JG2_A3CliCod = new int[1] ;
      P02JG2_A2298LiqCancel = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqcancel__default(),
         new Object[] {
             new Object[] {
            P02JG2_A31LiqNro, P02JG2_A1EmpCod, P02JG2_A3CliCod, P02JG2_A2298LiqCancel
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9LiqCancel ;
   private boolean A2298LiqCancel ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02JG2_A31LiqNro ;
   private short[] P02JG2_A1EmpCod ;
   private int[] P02JG2_A3CliCod ;
   private boolean[] P02JG2_A2298LiqCancel ;
}

final  class getliqcancel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JG2", "SELECT LiqNro, EmpCod, CliCod, LiqCancel FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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

