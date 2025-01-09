package web ;
import com.genexus.*;

public final  class StructSdtSDTSecciones_SDTSeccionesItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTSecciones_SDTSeccionesItem( )
   {
      this( -1, new ModelContext( StructSdtSDTSecciones_SDTSeccionesItem.class ));
   }

   public StructSdtSDTSecciones_SDTSeccionesItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo = "" ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip = "" ;
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

   public String getSeccodigo( )
   {
      return gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo ;
   }

   public void setSeccodigo( String value )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_N = (byte)(0) ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo = value ;
   }

   public String getSecdescrip( )
   {
      return gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip ;
   }

   public void setSecdescrip( String value )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_N = (byte)(0) ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip = value ;
   }

   protected byte gxTv_SdtSDTSecciones_SDTSeccionesItem_N ;
   protected String gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo ;
   protected String gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip ;
}

