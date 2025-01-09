package web ;
import com.genexus.*;

public final  class StructSdtsdt_errores_sdt_erroresItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_errores_sdt_erroresItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_errores_sdt_erroresItem.class ));
   }

   public StructSdtsdt_errores_sdt_erroresItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje = "" ;
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

   public String getMensaje( )
   {
      return gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje ;
   }

   public void setMensaje( String value )
   {
      gxTv_Sdtsdt_errores_sdt_erroresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje = value ;
   }

   protected byte gxTv_Sdtsdt_errores_sdt_erroresItem_N ;
   protected String gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje ;
}

