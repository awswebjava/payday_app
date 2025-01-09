package web ;
import com.genexus.*;

public final  class StructSdtpresentacion_1_18_cargaFamilia implements Cloneable, java.io.Serializable
{
   public StructSdtpresentacion_1_18_cargaFamilia( )
   {
      this( -1, new ModelContext( StructSdtpresentacion_1_18_cargaFamilia.class ));
   }

   public StructSdtpresentacion_1_18_cargaFamilia( int remoteHandle ,
                                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = cal.getTime() ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos = "" ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = cal.getTime() ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(1) ;
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

   public byte getTipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc ;
   }

   public void setTipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc = value ;
   }

   public long getNrodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc ;
   }

   public void setNrodoc( long value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc = value ;
   }

   public String getApellido( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido ;
   }

   public void setApellido( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido = value ;
   }

   public String getNombre( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre = value ;
   }

   public java.util.Date getFechanac( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac ;
   }

   public void setFechanac( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac = value ;
   }

   public byte getMesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde ;
   }

   public void setMesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde = value ;
   }

   public byte getMeshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta ;
   }

   public void setMeshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta = value ;
   }

   public byte getParentesco( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco ;
   }

   public void setParentesco( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco = value ;
   }

   public String getVigenteproximosperiodos( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos ;
   }

   public void setVigenteproximosperiodos( String value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos = value ;
   }

   public java.util.Date getFechalimite( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite ;
   }

   public void setFechalimite( java.util.Date value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite = value ;
   }

   public byte getPorcentajededuccion( )
   {
      return gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion ;
   }

   public void setPorcentajededuccion( byte value )
   {
      gxTv_Sdtpresentacion_1_18_cargaFamilia_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion = value ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Meshasta ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Parentesco ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Porcentajededuccion ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac_N ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite_N ;
   protected byte gxTv_Sdtpresentacion_1_18_cargaFamilia_N ;
   protected long gxTv_Sdtpresentacion_1_18_cargaFamilia_Nrodoc ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Apellido ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_cargaFamilia_Vigenteproximosperiodos ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechanac ;
   protected java.util.Date gxTv_Sdtpresentacion_1_18_cargaFamilia_Fechalimite ;
}

