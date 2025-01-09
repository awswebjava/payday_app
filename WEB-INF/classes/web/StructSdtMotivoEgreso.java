package web ;
import com.genexus.*;

public final  class StructSdtMotivoEgreso implements Cloneable, java.io.Serializable
{
   public StructSdtMotivoEgreso( )
   {
      this( -1, new ModelContext( StructSdtMotivoEgreso.class ));
   }

   public StructSdtMotivoEgreso( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtMotivoEgreso_Megcodigo = "" ;
      gxTv_SdtMotivoEgreso_Megdescrip = "" ;
      gxTv_SdtMotivoEgreso_Megres551 = "" ;
      gxTv_SdtMotivoEgreso_Megpadre = "" ;
      gxTv_SdtMotivoEgreso_Megrelref = "" ;
      gxTv_SdtMotivoEgreso_Megold = "" ;
      gxTv_SdtMotivoEgreso_Mode = "" ;
      gxTv_SdtMotivoEgreso_Megcodigo_Z = "" ;
      gxTv_SdtMotivoEgreso_Megdescrip_Z = "" ;
      gxTv_SdtMotivoEgreso_Megres551_Z = "" ;
      gxTv_SdtMotivoEgreso_Megpadre_Z = "" ;
      gxTv_SdtMotivoEgreso_Megrelref_Z = "" ;
      gxTv_SdtMotivoEgreso_Megres551_N = (byte)(1) ;
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
      return gxTv_SdtMotivoEgreso_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Clicod = value ;
   }

   public String getMegcodigo( )
   {
      return gxTv_SdtMotivoEgreso_Megcodigo ;
   }

   public void setMegcodigo( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megcodigo = value ;
   }

   public String getMegdescrip( )
   {
      return gxTv_SdtMotivoEgreso_Megdescrip ;
   }

   public void setMegdescrip( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megdescrip = value ;
   }

   public boolean getMeghabilitado( )
   {
      return gxTv_SdtMotivoEgreso_Meghabilitado ;
   }

   public void setMeghabilitado( boolean value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Meghabilitado = value ;
   }

   public String getMegres551( )
   {
      return gxTv_SdtMotivoEgreso_Megres551 ;
   }

   public void setMegres551( String value )
   {
      gxTv_SdtMotivoEgreso_Megres551_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megres551 = value ;
   }

   public int getMegrelsec( )
   {
      return gxTv_SdtMotivoEgreso_Megrelsec ;
   }

   public void setMegrelsec( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelsec = value ;
   }

   public int getMegrelseccli( )
   {
      return gxTv_SdtMotivoEgreso_Megrelseccli ;
   }

   public void setMegrelseccli( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelseccli = value ;
   }

   public String getMegpadre( )
   {
      return gxTv_SdtMotivoEgreso_Megpadre ;
   }

   public void setMegpadre( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megpadre = value ;
   }

   public String getMegrelref( )
   {
      return gxTv_SdtMotivoEgreso_Megrelref ;
   }

   public void setMegrelref( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelref = value ;
   }

   public String getMegold( )
   {
      return gxTv_SdtMotivoEgreso_Megold ;
   }

   public void setMegold( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megold = value ;
   }

   public java.util.Vector<web.StructSdtMotivoEgreso_RevistaAfip> getRevistaafip( )
   {
      return gxTv_SdtMotivoEgreso_Revistaafip ;
   }

   public void setRevistaafip( java.util.Vector<web.StructSdtMotivoEgreso_RevistaAfip> value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Revistaafip = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtMotivoEgreso_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtMotivoEgreso_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtMotivoEgreso_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Clicod_Z = value ;
   }

   public String getMegcodigo_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megcodigo_Z ;
   }

   public void setMegcodigo_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megcodigo_Z = value ;
   }

   public String getMegdescrip_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megdescrip_Z ;
   }

   public void setMegdescrip_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megdescrip_Z = value ;
   }

   public boolean getMeghabilitado_Z( )
   {
      return gxTv_SdtMotivoEgreso_Meghabilitado_Z ;
   }

   public void setMeghabilitado_Z( boolean value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Meghabilitado_Z = value ;
   }

   public String getMegres551_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megres551_Z ;
   }

   public void setMegres551_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megres551_Z = value ;
   }

   public int getMegrelsec_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelsec_Z ;
   }

   public void setMegrelsec_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelsec_Z = value ;
   }

   public int getMegrelseccli_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelseccli_Z ;
   }

   public void setMegrelseccli_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelseccli_Z = value ;
   }

   public String getMegpadre_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megpadre_Z ;
   }

   public void setMegpadre_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megpadre_Z = value ;
   }

   public String getMegrelref_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelref_Z ;
   }

   public void setMegrelref_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megrelref_Z = value ;
   }

   public byte getMegres551_N( )
   {
      return gxTv_SdtMotivoEgreso_Megres551_N ;
   }

   public void setMegres551_N( byte value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_Megres551_N = value ;
   }

   protected byte gxTv_SdtMotivoEgreso_Megres551_N ;
   private byte gxTv_SdtMotivoEgreso_N ;
   protected short gxTv_SdtMotivoEgreso_Initialized ;
   protected int gxTv_SdtMotivoEgreso_Clicod ;
   protected int gxTv_SdtMotivoEgreso_Megrelsec ;
   protected int gxTv_SdtMotivoEgreso_Megrelseccli ;
   protected int gxTv_SdtMotivoEgreso_Clicod_Z ;
   protected int gxTv_SdtMotivoEgreso_Megrelsec_Z ;
   protected int gxTv_SdtMotivoEgreso_Megrelseccli_Z ;
   protected String gxTv_SdtMotivoEgreso_Megcodigo ;
   protected String gxTv_SdtMotivoEgreso_Megres551 ;
   protected String gxTv_SdtMotivoEgreso_Megpadre ;
   protected String gxTv_SdtMotivoEgreso_Mode ;
   protected String gxTv_SdtMotivoEgreso_Megcodigo_Z ;
   protected String gxTv_SdtMotivoEgreso_Megres551_Z ;
   protected String gxTv_SdtMotivoEgreso_Megpadre_Z ;
   protected boolean gxTv_SdtMotivoEgreso_Meghabilitado ;
   protected boolean gxTv_SdtMotivoEgreso_Meghabilitado_Z ;
   protected String gxTv_SdtMotivoEgreso_Megold ;
   protected String gxTv_SdtMotivoEgreso_Megdescrip ;
   protected String gxTv_SdtMotivoEgreso_Megrelref ;
   protected String gxTv_SdtMotivoEgreso_Megdescrip_Z ;
   protected String gxTv_SdtMotivoEgreso_Megrelref_Z ;
   protected java.util.Vector<web.StructSdtMotivoEgreso_RevistaAfip> gxTv_SdtMotivoEgreso_Revistaafip=null ;
}

