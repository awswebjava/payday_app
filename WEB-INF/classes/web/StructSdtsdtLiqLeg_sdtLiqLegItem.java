package web ;
import com.genexus.*;

public final  class StructSdtsdtLiqLeg_sdtLiqLegItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtLiqLeg_sdtLiqLegItem( )
   {
      this( -1, new ModelContext( StructSdtsdtLiqLeg_sdtLiqLegItem.class ));
   }

   public StructSdtsdtLiqLeg_sdtLiqLegItem( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal = new java.math.BigDecimal(0) ;
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

   public int getImplegnumero( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero ;
   }

   public void setImplegnumero( int value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero = value ;
   }

   public java.math.BigDecimal getLiqlegimptotal( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal ;
   }

   public void setLiqlegimptotal( java.math.BigDecimal value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal = value ;
   }

   public int getMiolegnumero( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero ;
   }

   public void setMiolegnumero( int value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero = value ;
   }

   protected byte gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N ;
   protected int gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero ;
   protected int gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero ;
   protected java.math.BigDecimal gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal ;
}

