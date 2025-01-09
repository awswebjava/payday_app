package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasocialporsigla extends GXProcedure
{
   public getobrasocialporsigla( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasocialporsigla.class ), "" );
   }

   public getobrasocialporsigla( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getobrasocialporsigla.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getobrasocialporsigla.this.AV8CliCod = aP0;
      getobrasocialporsigla.this.AV11OsoSigla = aP1;
      getobrasocialporsigla.this.aP2 = aP2;
      getobrasocialporsigla.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV11OsoSigla});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A392OsoSigla = P00LW2_A392OsoSigla[0] ;
         A3CliCod = P00LW2_A3CliCod[0] ;
         A5OsoCod = P00LW2_A5OsoCod[0] ;
         AV10OsoCod = A5OsoCod ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getobrasocialporsigla.this.AV10OsoCod;
      this.aP3[0] = getobrasocialporsigla.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10OsoCod = "" ;
      scmdbuf = "" ;
      P00LW2_A392OsoSigla = new String[] {""} ;
      P00LW2_A3CliCod = new int[1] ;
      P00LW2_A5OsoCod = new String[] {""} ;
      A392OsoSigla = "" ;
      A5OsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasocialporsigla__default(),
         new Object[] {
             new Object[] {
            P00LW2_A392OsoSigla, P00LW2_A3CliCod, P00LW2_A5OsoCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV11OsoSigla ;
   private String AV10OsoCod ;
   private String scmdbuf ;
   private String A392OsoSigla ;
   private String A5OsoCod ;
   private boolean AV9existe ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LW2_A392OsoSigla ;
   private int[] P00LW2_A3CliCod ;
   private String[] P00LW2_A5OsoCod ;
}

final  class getobrasocialporsigla__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LW2", "SELECT OsoSigla, CliCod, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoSigla = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

