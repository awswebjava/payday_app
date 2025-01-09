package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_retPerPago_detalle implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_retPerPago_detalle( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_retPerPago_detalle.class ));
   }

   public StructSdtpresentacion_1_18_retPerPago_detalle( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Valor = "" ;
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

   public String getNombre( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Nombre = value ;
   }

   public String getValor( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Valor ;
   }

   public void setValor( String value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Valor = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_detalle_N ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_retPerPago_detalle_Valor ;
}

