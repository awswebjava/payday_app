package web ;
import com.genexus.*;

public final  class StructSdtloc_sdt_Localidades_Item implements Cloneable, java.io.Serializable
{
   public StructSdtloc_sdt_Localidades_Item( )
   {
      this( -1, new ModelContext( StructSdtloc_sdt_Localidades_Item.class ));
   }

   public StructSdtloc_sdt_Localidades_Item( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_Paicod = new java.math.BigDecimal(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Provcod = new java.math.BigDecimal(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccod = new java.math.BigDecimal(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Locnom = "" ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccp = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getPaicod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Paicod ;
   }

   public void setPaicod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Paicod = value ;
   }

   public java.math.BigDecimal getProvcod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Provcod ;
   }

   public void setProvcod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Provcod = value ;
   }

   public java.math.BigDecimal getLoccod( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Loccod ;
   }

   public void setLoccod( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccod = value ;
   }

   public String getLocnom( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Locnom ;
   }

   public void setLocnom( String value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Locnom = value ;
   }

   public java.math.BigDecimal getLoccp( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item_Loccp ;
   }

   public void setLoccp( java.math.BigDecimal value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item_Loccp = value ;
   }

   protected byte gxTv_Sdtloc_sdt_Localidades_Item_N ;
   protected String gxTv_Sdtloc_sdt_Localidades_Item_Locnom ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Paicod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Provcod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Loccod ;
   protected java.math.BigDecimal gxTv_Sdtloc_sdt_Localidades_Item_Loccp ;
}

