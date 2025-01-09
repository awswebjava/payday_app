package web ;
import com.genexus.*;

public final  class StructSdtloc_sdt_Localidades implements Cloneable, java.io.Serializable
{
   public StructSdtloc_sdt_Localidades( )
   {
      this( -1, new ModelContext( StructSdtloc_sdt_Localidades.class ));
   }

   public StructSdtloc_sdt_Localidades( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(1) ;
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

   public web.StructSdtloc_sdt_Localidades_Item getItem( )
   {
      return gxTv_Sdtloc_sdt_Localidades_Item ;
   }

   public void setItem( web.StructSdtloc_sdt_Localidades_Item value )
   {
      gxTv_Sdtloc_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtloc_sdt_Localidades_Item = value;
   }

   protected byte gxTv_Sdtloc_sdt_Localidades_Item_N ;
   protected byte gxTv_Sdtloc_sdt_Localidades_N ;
   protected web.StructSdtloc_sdt_Localidades_Item gxTv_Sdtloc_sdt_Localidades_Item=null ;
}

