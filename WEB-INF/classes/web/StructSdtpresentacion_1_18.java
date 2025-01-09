package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18 implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18.class ));
   }

   public StructSdtpresentacion_1_18( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtpresentacion_1_18_Fechapresentacion = cal.getTime() ;
      gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(1) ;
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

   public short getPeriodo( )
   {
      return gxTv_Sdtpresentacion_1_18_Periodo ;
   }

   public void setPeriodo( short value )
   {
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Periodo = value ;
   }

   public byte getNropresentacion( )
   {
      return gxTv_Sdtpresentacion_1_18_Nropresentacion ;
   }

   public void setNropresentacion( byte value )
   {
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Nropresentacion = value ;
   }

   public java.util.Date getFechapresentacion( )
   {
      return gxTv_Sdtpresentacion_1_18_Fechapresentacion ;
   }

   public void setFechapresentacion( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_Fechapresentacion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Fechapresentacion = value ;
   }

   public web.StructSdtpresentacion_1_18_empleado getEmpleado( )
   {
      return gxTv_Sdtpresentacion_1_18_Empleado ;
   }

   public void setEmpleado( web.StructSdtpresentacion_1_18_empleado value )
   {
      gxTv_Sdtpresentacion_1_18_Empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Empleado = value;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_cargaFamilia> getCargasfamilia( )
   {
      return gxTv_Sdtpresentacion_1_18_Cargasfamilia ;
   }

   public void setCargasfamilia( java.util.Vector<web.StructSdtpresentacion_1_18_cargaFamilia> value )
   {
      gxTv_Sdtpresentacion_1_18_Cargasfamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Cargasfamilia = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_empEnt> getGanliqotrosempent( )
   {
      return gxTv_Sdtpresentacion_1_18_Ganliqotrosempent ;
   }

   public void setGanliqotrosempent( java.util.Vector<web.StructSdtpresentacion_1_18_empEnt> value )
   {
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Ganliqotrosempent = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_deduccion> getDeducciones( )
   {
      return gxTv_Sdtpresentacion_1_18_Deducciones ;
   }

   public void setDeducciones( java.util.Vector<web.StructSdtpresentacion_1_18_deduccion> value )
   {
      gxTv_Sdtpresentacion_1_18_Deducciones_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Deducciones = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_ajuste> getAjustes( )
   {
      return gxTv_Sdtpresentacion_1_18_Ajustes ;
   }

   public void setAjustes( java.util.Vector<web.StructSdtpresentacion_1_18_ajuste> value )
   {
      gxTv_Sdtpresentacion_1_18_Ajustes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Ajustes = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago> getRetperpagos( )
   {
      return gxTv_Sdtpresentacion_1_18_Retperpagos ;
   }

   public void setRetperpagos( java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago> value )
   {
      gxTv_Sdtpresentacion_1_18_Retperpagos_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Retperpagos = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_datoAdicional> getDatosadicionales( )
   {
      return gxTv_Sdtpresentacion_1_18_Datosadicionales ;
   }

   public void setDatosadicionales( java.util.Vector<web.StructSdtpresentacion_1_18_datoAdicional> value )
   {
      gxTv_Sdtpresentacion_1_18_Datosadicionales_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_Datosadicionales = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_Nropresentacion ;
   protected byte gxTv_Sdtpresentacion_1_18_Fechapresentacion_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Empleado_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Cargasfamilia_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Ganliqotrosempent_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Deducciones_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Ajustes_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Retperpagos_N ;
   protected byte gxTv_Sdtpresentacion_1_18_Datosadicionales_N ;
   protected byte gxTv_Sdtpresentacion_1_18_N ;
   protected short gxTv_Sdtpresentacion_1_18_Periodo ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_Fechapresentacion ;
   protected web.StructSdtpresentacion_1_18_empleado gxTv_Sdtpresentacion_1_18_Empleado=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_cargaFamilia> gxTv_Sdtpresentacion_1_18_Cargasfamilia=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_empEnt> gxTv_Sdtpresentacion_1_18_Ganliqotrosempent=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_deduccion> gxTv_Sdtpresentacion_1_18_Deducciones=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_ajuste> gxTv_Sdtpresentacion_1_18_Ajustes=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_retPerPago> gxTv_Sdtpresentacion_1_18_Retperpagos=null ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_datoAdicional> gxTv_Sdtpresentacion_1_18_Datosadicionales=null ;
}

