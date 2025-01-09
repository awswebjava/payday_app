package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpdfdaemon extends GXProcedure
{
   public getpdfdaemon( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpdfdaemon.class ), "" );
   }

   public getpdfdaemon( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getpdfdaemon.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getpdfdaemon.this.AV9CliCod = aP0;
      getpdfdaemon.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8liqPDFModoPalabra ;
      GXt_char2 = AV8liqPDFModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char3) ;
      getpdfdaemon.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      getpdfdaemon.this.GXt_char1 = GXv_char4[0] ;
      AV8liqPDFModoPalabra = GXt_char1 ;
      if ( GXutil.strcmp(AV8liqPDFModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
      {
         GXv_char4[0] = AV10LiqLegDaemonUUID ;
         new web.daemondisponible(remoteHandle, context).execute( AV9CliCod, "CREARPDF", GXv_char4) ;
         getpdfdaemon.this.AV10LiqLegDaemonUUID = GXv_char4[0] ;
         GXv_boolean5[0] = AV11validoEs ;
         new web.daemonvalido(remoteHandle, context).execute( AV10LiqLegDaemonUUID, false, GXv_boolean5) ;
         getpdfdaemon.this.AV11validoEs = GXv_boolean5[0] ;
         if ( ! AV11validoEs )
         {
            AV10LiqLegDaemonUUID = "" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpdfdaemon.this.AV10LiqLegDaemonUUID;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqLegDaemonUUID = "" ;
      AV8liqPDFModoPalabra = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10LiqLegDaemonUUID ;
   private String AV8liqPDFModoPalabra ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private boolean AV11validoEs ;
   private boolean GXv_boolean5[] ;
   private String[] aP1 ;
}

