package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variablevalorgrabarrelref extends GXProcedure
{
   public variablevalorgrabarrelref( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablevalorgrabarrelref.class ), "" );
   }

   public variablevalorgrabarrelref( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 )
   {
      variablevalorgrabarrelref.this.AV8CliCod = aP0;
      variablevalorgrabarrelref.this.AV9OpeCliId = aP1;
      variablevalorgrabarrelref.this.AV11OpeCliVig = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01WC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId, AV11OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P01WC2_A754OpeCliVig[0] ;
         A82OpeCliId = P01WC2_A82OpeCliId[0] ;
         A3CliCod = P01WC2_A3CliCod[0] ;
         A1890OpeCliRelSec = P01WC2_A1890OpeCliRelSec[0] ;
         A2010OpeCliVRelRef = P01WC2_A2010OpeCliVRelRef[0] ;
         GXv_char1[0] = AV10CliRelNombre ;
         new web.getclirelnombre(remoteHandle, context).execute( A3CliCod, A1890OpeCliRelSec, GXv_char1) ;
         variablevalorgrabarrelref.this.AV10CliRelNombre = GXv_char1[0] ;
         A2010OpeCliVRelRef = AV10CliRelNombre ;
         /* Using cursor P01WC3 */
         pr_default.execute(1, new Object[] {A2010OpeCliVRelRef, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "variablevalorgrabarrelref");
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
      P01WC2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01WC2_A82OpeCliId = new String[] {""} ;
      P01WC2_A3CliCod = new int[1] ;
      P01WC2_A1890OpeCliRelSec = new int[1] ;
      P01WC2_A2010OpeCliVRelRef = new String[] {""} ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      A2010OpeCliVRelRef = "" ;
      AV10CliRelNombre = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablevalorgrabarrelref__default(),
         new Object[] {
             new Object[] {
            P01WC2_A754OpeCliVig, P01WC2_A82OpeCliId, P01WC2_A3CliCod, P01WC2_A1890OpeCliRelSec, P01WC2_A2010OpeCliVRelRef
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
   private int A1890OpeCliRelSec ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String GXv_char1[] ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private String A2010OpeCliVRelRef ;
   private String AV10CliRelNombre ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01WC2_A754OpeCliVig ;
   private String[] P01WC2_A82OpeCliId ;
   private int[] P01WC2_A3CliCod ;
   private int[] P01WC2_A1890OpeCliRelSec ;
   private String[] P01WC2_A2010OpeCliVRelRef ;
}

final  class variablevalorgrabarrelref__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WC2", "SELECT OpeCliVig, OpeCliId, CliCod, OpeCliRelSec, OpeCliVRelRef FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) and OpeCliVig = ? ORDER BY CliCod, OpeCliId, OpeCliVig  FOR UPDATE OF variable_valores",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WC3", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliVRelRef=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

