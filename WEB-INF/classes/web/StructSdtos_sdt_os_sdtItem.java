package web ;
import com.genexus.*;

public final  class StructSdtos_sdt_os_sdtItem implements Cloneable, java.io.Serializable
{
   public StructSdtos_sdt_os_sdtItem( )
   {
      this( -1, new ModelContext( StructSdtos_sdt_os_sdtItem.class ));
   }

   public StructSdtos_sdt_os_sdtItem( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_Sdtos_sdt_os_sdtItem_Osocod = "" ;
      gxTv_Sdtos_sdt_os_sdtItem_Osodescrip = "" ;
      gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 = "" ;
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

   public String getOsocod( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osocod ;
   }

   public void setOsocod( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osocod = value ;
   }

   public String getOsodescrip( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osodescrip ;
   }

   public void setOsodescrip( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osodescrip = value ;
   }

   public String getOsoc3992( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 ;
   }

   public void setOsoc3992( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 = value ;
   }

   protected byte gxTv_Sdtos_sdt_os_sdtItem_N ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osocod ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osodescrip ;
}

