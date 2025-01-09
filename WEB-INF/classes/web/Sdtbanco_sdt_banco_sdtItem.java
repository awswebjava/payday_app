package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbanco_sdt_banco_sdtItem extends GxUserType
{
   public Sdtbanco_sdt_banco_sdtItem( )
   {
      this(  new ModelContext(Sdtbanco_sdt_banco_sdtItem.class));
   }

   public Sdtbanco_sdt_banco_sdtItem( ModelContext context )
   {
      super( context, "Sdtbanco_sdt_banco_sdtItem");
   }

   public Sdtbanco_sdt_banco_sdtItem( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtbanco_sdt_banco_sdtItem");
   }

   public Sdtbanco_sdt_banco_sdtItem( StructSdtbanco_sdt_banco_sdtItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanCod") )
            {
               gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanDescrip") )
            {
               gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanHabilitado") )
            {
               gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanCUIT") )
            {
               gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit = oReader.getValue() ;
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
         sName = "banco_sdt.banco_sdtItem" ;
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
      oWriter.writeElement("BanCod", gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BanDescrip", gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BanHabilitado", GXutil.booltostr( gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BanCUIT", gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit);
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
      AddObjectProperty("BanCod", gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod, false, false);
      AddObjectProperty("BanDescrip", gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip, false, false);
      AddObjectProperty("BanHabilitado", gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado, false, false);
      AddObjectProperty("BanCUIT", gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit, false, false);
   }

   public String getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod ;
   }

   public void setgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod = value ;
   }

   public String getgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip ;
   }

   public void setgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip = value ;
   }

   public boolean getgxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado ;
   }

   public void setgxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado( boolean value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado = value ;
   }

   public String getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit ;
   }

   public void setgxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit( String value )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(0) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod = "" ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_N = (byte)(1) ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip = "" ;
      gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbanco_sdt_banco_sdtItem_N ;
   }

   public web.Sdtbanco_sdt_banco_sdtItem Clone( )
   {
      return (web.Sdtbanco_sdt_banco_sdtItem)(clone()) ;
   }

   public void setStruct( web.StructSdtbanco_sdt_banco_sdtItem struct )
   {
      setgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(struct.getBancod());
      setgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip(struct.getBandescrip());
      setgxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado(struct.getBanhabilitado());
      setgxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit(struct.getBancuit());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbanco_sdt_banco_sdtItem getStruct( )
   {
      web.StructSdtbanco_sdt_banco_sdtItem struct = new web.StructSdtbanco_sdt_banco_sdtItem ();
      struct.setBancod(getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod());
      struct.setBandescrip(getgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip());
      struct.setBanhabilitado(getgxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado());
      struct.setBancuit(getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit());
      return struct ;
   }

   protected byte gxTv_Sdtbanco_sdt_banco_sdtItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bancod ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bancuit ;
   protected String sTagName ;
   protected boolean gxTv_Sdtbanco_sdt_banco_sdtItem_Banhabilitado ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip ;
}

