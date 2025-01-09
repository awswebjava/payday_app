package web ;
import com.genexus.*;

public final  class StructSdtLegajoLicencias implements Cloneable, java.io.Serializable
{
   public StructSdtLegajoLicencias( )
   {
      this( -1, new ModelContext( StructSdtLegajoLicencias.class ));
   }

   public StructSdtLegajoLicencias( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajoLicencias_Leglicenini = cal.getTime() ;
      gxTv_SdtLegajoLicencias_Leglicenfin = cal.getTime() ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo = "" ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip = "" ;
      gxTv_SdtLegajoLicencias_Leglicdescrip = "" ;
      gxTv_SdtLegajoLicencias_Mode = "" ;
      gxTv_SdtLegajoLicencias_Leglicenini_Z = cal.getTime() ;
      gxTv_SdtLegajoLicencias_Leglicenfin_Z = cal.getTime() ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = "" ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = "" ;
      gxTv_SdtLegajoLicencias_Leglicdescrip_Z = "" ;
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
      return gxTv_SdtLegajoLicencias_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLegajoLicencias_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtLegajoLicencias_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Legnumero = value ;
   }

   public java.util.Date getLeglicenini( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenini ;
   }

   public void setLeglicenini( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicenini = value ;
   }

   public java.util.Date getLeglicenfin( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenfin ;
   }

   public void setLeglicenfin( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicenfin = value ;
   }

   public String getLeglicsitcodigo( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitcodigo ;
   }

   public void setLeglicsitcodigo( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo = value ;
   }

   public String getLeglicsitdescrip( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitdescrip ;
   }

   public void setLeglicsitdescrip( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip = value ;
   }

   public short getLegliccntdias( )
   {
      return gxTv_SdtLegajoLicencias_Legliccntdias ;
   }

   public void setLegliccntdias( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Legliccntdias = value ;
   }

   public String getLeglicdescrip( )
   {
      return gxTv_SdtLegajoLicencias_Leglicdescrip ;
   }

   public void setLeglicdescrip( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicdescrip = value ;
   }

   public boolean getLeglicconplus( )
   {
      return gxTv_SdtLegajoLicencias_Leglicconplus ;
   }

   public void setLeglicconplus( boolean value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicconplus = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajoLicencias_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajoLicencias_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLegajoLicencias_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLegajoLicencias_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtLegajoLicencias_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Legnumero_Z = value ;
   }

   public java.util.Date getLeglicenini_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenini_Z ;
   }

   public void setLeglicenini_Z( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicenini_Z = value ;
   }

   public java.util.Date getLeglicenfin_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenfin_Z ;
   }

   public void setLeglicenfin_Z( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicenfin_Z = value ;
   }

   public String getLeglicsitcodigo_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z ;
   }

   public void setLeglicsitcodigo_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = value ;
   }

   public String getLeglicsitdescrip_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z ;
   }

   public void setLeglicsitdescrip_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = value ;
   }

   public short getLegliccntdias_Z( )
   {
      return gxTv_SdtLegajoLicencias_Legliccntdias_Z ;
   }

   public void setLegliccntdias_Z( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Legliccntdias_Z = value ;
   }

   public String getLeglicdescrip_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicdescrip_Z ;
   }

   public void setLeglicdescrip_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicdescrip_Z = value ;
   }

   public boolean getLeglicconplus_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicconplus_Z ;
   }

   public void setLeglicconplus_Z( boolean value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      gxTv_SdtLegajoLicencias_Leglicconplus_Z = value ;
   }

   private byte gxTv_SdtLegajoLicencias_N ;
   protected short gxTv_SdtLegajoLicencias_Empcod ;
   protected short gxTv_SdtLegajoLicencias_Legliccntdias ;
   protected short gxTv_SdtLegajoLicencias_Initialized ;
   protected short gxTv_SdtLegajoLicencias_Empcod_Z ;
   protected short gxTv_SdtLegajoLicencias_Legliccntdias_Z ;
   protected int gxTv_SdtLegajoLicencias_Clicod ;
   protected int gxTv_SdtLegajoLicencias_Legnumero ;
   protected int gxTv_SdtLegajoLicencias_Clicod_Z ;
   protected int gxTv_SdtLegajoLicencias_Legnumero_Z ;
   protected String gxTv_SdtLegajoLicencias_Leglicsitcodigo ;
   protected String gxTv_SdtLegajoLicencias_Mode ;
   protected String gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z ;
   protected boolean gxTv_SdtLegajoLicencias_Leglicconplus ;
   protected boolean gxTv_SdtLegajoLicencias_Leglicconplus_Z ;
   protected String gxTv_SdtLegajoLicencias_Leglicsitdescrip ;
   protected String gxTv_SdtLegajoLicencias_Leglicdescrip ;
   protected String gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z ;
   protected String gxTv_SdtLegajoLicencias_Leglicdescrip_Z ;
   protected java.util.Date gxTv_SdtLegajoLicencias_Leglicenini ;
   protected java.util.Date gxTv_SdtLegajoLicencias_Leglicenfin ;
   protected java.util.Date gxTv_SdtLegajoLicencias_Leglicenini_Z ;
   protected java.util.Date gxTv_SdtLegajoLicencias_Leglicenfin_Z ;
}

