package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocarnotificacion extends GXProcedure
{
   public invocarnotificacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocarnotificacion.class ), "" );
   }

   public invocarnotificacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      invocarnotificacion.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      invocarnotificacion.this.AV8CliCod = aP0;
      invocarnotificacion.this.AV13idNotificacion = aP1;
      invocarnotificacion.this.AV14mensajeNotificacion = aP2;
      invocarnotificacion.this.AV15ClientId = aP3;
      invocarnotificacion.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV11SoapLocHab ;
      GXv_char2[0] = AV12error ;
      new web.soap_location_set(remoteHandle, context).execute( AV8CliCod, new web.id_soap_notificacion(remoteHandle, context).executeUdp( ), GXv_boolean1, GXv_char2) ;
      invocarnotificacion.this.AV11SoapLocHab = GXv_boolean1[0] ;
      invocarnotificacion.this.AV12error = GXv_char2[0] ;
      if ( AV11SoapLocHab )
      {
         AV17notification_soap.execute(AV13idNotificacion, AV14mensajeNotificacion, AV15ClientId);
         AV16errNumber = context.globals.getSoapErr( ) ;
         if ( AV16errNumber != 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "GetSOAPErrMsg() ", "")+context.globals.getSoapErrMsg( )) ;
         }
      }
      if ( ! AV11SoapLocHab )
      {
         AV18NotificationInfo.setgxTv_SdtNotificationInfo_Id( AV13idNotificacion );
         AV18NotificationInfo.setgxTv_SdtNotificationInfo_Message( AV14mensajeNotificacion );
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "5 &ClientId ", "")+AV15ClientId+httpContext.getMessage( " &NotificationInfo ", "")+AV18NotificationInfo.toJSonString(false, true)) ;
         AV19ServerSocket.notifyclient(GXutil.trim( AV15ClientId), AV18NotificationInfo);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, "6") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = invocarnotificacion.this.AV12error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12error = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_char2 = new String[1] ;
      AV17notification_soap = new web.Sdtnotification_soap(remoteHandle, context);
      AV22Pgmname = "" ;
      AV18NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV19ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      AV22Pgmname = "invocarNotificacion" ;
      /* GeneXus formulas. */
      AV22Pgmname = "invocarNotificacion" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV16errNumber ;
   private String GXv_char2[] ;
   private String AV22Pgmname ;
   private boolean AV11SoapLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV13idNotificacion ;
   private String AV14mensajeNotificacion ;
   private String AV15ClientId ;
   private String AV12error ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV18NotificationInfo ;
   private String[] aP4 ;
   private web.Sdtnotification_soap AV17notification_soap ;
   private com.genexuscore.genexus.server.SdtSocket AV19ServerSocket ;
}

