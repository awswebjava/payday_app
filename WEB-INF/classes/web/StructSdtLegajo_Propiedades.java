package web ;
import com.genexus.*;

public final  class StructSdtLegajo_Propiedades implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo_Propiedades( )
   {
      this( -1, new ModelContext( StructSdtLegajo_Propiedades.class ));
   }

   public StructSdtLegajo_Propiedades( int remoteHandle ,
                                       ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajo_Propiedades_Legpropcod = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropdes = "" ;
      gxTv_SdtLegajo_Propiedades_Legproptd = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate = cal.getTime() ;
      gxTv_SdtLegajo_Propiedades_Mode = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropcod_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropdes_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legproptd_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = "" ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = cal.getTime() ;
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

   public String getLegpropcod( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropcod ;
   }

   public void setLegpropcod( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropcod = value ;
   }

   public String getLegpropdes( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropdes ;
   }

   public void setLegpropdes( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropdes = value ;
   }

   public String getLegproptd( )
   {
      return gxTv_SdtLegajo_Propiedades_Legproptd ;
   }

   public void setLegproptd( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legproptd = value ;
   }

   public java.math.BigDecimal getLegpropvalnum( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalnum ;
   }

   public void setLegpropvalnum( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum = value ;
   }

   public boolean getLegpropvalbool( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalbool ;
   }

   public void setLegpropvalbool( boolean value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalbool = value ;
   }

   public String getLegpropvalstr( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalstr ;
   }

   public void setLegpropvalstr( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr = value ;
   }

   public java.util.Date getLegpropvaldate( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvaldate ;
   }

   public void setLegpropvaldate( java.util.Date value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_Propiedades_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtLegajo_Propiedades_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_Propiedades_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Initialized = value ;
   }

   public String getLegpropcod_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropcod_Z ;
   }

   public void setLegpropcod_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropcod_Z = value ;
   }

   public String getLegpropdes_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropdes_Z ;
   }

   public void setLegpropdes_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropdes_Z = value ;
   }

   public String getLegproptd_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legproptd_Z ;
   }

   public void setLegproptd_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legproptd_Z = value ;
   }

   public java.math.BigDecimal getLegpropvalnum_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z ;
   }

   public void setLegpropvalnum_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z = value ;
   }

   public boolean getLegpropvalbool_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z ;
   }

   public void setLegpropvalbool_Z( boolean value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z = value ;
   }

   public String getLegpropvalstr_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z ;
   }

   public void setLegpropvalstr_Z( String value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z = value ;
   }

   public java.util.Date getLegpropvaldate_Z( )
   {
      return gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z ;
   }

   public void setLegpropvaldate_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Propiedades_N = (byte)(0) ;
      gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z = value ;
   }

   private byte gxTv_SdtLegajo_Propiedades_N ;
   protected short gxTv_SdtLegajo_Propiedades_Modified ;
   protected short gxTv_SdtLegajo_Propiedades_Initialized ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropcod ;
   protected String gxTv_SdtLegajo_Propiedades_Legproptd ;
   protected String gxTv_SdtLegajo_Propiedades_Mode ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropcod_Z ;
   protected String gxTv_SdtLegajo_Propiedades_Legproptd_Z ;
   protected boolean gxTv_SdtLegajo_Propiedades_Legpropvalbool ;
   protected boolean gxTv_SdtLegajo_Propiedades_Legpropvalbool_Z ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropdes ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropvalstr ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropdes_Z ;
   protected String gxTv_SdtLegajo_Propiedades_Legpropvalstr_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Propiedades_Legpropvalnum ;
   protected java.util.Date gxTv_SdtLegajo_Propiedades_Legpropvaldate ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Propiedades_Legpropvalnum_Z ;
   protected java.util.Date gxTv_SdtLegajo_Propiedades_Legpropvaldate_Z ;
}

