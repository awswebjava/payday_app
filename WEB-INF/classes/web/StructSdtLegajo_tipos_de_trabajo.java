package web ;
import com.genexus.*;

public final  class StructSdtLegajo_tipos_de_trabajo implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo_tipos_de_trabajo( )
   {
      this( -1, new ModelContext( StructSdtLegajo_tipos_de_trabajo.class ));
   }

   public StructSdtLegajo_tipos_de_trabajo( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = "" ;
      gxTv_SdtLegajo_tipos_de_trabajo_Mode = "" ;
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = "" ;
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

   public String getLegtipotra( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra ;
   }

   public void setLegtipotra( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Initialized = value ;
   }

   public String getLegtipotra_Z( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z ;
   }

   public void setLegtipotra_Z( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = value ;
   }

   private byte gxTv_SdtLegajo_tipos_de_trabajo_N ;
   protected short gxTv_SdtLegajo_tipos_de_trabajo_Modified ;
   protected short gxTv_SdtLegajo_tipos_de_trabajo_Initialized ;
   protected String gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra ;
   protected String gxTv_SdtLegajo_tipos_de_trabajo_Mode ;
   protected String gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z ;
}

