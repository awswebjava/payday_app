package web ;
import com.genexus.*;

public final  class StructSdtUserCustom implements Cloneable, java.io.Serializable
{
   public StructSdtUserCustom( )
   {
      this( -1, new ModelContext( StructSdtUserCustom.class ));
   }

   public StructSdtUserCustom( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtUserCustom_Userid = "" ;
      gxTv_SdtUserCustom_Usercustomkey = "" ;
      gxTv_SdtUserCustom_Usercustomvalue = "" ;
      gxTv_SdtUserCustom_Mode = "" ;
      gxTv_SdtUserCustom_Userid_Z = "" ;
      gxTv_SdtUserCustom_Usercustomkey_Z = "" ;
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

   public String getUserid( )
   {
      return gxTv_SdtUserCustom_Userid ;
   }

   public void setUserid( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Userid = value ;
   }

   public String getUsercustomkey( )
   {
      return gxTv_SdtUserCustom_Usercustomkey ;
   }

   public void setUsercustomkey( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Usercustomkey = value ;
   }

   public String getUsercustomvalue( )
   {
      return gxTv_SdtUserCustom_Usercustomvalue ;
   }

   public void setUsercustomvalue( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Usercustomvalue = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtUserCustom_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtUserCustom_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Initialized = value ;
   }

   public String getUserid_Z( )
   {
      return gxTv_SdtUserCustom_Userid_Z ;
   }

   public void setUserid_Z( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Userid_Z = value ;
   }

   public String getUsercustomkey_Z( )
   {
      return gxTv_SdtUserCustom_Usercustomkey_Z ;
   }

   public void setUsercustomkey_Z( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      gxTv_SdtUserCustom_Usercustomkey_Z = value ;
   }

   private byte gxTv_SdtUserCustom_N ;
   protected short gxTv_SdtUserCustom_Initialized ;
   protected String gxTv_SdtUserCustom_Mode ;
   protected String gxTv_SdtUserCustom_Usercustomvalue ;
   protected String gxTv_SdtUserCustom_Userid ;
   protected String gxTv_SdtUserCustom_Usercustomkey ;
   protected String gxTv_SdtUserCustom_Userid_Z ;
   protected String gxTv_SdtUserCustom_Usercustomkey_Z ;
}

