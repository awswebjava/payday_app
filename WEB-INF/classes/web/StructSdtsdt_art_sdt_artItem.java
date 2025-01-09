package web ;
import com.genexus.*;

public final  class StructSdtsdt_art_sdt_artItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_art_sdt_artItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_art_sdt_artItem.class ));
   }

   public StructSdtsdt_art_sdt_artItem( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_Sdtsdt_art_sdt_artItem_Artnom = "" ;
      gxTv_Sdtsdt_art_sdt_artItem_Artali = new java.math.BigDecimal(0) ;
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

   public short getArtsec( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artsec ;
   }

   public void setArtsec( short value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artsec = value ;
   }

   public String getArtnom( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artnom ;
   }

   public void setArtnom( String value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artnom = value ;
   }

   public java.math.BigDecimal getArtali( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artali ;
   }

   public void setArtali( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artali = value ;
   }

   protected byte gxTv_Sdtsdt_art_sdt_artItem_N ;
   protected short gxTv_Sdtsdt_art_sdt_artItem_Artsec ;
   protected String gxTv_Sdtsdt_art_sdt_artItem_Artnom ;
   protected java.math.BigDecimal gxTv_Sdtsdt_art_sdt_artItem_Artali ;
}

