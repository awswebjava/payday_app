package web ;
import com.genexus.*;

public final  class StructSdtEmpresaReligiones implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresaReligiones( )
   {
      this( -1, new ModelContext( StructSdtEmpresaReligiones.class ));
   }

   public StructSdtEmpresaReligiones( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtEmpresaReligiones_Empreligion = "" ;
      gxTv_SdtEmpresaReligiones_Mode = "" ;
      gxTv_SdtEmpresaReligiones_Empreligion_Z = "" ;
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
      return gxTv_SdtEmpresaReligiones_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtEmpresaReligiones_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Empcod = value ;
   }

   public String getEmpreligion( )
   {
      return gxTv_SdtEmpresaReligiones_Empreligion ;
   }

   public void setEmpreligion( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Empreligion = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresaReligiones_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresaReligiones_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Empcod_Z = value ;
   }

   public String getEmpreligion_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Empreligion_Z ;
   }

   public void setEmpreligion_Z( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      gxTv_SdtEmpresaReligiones_Empreligion_Z = value ;
   }

   private byte gxTv_SdtEmpresaReligiones_N ;
   protected short gxTv_SdtEmpresaReligiones_Empcod ;
   protected short gxTv_SdtEmpresaReligiones_Initialized ;
   protected short gxTv_SdtEmpresaReligiones_Empcod_Z ;
   protected int gxTv_SdtEmpresaReligiones_Clicod ;
   protected int gxTv_SdtEmpresaReligiones_Clicod_Z ;
   protected String gxTv_SdtEmpresaReligiones_Empreligion ;
   protected String gxTv_SdtEmpresaReligiones_Mode ;
   protected String gxTv_SdtEmpresaReligiones_Empreligion_Z ;
}

