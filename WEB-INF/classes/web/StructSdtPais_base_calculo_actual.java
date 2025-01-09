package web ;
import com.genexus.*;

public final  class StructSdtPais_base_calculo_actual implements Cloneable, java.io.Serializable
{
   public StructSdtPais_base_calculo_actual( )
   {
      this( -1, new ModelContext( StructSdtPais_base_calculo_actual.class ));
   }

   public StructSdtPais_base_calculo_actual( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = "" ;
      gxTv_SdtPais_base_calculo_actual_Mode = "" ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = "" ;
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

   public int getPaibaseclicod( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseclicod ;
   }

   public void setPaibaseclicod( int value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseclicod = value ;
   }

   public String getPaibaseconcodigo( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo ;
   }

   public void setPaibaseconcodigo( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = value ;
   }

   public boolean getPaibaseconhabitual( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual ;
   }

   public void setPaibaseconhabitual( boolean value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_base_calculo_actual_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_base_calculo_actual_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_base_calculo_actual_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Initialized = value ;
   }

   public int getPaibaseclicod_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z ;
   }

   public void setPaibaseclicod_Z( int value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z = value ;
   }

   public String getPaibaseconcodigo_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z ;
   }

   public void setPaibaseconcodigo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = value ;
   }

   public boolean getPaibaseconhabitual_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z ;
   }

   public void setPaibaseconhabitual_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z = value ;
   }

   private byte gxTv_SdtPais_base_calculo_actual_N ;
   protected short gxTv_SdtPais_base_calculo_actual_Modified ;
   protected short gxTv_SdtPais_base_calculo_actual_Initialized ;
   protected int gxTv_SdtPais_base_calculo_actual_Paibaseclicod ;
   protected int gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z ;
   protected String gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo ;
   protected String gxTv_SdtPais_base_calculo_actual_Mode ;
   protected String gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z ;
   protected boolean gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual ;
   protected boolean gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z ;
}

