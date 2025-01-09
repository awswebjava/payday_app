package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdthttp_headers_http_headersItem extends GxUserType
{
   public Sdthttp_headers_http_headersItem( )
   {
      this(  new ModelContext(Sdthttp_headers_http_headersItem.class));
   }

   public Sdthttp_headers_http_headersItem( ModelContext context )
   {
      super( context, "Sdthttp_headers_http_headersItem");
   }

   public Sdthttp_headers_http_headersItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdthttp_headers_http_headersItem");
   }

   public Sdthttp_headers_http_headersItem( StructSdthttp_headers_http_headersItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "name") )
            {
               gxTv_Sdthttp_headers_http_headersItem_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "value") )
            {
               gxTv_Sdthttp_headers_http_headersItem_Value = oReader.getValue() ;
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
         sName = "http_headers.http_headersItem" ;
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
      oWriter.writeElement("name", gxTv_Sdthttp_headers_http_headersItem_Name);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("value", gxTv_Sdthttp_headers_http_headersItem_Value);
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
      AddObjectProperty("name", gxTv_Sdthttp_headers_http_headersItem_Name, false, false);
      AddObjectProperty("value", gxTv_Sdthttp_headers_http_headersItem_Value, false, false);
   }

   public String getgxTv_Sdthttp_headers_http_headersItem_Name( )
   {
      return gxTv_Sdthttp_headers_http_headersItem_Name ;
   }

   public void setgxTv_Sdthttp_headers_http_headersItem_Name( String value )
   {
      gxTv_Sdthttp_headers_http_headersItem_N = (byte)(0) ;
      gxTv_Sdthttp_headers_http_headersItem_Name = value ;
   }

   public String getgxTv_Sdthttp_headers_http_headersItem_Value( )
   {
      return gxTv_Sdthttp_headers_http_headersItem_Value ;
   }

   public void setgxTv_Sdthttp_headers_http_headersItem_Value( String value )
   {
      gxTv_Sdthttp_headers_http_headersItem_N = (byte)(0) ;
      gxTv_Sdthttp_headers_http_headersItem_Value = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdthttp_headers_http_headersItem_Name = "" ;
      gxTv_Sdthttp_headers_http_headersItem_N = (byte)(1) ;
      gxTv_Sdthttp_headers_http_headersItem_Value = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdthttp_headers_http_headersItem_N ;
   }

   public web.Sdthttp_headers_http_headersItem Clone( )
   {
      return (web.Sdthttp_headers_http_headersItem)(clone()) ;
   }

   public void setStruct( web.StructSdthttp_headers_http_headersItem struct )
   {
      setgxTv_Sdthttp_headers_http_headersItem_Name(struct.getName());
      setgxTv_Sdthttp_headers_http_headersItem_Value(struct.getValue());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdthttp_headers_http_headersItem getStruct( )
   {
      web.StructSdthttp_headers_http_headersItem struct = new web.StructSdthttp_headers_http_headersItem ();
      struct.setName(getgxTv_Sdthttp_headers_http_headersItem_Name());
      struct.setValue(getgxTv_Sdthttp_headers_http_headersItem_Value());
      return struct ;
   }

   protected byte gxTv_Sdthttp_headers_http_headersItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdthttp_headers_http_headersItem_Name ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdthttp_headers_http_headersItem_Value ;
}

