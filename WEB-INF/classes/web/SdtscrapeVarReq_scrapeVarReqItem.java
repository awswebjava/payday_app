package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtscrapeVarReq_scrapeVarReqItem extends GxUserType
{
   public SdtscrapeVarReq_scrapeVarReqItem( )
   {
      this(  new ModelContext(SdtscrapeVarReq_scrapeVarReqItem.class));
   }

   public SdtscrapeVarReq_scrapeVarReqItem( ModelContext context )
   {
      super( context, "SdtscrapeVarReq_scrapeVarReqItem");
   }

   public SdtscrapeVarReq_scrapeVarReqItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtscrapeVarReq_scrapeVarReqItem");
   }

   public SdtscrapeVarReq_scrapeVarReqItem( StructSdtscrapeVarReq_scrapeVarReqItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BusquedaGoogle") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BaseURL") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BusquedaVariables") )
            {
               if ( gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables == null )
               {
                  gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables.readxmlcollection(oReader, "BusquedaVariables", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "BusquedaVariables") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoDeDocumento") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoDeScraping") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Dato") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TextoFin") )
            {
               gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin = oReader.getValue() ;
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
         sName = "scrapeVarReq.scrapeVarReqItem" ;
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
      oWriter.writeElement("BusquedaGoogle", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BaseURL", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables.writexmlcollection(oWriter, "BusquedaVariables", sNameSpace1, "Item", sNameSpace1);
      }
      oWriter.writeElement("TipoDeDocumento", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoDeScraping", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Dato", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TextoFin", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin);
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
      AddObjectProperty("BusquedaGoogle", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle, false, false);
      AddObjectProperty("BaseURL", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl, false, false);
      if ( gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables != null )
      {
         AddObjectProperty("BusquedaVariables", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables, false, false);
      }
      AddObjectProperty("TipoDeDocumento", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento, false, false);
      AddObjectProperty("TipoDeScraping", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping, false, false);
      AddObjectProperty("Dato", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato, false, false);
      AddObjectProperty("TextoFin", gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin, false, false);
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle = value ;
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables( )
   {
      if ( gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables == null )
      {
         gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables( GXSimpleCollection<String> value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables = value ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_SetNull( )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(1) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables = null ;
   }

   public boolean getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_IsNull( )
   {
      if ( gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N ;
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento = value ;
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping = value ;
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato = value ;
   }

   public String getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin ;
   }

   public void setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin( String value )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_N = (byte)(1) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N = (byte)(1) ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato = "" ;
      gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtscrapeVarReq_scrapeVarReqItem_N ;
   }

   public web.SdtscrapeVarReq_scrapeVarReqItem Clone( )
   {
      return (web.SdtscrapeVarReq_scrapeVarReqItem)(clone()) ;
   }

   public void setStruct( web.StructSdtscrapeVarReq_scrapeVarReqItem struct )
   {
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle(struct.getBusquedagoogle());
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl(struct.getBaseurl());
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables(new GXSimpleCollection<String>(String.class, "internal", "", struct.getBusquedavariables()));
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento(struct.getTipodedocumento());
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping(struct.getTipodescraping());
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato(struct.getDato());
      setgxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin(struct.getTextofin());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtscrapeVarReq_scrapeVarReqItem getStruct( )
   {
      web.StructSdtscrapeVarReq_scrapeVarReqItem struct = new web.StructSdtscrapeVarReq_scrapeVarReqItem ();
      struct.setBusquedagoogle(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle());
      struct.setBaseurl(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl());
      struct.setBusquedavariables(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables().getStruct());
      struct.setTipodedocumento(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento());
      struct.setTipodescraping(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping());
      struct.setDato(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato());
      struct.setTextofin(getgxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin());
      return struct ;
   }

   protected byte gxTv_SdtscrapeVarReq_scrapeVarReqItem_N ;
   protected byte gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedagoogle ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Baseurl ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodedocumento ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Tipodescraping ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Dato ;
   protected String gxTv_SdtscrapeVarReq_scrapeVarReqItem_Textofin ;
   protected GXSimpleCollection<String> gxTv_SdtscrapeVarReq_scrapeVarReqItem_Busquedavariables=null ;
}

