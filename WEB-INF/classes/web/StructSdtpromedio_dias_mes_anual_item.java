package web ;
import com.genexus.*;

public final  class StructSdtpromedio_dias_mes_anual_item implements Cloneable, java.io.Serializable
{
   public StructSdtpromedio_dias_mes_anual_item( )
   {
      this( -1, new ModelContext( StructSdtpromedio_dias_mes_anual_item.class ));
   }

   public StructSdtpromedio_dias_mes_anual_item( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad = new java.math.BigDecimal(0) ;
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

   public short getAnio( )
   {
      return gxTv_Sdtpromedio_dias_mes_anual_item_Anio ;
   }

   public void setAnio( short value )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_N = (byte)(0) ;
      gxTv_Sdtpromedio_dias_mes_anual_item_Anio = value ;
   }

   public java.math.BigDecimal getCantidad( )
   {
      return gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad ;
   }

   public void setCantidad( java.math.BigDecimal value )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_N = (byte)(0) ;
      gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad = value ;
   }

   protected byte gxTv_Sdtpromedio_dias_mes_anual_item_N ;
   protected short gxTv_Sdtpromedio_dias_mes_anual_item_Anio ;
   protected java.math.BigDecimal gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad ;
}

