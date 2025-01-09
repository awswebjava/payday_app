package web ;
import com.genexus.*;

public final  class StructSdtConcepto_MotivosEgreso implements Cloneable, java.io.Serializable
{
   public StructSdtConcepto_MotivosEgreso( )
   {
      this( -1, new ModelContext( StructSdtConcepto_MotivosEgreso.class ));
   }

   public StructSdtConcepto_MotivosEgreso( int remoteHandle ,
                                           ModelContext context )
   {
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = new java.math.BigDecimal(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Mode = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = new java.math.BigDecimal(0) ;
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

   public String getMegcodigo( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megcodigo ;
   }

   public void setMegcodigo( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo = value ;
   }

   public short getConmegsec( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegsec ;
   }

   public void setConmegsec( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegsec = value ;
   }

   public String getMegpreatipo( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megpreatipo ;
   }

   public void setMegpreatipo( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = value ;
   }

   public byte getConmegmeses( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegmeses ;
   }

   public void setConmegmeses( byte value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegmeses = value ;
   }

   public String getConmegdura( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegdura ;
   }

   public void setConmegdura( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura = value ;
   }

   public java.math.BigDecimal getConmegpropor( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegpropor ;
   }

   public void setConmegpropor( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Initialized = value ;
   }

   public String getMegcodigo_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z ;
   }

   public void setMegcodigo_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = value ;
   }

   public short getConmegsec_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z ;
   }

   public void setConmegsec_Z( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z = value ;
   }

   public String getMegpreatipo_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z ;
   }

   public void setMegpreatipo_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = value ;
   }

   public byte getConmegmeses_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z ;
   }

   public void setConmegmeses_Z( byte value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z = value ;
   }

   public String getConmegdura_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z ;
   }

   public void setConmegdura_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = value ;
   }

   public java.math.BigDecimal getConmegpropor_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z ;
   }

   public void setConmegpropor_Z( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = value ;
   }

   protected byte gxTv_SdtConcepto_MotivosEgreso_Conmegmeses ;
   protected byte gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z ;
   private byte gxTv_SdtConcepto_MotivosEgreso_N ;
   protected short gxTv_SdtConcepto_MotivosEgreso_Conmegsec ;
   protected short gxTv_SdtConcepto_MotivosEgreso_Modified ;
   protected short gxTv_SdtConcepto_MotivosEgreso_Initialized ;
   protected short gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Megcodigo ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Megpreatipo ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Conmegdura ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Mode ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z ;
   protected String gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z ;
   protected java.math.BigDecimal gxTv_SdtConcepto_MotivosEgreso_Conmegpropor ;
   protected java.math.BigDecimal gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z ;
}

