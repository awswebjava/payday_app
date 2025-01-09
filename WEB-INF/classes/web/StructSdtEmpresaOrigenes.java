package web ;
import com.genexus.*;

public final  class StructSdtEmpresaOrigenes implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresaOrigenes( )
   {
      this( -1, new ModelContext( StructSdtEmpresaOrigenes.class ));
   }

   public StructSdtEmpresaOrigenes( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtEmpresaOrigenes_Emporigen = "" ;
      gxTv_SdtEmpresaOrigenes_Mode = "" ;
      gxTv_SdtEmpresaOrigenes_Emporigen_Z = "" ;
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
      return gxTv_SdtEmpresaOrigenes_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtEmpresaOrigenes_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Empcod = value ;
   }

   public String getEmporigen( )
   {
      return gxTv_SdtEmpresaOrigenes_Emporigen ;
   }

   public void setEmporigen( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Emporigen = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresaOrigenes_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresaOrigenes_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Empcod_Z = value ;
   }

   public String getEmporigen_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Emporigen_Z ;
   }

   public void setEmporigen_Z( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      gxTv_SdtEmpresaOrigenes_Emporigen_Z = value ;
   }

   private byte gxTv_SdtEmpresaOrigenes_N ;
   protected short gxTv_SdtEmpresaOrigenes_Empcod ;
   protected short gxTv_SdtEmpresaOrigenes_Initialized ;
   protected short gxTv_SdtEmpresaOrigenes_Empcod_Z ;
   protected int gxTv_SdtEmpresaOrigenes_Clicod ;
   protected int gxTv_SdtEmpresaOrigenes_Clicod_Z ;
   protected String gxTv_SdtEmpresaOrigenes_Emporigen ;
   protected String gxTv_SdtEmpresaOrigenes_Mode ;
   protected String gxTv_SdtEmpresaOrigenes_Emporigen_Z ;
}

