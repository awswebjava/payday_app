package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNodeHtmlAPdf extends GxUserType
{
   public SdtNodeHtmlAPdf( )
   {
      this(  new ModelContext(SdtNodeHtmlAPdf.class));
   }

   public SdtNodeHtmlAPdf( ModelContext context )
   {
      super( context, "SdtNodeHtmlAPdf");
   }

   public SdtNodeHtmlAPdf( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtNodeHtmlAPdf");
   }

   public SdtNodeHtmlAPdf( StructSdtNodeHtmlAPdf struct )
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
               gxTv_SdtNodeHtmlAPdf_Message = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "path") )
            {
               gxTv_SdtNodeHtmlAPdf_Path = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombreArchivo") )
            {
               gxTv_SdtNodeHtmlAPdf_Nombrearchivo = oReader.getValue() ;
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
         sName = "NodeHtmlAPdf" ;
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
      oWriter.writeElement("message", gxTv_SdtNodeHtmlAPdf_Message);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("path", gxTv_SdtNodeHtmlAPdf_Path);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("nombreArchivo", gxTv_SdtNodeHtmlAPdf_Nombrearchivo);
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
      AddObjectProperty("message", gxTv_SdtNodeHtmlAPdf_Message, false, false);
      AddObjectProperty("path", gxTv_SdtNodeHtmlAPdf_Path, false, false);
      AddObjectProperty("nombreArchivo", gxTv_SdtNodeHtmlAPdf_Nombrearchivo, false, false);
   }

   public String getgxTv_SdtNodeHtmlAPdf_Message( )
   {
      return gxTv_SdtNodeHtmlAPdf_Message ;
   }

   public void setgxTv_SdtNodeHtmlAPdf_Message( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Message = value ;
   }

   public String getgxTv_SdtNodeHtmlAPdf_Path( )
   {
      return gxTv_SdtNodeHtmlAPdf_Path ;
   }

   public void setgxTv_SdtNodeHtmlAPdf_Path( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Path = value ;
   }

   public String getgxTv_SdtNodeHtmlAPdf_Nombrearchivo( )
   {
      return gxTv_SdtNodeHtmlAPdf_Nombrearchivo ;
   }

   public void setgxTv_SdtNodeHtmlAPdf_Nombrearchivo( String value )
   {
      gxTv_SdtNodeHtmlAPdf_N = (byte)(0) ;
      gxTv_SdtNodeHtmlAPdf_Nombrearchivo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtNodeHtmlAPdf_Message = "" ;
      gxTv_SdtNodeHtmlAPdf_N = (byte)(1) ;
      gxTv_SdtNodeHtmlAPdf_Path = "" ;
      gxTv_SdtNodeHtmlAPdf_Nombrearchivo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNodeHtmlAPdf_N ;
   }

   public web.SdtNodeHtmlAPdf Clone( )
   {
      return (web.SdtNodeHtmlAPdf)(clone()) ;
   }

   public void setStruct( web.StructSdtNodeHtmlAPdf struct )
   {
      setgxTv_SdtNodeHtmlAPdf_Message(struct.getMessage());
      setgxTv_SdtNodeHtmlAPdf_Path(struct.getPath());
      setgxTv_SdtNodeHtmlAPdf_Nombrearchivo(struct.getNombrearchivo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtNodeHtmlAPdf getStruct( )
   {
      web.StructSdtNodeHtmlAPdf struct = new web.StructSdtNodeHtmlAPdf ();
      struct.setMessage(getgxTv_SdtNodeHtmlAPdf_Message());
      struct.setPath(getgxTv_SdtNodeHtmlAPdf_Path());
      struct.setNombrearchivo(getgxTv_SdtNodeHtmlAPdf_Nombrearchivo());
      return struct ;
   }

   protected byte gxTv_SdtNodeHtmlAPdf_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtNodeHtmlAPdf_Message ;
   protected String gxTv_SdtNodeHtmlAPdf_Path ;
   protected String gxTv_SdtNodeHtmlAPdf_Nombrearchivo ;
}

