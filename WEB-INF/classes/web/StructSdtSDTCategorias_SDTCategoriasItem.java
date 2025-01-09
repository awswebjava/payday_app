package web ;
import com.genexus.*;

public final  class StructSdtSDTCategorias_SDTCategoriasItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCategorias_SDTCategoriasItem( )
   {
      this( -1, new ModelContext( StructSdtSDTCategorias_SDTCategoriasItem.class ));
   }

   public StructSdtSDTCategorias_SDTCategoriasItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod = "" ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa = "" ;
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

   public String getCatcodigo( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo = value ;
   }

   public String getCatdescrip( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip ;
   }

   public void setCatdescrip( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip = value ;
   }

   public short getClipaiconve( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio = value ;
   }

   public byte getCatclase( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase ;
   }

   public void setCatclase( byte value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase = value ;
   }

   public byte getCatfrecact( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact ;
   }

   public void setCatfrecact( byte value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact = value ;
   }

   public String getCatafipcod( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod ;
   }

   public void setCatafipcod( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod = value ;
   }

   public String getCattipotarifa( )
   {
      return gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa ;
   }

   public void setCattipotarifa( String value )
   {
      gxTv_SdtSDTCategorias_SDTCategoriasItem_N = (byte)(0) ;
      gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa = value ;
   }

   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_Catclase ;
   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_Catfrecact ;
   protected byte gxTv_SdtSDTCategorias_SDTCategoriasItem_N ;
   protected short gxTv_SdtSDTCategorias_SDTCategoriasItem_Clipaiconve ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catcodigo ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Cliconvenio ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catafipcod ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Cattipotarifa ;
   protected String gxTv_SdtSDTCategorias_SDTCategoriasItem_Catdescrip ;
}

