package web ;
import com.genexus.*;

public final  class StructSdtlocalidades_sdt_Localidades_ItemItem implements Cloneable, java.io.Serializable
{
   public StructSdtlocalidades_sdt_Localidades_ItemItem( )
   {
      this( -1, new ModelContext( StructSdtlocalidades_sdt_Localidades_ItemItem.class ));
   }

   public StructSdtlocalidades_sdt_Localidades_ItemItem( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom = "" ;
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

   public short getPaicod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod = value ;
   }

   public short getProvcod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod ;
   }

   public void setProvcod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod = value ;
   }

   public short getLoccod( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod ;
   }

   public void setLoccod( short value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod = value ;
   }

   public String getLocnom( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom ;
   }

   public void setLocnom( String value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom = value ;
   }

   public int getLoccp( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp ;
   }

   public void setLoccp( int value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp = value ;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_N ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod ;
   protected short gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod ;
   protected int gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp ;
   protected String gxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom ;
}

