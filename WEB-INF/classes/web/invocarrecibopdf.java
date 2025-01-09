package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocarrecibopdf extends GXProcedure
{
   public invocarrecibopdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocarrecibopdf.class ), "" );
   }

   public invocarrecibopdf( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      invocarrecibopdf.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      invocarrecibopdf.this.AV11CliCod = aP0;
      invocarrecibopdf.this.AV12EmpCod = aP1;
      invocarrecibopdf.this.AV28LegNumero = aP2;
      invocarrecibopdf.this.AV29nombrePDF = aP3;
      invocarrecibopdf.this.AV23NombreArchivoHTML = aP4;
      invocarrecibopdf.this.aP5 = aP5;
      invocarrecibopdf.this.aP6 = aP6;
      invocarrecibopdf.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "buscaparm", "")) ;
      GXv_char1[0] = AV21a3lutilitiesHost ;
      GXv_int2[0] = AV19htmlAPDFPuerto ;
      new web.getnodehostyport(remoteHandle, context).execute( AV11CliCod, "", GXv_char1, GXv_int2) ;
      invocarrecibopdf.this.AV21a3lutilitiesHost = GXv_char1[0] ;
      invocarrecibopdf.this.AV19htmlAPDFPuerto = GXv_int2[0] ;
      GXv_char1[0] = AV21a3lutilitiesHost ;
      GXv_int3[0] = AV19htmlAPDFPuerto ;
      GXv_char4[0] = AV22urlBase ;
      GXv_char5[0] = AV33rutaRelativaUploads ;
      GXv_objcol_Sdthttp_headers_http_headersItem6[0] = AV8http_headers ;
      GXv_int2[0] = AV34timeOut ;
      new web.getnodedatos(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV28LegNumero, httpContext.getMessage( "htmlApdf", ""), AV23NombreArchivoHTML, true, true, "", GXv_char1, GXv_int3, GXv_char4, GXv_char5, GXv_objcol_Sdthttp_headers_http_headersItem6, GXv_int2) ;
      invocarrecibopdf.this.AV21a3lutilitiesHost = GXv_char1[0] ;
      invocarrecibopdf.this.AV19htmlAPDFPuerto = (short)((short)(GXv_int3[0])) ;
      invocarrecibopdf.this.AV22urlBase = GXv_char4[0] ;
      invocarrecibopdf.this.AV33rutaRelativaUploads = GXv_char5[0] ;
      AV8http_headers = GXv_objcol_Sdthttp_headers_http_headersItem6[0] ;
      invocarrecibopdf.this.AV34timeOut = GXv_int2[0] ;
      GXv_char5[0] = AV32s3Link ;
      GXv_boolean7[0] = false ;
      new web.geturlbases3_segunambiente(remoteHandle, context).execute( AV11CliCod, httpContext.getMessage( "HTML", ""), GXv_char5, GXv_boolean7) ;
      invocarrecibopdf.this.AV32s3Link = GXv_char5[0] ;
      AV32s3Link += "/" + GXutil.trim( AV33rutaRelativaUploads) + "/" + GXutil.trim( AV23NombreArchivoHTML) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "s3link ", "")+GXutil.trim( AV32s3Link)) ;
      AV22urlBase += "/" + GXutil.trim( AV29nombrePDF) ;
      GXv_char5[0] = AV9response_raw ;
      GXv_int3[0] = 0 ;
      new web.restexecute(remoteHandle, context).execute( AV21a3lutilitiesHost, AV19htmlAPDFPuerto, (short)(0), AV22urlBase, AV8http_headers, httpContext.getMessage( "POST", ""), httpContext.getMessage( "{\"s3Link\":\"", "")+GXutil.trim( AV32s3Link)+"\"}", AV34timeOut, GXv_char5, GXv_int3) ;
      invocarrecibopdf.this.AV9response_raw = GXv_char5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "volvio", "")) ;
      if ( GXutil.strSearch( AV9response_raw, httpContext.getMessage( "[OK]", ""), 1) == 0 )
      {
         if ( (GXutil.strcmp("", AV9response_raw)==0) )
         {
            AV10error = httpContext.getMessage( "El Webservice de recibo PDF no responde", "") ;
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV9response_raw)==0) )
            {
               AV10error = httpContext.getMessage( "Error al crear el PDF", "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&response_raw ", "")+GXutil.trim( AV9response_raw)) ;
            }
            else
            {
               AV10error = httpContext.getMessage( "El Webservice de recibos no está corriendo", "") ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV10error)) ;
      }
      else
      {
         AV15NodeHtmlAPdf.fromJSonString(AV9response_raw, null);
         AV16rutaPDF = AV15NodeHtmlAPdf.getgxTv_SdtNodeHtmlAPdf_Path() ;
         AV17nombreArchivoGenerado = AV15NodeHtmlAPdf.getgxTv_SdtNodeHtmlAPdf_Nombrearchivo() ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = invocarrecibopdf.this.AV10error;
      this.aP6[0] = invocarrecibopdf.this.AV16rutaPDF;
      this.aP7[0] = invocarrecibopdf.this.AV17nombreArchivoGenerado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10error = "" ;
      AV16rutaPDF = "" ;
      AV17nombreArchivoGenerado = "" ;
      AV37Pgmname = "" ;
      AV21a3lutilitiesHost = "" ;
      GXv_char1 = new String[1] ;
      AV22urlBase = "" ;
      GXv_char4 = new String[1] ;
      AV33rutaRelativaUploads = "" ;
      AV8http_headers = new GXBaseCollection<web.Sdthttp_headers_http_headersItem>(web.Sdthttp_headers_http_headersItem.class, "http_headersItem", "PayDay", remoteHandle);
      GXv_objcol_Sdthttp_headers_http_headersItem6 = new GXBaseCollection[1] ;
      GXv_int2 = new short[1] ;
      AV32s3Link = "" ;
      GXv_boolean7 = new boolean[1] ;
      AV9response_raw = "" ;
      GXv_char5 = new String[1] ;
      GXv_int3 = new int[1] ;
      AV15NodeHtmlAPdf = new web.SdtNodeHtmlAPdf(remoteHandle, context);
      AV37Pgmname = "invocarReciboPDF" ;
      /* GeneXus formulas. */
      AV37Pgmname = "invocarReciboPDF" ;
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV19htmlAPDFPuerto ;
   private short AV34timeOut ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV28LegNumero ;
   private int GXv_int3[] ;
   private String AV37Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private boolean GXv_boolean7[] ;
   private String AV29nombrePDF ;
   private String AV23NombreArchivoHTML ;
   private String AV10error ;
   private String AV16rutaPDF ;
   private String AV17nombreArchivoGenerado ;
   private String AV21a3lutilitiesHost ;
   private String AV22urlBase ;
   private String AV33rutaRelativaUploads ;
   private String AV32s3Link ;
   private String AV9response_raw ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> AV8http_headers ;
   private GXBaseCollection<web.Sdthttp_headers_http_headersItem> GXv_objcol_Sdthttp_headers_http_headersItem6[] ;
   private web.SdtNodeHtmlAPdf AV15NodeHtmlAPdf ;
}

