package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_empleado_direccion implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_empleado_direccion( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_empleado_direccion.class ));
   }

   public StructSdtpresentacion_1_18_empleado_direccion( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle = "" ;
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

   public byte getProvincia( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia ;
   }

   public void setProvincia( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia = value ;
   }

   public short getCp( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp ;
   }

   public void setCp( short value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp = value ;
   }

   public String getLocalidad( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad ;
   }

   public void setLocalidad( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad = value ;
   }

   public String getCalle( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle ;
   }

   public void setCalle( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle = value ;
   }

   public byte getNro( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro ;
   }

   public void setNro( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro = value ;
   }

   public byte getPiso( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso ;
   }

   public void setPiso( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso = value ;
   }

   public byte getDpto( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto ;
   }

   public void setDpto( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_N ;
   protected short gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle ;
}

