package web ;
import com.genexus.*;

public final  class StructSdtPais implements Cloneable, java.io.Serializable
{
   public StructSdtPais( )
   {
      this( -1, new ModelContext( StructSdtPais.class ));
   }

   public StructSdtPais( int remoteHandle ,
                         ModelContext context )
   {
      gxTv_SdtPais_Painom = "" ;
      gxTv_SdtPais_Paireligdefault = "" ;
      gxTv_SdtPais_Paimeshspext = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paidiahspext = "" ;
      gxTv_SdtPais_Paimaxhornor = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paifracvacant = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paiprommestcnt = "" ;
      gxTv_SdtPais_Paipromjormestcnt = "" ;
      gxTv_SdtPais_Paivizzoti = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Painom_Z = "" ;
      gxTv_SdtPais_Paireligdefault_Z = "" ;
      gxTv_SdtPais_Paimeshspext_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paidiahspext_Z = "" ;
      gxTv_SdtPais_Paimaxhornor_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paifracvacant_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paiprommestcnt_Z = "" ;
      gxTv_SdtPais_Paipromjormestcnt_Z = "" ;
      gxTv_SdtPais_Paivizzoti_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_Paireligdefault_N = (byte)(1) ;
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

   public short getPaicod( )
   {
      return gxTv_SdtPais_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paicod = value ;
   }

   public String getPainom( )
   {
      return gxTv_SdtPais_Painom ;
   }

   public void setPainom( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Painom = value ;
   }

   public boolean getPainacmostrar( )
   {
      return gxTv_SdtPais_Painacmostrar ;
   }

   public void setPainacmostrar( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Painacmostrar = value ;
   }

   public boolean getPaidommostrar( )
   {
      return gxTv_SdtPais_Paidommostrar ;
   }

   public void setPaidommostrar( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paidommostrar = value ;
   }

   public String getPaireligdefault( )
   {
      return gxTv_SdtPais_Paireligdefault ;
   }

   public void setPaireligdefault( String value )
   {
      gxTv_SdtPais_Paireligdefault_N = (byte)(0) ;
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paireligdefault = value ;
   }

   public java.math.BigDecimal getPaimeshspext( )
   {
      return gxTv_SdtPais_Paimeshspext ;
   }

   public void setPaimeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paimeshspext = value ;
   }

   public String getPaidiahspext( )
   {
      return gxTv_SdtPais_Paidiahspext ;
   }

   public void setPaidiahspext( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paidiahspext = value ;
   }

   public boolean getPaifondocese( )
   {
      return gxTv_SdtPais_Paifondocese ;
   }

   public void setPaifondocese( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paifondocese = value ;
   }

   public java.math.BigDecimal getPaimaxhornor( )
   {
      return gxTv_SdtPais_Paimaxhornor ;
   }

   public void setPaimaxhornor( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paimaxhornor = value ;
   }

   public byte getPaipervacdes( )
   {
      return gxTv_SdtPais_Paipervacdes ;
   }

   public void setPaipervacdes( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipervacdes = value ;
   }

   public byte getPaipervachas( )
   {
      return gxTv_SdtPais_Paipervachas ;
   }

   public void setPaipervachas( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipervachas = value ;
   }

   public java.math.BigDecimal getPaifracvacant( )
   {
      return gxTv_SdtPais_Paifracvacant ;
   }

   public void setPaifracvacant( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paifracvacant = value ;
   }

   public java.util.Vector<web.StructSdtPais_preaviso> getPreaviso( )
   {
      return gxTv_SdtPais_Preaviso ;
   }

   public void setPreaviso( java.util.Vector<web.StructSdtPais_preaviso> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Preaviso = value ;
   }

   public java.util.Vector<web.StructSdtPais_base_calculo> getBase_calculo( )
   {
      return gxTv_SdtPais_Base_calculo ;
   }

   public void setBase_calculo( java.util.Vector<web.StructSdtPais_base_calculo> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Base_calculo = value ;
   }

   public java.util.Vector<web.StructSdtPais_conceptos_horanormal_jornalizados> getConceptos_horanormal_jornalizados( )
   {
      return gxTv_SdtPais_Conceptos_horanormal_jornalizados ;
   }

   public void setConceptos_horanormal_jornalizados( java.util.Vector<web.StructSdtPais_conceptos_horanormal_jornalizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Conceptos_horanormal_jornalizados = value ;
   }

   public java.util.Vector<web.StructSdtPais_conceptos_horanormal_mensualizados> getConceptos_horanormal_mensualizados( )
   {
      return gxTv_SdtPais_Conceptos_horanormal_mensualizados ;
   }

   public void setConceptos_horanormal_mensualizados( java.util.Vector<web.StructSdtPais_conceptos_horanormal_mensualizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Conceptos_horanormal_mensualizados = value ;
   }

   public byte getPaiprommeses( )
   {
      return gxTv_SdtPais_Paiprommeses ;
   }

   public void setPaiprommeses( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiprommeses = value ;
   }

   public String getPaiprommestcnt( )
   {
      return gxTv_SdtPais_Paiprommestcnt ;
   }

   public void setPaiprommestcnt( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiprommestcnt = value ;
   }

   public byte getPaipromjormeses( )
   {
      return gxTv_SdtPais_Paipromjormeses ;
   }

   public void setPaipromjormeses( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipromjormeses = value ;
   }

   public String getPaipromjormestcnt( )
   {
      return gxTv_SdtPais_Paipromjormestcnt ;
   }

   public void setPaipromjormestcnt( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipromjormestcnt = value ;
   }

   public java.util.Vector<web.StructSdtPais_promedio_horanormal_mensualizados> getPromedio_horanormal_mensualizados( )
   {
      return gxTv_SdtPais_Promedio_horanormal_mensualizados ;
   }

   public void setPromedio_horanormal_mensualizados( java.util.Vector<web.StructSdtPais_promedio_horanormal_mensualizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Promedio_horanormal_mensualizados = value ;
   }

   public java.util.Vector<web.StructSdtPais_tipo_trabajo> getTipo_trabajo( )
   {
      return gxTv_SdtPais_Tipo_trabajo ;
   }

   public void setTipo_trabajo( java.util.Vector<web.StructSdtPais_tipo_trabajo> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Tipo_trabajo = value ;
   }

   public java.util.Vector<web.StructSdtPais_horasextras_pordia> getHorasextras_pordia( )
   {
      return gxTv_SdtPais_Horasextras_pordia ;
   }

   public void setHorasextras_pordia( java.util.Vector<web.StructSdtPais_horasextras_pordia> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Horasextras_pordia = value ;
   }

   public byte getPaiguaredadmin( )
   {
      return gxTv_SdtPais_Paiguaredadmin ;
   }

   public void setPaiguaredadmin( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiguaredadmin = value ;
   }

   public byte getPaiguaredadmax( )
   {
      return gxTv_SdtPais_Paiguaredadmax ;
   }

   public void setPaiguaredadmax( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiguaredadmax = value ;
   }

   public boolean getPaiexcvizzoti( )
   {
      return gxTv_SdtPais_Paiexcvizzoti ;
   }

   public void setPaiexcvizzoti( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiexcvizzoti = value ;
   }

   public java.math.BigDecimal getPaivizzoti( )
   {
      return gxTv_SdtPais_Paivizzoti ;
   }

   public void setPaivizzoti( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paivizzoti = value ;
   }

   public byte getPaiminmesesvac( )
   {
      return gxTv_SdtPais_Paiminmesesvac ;
   }

   public void setPaiminmesesvac( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiminmesesvac = value ;
   }

   public short getPaiinterdiasjor( )
   {
      return gxTv_SdtPais_Paiinterdiasjor ;
   }

   public void setPaiinterdiasjor( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiinterdiasjor = value ;
   }

   public byte getPaitipoexpdef( )
   {
      return gxTv_SdtPais_Paitipoexpdef ;
   }

   public void setPaitipoexpdef( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paitipoexpdef = value ;
   }

   public java.util.Vector<web.StructSdtPais_Vacaciones> getVacaciones( )
   {
      return gxTv_SdtPais_Vacaciones ;
   }

   public void setVacaciones( java.util.Vector<web.StructSdtPais_Vacaciones> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Initialized = value ;
   }

   public short getPaicod_Z( )
   {
      return gxTv_SdtPais_Paicod_Z ;
   }

   public void setPaicod_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paicod_Z = value ;
   }

   public String getPainom_Z( )
   {
      return gxTv_SdtPais_Painom_Z ;
   }

   public void setPainom_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Painom_Z = value ;
   }

   public boolean getPainacmostrar_Z( )
   {
      return gxTv_SdtPais_Painacmostrar_Z ;
   }

   public void setPainacmostrar_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Painacmostrar_Z = value ;
   }

   public boolean getPaidommostrar_Z( )
   {
      return gxTv_SdtPais_Paidommostrar_Z ;
   }

   public void setPaidommostrar_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paidommostrar_Z = value ;
   }

   public String getPaireligdefault_Z( )
   {
      return gxTv_SdtPais_Paireligdefault_Z ;
   }

   public void setPaireligdefault_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paireligdefault_Z = value ;
   }

   public java.math.BigDecimal getPaimeshspext_Z( )
   {
      return gxTv_SdtPais_Paimeshspext_Z ;
   }

   public void setPaimeshspext_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paimeshspext_Z = value ;
   }

   public String getPaidiahspext_Z( )
   {
      return gxTv_SdtPais_Paidiahspext_Z ;
   }

   public void setPaidiahspext_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paidiahspext_Z = value ;
   }

   public boolean getPaifondocese_Z( )
   {
      return gxTv_SdtPais_Paifondocese_Z ;
   }

   public void setPaifondocese_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paifondocese_Z = value ;
   }

   public java.math.BigDecimal getPaimaxhornor_Z( )
   {
      return gxTv_SdtPais_Paimaxhornor_Z ;
   }

   public void setPaimaxhornor_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paimaxhornor_Z = value ;
   }

   public byte getPaipervacdes_Z( )
   {
      return gxTv_SdtPais_Paipervacdes_Z ;
   }

   public void setPaipervacdes_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipervacdes_Z = value ;
   }

   public byte getPaipervachas_Z( )
   {
      return gxTv_SdtPais_Paipervachas_Z ;
   }

   public void setPaipervachas_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipervachas_Z = value ;
   }

   public java.math.BigDecimal getPaifracvacant_Z( )
   {
      return gxTv_SdtPais_Paifracvacant_Z ;
   }

   public void setPaifracvacant_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paifracvacant_Z = value ;
   }

   public byte getPaiprommeses_Z( )
   {
      return gxTv_SdtPais_Paiprommeses_Z ;
   }

   public void setPaiprommeses_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiprommeses_Z = value ;
   }

   public String getPaiprommestcnt_Z( )
   {
      return gxTv_SdtPais_Paiprommestcnt_Z ;
   }

   public void setPaiprommestcnt_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiprommestcnt_Z = value ;
   }

   public byte getPaipromjormeses_Z( )
   {
      return gxTv_SdtPais_Paipromjormeses_Z ;
   }

   public void setPaipromjormeses_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipromjormeses_Z = value ;
   }

   public String getPaipromjormestcnt_Z( )
   {
      return gxTv_SdtPais_Paipromjormestcnt_Z ;
   }

   public void setPaipromjormestcnt_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paipromjormestcnt_Z = value ;
   }

   public byte getPaiguaredadmin_Z( )
   {
      return gxTv_SdtPais_Paiguaredadmin_Z ;
   }

   public void setPaiguaredadmin_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiguaredadmin_Z = value ;
   }

   public byte getPaiguaredadmax_Z( )
   {
      return gxTv_SdtPais_Paiguaredadmax_Z ;
   }

   public void setPaiguaredadmax_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiguaredadmax_Z = value ;
   }

   public boolean getPaiexcvizzoti_Z( )
   {
      return gxTv_SdtPais_Paiexcvizzoti_Z ;
   }

   public void setPaiexcvizzoti_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiexcvizzoti_Z = value ;
   }

   public java.math.BigDecimal getPaivizzoti_Z( )
   {
      return gxTv_SdtPais_Paivizzoti_Z ;
   }

   public void setPaivizzoti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paivizzoti_Z = value ;
   }

   public byte getPaiminmesesvac_Z( )
   {
      return gxTv_SdtPais_Paiminmesesvac_Z ;
   }

   public void setPaiminmesesvac_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiminmesesvac_Z = value ;
   }

   public short getPaiinterdiasjor_Z( )
   {
      return gxTv_SdtPais_Paiinterdiasjor_Z ;
   }

   public void setPaiinterdiasjor_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paiinterdiasjor_Z = value ;
   }

   public byte getPaitipoexpdef_Z( )
   {
      return gxTv_SdtPais_Paitipoexpdef_Z ;
   }

   public void setPaitipoexpdef_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paitipoexpdef_Z = value ;
   }

   public byte getPaireligdefault_N( )
   {
      return gxTv_SdtPais_Paireligdefault_N ;
   }

   public void setPaireligdefault_N( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paireligdefault_N = value ;
   }

   protected byte gxTv_SdtPais_Paipervacdes ;
   protected byte gxTv_SdtPais_Paipervachas ;
   protected byte gxTv_SdtPais_Paiprommeses ;
   protected byte gxTv_SdtPais_Paipromjormeses ;
   protected byte gxTv_SdtPais_Paiguaredadmin ;
   protected byte gxTv_SdtPais_Paiguaredadmax ;
   protected byte gxTv_SdtPais_Paiminmesesvac ;
   protected byte gxTv_SdtPais_Paitipoexpdef ;
   protected byte gxTv_SdtPais_Paipervacdes_Z ;
   protected byte gxTv_SdtPais_Paipervachas_Z ;
   protected byte gxTv_SdtPais_Paiprommeses_Z ;
   protected byte gxTv_SdtPais_Paipromjormeses_Z ;
   protected byte gxTv_SdtPais_Paiguaredadmin_Z ;
   protected byte gxTv_SdtPais_Paiguaredadmax_Z ;
   protected byte gxTv_SdtPais_Paiminmesesvac_Z ;
   protected byte gxTv_SdtPais_Paitipoexpdef_Z ;
   protected byte gxTv_SdtPais_Paireligdefault_N ;
   private byte gxTv_SdtPais_N ;
   protected short gxTv_SdtPais_Paicod ;
   protected short gxTv_SdtPais_Paiinterdiasjor ;
   protected short gxTv_SdtPais_Initialized ;
   protected short gxTv_SdtPais_Paicod_Z ;
   protected short gxTv_SdtPais_Paiinterdiasjor_Z ;
   protected String gxTv_SdtPais_Paireligdefault ;
   protected String gxTv_SdtPais_Paidiahspext ;
   protected String gxTv_SdtPais_Paiprommestcnt ;
   protected String gxTv_SdtPais_Paipromjormestcnt ;
   protected String gxTv_SdtPais_Mode ;
   protected String gxTv_SdtPais_Paireligdefault_Z ;
   protected String gxTv_SdtPais_Paidiahspext_Z ;
   protected String gxTv_SdtPais_Paiprommestcnt_Z ;
   protected String gxTv_SdtPais_Paipromjormestcnt_Z ;
   protected boolean gxTv_SdtPais_Painacmostrar ;
   protected boolean gxTv_SdtPais_Paidommostrar ;
   protected boolean gxTv_SdtPais_Paifondocese ;
   protected boolean gxTv_SdtPais_Paiexcvizzoti ;
   protected boolean gxTv_SdtPais_Painacmostrar_Z ;
   protected boolean gxTv_SdtPais_Paidommostrar_Z ;
   protected boolean gxTv_SdtPais_Paifondocese_Z ;
   protected boolean gxTv_SdtPais_Paiexcvizzoti_Z ;
   protected String gxTv_SdtPais_Painom ;
   protected String gxTv_SdtPais_Painom_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_Paimeshspext ;
   protected java.math.BigDecimal gxTv_SdtPais_Paimaxhornor ;
   protected java.math.BigDecimal gxTv_SdtPais_Paifracvacant ;
   protected java.math.BigDecimal gxTv_SdtPais_Paivizzoti ;
   protected java.math.BigDecimal gxTv_SdtPais_Paimeshspext_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_Paimaxhornor_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_Paifracvacant_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_Paivizzoti_Z ;
   protected java.util.Vector<web.StructSdtPais_preaviso> gxTv_SdtPais_Preaviso=null ;
   protected java.util.Vector<web.StructSdtPais_base_calculo> gxTv_SdtPais_Base_calculo=null ;
   protected java.util.Vector<web.StructSdtPais_conceptos_horanormal_jornalizados> gxTv_SdtPais_Conceptos_horanormal_jornalizados=null ;
   protected java.util.Vector<web.StructSdtPais_conceptos_horanormal_mensualizados> gxTv_SdtPais_Conceptos_horanormal_mensualizados=null ;
   protected java.util.Vector<web.StructSdtPais_promedio_horanormal_mensualizados> gxTv_SdtPais_Promedio_horanormal_mensualizados=null ;
   protected java.util.Vector<web.StructSdtPais_tipo_trabajo> gxTv_SdtPais_Tipo_trabajo=null ;
   protected java.util.Vector<web.StructSdtPais_horasextras_pordia> gxTv_SdtPais_Horasextras_pordia=null ;
   protected java.util.Vector<web.StructSdtPais_Vacaciones> gxTv_SdtPais_Vacaciones=null ;
}

