package web ;
import com.genexus.*;

public final  class StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label implements Cloneable, java.io.Serializable
{
   public StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label( )
   {
      this( -1, new ModelContext( StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label.class ));
   }

   public StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label( int remoteHandle ,
                                                                                 ModelContext context )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Label = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Description = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Detail = "" ;
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

   public String getLabel( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Label ;
   }

   public void setLabel( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Label = value ;
   }

   public String getDescription( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Description = value ;
   }

   public String getDetail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Detail ;
   }

   public void setDetail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Detail = value ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_N ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Label ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Description ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label_Detail ;
}

