package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptosreintegros extends GXProcedure
{
   public getconceptosreintegros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptosreintegros.class ), "" );
   }

   public getconceptosreintegros( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 )
   {
      getconceptosreintegros.this.aP1 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXSimpleCollection<String>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXSimpleCollection<String>[] aP1 )
   {
      getconceptosreintegros.this.AV8CliCod = aP0;
      getconceptosreintegros.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01FL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1101SiraTipo = P01FL2_A1101SiraTipo[0] ;
         A3CliCod = P01FL2_A3CliCod[0] ;
         A1100SiraConCodigo = P01FL2_A1100SiraConCodigo[0] ;
         A1102SiraCodigo = P01FL2_A1102SiraCodigo[0] ;
         AV9SiraConCodigo.add(A1100SiraConCodigo, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getconceptosreintegros.this.AV9SiraConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SiraConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01FL2_A1101SiraTipo = new String[] {""} ;
      P01FL2_A3CliCod = new int[1] ;
      P01FL2_A1100SiraConCodigo = new String[] {""} ;
      P01FL2_A1102SiraCodigo = new String[] {""} ;
      A1101SiraTipo = "" ;
      A1100SiraConCodigo = "" ;
      A1102SiraCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptosreintegros__default(),
         new Object[] {
             new Object[] {
            P01FL2_A1101SiraTipo, P01FL2_A3CliCod, P01FL2_A1100SiraConCodigo, P01FL2_A1102SiraCodigo
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
   private String A1101SiraTipo ;
   private String A1100SiraConCodigo ;
   private String A1102SiraCodigo ;
   private GXSimpleCollection<String>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01FL2_A1101SiraTipo ;
   private int[] P01FL2_A3CliCod ;
   private String[] P01FL2_A1100SiraConCodigo ;
   private String[] P01FL2_A1102SiraCodigo ;
   private GXSimpleCollection<String> AV9SiraConCodigo ;
}

final  class getconceptosreintegros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FL2", "SELECT SiraTipo, CliCod, SiraConCodigo, SiraCodigo FROM siradig_codigos WHERE CliCod = ? and SiraTipo = ( 'RTO') ORDER BY CliCod, SiraTipo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 3);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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

