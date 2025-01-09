package web ;
import com.genexus.*;

public final  class StructSdtsdt_breadCrumb_sdt_breadCrumbItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_breadCrumb_sdt_breadCrumbItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_breadCrumb_sdt_breadCrumbItem.class ));
   }

   public StructSdtsdt_breadCrumb_sdt_breadCrumbItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo = "" ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url = "" ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod = "" ;
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

   public String getMenuopctitulo( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo ;
   }

   public void setMenuopctitulo( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo = value ;
   }

   public String getUrl( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url ;
   }

   public void setUrl( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url = value ;
   }

   public short getNivel( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel ;
   }

   public void setNivel( short value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel = value ;
   }

   public String getMenuopccod( )
   {
      return gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod ;
   }

   public void setMenuopccod( String value )
   {
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N = (byte)(0) ;
      gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod = value ;
   }

   protected byte gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_N ;
   protected short gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Nivel ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url ;
   protected String gxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopccod ;
}

