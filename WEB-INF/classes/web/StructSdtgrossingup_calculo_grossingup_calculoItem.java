package web ;
import com.genexus.*;

public final  class StructSdtgrossingup_calculo_grossingup_calculoItem implements Cloneable, java.io.Serializable
{
   public StructSdtgrossingup_calculo_grossingup_calculoItem( )
   {
      this( -1, new ModelContext( StructSdtgrossingup_calculo_grossingup_calculoItem.class ));
   }

   public StructSdtgrossingup_calculo_grossingup_calculoItem( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo = new java.math.BigDecimal(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto = new java.math.BigDecimal(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado = "" ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador = new java.math.BigDecimal(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta = new java.math.BigDecimal(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos = new java.math.BigDecimal(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog = "" ;
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

   public java.math.BigDecimal getCalculo( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo ;
   }

   public void setCalculo( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo = value ;
   }

   public java.math.BigDecimal getNeto( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto ;
   }

   public void setNeto( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto = value ;
   }

   public String getResultado( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado ;
   }

   public void setResultado( String value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado = value ;
   }

   public java.math.BigDecimal getMultiplicador( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador ;
   }

   public void setMultiplicador( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador = value ;
   }

   public java.math.BigDecimal getFalta( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta ;
   }

   public void setFalta( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta = value ;
   }

   public java.math.BigDecimal getDescuentosexcluidos( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos ;
   }

   public void setDescuentosexcluidos( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos = value ;
   }

   public String getLiqdlog( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog ;
   }

   public void setLiqdlog( String value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog = value ;
   }

   protected byte gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N ;
   protected String gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado ;
   protected String gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos ;
}

