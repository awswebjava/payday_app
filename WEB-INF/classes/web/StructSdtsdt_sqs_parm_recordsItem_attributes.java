package web ;
import com.genexus.*;

public final  class StructSdtsdt_sqs_parm_recordsItem_attributes implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_sqs_parm_recordsItem_attributes( )
   {
      this( -1, new ModelContext( StructSdtsdt_sqs_parm_recordsItem_attributes.class ));
   }

   public StructSdtsdt_sqs_parm_recordsItem_attributes( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp = "" ;
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

   public String getApproximatereceivecount( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount ;
   }

   public void setApproximatereceivecount( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount = value ;
   }

   public String getSenttimestamp( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp ;
   }

   public void setSenttimestamp( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp = value ;
   }

   public String getSenderid( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid ;
   }

   public void setSenderid( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid = value ;
   }

   public String getApproximatefirstreceivetimestamp( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp ;
   }

   public void setApproximatefirstreceivetimestamp( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp = value ;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp ;
}

