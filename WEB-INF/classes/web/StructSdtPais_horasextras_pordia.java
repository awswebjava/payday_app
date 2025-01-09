package web ;
import com.genexus.*;

public final  class StructSdtPais_horasextras_pordia implements Cloneable, java.io.Serializable
{
   public StructSdtPais_horasextras_pordia( )
   {
      this( -1, new ModelContext( StructSdtPais_horasextras_pordia.class ));
   }

   public StructSdtPais_horasextras_pordia( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = "" ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_horasextras_pordia_Mode = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = "" ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(1) ;
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

   public short getPaihsexsec( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihsexsec ;
   }

   public void setPaihsexsec( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihsexsec = value ;
   }

   public String getPaihspdiatiptra( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra ;
   }

   public void setPaihspdiatiptra( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = value ;
   }

   public byte getPaihspdiadia( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadia ;
   }

   public void setPaihspdiadia( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadia = value ;
   }

   public String getPaihspdiadesde( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde ;
   }

   public void setPaihspdiadesde( String value )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = value ;
   }

   public java.math.BigDecimal getPaitarifapdia( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdia ;
   }

   public void setPaitarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia = value ;
   }

   public java.math.BigDecimal getPaitarifapdrec( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdrec ;
   }

   public void setPaitarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_horasextras_pordia_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_horasextras_pordia_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_horasextras_pordia_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Initialized = value ;
   }

   public short getPaihsexsec_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z ;
   }

   public void setPaihsexsec_Z( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z = value ;
   }

   public String getPaihspdiatiptra_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z ;
   }

   public void setPaihspdiatiptra_Z( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = value ;
   }

   public byte getPaihspdiadia_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z ;
   }

   public void setPaihspdiadia_Z( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z = value ;
   }

   public String getPaihspdiadesde_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z ;
   }

   public void setPaihspdiadesde_Z( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = value ;
   }

   public java.math.BigDecimal getPaitarifapdia_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z ;
   }

   public void setPaitarifapdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = value ;
   }

   public java.math.BigDecimal getPaitarifapdrec_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z ;
   }

   public void setPaitarifapdrec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = value ;
   }

   public byte getPaihspdiadesde_N( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N ;
   }

   public void setPaihspdiadesde_N( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = value ;
   }

   protected byte gxTv_SdtPais_horasextras_pordia_Paihspdiadia ;
   protected byte gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z ;
   protected byte gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N ;
   private byte gxTv_SdtPais_horasextras_pordia_N ;
   protected short gxTv_SdtPais_horasextras_pordia_Paihsexsec ;
   protected short gxTv_SdtPais_horasextras_pordia_Modified ;
   protected short gxTv_SdtPais_horasextras_pordia_Initialized ;
   protected short gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z ;
   protected String gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra ;
   protected String gxTv_SdtPais_horasextras_pordia_Paihspdiadesde ;
   protected String gxTv_SdtPais_horasextras_pordia_Mode ;
   protected String gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z ;
   protected String gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdia ;
   protected java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdrec ;
   protected java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z ;
}

