package web ;
import com.genexus.*;

public final  class StructSdtCategoria implements Cloneable, java.io.Serializable
{
   public StructSdtCategoria( )
   {
      this( -1, new ModelContext( StructSdtCategoria.class ));
   }

   public StructSdtCategoria( int remoteHandle ,
                              ModelContext context )
   {
      gxTv_SdtCategoria_Cliconvenio = "" ;
      gxTv_SdtCategoria_Catcodigo = "" ;
      gxTv_SdtCategoria_Catdescrip = "" ;
      gxTv_SdtCategoria_Catdescripsinac = "" ;
      gxTv_SdtCategoria_Cattipotarifa = "" ;
      gxTv_SdtCategoria_Catrelref = "" ;
      gxTv_SdtCategoria_Catold = "" ;
      gxTv_SdtCategoria_Catafipcod = "" ;
      gxTv_SdtCategoria_Mode = "" ;
      gxTv_SdtCategoria_Cliconvenio_Z = "" ;
      gxTv_SdtCategoria_Catcodigo_Z = "" ;
      gxTv_SdtCategoria_Catdescrip_Z = "" ;
      gxTv_SdtCategoria_Catdescripsinac_Z = "" ;
      gxTv_SdtCategoria_Cattipotarifa_Z = "" ;
      gxTv_SdtCategoria_Catrelref_Z = "" ;
      gxTv_SdtCategoria_Catafipcod_Z = "" ;
      gxTv_SdtCategoria_Catrelsec_N = (byte)(1) ;
      gxTv_SdtCategoria_Catafipcod_N = (byte)(1) ;
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
      return gxTv_SdtCategoria_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Clicod = value ;
   }

   public short getClipaiconve( )
   {
      return gxTv_SdtCategoria_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_SdtCategoria_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Cliconvenio = value ;
   }

   public String getCatcodigo( )
   {
      return gxTv_SdtCategoria_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catcodigo = value ;
   }

   public String getCatdescrip( )
   {
      return gxTv_SdtCategoria_Catdescrip ;
   }

   public void setCatdescrip( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catdescrip = value ;
   }

   public String getCatdescripsinac( )
   {
      return gxTv_SdtCategoria_Catdescripsinac ;
   }

   public void setCatdescripsinac( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catdescripsinac = value ;
   }

   public byte getCatclase( )
   {
      return gxTv_SdtCategoria_Catclase ;
   }

   public void setCatclase( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catclase = value ;
   }

   public String getCattipotarifa( )
   {
      return gxTv_SdtCategoria_Cattipotarifa ;
   }

   public void setCattipotarifa( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Cattipotarifa = value ;
   }

   public byte getCatfrecact( )
   {
      return gxTv_SdtCategoria_Catfrecact ;
   }

   public void setCatfrecact( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catfrecact = value ;
   }

   public short getCatrelsec( )
   {
      return gxTv_SdtCategoria_Catrelsec ;
   }

   public void setCatrelsec( short value )
   {
      gxTv_SdtCategoria_Catrelsec_N = (byte)(0) ;
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catrelsec = value ;
   }

   public String getCatrelref( )
   {
      return gxTv_SdtCategoria_Catrelref ;
   }

   public void setCatrelref( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catrelref = value ;
   }

   public String getCatold( )
   {
      return gxTv_SdtCategoria_Catold ;
   }

   public void setCatold( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catold = value ;
   }

   public String getCatafipcod( )
   {
      return gxTv_SdtCategoria_Catafipcod ;
   }

   public void setCatafipcod( String value )
   {
      gxTv_SdtCategoria_Catafipcod_N = (byte)(0) ;
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catafipcod = value ;
   }

   public java.util.Vector<web.StructSdtCategoria_Provincias> getProvincias( )
   {
      return gxTv_SdtCategoria_Provincias ;
   }

   public void setProvincias( java.util.Vector<web.StructSdtCategoria_Provincias> value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias = value ;
   }

   public java.util.Vector<web.StructSdtCategoria_valores> getValores( )
   {
      return gxTv_SdtCategoria_Valores ;
   }

   public void setValores( java.util.Vector<web.StructSdtCategoria_valores> value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Valores = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCategoria_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCategoria_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtCategoria_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Clicod_Z = value ;
   }

   public short getClipaiconve_Z( )
   {
      return gxTv_SdtCategoria_Clipaiconve_Z ;
   }

   public void setClipaiconve_Z( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Clipaiconve_Z = value ;
   }

   public String getCliconvenio_Z( )
   {
      return gxTv_SdtCategoria_Cliconvenio_Z ;
   }

   public void setCliconvenio_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Cliconvenio_Z = value ;
   }

   public String getCatcodigo_Z( )
   {
      return gxTv_SdtCategoria_Catcodigo_Z ;
   }

   public void setCatcodigo_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catcodigo_Z = value ;
   }

   public String getCatdescrip_Z( )
   {
      return gxTv_SdtCategoria_Catdescrip_Z ;
   }

   public void setCatdescrip_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catdescrip_Z = value ;
   }

   public String getCatdescripsinac_Z( )
   {
      return gxTv_SdtCategoria_Catdescripsinac_Z ;
   }

   public void setCatdescripsinac_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catdescripsinac_Z = value ;
   }

   public byte getCatclase_Z( )
   {
      return gxTv_SdtCategoria_Catclase_Z ;
   }

   public void setCatclase_Z( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catclase_Z = value ;
   }

   public String getCattipotarifa_Z( )
   {
      return gxTv_SdtCategoria_Cattipotarifa_Z ;
   }

   public void setCattipotarifa_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Cattipotarifa_Z = value ;
   }

   public byte getCatfrecact_Z( )
   {
      return gxTv_SdtCategoria_Catfrecact_Z ;
   }

   public void setCatfrecact_Z( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catfrecact_Z = value ;
   }

   public short getCatrelsec_Z( )
   {
      return gxTv_SdtCategoria_Catrelsec_Z ;
   }

   public void setCatrelsec_Z( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catrelsec_Z = value ;
   }

   public String getCatrelref_Z( )
   {
      return gxTv_SdtCategoria_Catrelref_Z ;
   }

   public void setCatrelref_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catrelref_Z = value ;
   }

   public String getCatafipcod_Z( )
   {
      return gxTv_SdtCategoria_Catafipcod_Z ;
   }

   public void setCatafipcod_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catafipcod_Z = value ;
   }

   public byte getCatrelsec_N( )
   {
      return gxTv_SdtCategoria_Catrelsec_N ;
   }

   public void setCatrelsec_N( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catrelsec_N = value ;
   }

   public byte getCatafipcod_N( )
   {
      return gxTv_SdtCategoria_Catafipcod_N ;
   }

   public void setCatafipcod_N( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      gxTv_SdtCategoria_Catafipcod_N = value ;
   }

   protected byte gxTv_SdtCategoria_Catclase ;
   protected byte gxTv_SdtCategoria_Catfrecact ;
   protected byte gxTv_SdtCategoria_Catclase_Z ;
   protected byte gxTv_SdtCategoria_Catfrecact_Z ;
   protected byte gxTv_SdtCategoria_Catrelsec_N ;
   protected byte gxTv_SdtCategoria_Catafipcod_N ;
   private byte gxTv_SdtCategoria_N ;
   protected short gxTv_SdtCategoria_Clipaiconve ;
   protected short gxTv_SdtCategoria_Catrelsec ;
   protected short gxTv_SdtCategoria_Initialized ;
   protected short gxTv_SdtCategoria_Clipaiconve_Z ;
   protected short gxTv_SdtCategoria_Catrelsec_Z ;
   protected int gxTv_SdtCategoria_Clicod ;
   protected int gxTv_SdtCategoria_Clicod_Z ;
   protected String gxTv_SdtCategoria_Cliconvenio ;
   protected String gxTv_SdtCategoria_Catcodigo ;
   protected String gxTv_SdtCategoria_Cattipotarifa ;
   protected String gxTv_SdtCategoria_Catafipcod ;
   protected String gxTv_SdtCategoria_Mode ;
   protected String gxTv_SdtCategoria_Cliconvenio_Z ;
   protected String gxTv_SdtCategoria_Catcodigo_Z ;
   protected String gxTv_SdtCategoria_Cattipotarifa_Z ;
   protected String gxTv_SdtCategoria_Catafipcod_Z ;
   protected String gxTv_SdtCategoria_Catold ;
   protected String gxTv_SdtCategoria_Catdescrip ;
   protected String gxTv_SdtCategoria_Catdescripsinac ;
   protected String gxTv_SdtCategoria_Catrelref ;
   protected String gxTv_SdtCategoria_Catdescrip_Z ;
   protected String gxTv_SdtCategoria_Catdescripsinac_Z ;
   protected String gxTv_SdtCategoria_Catrelref_Z ;
   protected java.util.Vector<web.StructSdtCategoria_Provincias> gxTv_SdtCategoria_Provincias=null ;
   protected java.util.Vector<web.StructSdtCategoria_valores> gxTv_SdtCategoria_Valores=null ;
}

