package web ;
import com.genexus.*;

public final  class StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem.class ));
   }

   public StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod = "" ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes = "" ;
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

   public String getPueafipcod( )
   {
      return gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod ;
   }

   public void setPueafipcod( String value )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod = value ;
   }

   public String getPueafipdes( )
   {
      return gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes ;
   }

   public void setPueafipdes( String value )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes = value ;
   }

   protected byte gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N ;
   protected String gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod ;
   protected String gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes ;
}

