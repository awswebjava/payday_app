package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siradiggrabarrelref extends GXProcedure
{
   public siradiggrabarrelref( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradiggrabarrelref.class ), "" );
   }

   public siradiggrabarrelref( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      siradiggrabarrelref.this.AV9CliCod = aP0;
      siradiggrabarrelref.this.AV8SiraTipo = aP1;
      siradiggrabarrelref.this.AV11SiraCodigo = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01WD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8SiraTipo, AV11SiraCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1102SiraCodigo = P01WD2_A1102SiraCodigo[0] ;
         A1101SiraTipo = P01WD2_A1101SiraTipo[0] ;
         A3CliCod = P01WD2_A3CliCod[0] ;
         A2006SiraRelSec = P01WD2_A2006SiraRelSec[0] ;
         n2006SiraRelSec = P01WD2_n2006SiraRelSec[0] ;
         A2022SiraRelRef = P01WD2_A2022SiraRelRef[0] ;
         n2022SiraRelRef = P01WD2_n2022SiraRelRef[0] ;
         GXv_char1[0] = AV10CliRelNombre ;
         new web.getclirelnombre(remoteHandle, context).execute( A3CliCod, A2006SiraRelSec, GXv_char1) ;
         siradiggrabarrelref.this.AV10CliRelNombre = GXv_char1[0] ;
         A2022SiraRelRef = AV10CliRelNombre ;
         n2022SiraRelRef = false ;
         /* Using cursor P01WD3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n2022SiraRelRef), A2022SiraRelRef, Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "siradiggrabarrelref");
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
      P01WD2_A1102SiraCodigo = new String[] {""} ;
      P01WD2_A1101SiraTipo = new String[] {""} ;
      P01WD2_A3CliCod = new int[1] ;
      P01WD2_A2006SiraRelSec = new int[1] ;
      P01WD2_n2006SiraRelSec = new boolean[] {false} ;
      P01WD2_A2022SiraRelRef = new String[] {""} ;
      P01WD2_n2022SiraRelRef = new boolean[] {false} ;
      A1102SiraCodigo = "" ;
      A1101SiraTipo = "" ;
      A2022SiraRelRef = "" ;
      AV10CliRelNombre = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradiggrabarrelref__default(),
         new Object[] {
             new Object[] {
            P01WD2_A1102SiraCodigo, P01WD2_A1101SiraTipo, P01WD2_A3CliCod, P01WD2_A2006SiraRelSec, P01WD2_n2006SiraRelSec, P01WD2_A2022SiraRelRef, P01WD2_n2022SiraRelRef
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int A2006SiraRelSec ;
   private String AV8SiraTipo ;
   private String AV11SiraCodigo ;
   private String scmdbuf ;
   private String A1102SiraCodigo ;
   private String A1101SiraTipo ;
   private String GXv_char1[] ;
   private boolean n2006SiraRelSec ;
   private boolean n2022SiraRelRef ;
   private String A2022SiraRelRef ;
   private String AV10CliRelNombre ;
   private IDataStoreProvider pr_default ;
   private String[] P01WD2_A1102SiraCodigo ;
   private String[] P01WD2_A1101SiraTipo ;
   private int[] P01WD2_A3CliCod ;
   private int[] P01WD2_A2006SiraRelSec ;
   private boolean[] P01WD2_n2006SiraRelSec ;
   private String[] P01WD2_A2022SiraRelRef ;
   private boolean[] P01WD2_n2022SiraRelRef ;
}

final  class siradiggrabarrelref__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WD2", "SELECT SiraCodigo, SiraTipo, CliCod, SiraRelSec, SiraRelRef FROM siradig_codigos WHERE CliCod = ? and SiraTipo = ( ?) and SiraCodigo = ( ?) ORDER BY CliCod, SiraTipo, SiraCodigo  FOR UPDATE OF siradig_codigos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WD3", "SAVEPOINT gxupdate;UPDATE siradig_codigos SET SiraRelRef=?  WHERE CliCod = ? AND SiraTipo = ? AND SiraCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 40);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 3);
               stmt.setString(4, (String)parms[4], 20);
               return;
      }
   }

}

