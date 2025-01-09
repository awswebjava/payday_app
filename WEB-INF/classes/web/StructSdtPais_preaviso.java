package web ;
import com.genexus.*;

public final  class StructSdtPais_preaviso implements Cloneable, java.io.Serializable
{
   public StructSdtPais_preaviso( )
   {
      this( -1, new ModelContext( StructSdtPais_preaviso.class ));
   }

   public StructSdtPais_preaviso( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtPais_preaviso_Paiantmaydur = "" ;
      gxTv_SdtPais_preaviso_Paipreavidur = "" ;
      gxTv_SdtPais_preaviso_Mode = "" ;
      gxTv_SdtPais_preaviso_Paiantmaydur_Z = "" ;
      gxTv_SdtPais_preaviso_Paipreavidur_Z = "" ;
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

   public byte getPaiantmaycant( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaycant ;
   }

   public void setPaiantmaycant( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paiantmaycant = value ;
   }

   public String getPaiantmaydur( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaydur ;
   }

   public void setPaiantmaydur( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paiantmaydur = value ;
   }

   public byte getPaipreavicant( )
   {
      return gxTv_SdtPais_preaviso_Paipreavicant ;
   }

   public void setPaipreavicant( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paipreavicant = value ;
   }

   public String getPaipreavidur( )
   {
      return gxTv_SdtPais_preaviso_Paipreavidur ;
   }

   public void setPaipreavidur( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paipreavidur = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_preaviso_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_preaviso_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_preaviso_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Initialized = value ;
   }

   public byte getPaiantmaycant_Z( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaycant_Z ;
   }

   public void setPaiantmaycant_Z( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paiantmaycant_Z = value ;
   }

   public String getPaiantmaydur_Z( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaydur_Z ;
   }

   public void setPaiantmaydur_Z( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paiantmaydur_Z = value ;
   }

   public byte getPaipreavicant_Z( )
   {
      return gxTv_SdtPais_preaviso_Paipreavicant_Z ;
   }

   public void setPaipreavicant_Z( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paipreavicant_Z = value ;
   }

   public String getPaipreavidur_Z( )
   {
      return gxTv_SdtPais_preaviso_Paipreavidur_Z ;
   }

   public void setPaipreavidur_Z( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Paipreavidur_Z = value ;
   }

   protected byte gxTv_SdtPais_preaviso_Paiantmaycant ;
   protected byte gxTv_SdtPais_preaviso_Paipreavicant ;
   protected byte gxTv_SdtPais_preaviso_Paiantmaycant_Z ;
   protected byte gxTv_SdtPais_preaviso_Paipreavicant_Z ;
   private byte gxTv_SdtPais_preaviso_N ;
   protected short gxTv_SdtPais_preaviso_Modified ;
   protected short gxTv_SdtPais_preaviso_Initialized ;
   protected String gxTv_SdtPais_preaviso_Paiantmaydur ;
   protected String gxTv_SdtPais_preaviso_Paipreavidur ;
   protected String gxTv_SdtPais_preaviso_Mode ;
   protected String gxTv_SdtPais_preaviso_Paiantmaydur_Z ;
   protected String gxTv_SdtPais_preaviso_Paipreavidur_Z ;
}

