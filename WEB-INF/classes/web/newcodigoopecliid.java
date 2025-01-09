package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcodigoopecliid extends GXProcedure
{
   public newcodigoopecliid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcodigoopecliid.class ), "" );
   }

   public newcodigoopecliid( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      newcodigoopecliid.this.aP2 = new String[] {""};
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
      newcodigoopecliid.this.AV8CliCod = aP0;
      newcodigoopecliid.this.AV11parmOpeCliId = aP1;
      newcodigoopecliid.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9OpeCliId = AV11parmOpeCliId ;
      AV10seguir = true ;
      AV12i = (short)(1) ;
      while ( AV10seguir )
      {
         AV15GXLvl5 = (byte)(0) ;
         /* Using cursor P00JQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A82OpeCliId = P00JQ2_A82OpeCliId[0] ;
            A3CliCod = P00JQ2_A3CliCod[0] ;
            AV15GXLvl5 = (byte)(1) ;
            AV12i = (short)(AV12i+1) ;
            AV9OpeCliId = GXutil.trim( A82OpeCliId) + GXutil.trim( GXutil.str( AV12i, 4, 0)) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV15GXLvl5 == 0 )
         {
            AV10seguir = false ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = newcodigoopecliid.this.AV9OpeCliId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9OpeCliId = "" ;
      scmdbuf = "" ;
      P00JQ2_A82OpeCliId = new String[] {""} ;
      P00JQ2_A3CliCod = new int[1] ;
      A82OpeCliId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcodigoopecliid__default(),
         new Object[] {
             new Object[] {
            P00JQ2_A82OpeCliId, P00JQ2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl5 ;
   private short AV12i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV11parmOpeCliId ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private boolean AV10seguir ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00JQ2_A82OpeCliId ;
   private int[] P00JQ2_A3CliCod ;
}

final  class newcodigoopecliid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JQ2", "SELECT OpeCliId, CliCod FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

