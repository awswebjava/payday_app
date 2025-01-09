package web ;
import com.genexus.*;

public final  class StructSdtsdt_sqs_parm implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_sqs_parm( )
   {
      this( -1, new ModelContext( StructSdtsdt_sqs_parm.class ));
   }

   public StructSdtsdt_sqs_parm( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(1) ;
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

   public java.util.Vector<web.StructSdtsdt_sqs_parm_recordsItem> getRecords( )
   {
      return gxTv_Sdtsdt_sqs_parm_Records ;
   }

   public void setRecords( java.util.Vector<web.StructSdtsdt_sqs_parm_recordsItem> value )
   {
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_Records = value ;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_Records_N ;
   protected byte gxTv_Sdtsdt_sqs_parm_N ;
   protected java.util.Vector<web.StructSdtsdt_sqs_parm_recordsItem> gxTv_Sdtsdt_sqs_parm_Records=null ;
}

