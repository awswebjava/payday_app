package web ;
import com.genexus.*;

public final  class StructSdtsdt_eventBridge_parm implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_eventBridge_parm( )
   {
      this( -1, new ModelContext( StructSdtsdt_eventBridge_parm.class ));
   }

   public StructSdtsdt_eventBridge_parm( int remoteHandle ,
                                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_eventBridge_parm_Version = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Id = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Source = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Account = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Time = cal.getTime() ;
      gxTv_Sdtsdt_eventBridge_parm_Region = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Detail = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(1) ;
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

   public String getVersion( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Version ;
   }

   public void setVersion( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Version = value ;
   }

   public String getId( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Id ;
   }

   public void setId( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Id = value ;
   }

   public String getSource( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Source ;
   }

   public void setSource( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Source = value ;
   }

   public String getAccount( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Account ;
   }

   public void setAccount( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Account = value ;
   }

   public java.util.Date getTime( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Time ;
   }

   public void setTime( java.util.Date value )
   {
      gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Time = value ;
   }

   public String getRegion( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Region ;
   }

   public void setRegion( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Region = value ;
   }

   public String getDetail( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Detail ;
   }

   public void setDetail( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Detail = value ;
   }

   protected byte gxTv_Sdtsdt_eventBridge_parm_Time_N ;
   protected byte gxTv_Sdtsdt_eventBridge_parm_N ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Detail ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Version ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Id ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Source ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Account ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Region ;
   protected java.util.Date gxTv_Sdtsdt_eventBridge_parm_Time ;
}

