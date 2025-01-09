package web ;
import com.genexus.*;

public final  class StructSdtTipoLiquidacion_modo_frec implements Cloneable, java.io.Serializable
{
   public StructSdtTipoLiquidacion_modo_frec( )
   {
      this( -1, new ModelContext( StructSdtTipoLiquidacion_modo_frec.class ));
   }

   public StructSdtTipoLiquidacion_modo_frec( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Mode = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = "" ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = "" ;
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

   public String getTliqmodtra( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra ;
   }

   public void setTliqmodtra( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra = value ;
   }

   public byte getTliqfrecpag( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag ;
   }

   public void setTliqfrecpag( byte value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag = value ;
   }

   public String getTliqdescauxfrec( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec ;
   }

   public void setTliqdescauxfrec( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Initialized = value ;
   }

   public String getTliqmodtra_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z ;
   }

   public void setTliqmodtra_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z = value ;
   }

   public byte getTliqfrecpag_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z ;
   }

   public void setTliqfrecpag_Z( byte value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z = value ;
   }

   public String getTliqdescauxfrec_Z( )
   {
      return gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z ;
   }

   public void setTliqdescauxfrec_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_modo_frec_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z = value ;
   }

   protected byte gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag ;
   protected byte gxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z ;
   private byte gxTv_SdtTipoLiquidacion_modo_frec_N ;
   protected short gxTv_SdtTipoLiquidacion_modo_frec_Modified ;
   protected short gxTv_SdtTipoLiquidacion_modo_frec_Initialized ;
   protected String gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra ;
   protected String gxTv_SdtTipoLiquidacion_modo_frec_Mode ;
   protected String gxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z ;
   protected String gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec ;
   protected String gxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z ;
}

