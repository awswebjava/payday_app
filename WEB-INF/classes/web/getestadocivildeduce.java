package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadocivildeduce extends GXProcedure
{
   public getestadocivildeduce( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadocivildeduce.class ), "" );
   }

   public getestadocivildeduce( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 )
   {
      getestadocivildeduce.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             boolean[] aP1 )
   {
      getestadocivildeduce.this.AV9EstaCivilCod = aP0;
      getestadocivildeduce.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02AR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9EstaCivilCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1748EstaCivilCod = P02AR2_A1748EstaCivilCod[0] ;
         A2272EstaCivilCasadoEs = P02AR2_A2272EstaCivilCasadoEs[0] ;
         AV8EstaCivilCasadoEs = A2272EstaCivilCasadoEs ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getestadocivildeduce.this.AV8EstaCivilCasadoEs;
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
      P02AR2_A1748EstaCivilCod = new short[1] ;
      P02AR2_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadocivildeduce__default(),
         new Object[] {
             new Object[] {
            P02AR2_A1748EstaCivilCod, P02AR2_A2272EstaCivilCasadoEs
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EstaCivilCod ;
   private short A1748EstaCivilCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV8EstaCivilCasadoEs ;
   private boolean A2272EstaCivilCasadoEs ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P02AR2_A1748EstaCivilCod ;
   private boolean[] P02AR2_A2272EstaCivilCasadoEs ;
}

final  class getestadocivildeduce__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AR2", "SELECT EstaCivilCod, EstaCivilCasadoEs FROM Estados_civiles WHERE EstaCivilCod = ? ORDER BY EstaCivilCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

