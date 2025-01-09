package web ;
import com.genexus.*;

public final  class StructSdtPais_base_calculo_promedio implements Cloneable, java.io.Serializable
{
   public StructSdtPais_base_calculo_promedio( )
   {
      this( -1, new ModelContext( StructSdtPais_base_calculo_promedio.class ));
   }

   public StructSdtPais_base_calculo_promedio( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = "" ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = "" ;
      gxTv_SdtPais_base_calculo_promedio_Mode = "" ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = "" ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = "" ;
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

   public String getPaibasepromctipo( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo ;
   }

   public void setPaibasepromctipo( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = value ;
   }

   public String getPaibasepromfijvar( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar ;
   }

   public void setPaibasepromfijvar( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = value ;
   }

   public boolean getPaibasepromhab( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromhab ;
   }

   public void setPaibasepromhab( boolean value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromhab = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Initialized = value ;
   }

   public String getPaibasepromctipo_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z ;
   }

   public void setPaibasepromctipo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = value ;
   }

   public String getPaibasepromfijvar_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z ;
   }

   public void setPaibasepromfijvar_Z( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = value ;
   }

   public boolean getPaibasepromhab_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z ;
   }

   public void setPaibasepromhab_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z = value ;
   }

   private byte gxTv_SdtPais_base_calculo_promedio_N ;
   protected short gxTv_SdtPais_base_calculo_promedio_Modified ;
   protected short gxTv_SdtPais_base_calculo_promedio_Initialized ;
   protected String gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo ;
   protected String gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar ;
   protected String gxTv_SdtPais_base_calculo_promedio_Mode ;
   protected String gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z ;
   protected String gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z ;
   protected boolean gxTv_SdtPais_base_calculo_promedio_Paibasepromhab ;
   protected boolean gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z ;
}

