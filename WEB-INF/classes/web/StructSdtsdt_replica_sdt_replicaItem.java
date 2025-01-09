package web ;
import com.genexus.*;

public final  class StructSdtsdt_replica_sdt_replicaItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_replica_sdt_replicaItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_replica_sdt_replicaItem.class ));
   }

   public StructSdtsdt_replica_sdt_replicaItem( int remoteHandle ,
                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = cal.getTime() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = cal.getTime() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = cal.getTime() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = cal.getTime() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = cal.getTime() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(1) ;
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

   public java.util.Date getLiqfecha( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha ;
   }

   public void setLiqfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = value ;
   }

   public java.util.Date getLiqfecpago( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago ;
   }

   public void setLiqfecpago( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = value ;
   }

   public byte getLiqclase( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase ;
   }

   public void setLiqclase( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod = value ;
   }

   public String getLiqdepbancod( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod ;
   }

   public void setLiqdepbancod( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod = value ;
   }

   public java.util.Date getLiqdepprvfec( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec ;
   }

   public void setLiqdepprvfec( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = value ;
   }

   public short getLiqdepperano( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano ;
   }

   public void setLiqdepperano( short value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano = value ;
   }

   public byte getLiqdeppermes( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes ;
   }

   public void setLiqdeppermes( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes = value ;
   }

   public byte getLiqpermes( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes ;
   }

   public void setLiqpermes( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes = value ;
   }

   public short getLiqperano( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano ;
   }

   public void setLiqperano( short value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano = value ;
   }

   public java.util.Date getLiqfecimp( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp ;
   }

   public void setLiqfecimp( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = value ;
   }

   public String getLiqperpalabra( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra ;
   }

   public void setLiqperpalabra( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra = value ;
   }

   public java.math.BigDecimal getLiqimpneto( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto ;
   }

   public void setLiqimpneto( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = value ;
   }

   public String getLegajos( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos ;
   }

   public void setLegajos( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos = value ;
   }

   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_N ;
   protected short gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano ;
   protected short gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp ;
   protected java.math.BigDecimal gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo ;
}

