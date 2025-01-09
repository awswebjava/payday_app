package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_abm_1_nolaborables_origen implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_abm_1_nolaborables_origen( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_abm_1_nolaborables_origen.class ));
   }

   public StructSdtEmpresa_abm_1_nolaborables_origen( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z = "" ;
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

   public String getEmporigen( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen ;
   }

   public void setEmporigen( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_origen_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Initialized = value ;
   }

   public String getEmporigen_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z ;
   }

   public void setEmporigen_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z = value ;
   }

   private byte gxTv_SdtEmpresa_abm_1_nolaborables_origen_N ;
   protected short gxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified ;
   protected short gxTv_SdtEmpresa_abm_1_nolaborables_origen_Initialized ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode ;
   protected String gxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z ;
}

