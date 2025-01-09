package web ;
import com.genexus.*;

public final  class StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem.class ));
   }

   public StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo = "" ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = cal.getTime() ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod = "" ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(1) ;
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

   public String getCatcodigo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo = value ;
   }

   public java.math.BigDecimal getSueldobasico( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico ;
   }

   public void setSueldobasico( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico = value ;
   }

   public int getPeriodo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo ;
   }

   public void setPeriodo( int value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod = value ;
   }

   public byte getLiqpermes( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes ;
   }

   public void setLiqpermes( byte value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes = value ;
   }

   public short getLiqperano( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano ;
   }

   public void setLiqperano( short value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano = value ;
   }

   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes ;
   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N ;
   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N ;
   protected short gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano ;
   protected int gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo ;
   protected String gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo ;
   protected String gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod ;
   protected java.math.BigDecimal gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico ;
   protected java.util.Date gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo ;
}

