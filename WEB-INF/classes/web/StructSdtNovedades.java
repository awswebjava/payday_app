package web ;
import com.genexus.*;

public final  class StructSdtNovedades implements Cloneable, java.io.Serializable
{
   public StructSdtNovedades( )
   {
      this( -1, new ModelContext( StructSdtNovedades.class ));
   }

   public StructSdtNovedades( int remoteHandle ,
                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtNovedades_Empnom = "" ;
      gxTv_SdtNovedades_Legapellido = "" ;
      gxTv_SdtNovedades_Legnombre = "" ;
      gxTv_SdtNovedades_Legfecegreso = cal.getTime() ;
      gxTv_SdtNovedades_Concodigo = "" ;
      gxTv_SdtNovedades_Condescrip = "" ;
      gxTv_SdtNovedades_Agecanti = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Agevunit = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Ageimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Agefecdes = cal.getTime() ;
      gxTv_SdtNovedades_Agefechas = cal.getTime() ;
      gxTv_SdtNovedades_Legid = "" ;
      gxTv_SdtNovedades_Ageprevis = "" ;
      gxTv_SdtNovedades_Ageprevcalc = "" ;
      gxTv_SdtNovedades_Ageperdescrip = "" ;
      gxTv_SdtNovedades_Mode = "" ;
      gxTv_SdtNovedades_Empnom_Z = "" ;
      gxTv_SdtNovedades_Legapellido_Z = "" ;
      gxTv_SdtNovedades_Legnombre_Z = "" ;
      gxTv_SdtNovedades_Legfecegreso_Z = cal.getTime() ;
      gxTv_SdtNovedades_Concodigo_Z = "" ;
      gxTv_SdtNovedades_Condescrip_Z = "" ;
      gxTv_SdtNovedades_Agecanti_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Agevunit_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Ageimporte_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtNovedades_Agefecdes_Z = cal.getTime() ;
      gxTv_SdtNovedades_Agefechas_Z = cal.getTime() ;
      gxTv_SdtNovedades_Legid_Z = "" ;
      gxTv_SdtNovedades_Ageprevcalc_Z = "" ;
      gxTv_SdtNovedades_Ageperdescrip_Z = "" ;
      gxTv_SdtNovedades_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtNovedades_Agecanti_N = (byte)(1) ;
      gxTv_SdtNovedades_Agevunit_N = (byte)(1) ;
      gxTv_SdtNovedades_Ageimporte_N = (byte)(1) ;
      gxTv_SdtNovedades_Ageliqnro_N = (byte)(1) ;
      gxTv_SdtNovedades_Agefecdes_N = (byte)(1) ;
      gxTv_SdtNovedades_Agefechas_N = (byte)(1) ;
      gxTv_SdtNovedades_Legid_N = (byte)(1) ;
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
      return gxTv_SdtNovedades_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtNovedades_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtNovedades_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Empnom = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtNovedades_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legnumero = value ;
   }

   public String getLegapellido( )
   {
      return gxTv_SdtNovedades_Legapellido ;
   }

   public void setLegapellido( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legapellido = value ;
   }

   public String getLegnombre( )
   {
      return gxTv_SdtNovedades_Legnombre ;
   }

   public void setLegnombre( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legnombre = value ;
   }

   public java.util.Date getLegfecegreso( )
   {
      return gxTv_SdtNovedades_Legfecegreso ;
   }

   public void setLegfecegreso( java.util.Date value )
   {
      gxTv_SdtNovedades_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legfecegreso = value ;
   }

   public short getAgeorden( )
   {
      return gxTv_SdtNovedades_Ageorden ;
   }

   public void setAgeorden( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageorden = value ;
   }

   public String getConcodigo( )
   {
      return gxTv_SdtNovedades_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Concodigo = value ;
   }

   public String getCondescrip( )
   {
      return gxTv_SdtNovedades_Condescrip ;
   }

   public void setCondescrip( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Condescrip = value ;
   }

   public java.math.BigDecimal getAgecanti( )
   {
      return gxTv_SdtNovedades_Agecanti ;
   }

   public void setAgecanti( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Agecanti_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agecanti = value ;
   }

   public java.math.BigDecimal getAgevunit( )
   {
      return gxTv_SdtNovedades_Agevunit ;
   }

   public void setAgevunit( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Agevunit_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agevunit = value ;
   }

   public java.math.BigDecimal getAgeimporte( )
   {
      return gxTv_SdtNovedades_Ageimporte ;
   }

   public void setAgeimporte( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_Ageimporte_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageimporte = value ;
   }

   public int getAgeliqnro( )
   {
      return gxTv_SdtNovedades_Ageliqnro ;
   }

   public void setAgeliqnro( int value )
   {
      gxTv_SdtNovedades_Ageliqnro_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageliqnro = value ;
   }

   public java.util.Date getAgefecdes( )
   {
      return gxTv_SdtNovedades_Agefecdes ;
   }

   public void setAgefecdes( java.util.Date value )
   {
      gxTv_SdtNovedades_Agefecdes_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefecdes = value ;
   }

   public java.util.Date getAgefechas( )
   {
      return gxTv_SdtNovedades_Agefechas ;
   }

   public void setAgefechas( java.util.Date value )
   {
      gxTv_SdtNovedades_Agefechas_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefechas = value ;
   }

   public boolean getAgelegactivo( )
   {
      return gxTv_SdtNovedades_Agelegactivo ;
   }

   public void setAgelegactivo( boolean value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agelegactivo = value ;
   }

   public String getLegid( )
   {
      return gxTv_SdtNovedades_Legid ;
   }

   public void setLegid( String value )
   {
      gxTv_SdtNovedades_Legid_N = (byte)(0) ;
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legid = value ;
   }

   public String getAgeprevis( )
   {
      return gxTv_SdtNovedades_Ageprevis ;
   }

   public void setAgeprevis( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageprevis = value ;
   }

   public String getAgeprevcalc( )
   {
      return gxTv_SdtNovedades_Ageprevcalc ;
   }

   public void setAgeprevcalc( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageprevcalc = value ;
   }

   public long getLegcuil( )
   {
      return gxTv_SdtNovedades_Legcuil ;
   }

   public void setLegcuil( long value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legcuil = value ;
   }

   public String getAgeperdescrip( )
   {
      return gxTv_SdtNovedades_Ageperdescrip ;
   }

   public void setAgeperdescrip( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageperdescrip = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtNovedades_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtNovedades_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtNovedades_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtNovedades_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtNovedades_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Empnom_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtNovedades_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legnumero_Z = value ;
   }

   public String getLegapellido_Z( )
   {
      return gxTv_SdtNovedades_Legapellido_Z ;
   }

   public void setLegapellido_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legapellido_Z = value ;
   }

   public String getLegnombre_Z( )
   {
      return gxTv_SdtNovedades_Legnombre_Z ;
   }

   public void setLegnombre_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legnombre_Z = value ;
   }

   public java.util.Date getLegfecegreso_Z( )
   {
      return gxTv_SdtNovedades_Legfecegreso_Z ;
   }

   public void setLegfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legfecegreso_Z = value ;
   }

   public short getAgeorden_Z( )
   {
      return gxTv_SdtNovedades_Ageorden_Z ;
   }

   public void setAgeorden_Z( short value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageorden_Z = value ;
   }

   public String getConcodigo_Z( )
   {
      return gxTv_SdtNovedades_Concodigo_Z ;
   }

   public void setConcodigo_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Concodigo_Z = value ;
   }

   public String getCondescrip_Z( )
   {
      return gxTv_SdtNovedades_Condescrip_Z ;
   }

   public void setCondescrip_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Condescrip_Z = value ;
   }

   public java.math.BigDecimal getAgecanti_Z( )
   {
      return gxTv_SdtNovedades_Agecanti_Z ;
   }

   public void setAgecanti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agecanti_Z = value ;
   }

   public java.math.BigDecimal getAgevunit_Z( )
   {
      return gxTv_SdtNovedades_Agevunit_Z ;
   }

   public void setAgevunit_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agevunit_Z = value ;
   }

   public java.math.BigDecimal getAgeimporte_Z( )
   {
      return gxTv_SdtNovedades_Ageimporte_Z ;
   }

   public void setAgeimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageimporte_Z = value ;
   }

   public int getAgeliqnro_Z( )
   {
      return gxTv_SdtNovedades_Ageliqnro_Z ;
   }

   public void setAgeliqnro_Z( int value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageliqnro_Z = value ;
   }

   public java.util.Date getAgefecdes_Z( )
   {
      return gxTv_SdtNovedades_Agefecdes_Z ;
   }

   public void setAgefecdes_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefecdes_Z = value ;
   }

   public java.util.Date getAgefechas_Z( )
   {
      return gxTv_SdtNovedades_Agefechas_Z ;
   }

   public void setAgefechas_Z( java.util.Date value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefechas_Z = value ;
   }

   public boolean getAgelegactivo_Z( )
   {
      return gxTv_SdtNovedades_Agelegactivo_Z ;
   }

   public void setAgelegactivo_Z( boolean value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agelegactivo_Z = value ;
   }

   public String getLegid_Z( )
   {
      return gxTv_SdtNovedades_Legid_Z ;
   }

   public void setLegid_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legid_Z = value ;
   }

   public String getAgeprevcalc_Z( )
   {
      return gxTv_SdtNovedades_Ageprevcalc_Z ;
   }

   public void setAgeprevcalc_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageprevcalc_Z = value ;
   }

   public long getLegcuil_Z( )
   {
      return gxTv_SdtNovedades_Legcuil_Z ;
   }

   public void setLegcuil_Z( long value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legcuil_Z = value ;
   }

   public String getAgeperdescrip_Z( )
   {
      return gxTv_SdtNovedades_Ageperdescrip_Z ;
   }

   public void setAgeperdescrip_Z( String value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageperdescrip_Z = value ;
   }

   public byte getLegfecegreso_N( )
   {
      return gxTv_SdtNovedades_Legfecegreso_N ;
   }

   public void setLegfecegreso_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legfecegreso_N = value ;
   }

   public byte getAgecanti_N( )
   {
      return gxTv_SdtNovedades_Agecanti_N ;
   }

   public void setAgecanti_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agecanti_N = value ;
   }

   public byte getAgevunit_N( )
   {
      return gxTv_SdtNovedades_Agevunit_N ;
   }

   public void setAgevunit_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agevunit_N = value ;
   }

   public byte getAgeimporte_N( )
   {
      return gxTv_SdtNovedades_Ageimporte_N ;
   }

   public void setAgeimporte_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageimporte_N = value ;
   }

   public byte getAgeliqnro_N( )
   {
      return gxTv_SdtNovedades_Ageliqnro_N ;
   }

   public void setAgeliqnro_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Ageliqnro_N = value ;
   }

   public byte getAgefecdes_N( )
   {
      return gxTv_SdtNovedades_Agefecdes_N ;
   }

   public void setAgefecdes_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefecdes_N = value ;
   }

   public byte getAgefechas_N( )
   {
      return gxTv_SdtNovedades_Agefechas_N ;
   }

   public void setAgefechas_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Agefechas_N = value ;
   }

   public byte getLegid_N( )
   {
      return gxTv_SdtNovedades_Legid_N ;
   }

   public void setLegid_N( byte value )
   {
      gxTv_SdtNovedades_N = (byte)(0) ;
      gxTv_SdtNovedades_Legid_N = value ;
   }

   protected byte gxTv_SdtNovedades_Legfecegreso_N ;
   protected byte gxTv_SdtNovedades_Agecanti_N ;
   protected byte gxTv_SdtNovedades_Agevunit_N ;
   protected byte gxTv_SdtNovedades_Ageimporte_N ;
   protected byte gxTv_SdtNovedades_Ageliqnro_N ;
   protected byte gxTv_SdtNovedades_Agefecdes_N ;
   protected byte gxTv_SdtNovedades_Agefechas_N ;
   protected byte gxTv_SdtNovedades_Legid_N ;
   private byte gxTv_SdtNovedades_N ;
   protected short gxTv_SdtNovedades_Empcod ;
   protected short gxTv_SdtNovedades_Ageorden ;
   protected short gxTv_SdtNovedades_Initialized ;
   protected short gxTv_SdtNovedades_Empcod_Z ;
   protected short gxTv_SdtNovedades_Ageorden_Z ;
   protected int gxTv_SdtNovedades_Clicod ;
   protected int gxTv_SdtNovedades_Legnumero ;
   protected int gxTv_SdtNovedades_Ageliqnro ;
   protected int gxTv_SdtNovedades_Clicod_Z ;
   protected int gxTv_SdtNovedades_Legnumero_Z ;
   protected int gxTv_SdtNovedades_Ageliqnro_Z ;
   protected long gxTv_SdtNovedades_Legcuil ;
   protected long gxTv_SdtNovedades_Legcuil_Z ;
   protected String gxTv_SdtNovedades_Concodigo ;
   protected String gxTv_SdtNovedades_Legid ;
   protected String gxTv_SdtNovedades_Ageprevcalc ;
   protected String gxTv_SdtNovedades_Mode ;
   protected String gxTv_SdtNovedades_Concodigo_Z ;
   protected String gxTv_SdtNovedades_Legid_Z ;
   protected String gxTv_SdtNovedades_Ageprevcalc_Z ;
   protected boolean gxTv_SdtNovedades_Agelegactivo ;
   protected boolean gxTv_SdtNovedades_Agelegactivo_Z ;
   protected String gxTv_SdtNovedades_Ageprevis ;
   protected String gxTv_SdtNovedades_Empnom ;
   protected String gxTv_SdtNovedades_Legapellido ;
   protected String gxTv_SdtNovedades_Legnombre ;
   protected String gxTv_SdtNovedades_Condescrip ;
   protected String gxTv_SdtNovedades_Ageperdescrip ;
   protected String gxTv_SdtNovedades_Empnom_Z ;
   protected String gxTv_SdtNovedades_Legapellido_Z ;
   protected String gxTv_SdtNovedades_Legnombre_Z ;
   protected String gxTv_SdtNovedades_Condescrip_Z ;
   protected String gxTv_SdtNovedades_Ageperdescrip_Z ;
   protected java.util.Date gxTv_SdtNovedades_Legfecegreso ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Agecanti ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Agevunit ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Ageimporte ;
   protected java.util.Date gxTv_SdtNovedades_Agefecdes ;
   protected java.util.Date gxTv_SdtNovedades_Agefechas ;
   protected java.util.Date gxTv_SdtNovedades_Legfecegreso_Z ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Agecanti_Z ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Agevunit_Z ;
   protected java.math.BigDecimal gxTv_SdtNovedades_Ageimporte_Z ;
   protected java.util.Date gxTv_SdtNovedades_Agefecdes_Z ;
   protected java.util.Date gxTv_SdtNovedades_Agefechas_Z ;
}

