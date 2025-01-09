package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armasdtuploads3 extends GXProcedure
{
   public armasdtuploads3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armasdtuploads3.class ), "" );
   }

   public armasdtuploads3( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.SdtuploadS3_body executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           String aP5 ,
                                           String aP6 ,
                                           String aP7 ,
                                           String aP8 ,
                                           String aP9 ,
                                           String aP10 )
   {
      armasdtuploads3.this.aP11 = new web.SdtuploadS3_body[] {new web.SdtuploadS3_body()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        web.SdtuploadS3_body[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             web.SdtuploadS3_body[] aP11 )
   {
      armasdtuploads3.this.AV9CliCod = aP0;
      armasdtuploads3.this.AV12EmpCod = aP1;
      armasdtuploads3.this.AV19LiqNro = aP2;
      armasdtuploads3.this.AV13LegNumero = aP3;
      armasdtuploads3.this.AV11definitivoLegNumero = aP4;
      armasdtuploads3.this.AV8bucket_name = aP5;
      armasdtuploads3.this.AV14nombreCarpetaParaRecibosEnNode = aP6;
      armasdtuploads3.this.AV10contentTypePalabra = aP7;
      armasdtuploads3.this.AV16NombreArchivo = aP8;
      armasdtuploads3.this.AV17htmlContent = aP9;
      armasdtuploads3.this.AV20tipoReciboPalabra = aP10;
      armasdtuploads3.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Bucket_name( GXutil.trim( AV8bucket_name) );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_File_path( GXutil.trim( AV14nombreCarpetaParaRecibosEnNode) );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_S3_path( GXutil.trim( AV14nombreCarpetaParaRecibosEnNode) );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Content_type( GXutil.trim( AV10contentTypePalabra) );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_File_name( GXutil.trim( AV16NombreArchivo) );
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3[0] = GXt_char2 ;
      new web.s3awsregion_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      armasdtuploads3.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      armasdtuploads3.this.GXt_char1 = GXv_char4[0] ;
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Aws_region( GXt_char1 );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Clicod( AV9CliCod );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Empcod( AV12EmpCod );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Liqnro( AV19LiqNro );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Linklegnumero( AV13LegNumero );
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Leglinktiporec( AV20tipoReciboPalabra );
      GXv_char4[0] = AV22ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.uploadhtmltos3codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      armasdtuploads3.this.AV22ParmValue = GXv_char4[0] ;
      AV21uploadHTML = GXutil.boolval( AV22ParmValue) ;
      AV15uploadS3_body.setgxTv_SdtuploadS3_body_Uploadhtml( AV21uploadHTML );
      if ( ! (GXutil.strcmp("", AV17htmlContent)==0) )
      {
         AV15uploadS3_body.setgxTv_SdtuploadS3_body_Htmlcontent( GXutil.trim( AV17htmlContent) );
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = armasdtuploads3.this.AV15uploadS3_body;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15uploadS3_body = new web.SdtuploadS3_body(remoteHandle, context);
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV22ParmValue = "" ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV19LiqNro ;
   private int AV13LegNumero ;
   private int AV11definitivoLegNumero ;
   private String AV10contentTypePalabra ;
   private String AV20tipoReciboPalabra ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private boolean AV21uploadHTML ;
   private String AV17htmlContent ;
   private String AV22ParmValue ;
   private String AV8bucket_name ;
   private String AV14nombreCarpetaParaRecibosEnNode ;
   private String AV16NombreArchivo ;
   private web.SdtuploadS3_body[] aP11 ;
   private web.SdtuploadS3_body AV15uploadS3_body ;
}

