package web ;
import com.genexus.*;

public final  class StructSdtimportacion_sdt_importacion_sdtItem implements Cloneable, java.io.Serializable
{
   public StructSdtimportacion_sdt_importacion_sdtItem( )
   {
      this( -1, new ModelContext( StructSdtimportacion_sdt_importacion_sdtItem.class ));
   }

   public StructSdtimportacion_sdt_importacion_sdtItem( int remoteHandle ,
                                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = cal.getTime() ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(1) ;
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

   public String getImpliqdetper( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper ;
   }

   public void setImpliqdetper( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper = value ;
   }

   public String getLiqdescrip( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip ;
   }

   public void setLiqdescrip( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip = value ;
   }

   public byte getLiqclase( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase ;
   }

   public void setLiqclase( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase = value ;
   }

   public byte getLiqfrecpag( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag ;
   }

   public void setLiqfrecpag( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag = value ;
   }

   public String getLiqtipotarifa( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa ;
   }

   public void setLiqtipotarifa( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod = value ;
   }

   public String getLiqnombre( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre ;
   }

   public void setLiqnombre( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = value ;
   }

   public byte getLiqpermes( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes ;
   }

   public void setLiqpermes( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes = value ;
   }

   public short getLiqperano( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano ;
   }

   public void setLiqperano( short value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro = value ;
   }

   public short getSec( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec ;
   }

   public void setSec( short value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec = value ;
   }

   public java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem> getLegajos( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos ;
   }

   public void setLegajos( java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem> value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos = value ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_N ;
   protected short gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano ;
   protected short gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec ;
   protected int gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre ;
   protected java.util.Date gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo ;
   protected java.util.Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos=null ;
}

