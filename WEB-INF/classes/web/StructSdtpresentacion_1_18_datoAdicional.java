package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_datoAdicional implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_datoAdicional( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_datoAdicional.class ));
   }

   public StructSdtpresentacion_1_18_datoAdicional( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Valor = "" ;
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

   public String getNombre( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre = value ;
   }

   public byte getMesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde ;
   }

   public void setMesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde = value ;
   }

   public byte getMeshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta ;
   }

   public void setMeshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta = value ;
   }

   public String getValor( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Valor ;
   }

   public void setValor( String value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Valor = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta ;
   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_N ;
   protected String gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_datoAdicional_Valor ;
}

