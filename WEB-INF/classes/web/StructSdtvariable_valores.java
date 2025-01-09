package web ;
import com.genexus.*;

public final  class StructSdtvariable_valores implements Cloneable, java.io.Serializable
{
   public StructSdtvariable_valores( )
   {
      this( -1, new ModelContext( StructSdtvariable_valores.class ));
   }

   public StructSdtvariable_valores( int remoteHandle ,
                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtvariable_valores_Opecliid = "" ;
      gxTv_Sdtvariable_valores_Opeclivig = cal.getTime() ;
      gxTv_Sdtvariable_valores_Opeclivalor = "" ;
      gxTv_Sdtvariable_valores_Opeclivretro = cal.getTime() ;
      gxTv_Sdtvariable_valores_Opeclivrelref = "" ;
      gxTv_Sdtvariable_valores_Opeclivold = "" ;
      gxTv_Sdtvariable_valores_Mode = "" ;
      gxTv_Sdtvariable_valores_Opecliid_Z = "" ;
      gxTv_Sdtvariable_valores_Opeclivig_Z = cal.getTime() ;
      gxTv_Sdtvariable_valores_Opeclivretro_Z = cal.getTime() ;
      gxTv_Sdtvariable_valores_Opeclivrelref_Z = "" ;
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(1) ;
      gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(1) ;
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
      return gxTv_Sdtvariable_valores_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Clicod = value ;
   }

   public String getOpecliid( )
   {
      return gxTv_Sdtvariable_valores_Opecliid ;
   }

   public void setOpecliid( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opecliid = value ;
   }

   public java.util.Date getOpeclivig( )
   {
      return gxTv_Sdtvariable_valores_Opeclivig ;
   }

   public void setOpeclivig( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivig = value ;
   }

   public String getOpeclivalor( )
   {
      return gxTv_Sdtvariable_valores_Opeclivalor ;
   }

   public void setOpeclivalor( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivalor = value ;
   }

   public boolean getOpeclivpropagar( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar ;
   }

   public void setOpeclivpropagar( boolean value )
   {
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivpropagar = value ;
   }

   public java.util.Date getOpeclivretro( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro ;
   }

   public void setOpeclivretro( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_Opeclivretro_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivretro = value ;
   }

   public int getOpeclirelsec( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelsec ;
   }

   public void setOpeclirelsec( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclirelsec = value ;
   }

   public int getOpeclirelseccli( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelseccli ;
   }

   public void setOpeclirelseccli( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclirelseccli = value ;
   }

   public String getOpeclivrelref( )
   {
      return gxTv_Sdtvariable_valores_Opeclivrelref ;
   }

   public void setOpeclivrelref( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivrelref = value ;
   }

   public String getOpeclivold( )
   {
      return gxTv_Sdtvariable_valores_Opeclivold ;
   }

   public void setOpeclivold( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivold = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtvariable_valores_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtvariable_valores_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtvariable_valores_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Clicod_Z = value ;
   }

   public String getOpecliid_Z( )
   {
      return gxTv_Sdtvariable_valores_Opecliid_Z ;
   }

   public void setOpecliid_Z( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opecliid_Z = value ;
   }

   public java.util.Date getOpeclivig_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivig_Z ;
   }

   public void setOpeclivig_Z( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivig_Z = value ;
   }

   public boolean getOpeclivpropagar_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar_Z ;
   }

   public void setOpeclivpropagar_Z( boolean value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivpropagar_Z = value ;
   }

   public java.util.Date getOpeclivretro_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro_Z ;
   }

   public void setOpeclivretro_Z( java.util.Date value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivretro_Z = value ;
   }

   public int getOpeclirelsec_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelsec_Z ;
   }

   public void setOpeclirelsec_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclirelsec_Z = value ;
   }

   public int getOpeclirelseccli_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclirelseccli_Z ;
   }

   public void setOpeclirelseccli_Z( int value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclirelseccli_Z = value ;
   }

   public String getOpeclivrelref_Z( )
   {
      return gxTv_Sdtvariable_valores_Opeclivrelref_Z ;
   }

   public void setOpeclivrelref_Z( String value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivrelref_Z = value ;
   }

   public byte getOpeclivpropagar_N( )
   {
      return gxTv_Sdtvariable_valores_Opeclivpropagar_N ;
   }

   public void setOpeclivpropagar_N( byte value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivpropagar_N = value ;
   }

   public byte getOpeclivretro_N( )
   {
      return gxTv_Sdtvariable_valores_Opeclivretro_N ;
   }

   public void setOpeclivretro_N( byte value )
   {
      gxTv_Sdtvariable_valores_N = (byte)(0) ;
      gxTv_Sdtvariable_valores_Opeclivretro_N = value ;
   }

   protected byte gxTv_Sdtvariable_valores_Opeclivpropagar_N ;
   protected byte gxTv_Sdtvariable_valores_Opeclivretro_N ;
   private byte gxTv_Sdtvariable_valores_N ;
   protected short gxTv_Sdtvariable_valores_Initialized ;
   protected int gxTv_Sdtvariable_valores_Clicod ;
   protected int gxTv_Sdtvariable_valores_Opeclirelsec ;
   protected int gxTv_Sdtvariable_valores_Opeclirelseccli ;
   protected int gxTv_Sdtvariable_valores_Clicod_Z ;
   protected int gxTv_Sdtvariable_valores_Opeclirelsec_Z ;
   protected int gxTv_Sdtvariable_valores_Opeclirelseccli_Z ;
   protected String gxTv_Sdtvariable_valores_Opecliid ;
   protected String gxTv_Sdtvariable_valores_Mode ;
   protected String gxTv_Sdtvariable_valores_Opecliid_Z ;
   protected boolean gxTv_Sdtvariable_valores_Opeclivpropagar ;
   protected boolean gxTv_Sdtvariable_valores_Opeclivpropagar_Z ;
   protected String gxTv_Sdtvariable_valores_Opeclivalor ;
   protected String gxTv_Sdtvariable_valores_Opeclivold ;
   protected String gxTv_Sdtvariable_valores_Opeclivrelref ;
   protected String gxTv_Sdtvariable_valores_Opeclivrelref_Z ;
   protected java.util.Date gxTv_Sdtvariable_valores_Opeclivig ;
   protected java.util.Date gxTv_Sdtvariable_valores_Opeclivretro ;
   protected java.util.Date gxTv_Sdtvariable_valores_Opeclivig_Z ;
   protected java.util.Date gxTv_Sdtvariable_valores_Opeclivretro_Z ;
}

