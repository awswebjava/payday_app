package web ;
import com.genexus.*;

public final  class StructSdtTipoLiquidacion implements Cloneable, java.io.Serializable
{
   public StructSdtTipoLiquidacion( )
   {
      this( -1, new ModelContext( StructSdtTipoLiquidacion.class ));
   }

   public StructSdtTipoLiquidacion( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtTipoLiquidacion_Tliqcod = "" ;
      gxTv_SdtTipoLiquidacion_Tliqdesc = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor = "" ;
      gxTv_SdtTipoLiquidacion_Mode = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtTipoLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = "" ;
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

   public int getClicod( )
   {
      return gxTv_SdtTipoLiquidacion_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Clicod = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqcod = value ;
   }

   public String getTliqdesc( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqdesc ;
   }

   public void setTliqdesc( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqdesc = value ;
   }

   public boolean getTliqhabilitada( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqhabilitada ;
   }

   public void setTliqhabilitada( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqhabilitada = value ;
   }

   public boolean getTliqacudiastrab( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqacudiastrab ;
   }

   public void setTliqacudiastrab( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqacudiastrab = value ;
   }

   public boolean getTliqsac( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqsac ;
   }

   public void setTliqsac( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqsac = value ;
   }

   public short getTliqord( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqord ;
   }

   public void setTliqord( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqord = value ;
   }

   public String getTliqcodfor( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcodfor ;
   }

   public void setTliqcodfor( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor = value ;
   }

   public java.util.Vector<web.StructSdtTipoLiquidacion_modo_frec> getModo_frec( )
   {
      return gxTv_SdtTipoLiquidacion_Modo_frec ;
   }

   public void setModo_frec( java.util.Vector<web.StructSdtTipoLiquidacion_modo_frec> value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Modo_frec = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtTipoLiquidacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtTipoLiquidacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Clicod_Z = value ;
   }

   public String getTliqcod_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod_Z ;
   }

   public void setTliqcod_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqcod_Z = value ;
   }

   public String getTliqdesc_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqdesc_Z ;
   }

   public void setTliqdesc_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqdesc_Z = value ;
   }

   public boolean getTliqhabilitada_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z ;
   }

   public void setTliqhabilitada_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z = value ;
   }

   public boolean getTliqacudiastrab_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z ;
   }

   public void setTliqacudiastrab_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z = value ;
   }

   public boolean getTliqsac_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqsac_Z ;
   }

   public void setTliqsac_Z( boolean value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqsac_Z = value ;
   }

   public short getTliqord_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqord_Z ;
   }

   public void setTliqord_Z( short value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqord_Z = value ;
   }

   public String getTliqcodfor_Z( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcodfor_Z ;
   }

   public void setTliqcodfor_Z( String value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqcodfor_Z = value ;
   }

   public byte getTliqcod_N( )
   {
      return gxTv_SdtTipoLiquidacion_Tliqcod_N ;
   }

   public void setTliqcod_N( byte value )
   {
      gxTv_SdtTipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtTipoLiquidacion_Tliqcod_N = value ;
   }

   protected byte gxTv_SdtTipoLiquidacion_Tliqcod_N ;
   private byte gxTv_SdtTipoLiquidacion_N ;
   protected short gxTv_SdtTipoLiquidacion_Tliqord ;
   protected short gxTv_SdtTipoLiquidacion_Initialized ;
   protected short gxTv_SdtTipoLiquidacion_Tliqord_Z ;
   protected int gxTv_SdtTipoLiquidacion_Clicod ;
   protected int gxTv_SdtTipoLiquidacion_Clicod_Z ;
   protected String gxTv_SdtTipoLiquidacion_Tliqcod ;
   protected String gxTv_SdtTipoLiquidacion_Tliqcodfor ;
   protected String gxTv_SdtTipoLiquidacion_Mode ;
   protected String gxTv_SdtTipoLiquidacion_Tliqcod_Z ;
   protected String gxTv_SdtTipoLiquidacion_Tliqcodfor_Z ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqhabilitada ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqacudiastrab ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqsac ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqhabilitada_Z ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z ;
   protected boolean gxTv_SdtTipoLiquidacion_Tliqsac_Z ;
   protected String gxTv_SdtTipoLiquidacion_Tliqdesc ;
   protected String gxTv_SdtTipoLiquidacion_Tliqdesc_Z ;
   protected java.util.Vector<web.StructSdtTipoLiquidacion_modo_frec> gxTv_SdtTipoLiquidacion_Modo_frec=null ;
}

