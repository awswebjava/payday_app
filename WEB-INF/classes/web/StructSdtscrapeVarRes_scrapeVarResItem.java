package web ;
import com.genexus.*;

public final  class StructSdtscrapeVarRes_scrapeVarResItem implements Cloneable, java.io.Serializable
{
   public StructSdtscrapeVarRes_scrapeVarResItem( )
   {
      this( -1, new ModelContext( StructSdtscrapeVarRes_scrapeVarResItem.class ));
   }

   public StructSdtscrapeVarRes_scrapeVarResItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada = "" ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Message = "" ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(1) ;
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

   public java.util.Vector<web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> getBusquedavariables( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables ;
   }

   public void setBusquedavariables( java.util.Vector<web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables = value ;
   }

   public String getUrlencontrada( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada ;
   }

   public void setUrlencontrada( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada = value ;
   }

   public String getMessage( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Message ;
   }

   public void setMessage( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Message = value ;
   }

   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N ;
   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_N ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_Message ;
   protected java.util.Vector<web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables=null ;
}

