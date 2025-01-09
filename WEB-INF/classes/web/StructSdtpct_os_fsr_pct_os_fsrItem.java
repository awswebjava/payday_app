package web ;
import com.genexus.*;

public final  class StructSdtpct_os_fsr_pct_os_fsrItem implements Cloneable, java.io.Serializable
{
   public StructSdtpct_os_fsr_pct_os_fsrItem( )
   {
      this( -1, new ModelContext( StructSdtpct_os_fsr_pct_os_fsrItem.class ));
   }

   public StructSdtpct_os_fsr_pct_os_fsrItem( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde = new java.math.BigDecimal(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta = new java.math.BigDecimal(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota = new java.math.BigDecimal(0) ;
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

   public boolean getEnconvenio( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio ;
   }

   public void setEnconvenio( boolean value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio = value ;
   }

   public java.math.BigDecimal getRemuneraciondesde( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde ;
   }

   public void setRemuneraciondesde( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde = value ;
   }

   public java.math.BigDecimal getRemuneracionhasta( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta ;
   }

   public void setRemuneracionhasta( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta = value ;
   }

   public java.math.BigDecimal getAlicuota( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota ;
   }

   public void setAlicuota( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota = value ;
   }

   protected byte gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N ;
   protected boolean gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota ;
}

