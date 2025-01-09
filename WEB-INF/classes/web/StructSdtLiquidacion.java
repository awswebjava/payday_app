package web ;
import com.genexus.*;

public final  class StructSdtLiquidacion implements Cloneable, java.io.Serializable
{
   public StructSdtLiquidacion( )
   {
      this( -1, new ModelContext( StructSdtLiquidacion.class ));
   }

   public StructSdtLiquidacion( int remoteHandle ,
                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLiquidacion_Empnom = "" ;
      gxTv_SdtLiquidacion_Liqdescrip = "" ;
      gxTv_SdtLiquidacion_Liqfecha = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqperiodo = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqfecpago = cal.getTime() ;
      gxTv_SdtLiquidacion_Tliqcod = "" ;
      gxTv_SdtLiquidacion_Tliqdesc = "" ;
      gxTv_SdtLiquidacion_Tliqdescaux = "" ;
      gxTv_SdtLiquidacion_Liqpdfestado = "" ;
      gxTv_SdtLiquidacion_Liqimpneto = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpdescuentos = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpretengan = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpbruto = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqfeccre = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqusucre = "" ;
      gxTv_SdtLiquidacion_Liqpersindia = "" ;
      gxTv_SdtLiquidacion_Liqperpalabra = "" ;
      gxTv_SdtLiquidacion_Liqdepprvper = "" ;
      gxTv_SdtLiquidacion_Liqdepprvfec = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqdepbandescrip = "" ;
      gxTv_SdtLiquidacion_Liqdepbancod = "" ;
      gxTv_SdtLiquidacion_Liqfecmod = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqusumod = "" ;
      gxTv_SdtLiquidacion_Liqfecimp = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqpisoganancias = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqpisgansac = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqtopededinc = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqperultnorm = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqerror = "" ;
      gxTv_SdtLiquidacion_Liqerroraux = "" ;
      gxTv_SdtLiquidacion_Liqnombre = "" ;
      gxTv_SdtLiquidacion_Liqlegajostxt = "" ;
      gxTv_SdtLiquidacion_Liqsegundos = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = "" ;
      gxTv_SdtLiquidacion_Liqlog = "" ;
      gxTv_SdtLiquidacion_Periodoliq = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqsaclog = "" ;
      gxTv_SdtLiquidacion_Liqmodtra = "" ;
      gxTv_SdtLiquidacion_Liqperdes = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqperhas = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqtipotarifa = "" ;
      gxTv_SdtLiquidacion_Mode = "" ;
      gxTv_SdtLiquidacion_Empnom_Z = "" ;
      gxTv_SdtLiquidacion_Liqdescrip_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecha_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqperiodo_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqfecpago_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtLiquidacion_Tliqdescaux_Z = "" ;
      gxTv_SdtLiquidacion_Liqpdfestado_Z = "" ;
      gxTv_SdtLiquidacion_Liqimpneto_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpdescuentos_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpretengan_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqimpbruto_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqfeccre_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqusucre_Z = "" ;
      gxTv_SdtLiquidacion_Liqpersindia_Z = "" ;
      gxTv_SdtLiquidacion_Liqperpalabra_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepprvper_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepprvfec_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqdepbandescrip_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepbancod_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecmod_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqusumod_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecimp_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqpisoganancias_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqpisgansac_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqtopededinc_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqperultnorm_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqerror_Z = "" ;
      gxTv_SdtLiquidacion_Liqerroraux_Z = "" ;
      gxTv_SdtLiquidacion_Liqnombre_Z = "" ;
      gxTv_SdtLiquidacion_Liqlegajostxt_Z = "" ;
      gxTv_SdtLiquidacion_Liqsegundos_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = "" ;
      gxTv_SdtLiquidacion_Periodoliq_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqsaclog_Z = "" ;
      gxTv_SdtLiquidacion_Liqmodtra_Z = "" ;
      gxTv_SdtLiquidacion_Liqperdes_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqperhas_Z = cal.getTime() ;
      gxTv_SdtLiquidacion_Liqtipotarifa_Z = "" ;
      gxTv_SdtLiquidacion_Tliqcod_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqclase_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqsac_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(1) ;
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
      return gxTv_SdtLiquidacion_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLiquidacion_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Empcod = value ;
   }

   public String getEmpnom( )
   {
      return gxTv_SdtLiquidacion_Empnom ;
   }

   public void setEmpnom( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Empnom = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_SdtLiquidacion_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqnro = value ;
   }

   public String getLiqdescrip( )
   {
      return gxTv_SdtLiquidacion_Liqdescrip ;
   }

   public void setLiqdescrip( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdescrip = value ;
   }

   public java.util.Date getLiqfecha( )
   {
      return gxTv_SdtLiquidacion_Liqfecha ;
   }

   public void setLiqfecha( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecha = value ;
   }

   public short getLiqperano( )
   {
      return gxTv_SdtLiquidacion_Liqperano ;
   }

   public void setLiqperano( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperano = value ;
   }

   public byte getLiqpermes( )
   {
      return gxTv_SdtLiquidacion_Liqpermes ;
   }

   public void setLiqpermes( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpermes = value ;
   }

   public java.util.Date getLiqperiodo( )
   {
      return gxTv_SdtLiquidacion_Liqperiodo ;
   }

   public void setLiqperiodo( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperiodo = value ;
   }

   public java.util.Date getLiqfecpago( )
   {
      return gxTv_SdtLiquidacion_Liqfecpago ;
   }

   public void setLiqfecpago( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecpago = value ;
   }

   public String getTliqcod( )
   {
      return gxTv_SdtLiquidacion_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_SdtLiquidacion_Tliqcod_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqcod = value ;
   }

   public String getTliqdesc( )
   {
      return gxTv_SdtLiquidacion_Tliqdesc ;
   }

   public void setTliqdesc( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqdesc = value ;
   }

   public String getTliqdescaux( )
   {
      return gxTv_SdtLiquidacion_Tliqdescaux ;
   }

   public void setTliqdescaux( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqdescaux = value ;
   }

   public byte getLiqestado( )
   {
      return gxTv_SdtLiquidacion_Liqestado ;
   }

   public void setLiqestado( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqestado = value ;
   }

   public byte getLiqlsddepest( )
   {
      return gxTv_SdtLiquidacion_Liqlsddepest ;
   }

   public void setLiqlsddepest( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqlsddepest = value ;
   }

   public byte getLiqauxestado( )
   {
      return gxTv_SdtLiquidacion_Liqauxestado ;
   }

   public void setLiqauxestado( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqauxestado = value ;
   }

   public byte getLiqcontrest( )
   {
      return gxTv_SdtLiquidacion_Liqcontrest ;
   }

   public void setLiqcontrest( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcontrest = value ;
   }

   public byte getLiqclase( )
   {
      return gxTv_SdtLiquidacion_Liqclase ;
   }

   public void setLiqclase( byte value )
   {
      gxTv_SdtLiquidacion_Liqclase_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqclase = value ;
   }

   public String getLiqpdfestado( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado ;
   }

   public void setLiqpdfestado( String value )
   {
      gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpdfestado = value ;
   }

   public boolean getLiqgeninter( )
   {
      return gxTv_SdtLiquidacion_Liqgeninter ;
   }

   public void setLiqgeninter( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqgeninter = value ;
   }

   public boolean getLiqcontabilizada( )
   {
      return gxTv_SdtLiquidacion_Liqcontabilizada ;
   }

   public void setLiqcontabilizada( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcontabilizada = value ;
   }

   public short getLiqcntleg( )
   {
      return gxTv_SdtLiquidacion_Liqcntleg ;
   }

   public void setLiqcntleg( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcntleg = value ;
   }

   public java.math.BigDecimal getLiqimpneto( )
   {
      return gxTv_SdtLiquidacion_Liqimpneto ;
   }

   public void setLiqimpneto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpneto = value ;
   }

   public java.math.BigDecimal getLiqimpdescuentos( )
   {
      return gxTv_SdtLiquidacion_Liqimpdescuentos ;
   }

   public void setLiqimpdescuentos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpdescuentos = value ;
   }

   public java.math.BigDecimal getLiqimpretengan( )
   {
      return gxTv_SdtLiquidacion_Liqimpretengan ;
   }

   public void setLiqimpretengan( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpretengan = value ;
   }

   public java.math.BigDecimal getLiqimpbruto( )
   {
      return gxTv_SdtLiquidacion_Liqimpbruto ;
   }

   public void setLiqimpbruto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpbruto = value ;
   }

   public boolean getLegespecificos( )
   {
      return gxTv_SdtLiquidacion_Legespecificos ;
   }

   public void setLegespecificos( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Legespecificos = value ;
   }

   public java.util.Date getLiqfeccre( )
   {
      return gxTv_SdtLiquidacion_Liqfeccre ;
   }

   public void setLiqfeccre( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfeccre = value ;
   }

   public String getLiqusucre( )
   {
      return gxTv_SdtLiquidacion_Liqusucre ;
   }

   public void setLiqusucre( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqusucre = value ;
   }

   public String getLiqpersindia( )
   {
      return gxTv_SdtLiquidacion_Liqpersindia ;
   }

   public void setLiqpersindia( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpersindia = value ;
   }

   public String getLiqperpalabra( )
   {
      return gxTv_SdtLiquidacion_Liqperpalabra ;
   }

   public void setLiqperpalabra( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperpalabra = value ;
   }

   public String getLiqdepprvper( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvper ;
   }

   public void setLiqdepprvper( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepprvper = value ;
   }

   public java.util.Date getLiqdepprvfec( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvfec ;
   }

   public void setLiqdepprvfec( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepprvfec = value ;
   }

   public String getLiqdepbandescrip( )
   {
      return gxTv_SdtLiquidacion_Liqdepbandescrip ;
   }

   public void setLiqdepbandescrip( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepbandescrip = value ;
   }

   public String getLiqdepbancod( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod ;
   }

   public void setLiqdepbancod( String value )
   {
      gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepbancod = value ;
   }

   public short getLiqdepperano( )
   {
      return gxTv_SdtLiquidacion_Liqdepperano ;
   }

   public void setLiqdepperano( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepperano = value ;
   }

   public byte getLiqdeppermes( )
   {
      return gxTv_SdtLiquidacion_Liqdeppermes ;
   }

   public void setLiqdeppermes( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdeppermes = value ;
   }

   public java.util.Date getLiqfecmod( )
   {
      return gxTv_SdtLiquidacion_Liqfecmod ;
   }

   public void setLiqfecmod( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecmod = value ;
   }

   public String getLiqusumod( )
   {
      return gxTv_SdtLiquidacion_Liqusumod ;
   }

   public void setLiqusumod( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqusumod = value ;
   }

   public java.util.Date getLiqfecimp( )
   {
      return gxTv_SdtLiquidacion_Liqfecimp ;
   }

   public void setLiqfecimp( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecimp = value ;
   }

   public java.math.BigDecimal getLiqpisoganancias( )
   {
      return gxTv_SdtLiquidacion_Liqpisoganancias ;
   }

   public void setLiqpisoganancias( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpisoganancias = value ;
   }

   public java.math.BigDecimal getLiqpisgansac( )
   {
      return gxTv_SdtLiquidacion_Liqpisgansac ;
   }

   public void setLiqpisgansac( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpisgansac = value ;
   }

   public java.math.BigDecimal getLiqtopededinc( )
   {
      return gxTv_SdtLiquidacion_Liqtopededinc ;
   }

   public void setLiqtopededinc( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqtopededinc = value ;
   }

   public java.util.Date getLiqperultnorm( )
   {
      return gxTv_SdtLiquidacion_Liqperultnorm ;
   }

   public void setLiqperultnorm( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperultnorm = value ;
   }

   public String getLiqerror( )
   {
      return gxTv_SdtLiquidacion_Liqerror ;
   }

   public void setLiqerror( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqerror = value ;
   }

   public String getLiqerroraux( )
   {
      return gxTv_SdtLiquidacion_Liqerroraux ;
   }

   public void setLiqerroraux( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqerroraux = value ;
   }

   public String getLiqnombre( )
   {
      return gxTv_SdtLiquidacion_Liqnombre ;
   }

   public void setLiqnombre( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqnombre = value ;
   }

   public String getLiqlegajostxt( )
   {
      return gxTv_SdtLiquidacion_Liqlegajostxt ;
   }

   public void setLiqlegajostxt( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqlegajostxt = value ;
   }

   public java.math.BigDecimal getLiqsegundos( )
   {
      return gxTv_SdtLiquidacion_Liqsegundos ;
   }

   public void setLiqsegundos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsegundos = value ;
   }

   public String getLiqrutapdftodosvertical( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosvertical ;
   }

   public void setLiqrutapdftodosvertical( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical = value ;
   }

   public String getLiqrutapdftodoshorizontal( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal ;
   }

   public void setLiqrutapdftodoshorizontal( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = value ;
   }

   public String getLiqrutapdftodosnombrevertical( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical ;
   }

   public void setLiqrutapdftodosnombrevertical( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = value ;
   }

   public String getLiqrutapdftodosnombrehorizontal( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal ;
   }

   public void setLiqrutapdftodosnombrehorizontal( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = value ;
   }

   public String getLiqlog( )
   {
      return gxTv_SdtLiquidacion_Liqlog ;
   }

   public void setLiqlog( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqlog = value ;
   }

   public java.util.Date getPeriodoliq( )
   {
      return gxTv_SdtLiquidacion_Periodoliq ;
   }

   public void setPeriodoliq( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Periodoliq = value ;
   }

   public int getLiqrelnro( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro ;
   }

   public void setLiqrelnro( int value )
   {
      gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrelnro = value ;
   }

   public boolean getLiqsac( )
   {
      return gxTv_SdtLiquidacion_Liqsac ;
   }

   public void setLiqsac( boolean value )
   {
      gxTv_SdtLiquidacion_Liqsac_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsac = value ;
   }

   public String getLiqsaclog( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog ;
   }

   public void setLiqsaclog( String value )
   {
      gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsaclog = value ;
   }

   public boolean getLiqcancel( )
   {
      return gxTv_SdtLiquidacion_Liqcancel ;
   }

   public void setLiqcancel( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcancel = value ;
   }

   public String getLiqmodtra( )
   {
      return gxTv_SdtLiquidacion_Liqmodtra ;
   }

   public void setLiqmodtra( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqmodtra = value ;
   }

   public byte getLiqfrecpag( )
   {
      return gxTv_SdtLiquidacion_Liqfrecpag ;
   }

   public void setLiqfrecpag( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfrecpag = value ;
   }

   public java.util.Date getLiqperdes( )
   {
      return gxTv_SdtLiquidacion_Liqperdes ;
   }

   public void setLiqperdes( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperdes = value ;
   }

   public java.util.Date getLiqperhas( )
   {
      return gxTv_SdtLiquidacion_Liqperhas ;
   }

   public void setLiqperhas( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperhas = value ;
   }

   public String getLiqtipotarifa( )
   {
      return gxTv_SdtLiquidacion_Liqtipotarifa ;
   }

   public void setLiqtipotarifa( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqtipotarifa = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLiquidacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLiquidacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLiquidacion_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLiquidacion_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Empcod_Z = value ;
   }

   public String getEmpnom_Z( )
   {
      return gxTv_SdtLiquidacion_Empnom_Z ;
   }

   public void setEmpnom_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Empnom_Z = value ;
   }

   public int getLiqnro_Z( )
   {
      return gxTv_SdtLiquidacion_Liqnro_Z ;
   }

   public void setLiqnro_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqnro_Z = value ;
   }

   public String getLiqdescrip_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdescrip_Z ;
   }

   public void setLiqdescrip_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdescrip_Z = value ;
   }

   public java.util.Date getLiqfecha_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecha_Z ;
   }

   public void setLiqfecha_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecha_Z = value ;
   }

   public short getLiqperano_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperano_Z ;
   }

   public void setLiqperano_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperano_Z = value ;
   }

   public byte getLiqpermes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpermes_Z ;
   }

   public void setLiqpermes_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpermes_Z = value ;
   }

   public java.util.Date getLiqperiodo_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperiodo_Z ;
   }

   public void setLiqperiodo_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperiodo_Z = value ;
   }

   public java.util.Date getLiqfecpago_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecpago_Z ;
   }

   public void setLiqfecpago_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecpago_Z = value ;
   }

   public String getTliqcod_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqcod_Z ;
   }

   public void setTliqcod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqcod_Z = value ;
   }

   public String getTliqdesc_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqdesc_Z ;
   }

   public void setTliqdesc_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqdesc_Z = value ;
   }

   public String getTliqdescaux_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqdescaux_Z ;
   }

   public void setTliqdescaux_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqdescaux_Z = value ;
   }

   public byte getLiqestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqestado_Z ;
   }

   public void setLiqestado_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqestado_Z = value ;
   }

   public byte getLiqlsddepest_Z( )
   {
      return gxTv_SdtLiquidacion_Liqlsddepest_Z ;
   }

   public void setLiqlsddepest_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqlsddepest_Z = value ;
   }

   public byte getLiqauxestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqauxestado_Z ;
   }

   public void setLiqauxestado_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqauxestado_Z = value ;
   }

   public byte getLiqcontrest_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcontrest_Z ;
   }

   public void setLiqcontrest_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcontrest_Z = value ;
   }

   public byte getLiqclase_Z( )
   {
      return gxTv_SdtLiquidacion_Liqclase_Z ;
   }

   public void setLiqclase_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqclase_Z = value ;
   }

   public String getLiqpdfestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado_Z ;
   }

   public void setLiqpdfestado_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpdfestado_Z = value ;
   }

   public boolean getLiqgeninter_Z( )
   {
      return gxTv_SdtLiquidacion_Liqgeninter_Z ;
   }

   public void setLiqgeninter_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqgeninter_Z = value ;
   }

   public boolean getLiqcontabilizada_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcontabilizada_Z ;
   }

   public void setLiqcontabilizada_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcontabilizada_Z = value ;
   }

   public short getLiqcntleg_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcntleg_Z ;
   }

   public void setLiqcntleg_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcntleg_Z = value ;
   }

   public java.math.BigDecimal getLiqimpneto_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpneto_Z ;
   }

   public void setLiqimpneto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpneto_Z = value ;
   }

   public java.math.BigDecimal getLiqimpdescuentos_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpdescuentos_Z ;
   }

   public void setLiqimpdescuentos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpdescuentos_Z = value ;
   }

   public java.math.BigDecimal getLiqimpretengan_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpretengan_Z ;
   }

   public void setLiqimpretengan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpretengan_Z = value ;
   }

   public java.math.BigDecimal getLiqimpbruto_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpbruto_Z ;
   }

   public void setLiqimpbruto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqimpbruto_Z = value ;
   }

   public boolean getLegespecificos_Z( )
   {
      return gxTv_SdtLiquidacion_Legespecificos_Z ;
   }

   public void setLegespecificos_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Legespecificos_Z = value ;
   }

   public java.util.Date getLiqfeccre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfeccre_Z ;
   }

   public void setLiqfeccre_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfeccre_Z = value ;
   }

   public String getLiqusucre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqusucre_Z ;
   }

   public void setLiqusucre_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqusucre_Z = value ;
   }

   public String getLiqpersindia_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpersindia_Z ;
   }

   public void setLiqpersindia_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpersindia_Z = value ;
   }

   public String getLiqperpalabra_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperpalabra_Z ;
   }

   public void setLiqperpalabra_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperpalabra_Z = value ;
   }

   public String getLiqdepprvper_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvper_Z ;
   }

   public void setLiqdepprvper_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepprvper_Z = value ;
   }

   public java.util.Date getLiqdepprvfec_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvfec_Z ;
   }

   public void setLiqdepprvfec_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepprvfec_Z = value ;
   }

   public String getLiqdepbandescrip_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepbandescrip_Z ;
   }

   public void setLiqdepbandescrip_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepbandescrip_Z = value ;
   }

   public String getLiqdepbancod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod_Z ;
   }

   public void setLiqdepbancod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepbancod_Z = value ;
   }

   public short getLiqdepperano_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepperano_Z ;
   }

   public void setLiqdepperano_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepperano_Z = value ;
   }

   public byte getLiqdeppermes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdeppermes_Z ;
   }

   public void setLiqdeppermes_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdeppermes_Z = value ;
   }

   public java.util.Date getLiqfecmod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecmod_Z ;
   }

   public void setLiqfecmod_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecmod_Z = value ;
   }

   public String getLiqusumod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqusumod_Z ;
   }

   public void setLiqusumod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqusumod_Z = value ;
   }

   public java.util.Date getLiqfecimp_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecimp_Z ;
   }

   public void setLiqfecimp_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfecimp_Z = value ;
   }

   public java.math.BigDecimal getLiqpisoganancias_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpisoganancias_Z ;
   }

   public void setLiqpisoganancias_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpisoganancias_Z = value ;
   }

   public java.math.BigDecimal getLiqpisgansac_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpisgansac_Z ;
   }

   public void setLiqpisgansac_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpisgansac_Z = value ;
   }

   public java.math.BigDecimal getLiqtopededinc_Z( )
   {
      return gxTv_SdtLiquidacion_Liqtopededinc_Z ;
   }

   public void setLiqtopededinc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqtopededinc_Z = value ;
   }

   public java.util.Date getLiqperultnorm_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperultnorm_Z ;
   }

   public void setLiqperultnorm_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperultnorm_Z = value ;
   }

   public String getLiqerror_Z( )
   {
      return gxTv_SdtLiquidacion_Liqerror_Z ;
   }

   public void setLiqerror_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqerror_Z = value ;
   }

   public String getLiqerroraux_Z( )
   {
      return gxTv_SdtLiquidacion_Liqerroraux_Z ;
   }

   public void setLiqerroraux_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqerroraux_Z = value ;
   }

   public String getLiqnombre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqnombre_Z ;
   }

   public void setLiqnombre_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqnombre_Z = value ;
   }

   public String getLiqlegajostxt_Z( )
   {
      return gxTv_SdtLiquidacion_Liqlegajostxt_Z ;
   }

   public void setLiqlegajostxt_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqlegajostxt_Z = value ;
   }

   public java.math.BigDecimal getLiqsegundos_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsegundos_Z ;
   }

   public void setLiqsegundos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsegundos_Z = value ;
   }

   public String getLiqrutapdftodosvertical_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z ;
   }

   public void setLiqrutapdftodosvertical_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = value ;
   }

   public String getLiqrutapdftodoshorizontal_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z ;
   }

   public void setLiqrutapdftodoshorizontal_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = value ;
   }

   public String getLiqrutapdftodosnombrevertical_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z ;
   }

   public void setLiqrutapdftodosnombrevertical_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = value ;
   }

   public String getLiqrutapdftodosnombrehorizontal_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z ;
   }

   public void setLiqrutapdftodosnombrehorizontal_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = value ;
   }

   public java.util.Date getPeriodoliq_Z( )
   {
      return gxTv_SdtLiquidacion_Periodoliq_Z ;
   }

   public void setPeriodoliq_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Periodoliq_Z = value ;
   }

   public int getLiqrelnro_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro_Z ;
   }

   public void setLiqrelnro_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrelnro_Z = value ;
   }

   public boolean getLiqsac_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsac_Z ;
   }

   public void setLiqsac_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsac_Z = value ;
   }

   public String getLiqsaclog_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog_Z ;
   }

   public void setLiqsaclog_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsaclog_Z = value ;
   }

   public boolean getLiqcancel_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcancel_Z ;
   }

   public void setLiqcancel_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqcancel_Z = value ;
   }

   public String getLiqmodtra_Z( )
   {
      return gxTv_SdtLiquidacion_Liqmodtra_Z ;
   }

   public void setLiqmodtra_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqmodtra_Z = value ;
   }

   public byte getLiqfrecpag_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfrecpag_Z ;
   }

   public void setLiqfrecpag_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqfrecpag_Z = value ;
   }

   public java.util.Date getLiqperdes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperdes_Z ;
   }

   public void setLiqperdes_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperdes_Z = value ;
   }

   public java.util.Date getLiqperhas_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperhas_Z ;
   }

   public void setLiqperhas_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqperhas_Z = value ;
   }

   public String getLiqtipotarifa_Z( )
   {
      return gxTv_SdtLiquidacion_Liqtipotarifa_Z ;
   }

   public void setLiqtipotarifa_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqtipotarifa_Z = value ;
   }

   public byte getTliqcod_N( )
   {
      return gxTv_SdtLiquidacion_Tliqcod_N ;
   }

   public void setTliqcod_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Tliqcod_N = value ;
   }

   public byte getLiqclase_N( )
   {
      return gxTv_SdtLiquidacion_Liqclase_N ;
   }

   public void setLiqclase_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqclase_N = value ;
   }

   public byte getLiqpdfestado_N( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado_N ;
   }

   public void setLiqpdfestado_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqpdfestado_N = value ;
   }

   public byte getLiqdepbancod_N( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod_N ;
   }

   public void setLiqdepbancod_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqdepbancod_N = value ;
   }

   public byte getLiqrelnro_N( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro_N ;
   }

   public void setLiqrelnro_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqrelnro_N = value ;
   }

   public byte getLiqsac_N( )
   {
      return gxTv_SdtLiquidacion_Liqsac_N ;
   }

   public void setLiqsac_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsac_N = value ;
   }

   public byte getLiqsaclog_N( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog_N ;
   }

   public void setLiqsaclog_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      gxTv_SdtLiquidacion_Liqsaclog_N = value ;
   }

   protected byte gxTv_SdtLiquidacion_Liqpermes ;
   protected byte gxTv_SdtLiquidacion_Liqestado ;
   protected byte gxTv_SdtLiquidacion_Liqlsddepest ;
   protected byte gxTv_SdtLiquidacion_Liqauxestado ;
   protected byte gxTv_SdtLiquidacion_Liqcontrest ;
   protected byte gxTv_SdtLiquidacion_Liqclase ;
   protected byte gxTv_SdtLiquidacion_Liqdeppermes ;
   protected byte gxTv_SdtLiquidacion_Liqfrecpag ;
   protected byte gxTv_SdtLiquidacion_Liqpermes_Z ;
   protected byte gxTv_SdtLiquidacion_Liqestado_Z ;
   protected byte gxTv_SdtLiquidacion_Liqlsddepest_Z ;
   protected byte gxTv_SdtLiquidacion_Liqauxestado_Z ;
   protected byte gxTv_SdtLiquidacion_Liqcontrest_Z ;
   protected byte gxTv_SdtLiquidacion_Liqclase_Z ;
   protected byte gxTv_SdtLiquidacion_Liqdeppermes_Z ;
   protected byte gxTv_SdtLiquidacion_Liqfrecpag_Z ;
   protected byte gxTv_SdtLiquidacion_Tliqcod_N ;
   protected byte gxTv_SdtLiquidacion_Liqclase_N ;
   protected byte gxTv_SdtLiquidacion_Liqpdfestado_N ;
   protected byte gxTv_SdtLiquidacion_Liqdepbancod_N ;
   protected byte gxTv_SdtLiquidacion_Liqrelnro_N ;
   protected byte gxTv_SdtLiquidacion_Liqsac_N ;
   protected byte gxTv_SdtLiquidacion_Liqsaclog_N ;
   private byte gxTv_SdtLiquidacion_N ;
   protected short gxTv_SdtLiquidacion_Empcod ;
   protected short gxTv_SdtLiquidacion_Liqperano ;
   protected short gxTv_SdtLiquidacion_Liqcntleg ;
   protected short gxTv_SdtLiquidacion_Liqdepperano ;
   protected short gxTv_SdtLiquidacion_Initialized ;
   protected short gxTv_SdtLiquidacion_Empcod_Z ;
   protected short gxTv_SdtLiquidacion_Liqperano_Z ;
   protected short gxTv_SdtLiquidacion_Liqcntleg_Z ;
   protected short gxTv_SdtLiquidacion_Liqdepperano_Z ;
   protected int gxTv_SdtLiquidacion_Clicod ;
   protected int gxTv_SdtLiquidacion_Liqnro ;
   protected int gxTv_SdtLiquidacion_Liqrelnro ;
   protected int gxTv_SdtLiquidacion_Clicod_Z ;
   protected int gxTv_SdtLiquidacion_Liqnro_Z ;
   protected int gxTv_SdtLiquidacion_Liqrelnro_Z ;
   protected String gxTv_SdtLiquidacion_Tliqcod ;
   protected String gxTv_SdtLiquidacion_Liqpdfestado ;
   protected String gxTv_SdtLiquidacion_Liqpersindia ;
   protected String gxTv_SdtLiquidacion_Liqperpalabra ;
   protected String gxTv_SdtLiquidacion_Liqdepprvper ;
   protected String gxTv_SdtLiquidacion_Liqdepbancod ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal ;
   protected String gxTv_SdtLiquidacion_Liqmodtra ;
   protected String gxTv_SdtLiquidacion_Liqtipotarifa ;
   protected String gxTv_SdtLiquidacion_Mode ;
   protected String gxTv_SdtLiquidacion_Tliqcod_Z ;
   protected String gxTv_SdtLiquidacion_Liqpdfestado_Z ;
   protected String gxTv_SdtLiquidacion_Liqpersindia_Z ;
   protected String gxTv_SdtLiquidacion_Liqperpalabra_Z ;
   protected String gxTv_SdtLiquidacion_Liqdepprvper_Z ;
   protected String gxTv_SdtLiquidacion_Liqdepbancod_Z ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z ;
   protected String gxTv_SdtLiquidacion_Liqmodtra_Z ;
   protected String gxTv_SdtLiquidacion_Liqtipotarifa_Z ;
   protected boolean gxTv_SdtLiquidacion_Liqgeninter ;
   protected boolean gxTv_SdtLiquidacion_Liqcontabilizada ;
   protected boolean gxTv_SdtLiquidacion_Legespecificos ;
   protected boolean gxTv_SdtLiquidacion_Liqsac ;
   protected boolean gxTv_SdtLiquidacion_Liqcancel ;
   protected boolean gxTv_SdtLiquidacion_Liqgeninter_Z ;
   protected boolean gxTv_SdtLiquidacion_Liqcontabilizada_Z ;
   protected boolean gxTv_SdtLiquidacion_Legespecificos_Z ;
   protected boolean gxTv_SdtLiquidacion_Liqsac_Z ;
   protected boolean gxTv_SdtLiquidacion_Liqcancel_Z ;
   protected String gxTv_SdtLiquidacion_Liqlog ;
   protected String gxTv_SdtLiquidacion_Empnom ;
   protected String gxTv_SdtLiquidacion_Liqdescrip ;
   protected String gxTv_SdtLiquidacion_Tliqdesc ;
   protected String gxTv_SdtLiquidacion_Tliqdescaux ;
   protected String gxTv_SdtLiquidacion_Liqusucre ;
   protected String gxTv_SdtLiquidacion_Liqdepbandescrip ;
   protected String gxTv_SdtLiquidacion_Liqusumod ;
   protected String gxTv_SdtLiquidacion_Liqerror ;
   protected String gxTv_SdtLiquidacion_Liqerroraux ;
   protected String gxTv_SdtLiquidacion_Liqnombre ;
   protected String gxTv_SdtLiquidacion_Liqlegajostxt ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosvertical ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal ;
   protected String gxTv_SdtLiquidacion_Liqsaclog ;
   protected String gxTv_SdtLiquidacion_Empnom_Z ;
   protected String gxTv_SdtLiquidacion_Liqdescrip_Z ;
   protected String gxTv_SdtLiquidacion_Tliqdesc_Z ;
   protected String gxTv_SdtLiquidacion_Tliqdescaux_Z ;
   protected String gxTv_SdtLiquidacion_Liqusucre_Z ;
   protected String gxTv_SdtLiquidacion_Liqdepbandescrip_Z ;
   protected String gxTv_SdtLiquidacion_Liqusumod_Z ;
   protected String gxTv_SdtLiquidacion_Liqerror_Z ;
   protected String gxTv_SdtLiquidacion_Liqerroraux_Z ;
   protected String gxTv_SdtLiquidacion_Liqnombre_Z ;
   protected String gxTv_SdtLiquidacion_Liqlegajostxt_Z ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z ;
   protected String gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z ;
   protected String gxTv_SdtLiquidacion_Liqsaclog_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecha ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperiodo ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecpago ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpneto ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpdescuentos ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpretengan ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpbruto ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfeccre ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqdepprvfec ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecmod ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecimp ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisoganancias ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisgansac ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqtopededinc ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperultnorm ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqsegundos ;
   protected java.util.Date gxTv_SdtLiquidacion_Periodoliq ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperdes ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperhas ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecha_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperiodo_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecpago_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpneto_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpdescuentos_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpretengan_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpbruto_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfeccre_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqdepprvfec_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecmod_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqfecimp_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisoganancias_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisgansac_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqtopededinc_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperultnorm_Z ;
   protected java.math.BigDecimal gxTv_SdtLiquidacion_Liqsegundos_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Periodoliq_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperdes_Z ;
   protected java.util.Date gxTv_SdtLiquidacion_Liqperhas_Z ;
}

