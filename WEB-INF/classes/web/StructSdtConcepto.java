package web ;
import com.genexus.*;

public final  class StructSdtConcepto implements Cloneable, java.io.Serializable
{
   public StructSdtConcepto( )
   {
      this( -1, new ModelContext( StructSdtConcepto.class ));
   }

   public StructSdtConcepto( int remoteHandle ,
                             ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtConcepto_Concodigo = "" ;
      gxTv_SdtConcepto_Condescrip = "" ;
      gxTv_SdtConcepto_Conformula = "" ;
      gxTv_SdtConcepto_Conformulapreresuelta = "" ;
      gxTv_SdtConcepto_Convalorgen = new java.math.BigDecimal(0) ;
      gxTv_SdtConcepto_Contipoliqganancias = "" ;
      gxTv_SdtConcepto_Conobservacion = "" ;
      gxTv_SdtConcepto_Conhisformula = "" ;
      gxTv_SdtConcepto_Conusumodfor = "" ;
      gxTv_SdtConcepto_Confchmodfor = cal.getTime() ;
      gxTv_SdtConcepto_Conformulaabr = "" ;
      gxTv_SdtConcepto_Concodydesc = "" ;
      gxTv_SdtConcepto_Tipoconcod = "" ;
      gxTv_SdtConcepto_Subtipoconcod1 = "" ;
      gxTv_SdtConcepto_Subtipoconcod2 = "" ;
      gxTv_SdtConcepto_Concodold = "" ;
      gxTv_SdtConcepto_Concuendebe = "" ;
      gxTv_SdtConcepto_Concuenhaber = "" ;
      gxTv_SdtConcepto_Contipoliqaux = "" ;
      gxTv_SdtConcepto_Conconveaux = "" ;
      gxTv_SdtConcepto_Conclasifaux = "" ;
      gxTv_SdtConcepto_Conformulaexpl = "" ;
      gxTv_SdtConcepto_Conformulaobs2 = "" ;
      gxTv_SdtConcepto_Conrangocant = "" ;
      gxTv_SdtConcepto_Concondicion = "" ;
      gxTv_SdtConcepto_Concondcodigo = "" ;
      gxTv_SdtConcepto_Conprereq = "" ;
      gxTv_SdtConcepto_Conceptoconvecodigo = "" ;
      gxTv_SdtConcepto_Concodafip = "" ;
      gxTv_SdtConcepto_Conpadre = "" ;
      gxTv_SdtConcepto_Conoldvalues = "" ;
      gxTv_SdtConcepto_Conrelref = "" ;
      gxTv_SdtConcepto_Condescripsinac = "" ;
      gxTv_SdtConcepto_Conoblpalabra = "" ;
      gxTv_SdtConcepto_Mode = "" ;
      gxTv_SdtConcepto_Concodigo_Z = "" ;
      gxTv_SdtConcepto_Condescrip_Z = "" ;
      gxTv_SdtConcepto_Convalorgen_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtConcepto_Contipoliqganancias_Z = "" ;
      gxTv_SdtConcepto_Conusumodfor_Z = "" ;
      gxTv_SdtConcepto_Confchmodfor_Z = cal.getTime() ;
      gxTv_SdtConcepto_Conformulaabr_Z = "" ;
      gxTv_SdtConcepto_Concodydesc_Z = "" ;
      gxTv_SdtConcepto_Tipoconcod_Z = "" ;
      gxTv_SdtConcepto_Subtipoconcod1_Z = "" ;
      gxTv_SdtConcepto_Subtipoconcod2_Z = "" ;
      gxTv_SdtConcepto_Concodold_Z = "" ;
      gxTv_SdtConcepto_Concuendebe_Z = "" ;
      gxTv_SdtConcepto_Concuenhaber_Z = "" ;
      gxTv_SdtConcepto_Contipoliqaux_Z = "" ;
      gxTv_SdtConcepto_Conconveaux_Z = "" ;
      gxTv_SdtConcepto_Conclasifaux_Z = "" ;
      gxTv_SdtConcepto_Conrangocant_Z = "" ;
      gxTv_SdtConcepto_Concondicion_Z = "" ;
      gxTv_SdtConcepto_Concondcodigo_Z = "" ;
      gxTv_SdtConcepto_Conprereq_Z = "" ;
      gxTv_SdtConcepto_Conceptoconvecodigo_Z = "" ;
      gxTv_SdtConcepto_Concodafip_Z = "" ;
      gxTv_SdtConcepto_Conpadre_Z = "" ;
      gxTv_SdtConcepto_Conrelref_Z = "" ;
      gxTv_SdtConcepto_Condescripsinac_Z = "" ;
      gxTv_SdtConcepto_Conoblpalabra_Z = "" ;
      gxTv_SdtConcepto_Conformula_N = (byte)(1) ;
      gxTv_SdtConcepto_Convalorgen_N = (byte)(1) ;
      gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(1) ;
      gxTv_SdtConcepto_Conhisformula_N = (byte)(1) ;
      gxTv_SdtConcepto_Conusumodfor_N = (byte)(1) ;
      gxTv_SdtConcepto_Confchmodfor_N = (byte)(1) ;
      gxTv_SdtConcepto_Concodydesc_N = (byte)(1) ;
      gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(1) ;
      gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(1) ;
      gxTv_SdtConcepto_Concuendebe_N = (byte)(1) ;
      gxTv_SdtConcepto_Concuenhaber_N = (byte)(1) ;
      gxTv_SdtConcepto_Contipoliqaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Conconveaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Conclasifaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Conaplicgan_N = (byte)(1) ;
      gxTv_SdtConcepto_Conobliga_N = (byte)(1) ;
      gxTv_SdtConcepto_Conobligasisac_N = (byte)(1) ;
      gxTv_SdtConcepto_Concondicion_N = (byte)(1) ;
      gxTv_SdtConcepto_Conprereq_N = (byte)(1) ;
      gxTv_SdtConcepto_Conadeldescu_N = (byte)(1) ;
      gxTv_SdtConcepto_Apliigg_N = (byte)(1) ;
      gxTv_SdtConcepto_Conceptopais_N = (byte)(1) ;
      gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(1) ;
      gxTv_SdtConcepto_Clipadre_N = (byte)(1) ;
      gxTv_SdtConcepto_Conpadre_N = (byte)(1) ;
      gxTv_SdtConcepto_Conoblpalabra_N = (byte)(1) ;
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
      return gxTv_SdtConcepto_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Clicod = value ;
   }

   public String getConcodigo( )
   {
      return gxTv_SdtConcepto_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodigo = value ;
   }

   public String getCondescrip( )
   {
      return gxTv_SdtConcepto_Condescrip ;
   }

   public void setCondescrip( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Condescrip = value ;
   }

   public boolean getConhabilitado( )
   {
      return gxTv_SdtConcepto_Conhabilitado ;
   }

   public void setConhabilitado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conhabilitado = value ;
   }

   public int getConorden( )
   {
      return gxTv_SdtConcepto_Conorden ;
   }

   public void setConorden( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conorden = value ;
   }

   public boolean getConcanti( )
   {
      return gxTv_SdtConcepto_Concanti ;
   }

   public void setConcanti( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concanti = value ;
   }

   public boolean getConvaluni( )
   {
      return gxTv_SdtConcepto_Convaluni ;
   }

   public void setConvaluni( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convaluni = value ;
   }

   public boolean getConimporte( )
   {
      return gxTv_SdtConcepto_Conimporte ;
   }

   public void setConimporte( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conimporte = value ;
   }

   public byte getConvigencia( )
   {
      return gxTv_SdtConcepto_Convigencia ;
   }

   public void setConvigencia( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convigencia = value ;
   }

   public byte getConliqbasica( )
   {
      return gxTv_SdtConcepto_Conliqbasica ;
   }

   public void setConliqbasica( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conliqbasica = value ;
   }

   public String getConformula( )
   {
      return gxTv_SdtConcepto_Conformula ;
   }

   public void setConformula( String value )
   {
      gxTv_SdtConcepto_Conformula_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformula = value ;
   }

   public String getConformulapreresuelta( )
   {
      return gxTv_SdtConcepto_Conformulapreresuelta ;
   }

   public void setConformulapreresuelta( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformulapreresuelta = value ;
   }

   public java.math.BigDecimal getConvalorgen( )
   {
      return gxTv_SdtConcepto_Convalorgen ;
   }

   public void setConvalorgen( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_Convalorgen_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convalorgen = value ;
   }

   public String getContipoliqganancias( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias ;
   }

   public void setContipoliqganancias( String value )
   {
      gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqganancias = value ;
   }

   public String getConobservacion( )
   {
      return gxTv_SdtConcepto_Conobservacion ;
   }

   public void setConobservacion( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobservacion = value ;
   }

   public boolean getConvariable( )
   {
      return gxTv_SdtConcepto_Convariable ;
   }

   public void setConvariable( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convariable = value ;
   }

   public String getConhisformula( )
   {
      return gxTv_SdtConcepto_Conhisformula ;
   }

   public void setConhisformula( String value )
   {
      gxTv_SdtConcepto_Conhisformula_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conhisformula = value ;
   }

   public String getConusumodfor( )
   {
      return gxTv_SdtConcepto_Conusumodfor ;
   }

   public void setConusumodfor( String value )
   {
      gxTv_SdtConcepto_Conusumodfor_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conusumodfor = value ;
   }

   public java.util.Date getConfchmodfor( )
   {
      return gxTv_SdtConcepto_Confchmodfor ;
   }

   public void setConfchmodfor( java.util.Date value )
   {
      gxTv_SdtConcepto_Confchmodfor_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confchmodfor = value ;
   }

   public String getConformulaabr( )
   {
      return gxTv_SdtConcepto_Conformulaabr ;
   }

   public void setConformulaabr( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformulaabr = value ;
   }

   public String getConcodydesc( )
   {
      return gxTv_SdtConcepto_Concodydesc ;
   }

   public void setConcodydesc( String value )
   {
      gxTv_SdtConcepto_Concodydesc_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodydesc = value ;
   }

   public String getTipoconcod( )
   {
      return gxTv_SdtConcepto_Tipoconcod ;
   }

   public void setTipoconcod( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Tipoconcod = value ;
   }

   public String getSubtipoconcod1( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1 ;
   }

   public void setSubtipoconcod1( String value )
   {
      gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod1 = value ;
   }

   public String getSubtipoconcod2( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2 ;
   }

   public void setSubtipoconcod2( String value )
   {
      gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod2 = value ;
   }

   public byte getContipo( )
   {
      return gxTv_SdtConcepto_Contipo ;
   }

   public void setContipo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipo = value ;
   }

   public String getConcodold( )
   {
      return gxTv_SdtConcepto_Concodold ;
   }

   public void setConcodold( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodold = value ;
   }

   public String getConcuendebe( )
   {
      return gxTv_SdtConcepto_Concuendebe ;
   }

   public void setConcuendebe( String value )
   {
      gxTv_SdtConcepto_Concuendebe_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuendebe = value ;
   }

   public String getConcuenhaber( )
   {
      return gxTv_SdtConcepto_Concuenhaber ;
   }

   public void setConcuenhaber( String value )
   {
      gxTv_SdtConcepto_Concuenhaber_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuenhaber = value ;
   }

   public String getContipoliqaux( )
   {
      return gxTv_SdtConcepto_Contipoliqaux ;
   }

   public void setContipoliqaux( String value )
   {
      gxTv_SdtConcepto_Contipoliqaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqaux = value ;
   }

   public String getConconveaux( )
   {
      return gxTv_SdtConcepto_Conconveaux ;
   }

   public void setConconveaux( String value )
   {
      gxTv_SdtConcepto_Conconveaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conconveaux = value ;
   }

   public String getConclasifaux( )
   {
      return gxTv_SdtConcepto_Conclasifaux ;
   }

   public void setConclasifaux( String value )
   {
      gxTv_SdtConcepto_Conclasifaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conclasifaux = value ;
   }

   public long getConordejec( )
   {
      return gxTv_SdtConcepto_Conordejec ;
   }

   public void setConordejec( long value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conordejec = value ;
   }

   public String getConformulaexpl( )
   {
      return gxTv_SdtConcepto_Conformulaexpl ;
   }

   public void setConformulaexpl( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformulaexpl = value ;
   }

   public String getConformulaobs2( )
   {
      return gxTv_SdtConcepto_Conformulaobs2 ;
   }

   public void setConformulaobs2( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformulaobs2 = value ;
   }

   public boolean getConretganpropor( )
   {
      return gxTv_SdtConcepto_Conretganpropor ;
   }

   public void setConretganpropor( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conretganpropor = value ;
   }

   public byte getConaplicgan( )
   {
      return gxTv_SdtConcepto_Conaplicgan ;
   }

   public void setConaplicgan( byte value )
   {
      gxTv_SdtConcepto_Conaplicgan_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conaplicgan = value ;
   }

   public boolean getConrecalcular( )
   {
      return gxTv_SdtConcepto_Conrecalcular ;
   }

   public void setConrecalcular( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrecalcular = value ;
   }

   public boolean getConimportado( )
   {
      return gxTv_SdtConcepto_Conimportado ;
   }

   public void setConimportado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conimportado = value ;
   }

   public short getContipoorden( )
   {
      return gxTv_SdtConcepto_Contipoorden ;
   }

   public void setContipoorden( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoorden = value ;
   }

   public boolean getConedienrec( )
   {
      return gxTv_SdtConcepto_Conedienrec ;
   }

   public void setConedienrec( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conedienrec = value ;
   }

   public String getConrangocant( )
   {
      return gxTv_SdtConcepto_Conrangocant ;
   }

   public void setConrangocant( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrangocant = value ;
   }

   public java.util.Vector<web.StructSdtConcepto_TipoLiquidacion> getTipoliquidacion( )
   {
      return gxTv_SdtConcepto_Tipoliquidacion ;
   }

   public void setTipoliquidacion( java.util.Vector<web.StructSdtConcepto_TipoLiquidacion> value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Tipoliquidacion = value ;
   }

   public boolean getConusado( )
   {
      return gxTv_SdtConcepto_Conusado ;
   }

   public void setConusado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conusado = value ;
   }

   public boolean getConobliga( )
   {
      return gxTv_SdtConcepto_Conobliga ;
   }

   public void setConobliga( boolean value )
   {
      gxTv_SdtConcepto_Conobliga_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobliga = value ;
   }

   public boolean getConobligasisac( )
   {
      return gxTv_SdtConcepto_Conobligasisac ;
   }

   public void setConobligasisac( boolean value )
   {
      gxTv_SdtConcepto_Conobligasisac_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobligasisac = value ;
   }

   public String getConcondicion( )
   {
      return gxTv_SdtConcepto_Concondicion ;
   }

   public void setConcondicion( String value )
   {
      gxTv_SdtConcepto_Concondicion_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concondicion = value ;
   }

   public String getConcondcodigo( )
   {
      return gxTv_SdtConcepto_Concondcodigo ;
   }

   public void setConcondcodigo( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concondcodigo = value ;
   }

   public String getConprereq( )
   {
      return gxTv_SdtConcepto_Conprereq ;
   }

   public void setConprereq( String value )
   {
      gxTv_SdtConcepto_Conprereq_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conprereq = value ;
   }

   public boolean getConmostrarpos( )
   {
      return gxTv_SdtConcepto_Conmostrarpos ;
   }

   public void setConmostrarpos( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conmostrarpos = value ;
   }

   public byte getConadeldescu( )
   {
      return gxTv_SdtConcepto_Conadeldescu ;
   }

   public void setConadeldescu( byte value )
   {
      gxTv_SdtConcepto_Conadeldescu_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conadeldescu = value ;
   }

   public short getApliigg( )
   {
      return gxTv_SdtConcepto_Apliigg ;
   }

   public void setApliigg( short value )
   {
      gxTv_SdtConcepto_Apliigg_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Apliigg = value ;
   }

   public boolean getConsegunpla( )
   {
      return gxTv_SdtConcepto_Consegunpla ;
   }

   public void setConsegunpla( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consegunpla = value ;
   }

   public byte getConnumero( )
   {
      return gxTv_SdtConcepto_Connumero ;
   }

   public void setConnumero( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Connumero = value ;
   }

   public byte getConsipaapo( )
   {
      return gxTv_SdtConcepto_Consipaapo ;
   }

   public void setConsipaapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consipaapo = value ;
   }

   public byte getConsipacont( )
   {
      return gxTv_SdtConcepto_Consipacont ;
   }

   public void setConsipacont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consipacont = value ;
   }

   public byte getConinssjypapo( )
   {
      return gxTv_SdtConcepto_Coninssjypapo ;
   }

   public void setConinssjypapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Coninssjypapo = value ;
   }

   public byte getConinssjypcont( )
   {
      return gxTv_SdtConcepto_Coninssjypcont ;
   }

   public void setConinssjypcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Coninssjypcont = value ;
   }

   public byte getConobrasocapo( )
   {
      return gxTv_SdtConcepto_Conobrasocapo ;
   }

   public void setConobrasocapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobrasocapo = value ;
   }

   public byte getConobrasoccont( )
   {
      return gxTv_SdtConcepto_Conobrasoccont ;
   }

   public void setConobrasoccont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobrasoccont = value ;
   }

   public java.util.Vector<web.StructSdtConcepto_MotivosEgreso> getMotivosegreso( )
   {
      return gxTv_SdtConcepto_Motivosegreso ;
   }

   public void setMotivosegreso( java.util.Vector<web.StructSdtConcepto_MotivosEgreso> value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Motivosegreso = value ;
   }

   public byte getConfonsolredapo( )
   {
      return gxTv_SdtConcepto_Confonsolredapo ;
   }

   public void setConfonsolredapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonsolredapo = value ;
   }

   public byte getConfonsolredcont( )
   {
      return gxTv_SdtConcepto_Confonsolredcont ;
   }

   public void setConfonsolredcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonsolredcont = value ;
   }

   public byte getConrenateaapo( )
   {
      return gxTv_SdtConcepto_Conrenateaapo ;
   }

   public void setConrenateaapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrenateaapo = value ;
   }

   public byte getConrenateacont( )
   {
      return gxTv_SdtConcepto_Conrenateacont ;
   }

   public void setConrenateacont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrenateacont = value ;
   }

   public byte getConasigfamcont( )
   {
      return gxTv_SdtConcepto_Conasigfamcont ;
   }

   public void setConasigfamcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conasigfamcont = value ;
   }

   public byte getConfonnacempcont( )
   {
      return gxTv_SdtConcepto_Confonnacempcont ;
   }

   public void setConfonnacempcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonnacempcont = value ;
   }

   public byte getConleyrietrabcont( )
   {
      return gxTv_SdtConcepto_Conleyrietrabcont ;
   }

   public void setConleyrietrabcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conleyrietrabcont = value ;
   }

   public byte getConregdifapo( )
   {
      return gxTv_SdtConcepto_Conregdifapo ;
   }

   public void setConregdifapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conregdifapo = value ;
   }

   public byte getConregespapo( )
   {
      return gxTv_SdtConcepto_Conregespapo ;
   }

   public void setConregespapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conregespapo = value ;
   }

   public byte getConsacdeven( )
   {
      return gxTv_SdtConcepto_Consacdeven ;
   }

   public void setConsacdeven( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consacdeven = value ;
   }

   public byte getConbaselic( )
   {
      return gxTv_SdtConcepto_Conbaselic ;
   }

   public void setConbaselic( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaselic = value ;
   }

   public byte getConbaselicprom( )
   {
      return gxTv_SdtConcepto_Conbaselicprom ;
   }

   public void setConbaselicprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaselicprom = value ;
   }

   public byte getConbasefer( )
   {
      return gxTv_SdtConcepto_Conbasefer ;
   }

   public void setConbasefer( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasefer = value ;
   }

   public byte getConbaseferprom( )
   {
      return gxTv_SdtConcepto_Conbaseferprom ;
   }

   public void setConbaseferprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseferprom = value ;
   }

   public byte getConbasehorext( )
   {
      return gxTv_SdtConcepto_Conbasehorext ;
   }

   public void setConbasehorext( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasehorext = value ;
   }

   public byte getConbasehorextprom( )
   {
      return gxTv_SdtConcepto_Conbasehorextprom ;
   }

   public void setConbasehorextprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasehorextprom = value ;
   }

   public byte getConbasepres( )
   {
      return gxTv_SdtConcepto_Conbasepres ;
   }

   public void setConbasepres( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasepres = value ;
   }

   public byte getConbaseant( )
   {
      return gxTv_SdtConcepto_Conbaseant ;
   }

   public void setConbaseant( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseant = value ;
   }

   public byte getConbaseosdif( )
   {
      return gxTv_SdtConcepto_Conbaseosdif ;
   }

   public void setConbaseosdif( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseosdif = value ;
   }

   public byte getConbaseaus( )
   {
      return gxTv_SdtConcepto_Conbaseaus ;
   }

   public void setConbaseaus( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseaus = value ;
   }

   public byte getConbaseausprom( )
   {
      return gxTv_SdtConcepto_Conbaseausprom ;
   }

   public void setConbaseausprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseausprom = value ;
   }

   public short getConceptopais( )
   {
      return gxTv_SdtConcepto_Conceptopais ;
   }

   public void setConceptopais( short value )
   {
      gxTv_SdtConcepto_Conceptopais_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptopais = value ;
   }

   public String getConceptoconvecodigo( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo ;
   }

   public void setConceptoconvecodigo( String value )
   {
      gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptoconvecodigo = value ;
   }

   public String getConcodafip( )
   {
      return gxTv_SdtConcepto_Concodafip ;
   }

   public void setConcodafip( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodafip = value ;
   }

   public byte getConcntpa( )
   {
      return gxTv_SdtConcepto_Concntpa ;
   }

   public void setConcntpa( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concntpa = value ;
   }

   public boolean getConerrorsicero( )
   {
      return gxTv_SdtConcepto_Conerrorsicero ;
   }

   public void setConerrorsicero( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conerrorsicero = value ;
   }

   public int getClipadre( )
   {
      return gxTv_SdtConcepto_Clipadre ;
   }

   public void setClipadre( int value )
   {
      gxTv_SdtConcepto_Clipadre_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Clipadre = value ;
   }

   public String getConpadre( )
   {
      return gxTv_SdtConcepto_Conpadre ;
   }

   public void setConpadre( String value )
   {
      gxTv_SdtConcepto_Conpadre_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conpadre = value ;
   }

   public boolean getConpuenov( )
   {
      return gxTv_SdtConcepto_Conpuenov ;
   }

   public void setConpuenov( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conpuenov = value ;
   }

   public int getConrelsec( )
   {
      return gxTv_SdtConcepto_Conrelsec ;
   }

   public void setConrelsec( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelsec = value ;
   }

   public int getConrelseccli( )
   {
      return gxTv_SdtConcepto_Conrelseccli ;
   }

   public void setConrelseccli( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelseccli = value ;
   }

   public String getConoldvalues( )
   {
      return gxTv_SdtConcepto_Conoldvalues ;
   }

   public void setConoldvalues( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conoldvalues = value ;
   }

   public String getConrelref( )
   {
      return gxTv_SdtConcepto_Conrelref ;
   }

   public void setConrelref( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelref = value ;
   }

   public String getCondescripsinac( )
   {
      return gxTv_SdtConcepto_Condescripsinac ;
   }

   public void setCondescripsinac( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Condescripsinac = value ;
   }

   public String getConoblpalabra( )
   {
      return gxTv_SdtConcepto_Conoblpalabra ;
   }

   public void setConoblpalabra( String value )
   {
      gxTv_SdtConcepto_Conoblpalabra_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conoblpalabra = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConcepto_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConcepto_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtConcepto_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Clicod_Z = value ;
   }

   public String getConcodigo_Z( )
   {
      return gxTv_SdtConcepto_Concodigo_Z ;
   }

   public void setConcodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodigo_Z = value ;
   }

   public String getCondescrip_Z( )
   {
      return gxTv_SdtConcepto_Condescrip_Z ;
   }

   public void setCondescrip_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Condescrip_Z = value ;
   }

   public boolean getConhabilitado_Z( )
   {
      return gxTv_SdtConcepto_Conhabilitado_Z ;
   }

   public void setConhabilitado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conhabilitado_Z = value ;
   }

   public int getConorden_Z( )
   {
      return gxTv_SdtConcepto_Conorden_Z ;
   }

   public void setConorden_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conorden_Z = value ;
   }

   public boolean getConcanti_Z( )
   {
      return gxTv_SdtConcepto_Concanti_Z ;
   }

   public void setConcanti_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concanti_Z = value ;
   }

   public boolean getConvaluni_Z( )
   {
      return gxTv_SdtConcepto_Convaluni_Z ;
   }

   public void setConvaluni_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convaluni_Z = value ;
   }

   public boolean getConimporte_Z( )
   {
      return gxTv_SdtConcepto_Conimporte_Z ;
   }

   public void setConimporte_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conimporte_Z = value ;
   }

   public byte getConvigencia_Z( )
   {
      return gxTv_SdtConcepto_Convigencia_Z ;
   }

   public void setConvigencia_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convigencia_Z = value ;
   }

   public byte getConliqbasica_Z( )
   {
      return gxTv_SdtConcepto_Conliqbasica_Z ;
   }

   public void setConliqbasica_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conliqbasica_Z = value ;
   }

   public java.math.BigDecimal getConvalorgen_Z( )
   {
      return gxTv_SdtConcepto_Convalorgen_Z ;
   }

   public void setConvalorgen_Z( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convalorgen_Z = value ;
   }

   public String getContipoliqganancias_Z( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias_Z ;
   }

   public void setContipoliqganancias_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqganancias_Z = value ;
   }

   public boolean getConvariable_Z( )
   {
      return gxTv_SdtConcepto_Convariable_Z ;
   }

   public void setConvariable_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convariable_Z = value ;
   }

   public String getConusumodfor_Z( )
   {
      return gxTv_SdtConcepto_Conusumodfor_Z ;
   }

   public void setConusumodfor_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conusumodfor_Z = value ;
   }

   public java.util.Date getConfchmodfor_Z( )
   {
      return gxTv_SdtConcepto_Confchmodfor_Z ;
   }

   public void setConfchmodfor_Z( java.util.Date value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confchmodfor_Z = value ;
   }

   public String getConformulaabr_Z( )
   {
      return gxTv_SdtConcepto_Conformulaabr_Z ;
   }

   public void setConformulaabr_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformulaabr_Z = value ;
   }

   public String getConcodydesc_Z( )
   {
      return gxTv_SdtConcepto_Concodydesc_Z ;
   }

   public void setConcodydesc_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodydesc_Z = value ;
   }

   public String getTipoconcod_Z( )
   {
      return gxTv_SdtConcepto_Tipoconcod_Z ;
   }

   public void setTipoconcod_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Tipoconcod_Z = value ;
   }

   public String getSubtipoconcod1_Z( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1_Z ;
   }

   public void setSubtipoconcod1_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod1_Z = value ;
   }

   public String getSubtipoconcod2_Z( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2_Z ;
   }

   public void setSubtipoconcod2_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod2_Z = value ;
   }

   public byte getContipo_Z( )
   {
      return gxTv_SdtConcepto_Contipo_Z ;
   }

   public void setContipo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipo_Z = value ;
   }

   public String getConcodold_Z( )
   {
      return gxTv_SdtConcepto_Concodold_Z ;
   }

   public void setConcodold_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodold_Z = value ;
   }

   public String getConcuendebe_Z( )
   {
      return gxTv_SdtConcepto_Concuendebe_Z ;
   }

   public void setConcuendebe_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuendebe_Z = value ;
   }

   public String getConcuenhaber_Z( )
   {
      return gxTv_SdtConcepto_Concuenhaber_Z ;
   }

   public void setConcuenhaber_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuenhaber_Z = value ;
   }

   public String getContipoliqaux_Z( )
   {
      return gxTv_SdtConcepto_Contipoliqaux_Z ;
   }

   public void setContipoliqaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqaux_Z = value ;
   }

   public String getConconveaux_Z( )
   {
      return gxTv_SdtConcepto_Conconveaux_Z ;
   }

   public void setConconveaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conconveaux_Z = value ;
   }

   public String getConclasifaux_Z( )
   {
      return gxTv_SdtConcepto_Conclasifaux_Z ;
   }

   public void setConclasifaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conclasifaux_Z = value ;
   }

   public long getConordejec_Z( )
   {
      return gxTv_SdtConcepto_Conordejec_Z ;
   }

   public void setConordejec_Z( long value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conordejec_Z = value ;
   }

   public boolean getConretganpropor_Z( )
   {
      return gxTv_SdtConcepto_Conretganpropor_Z ;
   }

   public void setConretganpropor_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conretganpropor_Z = value ;
   }

   public byte getConaplicgan_Z( )
   {
      return gxTv_SdtConcepto_Conaplicgan_Z ;
   }

   public void setConaplicgan_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conaplicgan_Z = value ;
   }

   public boolean getConrecalcular_Z( )
   {
      return gxTv_SdtConcepto_Conrecalcular_Z ;
   }

   public void setConrecalcular_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrecalcular_Z = value ;
   }

   public boolean getConimportado_Z( )
   {
      return gxTv_SdtConcepto_Conimportado_Z ;
   }

   public void setConimportado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conimportado_Z = value ;
   }

   public short getContipoorden_Z( )
   {
      return gxTv_SdtConcepto_Contipoorden_Z ;
   }

   public void setContipoorden_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoorden_Z = value ;
   }

   public boolean getConedienrec_Z( )
   {
      return gxTv_SdtConcepto_Conedienrec_Z ;
   }

   public void setConedienrec_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conedienrec_Z = value ;
   }

   public String getConrangocant_Z( )
   {
      return gxTv_SdtConcepto_Conrangocant_Z ;
   }

   public void setConrangocant_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrangocant_Z = value ;
   }

   public boolean getConusado_Z( )
   {
      return gxTv_SdtConcepto_Conusado_Z ;
   }

   public void setConusado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conusado_Z = value ;
   }

   public boolean getConobliga_Z( )
   {
      return gxTv_SdtConcepto_Conobliga_Z ;
   }

   public void setConobliga_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobliga_Z = value ;
   }

   public boolean getConobligasisac_Z( )
   {
      return gxTv_SdtConcepto_Conobligasisac_Z ;
   }

   public void setConobligasisac_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobligasisac_Z = value ;
   }

   public String getConcondicion_Z( )
   {
      return gxTv_SdtConcepto_Concondicion_Z ;
   }

   public void setConcondicion_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concondicion_Z = value ;
   }

   public String getConcondcodigo_Z( )
   {
      return gxTv_SdtConcepto_Concondcodigo_Z ;
   }

   public void setConcondcodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concondcodigo_Z = value ;
   }

   public String getConprereq_Z( )
   {
      return gxTv_SdtConcepto_Conprereq_Z ;
   }

   public void setConprereq_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conprereq_Z = value ;
   }

   public boolean getConmostrarpos_Z( )
   {
      return gxTv_SdtConcepto_Conmostrarpos_Z ;
   }

   public void setConmostrarpos_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conmostrarpos_Z = value ;
   }

   public byte getConadeldescu_Z( )
   {
      return gxTv_SdtConcepto_Conadeldescu_Z ;
   }

   public void setConadeldescu_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conadeldescu_Z = value ;
   }

   public short getApliigg_Z( )
   {
      return gxTv_SdtConcepto_Apliigg_Z ;
   }

   public void setApliigg_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Apliigg_Z = value ;
   }

   public boolean getConsegunpla_Z( )
   {
      return gxTv_SdtConcepto_Consegunpla_Z ;
   }

   public void setConsegunpla_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consegunpla_Z = value ;
   }

   public byte getConnumero_Z( )
   {
      return gxTv_SdtConcepto_Connumero_Z ;
   }

   public void setConnumero_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Connumero_Z = value ;
   }

   public byte getConsipaapo_Z( )
   {
      return gxTv_SdtConcepto_Consipaapo_Z ;
   }

   public void setConsipaapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consipaapo_Z = value ;
   }

   public byte getConsipacont_Z( )
   {
      return gxTv_SdtConcepto_Consipacont_Z ;
   }

   public void setConsipacont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consipacont_Z = value ;
   }

   public byte getConinssjypapo_Z( )
   {
      return gxTv_SdtConcepto_Coninssjypapo_Z ;
   }

   public void setConinssjypapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Coninssjypapo_Z = value ;
   }

   public byte getConinssjypcont_Z( )
   {
      return gxTv_SdtConcepto_Coninssjypcont_Z ;
   }

   public void setConinssjypcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Coninssjypcont_Z = value ;
   }

   public byte getConobrasocapo_Z( )
   {
      return gxTv_SdtConcepto_Conobrasocapo_Z ;
   }

   public void setConobrasocapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobrasocapo_Z = value ;
   }

   public byte getConobrasoccont_Z( )
   {
      return gxTv_SdtConcepto_Conobrasoccont_Z ;
   }

   public void setConobrasoccont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobrasoccont_Z = value ;
   }

   public byte getConfonsolredapo_Z( )
   {
      return gxTv_SdtConcepto_Confonsolredapo_Z ;
   }

   public void setConfonsolredapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonsolredapo_Z = value ;
   }

   public byte getConfonsolredcont_Z( )
   {
      return gxTv_SdtConcepto_Confonsolredcont_Z ;
   }

   public void setConfonsolredcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonsolredcont_Z = value ;
   }

   public byte getConrenateaapo_Z( )
   {
      return gxTv_SdtConcepto_Conrenateaapo_Z ;
   }

   public void setConrenateaapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrenateaapo_Z = value ;
   }

   public byte getConrenateacont_Z( )
   {
      return gxTv_SdtConcepto_Conrenateacont_Z ;
   }

   public void setConrenateacont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrenateacont_Z = value ;
   }

   public byte getConasigfamcont_Z( )
   {
      return gxTv_SdtConcepto_Conasigfamcont_Z ;
   }

   public void setConasigfamcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conasigfamcont_Z = value ;
   }

   public byte getConfonnacempcont_Z( )
   {
      return gxTv_SdtConcepto_Confonnacempcont_Z ;
   }

   public void setConfonnacempcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confonnacempcont_Z = value ;
   }

   public byte getConleyrietrabcont_Z( )
   {
      return gxTv_SdtConcepto_Conleyrietrabcont_Z ;
   }

   public void setConleyrietrabcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conleyrietrabcont_Z = value ;
   }

   public byte getConregdifapo_Z( )
   {
      return gxTv_SdtConcepto_Conregdifapo_Z ;
   }

   public void setConregdifapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conregdifapo_Z = value ;
   }

   public byte getConregespapo_Z( )
   {
      return gxTv_SdtConcepto_Conregespapo_Z ;
   }

   public void setConregespapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conregespapo_Z = value ;
   }

   public byte getConsacdeven_Z( )
   {
      return gxTv_SdtConcepto_Consacdeven_Z ;
   }

   public void setConsacdeven_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Consacdeven_Z = value ;
   }

   public byte getConbaselic_Z( )
   {
      return gxTv_SdtConcepto_Conbaselic_Z ;
   }

   public void setConbaselic_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaselic_Z = value ;
   }

   public byte getConbaselicprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaselicprom_Z ;
   }

   public void setConbaselicprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaselicprom_Z = value ;
   }

   public byte getConbasefer_Z( )
   {
      return gxTv_SdtConcepto_Conbasefer_Z ;
   }

   public void setConbasefer_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasefer_Z = value ;
   }

   public byte getConbaseferprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaseferprom_Z ;
   }

   public void setConbaseferprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseferprom_Z = value ;
   }

   public byte getConbasehorext_Z( )
   {
      return gxTv_SdtConcepto_Conbasehorext_Z ;
   }

   public void setConbasehorext_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasehorext_Z = value ;
   }

   public byte getConbasehorextprom_Z( )
   {
      return gxTv_SdtConcepto_Conbasehorextprom_Z ;
   }

   public void setConbasehorextprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasehorextprom_Z = value ;
   }

   public byte getConbasepres_Z( )
   {
      return gxTv_SdtConcepto_Conbasepres_Z ;
   }

   public void setConbasepres_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbasepres_Z = value ;
   }

   public byte getConbaseant_Z( )
   {
      return gxTv_SdtConcepto_Conbaseant_Z ;
   }

   public void setConbaseant_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseant_Z = value ;
   }

   public byte getConbaseosdif_Z( )
   {
      return gxTv_SdtConcepto_Conbaseosdif_Z ;
   }

   public void setConbaseosdif_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseosdif_Z = value ;
   }

   public byte getConbaseaus_Z( )
   {
      return gxTv_SdtConcepto_Conbaseaus_Z ;
   }

   public void setConbaseaus_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseaus_Z = value ;
   }

   public byte getConbaseausprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaseausprom_Z ;
   }

   public void setConbaseausprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conbaseausprom_Z = value ;
   }

   public short getConceptopais_Z( )
   {
      return gxTv_SdtConcepto_Conceptopais_Z ;
   }

   public void setConceptopais_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptopais_Z = value ;
   }

   public String getConceptoconvecodigo_Z( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo_Z ;
   }

   public void setConceptoconvecodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptoconvecodigo_Z = value ;
   }

   public String getConcodafip_Z( )
   {
      return gxTv_SdtConcepto_Concodafip_Z ;
   }

   public void setConcodafip_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodafip_Z = value ;
   }

   public byte getConcntpa_Z( )
   {
      return gxTv_SdtConcepto_Concntpa_Z ;
   }

   public void setConcntpa_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concntpa_Z = value ;
   }

   public boolean getConerrorsicero_Z( )
   {
      return gxTv_SdtConcepto_Conerrorsicero_Z ;
   }

   public void setConerrorsicero_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conerrorsicero_Z = value ;
   }

   public int getClipadre_Z( )
   {
      return gxTv_SdtConcepto_Clipadre_Z ;
   }

   public void setClipadre_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Clipadre_Z = value ;
   }

   public String getConpadre_Z( )
   {
      return gxTv_SdtConcepto_Conpadre_Z ;
   }

   public void setConpadre_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conpadre_Z = value ;
   }

   public boolean getConpuenov_Z( )
   {
      return gxTv_SdtConcepto_Conpuenov_Z ;
   }

   public void setConpuenov_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conpuenov_Z = value ;
   }

   public int getConrelsec_Z( )
   {
      return gxTv_SdtConcepto_Conrelsec_Z ;
   }

   public void setConrelsec_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelsec_Z = value ;
   }

   public int getConrelseccli_Z( )
   {
      return gxTv_SdtConcepto_Conrelseccli_Z ;
   }

   public void setConrelseccli_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelseccli_Z = value ;
   }

   public String getConrelref_Z( )
   {
      return gxTv_SdtConcepto_Conrelref_Z ;
   }

   public void setConrelref_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conrelref_Z = value ;
   }

   public String getCondescripsinac_Z( )
   {
      return gxTv_SdtConcepto_Condescripsinac_Z ;
   }

   public void setCondescripsinac_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Condescripsinac_Z = value ;
   }

   public String getConoblpalabra_Z( )
   {
      return gxTv_SdtConcepto_Conoblpalabra_Z ;
   }

   public void setConoblpalabra_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conoblpalabra_Z = value ;
   }

   public byte getConformula_N( )
   {
      return gxTv_SdtConcepto_Conformula_N ;
   }

   public void setConformula_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conformula_N = value ;
   }

   public byte getConvalorgen_N( )
   {
      return gxTv_SdtConcepto_Convalorgen_N ;
   }

   public void setConvalorgen_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Convalorgen_N = value ;
   }

   public byte getContipoliqganancias_N( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias_N ;
   }

   public void setContipoliqganancias_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqganancias_N = value ;
   }

   public byte getConhisformula_N( )
   {
      return gxTv_SdtConcepto_Conhisformula_N ;
   }

   public void setConhisformula_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conhisformula_N = value ;
   }

   public byte getConusumodfor_N( )
   {
      return gxTv_SdtConcepto_Conusumodfor_N ;
   }

   public void setConusumodfor_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conusumodfor_N = value ;
   }

   public byte getConfchmodfor_N( )
   {
      return gxTv_SdtConcepto_Confchmodfor_N ;
   }

   public void setConfchmodfor_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Confchmodfor_N = value ;
   }

   public byte getConcodydesc_N( )
   {
      return gxTv_SdtConcepto_Concodydesc_N ;
   }

   public void setConcodydesc_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concodydesc_N = value ;
   }

   public byte getSubtipoconcod1_N( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1_N ;
   }

   public void setSubtipoconcod1_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod1_N = value ;
   }

   public byte getSubtipoconcod2_N( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2_N ;
   }

   public void setSubtipoconcod2_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Subtipoconcod2_N = value ;
   }

   public byte getConcuendebe_N( )
   {
      return gxTv_SdtConcepto_Concuendebe_N ;
   }

   public void setConcuendebe_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuendebe_N = value ;
   }

   public byte getConcuenhaber_N( )
   {
      return gxTv_SdtConcepto_Concuenhaber_N ;
   }

   public void setConcuenhaber_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concuenhaber_N = value ;
   }

   public byte getContipoliqaux_N( )
   {
      return gxTv_SdtConcepto_Contipoliqaux_N ;
   }

   public void setContipoliqaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Contipoliqaux_N = value ;
   }

   public byte getConconveaux_N( )
   {
      return gxTv_SdtConcepto_Conconveaux_N ;
   }

   public void setConconveaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conconveaux_N = value ;
   }

   public byte getConclasifaux_N( )
   {
      return gxTv_SdtConcepto_Conclasifaux_N ;
   }

   public void setConclasifaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conclasifaux_N = value ;
   }

   public byte getConaplicgan_N( )
   {
      return gxTv_SdtConcepto_Conaplicgan_N ;
   }

   public void setConaplicgan_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conaplicgan_N = value ;
   }

   public byte getConobliga_N( )
   {
      return gxTv_SdtConcepto_Conobliga_N ;
   }

   public void setConobliga_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobliga_N = value ;
   }

   public byte getConobligasisac_N( )
   {
      return gxTv_SdtConcepto_Conobligasisac_N ;
   }

   public void setConobligasisac_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conobligasisac_N = value ;
   }

   public byte getConcondicion_N( )
   {
      return gxTv_SdtConcepto_Concondicion_N ;
   }

   public void setConcondicion_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Concondicion_N = value ;
   }

   public byte getConprereq_N( )
   {
      return gxTv_SdtConcepto_Conprereq_N ;
   }

   public void setConprereq_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conprereq_N = value ;
   }

   public byte getConadeldescu_N( )
   {
      return gxTv_SdtConcepto_Conadeldescu_N ;
   }

   public void setConadeldescu_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conadeldescu_N = value ;
   }

   public byte getApliigg_N( )
   {
      return gxTv_SdtConcepto_Apliigg_N ;
   }

   public void setApliigg_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Apliigg_N = value ;
   }

   public byte getConceptopais_N( )
   {
      return gxTv_SdtConcepto_Conceptopais_N ;
   }

   public void setConceptopais_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptopais_N = value ;
   }

   public byte getConceptoconvecodigo_N( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo_N ;
   }

   public void setConceptoconvecodigo_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conceptoconvecodigo_N = value ;
   }

   public byte getClipadre_N( )
   {
      return gxTv_SdtConcepto_Clipadre_N ;
   }

   public void setClipadre_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Clipadre_N = value ;
   }

   public byte getConpadre_N( )
   {
      return gxTv_SdtConcepto_Conpadre_N ;
   }

   public void setConpadre_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conpadre_N = value ;
   }

   public byte getConoblpalabra_N( )
   {
      return gxTv_SdtConcepto_Conoblpalabra_N ;
   }

   public void setConoblpalabra_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      gxTv_SdtConcepto_Conoblpalabra_N = value ;
   }

   protected byte gxTv_SdtConcepto_Convigencia ;
   protected byte gxTv_SdtConcepto_Conliqbasica ;
   protected byte gxTv_SdtConcepto_Contipo ;
   protected byte gxTv_SdtConcepto_Conaplicgan ;
   protected byte gxTv_SdtConcepto_Conadeldescu ;
   protected byte gxTv_SdtConcepto_Connumero ;
   protected byte gxTv_SdtConcepto_Consipaapo ;
   protected byte gxTv_SdtConcepto_Consipacont ;
   protected byte gxTv_SdtConcepto_Coninssjypapo ;
   protected byte gxTv_SdtConcepto_Coninssjypcont ;
   protected byte gxTv_SdtConcepto_Conobrasocapo ;
   protected byte gxTv_SdtConcepto_Conobrasoccont ;
   protected byte gxTv_SdtConcepto_Confonsolredapo ;
   protected byte gxTv_SdtConcepto_Confonsolredcont ;
   protected byte gxTv_SdtConcepto_Conrenateaapo ;
   protected byte gxTv_SdtConcepto_Conrenateacont ;
   protected byte gxTv_SdtConcepto_Conasigfamcont ;
   protected byte gxTv_SdtConcepto_Confonnacempcont ;
   protected byte gxTv_SdtConcepto_Conleyrietrabcont ;
   protected byte gxTv_SdtConcepto_Conregdifapo ;
   protected byte gxTv_SdtConcepto_Conregespapo ;
   protected byte gxTv_SdtConcepto_Consacdeven ;
   protected byte gxTv_SdtConcepto_Conbaselic ;
   protected byte gxTv_SdtConcepto_Conbaselicprom ;
   protected byte gxTv_SdtConcepto_Conbasefer ;
   protected byte gxTv_SdtConcepto_Conbaseferprom ;
   protected byte gxTv_SdtConcepto_Conbasehorext ;
   protected byte gxTv_SdtConcepto_Conbasehorextprom ;
   protected byte gxTv_SdtConcepto_Conbasepres ;
   protected byte gxTv_SdtConcepto_Conbaseant ;
   protected byte gxTv_SdtConcepto_Conbaseosdif ;
   protected byte gxTv_SdtConcepto_Conbaseaus ;
   protected byte gxTv_SdtConcepto_Conbaseausprom ;
   protected byte gxTv_SdtConcepto_Concntpa ;
   protected byte gxTv_SdtConcepto_Convigencia_Z ;
   protected byte gxTv_SdtConcepto_Conliqbasica_Z ;
   protected byte gxTv_SdtConcepto_Contipo_Z ;
   protected byte gxTv_SdtConcepto_Conaplicgan_Z ;
   protected byte gxTv_SdtConcepto_Conadeldescu_Z ;
   protected byte gxTv_SdtConcepto_Connumero_Z ;
   protected byte gxTv_SdtConcepto_Consipaapo_Z ;
   protected byte gxTv_SdtConcepto_Consipacont_Z ;
   protected byte gxTv_SdtConcepto_Coninssjypapo_Z ;
   protected byte gxTv_SdtConcepto_Coninssjypcont_Z ;
   protected byte gxTv_SdtConcepto_Conobrasocapo_Z ;
   protected byte gxTv_SdtConcepto_Conobrasoccont_Z ;
   protected byte gxTv_SdtConcepto_Confonsolredapo_Z ;
   protected byte gxTv_SdtConcepto_Confonsolredcont_Z ;
   protected byte gxTv_SdtConcepto_Conrenateaapo_Z ;
   protected byte gxTv_SdtConcepto_Conrenateacont_Z ;
   protected byte gxTv_SdtConcepto_Conasigfamcont_Z ;
   protected byte gxTv_SdtConcepto_Confonnacempcont_Z ;
   protected byte gxTv_SdtConcepto_Conleyrietrabcont_Z ;
   protected byte gxTv_SdtConcepto_Conregdifapo_Z ;
   protected byte gxTv_SdtConcepto_Conregespapo_Z ;
   protected byte gxTv_SdtConcepto_Consacdeven_Z ;
   protected byte gxTv_SdtConcepto_Conbaselic_Z ;
   protected byte gxTv_SdtConcepto_Conbaselicprom_Z ;
   protected byte gxTv_SdtConcepto_Conbasefer_Z ;
   protected byte gxTv_SdtConcepto_Conbaseferprom_Z ;
   protected byte gxTv_SdtConcepto_Conbasehorext_Z ;
   protected byte gxTv_SdtConcepto_Conbasehorextprom_Z ;
   protected byte gxTv_SdtConcepto_Conbasepres_Z ;
   protected byte gxTv_SdtConcepto_Conbaseant_Z ;
   protected byte gxTv_SdtConcepto_Conbaseosdif_Z ;
   protected byte gxTv_SdtConcepto_Conbaseaus_Z ;
   protected byte gxTv_SdtConcepto_Conbaseausprom_Z ;
   protected byte gxTv_SdtConcepto_Concntpa_Z ;
   protected byte gxTv_SdtConcepto_Conformula_N ;
   protected byte gxTv_SdtConcepto_Convalorgen_N ;
   protected byte gxTv_SdtConcepto_Contipoliqganancias_N ;
   protected byte gxTv_SdtConcepto_Conhisformula_N ;
   protected byte gxTv_SdtConcepto_Conusumodfor_N ;
   protected byte gxTv_SdtConcepto_Confchmodfor_N ;
   protected byte gxTv_SdtConcepto_Concodydesc_N ;
   protected byte gxTv_SdtConcepto_Subtipoconcod1_N ;
   protected byte gxTv_SdtConcepto_Subtipoconcod2_N ;
   protected byte gxTv_SdtConcepto_Concuendebe_N ;
   protected byte gxTv_SdtConcepto_Concuenhaber_N ;
   protected byte gxTv_SdtConcepto_Contipoliqaux_N ;
   protected byte gxTv_SdtConcepto_Conconveaux_N ;
   protected byte gxTv_SdtConcepto_Conclasifaux_N ;
   protected byte gxTv_SdtConcepto_Conaplicgan_N ;
   protected byte gxTv_SdtConcepto_Conobliga_N ;
   protected byte gxTv_SdtConcepto_Conobligasisac_N ;
   protected byte gxTv_SdtConcepto_Concondicion_N ;
   protected byte gxTv_SdtConcepto_Conprereq_N ;
   protected byte gxTv_SdtConcepto_Conadeldescu_N ;
   protected byte gxTv_SdtConcepto_Apliigg_N ;
   protected byte gxTv_SdtConcepto_Conceptopais_N ;
   protected byte gxTv_SdtConcepto_Conceptoconvecodigo_N ;
   protected byte gxTv_SdtConcepto_Clipadre_N ;
   protected byte gxTv_SdtConcepto_Conpadre_N ;
   protected byte gxTv_SdtConcepto_Conoblpalabra_N ;
   private byte gxTv_SdtConcepto_N ;
   protected short gxTv_SdtConcepto_Contipoorden ;
   protected short gxTv_SdtConcepto_Apliigg ;
   protected short gxTv_SdtConcepto_Conceptopais ;
   protected short gxTv_SdtConcepto_Initialized ;
   protected short gxTv_SdtConcepto_Contipoorden_Z ;
   protected short gxTv_SdtConcepto_Apliigg_Z ;
   protected short gxTv_SdtConcepto_Conceptopais_Z ;
   protected int gxTv_SdtConcepto_Clicod ;
   protected int gxTv_SdtConcepto_Conorden ;
   protected int gxTv_SdtConcepto_Clipadre ;
   protected int gxTv_SdtConcepto_Conrelsec ;
   protected int gxTv_SdtConcepto_Conrelseccli ;
   protected int gxTv_SdtConcepto_Clicod_Z ;
   protected int gxTv_SdtConcepto_Conorden_Z ;
   protected int gxTv_SdtConcepto_Clipadre_Z ;
   protected int gxTv_SdtConcepto_Conrelsec_Z ;
   protected int gxTv_SdtConcepto_Conrelseccli_Z ;
   protected long gxTv_SdtConcepto_Conordejec ;
   protected long gxTv_SdtConcepto_Conordejec_Z ;
   protected String gxTv_SdtConcepto_Concodigo ;
   protected String gxTv_SdtConcepto_Contipoliqganancias ;
   protected String gxTv_SdtConcepto_Conusumodfor ;
   protected String gxTv_SdtConcepto_Conformulaabr ;
   protected String gxTv_SdtConcepto_Tipoconcod ;
   protected String gxTv_SdtConcepto_Subtipoconcod1 ;
   protected String gxTv_SdtConcepto_Subtipoconcod2 ;
   protected String gxTv_SdtConcepto_Concodold ;
   protected String gxTv_SdtConcepto_Concuendebe ;
   protected String gxTv_SdtConcepto_Concuenhaber ;
   protected String gxTv_SdtConcepto_Concondicion ;
   protected String gxTv_SdtConcepto_Concondcodigo ;
   protected String gxTv_SdtConcepto_Conprereq ;
   protected String gxTv_SdtConcepto_Conceptoconvecodigo ;
   protected String gxTv_SdtConcepto_Concodafip ;
   protected String gxTv_SdtConcepto_Conpadre ;
   protected String gxTv_SdtConcepto_Conoblpalabra ;
   protected String gxTv_SdtConcepto_Mode ;
   protected String gxTv_SdtConcepto_Concodigo_Z ;
   protected String gxTv_SdtConcepto_Contipoliqganancias_Z ;
   protected String gxTv_SdtConcepto_Conusumodfor_Z ;
   protected String gxTv_SdtConcepto_Conformulaabr_Z ;
   protected String gxTv_SdtConcepto_Tipoconcod_Z ;
   protected String gxTv_SdtConcepto_Subtipoconcod1_Z ;
   protected String gxTv_SdtConcepto_Subtipoconcod2_Z ;
   protected String gxTv_SdtConcepto_Concodold_Z ;
   protected String gxTv_SdtConcepto_Concuendebe_Z ;
   protected String gxTv_SdtConcepto_Concuenhaber_Z ;
   protected String gxTv_SdtConcepto_Concondicion_Z ;
   protected String gxTv_SdtConcepto_Concondcodigo_Z ;
   protected String gxTv_SdtConcepto_Conprereq_Z ;
   protected String gxTv_SdtConcepto_Conceptoconvecodigo_Z ;
   protected String gxTv_SdtConcepto_Concodafip_Z ;
   protected String gxTv_SdtConcepto_Conpadre_Z ;
   protected String gxTv_SdtConcepto_Conoblpalabra_Z ;
   protected boolean gxTv_SdtConcepto_Conhabilitado ;
   protected boolean gxTv_SdtConcepto_Concanti ;
   protected boolean gxTv_SdtConcepto_Convaluni ;
   protected boolean gxTv_SdtConcepto_Conimporte ;
   protected boolean gxTv_SdtConcepto_Convariable ;
   protected boolean gxTv_SdtConcepto_Conretganpropor ;
   protected boolean gxTv_SdtConcepto_Conrecalcular ;
   protected boolean gxTv_SdtConcepto_Conimportado ;
   protected boolean gxTv_SdtConcepto_Conedienrec ;
   protected boolean gxTv_SdtConcepto_Conusado ;
   protected boolean gxTv_SdtConcepto_Conobliga ;
   protected boolean gxTv_SdtConcepto_Conobligasisac ;
   protected boolean gxTv_SdtConcepto_Conmostrarpos ;
   protected boolean gxTv_SdtConcepto_Consegunpla ;
   protected boolean gxTv_SdtConcepto_Conerrorsicero ;
   protected boolean gxTv_SdtConcepto_Conpuenov ;
   protected boolean gxTv_SdtConcepto_Conhabilitado_Z ;
   protected boolean gxTv_SdtConcepto_Concanti_Z ;
   protected boolean gxTv_SdtConcepto_Convaluni_Z ;
   protected boolean gxTv_SdtConcepto_Conimporte_Z ;
   protected boolean gxTv_SdtConcepto_Convariable_Z ;
   protected boolean gxTv_SdtConcepto_Conretganpropor_Z ;
   protected boolean gxTv_SdtConcepto_Conrecalcular_Z ;
   protected boolean gxTv_SdtConcepto_Conimportado_Z ;
   protected boolean gxTv_SdtConcepto_Conedienrec_Z ;
   protected boolean gxTv_SdtConcepto_Conusado_Z ;
   protected boolean gxTv_SdtConcepto_Conobliga_Z ;
   protected boolean gxTv_SdtConcepto_Conobligasisac_Z ;
   protected boolean gxTv_SdtConcepto_Conmostrarpos_Z ;
   protected boolean gxTv_SdtConcepto_Consegunpla_Z ;
   protected boolean gxTv_SdtConcepto_Conerrorsicero_Z ;
   protected boolean gxTv_SdtConcepto_Conpuenov_Z ;
   protected String gxTv_SdtConcepto_Conformula ;
   protected String gxTv_SdtConcepto_Conformulapreresuelta ;
   protected String gxTv_SdtConcepto_Conobservacion ;
   protected String gxTv_SdtConcepto_Conhisformula ;
   protected String gxTv_SdtConcepto_Conformulaexpl ;
   protected String gxTv_SdtConcepto_Conformulaobs2 ;
   protected String gxTv_SdtConcepto_Conoldvalues ;
   protected String gxTv_SdtConcepto_Condescrip ;
   protected String gxTv_SdtConcepto_Concodydesc ;
   protected String gxTv_SdtConcepto_Contipoliqaux ;
   protected String gxTv_SdtConcepto_Conconveaux ;
   protected String gxTv_SdtConcepto_Conclasifaux ;
   protected String gxTv_SdtConcepto_Conrangocant ;
   protected String gxTv_SdtConcepto_Conrelref ;
   protected String gxTv_SdtConcepto_Condescripsinac ;
   protected String gxTv_SdtConcepto_Condescrip_Z ;
   protected String gxTv_SdtConcepto_Concodydesc_Z ;
   protected String gxTv_SdtConcepto_Contipoliqaux_Z ;
   protected String gxTv_SdtConcepto_Conconveaux_Z ;
   protected String gxTv_SdtConcepto_Conclasifaux_Z ;
   protected String gxTv_SdtConcepto_Conrangocant_Z ;
   protected String gxTv_SdtConcepto_Conrelref_Z ;
   protected String gxTv_SdtConcepto_Condescripsinac_Z ;
   protected java.math.BigDecimal gxTv_SdtConcepto_Convalorgen ;
   protected java.util.Date gxTv_SdtConcepto_Confchmodfor ;
   protected java.math.BigDecimal gxTv_SdtConcepto_Convalorgen_Z ;
   protected java.util.Date gxTv_SdtConcepto_Confchmodfor_Z ;
   protected java.util.Vector<web.StructSdtConcepto_TipoLiquidacion> gxTv_SdtConcepto_Tipoliquidacion=null ;
   protected java.util.Vector<web.StructSdtConcepto_MotivosEgreso> gxTv_SdtConcepto_Motivosegreso=null ;
}

