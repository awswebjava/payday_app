package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtfileUploadResponse extends GxUserType
{
   public SdtfileUploadResponse( )
   {
      this(  new ModelContext(SdtfileUploadResponse.class));
   }

   public SdtfileUploadResponse( ModelContext context )
   {
      super( context, "SdtfileUploadResponse");
   }

   public SdtfileUploadResponse( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtfileUploadResponse");
   }

   public SdtfileUploadResponse( StructSdtfileUploadResponse struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "status") )
            {
               gxTv_SdtfileUploadResponse_Status = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "dir") )
            {
               gxTv_SdtfileUploadResponse_Dir = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "name") )
            {
               gxTv_SdtfileUploadResponse_Name = oReader.getValue() ;
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
         sName = "fileUploadResponse" ;
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
      oWriter.writeElement("status", GXutil.trim( GXutil.strNoRound( gxTv_SdtfileUploadResponse_Status, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("dir", gxTv_SdtfileUploadResponse_Dir);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("name", gxTv_SdtfileUploadResponse_Name);
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
      AddObjectProperty("status", gxTv_SdtfileUploadResponse_Status, false, false);
      AddObjectProperty("dir", gxTv_SdtfileUploadResponse_Dir, false, false);
      AddObjectProperty("name", gxTv_SdtfileUploadResponse_Name, false, false);
   }

   public java.math.BigDecimal getgxTv_SdtfileUploadResponse_Status( )
   {
      return gxTv_SdtfileUploadResponse_Status ;
   }

   public void setgxTv_SdtfileUploadResponse_Status( java.math.BigDecimal value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Status = value ;
   }

   public String getgxTv_SdtfileUploadResponse_Dir( )
   {
      return gxTv_SdtfileUploadResponse_Dir ;
   }

   public void setgxTv_SdtfileUploadResponse_Dir( String value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Dir = value ;
   }

   public String getgxTv_SdtfileUploadResponse_Name( )
   {
      return gxTv_SdtfileUploadResponse_Name ;
   }

   public void setgxTv_SdtfileUploadResponse_Name( String value )
   {
      gxTv_SdtfileUploadResponse_N = (byte)(0) ;
      gxTv_SdtfileUploadResponse_Name = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtfileUploadResponse_Status = DecimalUtil.ZERO ;
      gxTv_SdtfileUploadResponse_N = (byte)(1) ;
      gxTv_SdtfileUploadResponse_Dir = "" ;
      gxTv_SdtfileUploadResponse_Name = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtfileUploadResponse_N ;
   }

   public web.SdtfileUploadResponse Clone( )
   {
      return (web.SdtfileUploadResponse)(clone()) ;
   }

   public void setStruct( web.StructSdtfileUploadResponse struct )
   {
      setgxTv_SdtfileUploadResponse_Status(struct.getStatus());
      setgxTv_SdtfileUploadResponse_Dir(struct.getDir());
      setgxTv_SdtfileUploadResponse_Name(struct.getName());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtfileUploadResponse getStruct( )
   {
      web.StructSdtfileUploadResponse struct = new web.StructSdtfileUploadResponse ();
      struct.setStatus(getgxTv_SdtfileUploadResponse_Status());
      struct.setDir(getgxTv_SdtfileUploadResponse_Dir());
      struct.setName(getgxTv_SdtfileUploadResponse_Name());
      return struct ;
   }

   protected byte gxTv_SdtfileUploadResponse_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtfileUploadResponse_Status ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtfileUploadResponse_Dir ;
   protected String gxTv_SdtfileUploadResponse_Name ;
}

