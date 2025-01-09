package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_abm_1_nolaborables_religion implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_abm_1_nolaborables_religion( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_abm_1_nolaborables_religion.class ));
   }

   public StructSdtEmpresa_abm_1_nolaborables_religion( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = "" ;
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

   public String getEmpreligion( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion ;
   }

   public void setEmpreligion( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized = value ;
   }

   public String getEmpreligion_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z ;
   }

   public void setEmpreligion_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = value ;
   }

   private byte gxTv_SdtEmpresa_abm_1_nolaborables_religion_N ;
   protected short gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified ;
   protected short gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z ;
}

