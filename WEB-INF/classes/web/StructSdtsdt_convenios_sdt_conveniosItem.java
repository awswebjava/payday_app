package web ;
import com.genexus.*;

public final  class StructSdtsdt_convenios_sdt_conveniosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_convenios_sdt_conveniosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_convenios_sdt_conveniosItem.class ));
   }

   public StructSdtsdt_convenios_sdt_conveniosItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo = "" ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri = "" ;
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

   public String getConvecodigo( )
   {
      return gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo ;
   }

   public void setConvecodigo( String value )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo = value ;
   }

   public String getConvedescri( )
   {
      return gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri ;
   }

   public void setConvedescri( String value )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri = value ;
   }

   protected byte gxTv_Sdtsdt_convenios_sdt_conveniosItem_N ;
   protected String gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo ;
   protected String gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri ;
}

