package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_estados_sdt_estadosItem extends GxUserType
{
   public Sdtsdt_estados_sdt_estadosItem( )
   {
      this(  new ModelContext(Sdtsdt_estados_sdt_estadosItem.class));
   }

   public Sdtsdt_estados_sdt_estadosItem( ModelContext context )
   {
      super( context, "Sdtsdt_estados_sdt_estadosItem");
   }

   public Sdtsdt_estados_sdt_estadosItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_estados_sdt_estadosItem");
   }

   public Sdtsdt_estados_sdt_estadosItem( StructSdtsdt_estados_sdt_estadosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitCodigo") )
            {
               gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescrip") )
            {
               gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip = oReader.getValue() ;
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
         sName = "sdt_estados.sdt_estadosItem" ;
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
      oWriter.writeElement("SitCodigo", gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDescrip", gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip);
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
      AddObjectProperty("SitCodigo", gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo, false, false);
      AddObjectProperty("SitDescrip", gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip, false, false);
   }

   public String getgxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo( )
   {
      return gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo ;
   }

   public void setgxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo( String value )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo = value ;
   }

   public String getgxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip( )
   {
      return gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip ;
   }

   public void setgxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip( String value )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo = "" ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_estados_sdt_estadosItem_N ;
   }

   public web.Sdtsdt_estados_sdt_estadosItem Clone( )
   {
      return (web.Sdtsdt_estados_sdt_estadosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_estados_sdt_estadosItem struct )
   {
      setgxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo(struct.getSitcodigo());
      setgxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip(struct.getSitdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_estados_sdt_estadosItem getStruct( )
   {
      web.StructSdtsdt_estados_sdt_estadosItem struct = new web.StructSdtsdt_estados_sdt_estadosItem ();
      struct.setSitcodigo(getgxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo());
      struct.setSitdescrip(getgxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_estados_sdt_estadosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_estados_sdt_estadosItem_Sitcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_estados_sdt_estadosItem_Sitdescrip ;
}

