package web ;
import com.genexus.*;

public final  class StructSdtLegajoFamilia implements Cloneable, java.io.Serializable
{
   public StructSdtLegajoFamilia( )
   {
      this( -1, new ModelContext( StructSdtLegajoFamilia.class ));
   }

   public StructSdtLegajoFamilia( int remoteHandle ,
                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajoFamilia_Famapellido = "" ;
      gxTv_SdtLegajoFamilia_Famnombres = "" ;
      gxTv_SdtLegajoFamilia_Famnomape = "" ;
      gxTv_SdtLegajoFamilia_Parcod = "" ;
      gxTv_SdtLegajoFamilia_Pardescrip = "" ;
      gxTv_SdtLegajoFamilia_Famfecnac = cal.getTime() ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajoFamilia_Famnrodoc = "" ;
      gxTv_SdtLegajoFamilia_Mode = "" ;
      gxTv_SdtLegajoFamilia_Famapellido_Z = "" ;
      gxTv_SdtLegajoFamilia_Famnombres_Z = "" ;
      gxTv_SdtLegajoFamilia_Famnomape_Z = "" ;
      gxTv_SdtLegajoFamilia_Parcod_Z = "" ;
      gxTv_SdtLegajoFamilia_Pardescrip_Z = "" ;
      gxTv_SdtLegajoFamilia_Famfecnac_Z = cal.getTime() ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajoFamilia_Famnrodoc_Z = "" ;
      gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(1) ;
      gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(1) ;
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
      return gxTv_SdtLegajoFamilia_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLegajoFamilia_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtLegajoFamilia_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Legnumero = value ;
   }

   public short getLegorden( )
   {
      return gxTv_SdtLegajoFamilia_Legorden ;
   }

   public void setLegorden( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Legorden = value ;
   }

   public String getFamapellido( )
   {
      return gxTv_SdtLegajoFamilia_Famapellido ;
   }

   public void setFamapellido( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famapellido = value ;
   }

   public String getFamnombres( )
   {
      return gxTv_SdtLegajoFamilia_Famnombres ;
   }

   public void setFamnombres( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnombres = value ;
   }

   public String getFamnomape( )
   {
      return gxTv_SdtLegajoFamilia_Famnomape ;
   }

   public void setFamnomape( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnomape = value ;
   }

   public String getParcod( )
   {
      return gxTv_SdtLegajoFamilia_Parcod ;
   }

   public void setParcod( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Parcod = value ;
   }

   public String getPardescrip( )
   {
      return gxTv_SdtLegajoFamilia_Pardescrip ;
   }

   public void setPardescrip( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Pardescrip = value ;
   }

   public java.util.Date getFamfecnac( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac ;
   }

   public void setFamfecnac( java.util.Date value )
   {
      gxTv_SdtLegajoFamilia_Famfecnac_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famfecnac = value ;
   }

   public boolean getFamdiscap( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap ;
   }

   public void setFamdiscap( boolean value )
   {
      gxTv_SdtLegajoFamilia_Famdiscap_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famdiscap = value ;
   }

   public boolean getFamasigfam( )
   {
      return gxTv_SdtLegajoFamilia_Famasigfam ;
   }

   public void setFamasigfam( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famasigfam = value ;
   }

   public java.math.BigDecimal getFamtomadeducimpgan( )
   {
      return gxTv_SdtLegajoFamilia_Famtomadeducimpgan ;
   }

   public void setFamtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan = value ;
   }

   public String getFamnrodoc( )
   {
      return gxTv_SdtLegajoFamilia_Famnrodoc ;
   }

   public void setFamnrodoc( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnrodoc = value ;
   }

   public short getFammesdesde( )
   {
      return gxTv_SdtLegajoFamilia_Fammesdesde ;
   }

   public void setFammesdesde( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Fammesdesde = value ;
   }

   public short getFammeshasta( )
   {
      return gxTv_SdtLegajoFamilia_Fammeshasta ;
   }

   public void setFammeshasta( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Fammeshasta = value ;
   }

   public boolean getFamadherente( )
   {
      return gxTv_SdtLegajoFamilia_Famadherente ;
   }

   public void setFamadherente( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famadherente = value ;
   }

   public short getGuarcod( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod ;
   }

   public void setGuarcod( short value )
   {
      gxTv_SdtLegajoFamilia_Guarcod_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Guarcod = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajoFamilia_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajoFamilia_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtLegajoFamilia_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Legnumero_Z = value ;
   }

   public short getLegorden_Z( )
   {
      return gxTv_SdtLegajoFamilia_Legorden_Z ;
   }

   public void setLegorden_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Legorden_Z = value ;
   }

   public String getFamapellido_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famapellido_Z ;
   }

   public void setFamapellido_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famapellido_Z = value ;
   }

   public String getFamnombres_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnombres_Z ;
   }

   public void setFamnombres_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnombres_Z = value ;
   }

   public String getFamnomape_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnomape_Z ;
   }

   public void setFamnomape_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnomape_Z = value ;
   }

   public String getParcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Parcod_Z ;
   }

   public void setParcod_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Parcod_Z = value ;
   }

   public String getPardescrip_Z( )
   {
      return gxTv_SdtLegajoFamilia_Pardescrip_Z ;
   }

   public void setPardescrip_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Pardescrip_Z = value ;
   }

   public java.util.Date getFamfecnac_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac_Z ;
   }

   public void setFamfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famfecnac_Z = value ;
   }

   public boolean getFamdiscap_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap_Z ;
   }

   public void setFamdiscap_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famdiscap_Z = value ;
   }

   public boolean getFamasigfam_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famasigfam_Z ;
   }

   public void setFamasigfam_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famasigfam_Z = value ;
   }

   public java.math.BigDecimal getFamtomadeducimpgan_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z ;
   }

   public void setFamtomadeducimpgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z = value ;
   }

   public String getFamnrodoc_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famnrodoc_Z ;
   }

   public void setFamnrodoc_Z( String value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famnrodoc_Z = value ;
   }

   public short getFammesdesde_Z( )
   {
      return gxTv_SdtLegajoFamilia_Fammesdesde_Z ;
   }

   public void setFammesdesde_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Fammesdesde_Z = value ;
   }

   public short getFammeshasta_Z( )
   {
      return gxTv_SdtLegajoFamilia_Fammeshasta_Z ;
   }

   public void setFammeshasta_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Fammeshasta_Z = value ;
   }

   public boolean getFamadherente_Z( )
   {
      return gxTv_SdtLegajoFamilia_Famadherente_Z ;
   }

   public void setFamadherente_Z( boolean value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famadherente_Z = value ;
   }

   public short getGuarcod_Z( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod_Z ;
   }

   public void setGuarcod_Z( short value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Guarcod_Z = value ;
   }

   public byte getFamfecnac_N( )
   {
      return gxTv_SdtLegajoFamilia_Famfecnac_N ;
   }

   public void setFamfecnac_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famfecnac_N = value ;
   }

   public byte getFamdiscap_N( )
   {
      return gxTv_SdtLegajoFamilia_Famdiscap_N ;
   }

   public void setFamdiscap_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Famdiscap_N = value ;
   }

   public byte getGuarcod_N( )
   {
      return gxTv_SdtLegajoFamilia_Guarcod_N ;
   }

   public void setGuarcod_N( byte value )
   {
      gxTv_SdtLegajoFamilia_N = (byte)(0) ;
      gxTv_SdtLegajoFamilia_Guarcod_N = value ;
   }

   protected byte gxTv_SdtLegajoFamilia_Famfecnac_N ;
   protected byte gxTv_SdtLegajoFamilia_Famdiscap_N ;
   protected byte gxTv_SdtLegajoFamilia_Guarcod_N ;
   private byte gxTv_SdtLegajoFamilia_N ;
   protected short gxTv_SdtLegajoFamilia_Empcod ;
   protected short gxTv_SdtLegajoFamilia_Legorden ;
   protected short gxTv_SdtLegajoFamilia_Fammesdesde ;
   protected short gxTv_SdtLegajoFamilia_Fammeshasta ;
   protected short gxTv_SdtLegajoFamilia_Guarcod ;
   protected short gxTv_SdtLegajoFamilia_Initialized ;
   protected short gxTv_SdtLegajoFamilia_Empcod_Z ;
   protected short gxTv_SdtLegajoFamilia_Legorden_Z ;
   protected short gxTv_SdtLegajoFamilia_Fammesdesde_Z ;
   protected short gxTv_SdtLegajoFamilia_Fammeshasta_Z ;
   protected short gxTv_SdtLegajoFamilia_Guarcod_Z ;
   protected int gxTv_SdtLegajoFamilia_Clicod ;
   protected int gxTv_SdtLegajoFamilia_Legnumero ;
   protected int gxTv_SdtLegajoFamilia_Clicod_Z ;
   protected int gxTv_SdtLegajoFamilia_Legnumero_Z ;
   protected String gxTv_SdtLegajoFamilia_Parcod ;
   protected String gxTv_SdtLegajoFamilia_Famnrodoc ;
   protected String gxTv_SdtLegajoFamilia_Mode ;
   protected String gxTv_SdtLegajoFamilia_Parcod_Z ;
   protected String gxTv_SdtLegajoFamilia_Famnrodoc_Z ;
   protected boolean gxTv_SdtLegajoFamilia_Famdiscap ;
   protected boolean gxTv_SdtLegajoFamilia_Famasigfam ;
   protected boolean gxTv_SdtLegajoFamilia_Famadherente ;
   protected boolean gxTv_SdtLegajoFamilia_Famdiscap_Z ;
   protected boolean gxTv_SdtLegajoFamilia_Famasigfam_Z ;
   protected boolean gxTv_SdtLegajoFamilia_Famadherente_Z ;
   protected String gxTv_SdtLegajoFamilia_Famapellido ;
   protected String gxTv_SdtLegajoFamilia_Famnombres ;
   protected String gxTv_SdtLegajoFamilia_Famnomape ;
   protected String gxTv_SdtLegajoFamilia_Pardescrip ;
   protected String gxTv_SdtLegajoFamilia_Famapellido_Z ;
   protected String gxTv_SdtLegajoFamilia_Famnombres_Z ;
   protected String gxTv_SdtLegajoFamilia_Famnomape_Z ;
   protected String gxTv_SdtLegajoFamilia_Pardescrip_Z ;
   protected java.util.Date gxTv_SdtLegajoFamilia_Famfecnac ;
   protected java.math.BigDecimal gxTv_SdtLegajoFamilia_Famtomadeducimpgan ;
   protected java.util.Date gxTv_SdtLegajoFamilia_Famfecnac_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z ;
}

