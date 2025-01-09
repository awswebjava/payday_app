package web ;
import com.genexus.*;

public final  class StructSdtImportarLiquidacionesWizard2Data implements Cloneable, java.io.Serializable
{
   public StructSdtImportarLiquidacionesWizard2Data( )
   {
      this( -1, new ModelContext( StructSdtImportarLiquidacionesWizard2Data.class ));
   }

   public StructSdtImportarLiquidacionesWizard2Data( int remoteHandle ,
                                                     ModelContext context )
   {
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(1) ;
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

   public java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> getAuxiliardata( )
   {
      return gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata ;
   }

   public void setAuxiliardata( java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_N = (byte)(0) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata = value ;
   }

   protected byte gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N ;
   protected byte gxTv_SdtImportarLiquidacionesWizard2Data_N ;
   protected java.util.Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata=null ;
}

