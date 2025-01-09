package web ;
import com.genexus.*;

public final  class StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem.class ));
   }

   public StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil = "" ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido = "" ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre = "" ;
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

   public String getCuil( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil ;
   }

   public void setCuil( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil = value ;
   }

   public String getApellido( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido ;
   }

   public void setApellido( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido = value ;
   }

   public String getNombre( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre = value ;
   }

   protected byte gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre ;
}

