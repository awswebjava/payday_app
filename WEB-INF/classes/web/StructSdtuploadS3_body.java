package web ;
import com.genexus.*;

public final  class StructSdtuploadS3_body implements Cloneable, java.io.Serializable
{
   public StructSdtuploadS3_body( )
   {
      this( -1, new ModelContext( StructSdtuploadS3_body.class ));
   }

   public StructSdtuploadS3_body( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtuploadS3_body_Bucket_name = "" ;
      gxTv_SdtuploadS3_body_File_path = "" ;
      gxTv_SdtuploadS3_body_S3_path = "" ;
      gxTv_SdtuploadS3_body_File_name = "" ;
      gxTv_SdtuploadS3_body_Content_type = "" ;
      gxTv_SdtuploadS3_body_Aws_region = "" ;
      gxTv_SdtuploadS3_body_Htmlcontent = "" ;
      gxTv_SdtuploadS3_body_Leglinktiporec = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getBucket_name( )
   {
      return gxTv_SdtuploadS3_body_Bucket_name ;
   }

   public void setBucket_name( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Bucket_name = value ;
   }

   public String getFile_path( )
   {
      return gxTv_SdtuploadS3_body_File_path ;
   }

   public void setFile_path( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_File_path = value ;
   }

   public String getS3_path( )
   {
      return gxTv_SdtuploadS3_body_S3_path ;
   }

   public void setS3_path( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_S3_path = value ;
   }

   public String getFile_name( )
   {
      return gxTv_SdtuploadS3_body_File_name ;
   }

   public void setFile_name( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_File_name = value ;
   }

   public String getContent_type( )
   {
      return gxTv_SdtuploadS3_body_Content_type ;
   }

   public void setContent_type( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Content_type = value ;
   }

   public String getAws_region( )
   {
      return gxTv_SdtuploadS3_body_Aws_region ;
   }

   public void setAws_region( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Aws_region = value ;
   }

   public String getHtmlcontent( )
   {
      return gxTv_SdtuploadS3_body_Htmlcontent ;
   }

   public void setHtmlcontent( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Htmlcontent = value ;
   }

   public int getClicod( )
   {
      return gxTv_SdtuploadS3_body_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtuploadS3_body_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Empcod = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_SdtuploadS3_body_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Liqnro = value ;
   }

   public int getLinklegnumero( )
   {
      return gxTv_SdtuploadS3_body_Linklegnumero ;
   }

   public void setLinklegnumero( int value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Linklegnumero = value ;
   }

   public String getLeglinktiporec( )
   {
      return gxTv_SdtuploadS3_body_Leglinktiporec ;
   }

   public void setLeglinktiporec( String value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Leglinktiporec = value ;
   }

   public boolean getUploadhtml( )
   {
      return gxTv_SdtuploadS3_body_Uploadhtml ;
   }

   public void setUploadhtml( boolean value )
   {
      gxTv_SdtuploadS3_body_N = (byte)(0) ;
      gxTv_SdtuploadS3_body_Uploadhtml = value ;
   }

   protected byte gxTv_SdtuploadS3_body_N ;
   protected short gxTv_SdtuploadS3_body_Empcod ;
   protected int gxTv_SdtuploadS3_body_Clicod ;
   protected int gxTv_SdtuploadS3_body_Liqnro ;
   protected int gxTv_SdtuploadS3_body_Linklegnumero ;
   protected String gxTv_SdtuploadS3_body_Content_type ;
   protected String gxTv_SdtuploadS3_body_Aws_region ;
   protected String gxTv_SdtuploadS3_body_Leglinktiporec ;
   protected boolean gxTv_SdtuploadS3_body_Uploadhtml ;
   protected String gxTv_SdtuploadS3_body_Htmlcontent ;
   protected String gxTv_SdtuploadS3_body_Bucket_name ;
   protected String gxTv_SdtuploadS3_body_File_path ;
   protected String gxTv_SdtuploadS3_body_S3_path ;
   protected String gxTv_SdtuploadS3_body_File_name ;
}

