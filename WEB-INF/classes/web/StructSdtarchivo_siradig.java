package web ;
import com.genexus.*;

public final  class StructSdtarchivo_siradig implements Cloneable, java.io.Serializable
{
   public StructSdtarchivo_siradig( )
   {
      this( -1, new ModelContext( StructSdtarchivo_siradig.class ));
   }

   public StructSdtarchivo_siradig( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtarchivo_siradig_Archsiradigfec = cal.getTime() ;
      gxTv_Sdtarchivo_siradig_Archsiradigfile = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigname = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror = "" ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype = "" ;
      gxTv_Sdtarchivo_siradig_Mode = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = cal.getTime() ;
      gxTv_Sdtarchivo_siradig_Archsiradigname_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = "" ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = "" ;
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
      return gxTv_Sdtarchivo_siradig_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtarchivo_siradig_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Empcod = value ;
   }

   public java.util.Date getArchsiradigfec( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfec ;
   }

   public void setArchsiradigfec( java.util.Date value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigfec = value ;
   }

   public String getArchsiradigfile( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfile ;
   }

   public void setArchsiradigfile( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigfile = value ;
   }

   public String getArchsiradigname( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigname ;
   }

   public void setArchsiradigname( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigname = value ;
   }

   public String getArchsiradigtype( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigtype ;
   }

   public void setArchsiradigtype( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype = value ;
   }

   public short getArchsiradigestado( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigestado ;
   }

   public void setArchsiradigestado( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigestado = value ;
   }

   public String getArchsiradigerror( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigerror ;
   }

   public void setArchsiradigerror( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror = value ;
   }

   public String getArchsirdignameandtype( )
   {
      return gxTv_Sdtarchivo_siradig_Archsirdignameandtype ;
   }

   public void setArchsirdignameandtype( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtarchivo_siradig_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtarchivo_siradig_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Clicod_Z = value ;
   }

   public short getEmpcod_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Empcod_Z ;
   }

   public void setEmpcod_Z( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Empcod_Z = value ;
   }

   public java.util.Date getArchsiradigfec_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigfec_Z ;
   }

   public void setArchsiradigfec_Z( java.util.Date value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigfec_Z = value ;
   }

   public String getArchsiradigname_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigname_Z ;
   }

   public void setArchsiradigname_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigname_Z = value ;
   }

   public String getArchsiradigtype_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigtype_Z ;
   }

   public void setArchsiradigtype_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigtype_Z = value ;
   }

   public short getArchsiradigestado_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigestado_Z ;
   }

   public void setArchsiradigestado_Z( short value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigestado_Z = value ;
   }

   public String getArchsiradigerror_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsiradigerror_Z ;
   }

   public void setArchsiradigerror_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsiradigerror_Z = value ;
   }

   public String getArchsirdignameandtype_Z( )
   {
      return gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z ;
   }

   public void setArchsirdignameandtype_Z( String value )
   {
      gxTv_Sdtarchivo_siradig_N = (byte)(0) ;
      gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z = value ;
   }

   private byte gxTv_Sdtarchivo_siradig_N ;
   protected short gxTv_Sdtarchivo_siradig_Empcod ;
   protected short gxTv_Sdtarchivo_siradig_Archsiradigestado ;
   protected short gxTv_Sdtarchivo_siradig_Initialized ;
   protected short gxTv_Sdtarchivo_siradig_Empcod_Z ;
   protected short gxTv_Sdtarchivo_siradig_Archsiradigestado_Z ;
   protected int gxTv_Sdtarchivo_siradig_Clicod ;
   protected int gxTv_Sdtarchivo_siradig_Clicod_Z ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigtype ;
   protected String gxTv_Sdtarchivo_siradig_Mode ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigtype_Z ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigfile ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigname ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigerror ;
   protected String gxTv_Sdtarchivo_siradig_Archsirdignameandtype ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigname_Z ;
   protected String gxTv_Sdtarchivo_siradig_Archsiradigerror_Z ;
   protected String gxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z ;
   protected java.util.Date gxTv_Sdtarchivo_siradig_Archsiradigfec ;
   protected java.util.Date gxTv_Sdtarchivo_siradig_Archsiradigfec_Z ;
}

