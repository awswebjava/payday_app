package web ;
import com.genexus.*;

public final  class StructSdtscrapeVarReq_scrapeVarReqItem implements Cloneable, java.io.Serializable
{
   public StructSdtscrapeVarReq_scrapeVarReqItem( )
   {
      this( -1, new ModelContext( StructSdtscrapeVarReq_scrapeVarReqItem.class ));
   }

   public StructSdtscrapeVarReq_scrapeVarReqItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(1) ;
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

   public String getBusquedagoogle( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle ;
   }

   public void setBusquedagoogle( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle = value ;
   }

   public String getBaseurl( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl ;
   }

   public void setBaseurl( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl = value ;
   }

   public java.util.Vector getBusquedavariables( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables ;
   }

   public void setBusquedavariables( java.util.Vector value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables = value ;
   }

   public String getTipodedocumento( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento ;
   }

   public void setTipodedocumento( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento = value ;
   }

   public String getTipodescraping( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping ;
   }

   public void setTipodescraping( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping = value ;
   }

   public String getDato( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato ;
   }

   public void setDato( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato = value ;
   }

   public String getTextofin( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin ;
   }

   public void setTextofin( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin = value ;
   }

   protected byte gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N ;
   protected byte gxTv_SdtscrapeVarReq_scrapeVarReqItem_N ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin ;
   protected java.util.Vector gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables=null ;
}

