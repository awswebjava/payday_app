package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtAdicional_sdtAdicionalItem extends GxUserType
{
   public SdtsdtAdicional_sdtAdicionalItem( )
   {
      this(  new ModelContext(SdtsdtAdicional_sdtAdicionalItem.class));
   }

   public SdtsdtAdicional_sdtAdicionalItem( ModelContext context )
   {
      super( context, "SdtsdtAdicional_sdtAdicionalItem");
   }

   public SdtsdtAdicional_sdtAdicionalItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtAdicional_sdtAdicionalItem");
   }

   public SdtsdtAdicional_sdtAdicionalItem( StructSdtsdtAdicional_sdtAdicionalItem struct )
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
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiDescri") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiAli") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiInfo") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiTipo") )
            {
               gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo = oReader.getValue() ;
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
         sName = "sdtAdicional.sdtAdicionalItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdicod", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiDescri", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiAli", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiInfo", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiTipo", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo);
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio, false, false);
      AddObjectProperty("ConveAdicod", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod, false, false);
      AddObjectProperty("ConveAdiDescri", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri, false, false);
      AddObjectProperty("ConveAdiAli", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali, false, false);
      AddObjectProperty("ConveAdiInfo", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo, false, false);
      AddObjectProperty("ConveAdiTipo", gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo, false, false);
   }

   public short getgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio = value ;
   }

   public String getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod = value ;
   }

   public String getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali = value ;
   }

   public String getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo = value ;
   }

   public String getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo ;
   }

   public void setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo( String value )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtAdicional_sdtAdicionalItem_N = (byte)(1) ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali = DecimalUtil.ZERO ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo = "" ;
      gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtAdicional_sdtAdicionalItem_N ;
   }

   public web.SdtsdtAdicional_sdtAdicionalItem Clone( )
   {
      return (web.SdtsdtAdicional_sdtAdicionalItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtAdicional_sdtAdicionalItem struct )
   {
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod(struct.getConveadicod());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri(struct.getConveadidescri());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali(struct.getConveadiali());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo(struct.getConveadiinfo());
      setgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo(struct.getConveaditipo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtAdicional_sdtAdicionalItem getStruct( )
   {
      web.StructSdtsdtAdicional_sdtAdicionalItem struct = new web.StructSdtsdtAdicional_sdtAdicionalItem ();
      struct.setClipaiconve(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio());
      struct.setConveadicod(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod());
      struct.setConveadidescri(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri());
      struct.setConveadiali(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali());
      struct.setConveadiinfo(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo());
      struct.setConveaditipo(getgxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo());
      return struct ;
   }

   protected byte gxTv_SdtsdtAdicional_sdtAdicionalItem_N ;
   protected short gxTv_SdtsdtAdicional_sdtAdicionalItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiali ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveaditipo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadiinfo ;
   protected String gxTv_SdtsdtAdicional_sdtAdicionalItem_Conveadidescri ;
}

