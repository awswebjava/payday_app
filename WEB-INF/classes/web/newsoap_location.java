package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newsoap_location extends GXProcedure
{
   public newsoap_location( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newsoap_location.class ), "" );
   }

   public newsoap_location( int remoteHandle ,
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
                        String aP7 ,
                        byte aP8 ,
                        short aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             byte aP8 ,
                             short aP9 )
   {
      newsoap_location.this.AV8CliCod = aP0;
      newsoap_location.this.AV9SoapLocId = aP1;
      newsoap_location.this.AV10SoapLocHab = aP2;
      newsoap_location.this.AV11SoapLocBaseUrl = aP3;
      newsoap_location.this.AV12SoapLocCancelOnError = aP4;
      newsoap_location.this.AV13SoapLocHost = aP5;
      newsoap_location.this.AV14SoapLocPort = aP6;
      newsoap_location.this.AV15SoapLocResourceName = aP7;
      newsoap_location.this.AV16SoapLocSecure = aP8;
      newsoap_location.this.AV17SoapLocTimeout = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE soap_location

      */
      A3CliCod = AV8CliCod ;
      A2162SoapLocId = GXutil.trim( AV9SoapLocId) ;
      A2163SoapLocHab = AV10SoapLocHab ;
      A2164SoapLocBaseUrl = AV11SoapLocBaseUrl ;
      A2165SoapLocCancelOnError = AV12SoapLocCancelOnError ;
      A2166SoapLocHost = AV13SoapLocHost ;
      A2167SoapLocPort = AV14SoapLocPort ;
      A2168SoapLocResourceName = AV15SoapLocResourceName ;
      A2169SoapLocSecure = AV16SoapLocSecure ;
      A2170SoapLocTimeout = AV17SoapLocTimeout ;
      /* Using cursor P023S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A2162SoapLocId, Boolean.valueOf(A2163SoapLocHab), A2164SoapLocBaseUrl, Byte.valueOf(A2165SoapLocCancelOnError), A2166SoapLocHost, Integer.valueOf(A2167SoapLocPort), A2168SoapLocResourceName, Byte.valueOf(A2169SoapLocSecure), Short.valueOf(A2170SoapLocTimeout)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("soap_location");
      if ( (pr_default.getStatus(0) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newsoap_location");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2162SoapLocId = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newsoap_location__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12SoapLocCancelOnError ;
   private byte AV16SoapLocSecure ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private short AV17SoapLocTimeout ;
   private short A2170SoapLocTimeout ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14SoapLocPort ;
   private int GX_INS272 ;
   private int A3CliCod ;
   private int A2167SoapLocPort ;
   private String AV9SoapLocId ;
   private String A2162SoapLocId ;
   private String Gx_emsg ;
   private boolean AV10SoapLocHab ;
   private boolean A2163SoapLocHab ;
   private String AV11SoapLocBaseUrl ;
   private String AV13SoapLocHost ;
   private String AV15SoapLocResourceName ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private IDataStoreProvider pr_default ;
}

final  class newsoap_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P023S2", "SAVEPOINT gxupdate;INSERT INTO soap_location(CliCod, SoapLocId, SoapLocHab, SoapLocBaseUrl, SoapLocCancelOnError, SoapLocHost, SoapLocPort, SoapLocResourceName, SoapLocSecure, SoapLocTimeout) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 1000, false);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 80, false);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
      }
   }

}

