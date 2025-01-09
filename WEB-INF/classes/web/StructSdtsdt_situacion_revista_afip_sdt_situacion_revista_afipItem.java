package web ;
import com.genexus.*;

public final  class StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem.class ));
   }

   public StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( int remoteHandle ,
                                                                              ModelContext context )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip = "" ;
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

   public short getSitrevcodigo( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo ;
   }

   public void setSitrevcodigo( short value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo = value ;
   }

   public String getSitrevdescrip( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip ;
   }

   public void setSitrevdescrip( String value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip = value ;
   }

   public boolean getSitrevesbaja( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja ;
   }

   public void setSitrevesbaja( boolean value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja = value ;
   }

   public boolean getMegsitrevdef( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef ;
   }

   public void setMegsitrevdef( boolean value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef = value ;
   }

   protected byte gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N ;
   protected short gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo ;
   protected boolean gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja ;
   protected boolean gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef ;
   protected String gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip ;
}

