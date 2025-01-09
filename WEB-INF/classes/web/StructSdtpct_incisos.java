package web ;
import com.genexus.*;

public final  class StructSdtpct_incisos implements Cloneable, java.io.Serializable
{
   public StructSdtpct_incisos( )
   {
      this( -1, new ModelContext( StructSdtpct_incisos.class ));
   }

   public StructSdtpct_incisos( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_Sdtpct_incisos_A = new java.math.BigDecimal(0) ;
      gxTv_Sdtpct_incisos_B = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getA( )
   {
      return gxTv_Sdtpct_incisos_A ;
   }

   public void setA( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_incisos_N = (byte)(0) ;
      gxTv_Sdtpct_incisos_A = value ;
   }

   public java.math.BigDecimal getB( )
   {
      return gxTv_Sdtpct_incisos_B ;
   }

   public void setB( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_incisos_N = (byte)(0) ;
      gxTv_Sdtpct_incisos_B = value ;
   }

   protected byte gxTv_Sdtpct_incisos_N ;
   protected java.math.BigDecimal gxTv_Sdtpct_incisos_A ;
   protected java.math.BigDecimal gxTv_Sdtpct_incisos_B ;
}

