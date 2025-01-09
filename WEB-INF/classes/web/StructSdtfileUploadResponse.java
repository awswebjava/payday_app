package web ;
import com.genexus.*;

public final  class StructSdtfileUploadResponse implements Cloneable, java.io.Serializable
{
   public StructSdtfileUploadResponse( )
   {
      this( -1, new ModelContext( StructSdtfileUploadResponse.class ));
   }

   public StructSdtfileUploadResponse( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtfileUploadResponse_Status = new java.math.BigDecimal(0) ;
      gxTv_SdtfileUploadResponse_Dir = "" ;
      gxTv_SdtfileUploadResponse_Name = "" ;
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

   public java.math.BigDecimal getStatus( )
   {
      return gxTv_SdtfileUploadResponse_Status ;
   }

   public void setStatus( java.math.BigDecimal value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Status = value ;
   }

   public String getDir( )
   {
      return gxTv_SdtfileUploadResponse_Dir ;
   }

   public void setDir( String value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Dir = value ;
   }

   public String getName( )
   {
      return gxTv_SdtfileUploadResponse_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Name = value ;
   }

   protected byte gxTv_SdtfileUploadResponse_N ;
   protected String gxTv_SdtfileUploadResponse_Dir ;
   protected String gxTv_SdtfileUploadResponse_Name ;
   protected java.math.BigDecimal gxTv_SdtfileUploadResponse_Status ;
}

