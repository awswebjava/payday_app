package web ;
import com.genexus.*;

public final  class StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem implements Cloneable, java.io.Serializable
{
   public StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( )
   {
      this( -1, new ModelContext( StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem.class ));
   }

   public StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem( int remoteHandle ,
                                                                           ModelContext context )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(1) ;
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

   public web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label getLabel( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label ;
   }

   public void setLabel( web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label = value;
   }

   public short getKind( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind ;
   }

   public void setKind( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind = value ;
   }

   public String getInserttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext ;
   }

   public void setInserttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext = value ;
   }

   public short getInserttextrules( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules ;
   }

   public void setInserttextrules( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules = value ;
   }

   public String getHover_value( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value ;
   }

   public void setHover_value( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value = value ;
   }

   public String getDetail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail ;
   }

   public void setDetail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail = value ;
   }

   public String getSorttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext ;
   }

   public void setSorttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext = value ;
   }

   public String getDocumentation( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation ;
   }

   public void setDocumentation( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation = value ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_N ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Kind ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttextrules ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Sorttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Inserttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Hover_value ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Detail ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Documentation ;
   protected web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_label gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_parametrosItem_Label=null ;
}

