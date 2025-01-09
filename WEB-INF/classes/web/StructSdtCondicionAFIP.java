package web ;
import com.genexus.*;

public final  class StructSdtCondicionAFIP implements Cloneable, java.io.Serializable
{
   public StructSdtCondicionAFIP( )
   {
      this( -1, new ModelContext( StructSdtCondicionAFIP.class ));
   }

   public StructSdtCondicionAFIP( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtCondicionAFIP_Condidescri = "" ;
      gxTv_SdtCondicionAFIP_Condidescrisinac = "" ;
      gxTv_SdtCondicionAFIP_Mode = "" ;
      gxTv_SdtCondicionAFIP_Condidescri_Z = "" ;
      gxTv_SdtCondicionAFIP_Condidescrisinac_Z = "" ;
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

   public short getCondicodigo( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo ;
   }

   public void setCondicodigo( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condicodigo = value ;
   }

   public String getCondidescri( )
   {
      return gxTv_SdtCondicionAFIP_Condidescri ;
   }

   public void setCondidescri( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condidescri = value ;
   }

   public String getCondidescrisinac( )
   {
      return gxTv_SdtCondicionAFIP_Condidescrisinac ;
   }

   public void setCondidescrisinac( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condidescrisinac = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCondicionAFIP_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCondicionAFIP_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Initialized = value ;
   }

   public short getCondicodigo_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo_Z ;
   }

   public void setCondicodigo_Z( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condicodigo_Z = value ;
   }

   public String getCondidescri_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condidescri_Z ;
   }

   public void setCondidescri_Z( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condidescri_Z = value ;
   }

   public String getCondidescrisinac_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condidescrisinac_Z ;
   }

   public void setCondidescrisinac_Z( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condidescrisinac_Z = value ;
   }

   public byte getCondicodigo_N( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo_N ;
   }

   public void setCondicodigo_N( byte value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      gxTv_SdtCondicionAFIP_Condicodigo_N = value ;
   }

   protected byte gxTv_SdtCondicionAFIP_Condicodigo_N ;
   private byte gxTv_SdtCondicionAFIP_N ;
   protected short gxTv_SdtCondicionAFIP_Condicodigo ;
   protected short gxTv_SdtCondicionAFIP_Initialized ;
   protected short gxTv_SdtCondicionAFIP_Condicodigo_Z ;
   protected String gxTv_SdtCondicionAFIP_Mode ;
   protected String gxTv_SdtCondicionAFIP_Condidescri ;
   protected String gxTv_SdtCondicionAFIP_Condidescrisinac ;
   protected String gxTv_SdtCondicionAFIP_Condidescri_Z ;
   protected String gxTv_SdtCondicionAFIP_Condidescrisinac_Z ;
}

