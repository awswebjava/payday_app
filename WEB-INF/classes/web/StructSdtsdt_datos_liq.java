package web ;
import com.genexus.*;

public final  class StructSdtsdt_datos_liq implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_datos_liq( )
   {
      this( -1, new ModelContext( StructSdtsdt_datos_liq.class ));
   }

   public StructSdtsdt_datos_liq( int remoteHandle ,
                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_datos_liq_Liqfecha = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Liqdescrip = "" ;
      gxTv_Sdtsdt_datos_liq_Tliqcod = "" ;
      gxTv_Sdtsdt_datos_liq_Aplicaa = "" ;
      gxTv_Sdtsdt_datos_liq_Legnumero_obj = "" ;
      gxTv_Sdtsdt_datos_liq_Liqdepbancod = "" ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Liqfecimp = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Parmliqperpalabra = "" ;
      gxTv_Sdtsdt_datos_liq_Liqnombre = "" ;
      gxTv_Sdtsdt_datos_liq_Clientid = "" ;
      gxTv_Sdtsdt_datos_liq_Liqsaclog = "" ;
      gxTv_Sdtsdt_datos_liq_Env = "" ;
      gxTv_Sdtsdt_datos_liq_Daemonuuid = "" ;
      gxTv_Sdtsdt_datos_liq_Liqmodtra = "" ;
      gxTv_Sdtsdt_datos_liq_Liqperdes = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Liqperhas = cal.getTime() ;
      gxTv_Sdtsdt_datos_liq_Liqtipotarifa = "" ;
      gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(1) ;
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
      return gxTv_Sdtsdt_datos_liq_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtsdt_datos_liq_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Empcod = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqnro = value ;
   }

   public java.util.Date getLiqfecha( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecha ;
   }

   public void setLiqfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecha = value ;
   }

   public java.util.Date getLiqfecpago( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecpago ;
   }

   public void setLiqfecpago( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago = value ;
   }

   public String getLiqdescrip( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdescrip ;
   }

   public void setLiqdescrip( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdescrip = value ;
   }

   public byte getLiqclase( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqclase ;
   }

   public void setLiqclase( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqclase = value ;
   }

   public byte getLiqestado( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqestado ;
   }

   public void setLiqestado( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqestado = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_Sdtsdt_datos_liq_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Tliqcod = value ;
   }

   public String getAplicaa( )
   {
      return gxTv_Sdtsdt_datos_liq_Aplicaa ;
   }

   public void setAplicaa( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Aplicaa = value ;
   }

   public String getLegnumero_obj( )
   {
      return gxTv_Sdtsdt_datos_liq_Legnumero_obj ;
   }

   public void setLegnumero_obj( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Legnumero_obj = value ;
   }

   public String getLiqdepbancod( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepbancod ;
   }

   public void setLiqdepbancod( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepbancod = value ;
   }

   public java.util.Date getLiqdepprvfec( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepprvfec ;
   }

   public void setLiqdepprvfec( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec = value ;
   }

   public short getLiqdepperano( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepperano ;
   }

   public void setLiqdepperano( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepperano = value ;
   }

   public byte getLiqdeppermes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdeppermes ;
   }

   public void setLiqdeppermes( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdeppermes = value ;
   }

   public byte getLiqpermes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqpermes ;
   }

   public void setLiqpermes( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqpermes = value ;
   }

   public short getLiqperano( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperano ;
   }

   public void setLiqperano( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperano = value ;
   }

   public java.util.Date getLiqfecimp( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecimp ;
   }

   public void setLiqfecimp( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecimp = value ;
   }

   public String getParmliqperpalabra( )
   {
      return gxTv_Sdtsdt_datos_liq_Parmliqperpalabra ;
   }

   public void setParmliqperpalabra( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Parmliqperpalabra = value ;
   }

   public String getLiqnombre( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqnombre ;
   }

   public void setLiqnombre( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqnombre = value ;
   }

   public int getLiqrelnro( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqrelnro ;
   }

   public void setLiqrelnro( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqrelnro = value ;
   }

   public String getClientid( )
   {
      return gxTv_Sdtsdt_datos_liq_Clientid ;
   }

   public void setClientid( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Clientid = value ;
   }

   public boolean getLiqsac( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqsac ;
   }

   public void setLiqsac( boolean value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqsac = value ;
   }

   public String getLiqsaclog( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqsaclog ;
   }

   public void setLiqsaclog( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqsaclog = value ;
   }

   public short getReplicanro( )
   {
      return gxTv_Sdtsdt_datos_liq_Replicanro ;
   }

   public void setReplicanro( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Replicanro = value ;
   }

   public String getEnv( )
   {
      return gxTv_Sdtsdt_datos_liq_Env ;
   }

   public void setEnv( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Env = value ;
   }

   public String getDaemonuuid( )
   {
      return gxTv_Sdtsdt_datos_liq_Daemonuuid ;
   }

   public void setDaemonuuid( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Daemonuuid = value ;
   }

   public boolean getReliquidacion( )
   {
      return gxTv_Sdtsdt_datos_liq_Reliquidacion ;
   }

   public void setReliquidacion( boolean value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Reliquidacion = value ;
   }

   public String getLiqmodtra( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqmodtra ;
   }

   public void setLiqmodtra( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqmodtra = value ;
   }

   public byte getLiqfrecpag( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfrecpag ;
   }

   public void setLiqfrecpag( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfrecpag = value ;
   }

   public java.util.Date getLiqperdes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperdes ;
   }

   public void setLiqperdes( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperdes = value ;
   }

   public java.util.Date getLiqperhas( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperhas ;
   }

   public void setLiqperhas( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperhas = value ;
   }

   public String getLiqtipotarifa( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqtipotarifa ;
   }

   public void setLiqtipotarifa( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqtipotarifa = value ;
   }

   protected byte gxTv_Sdtsdt_datos_liq_Liqclase ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqestado ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqdeppermes ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqpermes ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfrecpag ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecha_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecpago_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecimp_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqperdes_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqperhas_N ;
   protected byte gxTv_Sdtsdt_datos_liq_N ;
   protected short gxTv_Sdtsdt_datos_liq_Empcod ;
   protected short gxTv_Sdtsdt_datos_liq_Liqdepperano ;
   protected short gxTv_Sdtsdt_datos_liq_Liqperano ;
   protected short gxTv_Sdtsdt_datos_liq_Replicanro ;
   protected int gxTv_Sdtsdt_datos_liq_Clicod ;
   protected int gxTv_Sdtsdt_datos_liq_Liqnro ;
   protected int gxTv_Sdtsdt_datos_liq_Liqrelnro ;
   protected String gxTv_Sdtsdt_datos_liq_Tliqcod ;
   protected String gxTv_Sdtsdt_datos_liq_Aplicaa ;
   protected String gxTv_Sdtsdt_datos_liq_Liqdepbancod ;
   protected String gxTv_Sdtsdt_datos_liq_Parmliqperpalabra ;
   protected String gxTv_Sdtsdt_datos_liq_Env ;
   protected String gxTv_Sdtsdt_datos_liq_Daemonuuid ;
   protected String gxTv_Sdtsdt_datos_liq_Liqmodtra ;
   protected String gxTv_Sdtsdt_datos_liq_Liqtipotarifa ;
   protected boolean gxTv_Sdtsdt_datos_liq_Liqsac ;
   protected boolean gxTv_Sdtsdt_datos_liq_Reliquidacion ;
   protected String gxTv_Sdtsdt_datos_liq_Liqdescrip ;
   protected String gxTv_Sdtsdt_datos_liq_Legnumero_obj ;
   protected String gxTv_Sdtsdt_datos_liq_Liqnombre ;
   protected String gxTv_Sdtsdt_datos_liq_Clientid ;
   protected String gxTv_Sdtsdt_datos_liq_Liqsaclog ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecha ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecpago ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqdepprvfec ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecimp ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqperdes ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqperhas ;
}

