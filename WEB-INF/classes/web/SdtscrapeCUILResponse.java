package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtscrapeCUILResponse extends GxUserType
{
   public SdtscrapeCUILResponse( )
   {
      this(  new ModelContext(SdtscrapeCUILResponse.class));
   }

   public SdtscrapeCUILResponse( ModelContext context )
   {
      super( context, "SdtscrapeCUILResponse");
   }

   public SdtscrapeCUILResponse( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtscrapeCUILResponse");
   }

   public SdtscrapeCUILResponse( StructSdtscrapeCUILResponse struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombre") )
            {
               gxTv_SdtscrapeCUILResponse_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tiempoDeEjecucion") )
            {
               gxTv_SdtscrapeCUILResponse_Tiempodeejecucion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fuente") )
            {
               gxTv_SdtscrapeCUILResponse_Fuente = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "message") )
            {
               gxTv_SdtscrapeCUILResponse_Message = oReader.getValue() ;
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
         sName = "scrapeCUILResponse" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("nombre", gxTv_SdtscrapeCUILResponse_Nombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("tiempoDeEjecucion", gxTv_SdtscrapeCUILResponse_Tiempodeejecucion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fuente", gxTv_SdtscrapeCUILResponse_Fuente);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("message", gxTv_SdtscrapeCUILResponse_Message);
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
      AddObjectProperty("nombre", gxTv_SdtscrapeCUILResponse_Nombre, false, false);
      AddObjectProperty("tiempoDeEjecucion", gxTv_SdtscrapeCUILResponse_Tiempodeejecucion, false, false);
      AddObjectProperty("fuente", gxTv_SdtscrapeCUILResponse_Fuente, false, false);
      AddObjectProperty("message", gxTv_SdtscrapeCUILResponse_Message, false, false);
   }

   public String getgxTv_SdtscrapeCUILResponse_Nombre( )
   {
      return gxTv_SdtscrapeCUILResponse_Nombre ;
   }

   public void setgxTv_SdtscrapeCUILResponse_Nombre( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Nombre = value ;
   }

   public String getgxTv_SdtscrapeCUILResponse_Tiempodeejecucion( )
   {
      return gxTv_SdtscrapeCUILResponse_Tiempodeejecucion ;
   }

   public void setgxTv_SdtscrapeCUILResponse_Tiempodeejecucion( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Tiempodeejecucion = value ;
   }

   public String getgxTv_SdtscrapeCUILResponse_Fuente( )
   {
      return gxTv_SdtscrapeCUILResponse_Fuente ;
   }

   public void setgxTv_SdtscrapeCUILResponse_Fuente( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Fuente = value ;
   }

   public String getgxTv_SdtscrapeCUILResponse_Message( )
   {
      return gxTv_SdtscrapeCUILResponse_Message ;
   }

   public void setgxTv_SdtscrapeCUILResponse_Message( String value )
   {
      gxTv_SdtscrapeCUILResponse_N = (byte)(0) ;
      gxTv_SdtscrapeCUILResponse_Message = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtscrapeCUILResponse_Nombre = "" ;
      gxTv_SdtscrapeCUILResponse_N = (byte)(1) ;
      gxTv_SdtscrapeCUILResponse_Tiempodeejecucion = "" ;
      gxTv_SdtscrapeCUILResponse_Fuente = "" ;
      gxTv_SdtscrapeCUILResponse_Message = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtscrapeCUILResponse_N ;
   }

   public web.SdtscrapeCUILResponse Clone( )
   {
      return (web.SdtscrapeCUILResponse)(clone()) ;
   }

   public void setStruct( web.StructSdtscrapeCUILResponse struct )
   {
      setgxTv_SdtscrapeCUILResponse_Nombre(struct.getNombre());
      setgxTv_SdtscrapeCUILResponse_Tiempodeejecucion(struct.getTiempodeejecucion());
      setgxTv_SdtscrapeCUILResponse_Fuente(struct.getFuente());
      setgxTv_SdtscrapeCUILResponse_Message(struct.getMessage());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtscrapeCUILResponse getStruct( )
   {
      web.StructSdtscrapeCUILResponse struct = new web.StructSdtscrapeCUILResponse ();
      struct.setNombre(getgxTv_SdtscrapeCUILResponse_Nombre());
      struct.setTiempodeejecucion(getgxTv_SdtscrapeCUILResponse_Tiempodeejecucion());
      struct.setFuente(getgxTv_SdtscrapeCUILResponse_Fuente());
      struct.setMessage(getgxTv_SdtscrapeCUILResponse_Message());
      return struct ;
   }

   protected byte gxTv_SdtscrapeCUILResponse_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtscrapeCUILResponse_Nombre ;
   protected String gxTv_SdtscrapeCUILResponse_Tiempodeejecucion ;
   protected String gxTv_SdtscrapeCUILResponse_Fuente ;
   protected String gxTv_SdtscrapeCUILResponse_Message ;
}

