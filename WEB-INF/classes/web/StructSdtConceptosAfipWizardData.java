package web ;
import com.genexus.*;

public final  class StructSdtConceptosAfipWizardData implements Cloneable, java.io.Serializable
{
   public StructSdtConceptosAfipWizardData( )
   {
      this( -1, new ModelContext( StructSdtConceptosAfipWizardData.class ));
   }

   public StructSdtConceptosAfipWizardData( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(1) ;
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

   public web.StructSdtConceptosAfipWizardData_Concepto1 getConcepto1( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1 ;
   }

   public void setConcepto1( web.StructSdtConceptosAfipWizardData_Concepto1 value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1 = value;
   }

   public web.StructSdtConceptosAfipWizardData_Completado getCompletado( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado ;
   }

   public void setCompletado( web.StructSdtConceptosAfipWizardData_Completado value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado = value;
   }

   public java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> getAuxiliardata( )
   {
      return gxTv_SdtConceptosAfipWizardData_Auxiliardata ;
   }

   public void setAuxiliardata( java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Auxiliardata = value ;
   }

   protected byte gxTv_SdtConceptosAfipWizardData_Concepto1_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Completado_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Auxiliardata_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_N ;
   protected web.StructSdtConceptosAfipWizardData_Concepto1 gxTv_SdtConceptosAfipWizardData_Concepto1=null ;
   protected web.StructSdtConceptosAfipWizardData_Completado gxTv_SdtConceptosAfipWizardData_Completado=null ;
   protected java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtConceptosAfipWizardData_Auxiliardata=null ;
}

