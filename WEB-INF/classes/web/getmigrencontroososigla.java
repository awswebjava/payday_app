package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrencontroososigla extends GXProcedure
{
   public getmigrencontroososigla( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrencontroososigla.class ), "" );
   }

   public getmigrencontroososigla( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 )
   {
      getmigrencontroososigla.this.aP3 = new boolean[] {false};
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
      getmigrencontroososigla.this.AV11CliCod = aP0;
      getmigrencontroososigla.this.AV10EmpCod = aP1;
      getmigrencontroososigla.this.AV8MigrLegNumero = aP2;
      getmigrencontroososigla.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P00LV2_A87MigrLegNumero[0] ;
         A1EmpCod = P00LV2_A1EmpCod[0] ;
         A3CliCod = P00LV2_A3CliCod[0] ;
         A635MigrEncontroOsoSigla = P00LV2_A635MigrEncontroOsoSigla[0] ;
         AV9MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrencontroososigla.this.AV9MigrEncontroOsoSigla;
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
      P00LV2_A87MigrLegNumero = new int[1] ;
      P00LV2_A1EmpCod = new short[1] ;
      P00LV2_A3CliCod = new int[1] ;
      P00LV2_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrencontroososigla__default(),
         new Object[] {
             new Object[] {
            P00LV2_A87MigrLegNumero, P00LV2_A1EmpCod, P00LV2_A3CliCod, P00LV2_A635MigrEncontroOsoSigla
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
   private int AV8MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9MigrEncontroOsoSigla ;
   private boolean A635MigrEncontroOsoSigla ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00LV2_A87MigrLegNumero ;
   private short[] P00LV2_A1EmpCod ;
   private int[] P00LV2_A3CliCod ;
   private boolean[] P00LV2_A635MigrEncontroOsoSigla ;
}

final  class getmigrencontroososigla__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LV2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrEncontroOsoSigla FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

