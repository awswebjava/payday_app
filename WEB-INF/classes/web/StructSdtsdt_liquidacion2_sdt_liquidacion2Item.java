package web ;
import com.genexus.*;

public final  class StructSdtsdt_liquidacion2_sdt_liquidacion2Item implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_liquidacion2_sdt_liquidacion2Item( )
   {
      this( -1, new ModelContext( StructSdtsdt_liquidacion2_sdt_liquidacion2Item.class ));
   }

   public StructSdtsdt_liquidacion2_sdt_liquidacion2Item( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre = "" ;
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

   public int getLiqnro( )
   {
      return gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro = value ;
   }

   public String getLiqnombre( )
   {
      return gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre ;
   }

   public void setLiqnombre( String value )
   {
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre = value ;
   }

   protected byte gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_N ;
   protected int gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro ;
   protected String gxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre ;
}

