package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variablegrabarrelref extends GXProcedure
{
   public variablegrabarrelref( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablegrabarrelref.class ), "" );
   }

   public variablegrabarrelref( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      variablegrabarrelref.this.AV8CliCod = aP0;
      variablegrabarrelref.this.AV9OpeCliId = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01WM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01WM2_A82OpeCliId[0] ;
         A3CliCod = P01WM2_A3CliCod[0] ;
         A1895VarRelSec = P01WM2_A1895VarRelSec[0] ;
         A2011VarRelRef = P01WM2_A2011VarRelRef[0] ;
         GXv_char1[0] = AV10CliRelNombre ;
         new web.getclirelnombre(remoteHandle, context).execute( A3CliCod, A1895VarRelSec, GXv_char1) ;
         variablegrabarrelref.this.AV10CliRelNombre = GXv_char1[0] ;
         A2011VarRelRef = AV10CliRelNombre ;
         /* Using cursor P01WM3 */
         pr_default.execute(1, new Object[] {A2011VarRelRef, Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "variablegrabarrelref");
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
      P01WM2_A82OpeCliId = new String[] {""} ;
      P01WM2_A3CliCod = new int[1] ;
      P01WM2_A1895VarRelSec = new int[1] ;
      P01WM2_A2011VarRelRef = new String[] {""} ;
      A82OpeCliId = "" ;
      A2011VarRelRef = "" ;
      AV10CliRelNombre = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablegrabarrelref__default(),
         new Object[] {
             new Object[] {
            P01WM2_A82OpeCliId, P01WM2_A3CliCod, P01WM2_A1895VarRelSec, P01WM2_A2011VarRelRef
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int A1895VarRelSec ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String GXv_char1[] ;
   private String A2011VarRelRef ;
   private String AV10CliRelNombre ;
   private IDataStoreProvider pr_default ;
   private String[] P01WM2_A82OpeCliId ;
   private int[] P01WM2_A3CliCod ;
   private int[] P01WM2_A1895VarRelSec ;
   private String[] P01WM2_A2011VarRelRef ;
}

final  class variablegrabarrelref__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WM2", "SELECT OpeCliId, CliCod, VarRelSec, VarRelRef FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId  FOR UPDATE OF Variable",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WM3", "SAVEPOINT gxupdate;UPDATE Variable SET VarRelRef=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
      }
   }

}

