package web ;
import com.genexus.*;

public final  class StructSdtsdt_datos_sec implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_datos_sec( )
   {
      this( -1, new ModelContext( StructSdtsdt_datos_sec.class ));
   }

   public StructSdtsdt_datos_sec( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_Sdtsdt_datos_sec_Clientid = "" ;
      gxTv_Sdtsdt_datos_sec_Liqlote = "" ;
      gxTv_Sdtsdt_datos_sec_Env = "" ;
      gxTv_Sdtsdt_datos_sec_Ejecutarsolo = "" ;
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(1) ;
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
      return gxTv_Sdtsdt_datos_sec_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Clicod = value ;
   }

   public short getEmpcod( )
   {
      return gxTv_Sdtsdt_datos_sec_Empcod ;
   }

   public void setEmpcod( short value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Empcod = value ;
   }

   public int getLiqnro( )
   {
      return gxTv_Sdtsdt_datos_sec_Liqnro ;
   }

   public void setLiqnro( int value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Liqnro = value ;
   }

   public String getClientid( )
   {
      return gxTv_Sdtsdt_datos_sec_Clientid ;
   }

   public void setClientid( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Clientid = value ;
   }

   public String getLiqlote( )
   {
      return gxTv_Sdtsdt_datos_sec_Liqlote ;
   }

   public void setLiqlote( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Liqlote = value ;
   }

   public String getEnv( )
   {
      return gxTv_Sdtsdt_datos_sec_Env ;
   }

   public void setEnv( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Env = value ;
   }

   public String getEjecutarsolo( )
   {
      return gxTv_Sdtsdt_datos_sec_Ejecutarsolo ;
   }

   public void setEjecutarsolo( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Ejecutarsolo = value ;
   }

   public java.util.Vector getLegnumero( )
   {
      return gxTv_Sdtsdt_datos_sec_Legnumero ;
   }

   public void setLegnumero( java.util.Vector value )
   {
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Legnumero = value ;
   }

   protected byte gxTv_Sdtsdt_datos_sec_Legnumero_N ;
   protected byte gxTv_Sdtsdt_datos_sec_N ;
   protected short gxTv_Sdtsdt_datos_sec_Empcod ;
   protected int gxTv_Sdtsdt_datos_sec_Clicod ;
   protected int gxTv_Sdtsdt_datos_sec_Liqnro ;
   protected String gxTv_Sdtsdt_datos_sec_Env ;
   protected String gxTv_Sdtsdt_datos_sec_Ejecutarsolo ;
   protected String gxTv_Sdtsdt_datos_sec_Clientid ;
   protected String gxTv_Sdtsdt_datos_sec_Liqlote ;
   protected java.util.Vector gxTv_Sdtsdt_datos_sec_Legnumero=null ;
}

