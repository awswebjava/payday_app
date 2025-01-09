package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtscrapeVarRes_scrapeVarResItem extends GxUserType
{
   public SdtscrapeVarRes_scrapeVarResItem( )
   {
      this(  new ModelContext(SdtscrapeVarRes_scrapeVarResItem.class));
   }

   public SdtscrapeVarRes_scrapeVarResItem( ModelContext context )
   {
      super( context, "SdtscrapeVarRes_scrapeVarResItem");
   }

   public SdtscrapeVarRes_scrapeVarResItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtscrapeVarRes_scrapeVarResItem");
   }

   public SdtscrapeVarRes_scrapeVarResItem( StructSdtscrapeVarRes_scrapeVarResItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BusquedaVariables") )
            {
               if ( gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables == null )
               {
                  gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables = new GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem>(web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem.class, "scrapeVarRes.scrapeVarResItem.BusquedaVariablesItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables.readxmlcollection(oReader, "BusquedaVariables", "BusquedaVariablesItem") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "URLEncontrada") )
            {
               gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "message") )
            {
               gxTv_SdtscrapeVarRes_scrapeVarResItem_Message = oReader.getValue() ;
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
         sName = "scrapeVarRes.scrapeVarResItem" ;
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
      if ( gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables != null )
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
         gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables.writexmlcollection(oWriter, "BusquedaVariables", sNameSpace1, "BusquedaVariablesItem", sNameSpace1);
      }
      oWriter.writeElement("URLEncontrada", gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("message", gxTv_SdtscrapeVarRes_scrapeVarResItem_Message);
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
      if ( gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables != null )
      {
         AddObjectProperty("BusquedaVariables", gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables, false, false);
      }
      AddObjectProperty("URLEncontrada", gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada, false, false);
      AddObjectProperty("message", gxTv_SdtscrapeVarRes_scrapeVarResItem_Message, false, false);
   }

   public GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables( )
   {
      if ( gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables == null )
      {
         gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables = new GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem>(web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem.class, "scrapeVarRes.scrapeVarResItem.BusquedaVariablesItem", "PayDay", remoteHandle);
      }
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables( GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables = value ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_SetNull( )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(1) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables = null ;
   }

   public boolean getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_IsNull( )
   {
      if ( gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N ;
   }

   public String getgxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada = value ;
   }

   public String getgxTv_SdtscrapeVarRes_scrapeVarResItem_Message( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_Message ;
   }

   public void setgxTv_SdtscrapeVarRes_scrapeVarResItem_Message( String value )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(0) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Message = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N = (byte)(1) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_N = (byte)(1) ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada = "" ;
      gxTv_SdtscrapeVarRes_scrapeVarResItem_Message = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtscrapeVarRes_scrapeVarResItem_N ;
   }

   public web.SdtscrapeVarRes_scrapeVarResItem Clone( )
   {
      return (web.SdtscrapeVarRes_scrapeVarResItem)(clone()) ;
   }

   public void setStruct( web.StructSdtscrapeVarRes_scrapeVarResItem struct )
   {
      GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux = new GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem>(web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem.class, "scrapeVarRes.scrapeVarResItem.BusquedaVariablesItem", "PayDay", remoteHandle);
      Vector<web.StructSdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux1 = struct.getBusquedavariables();
      if (gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux1.size(); i++)
         {
            gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux.add(new web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem(gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables(gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux);
      setgxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada(struct.getUrlencontrada());
      setgxTv_SdtscrapeVarRes_scrapeVarResItem_Message(struct.getMessage());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtscrapeVarRes_scrapeVarResItem getStruct( )
   {
      web.StructSdtscrapeVarRes_scrapeVarResItem struct = new web.StructSdtscrapeVarRes_scrapeVarResItem ();
      struct.setBusquedavariables(getgxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables().getStruct());
      struct.setUrlencontrada(getgxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada());
      struct.setMessage(getgxTv_SdtscrapeVarRes_scrapeVarResItem_Message());
      return struct ;
   }

   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_N ;
   protected byte gxTv_SdtscrapeVarRes_scrapeVarResItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_Urlencontrada ;
   protected String gxTv_SdtscrapeVarRes_scrapeVarResItem_Message ;
   protected GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables_aux ;
   protected GXBaseCollection<web.SdtscrapeVarRes_scrapeVarResItem_BusquedaVariablesItem> gxTv_SdtscrapeVarRes_scrapeVarResItem_Busquedavariables=null ;
}

