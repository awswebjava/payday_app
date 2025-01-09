package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class soap_location_set extends GXProcedure
{
   public soap_location_set( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( soap_location_set.class ), "" );
   }

   public soap_location_set( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      soap_location_set.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             String[] aP3 )
   {
      soap_location_set.this.AV8CliCod = aP0;
      soap_location_set.this.AV9SoapLocId = aP1;
      soap_location_set.this.aP2 = aP2;
      soap_location_set.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV10SoapLocHab ;
      GXv_char2[0] = AV11SoapLocBaseUrl ;
      GXv_int3[0] = AV12SoapLocCancelOnError ;
      GXv_char4[0] = AV13SoapLocHost ;
      GXv_int5[0] = AV14SoapLocPort ;
      GXv_char6[0] = AV15SoapLocResourceName ;
      GXv_int7[0] = AV16SoapLocSecure ;
      GXv_int8[0] = AV17SoapLocTimeout ;
      new web.getsoap_location(remoteHandle, context).execute( AV8CliCod, AV9SoapLocId, GXv_boolean1, GXv_char2, GXv_int3, GXv_char4, GXv_int5, GXv_char6, GXv_int7, GXv_int8) ;
      soap_location_set.this.AV10SoapLocHab = GXv_boolean1[0] ;
      soap_location_set.this.AV11SoapLocBaseUrl = GXv_char2[0] ;
      soap_location_set.this.AV12SoapLocCancelOnError = GXv_int3[0] ;
      soap_location_set.this.AV13SoapLocHost = GXv_char4[0] ;
      soap_location_set.this.AV14SoapLocPort = GXv_int5[0] ;
      soap_location_set.this.AV15SoapLocResourceName = GXv_char6[0] ;
      soap_location_set.this.AV16SoapLocSecure = GXv_int7[0] ;
      soap_location_set.this.AV17SoapLocTimeout = GXv_int8[0] ;
      if ( AV10SoapLocHab )
      {
         GXv_char6[0] = AV18error ;
         new web.setsoap_location(remoteHandle, context).execute( AV9SoapLocId, AV11SoapLocBaseUrl, AV12SoapLocCancelOnError, AV13SoapLocHost, AV14SoapLocPort, AV15SoapLocResourceName, AV16SoapLocSecure, AV17SoapLocTimeout, GXv_char6) ;
         soap_location_set.this.AV18error = GXv_char6[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = soap_location_set.this.AV10SoapLocHab;
      this.aP3[0] = soap_location_set.this.AV18error;
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
      GXv_boolean1 = new boolean[1] ;
      AV11SoapLocBaseUrl = "" ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new byte[1] ;
      AV13SoapLocHost = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new int[1] ;
      AV15SoapLocResourceName = "" ;
      GXv_int7 = new byte[1] ;
      GXv_int8 = new short[1] ;
      GXv_char6 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12SoapLocCancelOnError ;
   private byte GXv_int3[] ;
   private byte AV16SoapLocSecure ;
   private byte GXv_int7[] ;
   private short AV17SoapLocTimeout ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14SoapLocPort ;
   private int GXv_int5[] ;
   private String AV9SoapLocId ;
   private String GXv_char2[] ;
   private String GXv_char4[] ;
   private String GXv_char6[] ;
   private boolean AV10SoapLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV18error ;
   private String AV11SoapLocBaseUrl ;
   private String AV13SoapLocHost ;
   private String AV15SoapLocResourceName ;
   private String[] aP3 ;
   private boolean[] aP2 ;
}

