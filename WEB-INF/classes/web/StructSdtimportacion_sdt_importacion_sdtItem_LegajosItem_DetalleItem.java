package web ;
import com.genexus.*;

public final  class StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem implements Cloneable, java.io.Serializable
{
   public StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( )
   {
      this( -1, new ModelContext( StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem.class ));
   }

   public StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( int remoteHandle ,
                                                                                ModelContext context )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum = new java.math.BigDecimal(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getImpliqdetimpnum( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum ;
   }

   public void setImpliqdetimpnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum = value ;
   }

   public String getImpliqdetconsis( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis ;
   }

   public void setImpliqdetconsis( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis = value ;
   }

   public String getImpliqdetsigno( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno ;
   }

   public void setImpliqdetsigno( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno = value ;
   }

   public String getImpliqconextdescrip( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip ;
   }

   public void setImpliqconextdescrip( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip = value ;
   }

   public java.math.BigDecimal getImpliqdetcantnum( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum ;
   }

   public void setImpliqdetcantnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum = value ;
   }

   public boolean getEsdescuentodias( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias ;
   }

   public void setEsdescuentodias( boolean value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias = value ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno ;
   protected boolean gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum ;
}

