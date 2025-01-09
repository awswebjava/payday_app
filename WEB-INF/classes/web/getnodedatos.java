package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnodedatos extends GXProcedure
{
   public getnodedatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnodedatos.class ), "" );
   }

   public getnodedatos( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            String aP4 ,
                            boolean aP5 ,
                            boolean aP6 ,
                            String aP7 ,
                            String[] aP8 ,
                            int[] aP9 ,
                            String[] aP10 ,
                            String[] aP11 ,
                            GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP12 )
   {
      getnodedatos.this.aP13 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        int[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP12 ,
                        short[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             int[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP12 ,
                             short[] aP13 )
   {
      getnodedatos.this.AV10CliCod = aP0;
      getnodedatos.this.AV11EmpCod = aP1;
      getnodedatos.this.AV13LegNumero = aP2;
      getnodedatos.this.AV17servicioPalabra = aP3;
      getnodedatos.this.AV15NombreArchivo = aP4;
      getnodedatos.this.AV9carpetaAURLAgregar = aP5;
      getnodedatos.this.AV19jsonHeaderAgregar = aP6;
      getnodedatos.this.AV21RestLocId = aP7;
      getnodedatos.this.aP8 = aP8;
      getnodedatos.this.aP9 = aP9;
      getnodedatos.this.aP10 = aP10;
      getnodedatos.this.aP11 = aP11;
      getnodedatos.this.aP12 = aP12;
      getnodedatos.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8a3lutilitiesHost ;
      GXv_int2[0] = (short)(AV14nodePort) ;
      new web.getnodehostyport(remoteHandle, context).execute( AV10CliCod, AV21RestLocId, GXv_char1, GXv_int2) ;
      getnodedatos.this.AV8a3lutilitiesHost = GXv_char1[0] ;
      getnodedatos.this.AV14nodePort = GXv_int2[0] ;
      GXt_char3 = AV16nombreCarpetaParaRecibosEnNode ;
      GXv_char1[0] = GXt_char3 ;
      new web.getnombrecarpetaennode(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV13LegNumero, GXv_char1) ;
      getnodedatos.this.GXt_char3 = GXv_char1[0] ;
      AV16nombreCarpetaParaRecibosEnNode = GXt_char3 ;
      GXv_boolean4[0] = AV22RestLocHab ;
      GXv_char1[0] = AV20nodeJSBasePalabra ;
      GXv_int2[0] = AV23timeOut ;
      new web.getrest_baseurlandtimeout(remoteHandle, context).execute( AV10CliCod, AV21RestLocId, (short)(0), GXv_boolean4, GXv_char1, GXv_int2) ;
      getnodedatos.this.AV22RestLocHab = GXv_boolean4[0] ;
      getnodedatos.this.AV20nodeJSBasePalabra = GXv_char1[0] ;
      getnodedatos.this.AV23timeOut = GXv_int2[0] ;
      if ( (GXutil.strcmp("", AV21RestLocId)==0) || ! AV22RestLocHab )
      {
         GXt_char3 = AV20nodeJSBasePalabra ;
         GXt_char5 = AV20nodeJSBasePalabra ;
         GXv_char1[0] = GXt_char5 ;
         new web.nodebaseurl_codigoparam(remoteHandle, context).execute( GXv_char1) ;
         getnodedatos.this.GXt_char5 = GXv_char1[0] ;
         GXv_char6[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char5, GXv_char6) ;
         getnodedatos.this.GXt_char3 = GXv_char6[0] ;
         AV20nodeJSBasePalabra = GXt_char3 ;
         AV23timeOut = (short)(0) ;
      }
      if ( GXutil.strSearch( GXutil.trim( AV20nodeJSBasePalabra), httpContext.getMessage( "web.ahttp_endpointtest", ""), 1) == 0 )
      {
         AV18urlBase = "/" + GXutil.trim( AV20nodeJSBasePalabra) + "/" + GXutil.trim( AV17servicioPalabra) ;
      }
      else
      {
         AV18urlBase = "/" + GXutil.trim( AV20nodeJSBasePalabra) ;
      }
      if ( GXutil.strSearch( GXutil.trim( AV20nodeJSBasePalabra), httpContext.getMessage( "web.ahttp_endpointtest", ""), 1) == 0 )
      {
         if ( ! AV9carpetaAURLAgregar && (GXutil.strcmp("", AV15NombreArchivo)==0) )
         {
            AV18urlBase += "/" ;
         }
         else
         {
            if ( AV9carpetaAURLAgregar )
            {
               AV18urlBase += "/" + AV16nombreCarpetaParaRecibosEnNode ;
            }
            if ( ! (GXutil.strcmp("", AV15NombreArchivo)==0) )
            {
               AV18urlBase += "/" + GXutil.trim( AV15NombreArchivo) ;
            }
         }
      }
      if ( AV19jsonHeaderAgregar )
      {
         GXv_objcol_Sdthttp_headers_http_headersItem7[0] = AV12http_headers ;
         new web.headerjsonadd(remoteHandle, context).execute( GXv_objcol_Sdthttp_headers_http_headersItem7) ;
         AV12http_headers = GXv_objcol_Sdthttp_headers_http_headersItem7[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getnodedatos.this.AV8a3lutilitiesHost;
      this.aP9[0] = getnodedatos.this.AV14nodePort;
      this.aP10[0] = getnodedatos.this.AV18urlBase;
      this.aP11[0] = getnodedatos.this.AV16nombreCarpetaParaRecibosEnNode;
      this.aP12[0] = getnodedatos.this.AV12http_headers;
      this.aP13[0] = getnodedatos.this.AV23timeOut;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8a3lutilitiesHost = "" ;
      AV18urlBase = "" ;
      AV16nombreCarpetaParaRecibosEnNode = "" ;
      AV12http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_boolean4 = new boolean[1] ;
      AV20nodeJSBasePalabra = "" ;
      GXv_int2 = new short[1] ;
      GXt_char3 = "" ;
      GXt_char5 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_objcol_Sdthttp_headers_http_headersItem7 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV23timeOut ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13LegNumero ;
   private int AV14nodePort ;
   private String AV17servicioPalabra ;
   private String AV21RestLocId ;
   private String AV20nodeJSBasePalabra ;
   private String GXt_char3 ;
   private String GXt_char5 ;
   private String GXv_char1[] ;
   private String GXv_char6[] ;
   private boolean AV9carpetaAURLAgregar ;
   private boolean AV19jsonHeaderAgregar ;
   private boolean AV22RestLocHab ;
   private boolean GXv_boolean4[] ;
   private String AV15NombreArchivo ;
   private String AV8a3lutilitiesHost ;
   private String AV18urlBase ;
   private String AV16nombreCarpetaParaRecibosEnNode ;
   private short[] aP13 ;
   private String[] aP8 ;
   private int[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem>[] aP12 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV12http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem7[] ;
}

