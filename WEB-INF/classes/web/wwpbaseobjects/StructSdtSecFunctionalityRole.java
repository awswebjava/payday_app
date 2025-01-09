package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecFunctionalityRole implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalityRole( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalityRole.class ));
   }

   public StructSdtSecFunctionalityRole( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = "" ;
      gxTv_SdtSecFunctionalityRole_Mode = "" ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = "" ;
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

   public long getSecfunctionalityid( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalityid ;
   }

   public void setSecfunctionalityid( long value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalityid = value ;
   }

   public String getSecfunctionalitydescription( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription ;
   }

   public void setSecfunctionalitydescription( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = value ;
   }

   public short getSecroleid( )
   {
      return gxTv_SdtSecFunctionalityRole_Secroleid ;
   }

   public void setSecroleid( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secroleid = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSecFunctionalityRole_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSecFunctionalityRole_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Initialized = value ;
   }

   public long getSecfunctionalityid_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z ;
   }

   public void setSecfunctionalityid_Z( long value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z = value ;
   }

   public String getSecfunctionalitydescription_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z ;
   }

   public void setSecfunctionalitydescription_Z( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = value ;
   }

   public short getSecroleid_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secroleid_Z ;
   }

   public void setSecroleid_Z( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      gxTv_SdtSecFunctionalityRole_Secroleid_Z = value ;
   }

   private byte gxTv_SdtSecFunctionalityRole_N ;
   protected short gxTv_SdtSecFunctionalityRole_Secroleid ;
   protected short gxTv_SdtSecFunctionalityRole_Initialized ;
   protected short gxTv_SdtSecFunctionalityRole_Secroleid_Z ;
   protected long gxTv_SdtSecFunctionalityRole_Secfunctionalityid ;
   protected long gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z ;
   protected String gxTv_SdtSecFunctionalityRole_Mode ;
   protected String gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription ;
   protected String gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z ;
}

