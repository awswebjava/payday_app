package web ;
import com.genexus.*;

public final  class StructSdtbatch_seccion_lote_batch_seccion_loteItem implements Cloneable, java.io.Serializable
{
   public StructSdtbatch_seccion_lote_batch_seccion_loteItem( )
   {
      this( -1, new ModelContext( StructSdtbatch_seccion_lote_batch_seccion_loteItem.class ));
   }

   public StructSdtbatch_seccion_lote_batch_seccion_loteItem( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion = "" ;
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod = "" ;
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
      return gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion ;
   }

   public void setLiqbatchseccion( String value )
   {
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion = value ;
   }

   public String getLiqbatchcod( )
   {
      return gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod ;
   }

   public void setLiqbatchcod( String value )
   {
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod = value ;
   }

   protected byte gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_N ;
   protected String gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchseccion ;
   protected String gxTv_Sdtbatch_seccion_lote_batch_seccion_loteItem_Liqbatchcod ;
}

