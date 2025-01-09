package web ;
import com.genexus.*;

public final  class StructSdtimportacion_liquidacion implements Cloneable, java.io.Serializable
{
   public StructSdtimportacion_liquidacion( )
   {
      this( -1, new ModelContext( StructSdtimportacion_liquidacion.class ));
   }

   public StructSdtimportacion_liquidacion( int remoteHandle ,
                                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtimportacion_liquidacion_Impliqfec = cal.getTime() ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfile = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = "" ;
      gxTv_Sdtimportacion_liquidacion_Mode = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = cal.getTime() ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = "" ;
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
      return gxTv_Sdtimportacion_liquidacion_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtimportacion_liquidacion_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Empcod = value ;
   }

   public short getImpliqsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqsec ;
   }

   public void setImpliqsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqsec = value ;
   }

   public java.util.Date getImpliqfec( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqfec ;
   }

   public void setImpliqfec( java.util.Date value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqfec = value ;
   }

   public String getImpliqconfile( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfile ;
   }

   public void setImpliqconfile( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfile = value ;
   }

   public String getImpliqconfilename( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilename ;
   }

   public void setImpliqconfilename( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename = value ;
   }

   public String getImpliqconfiletype( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfiletype ;
   }

   public void setImpliqconfiletype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype = value ;
   }

   public String getImpliqconfilenameandtype( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype ;
   }

   public void setImpliqconfilenameandtype( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtimportacion_liquidacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtimportacion_liquidacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Empcod_Z = value ;
   }

   public short getImpliqsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqsec_Z ;
   }

   public void setImpliqsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqsec_Z = value ;
   }

   public java.util.Date getImpliqfec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqfec_Z ;
   }

   public void setImpliqfec_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqfec_Z = value ;
   }

   public String getImpliqconfilename_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z ;
   }

   public void setImpliqconfilename_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z = value ;
   }

   public String getImpliqconfiletype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z ;
   }

   public void setImpliqconfiletype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z = value ;
   }

   public String getImpliqconfilenameandtype_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z ;
   }

   public void setImpliqconfilenameandtype_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_N = (byte)(0) ;
      gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z = value ;
   }

   private byte gxTv_Sdtimportacion_liquidacion_N ;
   protected short gxTv_Sdtimportacion_liquidacion_Empcod ;
   protected short gxTv_Sdtimportacion_liquidacion_Impliqsec ;
   protected short gxTv_Sdtimportacion_liquidacion_Initialized ;
   protected short gxTv_Sdtimportacion_liquidacion_Empcod_Z ;
   protected short gxTv_Sdtimportacion_liquidacion_Impliqsec_Z ;
   protected int gxTv_Sdtimportacion_liquidacion_Clicod ;
   protected int gxTv_Sdtimportacion_liquidacion_Clicod_Z ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfiletype ;
   protected String gxTv_Sdtimportacion_liquidacion_Mode ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfile ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfilename ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z ;
   protected String gxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z ;
   protected java.util.Date gxTv_Sdtimportacion_liquidacion_Impliqfec ;
   protected java.util.Date gxTv_Sdtimportacion_liquidacion_Impliqfec_Z ;
}

