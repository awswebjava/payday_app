package web ;
import com.genexus.*;

public final  class StructSdtPais_Vacaciones implements Cloneable, java.io.Serializable
{
   public StructSdtPais_Vacaciones( )
   {
      this( -1, new ModelContext( StructSdtPais_Vacaciones.class ));
   }

   public StructSdtPais_Vacaciones( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtPais_Vacaciones_Mode = "" ;
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

   public byte getPaivacdesant( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdesant ;
   }

   public void setPaivacdesant( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivacdesant = value ;
   }

   public byte getPaivachasant( )
   {
      return gxTv_SdtPais_Vacaciones_Paivachasant ;
   }

   public void setPaivachasant( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivachasant = value ;
   }

   public byte getPaivacdias( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdias ;
   }

   public void setPaivacdias( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivacdias = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_Vacaciones_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_Vacaciones_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_Vacaciones_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Initialized = value ;
   }

   public byte getPaivacdesant_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdesant_Z ;
   }

   public void setPaivacdesant_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivacdesant_Z = value ;
   }

   public byte getPaivachasant_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivachasant_Z ;
   }

   public void setPaivachasant_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivachasant_Z = value ;
   }

   public byte getPaivacdias_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdias_Z ;
   }

   public void setPaivacdias_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Paivacdias_Z = value ;
   }

   protected byte gxTv_SdtPais_Vacaciones_Paivacdesant ;
   protected byte gxTv_SdtPais_Vacaciones_Paivachasant ;
   protected byte gxTv_SdtPais_Vacaciones_Paivacdias ;
   protected byte gxTv_SdtPais_Vacaciones_Paivacdesant_Z ;
   protected byte gxTv_SdtPais_Vacaciones_Paivachasant_Z ;
   protected byte gxTv_SdtPais_Vacaciones_Paivacdias_Z ;
   private byte gxTv_SdtPais_Vacaciones_N ;
   protected short gxTv_SdtPais_Vacaciones_Modified ;
   protected short gxTv_SdtPais_Vacaciones_Initialized ;
   protected String gxTv_SdtPais_Vacaciones_Mode ;
}

