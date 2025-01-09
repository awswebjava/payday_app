package web ;
import com.genexus.*;

public final  class StructSdtNodeHtmlAPdf implements Cloneable, java.io.Serializable
{
   public StructSdtNodeHtmlAPdf( )
   {
      this( -1, new ModelContext( StructSdtNodeHtmlAPdf.class ));
   }

   public StructSdtNodeHtmlAPdf( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtNodeHtmlAPdf_Message = "" ;
      gxTv_SdtNodeHtmlAPdf_Path = "" ;
      gxTv_SdtNodeHtmlAPdf_Nombrearchivo = "" ;
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

   public String getMessage( )
   {
      return gxTv_SdtNodeHtmlAPdf_Message ;
   }

   public void setMessage( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Message = value ;
   }

   public String getPath( )
   {
      return gxTv_SdtNodeHtmlAPdf_Path ;
   }

   public void setPath( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Path = value ;
   }

   public String getNombrearchivo( )
   {
      return gxTv_SdtNodeHtmlAPdf_Nombrearchivo ;
   }

   public void setNombrearchivo( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Nombrearchivo = value ;
   }

   protected byte gxTv_SdtNodeHtmlAPdf_N ;
   protected String gxTv_SdtNodeHtmlAPdf_Message ;
   protected String gxTv_SdtNodeHtmlAPdf_Path ;
   protected String gxTv_SdtNodeHtmlAPdf_Nombrearchivo ;
}

