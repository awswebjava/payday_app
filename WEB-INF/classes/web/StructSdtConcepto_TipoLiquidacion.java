package web ;
import com.genexus.*;

public final  class StructSdtConcepto_TipoLiquidacion implements Cloneable, java.io.Serializable
{
   public StructSdtConcepto_TipoLiquidacion( )
   {
      this( -1, new ModelContext( StructSdtConcepto_TipoLiquidacion.class ));
   }

   public StructSdtConcepto_TipoLiquidacion( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Mode = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(1) ;
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
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = value ;
   }

   public String getTliqdesc( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc ;
   }

   public void setTliqdesc( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = value ;
   }

   public boolean getContliqsincausa( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa ;
   }

   public void setContliqsincausa( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa = value ;
   }

   public boolean getContliqsinpre( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre ;
   }

   public void setContliqsinpre( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre = value ;
   }

   public String getContltipegr( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipegr ;
   }

   public void setContltipegr( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = value ;
   }

   public long getContlordejec( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlordejec ;
   }

   public void setContlordejec( long value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlordejec = value ;
   }

   public short getContlconord( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconord ;
   }

   public void setContlconord( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlconord = value ;
   }

   public byte getContlvigencia( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia ;
   }

   public void setContlvigencia( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia = value ;
   }

   public String getContlcondicion( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion ;
   }

   public void setContlcondicion( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = value ;
   }

   public byte getContlconhab( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconhab ;
   }

   public void setContlconhab( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlconhab = value ;
   }

   public String getContltipocon( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon ;
   }

   public void setContltipocon( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = value ;
   }

   public byte getContlsegpla( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla ;
   }

   public void setContlsegpla( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Initialized = value ;
   }

   public String getTliqcod_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z ;
   }

   public void setTliqcod_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = value ;
   }

   public String getTliqdesc_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z ;
   }

   public void setTliqdesc_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = value ;
   }

   public boolean getContliqsincausa_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z ;
   }

   public void setContliqsincausa_Z( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z = value ;
   }

   public boolean getContliqsinpre_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z ;
   }

   public void setContliqsinpre_Z( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z = value ;
   }

   public String getContltipegr_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z ;
   }

   public void setContltipegr_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = value ;
   }

   public long getContlordejec_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z ;
   }

   public void setContlordejec_Z( long value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z = value ;
   }

   public short getContlconord_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z ;
   }

   public void setContlconord_Z( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z = value ;
   }

   public byte getContlvigencia_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z ;
   }

   public void setContlvigencia_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z = value ;
   }

   public String getContlcondicion_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z ;
   }

   public void setContlcondicion_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = value ;
   }

   public byte getContlconhab_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z ;
   }

   public void setContlconhab_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z = value ;
   }

   public String getContltipocon_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z ;
   }

   public void setContltipocon_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = value ;
   }

   public byte getContlsegpla_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z ;
   }

   public void setContlsegpla_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z = value ;
   }

   public byte getContliqsincausa_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N ;
   }

   public void setContliqsincausa_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = value ;
   }

   public byte getContliqsinpre_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N ;
   }

   public void setContliqsinpre_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = value ;
   }

   public byte getContlvigencia_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N ;
   }

   public void setContlvigencia_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = value ;
   }

   public byte getContlcondicion_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N ;
   }

   public void setContlcondicion_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = value ;
   }

   public byte getContltipocon_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N ;
   }

   public void setContltipocon_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = value ;
   }

   public byte getContlsegpla_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N ;
   }

   public void setContlsegpla_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = value ;
   }

   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlconhab ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N ;
   protected byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_N ;
   protected short gxTv_SdtConcepto_TipoLiquidacion_Contlconord ;
   protected short gxTv_SdtConcepto_TipoLiquidacion_Modified ;
   protected short gxTv_SdtConcepto_TipoLiquidacion_Initialized ;
   protected short gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z ;
   protected long gxTv_SdtConcepto_TipoLiquidacion_Contlordejec ;
   protected long gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Tliqcod ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contltipegr ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contltipocon ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Mode ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z ;
   protected boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa ;
   protected boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre ;
   protected boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z ;
   protected boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc ;
   protected String gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z ;
}

