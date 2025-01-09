package web ;
import com.genexus.*;

public final  class StructSdtbody_chequearLiquidacionFin implements Cloneable, java.io.Serializable
{
   public StructSdtbody_chequearLiquidacionFin( )
   {
      this( -1, new ModelContext( StructSdtbody_chequearLiquidacionFin.class ));
   }

   public StructSdtbody_chequearLiquidacionFin( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_Clientid = "" ;
      gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid = "" ;
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
      return gxTv_Sdtbody_chequearLiquidacionFin_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Empcod = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Liqnro = value ;
   }

   public short getCantidadporlote( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote ;
   }

   public void setCantidadporlote( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote = value ;
   }

   public short getCantidaddelotes( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes ;
   }

   public void setCantidaddelotes( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes = value ;
   }

   public String getClientid( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Clientid ;
   }

   public void setClientid( String value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Clientid = value ;
   }

   public String getDaemonuuid( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid ;
   }

   public void setDaemonuuid( String value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid = value ;
   }

   protected byte gxTv_Sdtbody_chequearLiquidacionFin_N ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Empcod ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes ;
   protected int gxTv_Sdtbody_chequearLiquidacionFin_Clicod ;
   protected int gxTv_Sdtbody_chequearLiquidacionFin_Liqnro ;
   protected String gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid ;
   protected String gxTv_Sdtbody_chequearLiquidacionFin_Clientid ;
}

