package web ;
import com.genexus.*;

public final  class StructSdtsdt_dedEspInc_sdt_dedEspIncItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_dedEspInc_sdt_dedEspIncItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_dedEspInc_sdt_dedEspIncItem.class ));
   }

   public StructSdtsdt_dedEspInc_sdt_dedEspIncItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getHasta( )
   {
      return gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta ;
   }

   public void setHasta( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N = (byte)(0) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta = value ;
   }

   public java.math.BigDecimal getDeduccion( )
   {
      return gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion ;
   }

   public void setDeduccion( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N = (byte)(0) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion = value ;
   }

   protected byte gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N ;
   protected java.math.BigDecimal gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta ;
   protected java.math.BigDecimal gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion ;
}

