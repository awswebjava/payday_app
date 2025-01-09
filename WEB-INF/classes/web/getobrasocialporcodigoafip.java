package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasocialporcodigoafip extends GXProcedure
{
   public getobrasocialporcodigoafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasocialporcodigoafip.class ), "" );
   }

   public getobrasocialporcodigoafip( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getobrasocialporcodigoafip.this.aP3 = new boolean[] {false};
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
      getobrasocialporcodigoafip.this.AV8CliCod = aP0;
      getobrasocialporcodigoafip.this.AV12OsoC3992 = aP1;
      getobrasocialporcodigoafip.this.aP2 = aP2;
      getobrasocialporcodigoafip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &OsoC3992 ", "")+GXutil.trim( AV12OsoC3992)) ;
      AV16GXLvl2 = (byte)(0) ;
      /* Using cursor P01MU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV12OsoC3992});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A306OsoC3992 = P01MU2_A306OsoC3992[0] ;
         n306OsoC3992 = P01MU2_n306OsoC3992[0] ;
         A3CliCod = P01MU2_A3CliCod[0] ;
         A5OsoCod = P01MU2_A5OsoCod[0] ;
         AV16GXLvl2 = (byte)(1) ;
         AV10OsoCod = A5OsoCod ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV16GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getobrasocialporcodigoafip.this.AV10OsoCod;
      this.aP3[0] = getobrasocialporcodigoafip.this.AV9existe;
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
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      P01MU2_A306OsoC3992 = new String[] {""} ;
      P01MU2_n306OsoC3992 = new boolean[] {false} ;
      P01MU2_A3CliCod = new int[1] ;
      P01MU2_A5OsoCod = new String[] {""} ;
      A306OsoC3992 = "" ;
      A5OsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasocialporcodigoafip__default(),
         new Object[] {
             new Object[] {
            P01MU2_A306OsoC3992, P01MU2_n306OsoC3992, P01MU2_A3CliCod, P01MU2_A5OsoCod
            }
         }
      );
      AV15Pgmname = "getObraSocialPorCodigoAfip" ;
      /* GeneXus formulas. */
      AV15Pgmname = "getObraSocialPorCodigoAfip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16GXLvl2 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV12OsoC3992 ;
   private String AV10OsoCod ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String A306OsoC3992 ;
   private String A5OsoCod ;
   private boolean AV9existe ;
   private boolean n306OsoC3992 ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MU2_A306OsoC3992 ;
   private boolean[] P01MU2_n306OsoC3992 ;
   private int[] P01MU2_A3CliCod ;
   private String[] P01MU2_A5OsoCod ;
}

final  class getobrasocialporcodigoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MU2", "SELECT OsoC3992, CliCod, OsoCod FROM ObraSocial WHERE CliCod = ? and OsoC3992 = ( ?) ORDER BY CliCod, OsoC3992  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
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

