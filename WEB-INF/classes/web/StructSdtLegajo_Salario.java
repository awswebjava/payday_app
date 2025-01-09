package web ;
import com.genexus.*;

public final  class StructSdtLegajo_Salario implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo_Salario( )
   {
      this( -1, new ModelContext( StructSdtLegajo_Salario.class ));
   }

   public StructSdtLegajo_Salario( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLegajo_Salario_Legsuelfecha = cal.getTime() ;
      gxTv_SdtLegajo_Salario_Legsuelimporte = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo = "" ;
      gxTv_SdtLegajo_Salario_Legsuelcalc = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Salario_Legsuellog = "" ;
      gxTv_SdtLegajo_Salario_Mode = "" ;
      gxTv_SdtLegajo_Salario_Legsuelfecha_Z = cal.getTime() ;
      gxTv_SdtLegajo_Salario_Legsuelimporte_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo_Z = "" ;
      gxTv_SdtLegajo_Salario_Legsuelcalc_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(1) ;
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

   public short getLegsuelsec( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelsec ;
   }

   public void setLegsuelsec( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelsec = value ;
   }

   public java.util.Date getLegsuelfecha( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelfecha ;
   }

   public void setLegsuelfecha( java.util.Date value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelfecha = value ;
   }

   public java.math.BigDecimal getLegsuelimporte( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelimporte ;
   }

   public void setLegsuelimporte( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelimporte = value ;
   }

   public String getLegsueltipo( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo ;
   }

   public void setLegsueltipo( String value )
   {
      gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo = value ;
   }

   public java.math.BigDecimal getLegsuelcalc( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelcalc ;
   }

   public void setLegsuelcalc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelcalc = value ;
   }

   public String getLegsuellog( )
   {
      return gxTv_SdtLegajo_Salario_Legsuellog ;
   }

   public void setLegsuellog( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuellog = value ;
   }

   public java.util.Vector<web.StructSdtLegajo_Salario_Conceptos> getConceptos( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos ;
   }

   public void setConceptos( java.util.Vector<web.StructSdtLegajo_Salario_Conceptos> value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_Salario_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtLegajo_Salario_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_Salario_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Initialized = value ;
   }

   public short getLegsuelsec_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelsec_Z ;
   }

   public void setLegsuelsec_Z( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelsec_Z = value ;
   }

   public java.util.Date getLegsuelfecha_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelfecha_Z ;
   }

   public void setLegsuelfecha_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelfecha_Z = value ;
   }

   public java.math.BigDecimal getLegsuelimporte_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelimporte_Z ;
   }

   public void setLegsuelimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelimporte_Z = value ;
   }

   public String getLegsueltipo_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo_Z ;
   }

   public void setLegsueltipo_Z( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo_Z = value ;
   }

   public java.math.BigDecimal getLegsuelcalc_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelcalc_Z ;
   }

   public void setLegsuelcalc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsuelcalc_Z = value ;
   }

   public byte getLegsueltipo_N( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo_N ;
   }

   public void setLegsueltipo_N( byte value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Legsueltipo_N = value ;
   }

   protected byte gxTv_SdtLegajo_Salario_Legsueltipo_N ;
   private byte gxTv_SdtLegajo_Salario_N ;
   protected short gxTv_SdtLegajo_Salario_Legsuelsec ;
   protected short gxTv_SdtLegajo_Salario_Modified ;
   protected short gxTv_SdtLegajo_Salario_Initialized ;
   protected short gxTv_SdtLegajo_Salario_Legsuelsec_Z ;
   protected String gxTv_SdtLegajo_Salario_Legsueltipo ;
   protected String gxTv_SdtLegajo_Salario_Mode ;
   protected String gxTv_SdtLegajo_Salario_Legsueltipo_Z ;
   protected String gxTv_SdtLegajo_Salario_Legsuellog ;
   protected java.util.Date gxTv_SdtLegajo_Salario_Legsuelfecha ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelimporte ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelcalc ;
   protected java.util.Date gxTv_SdtLegajo_Salario_Legsuelfecha_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelimporte_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelcalc_Z ;
   protected java.util.Vector<web.StructSdtLegajo_Salario_Conceptos> gxTv_SdtLegajo_Salario_Conceptos=null ;
}

