package web ;
import com.genexus.*;

public final  class StructSdtlocalidades_sdt implements Cloneable, java.io.Serializable
{
   public StructSdtlocalidades_sdt( )
   {
      this( -1, new ModelContext( StructSdtlocalidades_sdt.class ));
   }

   public StructSdtlocalidades_sdt( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(1) ;
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

   public web.StructSdtlocalidades_sdt_Localidades getLocalidades( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades ;
   }

   public void setLocalidades( web.StructSdtlocalidades_sdt_Localidades value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades = value;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_N ;
   protected byte gxTv_Sdtlocalidades_sdt_N ;
   protected web.StructSdtlocalidades_sdt_Localidades gxTv_Sdtlocalidades_sdt_Localidades=null ;
}

