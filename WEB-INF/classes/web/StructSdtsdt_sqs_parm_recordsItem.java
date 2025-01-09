package web ;
import com.genexus.*;

public final  class StructSdtsdt_sqs_parm_recordsItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_sqs_parm_recordsItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_sqs_parm_recordsItem.class ));
   }

   public StructSdtsdt_sqs_parm_recordsItem( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Body = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(1) ;
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

   public String getMessageid( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid ;
   }

   public void setMessageid( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid = value ;
   }

   public String getReceipthandle( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle ;
   }

   public void setReceipthandle( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle = value ;
   }

   public String getBody( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Body ;
   }

   public void setBody( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Body = value ;
   }

   public String getMd5ofbody( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody ;
   }

   public void setMd5ofbody( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody = value ;
   }

   public String getEventsourcearn( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn ;
   }

   public void setEventsourcearn( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn = value ;
   }

   public String getEventsource( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource ;
   }

   public void setEventsource( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource = value ;
   }

   public String getAwsregion( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion ;
   }

   public void setAwsregion( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion = value ;
   }

   public web.StructSdtsdt_sqs_parm_recordsItem_attributes getAttributes( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes ;
   }

   public void setAttributes( web.StructSdtsdt_sqs_parm_recordsItem_attributes value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes = value;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N ;
   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_N ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Body ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion ;
   protected web.StructSdtsdt_sqs_parm_recordsItem_attributes gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes=null ;
}

