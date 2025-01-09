package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsoap_location extends GXProcedure
{
   public getsoap_location( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsoap_location.class ), "" );
   }

   public getsoap_location( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            String aP1 ,
                            boolean[] aP2 ,
                            String[] aP3 ,
                            byte[] aP4 ,
                            String[] aP5 ,
                            int[] aP6 ,
                            String[] aP7 ,
                            byte[] aP8 )
   {
      getsoap_location.this.aP9 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        String[] aP3 ,
                        byte[] aP4 ,
                        String[] aP5 ,
                        int[] aP6 ,
                        String[] aP7 ,
                        byte[] aP8 ,
                        short[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             String[] aP3 ,
                             byte[] aP4 ,
                             String[] aP5 ,
                             int[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 ,
                             short[] aP9 )
   {
      getsoap_location.this.AV17CliCod = aP0;
      getsoap_location.this.AV16SoapLocId = aP1;
      getsoap_location.this.aP2 = aP2;
      getsoap_location.this.aP3 = aP3;
      getsoap_location.this.aP4 = aP4;
      getsoap_location.this.aP5 = aP5;
      getsoap_location.this.aP6 = aP6;
      getsoap_location.this.aP7 = aP7;
      getsoap_location.this.aP8 = aP8;
      getsoap_location.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P024F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod), AV16SoapLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2162SoapLocId = P024F2_A2162SoapLocId[0] ;
         A3CliCod = P024F2_A3CliCod[0] ;
         A2163SoapLocHab = P024F2_A2163SoapLocHab[0] ;
         A2164SoapLocBaseUrl = P024F2_A2164SoapLocBaseUrl[0] ;
         A2165SoapLocCancelOnError = P024F2_A2165SoapLocCancelOnError[0] ;
         A2166SoapLocHost = P024F2_A2166SoapLocHost[0] ;
         A2167SoapLocPort = P024F2_A2167SoapLocPort[0] ;
         A2168SoapLocResourceName = P024F2_A2168SoapLocResourceName[0] ;
         A2169SoapLocSecure = P024F2_A2169SoapLocSecure[0] ;
         A2170SoapLocTimeout = P024F2_A2170SoapLocTimeout[0] ;
         AV16SoapLocId = A2162SoapLocId ;
         AV15SoapLocHab = A2163SoapLocHab ;
         AV14SoapLocBaseUrl = A2164SoapLocBaseUrl ;
         AV13SoapLocCancelOnError = A2165SoapLocCancelOnError ;
         AV12SoapLocHost = A2166SoapLocHost ;
         AV11SoapLocPort = A2167SoapLocPort ;
         AV10SoapLocResourceName = A2168SoapLocResourceName ;
         AV9SoapLocSecure = A2169SoapLocSecure ;
         AV8SoapLocTimeout = A2170SoapLocTimeout ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsoap_location.this.AV15SoapLocHab;
      this.aP3[0] = getsoap_location.this.AV14SoapLocBaseUrl;
      this.aP4[0] = getsoap_location.this.AV13SoapLocCancelOnError;
      this.aP5[0] = getsoap_location.this.AV12SoapLocHost;
      this.aP6[0] = getsoap_location.this.AV11SoapLocPort;
      this.aP7[0] = getsoap_location.this.AV10SoapLocResourceName;
      this.aP8[0] = getsoap_location.this.AV9SoapLocSecure;
      this.aP9[0] = getsoap_location.this.AV8SoapLocTimeout;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14SoapLocBaseUrl = "" ;
      AV12SoapLocHost = "" ;
      AV10SoapLocResourceName = "" ;
      scmdbuf = "" ;
      P024F2_A2162SoapLocId = new String[] {""} ;
      P024F2_A3CliCod = new int[1] ;
      P024F2_A2163SoapLocHab = new boolean[] {false} ;
      P024F2_A2164SoapLocBaseUrl = new String[] {""} ;
      P024F2_A2165SoapLocCancelOnError = new byte[1] ;
      P024F2_A2166SoapLocHost = new String[] {""} ;
      P024F2_A2167SoapLocPort = new int[1] ;
      P024F2_A2168SoapLocResourceName = new String[] {""} ;
      P024F2_A2169SoapLocSecure = new byte[1] ;
      P024F2_A2170SoapLocTimeout = new short[1] ;
      A2162SoapLocId = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsoap_location__default(),
         new Object[] {
             new Object[] {
            P024F2_A2162SoapLocId, P024F2_A3CliCod, P024F2_A2163SoapLocHab, P024F2_A2164SoapLocBaseUrl, P024F2_A2165SoapLocCancelOnError, P024F2_A2166SoapLocHost, P024F2_A2167SoapLocPort, P024F2_A2168SoapLocResourceName, P024F2_A2169SoapLocSecure, P024F2_A2170SoapLocTimeout
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13SoapLocCancelOnError ;
   private byte AV9SoapLocSecure ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private short AV8SoapLocTimeout ;
   private short A2170SoapLocTimeout ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int AV11SoapLocPort ;
   private int A3CliCod ;
   private int A2167SoapLocPort ;
   private String AV16SoapLocId ;
   private String scmdbuf ;
   private String A2162SoapLocId ;
   private boolean AV15SoapLocHab ;
   private boolean A2163SoapLocHab ;
   private String AV14SoapLocBaseUrl ;
   private String AV12SoapLocHost ;
   private String AV10SoapLocResourceName ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private short[] aP9 ;
   private boolean[] aP2 ;
   private String[] aP3 ;
   private byte[] aP4 ;
   private String[] aP5 ;
   private int[] aP6 ;
   private String[] aP7 ;
   private byte[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P024F2_A2162SoapLocId ;
   private int[] P024F2_A3CliCod ;
   private boolean[] P024F2_A2163SoapLocHab ;
   private String[] P024F2_A2164SoapLocBaseUrl ;
   private byte[] P024F2_A2165SoapLocCancelOnError ;
   private String[] P024F2_A2166SoapLocHost ;
   private int[] P024F2_A2167SoapLocPort ;
   private String[] P024F2_A2168SoapLocResourceName ;
   private byte[] P024F2_A2169SoapLocSecure ;
   private short[] P024F2_A2170SoapLocTimeout ;
}

final  class getsoap_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P024F2", "SELECT SoapLocId, CliCod, SoapLocHab, SoapLocBaseUrl, SoapLocCancelOnError, SoapLocHost, SoapLocPort, SoapLocResourceName, SoapLocSecure, SoapLocTimeout FROM soap_location WHERE CliCod = ? and SoapLocId = ( ?) ORDER BY CliCod, SoapLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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

