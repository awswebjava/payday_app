package web ;
import com.genexus.*;

public final  class StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem.class ));
   }

   public StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr = "" ;
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

   public String getTliqcod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod = value ;
   }

   public boolean getContliqsincausa( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa ;
   }

   public void setContliqsincausa( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa = value ;
   }

   public boolean getContliqsinpre( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre ;
   }

   public void setContliqsinpre( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre = value ;
   }

   public String getContltipegr( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr ;
   }

   public void setContltipegr( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr = value ;
   }

   public short getContlconord( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord ;
   }

   public void setContlconord( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord = value ;
   }

   public long getContlordejec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec ;
   }

   public void setContlordejec( long value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec = value ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord ;
   protected long gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre ;
}

