package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armaurlrecibopdf extends GXProcedure
{
   public armaurlrecibopdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armaurlrecibopdf.class ), "" );
   }

   public armaurlrecibopdf( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             String[] aP7 )
   {
      armaurlrecibopdf.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        boolean aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      armaurlrecibopdf.this.AV8CliCod = aP0;
      armaurlrecibopdf.this.AV9EmpCod = aP1;
      armaurlrecibopdf.this.AV11LiqNro = aP2;
      armaurlrecibopdf.this.AV10LegNumero = aP3;
      armaurlrecibopdf.this.AV13tipoRecibo = aP4;
      armaurlrecibopdf.this.AV24soloCrearHTML = aP5;
      armaurlrecibopdf.this.AV44liquidando = aP6;
      armaurlrecibopdf.this.aP7 = aP7;
      armaurlrecibopdf.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV43modoPDFPalabra ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.metodoinvocapdf_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      armaurlrecibopdf.this.AV43modoPDFPalabra = GXv_char1[0] ;
      GXv_char1[0] = AV53imprimirLiqLeg ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      armaurlrecibopdf.this.AV53imprimirLiqLeg = GXv_char1[0] ;
      if ( ! AV24soloCrearHTML )
      {
         GXv_char1[0] = AV22nombreArchivoGenerado ;
         new web.liqleggetnombrearchivopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV13tipoRecibo, GXv_char1) ;
         armaurlrecibopdf.this.AV22nombreArchivoGenerado = GXv_char1[0] ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "!&nombreArchivoGenerado ", "")+AV22nombreArchivoGenerado+httpContext.getMessage( " &soloCrearHTML ", "")+GXutil.trim( GXutil.booltostr( AV24soloCrearHTML))) ;
      if ( (GXutil.strcmp("", AV22nombreArchivoGenerado)==0) )
      {
         AV30existe = false ;
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, "1") ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, "2") ;
         GXv_char1[0] = AV33LiqLinkS3Html ;
         new web.getlinks3recibo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV13tipoRecibo, GXv_char1) ;
         armaurlrecibopdf.this.AV33LiqLinkS3Html = GXv_char1[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "&LiqLinkS3Html ", "")+AV33LiqLinkS3Html) ;
         if ( ! (GXutil.strcmp("", AV33LiqLinkS3Html)==0) )
         {
            AV30existe = true ;
         }
         else
         {
            AV30existe = false ;
         }
      }
      if ( ! AV30existe )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "No existe Archivo ", "")+GXutil.trim( AV17rutaArchivo)+httpContext.getMessage( ", lo crea ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &nombreArchivoGenerado ", "")+AV22nombreArchivoGenerado) ;
         if ( ! (0==AV10LegNumero) )
         {
            AV23legNumeros.add((int)(AV10LegNumero), 0);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "agrega", "")) ;
         }
         else
         {
            GXv_objcol_int2[0] = AV23legNumeros ;
            new web.getliqlegnumeros(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, true, GXv_objcol_int2) ;
            AV23legNumeros = GXv_objcol_int2[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "agrega muchos", "")) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "agregó &legNumeros ", "")+AV23legNumeros.toJSonString(false)) ;
         GXv_boolean3[0] = AV21falloGeneracionPDF ;
         GXv_char1[0] = AV19error ;
         GXv_char4[0] = AV20rutaArchivoGenerada ;
         GXv_char5[0] = AV22nombreArchivoGenerado ;
         new web.crearrecibopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV23legNumeros, AV13tipoRecibo, AV24soloCrearHTML, AV43modoPDFPalabra, AV53imprimirLiqLeg, AV44liquidando, GXv_boolean3, GXv_char1, GXv_char4, GXv_char5) ;
         armaurlrecibopdf.this.AV21falloGeneracionPDF = GXv_boolean3[0] ;
         armaurlrecibopdf.this.AV19error = GXv_char1[0] ;
         armaurlrecibopdf.this.AV20rutaArchivoGenerada = GXv_char4[0] ;
         armaurlrecibopdf.this.AV22nombreArchivoGenerado = GXv_char5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( " fallo ", "")+GXutil.trim( GXutil.booltostr( AV21falloGeneracionPDF))+httpContext.getMessage( " nombre ", "")+AV22nombreArchivoGenerado+httpContext.getMessage( " &soloCrearHTML ", "")+GXutil.trim( GXutil.booltostr( AV24soloCrearHTML))+httpContext.getMessage( " &rutaArchivoGenerada ", "")+AV20rutaArchivoGenerada+httpContext.getMessage( " &nombreArchivoGenerado ", "")+AV22nombreArchivoGenerado) ;
         if ( ! AV24soloCrearHTML && ( GXutil.strcmp(AV43modoPDFPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) )
         {
            if ( AV21falloGeneracionPDF )
            {
               new web.liqgrabarutapdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV13tipoRecibo, "", "") ;
            }
            else
            {
               new web.liqgrabarutapdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV13tipoRecibo, AV20rutaArchivoGenerada, AV22nombreArchivoGenerado) ;
            }
         }
      }
      else
      {
      }
      if ( ! AV44liquidando || ( ( GXutil.strcmp(AV43modoPDFPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(AV53imprimirLiqLeg, httpContext.getMessage( "MASIVO", "")) == 0 ) ) )
      {
         GXv_char5[0] = AV28ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.s3presigexpiracion_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         armaurlrecibopdf.this.AV28ParmValue = GXv_char5[0] ;
         AV40expiresSeg = (short)(GXutil.lval( AV28ParmValue)) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "expiereseg ", "")+GXutil.trim( GXutil.str( AV40expiresSeg, 4, 0))) ;
         if ( (0==AV40expiresSeg) )
         {
            GXv_char5[0] = AV14URLRecibo ;
            new web.geturlbases3(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "PDF", ""), GXv_char5) ;
            armaurlrecibopdf.this.AV14URLRecibo = GXv_char5[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "ini ", "")+AV14URLRecibo) ;
            GXv_char5[0] = AV32rutaRelativaUploads ;
            new web.getnombrecarpetaennode(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_char5) ;
            armaurlrecibopdf.this.AV32rutaRelativaUploads = GXv_char5[0] ;
            AV14URLRecibo += "/" + GXutil.trim( AV32rutaRelativaUploads) + "/" + GXutil.trim( AV22nombreArchivoGenerado) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "despues ", "")+AV14URLRecibo) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "&nombreArchivoGenerado ", "")+AV22nombreArchivoGenerado) ;
         }
         else
         {
            GXv_char5[0] = AV25a3lutilitiesHost ;
            GXv_int6[0] = AV26nodePort ;
            GXv_char4[0] = AV36urlBase ;
            GXv_char1[0] = AV32rutaRelativaUploads ;
            GXv_objcol_Sdthttp_headers_http_headersItem7[0] = AV35http_headers ;
            GXv_int8[0] = AV55timeOutRest ;
            new web.getnodedatos(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXutil.trim( new web.geturlpresig(remoteHandle, context).executeUdp( )), "", false, true, "", GXv_char5, GXv_int6, GXv_char4, GXv_char1, GXv_objcol_Sdthttp_headers_http_headersItem7, GXv_int8) ;
            armaurlrecibopdf.this.AV25a3lutilitiesHost = GXv_char5[0] ;
            armaurlrecibopdf.this.AV26nodePort = GXv_int6[0] ;
            armaurlrecibopdf.this.AV36urlBase = GXv_char4[0] ;
            armaurlrecibopdf.this.AV32rutaRelativaUploads = GXv_char1[0] ;
            AV35http_headers = GXv_objcol_Sdthttp_headers_http_headersItem7[0] ;
            armaurlrecibopdf.this.AV55timeOutRest = GXv_int8[0] ;
            GXv_char5[0] = AV28ParmValue ;
            new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.bucketnamepdf_codigo(remoteHandle, context).executeUdp( ), GXv_char5) ;
            armaurlrecibopdf.this.AV28ParmValue = GXv_char5[0] ;
            AV34bodyTexto = httpContext.getMessage( "{\"bucketName\":\"", "") + GXutil.trim( AV28ParmValue) + httpContext.getMessage( "\",\"fileKey\":\"", "") + AV32rutaRelativaUploads + "/" + GXutil.trim( AV22nombreArchivoGenerado) + httpContext.getMessage( "\", \"expiresSeg\":", "") + GXutil.trim( GXutil.str( AV40expiresSeg, 4, 0)) + "}" ;
            GXv_char5[0] = AV37response_raw ;
            GXv_int6[0] = AV38statusCode ;
            new web.restexecute(remoteHandle, context).execute( AV25a3lutilitiesHost, AV26nodePort, (short)(0), AV36urlBase, AV35http_headers, httpContext.getMessage( "POST", ""), AV34bodyTexto, AV55timeOutRest, GXv_char5, GXv_int6) ;
            armaurlrecibopdf.this.AV37response_raw = GXv_char5[0] ;
            armaurlrecibopdf.this.AV38statusCode = (short)((short)(GXv_int6[0])) ;
            if ( AV38statusCode != 200 )
            {
               AV19error = GXutil.trim( AV37response_raw) ;
            }
            else
            {
               AV39responseUrlPresig.fromJSonString(AV37response_raw, null);
               if ( ( GXutil.strSearch( AV39responseUrlPresig.getgxTv_SdtresponseUrlPresig_Message(), httpContext.getMessage( "Error", ""), 1) != 0 ) || (GXutil.strcmp("", AV39responseUrlPresig.getgxTv_SdtresponseUrlPresig_Url())==0) )
               {
                  if ( GXutil.strSearch( AV39responseUrlPresig.getgxTv_SdtresponseUrlPresig_Message(), httpContext.getMessage( "Error", ""), 1) != 0 )
                  {
                     AV19error = AV39responseUrlPresig.getgxTv_SdtresponseUrlPresig_Message() ;
                  }
                  else
                  {
                     AV19error = httpContext.getMessage( "Se obtuvo una url presignada vacía", "") ;
                  }
               }
               else
               {
                  AV14URLRecibo = AV39responseUrlPresig.getgxTv_SdtresponseUrlPresig_Url() ;
               }
            }
         }
         if ( ! AV24soloCrearHTML )
         {
            AV42timeOut = (short)(20) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "&&URLRecibo ", "")+AV14URLRecibo) ;
            AV46hostS3 = GXutil.strReplace( AV14URLRecibo, httpContext.getMessage( "https://", ""), "") ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "&hostS3 ", "")+AV46hostS3) ;
            AV51HostCuantos = (short)(GXutil.strSearch( AV46hostS3, "/", 1)) ;
            AV48cuantos = (short)(AV51HostCuantos-1) ;
            AV46hostS3 = GXutil.substring( AV46hostS3, 1, AV48cuantos) ;
            AV46hostS3 = GXutil.trim( AV46hostS3) ;
            while ( AV41i <= AV42timeOut )
            {
               /* Execute user subroutine: 'GET URL BASE' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( ! (GXutil.strcmp("", AV22nombreArchivoGenerado)==0) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "!hosts3 ", "")+AV46hostS3+httpContext.getMessage( " baseurl ", "")+AV47baseURLS3+httpContext.getMessage( " desde ", "")+GXutil.trim( GXutil.str( AV49desde, 4, 0))+httpContext.getMessage( " cuantos ", "")+GXutil.trim( GXutil.str( AV48cuantos, 4, 0))) ;
                  GXv_char5[0] = "" ;
                  GXv_int6[0] = AV38statusCode ;
                  new web.restexecute(remoteHandle, context).execute( AV46hostS3, 443, (short)(1), AV47baseURLS3, AV50nada_http_headers, httpContext.getMessage( "GET", ""), "", (short)(2), GXv_char5, GXv_int6) ;
                  armaurlrecibopdf.this.AV38statusCode = (short)((short)(GXv_int6[0])) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "statuscode ", "")+GXutil.trim( GXutil.str( AV38statusCode, 4, 0))) ;
                  if ( AV38statusCode == 200 )
                  {
                     if (true) break;
                  }
               }
               AV41i = (short)(AV41i+1) ;
               Gx_err = GXutil.sleep( 1) ;
            }
            if ( AV38statusCode != 200 )
            {
               AV19error = httpContext.getMessage( "No se pudo recuperar la url del recibo. Status code: ", "") + GXutil.trim( GXutil.str( AV38statusCode, 4, 0)) + httpContext.getMessage( ". Url: ", "") + GXutil.trim( AV47baseURLS3) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GET URL BASE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "--&nombreArchivoGenerado ", "")+AV22nombreArchivoGenerado) ;
      if ( (GXutil.strcmp("", AV22nombreArchivoGenerado)==0) )
      {
         GXv_char5[0] = AV22nombreArchivoGenerado ;
         new web.liqleggetnombrearchivopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV13tipoRecibo, GXv_char5) ;
         armaurlrecibopdf.this.AV22nombreArchivoGenerado = GXv_char5[0] ;
         if ( ! (GXutil.strcmp("", AV22nombreArchivoGenerado)==0) )
         {
            AV14URLRecibo += AV22nombreArchivoGenerado ;
            AV47baseURLS3 = GXutil.strReplace( AV14URLRecibo, httpContext.getMessage( "https://", ""), "") ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV58Pgmname, httpContext.getMessage( "antes &baseURLS3 ", "")+AV47baseURLS3+httpContext.getMessage( " &cuantos ", "")+GXutil.trim( GXutil.str( AV48cuantos, 4, 0))+httpContext.getMessage( " &URLRecibo ", "")+AV14URLRecibo) ;
            AV49desde = (short)(AV51HostCuantos-1) ;
            AV48cuantos = (short)(GXutil.len( AV47baseURLS3)-AV49desde) ;
            AV49desde = (short)(AV49desde+1) ;
            AV47baseURLS3 = GXutil.substring( AV47baseURLS3, AV49desde, AV48cuantos) ;
            AV47baseURLS3 = GXutil.trim( AV47baseURLS3) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = armaurlrecibopdf.this.AV14URLRecibo;
      this.aP8[0] = armaurlrecibopdf.this.AV19error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14URLRecibo = "" ;
      AV19error = "" ;
      AV43modoPDFPalabra = "" ;
      AV53imprimirLiqLeg = "" ;
      AV22nombreArchivoGenerado = "" ;
      AV58Pgmname = "" ;
      AV33LiqLinkS3Html = "" ;
      AV17rutaArchivo = "" ;
      AV23legNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_objcol_int2 = new GXSimpleCollection[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV20rutaArchivoGenerada = "" ;
      AV28ParmValue = "" ;
      AV32rutaRelativaUploads = "" ;
      AV25a3lutilitiesHost = "" ;
      AV36urlBase = "" ;
      GXv_char4 = new String[1] ;
      GXv_char1 = new String[1] ;
      AV35http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem7 = new GXBaseCollection[1] ;
      GXv_int8 = new short[1] ;
      AV34bodyTexto = "" ;
      AV37response_raw = "" ;
      AV39responseUrlPresig = new web.SdtresponseUrlPresig(remoteHandle, context);
      AV46hostS3 = "" ;
      AV47baseURLS3 = "" ;
      AV50nada_http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_int6 = new int[1] ;
      GXv_char5 = new String[1] ;
      AV58Pgmname = "ArmaUrlReciboPDF" ;
      /* GeneXus formulas. */
      AV58Pgmname = "ArmaUrlReciboPDF" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV40expiresSeg ;
   private short AV55timeOutRest ;
   private short GXv_int8[] ;
   private short AV38statusCode ;
   private short AV42timeOut ;
   private short AV51HostCuantos ;
   private short AV48cuantos ;
   private short AV41i ;
   private short AV49desde ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int AV26nodePort ;
   private int GXv_int6[] ;
   private String AV13tipoRecibo ;
   private String AV43modoPDFPalabra ;
   private String AV53imprimirLiqLeg ;
   private String AV58Pgmname ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private String GXv_char5[] ;
   private boolean AV24soloCrearHTML ;
   private boolean AV44liquidando ;
   private boolean AV30existe ;
   private boolean AV21falloGeneracionPDF ;
   private boolean GXv_boolean3[] ;
   private boolean returnInSub ;
   private String AV28ParmValue ;
   private String AV14URLRecibo ;
   private String AV19error ;
   private String AV22nombreArchivoGenerado ;
   private String AV33LiqLinkS3Html ;
   private String AV17rutaArchivo ;
   private String AV20rutaArchivoGenerada ;
   private String AV32rutaRelativaUploads ;
   private String AV25a3lutilitiesHost ;
   private String AV36urlBase ;
   private String AV34bodyTexto ;
   private String AV37response_raw ;
   private String AV46hostS3 ;
   private String AV47baseURLS3 ;
   private GXSimpleCollection<Integer> AV23legNumeros ;
   private GXSimpleCollection<Integer> GXv_objcol_int2[] ;
   private String[] aP8 ;
   private String[] aP7 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV35http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem7[] ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV50nada_http_headers ;
   private web.SdtresponseUrlPresig AV39responseUrlPresig ;
}

