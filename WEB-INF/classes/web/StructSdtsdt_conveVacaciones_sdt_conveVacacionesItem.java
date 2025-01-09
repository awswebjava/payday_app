package web ;
import com.genexus.*;

public final  class StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem.class ));
   }

   public StructSdtsdt_conveVacaciones_sdt_conveVacacionesItem( int remoteHandle ,
                                                                ModelContext context )
   {
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

   public byte getConvevacdesdeanti( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti ;
   }

   public void setConvevacdesdeanti( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti = value ;
   }

   public byte getConvevachastaanti( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti ;
   }

   public void setConvevachastaanti( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti = value ;
   }

   public byte getConvevacdias( )
   {
      return gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias ;
   }

   public void setConvevacdias( byte value )
   {
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias = value ;
   }

   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias ;
   protected byte gxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_N ;
}

