package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtsdt_nav_sdt_navItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_nav_sdt_navItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_nav_sdt_navItem.class ));
   }

   public StructSdtsdt_nav_sdt_navItem( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_Sdtsdt_nav_sdt_navItem_Url = "" ;
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

   public String getUrl( )
   {
      return gxTv_Sdtsdt_nav_sdt_navItem_Url ;
   }

   public void setUrl( String value )
   {
      gxTv_Sdtsdt_nav_sdt_navItem_N = (byte)(0) ;
      gxTv_Sdtsdt_nav_sdt_navItem_Url = value ;
   }

   protected byte gxTv_Sdtsdt_nav_sdt_navItem_N ;
   protected String gxTv_Sdtsdt_nav_sdt_navItem_Url ;
}

