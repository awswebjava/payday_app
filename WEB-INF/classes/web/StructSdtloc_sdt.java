package web ;
import com.genexus.*;

public final  class StructSdtloc_sdt implements Cloneable, java.io.Serializable
{
   public StructSdtloc_sdt( )
   {
      this( -1, new ModelContext( StructSdtloc_sdt.class ));
   }

   public StructSdtloc_sdt( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(1) ;
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

   public web.StructSdtloc_sdt_Localidades getLocalidades( )
   {
      return gxTv_Sdtloc_sdt_Localidades ;
   }

   public void setLocalidades( web.StructSdtloc_sdt_Localidades value )
   {
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades = value;
   }

   protected byte gxTv_Sdtloc_sdt_Localidades_N ;
   protected byte gxTv_Sdtloc_sdt_N ;
   protected web.StructSdtloc_sdt_Localidades gxTv_Sdtloc_sdt_Localidades=null ;
}

