package web ;
import com.genexus.*;

public final  class StructSdtF1357_GNSI implements Cloneable, java.io.Serializable
{
   public StructSdtF1357_GNSI( )
   {
      this( -1, new ModelContext( StructSdtF1357_GNSI.class ));
   }

   public StructSdtF1357_GNSI( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtF1357_GNSI_F1357lrgravada = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_GNSI_F1357ldgtotal = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_GNSI_F1357ldptotalart30 = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_GNSI_Descuentosdeley = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_GNSI_Anticiposdesac = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getF1357lrgravada( )
   {
      return gxTv_SdtF1357_GNSI_F1357lrgravada ;
   }

   public void setF1357lrgravada( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357lrgravada = value ;
   }

   public java.math.BigDecimal getF1357ldgtotal( )
   {
      return gxTv_SdtF1357_GNSI_F1357ldgtotal ;
   }

   public void setF1357ldgtotal( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357ldgtotal = value ;
   }

   public java.math.BigDecimal getF1357ldptotalart30( )
   {
      return gxTv_SdtF1357_GNSI_F1357ldptotalart30 ;
   }

   public void setF1357ldptotalart30( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_F1357ldptotalart30 = value ;
   }

   public java.math.BigDecimal getDescuentosdeley( )
   {
      return gxTv_SdtF1357_GNSI_Descuentosdeley ;
   }

   public void setDescuentosdeley( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_Descuentosdeley = value ;
   }

   public java.math.BigDecimal getAnticiposdesac( )
   {
      return gxTv_SdtF1357_GNSI_Anticiposdesac ;
   }

   public void setAnticiposdesac( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GNSI_N = (byte)(0) ;
      gxTv_SdtF1357_GNSI_Anticiposdesac = value ;
   }

   protected byte gxTv_SdtF1357_GNSI_N ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357lrgravada ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357ldgtotal ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_F1357ldptotalart30 ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_Descuentosdeley ;
   protected java.math.BigDecimal gxTv_SdtF1357_GNSI_Anticiposdesac ;
}

