package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrmismapersona extends GXProcedure
{
   public getmigrmismapersona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrmismapersona.class ), "" );
   }

   public getmigrmismapersona( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        boolean aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             boolean aP6 )
   {
      getmigrmismapersona.this.AV8CliCod = aP0;
      getmigrmismapersona.this.AV9EmpCod = aP1;
      getmigrmismapersona.this.AV10MigrLegNumero = aP2;
      getmigrmismapersona.this.AV11MigrLegId = aP3;
      getmigrmismapersona.this.AV13MigrLegCUIL = aP4;
      getmigrmismapersona.this.AV12existeMismoId = aP5;
      getmigrmismapersona.this.AV14existeMismoCUIL = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV11MigrLegId)==0) )
      {
         /* Using cursor P00LK2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10MigrLegNumero), AV11MigrLegId});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A626MigrLegId = P00LK2_A626MigrLegId[0] ;
            A87MigrLegNumero = P00LK2_A87MigrLegNumero[0] ;
            A1EmpCod = P00LK2_A1EmpCod[0] ;
            A3CliCod = P00LK2_A3CliCod[0] ;
            AV12existeMismoId = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      if ( ! (GXutil.strcmp("", AV13MigrLegCUIL)==0) )
      {
         /* Using cursor P00LK3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10MigrLegNumero), AV13MigrLegCUIL});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A597MigrLegCUIL = P00LK3_A597MigrLegCUIL[0] ;
            A87MigrLegNumero = P00LK3_A87MigrLegNumero[0] ;
            A1EmpCod = P00LK3_A1EmpCod[0] ;
            A3CliCod = P00LK3_A3CliCod[0] ;
            AV14existeMismoCUIL = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
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
      P00LK2_A626MigrLegId = new String[] {""} ;
      P00LK2_A87MigrLegNumero = new int[1] ;
      P00LK2_A1EmpCod = new short[1] ;
      P00LK2_A3CliCod = new int[1] ;
      A626MigrLegId = "" ;
      P00LK3_A597MigrLegCUIL = new String[] {""} ;
      P00LK3_A87MigrLegNumero = new int[1] ;
      P00LK3_A1EmpCod = new short[1] ;
      P00LK3_A3CliCod = new int[1] ;
      A597MigrLegCUIL = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrmismapersona__default(),
         new Object[] {
             new Object[] {
            P00LK2_A626MigrLegId, P00LK2_A87MigrLegNumero, P00LK2_A1EmpCod, P00LK2_A3CliCod
            }
            , new Object[] {
            P00LK3_A597MigrLegCUIL, P00LK3_A87MigrLegNumero, P00LK3_A1EmpCod, P00LK3_A3CliCod
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
   private int AV10MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV11MigrLegId ;
   private String AV13MigrLegCUIL ;
   private String scmdbuf ;
   private String A626MigrLegId ;
   private String A597MigrLegCUIL ;
   private boolean AV12existeMismoId ;
   private boolean AV14existeMismoCUIL ;
   private IDataStoreProvider pr_default ;
   private String[] P00LK2_A626MigrLegId ;
   private int[] P00LK2_A87MigrLegNumero ;
   private short[] P00LK2_A1EmpCod ;
   private int[] P00LK2_A3CliCod ;
   private String[] P00LK3_A597MigrLegCUIL ;
   private int[] P00LK3_A87MigrLegNumero ;
   private short[] P00LK3_A1EmpCod ;
   private int[] P00LK3_A3CliCod ;
}

final  class getmigrmismapersona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LK2", "SELECT MigrLegId, MigrLegNumero, EmpCod, CliCod FROM importacion_legajo WHERE (CliCod = ? and EmpCod = ?) AND (MigrLegNumero <> ?) AND (MigrLegId = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00LK3", "SELECT MigrLegCUIL, MigrLegNumero, EmpCod, CliCod FROM importacion_legajo WHERE (CliCod = ? and EmpCod = ?) AND (MigrLegNumero <> ?) AND (MigrLegCUIL = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 13);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 13);
               return;
      }
   }

}

