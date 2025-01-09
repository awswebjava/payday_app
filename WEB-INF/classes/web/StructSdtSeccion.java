package web ;
import com.genexus.*;

public final  class StructSdtSeccion implements Cloneable, java.io.Serializable
{
   public StructSdtSeccion( )
   {
      this( -1, new ModelContext( StructSdtSeccion.class ));
   }

   public StructSdtSeccion( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtSeccion_Seccodigo = "" ;
      gxTv_SdtSeccion_Secdescrip = "" ;
      gxTv_SdtSeccion_Secdescripsinac = "" ;
      gxTv_SdtSeccion_Secpadre = "" ;
      gxTv_SdtSeccion_Secrelref = "" ;
      gxTv_SdtSeccion_Secold = "" ;
      gxTv_SdtSeccion_Mode = "" ;
      gxTv_SdtSeccion_Seccodigo_Z = "" ;
      gxTv_SdtSeccion_Secdescrip_Z = "" ;
      gxTv_SdtSeccion_Secdescripsinac_Z = "" ;
      gxTv_SdtSeccion_Secpadre_Z = "" ;
      gxTv_SdtSeccion_Secrelref_Z = "" ;
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
      return gxTv_SdtSeccion_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Clicod = value ;
   }

   public String getSeccodigo( )
   {
      return gxTv_SdtSeccion_Seccodigo ;
   }

   public void setSeccodigo( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Seccodigo = value ;
   }

   public String getSecdescrip( )
   {
      return gxTv_SdtSeccion_Secdescrip ;
   }

   public void setSecdescrip( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secdescrip = value ;
   }

   public boolean getSechabilitada( )
   {
      return gxTv_SdtSeccion_Sechabilitada ;
   }

   public void setSechabilitada( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Sechabilitada = value ;
   }

   public String getSecdescripsinac( )
   {
      return gxTv_SdtSeccion_Secdescripsinac ;
   }

   public void setSecdescripsinac( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secdescripsinac = value ;
   }

   public int getSecrelsec( )
   {
      return gxTv_SdtSeccion_Secrelsec ;
   }

   public void setSecrelsec( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelsec = value ;
   }

   public int getSecrelseccli( )
   {
      return gxTv_SdtSeccion_Secrelseccli ;
   }

   public void setSecrelseccli( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelseccli = value ;
   }

   public String getSecpadre( )
   {
      return gxTv_SdtSeccion_Secpadre ;
   }

   public void setSecpadre( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secpadre = value ;
   }

   public String getSecrelref( )
   {
      return gxTv_SdtSeccion_Secrelref ;
   }

   public void setSecrelref( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelref = value ;
   }

   public String getSecold( )
   {
      return gxTv_SdtSeccion_Secold ;
   }

   public void setSecold( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secold = value ;
   }

   public boolean getSecapoopc( )
   {
      return gxTv_SdtSeccion_Secapoopc ;
   }

   public void setSecapoopc( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secapoopc = value ;
   }

   public java.util.Vector<web.StructSdtSeccion_Puestos> getPuestos( )
   {
      return gxTv_SdtSeccion_Puestos ;
   }

   public void setPuestos( java.util.Vector<web.StructSdtSeccion_Puestos> value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Puestos = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSeccion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSeccion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtSeccion_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Clicod_Z = value ;
   }

   public String getSeccodigo_Z( )
   {
      return gxTv_SdtSeccion_Seccodigo_Z ;
   }

   public void setSeccodigo_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Seccodigo_Z = value ;
   }

   public String getSecdescrip_Z( )
   {
      return gxTv_SdtSeccion_Secdescrip_Z ;
   }

   public void setSecdescrip_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secdescrip_Z = value ;
   }

   public boolean getSechabilitada_Z( )
   {
      return gxTv_SdtSeccion_Sechabilitada_Z ;
   }

   public void setSechabilitada_Z( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Sechabilitada_Z = value ;
   }

   public String getSecdescripsinac_Z( )
   {
      return gxTv_SdtSeccion_Secdescripsinac_Z ;
   }

   public void setSecdescripsinac_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secdescripsinac_Z = value ;
   }

   public int getSecrelsec_Z( )
   {
      return gxTv_SdtSeccion_Secrelsec_Z ;
   }

   public void setSecrelsec_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelsec_Z = value ;
   }

   public int getSecrelseccli_Z( )
   {
      return gxTv_SdtSeccion_Secrelseccli_Z ;
   }

   public void setSecrelseccli_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelseccli_Z = value ;
   }

   public String getSecpadre_Z( )
   {
      return gxTv_SdtSeccion_Secpadre_Z ;
   }

   public void setSecpadre_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secpadre_Z = value ;
   }

   public String getSecrelref_Z( )
   {
      return gxTv_SdtSeccion_Secrelref_Z ;
   }

   public void setSecrelref_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secrelref_Z = value ;
   }

   public boolean getSecapoopc_Z( )
   {
      return gxTv_SdtSeccion_Secapoopc_Z ;
   }

   public void setSecapoopc_Z( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      gxTv_SdtSeccion_Secapoopc_Z = value ;
   }

   private byte gxTv_SdtSeccion_N ;
   protected short gxTv_SdtSeccion_Initialized ;
   protected int gxTv_SdtSeccion_Clicod ;
   protected int gxTv_SdtSeccion_Secrelsec ;
   protected int gxTv_SdtSeccion_Secrelseccli ;
   protected int gxTv_SdtSeccion_Clicod_Z ;
   protected int gxTv_SdtSeccion_Secrelsec_Z ;
   protected int gxTv_SdtSeccion_Secrelseccli_Z ;
   protected String gxTv_SdtSeccion_Seccodigo ;
   protected String gxTv_SdtSeccion_Secpadre ;
   protected String gxTv_SdtSeccion_Mode ;
   protected String gxTv_SdtSeccion_Seccodigo_Z ;
   protected String gxTv_SdtSeccion_Secpadre_Z ;
   protected boolean gxTv_SdtSeccion_Sechabilitada ;
   protected boolean gxTv_SdtSeccion_Secapoopc ;
   protected boolean gxTv_SdtSeccion_Sechabilitada_Z ;
   protected boolean gxTv_SdtSeccion_Secapoopc_Z ;
   protected String gxTv_SdtSeccion_Secold ;
   protected String gxTv_SdtSeccion_Secdescrip ;
   protected String gxTv_SdtSeccion_Secdescripsinac ;
   protected String gxTv_SdtSeccion_Secrelref ;
   protected String gxTv_SdtSeccion_Secdescrip_Z ;
   protected String gxTv_SdtSeccion_Secdescripsinac_Z ;
   protected String gxTv_SdtSeccion_Secrelref_Z ;
   protected java.util.Vector<web.StructSdtSeccion_Puestos> gxTv_SdtSeccion_Puestos=null ;
}

