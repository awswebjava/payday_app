package web ;
import com.genexus.*;

public final  class StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem.class ));
   }

   public StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod = "" ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc = "" ;
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

   public String getTliqcod( )
   {
      return gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod ;
   }

   public void setTliqcod( String value )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod = value ;
   }

   public String getTliqdesc( )
   {
      return gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc ;
   }

   public void setTliqdesc( String value )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc = value ;
   }

   protected byte gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N ;
   protected String gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod ;
   protected String gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc ;
}

