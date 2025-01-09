package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_retPerPago_periodo implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_retPerPago_periodo( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_retPerPago_periodo.class ));
   }

   public StructSdtpresentacion_1_18_retPerPago_periodo( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual = new java.math.BigDecimal(0) ;
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

   public byte getMesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde ;
   }

   public void setMesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde = value ;
   }

   public byte getMeshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta ;
   }

   public void setMeshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta = value ;
   }

   public java.math.BigDecimal getMontomensual( )
   {
      return gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual ;
   }

   public void setMontomensual( java.math.BigDecimal value )
   {
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Meshasta ;
   protected byte gxTv_Sdtpresentacion_1_18_retPerPago_periodo_N ;
   protected java.math.BigDecimal gxTv_Sdtpresentacion_1_18_retPerPago_periodo_Montomensual ;
}

