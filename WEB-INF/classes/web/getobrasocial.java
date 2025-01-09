package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasocial extends GXProcedure
{
   public getobrasocial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasocial.class ), "" );
   }

   public getobrasocial( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getobrasocial.this.aP3 = new boolean[] {false};
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
      getobrasocial.this.AV10CliCod = aP0;
      getobrasocial.this.AV8OsoCod = aP1;
      getobrasocial.this.aP2 = aP2;
      getobrasocial.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8OsoCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A5OsoCod = P00AI2_A5OsoCod[0] ;
         A3CliCod = P00AI2_A3CliCod[0] ;
         A307OsoDescrip = P00AI2_A307OsoDescrip[0] ;
         AV9OsoDescrip = A307OsoDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getobrasocial.this.AV9OsoDescrip;
      this.aP3[0] = getobrasocial.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9OsoDescrip = "" ;
      scmdbuf = "" ;
      P00AI2_A5OsoCod = new String[] {""} ;
      P00AI2_A3CliCod = new int[1] ;
      P00AI2_A307OsoDescrip = new String[] {""} ;
      A5OsoCod = "" ;
      A307OsoDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasocial__default(),
         new Object[] {
             new Object[] {
            P00AI2_A5OsoCod, P00AI2_A3CliCod, P00AI2_A307OsoDescrip
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
   private String A307OsoDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AI2_A5OsoCod ;
   private int[] P00AI2_A3CliCod ;
   private String[] P00AI2_A307OsoDescrip ;
}

final  class getobrasocial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AI2", "SELECT OsoCod, CliCod, OsoDescrip FROM ObraSocial WHERE CliCod = ? and OsoCod = ( ?) ORDER BY CliCod, OsoCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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

