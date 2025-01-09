package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gethomesamplenamevaluedata_impl extends GXWebProcedure
{
   public gethomesamplenamevaluedata_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gethomesamplenamevaluedata_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethomesamplenamevaluedata_impl.class ));
   }

   public gethomesamplenamevaluedata_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void webExecute( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GXSoapHTTPResponse.addHeader("Content-type", "text/xml;charset=utf-8");
      }
      if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getMethod()), "get") == 0 )
      {
         if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getQuerystring()), "wsdl") == 0 )
         {
            GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
            GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
            GXSoapXMLWriter.writeStartElement("definitions");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "PayDay");
            GXSoapXMLWriter.writeAttribute("xmlns:wsdlns", "PayDay");
            GXSoapXMLWriter.writeAttribute("xmlns:soap", "http://schemas.xmlsoap.org/wsdl/soap/");
            GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://schemas.xmlsoap.org/wsdl/");
            GXSoapXMLWriter.writeAttribute("xmlns:tns", "PayDay");
            GXSoapXMLWriter.writeStartElement("types");
            GXSoapXMLWriter.writeStartElement("schema");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "PayDay");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
            GXSoapXMLWriter.writeAttribute("elementFormDefault", "qualified");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "HomeSampleNameValueData");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "HomeSampleNameValueDataItem");
            GXSoapXMLWriter.writeAttribute("type", "tns:WWPBaseObjects.HomeSampleNameValueData.HomeSampleNameValueDataItem");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "WWPBaseObjects.HomeSampleNameValueData.HomeSampleNameValueDataItem");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Name");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Value");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Check");
            GXSoapXMLWriter.writeAttribute("type", "xsd:boolean");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "ReturnValue");
            GXSoapXMLWriter.writeAttribute("type", "tns:HomeSampleNameValueData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:GetHomeSampleNameValueData.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:GetHomeSampleNameValueData.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueDataSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"GetHomeSampleNameValueData.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"GetHomeSampleNameValueData.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueDataSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"GetHomeSampleNameValueDataSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "PayDayaction/"+"wwpbaseobjects.AGETHOMESAMPLENAMEVALUEDATA.Execute");
            GXSoapXMLWriter.writeStartElement("input");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("output");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("service");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueData");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleNameValueDataSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"GetHomeSampleNameValueDataSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", ((httpContext.getHttpSecure( )==1) ? "https://" : "http://")+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"web.wwpbaseobjects.gethomesamplenamevaluedata");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + ((httpContext.getHttpSecure( )==1) ? "https://" : "http://") + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "web.wwpbaseobjects.gethomesamplenamevaluedata" + "?wsdl to get the WSDL." ;
         }
      }
      if ( currSoapErr == 0 )
      {
         GXSoapXMLReader.openRequest(GXSoapHTTPRequest);
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
            if ( GXSoapError > 0 )
            {
               currMethod = GXSoapXMLReader.getName() ;
               if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
               {
                  if ( currSoapErr == 0 )
                  {
                  }
               }
               else
               {
                  currSoapErr = (short)(-20002) ;
                  currSoapErrmsg = "Wrong method called. Expected method: " + "Execute" ;
               }
            }
         }
         GXSoapXMLReader.close();
      }
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
      if ( currSoapErr == 0 )
      {
         execute_internal();
      }
      sIncludeState = true ;
      GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
      GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
      GXSoapXMLWriter.writeStartElement("SOAP-ENV:Envelope");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
      if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
      {
         GXSoapXMLWriter.writeStartElement("SOAP-ENV:Body");
         GXSoapXMLWriter.writeStartElement("GetHomeSampleNameValueData.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "PayDay");
         if ( currSoapErr == 0 )
         {
            if ( Gxm3rootcol != null )
            {
               Gxm3rootcol.writexmlcollection(GXSoapXMLWriter, "ReturnValue", "PayDay", "HomeSampleNameValueDataItem", "PayDay");
            }
         }
         else
         {
            GXSoapXMLWriter.writeStartElement("SOAP-ENV:Fault");
            GXSoapXMLWriter.writeElement("faultcode", "SOAP-ENV:Client");
            GXSoapXMLWriter.writeElement("faultstring", currSoapErrmsg);
            GXSoapXMLWriter.writeElement("detail", GXutil.trim( GXutil.str( currSoapErr, 10, 0)));
            GXSoapXMLWriter.writeEndElement();
         }
         GXSoapXMLWriter.writeEndElement();
         GXSoapXMLWriter.writeEndElement();
      }
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.close();
   }

   public void execute( GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem>[] aP0 )
   {
      gethomesamplenamevaluedata_impl.this.aP0 = aP0;
      initialize();
      internalCall = true ;
      privateExecute();
   }

   public void execute_internal( )
   {
      initialized = (short)(1) ;
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = AV5HomeSampleData ;
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      new web.wwpbaseobjects.gethomesampledata(remoteHandle, context).execute( GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2) ;
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[0] ;
      AV5HomeSampleData = GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
      Gxv1skipcount = 0 ;
      AV12GXV1 = 1 ;
      while ( AV12GXV1 <= AV5HomeSampleData.size() )
      {
         AV6HomeSampleDataItem = (web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)((web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)AV5HomeSampleData.elementAt(-1+AV12GXV1));
         Gxv1skipcount = (int)(Gxv1skipcount+1) ;
         Gxm2homesamplenamevaluedata = (web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem)new web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem(remoteHandle, context);
         Gxm3rootcol.add(Gxm2homesamplenamevaluedata, 0);
         Gxm2homesamplenamevaluedata.setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname() );
         Gxm2homesamplenamevaluedata.setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice() );
         if ( ( 6 != 0 ) && ( Gxv1skipcount >= 6 ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         AV12GXV1 = (int)(AV12GXV1+1) ;
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      if ( internalCall )
      {
         this.aP0[0] = gethomesamplenamevaluedata_impl.this.Gxm3rootcol;
      }
      CloseOpenCursors();
      if ( ! internalCall )
      {
         super.cleanup();
      }
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXSoapHTTPRequest = httpContext.getHttpRequest();
      GXSoapXMLReader = new com.genexus.xml.XMLReader();
      GXSoapHTTPResponse = httpContext.getHttpResponse();
      GXSoapXMLWriter = new com.genexus.xml.XMLWriter();
      currSoapErrmsg = "" ;
      currMethod = "" ;
      Gxm3rootcol = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem>(web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem.class, "HomeSampleNameValueDataItem", "PayDay", remoteHandle);
      AV5HomeSampleData = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2 = new GXBaseCollection[1] ;
      AV6HomeSampleDataItem = new web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2homesamplenamevaluedata = new web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short initialized ;
   private short Gx_err ;
   private int Gxv1skipcount ;
   private int AV12GXV1 ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private boolean sIncludeState ;
   private boolean internalCall ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem>[] aP0 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> AV5HomeSampleData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem> Gxm3rootcol ;
   private web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem AV6HomeSampleDataItem ;
   private web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem Gxm2homesamplenamevaluedata ;
}

