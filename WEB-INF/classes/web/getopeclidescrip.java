package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclidescrip extends GXProcedure
{
   public getopeclidescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclidescrip.class ), "" );
   }

   public getopeclidescrip( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getopeclidescrip.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getopeclidescrip.this.AV9CliCod = aP0;
      getopeclidescrip.this.AV10OpeCliId = aP1;
      getopeclidescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01GD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01GD2_A82OpeCliId[0] ;
         A3CliCod = P01GD2_A3CliCod[0] ;
         A534OpeCliDescrip = P01GD2_A534OpeCliDescrip[0] ;
         AV8OpeCliDescrip = A534OpeCliDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getopeclidescrip.this.AV8OpeCliDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OpeCliDescrip = "" ;
      scmdbuf = "" ;
      P01GD2_A82OpeCliId = new String[] {""} ;
      P01GD2_A3CliCod = new int[1] ;
      P01GD2_A534OpeCliDescrip = new String[] {""} ;
      A82OpeCliId = "" ;
      A534OpeCliDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclidescrip__default(),
         new Object[] {
             new Object[] {
            P01GD2_A82OpeCliId, P01GD2_A3CliCod, P01GD2_A534OpeCliDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String AV8OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GD2_A82OpeCliId ;
   private int[] P01GD2_A3CliCod ;
   private String[] P01GD2_A534OpeCliDescrip ;
}

final  class getopeclidescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GD2", "SELECT OpeCliId, CliCod, OpeCliDescrip FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

