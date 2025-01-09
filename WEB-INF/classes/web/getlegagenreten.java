package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegagenreten extends GXProcedure
{
   public getlegagenreten( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegagenreten.class ), "" );
   }

   public getlegagenreten( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 )
   {
      getlegagenreten.this.aP3 = new boolean[] {false};
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
      getlegagenreten.this.AV11CliCod = aP0;
      getlegagenreten.this.AV10EmpCod = aP1;
      getlegagenreten.this.AV9LegNumero = aP2;
      getlegagenreten.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00ZN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00ZN2_A6LegNumero[0] ;
         A1EmpCod = P00ZN2_A1EmpCod[0] ;
         A3CliCod = P00ZN2_A3CliCod[0] ;
         A877LegAgenReten = P00ZN2_A877LegAgenReten[0] ;
         AV8LegAgenReten = A877LegAgenReten ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegagenreten.this.AV8LegAgenReten;
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
      P00ZN2_A6LegNumero = new int[1] ;
      P00ZN2_A1EmpCod = new short[1] ;
      P00ZN2_A3CliCod = new int[1] ;
      P00ZN2_A877LegAgenReten = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegagenreten__default(),
         new Object[] {
             new Object[] {
            P00ZN2_A6LegNumero, P00ZN2_A1EmpCod, P00ZN2_A3CliCod, P00ZN2_A877LegAgenReten
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8LegAgenReten ;
   private boolean A877LegAgenReten ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00ZN2_A6LegNumero ;
   private short[] P00ZN2_A1EmpCod ;
   private int[] P00ZN2_A3CliCod ;
   private boolean[] P00ZN2_A877LegAgenReten ;
}

final  class getlegagenreten__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZN2", "SELECT LegNumero, EmpCod, CliCod, LegAgenReten FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

