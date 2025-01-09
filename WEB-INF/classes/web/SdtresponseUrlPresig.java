package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtresponseUrlPresig extends GxUserType
{
   public SdtresponseUrlPresig( )
   {
      this(  new ModelContext(SdtresponseUrlPresig.class));
   }

   public SdtresponseUrlPresig( ModelContext context )
   {
      super( context, "SdtresponseUrlPresig");
   }

   public SdtresponseUrlPresig( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtresponseUrlPresig");
   }

   public SdtresponseUrlPresig( StructSdtresponseUrlPresig struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "message") )
            {
               gxTv_SdtresponseUrlPresig_Message = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "url") )
            {
               gxTv_SdtresponseUrlPresig_Url = oReader.getValue() ;
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
         sName = "responseUrlPresig" ;
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
      oWriter.writeElement("message", gxTv_SdtresponseUrlPresig_Message);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("url", gxTv_SdtresponseUrlPresig_Url);
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
      AddObjectProperty("message", gxTv_SdtresponseUrlPresig_Message, false, false);
      AddObjectProperty("url", gxTv_SdtresponseUrlPresig_Url, false, false);
   }

   public String getgxTv_SdtresponseUrlPresig_Message( )
   {
      return gxTv_SdtresponseUrlPresig_Message ;
   }

   public void setgxTv_SdtresponseUrlPresig_Message( String value )
   {
      gxTv_SdtresponseUrlPresig_N = (byte)(0) ;
      gxTv_SdtresponseUrlPresig_Message = value ;
   }

   public String getgxTv_SdtresponseUrlPresig_Url( )
   {
      return gxTv_SdtresponseUrlPresig_Url ;
   }

   public void setgxTv_SdtresponseUrlPresig_Url( String value )
   {
      gxTv_SdtresponseUrlPresig_N = (byte)(0) ;
      gxTv_SdtresponseUrlPresig_Url = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtresponseUrlPresig_Message = "" ;
      gxTv_SdtresponseUrlPresig_N = (byte)(1) ;
      gxTv_SdtresponseUrlPresig_Url = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtresponseUrlPresig_N ;
   }

   public web.SdtresponseUrlPresig Clone( )
   {
      return (web.SdtresponseUrlPresig)(clone()) ;
   }

   public void setStruct( web.StructSdtresponseUrlPresig struct )
   {
      setgxTv_SdtresponseUrlPresig_Message(struct.getMessage());
      setgxTv_SdtresponseUrlPresig_Url(struct.getUrl());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtresponseUrlPresig getStruct( )
   {
      web.StructSdtresponseUrlPresig struct = new web.StructSdtresponseUrlPresig ();
      struct.setMessage(getgxTv_SdtresponseUrlPresig_Message());
      struct.setUrl(getgxTv_SdtresponseUrlPresig_Url());
      return struct ;
   }

   protected byte gxTv_SdtresponseUrlPresig_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtresponseUrlPresig_Message ;
   protected String gxTv_SdtresponseUrlPresig_Url ;
}

