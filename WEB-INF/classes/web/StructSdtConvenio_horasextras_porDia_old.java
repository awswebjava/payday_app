package web ;
import com.genexus.*;

public final  class StructSdtConvenio_horasextras_porDia_old implements Cloneable, java.io.Serializable
{
   public StructSdtConvenio_horasextras_porDia_old( )
   {
      this( -1, new ModelContext( StructSdtConvenio_horasextras_porDia_old.class ));
   }

   public StructSdtConvenio_horasextras_porDia_old( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra = "" ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde = "" ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia = new java.math.BigDecimal(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec = new java.math.BigDecimal(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri = "" ;
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

   public String getConvhspdiatiptra( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra ;
   }

   public void setConvhspdiatiptra( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra = value ;
   }

   public byte getConvehspdiadia( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia ;
   }

   public void setConvehspdiadia( byte value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia = value ;
   }

   public String getConvehspdiadesde( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde ;
   }

   public void setConvehspdiadesde( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde = value ;
   }

   public java.math.BigDecimal getConvetarifapdia( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia ;
   }

   public void setConvetarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia = value ;
   }

   public java.math.BigDecimal getConvetarifapdrec( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec ;
   }

   public void setConvetarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec = value ;
   }

   public String getConvetarifapdcri( )
   {
      return gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri ;
   }

   public void setConvetarifapdcri( String value )
   {
      gxTv_SdtConvenio_horasextras_porDia_old_N = (byte)(0) ;
      gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri = value ;
   }

   protected byte gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia ;
   protected byte gxTv_SdtConvenio_horasextras_porDia_old_N ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde ;
   protected String gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri ;
   protected java.math.BigDecimal gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia ;
   protected java.math.BigDecimal gxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec ;
}

