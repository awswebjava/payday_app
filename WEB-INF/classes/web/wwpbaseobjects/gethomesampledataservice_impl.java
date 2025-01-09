package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gethomesampledataservice_impl extends GXWebProcedure
{
   public gethomesampledataservice_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gethomesampledataservice_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethomesampledataservice_impl.class ));
   }

   public gethomesampledataservice_impl( int remoteHandle ,
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
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService");
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
            GXSoapXMLWriter.writeAttribute("name", "HomeSampleData");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "HomeSampleDataItem");
            GXSoapXMLWriter.writeAttribute("type", "tns:WWPBaseObjects.HomeSampleData.HomeSampleDataItem");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "WWPBaseObjects.HomeSampleData.HomeSampleDataItem");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductName");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductPrice");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductWeight");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductVolume");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductDiscount");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ProductStatus");
            GXSoapXMLWriter.writeAttribute("type", "xsd:byte");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "ReturnValue");
            GXSoapXMLWriter.writeAttribute("type", "tns:HomeSampleData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:GetHomeSampleDataService.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:GetHomeSampleDataService.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataServiceSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"GetHomeSampleDataService.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"GetHomeSampleDataService.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataServiceSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"GetHomeSampleDataServiceSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "PayDayaction/"+"wwpbaseobjects.AGETHOMESAMPLEDATASERVICE.Execute");
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
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataService");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "GetHomeSampleDataServiceSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"GetHomeSampleDataServiceSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", ((httpContext.getHttpSecure( )==1) ? "https://" : "http://")+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"web.wwpbaseobjects.gethomesampledataservice");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + ((httpContext.getHttpSecure( )==1) ? "https://" : "http://") + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "web.wwpbaseobjects.gethomesampledataservice" + "?wsdl to get the WSDL." ;
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
         GXSoapXMLWriter.writeStartElement("GetHomeSampleDataService.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "PayDay");
         if ( currSoapErr == 0 )
         {
            if ( Gxm2rootcol != null )
            {
               Gxm2rootcol.writexmlcollection(GXSoapXMLWriter, "ReturnValue", "PayDay", "HomeSampleDataItem", "PayDay");
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

   public void execute( GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 )
   {
      gethomesampledataservice_impl.this.aP0 = aP0;
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
      AV11GXV1 = 1 ;
      while ( AV11GXV1 <= AV5HomeSampleData.size() )
      {
         AV6HomeSampleDataItem = (web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)((web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)AV5HomeSampleData.elementAt(-1+AV11GXV1));
         Gxm1homesampledata = (web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1homesampledata, 0);
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname() );
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice() );
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume() );
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight() );
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount() );
         Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( AV6HomeSampleDataItem.getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus() );
         AV11GXV1 = (int)(AV11GXV1+1) ;
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
         this.aP0[0] = gethomesampledataservice_impl.this.Gxm2rootcol;
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
      Gxm2rootcol = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      AV5HomeSampleData = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 = new GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "PayDay", remoteHandle);
      GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2 = new GXBaseCollection[1] ;
      AV6HomeSampleDataItem = new web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm1homesampledata = new web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short initialized ;
   private short Gx_err ;
   private int AV11GXV1 ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private boolean sIncludeState ;
   private boolean internalCall ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> Gxm2rootcol ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> AV5HomeSampleData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXt_objcol_SdtHomeSampleData_HomeSampleDataItem1 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> GXv_objcol_SdtHomeSampleData_HomeSampleDataItem2[] ;
   private web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem AV6HomeSampleDataItem ;
   private web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem Gxm1homesampledata ;
}

