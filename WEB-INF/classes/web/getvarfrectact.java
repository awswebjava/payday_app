package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getvarfrectact extends GXProcedure
{
   public getvarfrectact( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getvarfrectact.class ), "" );
   }

   public getvarfrectact( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 )
   {
      getvarfrectact.this.aP2 = new byte[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 )
   {
      getvarfrectact.this.AV8CliCod = aP0;
      getvarfrectact.this.AV9OpeCliId = aP1;
      getvarfrectact.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01UC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01UC2_A82OpeCliId[0] ;
         A3CliCod = P01UC2_A3CliCod[0] ;
         A1913VarFrecAct = P01UC2_A1913VarFrecAct[0] ;
         AV10VarFrecAct = A1913VarFrecAct ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getvarfrectact.this.AV10VarFrecAct;
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
      P01UC2_A82OpeCliId = new String[] {""} ;
      P01UC2_A3CliCod = new int[1] ;
      P01UC2_A1913VarFrecAct = new byte[1] ;
      A82OpeCliId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getvarfrectact__default(),
         new Object[] {
             new Object[] {
            P01UC2_A82OpeCliId, P01UC2_A3CliCod, P01UC2_A1913VarFrecAct
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10VarFrecAct ;
   private byte A1913VarFrecAct ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UC2_A82OpeCliId ;
   private int[] P01UC2_A3CliCod ;
   private byte[] P01UC2_A1913VarFrecAct ;
}

final  class getvarfrectact__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UC2", "SELECT OpeCliId, CliCod, VarFrecAct FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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

