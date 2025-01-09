package web ;
import com.genexus.*;

public final  class StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem implements Cloneable, java.io.Serializable
{
   public StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( )
   {
      this( -1, new ModelContext( StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem.class ));
   }

   public StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( int remoteHandle ,
                                                                        ModelContext context )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable = "" ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor = "" ;
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

   public String getBusquedavariable( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable ;
   }

   public void setBusquedavariable( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable = value ;
   }

   public String getValor( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor ;
   }

   public void setValor( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor = value ;
   }

   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor ;
}

