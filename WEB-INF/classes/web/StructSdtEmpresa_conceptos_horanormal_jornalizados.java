package web ;
import com.genexus.*;

public final  class StructSdtEmpresa_conceptos_horanormal_jornalizados implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa_conceptos_horanormal_jornalizados( )
   {
      this( -1, new ModelContext( StructSdtEmpresa_conceptos_horanormal_jornalizados.class ));
   }

   public StructSdtEmpresa_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo = "" ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode = "" ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = "" ;
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

   public String getEmpjorconcodigo( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo ;
   }

   public void setEmpjorconcodigo( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo = value ;
   }

   public boolean getEmpjorhabitual( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual ;
   }

   public void setEmpjorhabitual( boolean value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Initialized = value ;
   }

   public String getEmpjorconcodigo_Z( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z ;
   }

   public void setEmpjorconcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = value ;
   }

   public boolean getEmpjorhabitual_Z( )
   {
      return gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual_Z ;
   }

   public void setEmpjorhabitual_Z( boolean value )
   {
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual_Z = value ;
   }

   private byte gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_N ;
   protected short gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified ;
   protected short gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Initialized ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode ;
   protected String gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z ;
   protected boolean gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual ;
   protected boolean gxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual_Z ;
}

