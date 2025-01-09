package web ;
import com.genexus.*;

public final  class StructSdtEstado implements Cloneable, java.io.Serializable
{
   public StructSdtEstado( )
   {
      this( -1, new ModelContext( StructSdtEstado.class ));
   }

   public StructSdtEstado( int remoteHandle ,
                           ModelContext context )
   {
      gxTv_SdtEstado_Sitcodigo = "" ;
      gxTv_SdtEstado_Sitdescrip = "" ;
      gxTv_SdtEstado_Sitdescripsinac = "" ;
      gxTv_SdtEstado_Sitdescabrev = "" ;
      gxTv_SdtEstado_Sitdiasdivision = new java.math.BigDecimal(0) ;
      gxTv_SdtEstado_Estadosiniestro = "" ;
      gxTv_SdtEstado_Mode = "" ;
      gxTv_SdtEstado_Sitcodigo_Z = "" ;
      gxTv_SdtEstado_Sitdescrip_Z = "" ;
      gxTv_SdtEstado_Sitdescripsinac_Z = "" ;
      gxTv_SdtEstado_Sitdescabrev_Z = "" ;
      gxTv_SdtEstado_Sitdiasdivision_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtEstado_Estadosiniestro_Z = "" ;
      gxTv_SdtEstado_Sitpaicod_N = (byte)(1) ;
      gxTv_SdtEstado_Estadositrevista_N = (byte)(1) ;
      gxTv_SdtEstado_Estadosiniestro_N = (byte)(1) ;
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

   public String getSitcodigo( )
   {
      return gxTv_SdtEstado_Sitcodigo ;
   }

   public void setSitcodigo( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitcodigo = value ;
   }

   public String getSitdescrip( )
   {
      return gxTv_SdtEstado_Sitdescrip ;
   }

   public void setSitdescrip( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescrip = value ;
   }

   public String getSitdescripsinac( )
   {
      return gxTv_SdtEstado_Sitdescripsinac ;
   }

   public void setSitdescripsinac( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescripsinac = value ;
   }

   public boolean getSiteslicencia( )
   {
      return gxTv_SdtEstado_Siteslicencia ;
   }

   public void setSiteslicencia( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Siteslicencia = value ;
   }

   public boolean getSitliccuentatrab( )
   {
      return gxTv_SdtEstado_Sitliccuentatrab ;
   }

   public void setSitliccuentatrab( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitliccuentatrab = value ;
   }

   public byte getSitlicmesesprom( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom ;
   }

   public void setSitlicmesesprom( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicmesesprom = value ;
   }

   public byte getSitlicmesesprom2( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom2 ;
   }

   public void setSitlicmesesprom2( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicmesesprom2 = value ;
   }

   public String getSitdescabrev( )
   {
      return gxTv_SdtEstado_Sitdescabrev ;
   }

   public void setSitdescabrev( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescabrev = value ;
   }

   public java.math.BigDecimal getSitdiasdivision( )
   {
      return gxTv_SdtEstado_Sitdiasdivision ;
   }

   public void setSitdiasdivision( java.math.BigDecimal value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdiasdivision = value ;
   }

   public boolean getSitesausencia( )
   {
      return gxTv_SdtEstado_Sitesausencia ;
   }

   public void setSitesausencia( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitesausencia = value ;
   }

   public byte getSitaplicaplus( )
   {
      return gxTv_SdtEstado_Sitaplicaplus ;
   }

   public void setSitaplicaplus( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitaplicaplus = value ;
   }

   public boolean getSitabsorbefer( )
   {
      return gxTv_SdtEstado_Sitabsorbefer ;
   }

   public void setSitabsorbefer( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitabsorbefer = value ;
   }

   public short getSitliclimitedef( )
   {
      return gxTv_SdtEstado_Sitliclimitedef ;
   }

   public void setSitliclimitedef( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitliclimitedef = value ;
   }

   public boolean getSitlicadjundef( )
   {
      return gxTv_SdtEstado_Sitlicadjundef ;
   }

   public void setSitlicadjundef( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicadjundef = value ;
   }

   public boolean getSitlicadjobldef( )
   {
      return gxTv_SdtEstado_Sitlicadjobldef ;
   }

   public void setSitlicadjobldef( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicadjobldef = value ;
   }

   public boolean getSitlicnecapr( )
   {
      return gxTv_SdtEstado_Sitlicnecapr ;
   }

   public void setSitlicnecapr( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicnecapr = value ;
   }

   public boolean getSitlicingmot( )
   {
      return gxTv_SdtEstado_Sitlicingmot ;
   }

   public void setSitlicingmot( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicingmot = value ;
   }

   public boolean getSitlicoblingmot( )
   {
      return gxTv_SdtEstado_Sitlicoblingmot ;
   }

   public void setSitlicoblingmot( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicoblingmot = value ;
   }

   public short getSitpaicod( )
   {
      return gxTv_SdtEstado_Sitpaicod ;
   }

   public void setSitpaicod( short value )
   {
      gxTv_SdtEstado_Sitpaicod_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitpaicod = value ;
   }

   public short getEstadositrevista( )
   {
      return gxTv_SdtEstado_Estadositrevista ;
   }

   public void setEstadositrevista( short value )
   {
      gxTv_SdtEstado_Estadositrevista_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadositrevista = value ;
   }

   public String getEstadosiniestro( )
   {
      return gxTv_SdtEstado_Estadosiniestro ;
   }

   public void setEstadosiniestro( String value )
   {
      gxTv_SdtEstado_Estadosiniestro_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadosiniestro = value ;
   }

   public boolean getEstadocanpresen( )
   {
      return gxTv_SdtEstado_Estadocanpresen ;
   }

   public void setEstadocanpresen( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadocanpresen = value ;
   }

   public boolean getEstadoremcorr( )
   {
      return gxTv_SdtEstado_Estadoremcorr ;
   }

   public void setEstadoremcorr( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadoremcorr = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEstado_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEstado_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Initialized = value ;
   }

   public String getSitcodigo_Z( )
   {
      return gxTv_SdtEstado_Sitcodigo_Z ;
   }

   public void setSitcodigo_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitcodigo_Z = value ;
   }

   public String getSitdescrip_Z( )
   {
      return gxTv_SdtEstado_Sitdescrip_Z ;
   }

   public void setSitdescrip_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescrip_Z = value ;
   }

   public String getSitdescripsinac_Z( )
   {
      return gxTv_SdtEstado_Sitdescripsinac_Z ;
   }

   public void setSitdescripsinac_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescripsinac_Z = value ;
   }

   public boolean getSiteslicencia_Z( )
   {
      return gxTv_SdtEstado_Siteslicencia_Z ;
   }

   public void setSiteslicencia_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Siteslicencia_Z = value ;
   }

   public boolean getSitliccuentatrab_Z( )
   {
      return gxTv_SdtEstado_Sitliccuentatrab_Z ;
   }

   public void setSitliccuentatrab_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitliccuentatrab_Z = value ;
   }

   public byte getSitlicmesesprom_Z( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom_Z ;
   }

   public void setSitlicmesesprom_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicmesesprom_Z = value ;
   }

   public byte getSitlicmesesprom2_Z( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom2_Z ;
   }

   public void setSitlicmesesprom2_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicmesesprom2_Z = value ;
   }

   public String getSitdescabrev_Z( )
   {
      return gxTv_SdtEstado_Sitdescabrev_Z ;
   }

   public void setSitdescabrev_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdescabrev_Z = value ;
   }

   public java.math.BigDecimal getSitdiasdivision_Z( )
   {
      return gxTv_SdtEstado_Sitdiasdivision_Z ;
   }

   public void setSitdiasdivision_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitdiasdivision_Z = value ;
   }

   public boolean getSitesausencia_Z( )
   {
      return gxTv_SdtEstado_Sitesausencia_Z ;
   }

   public void setSitesausencia_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitesausencia_Z = value ;
   }

   public byte getSitaplicaplus_Z( )
   {
      return gxTv_SdtEstado_Sitaplicaplus_Z ;
   }

   public void setSitaplicaplus_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitaplicaplus_Z = value ;
   }

   public boolean getSitabsorbefer_Z( )
   {
      return gxTv_SdtEstado_Sitabsorbefer_Z ;
   }

   public void setSitabsorbefer_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitabsorbefer_Z = value ;
   }

   public short getSitliclimitedef_Z( )
   {
      return gxTv_SdtEstado_Sitliclimitedef_Z ;
   }

   public void setSitliclimitedef_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitliclimitedef_Z = value ;
   }

   public boolean getSitlicadjundef_Z( )
   {
      return gxTv_SdtEstado_Sitlicadjundef_Z ;
   }

   public void setSitlicadjundef_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicadjundef_Z = value ;
   }

   public boolean getSitlicadjobldef_Z( )
   {
      return gxTv_SdtEstado_Sitlicadjobldef_Z ;
   }

   public void setSitlicadjobldef_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicadjobldef_Z = value ;
   }

   public boolean getSitlicnecapr_Z( )
   {
      return gxTv_SdtEstado_Sitlicnecapr_Z ;
   }

   public void setSitlicnecapr_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicnecapr_Z = value ;
   }

   public boolean getSitlicingmot_Z( )
   {
      return gxTv_SdtEstado_Sitlicingmot_Z ;
   }

   public void setSitlicingmot_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicingmot_Z = value ;
   }

   public boolean getSitlicoblingmot_Z( )
   {
      return gxTv_SdtEstado_Sitlicoblingmot_Z ;
   }

   public void setSitlicoblingmot_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitlicoblingmot_Z = value ;
   }

   public short getSitpaicod_Z( )
   {
      return gxTv_SdtEstado_Sitpaicod_Z ;
   }

   public void setSitpaicod_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitpaicod_Z = value ;
   }

   public short getEstadositrevista_Z( )
   {
      return gxTv_SdtEstado_Estadositrevista_Z ;
   }

   public void setEstadositrevista_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadositrevista_Z = value ;
   }

   public String getEstadosiniestro_Z( )
   {
      return gxTv_SdtEstado_Estadosiniestro_Z ;
   }

   public void setEstadosiniestro_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadosiniestro_Z = value ;
   }

   public boolean getEstadocanpresen_Z( )
   {
      return gxTv_SdtEstado_Estadocanpresen_Z ;
   }

   public void setEstadocanpresen_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadocanpresen_Z = value ;
   }

   public boolean getEstadoremcorr_Z( )
   {
      return gxTv_SdtEstado_Estadoremcorr_Z ;
   }

   public void setEstadoremcorr_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadoremcorr_Z = value ;
   }

   public byte getSitpaicod_N( )
   {
      return gxTv_SdtEstado_Sitpaicod_N ;
   }

   public void setSitpaicod_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Sitpaicod_N = value ;
   }

   public byte getEstadositrevista_N( )
   {
      return gxTv_SdtEstado_Estadositrevista_N ;
   }

   public void setEstadositrevista_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadositrevista_N = value ;
   }

   public byte getEstadosiniestro_N( )
   {
      return gxTv_SdtEstado_Estadosiniestro_N ;
   }

   public void setEstadosiniestro_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      gxTv_SdtEstado_Estadosiniestro_N = value ;
   }

   protected byte gxTv_SdtEstado_Sitlicmesesprom ;
   protected byte gxTv_SdtEstado_Sitlicmesesprom2 ;
   protected byte gxTv_SdtEstado_Sitaplicaplus ;
   protected byte gxTv_SdtEstado_Sitlicmesesprom_Z ;
   protected byte gxTv_SdtEstado_Sitlicmesesprom2_Z ;
   protected byte gxTv_SdtEstado_Sitaplicaplus_Z ;
   protected byte gxTv_SdtEstado_Sitpaicod_N ;
   protected byte gxTv_SdtEstado_Estadositrevista_N ;
   protected byte gxTv_SdtEstado_Estadosiniestro_N ;
   private byte gxTv_SdtEstado_N ;
   protected short gxTv_SdtEstado_Sitliclimitedef ;
   protected short gxTv_SdtEstado_Sitpaicod ;
   protected short gxTv_SdtEstado_Estadositrevista ;
   protected short gxTv_SdtEstado_Initialized ;
   protected short gxTv_SdtEstado_Sitliclimitedef_Z ;
   protected short gxTv_SdtEstado_Sitpaicod_Z ;
   protected short gxTv_SdtEstado_Estadositrevista_Z ;
   protected String gxTv_SdtEstado_Sitcodigo ;
   protected String gxTv_SdtEstado_Estadosiniestro ;
   protected String gxTv_SdtEstado_Mode ;
   protected String gxTv_SdtEstado_Sitcodigo_Z ;
   protected String gxTv_SdtEstado_Estadosiniestro_Z ;
   protected boolean gxTv_SdtEstado_Siteslicencia ;
   protected boolean gxTv_SdtEstado_Sitliccuentatrab ;
   protected boolean gxTv_SdtEstado_Sitesausencia ;
   protected boolean gxTv_SdtEstado_Sitabsorbefer ;
   protected boolean gxTv_SdtEstado_Sitlicadjundef ;
   protected boolean gxTv_SdtEstado_Sitlicadjobldef ;
   protected boolean gxTv_SdtEstado_Sitlicnecapr ;
   protected boolean gxTv_SdtEstado_Sitlicingmot ;
   protected boolean gxTv_SdtEstado_Sitlicoblingmot ;
   protected boolean gxTv_SdtEstado_Estadocanpresen ;
   protected boolean gxTv_SdtEstado_Estadoremcorr ;
   protected boolean gxTv_SdtEstado_Siteslicencia_Z ;
   protected boolean gxTv_SdtEstado_Sitliccuentatrab_Z ;
   protected boolean gxTv_SdtEstado_Sitesausencia_Z ;
   protected boolean gxTv_SdtEstado_Sitabsorbefer_Z ;
   protected boolean gxTv_SdtEstado_Sitlicadjundef_Z ;
   protected boolean gxTv_SdtEstado_Sitlicadjobldef_Z ;
   protected boolean gxTv_SdtEstado_Sitlicnecapr_Z ;
   protected boolean gxTv_SdtEstado_Sitlicingmot_Z ;
   protected boolean gxTv_SdtEstado_Sitlicoblingmot_Z ;
   protected boolean gxTv_SdtEstado_Estadocanpresen_Z ;
   protected boolean gxTv_SdtEstado_Estadoremcorr_Z ;
   protected String gxTv_SdtEstado_Sitdescrip ;
   protected String gxTv_SdtEstado_Sitdescripsinac ;
   protected String gxTv_SdtEstado_Sitdescabrev ;
   protected String gxTv_SdtEstado_Sitdescrip_Z ;
   protected String gxTv_SdtEstado_Sitdescripsinac_Z ;
   protected String gxTv_SdtEstado_Sitdescabrev_Z ;
   protected java.math.BigDecimal gxTv_SdtEstado_Sitdiasdivision ;
   protected java.math.BigDecimal gxTv_SdtEstado_Sitdiasdivision_Z ;
}

