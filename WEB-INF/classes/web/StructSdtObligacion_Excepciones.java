package web ;
import com.genexus.*;

public final  class StructSdtObligacion_Excepciones implements Cloneable, java.io.Serializable
{
   public StructSdtObligacion_Excepciones( )
   {
      this( -1, new ModelContext( StructSdtObligacion_Excepciones.class ));
   }

   public StructSdtObligacion_Excepciones( int remoteHandle ,
                                           ModelContext context )
   {
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = "" ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo = "" ;
      gxTv_SdtObligacion_Excepciones_Mode = "" ;
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = "" ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = "" ;
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

   public String getOblexcconcodigo( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexcconcodigo ;
   }

   public void setOblexcconcodigo( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = value ;
   }

   public String getOblexctipo( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexctipo ;
   }

   public void setOblexctipo( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtObligacion_Excepciones_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtObligacion_Excepciones_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtObligacion_Excepciones_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Initialized = value ;
   }

   public String getOblexcconcodigo_Z( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z ;
   }

   public void setOblexcconcodigo_Z( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = value ;
   }

   public String getOblexctipo_Z( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexctipo_Z ;
   }

   public void setOblexctipo_Z( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = value ;
   }

   private byte gxTv_SdtObligacion_Excepciones_N ;
   protected short gxTv_SdtObligacion_Excepciones_Modified ;
   protected short gxTv_SdtObligacion_Excepciones_Initialized ;
   protected String gxTv_SdtObligacion_Excepciones_Oblexcconcodigo ;
   protected String gxTv_SdtObligacion_Excepciones_Oblexctipo ;
   protected String gxTv_SdtObligacion_Excepciones_Mode ;
   protected String gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z ;
   protected String gxTv_SdtObligacion_Excepciones_Oblexctipo_Z ;
}

