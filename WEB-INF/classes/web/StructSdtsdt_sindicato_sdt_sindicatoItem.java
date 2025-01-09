package web ;
import com.genexus.*;

public final  class StructSdtsdt_sindicato_sdt_sindicatoItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_sindicato_sdt_sindicatoItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_sindicato_sdt_sindicatoItem.class ));
   }

   public StructSdtsdt_sindicato_sdt_sindicatoItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod = "" ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip = "" ;
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

   public String getSincod( )
   {
      return gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod ;
   }

   public void setSincod( String value )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod = value ;
   }

   public String getSindescrip( )
   {
      return gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip ;
   }

   public void setSindescrip( String value )
   {
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip = value ;
   }

   protected byte gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_N ;
   protected String gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sincod ;
   protected String gxTv_Sdtsdt_sindicato_sdt_sindicatoItem_Sindescrip ;
}

