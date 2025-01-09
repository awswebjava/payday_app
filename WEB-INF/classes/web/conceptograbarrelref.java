package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptograbarrelref extends GXProcedure
{
   public conceptograbarrelref( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptograbarrelref.class ), "" );
   }

   public conceptograbarrelref( int remoteHandle ,
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
      conceptograbarrelref.this.AV8CliCod = aP0;
      conceptograbarrelref.this.AV10ConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01XM2_A26ConCodigo[0] ;
         A3CliCod = P01XM2_A3CliCod[0] ;
         A1886ConRelSec = P01XM2_A1886ConRelSec[0] ;
         A2013ConRelRef = P01XM2_A2013ConRelRef[0] ;
         GXv_char1[0] = AV9CliRelNombre ;
         new web.getclirelnombre(remoteHandle, context).execute( A3CliCod, A1886ConRelSec, GXv_char1) ;
         conceptograbarrelref.this.AV9CliRelNombre = GXv_char1[0] ;
         A2013ConRelRef = AV9CliRelNombre ;
         /* Using cursor P01XM3 */
         pr_default.execute(1, new Object[] {A2013ConRelRef, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "conceptograbarrelref");
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
      P01XM2_A26ConCodigo = new String[] {""} ;
      P01XM2_A3CliCod = new int[1] ;
      P01XM2_A1886ConRelSec = new int[1] ;
      P01XM2_A2013ConRelRef = new String[] {""} ;
      A26ConCodigo = "" ;
      A2013ConRelRef = "" ;
      AV9CliRelNombre = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptograbarrelref__default(),
         new Object[] {
             new Object[] {
            P01XM2_A26ConCodigo, P01XM2_A3CliCod, P01XM2_A1886ConRelSec, P01XM2_A2013ConRelRef
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
   private int A1886ConRelSec ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String GXv_char1[] ;
   private String A2013ConRelRef ;
   private String AV9CliRelNombre ;
   private IDataStoreProvider pr_default ;
   private String[] P01XM2_A26ConCodigo ;
   private int[] P01XM2_A3CliCod ;
   private int[] P01XM2_A1886ConRelSec ;
   private String[] P01XM2_A2013ConRelRef ;
}

final  class conceptograbarrelref__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XM2", "SELECT ConCodigo, CliCod, ConRelSec, ConRelRef FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01XM3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConRelRef=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

