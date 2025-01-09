package web ;
import com.genexus.*;

public final  class StructSdtdeduccionesSolapa implements Cloneable, java.io.Serializable
{
   public StructSdtdeduccionesSolapa( )
   {
      this( -1, new ModelContext( StructSdtdeduccionesSolapa.class ));
   }

   public StructSdtdeduccionesSolapa( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtdeduccionesSolapa_Legdedfchdes = cal.getTime() ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas = cal.getTime() ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip = "" ;
      gxTv_SdtdeduccionesSolapa_Legidnomape = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = "" ;
      gxTv_SdtdeduccionesSolapa_Mode = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = cal.getTime() ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = cal.getTime() ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legidnomape_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = "" ;
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
      return gxTv_SdtdeduccionesSolapa_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtdeduccionesSolapa_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtdeduccionesSolapa_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legnumero = value ;
   }

   public int getLegdedsec( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedsec ;
   }

   public void setLegdedsec( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedsec = value ;
   }

   public java.util.Date getLegdedfchdes( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchdes ;
   }

   public void setLegdedfchdes( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedfchdes = value ;
   }

   public java.util.Date getLegdedfchhas( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchhas ;
   }

   public void setLegdedfchhas( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas = value ;
   }

   public String getLegdedconcodigo( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodigo ;
   }

   public void setLegdedconcodigo( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo = value ;
   }

   public String getLegdedcondescrip( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedcondescrip ;
   }

   public void setLegdedcondescrip( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip = value ;
   }

   public String getLegidnomape( )
   {
      return gxTv_SdtdeduccionesSolapa_Legidnomape ;
   }

   public void setLegidnomape( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legidnomape = value ;
   }

   public java.math.BigDecimal getLegdedimporte( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedimporte ;
   }

   public void setLegdedimporte( java.math.BigDecimal value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte = value ;
   }

   public String getLegdeddescrip( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdeddescrip ;
   }

   public void setLegdeddescrip( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip = value ;
   }

   public String getLegdedconcodydesc( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodydesc ;
   }

   public void setLegdedconcodydesc( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtdeduccionesSolapa_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtdeduccionesSolapa_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legnumero_Z = value ;
   }

   public int getLegdedsec_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedsec_Z ;
   }

   public void setLegdedsec_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedsec_Z = value ;
   }

   public java.util.Date getLegdedfchdes_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z ;
   }

   public void setLegdedfchdes_Z( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = value ;
   }

   public java.util.Date getLegdedfchhas_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z ;
   }

   public void setLegdedfchhas_Z( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = value ;
   }

   public String getLegdedconcodigo_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z ;
   }

   public void setLegdedconcodigo_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = value ;
   }

   public String getLegdedcondescrip_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z ;
   }

   public void setLegdedcondescrip_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = value ;
   }

   public String getLegidnomape_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legidnomape_Z ;
   }

   public void setLegidnomape_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legidnomape_Z = value ;
   }

   public java.math.BigDecimal getLegdedimporte_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedimporte_Z ;
   }

   public void setLegdedimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = value ;
   }

   public String getLegdeddescrip_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z ;
   }

   public void setLegdeddescrip_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = value ;
   }

   public String getLegdedconcodydesc_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z ;
   }

   public void setLegdedconcodydesc_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = value ;
   }

   private byte gxTv_SdtdeduccionesSolapa_N ;
   protected short gxTv_SdtdeduccionesSolapa_Empcod ;
   protected short gxTv_SdtdeduccionesSolapa_Initialized ;
   protected short gxTv_SdtdeduccionesSolapa_Empcod_Z ;
   protected int gxTv_SdtdeduccionesSolapa_Clicod ;
   protected int gxTv_SdtdeduccionesSolapa_Legnumero ;
   protected int gxTv_SdtdeduccionesSolapa_Legdedsec ;
   protected int gxTv_SdtdeduccionesSolapa_Clicod_Z ;
   protected int gxTv_SdtdeduccionesSolapa_Legnumero_Z ;
   protected int gxTv_SdtdeduccionesSolapa_Legdedsec_Z ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedconcodigo ;
   protected String gxTv_SdtdeduccionesSolapa_Mode ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedcondescrip ;
   protected String gxTv_SdtdeduccionesSolapa_Legidnomape ;
   protected String gxTv_SdtdeduccionesSolapa_Legdeddescrip ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedconcodydesc ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z ;
   protected String gxTv_SdtdeduccionesSolapa_Legidnomape_Z ;
   protected String gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z ;
   protected String gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z ;
   protected java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchdes ;
   protected java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchhas ;
   protected java.math.BigDecimal gxTv_SdtdeduccionesSolapa_Legdedimporte ;
   protected java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z ;
   protected java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z ;
   protected java.math.BigDecimal gxTv_SdtdeduccionesSolapa_Legdedimporte_Z ;
}

