package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtClienteConvenio_sdtClienteConvenioItem extends GxUserType
{
   public SdtsdtClienteConvenio_sdtClienteConvenioItem( )
   {
      this(  new ModelContext(SdtsdtClienteConvenio_sdtClienteConvenioItem.class));
   }

   public SdtsdtClienteConvenio_sdtClienteConvenioItem( ModelContext context )
   {
      super( context, "SdtsdtClienteConvenio_sdtClienteConvenioItem");
   }

   public SdtsdtClienteConvenio_sdtClienteConvenioItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtClienteConvenio_sdtClienteConvenioItem");
   }

   public SdtsdtClienteConvenio_sdtClienteConvenioItem( StructSdtsdtClienteConvenio_sdtClienteConvenioItem struct )
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
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = GXutil.nullDate() ;
                  gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(0) ;
                  gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDefault") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveInterDiasJor") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMinMesesVac") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMesHsPExt") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiaHsPExt") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveFondoCese") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMin") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMax") )
            {
               gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdtClienteConvenio.sdtClienteConvenioItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig)) && ( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N == 1 ) )
      {
         oWriter.writeElement("CliConveVig", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CliConveVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("ConveDefault", GXutil.booltostr( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveInterDiasJor", GXutil.trim( GXutil.str( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveMinMesesVac", GXutil.trim( GXutil.str( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveMesHsPExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDiaHsPExt", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveFondoCese", GXutil.booltostr( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveGuarEdadMin", GXutil.trim( GXutil.str( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveGuarEdadMax", GXutil.trim( GXutil.str( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax, 2, 0)));
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CliConveVig", sDateCnv, false, false);
      AddObjectProperty("ConveDefault", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault, false, false);
      AddObjectProperty("ConveInterDiasJor", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor, false, false);
      AddObjectProperty("ConveMinMesesVac", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac, false, false);
      AddObjectProperty("ConveMesHsPExt", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext, false, false);
      AddObjectProperty("ConveDiaHsPExt", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext, false, false);
      AddObjectProperty("ConveFondoCese", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese, false, false);
      AddObjectProperty("ConveGuarEdadMin", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin, false, false);
      AddObjectProperty("ConveGuarEdadMax", gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax, false, false);
   }

   public short getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio = value ;
   }

   public java.util.Date getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig( java.util.Date value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = value ;
   }

   public boolean getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault( boolean value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault = value ;
   }

   public short getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor( short value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor = value ;
   }

   public byte getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext = value ;
   }

   public String getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext( String value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext = value ;
   }

   public boolean getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese( boolean value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese = value ;
   }

   public byte getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin = value ;
   }

   public byte getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax ;
   }

   public void setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax( byte value )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(0) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N = (byte)(1) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio = "" ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig = GXutil.nullDate() ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N = (byte)(1) ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext = DecimalUtil.ZERO ;
      gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N ;
   }

   public web.SdtsdtClienteConvenio_sdtClienteConvenioItem Clone( )
   {
      return (web.SdtsdtClienteConvenio_sdtClienteConvenioItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtClienteConvenio_sdtClienteConvenioItem struct )
   {
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio(struct.getCliconvenio());
      if ( struct.gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N == 0 )
      {
         setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig(struct.getCliconvevig());
      }
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault(struct.getConvedefault());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor(struct.getConveinterdiasjor());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac(struct.getConveminmesesvac());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext(struct.getConvemeshspext());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext(struct.getConvediahspext());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese(struct.getConvefondocese());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin(struct.getConveguaredadmin());
      setgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax(struct.getConveguaredadmax());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtClienteConvenio_sdtClienteConvenioItem getStruct( )
   {
      web.StructSdtsdtClienteConvenio_sdtClienteConvenioItem struct = new web.StructSdtsdtClienteConvenio_sdtClienteConvenioItem ();
      struct.setClipaiconve(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio());
      if ( gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N == 0 )
      {
         struct.setCliconvevig(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig());
      }
      struct.setConvedefault(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault());
      struct.setConveinterdiasjor(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor());
      struct.setConveminmesesvac(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac());
      struct.setConvemeshspext(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext());
      struct.setConvediahspext(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext());
      struct.setConvefondocese(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese());
      struct.setConveguaredadmin(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin());
      struct.setConveguaredadmax(getgxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax());
      return struct ;
   }

   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_N ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig_N ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveminmesesvac ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmin ;
   protected byte gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveguaredadmax ;
   protected short gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Clipaiconve ;
   protected short gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Conveinterdiasjor ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convemeshspext ;
   protected String gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvenio ;
   protected String gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convediahspext ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Cliconvevig ;
   protected boolean gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convedefault ;
   protected boolean gxTv_SdtsdtClienteConvenio_sdtClienteConvenioItem_Convefondocese ;
   protected boolean readElement ;
   protected boolean formatError ;
}

