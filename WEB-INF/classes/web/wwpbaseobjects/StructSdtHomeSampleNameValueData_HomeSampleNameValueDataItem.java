package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem( )
   {
      this( -1, new ModelContext( StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem.class ));
   }

   public StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem( int remoteHandle ,
                                                                        ModelContext context )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name = "" ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value = new java.math.BigDecimal(0) ;
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

   public String getName( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name = value ;
   }

   public java.math.BigDecimal getValue( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value ;
   }

   public void setValue( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value = value ;
   }

   public boolean getCheck( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check ;
   }

   public void setCheck( boolean value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check = value ;
   }

   protected byte gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N ;
   protected boolean gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check ;
   protected String gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value ;
}

