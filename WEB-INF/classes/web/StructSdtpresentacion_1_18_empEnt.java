package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_empEnt implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_empEnt( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_empEnt.class ));
   }

   public StructSdtpresentacion_1_18_empEnt( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(1) ;
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

   public long getCuit( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Cuit ;
   }

   public void setCuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Cuit = value ;
   }

   public String getDenominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Denominacion ;
   }

   public void setDenominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Denominacion = value ;
   }

   public java.util.Vector<web.StructSdtpresentacion_1_18_empEnt_ingAp> getIngresosaportes( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes ;
   }

   public void setIngresosaportes( java.util.Vector<web.StructSdtpresentacion_1_18_empEnt_ingAp> value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N ;
   protected byte gxTv_Sdtpresentacion_1_18_empEnt_N ;
   protected long gxTv_Sdtpresentacion_1_18_empEnt_Cuit ;
   protected String gxTv_Sdtpresentacion_1_18_empEnt_Denominacion ;
   protected java.util.Vector<web.StructSdtpresentacion_1_18_empEnt_ingAp> gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes=null ;
}

