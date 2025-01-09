package web ;
import com.genexus.*;

public final  class StructSdtsdt_modprom_sdt_modpromItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_modprom_sdt_modpromItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_modprom_sdt_modpromItem.class ));
   }

   public StructSdtsdt_modprom_sdt_modpromItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod = "" ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip = "" ;
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

   public String getMprcod( )
   {
      return gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod ;
   }

   public void setMprcod( String value )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_N = (byte)(0) ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod = value ;
   }

   public String getMprdescrip( )
   {
      return gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip ;
   }

   public void setMprdescrip( String value )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_N = (byte)(0) ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip = value ;
   }

   protected byte gxTv_Sdtsdt_modprom_sdt_modpromItem_N ;
   protected String gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod ;
   protected String gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip ;
}

