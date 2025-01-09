package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getobrasociallikedescrip extends GXProcedure
{
   public getobrasociallikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getobrasociallikedescrip.class ), "" );
   }

   public getobrasociallikedescrip( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getobrasociallikedescrip.this.aP3 = new boolean[] {false};
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
      getobrasociallikedescrip.this.AV10CliCod = aP0;
      getobrasociallikedescrip.this.AV9OsoDescrip = aP1;
      getobrasociallikedescrip.this.aP2 = aP2;
      getobrasociallikedescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV9OsoDescrip = GXutil.concat( GXutil.rtrim( AV9OsoDescrip), "%", "") ;
      /* Using cursor P00M92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), lV9OsoDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A681OsoDescripSinAc = P00M92_A681OsoDescripSinAc[0] ;
         A3CliCod = P00M92_A3CliCod[0] ;
         A5OsoCod = P00M92_A5OsoCod[0] ;
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
      this.aP2[0] = getobrasociallikedescrip.this.AV8OsoCod;
      this.aP3[0] = getobrasociallikedescrip.this.AV11existe;
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
      lV9OsoDescrip = "" ;
      scmdbuf = "" ;
      P00M92_A681OsoDescripSinAc = new String[] {""} ;
      P00M92_A3CliCod = new int[1] ;
      P00M92_A5OsoCod = new String[] {""} ;
      A681OsoDescripSinAc = "" ;
      A5OsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getobrasociallikedescrip__default(),
         new Object[] {
             new Object[] {
            P00M92_A681OsoDescripSinAc, P00M92_A3CliCod, P00M92_A5OsoCod
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
   private String lV9OsoDescrip ;
   private String A681OsoDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M92_A681OsoDescripSinAc ;
   private int[] P00M92_A3CliCod ;
   private String[] P00M92_A5OsoCod ;
}

final  class getobrasociallikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M92", "SELECT OsoDescripSinAc, CliCod, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoDescripSinAc like '%' || ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

