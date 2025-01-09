package web ;
import com.genexus.*;

public final  class StructSdtPais_tipo_trabajo implements Cloneable, java.io.Serializable
{
   public StructSdtPais_tipo_trabajo( )
   {
      this( -1, new ModelContext( StructSdtPais_tipo_trabajo.class ));
   }

   public StructSdtPais_tipo_trabajo( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotraid = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Mode = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(1) ;
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

   public String getPaitipotraid( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotraid ;
   }

   public void setPaitipotraid( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotraid = value ;
   }

   public String getPaitipotranom( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotranom ;
   }

   public void setPaitipotranom( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom = value ;
   }

   public String getPaitipotrahor( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor ;
   }

   public void setPaitipotrahor( String value )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor = value ;
   }

   public boolean getPaitipotrains( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrains ;
   }

   public void setPaitipotrains( boolean value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrains = value ;
   }

   public java.math.BigDecimal getPaitipohsdia( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsdia ;
   }

   public void setPaitipohsdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia = value ;
   }

   public java.math.BigDecimal getPaitipohssem( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohssem ;
   }

   public void setPaitipohssem( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem = value ;
   }

   public java.math.BigDecimal getPaitipotarifaxlim( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim ;
   }

   public void setPaitipotarifaxlim( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = value ;
   }

   public java.math.BigDecimal getPaitipotarifarec( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifarec ;
   }

   public void setPaitipotarifarec( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxdia( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia ;
   }

   public void setPaitipohsmaxdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxsem( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem ;
   }

   public void setPaitipohsmaxsem( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxmes( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes ;
   }

   public void setPaitipohsmaxmes( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxanu( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu ;
   }

   public void setPaitipohsmaxanu( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_tipo_trabajo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtPais_tipo_trabajo_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_tipo_trabajo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Initialized = value ;
   }

   public String getPaitipotraid_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z ;
   }

   public void setPaitipotraid_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = value ;
   }

   public String getPaitipotranom_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z ;
   }

   public void setPaitipotranom_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = value ;
   }

   public String getPaitipotrahor_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z ;
   }

   public void setPaitipotrahor_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = value ;
   }

   public boolean getPaitipotrains_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z ;
   }

   public void setPaitipotrains_Z( boolean value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z = value ;
   }

   public java.math.BigDecimal getPaitipohsdia_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z ;
   }

   public void setPaitipohsdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = value ;
   }

   public java.math.BigDecimal getPaitipohssem_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z ;
   }

   public void setPaitipohssem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = value ;
   }

   public java.math.BigDecimal getPaitipotarifaxlim_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z ;
   }

   public void setPaitipotarifaxlim_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = value ;
   }

   public java.math.BigDecimal getPaitipotarifarec_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z ;
   }

   public void setPaitipotarifarec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxdia_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z ;
   }

   public void setPaitipohsmaxdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxsem_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z ;
   }

   public void setPaitipohsmaxsem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxmes_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z ;
   }

   public void setPaitipohsmaxmes_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = value ;
   }

   public java.math.BigDecimal getPaitipohsmaxanu_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z ;
   }

   public void setPaitipohsmaxanu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = value ;
   }

   public byte getPaitipotrahor_N( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N ;
   }

   public void setPaitipotrahor_N( byte value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = value ;
   }

   protected byte gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N ;
   private byte gxTv_SdtPais_tipo_trabajo_N ;
   protected short gxTv_SdtPais_tipo_trabajo_Modified ;
   protected short gxTv_SdtPais_tipo_trabajo_Initialized ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotraid ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotrahor ;
   protected String gxTv_SdtPais_tipo_trabajo_Mode ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z ;
   protected boolean gxTv_SdtPais_tipo_trabajo_Paitipotrains ;
   protected boolean gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotranom ;
   protected String gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsdia ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohssem ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifarec ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z ;
   protected java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z ;
}

