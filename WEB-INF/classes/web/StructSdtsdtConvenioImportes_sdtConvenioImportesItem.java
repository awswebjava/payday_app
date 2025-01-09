package web ;
import com.genexus.*;

public final  class StructSdtsdtConvenioImportes_sdtConvenioImportesItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdtConvenioImportes_sdtConvenioImportesItem( )
   {
      this( -1, new ModelContext( StructSdtsdtConvenioImportes_sdtConvenioImportesItem.class ));
   }

   public StructSdtsdtConvenioImportes_sdtConvenioImportesItem( int remoteHandle ,
                                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio = "" ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = cal.getTime() ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo = "" ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(1) ;
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
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio = value ;
   }

   public java.util.Date getCliconveimpvig( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig ;
   }

   public void setCliconveimpvig( java.util.Date value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = value ;
   }

   public String getCliconveimptipo( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo ;
   }

   public void setCliconveimptipo( String value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo = value ;
   }

   public java.math.BigDecimal getCliconveimporte( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte ;
   }

   public void setCliconveimporte( java.math.BigDecimal value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte = value ;
   }

   protected byte gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N ;
   protected byte gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N ;
   protected short gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve ;
   protected String gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio ;
   protected String gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo ;
   protected java.util.Date gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig ;
   protected java.math.BigDecimal gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte ;
}

