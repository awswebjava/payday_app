package web ;
import com.genexus.*;

public final  class StructSdtsdt_estados_sdt_estadosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_estados_sdt_estadosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_estados_sdt_estadosItem.class ));
   }

   public StructSdtsdt_estados_sdt_estadosItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo = "" ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip = "" ;
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

   public String getSitcodigo( )
   {
      return gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo ;
   }

   public void setSitcodigo( String value )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo = value ;
   }

   public String getSitdescrip( )
   {
      return gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip ;
   }

   public void setSitdescrip( String value )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip = value ;
   }

   protected byte gxTv_Sdtsdt_estados_sdt_estadosItem_N ;
   protected String gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo ;
   protected String gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip ;
}

