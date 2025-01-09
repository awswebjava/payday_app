package web ;
import com.genexus.*;

public final  class StructSdtsdt_autoConcepto_sdt_autoConceptoItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_autoConcepto_sdt_autoConceptoItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_autoConcepto_sdt_autoConceptoItem.class ));
   }

   public StructSdtsdt_autoConcepto_sdt_autoConceptoItem( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo = "" ;
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

   public String getConcodigo( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo = value ;
   }

   public long getConordejec( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec ;
   }

   public void setConordejec( long value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec = value ;
   }

   public int getConorden( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden ;
   }

   public void setConorden( int value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden = value ;
   }

   protected byte gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N ;
   protected int gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden ;
   protected long gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec ;
   protected String gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo ;
}

