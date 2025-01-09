package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_nav_sdt_navItem extends GxUserType
{
   public Sdtsdt_nav_sdt_navItem( )
   {
      this(  new ModelContext(Sdtsdt_nav_sdt_navItem.class));
   }

   public Sdtsdt_nav_sdt_navItem( ModelContext context )
   {
      super( context, "Sdtsdt_nav_sdt_navItem");
   }

   public Sdtsdt_nav_sdt_navItem( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_nav_sdt_navItem");
   }

   public Sdtsdt_nav_sdt_navItem( StructSdtsdt_nav_sdt_navItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "url") )
            {
               gxTv_Sdtsdt_nav_sdt_navItem_Url = oReader.getValue() ;
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
         sName = "sdt_nav.sdt_navItem" ;
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
      oWriter.writeElement("url", gxTv_Sdtsdt_nav_sdt_navItem_Url);
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
      AddObjectProperty("url", gxTv_Sdtsdt_nav_sdt_navItem_Url, false, false);
   }

   public String getgxTv_Sdtsdt_nav_sdt_navItem_Url( )
   {
      return gxTv_Sdtsdt_nav_sdt_navItem_Url ;
   }

   public void setgxTv_Sdtsdt_nav_sdt_navItem_Url( String value )
   {
      gxTv_Sdtsdt_nav_sdt_navItem_N = (byte)(0) ;
      gxTv_Sdtsdt_nav_sdt_navItem_Url = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_nav_sdt_navItem_Url = "" ;
      gxTv_Sdtsdt_nav_sdt_navItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_nav_sdt_navItem_N ;
   }

   public web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem Clone( )
   {
      return (web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem)(clone()) ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtsdt_nav_sdt_navItem struct )
   {
      setgxTv_Sdtsdt_nav_sdt_navItem_Url(struct.getUrl());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtsdt_nav_sdt_navItem getStruct( )
   {
      web.wwpbaseobjects.StructSdtsdt_nav_sdt_navItem struct = new web.wwpbaseobjects.StructSdtsdt_nav_sdt_navItem ();
      struct.setUrl(getgxTv_Sdtsdt_nav_sdt_navItem_Url());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_nav_sdt_navItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_nav_sdt_navItem_Url ;
}

