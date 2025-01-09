package web ;
import com.genexus.*;

public final  class StructSdtresponseUrlPresig implements Cloneable, java.io.Serializable
{
   public StructSdtresponseUrlPresig( )
   {
      this( -1, new ModelContext( StructSdtresponseUrlPresig.class ));
   }

   public StructSdtresponseUrlPresig( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtresponseUrlPresig_Message = "" ;
      gxTv_SdtresponseUrlPresig_Url = "" ;
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
      return gxTv_SdtresponseUrlPresig_Message ;
   }

   public void setMessage( String value )
   {
      gxTv_SdtresponseUrlPresig_N = (byte)(0) ;
      gxTv_SdtresponseUrlPresig_Message = value ;
   }

   public String getUrl( )
   {
      return gxTv_SdtresponseUrlPresig_Url ;
   }

   public void setUrl( String value )
   {
      gxTv_SdtresponseUrlPresig_N = (byte)(0) ;
      gxTv_SdtresponseUrlPresig_Url = value ;
   }

   protected byte gxTv_SdtresponseUrlPresig_N ;
   protected String gxTv_SdtresponseUrlPresig_Message ;
   protected String gxTv_SdtresponseUrlPresig_Url ;
}

