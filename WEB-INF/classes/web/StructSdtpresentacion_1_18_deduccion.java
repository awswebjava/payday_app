package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_deduccion implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_deduccion( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_deduccion.class ));
   }

   public StructSdtpresentacion_1_18_deduccion( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Tipo = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descbasica = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descadicional = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_Montototal = new java.math.BigDecimal(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(1) ;
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
      return gxTv_Sdtpresentacion_1_18_deduccion_Tipo ;
   }

   public void setTipo( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Tipo = value ;
   }

   public byte getTipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc ;
   }

   public void setTipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc = value ;
   }

   public long getNrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc ;
   }

   public void setNrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc = value ;
   }

   public String getDenominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Denominacion ;
   }

   public void setDenominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Denominacion = value ;
   }

   public String getDescbasica( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Descbasica ;
   }

   public void setDescbasica( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descbasica = value ;
   }

   public String getDescadicional( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Descadicional ;
   }

   public void setDescadicional( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Descadicional = value ;
   }

   public java.math.BigDecimal getMontototal( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Montototal ;
   }

   public void setMontototal( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Montototal = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_detalle> getDetalles( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Detalles ;
   }

   public void setDetalles( java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_detalle> value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Detalles = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_periodo> getPeriodos( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_Periodos ;
   }

   public void setPeriodos( java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_periodo> value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_Periodos = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Detalles_N ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_Periodos_N ;
   protected byte gxTv_Sdtpresentacion_1_18_deduccion_N ;
   protected long gxTv_Sdtpresentacion_1_18_deduccion_Nrodoc ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Tipo ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Denominacion ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Descbasica ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_Descadicional ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_deduccion_Montototal ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_detalle> gxTv_Sdtpresentacion_1_18_deduccion_Detalles=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_deduccion_periodo> gxTv_Sdtpresentacion_1_18_deduccion_Periodos=null ;
}

