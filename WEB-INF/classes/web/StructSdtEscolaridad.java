package web ;
import com.genexus.*;

public final  class StructSdtEscolaridad implements Cloneable, java.io.Serializable
{
   public StructSdtEscolaridad( )
   {
      this( -1, new ModelContext( StructSdtEscolaridad.class ));
   }

   public StructSdtEscolaridad( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_SdtEscolaridad_Esccod = "" ;
      gxTv_SdtEscolaridad_Escdescrip = "" ;
      gxTv_SdtEscolaridad_Escres551 = "" ;
      gxTv_SdtEscolaridad_Mode = "" ;
      gxTv_SdtEscolaridad_Esccod_Z = "" ;
      gxTv_SdtEscolaridad_Escdescrip_Z = "" ;
      gxTv_SdtEscolaridad_Escres551_Z = "" ;
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
      return gxTv_SdtEscolaridad_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Clicod = value ;
   }

   public String getEsccod( )
   {
      return gxTv_SdtEscolaridad_Esccod ;
   }

   public void setEsccod( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Esccod = value ;
   }

   public String getEscdescrip( )
   {
      return gxTv_SdtEscolaridad_Escdescrip ;
   }

   public void setEscdescrip( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Escdescrip = value ;
   }

   public boolean getEschabilitada( )
   {
      return gxTv_SdtEscolaridad_Eschabilitada ;
   }

   public void setEschabilitada( boolean value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Eschabilitada = value ;
   }

   public String getEscres551( )
   {
      return gxTv_SdtEscolaridad_Escres551 ;
   }

   public void setEscres551( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Escres551 = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEscolaridad_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEscolaridad_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtEscolaridad_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Clicod_Z = value ;
   }

   public String getEsccod_Z( )
   {
      return gxTv_SdtEscolaridad_Esccod_Z ;
   }

   public void setEsccod_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Esccod_Z = value ;
   }

   public String getEscdescrip_Z( )
   {
      return gxTv_SdtEscolaridad_Escdescrip_Z ;
   }

   public void setEscdescrip_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Escdescrip_Z = value ;
   }

   public boolean getEschabilitada_Z( )
   {
      return gxTv_SdtEscolaridad_Eschabilitada_Z ;
   }

   public void setEschabilitada_Z( boolean value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Eschabilitada_Z = value ;
   }

   public String getEscres551_Z( )
   {
      return gxTv_SdtEscolaridad_Escres551_Z ;
   }

   public void setEscres551_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      gxTv_SdtEscolaridad_Escres551_Z = value ;
   }

   private byte gxTv_SdtEscolaridad_N ;
   protected short gxTv_SdtEscolaridad_Initialized ;
   protected int gxTv_SdtEscolaridad_Clicod ;
   protected int gxTv_SdtEscolaridad_Clicod_Z ;
   protected String gxTv_SdtEscolaridad_Esccod ;
   protected String gxTv_SdtEscolaridad_Mode ;
   protected String gxTv_SdtEscolaridad_Esccod_Z ;
   protected boolean gxTv_SdtEscolaridad_Eschabilitada ;
   protected boolean gxTv_SdtEscolaridad_Eschabilitada_Z ;
   protected String gxTv_SdtEscolaridad_Escdescrip ;
   protected String gxTv_SdtEscolaridad_Escres551 ;
   protected String gxTv_SdtEscolaridad_Escdescrip_Z ;
   protected String gxTv_SdtEscolaridad_Escres551_Z ;
}

