package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setsoap_location extends GXProcedure
{
   public setsoap_location( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setsoap_location.class ), "" );
   }

   public setsoap_location( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             int aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             short aP7 )
   {
      setsoap_location.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        byte aP2 ,
                        String aP3 ,
                        int aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        short aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             int aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             short aP7 ,
                             String[] aP8 )
   {
      setsoap_location.this.AV10SoapLocId = aP0;
      setsoap_location.this.AV11SoapLocBaseUrl = aP1;
      setsoap_location.this.AV12SoapLocCancelOnError = aP2;
      setsoap_location.this.AV13SoapLocHost = aP3;
      setsoap_location.this.AV14SoapLocPort = aP4;
      setsoap_location.this.AV15SoapLocResourceName = aP5;
      setsoap_location.this.AV16SoapLocSecure = aP6;
      setsoap_location.this.AV17SoapLocTimeout = aP7;
      setsoap_location.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19locationName = GXutil.trim( AV10SoapLocId) ;
      AV8location = (com.genexus.internet.Location)SoapParm.getlocation(context, AV19locationName);
      AV8location.setBaseURL( AV11SoapLocBaseUrl );
      AV8location.setCancelOnError( AV12SoapLocCancelOnError );
      AV8location.setHost( AV13SoapLocHost );
      AV8location.setPort( AV14SoapLocPort );
      AV8location.setResourceName( AV15SoapLocResourceName );
      AV8location.setSecure( AV16SoapLocSecure );
      AV8location.setTimeout( AV17SoapLocTimeout );
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocBaseUrl: ", "")+GXutil.trim( AV11SoapLocBaseUrl)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocCancelOnError: ", "")+GXutil.trim( GXutil.str( AV12SoapLocCancelOnError, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocHost: ", "")+GXutil.trim( AV13SoapLocHost)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocPort: ", "")+GXutil.trim( GXutil.str( AV14SoapLocPort, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocResourceName: ", "")+GXutil.trim( AV15SoapLocResourceName)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocSecure: ", "")+GXutil.trim( GXutil.str( AV16SoapLocSecure, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&SoapLocTimeout: ", "")+GXutil.trim( GXutil.str( AV17SoapLocTimeout, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&&errNumber: ", "")+GXutil.trim( GXutil.str( AV20errNumber, 4, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = setsoap_location.this.AV18error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18error = "" ;
      AV19locationName = "" ;
      AV8location = new com.genexus.internet.Location();
      AV23Pgmname = "" ;
      AV23Pgmname = "setSoap_Location" ;
      /* GeneXus formulas. */
      AV23Pgmname = "setSoap_Location" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12SoapLocCancelOnError ;
   private byte AV16SoapLocSecure ;
   private short AV17SoapLocTimeout ;
   private short AV20errNumber ;
   private short Gx_err ;
   private int AV14SoapLocPort ;
   private String AV10SoapLocId ;
   private String AV19locationName ;
   private String AV23Pgmname ;
   private String AV11SoapLocBaseUrl ;
   private String AV13SoapLocHost ;
   private String AV15SoapLocResourceName ;
   private String AV18error ;
   private String[] aP8 ;
   private com.genexus.internet.Location AV8location ;
}

