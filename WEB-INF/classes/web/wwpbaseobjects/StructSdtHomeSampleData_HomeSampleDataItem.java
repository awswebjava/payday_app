package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtHomeSampleData_HomeSampleDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtHomeSampleData_HomeSampleDataItem( )
   {
      this( -1, new ModelContext( StructSdtHomeSampleData_HomeSampleDataItem.class ));
   }

   public StructSdtHomeSampleData_HomeSampleDataItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname = "" ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice = new java.math.BigDecimal(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight = new java.math.BigDecimal(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume = new java.math.BigDecimal(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount = new java.math.BigDecimal(0) ;
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

   public String getProductname( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname ;
   }

   public void setProductname( String value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname = value ;
   }

   public java.math.BigDecimal getProductprice( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice ;
   }

   public void setProductprice( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice = value ;
   }

   public java.math.BigDecimal getProductweight( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight ;
   }

   public void setProductweight( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight = value ;
   }

   public java.math.BigDecimal getProductvolume( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume ;
   }

   public void setProductvolume( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume = value ;
   }

   public java.math.BigDecimal getProductdiscount( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount ;
   }

   public void setProductdiscount( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount = value ;
   }

   public byte getProductstatus( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus ;
   }

   public void setProductstatus( byte value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus = value ;
   }

   protected byte gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus ;
   protected byte gxTv_SdtHomeSampleData_HomeSampleDataItem_N ;
   protected String gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount ;
}

