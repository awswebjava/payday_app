package web ;
import com.genexus.*;

public final  class StructSdtsdt_variableValores_sdt_variableValoresItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_variableValores_sdt_variableValoresItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_variableValores_sdt_variableValoresItem.class ));
   }

   public StructSdtsdt_variableValores_sdt_variableValoresItem( int remoteHandle ,
                                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid = "" ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = cal.getTime() ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = cal.getTime() ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor = "" ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(1) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(1) ;
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

   public String getOpecliid( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid ;
   }

   public void setOpecliid( String value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid = value ;
   }

   public java.util.Date getOpeclivretro( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro ;
   }

   public void setOpeclivretro( java.util.Date value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = value ;
   }

   public java.util.Date getOpeclivig( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig ;
   }

   public void setOpeclivig( java.util.Date value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = value ;
   }

   public String getOpeclivalor( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor ;
   }

   public void setOpeclivalor( String value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor = value ;
   }

   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N ;
   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N ;
   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N ;
   protected String gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid ;
   protected String gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor ;
   protected java.util.Date gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro ;
   protected java.util.Date gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig ;
}

