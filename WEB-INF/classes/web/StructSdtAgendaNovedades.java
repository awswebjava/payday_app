package web ;
import com.genexus.*;

public final  class StructSdtAgendaNovedades implements Cloneable, java.io.Serializable
{
   public StructSdtAgendaNovedades( )
   {
      this( -1, new ModelContext( StructSdtAgendaNovedades.class ));
   }

   public StructSdtAgendaNovedades( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtAgendaNovedades_Empnom = "" ;
      gxTv_SdtAgendaNovedades_Legapellido = "" ;
      gxTv_SdtAgendaNovedades_Legnombre = "" ;
      gxTv_SdtAgendaNovedades_Legfecegreso = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Concodigo = "" ;
      gxTv_SdtAgendaNovedades_Condescrip = "" ;
      gxTv_SdtAgendaNovedades_Agecanti = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Agevunit = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Ageimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Agefecdes = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Agefechas = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Legid = "" ;
      gxTv_SdtAgendaNovedades_Mode = "" ;
      gxTv_SdtAgendaNovedades_Empnom_Z = "" ;
      gxTv_SdtAgendaNovedades_Legapellido_Z = "" ;
      gxTv_SdtAgendaNovedades_Legnombre_Z = "" ;
      gxTv_SdtAgendaNovedades_Legfecegreso_Z = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Concodigo_Z = "" ;
      gxTv_SdtAgendaNovedades_Condescrip_Z = "" ;
      gxTv_SdtAgendaNovedades_Agecanti_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Agevunit_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Ageimporte_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtAgendaNovedades_Agefecdes_Z = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Agefechas_Z = cal.getTime() ;
      gxTv_SdtAgendaNovedades_Legid_Z = "" ;
      gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Legid_N = (byte)(1) ;
      gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(1) ;
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
      return gxTv_SdtAgendaNovedades_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtAgendaNovedades_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtAgendaNovedades_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Empnom = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtAgendaNovedades_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legnumero = value ;
   }

   public String getLegapellido( )
   {
      return gxTv_SdtAgendaNovedades_Legapellido ;
   }

   public void setLegapellido( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legapellido = value ;
   }

   public String getLegnombre( )
   {
      return gxTv_SdtAgendaNovedades_Legnombre ;
   }

   public void setLegnombre( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legnombre = value ;
   }

   public java.util.Date getLegfecegreso( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso ;
   }

   public void setLegfecegreso( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legfecegreso = value ;
   }

   public short getAgeorden( )
   {
      return gxTv_SdtAgendaNovedades_Ageorden ;
   }

   public void setAgeorden( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageorden = value ;
   }

   public String getConcodigo( )
   {
      return gxTv_SdtAgendaNovedades_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Concodigo = value ;
   }

   public String getCondescrip( )
   {
      return gxTv_SdtAgendaNovedades_Condescrip ;
   }

   public void setCondescrip( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Condescrip = value ;
   }

   public java.math.BigDecimal getAgecanti( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti ;
   }

   public void setAgecanti( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Agecanti_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agecanti = value ;
   }

   public java.math.BigDecimal getAgevunit( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit ;
   }

   public void setAgevunit( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Agevunit_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agevunit = value ;
   }

   public java.math.BigDecimal getAgeimporte( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte ;
   }

   public void setAgeimporte( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_Ageimporte_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageimporte = value ;
   }

   public java.util.Date getAgefecdes( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes ;
   }

   public void setAgefecdes( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Agefecdes_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefecdes = value ;
   }

   public java.util.Date getAgefechas( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas ;
   }

   public void setAgefechas( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_Agefechas_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefechas = value ;
   }

   public boolean getAgelegactivo( )
   {
      return gxTv_SdtAgendaNovedades_Agelegactivo ;
   }

   public void setAgelegactivo( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agelegactivo = value ;
   }

   public String getLegid( )
   {
      return gxTv_SdtAgendaNovedades_Legid ;
   }

   public void setLegid( String value )
   {
      gxTv_SdtAgendaNovedades_Legid_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legid = value ;
   }

   public boolean getConcanti( )
   {
      return gxTv_SdtAgendaNovedades_Concanti ;
   }

   public void setConcanti( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Concanti = value ;
   }

   public boolean getConvaluni( )
   {
      return gxTv_SdtAgendaNovedades_Convaluni ;
   }

   public void setConvaluni( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Convaluni = value ;
   }

   public boolean getConimporte( )
   {
      return gxTv_SdtAgendaNovedades_Conimporte ;
   }

   public void setConimporte( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Conimporte = value ;
   }

   public int getAgeliqnro( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro ;
   }

   public void setAgeliqnro( int value )
   {
      gxTv_SdtAgendaNovedades_Ageliqnro_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageliqnro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtAgendaNovedades_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtAgendaNovedades_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtAgendaNovedades_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtAgendaNovedades_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtAgendaNovedades_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Empnom_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legnumero_Z = value ;
   }

   public String getLegapellido_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legapellido_Z ;
   }

   public void setLegapellido_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legapellido_Z = value ;
   }

   public String getLegnombre_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legnombre_Z ;
   }

   public void setLegnombre_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legnombre_Z = value ;
   }

   public java.util.Date getLegfecegreso_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso_Z ;
   }

   public void setLegfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legfecegreso_Z = value ;
   }

   public short getAgeorden_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageorden_Z ;
   }

   public void setAgeorden_Z( short value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageorden_Z = value ;
   }

   public String getConcodigo_Z( )
   {
      return gxTv_SdtAgendaNovedades_Concodigo_Z ;
   }

   public void setConcodigo_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Concodigo_Z = value ;
   }

   public String getCondescrip_Z( )
   {
      return gxTv_SdtAgendaNovedades_Condescrip_Z ;
   }

   public void setCondescrip_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Condescrip_Z = value ;
   }

   public java.math.BigDecimal getAgecanti_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti_Z ;
   }

   public void setAgecanti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agecanti_Z = value ;
   }

   public java.math.BigDecimal getAgevunit_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit_Z ;
   }

   public void setAgevunit_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agevunit_Z = value ;
   }

   public java.math.BigDecimal getAgeimporte_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte_Z ;
   }

   public void setAgeimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageimporte_Z = value ;
   }

   public java.util.Date getAgefecdes_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes_Z ;
   }

   public void setAgefecdes_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefecdes_Z = value ;
   }

   public java.util.Date getAgefechas_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas_Z ;
   }

   public void setAgefechas_Z( java.util.Date value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefechas_Z = value ;
   }

   public boolean getAgelegactivo_Z( )
   {
      return gxTv_SdtAgendaNovedades_Agelegactivo_Z ;
   }

   public void setAgelegactivo_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agelegactivo_Z = value ;
   }

   public String getLegid_Z( )
   {
      return gxTv_SdtAgendaNovedades_Legid_Z ;
   }

   public void setLegid_Z( String value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legid_Z = value ;
   }

   public boolean getConcanti_Z( )
   {
      return gxTv_SdtAgendaNovedades_Concanti_Z ;
   }

   public void setConcanti_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Concanti_Z = value ;
   }

   public boolean getConvaluni_Z( )
   {
      return gxTv_SdtAgendaNovedades_Convaluni_Z ;
   }

   public void setConvaluni_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Convaluni_Z = value ;
   }

   public boolean getConimporte_Z( )
   {
      return gxTv_SdtAgendaNovedades_Conimporte_Z ;
   }

   public void setConimporte_Z( boolean value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Conimporte_Z = value ;
   }

   public int getAgeliqnro_Z( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro_Z ;
   }

   public void setAgeliqnro_Z( int value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageliqnro_Z = value ;
   }

   public byte getLegfecegreso_N( )
   {
      return gxTv_SdtAgendaNovedades_Legfecegreso_N ;
   }

   public void setLegfecegreso_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legfecegreso_N = value ;
   }

   public byte getAgecanti_N( )
   {
      return gxTv_SdtAgendaNovedades_Agecanti_N ;
   }

   public void setAgecanti_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agecanti_N = value ;
   }

   public byte getAgevunit_N( )
   {
      return gxTv_SdtAgendaNovedades_Agevunit_N ;
   }

   public void setAgevunit_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agevunit_N = value ;
   }

   public byte getAgeimporte_N( )
   {
      return gxTv_SdtAgendaNovedades_Ageimporte_N ;
   }

   public void setAgeimporte_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageimporte_N = value ;
   }

   public byte getAgefecdes_N( )
   {
      return gxTv_SdtAgendaNovedades_Agefecdes_N ;
   }

   public void setAgefecdes_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefecdes_N = value ;
   }

   public byte getAgefechas_N( )
   {
      return gxTv_SdtAgendaNovedades_Agefechas_N ;
   }

   public void setAgefechas_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Agefechas_N = value ;
   }

   public byte getLegid_N( )
   {
      return gxTv_SdtAgendaNovedades_Legid_N ;
   }

   public void setLegid_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Legid_N = value ;
   }

   public byte getAgeliqnro_N( )
   {
      return gxTv_SdtAgendaNovedades_Ageliqnro_N ;
   }

   public void setAgeliqnro_N( byte value )
   {
      gxTv_SdtAgendaNovedades_N = (byte)(0) ;
      gxTv_SdtAgendaNovedades_Ageliqnro_N = value ;
   }

   protected byte gxTv_SdtAgendaNovedades_Legfecegreso_N ;
   protected byte gxTv_SdtAgendaNovedades_Agecanti_N ;
   protected byte gxTv_SdtAgendaNovedades_Agevunit_N ;
   protected byte gxTv_SdtAgendaNovedades_Ageimporte_N ;
   protected byte gxTv_SdtAgendaNovedades_Agefecdes_N ;
   protected byte gxTv_SdtAgendaNovedades_Agefechas_N ;
   protected byte gxTv_SdtAgendaNovedades_Legid_N ;
   protected byte gxTv_SdtAgendaNovedades_Ageliqnro_N ;
   private byte gxTv_SdtAgendaNovedades_N ;
   protected short gxTv_SdtAgendaNovedades_Empcod ;
   protected short gxTv_SdtAgendaNovedades_Ageorden ;
   protected short gxTv_SdtAgendaNovedades_Initialized ;
   protected short gxTv_SdtAgendaNovedades_Empcod_Z ;
   protected short gxTv_SdtAgendaNovedades_Ageorden_Z ;
   protected int gxTv_SdtAgendaNovedades_Clicod ;
   protected int gxTv_SdtAgendaNovedades_Legnumero ;
   protected int gxTv_SdtAgendaNovedades_Ageliqnro ;
   protected int gxTv_SdtAgendaNovedades_Clicod_Z ;
   protected int gxTv_SdtAgendaNovedades_Legnumero_Z ;
   protected int gxTv_SdtAgendaNovedades_Ageliqnro_Z ;
   protected String gxTv_SdtAgendaNovedades_Concodigo ;
   protected String gxTv_SdtAgendaNovedades_Legid ;
   protected String gxTv_SdtAgendaNovedades_Mode ;
   protected String gxTv_SdtAgendaNovedades_Concodigo_Z ;
   protected String gxTv_SdtAgendaNovedades_Legid_Z ;
   protected boolean gxTv_SdtAgendaNovedades_Agelegactivo ;
   protected boolean gxTv_SdtAgendaNovedades_Concanti ;
   protected boolean gxTv_SdtAgendaNovedades_Convaluni ;
   protected boolean gxTv_SdtAgendaNovedades_Conimporte ;
   protected boolean gxTv_SdtAgendaNovedades_Agelegactivo_Z ;
   protected boolean gxTv_SdtAgendaNovedades_Concanti_Z ;
   protected boolean gxTv_SdtAgendaNovedades_Convaluni_Z ;
   protected boolean gxTv_SdtAgendaNovedades_Conimporte_Z ;
   protected String gxTv_SdtAgendaNovedades_Empnom ;
   protected String gxTv_SdtAgendaNovedades_Legapellido ;
   protected String gxTv_SdtAgendaNovedades_Legnombre ;
   protected String gxTv_SdtAgendaNovedades_Condescrip ;
   protected String gxTv_SdtAgendaNovedades_Empnom_Z ;
   protected String gxTv_SdtAgendaNovedades_Legapellido_Z ;
   protected String gxTv_SdtAgendaNovedades_Legnombre_Z ;
   protected String gxTv_SdtAgendaNovedades_Condescrip_Z ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Legfecegreso ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Agecanti ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Agevunit ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Ageimporte ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Agefecdes ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Agefechas ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Legfecegreso_Z ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Agecanti_Z ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Agevunit_Z ;
   protected java.math.BigDecimal gxTv_SdtAgendaNovedades_Ageimporte_Z ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Agefecdes_Z ;
   protected java.util.Date gxTv_SdtAgendaNovedades_Agefechas_Z ;
}

