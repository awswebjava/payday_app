package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclimanten extends GXProcedure
{
   public getclimanten( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclimanten.class ), "" );
   }

   public getclimanten( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      getclimanten.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      getclimanten.this.AV8CliCod = aP0;
      getclimanten.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01XP2_A3CliCod[0] ;
         A2023CliManten = P01XP2_A2023CliManten[0] ;
         AV9CliManten = A2023CliManten ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getclimanten.this.AV9CliManten;
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
      P01XP2_A3CliCod = new int[1] ;
      P01XP2_A2023CliManten = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getclimanten__default(),
         new Object[] {
             new Object[] {
            P01XP2_A3CliCod, P01XP2_A2023CliManten
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9CliManten ;
   private boolean A2023CliManten ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P01XP2_A3CliCod ;
   private boolean[] P01XP2_A2023CliManten ;
}

final  class getclimanten__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XP2", "SELECT CliCod, CliManten FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

