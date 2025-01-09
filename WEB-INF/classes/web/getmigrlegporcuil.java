package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrlegporcuil extends GXProcedure
{
   public getmigrlegporcuil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrlegporcuil.class ), "" );
   }

   public getmigrlegporcuil( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          String aP2 )
   {
      getmigrlegporcuil.this.aP3 = new int[] {0};
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
      getmigrlegporcuil.this.AV9CliCod = aP0;
      getmigrlegporcuil.this.AV10EmpCod = aP1;
      getmigrlegporcuil.this.AV11MigrLegCUIL = aP2;
      getmigrlegporcuil.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P027J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), AV11MigrLegCUIL});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A597MigrLegCUIL = P027J2_A597MigrLegCUIL[0] ;
         A1EmpCod = P027J2_A1EmpCod[0] ;
         A3CliCod = P027J2_A3CliCod[0] ;
         A87MigrLegNumero = P027J2_A87MigrLegNumero[0] ;
         AV8MigrLegNumero = A87MigrLegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrlegporcuil.this.AV8MigrLegNumero;
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
      P027J2_A597MigrLegCUIL = new String[] {""} ;
      P027J2_A1EmpCod = new short[1] ;
      P027J2_A3CliCod = new int[1] ;
      P027J2_A87MigrLegNumero = new int[1] ;
      A597MigrLegCUIL = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrlegporcuil__default(),
         new Object[] {
             new Object[] {
            P027J2_A597MigrLegCUIL, P027J2_A1EmpCod, P027J2_A3CliCod, P027J2_A87MigrLegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV8MigrLegNumero ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private String AV11MigrLegCUIL ;
   private String scmdbuf ;
   private String A597MigrLegCUIL ;
   private int[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P027J2_A597MigrLegCUIL ;
   private short[] P027J2_A1EmpCod ;
   private int[] P027J2_A3CliCod ;
   private int[] P027J2_A87MigrLegNumero ;
}

final  class getmigrlegporcuil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027J2", "SELECT MigrLegCUIL, EmpCod, CliCod, MigrLegNumero FROM importacion_legajo WHERE (CliCod = ? and EmpCod = ?) AND (MigrLegCUIL = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 13);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setString(3, (String)parms[2], 13);
               return;
      }
   }

}

