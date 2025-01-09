package web ;
import com.genexus.*;

public final  class StructSdtProvincia implements Cloneable, java.io.Serializable
{
   public StructSdtProvincia( )
   {
      this( -1, new ModelContext( StructSdtProvincia.class ));
   }

   public StructSdtProvincia( int remoteHandle ,
                              ModelContext context )
   {
      gxTv_SdtProvincia_Painom = "" ;
      gxTv_SdtProvincia_Provnom = "" ;
      gxTv_SdtProvincia_Mode = "" ;
      gxTv_SdtProvincia_Painom_Z = "" ;
      gxTv_SdtProvincia_Provnom_Z = "" ;
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

   public short getPaicod( )
   {
      return gxTv_SdtProvincia_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Paicod = value ;
   }

   public String getPainom( )
   {
      return gxTv_SdtProvincia_Painom ;
   }

   public void setPainom( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Painom = value ;
   }

   public short getProvcod( )
   {
      return gxTv_SdtProvincia_Provcod ;
   }

   public void setProvcod( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provcod = value ;
   }

   public String getProvnom( )
   {
      return gxTv_SdtProvincia_Provnom ;
   }

   public void setProvnom( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provnom = value ;
   }

   public short getProvsiradig( )
   {
      return gxTv_SdtProvincia_Provsiradig ;
   }

   public void setProvsiradig( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provsiradig = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProvincia_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProvincia_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Initialized = value ;
   }

   public short getPaicod_Z( )
   {
      return gxTv_SdtProvincia_Paicod_Z ;
   }

   public void setPaicod_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Paicod_Z = value ;
   }

   public String getPainom_Z( )
   {
      return gxTv_SdtProvincia_Painom_Z ;
   }

   public void setPainom_Z( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Painom_Z = value ;
   }

   public short getProvcod_Z( )
   {
      return gxTv_SdtProvincia_Provcod_Z ;
   }

   public void setProvcod_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provcod_Z = value ;
   }

   public String getProvnom_Z( )
   {
      return gxTv_SdtProvincia_Provnom_Z ;
   }

   public void setProvnom_Z( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provnom_Z = value ;
   }

   public short getProvsiradig_Z( )
   {
      return gxTv_SdtProvincia_Provsiradig_Z ;
   }

   public void setProvsiradig_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      gxTv_SdtProvincia_Provsiradig_Z = value ;
   }

   private byte gxTv_SdtProvincia_N ;
   protected short gxTv_SdtProvincia_Paicod ;
   protected short gxTv_SdtProvincia_Provcod ;
   protected short gxTv_SdtProvincia_Provsiradig ;
   protected short gxTv_SdtProvincia_Initialized ;
   protected short gxTv_SdtProvincia_Paicod_Z ;
   protected short gxTv_SdtProvincia_Provcod_Z ;
   protected short gxTv_SdtProvincia_Provsiradig_Z ;
   protected String gxTv_SdtProvincia_Mode ;
   protected String gxTv_SdtProvincia_Painom ;
   protected String gxTv_SdtProvincia_Provnom ;
   protected String gxTv_SdtProvincia_Painom_Z ;
   protected String gxTv_SdtProvincia_Provnom_Z ;
}

