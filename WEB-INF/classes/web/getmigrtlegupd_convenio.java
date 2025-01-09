package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrtlegupd_convenio extends GXProcedure
{
   public getmigrtlegupd_convenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrtlegupd_convenio.class ), "" );
   }

   public getmigrtlegupd_convenio( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getmigrtlegupd_convenio.this.aP3 = new String[] {""};
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
      getmigrtlegupd_convenio.this.AV10CliCod = aP0;
      getmigrtlegupd_convenio.this.AV9EmpCod = aP1;
      getmigrtlegupd_convenio.this.AV8MigrLegNumero = aP2;
      getmigrtlegupd_convenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01J92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P01J92_A87MigrLegNumero[0] ;
         A1EmpCod = P01J92_A1EmpCod[0] ;
         A3CliCod = P01J92_A3CliCod[0] ;
         A627MigrLegConvenio = P01J92_A627MigrLegConvenio[0] ;
         AV12MigrLegConvenio = A627MigrLegConvenio ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrtlegupd_convenio.this.AV12MigrLegConvenio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MigrLegConvenio = "" ;
      scmdbuf = "" ;
      P01J92_A87MigrLegNumero = new int[1] ;
      P01J92_A1EmpCod = new short[1] ;
      P01J92_A3CliCod = new int[1] ;
      P01J92_A627MigrLegConvenio = new String[] {""} ;
      A627MigrLegConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrtlegupd_convenio__default(),
         new Object[] {
             new Object[] {
            P01J92_A87MigrLegNumero, P01J92_A1EmpCod, P01J92_A3CliCod, P01J92_A627MigrLegConvenio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV12MigrLegConvenio ;
   private String A627MigrLegConvenio ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01J92_A87MigrLegNumero ;
   private short[] P01J92_A1EmpCod ;
   private int[] P01J92_A3CliCod ;
   private String[] P01J92_A627MigrLegConvenio ;
}

final  class getmigrtlegupd_convenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01J92", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegConvenio FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

