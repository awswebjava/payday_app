package web ;
import com.genexus.*;

public final  class StructSdtPais_conceptos_horanormal_mensualizados implements Cloneable, java.io.Serializable
{
   public StructSdtPais_conceptos_horanormal_mensualizados( )
   {
      this( -1, new ModelContext( StructSdtPais_conceptos_horanormal_mensualizados.class ));
   }

   public StructSdtPais_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = "" ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = "" ;
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

   public int getPaimenclicod( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod ;
   }

   public void setPaimenclicod( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod = value ;
   }

   public String getPaimesconcodigo( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo ;
   }

   public void setPaimesconcodigo( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = value ;
   }

   public boolean getPaimeshabitual( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual ;
   }

   public void setPaimeshabitual( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized = value ;
   }

   public int getPaimenclicod_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z ;
   }

   public void setPaimenclicod_Z( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z = value ;
   }

   public String getPaimesconcodigo_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z ;
   }

   public void setPaimesconcodigo_Z( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = value ;
   }

   public boolean getPaimeshabitual_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z ;
   }

   public void setPaimeshabitual_Z( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z = value ;
   }

   private byte gxTv_SdtPais_conceptos_horanormal_mensualizados_N ;
   protected short gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified ;
   protected short gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized ;
   protected int gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod ;
   protected int gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z ;
   protected String gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo ;
   protected String gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode ;
   protected String gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z ;
   protected boolean gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual ;
   protected boolean gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z ;
}

