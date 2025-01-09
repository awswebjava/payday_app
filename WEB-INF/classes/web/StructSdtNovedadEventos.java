package web ;
import com.genexus.*;

public final  class StructSdtNovedadEventos implements Cloneable, java.io.Serializable
{
   public StructSdtNovedadEventos( )
   {
      this( -1, new ModelContext( StructSdtNovedadEventos.class ));
   }

   public StructSdtNovedadEventos( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtNovedadEventos_Leglicenini = cal.getTime() ;
      gxTv_SdtNovedadEventos_Leglicenfin = cal.getTime() ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo = "" ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip = "" ;
      gxTv_SdtNovedadEventos_Leglicdescrip = "" ;
      gxTv_SdtNovedadEventos_Leglicestado = "" ;
      gxTv_SdtNovedadEventos_Leglicmot = "" ;
      gxTv_SdtNovedadEventos_Leglicfile = "" ;
      gxTv_SdtNovedadEventos_Leglicfilenom = "" ;
      gxTv_SdtNovedadEventos_Leglicfileext = "" ;
      gxTv_SdtNovedadEventos_Mode = "" ;
      gxTv_SdtNovedadEventos_Leglicenini_Z = cal.getTime() ;
      gxTv_SdtNovedadEventos_Leglicenfin_Z = cal.getTime() ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicdescrip_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicestado_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicfilenom_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicfileext_Z = "" ;
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
      return gxTv_SdtNovedadEventos_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtNovedadEventos_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtNovedadEventos_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legnumero = value ;
   }

   public java.util.Date getLeglicenini( )
   {
      return gxTv_SdtNovedadEventos_Leglicenini ;
   }

   public void setLeglicenini( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicenini = value ;
   }

   public java.util.Date getLeglicenfin( )
   {
      return gxTv_SdtNovedadEventos_Leglicenfin ;
   }

   public void setLeglicenfin( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicenfin = value ;
   }

   public String getLeglicsitcodigo( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitcodigo ;
   }

   public void setLeglicsitcodigo( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo = value ;
   }

   public String getLeglicsitdescrip( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitdescrip ;
   }

   public void setLeglicsitdescrip( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip = value ;
   }

   public short getLegliccntdias( )
   {
      return gxTv_SdtNovedadEventos_Legliccntdias ;
   }

   public void setLegliccntdias( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legliccntdias = value ;
   }

   public String getLeglicdescrip( )
   {
      return gxTv_SdtNovedadEventos_Leglicdescrip ;
   }

   public void setLeglicdescrip( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicdescrip = value ;
   }

   public boolean getLeglicconplus( )
   {
      return gxTv_SdtNovedadEventos_Leglicconplus ;
   }

   public void setLeglicconplus( boolean value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicconplus = value ;
   }

   public byte getLegsiteslic( )
   {
      return gxTv_SdtNovedadEventos_Legsiteslic ;
   }

   public void setLegsiteslic( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsiteslic = value ;
   }

   public byte getLegsitesau( )
   {
      return gxTv_SdtNovedadEventos_Legsitesau ;
   }

   public void setLegsitesau( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitesau = value ;
   }

   public byte getLegsitesafip( )
   {
      return gxTv_SdtNovedadEventos_Legsitesafip ;
   }

   public void setLegsitesafip( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitesafip = value ;
   }

   public byte getLegsitcuentrab( )
   {
      return gxTv_SdtNovedadEventos_Legsitcuentrab ;
   }

   public void setLegsitcuentrab( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitcuentrab = value ;
   }

   public String getLeglicestado( )
   {
      return gxTv_SdtNovedadEventos_Leglicestado ;
   }

   public void setLeglicestado( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicestado = value ;
   }

   public String getLeglicmot( )
   {
      return gxTv_SdtNovedadEventos_Leglicmot ;
   }

   public void setLeglicmot( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicmot = value ;
   }

   public String getLeglicfile( )
   {
      return gxTv_SdtNovedadEventos_Leglicfile ;
   }

   public void setLeglicfile( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicfile = value ;
   }

   public String getLeglicfilenom( )
   {
      return gxTv_SdtNovedadEventos_Leglicfilenom ;
   }

   public void setLeglicfilenom( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicfilenom = value ;
   }

   public String getLeglicfileext( )
   {
      return gxTv_SdtNovedadEventos_Leglicfileext ;
   }

   public void setLeglicfileext( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicfileext = value ;
   }

   public byte getLegliccanpres( )
   {
      return gxTv_SdtNovedadEventos_Legliccanpres ;
   }

   public void setLegliccanpres( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legliccanpres = value ;
   }

   public byte getLeglicremcorr( )
   {
      return gxTv_SdtNovedadEventos_Leglicremcorr ;
   }

   public void setLeglicremcorr( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicremcorr = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtNovedadEventos_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtNovedadEventos_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtNovedadEventos_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtNovedadEventos_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtNovedadEventos_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legnumero_Z = value ;
   }

   public java.util.Date getLeglicenini_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicenini_Z ;
   }

   public void setLeglicenini_Z( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicenini_Z = value ;
   }

   public java.util.Date getLeglicenfin_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicenfin_Z ;
   }

   public void setLeglicenfin_Z( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicenfin_Z = value ;
   }

   public String getLeglicsitcodigo_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitcodigo_Z ;
   }

   public void setLeglicsitcodigo_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = value ;
   }

   public String getLeglicsitdescrip_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitdescrip_Z ;
   }

   public void setLeglicsitdescrip_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = value ;
   }

   public short getLegliccntdias_Z( )
   {
      return gxTv_SdtNovedadEventos_Legliccntdias_Z ;
   }

   public void setLegliccntdias_Z( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legliccntdias_Z = value ;
   }

   public String getLeglicdescrip_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicdescrip_Z ;
   }

   public void setLeglicdescrip_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicdescrip_Z = value ;
   }

   public boolean getLeglicconplus_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicconplus_Z ;
   }

   public void setLeglicconplus_Z( boolean value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicconplus_Z = value ;
   }

   public byte getLegsiteslic_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsiteslic_Z ;
   }

   public void setLegsiteslic_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsiteslic_Z = value ;
   }

   public byte getLegsitesau_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitesau_Z ;
   }

   public void setLegsitesau_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitesau_Z = value ;
   }

   public byte getLegsitesafip_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitesafip_Z ;
   }

   public void setLegsitesafip_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitesafip_Z = value ;
   }

   public byte getLegsitcuentrab_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitcuentrab_Z ;
   }

   public void setLegsitcuentrab_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legsitcuentrab_Z = value ;
   }

   public String getLeglicestado_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicestado_Z ;
   }

   public void setLeglicestado_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicestado_Z = value ;
   }

   public String getLeglicfilenom_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicfilenom_Z ;
   }

   public void setLeglicfilenom_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicfilenom_Z = value ;
   }

   public String getLeglicfileext_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicfileext_Z ;
   }

   public void setLeglicfileext_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicfileext_Z = value ;
   }

   public byte getLegliccanpres_Z( )
   {
      return gxTv_SdtNovedadEventos_Legliccanpres_Z ;
   }

   public void setLegliccanpres_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Legliccanpres_Z = value ;
   }

   public byte getLeglicremcorr_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicremcorr_Z ;
   }

   public void setLeglicremcorr_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      gxTv_SdtNovedadEventos_Leglicremcorr_Z = value ;
   }

   protected byte gxTv_SdtNovedadEventos_Legsiteslic ;
   protected byte gxTv_SdtNovedadEventos_Legsitesau ;
   protected byte gxTv_SdtNovedadEventos_Legsitesafip ;
   protected byte gxTv_SdtNovedadEventos_Legsitcuentrab ;
   protected byte gxTv_SdtNovedadEventos_Legliccanpres ;
   protected byte gxTv_SdtNovedadEventos_Leglicremcorr ;
   protected byte gxTv_SdtNovedadEventos_Legsiteslic_Z ;
   protected byte gxTv_SdtNovedadEventos_Legsitesau_Z ;
   protected byte gxTv_SdtNovedadEventos_Legsitesafip_Z ;
   protected byte gxTv_SdtNovedadEventos_Legsitcuentrab_Z ;
   protected byte gxTv_SdtNovedadEventos_Legliccanpres_Z ;
   protected byte gxTv_SdtNovedadEventos_Leglicremcorr_Z ;
   private byte gxTv_SdtNovedadEventos_N ;
   protected short gxTv_SdtNovedadEventos_Empcod ;
   protected short gxTv_SdtNovedadEventos_Legliccntdias ;
   protected short gxTv_SdtNovedadEventos_Initialized ;
   protected short gxTv_SdtNovedadEventos_Empcod_Z ;
   protected short gxTv_SdtNovedadEventos_Legliccntdias_Z ;
   protected int gxTv_SdtNovedadEventos_Clicod ;
   protected int gxTv_SdtNovedadEventos_Legnumero ;
   protected int gxTv_SdtNovedadEventos_Clicod_Z ;
   protected int gxTv_SdtNovedadEventos_Legnumero_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicsitcodigo ;
   protected String gxTv_SdtNovedadEventos_Leglicestado ;
   protected String gxTv_SdtNovedadEventos_Leglicfileext ;
   protected String gxTv_SdtNovedadEventos_Mode ;
   protected String gxTv_SdtNovedadEventos_Leglicsitcodigo_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicestado_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicfileext_Z ;
   protected boolean gxTv_SdtNovedadEventos_Leglicconplus ;
   protected boolean gxTv_SdtNovedadEventos_Leglicconplus_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicmot ;
   protected String gxTv_SdtNovedadEventos_Leglicfile ;
   protected String gxTv_SdtNovedadEventos_Leglicsitdescrip ;
   protected String gxTv_SdtNovedadEventos_Leglicdescrip ;
   protected String gxTv_SdtNovedadEventos_Leglicfilenom ;
   protected String gxTv_SdtNovedadEventos_Leglicsitdescrip_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicdescrip_Z ;
   protected String gxTv_SdtNovedadEventos_Leglicfilenom_Z ;
   protected java.util.Date gxTv_SdtNovedadEventos_Leglicenini ;
   protected java.util.Date gxTv_SdtNovedadEventos_Leglicenfin ;
   protected java.util.Date gxTv_SdtNovedadEventos_Leglicenini_Z ;
   protected java.util.Date gxTv_SdtNovedadEventos_Leglicenfin_Z ;
}

