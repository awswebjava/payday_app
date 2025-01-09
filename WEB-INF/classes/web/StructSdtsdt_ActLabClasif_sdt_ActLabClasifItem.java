package web ;
import com.genexus.*;

public final  class StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem.class ));
   }

   public StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip = "" ;
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

   public int getActlabnro( )
   {
      return gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro ;
   }

   public void setActlabnro( int value )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro = value ;
   }

   public String getActlabdescrip( )
   {
      return gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip ;
   }

   public void setActlabdescrip( String value )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip = value ;
   }

   protected byte gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N ;
   protected int gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro ;
   protected String gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip ;
}

