package web ;
import com.genexus.*;

public final  class StructSdtparm_sueldoPrecalc implements Cloneable, java.io.Serializable
{
   public StructSdtparm_sueldoPrecalc( )
   {
      this( -1, new ModelContext( StructSdtparm_sueldoPrecalc.class ));
   }

   public StructSdtparm_sueldoPrecalc( int remoteHandle ,
                                       ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtparm_sueldoPrecalc_Legsueltipo = "" ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = cal.getTime() ;
      gxTv_Sdtparm_sueldoPrecalc_Parmimportes = new java.math.BigDecimal(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmsincod = "" ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(1) ;
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
      return gxTv_Sdtparm_sueldoPrecalc_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legnumero = value ;
   }

   public String getLegsueltipo( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsueltipo ;
   }

   public void setLegsueltipo( String value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsueltipo = value ;
   }

   public java.util.Date getLegsuelfecha( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha ;
   }

   public void setLegsuelfecha( java.util.Date value )
   {
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = value ;
   }

   public short getLegsuelsec( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsuelsec ;
   }

   public void setLegsuelsec( short value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelsec = value ;
   }

   public java.math.BigDecimal getParmimportes( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmimportes ;
   }

   public void setParmimportes( java.math.BigDecimal value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmimportes = value ;
   }

   public boolean getParmlegliqapo( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo ;
   }

   public void setParmlegliqapo( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo = value ;
   }

   public boolean getParmlegjubilado( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado ;
   }

   public void setParmlegjubilado( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado = value ;
   }

   public String getParmsincod( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmsincod ;
   }

   public void setParmsincod( String value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmsincod = value ;
   }

   public boolean getSetcalcytxt( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt ;
   }

   public void setSetcalcytxt( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt = value ;
   }

   protected byte gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N ;
   protected byte gxTv_Sdtparm_sueldoPrecalc_N ;
   protected short gxTv_Sdtparm_sueldoPrecalc_Empcod ;
   protected short gxTv_Sdtparm_sueldoPrecalc_Legsuelsec ;
   protected int gxTv_Sdtparm_sueldoPrecalc_Clicod ;
   protected int gxTv_Sdtparm_sueldoPrecalc_Legnumero ;
   protected String gxTv_Sdtparm_sueldoPrecalc_Legsueltipo ;
   protected String gxTv_Sdtparm_sueldoPrecalc_Parmsincod ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt ;
   protected java.util.Date gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha ;
   protected java.math.BigDecimal gxTv_Sdtparm_sueldoPrecalc_Parmimportes ;
}

