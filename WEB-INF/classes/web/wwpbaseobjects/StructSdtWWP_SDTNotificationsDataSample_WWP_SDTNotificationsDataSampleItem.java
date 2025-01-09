package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( )
   {
      this( -1, new ModelContext( StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class ));
   }

   public StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( int remoteHandle ,
                                                                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = cal.getTime() ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(1) ;
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

   public int getNotificationid( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid ;
   }

   public void setNotificationid( int value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid = value ;
   }

   public String getNotificationiconclass( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass ;
   }

   public void setNotificationiconclass( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass = value ;
   }

   public String getNotificationtitle( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle ;
   }

   public void setNotificationtitle( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle = value ;
   }

   public String getNotificationdescription( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription ;
   }

   public void setNotificationdescription( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription = value ;
   }

   public java.util.Date getNotificationdatetime( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime ;
   }

   public void setNotificationdatetime( java.util.Date value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = value ;
   }

   public String getNotificationlink( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink ;
   }

   public void setNotificationlink( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink = value ;
   }

   protected byte gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N ;
   protected byte gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N ;
   protected int gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink ;
   protected java.util.Date gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime ;
}

