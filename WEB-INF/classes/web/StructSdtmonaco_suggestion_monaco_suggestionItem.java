package web ;
import com.genexus.*;

public final  class StructSdtmonaco_suggestion_monaco_suggestionItem implements Cloneable, java.io.Serializable
{
   public StructSdtmonaco_suggestion_monaco_suggestionItem( )
   {
      this( -1, new ModelContext( StructSdtmonaco_suggestion_monaco_suggestionItem.class ));
   }

   public StructSdtmonaco_suggestion_monaco_suggestionItem( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(1) ;
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

   public web.StructSdtmonaco_suggestion_monaco_suggestionItem_label getLabel( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label ;
   }

   public void setLabel( web.StructSdtmonaco_suggestion_monaco_suggestionItem_label value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label = value;
   }

   public short getKind( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind ;
   }

   public void setKind( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind = value ;
   }

   public String getInserttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext ;
   }

   public void setInserttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext = value ;
   }

   public short getInserttextrules( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules ;
   }

   public void setInserttextrules( short value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules = value ;
   }

   public String getHover_value( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value ;
   }

   public void setHover_value( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value = value ;
   }

   public String getLabel2( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 ;
   }

   public void setLabel2( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 = value ;
   }

   public String getDetail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail ;
   }

   public void setDetail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail = value ;
   }

   public String getDocumentation( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation ;
   }

   public void setDocumentation( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation = value ;
   }

   public String getSorttext( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext ;
   }

   public void setSorttext( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext = value ;
   }

   public java.util.Vector<web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> getParametros( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros ;
   }

   public void setParametros( java.util.Vector<web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros = value ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros_N ;
   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_N ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Kind ;
   protected short gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttextrules ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Sorttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Inserttext ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Hover_value ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label2 ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Detail ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Documentation ;
   protected web.StructSdtmonaco_suggestion_monaco_suggestionItem_label gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Label=null ;
   protected java.util.Vector<web.StructSdtmonaco_suggestion_monaco_suggestionItem_parametrosItem> gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_Parametros=null ;
}

