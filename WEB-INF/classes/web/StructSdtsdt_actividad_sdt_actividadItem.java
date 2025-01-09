package web ;
import com.genexus.*;

public final  class StructSdtsdt_actividad_sdt_actividadItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_actividad_sdt_actividadItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_actividad_sdt_actividadItem.class ));
   }

   public StructSdtsdt_actividad_sdt_actividadItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo = "" ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip = "" ;
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

   public String getActcodigo( )
   {
      return gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo ;
   }

   public void setActcodigo( String value )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_N = (byte)(0) ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo = value ;
   }

   public String getActdescrip( )
   {
      return gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip ;
   }

   public void setActdescrip( String value )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_N = (byte)(0) ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip = value ;
   }

   protected byte gxTv_Sdtsdt_actividad_sdt_actividadItem_N ;
   protected String gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo ;
   protected String gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip ;
}

