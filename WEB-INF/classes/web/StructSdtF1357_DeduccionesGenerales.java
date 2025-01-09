package web ;
import com.genexus.*;

public final  class StructSdtF1357_DeduccionesGenerales implements Cloneable, java.io.Serializable
{
   public StructSdtF1357_DeduccionesGenerales( )
   {
      this( -1, new ModelContext( StructSdtF1357_DeduccionesGenerales.class ));
   }

   public StructSdtF1357_DeduccionesGenerales( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtF1357_DeduccionesGenerales_Jub = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Os = new java.math.BigDecimal(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Cuotasin = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getJub( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Jub ;
   }

   public void setJub( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Jub = value ;
   }

   public java.math.BigDecimal getOs( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Os ;
   }

   public void setOs( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Os = value ;
   }

   public java.math.BigDecimal getCuotasin( )
   {
      return gxTv_SdtF1357_DeduccionesGenerales_Cuotasin ;
   }

   public void setCuotasin( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_DeduccionesGenerales_N = (byte)(0) ;
      gxTv_SdtF1357_DeduccionesGenerales_Cuotasin = value ;
   }

   protected byte gxTv_SdtF1357_DeduccionesGenerales_N ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Jub ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Os ;
   protected java.math.BigDecimal gxTv_SdtF1357_DeduccionesGenerales_Cuotasin ;
}

