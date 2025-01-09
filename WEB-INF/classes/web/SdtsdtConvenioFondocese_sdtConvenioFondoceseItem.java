package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtConvenioFondocese_sdtConvenioFondoceseItem extends GxUserType
{
   public SdtsdtConvenioFondocese_sdtConvenioFondoceseItem( )
   {
      this(  new ModelContext(SdtsdtConvenioFondocese_sdtConvenioFondoceseItem.class));
   }

   public SdtsdtConvenioFondocese_sdtConvenioFondoceseItem( ModelContext context )
   {
      super( context, "SdtsdtConvenioFondocese_sdtConvenioFondoceseItem");
   }

   public SdtsdtConvenioFondocese_sdtConvenioFondoceseItem( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtConvenioFondocese_sdtConvenioFondoceseItem");
   }

   public SdtsdtConvenioFondocese_sdtConvenioFondoceseItem( StructSdtsdtConvenioFondocese_sdtConvenioFondoceseItem struct )
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
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio = oReader.getValue() ;
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
                  gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig = GXutil.nullDate() ;
                  gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N = (byte)(0) ;
                  gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoSec") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoMeses") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoPrc") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoRem") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoNre") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveFondoDes") )
            {
               gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdtConvenioFondocese.sdtConvenioFondoceseItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig)) && ( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CliConveVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("CliConveFondoSec", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveFondoMeses", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveFondoPrc", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveFondoRem", GXutil.booltostr( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveFondoNre", GXutil.booltostr( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveFondoDes", GXutil.booltostr( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes));
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CliConveVig", sDateCnv, false, false);
      AddObjectProperty("CliConveFondoSec", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec, false, false);
      AddObjectProperty("CliConveFondoMeses", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses, false, false);
      AddObjectProperty("CliConveFondoPrc", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc, false, false);
      AddObjectProperty("CliConveFondoRem", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem, false, false);
      AddObjectProperty("CliConveFondoNre", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre, false, false);
      AddObjectProperty("CliConveFondoDes", gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes, false, false);
   }

   public short getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio = value ;
   }

   public java.util.Date getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig( java.util.Date value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig = value ;
   }

   public short getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec( short value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec = value ;
   }

   public short getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses( short value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc( java.math.BigDecimal value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc = value ;
   }

   public boolean getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem( boolean value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem = value ;
   }

   public boolean getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre( boolean value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre = value ;
   }

   public boolean getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes ;
   }

   public void setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes( boolean value )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N = (byte)(1) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio = "" ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig = GXutil.nullDate() ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N = (byte)(1) ;
      gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N ;
   }

   public web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem Clone( )
   {
      return (web.SdtsdtConvenioFondocese_sdtConvenioFondoceseItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtConvenioFondocese_sdtConvenioFondoceseItem struct )
   {
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio(struct.getCliconvenio());
      if ( struct.gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N == 0 )
      {
         setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig(struct.getCliconvevig());
      }
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec(struct.getCliconvefondosec());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses(struct.getCliconvefondomeses());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc(struct.getCliconvefondoprc());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem(struct.getCliconvefondorem());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre(struct.getCliconvefondonre());
      setgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes(struct.getCliconvefondodes());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtConvenioFondocese_sdtConvenioFondoceseItem getStruct( )
   {
      web.StructSdtsdtConvenioFondocese_sdtConvenioFondoceseItem struct = new web.StructSdtsdtConvenioFondocese_sdtConvenioFondoceseItem ();
      struct.setClipaiconve(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio());
      if ( gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N == 0 )
      {
         struct.setCliconvevig(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig());
      }
      struct.setCliconvefondosec(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec());
      struct.setCliconvefondomeses(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses());
      struct.setCliconvefondoprc(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc());
      struct.setCliconvefondorem(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem());
      struct.setCliconvefondonre(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre());
      struct.setCliconvefondodes(getgxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes());
      return struct ;
   }

   protected byte gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_N ;
   protected byte gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig_N ;
   protected short gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Clipaiconve ;
   protected short gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondosec ;
   protected short gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondomeses ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondoprc ;
   protected String gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvenio ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvevig ;
   protected boolean gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondorem ;
   protected boolean gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondonre ;
   protected boolean gxTv_SdtsdtConvenioFondocese_sdtConvenioFondoceseItem_Cliconvefondodes ;
   protected boolean readElement ;
   protected boolean formatError ;
}

