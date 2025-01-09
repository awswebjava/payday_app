package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newrest_location extends GXProcedure
{
   public newrest_location( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newrest_location.class ), "" );
   }

   public newrest_location( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        String aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        int aP6 ,
                        short aP7 ,
                        byte aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             int aP6 ,
                             short aP7 ,
                             byte aP8 )
   {
      newrest_location.this.AV8CliCod = aP0;
      newrest_location.this.AV24RestLocId = aP1;
      newrest_location.this.AV23RestLocHab = aP2;
      newrest_location.this.AV22RestLocBaseUrl = aP3;
      newrest_location.this.AV21RestLocCancelOnError = aP4;
      newrest_location.this.AV19RestLocHost = aP5;
      newrest_location.this.AV20RestLocPort = aP6;
      newrest_location.this.AV18RestLocTimeout = aP7;
      newrest_location.this.AV25RestLocSecure = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV28GXLvl1 = (byte)(0) ;
      /* Using cursor P023W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV24RestLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2171RestLocId = P023W2_A2171RestLocId[0] ;
         A3CliCod = P023W2_A3CliCod[0] ;
         AV28GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV28GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE rest_location

         */
         A3CliCod = AV8CliCod ;
         A2171RestLocId = GXutil.trim( AV24RestLocId) ;
         A2172RestLocHab = AV23RestLocHab ;
         A2173RestLocBaseUrl = AV22RestLocBaseUrl ;
         A2174RestLocCancelOnError = AV21RestLocCancelOnError ;
         A2175RestLocHost = AV19RestLocHost ;
         A2176RestLocPort = AV20RestLocPort ;
         A2177RestLocTimeout = AV18RestLocTimeout ;
         A2178RestLocSecure = AV25RestLocSecure ;
         /* Using cursor P023W3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Boolean.valueOf(A2172RestLocHab), A2173RestLocBaseUrl, Byte.valueOf(A2174RestLocCancelOnError), A2175RestLocHost, Integer.valueOf(A2176RestLocPort), Short.valueOf(A2177RestLocTimeout), Byte.valueOf(A2178RestLocSecure)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_location");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newrest_location");
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
      P023W2_A2171RestLocId = new String[] {""} ;
      P023W2_A3CliCod = new int[1] ;
      A2171RestLocId = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newrest_location__default(),
         new Object[] {
             new Object[] {
            P023W2_A2171RestLocId, P023W2_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21RestLocCancelOnError ;
   private byte AV25RestLocSecure ;
   private byte AV28GXLvl1 ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private short AV18RestLocTimeout ;
   private short A2177RestLocTimeout ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV20RestLocPort ;
   private int A3CliCod ;
   private int GX_INS273 ;
   private int A2176RestLocPort ;
   private String AV24RestLocId ;
   private String scmdbuf ;
   private String A2171RestLocId ;
   private String Gx_emsg ;
   private boolean AV23RestLocHab ;
   private boolean A2172RestLocHab ;
   private String AV22RestLocBaseUrl ;
   private String AV19RestLocHost ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private IDataStoreProvider pr_default ;
   private String[] P023W2_A2171RestLocId ;
   private int[] P023W2_A3CliCod ;
}

final  class newrest_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P023W2", "SELECT RestLocId, CliCod FROM rest_location WHERE (CliCod = ?) AND (RestLocId = ( RTRIM(LTRIM(?)))) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P023W3", "SAVEPOINT gxupdate;INSERT INTO rest_location(CliCod, RestLocId, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 1000, false);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setVarchar(6, (String)parms[5], 200, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               return;
      }
   }

}

