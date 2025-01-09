package web ;
import com.genexus.*;

public final  class StructSdtsdt_detalle_sdt_detalleItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_detalle_sdt_detalleItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_detalle_sdt_detalleItem.class ));
   }

   public StructSdtsdt_detalle_sdt_detalleItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo = "" ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu = new java.math.BigDecimal(0) ;
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

   public String getConcodigo( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo = value ;
   }

   public java.math.BigDecimal getLiqdimpcalcu( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu ;
   }

   public void setLiqdimpcalcu( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu = value ;
   }

   public boolean getEncontrado( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado ;
   }

   public void setEncontrado( boolean value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado = value ;
   }

   protected byte gxTv_Sdtsdt_detalle_sdt_detalleItem_N ;
   protected String gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo ;
   protected boolean gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado ;
   protected java.math.BigDecimal gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu ;
}

