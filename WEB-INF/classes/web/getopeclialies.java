package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclialies extends GXProcedure
{
   public getopeclialies( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclialies.class ), "" );
   }

   public getopeclialies( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      getopeclialies.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      getopeclialies.this.AV8CliCod = aP0;
      getopeclialies.this.AV9OpeCliId = aP1;
      getopeclialies.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P022J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P022J2_A82OpeCliId[0] ;
         A3CliCod = P022J2_A3CliCod[0] ;
         A934OpeCliAliEs = P022J2_A934OpeCliAliEs[0] ;
         AV10OpeCliAliEs = A934OpeCliAliEs ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getopeclialies.this.AV10OpeCliAliEs;
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
      P022J2_A82OpeCliId = new String[] {""} ;
      P022J2_A3CliCod = new int[1] ;
      P022J2_A934OpeCliAliEs = new boolean[] {false} ;
      A82OpeCliId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclialies__default(),
         new Object[] {
             new Object[] {
            P022J2_A82OpeCliId, P022J2_A3CliCod, P022J2_A934OpeCliAliEs
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private boolean AV10OpeCliAliEs ;
   private boolean A934OpeCliAliEs ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P022J2_A82OpeCliId ;
   private int[] P022J2_A3CliCod ;
   private boolean[] P022J2_A934OpeCliAliEs ;
}

final  class getopeclialies__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P022J2", "SELECT OpeCliId, CliCod, OpeCliAliEs FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

