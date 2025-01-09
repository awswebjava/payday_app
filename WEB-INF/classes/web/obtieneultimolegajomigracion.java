package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtieneultimolegajomigracion extends GXProcedure
{
   public obtieneultimolegajomigracion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtieneultimolegajomigracion.class ), "" );
   }

   public obtieneultimolegajomigracion( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 )
   {
      obtieneultimolegajomigracion.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int[] aP2 )
   {
      obtieneultimolegajomigracion.this.AV8CliCod = aP0;
      obtieneultimolegajomigracion.this.AV9EmpCod = aP1;
      obtieneultimolegajomigracion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00L72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P00L72_A1EmpCod[0] ;
         A3CliCod = P00L72_A3CliCod[0] ;
         A87MigrLegNumero = P00L72_A87MigrLegNumero[0] ;
         AV11MigrLegNumero = A87MigrLegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = obtieneultimolegajomigracion.this.AV11MigrLegNumero;
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
      P00L72_A1EmpCod = new short[1] ;
      P00L72_A3CliCod = new int[1] ;
      P00L72_A87MigrLegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtieneultimolegajomigracion__default(),
         new Object[] {
             new Object[] {
            P00L72_A1EmpCod, P00L72_A3CliCod, P00L72_A87MigrLegNumero
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
   private int AV11MigrLegNumero ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private String scmdbuf ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00L72_A1EmpCod ;
   private int[] P00L72_A3CliCod ;
   private int[] P00L72_A87MigrLegNumero ;
}

final  class obtieneultimolegajomigracion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00L72", "SELECT EmpCod, CliCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, MigrLegNumero DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

