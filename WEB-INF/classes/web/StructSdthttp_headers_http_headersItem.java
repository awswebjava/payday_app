package web ;
import com.genexus.*;

public final  class StructSdthttp_headers_http_headersItem implements Cloneable, java.io.Serializable
{
   public StructSdthttp_headers_http_headersItem( )
   {
      this( -1, new ModelContext( StructSdthttp_headers_http_headersItem.class ));
   }

   public StructSdthttp_headers_http_headersItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_Sdthttp_headers_http_headersItem_Name = "" ;
      gxTv_Sdthttp_headers_http_headersItem_Value = "" ;
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
      return gxTv_Sdthttp_headers_http_headersItem_Name ;
   }

   public void setName( String value )
   {
      gxTv_Sdthttp_headers_http_headersItem_N = (byte)(0) ;
      gxTv_Sdthttp_headers_http_headersItem_Name = value ;
   }

   public String getValue( )
   {
      return gxTv_Sdthttp_headers_http_headersItem_Value ;
   }

   public void setValue( String value )
   {
      gxTv_Sdthttp_headers_http_headersItem_N = (byte)(0) ;
      gxTv_Sdthttp_headers_http_headersItem_Value = value ;
   }

   protected byte gxTv_Sdthttp_headers_http_headersItem_N ;
   protected String gxTv_Sdthttp_headers_http_headersItem_Name ;
   protected String gxTv_Sdthttp_headers_http_headersItem_Value ;
}

