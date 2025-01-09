package web ;
import com.genexus.*;

public final  class StructSdtparm_iniPerCCLic implements Cloneable, java.io.Serializable
{
   public StructSdtparm_iniPerCCLic( )
   {
      this( -1, new ModelContext( StructSdtparm_iniPerCCLic.class ));
   }

   public StructSdtparm_iniPerCCLic( int remoteHandle ,
                                     ModelContext context )
   {
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

   public int getClicod( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Legnumero = value ;
   }

   public short getDesdeanio( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Desdeanio ;
   }

   public void setDesdeanio( short value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Desdeanio = value ;
   }

   protected byte gxTv_Sdtparm_iniPerCCLic_N ;
   protected short gxTv_Sdtparm_iniPerCCLic_Empcod ;
   protected short gxTv_Sdtparm_iniPerCCLic_Desdeanio ;
   protected int gxTv_Sdtparm_iniPerCCLic_Clicod ;
   protected int gxTv_Sdtparm_iniPerCCLic_Legnumero ;
}

