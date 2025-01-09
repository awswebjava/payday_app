package web ;
import com.genexus.*;

public final  class StructSdtSDTLegajos_SDTLegajosItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTLegajos_SDTLegajosItem( )
   {
      this( -1, new ModelContext( StructSdtSDTLegajos_SDTLegajosItem.class ));
   }

   public StructSdtSDTLegajos_SDTLegajosItem( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legid = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti = new java.math.BigDecimal(0) ;
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

   public int getLegnumero( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero = value ;
   }

   public String getLegid( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legid ;
   }

   public void setLegid( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legid = value ;
   }

   public String getLegapellido( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido ;
   }

   public void setLegapellido( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido = value ;
   }

   public String getLegnombre( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre ;
   }

   public void setLegnombre( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre = value ;
   }

   public String getLegidnomape( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape ;
   }

   public void setLegidnomape( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape = value ;
   }

   public boolean getSeleccionado( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado ;
   }

   public void setSeleccionado( boolean value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado = value ;
   }

   public java.math.BigDecimal getAgecanti( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti ;
   }

   public void setAgecanti( java.math.BigDecimal value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti = value ;
   }

   protected byte gxTv_SdtSDTLegajos_SDTLegajosItem_N ;
   protected int gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legid ;
   protected boolean gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape ;
   protected java.math.BigDecimal gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti ;
}

