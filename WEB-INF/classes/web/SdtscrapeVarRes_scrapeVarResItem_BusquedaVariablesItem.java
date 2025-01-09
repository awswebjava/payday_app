package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem extends GxUserType
{
   public SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( )
   {
      this(  new ModelContext(SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem.class));
   }

   public SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( ModelContext context )
   {
      super( context, "SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem");
   }

   public SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem");
   }

   public SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem( StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "BusquedaVariable") )
            {
               gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Valor") )
            {
               gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "scrapeVarRes.scrapeVarResItem.BusquedaVariablesItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("BusquedaVariable", gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Valor", gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("BusquedaVariable", gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable, false, false);
      AddObjectProperty("Valor", gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor, false, false);
   }

   public String getgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable = value ;
   }

   public String getgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable = "" ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N = (byte)(1) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N ;
   }

   public web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem Clone( )
   {
      return (web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem struct )
   {
      setgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable(struct.getBusquedavariable());
      setgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor(struct.getValor());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem getStruct( )
   {
      web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem struct = new web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem ();
      struct.setBusquedavariable(getgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable());
      struct.setValor(getgxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor());
      return struct ;
   }

   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Busquedavariable ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem_Valor ;
}

