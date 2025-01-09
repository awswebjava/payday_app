package web ;
import com.genexus.*;

public final  class StructSdtsdt_adicionales_sdt_adicionalesItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_adicionales_sdt_adicionalesItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_adicionales_sdt_adicionalesItem.class ));
   }

   public StructSdtsdt_adicionales_sdt_adicionalesItem( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod = "" ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri = "" ;
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

   public String getConveadicod( )
   {
      return gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod ;
   }

   public void setConveadicod( String value )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod = value ;
   }

   public String getConveadidescri( )
   {
      return gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri ;
   }

   public void setConveadidescri( String value )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri = value ;
   }

   protected byte gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N ;
   protected String gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod ;
   protected String gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri ;
}

