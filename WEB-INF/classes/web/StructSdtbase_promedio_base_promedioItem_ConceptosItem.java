package web ;
import com.genexus.*;

public final  class StructSdtbase_promedio_base_promedioItem_ConceptosItem implements Cloneable, java.io.Serializable
{
   public StructSdtbase_promedio_base_promedioItem_ConceptosItem( )
   {
      this( -1, new ModelContext( StructSdtbase_promedio_base_promedioItem_ConceptosItem.class ));
   }

   public StructSdtbase_promedio_base_promedioItem_ConceptosItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo = "" ;
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
      return gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo = value ;
   }

   protected byte gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo ;
}

