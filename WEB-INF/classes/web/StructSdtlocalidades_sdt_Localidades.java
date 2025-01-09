package web ;
import com.genexus.*;

public final  class StructSdtlocalidades_sdt_Localidades implements Cloneable, java.io.Serializable
{
   public StructSdtlocalidades_sdt_Localidades( )
   {
      this( -1, new ModelContext( StructSdtlocalidades_sdt_Localidades.class ));
   }

   public StructSdtlocalidades_sdt_Localidades( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(1) ;
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

   public java.util.Vector<web.StructSdtlocalidades_sdt_Localidades_ItemItem> getItem( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_Item ;
   }

   public void setItem( java.util.Vector<web.StructSdtlocalidades_sdt_Localidades_ItemItem> value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_Item_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades_Item = value ;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_Item_N ;
   protected byte gxTv_Sdtlocalidades_sdt_Localidades_N ;
   protected java.util.Vector<web.StructSdtlocalidades_sdt_Localidades_ItemItem> gxTv_Sdtlocalidades_sdt_Localidades_Item=null ;
}

