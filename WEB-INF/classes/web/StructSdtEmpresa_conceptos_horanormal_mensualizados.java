package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_conceptos_horanormal_mensualizados implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_conceptos_horanormal_mensualizados( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_conceptos_horanormal_mensualizados.class ));
   }

   public StructSdtEmpresa_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                               ModelContext context )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo = "" ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = "" ;
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

   public String getEmpmenconcodigo( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo ;
   }

   public void setEmpmenconcodigo( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo = value ;
   }

   public boolean getEmpmenhabitual( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual ;
   }

   public void setEmpmenhabitual( boolean value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Initialized = value ;
   }

   public String getEmpmenconcodigo_Z( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z ;
   }

   public void setEmpmenconcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = value ;
   }

   public boolean getEmpmenhabitual_Z( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual_Z ;
   }

   public void setEmpmenhabitual_Z( boolean value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual_Z = value ;
   }

   private byte gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_N ;
   protected short gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified ;
   protected short gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Initialized ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z ;
   protected boolean gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual ;
   protected boolean gxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual_Z ;
}

