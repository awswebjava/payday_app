package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocar_rest_conreplica extends GXProcedure
{
   public invocar_rest_conreplica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocar_rest_conreplica.class ), "" );
   }

   public invocar_rest_conreplica( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      invocar_rest_conreplica.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        String aP3 ,
                        boolean[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             String aP3 ,
                             boolean[] aP4 ,
                             String[] aP5 )
   {
      invocar_rest_conreplica.this.AV11CliCod = aP0;
      invocar_rest_conreplica.this.AV40RestLocId = aP1;
      invocar_rest_conreplica.this.AV51replicaNro = aP2;
      invocar_rest_conreplica.this.AV10body = aP3;
      invocar_rest_conreplica.this.aP4 = aP4;
      invocar_rest_conreplica.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV40RestLocId, httpContext.getMessage( "CalcDepLSD", "")) == 0 )
      {
         GXt_char1 = AV52liqModoPalabra ;
         GXt_char2 = AV52liqModoPalabra ;
         GXv_char3[0] = GXt_char2 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char3) ;
         invocar_rest_conreplica.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
         invocar_rest_conreplica.this.GXt_char1 = GXv_char4[0] ;
         AV52liqModoPalabra = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV40RestLocId, httpContext.getMessage( "CalcContr ", "")) == 0 )
      {
         GXt_char2 = AV52liqModoPalabra ;
         GXt_char1 = AV52liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_contr", GXv_char4) ;
         invocar_rest_conreplica.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char3) ;
         invocar_rest_conreplica.this.GXt_char2 = GXv_char3[0] ;
         AV52liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV40RestLocId, httpContext.getMessage( "CalcOtros", "")) == 0 )
      {
         GXt_char2 = AV52liqModoPalabra ;
         GXt_char1 = AV52liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_otros", GXv_char4) ;
         invocar_rest_conreplica.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char3) ;
         invocar_rest_conreplica.this.GXt_char2 = GXv_char3[0] ;
         AV52liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV40RestLocId, httpContext.getMessage( "GenRecibos", "")) == 0 )
      {
         GXt_char2 = AV52liqModoPalabra ;
         GXt_char1 = AV52liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char4) ;
         invocar_rest_conreplica.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char3) ;
         invocar_rest_conreplica.this.GXt_char2 = GXv_char3[0] ;
         AV52liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV40RestLocId, httpContext.getMessage( "GuardaLiquidacion_rest", "")) == 0 )
      {
         GXt_char2 = AV52liqModoPalabra ;
         GXt_char1 = AV52liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char4) ;
         invocar_rest_conreplica.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char3) ;
         invocar_rest_conreplica.this.GXt_char2 = GXv_char3[0] ;
         AV52liqModoPalabra = GXt_char2 ;
      }
      if ( GXutil.strcmp(AV52liqModoPalabra, httpContext.getMessage( "DOCKER", "")) == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV56Pgmname, "1") ;
         GXv_boolean5[0] = AV38RestLocHab ;
         GXv_char4[0] = AV36RestLocBaseUrl ;
         GXv_int6[0] = AV37RestLocCancelOnError ;
         GXv_char3[0] = AV39RestLocHost ;
         GXv_int7[0] = AV41RestLocPort ;
         GXv_int8[0] = AV43RestLocTimeout ;
         GXv_int9[0] = AV42RestLocSecure ;
         new web.getrest_location(remoteHandle, context).execute( AV11CliCod, AV40RestLocId, AV51replicaNro, GXv_boolean5, GXv_char4, GXv_int6, GXv_char3, GXv_int7, GXv_int8, GXv_int9) ;
         invocar_rest_conreplica.this.AV38RestLocHab = GXv_boolean5[0] ;
         invocar_rest_conreplica.this.AV36RestLocBaseUrl = GXv_char4[0] ;
         invocar_rest_conreplica.this.AV37RestLocCancelOnError = GXv_int6[0] ;
         invocar_rest_conreplica.this.AV39RestLocHost = GXv_char3[0] ;
         invocar_rest_conreplica.this.AV41RestLocPort = GXv_int7[0] ;
         invocar_rest_conreplica.this.AV43RestLocTimeout = GXv_int8[0] ;
         invocar_rest_conreplica.this.AV42RestLocSecure = GXv_int9[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV56Pgmname, httpContext.getMessage( "&RestLocHab ", "")+GXutil.trim( GXutil.booltostr( AV38RestLocHab))) ;
         if ( AV38RestLocHab )
         {
            GXv_objcol_Sdthttp_headers_http_headersItem10[0] = AV17http_headers ;
            new web.headerjsonadd(remoteHandle, context).execute( GXv_objcol_Sdthttp_headers_http_headersItem10) ;
            AV17http_headers = GXv_objcol_Sdthttp_headers_http_headersItem10[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV56Pgmname, httpContext.getMessage( "ini ", "")+GXutil.trim( AV36RestLocBaseUrl)+" "+GXutil.trim( GXutil.str( AV50auxRestLocPort, 8, 0))+httpContext.getMessage( " &RestLocBaseUrl ", "")+AV36RestLocBaseUrl) ;
            GXv_char4[0] = AV35response_raw ;
            GXv_int7[0] = AV44statusCode ;
            new web.restexecute(remoteHandle, context).execute( AV39RestLocHost, AV41RestLocPort, AV42RestLocSecure, AV36RestLocBaseUrl, AV17http_headers, httpContext.getMessage( "POST", ""), AV10body, AV43RestLocTimeout, GXv_char4, GXv_int7) ;
            invocar_rest_conreplica.this.AV35response_raw = GXv_char4[0] ;
            invocar_rest_conreplica.this.AV44statusCode = GXv_int7[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV56Pgmname, httpContext.getMessage( "fin ", "")+GXutil.trim( AV36RestLocBaseUrl)+" "+GXutil.trim( GXutil.str( AV44statusCode, 8, 0))) ;
            if ( AV44statusCode != 200 )
            {
               AV15error = GXutil.trim( AV35response_raw) ;
            }
         }
         else
         {
            AV15error = httpContext.getMessage( "Está configurado para liquidar con microservicio docker y el endpoint no está configurado", "") ;
         }
      }
      else
      {
         AV38RestLocHab = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = invocar_rest_conreplica.this.AV38RestLocHab;
      this.aP5[0] = invocar_rest_conreplica.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15error = "" ;
      AV52liqModoPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      AV56Pgmname = "" ;
      GXv_boolean5 = new boolean[1] ;
      AV36RestLocBaseUrl = "" ;
      GXv_int6 = new byte[1] ;
      AV39RestLocHost = "" ;
      GXv_char3 = new String[1] ;
      GXv_int8 = new short[1] ;
      GXv_int9 = new byte[1] ;
      AV17http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem10 = new GXBaseCollection[1] ;
      AV35response_raw = "" ;
      GXv_char4 = new String[1] ;
      GXv_int7 = new int[1] ;
      AV56Pgmname = "invocar_rest_conReplica" ;
      /* GeneXus formulas. */
      AV56Pgmname = "invocar_rest_conReplica" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37RestLocCancelOnError ;
   private byte GXv_int6[] ;
   private byte AV42RestLocSecure ;
   private byte GXv_int9[] ;
   private short AV51replicaNro ;
   private short AV43RestLocTimeout ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV41RestLocPort ;
   private int AV50auxRestLocPort ;
   private int AV44statusCode ;
   private int GXv_int7[] ;
   private String AV40RestLocId ;
   private String AV52liqModoPalabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String AV56Pgmname ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private boolean AV38RestLocHab ;
   private boolean GXv_boolean5[] ;
   private String AV10body ;
   private String AV15error ;
   private String AV36RestLocBaseUrl ;
   private String AV39RestLocHost ;
   private String AV35response_raw ;
   private String[] aP5 ;
   private boolean[] aP4 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV17http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem10[] ;
}

