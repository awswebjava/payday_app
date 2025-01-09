package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_nolaborables_convenio implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_nolaborables_convenio( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_nolaborables_convenio.class ));
   }

   public StructSdtEmpresa_nolaborables_convenio( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio = "" ;
      gxTv_SdtEmpresa_nolaborables_convenio_Mode = "" ;
      gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z = "" ;
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

   public String getEmpconvenio( )
   {
      return gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio ;
   }

   public void setEmpconvenio( String value )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_nolaborables_convenio_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_convenio_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_nolaborables_convenio_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_convenio_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_nolaborables_convenio_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_convenio_Initialized = value ;
   }

   public String getEmpconvenio_Z( )
   {
      return gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z ;
   }

   public void setEmpconvenio_Z( String value )
   {
      gxTv_SdtEmpresa_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z = value ;
   }

   private byte gxTv_SdtEmpresa_nolaborables_convenio_N ;
   protected short gxTv_SdtEmpresa_nolaborables_convenio_Modified ;
   protected short gxTv_SdtEmpresa_nolaborables_convenio_Initialized ;
   protected String gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio ;
   protected String gxTv_SdtEmpresa_nolaborables_convenio_Mode ;
   protected String gxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z ;
}

