package web ;
import com.genexus.*;

public final  class StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem.class ));
   }

   public StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( int remoteHandle ,
                                                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = cal.getTime() ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo = "" ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog = "" ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(1) ;
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

   public short getEmpcod( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero = value ;
   }

   public short getLegsuelsec( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec ;
   }

   public void setLegsuelsec( short value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec = value ;
   }

   public java.util.Date getLegsuelfecha( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha ;
   }

   public void setLegsuelfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = value ;
   }

   public java.math.BigDecimal getLegsuelimporte( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte ;
   }

   public void setLegsuelimporte( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte = value ;
   }

   public String getLegsueltipo( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo ;
   }

   public void setLegsueltipo( String value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo = value ;
   }

   public int getClicod( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod = value ;
   }

   public java.math.BigDecimal getLegsuelcalc( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc ;
   }

   public void setLegsuelcalc( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc = value ;
   }

   public String getLegsuellog( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog ;
   }

   public void setLegsuellog( String value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog = value ;
   }

   protected byte gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N ;
   protected byte gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N ;
   protected short gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod ;
   protected short gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec ;
   protected int gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero ;
   protected int gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod ;
   protected String gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo ;
   protected String gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog ;
   protected java.util.Date gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha ;
   protected java.math.BigDecimal gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte ;
   protected java.math.BigDecimal gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc ;
}

