package web ;
import com.genexus.*;

public final  class StructSdtLegajo_Familia implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo_Familia( )
   {
      this( -1, new ModelContext( StructSdtLegajo_Familia.class ));
   }

   public StructSdtLegajo_Familia( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajo_Familia_Famnomape = "" ;
      gxTv_SdtLegajo_Familia_Parcod = "" ;
      gxTv_SdtLegajo_Familia_Famfecnac = cal.getTime() ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Familia_Famnrodoc = "" ;
      gxTv_SdtLegajo_Familia_Mode = "" ;
      gxTv_SdtLegajo_Familia_Famnomape_Z = "" ;
      gxTv_SdtLegajo_Familia_Parcod_Z = "" ;
      gxTv_SdtLegajo_Familia_Famfecnac_Z = cal.getTime() ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Familia_Famnrodoc_Z = "" ;
      gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(1) ;
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

   public short getLegorden( )
   {
      return gxTv_SdtLegajo_Familia_Legorden ;
   }

   public void setLegorden( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Legorden = value ;
   }

   public String getFamnomape( )
   {
      return gxTv_SdtLegajo_Familia_Famnomape ;
   }

   public void setFamnomape( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famnomape = value ;
   }

   public String getParcod( )
   {
      return gxTv_SdtLegajo_Familia_Parcod ;
   }

   public void setParcod( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Parcod = value ;
   }

   public java.util.Date getFamfecnac( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac ;
   }

   public void setFamfecnac( java.util.Date value )
   {
      gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famfecnac = value ;
   }

   public boolean getFamdiscap( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap ;
   }

   public void setFamdiscap( boolean value )
   {
      gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famdiscap = value ;
   }

   public java.math.BigDecimal getFamtomadeducimpgan( )
   {
      return gxTv_SdtLegajo_Familia_Famtomadeducimpgan ;
   }

   public void setFamtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan = value ;
   }

   public String getFamnrodoc( )
   {
      return gxTv_SdtLegajo_Familia_Famnrodoc ;
   }

   public void setFamnrodoc( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famnrodoc = value ;
   }

   public boolean getFamadherente( )
   {
      return gxTv_SdtLegajo_Familia_Famadherente ;
   }

   public void setFamadherente( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famadherente = value ;
   }

   public short getGuarcod( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod ;
   }

   public void setGuarcod( short value )
   {
      gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Guarcod = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_Familia_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtLegajo_Familia_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_Familia_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Initialized = value ;
   }

   public short getLegorden_Z( )
   {
      return gxTv_SdtLegajo_Familia_Legorden_Z ;
   }

   public void setLegorden_Z( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Legorden_Z = value ;
   }

   public String getFamnomape_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famnomape_Z ;
   }

   public void setFamnomape_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famnomape_Z = value ;
   }

   public String getParcod_Z( )
   {
      return gxTv_SdtLegajo_Familia_Parcod_Z ;
   }

   public void setParcod_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Parcod_Z = value ;
   }

   public java.util.Date getFamfecnac_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac_Z ;
   }

   public void setFamfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famfecnac_Z = value ;
   }

   public boolean getFamdiscap_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap_Z ;
   }

   public void setFamdiscap_Z( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famdiscap_Z = value ;
   }

   public java.math.BigDecimal getFamtomadeducimpgan_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z ;
   }

   public void setFamtomadeducimpgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = value ;
   }

   public String getFamnrodoc_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famnrodoc_Z ;
   }

   public void setFamnrodoc_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famnrodoc_Z = value ;
   }

   public boolean getFamadherente_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famadherente_Z ;
   }

   public void setFamadherente_Z( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famadherente_Z = value ;
   }

   public short getGuarcod_Z( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod_Z ;
   }

   public void setGuarcod_Z( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Guarcod_Z = value ;
   }

   public byte getFamfecnac_N( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac_N ;
   }

   public void setFamfecnac_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famfecnac_N = value ;
   }

   public byte getFamdiscap_N( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap_N ;
   }

   public void setFamdiscap_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Famdiscap_N = value ;
   }

   public byte getGuarcod_N( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod_N ;
   }

   public void setGuarcod_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Guarcod_N = value ;
   }

   protected byte gxTv_SdtLegajo_Familia_Famfecnac_N ;
   protected byte gxTv_SdtLegajo_Familia_Famdiscap_N ;
   protected byte gxTv_SdtLegajo_Familia_Guarcod_N ;
   private byte gxTv_SdtLegajo_Familia_N ;
   protected short gxTv_SdtLegajo_Familia_Legorden ;
   protected short gxTv_SdtLegajo_Familia_Guarcod ;
   protected short gxTv_SdtLegajo_Familia_Modified ;
   protected short gxTv_SdtLegajo_Familia_Initialized ;
   protected short gxTv_SdtLegajo_Familia_Legorden_Z ;
   protected short gxTv_SdtLegajo_Familia_Guarcod_Z ;
   protected String gxTv_SdtLegajo_Familia_Parcod ;
   protected String gxTv_SdtLegajo_Familia_Famnrodoc ;
   protected String gxTv_SdtLegajo_Familia_Mode ;
   protected String gxTv_SdtLegajo_Familia_Parcod_Z ;
   protected String gxTv_SdtLegajo_Familia_Famnrodoc_Z ;
   protected boolean gxTv_SdtLegajo_Familia_Famdiscap ;
   protected boolean gxTv_SdtLegajo_Familia_Famadherente ;
   protected boolean gxTv_SdtLegajo_Familia_Famdiscap_Z ;
   protected boolean gxTv_SdtLegajo_Familia_Famadherente_Z ;
   protected String gxTv_SdtLegajo_Familia_Famnomape ;
   protected String gxTv_SdtLegajo_Familia_Famnomape_Z ;
   protected java.util.Date gxTv_SdtLegajo_Familia_Famfecnac ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Familia_Famtomadeducimpgan ;
   protected java.util.Date gxTv_SdtLegajo_Familia_Famfecnac_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z ;
}

