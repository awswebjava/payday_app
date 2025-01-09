package web ;
import com.genexus.*;

public final  class StructSdttasas_y_tramos_de_escala_tramo implements Cloneable, java.io.Serializable
{
   public StructSdttasas_y_tramos_de_escala_tramo( )
   {
      this( -1, new ModelContext( StructSdttasas_y_tramos_de_escala_tramo.class ));
   }

   public StructSdttasas_y_tramos_de_escala_tramo( int remoteHandle ,
                                                   ModelContext context )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta = new java.math.BigDecimal(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe = new java.math.BigDecimal(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel = new java.math.BigDecimal(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto = new java.math.BigDecimal(0) ;
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
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta ;
   }

   public void setHasta( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta = value ;
   }

   public java.math.BigDecimal getImporte( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe ;
   }

   public void setImporte( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe = value ;
   }

   public java.math.BigDecimal getMasel( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel ;
   }

   public void setMasel( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel = value ;
   }

   public java.math.BigDecimal getResto( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto ;
   }

   public void setResto( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto = value ;
   }

   protected byte gxTv_Sdttasas_y_tramos_de_escala_tramo_N ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto ;
}

