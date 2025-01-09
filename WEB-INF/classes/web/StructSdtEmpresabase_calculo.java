package web ;
import com.genexus.*;

public final  class StructSdtEmpresabase_calculo implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresabase_calculo( )
   {
      this( -1, new ModelContext( StructSdtEmpresabase_calculo.class ));
   }

   public StructSdtEmpresabase_calculo( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_SdtEmpresabase_calculo_Empbasetipo = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1 = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2 = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt = "" ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = "" ;
      gxTv_SdtEmpresabase_calculo_Mode = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(1) ;
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
      return gxTv_SdtEmpresabase_calculo_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtEmpresabase_calculo_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empcod = value ;
   }

   public byte getEmpbaseclaseleg( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseclaseleg ;
   }

   public void setEmpbaseclaseleg( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseclaseleg = value ;
   }

   public String getEmpbasetipo( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasetipo ;
   }

   public void setEmpbasetipo( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasetipo = value ;
   }

   public String getEmpbasecod1( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod1 ;
   }

   public void setEmpbasecod1( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1 = value ;
   }

   public String getEmpbasec1txt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec1txt ;
   }

   public void setEmpbasec1txt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt = value ;
   }

   public String getEmpbasecod2( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod2 ;
   }

   public void setEmpbasecod2( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2 = value ;
   }

   public String getEmpbasec2txt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec2txt ;
   }

   public void setEmpbasec2txt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt = value ;
   }

   public java.math.BigDecimal getEmpbaseplus( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseplus ;
   }

   public void setEmpbaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus = value ;
   }

   public byte getEmplicdmin( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin ;
   }

   public void setEmplicdmin( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmin = value ;
   }

   public short getEmplicdlim( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim ;
   }

   public void setEmplicdlim( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdlim = value ;
   }

   public byte getEmplicdseman( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman ;
   }

   public void setEmplicdseman( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdseman = value ;
   }

   public byte getEmplicdmes( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes ;
   }

   public void setEmplicdmes( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmes = value ;
   }

   public short getEmplicdsemes( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes ;
   }

   public void setEmplicdsemes( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdsemes = value ;
   }

   public short getEmplicdanual( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual ;
   }

   public void setEmplicdanual( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdanual = value ;
   }

   public boolean getEmplicadju( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju ;
   }

   public void setEmplicadju( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadju = value ;
   }

   public boolean getEmplicadjuobl( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl ;
   }

   public void setEmplicadjuobl( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl = value ;
   }

   public boolean getEmplicnecaut( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut ;
   }

   public void setEmplicnecaut( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicnecaut = value ;
   }

   public boolean getEmplicingmot( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot ;
   }

   public void setEmplicingmot( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicingmot = value ;
   }

   public boolean getEmplicmotobl( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl ;
   }

   public void setEmplicmotobl( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicmotobl = value ;
   }

   public short getEmpbaseord( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord ;
   }

   public void setEmpbaseord( short value )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseord = value ;
   }

   public short getEmpbasepromcnt1( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 ;
   }

   public void setEmpbasepromcnt1( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 = value ;
   }

   public short getEmpbasepromcnt2( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 ;
   }

   public void setEmpbasepromcnt2( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 = value ;
   }

   public String getEmpbasepromtcnt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromtcnt ;
   }

   public void setEmpbasepromtcnt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = value ;
   }

   public int getEmpbaserelsec( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaserelsec ;
   }

   public void setEmpbaserelsec( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaserelsec = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresabase_calculo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresabase_calculo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empcod_Z = value ;
   }

   public byte getEmpbaseclaseleg_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z ;
   }

   public void setEmpbaseclaseleg_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z = value ;
   }

   public String getEmpbasetipo_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasetipo_Z ;
   }

   public void setEmpbasetipo_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = value ;
   }

   public String getEmpbasecod1_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod1_Z ;
   }

   public void setEmpbasecod1_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = value ;
   }

   public String getEmpbasec1txt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z ;
   }

   public void setEmpbasec1txt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = value ;
   }

   public String getEmpbasecod2_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod2_Z ;
   }

   public void setEmpbasecod2_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = value ;
   }

   public String getEmpbasec2txt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z ;
   }

   public void setEmpbasec2txt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = value ;
   }

   public java.math.BigDecimal getEmpbaseplus_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseplus_Z ;
   }

   public void setEmpbaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = value ;
   }

   public byte getEmplicdmin_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin_Z ;
   }

   public void setEmplicdmin_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmin_Z = value ;
   }

   public short getEmplicdlim_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim_Z ;
   }

   public void setEmplicdlim_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdlim_Z = value ;
   }

   public byte getEmplicdseman_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman_Z ;
   }

   public void setEmplicdseman_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdseman_Z = value ;
   }

   public byte getEmplicdmes_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes_Z ;
   }

   public void setEmplicdmes_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmes_Z = value ;
   }

   public short getEmplicdsemes_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z ;
   }

   public void setEmplicdsemes_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z = value ;
   }

   public short getEmplicdanual_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual_Z ;
   }

   public void setEmplicdanual_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdanual_Z = value ;
   }

   public boolean getEmplicadju_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju_Z ;
   }

   public void setEmplicadju_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadju_Z = value ;
   }

   public boolean getEmplicadjuobl_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z ;
   }

   public void setEmplicadjuobl_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z = value ;
   }

   public boolean getEmplicnecaut_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z ;
   }

   public void setEmplicnecaut_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z = value ;
   }

   public boolean getEmplicingmot_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot_Z ;
   }

   public void setEmplicingmot_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicingmot_Z = value ;
   }

   public boolean getEmplicmotobl_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z ;
   }

   public void setEmplicmotobl_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z = value ;
   }

   public short getEmpbaseord_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord_Z ;
   }

   public void setEmpbaseord_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseord_Z = value ;
   }

   public short getEmpbasepromcnt1_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z ;
   }

   public void setEmpbasepromcnt1_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z = value ;
   }

   public short getEmpbasepromcnt2_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z ;
   }

   public void setEmpbasepromcnt2_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z = value ;
   }

   public String getEmpbasepromtcnt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z ;
   }

   public void setEmpbasepromtcnt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = value ;
   }

   public int getEmpbaserelsec_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z ;
   }

   public void setEmpbaserelsec_Z( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z = value ;
   }

   public byte getEmplicdmin_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin_N ;
   }

   public void setEmplicdmin_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = value ;
   }

   public byte getEmplicdlim_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim_N ;
   }

   public void setEmplicdlim_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = value ;
   }

   public byte getEmplicdseman_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman_N ;
   }

   public void setEmplicdseman_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = value ;
   }

   public byte getEmplicdmes_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes_N ;
   }

   public void setEmplicdmes_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = value ;
   }

   public byte getEmplicdsemes_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes_N ;
   }

   public void setEmplicdsemes_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = value ;
   }

   public byte getEmplicdanual_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual_N ;
   }

   public void setEmplicdanual_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = value ;
   }

   public byte getEmplicadju_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju_N ;
   }

   public void setEmplicadju_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = value ;
   }

   public byte getEmplicadjuobl_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N ;
   }

   public void setEmplicadjuobl_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = value ;
   }

   public byte getEmplicnecaut_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut_N ;
   }

   public void setEmplicnecaut_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = value ;
   }

   public byte getEmplicingmot_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot_N ;
   }

   public void setEmplicingmot_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = value ;
   }

   public byte getEmplicmotobl_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl_N ;
   }

   public void setEmplicmotobl_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = value ;
   }

   public byte getEmpbaseord_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord_N ;
   }

   public void setEmpbaseord_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = value ;
   }

   protected byte gxTv_SdtEmpresabase_calculo_Empbaseclaseleg ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmin ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdseman ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmes ;
   protected byte gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmin_Z ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdseman_Z ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmes_Z ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmin_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdlim_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdseman_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdmes_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdsemes_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicdanual_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicadju_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicnecaut_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicingmot_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Emplicmotobl_N ;
   protected byte gxTv_SdtEmpresabase_calculo_Empbaseord_N ;
   private byte gxTv_SdtEmpresabase_calculo_N ;
   protected short gxTv_SdtEmpresabase_calculo_Empcod ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdlim ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdsemes ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdanual ;
   protected short gxTv_SdtEmpresabase_calculo_Empbaseord ;
   protected short gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 ;
   protected short gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 ;
   protected short gxTv_SdtEmpresabase_calculo_Initialized ;
   protected short gxTv_SdtEmpresabase_calculo_Empcod_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdlim_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Emplicdanual_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Empbaseord_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z ;
   protected short gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z ;
   protected int gxTv_SdtEmpresabase_calculo_Clicod ;
   protected int gxTv_SdtEmpresabase_calculo_Empbaserelsec ;
   protected int gxTv_SdtEmpresabase_calculo_Clicod_Z ;
   protected int gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasetipo ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasecod1 ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasecod2 ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasepromtcnt ;
   protected String gxTv_SdtEmpresabase_calculo_Mode ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasetipo_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasecod1_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasecod2_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicadju ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicadjuobl ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicnecaut ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicingmot ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicmotobl ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicadju_Z ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicingmot_Z ;
   protected boolean gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasec1txt ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasec2txt ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z ;
   protected String gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresabase_calculo_Empbaseplus ;
   protected java.math.BigDecimal gxTv_SdtEmpresabase_calculo_Empbaseplus_Z ;
}

