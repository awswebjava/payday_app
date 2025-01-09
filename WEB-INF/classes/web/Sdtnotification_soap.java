package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtnotification_soap extends GxUserType
{
   public Sdtnotification_soap( )
   {
      this(  new ModelContext(Sdtnotification_soap.class));
   }

   public Sdtnotification_soap( ModelContext context )
   {
      super( context, "Sdtnotification_soap");
   }

   public Sdtnotification_soap( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtnotification_soap");
   }

   public Sdtnotification_soap( StructSdtnotification_soap struct )
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

   public String execute( String gxTp_Idvarchar ,
                          String gxTp_Mensaje ,
                          String gxTp_Clientid )
   {
      String returnexecute;
      sIncludeState = true ;
      returnexecute = "";
      context.globals.nSOAPErr = (short)(0) ;
      context.globals.sSOAPErrMsg = "" ;
      GXSoapHTTPClient.setHost( "localhost" );
      GXSoapHTTPClient.setPort( 8080 );
      GXSoapHTTPClient.setBaseURL( "/PagaJavaPostgreSQL/" );
      SoapParm.assignlocationproperties( context, "notification_soap", GXSoapHTTPClient);
      if ( GXutil.strcmp(defaultExecute, "") == 0 )
      {
         targetResourceName = SoapParm.getresourcename(context, "notification_soap") ;
         if ( GXutil.strcmp(targetResourceName, "") == 0 )
         {
            execName = "com.paga.asoap_notification" ;
         }
         else
         {
            execName = targetResourceName ;
         }
      }
      else
      {
         execName = defaultExecute ;
      }
      GXSoapHTTPClient.addHeader("Content-type", "text/xml;charset=utf-8");
      GXSoapHTTPClient.addHeader("Connection", "close");
      GXSoapHTTPClient.addHeader("SOAPAction", "Pagaaction/ASOAP_NOTIFICATION.Execute");
      GXSoapXMLWriter.openRequest(GXSoapHTTPClient);
      GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
      GXSoapXMLWriter.writeStartElement("SOAP-ENV:Envelope");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
      if ( ! ( soapHeaders == null ) )
      {
         if ( soapHeaders.size() > 0 )
         {
            soapHeaders.writexml(GXSoapXMLWriter, "SOAP-ENV:Header", "", true);
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", soapHeadersRaw)==0) ) )
         {
            GXSoapXMLWriter.writeStartElement("SOAP-ENV:Header");
            GXSoapXMLWriter.writeRawText(soapHeadersRaw);
            GXSoapXMLWriter.writeEndElement();
         }
      }
      GXSoapXMLWriter.writeStartElement("SOAP-ENV:Body");
      GXSoapXMLWriter.writeStartElement("soap_notification.Execute");
      GXSoapXMLWriter.writeAttribute("xmlns", "Paga");
      GXSoapXMLWriter.writeElement("Idvarchar", gxTp_Idvarchar);
      GXSoapXMLWriter.writeAttribute("xmlns", "Paga");
      GXSoapXMLWriter.writeElement("Mensaje", gxTp_Mensaje);
      GXSoapXMLWriter.writeAttribute("xmlns", "Paga");
      GXSoapXMLWriter.writeElement("Clientid", gxTp_Clientid);
      GXSoapXMLWriter.writeAttribute("xmlns", "Paga");
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.close();
      GXSoapHTTPClient.execute("POST", execName);
      if ( GXSoapHTTPClient.getErrCode() != 0 )
      {
         currSoapErr = (short)(GXSoapHTTPClient.getErrCode()*-1-10000) ;
         currSoapErrmsg = GXSoapHTTPClient.getErrDescription() ;
      }
      GXSoapXMLReader.openResponse(GXSoapHTTPClient);
      GXSoapError = GXSoapXMLReader.read() ;
      while ( GXSoapError > 0 )
      {
         if ( GXutil.strSearch( GXSoapXMLReader.getName(), "Body", 1) > 0 )
         {
            if (true) break;
         }
         GXSoapError = GXSoapXMLReader.read() ;
      }
      if ( GXSoapError > 0 )
      {
         GXSoapError = GXSoapXMLReader.read() ;
         if ( ( GXSoapError > 0 ) && ( GXutil.strcmp(GXSoapXMLReader.getLocalName(), "Fault") == 0 ) )
         {
            soapFault = (short)(1) ;
         }
      }
      formatError = false ;
      sTagName = GXSoapXMLReader.getName() ;
      if ( GXSoapXMLReader.getIsSimple() == 0 )
      {
         if ( soapFault == 0 )
         {
            GXSoapError = GXSoapXMLReader.read() ;
            if ( ( GXSoapError > 0 ) && ( GXutil.strcmp(GXSoapXMLReader.getLocalName(), "Fault") == 0 ) )
            {
               soapFault = (short)(1) ;
            }
         }
         if ( soapFault == 1 )
         {
            soapFaultHandling( ) ;
         }
         else
         {
            nOutParmCount = (short)(0) ;
            while ( ( ( GXutil.strcmp(GXSoapXMLReader.getName(), sTagName) != 0 ) || ( GXSoapXMLReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
            {
               readOk = (short)(0) ;
               readElement = false ;
               if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "retval") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Paga") == 0 ) )
               {
                  returnexecute = GXSoapXMLReader.getValue() ;
                  readElement = true ;
                  if ( GXSoapError > 0 )
                  {
                     readOk = (short)(1) ;
                  }
                  GXSoapError = GXSoapXMLReader.read() ;
               }
               if ( ! readElement )
               {
                  readOk = (short)(1) ;
                  GXSoapError = GXSoapXMLReader.read() ;
               }
               nOutParmCount = (short)(nOutParmCount+1) ;
               if ( ( readOk == 0 ) || formatError )
               {
                  context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
                  context.globals.sSOAPErrMsg += "Message: " + GXSoapXMLReader.readRawXML() ;
                  GXSoapError = (short)(nOutParmCount*-1) ;
               }
            }
         }
      }
      GXSoapXMLReader.close();
      if ( currSoapErr == 0 )
      {
         if ( GXSoapError < 0 )
         {
            currSoapErr = (short)(GXSoapError*-1) ;
            currSoapErrmsg = context.globals.sSOAPErrMsg ;
         }
         else
         {
            if ( GXSoapXMLReader.getErrCode() > 0 )
            {
               currSoapErr = (short)(GXSoapXMLReader.getErrCode()*-1) ;
               currSoapErrmsg = GXSoapXMLReader.getErrDescription() ;
            }
            else
            {
               if ( GXSoapError == 0 )
               {
                  currSoapErr = (short)(-20001) ;
                  currSoapErrmsg = "Malformed SOAP message." ;
               }
               else
               {
                  currSoapErr = (short)(0) ;
                  currSoapErrmsg = "No error." ;
               }
            }
         }
      }
      if ( currSoapErr != 0 )
      {
         oLocation = SoapParm.getlocation(context, "notification_soap") ;
         if ( ( oLocation.getCancelOnError() == 0 ) || ( oLocation.getCancelOnError() == 1 ) )
         {
            throw new RuntimeException(currSoapErrmsg + "(" + currSoapErr+ ")");
         }
      }
      context.globals.nSOAPErr = currSoapErr ;
      context.globals.sSOAPErrMsg = currSoapErrmsg ;
      return returnexecute ;
   }

   public void soapFaultHandling( )
   {
      GXSoapXMLReader.read();
      while ( ! ( ( GXutil.strcmp(GXSoapXMLReader.getLocalName(), "Fault") == 0 ) && ( GXSoapXMLReader.getNodeType() == 2 ) ) )
      {
         if ( GXutil.strcmp(GXutil.lower( GXSoapXMLReader.getName()), "faultcode") == 0 )
         {
            sFaultCode = GXSoapXMLReader.getValue() ;
         }
         else if ( GXutil.strcmp(GXutil.lower( GXSoapXMLReader.getName()), "faultstring") == 0 )
         {
            sFaultString = GXSoapXMLReader.getValue() ;
         }
         else if ( GXutil.strcmp(GXutil.lower( GXSoapXMLReader.getName()), "detail") == 0 )
         {
            if ( GXSoapXMLReader.getIsSimple() == 0 )
            {
               GXSoapXMLReader.read();
               sDetail = GXSoapXMLReader.readRawXML() ;
            }
            else
            {
               sDetail = GXSoapXMLReader.getValue() ;
            }
         }
         if ( ! ( ( GXutil.strcmp(GXSoapXMLReader.getLocalName(), "Fault") == 0 ) && ( GXSoapXMLReader.getNodeType() == 2 ) ) )
         {
            GXSoapError = GXSoapXMLReader.read() ;
            if ( GXSoapError == 0 )
            {
               if (true) break;
            }
         }
      }
      if ( GXutil.strSearch( GXutil.lower( sFaultCode), "client", 1) > 0 )
      {
         currSoapErr = (short)(-20004) ;
         currSoapErrmsg += "SOAP Fault: Error in client request." + GXutil.newLine( ) + "Message: " + sFaultString + GXutil.newLine( ) + "Detail: " + sDetail ;
      }
      else if ( GXutil.strSearch( GXutil.lower( sFaultCode), "server", 1) > 0 )
      {
         currSoapErr = (short)(-20005) ;
         currSoapErrmsg += "SOAP Fault: Error in server execution." + GXutil.newLine( ) + "Message: " + sFaultString + GXutil.newLine( ) + "Detail: " + sDetail ;
      }
      else
      {
         currSoapErr = (short)(-20006) ;
         currSoapErrmsg += "Unknown error: " + sFaultCode + GXutil.newLine( ) + "Message: " + sFaultString + GXutil.newLine( ) + "Detail: " + sDetail ;
      }
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
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
   }

   public String getgxTv_Sdtnotification_soap_DefaultExecute( )
   {
      return defaultExecute ;
   }

   public com.genexus.GxUnknownObjectCollection getgxTv_Sdtnotification_soap_Soapheaders( )
   {
      if ( soapHeaders == null )
      {
         soapHeaders = new com.genexus.GxUnknownObjectCollection();
      }
      return soapHeaders ;
   }

   public String getgxTv_Sdtnotification_soap_Soapheadersraw( )
   {
      if ( (GXutil.strcmp("", soapHeadersRaw)==0) )
      {
         soapHeadersRaw = "" ;
      }
      return soapHeadersRaw ;
   }

   public void setSoapheadersraw( String value )
   {
      soapHeadersRaw = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      defaultExecute = "" ;
      GXSoapHTTPClient = new com.genexus.internet.HttpClient();
      execName = "" ;
      targetResourceName = "" ;
      GXSoapXMLReader = new com.genexus.xml.XMLReader();
      GXSoapXMLWriter = new com.genexus.xml.XMLWriter();
      currSoapErrmsg = "" ;
      sTagName = "" ;
      oLocation = new com.genexus.internet.Location();
      sFaultCode = "" ;
      sFaultString = "" ;
      sDetail = "" ;
   }

   public web.Sdtnotification_soap Clone( )
   {
      return (web.Sdtnotification_soap)(clone()) ;
   }

   public void setStruct( web.StructSdtnotification_soap struct )
   {
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtnotification_soap getStruct( )
   {
      web.StructSdtnotification_soap struct = new web.StructSdtnotification_soap ();
      return struct ;
   }

   protected short GXSoapError ;
   protected short currSoapErr ;
   protected short soapFault ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String defaultExecute ;
   protected String execName ;
   protected String targetResourceName ;
   protected String currSoapErrmsg ;
   protected String soapHeadersRaw ;
   protected String sTagName ;
   protected String sFaultCode ;
   protected String sFaultString ;
   protected String sDetail ;
   protected boolean sIncludeState ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   protected com.genexus.xml.XMLReader GXSoapXMLReader ;
   protected com.genexus.internet.Location oLocation ;
   protected com.genexus.internet.HttpClient GXSoapHTTPClient ;
   protected com.genexus.GxUnknownObjectCollection soapHeaders ;
}

