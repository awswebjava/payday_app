package web ;
import com.genexus.*;

public final  class StructSdtsdt_categorias_sdt_categoriasItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_categorias_sdt_categoriasItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_categorias_sdt_categoriasItem.class ));
   }

   public StructSdtsdt_categorias_sdt_categoriasItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo = "" ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip = "" ;
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
      return gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo = value ;
   }

   public String getCatdescrip( )
   {
      return gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip ;
   }

   public void setCatdescrip( String value )
   {
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip = value ;
   }

   protected byte gxTv_Sdtsdt_categorias_sdt_categoriasItem_N ;
   protected String gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo ;
   protected String gxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip ;
}

