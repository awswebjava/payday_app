package web ;
import com.genexus.*;

public final  class StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem.class ));
   }

   public StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold = "" ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo = "" ;
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

   public String getConcodold( )
   {
      return gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold ;
   }

   public void setConcodold( String value )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold = value ;
   }

   public String getConcodigo( )
   {
      return gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo = value ;
   }

   protected byte gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N ;
   protected String gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold ;
   protected String gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo ;
}

