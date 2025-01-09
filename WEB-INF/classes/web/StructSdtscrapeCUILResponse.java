package web ;
import com.genexus.*;

public final  class StructSdtscrapeCUILResponse implements Cloneable, java.io.Serializable
{
   public StructSdtscrapeCUILResponse( )
   {
      this( -1, new ModelContext( StructSdtscrapeCUILResponse.class ));
   }

   public StructSdtscrapeCUILResponse( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtscrapeCUILResponse_Nombre = "" ;
      gxTv_SdtscrapeCUILResponse_Tiempodeejecucion = "" ;
      gxTv_SdtscrapeCUILResponse_Fuente = "" ;
      gxTv_SdtscrapeCUILResponse_Message = "" ;
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

   public String getNombre( )
   {
      return gxTv_SdtscrapeCUILResponse_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Nombre = value ;
   }

   public String getTiempodeejecucion( )
   {
      return gxTv_SdtscrapeCUILResponse_Tiempodeejecucion ;
   }

   public void setTiempodeejecucion( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Tiempodeejecucion = value ;
   }

   public String getFuente( )
   {
      return gxTv_SdtscrapeCUILResponse_Fuente ;
   }

   public void setFuente( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Fuente = value ;
   }

   public String getMessage( )
   {
      return gxTv_SdtscrapeCUILResponse_Message ;
   }

   public void setMessage( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Message = value ;
   }

   protected byte gxTv_SdtscrapeCUILResponse_N ;
   protected String gxTv_SdtscrapeCUILResponse_Nombre ;
   protected String gxTv_SdtscrapeCUILResponse_Tiempodeejecucion ;
   protected String gxTv_SdtscrapeCUILResponse_Fuente ;
   protected String gxTv_SdtscrapeCUILResponse_Message ;
}

