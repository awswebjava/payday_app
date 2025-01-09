package web ;
import com.genexus.*;

public final  class StructSdtConvenio implements Cloneable, java.io.Serializable
{
   public StructSdtConvenio( )
   {
      this( -1, new ModelContext( StructSdtConvenio.class ));
   }

   public StructSdtConvenio( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_SdtConvenio_Convecodigo = "" ;
      gxTv_SdtConvenio_Convedescri = "" ;
      gxTv_SdtConvenio_Convedescrisinac = "" ;
      gxTv_SdtConvenio_Convesincod = "" ;
      gxTv_SdtConvenio_Convesindesc = "" ;
      gxTv_SdtConvenio_Convbusgoogle = "" ;
      gxTv_SdtConvenio_Convbusweb = "" ;
      gxTv_SdtConvenio_Convbaseurl = "" ;
      gxTv_SdtConvenio_Convscraptipo = "" ;
      gxTv_SdtConvenio_Convscraptdoc = "" ;
      gxTv_SdtConvenio_Mode = "" ;
      gxTv_SdtConvenio_Convecodigo_Z = "" ;
      gxTv_SdtConvenio_Convedescri_Z = "" ;
      gxTv_SdtConvenio_Convedescrisinac_Z = "" ;
      gxTv_SdtConvenio_Convesincod_Z = "" ;
      gxTv_SdtConvenio_Convesindesc_Z = "" ;
      gxTv_SdtConvenio_Convbusgoogle_Z = "" ;
      gxTv_SdtConvenio_Convbusweb_Z = "" ;
      gxTv_SdtConvenio_Convbaseurl_Z = "" ;
      gxTv_SdtConvenio_Convscraptipo_Z = "" ;
      gxTv_SdtConvenio_Convscraptdoc_Z = "" ;
      gxTv_SdtConvenio_Convesincod_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbusgoogle_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbusweb_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbaseurl_N = (byte)(1) ;
      gxTv_SdtConvenio_Convscraptipo_N = (byte)(1) ;
      gxTv_SdtConvenio_Convscraptdoc_N = (byte)(1) ;
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
      return gxTv_SdtConvenio_Paicod ;
   }

   public void setPaicod( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Paicod = value ;
   }

   public String getConvecodigo( )
   {
      return gxTv_SdtConvenio_Convecodigo ;
   }

   public void setConvecodigo( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convecodigo = value ;
   }

   public String getConvedescri( )
   {
      return gxTv_SdtConvenio_Convedescri ;
   }

   public void setConvedescri( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convedescri = value ;
   }

   public boolean getConvehabilitada( )
   {
      return gxTv_SdtConvenio_Convehabilitada ;
   }

   public void setConvehabilitada( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convehabilitada = value ;
   }

   public String getConvedescrisinac( )
   {
      return gxTv_SdtConvenio_Convedescrisinac ;
   }

   public void setConvedescrisinac( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convedescrisinac = value ;
   }

   public String getConvesincod( )
   {
      return gxTv_SdtConvenio_Convesincod ;
   }

   public void setConvesincod( String value )
   {
      gxTv_SdtConvenio_Convesincod_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convesincod = value ;
   }

   public String getConvesindesc( )
   {
      return gxTv_SdtConvenio_Convesindesc ;
   }

   public void setConvesindesc( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convesindesc = value ;
   }

   public String getConvbusgoogle( )
   {
      return gxTv_SdtConvenio_Convbusgoogle ;
   }

   public void setConvbusgoogle( String value )
   {
      gxTv_SdtConvenio_Convbusgoogle_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusgoogle = value ;
   }

   public String getConvbusweb( )
   {
      return gxTv_SdtConvenio_Convbusweb ;
   }

   public void setConvbusweb( String value )
   {
      gxTv_SdtConvenio_Convbusweb_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusweb = value ;
   }

   public String getConvbaseurl( )
   {
      return gxTv_SdtConvenio_Convbaseurl ;
   }

   public void setConvbaseurl( String value )
   {
      gxTv_SdtConvenio_Convbaseurl_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbaseurl = value ;
   }

   public String getConvscraptipo( )
   {
      return gxTv_SdtConvenio_Convscraptipo ;
   }

   public void setConvscraptipo( String value )
   {
      gxTv_SdtConvenio_Convscraptipo_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptipo = value ;
   }

   public String getConvscraptdoc( )
   {
      return gxTv_SdtConvenio_Convscraptdoc ;
   }

   public void setConvscraptdoc( String value )
   {
      gxTv_SdtConvenio_Convscraptdoc_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptdoc = value ;
   }

   public short getConveescfrecact( )
   {
      return gxTv_SdtConvenio_Conveescfrecact ;
   }

   public void setConveescfrecact( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Conveescfrecact = value ;
   }

   public boolean getConveesquemaes( )
   {
      return gxTv_SdtConvenio_Conveesquemaes ;
   }

   public void setConveesquemaes( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Conveesquemaes = value ;
   }

   public java.util.Vector<web.StructSdtConvenio_PropiedadesAdicionales> getPropiedadesadicionales( )
   {
      return gxTv_SdtConvenio_Propiedadesadicionales ;
   }

   public void setPropiedadesadicionales( java.util.Vector<web.StructSdtConvenio_PropiedadesAdicionales> value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Propiedadesadicionales = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConvenio_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConvenio_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Initialized = value ;
   }

   public short getPaicod_Z( )
   {
      return gxTv_SdtConvenio_Paicod_Z ;
   }

   public void setPaicod_Z( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Paicod_Z = value ;
   }

   public String getConvecodigo_Z( )
   {
      return gxTv_SdtConvenio_Convecodigo_Z ;
   }

   public void setConvecodigo_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convecodigo_Z = value ;
   }

   public String getConvedescri_Z( )
   {
      return gxTv_SdtConvenio_Convedescri_Z ;
   }

   public void setConvedescri_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convedescri_Z = value ;
   }

   public boolean getConvehabilitada_Z( )
   {
      return gxTv_SdtConvenio_Convehabilitada_Z ;
   }

   public void setConvehabilitada_Z( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convehabilitada_Z = value ;
   }

   public String getConvedescrisinac_Z( )
   {
      return gxTv_SdtConvenio_Convedescrisinac_Z ;
   }

   public void setConvedescrisinac_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convedescrisinac_Z = value ;
   }

   public String getConvesincod_Z( )
   {
      return gxTv_SdtConvenio_Convesincod_Z ;
   }

   public void setConvesincod_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convesincod_Z = value ;
   }

   public String getConvesindesc_Z( )
   {
      return gxTv_SdtConvenio_Convesindesc_Z ;
   }

   public void setConvesindesc_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convesindesc_Z = value ;
   }

   public String getConvbusgoogle_Z( )
   {
      return gxTv_SdtConvenio_Convbusgoogle_Z ;
   }

   public void setConvbusgoogle_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusgoogle_Z = value ;
   }

   public String getConvbusweb_Z( )
   {
      return gxTv_SdtConvenio_Convbusweb_Z ;
   }

   public void setConvbusweb_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusweb_Z = value ;
   }

   public String getConvbaseurl_Z( )
   {
      return gxTv_SdtConvenio_Convbaseurl_Z ;
   }

   public void setConvbaseurl_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbaseurl_Z = value ;
   }

   public String getConvscraptipo_Z( )
   {
      return gxTv_SdtConvenio_Convscraptipo_Z ;
   }

   public void setConvscraptipo_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptipo_Z = value ;
   }

   public String getConvscraptdoc_Z( )
   {
      return gxTv_SdtConvenio_Convscraptdoc_Z ;
   }

   public void setConvscraptdoc_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptdoc_Z = value ;
   }

   public short getConveescfrecact_Z( )
   {
      return gxTv_SdtConvenio_Conveescfrecact_Z ;
   }

   public void setConveescfrecact_Z( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Conveescfrecact_Z = value ;
   }

   public boolean getConveesquemaes_Z( )
   {
      return gxTv_SdtConvenio_Conveesquemaes_Z ;
   }

   public void setConveesquemaes_Z( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Conveesquemaes_Z = value ;
   }

   public byte getConvesincod_N( )
   {
      return gxTv_SdtConvenio_Convesincod_N ;
   }

   public void setConvesincod_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convesincod_N = value ;
   }

   public byte getConvbusgoogle_N( )
   {
      return gxTv_SdtConvenio_Convbusgoogle_N ;
   }

   public void setConvbusgoogle_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusgoogle_N = value ;
   }

   public byte getConvbusweb_N( )
   {
      return gxTv_SdtConvenio_Convbusweb_N ;
   }

   public void setConvbusweb_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbusweb_N = value ;
   }

   public byte getConvbaseurl_N( )
   {
      return gxTv_SdtConvenio_Convbaseurl_N ;
   }

   public void setConvbaseurl_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convbaseurl_N = value ;
   }

   public byte getConvscraptipo_N( )
   {
      return gxTv_SdtConvenio_Convscraptipo_N ;
   }

   public void setConvscraptipo_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptipo_N = value ;
   }

   public byte getConvscraptdoc_N( )
   {
      return gxTv_SdtConvenio_Convscraptdoc_N ;
   }

   public void setConvscraptdoc_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      gxTv_SdtConvenio_Convscraptdoc_N = value ;
   }

   protected byte gxTv_SdtConvenio_Convesincod_N ;
   protected byte gxTv_SdtConvenio_Convbusgoogle_N ;
   protected byte gxTv_SdtConvenio_Convbusweb_N ;
   protected byte gxTv_SdtConvenio_Convbaseurl_N ;
   protected byte gxTv_SdtConvenio_Convscraptipo_N ;
   protected byte gxTv_SdtConvenio_Convscraptdoc_N ;
   private byte gxTv_SdtConvenio_N ;
   protected short gxTv_SdtConvenio_Paicod ;
   protected short gxTv_SdtConvenio_Conveescfrecact ;
   protected short gxTv_SdtConvenio_Initialized ;
   protected short gxTv_SdtConvenio_Paicod_Z ;
   protected short gxTv_SdtConvenio_Conveescfrecact_Z ;
   protected String gxTv_SdtConvenio_Convecodigo ;
   protected String gxTv_SdtConvenio_Convesincod ;
   protected String gxTv_SdtConvenio_Convscraptipo ;
   protected String gxTv_SdtConvenio_Convscraptdoc ;
   protected String gxTv_SdtConvenio_Mode ;
   protected String gxTv_SdtConvenio_Convecodigo_Z ;
   protected String gxTv_SdtConvenio_Convesincod_Z ;
   protected String gxTv_SdtConvenio_Convscraptipo_Z ;
   protected String gxTv_SdtConvenio_Convscraptdoc_Z ;
   protected boolean gxTv_SdtConvenio_Convehabilitada ;
   protected boolean gxTv_SdtConvenio_Conveesquemaes ;
   protected boolean gxTv_SdtConvenio_Convehabilitada_Z ;
   protected boolean gxTv_SdtConvenio_Conveesquemaes_Z ;
   protected String gxTv_SdtConvenio_Convedescri ;
   protected String gxTv_SdtConvenio_Convedescrisinac ;
   protected String gxTv_SdtConvenio_Convesindesc ;
   protected String gxTv_SdtConvenio_Convbusgoogle ;
   protected String gxTv_SdtConvenio_Convbusweb ;
   protected String gxTv_SdtConvenio_Convbaseurl ;
   protected String gxTv_SdtConvenio_Convedescri_Z ;
   protected String gxTv_SdtConvenio_Convedescrisinac_Z ;
   protected String gxTv_SdtConvenio_Convesindesc_Z ;
   protected String gxTv_SdtConvenio_Convbusgoogle_Z ;
   protected String gxTv_SdtConvenio_Convbusweb_Z ;
   protected String gxTv_SdtConvenio_Convbaseurl_Z ;
   protected java.util.Vector<web.StructSdtConvenio_PropiedadesAdicionales> gxTv_SdtConvenio_Propiedadesadicionales=null ;
}

