package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parentescoconyuge extends GXProcedure
{
   public parentescoconyuge( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parentescoconyuge.class ), "" );
   }

   public parentescoconyuge( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      parentescoconyuge.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      parentescoconyuge.this.AV8CliCod = aP0;
      parentescoconyuge.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2274ParenTipo = P00LG2_A2274ParenTipo[0] ;
         A3CliCod = P00LG2_A3CliCod[0] ;
         A30ParCod = P00LG2_A30ParCod[0] ;
         AV9ParCod = A30ParCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = parentescoconyuge.this.AV9ParCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ParCod = "" ;
      scmdbuf = "" ;
      P00LG2_A2274ParenTipo = new String[] {""} ;
      P00LG2_A3CliCod = new int[1] ;
      P00LG2_A30ParCod = new String[] {""} ;
      A2274ParenTipo = "" ;
      A30ParCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parentescoconyuge__default(),
         new Object[] {
             new Object[] {
            P00LG2_A2274ParenTipo, P00LG2_A3CliCod, P00LG2_A30ParCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ParCod ;
   private String scmdbuf ;
   private String A2274ParenTipo ;
   private String A30ParCod ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LG2_A2274ParenTipo ;
   private int[] P00LG2_A3CliCod ;
   private String[] P00LG2_A30ParCod ;
}

final  class parentescoconyuge__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LG2", "SELECT ParenTipo, CliCod, ParCod FROM Parentesco WHERE (CliCod = ?) AND (ParenTipo = ( '1')) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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

