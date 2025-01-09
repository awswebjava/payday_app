package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultempresalocalidad extends GXProcedure
{
   public getultempresalocalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultempresalocalidad.class ), "" );
   }

   public getultempresalocalidad( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short[] aP1 ,
                             short[] aP2 )
   {
      getultempresalocalidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 ,
                        short[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 ,
                             short[] aP2 ,
                             String[] aP3 )
   {
      getultempresalocalidad.this.AV8CliCod = aP0;
      getultempresalocalidad.this.aP1 = aP1;
      getultempresalocalidad.this.aP2 = aP2;
      getultempresalocalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02AV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02AV2_A3CliCod[0] ;
         A47ProvCod = P02AV2_A47ProvCod[0] ;
         n47ProvCod = P02AV2_n47ProvCod[0] ;
         A48LocCod = P02AV2_A48LocCod[0] ;
         n48LocCod = P02AV2_n48LocCod[0] ;
         A44EmpZonCod = P02AV2_A44EmpZonCod[0] ;
         n44EmpZonCod = P02AV2_n44EmpZonCod[0] ;
         A1EmpCod = P02AV2_A1EmpCod[0] ;
         AV11ProvCod = A47ProvCod ;
         AV12LocCod = A48LocCod ;
         AV13EmpZonCod = A44EmpZonCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getultempresalocalidad.this.AV11ProvCod;
      this.aP2[0] = getultempresalocalidad.this.AV12LocCod;
      this.aP3[0] = getultempresalocalidad.this.AV13EmpZonCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13EmpZonCod = "" ;
      scmdbuf = "" ;
      P02AV2_A3CliCod = new int[1] ;
      P02AV2_A47ProvCod = new short[1] ;
      P02AV2_n47ProvCod = new boolean[] {false} ;
      P02AV2_A48LocCod = new short[1] ;
      P02AV2_n48LocCod = new boolean[] {false} ;
      P02AV2_A44EmpZonCod = new String[] {""} ;
      P02AV2_n44EmpZonCod = new boolean[] {false} ;
      P02AV2_A1EmpCod = new short[1] ;
      A44EmpZonCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultempresalocalidad__default(),
         new Object[] {
             new Object[] {
            P02AV2_A3CliCod, P02AV2_A47ProvCod, P02AV2_n47ProvCod, P02AV2_A48LocCod, P02AV2_n48LocCod, P02AV2_A44EmpZonCod, P02AV2_n44EmpZonCod, P02AV2_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11ProvCod ;
   private short AV12LocCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV13EmpZonCod ;
   private String scmdbuf ;
   private String A44EmpZonCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n44EmpZonCod ;
   private String[] aP3 ;
   private short[] aP1 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P02AV2_A3CliCod ;
   private short[] P02AV2_A47ProvCod ;
   private boolean[] P02AV2_n47ProvCod ;
   private short[] P02AV2_A48LocCod ;
   private boolean[] P02AV2_n48LocCod ;
   private String[] P02AV2_A44EmpZonCod ;
   private boolean[] P02AV2_n44EmpZonCod ;
   private short[] P02AV2_A1EmpCod ;
}

final  class getultempresalocalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AV2", "SELECT CliCod, ProvCod, LocCod, EmpZonCod, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod, EmpCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(5);
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
               return;
      }
   }

}

