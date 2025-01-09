package web ;
import com.genexus.*;

public final  class StructSdtsdt_LiqLegLSD implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_LiqLegLSD( )
   {
      this( -1, new ModelContext( StructSdtsdt_LiqLegLSD.class ));
   }

   public StructSdtsdt_LiqLegLSD( int remoteHandle ,
                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = cal.getTime() ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(1) ;
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

   public String getImpliqlsdlegid( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid ;
   }

   public void setImpliqlsdlegid( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid = value ;
   }

   public String getImpliqlsdlegcbu( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu ;
   }

   public void setImpliqlsdlegcbu( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu = value ;
   }

   public short getImpliqlsdlegdiasliq( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq ;
   }

   public void setImpliqlsdlegdiasliq( short value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq = value ;
   }

   public java.util.Date getImpliqlsdlegfecpag( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag ;
   }

   public void setImpliqlsdlegfecpag( java.util.Date value )
   {
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = value ;
   }

   public boolean getImpliqlsdlegcony( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony ;
   }

   public void setImpliqlsdlegcony( boolean value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony = value ;
   }

   public byte getImpliqlsdleghijos( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos ;
   }

   public void setImpliqlsdleghijos( byte value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos = value ;
   }

   public String getImpliqlsddeprev( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev ;
   }

   public void setImpliqlsddeprev( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev = value ;
   }

   public String getImpliqlsdforpag( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag ;
   }

   public void setImpliqlsdforpag( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag = value ;
   }

   protected byte gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos ;
   protected byte gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N ;
   protected byte gxTv_Sdtsdt_LiqLegLSD_N ;
   protected short gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag ;
   protected boolean gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony ;
   protected java.util.Date gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag ;
}

