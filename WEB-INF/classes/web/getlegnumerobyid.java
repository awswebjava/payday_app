package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegnumerobyid extends GXProcedure
{
   public getlegnumerobyid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegnumerobyid.class ), "" );
   }

   public getlegnumerobyid( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          String aP2 )
   {
      getlegnumerobyid.this.aP3 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        int[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int[] aP3 )
   {
      getlegnumerobyid.this.AV8CliCod = aP0;
      getlegnumerobyid.this.AV9EmpCod = aP1;
      getlegnumerobyid.this.AV10LegId = aP2;
      getlegnumerobyid.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00L32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV10LegId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A93LegId = P00L32_A93LegId[0] ;
         n93LegId = P00L32_n93LegId[0] ;
         A1EmpCod = P00L32_A1EmpCod[0] ;
         A3CliCod = P00L32_A3CliCod[0] ;
         A6LegNumero = P00L32_A6LegNumero[0] ;
         AV11LegNumero = A6LegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegnumerobyid.this.AV11LegNumero;
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
      P00L32_A93LegId = new String[] {""} ;
      P00L32_n93LegId = new boolean[] {false} ;
      P00L32_A1EmpCod = new short[1] ;
      P00L32_A3CliCod = new int[1] ;
      P00L32_A6LegNumero = new int[1] ;
      A93LegId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegnumerobyid__default(),
         new Object[] {
             new Object[] {
            P00L32_A93LegId, P00L32_n93LegId, P00L32_A1EmpCod, P00L32_A3CliCod, P00L32_A6LegNumero
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
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV10LegId ;
   private String scmdbuf ;
   private String A93LegId ;
   private boolean n93LegId ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00L32_A93LegId ;
   private boolean[] P00L32_n93LegId ;
   private short[] P00L32_A1EmpCod ;
   private int[] P00L32_A3CliCod ;
   private int[] P00L32_A6LegNumero ;
}

final  class getlegnumerobyid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00L32", "SELECT LegId, EmpCod, CliCod, LegNumero FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegId = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

