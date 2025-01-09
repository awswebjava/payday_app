package web ;
import com.genexus.*;

public final  class StructSdtconvenio_adicional implements Cloneable, java.io.Serializable
{
   public StructSdtconvenio_adicional( )
   {
      this( -1, new ModelContext( StructSdtconvenio_adicional.class ));
   }

   public StructSdtconvenio_adicional( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_Sdtconvenio_adicional_Cliconvenio = "" ;
      gxTv_Sdtconvenio_adicional_Conveadicod = "" ;
      gxTv_Sdtconvenio_adicional_Conveadidescri = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiali = new java.math.BigDecimal(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo = "" ;
      gxTv_Sdtconvenio_adicional_Conveaditipo = "" ;
      gxTv_Sdtconvenio_adicional_Conveadirelref = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiold = "" ;
      gxTv_Sdtconvenio_adicional_Mode = "" ;
      gxTv_Sdtconvenio_adicional_Cliconvenio_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadicod_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadidescri_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiali_Z = new java.math.BigDecimal(0) ;
      gxTv_Sdtconvenio_adicional_Conveaditipo_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadirelref_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(1) ;
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
      return gxTv_Sdtconvenio_adicional_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Clicod = value ;
   }

   public short getClipaiconve( )
   {
      return gxTv_Sdtconvenio_adicional_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Clipaiconve = value ;
   }

   public String getCliconvenio( )
   {
      return gxTv_Sdtconvenio_adicional_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cliconvenio = value ;
   }

   public String getConveadicod( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadicod = value ;
   }

   public String getConveadidescri( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadidescri ;
   }

   public void setConveadidescri( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadidescri = value ;
   }

   public java.math.BigDecimal getConveadiali( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiali ;
   }

   public void setConveadiali( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiali = value ;
   }

   public String getConveadiinfo( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiinfo ;
   }

   public void setConveadiinfo( String value )
   {
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo = value ;
   }

   public String getConveaditipo( )
   {
      return gxTv_Sdtconvenio_adicional_Conveaditipo ;
   }

   public void setConveaditipo( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveaditipo = value ;
   }

   public int getConveadirelsec( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec ;
   }

   public void setConveadirelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadirelsec = value ;
   }

   public String getConveadirelref( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelref ;
   }

   public void setConveadirelref( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadirelref = value ;
   }

   public String getConveadiold( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiold ;
   }

   public void setConveadiold( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiold = value ;
   }

   public java.util.Vector<web.StructSdtconvenio_adicional_Cancela> getCancela( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela ;
   }

   public void setCancela( java.util.Vector<web.StructSdtconvenio_adicional_Cancela> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela = value ;
   }

   public java.util.Vector<web.StructSdtconvenio_adicional_importes> getImportes( )
   {
      return gxTv_Sdtconvenio_adicional_Importes ;
   }

   public void setImportes( java.util.Vector<web.StructSdtconvenio_adicional_importes> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Importes = value ;
   }

   public java.util.Vector<web.StructSdtconvenio_adicional_alicuotas> getAlicuotas( )
   {
      return gxTv_Sdtconvenio_adicional_Alicuotas ;
   }

   public void setAlicuotas( java.util.Vector<web.StructSdtconvenio_adicional_alicuotas> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Alicuotas = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtconvenio_adicional_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtconvenio_adicional_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Clicod_Z = value ;
   }

   public short getClipaiconve_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Clipaiconve_Z ;
   }

   public void setClipaiconve_Z( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Clipaiconve_Z = value ;
   }

   public String getCliconvenio_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Cliconvenio_Z ;
   }

   public void setCliconvenio_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cliconvenio_Z = value ;
   }

   public String getConveadicod_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadicod_Z ;
   }

   public void setConveadicod_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadicod_Z = value ;
   }

   public String getConveadidescri_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadidescri_Z ;
   }

   public void setConveadidescri_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadidescri_Z = value ;
   }

   public java.math.BigDecimal getConveadiali_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiali_Z ;
   }

   public void setConveadiali_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiali_Z = value ;
   }

   public String getConveaditipo_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveaditipo_Z ;
   }

   public void setConveaditipo_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveaditipo_Z = value ;
   }

   public int getConveadirelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec_Z ;
   }

   public void setConveadirelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadirelsec_Z = value ;
   }

   public String getConveadirelref_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelref_Z ;
   }

   public void setConveadirelref_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadirelref_Z = value ;
   }

   public byte getConveadiinfo_N( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiinfo_N ;
   }

   public void setConveadiinfo_N( byte value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = value ;
   }

   public byte getConveadirelsec_N( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec_N ;
   }

   public void setConveadirelsec_N( byte value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = value ;
   }

   protected byte gxTv_Sdtconvenio_adicional_Conveadiinfo_N ;
   protected byte gxTv_Sdtconvenio_adicional_Conveadirelsec_N ;
   private byte gxTv_Sdtconvenio_adicional_N ;
   protected short gxTv_Sdtconvenio_adicional_Clipaiconve ;
   protected short gxTv_Sdtconvenio_adicional_Initialized ;
   protected short gxTv_Sdtconvenio_adicional_Clipaiconve_Z ;
   protected int gxTv_Sdtconvenio_adicional_Clicod ;
   protected int gxTv_Sdtconvenio_adicional_Conveadirelsec ;
   protected int gxTv_Sdtconvenio_adicional_Clicod_Z ;
   protected int gxTv_Sdtconvenio_adicional_Conveadirelsec_Z ;
   protected String gxTv_Sdtconvenio_adicional_Cliconvenio ;
   protected String gxTv_Sdtconvenio_adicional_Conveadicod ;
   protected String gxTv_Sdtconvenio_adicional_Conveaditipo ;
   protected String gxTv_Sdtconvenio_adicional_Mode ;
   protected String gxTv_Sdtconvenio_adicional_Cliconvenio_Z ;
   protected String gxTv_Sdtconvenio_adicional_Conveadicod_Z ;
   protected String gxTv_Sdtconvenio_adicional_Conveaditipo_Z ;
   protected String gxTv_Sdtconvenio_adicional_Conveadiinfo ;
   protected String gxTv_Sdtconvenio_adicional_Conveadiold ;
   protected String gxTv_Sdtconvenio_adicional_Conveadidescri ;
   protected String gxTv_Sdtconvenio_adicional_Conveadirelref ;
   protected String gxTv_Sdtconvenio_adicional_Conveadidescri_Z ;
   protected String gxTv_Sdtconvenio_adicional_Conveadirelref_Z ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_adicional_Conveadiali ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_adicional_Conveadiali_Z ;
   protected java.util.Vector<web.StructSdtconvenio_adicional_Cancela> gxTv_Sdtconvenio_adicional_Cancela=null ;
   protected java.util.Vector<web.StructSdtconvenio_adicional_importes> gxTv_Sdtconvenio_adicional_Importes=null ;
   protected java.util.Vector<web.StructSdtconvenio_adicional_alicuotas> gxTv_Sdtconvenio_adicional_Alicuotas=null ;
}

