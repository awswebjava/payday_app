package web ;
import com.genexus.*;

public final  class StructSdtEmpresa implements Cloneable, java.io.Serializable
{
   public StructSdtEmpresa( )
   {
      this( -1, new ModelContext( StructSdtEmpresa.class ));
   }

   public StructSdtEmpresa( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtEmpresa_Empnom = "" ;
      gxTv_SdtEmpresa_Cativadesc = "" ;
      gxTv_SdtEmpresa_Empdir = "" ;
      gxTv_SdtEmpresa_Emptel = "" ;
      gxTv_SdtEmpresa_Empcp = "" ;
      gxTv_SdtEmpresa_Painom = "" ;
      gxTv_SdtEmpresa_Provnom = "" ;
      gxTv_SdtEmpresa_Locnom = "" ;
      gxTv_SdtEmpresa_Actcodigo = "" ;
      gxTv_SdtEmpresa_Actdescrip = "" ;
      gxTv_SdtEmpresa_Tipemplecod = "" ;
      gxTv_SdtEmpresa_Empzoncod = "" ;
      gxTv_SdtEmpresa_Empzondescrip = "" ;
      gxTv_SdtEmpresa_Empactcomercial = "" ;
      gxTv_SdtEmpresa_Tipempledefins = "" ;
      gxTv_SdtEmpresa_Emplogo = "" ;
      gxTv_SdtEmpresa_Emplogonom = "" ;
      gxTv_SdtEmpresa_Emplogoext = "" ;
      gxTv_SdtEmpresa_Empfirma = "" ;
      gxTv_SdtEmpresa_Empfirmanom = "" ;
      gxTv_SdtEmpresa_Empfirmaext = "" ;
      gxTv_SdtEmpresa_Empantiguedad = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Emppresentismo = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Empmeshspext = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Empdiahspext = "" ;
      gxTv_SdtEmpresa_Actcomcodigo = "" ;
      gxTv_SdtEmpresa_Emppromdesde = "" ;
      gxTv_SdtEmpresa_Empfracvacant = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Emposocod = "" ;
      gxTv_SdtEmpresa_Empmodtra = "" ;
      gxTv_SdtEmpresa_Mode = "" ;
      gxTv_SdtEmpresa_Empnom_Z = "" ;
      gxTv_SdtEmpresa_Cativadesc_Z = "" ;
      gxTv_SdtEmpresa_Empdir_Z = "" ;
      gxTv_SdtEmpresa_Emptel_Z = "" ;
      gxTv_SdtEmpresa_Empcp_Z = "" ;
      gxTv_SdtEmpresa_Painom_Z = "" ;
      gxTv_SdtEmpresa_Provnom_Z = "" ;
      gxTv_SdtEmpresa_Locnom_Z = "" ;
      gxTv_SdtEmpresa_Actcodigo_Z = "" ;
      gxTv_SdtEmpresa_Actdescrip_Z = "" ;
      gxTv_SdtEmpresa_Tipemplecod_Z = "" ;
      gxTv_SdtEmpresa_Empzoncod_Z = "" ;
      gxTv_SdtEmpresa_Empzondescrip_Z = "" ;
      gxTv_SdtEmpresa_Empactcomercial_Z = "" ;
      gxTv_SdtEmpresa_Tipempledefins_Z = "" ;
      gxTv_SdtEmpresa_Emplogonom_Z = "" ;
      gxTv_SdtEmpresa_Emplogoext_Z = "" ;
      gxTv_SdtEmpresa_Empfirmanom_Z = "" ;
      gxTv_SdtEmpresa_Empfirmaext_Z = "" ;
      gxTv_SdtEmpresa_Empantiguedad_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Emppresentismo_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Empmeshspext_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Empdiahspext_Z = "" ;
      gxTv_SdtEmpresa_Actcomcodigo_Z = "" ;
      gxTv_SdtEmpresa_Emppromdesde_Z = "" ;
      gxTv_SdtEmpresa_Empfracvacant_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEmpresa_Emposocod_Z = "" ;
      gxTv_SdtEmpresa_Empmodtra_Z = "" ;
      gxTv_SdtEmpresa_Cativacod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Cativadesc_N = (byte)(1) ;
      gxTv_SdtEmpresa_Emptel_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empcp_N = (byte)(1) ;
      gxTv_SdtEmpresa_Paicod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Provcod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Loccod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Actcodigo_N = (byte)(1) ;
      gxTv_SdtEmpresa_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empzoncod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Emplogo_N = (byte)(1) ;
      gxTv_SdtEmpresa_Emplogonom_N = (byte)(1) ;
      gxTv_SdtEmpresa_Emplogoext_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empfirma_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empfirmanom_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empfirmaext_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empmeshspext_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empdiahspext_N = (byte)(1) ;
      gxTv_SdtEmpresa_Emposocod_N = (byte)(1) ;
      gxTv_SdtEmpresa_Empultsexoing_N = (byte)(1) ;
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
      return gxTv_SdtEmpresa_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtEmpresa_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtEmpresa_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empnom = value ;
   }

   public long getEmpcuit( )
   {
      return gxTv_SdtEmpresa_Empcuit ;
   }

   public void setEmpcuit( long value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcuit = value ;
   }

   public short getCativacod( )
   {
      return gxTv_SdtEmpresa_Cativacod ;
   }

   public void setCativacod( short value )
   {
      gxTv_SdtEmpresa_Cativacod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativacod = value ;
   }

   public String getCativadesc( )
   {
      return gxTv_SdtEmpresa_Cativadesc ;
   }

   public void setCativadesc( String value )
   {
      gxTv_SdtEmpresa_Cativadesc_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativadesc = value ;
   }

   public String getEmpdir( )
   {
      return gxTv_SdtEmpresa_Empdir ;
   }

   public void setEmpdir( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empdir = value ;
   }

   public String getEmptel( )
   {
      return gxTv_SdtEmpresa_Emptel ;
   }

   public void setEmptel( String value )
   {
      gxTv_SdtEmpresa_Emptel_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emptel = value ;
   }

   public String getEmpcp( )
   {
      return gxTv_SdtEmpresa_Empcp ;
   }

   public void setEmpcp( String value )
   {
      gxTv_SdtEmpresa_Empcp_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcp = value ;
   }

   public short getPaicod( )
   {
      return gxTv_SdtEmpresa_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_SdtEmpresa_Paicod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Paicod = value ;
   }

   public String getPainom( )
   {
      return gxTv_SdtEmpresa_Painom ;
   }

   public void setPainom( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Painom = value ;
   }

   public short getProvcod( )
   {
      return gxTv_SdtEmpresa_Provcod ;
   }

   public void setProvcod( short value )
   {
      gxTv_SdtEmpresa_Provcod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Provcod = value ;
   }

   public String getProvnom( )
   {
      return gxTv_SdtEmpresa_Provnom ;
   }

   public void setProvnom( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Provnom = value ;
   }

   public short getLoccod( )
   {
      return gxTv_SdtEmpresa_Loccod ;
   }

   public void setLoccod( short value )
   {
      gxTv_SdtEmpresa_Loccod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Loccod = value ;
   }

   public String getLocnom( )
   {
      return gxTv_SdtEmpresa_Locnom ;
   }

   public void setLocnom( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Locnom = value ;
   }

   public String getActcodigo( )
   {
      return gxTv_SdtEmpresa_Actcodigo ;
   }

   public void setActcodigo( String value )
   {
      gxTv_SdtEmpresa_Actcodigo_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actcodigo = value ;
   }

   public String getActdescrip( )
   {
      return gxTv_SdtEmpresa_Actdescrip ;
   }

   public void setActdescrip( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actdescrip = value ;
   }

   public String getTipemplecod( )
   {
      return gxTv_SdtEmpresa_Tipemplecod ;
   }

   public void setTipemplecod( String value )
   {
      gxTv_SdtEmpresa_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipemplecod = value ;
   }

   public String getEmpzoncod( )
   {
      return gxTv_SdtEmpresa_Empzoncod ;
   }

   public void setEmpzoncod( String value )
   {
      gxTv_SdtEmpresa_Empzoncod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empzoncod = value ;
   }

   public String getEmpzondescrip( )
   {
      return gxTv_SdtEmpresa_Empzondescrip ;
   }

   public void setEmpzondescrip( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empzondescrip = value ;
   }

   public boolean getEmpreducc( )
   {
      return gxTv_SdtEmpresa_Empreducc ;
   }

   public void setEmpreducc( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empreducc = value ;
   }

   public String getEmpactcomercial( )
   {
      return gxTv_SdtEmpresa_Empactcomercial ;
   }

   public void setEmpactcomercial( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empactcomercial = value ;
   }

   public String getTipempledefins( )
   {
      return gxTv_SdtEmpresa_Tipempledefins ;
   }

   public void setTipempledefins( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipempledefins = value ;
   }

   public String getEmplogo( )
   {
      return gxTv_SdtEmpresa_Emplogo ;
   }

   public void setEmplogo( String value )
   {
      gxTv_SdtEmpresa_Emplogo_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogo = value ;
   }

   public String getEmplogonom( )
   {
      return gxTv_SdtEmpresa_Emplogonom ;
   }

   public void setEmplogonom( String value )
   {
      gxTv_SdtEmpresa_Emplogonom_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogonom = value ;
   }

   public String getEmplogoext( )
   {
      return gxTv_SdtEmpresa_Emplogoext ;
   }

   public void setEmplogoext( String value )
   {
      gxTv_SdtEmpresa_Emplogoext_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogoext = value ;
   }

   public String getEmpfirma( )
   {
      return gxTv_SdtEmpresa_Empfirma ;
   }

   public void setEmpfirma( String value )
   {
      gxTv_SdtEmpresa_Empfirma_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirma = value ;
   }

   public String getEmpfirmanom( )
   {
      return gxTv_SdtEmpresa_Empfirmanom ;
   }

   public void setEmpfirmanom( String value )
   {
      gxTv_SdtEmpresa_Empfirmanom_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmanom = value ;
   }

   public String getEmpfirmaext( )
   {
      return gxTv_SdtEmpresa_Empfirmaext ;
   }

   public void setEmpfirmaext( String value )
   {
      gxTv_SdtEmpresa_Empfirmaext_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmaext = value ;
   }

   public java.math.BigDecimal getEmpantiguedad( )
   {
      return gxTv_SdtEmpresa_Empantiguedad ;
   }

   public void setEmpantiguedad( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empantiguedad = value ;
   }

   public java.math.BigDecimal getEmppresentismo( )
   {
      return gxTv_SdtEmpresa_Emppresentismo ;
   }

   public void setEmppresentismo( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppresentismo = value ;
   }

   public java.math.BigDecimal getEmpmeshspext( )
   {
      return gxTv_SdtEmpresa_Empmeshspext ;
   }

   public void setEmpmeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_Empmeshspext_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empmeshspext = value ;
   }

   public String getEmpdiahspext( )
   {
      return gxTv_SdtEmpresa_Empdiahspext ;
   }

   public void setEmpdiahspext( String value )
   {
      gxTv_SdtEmpresa_Empdiahspext_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empdiahspext = value ;
   }

   public short getArtsec( )
   {
      return gxTv_SdtEmpresa_Artsec ;
   }

   public void setArtsec( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Artsec = value ;
   }

   public byte getEmppervacdes( )
   {
      return gxTv_SdtEmpresa_Emppervacdes ;
   }

   public void setEmppervacdes( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppervacdes = value ;
   }

   public byte getEmppervachas( )
   {
      return gxTv_SdtEmpresa_Emppervachas ;
   }

   public void setEmppervachas( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppervachas = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_jornalizados> getConceptos_horanormal_jornalizados( )
   {
      return gxTv_SdtEmpresa_Conceptos_horanormal_jornalizados ;
   }

   public void setConceptos_horanormal_jornalizados( java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_jornalizados> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Conceptos_horanormal_jornalizados = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_mensualizados> getConceptos_horanormal_mensualizados( )
   {
      return gxTv_SdtEmpresa_Conceptos_horanormal_mensualizados ;
   }

   public void setConceptos_horanormal_mensualizados( java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_mensualizados> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Conceptos_horanormal_mensualizados = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_promedio_horanormal_mensualizados> getPromedio_horanormal_mensualizados( )
   {
      return gxTv_SdtEmpresa_Promedio_horanormal_mensualizados ;
   }

   public void setPromedio_horanormal_mensualizados( java.util.Vector<web.StructSdtEmpresa_promedio_horanormal_mensualizados> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Promedio_horanormal_mensualizados = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_horasextras_pordia> getHorasextras_pordia( )
   {
      return gxTv_SdtEmpresa_Horasextras_pordia ;
   }

   public void setHorasextras_pordia( java.util.Vector<web.StructSdtEmpresa_horasextras_pordia> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Horasextras_pordia = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_tipo_trabajo> getTipo_trabajo( )
   {
      return gxTv_SdtEmpresa_Tipo_trabajo ;
   }

   public void setTipo_trabajo( java.util.Vector<web.StructSdtEmpresa_tipo_trabajo> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipo_trabajo = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_nolaborables_convenio> getNolaborables_convenio( )
   {
      return gxTv_SdtEmpresa_Nolaborables_convenio ;
   }

   public void setNolaborables_convenio( java.util.Vector<web.StructSdtEmpresa_nolaborables_convenio> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Nolaborables_convenio = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_nolaborables_origen> getNolaborables_origen( )
   {
      return gxTv_SdtEmpresa_Nolaborables_origen ;
   }

   public void setNolaborables_origen( java.util.Vector<web.StructSdtEmpresa_nolaborables_origen> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Nolaborables_origen = value ;
   }

   public java.util.Vector<web.StructSdtEmpresa_nolaborables_religion> getNolaborables_religion( )
   {
      return gxTv_SdtEmpresa_Nolaborables_religion ;
   }

   public void setNolaborables_religion( java.util.Vector<web.StructSdtEmpresa_nolaborables_religion> value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Nolaborables_religion = value ;
   }

   public boolean getEmpliqfer( )
   {
      return gxTv_SdtEmpresa_Empliqfer ;
   }

   public void setEmpliqfer( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqfer = value ;
   }

   public byte getEmpguaredadmin( )
   {
      return gxTv_SdtEmpresa_Empguaredadmin ;
   }

   public void setEmpguaredadmin( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empguaredadmin = value ;
   }

   public byte getEmpguaredadmax( )
   {
      return gxTv_SdtEmpresa_Empguaredadmax ;
   }

   public void setEmpguaredadmax( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empguaredadmax = value ;
   }

   public String getActcomcodigo( )
   {
      return gxTv_SdtEmpresa_Actcomcodigo ;
   }

   public void setActcomcodigo( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actcomcodigo = value ;
   }

   public boolean getEmpliqferjor( )
   {
      return gxTv_SdtEmpresa_Empliqferjor ;
   }

   public void setEmpliqferjor( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqferjor = value ;
   }

   public boolean getEmpliqgan( )
   {
      return gxTv_SdtEmpresa_Empliqgan ;
   }

   public void setEmpliqgan( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqgan = value ;
   }

   public byte getEmptipoexp( )
   {
      return gxTv_SdtEmpresa_Emptipoexp ;
   }

   public void setEmptipoexp( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emptipoexp = value ;
   }

   public String getEmppromdesde( )
   {
      return gxTv_SdtEmpresa_Emppromdesde ;
   }

   public void setEmppromdesde( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppromdesde = value ;
   }

   public java.math.BigDecimal getEmpfracvacant( )
   {
      return gxTv_SdtEmpresa_Empfracvacant ;
   }

   public void setEmpfracvacant( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfracvacant = value ;
   }

   public String getEmposocod( )
   {
      return gxTv_SdtEmpresa_Emposocod ;
   }

   public void setEmposocod( String value )
   {
      gxTv_SdtEmpresa_Emposocod_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emposocod = value ;
   }

   public byte getEmpultsexoing( )
   {
      return gxTv_SdtEmpresa_Empultsexoing ;
   }

   public void setEmpultsexoing( byte value )
   {
      gxTv_SdtEmpresa_Empultsexoing_N = (byte)(0) ;
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empultsexoing = value ;
   }

   public short getEmpcondicod( )
   {
      return gxTv_SdtEmpresa_Empcondicod ;
   }

   public void setEmpcondicod( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcondicod = value ;
   }

   public String getEmpmodtra( )
   {
      return gxTv_SdtEmpresa_Empmodtra ;
   }

   public void setEmpmodtra( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empmodtra = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEmpresa_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEmpresa_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtEmpresa_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtEmpresa_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtEmpresa_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empnom_Z = value ;
   }

   public long getEmpcuit_Z( )
   {
      return gxTv_SdtEmpresa_Empcuit_Z ;
   }

   public void setEmpcuit_Z( long value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcuit_Z = value ;
   }

   public short getCativacod_Z( )
   {
      return gxTv_SdtEmpresa_Cativacod_Z ;
   }

   public void setCativacod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativacod_Z = value ;
   }

   public String getCativadesc_Z( )
   {
      return gxTv_SdtEmpresa_Cativadesc_Z ;
   }

   public void setCativadesc_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativadesc_Z = value ;
   }

   public String getEmpdir_Z( )
   {
      return gxTv_SdtEmpresa_Empdir_Z ;
   }

   public void setEmpdir_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empdir_Z = value ;
   }

   public String getEmptel_Z( )
   {
      return gxTv_SdtEmpresa_Emptel_Z ;
   }

   public void setEmptel_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emptel_Z = value ;
   }

   public String getEmpcp_Z( )
   {
      return gxTv_SdtEmpresa_Empcp_Z ;
   }

   public void setEmpcp_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcp_Z = value ;
   }

   public short getPaicod_Z( )
   {
      return gxTv_SdtEmpresa_Paicod_Z ;
   }

   public void setPaicod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Paicod_Z = value ;
   }

   public String getPainom_Z( )
   {
      return gxTv_SdtEmpresa_Painom_Z ;
   }

   public void setPainom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Painom_Z = value ;
   }

   public short getProvcod_Z( )
   {
      return gxTv_SdtEmpresa_Provcod_Z ;
   }

   public void setProvcod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Provcod_Z = value ;
   }

   public String getProvnom_Z( )
   {
      return gxTv_SdtEmpresa_Provnom_Z ;
   }

   public void setProvnom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Provnom_Z = value ;
   }

   public short getLoccod_Z( )
   {
      return gxTv_SdtEmpresa_Loccod_Z ;
   }

   public void setLoccod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Loccod_Z = value ;
   }

   public String getLocnom_Z( )
   {
      return gxTv_SdtEmpresa_Locnom_Z ;
   }

   public void setLocnom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Locnom_Z = value ;
   }

   public String getActcodigo_Z( )
   {
      return gxTv_SdtEmpresa_Actcodigo_Z ;
   }

   public void setActcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actcodigo_Z = value ;
   }

   public String getActdescrip_Z( )
   {
      return gxTv_SdtEmpresa_Actdescrip_Z ;
   }

   public void setActdescrip_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actdescrip_Z = value ;
   }

   public String getTipemplecod_Z( )
   {
      return gxTv_SdtEmpresa_Tipemplecod_Z ;
   }

   public void setTipemplecod_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipemplecod_Z = value ;
   }

   public String getEmpzoncod_Z( )
   {
      return gxTv_SdtEmpresa_Empzoncod_Z ;
   }

   public void setEmpzoncod_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empzoncod_Z = value ;
   }

   public String getEmpzondescrip_Z( )
   {
      return gxTv_SdtEmpresa_Empzondescrip_Z ;
   }

   public void setEmpzondescrip_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empzondescrip_Z = value ;
   }

   public boolean getEmpreducc_Z( )
   {
      return gxTv_SdtEmpresa_Empreducc_Z ;
   }

   public void setEmpreducc_Z( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empreducc_Z = value ;
   }

   public String getEmpactcomercial_Z( )
   {
      return gxTv_SdtEmpresa_Empactcomercial_Z ;
   }

   public void setEmpactcomercial_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empactcomercial_Z = value ;
   }

   public String getTipempledefins_Z( )
   {
      return gxTv_SdtEmpresa_Tipempledefins_Z ;
   }

   public void setTipempledefins_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipempledefins_Z = value ;
   }

   public String getEmplogonom_Z( )
   {
      return gxTv_SdtEmpresa_Emplogonom_Z ;
   }

   public void setEmplogonom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogonom_Z = value ;
   }

   public String getEmplogoext_Z( )
   {
      return gxTv_SdtEmpresa_Emplogoext_Z ;
   }

   public void setEmplogoext_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogoext_Z = value ;
   }

   public String getEmpfirmanom_Z( )
   {
      return gxTv_SdtEmpresa_Empfirmanom_Z ;
   }

   public void setEmpfirmanom_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmanom_Z = value ;
   }

   public String getEmpfirmaext_Z( )
   {
      return gxTv_SdtEmpresa_Empfirmaext_Z ;
   }

   public void setEmpfirmaext_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmaext_Z = value ;
   }

   public java.math.BigDecimal getEmpantiguedad_Z( )
   {
      return gxTv_SdtEmpresa_Empantiguedad_Z ;
   }

   public void setEmpantiguedad_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empantiguedad_Z = value ;
   }

   public java.math.BigDecimal getEmppresentismo_Z( )
   {
      return gxTv_SdtEmpresa_Emppresentismo_Z ;
   }

   public void setEmppresentismo_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppresentismo_Z = value ;
   }

   public java.math.BigDecimal getEmpmeshspext_Z( )
   {
      return gxTv_SdtEmpresa_Empmeshspext_Z ;
   }

   public void setEmpmeshspext_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empmeshspext_Z = value ;
   }

   public String getEmpdiahspext_Z( )
   {
      return gxTv_SdtEmpresa_Empdiahspext_Z ;
   }

   public void setEmpdiahspext_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empdiahspext_Z = value ;
   }

   public short getArtsec_Z( )
   {
      return gxTv_SdtEmpresa_Artsec_Z ;
   }

   public void setArtsec_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Artsec_Z = value ;
   }

   public byte getEmppervacdes_Z( )
   {
      return gxTv_SdtEmpresa_Emppervacdes_Z ;
   }

   public void setEmppervacdes_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppervacdes_Z = value ;
   }

   public byte getEmppervachas_Z( )
   {
      return gxTv_SdtEmpresa_Emppervachas_Z ;
   }

   public void setEmppervachas_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppervachas_Z = value ;
   }

   public boolean getEmpliqfer_Z( )
   {
      return gxTv_SdtEmpresa_Empliqfer_Z ;
   }

   public void setEmpliqfer_Z( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqfer_Z = value ;
   }

   public byte getEmpguaredadmin_Z( )
   {
      return gxTv_SdtEmpresa_Empguaredadmin_Z ;
   }

   public void setEmpguaredadmin_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empguaredadmin_Z = value ;
   }

   public byte getEmpguaredadmax_Z( )
   {
      return gxTv_SdtEmpresa_Empguaredadmax_Z ;
   }

   public void setEmpguaredadmax_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empguaredadmax_Z = value ;
   }

   public String getActcomcodigo_Z( )
   {
      return gxTv_SdtEmpresa_Actcomcodigo_Z ;
   }

   public void setActcomcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actcomcodigo_Z = value ;
   }

   public boolean getEmpliqferjor_Z( )
   {
      return gxTv_SdtEmpresa_Empliqferjor_Z ;
   }

   public void setEmpliqferjor_Z( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqferjor_Z = value ;
   }

   public boolean getEmpliqgan_Z( )
   {
      return gxTv_SdtEmpresa_Empliqgan_Z ;
   }

   public void setEmpliqgan_Z( boolean value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empliqgan_Z = value ;
   }

   public byte getEmptipoexp_Z( )
   {
      return gxTv_SdtEmpresa_Emptipoexp_Z ;
   }

   public void setEmptipoexp_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emptipoexp_Z = value ;
   }

   public String getEmppromdesde_Z( )
   {
      return gxTv_SdtEmpresa_Emppromdesde_Z ;
   }

   public void setEmppromdesde_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emppromdesde_Z = value ;
   }

   public java.math.BigDecimal getEmpfracvacant_Z( )
   {
      return gxTv_SdtEmpresa_Empfracvacant_Z ;
   }

   public void setEmpfracvacant_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfracvacant_Z = value ;
   }

   public String getEmposocod_Z( )
   {
      return gxTv_SdtEmpresa_Emposocod_Z ;
   }

   public void setEmposocod_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emposocod_Z = value ;
   }

   public byte getEmpultsexoing_Z( )
   {
      return gxTv_SdtEmpresa_Empultsexoing_Z ;
   }

   public void setEmpultsexoing_Z( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empultsexoing_Z = value ;
   }

   public short getEmpcondicod_Z( )
   {
      return gxTv_SdtEmpresa_Empcondicod_Z ;
   }

   public void setEmpcondicod_Z( short value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcondicod_Z = value ;
   }

   public String getEmpmodtra_Z( )
   {
      return gxTv_SdtEmpresa_Empmodtra_Z ;
   }

   public void setEmpmodtra_Z( String value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empmodtra_Z = value ;
   }

   public byte getCativacod_N( )
   {
      return gxTv_SdtEmpresa_Cativacod_N ;
   }

   public void setCativacod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativacod_N = value ;
   }

   public byte getCativadesc_N( )
   {
      return gxTv_SdtEmpresa_Cativadesc_N ;
   }

   public void setCativadesc_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Cativadesc_N = value ;
   }

   public byte getEmptel_N( )
   {
      return gxTv_SdtEmpresa_Emptel_N ;
   }

   public void setEmptel_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emptel_N = value ;
   }

   public byte getEmpcp_N( )
   {
      return gxTv_SdtEmpresa_Empcp_N ;
   }

   public void setEmpcp_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empcp_N = value ;
   }

   public byte getPaicod_N( )
   {
      return gxTv_SdtEmpresa_Paicod_N ;
   }

   public void setPaicod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Paicod_N = value ;
   }

   public byte getProvcod_N( )
   {
      return gxTv_SdtEmpresa_Provcod_N ;
   }

   public void setProvcod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Provcod_N = value ;
   }

   public byte getLoccod_N( )
   {
      return gxTv_SdtEmpresa_Loccod_N ;
   }

   public void setLoccod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Loccod_N = value ;
   }

   public byte getActcodigo_N( )
   {
      return gxTv_SdtEmpresa_Actcodigo_N ;
   }

   public void setActcodigo_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Actcodigo_N = value ;
   }

   public byte getTipemplecod_N( )
   {
      return gxTv_SdtEmpresa_Tipemplecod_N ;
   }

   public void setTipemplecod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Tipemplecod_N = value ;
   }

   public byte getEmpzoncod_N( )
   {
      return gxTv_SdtEmpresa_Empzoncod_N ;
   }

   public void setEmpzoncod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empzoncod_N = value ;
   }

   public byte getEmplogo_N( )
   {
      return gxTv_SdtEmpresa_Emplogo_N ;
   }

   public void setEmplogo_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogo_N = value ;
   }

   public byte getEmplogonom_N( )
   {
      return gxTv_SdtEmpresa_Emplogonom_N ;
   }

   public void setEmplogonom_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogonom_N = value ;
   }

   public byte getEmplogoext_N( )
   {
      return gxTv_SdtEmpresa_Emplogoext_N ;
   }

   public void setEmplogoext_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emplogoext_N = value ;
   }

   public byte getEmpfirma_N( )
   {
      return gxTv_SdtEmpresa_Empfirma_N ;
   }

   public void setEmpfirma_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirma_N = value ;
   }

   public byte getEmpfirmanom_N( )
   {
      return gxTv_SdtEmpresa_Empfirmanom_N ;
   }

   public void setEmpfirmanom_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmanom_N = value ;
   }

   public byte getEmpfirmaext_N( )
   {
      return gxTv_SdtEmpresa_Empfirmaext_N ;
   }

   public void setEmpfirmaext_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empfirmaext_N = value ;
   }

   public byte getEmpmeshspext_N( )
   {
      return gxTv_SdtEmpresa_Empmeshspext_N ;
   }

   public void setEmpmeshspext_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empmeshspext_N = value ;
   }

   public byte getEmpdiahspext_N( )
   {
      return gxTv_SdtEmpresa_Empdiahspext_N ;
   }

   public void setEmpdiahspext_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empdiahspext_N = value ;
   }

   public byte getEmposocod_N( )
   {
      return gxTv_SdtEmpresa_Emposocod_N ;
   }

   public void setEmposocod_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Emposocod_N = value ;
   }

   public byte getEmpultsexoing_N( )
   {
      return gxTv_SdtEmpresa_Empultsexoing_N ;
   }

   public void setEmpultsexoing_N( byte value )
   {
      gxTv_SdtEmpresa_N = (byte)(0) ;
      gxTv_SdtEmpresa_Empultsexoing_N = value ;
   }

   protected byte gxTv_SdtEmpresa_Emppervacdes ;
   protected byte gxTv_SdtEmpresa_Emppervachas ;
   protected byte gxTv_SdtEmpresa_Empguaredadmin ;
   protected byte gxTv_SdtEmpresa_Empguaredadmax ;
   protected byte gxTv_SdtEmpresa_Emptipoexp ;
   protected byte gxTv_SdtEmpresa_Empultsexoing ;
   protected byte gxTv_SdtEmpresa_Emppervacdes_Z ;
   protected byte gxTv_SdtEmpresa_Emppervachas_Z ;
   protected byte gxTv_SdtEmpresa_Empguaredadmin_Z ;
   protected byte gxTv_SdtEmpresa_Empguaredadmax_Z ;
   protected byte gxTv_SdtEmpresa_Emptipoexp_Z ;
   protected byte gxTv_SdtEmpresa_Empultsexoing_Z ;
   protected byte gxTv_SdtEmpresa_Cativacod_N ;
   protected byte gxTv_SdtEmpresa_Cativadesc_N ;
   protected byte gxTv_SdtEmpresa_Emptel_N ;
   protected byte gxTv_SdtEmpresa_Empcp_N ;
   protected byte gxTv_SdtEmpresa_Paicod_N ;
   protected byte gxTv_SdtEmpresa_Provcod_N ;
   protected byte gxTv_SdtEmpresa_Loccod_N ;
   protected byte gxTv_SdtEmpresa_Actcodigo_N ;
   protected byte gxTv_SdtEmpresa_Tipemplecod_N ;
   protected byte gxTv_SdtEmpresa_Empzoncod_N ;
   protected byte gxTv_SdtEmpresa_Emplogo_N ;
   protected byte gxTv_SdtEmpresa_Emplogonom_N ;
   protected byte gxTv_SdtEmpresa_Emplogoext_N ;
   protected byte gxTv_SdtEmpresa_Empfirma_N ;
   protected byte gxTv_SdtEmpresa_Empfirmanom_N ;
   protected byte gxTv_SdtEmpresa_Empfirmaext_N ;
   protected byte gxTv_SdtEmpresa_Empmeshspext_N ;
   protected byte gxTv_SdtEmpresa_Empdiahspext_N ;
   protected byte gxTv_SdtEmpresa_Emposocod_N ;
   protected byte gxTv_SdtEmpresa_Empultsexoing_N ;
   private byte gxTv_SdtEmpresa_N ;
   protected short gxTv_SdtEmpresa_Empcod ;
   protected short gxTv_SdtEmpresa_Cativacod ;
   protected short gxTv_SdtEmpresa_Paicod ;
   protected short gxTv_SdtEmpresa_Provcod ;
   protected short gxTv_SdtEmpresa_Loccod ;
   protected short gxTv_SdtEmpresa_Artsec ;
   protected short gxTv_SdtEmpresa_Empcondicod ;
   protected short gxTv_SdtEmpresa_Initialized ;
   protected short gxTv_SdtEmpresa_Empcod_Z ;
   protected short gxTv_SdtEmpresa_Cativacod_Z ;
   protected short gxTv_SdtEmpresa_Paicod_Z ;
   protected short gxTv_SdtEmpresa_Provcod_Z ;
   protected short gxTv_SdtEmpresa_Loccod_Z ;
   protected short gxTv_SdtEmpresa_Artsec_Z ;
   protected short gxTv_SdtEmpresa_Empcondicod_Z ;
   protected int gxTv_SdtEmpresa_Clicod ;
   protected int gxTv_SdtEmpresa_Clicod_Z ;
   protected long gxTv_SdtEmpresa_Empcuit ;
   protected long gxTv_SdtEmpresa_Empcuit_Z ;
   protected String gxTv_SdtEmpresa_Empcp ;
   protected String gxTv_SdtEmpresa_Actcodigo ;
   protected String gxTv_SdtEmpresa_Tipemplecod ;
   protected String gxTv_SdtEmpresa_Empzoncod ;
   protected String gxTv_SdtEmpresa_Empactcomercial ;
   protected String gxTv_SdtEmpresa_Tipempledefins ;
   protected String gxTv_SdtEmpresa_Emplogoext ;
   protected String gxTv_SdtEmpresa_Empfirmaext ;
   protected String gxTv_SdtEmpresa_Empdiahspext ;
   protected String gxTv_SdtEmpresa_Actcomcodigo ;
   protected String gxTv_SdtEmpresa_Emppromdesde ;
   protected String gxTv_SdtEmpresa_Emposocod ;
   protected String gxTv_SdtEmpresa_Empmodtra ;
   protected String gxTv_SdtEmpresa_Mode ;
   protected String gxTv_SdtEmpresa_Empcp_Z ;
   protected String gxTv_SdtEmpresa_Actcodigo_Z ;
   protected String gxTv_SdtEmpresa_Tipemplecod_Z ;
   protected String gxTv_SdtEmpresa_Empzoncod_Z ;
   protected String gxTv_SdtEmpresa_Empactcomercial_Z ;
   protected String gxTv_SdtEmpresa_Tipempledefins_Z ;
   protected String gxTv_SdtEmpresa_Emplogoext_Z ;
   protected String gxTv_SdtEmpresa_Empfirmaext_Z ;
   protected String gxTv_SdtEmpresa_Empdiahspext_Z ;
   protected String gxTv_SdtEmpresa_Actcomcodigo_Z ;
   protected String gxTv_SdtEmpresa_Emppromdesde_Z ;
   protected String gxTv_SdtEmpresa_Emposocod_Z ;
   protected String gxTv_SdtEmpresa_Empmodtra_Z ;
   protected boolean gxTv_SdtEmpresa_Empreducc ;
   protected boolean gxTv_SdtEmpresa_Empliqfer ;
   protected boolean gxTv_SdtEmpresa_Empliqferjor ;
   protected boolean gxTv_SdtEmpresa_Empliqgan ;
   protected boolean gxTv_SdtEmpresa_Empreducc_Z ;
   protected boolean gxTv_SdtEmpresa_Empliqfer_Z ;
   protected boolean gxTv_SdtEmpresa_Empliqferjor_Z ;
   protected boolean gxTv_SdtEmpresa_Empliqgan_Z ;
   protected String gxTv_SdtEmpresa_Emplogo ;
   protected String gxTv_SdtEmpresa_Empfirma ;
   protected String gxTv_SdtEmpresa_Empnom ;
   protected String gxTv_SdtEmpresa_Cativadesc ;
   protected String gxTv_SdtEmpresa_Empdir ;
   protected String gxTv_SdtEmpresa_Emptel ;
   protected String gxTv_SdtEmpresa_Painom ;
   protected String gxTv_SdtEmpresa_Provnom ;
   protected String gxTv_SdtEmpresa_Locnom ;
   protected String gxTv_SdtEmpresa_Actdescrip ;
   protected String gxTv_SdtEmpresa_Empzondescrip ;
   protected String gxTv_SdtEmpresa_Emplogonom ;
   protected String gxTv_SdtEmpresa_Empfirmanom ;
   protected String gxTv_SdtEmpresa_Empnom_Z ;
   protected String gxTv_SdtEmpresa_Cativadesc_Z ;
   protected String gxTv_SdtEmpresa_Empdir_Z ;
   protected String gxTv_SdtEmpresa_Emptel_Z ;
   protected String gxTv_SdtEmpresa_Painom_Z ;
   protected String gxTv_SdtEmpresa_Provnom_Z ;
   protected String gxTv_SdtEmpresa_Locnom_Z ;
   protected String gxTv_SdtEmpresa_Actdescrip_Z ;
   protected String gxTv_SdtEmpresa_Empzondescrip_Z ;
   protected String gxTv_SdtEmpresa_Emplogonom_Z ;
   protected String gxTv_SdtEmpresa_Empfirmanom_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empantiguedad ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Emppresentismo ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empmeshspext ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empfracvacant ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empantiguedad_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Emppresentismo_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empmeshspext_Z ;
   protected java.math.BigDecimal gxTv_SdtEmpresa_Empfracvacant_Z ;
   protected java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_jornalizados> gxTv_SdtEmpresa_Conceptos_horanormal_jornalizados=null ;
   protected java.util.Vector<web.StructSdtEmpresa_conceptos_horanormal_mensualizados> gxTv_SdtEmpresa_Conceptos_horanormal_mensualizados=null ;
   protected java.util.Vector<web.StructSdtEmpresa_promedio_horanormal_mensualizados> gxTv_SdtEmpresa_Promedio_horanormal_mensualizados=null ;
   protected java.util.Vector<web.StructSdtEmpresa_horasextras_pordia> gxTv_SdtEmpresa_Horasextras_pordia=null ;
   protected java.util.Vector<web.StructSdtEmpresa_tipo_trabajo> gxTv_SdtEmpresa_Tipo_trabajo=null ;
   protected java.util.Vector<web.StructSdtEmpresa_nolaborables_convenio> gxTv_SdtEmpresa_Nolaborables_convenio=null ;
   protected java.util.Vector<web.StructSdtEmpresa_nolaborables_origen> gxTv_SdtEmpresa_Nolaborables_origen=null ;
   protected java.util.Vector<web.StructSdtEmpresa_nolaborables_religion> gxTv_SdtEmpresa_Nolaborables_religion=null ;
}

