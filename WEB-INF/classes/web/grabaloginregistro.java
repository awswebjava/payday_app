package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaloginregistro extends GXProcedure
{
   public grabaloginregistro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaloginregistro.class ), "" );
   }

   public grabaloginregistro( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              java.util.Date aP2 )
   {
      grabaloginregistro.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             boolean[] aP3 )
   {
      grabaloginregistro.this.AV9CliCod = aP0;
      grabaloginregistro.this.AV11LogRegUsu = aP1;
      grabaloginregistro.this.AV12LogRegFec = aP2;
      grabaloginregistro.this.AV8LogRegOK = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LogIp = GXutil.trim( AV13httpRequest.getRemoteAddress()) ;
      if ( GXutil.strcmp(GXutil.trim( AV15LogIp), "0:0:0:0:0:0:0:1") != 0 )
      {
         GXv_char1[0] = AV14LogIpLocation ;
         GXv_int2[0] = 0 ;
         new web.restexecute(remoteHandle, context).execute( httpContext.getMessage( "ip-api.com", ""), 80, (short)(0), httpContext.getMessage( "/json/", "")+GXutil.trim( AV15LogIp), AV16http_headers, httpContext.getMessage( "GET", ""), "", (short)(1), GXv_char1, GXv_int2) ;
         grabaloginregistro.this.AV14LogIpLocation = GXv_char1[0] ;
      }
      /*
         INSERT RECORD ON TABLE Logins_registro

      */
      A3CliCod = AV9CliCod ;
      A1839LogRegUsu = AV11LogRegUsu ;
      A1840LogRegFec = AV12LogRegFec ;
      A1841LogRegOK = AV8LogRegOK ;
      A1920LogIp = AV15LogIp ;
      A2087LogIpLocation = AV14LogIpLocation ;
      /* Using cursor P01SW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A1839LogRegUsu, A1840LogRegFec, Boolean.valueOf(A1841LogRegOK), A1920LogIp, A2087LogIpLocation});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Logins_registro");
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
      this.aP3[0] = grabaloginregistro.this.AV8LogRegOK;
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaloginregistro");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LogIp = "" ;
      AV13httpRequest = httpContext.getHttpRequest();
      AV16http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      AV14LogIpLocation = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new int[1] ;
      A1839LogRegUsu = "" ;
      A1840LogRegFec = GXutil.resetTime( GXutil.nullDate() );
      A1920LogIp = "" ;
      A2087LogIpLocation = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaloginregistro__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int GXv_int2[] ;
   private int GX_INS250 ;
   private int A3CliCod ;
   private String GXv_char1[] ;
   private String Gx_emsg ;
   private java.util.Date AV12LogRegFec ;
   private java.util.Date A1840LogRegFec ;
   private boolean AV8LogRegOK ;
   private boolean A1841LogRegOK ;
   private String AV11LogRegUsu ;
   private String AV15LogIp ;
   private String AV14LogIpLocation ;
   private String A1839LogRegUsu ;
   private String A1920LogIp ;
   private String A2087LogIpLocation ;
   private com.genexus.internet.HttpRequest AV13httpRequest ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV16http_headers ;
}

final  class grabaloginregistro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01SW2", "SAVEPOINT gxupdate;INSERT INTO Logins_registro(CliCod, LogRegUsu, LogRegFec, LogRegOK, LogIp, LogIpLocation) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 900, false);
               return;
      }
   }

}

