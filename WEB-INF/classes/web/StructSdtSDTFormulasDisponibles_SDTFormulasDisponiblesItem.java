package web ;
import com.genexus.*;

public final  class StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( )
   {
      this( -1, new ModelContext( StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem.class ));
   }

   public StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad = "" ;
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

   public String getFormula( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula ;
   }

   public void setFormula( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula = value ;
   }

   public String getTitulo( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo = value ;
   }

   public String getTituloreducido( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido ;
   }

   public void setTituloreducido( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido = value ;
   }

   public boolean getSimple( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple ;
   }

   public void setSimple( boolean value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple = value ;
   }

   public String getEntidad( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad ;
   }

   public void setEntidad( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad = value ;
   }

   protected byte gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad ;
   protected boolean gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido ;
}

