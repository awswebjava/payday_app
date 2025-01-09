package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVelop_Menu_Item implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_Menu_Item( )
   {
      this( -1, new ModelContext( StructSdtDVelop_Menu_Item.class ));
   }

   public StructSdtDVelop_Menu_Item( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtDVelop_Menu_Item_Id = "" ;
      gxTv_SdtDVelop_Menu_Item_Tooltip = "" ;
      gxTv_SdtDVelop_Menu_Item_Link = "" ;
      gxTv_SdtDVelop_Menu_Item_Linktarget = "" ;
      gxTv_SdtDVelop_Menu_Item_Iconclass = "" ;
      gxTv_SdtDVelop_Menu_Item_Caption = "" ;
      gxTv_SdtDVelop_Menu_Item_Authorizationkey = "" ;
      gxTv_SdtDVelop_Menu_Item_Additionaldata = "" ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage = "" ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi = "" ;
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(1) ;
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

   public String getId( )
   {
      return gxTv_SdtDVelop_Menu_Item_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Id = value ;
   }

   public String getTooltip( )
   {
      return gxTv_SdtDVelop_Menu_Item_Tooltip ;
   }

   public void setTooltip( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Tooltip = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtDVelop_Menu_Item_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Link = value ;
   }

   public String getLinktarget( )
   {
      return gxTv_SdtDVelop_Menu_Item_Linktarget ;
   }

   public void setLinktarget( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Linktarget = value ;
   }

   public String getIconclass( )
   {
      return gxTv_SdtDVelop_Menu_Item_Iconclass ;
   }

   public void setIconclass( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Iconclass = value ;
   }

   public String getCaption( )
   {
      return gxTv_SdtDVelop_Menu_Item_Caption ;
   }

   public void setCaption( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Caption = value ;
   }

   public String getAuthorizationkey( )
   {
      return gxTv_SdtDVelop_Menu_Item_Authorizationkey ;
   }

   public void setAuthorizationkey( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Authorizationkey = value ;
   }

   public String getAdditionaldata( )
   {
      return gxTv_SdtDVelop_Menu_Item_Additionaldata ;
   }

   public void setAdditionaldata( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Additionaldata = value ;
   }

   public String getSubmenuimage( )
   {
      return gxTv_SdtDVelop_Menu_Item_Submenuimage ;
   }

   public void setSubmenuimage( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage = value ;
   }

   public String getSubmenuimage_gxi( )
   {
      return gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi ;
   }

   public void setSubmenuimage_gxi( String value )
   {
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi = value ;
   }

   public java.util.Vector<web.wwpbaseobjects.StructSdtDVelop_Menu_Item> getSubitems( )
   {
      return gxTv_SdtDVelop_Menu_Item_Subitems ;
   }

   public void setSubitems( java.util.Vector<web.wwpbaseobjects.StructSdtDVelop_Menu_Item> value )
   {
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Subitems = value ;
   }

   protected byte gxTv_SdtDVelop_Menu_Item_Subitems_N ;
   protected byte gxTv_SdtDVelop_Menu_Item_N ;
   protected String gxTv_SdtDVelop_Menu_Item_Id ;
   protected String gxTv_SdtDVelop_Menu_Item_Tooltip ;
   protected String gxTv_SdtDVelop_Menu_Item_Link ;
   protected String gxTv_SdtDVelop_Menu_Item_Linktarget ;
   protected String gxTv_SdtDVelop_Menu_Item_Iconclass ;
   protected String gxTv_SdtDVelop_Menu_Item_Caption ;
   protected String gxTv_SdtDVelop_Menu_Item_Authorizationkey ;
   protected String gxTv_SdtDVelop_Menu_Item_Additionaldata ;
   protected String gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi ;
   protected String gxTv_SdtDVelop_Menu_Item_Submenuimage ;
   protected java.util.Vector<web.wwpbaseobjects.StructSdtDVelop_Menu_Item> gxTv_SdtDVelop_Menu_Item_Subitems=null ;
}

