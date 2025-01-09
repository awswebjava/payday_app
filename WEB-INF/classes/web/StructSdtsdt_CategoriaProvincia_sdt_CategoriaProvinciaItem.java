package web ;
import com.genexus.*;

public final  class StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem.class ));
   }

   public StructSdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio = "" ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo = "" ;
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

   public short getClipaiconve( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio = value ;
   }

   public String getCatcodigo( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo = value ;
   }

   public short getCatprovcod( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod ;
   }

   public void setCatprovcod( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod = value ;
   }

   public short getCatpaicod( )
   {
      return gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod ;
   }

   public void setCatpaicod( short value )
   {
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod = value ;
   }

   protected byte gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_N ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Clipaiconve ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catprovcod ;
   protected short gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catpaicod ;
   protected String gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Cliconvenio ;
   protected String gxTv_Sdtsdt_CategoriaProvincia_sdt_CategoriaProvinciaItem_Catcodigo ;
}

