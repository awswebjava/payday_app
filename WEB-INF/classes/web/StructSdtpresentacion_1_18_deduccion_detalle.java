package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_deduccion_detalle implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_deduccion_detalle( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_deduccion_detalle.class ));
   }

   public StructSdtpresentacion_1_18_deduccion_detalle( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor = "" ;
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
      return gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre = value ;
   }

   public String getValor( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor ;
   }

   public void setValor( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_deduccion_detalle_N ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor ;
}

