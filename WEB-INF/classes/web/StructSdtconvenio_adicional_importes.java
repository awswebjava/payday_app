package web ;
import com.genexus.*;

public final  class StructSdtconvenio_adicional_importes implements Cloneable, java.io.Serializable
{
   public StructSdtconvenio_adicional_importes( )
   {
      this( -1, new ModelContext( StructSdtconvenio_adicional_importes.class ));
   }

   public StructSdtconvenio_adicional_importes( int remoteHandle ,
                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtconvenio_adicional_importes_Conveadivig = cal.getTime() ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = new java.math.BigDecimal(0) ;
      gxTv_Sdtconvenio_adicional_importes_Mode = "" ;
      gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = cal.getTime() ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = new java.math.BigDecimal(0) ;
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

   public java.util.Date getConveadivig( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadivig ;
   }

   public void setConveadivig( java.util.Date value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadivig = value ;
   }

   public java.math.BigDecimal getConveadiimporte( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimporte ;
   }

   public void setConveadiimporte( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte = value ;
   }

   public int getConveadiimprelsec( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec ;
   }

   public void setConveadiimprelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec = value ;
   }

   public String getMode( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Initialized = value ;
   }

   public java.util.Date getConveadivig_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z ;
   }

   public void setConveadivig_Z( java.util.Date value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z = value ;
   }

   public java.math.BigDecimal getConveadiimporte_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z ;
   }

   public void setConveadiimporte_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z = value ;
   }

   public int getConveadiimprelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z ;
   }

   public void setConveadiimprelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_importes_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z = value ;
   }

   private byte gxTv_Sdtconvenio_adicional_importes_N ;
   protected short gxTv_Sdtconvenio_adicional_importes_Modified ;
   protected short gxTv_Sdtconvenio_adicional_importes_Initialized ;
   protected int gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec ;
   protected int gxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z ;
   protected String gxTv_Sdtconvenio_adicional_importes_Mode ;
   protected java.util.Date gxTv_Sdtconvenio_adicional_importes_Conveadivig ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_adicional_importes_Conveadiimporte ;
   protected java.util.Date gxTv_Sdtconvenio_adicional_importes_Conveadivig_Z ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z ;
}

