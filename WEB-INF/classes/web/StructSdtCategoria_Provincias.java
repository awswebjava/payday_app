package web ;
import com.genexus.*;

public final  class StructSdtCategoria_Provincias implements Cloneable, java.io.Serializable
{
   public StructSdtCategoria_Provincias( )
   {
      this( -1, new ModelContext( StructSdtCategoria_Provincias.class ));
   }

   public StructSdtCategoria_Provincias( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref = "" ;
      gxTv_SdtCategoria_Provincias_Catprovold = "" ;
      gxTv_SdtCategoria_Provincias_Mode = "" ;
      gxTv_SdtCategoria_Provincias_Catprovrelref_Z = "" ;
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(1) ;
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

   public short getCatpaicod( )
   {
      return gxTv_SdtCategoria_Provincias_Catpaicod ;
   }

   public void setCatpaicod( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catpaicod = value ;
   }

   public short getCatprovcod( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovcod ;
   }

   public void setCatprovcod( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovcod = value ;
   }

   public int getCatprovrelsec( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec ;
   }

   public void setCatprovrelsec( int value )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelsec = value ;
   }

   public String getCatprovrelref( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref ;
   }

   public void setCatprovrelref( String value )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref = value ;
   }

   public String getCatprovold( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovold ;
   }

   public void setCatprovold( String value )
   {
      gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovold = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCategoria_Provincias_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtCategoria_Provincias_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCategoria_Provincias_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Initialized = value ;
   }

   public short getCatpaicod_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catpaicod_Z ;
   }

   public void setCatpaicod_Z( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catpaicod_Z = value ;
   }

   public short getCatprovcod_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovcod_Z ;
   }

   public void setCatprovcod_Z( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovcod_Z = value ;
   }

   public int getCatprovrelsec_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec_Z ;
   }

   public void setCatprovrelsec_Z( int value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelsec_Z = value ;
   }

   public String getCatprovrelref_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref_Z ;
   }

   public void setCatprovrelref_Z( String value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref_Z = value ;
   }

   public byte getCatprovrelsec_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec_N ;
   }

   public void setCatprovrelsec_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = value ;
   }

   public byte getCatprovrelref_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref_N ;
   }

   public void setCatprovrelref_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = value ;
   }

   public byte getCatprovold_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovold_N ;
   }

   public void setCatprovold_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Catprovold_N = value ;
   }

   protected byte gxTv_SdtCategoria_Provincias_Catprovrelsec_N ;
   protected byte gxTv_SdtCategoria_Provincias_Catprovrelref_N ;
   protected byte gxTv_SdtCategoria_Provincias_Catprovold_N ;
   private byte gxTv_SdtCategoria_Provincias_N ;
   protected short gxTv_SdtCategoria_Provincias_Catpaicod ;
   protected short gxTv_SdtCategoria_Provincias_Catprovcod ;
   protected short gxTv_SdtCategoria_Provincias_Modified ;
   protected short gxTv_SdtCategoria_Provincias_Initialized ;
   protected short gxTv_SdtCategoria_Provincias_Catpaicod_Z ;
   protected short gxTv_SdtCategoria_Provincias_Catprovcod_Z ;
   protected int gxTv_SdtCategoria_Provincias_Catprovrelsec ;
   protected int gxTv_SdtCategoria_Provincias_Catprovrelsec_Z ;
   protected String gxTv_SdtCategoria_Provincias_Mode ;
   protected String gxTv_SdtCategoria_Provincias_Catprovold ;
   protected String gxTv_SdtCategoria_Provincias_Catprovrelref ;
   protected String gxTv_SdtCategoria_Provincias_Catprovrelref_Z ;
}

