package web ;
import com.genexus.*;

public final  class StructSdtParentesco implements Cloneable, java.io.Serializable
{
   public StructSdtParentesco( )
   {
      this( -1, new ModelContext( StructSdtParentesco.class ));
   }

   public StructSdtParentesco( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtParentesco_Parcod = "" ;
      gxTv_SdtParentesco_Pardescrip = "" ;
      gxTv_SdtParentesco_Parres551 = "" ;
      gxTv_SdtParentesco_Pardescripsinac = "" ;
      gxTv_SdtParentesco_Parentipo = "" ;
      gxTv_SdtParentesco_Mode = "" ;
      gxTv_SdtParentesco_Parcod_Z = "" ;
      gxTv_SdtParentesco_Pardescrip_Z = "" ;
      gxTv_SdtParentesco_Parres551_Z = "" ;
      gxTv_SdtParentesco_Pardescripsinac_Z = "" ;
      gxTv_SdtParentesco_Parentipo_Z = "" ;
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
      return gxTv_SdtParentesco_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Clicod = value ;
   }

   public String getParcod( )
   {
      return gxTv_SdtParentesco_Parcod ;
   }

   public void setParcod( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parcod = value ;
   }

   public String getPardescrip( )
   {
      return gxTv_SdtParentesco_Pardescrip ;
   }

   public void setPardescrip( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Pardescrip = value ;
   }

   public String getParres551( )
   {
      return gxTv_SdtParentesco_Parres551 ;
   }

   public void setParres551( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parres551 = value ;
   }

   public boolean getParhabilitado( )
   {
      return gxTv_SdtParentesco_Parhabilitado ;
   }

   public void setParhabilitado( boolean value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parhabilitado = value ;
   }

   public String getPardescripsinac( )
   {
      return gxTv_SdtParentesco_Pardescripsinac ;
   }

   public void setPardescripsinac( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Pardescripsinac = value ;
   }

   public String getParentipo( )
   {
      return gxTv_SdtParentesco_Parentipo ;
   }

   public void setParentipo( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parentipo = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtParentesco_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtParentesco_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtParentesco_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Clicod_Z = value ;
   }

   public String getParcod_Z( )
   {
      return gxTv_SdtParentesco_Parcod_Z ;
   }

   public void setParcod_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parcod_Z = value ;
   }

   public String getPardescrip_Z( )
   {
      return gxTv_SdtParentesco_Pardescrip_Z ;
   }

   public void setPardescrip_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Pardescrip_Z = value ;
   }

   public String getParres551_Z( )
   {
      return gxTv_SdtParentesco_Parres551_Z ;
   }

   public void setParres551_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parres551_Z = value ;
   }

   public boolean getParhabilitado_Z( )
   {
      return gxTv_SdtParentesco_Parhabilitado_Z ;
   }

   public void setParhabilitado_Z( boolean value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parhabilitado_Z = value ;
   }

   public String getPardescripsinac_Z( )
   {
      return gxTv_SdtParentesco_Pardescripsinac_Z ;
   }

   public void setPardescripsinac_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Pardescripsinac_Z = value ;
   }

   public String getParentipo_Z( )
   {
      return gxTv_SdtParentesco_Parentipo_Z ;
   }

   public void setParentipo_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      gxTv_SdtParentesco_Parentipo_Z = value ;
   }

   private byte gxTv_SdtParentesco_N ;
   protected short gxTv_SdtParentesco_Initialized ;
   protected int gxTv_SdtParentesco_Clicod ;
   protected int gxTv_SdtParentesco_Clicod_Z ;
   protected String gxTv_SdtParentesco_Parcod ;
   protected String gxTv_SdtParentesco_Parentipo ;
   protected String gxTv_SdtParentesco_Mode ;
   protected String gxTv_SdtParentesco_Parcod_Z ;
   protected String gxTv_SdtParentesco_Parentipo_Z ;
   protected boolean gxTv_SdtParentesco_Parhabilitado ;
   protected boolean gxTv_SdtParentesco_Parhabilitado_Z ;
   protected String gxTv_SdtParentesco_Pardescrip ;
   protected String gxTv_SdtParentesco_Parres551 ;
   protected String gxTv_SdtParentesco_Pardescripsinac ;
   protected String gxTv_SdtParentesco_Pardescrip_Z ;
   protected String gxTv_SdtParentesco_Parres551_Z ;
   protected String gxTv_SdtParentesco_Pardescripsinac_Z ;
}

