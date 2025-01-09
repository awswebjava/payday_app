package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasocialpordescrip extends GXProcedure
{
   public getobrasocialpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasocialpordescrip.class ), "" );
   }

   public getobrasocialpordescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getobrasocialpordescrip.this.aP3 = new boolean[] {false};
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
      getobrasocialpordescrip.this.AV10CliCod = aP0;
      getobrasocialpordescrip.this.AV9OsoDescrip = aP1;
      getobrasocialpordescrip.this.aP2 = aP2;
      getobrasocialpordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9OsoDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A681OsoDescripSinAc = P00LX2_A681OsoDescripSinAc[0] ;
         A3CliCod = P00LX2_A3CliCod[0] ;
         A5OsoCod = P00LX2_A5OsoCod[0] ;
         AV8OsoCod = A5OsoCod ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getobrasocialpordescrip.this.AV8OsoCod;
      this.aP3[0] = getobrasocialpordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OsoCod = "" ;
      scmdbuf = "" ;
      P00LX2_A681OsoDescripSinAc = new String[] {""} ;
      P00LX2_A3CliCod = new int[1] ;
      P00LX2_A5OsoCod = new String[] {""} ;
      A681OsoDescripSinAc = "" ;
      A5OsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasocialpordescrip__default(),
         new Object[] {
             new Object[] {
            P00LX2_A681OsoDescripSinAc, P00LX2_A3CliCod, P00LX2_A5OsoCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8OsoCod ;
   private String scmdbuf ;
   private String A5OsoCod ;
   private boolean AV11existe ;
   private String AV9OsoDescrip ;
   private String A681OsoDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LX2_A681OsoDescripSinAc ;
   private int[] P00LX2_A3CliCod ;
   private String[] P00LX2_A5OsoCod ;
}

final  class getobrasocialpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LX2", "SELECT OsoDescripSinAc, CliCod, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoDescripSinAc = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

