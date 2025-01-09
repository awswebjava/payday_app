package web ;
import com.genexus.*;

public final  class StructSdtLegajoCC implements Cloneable, java.io.Serializable
{
   public StructSdtLegajoCC( )
   {
      this( -1, new ModelContext( StructSdtLegajoCC.class ));
   }

   public StructSdtLegajoCC( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_SdtLegajoCC_Legcenprc = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajoCC_Cendescripcion = "" ;
      gxTv_SdtLegajoCC_Mode = "" ;
      gxTv_SdtLegajoCC_Legcenprc_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtLegajoCC_Cendescripcion_Z = "" ;
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
      return gxTv_SdtLegajoCC_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_SdtLegajoCC_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Empcod = value ;
   }

   public int getLegnumero( )
   {
      return gxTv_SdtLegajoCC_Legnumero ;
   }

   public void setLegnumero( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Legnumero = value ;
   }

   public short getCencodigo( )
   {
      return gxTv_SdtLegajoCC_Cencodigo ;
   }

   public void setCencodigo( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Cencodigo = value ;
   }

   public java.math.BigDecimal getLegcenprc( )
   {
      return gxTv_SdtLegajoCC_Legcenprc ;
   }

   public void setLegcenprc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Legcenprc = value ;
   }

   public String getCendescripcion( )
   {
      return gxTv_SdtLegajoCC_Cendescripcion ;
   }

   public void setCendescripcion( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Cendescripcion = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajoCC_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajoCC_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtLegajoCC_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_SdtLegajoCC_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Empcod_Z = value ;
   }

   public int getLegnumero_Z( )
   {
      return gxTv_SdtLegajoCC_Legnumero_Z ;
   }

   public void setLegnumero_Z( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Legnumero_Z = value ;
   }

   public short getCencodigo_Z( )
   {
      return gxTv_SdtLegajoCC_Cencodigo_Z ;
   }

   public void setCencodigo_Z( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Cencodigo_Z = value ;
   }

   public java.math.BigDecimal getLegcenprc_Z( )
   {
      return gxTv_SdtLegajoCC_Legcenprc_Z ;
   }

   public void setLegcenprc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Legcenprc_Z = value ;
   }

   public String getCendescripcion_Z( )
   {
      return gxTv_SdtLegajoCC_Cendescripcion_Z ;
   }

   public void setCendescripcion_Z( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      gxTv_SdtLegajoCC_Cendescripcion_Z = value ;
   }

   private byte gxTv_SdtLegajoCC_N ;
   protected short gxTv_SdtLegajoCC_Empcod ;
   protected short gxTv_SdtLegajoCC_Cencodigo ;
   protected short gxTv_SdtLegajoCC_Initialized ;
   protected short gxTv_SdtLegajoCC_Empcod_Z ;
   protected short gxTv_SdtLegajoCC_Cencodigo_Z ;
   protected int gxTv_SdtLegajoCC_Clicod ;
   protected int gxTv_SdtLegajoCC_Legnumero ;
   protected int gxTv_SdtLegajoCC_Clicod_Z ;
   protected int gxTv_SdtLegajoCC_Legnumero_Z ;
   protected String gxTv_SdtLegajoCC_Mode ;
   protected String gxTv_SdtLegajoCC_Cendescripcion ;
   protected String gxTv_SdtLegajoCC_Cendescripcion_Z ;
   protected java.math.BigDecimal gxTv_SdtLegajoCC_Legcenprc ;
   protected java.math.BigDecimal gxTv_SdtLegajoCC_Legcenprc_Z ;
}

