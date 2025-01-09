package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtmonaco_token_monaco_tokenItem extends GxUserType
{
   public Sdtmonaco_token_monaco_tokenItem( )
   {
      this(  new ModelContext(Sdtmonaco_token_monaco_tokenItem.class));
   }

   public Sdtmonaco_token_monaco_tokenItem( ModelContext context )
   {
      super( context, "Sdtmonaco_token_monaco_tokenItem");
   }

   public Sdtmonaco_token_monaco_tokenItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtmonaco_token_monaco_tokenItem");
   }

   public Sdtmonaco_token_monaco_tokenItem( StructSdtmonaco_token_monaco_tokenItem struct )
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
               gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "regex") )
            {
               gxTv_Sdtmonaco_token_monaco_tokenItem_Regex = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "css") )
            {
               gxTv_Sdtmonaco_token_monaco_tokenItem_Css = oReader.getValue() ;
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
         sName = "monaco_token.monaco_tokenItem" ;
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
      oWriter.writeElement("nombre", gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("regex", gxTv_Sdtmonaco_token_monaco_tokenItem_Regex);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("css", gxTv_Sdtmonaco_token_monaco_tokenItem_Css);
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
      AddObjectProperty("nombre", gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre, false, false);
      AddObjectProperty("regex", gxTv_Sdtmonaco_token_monaco_tokenItem_Regex, false, false);
      AddObjectProperty("css", gxTv_Sdtmonaco_token_monaco_tokenItem_Css, false, false);
   }

   public String getgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre ;
   }

   public void setgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre = value ;
   }

   public String getgxTv_Sdtmonaco_token_monaco_tokenItem_Regex( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Regex ;
   }

   public void setgxTv_Sdtmonaco_token_monaco_tokenItem_Regex( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Regex = value ;
   }

   public String getgxTv_Sdtmonaco_token_monaco_tokenItem_Css( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_Css ;
   }

   public void setgxTv_Sdtmonaco_token_monaco_tokenItem_Css( String value )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(0) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Css = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre = "" ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_N = (byte)(1) ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Regex = "" ;
      gxTv_Sdtmonaco_token_monaco_tokenItem_Css = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtmonaco_token_monaco_tokenItem_N ;
   }

   public web.Sdtmonaco_token_monaco_tokenItem Clone( )
   {
      return (web.Sdtmonaco_token_monaco_tokenItem)(clone()) ;
   }

   public void setStruct( web.StructSdtmonaco_token_monaco_tokenItem struct )
   {
      setgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre(struct.getNombre());
      setgxTv_Sdtmonaco_token_monaco_tokenItem_Regex(struct.getRegex());
      setgxTv_Sdtmonaco_token_monaco_tokenItem_Css(struct.getCss());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtmonaco_token_monaco_tokenItem getStruct( )
   {
      web.StructSdtmonaco_token_monaco_tokenItem struct = new web.StructSdtmonaco_token_monaco_tokenItem ();
      struct.setNombre(getgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre());
      struct.setRegex(getgxTv_Sdtmonaco_token_monaco_tokenItem_Regex());
      struct.setCss(getgxTv_Sdtmonaco_token_monaco_tokenItem_Css());
      return struct ;
   }

   protected byte gxTv_Sdtmonaco_token_monaco_tokenItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Nombre ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Regex ;
   protected String gxTv_Sdtmonaco_token_monaco_tokenItem_Css ;
}

