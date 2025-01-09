package web ;
import com.genexus.*;

public final  class StructSdtsdt_liquidacion_sdt_liquidacionItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_liquidacion_sdt_liquidacionItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_liquidacion_sdt_liquidacionItem.class ));
   }

   public StructSdtsdt_liquidacion_sdt_liquidacionItem( int remoteHandle ,
                                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = cal.getTime() ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(1) ;
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
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = value ;
   }

   public boolean getIncluir( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir ;
   }

   public void setIncluir( boolean value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir = value ;
   }

   protected byte gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N ;
   protected byte gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N ;
   protected int gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro ;
   protected boolean gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir ;
   protected java.util.Date gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo ;
}

