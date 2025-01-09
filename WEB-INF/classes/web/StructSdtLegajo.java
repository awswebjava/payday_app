package web ;
import com.genexus.*;

public final  class StructSdtLegajo implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo( )
   {
      this( -1, new ModelContext( StructSdtLegajo.class ));
   }

   public StructSdtLegajo( int remoteHandle ,
                           ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajo_Empnom = "" ;
      gxTv_SdtLegajo_Legapellido = "" ;
      gxTv_SdtLegajo_Legnombre = "" ;
      gxTv_SdtLegajo_Legfoto = "" ;
      gxTv_SdtLegajo_Legfotonom = "" ;
      gxTv_SdtLegajo_Legfotoext = "" ;
      gxTv_SdtLegajo_Legnumdoc = "" ;
      gxTv_SdtLegajo_Legfecnac = cal.getTime() ;
      gxTv_SdtLegajo_Legnacionalidad = "" ;
      gxTv_SdtLegajo_Legdomici = "" ;
      gxTv_SdtLegajo_Legemail = "" ;
      gxTv_SdtLegajo_Legcodpos = "" ;
      gxTv_SdtLegajo_Legpainom = "" ;
      gxTv_SdtLegajo_Legprovnom = "" ;
      gxTv_SdtLegajo_Leglocnom = "" ;
      gxTv_SdtLegajo_Legtelefono = "" ;
      gxTv_SdtLegajo_Legfecingreso = cal.getTime() ;
      gxTv_SdtLegajo_Legfecegreso = cal.getTime() ;
      gxTv_SdtLegajo_Legmegcodigo = "" ;
      gxTv_SdtLegajo_Megdescrip = "" ;
      gxTv_SdtLegajo_Legcatcodigo = "" ;
      gxTv_SdtLegajo_Legseccodigo = "" ;
      gxTv_SdtLegajo_Secdescrip = "" ;
      gxTv_SdtLegajo_Leglpgcodigo = "" ;
      gxTv_SdtLegajo_Lpgdescri = "" ;
      gxTv_SdtLegajo_Legbasico = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legbancod = "" ;
      gxTv_SdtLegajo_Legbandes = "" ;
      gxTv_SdtLegajo_Legbansuc = "" ;
      gxTv_SdtLegajo_Legbantipcuen = "" ;
      gxTv_SdtLegajo_Legsincod = "" ;
      gxTv_SdtLegajo_Sindescrip = "" ;
      gxTv_SdtLegajo_Legosocod = "" ;
      gxTv_SdtLegajo_Legosodes = "" ;
      gxTv_SdtLegajo_Legosoafipcod = "" ;
      gxTv_SdtLegajo_Osodescrip = "" ;
      gxTv_SdtLegajo_Legactcodigo = "" ;
      gxTv_SdtLegajo_Legactdescri = "" ;
      gxTv_SdtLegajo_Mprcod = "" ;
      gxTv_SdtLegajo_Mprdescrip = "" ;
      gxTv_SdtLegajo_Legfecultmod = cal.getTime() ;
      gxTv_SdtLegajo_Legcuentabanc = "" ;
      gxTv_SdtLegajo_Leglicinicio = cal.getTime() ;
      gxTv_SdtLegajo_Leglicfinal = cal.getTime() ;
      gxTv_SdtLegajo_Zoncod = "" ;
      gxTv_SdtLegajo_Zondescrip = "" ;
      gxTv_SdtLegajo_Zonporcreduc = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legcbu = "" ;
      gxTv_SdtLegajo_Condidescri = "" ;
      gxTv_SdtLegajo_Siniecodigo = "" ;
      gxTv_SdtLegajo_Siniedescri = "" ;
      gxTv_SdtLegajo_Legsueldofuera = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legid = "" ;
      gxTv_SdtLegajo_Legconvecodigo = "" ;
      gxTv_SdtLegajo_Legidnomape = "" ;
      gxTv_SdtLegajo_Tipemplecod = "" ;
      gxTv_SdtLegajo_Osoc3992 = "" ;
      gxTv_SdtLegajo_Legobs = "" ;
      gxTv_SdtLegajo_Legnomape = "" ;
      gxTv_SdtLegajo_Legfecimportacion = cal.getTime() ;
      gxTv_SdtLegajo_Legcontinua = "" ;
      gxTv_SdtLegajo_Leghorasdia = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Leghorassem = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legreligion = "" ;
      gxTv_SdtLegajo_Legorigen = "" ;
      gxTv_SdtLegajo_Legpuescodigo = "" ;
      gxTv_SdtLegajo_Legsuccodigo = "" ;
      gxTv_SdtLegajo_Legfecpreaviso = cal.getTime() ;
      gxTv_SdtLegajo_Legpromdias = "" ;
      gxTv_SdtLegajo_Legtitulo = "" ;
      gxTv_SdtLegajo_Legpueaficod = "" ;
      gxTv_SdtLegajo_Legmigrwarn = "" ;
      gxTv_SdtLegajo_Legmodtra = "" ;
      gxTv_SdtLegajo_Legtipotarifa = "" ;
      gxTv_SdtLegajo_Mode = "" ;
      gxTv_SdtLegajo_Empnom_Z = "" ;
      gxTv_SdtLegajo_Legapellido_Z = "" ;
      gxTv_SdtLegajo_Legnombre_Z = "" ;
      gxTv_SdtLegajo_Legfotonom_Z = "" ;
      gxTv_SdtLegajo_Legfotoext_Z = "" ;
      gxTv_SdtLegajo_Legnumdoc_Z = "" ;
      gxTv_SdtLegajo_Legfecnac_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legnacionalidad_Z = "" ;
      gxTv_SdtLegajo_Legdomici_Z = "" ;
      gxTv_SdtLegajo_Legemail_Z = "" ;
      gxTv_SdtLegajo_Legcodpos_Z = "" ;
      gxTv_SdtLegajo_Legpainom_Z = "" ;
      gxTv_SdtLegajo_Legprovnom_Z = "" ;
      gxTv_SdtLegajo_Leglocnom_Z = "" ;
      gxTv_SdtLegajo_Legtelefono_Z = "" ;
      gxTv_SdtLegajo_Legfecingreso_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legfecegreso_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legmegcodigo_Z = "" ;
      gxTv_SdtLegajo_Megdescrip_Z = "" ;
      gxTv_SdtLegajo_Legcatcodigo_Z = "" ;
      gxTv_SdtLegajo_Legseccodigo_Z = "" ;
      gxTv_SdtLegajo_Secdescrip_Z = "" ;
      gxTv_SdtLegajo_Leglpgcodigo_Z = "" ;
      gxTv_SdtLegajo_Lpgdescri_Z = "" ;
      gxTv_SdtLegajo_Legbasico_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legbancod_Z = "" ;
      gxTv_SdtLegajo_Legbandes_Z = "" ;
      gxTv_SdtLegajo_Legbansuc_Z = "" ;
      gxTv_SdtLegajo_Legbantipcuen_Z = "" ;
      gxTv_SdtLegajo_Legsincod_Z = "" ;
      gxTv_SdtLegajo_Sindescrip_Z = "" ;
      gxTv_SdtLegajo_Legosocod_Z = "" ;
      gxTv_SdtLegajo_Legosodes_Z = "" ;
      gxTv_SdtLegajo_Legosoafipcod_Z = "" ;
      gxTv_SdtLegajo_Osodescrip_Z = "" ;
      gxTv_SdtLegajo_Legactcodigo_Z = "" ;
      gxTv_SdtLegajo_Legactdescri_Z = "" ;
      gxTv_SdtLegajo_Mprcod_Z = "" ;
      gxTv_SdtLegajo_Mprdescrip_Z = "" ;
      gxTv_SdtLegajo_Legfecultmod_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legcuentabanc_Z = "" ;
      gxTv_SdtLegajo_Leglicinicio_Z = cal.getTime() ;
      gxTv_SdtLegajo_Leglicfinal_Z = cal.getTime() ;
      gxTv_SdtLegajo_Zoncod_Z = "" ;
      gxTv_SdtLegajo_Zondescrip_Z = "" ;
      gxTv_SdtLegajo_Zonporcreduc_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legcbu_Z = "" ;
      gxTv_SdtLegajo_Condidescri_Z = "" ;
      gxTv_SdtLegajo_Siniecodigo_Z = "" ;
      gxTv_SdtLegajo_Siniedescri_Z = "" ;
      gxTv_SdtLegajo_Legsueldofuera_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legid_Z = "" ;
      gxTv_SdtLegajo_Legconvecodigo_Z = "" ;
      gxTv_SdtLegajo_Legidnomape_Z = "" ;
      gxTv_SdtLegajo_Tipemplecod_Z = "" ;
      gxTv_SdtLegajo_Osoc3992_Z = "" ;
      gxTv_SdtLegajo_Legnomape_Z = "" ;
      gxTv_SdtLegajo_Legfecimportacion_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legcontinua_Z = "" ;
      gxTv_SdtLegajo_Leghorasdia_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Leghorassem_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Legreligion_Z = "" ;
      gxTv_SdtLegajo_Legorigen_Z = "" ;
      gxTv_SdtLegajo_Legpuescodigo_Z = "" ;
      gxTv_SdtLegajo_Legsuccodigo_Z = "" ;
      gxTv_SdtLegajo_Legfecpreaviso_Z = cal.getTime() ;
      gxTv_SdtLegajo_Legpromdias_Z = "" ;
      gxTv_SdtLegajo_Legtitulo_Z = "" ;
      gxTv_SdtLegajo_Legpueaficod_Z = "" ;
      gxTv_SdtLegajo_Legmodtra_Z = "" ;
      gxTv_SdtLegajo_Legtipotarifa_Z = "" ;
      gxTv_SdtLegajo_Legfoto_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsexo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legestadocivil_N = (byte)(1) ;
      gxTv_SdtLegajo_Legnacioncod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpaicod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legprovcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legloccod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legtelefono_N = (byte)(1) ;
      gxTv_SdtLegajo_Legfecegreso_N = (byte)(1) ;
      gxTv_SdtLegajo_Legmegcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Megdescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcatcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcatpuecod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legseccodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Secdescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Lpgdescri_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbancod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbansuc_N = (byte)(1) ;
      gxTv_SdtLegajo_Legbantipcuen_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsincod_N = (byte)(1) ;
      gxTv_SdtLegajo_Sindescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Legosocod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legosoafipcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Osodescrip_N = (byte)(1) ;
      gxTv_SdtLegajo_Legactcodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Mprcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcuentabanc_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglicinicio_N = (byte)(1) ;
      gxTv_SdtLegajo_Leglicfinal_N = (byte)(1) ;
      gxTv_SdtLegajo_Zoncod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legcbu_N = (byte)(1) ;
      gxTv_SdtLegajo_Condicodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Siniecodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legid_N = (byte)(1) ;
      gxTv_SdtLegajo_Legconvecodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtLegajo_Osoc3992_N = (byte)(1) ;
      gxTv_SdtLegajo_Legreligion_N = (byte)(1) ;
      gxTv_SdtLegajo_Legorigen_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpuescodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsuccodigo_N = (byte)(1) ;
      gxTv_SdtLegajo_Legconveversioncli_N = (byte)(1) ;
      gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(1) ;
      gxTv_SdtLegajo_Legactclasnro_N = (byte)(1) ;
      gxTv_SdtLegajo_Legpueaficod_N = (byte)(1) ;
      gxTv_SdtLegajo_Legmigrwarn_N = (byte)(1) ;
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
      return gxTv_SdtLegajo_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLegajo_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtLegajo_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Empnom = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtLegajo_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnumero = value ;
   }

   public String getLegapellido( )
   {
      return gxTv_SdtLegajo_Legapellido ;
   }

   public void setLegapellido( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legapellido = value ;
   }

   public String getLegnombre( )
   {
      return gxTv_SdtLegajo_Legnombre ;
   }

   public void setLegnombre( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnombre = value ;
   }

   public String getLegfoto( )
   {
      return gxTv_SdtLegajo_Legfoto ;
   }

   public void setLegfoto( String value )
   {
      gxTv_SdtLegajo_Legfoto_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfoto = value ;
   }

   public java.util.Vector<web.StructSdtLegajo_Salario> getSalario( )
   {
      return gxTv_SdtLegajo_Salario ;
   }

   public void setSalario( java.util.Vector<web.StructSdtLegajo_Salario> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario = value ;
   }

   public java.util.Vector<web.StructSdtLegajo_Familia> getFamilia( )
   {
      return gxTv_SdtLegajo_Familia ;
   }

   public void setFamilia( java.util.Vector<web.StructSdtLegajo_Familia> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia = value ;
   }

   public String getLegfotonom( )
   {
      return gxTv_SdtLegajo_Legfotonom ;
   }

   public void setLegfotonom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfotonom = value ;
   }

   public String getLegfotoext( )
   {
      return gxTv_SdtLegajo_Legfotoext ;
   }

   public void setLegfotoext( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfotoext = value ;
   }

   public byte getLegtipdoc( )
   {
      return gxTv_SdtLegajo_Legtipdoc ;
   }

   public void setLegtipdoc( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtipdoc = value ;
   }

   public String getLegnumdoc( )
   {
      return gxTv_SdtLegajo_Legnumdoc ;
   }

   public void setLegnumdoc( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnumdoc = value ;
   }

   public java.util.Date getLegfecnac( )
   {
      return gxTv_SdtLegajo_Legfecnac ;
   }

   public void setLegfecnac( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecnac = value ;
   }

   public byte getLegsexo( )
   {
      return gxTv_SdtLegajo_Legsexo ;
   }

   public void setLegsexo( byte value )
   {
      gxTv_SdtLegajo_Legsexo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsexo = value ;
   }

   public short getLegestadocivil( )
   {
      return gxTv_SdtLegajo_Legestadocivil ;
   }

   public void setLegestadocivil( short value )
   {
      gxTv_SdtLegajo_Legestadocivil_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legestadocivil = value ;
   }

   public short getLegnacioncod( )
   {
      return gxTv_SdtLegajo_Legnacioncod ;
   }

   public void setLegnacioncod( short value )
   {
      gxTv_SdtLegajo_Legnacioncod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnacioncod = value ;
   }

   public String getLegnacionalidad( )
   {
      return gxTv_SdtLegajo_Legnacionalidad ;
   }

   public void setLegnacionalidad( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnacionalidad = value ;
   }

   public long getLegcuil( )
   {
      return gxTv_SdtLegajo_Legcuil ;
   }

   public void setLegcuil( long value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcuil = value ;
   }

   public byte getLegdiscapacidad( )
   {
      return gxTv_SdtLegajo_Legdiscapacidad ;
   }

   public void setLegdiscapacidad( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legdiscapacidad = value ;
   }

   public String getLegdomici( )
   {
      return gxTv_SdtLegajo_Legdomici ;
   }

   public void setLegdomici( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legdomici = value ;
   }

   public String getLegemail( )
   {
      return gxTv_SdtLegajo_Legemail ;
   }

   public void setLegemail( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legemail = value ;
   }

   public String getLegcodpos( )
   {
      return gxTv_SdtLegajo_Legcodpos ;
   }

   public void setLegcodpos( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcodpos = value ;
   }

   public short getLegpaicod( )
   {
      return gxTv_SdtLegajo_Legpaicod ;
   }

   public void setLegpaicod( short value )
   {
      gxTv_SdtLegajo_Legpaicod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpaicod = value ;
   }

   public String getLegpainom( )
   {
      return gxTv_SdtLegajo_Legpainom ;
   }

   public void setLegpainom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpainom = value ;
   }

   public short getLegprovcod( )
   {
      return gxTv_SdtLegajo_Legprovcod ;
   }

   public void setLegprovcod( short value )
   {
      gxTv_SdtLegajo_Legprovcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legprovcod = value ;
   }

   public String getLegprovnom( )
   {
      return gxTv_SdtLegajo_Legprovnom ;
   }

   public void setLegprovnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legprovnom = value ;
   }

   public short getLegloccod( )
   {
      return gxTv_SdtLegajo_Legloccod ;
   }

   public void setLegloccod( short value )
   {
      gxTv_SdtLegajo_Legloccod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legloccod = value ;
   }

   public String getLeglocnom( )
   {
      return gxTv_SdtLegajo_Leglocnom ;
   }

   public void setLeglocnom( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglocnom = value ;
   }

   public String getLegtelefono( )
   {
      return gxTv_SdtLegajo_Legtelefono ;
   }

   public void setLegtelefono( String value )
   {
      gxTv_SdtLegajo_Legtelefono_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtelefono = value ;
   }

   public java.util.Date getLegfecingreso( )
   {
      return gxTv_SdtLegajo_Legfecingreso ;
   }

   public void setLegfecingreso( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecingreso = value ;
   }

   public java.util.Date getLegfecegreso( )
   {
      return gxTv_SdtLegajo_Legfecegreso ;
   }

   public void setLegfecegreso( java.util.Date value )
   {
      gxTv_SdtLegajo_Legfecegreso_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecegreso = value ;
   }

   public String getLegmegcodigo( )
   {
      return gxTv_SdtLegajo_Legmegcodigo ;
   }

   public void setLegmegcodigo( String value )
   {
      gxTv_SdtLegajo_Legmegcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmegcodigo = value ;
   }

   public String getMegdescrip( )
   {
      return gxTv_SdtLegajo_Megdescrip ;
   }

   public void setMegdescrip( String value )
   {
      gxTv_SdtLegajo_Megdescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Megdescrip = value ;
   }

   public String getLegcatcodigo( )
   {
      return gxTv_SdtLegajo_Legcatcodigo ;
   }

   public void setLegcatcodigo( String value )
   {
      gxTv_SdtLegajo_Legcatcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatcodigo = value ;
   }

   public int getLegcatpuecod( )
   {
      return gxTv_SdtLegajo_Legcatpuecod ;
   }

   public void setLegcatpuecod( int value )
   {
      gxTv_SdtLegajo_Legcatpuecod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatpuecod = value ;
   }

   public String getLegseccodigo( )
   {
      return gxTv_SdtLegajo_Legseccodigo ;
   }

   public void setLegseccodigo( String value )
   {
      gxTv_SdtLegajo_Legseccodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legseccodigo = value ;
   }

   public String getSecdescrip( )
   {
      return gxTv_SdtLegajo_Secdescrip ;
   }

   public void setSecdescrip( String value )
   {
      gxTv_SdtLegajo_Secdescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Secdescrip = value ;
   }

   public String getLeglpgcodigo( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo ;
   }

   public void setLeglpgcodigo( String value )
   {
      gxTv_SdtLegajo_Leglpgcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglpgcodigo = value ;
   }

   public String getLpgdescri( )
   {
      return gxTv_SdtLegajo_Lpgdescri ;
   }

   public void setLpgdescri( String value )
   {
      gxTv_SdtLegajo_Lpgdescri_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Lpgdescri = value ;
   }

   public byte getLegclase( )
   {
      return gxTv_SdtLegajo_Legclase ;
   }

   public void setLegclase( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legclase = value ;
   }

   public java.math.BigDecimal getLegbasico( )
   {
      return gxTv_SdtLegajo_Legbasico ;
   }

   public void setLegbasico( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbasico = value ;
   }

   public byte getLegformapago( )
   {
      return gxTv_SdtLegajo_Legformapago ;
   }

   public void setLegformapago( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legformapago = value ;
   }

   public String getLegbancod( )
   {
      return gxTv_SdtLegajo_Legbancod ;
   }

   public void setLegbancod( String value )
   {
      gxTv_SdtLegajo_Legbancod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbancod = value ;
   }

   public String getLegbandes( )
   {
      return gxTv_SdtLegajo_Legbandes ;
   }

   public void setLegbandes( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbandes = value ;
   }

   public String getLegbansuc( )
   {
      return gxTv_SdtLegajo_Legbansuc ;
   }

   public void setLegbansuc( String value )
   {
      gxTv_SdtLegajo_Legbansuc_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbansuc = value ;
   }

   public String getLegbantipcuen( )
   {
      return gxTv_SdtLegajo_Legbantipcuen ;
   }

   public void setLegbantipcuen( String value )
   {
      gxTv_SdtLegajo_Legbantipcuen_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbantipcuen = value ;
   }

   public String getLegsincod( )
   {
      return gxTv_SdtLegajo_Legsincod ;
   }

   public void setLegsincod( String value )
   {
      gxTv_SdtLegajo_Legsincod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsincod = value ;
   }

   public String getSindescrip( )
   {
      return gxTv_SdtLegajo_Sindescrip ;
   }

   public void setSindescrip( String value )
   {
      gxTv_SdtLegajo_Sindescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Sindescrip = value ;
   }

   public String getLegosocod( )
   {
      return gxTv_SdtLegajo_Legosocod ;
   }

   public void setLegosocod( String value )
   {
      gxTv_SdtLegajo_Legosocod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosocod = value ;
   }

   public String getLegosodes( )
   {
      return gxTv_SdtLegajo_Legosodes ;
   }

   public void setLegosodes( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosodes = value ;
   }

   public String getLegosoafipcod( )
   {
      return gxTv_SdtLegajo_Legosoafipcod ;
   }

   public void setLegosoafipcod( String value )
   {
      gxTv_SdtLegajo_Legosoafipcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosoafipcod = value ;
   }

   public String getOsodescrip( )
   {
      return gxTv_SdtLegajo_Osodescrip ;
   }

   public void setOsodescrip( String value )
   {
      gxTv_SdtLegajo_Osodescrip_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osodescrip = value ;
   }

   public String getLegactcodigo( )
   {
      return gxTv_SdtLegajo_Legactcodigo ;
   }

   public void setLegactcodigo( String value )
   {
      gxTv_SdtLegajo_Legactcodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactcodigo = value ;
   }

   public String getLegactdescri( )
   {
      return gxTv_SdtLegajo_Legactdescri ;
   }

   public void setLegactdescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactdescri = value ;
   }

   public String getMprcod( )
   {
      return gxTv_SdtLegajo_Mprcod ;
   }

   public void setMprcod( String value )
   {
      gxTv_SdtLegajo_Mprcod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mprcod = value ;
   }

   public String getMprdescrip( )
   {
      return gxTv_SdtLegajo_Mprdescrip ;
   }

   public void setMprdescrip( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mprdescrip = value ;
   }

   public java.util.Date getLegfecultmod( )
   {
      return gxTv_SdtLegajo_Legfecultmod ;
   }

   public void setLegfecultmod( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecultmod = value ;
   }

   public String getLegcuentabanc( )
   {
      return gxTv_SdtLegajo_Legcuentabanc ;
   }

   public void setLegcuentabanc( String value )
   {
      gxTv_SdtLegajo_Legcuentabanc_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcuentabanc = value ;
   }

   public java.util.Date getLeglicinicio( )
   {
      return gxTv_SdtLegajo_Leglicinicio ;
   }

   public void setLeglicinicio( java.util.Date value )
   {
      gxTv_SdtLegajo_Leglicinicio_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicinicio = value ;
   }

   public java.util.Date getLeglicfinal( )
   {
      return gxTv_SdtLegajo_Leglicfinal ;
   }

   public void setLeglicfinal( java.util.Date value )
   {
      gxTv_SdtLegajo_Leglicfinal_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicfinal = value ;
   }

   public String getZoncod( )
   {
      return gxTv_SdtLegajo_Zoncod ;
   }

   public void setZoncod( String value )
   {
      gxTv_SdtLegajo_Zoncod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zoncod = value ;
   }

   public String getZondescrip( )
   {
      return gxTv_SdtLegajo_Zondescrip ;
   }

   public void setZondescrip( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zondescrip = value ;
   }

   public java.math.BigDecimal getZonporcreduc( )
   {
      return gxTv_SdtLegajo_Zonporcreduc ;
   }

   public void setZonporcreduc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zonporcreduc = value ;
   }

   public String getLegcbu( )
   {
      return gxTv_SdtLegajo_Legcbu ;
   }

   public void setLegcbu( String value )
   {
      gxTv_SdtLegajo_Legcbu_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcbu = value ;
   }

   public boolean getLegconvenio( )
   {
      return gxTv_SdtLegajo_Legconvenio ;
   }

   public void setLegconvenio( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconvenio = value ;
   }

   public boolean getLegscvo( )
   {
      return gxTv_SdtLegajo_Legscvo ;
   }

   public void setLegscvo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legscvo = value ;
   }

   public short getCondicodigo( )
   {
      return gxTv_SdtLegajo_Condicodigo ;
   }

   public void setCondicodigo( short value )
   {
      gxTv_SdtLegajo_Condicodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Condicodigo = value ;
   }

   public String getCondidescri( )
   {
      return gxTv_SdtLegajo_Condidescri ;
   }

   public void setCondidescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Condidescri = value ;
   }

   public String getSiniecodigo( )
   {
      return gxTv_SdtLegajo_Siniecodigo ;
   }

   public void setSiniecodigo( String value )
   {
      gxTv_SdtLegajo_Siniecodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Siniecodigo = value ;
   }

   public String getSiniedescri( )
   {
      return gxTv_SdtLegajo_Siniedescri ;
   }

   public void setSiniedescri( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Siniedescri = value ;
   }

   public boolean getLegactivo( )
   {
      return gxTv_SdtLegajo_Legactivo ;
   }

   public void setLegactivo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactivo = value ;
   }

   public java.math.BigDecimal getLegsueldofuera( )
   {
      return gxTv_SdtLegajo_Legsueldofuera ;
   }

   public void setLegsueldofuera( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsueldofuera = value ;
   }

   public String getLegid( )
   {
      return gxTv_SdtLegajo_Legid ;
   }

   public void setLegid( String value )
   {
      gxTv_SdtLegajo_Legid_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legid = value ;
   }

   public String getLegconvecodigo( )
   {
      return gxTv_SdtLegajo_Legconvecodigo ;
   }

   public void setLegconvecodigo( String value )
   {
      gxTv_SdtLegajo_Legconvecodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconvecodigo = value ;
   }

   public String getLegidnomape( )
   {
      return gxTv_SdtLegajo_Legidnomape ;
   }

   public void setLegidnomape( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legidnomape = value ;
   }

   public String getTipemplecod( )
   {
      return gxTv_SdtLegajo_Tipemplecod ;
   }

   public void setTipemplecod( String value )
   {
      gxTv_SdtLegajo_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Tipemplecod = value ;
   }

   public String getOsoc3992( )
   {
      return gxTv_SdtLegajo_Osoc3992 ;
   }

   public void setOsoc3992( String value )
   {
      gxTv_SdtLegajo_Osoc3992_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osoc3992 = value ;
   }

   public String getLegobs( )
   {
      return gxTv_SdtLegajo_Legobs ;
   }

   public void setLegobs( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legobs = value ;
   }

   public String getLegnomape( )
   {
      return gxTv_SdtLegajo_Legnomape ;
   }

   public void setLegnomape( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnomape = value ;
   }

   public java.util.Date getLegfecimportacion( )
   {
      return gxTv_SdtLegajo_Legfecimportacion ;
   }

   public void setLegfecimportacion( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecimportacion = value ;
   }

   public boolean getLegagenreten( )
   {
      return gxTv_SdtLegajo_Legagenreten ;
   }

   public void setLegagenreten( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legagenreten = value ;
   }

   public String getLegcontinua( )
   {
      return gxTv_SdtLegajo_Legcontinua ;
   }

   public void setLegcontinua( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcontinua = value ;
   }

   public boolean getLegrecalcliq( )
   {
      return gxTv_SdtLegajo_Legrecalcliq ;
   }

   public void setLegrecalcliq( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legrecalcliq = value ;
   }

   public boolean getLegjubilado( )
   {
      return gxTv_SdtLegajo_Legjubilado ;
   }

   public void setLegjubilado( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legjubilado = value ;
   }

   public java.math.BigDecimal getLeghorasdia( )
   {
      return gxTv_SdtLegajo_Leghorasdia ;
   }

   public void setLeghorasdia( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leghorasdia = value ;
   }

   public java.math.BigDecimal getLeghorassem( )
   {
      return gxTv_SdtLegajo_Leghorassem ;
   }

   public void setLeghorassem( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leghorassem = value ;
   }

   public String getLegreligion( )
   {
      return gxTv_SdtLegajo_Legreligion ;
   }

   public void setLegreligion( String value )
   {
      gxTv_SdtLegajo_Legreligion_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legreligion = value ;
   }

   public String getLegorigen( )
   {
      return gxTv_SdtLegajo_Legorigen ;
   }

   public void setLegorigen( String value )
   {
      gxTv_SdtLegajo_Legorigen_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legorigen = value ;
   }

   public String getLegpuescodigo( )
   {
      return gxTv_SdtLegajo_Legpuescodigo ;
   }

   public void setLegpuescodigo( String value )
   {
      gxTv_SdtLegajo_Legpuescodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpuescodigo = value ;
   }

   public String getLegsuccodigo( )
   {
      return gxTv_SdtLegajo_Legsuccodigo ;
   }

   public void setLegsuccodigo( String value )
   {
      gxTv_SdtLegajo_Legsuccodigo_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsuccodigo = value ;
   }

   public boolean getLegtrablun( )
   {
      return gxTv_SdtLegajo_Legtrablun ;
   }

   public void setLegtrablun( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrablun = value ;
   }

   public boolean getLegtrabmar( )
   {
      return gxTv_SdtLegajo_Legtrabmar ;
   }

   public void setLegtrabmar( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabmar = value ;
   }

   public boolean getLegtrabmie( )
   {
      return gxTv_SdtLegajo_Legtrabmie ;
   }

   public void setLegtrabmie( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabmie = value ;
   }

   public boolean getLegtrabjue( )
   {
      return gxTv_SdtLegajo_Legtrabjue ;
   }

   public void setLegtrabjue( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabjue = value ;
   }

   public boolean getLegtrabvie( )
   {
      return gxTv_SdtLegajo_Legtrabvie ;
   }

   public void setLegtrabvie( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabvie = value ;
   }

   public boolean getLegtrabsa( )
   {
      return gxTv_SdtLegajo_Legtrabsa ;
   }

   public void setLegtrabsa( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabsa = value ;
   }

   public boolean getLegtrabdo( )
   {
      return gxTv_SdtLegajo_Legtrabdo ;
   }

   public void setLegtrabdo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabdo = value ;
   }

   public java.util.Vector<web.StructSdtLegajo_tipos_de_trabajo> getTipos_de_trabajo( )
   {
      return gxTv_SdtLegajo_Tipos_de_trabajo ;
   }

   public void setTipos_de_trabajo( java.util.Vector<web.StructSdtLegajo_tipos_de_trabajo> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Tipos_de_trabajo = value ;
   }

   public short getLegvacpend( )
   {
      return gxTv_SdtLegajo_Legvacpend ;
   }

   public void setLegvacpend( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legvacpend = value ;
   }

   public java.util.Date getLegfecpreaviso( )
   {
      return gxTv_SdtLegajo_Legfecpreaviso ;
   }

   public void setLegfecpreaviso( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecpreaviso = value ;
   }

   public int getLegconveversioncli( )
   {
      return gxTv_SdtLegajo_Legconveversioncli ;
   }

   public void setLegconveversioncli( int value )
   {
      gxTv_SdtLegajo_Legconveversioncli_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconveversioncli = value ;
   }

   public short getLegsitrevegreso( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso ;
   }

   public void setLegsitrevegreso( short value )
   {
      gxTv_SdtLegajo_Legsitrevegreso_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsitrevegreso = value ;
   }

   public String getLegpromdias( )
   {
      return gxTv_SdtLegajo_Legpromdias ;
   }

   public void setLegpromdias( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpromdias = value ;
   }

   public String getLegtitulo( )
   {
      return gxTv_SdtLegajo_Legtitulo ;
   }

   public void setLegtitulo( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtitulo = value ;
   }

   public byte getLegestado( )
   {
      return gxTv_SdtLegajo_Legestado ;
   }

   public void setLegestado( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legestado = value ;
   }

   public int getLegactclasnro( )
   {
      return gxTv_SdtLegajo_Legactclasnro ;
   }

   public void setLegactclasnro( int value )
   {
      gxTv_SdtLegajo_Legactclasnro_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactclasnro = value ;
   }

   public String getLegpueaficod( )
   {
      return gxTv_SdtLegajo_Legpueaficod ;
   }

   public void setLegpueaficod( String value )
   {
      gxTv_SdtLegajo_Legpueaficod_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpueaficod = value ;
   }

   public String getLegmigrwarn( )
   {
      return gxTv_SdtLegajo_Legmigrwarn ;
   }

   public void setLegmigrwarn( String value )
   {
      gxTv_SdtLegajo_Legmigrwarn_N = (byte)(0) ;
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmigrwarn = value ;
   }

   public boolean getLegincompleto( )
   {
      return gxTv_SdtLegajo_Legincompleto ;
   }

   public void setLegincompleto( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legincompleto = value ;
   }

   public boolean getLegliqapo( )
   {
      return gxTv_SdtLegajo_Legliqapo ;
   }

   public void setLegliqapo( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legliqapo = value ;
   }

   public java.util.Vector<web.StructSdtLegajo_Propiedades> getPropiedades( )
   {
      return gxTv_SdtLegajo_Propiedades ;
   }

   public void setPropiedades( java.util.Vector<web.StructSdtLegajo_Propiedades> value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades = value ;
   }

   public String getLegmodtra( )
   {
      return gxTv_SdtLegajo_Legmodtra ;
   }

   public void setLegmodtra( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmodtra = value ;
   }

   public String getLegtipotarifa( )
   {
      return gxTv_SdtLegajo_Legtipotarifa ;
   }

   public void setLegtipotarifa( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtipotarifa = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLegajo_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLegajo_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtLegajo_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Empnom_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtLegajo_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnumero_Z = value ;
   }

   public String getLegapellido_Z( )
   {
      return gxTv_SdtLegajo_Legapellido_Z ;
   }

   public void setLegapellido_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legapellido_Z = value ;
   }

   public String getLegnombre_Z( )
   {
      return gxTv_SdtLegajo_Legnombre_Z ;
   }

   public void setLegnombre_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnombre_Z = value ;
   }

   public String getLegfotonom_Z( )
   {
      return gxTv_SdtLegajo_Legfotonom_Z ;
   }

   public void setLegfotonom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfotonom_Z = value ;
   }

   public String getLegfotoext_Z( )
   {
      return gxTv_SdtLegajo_Legfotoext_Z ;
   }

   public void setLegfotoext_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfotoext_Z = value ;
   }

   public byte getLegtipdoc_Z( )
   {
      return gxTv_SdtLegajo_Legtipdoc_Z ;
   }

   public void setLegtipdoc_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtipdoc_Z = value ;
   }

   public String getLegnumdoc_Z( )
   {
      return gxTv_SdtLegajo_Legnumdoc_Z ;
   }

   public void setLegnumdoc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnumdoc_Z = value ;
   }

   public java.util.Date getLegfecnac_Z( )
   {
      return gxTv_SdtLegajo_Legfecnac_Z ;
   }

   public void setLegfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecnac_Z = value ;
   }

   public byte getLegsexo_Z( )
   {
      return gxTv_SdtLegajo_Legsexo_Z ;
   }

   public void setLegsexo_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsexo_Z = value ;
   }

   public short getLegestadocivil_Z( )
   {
      return gxTv_SdtLegajo_Legestadocivil_Z ;
   }

   public void setLegestadocivil_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legestadocivil_Z = value ;
   }

   public short getLegnacioncod_Z( )
   {
      return gxTv_SdtLegajo_Legnacioncod_Z ;
   }

   public void setLegnacioncod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnacioncod_Z = value ;
   }

   public String getLegnacionalidad_Z( )
   {
      return gxTv_SdtLegajo_Legnacionalidad_Z ;
   }

   public void setLegnacionalidad_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnacionalidad_Z = value ;
   }

   public long getLegcuil_Z( )
   {
      return gxTv_SdtLegajo_Legcuil_Z ;
   }

   public void setLegcuil_Z( long value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcuil_Z = value ;
   }

   public byte getLegdiscapacidad_Z( )
   {
      return gxTv_SdtLegajo_Legdiscapacidad_Z ;
   }

   public void setLegdiscapacidad_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legdiscapacidad_Z = value ;
   }

   public String getLegdomici_Z( )
   {
      return gxTv_SdtLegajo_Legdomici_Z ;
   }

   public void setLegdomici_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legdomici_Z = value ;
   }

   public String getLegemail_Z( )
   {
      return gxTv_SdtLegajo_Legemail_Z ;
   }

   public void setLegemail_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legemail_Z = value ;
   }

   public String getLegcodpos_Z( )
   {
      return gxTv_SdtLegajo_Legcodpos_Z ;
   }

   public void setLegcodpos_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcodpos_Z = value ;
   }

   public short getLegpaicod_Z( )
   {
      return gxTv_SdtLegajo_Legpaicod_Z ;
   }

   public void setLegpaicod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpaicod_Z = value ;
   }

   public String getLegpainom_Z( )
   {
      return gxTv_SdtLegajo_Legpainom_Z ;
   }

   public void setLegpainom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpainom_Z = value ;
   }

   public short getLegprovcod_Z( )
   {
      return gxTv_SdtLegajo_Legprovcod_Z ;
   }

   public void setLegprovcod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legprovcod_Z = value ;
   }

   public String getLegprovnom_Z( )
   {
      return gxTv_SdtLegajo_Legprovnom_Z ;
   }

   public void setLegprovnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legprovnom_Z = value ;
   }

   public short getLegloccod_Z( )
   {
      return gxTv_SdtLegajo_Legloccod_Z ;
   }

   public void setLegloccod_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legloccod_Z = value ;
   }

   public String getLeglocnom_Z( )
   {
      return gxTv_SdtLegajo_Leglocnom_Z ;
   }

   public void setLeglocnom_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglocnom_Z = value ;
   }

   public String getLegtelefono_Z( )
   {
      return gxTv_SdtLegajo_Legtelefono_Z ;
   }

   public void setLegtelefono_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtelefono_Z = value ;
   }

   public java.util.Date getLegfecingreso_Z( )
   {
      return gxTv_SdtLegajo_Legfecingreso_Z ;
   }

   public void setLegfecingreso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecingreso_Z = value ;
   }

   public java.util.Date getLegfecegreso_Z( )
   {
      return gxTv_SdtLegajo_Legfecegreso_Z ;
   }

   public void setLegfecegreso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecegreso_Z = value ;
   }

   public String getLegmegcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legmegcodigo_Z ;
   }

   public void setLegmegcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmegcodigo_Z = value ;
   }

   public String getMegdescrip_Z( )
   {
      return gxTv_SdtLegajo_Megdescrip_Z ;
   }

   public void setMegdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Megdescrip_Z = value ;
   }

   public String getLegcatcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legcatcodigo_Z ;
   }

   public void setLegcatcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatcodigo_Z = value ;
   }

   public int getLegcatpuecod_Z( )
   {
      return gxTv_SdtLegajo_Legcatpuecod_Z ;
   }

   public void setLegcatpuecod_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatpuecod_Z = value ;
   }

   public String getLegseccodigo_Z( )
   {
      return gxTv_SdtLegajo_Legseccodigo_Z ;
   }

   public void setLegseccodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legseccodigo_Z = value ;
   }

   public String getSecdescrip_Z( )
   {
      return gxTv_SdtLegajo_Secdescrip_Z ;
   }

   public void setSecdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Secdescrip_Z = value ;
   }

   public String getLeglpgcodigo_Z( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo_Z ;
   }

   public void setLeglpgcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglpgcodigo_Z = value ;
   }

   public String getLpgdescri_Z( )
   {
      return gxTv_SdtLegajo_Lpgdescri_Z ;
   }

   public void setLpgdescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Lpgdescri_Z = value ;
   }

   public byte getLegclase_Z( )
   {
      return gxTv_SdtLegajo_Legclase_Z ;
   }

   public void setLegclase_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legclase_Z = value ;
   }

   public java.math.BigDecimal getLegbasico_Z( )
   {
      return gxTv_SdtLegajo_Legbasico_Z ;
   }

   public void setLegbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbasico_Z = value ;
   }

   public byte getLegformapago_Z( )
   {
      return gxTv_SdtLegajo_Legformapago_Z ;
   }

   public void setLegformapago_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legformapago_Z = value ;
   }

   public String getLegbancod_Z( )
   {
      return gxTv_SdtLegajo_Legbancod_Z ;
   }

   public void setLegbancod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbancod_Z = value ;
   }

   public String getLegbandes_Z( )
   {
      return gxTv_SdtLegajo_Legbandes_Z ;
   }

   public void setLegbandes_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbandes_Z = value ;
   }

   public String getLegbansuc_Z( )
   {
      return gxTv_SdtLegajo_Legbansuc_Z ;
   }

   public void setLegbansuc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbansuc_Z = value ;
   }

   public String getLegbantipcuen_Z( )
   {
      return gxTv_SdtLegajo_Legbantipcuen_Z ;
   }

   public void setLegbantipcuen_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbantipcuen_Z = value ;
   }

   public String getLegsincod_Z( )
   {
      return gxTv_SdtLegajo_Legsincod_Z ;
   }

   public void setLegsincod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsincod_Z = value ;
   }

   public String getSindescrip_Z( )
   {
      return gxTv_SdtLegajo_Sindescrip_Z ;
   }

   public void setSindescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Sindescrip_Z = value ;
   }

   public String getLegosocod_Z( )
   {
      return gxTv_SdtLegajo_Legosocod_Z ;
   }

   public void setLegosocod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosocod_Z = value ;
   }

   public String getLegosodes_Z( )
   {
      return gxTv_SdtLegajo_Legosodes_Z ;
   }

   public void setLegosodes_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosodes_Z = value ;
   }

   public String getLegosoafipcod_Z( )
   {
      return gxTv_SdtLegajo_Legosoafipcod_Z ;
   }

   public void setLegosoafipcod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosoafipcod_Z = value ;
   }

   public String getOsodescrip_Z( )
   {
      return gxTv_SdtLegajo_Osodescrip_Z ;
   }

   public void setOsodescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osodescrip_Z = value ;
   }

   public String getLegactcodigo_Z( )
   {
      return gxTv_SdtLegajo_Legactcodigo_Z ;
   }

   public void setLegactcodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactcodigo_Z = value ;
   }

   public String getLegactdescri_Z( )
   {
      return gxTv_SdtLegajo_Legactdescri_Z ;
   }

   public void setLegactdescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactdescri_Z = value ;
   }

   public String getMprcod_Z( )
   {
      return gxTv_SdtLegajo_Mprcod_Z ;
   }

   public void setMprcod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mprcod_Z = value ;
   }

   public String getMprdescrip_Z( )
   {
      return gxTv_SdtLegajo_Mprdescrip_Z ;
   }

   public void setMprdescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mprdescrip_Z = value ;
   }

   public java.util.Date getLegfecultmod_Z( )
   {
      return gxTv_SdtLegajo_Legfecultmod_Z ;
   }

   public void setLegfecultmod_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecultmod_Z = value ;
   }

   public String getLegcuentabanc_Z( )
   {
      return gxTv_SdtLegajo_Legcuentabanc_Z ;
   }

   public void setLegcuentabanc_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcuentabanc_Z = value ;
   }

   public java.util.Date getLeglicinicio_Z( )
   {
      return gxTv_SdtLegajo_Leglicinicio_Z ;
   }

   public void setLeglicinicio_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicinicio_Z = value ;
   }

   public java.util.Date getLeglicfinal_Z( )
   {
      return gxTv_SdtLegajo_Leglicfinal_Z ;
   }

   public void setLeglicfinal_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicfinal_Z = value ;
   }

   public String getZoncod_Z( )
   {
      return gxTv_SdtLegajo_Zoncod_Z ;
   }

   public void setZoncod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zoncod_Z = value ;
   }

   public String getZondescrip_Z( )
   {
      return gxTv_SdtLegajo_Zondescrip_Z ;
   }

   public void setZondescrip_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zondescrip_Z = value ;
   }

   public java.math.BigDecimal getZonporcreduc_Z( )
   {
      return gxTv_SdtLegajo_Zonporcreduc_Z ;
   }

   public void setZonporcreduc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zonporcreduc_Z = value ;
   }

   public String getLegcbu_Z( )
   {
      return gxTv_SdtLegajo_Legcbu_Z ;
   }

   public void setLegcbu_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcbu_Z = value ;
   }

   public boolean getLegconvenio_Z( )
   {
      return gxTv_SdtLegajo_Legconvenio_Z ;
   }

   public void setLegconvenio_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconvenio_Z = value ;
   }

   public boolean getLegscvo_Z( )
   {
      return gxTv_SdtLegajo_Legscvo_Z ;
   }

   public void setLegscvo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legscvo_Z = value ;
   }

   public short getCondicodigo_Z( )
   {
      return gxTv_SdtLegajo_Condicodigo_Z ;
   }

   public void setCondicodigo_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Condicodigo_Z = value ;
   }

   public String getCondidescri_Z( )
   {
      return gxTv_SdtLegajo_Condidescri_Z ;
   }

   public void setCondidescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Condidescri_Z = value ;
   }

   public String getSiniecodigo_Z( )
   {
      return gxTv_SdtLegajo_Siniecodigo_Z ;
   }

   public void setSiniecodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Siniecodigo_Z = value ;
   }

   public String getSiniedescri_Z( )
   {
      return gxTv_SdtLegajo_Siniedescri_Z ;
   }

   public void setSiniedescri_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Siniedescri_Z = value ;
   }

   public boolean getLegactivo_Z( )
   {
      return gxTv_SdtLegajo_Legactivo_Z ;
   }

   public void setLegactivo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactivo_Z = value ;
   }

   public java.math.BigDecimal getLegsueldofuera_Z( )
   {
      return gxTv_SdtLegajo_Legsueldofuera_Z ;
   }

   public void setLegsueldofuera_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsueldofuera_Z = value ;
   }

   public String getLegid_Z( )
   {
      return gxTv_SdtLegajo_Legid_Z ;
   }

   public void setLegid_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legid_Z = value ;
   }

   public String getLegconvecodigo_Z( )
   {
      return gxTv_SdtLegajo_Legconvecodigo_Z ;
   }

   public void setLegconvecodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconvecodigo_Z = value ;
   }

   public String getLegidnomape_Z( )
   {
      return gxTv_SdtLegajo_Legidnomape_Z ;
   }

   public void setLegidnomape_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legidnomape_Z = value ;
   }

   public String getTipemplecod_Z( )
   {
      return gxTv_SdtLegajo_Tipemplecod_Z ;
   }

   public void setTipemplecod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Tipemplecod_Z = value ;
   }

   public String getOsoc3992_Z( )
   {
      return gxTv_SdtLegajo_Osoc3992_Z ;
   }

   public void setOsoc3992_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osoc3992_Z = value ;
   }

   public String getLegnomape_Z( )
   {
      return gxTv_SdtLegajo_Legnomape_Z ;
   }

   public void setLegnomape_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnomape_Z = value ;
   }

   public java.util.Date getLegfecimportacion_Z( )
   {
      return gxTv_SdtLegajo_Legfecimportacion_Z ;
   }

   public void setLegfecimportacion_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecimportacion_Z = value ;
   }

   public boolean getLegagenreten_Z( )
   {
      return gxTv_SdtLegajo_Legagenreten_Z ;
   }

   public void setLegagenreten_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legagenreten_Z = value ;
   }

   public String getLegcontinua_Z( )
   {
      return gxTv_SdtLegajo_Legcontinua_Z ;
   }

   public void setLegcontinua_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcontinua_Z = value ;
   }

   public boolean getLegrecalcliq_Z( )
   {
      return gxTv_SdtLegajo_Legrecalcliq_Z ;
   }

   public void setLegrecalcliq_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legrecalcliq_Z = value ;
   }

   public boolean getLegjubilado_Z( )
   {
      return gxTv_SdtLegajo_Legjubilado_Z ;
   }

   public void setLegjubilado_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legjubilado_Z = value ;
   }

   public java.math.BigDecimal getLeghorasdia_Z( )
   {
      return gxTv_SdtLegajo_Leghorasdia_Z ;
   }

   public void setLeghorasdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leghorasdia_Z = value ;
   }

   public java.math.BigDecimal getLeghorassem_Z( )
   {
      return gxTv_SdtLegajo_Leghorassem_Z ;
   }

   public void setLeghorassem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leghorassem_Z = value ;
   }

   public String getLegreligion_Z( )
   {
      return gxTv_SdtLegajo_Legreligion_Z ;
   }

   public void setLegreligion_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legreligion_Z = value ;
   }

   public String getLegorigen_Z( )
   {
      return gxTv_SdtLegajo_Legorigen_Z ;
   }

   public void setLegorigen_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legorigen_Z = value ;
   }

   public String getLegpuescodigo_Z( )
   {
      return gxTv_SdtLegajo_Legpuescodigo_Z ;
   }

   public void setLegpuescodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpuescodigo_Z = value ;
   }

   public String getLegsuccodigo_Z( )
   {
      return gxTv_SdtLegajo_Legsuccodigo_Z ;
   }

   public void setLegsuccodigo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsuccodigo_Z = value ;
   }

   public boolean getLegtrablun_Z( )
   {
      return gxTv_SdtLegajo_Legtrablun_Z ;
   }

   public void setLegtrablun_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrablun_Z = value ;
   }

   public boolean getLegtrabmar_Z( )
   {
      return gxTv_SdtLegajo_Legtrabmar_Z ;
   }

   public void setLegtrabmar_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabmar_Z = value ;
   }

   public boolean getLegtrabmie_Z( )
   {
      return gxTv_SdtLegajo_Legtrabmie_Z ;
   }

   public void setLegtrabmie_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabmie_Z = value ;
   }

   public boolean getLegtrabjue_Z( )
   {
      return gxTv_SdtLegajo_Legtrabjue_Z ;
   }

   public void setLegtrabjue_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabjue_Z = value ;
   }

   public boolean getLegtrabvie_Z( )
   {
      return gxTv_SdtLegajo_Legtrabvie_Z ;
   }

   public void setLegtrabvie_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabvie_Z = value ;
   }

   public boolean getLegtrabsa_Z( )
   {
      return gxTv_SdtLegajo_Legtrabsa_Z ;
   }

   public void setLegtrabsa_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabsa_Z = value ;
   }

   public boolean getLegtrabdo_Z( )
   {
      return gxTv_SdtLegajo_Legtrabdo_Z ;
   }

   public void setLegtrabdo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtrabdo_Z = value ;
   }

   public short getLegvacpend_Z( )
   {
      return gxTv_SdtLegajo_Legvacpend_Z ;
   }

   public void setLegvacpend_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legvacpend_Z = value ;
   }

   public java.util.Date getLegfecpreaviso_Z( )
   {
      return gxTv_SdtLegajo_Legfecpreaviso_Z ;
   }

   public void setLegfecpreaviso_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecpreaviso_Z = value ;
   }

   public int getLegconveversioncli_Z( )
   {
      return gxTv_SdtLegajo_Legconveversioncli_Z ;
   }

   public void setLegconveversioncli_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconveversioncli_Z = value ;
   }

   public short getLegsitrevegreso_Z( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso_Z ;
   }

   public void setLegsitrevegreso_Z( short value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsitrevegreso_Z = value ;
   }

   public String getLegpromdias_Z( )
   {
      return gxTv_SdtLegajo_Legpromdias_Z ;
   }

   public void setLegpromdias_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpromdias_Z = value ;
   }

   public String getLegtitulo_Z( )
   {
      return gxTv_SdtLegajo_Legtitulo_Z ;
   }

   public void setLegtitulo_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtitulo_Z = value ;
   }

   public byte getLegestado_Z( )
   {
      return gxTv_SdtLegajo_Legestado_Z ;
   }

   public void setLegestado_Z( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legestado_Z = value ;
   }

   public int getLegactclasnro_Z( )
   {
      return gxTv_SdtLegajo_Legactclasnro_Z ;
   }

   public void setLegactclasnro_Z( int value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactclasnro_Z = value ;
   }

   public String getLegpueaficod_Z( )
   {
      return gxTv_SdtLegajo_Legpueaficod_Z ;
   }

   public void setLegpueaficod_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpueaficod_Z = value ;
   }

   public boolean getLegincompleto_Z( )
   {
      return gxTv_SdtLegajo_Legincompleto_Z ;
   }

   public void setLegincompleto_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legincompleto_Z = value ;
   }

   public boolean getLegliqapo_Z( )
   {
      return gxTv_SdtLegajo_Legliqapo_Z ;
   }

   public void setLegliqapo_Z( boolean value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legliqapo_Z = value ;
   }

   public String getLegmodtra_Z( )
   {
      return gxTv_SdtLegajo_Legmodtra_Z ;
   }

   public void setLegmodtra_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmodtra_Z = value ;
   }

   public String getLegtipotarifa_Z( )
   {
      return gxTv_SdtLegajo_Legtipotarifa_Z ;
   }

   public void setLegtipotarifa_Z( String value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtipotarifa_Z = value ;
   }

   public byte getLegfoto_N( )
   {
      return gxTv_SdtLegajo_Legfoto_N ;
   }

   public void setLegfoto_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfoto_N = value ;
   }

   public byte getLegsexo_N( )
   {
      return gxTv_SdtLegajo_Legsexo_N ;
   }

   public void setLegsexo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsexo_N = value ;
   }

   public byte getLegestadocivil_N( )
   {
      return gxTv_SdtLegajo_Legestadocivil_N ;
   }

   public void setLegestadocivil_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legestadocivil_N = value ;
   }

   public byte getLegnacioncod_N( )
   {
      return gxTv_SdtLegajo_Legnacioncod_N ;
   }

   public void setLegnacioncod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legnacioncod_N = value ;
   }

   public byte getLegpaicod_N( )
   {
      return gxTv_SdtLegajo_Legpaicod_N ;
   }

   public void setLegpaicod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpaicod_N = value ;
   }

   public byte getLegprovcod_N( )
   {
      return gxTv_SdtLegajo_Legprovcod_N ;
   }

   public void setLegprovcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legprovcod_N = value ;
   }

   public byte getLegloccod_N( )
   {
      return gxTv_SdtLegajo_Legloccod_N ;
   }

   public void setLegloccod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legloccod_N = value ;
   }

   public byte getLegtelefono_N( )
   {
      return gxTv_SdtLegajo_Legtelefono_N ;
   }

   public void setLegtelefono_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legtelefono_N = value ;
   }

   public byte getLegfecegreso_N( )
   {
      return gxTv_SdtLegajo_Legfecegreso_N ;
   }

   public void setLegfecegreso_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legfecegreso_N = value ;
   }

   public byte getLegmegcodigo_N( )
   {
      return gxTv_SdtLegajo_Legmegcodigo_N ;
   }

   public void setLegmegcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmegcodigo_N = value ;
   }

   public byte getMegdescrip_N( )
   {
      return gxTv_SdtLegajo_Megdescrip_N ;
   }

   public void setMegdescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Megdescrip_N = value ;
   }

   public byte getLegcatcodigo_N( )
   {
      return gxTv_SdtLegajo_Legcatcodigo_N ;
   }

   public void setLegcatcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatcodigo_N = value ;
   }

   public byte getLegcatpuecod_N( )
   {
      return gxTv_SdtLegajo_Legcatpuecod_N ;
   }

   public void setLegcatpuecod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcatpuecod_N = value ;
   }

   public byte getLegseccodigo_N( )
   {
      return gxTv_SdtLegajo_Legseccodigo_N ;
   }

   public void setLegseccodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legseccodigo_N = value ;
   }

   public byte getSecdescrip_N( )
   {
      return gxTv_SdtLegajo_Secdescrip_N ;
   }

   public void setSecdescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Secdescrip_N = value ;
   }

   public byte getLeglpgcodigo_N( )
   {
      return gxTv_SdtLegajo_Leglpgcodigo_N ;
   }

   public void setLeglpgcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglpgcodigo_N = value ;
   }

   public byte getLpgdescri_N( )
   {
      return gxTv_SdtLegajo_Lpgdescri_N ;
   }

   public void setLpgdescri_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Lpgdescri_N = value ;
   }

   public byte getLegbancod_N( )
   {
      return gxTv_SdtLegajo_Legbancod_N ;
   }

   public void setLegbancod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbancod_N = value ;
   }

   public byte getLegbansuc_N( )
   {
      return gxTv_SdtLegajo_Legbansuc_N ;
   }

   public void setLegbansuc_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbansuc_N = value ;
   }

   public byte getLegbantipcuen_N( )
   {
      return gxTv_SdtLegajo_Legbantipcuen_N ;
   }

   public void setLegbantipcuen_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legbantipcuen_N = value ;
   }

   public byte getLegsincod_N( )
   {
      return gxTv_SdtLegajo_Legsincod_N ;
   }

   public void setLegsincod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsincod_N = value ;
   }

   public byte getSindescrip_N( )
   {
      return gxTv_SdtLegajo_Sindescrip_N ;
   }

   public void setSindescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Sindescrip_N = value ;
   }

   public byte getLegosocod_N( )
   {
      return gxTv_SdtLegajo_Legosocod_N ;
   }

   public void setLegosocod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosocod_N = value ;
   }

   public byte getLegosoafipcod_N( )
   {
      return gxTv_SdtLegajo_Legosoafipcod_N ;
   }

   public void setLegosoafipcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legosoafipcod_N = value ;
   }

   public byte getOsodescrip_N( )
   {
      return gxTv_SdtLegajo_Osodescrip_N ;
   }

   public void setOsodescrip_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osodescrip_N = value ;
   }

   public byte getLegactcodigo_N( )
   {
      return gxTv_SdtLegajo_Legactcodigo_N ;
   }

   public void setLegactcodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactcodigo_N = value ;
   }

   public byte getMprcod_N( )
   {
      return gxTv_SdtLegajo_Mprcod_N ;
   }

   public void setMprcod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Mprcod_N = value ;
   }

   public byte getLegcuentabanc_N( )
   {
      return gxTv_SdtLegajo_Legcuentabanc_N ;
   }

   public void setLegcuentabanc_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcuentabanc_N = value ;
   }

   public byte getLeglicinicio_N( )
   {
      return gxTv_SdtLegajo_Leglicinicio_N ;
   }

   public void setLeglicinicio_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicinicio_N = value ;
   }

   public byte getLeglicfinal_N( )
   {
      return gxTv_SdtLegajo_Leglicfinal_N ;
   }

   public void setLeglicfinal_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Leglicfinal_N = value ;
   }

   public byte getZoncod_N( )
   {
      return gxTv_SdtLegajo_Zoncod_N ;
   }

   public void setZoncod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Zoncod_N = value ;
   }

   public byte getLegcbu_N( )
   {
      return gxTv_SdtLegajo_Legcbu_N ;
   }

   public void setLegcbu_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legcbu_N = value ;
   }

   public byte getCondicodigo_N( )
   {
      return gxTv_SdtLegajo_Condicodigo_N ;
   }

   public void setCondicodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Condicodigo_N = value ;
   }

   public byte getSiniecodigo_N( )
   {
      return gxTv_SdtLegajo_Siniecodigo_N ;
   }

   public void setSiniecodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Siniecodigo_N = value ;
   }

   public byte getLegid_N( )
   {
      return gxTv_SdtLegajo_Legid_N ;
   }

   public void setLegid_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legid_N = value ;
   }

   public byte getLegconvecodigo_N( )
   {
      return gxTv_SdtLegajo_Legconvecodigo_N ;
   }

   public void setLegconvecodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconvecodigo_N = value ;
   }

   public byte getTipemplecod_N( )
   {
      return gxTv_SdtLegajo_Tipemplecod_N ;
   }

   public void setTipemplecod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Tipemplecod_N = value ;
   }

   public byte getOsoc3992_N( )
   {
      return gxTv_SdtLegajo_Osoc3992_N ;
   }

   public void setOsoc3992_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Osoc3992_N = value ;
   }

   public byte getLegreligion_N( )
   {
      return gxTv_SdtLegajo_Legreligion_N ;
   }

   public void setLegreligion_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legreligion_N = value ;
   }

   public byte getLegorigen_N( )
   {
      return gxTv_SdtLegajo_Legorigen_N ;
   }

   public void setLegorigen_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legorigen_N = value ;
   }

   public byte getLegpuescodigo_N( )
   {
      return gxTv_SdtLegajo_Legpuescodigo_N ;
   }

   public void setLegpuescodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpuescodigo_N = value ;
   }

   public byte getLegsuccodigo_N( )
   {
      return gxTv_SdtLegajo_Legsuccodigo_N ;
   }

   public void setLegsuccodigo_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsuccodigo_N = value ;
   }

   public byte getLegconveversioncli_N( )
   {
      return gxTv_SdtLegajo_Legconveversioncli_N ;
   }

   public void setLegconveversioncli_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legconveversioncli_N = value ;
   }

   public byte getLegsitrevegreso_N( )
   {
      return gxTv_SdtLegajo_Legsitrevegreso_N ;
   }

   public void setLegsitrevegreso_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legsitrevegreso_N = value ;
   }

   public byte getLegactclasnro_N( )
   {
      return gxTv_SdtLegajo_Legactclasnro_N ;
   }

   public void setLegactclasnro_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legactclasnro_N = value ;
   }

   public byte getLegpueaficod_N( )
   {
      return gxTv_SdtLegajo_Legpueaficod_N ;
   }

   public void setLegpueaficod_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legpueaficod_N = value ;
   }

   public byte getLegmigrwarn_N( )
   {
      return gxTv_SdtLegajo_Legmigrwarn_N ;
   }

   public void setLegmigrwarn_N( byte value )
   {
      gxTv_SdtLegajo_N = (byte)(0) ;
      gxTv_SdtLegajo_Legmigrwarn_N = value ;
   }

   protected byte gxTv_SdtLegajo_Legtipdoc ;
   protected byte gxTv_SdtLegajo_Legsexo ;
   protected byte gxTv_SdtLegajo_Legdiscapacidad ;
   protected byte gxTv_SdtLegajo_Legclase ;
   protected byte gxTv_SdtLegajo_Legformapago ;
   protected byte gxTv_SdtLegajo_Legestado ;
   protected byte gxTv_SdtLegajo_Legtipdoc_Z ;
   protected byte gxTv_SdtLegajo_Legsexo_Z ;
   protected byte gxTv_SdtLegajo_Legdiscapacidad_Z ;
   protected byte gxTv_SdtLegajo_Legclase_Z ;
   protected byte gxTv_SdtLegajo_Legformapago_Z ;
   protected byte gxTv_SdtLegajo_Legestado_Z ;
   protected byte gxTv_SdtLegajo_Legfoto_N ;
   protected byte gxTv_SdtLegajo_Legsexo_N ;
   protected byte gxTv_SdtLegajo_Legestadocivil_N ;
   protected byte gxTv_SdtLegajo_Legnacioncod_N ;
   protected byte gxTv_SdtLegajo_Legpaicod_N ;
   protected byte gxTv_SdtLegajo_Legprovcod_N ;
   protected byte gxTv_SdtLegajo_Legloccod_N ;
   protected byte gxTv_SdtLegajo_Legtelefono_N ;
   protected byte gxTv_SdtLegajo_Legfecegreso_N ;
   protected byte gxTv_SdtLegajo_Legmegcodigo_N ;
   protected byte gxTv_SdtLegajo_Megdescrip_N ;
   protected byte gxTv_SdtLegajo_Legcatcodigo_N ;
   protected byte gxTv_SdtLegajo_Legcatpuecod_N ;
   protected byte gxTv_SdtLegajo_Legseccodigo_N ;
   protected byte gxTv_SdtLegajo_Secdescrip_N ;
   protected byte gxTv_SdtLegajo_Leglpgcodigo_N ;
   protected byte gxTv_SdtLegajo_Lpgdescri_N ;
   protected byte gxTv_SdtLegajo_Legbancod_N ;
   protected byte gxTv_SdtLegajo_Legbansuc_N ;
   protected byte gxTv_SdtLegajo_Legbantipcuen_N ;
   protected byte gxTv_SdtLegajo_Legsincod_N ;
   protected byte gxTv_SdtLegajo_Sindescrip_N ;
   protected byte gxTv_SdtLegajo_Legosocod_N ;
   protected byte gxTv_SdtLegajo_Legosoafipcod_N ;
   protected byte gxTv_SdtLegajo_Osodescrip_N ;
   protected byte gxTv_SdtLegajo_Legactcodigo_N ;
   protected byte gxTv_SdtLegajo_Mprcod_N ;
   protected byte gxTv_SdtLegajo_Legcuentabanc_N ;
   protected byte gxTv_SdtLegajo_Leglicinicio_N ;
   protected byte gxTv_SdtLegajo_Leglicfinal_N ;
   protected byte gxTv_SdtLegajo_Zoncod_N ;
   protected byte gxTv_SdtLegajo_Legcbu_N ;
   protected byte gxTv_SdtLegajo_Condicodigo_N ;
   protected byte gxTv_SdtLegajo_Siniecodigo_N ;
   protected byte gxTv_SdtLegajo_Legid_N ;
   protected byte gxTv_SdtLegajo_Legconvecodigo_N ;
   protected byte gxTv_SdtLegajo_Tipemplecod_N ;
   protected byte gxTv_SdtLegajo_Osoc3992_N ;
   protected byte gxTv_SdtLegajo_Legreligion_N ;
   protected byte gxTv_SdtLegajo_Legorigen_N ;
   protected byte gxTv_SdtLegajo_Legpuescodigo_N ;
   protected byte gxTv_SdtLegajo_Legsuccodigo_N ;
   protected byte gxTv_SdtLegajo_Legconveversioncli_N ;
   protected byte gxTv_SdtLegajo_Legsitrevegreso_N ;
   protected byte gxTv_SdtLegajo_Legactclasnro_N ;
   protected byte gxTv_SdtLegajo_Legpueaficod_N ;
   protected byte gxTv_SdtLegajo_Legmigrwarn_N ;
   private byte gxTv_SdtLegajo_N ;
   protected short gxTv_SdtLegajo_Empcod ;
   protected short gxTv_SdtLegajo_Legestadocivil ;
   protected short gxTv_SdtLegajo_Legnacioncod ;
   protected short gxTv_SdtLegajo_Legpaicod ;
   protected short gxTv_SdtLegajo_Legprovcod ;
   protected short gxTv_SdtLegajo_Legloccod ;
   protected short gxTv_SdtLegajo_Condicodigo ;
   protected short gxTv_SdtLegajo_Legvacpend ;
   protected short gxTv_SdtLegajo_Legsitrevegreso ;
   protected short gxTv_SdtLegajo_Initialized ;
   protected short gxTv_SdtLegajo_Empcod_Z ;
   protected short gxTv_SdtLegajo_Legestadocivil_Z ;
   protected short gxTv_SdtLegajo_Legnacioncod_Z ;
   protected short gxTv_SdtLegajo_Legpaicod_Z ;
   protected short gxTv_SdtLegajo_Legprovcod_Z ;
   protected short gxTv_SdtLegajo_Legloccod_Z ;
   protected short gxTv_SdtLegajo_Condicodigo_Z ;
   protected short gxTv_SdtLegajo_Legvacpend_Z ;
   protected short gxTv_SdtLegajo_Legsitrevegreso_Z ;
   protected int gxTv_SdtLegajo_Clicod ;
   protected int gxTv_SdtLegajo_Legnumero ;
   protected int gxTv_SdtLegajo_Legcatpuecod ;
   protected int gxTv_SdtLegajo_Legconveversioncli ;
   protected int gxTv_SdtLegajo_Legactclasnro ;
   protected int gxTv_SdtLegajo_Clicod_Z ;
   protected int gxTv_SdtLegajo_Legnumero_Z ;
   protected int gxTv_SdtLegajo_Legcatpuecod_Z ;
   protected int gxTv_SdtLegajo_Legconveversioncli_Z ;
   protected int gxTv_SdtLegajo_Legactclasnro_Z ;
   protected long gxTv_SdtLegajo_Legcuil ;
   protected long gxTv_SdtLegajo_Legcuil_Z ;
   protected String gxTv_SdtLegajo_Legfotoext ;
   protected String gxTv_SdtLegajo_Legcodpos ;
   protected String gxTv_SdtLegajo_Legmegcodigo ;
   protected String gxTv_SdtLegajo_Legcatcodigo ;
   protected String gxTv_SdtLegajo_Legseccodigo ;
   protected String gxTv_SdtLegajo_Leglpgcodigo ;
   protected String gxTv_SdtLegajo_Legbancod ;
   protected String gxTv_SdtLegajo_Legbantipcuen ;
   protected String gxTv_SdtLegajo_Legsincod ;
   protected String gxTv_SdtLegajo_Legosocod ;
   protected String gxTv_SdtLegajo_Legosoafipcod ;
   protected String gxTv_SdtLegajo_Legactcodigo ;
   protected String gxTv_SdtLegajo_Mprcod ;
   protected String gxTv_SdtLegajo_Zoncod ;
   protected String gxTv_SdtLegajo_Siniecodigo ;
   protected String gxTv_SdtLegajo_Legid ;
   protected String gxTv_SdtLegajo_Legconvecodigo ;
   protected String gxTv_SdtLegajo_Tipemplecod ;
   protected String gxTv_SdtLegajo_Osoc3992 ;
   protected String gxTv_SdtLegajo_Legcontinua ;
   protected String gxTv_SdtLegajo_Legreligion ;
   protected String gxTv_SdtLegajo_Legorigen ;
   protected String gxTv_SdtLegajo_Legpuescodigo ;
   protected String gxTv_SdtLegajo_Legsuccodigo ;
   protected String gxTv_SdtLegajo_Legtitulo ;
   protected String gxTv_SdtLegajo_Legpueaficod ;
   protected String gxTv_SdtLegajo_Legmodtra ;
   protected String gxTv_SdtLegajo_Legtipotarifa ;
   protected String gxTv_SdtLegajo_Mode ;
   protected String gxTv_SdtLegajo_Legfotoext_Z ;
   protected String gxTv_SdtLegajo_Legcodpos_Z ;
   protected String gxTv_SdtLegajo_Legmegcodigo_Z ;
   protected String gxTv_SdtLegajo_Legcatcodigo_Z ;
   protected String gxTv_SdtLegajo_Legseccodigo_Z ;
   protected String gxTv_SdtLegajo_Leglpgcodigo_Z ;
   protected String gxTv_SdtLegajo_Legbancod_Z ;
   protected String gxTv_SdtLegajo_Legbantipcuen_Z ;
   protected String gxTv_SdtLegajo_Legsincod_Z ;
   protected String gxTv_SdtLegajo_Legosocod_Z ;
   protected String gxTv_SdtLegajo_Legosoafipcod_Z ;
   protected String gxTv_SdtLegajo_Legactcodigo_Z ;
   protected String gxTv_SdtLegajo_Mprcod_Z ;
   protected String gxTv_SdtLegajo_Zoncod_Z ;
   protected String gxTv_SdtLegajo_Siniecodigo_Z ;
   protected String gxTv_SdtLegajo_Legid_Z ;
   protected String gxTv_SdtLegajo_Legconvecodigo_Z ;
   protected String gxTv_SdtLegajo_Tipemplecod_Z ;
   protected String gxTv_SdtLegajo_Osoc3992_Z ;
   protected String gxTv_SdtLegajo_Legcontinua_Z ;
   protected String gxTv_SdtLegajo_Legreligion_Z ;
   protected String gxTv_SdtLegajo_Legorigen_Z ;
   protected String gxTv_SdtLegajo_Legpuescodigo_Z ;
   protected String gxTv_SdtLegajo_Legsuccodigo_Z ;
   protected String gxTv_SdtLegajo_Legtitulo_Z ;
   protected String gxTv_SdtLegajo_Legpueaficod_Z ;
   protected String gxTv_SdtLegajo_Legmodtra_Z ;
   protected String gxTv_SdtLegajo_Legtipotarifa_Z ;
   protected boolean gxTv_SdtLegajo_Legconvenio ;
   protected boolean gxTv_SdtLegajo_Legscvo ;
   protected boolean gxTv_SdtLegajo_Legactivo ;
   protected boolean gxTv_SdtLegajo_Legagenreten ;
   protected boolean gxTv_SdtLegajo_Legrecalcliq ;
   protected boolean gxTv_SdtLegajo_Legjubilado ;
   protected boolean gxTv_SdtLegajo_Legtrablun ;
   protected boolean gxTv_SdtLegajo_Legtrabmar ;
   protected boolean gxTv_SdtLegajo_Legtrabmie ;
   protected boolean gxTv_SdtLegajo_Legtrabjue ;
   protected boolean gxTv_SdtLegajo_Legtrabvie ;
   protected boolean gxTv_SdtLegajo_Legtrabsa ;
   protected boolean gxTv_SdtLegajo_Legtrabdo ;
   protected boolean gxTv_SdtLegajo_Legincompleto ;
   protected boolean gxTv_SdtLegajo_Legliqapo ;
   protected boolean gxTv_SdtLegajo_Legconvenio_Z ;
   protected boolean gxTv_SdtLegajo_Legscvo_Z ;
   protected boolean gxTv_SdtLegajo_Legactivo_Z ;
   protected boolean gxTv_SdtLegajo_Legagenreten_Z ;
   protected boolean gxTv_SdtLegajo_Legrecalcliq_Z ;
   protected boolean gxTv_SdtLegajo_Legjubilado_Z ;
   protected boolean gxTv_SdtLegajo_Legtrablun_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabmar_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabmie_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabjue_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabvie_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabsa_Z ;
   protected boolean gxTv_SdtLegajo_Legtrabdo_Z ;
   protected boolean gxTv_SdtLegajo_Legincompleto_Z ;
   protected boolean gxTv_SdtLegajo_Legliqapo_Z ;
   protected String gxTv_SdtLegajo_Legobs ;
   protected String gxTv_SdtLegajo_Legmigrwarn ;
   protected String gxTv_SdtLegajo_Legfoto ;
   protected String gxTv_SdtLegajo_Empnom ;
   protected String gxTv_SdtLegajo_Legapellido ;
   protected String gxTv_SdtLegajo_Legnombre ;
   protected String gxTv_SdtLegajo_Legfotonom ;
   protected String gxTv_SdtLegajo_Legnumdoc ;
   protected String gxTv_SdtLegajo_Legnacionalidad ;
   protected String gxTv_SdtLegajo_Legdomici ;
   protected String gxTv_SdtLegajo_Legemail ;
   protected String gxTv_SdtLegajo_Legpainom ;
   protected String gxTv_SdtLegajo_Legprovnom ;
   protected String gxTv_SdtLegajo_Leglocnom ;
   protected String gxTv_SdtLegajo_Legtelefono ;
   protected String gxTv_SdtLegajo_Megdescrip ;
   protected String gxTv_SdtLegajo_Secdescrip ;
   protected String gxTv_SdtLegajo_Lpgdescri ;
   protected String gxTv_SdtLegajo_Legbandes ;
   protected String gxTv_SdtLegajo_Legbansuc ;
   protected String gxTv_SdtLegajo_Sindescrip ;
   protected String gxTv_SdtLegajo_Legosodes ;
   protected String gxTv_SdtLegajo_Osodescrip ;
   protected String gxTv_SdtLegajo_Legactdescri ;
   protected String gxTv_SdtLegajo_Mprdescrip ;
   protected String gxTv_SdtLegajo_Legcuentabanc ;
   protected String gxTv_SdtLegajo_Zondescrip ;
   protected String gxTv_SdtLegajo_Legcbu ;
   protected String gxTv_SdtLegajo_Condidescri ;
   protected String gxTv_SdtLegajo_Siniedescri ;
   protected String gxTv_SdtLegajo_Legidnomape ;
   protected String gxTv_SdtLegajo_Legnomape ;
   protected String gxTv_SdtLegajo_Legpromdias ;
   protected String gxTv_SdtLegajo_Empnom_Z ;
   protected String gxTv_SdtLegajo_Legapellido_Z ;
   protected String gxTv_SdtLegajo_Legnombre_Z ;
   protected String gxTv_SdtLegajo_Legfotonom_Z ;
   protected String gxTv_SdtLegajo_Legnumdoc_Z ;
   protected String gxTv_SdtLegajo_Legnacionalidad_Z ;
   protected String gxTv_SdtLegajo_Legdomici_Z ;
   protected String gxTv_SdtLegajo_Legemail_Z ;
   protected String gxTv_SdtLegajo_Legpainom_Z ;
   protected String gxTv_SdtLegajo_Legprovnom_Z ;
   protected String gxTv_SdtLegajo_Leglocnom_Z ;
   protected String gxTv_SdtLegajo_Legtelefono_Z ;
   protected String gxTv_SdtLegajo_Megdescrip_Z ;
   protected String gxTv_SdtLegajo_Secdescrip_Z ;
   protected String gxTv_SdtLegajo_Lpgdescri_Z ;
   protected String gxTv_SdtLegajo_Legbandes_Z ;
   protected String gxTv_SdtLegajo_Legbansuc_Z ;
   protected String gxTv_SdtLegajo_Sindescrip_Z ;
   protected String gxTv_SdtLegajo_Legosodes_Z ;
   protected String gxTv_SdtLegajo_Osodescrip_Z ;
   protected String gxTv_SdtLegajo_Legactdescri_Z ;
   protected String gxTv_SdtLegajo_Mprdescrip_Z ;
   protected String gxTv_SdtLegajo_Legcuentabanc_Z ;
   protected String gxTv_SdtLegajo_Zondescrip_Z ;
   protected String gxTv_SdtLegajo_Legcbu_Z ;
   protected String gxTv_SdtLegajo_Condidescri_Z ;
   protected String gxTv_SdtLegajo_Siniedescri_Z ;
   protected String gxTv_SdtLegajo_Legidnomape_Z ;
   protected String gxTv_SdtLegajo_Legnomape_Z ;
   protected String gxTv_SdtLegajo_Legpromdias_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecnac ;
   protected java.util.Date gxTv_SdtLegajo_Legfecingreso ;
   protected java.util.Date gxTv_SdtLegajo_Legfecegreso ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Legbasico ;
   protected java.util.Date gxTv_SdtLegajo_Legfecultmod ;
   protected java.util.Date gxTv_SdtLegajo_Leglicinicio ;
   protected java.util.Date gxTv_SdtLegajo_Leglicfinal ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Zonporcreduc ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Legsueldofuera ;
   protected java.util.Date gxTv_SdtLegajo_Legfecimportacion ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Leghorasdia ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Leghorassem ;
   protected java.util.Date gxTv_SdtLegajo_Legfecpreaviso ;
   protected java.util.Date gxTv_SdtLegajo_Legfecnac_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecingreso_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecegreso_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Legbasico_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecultmod_Z ;
   protected java.util.Date gxTv_SdtLegajo_Leglicinicio_Z ;
   protected java.util.Date gxTv_SdtLegajo_Leglicfinal_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Zonporcreduc_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Legsueldofuera_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecimportacion_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Leghorasdia_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Leghorassem_Z ;
   protected java.util.Date gxTv_SdtLegajo_Legfecpreaviso_Z ;
   protected java.util.Vector<web.StructSdtLegajo_Salario> gxTv_SdtLegajo_Salario=null ;
   protected java.util.Vector<web.StructSdtLegajo_Familia> gxTv_SdtLegajo_Familia=null ;
   protected java.util.Vector<web.StructSdtLegajo_tipos_de_trabajo> gxTv_SdtLegajo_Tipos_de_trabajo=null ;
   protected java.util.Vector<web.StructSdtLegajo_Propiedades> gxTv_SdtLegajo_Propiedades=null ;
}

