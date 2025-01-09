package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresalocalidad extends GXProcedure
{
   public getempresalocalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresalocalidad.class ), "" );
   }

   public getempresalocalidad( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short[] aP2 )
   {
      getempresalocalidad.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      getempresalocalidad.this.AV11CliCod = aP0;
      getempresalocalidad.this.AV8EmpCod = aP1;
      getempresalocalidad.this.aP2 = aP2;
      getempresalocalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02872 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02872_A1EmpCod[0] ;
         A3CliCod = P02872_A3CliCod[0] ;
         A47ProvCod = P02872_A47ProvCod[0] ;
         n47ProvCod = P02872_n47ProvCod[0] ;
         A48LocCod = P02872_A48LocCod[0] ;
         n48LocCod = P02872_n48LocCod[0] ;
         AV9ProvCod = A47ProvCod ;
         AV10LocCod = A48LocCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresalocalidad.this.AV9ProvCod;
      this.aP3[0] = getempresalocalidad.this.AV10LocCod;
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
      P02872_A1EmpCod = new short[1] ;
      P02872_A3CliCod = new int[1] ;
      P02872_A47ProvCod = new short[1] ;
      P02872_n47ProvCod = new boolean[] {false} ;
      P02872_A48LocCod = new short[1] ;
      P02872_n48LocCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresalocalidad__default(),
         new Object[] {
             new Object[] {
            P02872_A1EmpCod, P02872_A3CliCod, P02872_A47ProvCod, P02872_n47ProvCod, P02872_A48LocCod, P02872_n48LocCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV9ProvCod ;
   private short AV10LocCod ;
   private short A1EmpCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private short[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02872_A1EmpCod ;
   private int[] P02872_A3CliCod ;
   private short[] P02872_A47ProvCod ;
   private boolean[] P02872_n47ProvCod ;
   private short[] P02872_A48LocCod ;
   private boolean[] P02872_n48LocCod ;
}

final  class getempresalocalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02872", "SELECT EmpCod, CliCod, ProvCod, LocCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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

