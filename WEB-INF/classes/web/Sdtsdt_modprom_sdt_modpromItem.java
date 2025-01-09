package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_modprom_sdt_modpromItem extends GxUserType
{
   public Sdtsdt_modprom_sdt_modpromItem( )
   {
      this(  new ModelContext(Sdtsdt_modprom_sdt_modpromItem.class));
   }

   public Sdtsdt_modprom_sdt_modpromItem( ModelContext context )
   {
      super( context, "Sdtsdt_modprom_sdt_modpromItem");
   }

   public Sdtsdt_modprom_sdt_modpromItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_modprom_sdt_modpromItem");
   }

   public Sdtsdt_modprom_sdt_modpromItem( StructSdtsdt_modprom_sdt_modpromItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprCod") )
            {
               gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MprDescrip") )
            {
               gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip = oReader.getValue() ;
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
         sName = "sdt_modprom.sdt_modpromItem" ;
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
      oWriter.writeElement("MprCod", gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MprDescrip", gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip);
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
      AddObjectProperty("MprCod", gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod, false, false);
      AddObjectProperty("MprDescrip", gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip, false, false);
   }

   public String getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod( )
   {
      return gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod ;
   }

   public void setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod( String value )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_N = (byte)(0) ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod = value ;
   }

   public String getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip( )
   {
      return gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip ;
   }

   public void setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip( String value )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_N = (byte)(0) ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod = "" ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_N = (byte)(1) ;
      gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_modprom_sdt_modpromItem_N ;
   }

   public web.Sdtsdt_modprom_sdt_modpromItem Clone( )
   {
      return (web.Sdtsdt_modprom_sdt_modpromItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_modprom_sdt_modpromItem struct )
   {
      setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod(struct.getMprcod());
      setgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip(struct.getMprdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_modprom_sdt_modpromItem getStruct( )
   {
      web.StructSdtsdt_modprom_sdt_modpromItem struct = new web.StructSdtsdt_modprom_sdt_modpromItem ();
      struct.setMprcod(getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod());
      struct.setMprdescrip(getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_modprom_sdt_modpromItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip ;
}

