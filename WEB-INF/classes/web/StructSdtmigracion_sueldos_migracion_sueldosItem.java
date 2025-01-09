package web ;
import com.genexus.*;

public final  class StructSdtmigracion_sueldos_migracion_sueldosItem implements Cloneable, java.io.Serializable
{
   public StructSdtmigracion_sueldos_migracion_sueldosItem( )
   {
      this( -1, new ModelContext( StructSdtmigracion_sueldos_migracion_sueldosItem.class ));
   }

   public StructSdtmigracion_sueldos_migracion_sueldosItem( int remoteHandle ,
                                                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo = new java.math.BigDecimal(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = cal.getTime() ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(1) ;
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

   public java.math.BigDecimal getSueldo( )
   {
      return gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo ;
   }

   public void setSueldo( java.math.BigDecimal value )
   {
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo = value ;
   }

   public java.util.Date getFecha( )
   {
      return gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha ;
   }

   public void setFecha( java.util.Date value )
   {
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = value ;
   }

   protected byte gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N ;
   protected byte gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N ;
   protected java.math.BigDecimal gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo ;
   protected java.util.Date gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha ;
}

