package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_retPerPago implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_retPerPago( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_retPerPago.class ));
   }

   public StructSdtpresentacion_1_18_retPerPago( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Montototal = new java.math.BigDecimal(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(1) ;
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
      return gxTv_Sdtpresentacion_1_18_retPerPago_Tipo ;
   }

   public void setTipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipo = value ;
   }

   public byte getTipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc ;
   }

   public void setTipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc = value ;
   }

   public long getNrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc ;
   }

   public void setNrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc = value ;
   }

   public String getDenominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion ;
   }

   public void setDenominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion = value ;
   }

   public String getDescbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica ;
   }

   public void setDescbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica = value ;
   }

   public String getDescadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional ;
   }

   public void setDescadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional = value ;
   }

   public java.math.BigDecimal getMontototal( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Montototal ;
   }

   public void setMontototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Montototal = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_periodo> getPeriodos( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Periodos ;
   }

   public void setPeriodos( java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_periodo> value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Periodos = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_detalle> getDetalles( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_Detalles ;
   }

   public void setDetalles( java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_Detalles = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Periodos_N ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_Detalles_N ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_N ;
   protected long gxTv_Sdtpresentacion_1_18_retPerPago_Nrodoc ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_Descadicional ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_retPerPago_Montototal ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_periodo> gxTv_Sdtpresentacion_1_18_retPerPago_Periodos=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago_detalle> gxTv_Sdtpresentacion_1_18_retPerPago_Detalles=null ;
}

