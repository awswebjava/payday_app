package web ;
import com.genexus.*;

public final  class StructSdtPaisExtraOrdinarias_old implements Cloneable, java.io.Serializable
{
   public StructSdtPaisExtraOrdinarias_old( )
   {
      this( -1, new ModelContext( StructSdtPaisExtraOrdinarias_old.class ));
   }

   public StructSdtPaisExtraOrdinarias_old( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra = "" ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde = "" ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia = new java.math.BigDecimal(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec = new java.math.BigDecimal(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri = "" ;
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

   public String getPaihspdiatiptra( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra ;
   }

   public void setPaihspdiatiptra( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra = value ;
   }

   public byte getPaihspdiadia( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia ;
   }

   public void setPaihspdiadia( byte value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia = value ;
   }

   public String getPaihspdiadesde( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde ;
   }

   public void setPaihspdiadesde( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde = value ;
   }

   public java.math.BigDecimal getPaitarifapdia( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia ;
   }

   public void setPaitarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia = value ;
   }

   public java.math.BigDecimal getPaitarifapdrec( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec ;
   }

   public void setPaitarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec = value ;
   }

   public String getPaitarifapdcri( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri ;
   }

   public void setPaitarifapdcri( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri = value ;
   }

   protected byte gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia ;
   protected byte gxTv_SdtPaisExtraOrdinarias_old_N ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri ;
   protected java.math.BigDecimal gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia ;
   protected java.math.BigDecimal gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec ;
}

