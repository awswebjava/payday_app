package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_ajuste implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_ajuste( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_ajuste.class ));
   }

   public StructSdtpresentacion_1_18_ajuste( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_ajuste_Montototal = new java.math.BigDecimal(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(1) ;
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

   public String getTipo( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Tipo ;
   }

   public void setTipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Tipo = value ;
   }

   public long getCuit( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Cuit ;
   }

   public void setCuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Cuit = value ;
   }

   public String getDenominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Denominacion ;
   }

   public void setDenominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Denominacion = value ;
   }

   public String getDescbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Descbasica ;
   }

   public void setDescbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descbasica = value ;
   }

   public String getDescadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Descadicional ;
   }

   public void setDescadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Descadicional = value ;
   }

   public java.math.BigDecimal getMontototal( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Montototal ;
   }

   public void setMontototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Montototal = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_ajuste_detalle> getDetalles( )
   {
      return gxTv_Sdtpresentacion_1_18_ajuste_Detalles ;
   }

   public void setDetalles( java.util.Vector<web.StructSdtpresentacion_1_18_ajuste_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_ajuste_Detalles = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_ajuste_Detalles_N ;
   protected byte gxTv_Sdtpresentacion_1_18_ajuste_N ;
   protected long gxTv_Sdtpresentacion_1_18_ajuste_Cuit ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_ajuste_Descadicional ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_ajuste_Montototal ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_ajuste_detalle> gxTv_Sdtpresentacion_1_18_ajuste_Detalles=null ;
}

