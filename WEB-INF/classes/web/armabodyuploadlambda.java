package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armabodyuploadlambda extends GXProcedure
{
   public armabodyuploadlambda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armabodyuploadlambda.class ), "" );
   }

   public armabodyuploadlambda( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             int aP7 ,
                             short aP8 ,
                             int aP9 ,
                             int aP10 ,
                             String aP11 )
   {
      armabodyuploadlambda.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        int aP7 ,
                        short aP8 ,
                        int aP9 ,
                        int aP10 ,
                        String aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             int aP7 ,
                             short aP8 ,
                             int aP9 ,
                             int aP10 ,
                             String aP11 ,
                             String[] aP12 )
   {
      armabodyuploadlambda.this.AV9base64String = aP0;
      armabodyuploadlambda.this.AV14fileContent = aP1;
      armabodyuploadlambda.this.AV10NombreArchivo = aP2;
      armabodyuploadlambda.this.AV11bucket_name = aP3;
      armabodyuploadlambda.this.AV12nombreCarpetaParaRecibosEnNode = aP4;
      armabodyuploadlambda.this.AV13regionPalabra = aP5;
      armabodyuploadlambda.this.AV15contentTypePalabra = aP6;
      armabodyuploadlambda.this.AV16CliCod = aP7;
      armabodyuploadlambda.this.AV17EmpCod = aP8;
      armabodyuploadlambda.this.AV18LiqNro = aP9;
      armabodyuploadlambda.this.AV19LinkLegNumero = aP10;
      armabodyuploadlambda.this.AV21leglinktiporecPalabra = aP11;
      armabodyuploadlambda.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8body = "{" ;
      if ( ! (GXutil.strcmp("", AV9base64String)==0) )
      {
         AV8body += httpContext.getMessage( "\"base64Data\": \"", "") + GXutil.trim( AV9base64String) + "\"," ;
      }
      else
      {
         AV8body += httpContext.getMessage( "\"fileContent\": \"", "") + GXutil.trim( AV14fileContent) + "\"," ;
      }
      AV8body += httpContext.getMessage( "\"fileName\": \"", "") + GXutil.trim( AV10NombreArchivo) + "\"," ;
      AV8body += httpContext.getMessage( "\"bucket_name\": \"", "") + GXutil.trim( AV11bucket_name) + "\"," ;
      AV8body += httpContext.getMessage( "\"s3_path\": \"", "") + GXutil.trim( AV12nombreCarpetaParaRecibosEnNode) + "\"," ;
      AV8body += httpContext.getMessage( "\"aws_region\": \"", "") + GXutil.trim( AV13regionPalabra) + "\"," ;
      AV8body += httpContext.getMessage( "\"contentType\": \"", "") + GXutil.trim( AV15contentTypePalabra) + "\"" ;
      if ( ! (0==AV16CliCod) )
      {
         AV8body += httpContext.getMessage( ",\"clicod\": \"", "") + GXutil.trim( GXutil.str( AV16CliCod, 6, 0)) + "\"" ;
      }
      if ( ! (0==AV17EmpCod) )
      {
         AV8body += httpContext.getMessage( ",\"empcod\": \"", "") + GXutil.trim( GXutil.str( AV17EmpCod, 4, 0)) + "\"" ;
      }
      if ( ! (0==AV18LiqNro) )
      {
         AV8body += httpContext.getMessage( ",\"liqnro\": \"", "") + GXutil.trim( GXutil.str( AV18LiqNro, 8, 0)) + "\"" ;
      }
      if ( ! (0==AV19LinkLegNumero) )
      {
         AV8body += httpContext.getMessage( ",\"linklegnumero\": \"", "") + GXutil.trim( GXutil.str( AV19LinkLegNumero, 8, 0)) + "\"" ;
      }
      if ( ! (GXutil.strcmp("", AV21leglinktiporecPalabra)==0) )
      {
         AV8body += httpContext.getMessage( ",\"leglinktiporec\": \"", "") + GXutil.trim( AV21leglinktiporecPalabra) + "\"" ;
      }
      AV8body += "}" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = armabodyuploadlambda.this.AV8body;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8body = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV18LiqNro ;
   private int AV19LinkLegNumero ;
   private String AV13regionPalabra ;
   private String AV15contentTypePalabra ;
   private String AV21leglinktiporecPalabra ;
   private String AV9base64String ;
   private String AV14fileContent ;
   private String AV8body ;
   private String AV10NombreArchivo ;
   private String AV11bucket_name ;
   private String AV12nombreCarpetaParaRecibosEnNode ;
   private String[] aP12 ;
}

