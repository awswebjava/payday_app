package web ;
import com.genexus.*;

public final  class StructSdtfaltas_y_tardes implements Cloneable, java.io.Serializable
{
   public StructSdtfaltas_y_tardes( )
   {
      this( -1, new ModelContext( StructSdtfaltas_y_tardes.class ));
   }

   public StructSdtfaltas_y_tardes( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtfaltas_y_tardes_Leglicenini = cal.getTime() ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin = cal.getTime() ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado = "" ;
      gxTv_Sdtfaltas_y_tardes_Mode = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = cal.getTime() ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = cal.getTime() ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = "" ;
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
      return gxTv_Sdtfaltas_y_tardes_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtfaltas_y_tardes_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legnumero = value ;
   }

   public java.util.Date getLeglicenini( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenini ;
   }

   public void setLeglicenini( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicenini = value ;
   }

   public java.util.Date getLeglicenfin( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenfin ;
   }

   public void setLeglicenfin( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin = value ;
   }

   public String getLeglicsitcodigo( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo ;
   }

   public void setLeglicsitcodigo( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = value ;
   }

   public String getLeglicsitdescrip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip ;
   }

   public void setLeglicsitdescrip( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = value ;
   }

   public short getLegliccntdias( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccntdias ;
   }

   public void setLegliccntdias( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legliccntdias = value ;
   }

   public String getLeglicdescrip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicdescrip ;
   }

   public void setLeglicdescrip( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip = value ;
   }

   public boolean getLeglicconplus( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicconplus ;
   }

   public void setLeglicconplus( boolean value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicconplus = value ;
   }

   public byte getLegsiteslic( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsiteslic ;
   }

   public void setLegsiteslic( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsiteslic = value ;
   }

   public byte getLegsitesau( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesau ;
   }

   public void setLegsitesau( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitesau = value ;
   }

   public byte getLegsitesafip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesafip ;
   }

   public void setLegsitesafip( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitesafip = value ;
   }

   public byte getLegsitcuentrab( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitcuentrab ;
   }

   public void setLegsitcuentrab( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitcuentrab = value ;
   }

   public byte getLegliccanpres( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccanpres ;
   }

   public void setLegliccanpres( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legliccanpres = value ;
   }

   public byte getLeglicremcorr( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicremcorr ;
   }

   public void setLeglicremcorr( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicremcorr = value ;
   }

   public String getLeglicestado( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicestado ;
   }

   public void setLeglicestado( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtfaltas_y_tardes_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtfaltas_y_tardes_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legnumero_Z = value ;
   }

   public java.util.Date getLeglicenini_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenini_Z ;
   }

   public void setLeglicenini_Z( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = value ;
   }

   public java.util.Date getLeglicenfin_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z ;
   }

   public void setLeglicenfin_Z( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = value ;
   }

   public String getLeglicsitcodigo_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z ;
   }

   public void setLeglicsitcodigo_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = value ;
   }

   public String getLeglicsitdescrip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z ;
   }

   public void setLeglicsitdescrip_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = value ;
   }

   public short getLegliccntdias_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z ;
   }

   public void setLegliccntdias_Z( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z = value ;
   }

   public String getLeglicdescrip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z ;
   }

   public void setLeglicdescrip_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = value ;
   }

   public boolean getLeglicconplus_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z ;
   }

   public void setLeglicconplus_Z( boolean value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z = value ;
   }

   public byte getLegsiteslic_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z ;
   }

   public void setLegsiteslic_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z = value ;
   }

   public byte getLegsitesau_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesau_Z ;
   }

   public void setLegsitesau_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitesau_Z = value ;
   }

   public byte getLegsitesafip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z ;
   }

   public void setLegsitesafip_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z = value ;
   }

   public byte getLegsitcuentrab_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z ;
   }

   public void setLegsitcuentrab_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z = value ;
   }

   public byte getLegliccanpres_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z ;
   }

   public void setLegliccanpres_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z = value ;
   }

   public byte getLeglicremcorr_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z ;
   }

   public void setLeglicremcorr_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z = value ;
   }

   public String getLeglicestado_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicestado_Z ;
   }

   public void setLeglicestado_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = value ;
   }

   protected byte gxTv_Sdtfaltas_y_tardes_Legsiteslic ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitesau ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitesafip ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitcuentrab ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legliccanpres ;
   protected byte gxTv_Sdtfaltas_y_tardes_Leglicremcorr ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitesau_Z ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z ;
   protected byte gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z ;
   protected byte gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_N ;
   protected short gxTv_Sdtfaltas_y_tardes_Empcod ;
   protected short gxTv_Sdtfaltas_y_tardes_Legliccntdias ;
   protected short gxTv_Sdtfaltas_y_tardes_Initialized ;
   protected short gxTv_Sdtfaltas_y_tardes_Empcod_Z ;
   protected short gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z ;
   protected int gxTv_Sdtfaltas_y_tardes_Clicod ;
   protected int gxTv_Sdtfaltas_y_tardes_Legnumero ;
   protected int gxTv_Sdtfaltas_y_tardes_Clicod_Z ;
   protected int gxTv_Sdtfaltas_y_tardes_Legnumero_Z ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicestado ;
   protected String gxTv_Sdtfaltas_y_tardes_Mode ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicestado_Z ;
   protected boolean gxTv_Sdtfaltas_y_tardes_Leglicconplus ;
   protected boolean gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicdescrip ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z ;
   protected String gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z ;
   protected java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenini ;
   protected java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenfin ;
   protected java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenini_Z ;
   protected java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z ;
}

