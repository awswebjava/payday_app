package web ;
import com.genexus.*;

public final  class StructSdtsdt_subtipos_sdt_subtiposItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_subtipos_sdt_subtiposItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_subtipos_sdt_subtiposItem.class ));
   }

   public StructSdtsdt_subtipos_sdt_subtiposItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 = "" ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 = "" ;
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

   public String getSubtipoconcod1( )
   {
      return gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 ;
   }

   public void setSubtipoconcod1( String value )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N = (byte)(0) ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 = value ;
   }

   public String getSubtipocondes1( )
   {
      return gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 ;
   }

   public void setSubtipocondes1( String value )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N = (byte)(0) ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 = value ;
   }

   protected byte gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N ;
   protected String gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 ;
   protected String gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 ;
}

