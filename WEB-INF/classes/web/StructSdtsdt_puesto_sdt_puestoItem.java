package web ;
import com.genexus.*;

public final  class StructSdtsdt_puesto_sdt_puestoItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_puesto_sdt_puestoItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_puesto_sdt_puestoItem.class ));
   }

   public StructSdtsdt_puesto_sdt_puestoItem( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo = "" ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip = "" ;
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

   public String getPuestocodigo( )
   {
      return gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo ;
   }

   public void setPuestocodigo( String value )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo = value ;
   }

   public String getPuestodescrip( )
   {
      return gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip ;
   }

   public void setPuestodescrip( String value )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip = value ;
   }

   protected byte gxTv_Sdtsdt_puesto_sdt_puestoItem_N ;
   protected String gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo ;
   protected String gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip ;
}

