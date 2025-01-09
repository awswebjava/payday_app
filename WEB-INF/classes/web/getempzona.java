package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempzona extends GXProcedure
{
   public getempzona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempzona.class ), "" );
   }

   public getempzona( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getempzona.this.aP2 = new String[] {""};
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
      getempzona.this.AV8CliCod = aP0;
      getempzona.this.AV9EmpCod = aP1;
      getempzona.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P028J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P028J2_A1EmpCod[0] ;
         A3CliCod = P028J2_A3CliCod[0] ;
         A44EmpZonCod = P028J2_A44EmpZonCod[0] ;
         n44EmpZonCod = P028J2_n44EmpZonCod[0] ;
         AV10EmpZonCod = A44EmpZonCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempzona.this.AV10EmpZonCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10EmpZonCod = "" ;
      scmdbuf = "" ;
      P028J2_A1EmpCod = new short[1] ;
      P028J2_A3CliCod = new int[1] ;
      P028J2_A44EmpZonCod = new String[] {""} ;
      P028J2_n44EmpZonCod = new boolean[] {false} ;
      A44EmpZonCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempzona__default(),
         new Object[] {
             new Object[] {
            P028J2_A1EmpCod, P028J2_A3CliCod, P028J2_A44EmpZonCod, P028J2_n44EmpZonCod
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
   private String AV10EmpZonCod ;
   private String scmdbuf ;
   private String A44EmpZonCod ;
   private boolean n44EmpZonCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P028J2_A1EmpCod ;
   private int[] P028J2_A3CliCod ;
   private String[] P028J2_A44EmpZonCod ;
   private boolean[] P028J2_n44EmpZonCod ;
}

final  class getempzona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028J2", "SELECT EmpCod, CliCod, EmpZonCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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

