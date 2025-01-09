package web ;
import com.genexus.*;

public final  class StructSdtsdt_mot_egr_sdt_mot_egrItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_mot_egr_sdt_mot_egrItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_mot_egr_sdt_mot_egrItem.class ));
   }

   public StructSdtsdt_mot_egr_sdt_mot_egrItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo = "" ;
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

   public String getMegcodigo( )
   {
      return gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo ;
   }

   public void setMegcodigo( String value )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo = value ;
   }

   public short getConmegsec( )
   {
      return gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec ;
   }

   public void setConmegsec( short value )
   {
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec = value ;
   }

   protected byte gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_N ;
   protected short gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec ;
   protected String gxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo ;
}

