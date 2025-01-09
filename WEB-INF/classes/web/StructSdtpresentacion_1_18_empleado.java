package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_empleado implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_empleado( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_empleado.class ));
   }

   public StructSdtpresentacion_1_18_empleado( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_empleado_Apellido = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(1) ;
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

   public long getCuit( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Cuit ;
   }

   public void setCuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Cuit = value ;
   }

   public byte getTipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Tipodoc ;
   }

   public void setTipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Tipodoc = value ;
   }

   public String getApellido( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Apellido ;
   }

   public void setApellido( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Apellido = value ;
   }

   public String getNombre( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Nombre = value ;
   }

   public web.StructSdtpresentacion_1_18_empleado_direccion getDireccion( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Direccion ;
   }

   public void setDireccion( web.StructSdtpresentacion_1_18_empleado_direccion value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Direccion = value;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empleado_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_Direccion_N ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_N ;
   protected long gxTv_Sdtpresentacion_1_18_empleado_Cuit ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_Apellido ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_Nombre ;
   protected web.StructSdtpresentacion_1_18_empleado_direccion gxTv_Sdtpresentacion_1_18_empleado_Direccion=null ;
}

