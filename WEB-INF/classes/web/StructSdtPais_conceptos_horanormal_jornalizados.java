package web ;
import com.genexus.*;

public final  class StructSdtPais_conceptos_horanormal_jornalizados implements Cloneable, java.io.Serializable
{
   public StructSdtPais_conceptos_horanormal_jornalizados( )
   {
      this( -1, new ModelContext( StructSdtPais_conceptos_horanormal_jornalizados.class ));
   }

   public StructSdtPais_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                           ModelContext context )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = "" ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = "" ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = "" ;
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

   public int getPaijorclicod( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod ;
   }

   public void setPaijorclicod( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod = value ;
   }

   public String getPaijorconcodigo( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo ;
   }

   public void setPaijorconcodigo( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = value ;
   }

   public boolean getPaijorhabitual( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual ;
   }

   public void setPaijorhabitual( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized = value ;
   }

   public int getPaijorclicod_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z ;
   }

   public void setPaijorclicod_Z( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z = value ;
   }

   public String getPaijorconcodigo_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z ;
   }

   public void setPaijorconcodigo_Z( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = value ;
   }

   public boolean getPaijorhabitual_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z ;
   }

   public void setPaijorhabitual_Z( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z = value ;
   }

   private byte gxTv_SdtPais_conceptos_horanormal_jornalizados_N ;
   protected short gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified ;
   protected short gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized ;
   protected int gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod ;
   protected int gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z ;
   protected String gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo ;
   protected String gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode ;
   protected String gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z ;
   protected boolean gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual ;
   protected boolean gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z ;
}

