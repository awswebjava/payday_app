package web ;
import com.genexus.*;

public final  class StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem implements Cloneable, java.io.Serializable
{
   public StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem( )
   {
      this( -1, new ModelContext( StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem.class ));
   }

   public StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem( int remoteHandle ,
                                                                    ModelContext context )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes = new java.math.BigDecimal(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(1) ;
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
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero = value ;
   }

   public java.math.BigDecimal getNetoimportes( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes ;
   }

   public void setNetoimportes( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes = value ;
   }

   public boolean getDuplica( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica ;
   }

   public void setDuplica( boolean value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica = value ;
   }

   public java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> getDetalle( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle ;
   }

   public void setDetalle( java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle = value ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N ;
   protected int gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero ;
   protected boolean gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes ;
   protected java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle=null ;
}

