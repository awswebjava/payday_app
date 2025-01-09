package web ;
import com.genexus.*;

public final  class StructSdtCategoria_valores implements Cloneable, java.io.Serializable
{
   public StructSdtCategoria_valores( )
   {
      this( -1, new ModelContext( StructSdtCategoria_valores.class ));
   }

   public StructSdtCategoria_valores( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtCategoria_valores_Catvigencia = cal.getTime() ;
      gxTv_SdtCategoria_valores_Catbasico = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catvalorhora = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catadicional = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catadihora = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Escbasico = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Escadicional = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Mode = "" ;
      gxTv_SdtCategoria_valores_Catvigencia_Z = cal.getTime() ;
      gxTv_SdtCategoria_valores_Catbasico_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catvalorhora_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catadicional_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catadihora_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Escbasico_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Escadicional_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCategoria_valores_Catbasico_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catadicional_N = (byte)(1) ;
      gxTv_SdtCategoria_valores_Catadihora_N = (byte)(1) ;
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

   public java.util.Date getCatvigencia( )
   {
      return gxTv_SdtCategoria_valores_Catvigencia ;
   }

   public void setCatvigencia( java.util.Date value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catvigencia = value ;
   }

   public java.math.BigDecimal getCatbasico( )
   {
      return gxTv_SdtCategoria_valores_Catbasico ;
   }

   public void setCatbasico( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catbasico_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catbasico = value ;
   }

   public java.math.BigDecimal getCatvalorhora( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora ;
   }

   public void setCatvalorhora( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catvalorhora_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catvalorhora = value ;
   }

   public java.math.BigDecimal getCatadicional( )
   {
      return gxTv_SdtCategoria_valores_Catadicional ;
   }

   public void setCatadicional( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catadicional_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadicional = value ;
   }

   public java.math.BigDecimal getCatadihora( )
   {
      return gxTv_SdtCategoria_valores_Catadihora ;
   }

   public void setCatadihora( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_Catadihora_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadihora = value ;
   }

   public java.math.BigDecimal getEscbasico( )
   {
      return gxTv_SdtCategoria_valores_Escbasico ;
   }

   public void setEscbasico( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Escbasico = value ;
   }

   public java.math.BigDecimal getEscadicional( )
   {
      return gxTv_SdtCategoria_valores_Escadicional ;
   }

   public void setEscadicional( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Escadicional = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCategoria_valores_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtCategoria_valores_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCategoria_valores_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Initialized = value ;
   }

   public java.util.Date getCatvigencia_Z( )
   {
      return gxTv_SdtCategoria_valores_Catvigencia_Z ;
   }

   public void setCatvigencia_Z( java.util.Date value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catvigencia_Z = value ;
   }

   public java.math.BigDecimal getCatbasico_Z( )
   {
      return gxTv_SdtCategoria_valores_Catbasico_Z ;
   }

   public void setCatbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catbasico_Z = value ;
   }

   public java.math.BigDecimal getCatvalorhora_Z( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora_Z ;
   }

   public void setCatvalorhora_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catvalorhora_Z = value ;
   }

   public java.math.BigDecimal getCatadicional_Z( )
   {
      return gxTv_SdtCategoria_valores_Catadicional_Z ;
   }

   public void setCatadicional_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadicional_Z = value ;
   }

   public java.math.BigDecimal getCatadihora_Z( )
   {
      return gxTv_SdtCategoria_valores_Catadihora_Z ;
   }

   public void setCatadihora_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadihora_Z = value ;
   }

   public java.math.BigDecimal getEscbasico_Z( )
   {
      return gxTv_SdtCategoria_valores_Escbasico_Z ;
   }

   public void setEscbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Escbasico_Z = value ;
   }

   public java.math.BigDecimal getEscadicional_Z( )
   {
      return gxTv_SdtCategoria_valores_Escadicional_Z ;
   }

   public void setEscadicional_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Escadicional_Z = value ;
   }

   public byte getCatbasico_N( )
   {
      return gxTv_SdtCategoria_valores_Catbasico_N ;
   }

   public void setCatbasico_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catbasico_N = value ;
   }

   public byte getCatvalorhora_N( )
   {
      return gxTv_SdtCategoria_valores_Catvalorhora_N ;
   }

   public void setCatvalorhora_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catvalorhora_N = value ;
   }

   public byte getCatadicional_N( )
   {
      return gxTv_SdtCategoria_valores_Catadicional_N ;
   }

   public void setCatadicional_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadicional_N = value ;
   }

   public byte getCatadihora_N( )
   {
      return gxTv_SdtCategoria_valores_Catadihora_N ;
   }

   public void setCatadihora_N( byte value )
   {
      gxTv_SdtCategoria_valores_N = (byte)(0) ;
      gxTv_SdtCategoria_valores_Catadihora_N = value ;
   }

   protected byte gxTv_SdtCategoria_valores_Catbasico_N ;
   protected byte gxTv_SdtCategoria_valores_Catvalorhora_N ;
   protected byte gxTv_SdtCategoria_valores_Catadicional_N ;
   protected byte gxTv_SdtCategoria_valores_Catadihora_N ;
   private byte gxTv_SdtCategoria_valores_N ;
   protected short gxTv_SdtCategoria_valores_Modified ;
   protected short gxTv_SdtCategoria_valores_Initialized ;
   protected String gxTv_SdtCategoria_valores_Mode ;
   protected java.util.Date gxTv_SdtCategoria_valores_Catvigencia ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catbasico ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catvalorhora ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catadicional ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catadihora ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Escbasico ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Escadicional ;
   protected java.util.Date gxTv_SdtCategoria_valores_Catvigencia_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catbasico_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catvalorhora_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catadicional_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Catadihora_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Escbasico_Z ;
   protected java.math.BigDecimal gxTv_SdtCategoria_valores_Escadicional_Z ;
}

