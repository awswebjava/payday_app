package web ;
import com.genexus.*;

public final  class StructSdtpuesto_old implements Cloneable, java.io.Serializable
{
   public StructSdtpuesto_old( )
   {
      this( -1, new ModelContext( StructSdtpuesto_old.class ));
   }

   public StructSdtpuesto_old( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_Sdtpuesto_old_Puestodescrip = "" ;
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

   public String getPuestodescrip( )
   {
      return gxTv_Sdtpuesto_old_Puestodescrip ;
   }

   public void setPuestodescrip( String value )
   {
      gxTv_Sdtpuesto_old_N = (byte)(0) ;
      gxTv_Sdtpuesto_old_Puestodescrip = value ;
   }

   public boolean getPuestohorasext( )
   {
      return gxTv_Sdtpuesto_old_Puestohorasext ;
   }

   public void setPuestohorasext( boolean value )
   {
      gxTv_Sdtpuesto_old_N = (byte)(0) ;
      gxTv_Sdtpuesto_old_Puestohorasext = value ;
   }

   protected byte gxTv_Sdtpuesto_old_N ;
   protected boolean gxTv_Sdtpuesto_old_Puestohorasext ;
   protected String gxTv_Sdtpuesto_old_Puestodescrip ;
}

