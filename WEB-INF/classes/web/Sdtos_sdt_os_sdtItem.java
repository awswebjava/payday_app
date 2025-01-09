package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtos_sdt_os_sdtItem extends GxUserType
{
   public Sdtos_sdt_os_sdtItem( )
   {
      this(  new ModelContext(Sdtos_sdt_os_sdtItem.class));
   }

   public Sdtos_sdt_os_sdtItem( ModelContext context )
   {
      super( context, "Sdtos_sdt_os_sdtItem");
   }

   public Sdtos_sdt_os_sdtItem( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtos_sdt_os_sdtItem");
   }

   public Sdtos_sdt_os_sdtItem( StructSdtos_sdt_os_sdtItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoCod") )
            {
               gxTv_Sdtos_sdt_os_sdtItem_Osocod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoDescrip") )
            {
               gxTv_Sdtos_sdt_os_sdtItem_Osodescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoC3992") )
            {
               gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 = oReader.getValue() ;
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
         sName = "os_sdt.os_sdtItem" ;
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
      oWriter.writeElement("OsoCod", gxTv_Sdtos_sdt_os_sdtItem_Osocod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoDescrip", gxTv_Sdtos_sdt_os_sdtItem_Osodescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoC3992", gxTv_Sdtos_sdt_os_sdtItem_Osoc3992);
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
      AddObjectProperty("OsoCod", gxTv_Sdtos_sdt_os_sdtItem_Osocod, false, false);
      AddObjectProperty("OsoDescrip", gxTv_Sdtos_sdt_os_sdtItem_Osodescrip, false, false);
      AddObjectProperty("OsoC3992", gxTv_Sdtos_sdt_os_sdtItem_Osoc3992, false, false);
   }

   public String getgxTv_Sdtos_sdt_os_sdtItem_Osocod( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osocod ;
   }

   public void setgxTv_Sdtos_sdt_os_sdtItem_Osocod( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osocod = value ;
   }

   public String getgxTv_Sdtos_sdt_os_sdtItem_Osodescrip( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osodescrip ;
   }

   public void setgxTv_Sdtos_sdt_os_sdtItem_Osodescrip( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osodescrip = value ;
   }

   public String getgxTv_Sdtos_sdt_os_sdtItem_Osoc3992( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 ;
   }

   public void setgxTv_Sdtos_sdt_os_sdtItem_Osoc3992( String value )
   {
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(0) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtos_sdt_os_sdtItem_Osocod = "" ;
      gxTv_Sdtos_sdt_os_sdtItem_N = (byte)(1) ;
      gxTv_Sdtos_sdt_os_sdtItem_Osodescrip = "" ;
      gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtos_sdt_os_sdtItem_N ;
   }

   public web.Sdtos_sdt_os_sdtItem Clone( )
   {
      return (web.Sdtos_sdt_os_sdtItem)(clone()) ;
   }

   public void setStruct( web.StructSdtos_sdt_os_sdtItem struct )
   {
      setgxTv_Sdtos_sdt_os_sdtItem_Osocod(struct.getOsocod());
      setgxTv_Sdtos_sdt_os_sdtItem_Osodescrip(struct.getOsodescrip());
      setgxTv_Sdtos_sdt_os_sdtItem_Osoc3992(struct.getOsoc3992());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtos_sdt_os_sdtItem getStruct( )
   {
      web.StructSdtos_sdt_os_sdtItem struct = new web.StructSdtos_sdt_os_sdtItem ();
      struct.setOsocod(getgxTv_Sdtos_sdt_os_sdtItem_Osocod());
      struct.setOsodescrip(getgxTv_Sdtos_sdt_os_sdtItem_Osodescrip());
      struct.setOsoc3992(getgxTv_Sdtos_sdt_os_sdtItem_Osoc3992());
      return struct ;
   }

   protected byte gxTv_Sdtos_sdt_os_sdtItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osocod ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osoc3992 ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtos_sdt_os_sdtItem_Osodescrip ;
}

