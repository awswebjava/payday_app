package web ;
import com.genexus.*;

public final  class StructSdtLiquidacionLegajo implements Cloneable, java.io.Serializable
{
   public StructSdtLiquidacionLegajo( )
   {
      this( -1, new ModelContext( StructSdtLiquidacionLegajo.class ));
   }

   public StructSdtLiquidacionLegajo( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLiquidacionLegajo_Empnom = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo = "" ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip = "" ;
      gxTv_SdtLiquidacionLegajo_Legid = "" ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf = "" ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror = "" ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf = "" ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = "" ;
      gxTv_SdtLiquidacionLegajo_Tliqcod = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghtml = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Mode = "" ;
      gxTv_SdtLiquidacionLegajo_Empnom_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Legid_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Tliqcod_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = cal.getTime() ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(1) ;
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
      return gxTv_SdtLiquidacionLegajo_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLiquidacionLegajo_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtLiquidacionLegajo_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Empnom = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnro = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtLiquidacionLegajo_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legnumero = value ;
   }

   public java.math.BigDecimal getLiqlegimptotal( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotal ;
   }

   public void setLiqlegimptotal( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal = value ;
   }

   public String getLiqseccodigo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo ;
   }

   public void setLiqseccodigo( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo = value ;
   }

   public String getLiqsecdescrip( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqsecdescrip ;
   }

   public void setLiqsecdescrip( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip = value ;
   }

   public int getLiqlegrecibonro( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegrecibonro ;
   }

   public void setLiqlegrecibonro( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegrecibonro = value ;
   }

   public String getLegid( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid ;
   }

   public void setLegid( String value )
   {
      gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legid = value ;
   }

   public String getLegliqdatoshis( )
   {
      return gxTv_SdtLiquidacionLegajo_Legliqdatoshis ;
   }

   public void setLegliqdatoshis( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbruto( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto ;
   }

   public void setLiqlegimptotbruto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbrusinsac( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac ;
   }

   public void setLiqlegimptotbrusinsac( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = value ;
   }

   public short getLiqlegcntconc( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcntconc ;
   }

   public void setLiqlegcntconc( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegcntconc = value ;
   }

   public java.math.BigDecimal getLiqlegimptotremu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotremu ;
   }

   public void setLiqlegimptotremu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = value ;
   }

   public java.math.BigDecimal getLiqlegimptotnoremu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu ;
   }

   public void setLiqlegimptotnoremu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = value ;
   }

   public java.math.BigDecimal getLiqlegimptotdescu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu ;
   }

   public void setLiqlegimptotdescu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = value ;
   }

   public java.math.BigDecimal getLiqlegimpcontr( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcontr ;
   }

   public void setLiqlegimpcontr( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = value ;
   }

   public java.math.BigDecimal getLiqlegimpcosto( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcosto ;
   }

   public void setLiqlegimpcosto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = value ;
   }

   public java.math.BigDecimal getLiqlegimpotrdescu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu ;
   }

   public void setLiqlegimpotrdescu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = value ;
   }

   public java.math.BigDecimal getLiqlegimpdescuneg( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg ;
   }

   public void setLiqlegimpdescuneg( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = value ;
   }

   public java.math.BigDecimal getLiqlegimptotretgan( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan ;
   }

   public void setLiqlegimptotretgan( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = value ;
   }

   public java.math.BigDecimal getLiqlegimppagosacuen( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen ;
   }

   public void setLiqlegimppagosacuen( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbruprom( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom ;
   }

   public void setLiqlegimptotbruprom( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = value ;
   }

   public java.math.BigDecimal getLiqlegimpbasico( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpbasico ;
   }

   public void setLiqlegimpbasico( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = value ;
   }

   public java.math.BigDecimal getLiqleggnsi( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleggnsi ;
   }

   public void setLiqleggnsi( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi = value ;
   }

   public String getLiqrutapdf( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdf ;
   }

   public void setLiqrutapdf( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf = value ;
   }

   public String getLiqrutapdfvertical( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical ;
   }

   public void setLiqrutapdfvertical( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = value ;
   }

   public short getLiqlegiteraciones( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegiteraciones ;
   }

   public void setLiqlegiteraciones( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegiteraciones = value ;
   }

   public java.math.BigDecimal getLiqlegsegundos( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegundos ;
   }

   public void setLiqlegsegundos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos = value ;
   }

   public java.math.BigDecimal getLiqlegsegins( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegins ;
   }

   public void setLiqlegsegins( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins = value ;
   }

   public java.math.BigDecimal getLieqlegsegupd( )
   {
      return gxTv_SdtLiquidacionLegajo_Lieqlegsegupd ;
   }

   public void setLieqlegsegupd( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = value ;
   }

   public String getLiqlegerror( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerror ;
   }

   public void setLiqlegerror( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo = value ;
   }

   public String getLiqnombrepdf( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdf ;
   }

   public void setLiqnombrepdf( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf = value ;
   }

   public String getLiqnombrepdfvertical( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical ;
   }

   public void setLiqnombrepdfvertical( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Tliqcod = value ;
   }

   public java.math.BigDecimal getLiqleghorassem( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghorassem ;
   }

   public void setLiqleghorassem( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem = value ;
   }

   public byte getLiqlegauxestado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegauxestado ;
   }

   public void setLiqlegauxestado( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegauxestado = value ;
   }

   public String getLiqlegerroraux( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerroraux ;
   }

   public void setLiqlegerroraux( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux = value ;
   }

   public java.util.Date getLiqlegfecegr( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecegr ;
   }

   public void setLiqlegfecegr( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr = value ;
   }

   public java.util.Date getLiqlegfecing( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecing ;
   }

   public void setLiqlegfecing( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing = value ;
   }

   public String getLiqlegcatcodigo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo ;
   }

   public void setLiqlegcatcodigo( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = value ;
   }

   public String getLiqlegconvenio( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegconvenio ;
   }

   public void setLiqlegconvenio( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio = value ;
   }

   public java.math.BigDecimal getLiqlegsueldo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsueldo ;
   }

   public void setLiqlegsueldo( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo = value ;
   }

   public String getLiqlegpdfestado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado ;
   }

   public void setLiqlegpdfestado( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = value ;
   }

   public byte getLiqlegprocesado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegprocesado ;
   }

   public void setLiqlegprocesado( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegprocesado = value ;
   }

   public byte getLiqlegnivliq( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegnivliq ;
   }

   public void setLiqlegnivliq( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegnivliq = value ;
   }

   public String getLiqleghtml( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghtml ;
   }

   public void setLiqleghtml( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleghtml = value ;
   }

   public byte getLiqleglsd( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleglsd ;
   }

   public void setLiqleglsd( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleglsd = value ;
   }

   public String getLiqlegdaemonuuid( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid ;
   }

   public void setLiqlegdaemonuuid( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = value ;
   }

   public java.util.Date getLiqlegfechor( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfechor ;
   }

   public void setLiqlegfechor( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLiquidacionLegajo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLiquidacionLegajo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Empnom_Z = value ;
   }

   public int getLiqnro_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnro_Z ;
   }

   public void setLiqnro_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnro_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legnumero_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotal_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z ;
   }

   public void setLiqlegimptotal_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = value ;
   }

   public String getLiqseccodigo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z ;
   }

   public void setLiqseccodigo_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = value ;
   }

   public String getLiqsecdescrip_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z ;
   }

   public void setLiqsecdescrip_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = value ;
   }

   public int getLiqlegrecibonro_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z ;
   }

   public void setLiqlegrecibonro_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z = value ;
   }

   public String getLegid_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid_Z ;
   }

   public void setLegid_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legid_Z = value ;
   }

   public String getLegliqdatoshis_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z ;
   }

   public void setLegliqdatoshis_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbruto_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z ;
   }

   public void setLiqlegimptotbruto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbrusinsac_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z ;
   }

   public void setLiqlegimptotbrusinsac_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = value ;
   }

   public short getLiqlegcntconc_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z ;
   }

   public void setLiqlegcntconc_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotremu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z ;
   }

   public void setLiqlegimptotremu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotnoremu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z ;
   }

   public void setLiqlegimptotnoremu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotdescu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z ;
   }

   public void setLiqlegimptotdescu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimpcontr_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z ;
   }

   public void setLiqlegimpcontr_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimpcosto_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z ;
   }

   public void setLiqlegimpcosto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimpotrdescu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z ;
   }

   public void setLiqlegimpotrdescu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimpdescuneg_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z ;
   }

   public void setLiqlegimpdescuneg_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotretgan_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z ;
   }

   public void setLiqlegimptotretgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimppagosacuen_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z ;
   }

   public void setLiqlegimppagosacuen_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimptotbruprom_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z ;
   }

   public void setLiqlegimptotbruprom_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = value ;
   }

   public java.math.BigDecimal getLiqlegimpbasico_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z ;
   }

   public void setLiqlegimpbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = value ;
   }

   public java.math.BigDecimal getLiqleggnsi_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z ;
   }

   public void setLiqleggnsi_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = value ;
   }

   public String getLiqrutapdf_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z ;
   }

   public void setLiqrutapdf_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = value ;
   }

   public String getLiqrutapdfvertical_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z ;
   }

   public void setLiqrutapdfvertical_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = value ;
   }

   public short getLiqlegiteraciones_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z ;
   }

   public void setLiqlegiteraciones_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z = value ;
   }

   public java.math.BigDecimal getLiqlegsegundos_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z ;
   }

   public void setLiqlegsegundos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = value ;
   }

   public java.math.BigDecimal getLiqlegsegins_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z ;
   }

   public void setLiqlegsegins_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = value ;
   }

   public java.math.BigDecimal getLieqlegsegupd_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z ;
   }

   public void setLieqlegsegupd_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = value ;
   }

   public String getLiqlegerror_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerror_Z ;
   }

   public void setLiqlegerror_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = value ;
   }

   public java.util.Date getLiqperiodo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqperiodo_Z ;
   }

   public void setLiqperiodo_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = value ;
   }

   public String getLiqnombrepdf_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z ;
   }

   public void setLiqnombrepdf_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = value ;
   }

   public String getLiqnombrepdfvertical_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z ;
   }

   public void setLiqnombrepdfvertical_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = value ;
   }

   public String getTliqcod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod_Z ;
   }

   public void setTliqcod_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Tliqcod_Z = value ;
   }

   public java.math.BigDecimal getLiqleghorassem_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z ;
   }

   public void setLiqleghorassem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = value ;
   }

   public byte getLiqlegauxestado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z ;
   }

   public void setLiqlegauxestado_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z = value ;
   }

   public String getLiqlegerroraux_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z ;
   }

   public void setLiqlegerroraux_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = value ;
   }

   public java.util.Date getLiqlegfecegr_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z ;
   }

   public void setLiqlegfecegr_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = value ;
   }

   public java.util.Date getLiqlegfecing_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z ;
   }

   public void setLiqlegfecing_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = value ;
   }

   public String getLiqlegcatcodigo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z ;
   }

   public void setLiqlegcatcodigo_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = value ;
   }

   public String getLiqlegconvenio_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z ;
   }

   public void setLiqlegconvenio_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = value ;
   }

   public java.math.BigDecimal getLiqlegsueldo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z ;
   }

   public void setLiqlegsueldo_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = value ;
   }

   public String getLiqlegpdfestado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z ;
   }

   public void setLiqlegpdfestado_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = value ;
   }

   public byte getLiqlegprocesado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z ;
   }

   public void setLiqlegprocesado_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z = value ;
   }

   public byte getLiqlegnivliq_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z ;
   }

   public void setLiqlegnivliq_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z = value ;
   }

   public byte getLiqleglsd_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleglsd_Z ;
   }

   public void setLiqleglsd_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqleglsd_Z = value ;
   }

   public String getLiqlegdaemonuuid_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z ;
   }

   public void setLiqlegdaemonuuid_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = value ;
   }

   public java.util.Date getLiqlegfechor_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z ;
   }

   public void setLiqlegfechor_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = value ;
   }

   public byte getLiqseccodigo_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo_N ;
   }

   public void setLiqseccodigo_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = value ;
   }

   public byte getLegid_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid_N ;
   }

   public void setLegid_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Legid_N = value ;
   }

   public byte getTliqcod_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod_N ;
   }

   public void setTliqcod_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = value ;
   }

   public byte getLiqlegpdfestado_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N ;
   }

   public void setLiqlegpdfestado_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = value ;
   }

   public byte getLiqlegdaemonuuid_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N ;
   }

   public void setLiqlegdaemonuuid_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = value ;
   }

   protected byte gxTv_SdtLiquidacionLegajo_Liqlegauxestado ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegprocesado ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegnivliq ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqleglsd ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqleglsd_Z ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqseccodigo_N ;
   protected byte gxTv_SdtLiquidacionLegajo_Legid_N ;
   protected byte gxTv_SdtLiquidacionLegajo_Tliqcod_N ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N ;
   protected byte gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N ;
   private byte gxTv_SdtLiquidacionLegajo_N ;
   protected short gxTv_SdtLiquidacionLegajo_Empcod ;
   protected short gxTv_SdtLiquidacionLegajo_Liqlegcntconc ;
   protected short gxTv_SdtLiquidacionLegajo_Liqlegiteraciones ;
   protected short gxTv_SdtLiquidacionLegajo_Initialized ;
   protected short gxTv_SdtLiquidacionLegajo_Empcod_Z ;
   protected short gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z ;
   protected short gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z ;
   protected int gxTv_SdtLiquidacionLegajo_Clicod ;
   protected int gxTv_SdtLiquidacionLegajo_Liqnro ;
   protected int gxTv_SdtLiquidacionLegajo_Legnumero ;
   protected int gxTv_SdtLiquidacionLegajo_Liqlegrecibonro ;
   protected int gxTv_SdtLiquidacionLegajo_Clicod_Z ;
   protected int gxTv_SdtLiquidacionLegajo_Liqnro_Z ;
   protected int gxTv_SdtLiquidacionLegajo_Legnumero_Z ;
   protected int gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqseccodigo ;
   protected String gxTv_SdtLiquidacionLegajo_Legid ;
   protected String gxTv_SdtLiquidacionLegajo_Liqnombrepdf ;
   protected String gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical ;
   protected String gxTv_SdtLiquidacionLegajo_Tliqcod ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegconvenio ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegpdfestado ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid ;
   protected String gxTv_SdtLiquidacionLegajo_Mode ;
   protected String gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Legid_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Tliqcod_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqleghtml ;
   protected String gxTv_SdtLiquidacionLegajo_Empnom ;
   protected String gxTv_SdtLiquidacionLegajo_Liqsecdescrip ;
   protected String gxTv_SdtLiquidacionLegajo_Legliqdatoshis ;
   protected String gxTv_SdtLiquidacionLegajo_Liqrutapdf ;
   protected String gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegerror ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegerroraux ;
   protected String gxTv_SdtLiquidacionLegajo_Empnom_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegerror_Z ;
   protected String gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotal ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotremu ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcontr ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcosto ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpbasico ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleggnsi ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegundos ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegins ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Lieqlegsegupd ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqperiodo ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleghorassem ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecegr ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecing ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsueldo ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfechor ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqperiodo_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z ;
   protected java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z ;
}

