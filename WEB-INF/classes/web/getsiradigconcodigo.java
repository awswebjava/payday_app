package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsiradigconcodigo extends GXProcedure
{
   public getsiradigconcodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsiradigconcodigo.class ), "" );
   }

   public getsiradigconcodigo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      getsiradigconcodigo.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getsiradigconcodigo.this.AV8CliCod = aP0;
      getsiradigconcodigo.this.AV9SiraTipo = aP1;
      getsiradigconcodigo.this.AV10SiraCodigo = aP2;
      getsiradigconcodigo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01AZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9SiraTipo, AV10SiraCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1102SiraCodigo = P01AZ2_A1102SiraCodigo[0] ;
         A1101SiraTipo = P01AZ2_A1101SiraTipo[0] ;
         A3CliCod = P01AZ2_A3CliCod[0] ;
         A1100SiraConCodigo = P01AZ2_A1100SiraConCodigo[0] ;
         AV11SiraConCodigo = A1100SiraConCodigo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getsiradigconcodigo.this.AV11SiraConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11SiraConCodigo = "" ;
      scmdbuf = "" ;
      P01AZ2_A1102SiraCodigo = new String[] {""} ;
      P01AZ2_A1101SiraTipo = new String[] {""} ;
      P01AZ2_A3CliCod = new int[1] ;
      P01AZ2_A1100SiraConCodigo = new String[] {""} ;
      A1102SiraCodigo = "" ;
      A1101SiraTipo = "" ;
      A1100SiraConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsiradigconcodigo__default(),
         new Object[] {
             new Object[] {
            P01AZ2_A1102SiraCodigo, P01AZ2_A1101SiraTipo, P01AZ2_A3CliCod, P01AZ2_A1100SiraConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9SiraTipo ;
   private String AV10SiraCodigo ;
   private String AV11SiraConCodigo ;
   private String scmdbuf ;
   private String A1102SiraCodigo ;
   private String A1101SiraTipo ;
   private String A1100SiraConCodigo ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01AZ2_A1102SiraCodigo ;
   private String[] P01AZ2_A1101SiraTipo ;
   private int[] P01AZ2_A3CliCod ;
   private String[] P01AZ2_A1100SiraConCodigo ;
}

final  class getsiradigconcodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AZ2", "SELECT SiraCodigo, SiraTipo, CliCod, SiraConCodigo FROM siradig_codigos WHERE CliCod = ? and SiraTipo = ( ?) and SiraCodigo = ( ?) ORDER BY CliCod, SiraTipo, SiraCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
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
      }
   }

}

