package web ;
import com.genexus.*;

public final  class StructSdtObligacion implements Cloneable, java.io.Serializable
{
   public StructSdtObligacion( )
   {
      this( -1, new ModelContext( StructSdtObligacion.class ));
   }

   public StructSdtObligacion( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtObligacion_Legidnomape = "" ;
      gxTv_SdtObligacion_Tipoobldescrip = "" ;
      gxTv_SdtObligacion_Tipooblcodigo = "" ;
      gxTv_SdtObligacion_Oblobs = "" ;
      gxTv_SdtObligacion_Oblconcodigo = "" ;
      gxTv_SdtObligacion_Obltotal = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblimpfij = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblporc = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblconcepto = "" ;
      gxTv_SdtObligacion_Obltipomov = "" ;
      gxTv_SdtObligacion_Mode = "" ;
      gxTv_SdtObligacion_Legidnomape_Z = "" ;
      gxTv_SdtObligacion_Tipoobldescrip_Z = "" ;
      gxTv_SdtObligacion_Tipooblcodigo_Z = "" ;
      gxTv_SdtObligacion_Oblconcodigo_Z = "" ;
      gxTv_SdtObligacion_Obltotal_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblimpfij_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblporc_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtObligacion_Oblconcepto_Z = "" ;
      gxTv_SdtObligacion_Obltipomov_Z = "" ;
      gxTv_SdtObligacion_Embargasec_N = (byte)(1) ;
      gxTv_SdtObligacion_Oblconcodigo_N = (byte)(1) ;
      gxTv_SdtObligacion_Oblliqnro_N = (byte)(1) ;
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
      return gxTv_SdtObligacion_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtObligacion_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtObligacion_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Legnumero = value ;
   }

   public short getOblsecuencial( )
   {
      return gxTv_SdtObligacion_Oblsecuencial ;
   }

   public void setOblsecuencial( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblsecuencial = value ;
   }

   public String getLegidnomape( )
   {
      return gxTv_SdtObligacion_Legidnomape ;
   }

   public void setLegidnomape( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Legidnomape = value ;
   }

   public short getTipooblsec( )
   {
      return gxTv_SdtObligacion_Tipooblsec ;
   }

   public void setTipooblsec( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblsec = value ;
   }

   public String getTipoobldescrip( )
   {
      return gxTv_SdtObligacion_Tipoobldescrip ;
   }

   public void setTipoobldescrip( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipoobldescrip = value ;
   }

   public String getTipooblcodigo( )
   {
      return gxTv_SdtObligacion_Tipooblcodigo ;
   }

   public void setTipooblcodigo( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblcodigo = value ;
   }

   public byte getOblestado( )
   {
      return gxTv_SdtObligacion_Oblestado ;
   }

   public void setOblestado( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblestado = value ;
   }

   public String getOblobs( )
   {
      return gxTv_SdtObligacion_Oblobs ;
   }

   public void setOblobs( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblobs = value ;
   }

   public byte getObloriper( )
   {
      return gxTv_SdtObligacion_Obloriper ;
   }

   public void setObloriper( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obloriper = value ;
   }

   public byte getTipoobltottipo( )
   {
      return gxTv_SdtObligacion_Tipoobltottipo ;
   }

   public void setTipoobltottipo( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipoobltottipo = value ;
   }

   public short getEmbargasec( )
   {
      return gxTv_SdtObligacion_Embargasec ;
   }

   public void setEmbargasec( short value )
   {
      gxTv_SdtObligacion_Embargasec_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Embargasec = value ;
   }

   public String getOblconcodigo( )
   {
      return gxTv_SdtObligacion_Oblconcodigo ;
   }

   public void setOblconcodigo( String value )
   {
      gxTv_SdtObligacion_Oblconcodigo_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblconcodigo = value ;
   }

   public java.math.BigDecimal getObltotal( )
   {
      return gxTv_SdtObligacion_Obltotal ;
   }

   public void setObltotal( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obltotal = value ;
   }

   public short getOblcancuo( )
   {
      return gxTv_SdtObligacion_Oblcancuo ;
   }

   public void setOblcancuo( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblcancuo = value ;
   }

   public java.math.BigDecimal getOblimpfij( )
   {
      return gxTv_SdtObligacion_Oblimpfij ;
   }

   public void setOblimpfij( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblimpfij = value ;
   }

   public java.math.BigDecimal getOblporc( )
   {
      return gxTv_SdtObligacion_Oblporc ;
   }

   public void setOblporc( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblporc = value ;
   }

   public boolean getOblnoremu( )
   {
      return gxTv_SdtObligacion_Oblnoremu ;
   }

   public void setOblnoremu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblnoremu = value ;
   }

   public boolean getObldescu( )
   {
      return gxTv_SdtObligacion_Obldescu ;
   }

   public void setObldescu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obldescu = value ;
   }

   public int getOblliqnro( )
   {
      return gxTv_SdtObligacion_Oblliqnro ;
   }

   public void setOblliqnro( int value )
   {
      gxTv_SdtObligacion_Oblliqnro_N = (byte)(0) ;
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblliqnro = value ;
   }

   public boolean getOblantirelaliq( )
   {
      return gxTv_SdtObligacion_Oblantirelaliq ;
   }

   public void setOblantirelaliq( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblantirelaliq = value ;
   }

   public String getOblconcepto( )
   {
      return gxTv_SdtObligacion_Oblconcepto ;
   }

   public void setOblconcepto( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblconcepto = value ;
   }

   public String getObltipomov( )
   {
      return gxTv_SdtObligacion_Obltipomov ;
   }

   public void setObltipomov( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obltipomov = value ;
   }

   public boolean getTipooblsolodescu( )
   {
      return gxTv_SdtObligacion_Tipooblsolodescu ;
   }

   public void setTipooblsolodescu( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblsolodescu = value ;
   }

   public java.util.Vector<web.StructSdtObligacion_Excepciones> getExcepciones( )
   {
      return gxTv_SdtObligacion_Excepciones ;
   }

   public void setExcepciones( java.util.Vector<web.StructSdtObligacion_Excepciones> value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtObligacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtObligacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtObligacion_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtObligacion_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtObligacion_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Legnumero_Z = value ;
   }

   public short getOblsecuencial_Z( )
   {
      return gxTv_SdtObligacion_Oblsecuencial_Z ;
   }

   public void setOblsecuencial_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblsecuencial_Z = value ;
   }

   public String getLegidnomape_Z( )
   {
      return gxTv_SdtObligacion_Legidnomape_Z ;
   }

   public void setLegidnomape_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Legidnomape_Z = value ;
   }

   public short getTipooblsec_Z( )
   {
      return gxTv_SdtObligacion_Tipooblsec_Z ;
   }

   public void setTipooblsec_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblsec_Z = value ;
   }

   public String getTipoobldescrip_Z( )
   {
      return gxTv_SdtObligacion_Tipoobldescrip_Z ;
   }

   public void setTipoobldescrip_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipoobldescrip_Z = value ;
   }

   public String getTipooblcodigo_Z( )
   {
      return gxTv_SdtObligacion_Tipooblcodigo_Z ;
   }

   public void setTipooblcodigo_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblcodigo_Z = value ;
   }

   public byte getOblestado_Z( )
   {
      return gxTv_SdtObligacion_Oblestado_Z ;
   }

   public void setOblestado_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblestado_Z = value ;
   }

   public byte getObloriper_Z( )
   {
      return gxTv_SdtObligacion_Obloriper_Z ;
   }

   public void setObloriper_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obloriper_Z = value ;
   }

   public byte getTipoobltottipo_Z( )
   {
      return gxTv_SdtObligacion_Tipoobltottipo_Z ;
   }

   public void setTipoobltottipo_Z( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipoobltottipo_Z = value ;
   }

   public short getEmbargasec_Z( )
   {
      return gxTv_SdtObligacion_Embargasec_Z ;
   }

   public void setEmbargasec_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Embargasec_Z = value ;
   }

   public String getOblconcodigo_Z( )
   {
      return gxTv_SdtObligacion_Oblconcodigo_Z ;
   }

   public void setOblconcodigo_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblconcodigo_Z = value ;
   }

   public java.math.BigDecimal getObltotal_Z( )
   {
      return gxTv_SdtObligacion_Obltotal_Z ;
   }

   public void setObltotal_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obltotal_Z = value ;
   }

   public short getOblcancuo_Z( )
   {
      return gxTv_SdtObligacion_Oblcancuo_Z ;
   }

   public void setOblcancuo_Z( short value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblcancuo_Z = value ;
   }

   public java.math.BigDecimal getOblimpfij_Z( )
   {
      return gxTv_SdtObligacion_Oblimpfij_Z ;
   }

   public void setOblimpfij_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblimpfij_Z = value ;
   }

   public java.math.BigDecimal getOblporc_Z( )
   {
      return gxTv_SdtObligacion_Oblporc_Z ;
   }

   public void setOblporc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblporc_Z = value ;
   }

   public boolean getOblnoremu_Z( )
   {
      return gxTv_SdtObligacion_Oblnoremu_Z ;
   }

   public void setOblnoremu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblnoremu_Z = value ;
   }

   public boolean getObldescu_Z( )
   {
      return gxTv_SdtObligacion_Obldescu_Z ;
   }

   public void setObldescu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obldescu_Z = value ;
   }

   public int getOblliqnro_Z( )
   {
      return gxTv_SdtObligacion_Oblliqnro_Z ;
   }

   public void setOblliqnro_Z( int value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblliqnro_Z = value ;
   }

   public boolean getOblantirelaliq_Z( )
   {
      return gxTv_SdtObligacion_Oblantirelaliq_Z ;
   }

   public void setOblantirelaliq_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblantirelaliq_Z = value ;
   }

   public String getOblconcepto_Z( )
   {
      return gxTv_SdtObligacion_Oblconcepto_Z ;
   }

   public void setOblconcepto_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblconcepto_Z = value ;
   }

   public String getObltipomov_Z( )
   {
      return gxTv_SdtObligacion_Obltipomov_Z ;
   }

   public void setObltipomov_Z( String value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Obltipomov_Z = value ;
   }

   public boolean getTipooblsolodescu_Z( )
   {
      return gxTv_SdtObligacion_Tipooblsolodescu_Z ;
   }

   public void setTipooblsolodescu_Z( boolean value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Tipooblsolodescu_Z = value ;
   }

   public byte getEmbargasec_N( )
   {
      return gxTv_SdtObligacion_Embargasec_N ;
   }

   public void setEmbargasec_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Embargasec_N = value ;
   }

   public byte getOblconcodigo_N( )
   {
      return gxTv_SdtObligacion_Oblconcodigo_N ;
   }

   public void setOblconcodigo_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblconcodigo_N = value ;
   }

   public byte getOblliqnro_N( )
   {
      return gxTv_SdtObligacion_Oblliqnro_N ;
   }

   public void setOblliqnro_N( byte value )
   {
      gxTv_SdtObligacion_N = (byte)(0) ;
      gxTv_SdtObligacion_Oblliqnro_N = value ;
   }

   protected byte gxTv_SdtObligacion_Oblestado ;
   protected byte gxTv_SdtObligacion_Obloriper ;
   protected byte gxTv_SdtObligacion_Tipoobltottipo ;
   protected byte gxTv_SdtObligacion_Oblestado_Z ;
   protected byte gxTv_SdtObligacion_Obloriper_Z ;
   protected byte gxTv_SdtObligacion_Tipoobltottipo_Z ;
   protected byte gxTv_SdtObligacion_Embargasec_N ;
   protected byte gxTv_SdtObligacion_Oblconcodigo_N ;
   protected byte gxTv_SdtObligacion_Oblliqnro_N ;
   private byte gxTv_SdtObligacion_N ;
   protected short gxTv_SdtObligacion_Empcod ;
   protected short gxTv_SdtObligacion_Oblsecuencial ;
   protected short gxTv_SdtObligacion_Tipooblsec ;
   protected short gxTv_SdtObligacion_Embargasec ;
   protected short gxTv_SdtObligacion_Oblcancuo ;
   protected short gxTv_SdtObligacion_Initialized ;
   protected short gxTv_SdtObligacion_Empcod_Z ;
   protected short gxTv_SdtObligacion_Oblsecuencial_Z ;
   protected short gxTv_SdtObligacion_Tipooblsec_Z ;
   protected short gxTv_SdtObligacion_Embargasec_Z ;
   protected short gxTv_SdtObligacion_Oblcancuo_Z ;
   protected int gxTv_SdtObligacion_Clicod ;
   protected int gxTv_SdtObligacion_Legnumero ;
   protected int gxTv_SdtObligacion_Oblliqnro ;
   protected int gxTv_SdtObligacion_Clicod_Z ;
   protected int gxTv_SdtObligacion_Legnumero_Z ;
   protected int gxTv_SdtObligacion_Oblliqnro_Z ;
   protected String gxTv_SdtObligacion_Tipooblcodigo ;
   protected String gxTv_SdtObligacion_Oblconcodigo ;
   protected String gxTv_SdtObligacion_Oblconcepto ;
   protected String gxTv_SdtObligacion_Obltipomov ;
   protected String gxTv_SdtObligacion_Mode ;
   protected String gxTv_SdtObligacion_Tipooblcodigo_Z ;
   protected String gxTv_SdtObligacion_Oblconcodigo_Z ;
   protected String gxTv_SdtObligacion_Oblconcepto_Z ;
   protected String gxTv_SdtObligacion_Obltipomov_Z ;
   protected boolean gxTv_SdtObligacion_Oblnoremu ;
   protected boolean gxTv_SdtObligacion_Obldescu ;
   protected boolean gxTv_SdtObligacion_Oblantirelaliq ;
   protected boolean gxTv_SdtObligacion_Tipooblsolodescu ;
   protected boolean gxTv_SdtObligacion_Oblnoremu_Z ;
   protected boolean gxTv_SdtObligacion_Obldescu_Z ;
   protected boolean gxTv_SdtObligacion_Oblantirelaliq_Z ;
   protected boolean gxTv_SdtObligacion_Tipooblsolodescu_Z ;
   protected String gxTv_SdtObligacion_Oblobs ;
   protected String gxTv_SdtObligacion_Legidnomape ;
   protected String gxTv_SdtObligacion_Tipoobldescrip ;
   protected String gxTv_SdtObligacion_Legidnomape_Z ;
   protected String gxTv_SdtObligacion_Tipoobldescrip_Z ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Obltotal ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Oblimpfij ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Oblporc ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Obltotal_Z ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Oblimpfij_Z ;
   protected java.math.BigDecimal gxTv_SdtObligacion_Oblporc_Z ;
   protected java.util.Vector<web.StructSdtObligacion_Excepciones> gxTv_SdtObligacion_Excepciones=null ;
}

