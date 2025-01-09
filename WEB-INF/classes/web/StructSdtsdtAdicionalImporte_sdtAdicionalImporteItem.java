package web ;
import com.genexus.*;

public final  class StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem( )
   {
      this( -1, new ModelContext( StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem.class ));
   }

   public StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem( int remoteHandle ,
                                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = cal.getTime() ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(1) ;
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
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio = value ;
   }

   public String getConveadicod( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod = value ;
   }

   public java.util.Date getConveadivig( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig ;
   }

   public void setConveadivig( java.util.Date value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = value ;
   }

   public java.math.BigDecimal getConveadiimporte( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte ;
   }

   public void setConveadiimporte( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte = value ;
   }

   protected byte gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N ;
   protected byte gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N ;
   protected short gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve ;
   protected String gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod ;
   protected java.util.Date gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte ;
}

