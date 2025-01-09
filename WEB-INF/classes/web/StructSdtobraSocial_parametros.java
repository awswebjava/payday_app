package web ;
import com.genexus.*;

public final  class StructSdtobraSocial_parametros implements Cloneable, java.io.Serializable
{
   public StructSdtobraSocial_parametros( )
   {
      this( -1, new ModelContext( StructSdtobraSocial_parametros.class ));
   }

   public StructSdtobraSocial_parametros( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtobraSocial_parametros_Osoprcsuperatope = new java.math.BigDecimal(0) ;
      gxTv_SdtobraSocial_parametros_Osoprchastatope = new java.math.BigDecimal(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope = new java.math.BigDecimal(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getOsoprcsuperatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcsuperatope ;
   }

   public void setOsoprcsuperatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcsuperatope = value ;
   }

   public java.math.BigDecimal getOsoprchastatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprchastatope ;
   }

   public void setOsoprchastatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprchastatope = value ;
   }

   public java.math.BigDecimal getOsoprcanssalsuperatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope ;
   }

   public void setOsoprcanssalsuperatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope = value ;
   }

   public java.math.BigDecimal getOsoprcanssalhastatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope ;
   }

   public void setOsoprcanssalhastatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope = value ;
   }

   public boolean getOsojerarquica( )
   {
      return gxTv_SdtobraSocial_parametros_Osojerarquica ;
   }

   public void setOsojerarquica( boolean value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osojerarquica = value ;
   }

   protected byte gxTv_SdtobraSocial_parametros_N ;
   protected boolean gxTv_SdtobraSocial_parametros_Osojerarquica ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcsuperatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprchastatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope ;
}

