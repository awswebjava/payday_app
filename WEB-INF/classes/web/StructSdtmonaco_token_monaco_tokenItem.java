package web ;
import com.genexus.*;

public final  class StructSdtmonaco_token_monaco_tokenItem implements Cloneable, java.io.Serializable
{
   public StructSdtmonaco_token_monaco_tokenItem( )
   {
      this( -1, new ModelContext( StructSdtmonaco_token_monaco_tokenItem.class ));
   }

   public StructSdtmonaco_token_monaco_tokenItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre = "" ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Regex = "" ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Css = "" ;
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

   public String getNombre( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre = value ;
   }

   public String getRegex( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Regex ;
   }

   public void setRegex( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Regex = value ;
   }

   public String getCss( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Css ;
   }

   public void setCss( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Css = value ;
   }

   protected byte gxTv_Sdtmonaco_token_monaco_tokenItem_N ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Regex ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Css ;
}

