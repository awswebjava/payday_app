package web ;
import com.genexus.*;

public final  class StructSdtConceptosAfipWizardData_Completado implements Cloneable, java.io.Serializable
{
   public StructSdtConceptosAfipWizardData_Completado( )
   {
      this( -1, new ModelContext( StructSdtConceptosAfipWizardData_Completado.class ));
   }

   public StructSdtConceptosAfipWizardData_Completado( int remoteHandle ,
                                                       ModelContext context )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_Archivochar = "" ;
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(1) ;
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

   public String getArchivochar( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_Archivochar ;
   }

   public void setArchivochar( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Archivochar = value ;
   }

   public java.util.Vector<web.StructSdtsdt_errores_sdt_erroresItem> getSdt_errores( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores ;
   }

   public void setSdt_errores( java.util.Vector<web.StructSdtsdt_errores_sdt_erroresItem> value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores = value ;
   }

   protected byte gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Completado_N ;
   protected String gxTv_SdtConceptosAfipWizardData_Completado_Archivochar ;
   protected java.util.Vector<web.StructSdtsdt_errores_sdt_erroresItem> gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores=null ;
}

