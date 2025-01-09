package web ;
import com.genexus.*;

public final  class StructSdtbase_promedio_base_promedioItem implements Cloneable, java.io.Serializable
{
   public StructSdtbase_promedio_base_promedioItem( )
   {
      this( -1, new ModelContext( StructSdtbase_promedio_base_promedioItem.class ));
   }

   public StructSdtbase_promedio_base_promedioItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo = "" ;
      gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable = "" ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(1) ;
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

   public String getConceptotipo( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo ;
   }

   public void setConceptotipo( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo = value ;
   }

   public String getFijo_variable( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable ;
   }

   public void setFijo_variable( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable = value ;
   }

   public boolean getChequearhabitual( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual ;
   }

   public void setChequearhabitual( boolean value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual = value ;
   }

   public java.util.Vector<web.StructSdtbase_promedio_base_promedioItem_ConceptosItem> getConceptos( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Conceptos ;
   }

   public void setConceptos( java.util.Vector<web.StructSdtbase_promedio_base_promedioItem_ConceptosItem> value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos = value ;
   }

   protected byte gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N ;
   protected byte gxTv_Sdtbase_promedio_base_promedioItem_N ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable ;
   protected boolean gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual ;
   protected java.util.Vector<web.StructSdtbase_promedio_base_promedioItem_ConceptosItem> gxTv_Sdtbase_promedio_base_promedioItem_Conceptos=null ;
}

