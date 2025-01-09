package web ;
import com.genexus.*;

public final  class StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem implements Cloneable, java.io.Serializable
{
   public StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( )
   {
      this( -1, new ModelContext( StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem.class ));
   }

   public StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( int remoteHandle ,
                                                                            ModelContext context )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion = "" ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod = "" ;
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

   public String getLiqbatchseccion( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion ;
   }

   public void setLiqbatchseccion( String value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion = value ;
   }

   public String getLiqbatchcod( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod ;
   }

   public void setLiqbatchcod( String value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod = value ;
   }

   public int getLiqbatchlegnro( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro ;
   }

   public void setLiqbatchlegnro( int value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro = value ;
   }

   protected byte gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N ;
   protected int gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro ;
   protected String gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion ;
   protected String gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod ;
}

