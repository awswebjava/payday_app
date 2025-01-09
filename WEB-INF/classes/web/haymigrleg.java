package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haymigrleg extends GXProcedure
{
   public haymigrleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haymigrleg.class ), "" );
   }

   public haymigrleg( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      haymigrleg.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      haymigrleg.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00NL2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00NL2_A3CliCod[0] ;
         A1EmpCod = P00NL2_A1EmpCod[0] ;
         A87MigrLegNumero = P00NL2_A87MigrLegNumero[0] ;
         AV8hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = haymigrleg.this.AV8hay;
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
      P00NL2_A3CliCod = new int[1] ;
      P00NL2_A1EmpCod = new short[1] ;
      P00NL2_A87MigrLegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haymigrleg__default(),
         new Object[] {
             new Object[] {
            P00NL2_A3CliCod, P00NL2_A1EmpCod, P00NL2_A87MigrLegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short Gx_err ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private String scmdbuf ;
   private boolean AV8hay ;
   private boolean[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00NL2_A3CliCod ;
   private short[] P00NL2_A1EmpCod ;
   private int[] P00NL2_A87MigrLegNumero ;
}

final  class haymigrleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00NL2", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo ORDER BY CliCod, EmpCod, MigrLegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

