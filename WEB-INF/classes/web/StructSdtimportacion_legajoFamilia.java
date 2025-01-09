package web ;
import com.genexus.*;

public final  class StructSdtimportacion_legajoFamilia implements Cloneable, java.io.Serializable
{
   public StructSdtimportacion_legajoFamilia( )
   {
      this( -1, new ModelContext( StructSdtimportacion_legajoFamilia.class ));
   }

   public StructSdtimportacion_legajoFamilia( int remoteHandle ,
                                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = new java.math.BigDecimal(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = cal.getTime() ;
      gxTv_Sdtimportacion_legajoFamilia_Mode = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = new java.math.BigDecimal(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = cal.getTime() ;
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
      return gxTv_Sdtimportacion_legajoFamilia_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Empcod = value ;
   }

   public int getMigrlegnumero( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero ;
   }

   public void setMigrlegnumero( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero = value ;
   }

   public short getMigrlegfamsec( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec ;
   }

   public void setMigrlegfamsec( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec = value ;
   }

   public String getMigrlegfamparen( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen ;
   }

   public void setMigrlegfamparen( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = value ;
   }

   public String getMigrlegfamdiscap( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap ;
   }

   public void setMigrlegfamdiscap( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = value ;
   }

   public String getMigrlegfamnrodoc( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc ;
   }

   public void setMigrlegfamnrodoc( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = value ;
   }

   public java.math.BigDecimal getMigrlegfamdedgan( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan ;
   }

   public void setMigrlegfamdedgan( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = value ;
   }

   public String getMigrlegfamadh( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh ;
   }

   public void setMigrlegfamadh( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = value ;
   }

   public String getMigrlegfamerrores( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores ;
   }

   public void setMigrlegfamerrores( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = value ;
   }

   public String getMigrlegfamwarnings( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings ;
   }

   public void setMigrlegfamwarnings( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = value ;
   }

   public String getMigrlegapellido( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido ;
   }

   public void setMigrlegapellido( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = value ;
   }

   public String getMigrlegnombre( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre ;
   }

   public void setMigrlegnombre( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = value ;
   }

   public String getMigrlegcuil( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil ;
   }

   public void setMigrlegcuil( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = value ;
   }

   public String getMigrlegfamnomape( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape ;
   }

   public void setMigrlegfamnomape( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = value ;
   }

   public java.util.Date getMigrlegfamfecnac( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac ;
   }

   public void setMigrlegfamfecnac( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Empcod_Z = value ;
   }

   public int getMigrlegnumero_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z ;
   }

   public void setMigrlegnumero_Z( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z = value ;
   }

   public short getMigrlegfamsec_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z ;
   }

   public void setMigrlegfamsec_Z( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z = value ;
   }

   public String getMigrlegfamparen_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z ;
   }

   public void setMigrlegfamparen_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = value ;
   }

   public String getMigrlegfamdiscap_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z ;
   }

   public void setMigrlegfamdiscap_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = value ;
   }

   public String getMigrlegfamnrodoc_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z ;
   }

   public void setMigrlegfamnrodoc_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = value ;
   }

   public java.math.BigDecimal getMigrlegfamdedgan_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z ;
   }

   public void setMigrlegfamdedgan_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = value ;
   }

   public String getMigrlegfamadh_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z ;
   }

   public void setMigrlegfamadh_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = value ;
   }

   public String getMigrlegapellido_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z ;
   }

   public void setMigrlegapellido_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = value ;
   }

   public String getMigrlegnombre_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z ;
   }

   public void setMigrlegnombre_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = value ;
   }

   public String getMigrlegcuil_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z ;
   }

   public void setMigrlegcuil_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = value ;
   }

   public String getMigrlegfamnomape_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z ;
   }

   public void setMigrlegfamnomape_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = value ;
   }

   public java.util.Date getMigrlegfamfecnac_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z ;
   }

   public void setMigrlegfamfecnac_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = value ;
   }

   private byte gxTv_Sdtimportacion_legajoFamilia_N ;
   protected short gxTv_Sdtimportacion_legajoFamilia_Empcod ;
   protected short gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec ;
   protected short gxTv_Sdtimportacion_legajoFamilia_Initialized ;
   protected short gxTv_Sdtimportacion_legajoFamilia_Empcod_Z ;
   protected short gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z ;
   protected int gxTv_Sdtimportacion_legajoFamilia_Clicod ;
   protected int gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero ;
   protected int gxTv_Sdtimportacion_legajoFamilia_Clicod_Z ;
   protected int gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Mode ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z ;
   protected String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan ;
   protected java.util.Date gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z ;
   protected java.util.Date gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z ;
}

