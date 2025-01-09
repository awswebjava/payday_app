package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem extends GxUserType
{
   public SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( )
   {
      this(  new ModelContext(SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem.class));
   }

   public SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( ModelContext context )
   {
      super( context, "SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem");
   }

   public SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem");
   }

   public SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem( StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCancela") )
            {
               gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela = oReader.getValue() ;
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
         sName = "sdtAdicionalCancelan.sdtAdicionalCancelanItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdicod", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiSitCancela", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio, false, false);
      AddObjectProperty("ConveAdicod", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod, false, false);
      AddObjectProperty("ConveAdiSitCancela", gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela, false, false);
   }

   public short getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio = value ;
   }

   public String getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod ;
   }

   public void setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod = value ;
   }

   public String getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela ;
   }

   public void setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela( String value )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N = (byte)(1) ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N ;
   }

   public web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem Clone( )
   {
      return (web.SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem struct )
   {
      setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod(struct.getConveadicod());
      setgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela(struct.getConveadisitcancela());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem getStruct( )
   {
      web.StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem struct = new web.StructSdtsdtAdicionalCancelan_sdtAdicionalCancelanItem ();
      struct.setClipaiconve(getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio());
      struct.setConveadicod(getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod());
      struct.setConveadisitcancela(getgxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela());
      return struct ;
   }

   protected byte gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_N ;
   protected short gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicionalCancelan_sdtAdicionalCancelanItem_Conveadisitcancela ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

