package web ;
import com.genexus.*;

public final  class StructSdtini_bienvenida_ini_bienvenidaItem implements Cloneable, java.io.Serializable
{
   public StructSdtini_bienvenida_ini_bienvenidaItem( )
   {
      this( -1, new ModelContext( StructSdtini_bienvenida_ini_bienvenidaItem.class ));
   }

   public StructSdtini_bienvenida_ini_bienvenidaItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid = "" ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef = "" ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef = "" ;
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

   public String getMenuitemid( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid ;
   }

   public void setMenuitemid( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid = value ;
   }

   public String getMitembientextdef( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef ;
   }

   public void setMitembientextdef( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef = value ;
   }

   public String getMitembientitdef( )
   {
      return gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef ;
   }

   public void setMitembientitdef( String value )
   {
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N = (byte)(0) ;
      gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef = value ;
   }

   protected byte gxTv_Sdtini_bienvenida_ini_bienvenidaItem_N ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid ;
   protected String gxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef ;
}

