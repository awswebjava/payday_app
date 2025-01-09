package web ;
import com.genexus.*;

public final  class StructSdtPais_base_calculo implements Cloneable, java.io.Serializable
{
   public StructSdtPais_base_calculo( )
   {
      this( -1, new ModelContext( StructSdtPais_base_calculo.class ));
   }

   public StructSdtPais_base_calculo( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtPais_base_calculo_Paibasetipo = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod1 = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod2 = "" ;
      gxTv_SdtPais_base_calculo_Paibaseplus = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt = "" ;
      gxTv_SdtPais_base_calculo_Mode = "" ;
      gxTv_SdtPais_base_calculo_Paibasetipo_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod1_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibasecod2_Z = "" ;
      gxTv_SdtPais_base_calculo_Paibaseplus_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = "" ;
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

   public byte getPaibaseclaseleg( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseclaseleg ;
   }

   public void setPaibaseclaseleg( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibaseclaseleg = value ;
   }

   public String getPaibasetipo( )
   {
      return gxTv_SdtPais_base_calculo_Paibasetipo ;
   }

   public void setPaibasetipo( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasetipo = value ;
   }

   public String getPaibasecod1( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod1 ;
   }

   public void setPaibasecod1( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasecod1 = value ;
   }

   public String getPaibasecod2( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod2 ;
   }

   public void setPaibasecod2( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasecod2 = value ;
   }

   public java.math.BigDecimal getPaibaseplus( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseplus ;
   }

   public void setPaibaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibaseplus = value ;
   }

   public short getPailicdlim( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdlim ;
   }

   public void setPailicdlim( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdlim = value ;
   }

   public byte getPailicdseman( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdseman ;
   }

   public void setPailicdseman( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdseman = value ;
   }

   public byte getPailicdmes( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdmes ;
   }

   public void setPailicdmes( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdmes = value ;
   }

   public short getPailicdsemes( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdsemes ;
   }

   public void setPailicdsemes( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdsemes = value ;
   }

   public short getPailicdanual( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdanual ;
   }

   public void setPailicdanual( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdanual = value ;
   }

   public boolean getPailicadju( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadju ;
   }

   public void setPailicadju( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicadju = value ;
   }

   public boolean getPailicadjuobl( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadjuobl ;
   }

   public void setPailicadjuobl( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicadjuobl = value ;
   }

   public boolean getPailicnecaut( )
   {
      return gxTv_SdtPais_base_calculo_Pailicnecaut ;
   }

   public void setPailicnecaut( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicnecaut = value ;
   }

   public boolean getPailicingmot( )
   {
      return gxTv_SdtPais_base_calculo_Pailicingmot ;
   }

   public void setPailicingmot( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicingmot = value ;
   }

   public boolean getPailicmotobl( )
   {
      return gxTv_SdtPais_base_calculo_Pailicmotobl ;
   }

   public void setPailicmotobl( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicmotobl = value ;
   }

   public short getPaibasepromcnt1( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt1 ;
   }

   public void setPaibasepromcnt1( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromcnt1 = value ;
   }

   public short getPaibasepromcnt2( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt2 ;
   }

   public void setPaibasepromcnt2( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromcnt2 = value ;
   }

   public String getPaibasepromtcnt( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromtcnt ;
   }

   public void setPaibasepromtcnt( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt = value ;
   }

   public java.util.Vector<web.StructSdtPais_base_calculo_actual> getActual( )
   {
      return gxTv_SdtPais_base_calculo_Actual ;
   }

   public void setActual( java.util.Vector<web.StructSdtPais_base_calculo_actual> value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Actual = value ;
   }

   public java.util.Vector<web.StructSdtPais_base_calculo_promedio> getPromedio( )
   {
      return gxTv_SdtPais_base_calculo_Promedio ;
   }

   public void setPromedio( java.util.Vector<web.StructSdtPais_base_calculo_promedio> value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Promedio = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_base_calculo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_base_calculo_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_base_calculo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Initialized = value ;
   }

   public byte getPaibaseclaseleg_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z ;
   }

   public void setPaibaseclaseleg_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z = value ;
   }

   public String getPaibasetipo_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasetipo_Z ;
   }

   public void setPaibasetipo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasetipo_Z = value ;
   }

   public String getPaibasecod1_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod1_Z ;
   }

   public void setPaibasecod1_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasecod1_Z = value ;
   }

   public String getPaibasecod2_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasecod2_Z ;
   }

   public void setPaibasecod2_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasecod2_Z = value ;
   }

   public java.math.BigDecimal getPaibaseplus_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibaseplus_Z ;
   }

   public void setPaibaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibaseplus_Z = value ;
   }

   public short getPailicdlim_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdlim_Z ;
   }

   public void setPailicdlim_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdlim_Z = value ;
   }

   public byte getPailicdseman_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdseman_Z ;
   }

   public void setPailicdseman_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdseman_Z = value ;
   }

   public byte getPailicdmes_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdmes_Z ;
   }

   public void setPailicdmes_Z( byte value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdmes_Z = value ;
   }

   public short getPailicdsemes_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdsemes_Z ;
   }

   public void setPailicdsemes_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdsemes_Z = value ;
   }

   public short getPailicdanual_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicdanual_Z ;
   }

   public void setPailicdanual_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicdanual_Z = value ;
   }

   public boolean getPailicadju_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadju_Z ;
   }

   public void setPailicadju_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicadju_Z = value ;
   }

   public boolean getPailicadjuobl_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicadjuobl_Z ;
   }

   public void setPailicadjuobl_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicadjuobl_Z = value ;
   }

   public boolean getPailicnecaut_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicnecaut_Z ;
   }

   public void setPailicnecaut_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicnecaut_Z = value ;
   }

   public boolean getPailicingmot_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicingmot_Z ;
   }

   public void setPailicingmot_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicingmot_Z = value ;
   }

   public boolean getPailicmotobl_Z( )
   {
      return gxTv_SdtPais_base_calculo_Pailicmotobl_Z ;
   }

   public void setPailicmotobl_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Pailicmotobl_Z = value ;
   }

   public short getPaibasepromcnt1_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z ;
   }

   public void setPaibasepromcnt1_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z = value ;
   }

   public short getPaibasepromcnt2_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z ;
   }

   public void setPaibasepromcnt2_Z( short value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z = value ;
   }

   public String getPaibasepromtcnt_Z( )
   {
      return gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z ;
   }

   public void setPaibasepromtcnt_Z( String value )
   {
      gxTv_SdtPais_base_calculo_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z = value ;
   }

   protected byte gxTv_SdtPais_base_calculo_Paibaseclaseleg ;
   protected byte gxTv_SdtPais_base_calculo_Pailicdseman ;
   protected byte gxTv_SdtPais_base_calculo_Pailicdmes ;
   protected byte gxTv_SdtPais_base_calculo_Paibaseclaseleg_Z ;
   protected byte gxTv_SdtPais_base_calculo_Pailicdseman_Z ;
   protected byte gxTv_SdtPais_base_calculo_Pailicdmes_Z ;
   private byte gxTv_SdtPais_base_calculo_N ;
   protected short gxTv_SdtPais_base_calculo_Pailicdlim ;
   protected short gxTv_SdtPais_base_calculo_Pailicdsemes ;
   protected short gxTv_SdtPais_base_calculo_Pailicdanual ;
   protected short gxTv_SdtPais_base_calculo_Paibasepromcnt1 ;
   protected short gxTv_SdtPais_base_calculo_Paibasepromcnt2 ;
   protected short gxTv_SdtPais_base_calculo_Modified ;
   protected short gxTv_SdtPais_base_calculo_Initialized ;
   protected short gxTv_SdtPais_base_calculo_Pailicdlim_Z ;
   protected short gxTv_SdtPais_base_calculo_Pailicdsemes_Z ;
   protected short gxTv_SdtPais_base_calculo_Pailicdanual_Z ;
   protected short gxTv_SdtPais_base_calculo_Paibasepromcnt1_Z ;
   protected short gxTv_SdtPais_base_calculo_Paibasepromcnt2_Z ;
   protected String gxTv_SdtPais_base_calculo_Paibasetipo ;
   protected String gxTv_SdtPais_base_calculo_Paibasecod1 ;
   protected String gxTv_SdtPais_base_calculo_Paibasecod2 ;
   protected String gxTv_SdtPais_base_calculo_Paibasepromtcnt ;
   protected String gxTv_SdtPais_base_calculo_Mode ;
   protected String gxTv_SdtPais_base_calculo_Paibasetipo_Z ;
   protected String gxTv_SdtPais_base_calculo_Paibasecod1_Z ;
   protected String gxTv_SdtPais_base_calculo_Paibasecod2_Z ;
   protected String gxTv_SdtPais_base_calculo_Paibasepromtcnt_Z ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicadju ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicadjuobl ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicnecaut ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicingmot ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicmotobl ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicadju_Z ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicadjuobl_Z ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicnecaut_Z ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicingmot_Z ;
   protected boolean gxTv_SdtPais_base_calculo_Pailicmotobl_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_base_calculo_Paibaseplus ;
   protected java.math.BigDecimal gxTv_SdtPais_base_calculo_Paibaseplus_Z ;
   protected java.util.Vector<web.StructSdtPais_base_calculo_actual> gxTv_SdtPais_base_calculo_Actual=null ;
   protected java.util.Vector<web.StructSdtPais_base_calculo_promedio> gxTv_SdtPais_base_calculo_Promedio=null ;
}

