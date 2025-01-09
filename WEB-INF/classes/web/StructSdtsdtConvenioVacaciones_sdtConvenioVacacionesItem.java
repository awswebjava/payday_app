package web ;
import com.genexus.*;

public final  class StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( )
   {
      this( -1, new ModelContext( StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem.class ));
   }

   public StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( int remoteHandle ,
                                                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio = "" ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = cal.getTime() ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(1) ;
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

   public short getClipaiconve( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio = value ;
   }

   public java.util.Date getCliconvevig( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig ;
   }

   public void setCliconvevig( java.util.Date value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = value ;
   }

   public byte getCliconvevacdesant( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant ;
   }

   public void setCliconvevacdesant( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant = value ;
   }

   public byte getCliconvevachasant( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant ;
   }

   public void setCliconvevachasant( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant = value ;
   }

   public byte getCliconvevacdias( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias ;
   }

   public void setCliconvevacdias( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias = value ;
   }

   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N ;
   protected short gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve ;
   protected String gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio ;
   protected java.util.Date gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig ;
}

