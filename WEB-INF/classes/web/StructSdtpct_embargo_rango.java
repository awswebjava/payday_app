package web ;
import com.genexus.*;

public final  class StructSdtpct_embargo_rango implements Cloneable, java.io.Serializable
{
   public StructSdtpct_embargo_rango( )
   {
      this( -1, new ModelContext( StructSdtpct_embargo_rango.class ));
   }

   public StructSdtpct_embargo_rango( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_Sdtpct_embargo_rango_Hastaremuneracion = new java.math.BigDecimal(0) ;
      gxTv_Sdtpct_embargo_rango_Alicuota = new java.math.BigDecimal(0) ;
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

   public java.math.BigDecimal getHastaremuneracion( )
   {
      return gxTv_Sdtpct_embargo_rango_Hastaremuneracion ;
   }

   public void setHastaremuneracion( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_embargo_rango_N = (byte)(0) ;
      gxTv_Sdtpct_embargo_rango_Hastaremuneracion = value ;
   }

   public java.math.BigDecimal getAlicuota( )
   {
      return gxTv_Sdtpct_embargo_rango_Alicuota ;
   }

   public void setAlicuota( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_embargo_rango_N = (byte)(0) ;
      gxTv_Sdtpct_embargo_rango_Alicuota = value ;
   }

   protected byte gxTv_Sdtpct_embargo_rango_N ;
   protected java.math.BigDecimal gxTv_Sdtpct_embargo_rango_Hastaremuneracion ;
   protected java.math.BigDecimal gxTv_Sdtpct_embargo_rango_Alicuota ;
}

