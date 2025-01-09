package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrest_location extends GXProcedure
{
   public getrest_location( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrest_location.class ), "" );
   }

   public getrest_location( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           short aP2 ,
                           boolean[] aP3 ,
                           String[] aP4 ,
                           byte[] aP5 ,
                           String[] aP6 ,
                           int[] aP7 ,
                           short[] aP8 )
   {
      getrest_location.this.aP9 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 ,
                        byte[] aP5 ,
                        String[] aP6 ,
                        int[] aP7 ,
                        short[] aP8 ,
                        byte[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 ,
                             byte[] aP5 ,
                             String[] aP6 ,
                             int[] aP7 ,
                             short[] aP8 ,
                             byte[] aP9 )
   {
      getrest_location.this.AV8CliCod = aP0;
      getrest_location.this.AV9RestLocId = aP1;
      getrest_location.this.AV17RestLocRNro = aP2;
      getrest_location.this.aP3 = aP3;
      getrest_location.this.aP4 = aP4;
      getrest_location.this.aP5 = aP5;
      getrest_location.this.aP6 = aP6;
      getrest_location.this.aP7 = aP7;
      getrest_location.this.aP8 = aP8;
      getrest_location.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV20Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &RestLocId \"", "")+AV9RestLocId+"\"") ;
      AV21GXLvl2 = (byte)(0) ;
      /* Using cursor P024I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9RestLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2171RestLocId = P024I2_A2171RestLocId[0] ;
         A3CliCod = P024I2_A3CliCod[0] ;
         A2172RestLocHab = P024I2_A2172RestLocHab[0] ;
         A2173RestLocBaseUrl = P024I2_A2173RestLocBaseUrl[0] ;
         A2174RestLocCancelOnError = P024I2_A2174RestLocCancelOnError[0] ;
         A2175RestLocHost = P024I2_A2175RestLocHost[0] ;
         A2176RestLocPort = P024I2_A2176RestLocPort[0] ;
         A2177RestLocTimeout = P024I2_A2177RestLocTimeout[0] ;
         A2178RestLocSecure = P024I2_A2178RestLocSecure[0] ;
         AV21GXLvl2 = (byte)(1) ;
         if ( (0==AV17RestLocRNro) )
         {
            AV10RestLocHab = A2172RestLocHab ;
            AV11RestLocBaseUrl = A2173RestLocBaseUrl ;
            AV12RestLocCancelOnError = A2174RestLocCancelOnError ;
            AV13RestLocHost = A2175RestLocHost ;
            AV14RestLocPort = A2176RestLocPort ;
            AV15RestLocTimeout = A2177RestLocTimeout ;
            AV16RestLocSecure = A2178RestLocSecure ;
         }
         else
         {
            /* Using cursor P024I3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(AV17RestLocRNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2333RestLocRNro = P024I3_A2333RestLocRNro[0] ;
               A2334RestLocRHab = P024I3_A2334RestLocRHab[0] ;
               A2335RestLocRBaseUrl = P024I3_A2335RestLocRBaseUrl[0] ;
               A2336RestLocRCancel = P024I3_A2336RestLocRCancel[0] ;
               A2337RestLocRHost = P024I3_A2337RestLocRHost[0] ;
               A2338RestLocRPort = P024I3_A2338RestLocRPort[0] ;
               A2339RestLocRTimeout = P024I3_A2339RestLocRTimeout[0] ;
               A2340RestLocRSecure = P024I3_A2340RestLocRSecure[0] ;
               AV10RestLocHab = A2334RestLocRHab ;
               AV11RestLocBaseUrl = A2335RestLocRBaseUrl ;
               AV12RestLocCancelOnError = A2336RestLocRCancel ;
               AV13RestLocHost = A2337RestLocRHost ;
               AV14RestLocPort = A2338RestLocRPort ;
               AV15RestLocTimeout = A2339RestLocRTimeout ;
               AV16RestLocSecure = A2340RestLocRSecure ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV20Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getrest_location.this.AV10RestLocHab;
      this.aP4[0] = getrest_location.this.AV11RestLocBaseUrl;
      this.aP5[0] = getrest_location.this.AV12RestLocCancelOnError;
      this.aP6[0] = getrest_location.this.AV13RestLocHost;
      this.aP7[0] = getrest_location.this.AV14RestLocPort;
      this.aP8[0] = getrest_location.this.AV15RestLocTimeout;
      this.aP9[0] = getrest_location.this.AV16RestLocSecure;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11RestLocBaseUrl = "" ;
      AV13RestLocHost = "" ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      P024I2_A2171RestLocId = new String[] {""} ;
      P024I2_A3CliCod = new int[1] ;
      P024I2_A2172RestLocHab = new boolean[] {false} ;
      P024I2_A2173RestLocBaseUrl = new String[] {""} ;
      P024I2_A2174RestLocCancelOnError = new byte[1] ;
      P024I2_A2175RestLocHost = new String[] {""} ;
      P024I2_A2176RestLocPort = new int[1] ;
      P024I2_A2177RestLocTimeout = new short[1] ;
      P024I2_A2178RestLocSecure = new byte[1] ;
      A2171RestLocId = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      P024I3_A3CliCod = new int[1] ;
      P024I3_A2171RestLocId = new String[] {""} ;
      P024I3_A2333RestLocRNro = new short[1] ;
      P024I3_A2334RestLocRHab = new boolean[] {false} ;
      P024I3_A2335RestLocRBaseUrl = new String[] {""} ;
      P024I3_A2336RestLocRCancel = new byte[1] ;
      P024I3_A2337RestLocRHost = new String[] {""} ;
      P024I3_A2338RestLocRPort = new int[1] ;
      P024I3_A2339RestLocRTimeout = new short[1] ;
      P024I3_A2340RestLocRSecure = new byte[1] ;
      A2335RestLocRBaseUrl = "" ;
      A2337RestLocRHost = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrest_location__default(),
         new Object[] {
             new Object[] {
            P024I2_A2171RestLocId, P024I2_A3CliCod, P024I2_A2172RestLocHab, P024I2_A2173RestLocBaseUrl, P024I2_A2174RestLocCancelOnError, P024I2_A2175RestLocHost, P024I2_A2176RestLocPort, P024I2_A2177RestLocTimeout, P024I2_A2178RestLocSecure
            }
            , new Object[] {
            P024I3_A3CliCod, P024I3_A2171RestLocId, P024I3_A2333RestLocRNro, P024I3_A2334RestLocRHab, P024I3_A2335RestLocRBaseUrl, P024I3_A2336RestLocRCancel, P024I3_A2337RestLocRHost, P024I3_A2338RestLocRPort, P024I3_A2339RestLocRTimeout, P024I3_A2340RestLocRSecure
            }
         }
      );
      AV20Pgmname = "getRest_Location" ;
      /* GeneXus formulas. */
      AV20Pgmname = "getRest_Location" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12RestLocCancelOnError ;
   private byte AV16RestLocSecure ;
   private byte AV21GXLvl2 ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private byte A2336RestLocRCancel ;
   private byte A2340RestLocRSecure ;
   private short AV17RestLocRNro ;
   private short AV15RestLocTimeout ;
   private short A2177RestLocTimeout ;
   private short A2333RestLocRNro ;
   private short A2339RestLocRTimeout ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14RestLocPort ;
   private int A3CliCod ;
   private int A2176RestLocPort ;
   private int A2338RestLocRPort ;
   private String AV9RestLocId ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String A2171RestLocId ;
   private boolean AV10RestLocHab ;
   private boolean A2172RestLocHab ;
   private boolean A2334RestLocRHab ;
   private String AV11RestLocBaseUrl ;
   private String AV13RestLocHost ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private String A2335RestLocRBaseUrl ;
   private String A2337RestLocRHost ;
   private byte[] aP9 ;
   private boolean[] aP3 ;
   private String[] aP4 ;
   private byte[] aP5 ;
   private String[] aP6 ;
   private int[] aP7 ;
   private short[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P024I2_A2171RestLocId ;
   private int[] P024I2_A3CliCod ;
   private boolean[] P024I2_A2172RestLocHab ;
   private String[] P024I2_A2173RestLocBaseUrl ;
   private byte[] P024I2_A2174RestLocCancelOnError ;
   private String[] P024I2_A2175RestLocHost ;
   private int[] P024I2_A2176RestLocPort ;
   private short[] P024I2_A2177RestLocTimeout ;
   private byte[] P024I2_A2178RestLocSecure ;
   private int[] P024I3_A3CliCod ;
   private String[] P024I3_A2171RestLocId ;
   private short[] P024I3_A2333RestLocRNro ;
   private boolean[] P024I3_A2334RestLocRHab ;
   private String[] P024I3_A2335RestLocRBaseUrl ;
   private byte[] P024I3_A2336RestLocRCancel ;
   private String[] P024I3_A2337RestLocRHost ;
   private int[] P024I3_A2338RestLocRPort ;
   private short[] P024I3_A2339RestLocRTimeout ;
   private byte[] P024I3_A2340RestLocRSecure ;
}

final  class getrest_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P024I2", "SELECT RestLocId, CliCod, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure FROM rest_location WHERE CliCod = ? and RestLocId = ( ?) ORDER BY CliCod, RestLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P024I3", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRCancel, RestLocRHost, RestLocRPort, RestLocRTimeout, RestLocRSecure FROM rest_locationreplicas WHERE CliCod = ? and RestLocId = ( ?) and RestLocRNro = ? ORDER BY CliCod, RestLocId, RestLocRNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

